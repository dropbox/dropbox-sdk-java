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
    public void testDefaultAndCopiedOptIn() {
        assertFalse(new DbxRequestConfig("test").isAutoContentHashEnabled());
        assertFalse(DbxRequestConfig.newBuilder("test").build().isAutoContentHashEnabled());
        DbxRequestConfig enabled = DbxRequestConfig.newBuilder("test").withAutoContentHash(true).build();
        assertTrue(enabled.copy().build().isAutoContentHashEnabled());
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

    @Test
    public void testDefaultPreservesEagerInitializationAndOriginalInput() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        DbxClientV2 client = new DbxClientV2(DbxRequestConfig.newBuilder("test")
                .withHttpRequestor(requestor).build(), "fake-token");
        UploadSessionAppendV2Uploader uploader = client.files().uploadSessionAppendV2(CURSOR);
        assertEquals(requestor.starts, 1);
        ByteArrayInputStream input = new ByteArrayInputStream(DATA);
        uploader.uploadAndFinish(input);
        assertSame(requestor.input, input);
        assertFalse(requestor.arg.contains("content_hash"));
    }

    @Test
    public void testBodyIsObtainedOnceAndClosedOnce() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        OutputStream output = uploader.getBody();
        assertSame(uploader.getBody(), output);
        assertEquals(requestor.starts, 0);
        output.write('a');
        output.write(new byte[]{'b', 'c'});
        output.flush();
        output.close();
        output.close();
        assertEquals(requestor.bodyCalls, 1);
        assertEquals(requestor.bodyCloses, 1);
        assertEquals(requestor.flushes, 1);
        assertEquals(requestor.body.toByteArray(), new byte[]{'a', 'b', 'c'});
        expectThrows(IOException.class, () -> output.write('d'));
        expectThrows(IOException.class, output::flush);
        uploader.finish();
        expectThrows(IOException.class, uploader::finish);
        uploader.close();
        uploader.close();
        assertEquals(requestor.closes, 1);
    }

    @Test
    public void testEmptyBodyCloseAndAbortDoNotReopenConnection() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        uploader.getBody().close();
        uploader.finish();
        assertEquals(requestor.starts, 1);
        assertEquals(requestor.bodyCalls, 1);
        assertEquals(requestor.bodyCloses, 1);
        uploader.close();

        requestor = new RecordingRequestor();
        uploader = lazyUploader(requestor, "{}");
        OutputStream output = uploader.getBody();
        uploader.abort();
        output.close();
        assertEquals(requestor.starts, 0);
        expectThrows(IOException.class, () -> output.write(1));
    }

    @Test
    public void testInitializationFailureDoesNotRetryDuringBodyCleanup() throws Exception {
        IOException failure = new IOException("connect failed");
        RecordingRequestor requestor = new RecordingRequestor() {
            @Override public Uploader startPost(String url, Iterable<Header> headers) throws IOException {
                starts++;
                throw failure;
            }
        };
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        OutputStream output = uploader.getBody();
        assertSame(expectThrows(IOException.class, () -> output.write(1)), failure);
        output.close();
        expectThrows(IOException.class, uploader::finish);
        assertEquals(requestor.starts, 1);
    }

    @Test
    public void testListenerFailureClosesInitializedDelegate() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        requestor.listenerFailure = new IllegalStateException("listener failed");
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        OutputStream output = uploader.getBody();
        assertSame(expectThrows(IllegalStateException.class, () -> output.write(1)), requestor.listenerFailure);
        output.close();
        uploader.close();
        assertEquals(requestor.starts, 1);
        assertEquals(requestor.closes, 1);
    }

    @Test
    public void testBodyFailureReleasesDelegate() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        requestor.bodyFailure = new IllegalStateException("body failed");
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        OutputStream output = uploader.getBody();
        assertSame(expectThrows(IllegalStateException.class, () -> output.write(1)), requestor.bodyFailure);
        output.close();
        assertEquals(requestor.closes, 1);
        assertEquals(requestor.bodyCalls, 1);
    }

    @Test
    public void testJsonInjectionPreservesNestedValuesAndHeaderEscaping() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        String json = " \n { \"commit\":{\"path\":\"/caf\u00e9\u007f\\\".txt\",\"mute\":true},"
                + "\"entries\":[{\"length\":3}],\"cursor\":{\"offset\":9007199254740993} } ";
        AutoContentHashUploader uploader = lazyUploader(requestor, json);
        uploader.upload(new ByteArrayInputStream(DATA));
        assertHash(requestor, DATA);
        assertTrue(requestor.arg.contains("9007199254740993"));
        assertTrue(requestor.arg.contains("\"mute\":true"));
        assertTrue(requestor.arg.contains("\"entries\":[{\"length\":3}]"));
        for (char c : requestor.arg.toCharArray()) assertTrue(c >= 0x20 && c <= 0x7e);
        try (com.fasterxml.jackson.core.JsonParser parser = new com.fasterxml.jackson.core.JsonFactory()
                .createParser(requestor.arg)) {
            boolean sawPath = false;
            while (parser.nextToken() != null) {
                if (parser.currentToken() == com.fasterxml.jackson.core.JsonToken.FIELD_NAME
                        && "path".equals(parser.currentName())) {
                    assertEquals(parser.nextTextValue(), "/caf\u00e9\u007f\".txt");
                    sawPath = true;
                }
            }
            assertTrue(sawPath);
        }
        uploader.close();
    }

    @Test
    public void testSessionFinishHashesOnlyCurrentPayloadAndBatchDoesNotResetAtEntries() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        requestor.response = "{\"name\":\"file\",\"id\":\"id:123\","
                + "\"client_modified\":\"2020-01-01T00:00:00Z\","
                + "\"server_modified\":\"2020-01-01T00:00:00Z\",\"rev\":\"123456789\",\"size\":20}";
        client(requestor, true).files().uploadSessionFinish(new UploadSessionCursor("session", 12345),
                new CommitInfo("/file")).uploadAndFinish(new ByteArrayInputStream(new byte[]{0}));
        assertTrue(requestor.arg.contains("1406e05881e299367766d313e26c05564ec91bf721d31726bd6e46e60689539a"));
        assertEquals(requestor.body.toByteArray(), new byte[]{0});

        byte[] payload = new byte[DropboxContentHasher.BLOCK_SIZE + 1];
        for (int i = 0; i < payload.length; i++) payload[i] = (byte) (i % 251);
        requestor = new RecordingRequestor();
        requestor.response = "{\"entries\":[]}";
        client(requestor, true).files().uploadSessionAppendBatch(java.util.Arrays.asList(
                new UploadSessionAppendBatchArgEntry(CURSOR, 3, true),
                new UploadSessionAppendBatchArgEntry(new UploadSessionCursor("other", 5678), payload.length - 3, true)))
                .uploadAndFinish(new ByteArrayInputStream(payload));
        assertTrue(requestor.arg.contains("4a6cc0a344febaa07772e7c974834b2fb1d24594d4ba15f27c97a54699709f44"));
        assertEquals(requestor.body.toByteArray(), payload);
    }

    @Test
    public void testWriteAndFinishFailuresCloseDelegate() throws Exception {
        for (boolean failWrite : new boolean[]{true, false}) {
            RecordingRequestor requestor = new RecordingRequestor();
            IOException failure = new IOException(failWrite ? "write failed" : "finish failed");
            if (failWrite) requestor.writeFailure = failure;
            else requestor.finishFailure = failure;
            NetworkIOException thrown = expectThrows(NetworkIOException.class, () -> client(requestor, true)
                    .files().uploadSessionAppendV2(CURSOR).uploadAndFinish(new ByteArrayInputStream(DATA)));
            assertTrue(thrown.getCause() == failure || thrown.getCause().getCause() == failure);
            assertEquals(requestor.starts, 1);
            assertEquals(requestor.closes, 1);
            assertEquals(requestor.bodyCloses, 1);
        }
    }

    @Test
    public void testHashAndRewindFailuresPreserveBothExceptions() throws Exception {
        Path file = Files.createTempFile("dropbox-hash-rewind", ".bin");
        IOException failure = new IOException("read failed");
        try (FileInputStream input = new FileInputStream(file.toFile()) {
            @Override public int read(byte[] bytes, int off, int len) throws IOException {
                close(); // Also make restoring the file position fail.
                throw failure;
            }
        }) {
            RecordingRequestor requestor = new RecordingRequestor();
            IOException thrown = expectThrows(IOException.class, () -> client(requestor, true).files()
                    .uploadSessionAppendV2(CURSOR).uploadAndFinish(input));
            assertSame(thrown, failure);
            assertEquals(thrown.getSuppressed().length, 1);
            assertTrue(thrown.getSuppressed()[0] instanceof java.nio.channels.ClosedChannelException);
            assertEquals(requestor.starts, 0);
        } finally {
            Files.delete(file);
        }
    }

    @Test
    public void testFinishSuccessKeepsResponseAliveUntilExplicitClose() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        HttpRequestor.Response response = uploader.finish();
        assertEquals(requestor.closes, 0, "custom requestors may own a still-readable response");
        expectThrows(IOException.class, uploader::finish);
        assertFalse(requestor.responseClosed);
        assertEquals(response.getBody().read(), 'n');
        uploader.close();
        uploader.close();
        uploader.abort();
        assertTrue(requestor.responseClosed);
        assertEquals(requestor.closes, 1);
        assertEquals(requestor.aborts, 0);
        assertEquals(requestor.finishCalls, 1);
    }

    @Test
    public void testFinishIOExceptionReleasesDelegateWithoutCallerCleanup() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        requestor.finishFailure = new IOException("finish failed");
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        assertSame(expectThrows(IOException.class, uploader::finish), requestor.finishFailure);
        assertEquals(requestor.closes, 1);
        expectThrows(IOException.class, uploader::finish);
        uploader.close();
        uploader.abort();
        assertEquals(requestor.closes, 1);
        assertEquals(requestor.aborts, 0);
        assertEquals(requestor.finishCalls, 1);
    }

    @Test
    public void testBodyCloseFailureReleasesDelegateWithoutCallerCleanup() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        requestor.bodyCloseFailure = new IOException("body close failed");
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        OutputStream output = uploader.getBody();
        assertSame(expectThrows(IOException.class, output::close), requestor.bodyCloseFailure);
        assertEquals(requestor.closes, 1);
        output.close();
        uploader.close();
        uploader.abort();
        expectThrows(IOException.class, uploader::finish);
        assertEquals(requestor.bodyCloses, 1);
        assertEquals(requestor.closes, 1);
        assertEquals(requestor.aborts, 0);
    }

    @Test
    public void testCleanupFailureIsSuppressedAndCloseCanBeRetried() throws Exception {
        for (boolean failFinish : new boolean[]{true, false}) {
            RecordingRequestor requestor = new RecordingRequestor();
            IOException failure = new IOException("operation failed");
            if (failFinish) requestor.finishFailure = failure;
            else requestor.bodyCloseFailure = failure;
            requestor.closeFailuresRemaining = 1;
            AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
            IOException thrown = expectThrows(IOException.class, () -> {
                if (failFinish) uploader.finish();
                else uploader.getBody().close();
            });
            assertSame(thrown, failure);
            assertEquals(thrown.getSuppressed().length, 1);
            assertSame(thrown.getSuppressed()[0], requestor.closeFailure);
            assertEquals(requestor.closes, 1);
            uploader.close();
            uploader.close();
            uploader.abort();
            assertEquals(requestor.closes, 2);
            assertEquals(requestor.aborts, 0);
            assertEquals(requestor.starts, 1);
        }
    }

    @Test
    public void testExplicitCloseFailureIsTerminalButCleanupCanBeRetried() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        requestor.closeFailuresRemaining = 1;
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        OutputStream output = uploader.getBody();
        output.write(1);
        assertSame(expectThrows(IllegalStateException.class, uploader::close), requestor.closeFailure);
        expectThrows(IOException.class, () -> output.write(2));
        expectThrows(IOException.class, uploader::finish);
        uploader.close();
        uploader.close();
        uploader.abort();
        assertEquals(requestor.closes, 2);
        assertEquals(requestor.aborts, 0);
        assertEquals(requestor.starts, 1);
    }

    @Test
    public void testAbortPreservesFailureAndRetriesOnlyCleanup() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        requestor.abortFailure = new IllegalStateException("abort failed");
        requestor.closeFailuresRemaining = 1;
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        uploader.getBody().write(1);
        RuntimeException thrown = expectThrows(IllegalStateException.class, uploader::abort);
        assertSame(thrown, requestor.abortFailure);
        assertEquals(thrown.getSuppressed().length, 1);
        assertSame(thrown.getSuppressed()[0], requestor.closeFailure);
        uploader.abort();
        uploader.abort();
        uploader.close();
        expectThrows(IOException.class, uploader::finish);
        assertEquals(requestor.aborts, 1);
        assertEquals(requestor.closes, 2);
        assertEquals(requestor.starts, 1);
    }

    @Test
    public void testAbortAfterSuccessfulFinishOnlyClosesDelegate() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        requestor.abortFailure = new IllegalStateException("transport already finished");
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        uploader.finish();
        uploader.abort();
        uploader.abort();
        uploader.close();
        assertEquals(requestor.closes, 1);
        assertEquals(requestor.aborts, 0);
        assertEquals(requestor.starts, 1);
    }

    @Test
    public void testInitializationCleanupFailureCanBeRetried() throws Exception {
        RecordingRequestor requestor = new RecordingRequestor();
        requestor.listenerFailure = new IllegalStateException("listener failed");
        requestor.closeFailuresRemaining = 1;
        AutoContentHashUploader uploader = lazyUploader(requestor, "{}");
        RuntimeException thrown = expectThrows(IllegalStateException.class, () -> uploader.getBody().write(1));
        assertSame(thrown, requestor.listenerFailure);
        assertSame(thrown.getSuppressed()[0], requestor.closeFailure);
        uploader.close();
        uploader.abort();
        expectThrows(IOException.class, uploader::finish);
        assertEquals(requestor.closes, 2);
        assertEquals(requestor.aborts, 0);
        assertEquals(requestor.starts, 1);
    }

    @Test
    public void testManualDbxUploaderFinishLifecycle() throws Exception {
        for (boolean failFinish : new boolean[]{false, true}) {
            RecordingRequestor requestor = new RecordingRequestor();
            if (failFinish) requestor.finishFailure = new IOException("finish failed");
            UploadSessionAppendV2Uploader uploader = client(requestor, true).files().uploadSessionAppendV2(CURSOR);
            try {
                OutputStream output = uploader.getOutputStream();
                output.write(DATA);
                output.close();
                if (failFinish) {
                    NetworkIOException thrown = expectThrows(NetworkIOException.class, uploader::finish);
                    assertSame(thrown.getCause(), requestor.finishFailure);
                    assertEquals(requestor.closes, 1);
                } else {
                    uploader.finish();
                    assertTrue(requestor.responseClosed, "DbxUploader must consume and close the response");
                    assertEquals(requestor.closes, 0, "delegate stays open until caller cleanup");
                }
                expectThrows(IllegalStateException.class, uploader::finish);
                uploader.abort();
                uploader.abort();
            } finally {
                uploader.close();
                uploader.close();
            }
            assertEquals(requestor.closes, 1);
            assertEquals(requestor.aborts, 0);
            assertEquals(requestor.finishCalls, 1);
        }
    }

    private static AutoContentHashUploader lazyUploader(RecordingRequestor requestor, String json) {
        return new AutoContentHashUploader(requestor, "https://example.test/upload",
                Collections.singletonList(new HttpRequestor.Header("Dropbox-API-Arg", json)));
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
        InputStream input;
        int bodyCalls;
        int bodyCloses;
        int flushes;
        int closes;
        RuntimeException listenerFailure;
        RuntimeException bodyFailure;
        IOException writeFailure;
        IOException finishFailure;
        IOException bodyCloseFailure;
        final RuntimeException closeFailure = new IllegalStateException("close failed");
        RuntimeException abortFailure;
        int closeFailuresRemaining;
        int aborts;
        int finishCalls;
        boolean responseClosed;

        @Override public Uploader startPost(String url, Iterable<Header> headers) throws IOException {
            starts++;
            for (Header header : headers) {
                if ("Dropbox-API-Arg".equals(header.getKey())) arg = header.getValue();
            }
            return new Uploader() {
                @Override public OutputStream getBody() {
                    bodyCalls++;
                    if (bodyFailure != null) throw bodyFailure;
                    return new OutputStream() {
                        @Override public void write(int value) throws IOException {
                            if (writeFailure != null) throw writeFailure;
                            body.write(value);
                        }
                        @Override public void write(byte[] b, int off, int len) throws IOException {
                            if (writeFailure != null) throw writeFailure;
                            body.write(b, off, len);
                        }
                        @Override public void flush() { flushes++; }
                        @Override public void close() throws IOException {
                            bodyCloses++;
                            if (bodyCloseFailure != null) throw bodyCloseFailure;
                        }
                    };
                }
                @Override public void upload(InputStream in) throws IOException {
                    input = in;
                    super.upload(in);
                }
                @Override public void close() {
                    closes++;
                    if (closeFailuresRemaining > 0) {
                        closeFailuresRemaining--;
                        throw closeFailure;
                    }
                    responseClosed = true;
                }
                @Override public void abort() {
                    aborts++;
                    if (abortFailure != null) throw abortFailure;
                }
                @Override public Response finish() throws IOException {
                    finishCalls++;
                    if (finishFailure != null) throw finishFailure;
                    responseClosed = false;
                    InputStream responseBody = new ByteArrayInputStream(response.getBytes(StandardCharsets.UTF_8)) {
                        @Override public synchronized int read() {
                            if (responseClosed) throw new IllegalStateException("response closed");
                            return super.read();
                        }
                        @Override public synchronized int read(byte[] bytes, int offset, int length) {
                            if (responseClosed) throw new IllegalStateException("response closed");
                            return super.read(bytes, offset, length);
                        }
                        @Override public void close() { responseClosed = true; }
                    };
                    return new Response(200, responseBody, Collections.emptyMap());
                }
                @Override public void setProgressListener(IOUtil.ProgressListener value) {
                    if (listenerFailure != null) throw listenerFailure;
                    listener = value;
                }
            };
        }
        @Override public Response doGet(String url, Iterable<Header> headers) { throw new AssertionError(); }
        @Override public Uploader startPut(String url, Iterable<Header> headers) { throw new AssertionError(); }
    }
}
