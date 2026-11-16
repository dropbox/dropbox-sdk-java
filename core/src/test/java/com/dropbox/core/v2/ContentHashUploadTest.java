package com.dropbox.core.v2;

import com.dropbox.core.*;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.DropboxContentHasher;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.v2.files.*;
import com.dropbox.core.v2.fileproperties.PropertyGroup;
import com.dropbox.core.v2.fileproperties.PropertyField;
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
        for (String route : new String[]{"upload", "start", "append", "batch", "finish", "alpha"})
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
                boolean hashed = kind.equals("file") || kind.equals("bytes");
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
        Path file = Files.createTempFile("dropbox-hash-precedence", ".bin");
        try {
            Files.write(file, DATA);
            for (String route : new String[]{"upload", "start", "append", "batch", "finish", "alpha"}) {
                for (boolean enabled : new boolean[]{false, true}) {
                    for (boolean explicit : new boolean[]{false, true}) {
                        RecordingRequestor requestor = new RecordingRequestor();
                        DbxUploadStyleBuilder<?, ?, ?> builder = builder(client(requestor, enabled).files(), route,
                                explicit ? manual : null);
                        try (FileInputStream input = new FileInputStream(file.toFile()) {
                            @Override public int read(byte[] b, int off, int len) throws IOException {
                                if (!enabled || explicit) assertEquals(requestor.starts, 1);
                                return super.read(b, off, len);
                            }
                        }) {
                            builder.uploadAndFinish(input);
                        }
                        if (explicit) assertTrue(requestor.arg.contains(manual));
                        else if (enabled) assertHash(requestor, DATA);
                        else assertFalse(requestor.arg.contains("content_hash"));
                    }
                }
            }
        } finally {
            Files.delete(file);
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
    public void markStreamReadFailureUsesOriginalUploadLifecycleWithoutReset() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        UploadSessionAppendV2Builder builder = client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR);
        IOException read = new IOException("read failed");
        int[] resets = {0};
        InputStream input = new InputStream() {
            @Override public boolean markSupported() { return true; }
            @Override public int read() throws IOException { throw read; }
            @Override public void reset() throws IOException { resets[0]++; throw new IOException("reset failed"); }
        };
        assertSame(expectThrows(IOException.class, () -> builder.uploadAndFinish(input, 7)), read);
        assertEquals(resets[0], 0);
        assertEquals(requestor.starts, 1);
        assertEquals(requestor.closes, 1);
        assertFalse(requestor.arg.contains("content_hash"));
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
        for (String route : new String[]{"upload", "start", "append", "batch", "finish", "alpha"}) {
            RecordingRequestor requestor = new RecordingRequestor();
            IOException failure = new IOException("connect failed");
            requestor.startFailure = failure;
            DbxUploadStyleBuilder<?, ?, ?> builder = builder(client(requestor, true).files(), route,
                    null, DATA.length - 7);
            ByteArrayInputStream input = new ByteArrayInputStream(DATA);
            input.skip(3);
            input.mark(0);
            input.skip(4);
            NetworkIOException thrown = expectThrows(NetworkIOException.class, () -> builder.uploadAndFinish(input));
            assertSame(thrown.getCause(), failure);
            assertEquals(input.available(), DATA.length - 7);
            input.reset();
            assertEquals(input.read(), DATA[3]);
            requestor.startFailure = null;
            byte[] second = Arrays.copyOfRange(DATA, 7, DATA.length);
            second[0] ^= 1;
            builder.uploadAndFinish(new ByteArrayInputStream(second));
            assertHash(requestor, second);
        }
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
    public void bufferedAndOtherMarkStreamsPreserveTheCallersMark() throws Exception {
        for (boolean buffered : new boolean[]{true, false}) {
            InputStream source = new ByteArrayInputStream(DATA);
            InputStream input = buffered ? new BufferedInputStream(source, DATA.length) : new FilterInputStream(source) { };
            RecordingRequestor requestor = new RecordingRequestor();
            try (InputStream owned = input) {
                owned.skip(3);
                owned.mark(DATA.length);
                owned.skip(4);
                client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(owned, 7);
                assertEquals(requestor.body.toByteArray(), Arrays.copyOfRange(DATA, 7, 14));
                assertFalse(requestor.arg.contains("content_hash"));
                assertEquals(owned.read(), DATA[14]);
                owned.reset();
                assertEquals(owned.read(), DATA[3], "automatic hashing must not replace the caller's mark");
            }
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

    @DataProvider(name = "byteArraySubclasses")
    public Object[][] byteArraySubclasses() {
        return new Object[][]{{"shortSkip", 0L}, {"zeroSkip", 0L}, {"available", 0L}, {"reset", 0L},
                {"shortSkip", 7L}, {"zeroSkip", 7L}, {"available", 7L}, {"reset", 7L},
                {"shortSkip", Long.MAX_VALUE}, {"zeroSkip", Long.MAX_VALUE},
                {"available", Long.MAX_VALUE}, {"reset", Long.MAX_VALUE}};
    }

    @Test(dataProvider = "byteArraySubclasses")
    public void byteArraySubclassMustNotBeConsumedOrRepositionedByHashing(String kind, long limit) throws Exception {
        int[] resets = {0};
        ByteArrayInputStream input = new ByteArrayInputStream(DATA) {
            @Override public synchronized long skip(long count) {
                if (kind.equals("shortSkip")) return super.skip(Math.min(1, count));
                if (kind.equals("zeroSkip")) return 0;
                return super.skip(count);
            }
            @Override public synchronized int available() {
                return kind.equals("available") ? 0 : super.available();
            }
            @Override public synchronized void reset() {
                resets[0]++;
                if (kind.equals("reset")) throw new IllegalStateException("reset unsupported");
                super.reset();
            }
        };
        for (int i = 0; i < 3; i++) input.read();
        input.mark(0);
        for (int i = 0; i < 4; i++) input.read();
        RecordingRequestor requestor = new RecordingRequestor();
        client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(input, limit);
        int end = 7 + (int) Math.min(limit, DATA.length - 7);
        assertEquals(requestor.body.toByteArray(), Arrays.copyOfRange(DATA, 7, end));
        assertFalse(requestor.arg.contains("content_hash"), "unknown subclass rewind behavior must be skipped");
        assertEquals(resets[0], 0, "automatic hashing must not alter the subclass's state");
        assertEquals(input.read(), end < DATA.length ? DATA[end] & 0xff : -1);
        if (!kind.equals("reset")) {
            input.reset();
            assertEquals(input.read(), DATA[3]);
        }
    }

    @Test
    public void generatedArgumentCopiesAndReuseAcrossSupportedRoutes() throws Exception {
        for (String route : new String[]{"upload", "start", "append", "batch", "finish", "alpha"}) {
            RecordingRequestor requestor = new RecordingRequestor();
            DbxUploadStyleBuilder<?, ?, ?> builder = builder(client(requestor, true).files(), route);
            Class<?> type = builder.getClass();
            java.lang.reflect.Method setter = type.getDeclaredMethod("withContentHash", String.class);
            assertTrue(java.lang.reflect.Modifier.isPublic(setter.getModifiers()));
            java.lang.reflect.Method start = type.getDeclaredMethod("start", InputStream.class, long.class);
            assertTrue(java.lang.reflect.Modifier.isProtected(start.getModifiers()));
            byte[] second = DATA.clone();
            second[0] ^= 1; // Keep batch entry lengths valid while changing its content.
            builder.uploadAndFinish(new ByteArrayInputStream(DATA));
            assertHash(requestor, DATA);
            builder.uploadAndFinish(new ByteArrayInputStream(second));
            assertHash(requestor, second);
            String manual = "0".repeat(64);
            setter.invoke(builder, manual);
            builder.uploadAndFinish(new ByteArrayInputStream(DATA));
            assertTrue(requestor.arg.contains(manual));
            builder.uploadAndFinish(new ByteArrayInputStream(second));
            assertTrue(requestor.arg.contains(manual), "reuse must retain an explicit hash");
            setter.invoke(builder, (Object) null);
            builder.uploadAndFinish(new ByteArrayInputStream(second));
            assertHash(requestor, second);
            InputStream nonmark = new FilterInputStream(new ByteArrayInputStream(DATA)) {
                @Override public boolean markSupported() { return false; }
            };
            builder.uploadAndFinish(nonmark);
            assertFalse(requestor.arg.contains("content_hash"), "skipped hashing must not retain a prior hash");
            assertEquals(requestor.starts, 6);
            assertEquals(requestor.closes, 6);
        }
    }

    @Test
    public void failedFileRewindNeverStartsHttp() throws Exception {
        Path path = Files.createTempFile("dropbox-failed-rewind", ".bin");
        try {
            Files.write(path, DATA);
            RecordingRequestor requestor = new RecordingRequestor();
            UploadSessionAppendV2Builder builder = client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR);
            try (FileInputStream input = new FileInputStream(path.toFile()) {
                @Override public int read(byte[] bytes, int offset, int length) throws IOException {
                    int count = super.read(bytes, offset, length);
                    close(); // Hashing the limited payload succeeds; restoring its position cannot.
                    return count;
                }
            }) {
                expectThrows(java.nio.channels.ClosedChannelException.class, () -> builder.uploadAndFinish(input, 7));
                assertEquals(requestor.starts, 0);
            }
            builder.uploadAndFinish(new ByteArrayInputStream(DATA));
            assertHash(requestor, DATA);
        } finally {
            Files.delete(path);
        }
    }

    @Test
    public void customRequestorReceivesOriginalUnlimitedInput() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        ByteArrayInputStream input = new ByteArrayInputStream(DATA);
        client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(input);
        assertSame(requestor.input, input);
        assertEquals(requestor.closes, 1);
    }

    @Test
    public void automaticHashesAreRequestLocalDuringHttpCreation() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        UploadBuilder builder = client(requestor, true).files().uploadBuilder("/file");
        requestor.onStart = () -> {
            requestor.onStart = null;
            try {
                builder.start().close();
            } catch (DbxException ex) {
                throw new AssertionError(ex);
            }
        };
        builder.uploadAndFinish(new ByteArrayInputStream(DATA));
        assertEquals(requestor.arguments.size(), 2);
        assertTrue(requestor.arguments.get(0).contains("content_hash"));
        assertFalse(requestor.arguments.get(1).contains("content_hash"), "a second request must not see the first request's hash");
        assertEquals(requestor.closes, 2);
    }

    @Test
    public void snapshotDoesNotOverwriteBuilderChangesDuringHashing() throws Exception {
        Path path = Files.createTempFile("dropbox-hash-snapshot", ".bin");
        try {
            Files.write(path, DATA);
            RecordingRequestor requestor = new RecordingRequestor();
            UploadBuilder builder = client(requestor, true).files().uploadBuilder("/file")
                    .withAutorename(true).withMute(true).withStrictConflict(true).withMode(WriteMode.OVERWRITE)
                    .withClientModified(new Date(1577836800000L))
                    .withPropertyGroups(Collections.singletonList(new PropertyGroup("ptid:copy-test",
                            Collections.singletonList(new PropertyField("tag", "kept")))));
            String manual = "0".repeat(64);
            try (FileInputStream input = new FileInputStream(path.toFile()) {
                boolean changed;
                @Override public int read(byte[] bytes, int offset, int length) throws IOException {
                    if (!changed) {
                        changed = true;
                        builder.withContentHash(manual).withMute(false);
                    }
                    return super.read(bytes, offset, length);
                }
            }) {
                builder.uploadAndFinish(input);
            }
            assertHash(requestor, DATA);
            assertTrue(requestor.arg.contains("\"mute\":true"));
            assertTrue(requestor.arg.contains("\"autorename\":true"));
            assertTrue(requestor.arg.contains("\"strict_conflict\":true"));
            assertTrue(requestor.arg.contains("overwrite"));
            assertTrue(requestor.arg.contains("\"client_modified\":\"2020-01-01T00:00:00Z\""));
            assertTrue(requestor.arg.contains("\"template_id\":\"ptid:copy-test\""));
            assertTrue(requestor.arg.contains("\"value\":\"kept\""));
            builder.uploadAndFinish(new ByteArrayInputStream(DATA));
            assertTrue(requestor.arg.contains(manual), "preparing one request must not overwrite subsequent builder state");
            assertTrue(requestor.arg.contains("\"mute\":false"));
        } finally {
            Files.delete(path);
        }
    }

    @Test
    public void copiedArgumentsMatchTheOrdinaryBuilderForDefaultsNullsAndOptions() throws Exception {
        String hash = DropboxContentHasher.hashHex(DATA);
        for (String route : new String[]{"upload", "start", "append", "batch", "finish", "alpha"}) {
            for (boolean options : new boolean[]{false, true}) {
                Date modified = options ? new Date(1577836800000L) : null;
                List<PropertyGroup> groups = options ? Collections.singletonList(new PropertyGroup("ptid:copy",
                        Collections.singletonList(new PropertyField("tag", "value")))) : null;
                WriteMode mode = options ? WriteMode.OVERWRITE : null;
                CommitInfo fromBuilder = CommitInfo.newBuilder("/file").withMode(mode)
                        .withAutorename(options ? true : null).withMute(options ? true : null)
                        .withStrictConflict(options ? true : null).withClientModified(modified)
                        .withPropertyGroups(groups).build();
                CommitInfo fromConstructor = new CommitInfo("/file", options ? WriteMode.OVERWRITE : WriteMode.ADD,
                        options, modified, options, groups, options);
                assertEquals(fromBuilder, fromConstructor);
                RecordingRequestor automatic = new RecordingRequestor(), explicit = new RecordingRequestor();
                DbxUserFilesRequests autoFiles = client(automatic, true).files(), manualFiles = client(explicit, true).files();
                DbxUploadStyleBuilder<?, ?, ?> auto = route.equals("finish")
                        ? autoFiles.uploadSessionFinishBuilder(CURSOR, fromBuilder) : builder(autoFiles, route);
                DbxUploadStyleBuilder<?, ?, ?> manual = route.equals("finish")
                        ? manualFiles.uploadSessionFinishBuilder(CURSOR, fromConstructor).withContentHash(hash)
                        : builder(manualFiles, route, hash);
                for (DbxUploadStyleBuilder<?, ?, ?> target : new DbxUploadStyleBuilder<?, ?, ?>[]{auto, manual}) {
                    Class<?> type = target.getClass();
                    if (route.equals("upload") || route.equals("alpha")) {
                        type.getMethod("withMode", WriteMode.class).invoke(target, mode);
                        type.getMethod("withAutorename", Boolean.class).invoke(target, options ? Boolean.TRUE : null);
                        type.getMethod("withMute", Boolean.class).invoke(target, options ? Boolean.TRUE : null);
                        type.getMethod("withStrictConflict", Boolean.class).invoke(target, options ? Boolean.TRUE : null);
                        type.getMethod("withClientModified", Date.class).invoke(target, modified);
                        type.getMethod("withPropertyGroups", List.class).invoke(target, groups);
                    } else if (route.equals("start")) {
                        ((UploadSessionStartBuilder) target).withClose(options ? true : null)
                                .withSessionType(options ? UploadSessionType.SEQUENTIAL : null);
                    } else if (route.equals("append")) {
                        ((UploadSessionAppendV2Builder) target).withClose(options ? true : null);
                    }
                }
                auto.uploadAndFinish(new ByteArrayInputStream(DATA));
                manual.start().uploadAndFinish(new ByteArrayInputStream(DATA));
                assertEquals(automatic.arg, explicit.arg, route + ": options=" + options);
                assertEquals(automatic.body.toByteArray(), explicit.body.toByteArray());
            }
        }
    }

    @DataProvider(name = "byteArrayViews")
    public Object[][] byteArrayViews() {
        List<Object[]> cases = new ArrayList<>();
        for (int[] view : new int[][]{{0, DATA.length, 0, 0}, {3, 13, 5, 7}, {3, 13, 3, 16}, {3, 13, 6, 6}})
            for (long limit : new long[]{0, 7, Long.MAX_VALUE}) cases.add(new Object[]{view, limit});
        return cases.toArray(new Object[0][]);
    }

    @Test(dataProvider = "byteArrayViews")
    public void byteArrayViewsKeepTheirPositionMarkAndLogicalEnd(int[] view, long limit) throws Exception {
        int offset = view[0], length = view[1], mark = view[2], position = view[3];
        ByteArrayInputStream input = new ByteArrayInputStream(DATA, offset, length);
        input.skip(mark - offset);
        input.mark(0);
        input.skip(position - mark);
        RecordingRequestor requestor = new RecordingRequestor();
        client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(input, limit);
        int end = position + (int) Math.min(limit, offset + length - position);
        byte[] expected = Arrays.copyOfRange(DATA, position, end);
        assertHash(requestor, expected);
        assertEquals(requestor.body.toByteArray(), expected);
        assertEquals(input.available(), offset + length - end);
        input.reset();
        assertEquals(input.available(), offset + length - mark);
        assertEquals(input.read(), DATA[mark] & 0xff);
    }

    @Test
    public void readAndRewindFailuresPreserveTheOriginalReadError() throws Exception {
        Path path = Files.createTempFile("dropbox-read-rewind", ".bin");
        IOException failure = new IOException("read failed");
        try {
            Files.write(path, DATA);
            RecordingRequestor requestor = new RecordingRequestor();
            try (FileInputStream input = new FileInputStream(path.toFile()) {
                @Override public int read(byte[] bytes, int offset, int length) throws IOException {
                    super.read(bytes, offset, Math.min(1, length));
                    close();
                    throw failure;
                }
            }) {
                input.getChannel().position(7);
                IOException thrown = expectThrows(IOException.class, () -> client(requestor, true).files()
                        .uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(input, 7));
                assertSame(thrown, failure);
                assertEquals(thrown.getSuppressed().length, 1);
                assertTrue(thrown.getSuppressed()[0] instanceof java.nio.channels.ClosedChannelException);
                assertEquals(requestor.starts, 0);
            }
        } finally {
            Files.delete(path);
        }
    }

    @Test
    public void nonSeekableFileChannelFallsBackWithoutPreReading() throws Exception {
        FileInputStream input = org.mockito.Mockito.mock(FileInputStream.class);
        java.nio.channels.FileChannel channel = org.mockito.Mockito.mock(java.nio.channels.FileChannel.class);
        org.mockito.Mockito.when(input.getChannel()).thenReturn(channel);
        org.mockito.Mockito.when(channel.position()).thenThrow(new IOException("Illegal seek"));
        ByteArrayInputStream payload = new ByteArrayInputStream(DATA);
        RecordingRequestor requestor = new RecordingRequestor();
        org.mockito.Mockito.when(input.read(org.mockito.ArgumentMatchers.any(byte[].class))).thenAnswer(call -> {
            assertEquals(requestor.starts, 1, "non-seekable file input must not be pre-read");
            return payload.read(call.getArgument(0));
        });
        client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR).uploadAndFinish(input);
        assertEquals(requestor.body.toByteArray(), DATA);
        assertFalse(requestor.arg.contains("content_hash"));
        assertEquals(requestor.closes, 1);
        org.mockito.Mockito.verify(channel).position();
        org.mockito.Mockito.verify(channel, org.mockito.Mockito.never()).position(org.mockito.ArgumentMatchers.anyLong());
        org.mockito.Mockito.verify(input, org.mockito.Mockito.never()).close();
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

    @SuppressWarnings("deprecation")
    private static DbxUploadStyleBuilder<?, ?, ?> builder(DbxUserFilesRequests files, String route, String hash, long length) {
        switch (route) {
            case "upload": return files.uploadBuilder("/file").withContentHash(hash);
            case "alpha": return files.alphaUploadBuilder("/file").withContentHash(hash);
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
        final List<String> arguments = new ArrayList<>();
        Runnable onStart;
        String arg;
        int starts, closes;
        IOException startFailure, writeFailure;
        InputStream input;
        IOUtil.ProgressListener listener;
        @Override public Uploader startPost(String url, Iterable<Header> headers) throws IOException {
            starts++;
            if (startFailure != null) throw startFailure;
            body.reset();
            for (Header header : headers) if (header.getKey().equals("Dropbox-API-Arg")) arg = header.getValue();
            String currentArg = arg;
            arguments.add(currentArg);
            if (onStart != null) onStart.run();
            arg = currentArg;
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
                @Override public void upload(InputStream stream) throws IOException {
                    input = stream;
                    super.upload(stream);
                }
                @Override public void upload(InputStream stream, long limit) {
                    throw new AssertionError("DbxUploader must retain its original single-argument dispatch");
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
