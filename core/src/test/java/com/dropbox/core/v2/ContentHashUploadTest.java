package com.dropbox.core.v2;

import com.dropbox.core.*;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.DropboxContentHasher;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.v2.files.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.*;

import static org.testng.Assert.*;

public class ContentHashUploadTest {
    private static final byte[] DATA = "prefix-payload-suffix".getBytes(StandardCharsets.UTF_8);
    private static final UploadSessionCursor CURSOR = new UploadSessionCursor("session", 1234);
    private static final String METADATA = "{\"name\":\"file\",\"id\":\"id:123\","
            + "\"client_modified\":\"2020-01-01T00:00:00Z\","
            + "\"server_modified\":\"2020-01-01T00:00:00Z\",\"rev\":\"123456789\",\"size\":21}";

    @Test
    @SuppressWarnings("deprecation")
    public void defaultsAndCopies() {
        assertTrue(new DbxRequestConfig("test").isAutoContentHashEnabled());
        assertTrue(new DbxRequestConfig("test", "en").isAutoContentHashEnabled());
        assertTrue(new DbxRequestConfig("test", null, new RecordingRequestor()).isAutoContentHashEnabled());
        assertTrue(DbxRequestConfig.newBuilder("test").build().copy().build().isAutoContentHashEnabled());
        assertFalse(DbxRequestConfig.newBuilder("test").withAutoContentHash(false).build()
                .copy().build().isAutoContentHashEnabled());
    }

    @DataProvider(name = "payloads")
    public Object[][] payloads() {
        List<Object[]> cases = new ArrayList<>();
        for (String route : new String[]{"upload", "start", "append", "batch", "finish"})
            for (String stream : new String[]{"file", "bytes", "buffered", "mark", "nonmark"})
                for (long limit : new long[]{0, 7, 100, Long.MAX_VALUE})
                    cases.add(new Object[]{route, stream, limit});
        return cases.toArray(new Object[0][]);
    }

    @Test(dataProvider = "payloads")
    public void exactPayloadPositionAndOwnership(String route, String kind, long limit) throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        int count = (int) Math.min(limit, DATA.length - 7);
        DbxUploadStyleBuilder<?, ?, ?> builder = builder(client(requestor, true).files(), route, null, count);
        Path file = kind.equals("file") ? Files.createTempFile("dropbox-hash", ".bin") : null;
        try {
            if (file != null) Files.write(file, DATA);
            InputStream source = file != null ? new FileInputStream(file.toFile()) : new ByteArrayInputStream(DATA);
            if (kind.equals("buffered")) source = new BufferedInputStream(source, 2);
            if (kind.equals("mark")) source = new FilterInputStream(source) { };
            if (kind.equals("nonmark")) source = new FilterInputStream(source) {
                @Override public boolean markSupported() { return false; }
            };
            try (InputStream input = source) {
                assertEquals(input.skip(7), 7);
                IOUtil.ProgressListener progress = bytes -> { };
                if (limit == Long.MAX_VALUE) builder.uploadAndFinish(input, progress);
                else builder.uploadAndFinish(input, limit, progress);
                byte[] expected = Arrays.copyOfRange(DATA, 7, 7 + count);
                assertEquals(requestor.body.toByteArray(), expected);
                boolean hashed = limit == 0 || kind.equals("file") || kind.equals("bytes")
                        || (!kind.equals("nonmark") && limit <= IOUtil.DEFAULT_COPY_BUFFER_SIZE);
                if (hashed) assertHash(requestor, expected);
                else assertFalse(requestor.arg.contains("content_hash"));
                assertEquals(input.read(), count < DATA.length - 7 ? DATA[7 + count] & 0xff : -1);
                if (input instanceof FileInputStream) assertTrue(((FileInputStream) input).getChannel().isOpen());
                if (input instanceof ByteArrayInputStream) {
                    input.reset();
                    assertEquals(input.read(), DATA[0]);
                }
                assertSame(requestor.listener, progress);
                assertEquals(requestor.closes, 1);
                assertEquals(requestor.starts, 1);
            }
        } finally {
            if (file != null) Files.delete(file);
        }
    }

    @Test
    public void manualHashAndOptOutDoNotPreRead() throws Exception {
        String manual = "0".repeat(64);
        for (String route : new String[]{"upload", "start", "append", "batch", "finish"}) {
            for (boolean enabled : new boolean[]{false, true}) {
                for (boolean explicit : new boolean[]{false, true}) {
                    RecordingRequestor requestor = new RecordingRequestor();
                    DbxUploadStyleBuilder<?, ?, ?> builder = builder(client(requestor, enabled).files(), route,
                            explicit ? manual : null);
                    ByteArrayInputStream input = new ByteArrayInputStream(DATA) {
                        @Override public synchronized int read(byte[] b, int off, int len) {
                            if (!enabled || explicit) assertEquals(requestor.starts, 1);
                            return super.read(b, off, len);
                        }
                    };
                    builder.uploadAndFinish(input);
                    if (explicit) assertTrue(requestor.arg.contains(manual));
                    else if (enabled) assertHash(requestor, DATA);
                    else assertFalse(requestor.arg.contains("content_hash"));
                }
            }
        }
    }

    @Test
    public void reusableBuilderDoesNotKeepAnAutomaticHash() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        UploadBuilder builder = client(requestor, true).files().uploadBuilder("/caf\u00e9\u007f.txt");
        builder.uploadAndFinish(new ByteArrayInputStream(DATA));
        assertHash(requestor, DATA);
        for (char c : requestor.arg.toCharArray()) assertTrue(c < 0x7f);
        byte[] second = {1, 2, 3};
        builder.uploadAndFinish(new ByteArrayInputStream(second));
        assertHash(requestor, second);
        builder.start().uploadAndFinish(new ByteArrayInputStream(DATA));
        assertFalse(requestor.arg.contains("content_hash"));
    }

    @Test
    public void streamingAndDirectUploadersKeepOriginalLifecycle() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        DbxClientV2 client = client(requestor, true);
        try (UploadSessionAppendV2Uploader uploader = client.files().uploadSessionAppendV2(CURSOR)) {
            assertEquals(requestor.starts, 1);
            uploader.getOutputStream().write(DATA);
            uploader.finish();
        }
        assertFalse(requestor.arg.contains("content_hash"));
        assertEquals(requestor.body.toByteArray(), DATA);
        assertEquals(requestor.closes, 1);
    }

    @Test
    public void readAndResetFailuresAbortBeforeHttpAndPreserveBuilder() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        UploadSessionAppendV2Builder builder = client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR);
        IOException read = new IOException("read failed"), reset = new IOException("reset failed");
        InputStream input = new InputStream() {
            @Override public boolean markSupported() { return true; }
            @Override public int read() throws IOException { throw read; }
            @Override public void reset() throws IOException { throw reset; }
        };
        IOException thrown = expectThrows(IOException.class, () -> builder.uploadAndFinish(input, 7));
        assertSame(thrown, read);
        assertSame(thrown.getSuppressed()[0], reset);
        assertEquals(requestor.starts, 0);
        builder.uploadAndFinish(new ByteArrayInputStream(DATA));
        assertHash(requestor, DATA);
    }

    @Test
    public void fileReadFailureRestoresPositionAndSendsNothing() throws Exception {
        Path path = Files.createTempFile("dropbox-hash-error", ".bin");
        IOException failure = new IOException("read failed");
        try {
            Files.write(path, DATA);
            RecordingRequestor requestor = new RecordingRequestor();
            try (FileInputStream input = new FileInputStream(path.toFile()) {
                @Override public int read(byte[] b, int off, int len) throws IOException {
                    super.read(b, off, Math.min(len, 1));
                    throw failure;
                }
            }) {
                input.getChannel().position(7);
                assertSame(expectThrows(IOException.class, () -> client(requestor, true).files()
                        .uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(input)), failure);
                assertEquals(input.getChannel().position(), 7);
                assertEquals(requestor.starts, 0);
            }
        } finally {
            Files.delete(path);
        }
    }

    @Test
    public void sparseLargeFileUsesBoundedReads() throws Exception {
        Path path = Files.createTempFile("dropbox-large-hash", ".bin");
        try {
            try (RandomAccessFile file = new RandomAccessFile(path.toFile(), "rw")) { file.setLength(256L * 1024 * 1024); }
            long[] read = {0};
            try (FileInputStream input = new FileInputStream(path.toFile()) {
                @Override public int read(byte[] b, int off, int len) throws IOException {
                    assertTrue(len <= IOUtil.DEFAULT_COPY_BUFFER_SIZE);
                    int count = super.read(b, off, len);
                    if (count > 0) read[0] += count;
                    return count;
                }
            }) {
                input.getChannel().position(128L * 1024 * 1024);
                RecordingRequestor requestor = new RecordingRequestor();
                client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(input, 65536);
                assertEquals(read[0], 2L * 65536);
                assertEquals(input.getChannel().position(), 128L * 1024 * 1024 + 65536);
                assertHash(requestor, new byte[65536]);
            }
        } finally {
            Files.delete(path);
        }
    }

    @Test
    public void batchHashDoesNotRestartAtEntryBoundaries() throws Exception {
        byte[] payload = new byte[DropboxContentHasher.BLOCK_SIZE + 1];
        for (int i = 0; i < payload.length; i++) payload[i] = (byte) (i % 251);
        RecordingRequestor requestor = new RecordingRequestor();
        client(requestor, true).files().uploadSessionAppendBatchBuilder(Arrays.asList(
                new UploadSessionAppendBatchArgEntry(CURSOR, 3, true),
                new UploadSessionAppendBatchArgEntry(new UploadSessionCursor("other", 5678), payload.length - 3, true)))
                .uploadAndFinish(new ByteArrayInputStream(payload));
        assertTrue(requestor.arg.contains("4a6cc0a344febaa07772e7c974834b2fb1d24594d4ba15f27c97a54699709f44"));
        assertEquals(requestor.body.toByteArray(), payload);
    }

    @Test
    public void bufferedLargeLimitSkipsHashWithoutAnExtraRead() throws Exception {
        long[] read = {0};
        InputStream zeros = new InputStream() {
            @Override public int read() { read[0]++; return 0; }
            @Override public int read(byte[] b, int off, int len) {
                Arrays.fill(b, off, off + len, (byte) 0);
                read[0] += len;
                return len;
            }
        };
        RecordingRequestor requestor = new RecordingRequestor();
        try (BufferedInputStream input = new BufferedInputStream(zeros, 2)) {
            client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(input, 65536);
        }
        assertEquals(read[0], 65536);
        assertFalse(requestor.arg.contains("content_hash"));
    }

    @Test
    public void startFailureDoesNotLeaveAStaleHash() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        IOException failure = new IOException("connect failed");
        requestor.startFailure = failure;
        UploadBuilder builder = client(requestor, true).files().uploadBuilder("/file");
        ByteArrayInputStream input = new ByteArrayInputStream(DATA);
        input.skip(7);
        NetworkIOException thrown = expectThrows(NetworkIOException.class, () -> builder.uploadAndFinish(input));
        assertSame(thrown.getCause(), failure);
        assertEquals(input.available(), DATA.length - 7);
        requestor.startFailure = null;
        byte[] second = {1, 2, 3};
        builder.uploadAndFinish(new ByteArrayInputStream(second));
        assertHash(requestor, second);
    }

    @Test
    public void originalCustomRequestorErrorsAndCleanupAreUnchanged() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        IOException failure = new IOException("write failed");
        requestor.writeFailure = failure;
        NetworkIOException thrown = expectThrows(NetworkIOException.class, () -> client(requestor, true).files()
                .uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(new ByteArrayInputStream(DATA)));
        assertTrue(thrown.getCause() == failure || thrown.getCause().getCause() == failure);
        assertEquals(requestor.closes, 1);
    }

    @Test
    public void bufferedMarkWindowBoundaryAndCallerPosition() throws Exception {
        byte[] bytes = new byte[IOUtil.DEFAULT_COPY_BUFFER_SIZE + 7];
        for (int i = 0; i < bytes.length; i++) bytes[i] = (byte) i;
        RecordingRequestor requestor = new RecordingRequestor();
        try (BufferedInputStream input = new BufferedInputStream(new ByteArrayInputStream(bytes), 1)) {
            input.skip(7);
            client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR)
                    .uploadAndFinish(input, IOUtil.DEFAULT_COPY_BUFFER_SIZE);
            byte[] expected = Arrays.copyOfRange(bytes, 7, bytes.length);
            assertEquals(requestor.body.toByteArray(), expected);
            assertHash(requestor, expected);
            assertEquals(input.read(), -1);
        }
    }

    @Test
    public void defaultClientHashesAndPreservesANonzeroByteArrayMark() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        DbxClientV2 client = new DbxClientV2(DbxRequestConfig.newBuilder("test")
                .withHttpRequestor(requestor).build(), "fake-token");
        ByteArrayInputStream input = new ByteArrayInputStream(DATA);
        input.skip(3);
        input.mark(0);
        input.skip(4);
        client.files().uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(input, 7);
        assertHash(requestor, Arrays.copyOfRange(DATA, 7, 14));
        assertEquals(input.available(), DATA.length - 14);
        input.reset();
        assertEquals(input.read(), DATA[3]);
    }

    private static DbxClientV2 client(RecordingRequestor requestor, boolean enabled) {
        return new DbxClientV2(DbxRequestConfig.newBuilder("test").withHttpRequestor(requestor)
                .withAutoContentHash(enabled).build(), "fake-token");
    }

    private static DbxUploadStyleBuilder<?, ?, ?> builder(DbxUserFilesRequests files, String route) {
        return builder(files, route, null);
    }

    private static DbxUploadStyleBuilder<?, ?, ?> builder(DbxUserFilesRequests files, String route, String hash) {
        return builder(files, route, hash, DATA.length);
    }

    private static DbxUploadStyleBuilder<?, ?, ?> builder(DbxUserFilesRequests files, String route, String hash, long length) {
        switch (route) {
            case "upload": return files.uploadBuilder("/file").withContentHash(hash);
            case "start": return files.uploadSessionStartBuilder().withContentHash(hash);
            case "append": return files.uploadSessionAppendV2Builder(CURSOR).withContentHash(hash);
            case "batch": return files.uploadSessionAppendBatchBuilder(Collections.singletonList(new UploadSessionAppendBatchArgEntry(CURSOR, length, true))).withContentHash(hash);
            case "finish": return files.uploadSessionFinishBuilder(CURSOR, new CommitInfo("/file")).withContentHash(hash);
            default: throw new AssertionError(route);
        }
    }

    private static void assertHash(RecordingRequestor requestor, byte[] payload) throws Exception {
        MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
        MessageDigest overall = MessageDigest.getInstance("SHA-256");
        for (int offset = 0; offset < payload.length; offset += DropboxContentHasher.BLOCK_SIZE)
            overall.update(sha256.digest(Arrays.copyOfRange(payload, offset, Math.min(payload.length, offset + DropboxContentHasher.BLOCK_SIZE))));
        assertTrue(requestor.arg.contains("\"content_hash\":\"" + HexFormat.of().formatHex(overall.digest()) + "\""), requestor.arg);
    }

    private static class RecordingRequestor extends HttpRequestor {
        final ByteArrayOutputStream body = new ByteArrayOutputStream();
        String arg;
        int starts, closes;
        IOException startFailure, writeFailure;
        IOUtil.ProgressListener listener;
        @Override public Uploader startPost(String url, Iterable<Header> headers) throws IOException {
            starts++;
            if (startFailure != null) throw startFailure;
            body.reset();
            for (Header header : headers) if (header.getKey().equals("Dropbox-API-Arg")) arg = header.getValue();
            return new Uploader() {
                @Override public OutputStream getBody() {
                    return new FilterOutputStream(body) {
                        @Override public void write(byte[] bytes, int offset, int length) throws IOException {
                            if (writeFailure != null) throw writeFailure;
                            body.write(bytes, offset, length);
                        }
                        @Override public void write(int value) throws IOException {
                            if (writeFailure != null) throw writeFailure;
                            body.write(value);
                        }
                    };
                }
                @Override public void close() { closes++; }
                @Override public void abort() { }
                @Override public void setProgressListener(IOUtil.ProgressListener value) { listener = value; }
                @Override public Response finish() {
                    String response = url.endsWith("/start") ? "{\"session_id\":\"session\"}" :
                            url.endsWith("/append_v2") ? "null" : url.endsWith("/append_batch") ? "{\"entries\":[]}" : METADATA;
                    return new Response(200, new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8)), Collections.emptyMap());
                }
            };
        }
        @Override public Response doGet(String url, Iterable<Header> headers) { throw new AssertionError(); }
        @Override public Uploader startPut(String url, Iterable<Header> headers) { throw new AssertionError(); }
    }
}
