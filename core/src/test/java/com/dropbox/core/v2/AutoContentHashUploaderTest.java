package com.dropbox.core.v2;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.NetworkIOException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.DropboxContentHasher;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.v2.files.UploadSessionCursor;
import com.dropbox.core.v2.files.CommitInfo;
import com.dropbox.core.v2.files.UploadBuilder;
import com.dropbox.core.v2.files.UploadSessionAppendBatchArgEntry;
import com.dropbox.core.v2.files.UploadSessionAppendV2Uploader;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

import static org.testng.Assert.*;

public class AutoContentHashUploaderTest {
    private static final byte[] DATA = "prefix-payload-suffix".getBytes(StandardCharsets.UTF_8);
    private static final UploadSessionCursor CURSOR = new UploadSessionCursor("session", 0);

    @Test
    public void testDefaultAndCopiedOptOut() {
        assertTrue(new DbxRequestConfig("test").isAutoContentHashEnabled());
        DbxRequestConfig disabled = DbxRequestConfig.newBuilder("test").withAutoContentHash(false).build();
        assertFalse(disabled.isAutoContentHashEnabled());
        assertFalse(disabled.copy().build().isAutoContentHashEnabled());
        assertTrue(disabled.copy().withAutoContentHash(true).build().isAutoContentHashEnabled());
    }

    @Test
    public void testLimitedUploadFromCurrentPositionAndProgress() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        ByteArrayInputStream input = new ByteArrayInputStream(DATA);
        input.skip(7);
        IOUtil.ProgressListener listener = bytes -> { };
        client(requestor, true).files().uploadSessionAppendV2Builder(CURSOR)
                .uploadAndFinish(input, 7, listener);
        assertEquals(requestor.body.toByteArray(), "payload".getBytes(StandardCharsets.UTF_8));
        assertHash(requestor, "payload".getBytes(StandardCharsets.UTF_8));
        assertEquals(input.read(), '-');
        assertSame(requestor.listener, listener);
    }

    @Test
    public void testFilePositionAndOwnership() throws Exception {
        Path file = Files.createTempFile("dropbox-content-hash", ".bin");
        try {
            Files.write(file, DATA);
            RecordingRequestor requestor = new RecordingRequestor();
            try (FileInputStream input = new FileInputStream(file.toFile())) {
                input.getChannel().position(7);
                client(requestor, true).files().uploadSessionAppendV2(CURSOR).uploadAndFinish(input);
                assertHash(requestor, "payload-suffix".getBytes(StandardCharsets.UTF_8));
                assertEquals(input.getChannel().position(), DATA.length);
                assertTrue(input.getChannel().isOpen());
            }
        } finally {
            Files.delete(file);
        }
    }

    @Test
    public void testOptOutDoesNotPreRead() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        ByteArrayInputStream input = new ByteArrayInputStream(DATA) {
            @Override
            public synchronized int read(byte[] b, int off, int len) {
                assertEquals(requestor.starts, 1, "opt-out must not pre-read the input");
                return super.read(b, off, len);
            }
        };
        client(requestor, false).files().uploadSessionAppendV2(CURSOR).uploadAndFinish(input);
        assertFalse(requestor.arg.contains("content_hash"));
        assertEquals(requestor.body.toByteArray(), DATA);
    }

    @Test
    public void testManualHashSurvivesOptOutAndDefault() throws Exception {
        String manual = "0".repeat(64);
        for (boolean enabled : new boolean[]{true, false}) {
            RecordingRequestor requestor = new RecordingRequestor();
            client(requestor, enabled).files().uploadSessionAppendV2Builder(CURSOR)
                    .withContentHash(manual).uploadAndFinish(new ByteArrayInputStream(DATA));
            assertTrue(requestor.arg.contains("\"content_hash\":\"" + manual + "\""));
        }
    }

    @Test
    public void testNonSeekableAndOutputStreamUploads() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        InputStream input = new FilterInputStream(new ByteArrayInputStream(DATA)) {
            @Override public boolean markSupported() { return false; }
        };
        client(requestor, true).files().uploadSessionAppendV2(CURSOR).uploadAndFinish(input);
        assertFalse(requestor.arg.contains("content_hash"));
        assertEquals(requestor.body.toByteArray(), DATA);

        requestor = new RecordingRequestor();
        try (UploadSessionAppendV2Uploader uploader = client(requestor, true).files().uploadSessionAppendV2(CURSOR)) {
            uploader.getOutputStream().write(DATA);
            uploader.finish();
        }
        assertFalse(requestor.arg.contains("content_hash"));
        assertEquals(requestor.body.toByteArray(), DATA);
    }

    @Test
    public void testZeroLengthUpload() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        client(requestor, true).files().uploadSessionAppendV2(CURSOR)
                .uploadAndFinish(new ByteArrayInputStream(DATA), 0);
        assertEquals(requestor.body.size(), 0);
        assertHash(requestor, new byte[0]);
    }

    @Test
    public void testHashReadFailureRestoresPositionAndSendsNothing() throws Exception {
        Path file = Files.createTempFile("dropbox-content-hash-error", ".bin");
        try {
            Files.write(file, DATA);
            RecordingRequestor requestor = new RecordingRequestor();
            IOException failure = new IOException("read failed");
            try (FileInputStream input = new FileInputStream(file.toFile()) {
                @Override public int read(byte[] b, int off, int len) throws IOException {
                    super.read(b, off, Math.min(1, len));
                    throw failure;
                }
            }) {
                input.getChannel().position(3);
                IOException thrown = expectThrows(IOException.class, () -> client(requestor, true).files()
                        .uploadSessionAppendV2(CURSOR).uploadAndFinish(input));
                assertSame(thrown, failure);
                assertEquals(input.getChannel().position(), 3);
                assertEquals(requestor.starts, 0);
            }
        } finally {
            Files.delete(file);
        }
    }

    @Test
    public void testDeferredConnectionFailure() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor() {
            @Override public Uploader startPost(String url, Iterable<Header> headers) throws IOException {
                throw new IOException("connect failed");
            }
        };
        expectThrows(NetworkIOException.class, () -> client(requestor, true).files()
                .uploadSessionAppendV2(CURSOR).uploadAndFinish(new ByteArrayInputStream(DATA)));
    }

    @Test
    public void testSupportedRoutesAndExplicitHashDetection() throws Exception {
        for (String path : new String[]{"upload", "upload_session/start", "upload_session/append_v2",
                "upload_session/append_batch", "upload_session/finish"}) {
            assertTrue(AutoContentHashUploader.needsContentHash("2/files/" + path, "{}"));
            assertFalse(AutoContentHashUploader.needsContentHash("2/files/" + path,
                    "{\"content_hash\":\"manual\"}"));
        }
        assertFalse(AutoContentHashUploader.needsContentHash("2/files/upload_session/append", "{}"));
        assertFalse(AutoContentHashUploader.needsContentHash("2/paper/docs/create", "{}"));
        assertTrue(AutoContentHashUploader.needsContentHash("2/files/upload_session/finish",
                "{\"commit\":{\"path\":\"/file\",\"content_hash\":\"nested\"}}"));
    }

    @Test
    public void testEveryUploadRouteAndReusableBuilder() throws Exception {
        String metadata = "{\"name\":\"file\",\"id\":\"id:123\","
                + "\"client_modified\":\"2020-01-01T00:00:00Z\","
                + "\"server_modified\":\"2020-01-01T00:00:00Z\",\"rev\":\"123456789\",\"size\":20}";
        RecordingRequestor requestor = new RecordingRequestor();
        requestor.response = metadata;
        UploadBuilder builder = client(requestor, true).files().uploadBuilder("/caf\u00e9.txt");
        builder.uploadAndFinish(new ByteArrayInputStream(DATA));
        assertHash(requestor, DATA);
        assertTrue(requestor.arg.contains("\\u00E9") || requestor.arg.contains("\\u00e9"));
        byte[] second = {1, 2, 3};
        builder.uploadAndFinish(new ByteArrayInputStream(second));
        assertHash(requestor, second);
        assertEquals(requestor.starts, 2);

        requestor = new RecordingRequestor();
        requestor.response = "{\"session_id\":\"session\"}";
        client(requestor, true).files().uploadSessionStartBuilder().uploadAndFinish(new ByteArrayInputStream(DATA));
        assertHash(requestor, DATA);

        requestor = new RecordingRequestor();
        requestor.response = "{\"entries\":[]}";
        client(requestor, true).files().uploadSessionAppendBatch(Collections.singletonList(
                new UploadSessionAppendBatchArgEntry(CURSOR, DATA.length)))
                .uploadAndFinish(new ByteArrayInputStream(DATA));
        assertHash(requestor, DATA);

        requestor = new RecordingRequestor();
        requestor.response = metadata;
        client(requestor, true).files().uploadSessionFinish(CURSOR, new CommitInfo("/file"))
                .uploadAndFinish(new ByteArrayInputStream(DATA));
        assertHash(requestor, DATA);
    }

    @Test
    public void testCloseAndAbortBeforeStartDoNotConnect() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        UploadSessionAppendV2Uploader uploader = client(requestor, true).files().uploadSessionAppendV2(CURSOR);
        uploader.close();
        expectThrows(IllegalStateException.class, () -> uploader.uploadAndFinish(new ByteArrayInputStream(DATA)));
        assertEquals(requestor.starts, 0);
        UploadSessionAppendV2Uploader aborted = client(requestor, true).files().uploadSessionAppendV2(CURSOR);
        aborted.abort();
        assertEquals(requestor.starts, 0);
    }

    private static DbxClientV2 client(RecordingRequestor requestor, boolean enabled) {
        return new DbxClientV2(DbxRequestConfig.newBuilder("test").withHttpRequestor(requestor)
                .withAutoContentHash(enabled).build(), "fake-token");
    }

    private static void assertHash(RecordingRequestor requestor, byte[] payload) {
        assertTrue(requestor.arg.contains("\"content_hash\":\"" + DropboxContentHasher.hashHex(payload) + "\""),
                requestor.arg);
    }

    private static class RecordingRequestor extends HttpRequestor {
        final ByteArrayOutputStream body = new ByteArrayOutputStream();
        int starts;
        String arg;
        String response = "null";
        IOUtil.ProgressListener listener;

        @Override public Uploader startPost(String url, Iterable<Header> headers) throws IOException {
            starts++;
            for (Header header : headers) {
                if ("Dropbox-API-Arg".equals(header.getKey())) arg = header.getValue();
            }
            return new Uploader() {
                @Override public OutputStream getBody() { return body; }
                @Override public void close() { }
                @Override public void abort() { }
                @Override public Response finish() {
                    return new Response(200, new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8)),
                            Collections.emptyMap());
                }
                @Override public void setProgressListener(IOUtil.ProgressListener value) { listener = value; }
            };
        }
        @Override public Response doGet(String url, Iterable<Header> headers) { throw new AssertionError(); }
        @Override public Uploader startPut(String url, Iterable<Header> headers) { throw new AssertionError(); }
    }
}
