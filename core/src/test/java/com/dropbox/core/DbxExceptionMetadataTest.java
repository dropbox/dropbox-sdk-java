package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.callbacks.DbxGlobalCallbackFactory;
import com.dropbox.core.v2.callbacks.DbxNetworkErrorCallback;
import com.dropbox.core.v2.callbacks.DbxRouteErrorCallback;
import com.dropbox.core.v2.files.DownloadErrorException;
import com.dropbox.core.v2.files.GetMetadataErrorException;
import com.dropbox.core.v2.files.UploadErrorException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.testng.Assert.expectThrows;
import static org.testng.Assert.fail;

public class DbxExceptionMetadataTest {
    private static final String OTHER = "{\"error\":{\".tag\":\"other\"}}";
    private static final String FILE_METADATA = "{\"name\":\"x.txt\",\"id\":\"id:x\","
        + "\"client_modified\":\"2020-01-01T00:00:00Z\",\"server_modified\":\"2020-01-01T00:00:00Z\","
        + "\"rev\":\"123456789\",\"size\":1}";

    private static class Response extends ByteArrayInputStream {
        boolean closed;
        int closeCount;
        final List<String> values = new ArrayList<String>(Arrays.asList("private-first", "second"));
        final HttpRequestor.Response response;

        Response(int status, String body, String requestId) {
            super(body.getBytes(StandardCharsets.UTF_8));
            Map<String, List<String>> headers = new TreeMap<String, List<String>>();
            headers.put("X-Dropbox-Request-Id", Collections.singletonList(requestId));
            headers.put("X-Test", values);
            headers.put("Retry-After", Collections.singletonList("0"));
            response = new HttpRequestor.Response(status, this, headers);
        }

        @Override
        public void close() {
            closed = true;
            ++closeCount;
            values.clear(); // A transport may release header storage when it closes the response.
        }
    }

    private static DbxClientV2 client(HttpRequestor requestor, int retries) {
        DbxRequestConfig.Builder config = DbxRequestConfig.newBuilder("metadata-test").withHttpRequestor(requestor);
        if (retries == 0) {
            config.withAutoRetryDisabled();
        } else {
            config.withAutoRetryEnabled(retries);
        }
        return new DbxClientV2(config.build(), "fake-token");
    }

    private static HttpRequestor requestor(HttpRequestor.Response... responses) throws IOException {
        HttpRequestor requestor = mock(HttpRequestor.class);
        HttpRequestor.Uploader uploader = mock(HttpRequestor.Uploader.class);
        when(uploader.getBody()).thenReturn(new ByteArrayOutputStream());
        when(uploader.finish()).thenReturn(responses[0], Arrays.copyOfRange(responses, 1, responses.length));
        when(requestor.startPost(anyString(), any())).thenReturn(uploader);
        when(requestor.startPostInStreamingMode(anyString(), any())).thenReturn(uploader);
        return requestor;
    }

    private static DbxException invoke(DbxClientV2 client, String style) throws Exception {
        try {
            if (style.equals("rpc")) {
                client.files().getMetadata("/test.txt");
            } else if (style.equals("download")) {
                client.files().download("/test.txt");
            } else {
                try (DbxUploader<?, ?, ?> uploader = client.files().upload("/test.txt")) {
                    uploader.finish();
                }
            }
            fail("Expected HTTP failure");
            return null;
        } catch (DbxException ex) {
            return ex;
        }
    }

    private static void assertMetadata(DbxException ex, int status, String requestId) {
        assertThat(ex.getResponseStatusCode()).isEqualTo(status);
        assertThat(ex.getRequestId()).isEqualTo(requestId);
        assertThat(ex.getResponseHeaders().get("x-test")).containsExactly("private-first", "second").inOrder();
        assertThat(ex.getResponseHeaders().containsKey("X-TEST")).isTrue();
        assertThat(ex.toString()).doesNotContain("private-first");
        assertThat(ex.toString()).doesNotContain("X-Test");
        expectThrows(UnsupportedOperationException.class, () -> ex.getResponseHeaders().clear());
        expectThrows(UnsupportedOperationException.class, () -> ex.getResponseHeaders().get("X-Test").add("third"));
        expectThrows(UnsupportedOperationException.class, () -> ex.getResponseHeaders().entrySet().iterator().next().setValue(Collections.emptyList()));
    }

    @DataProvider
    public Object[][] errors() {
        List<Object[]> cases = new ArrayList<Object[]>();
        for (String style : Arrays.asList("rpc", "upload", "download")) {
            for (int status : new int[]{400, 401, 403, 409, 418, 422, 429, 500, 503}) {
                Class<?> type;
                switch (status) {
                    case 400: type = BadRequestException.class; break;
                    case 401: type = InvalidAccessTokenException.class; break;
                    case 403: type = AccessErrorException.class; break;
                    case 409: type = style.equals("rpc") ? GetMetadataErrorException.class
                        : style.equals("upload") ? UploadErrorException.class : DownloadErrorException.class; break;
                    case 422: type = PathRootErrorException.class; break;
                    case 429: type = RateLimitException.class; break;
                    case 500: type = ServerException.class; break;
                    case 503: type = RetryException.class; break;
                    default: type = BadResponseCodeException.class;
                }
                cases.add(new Object[]{style, status, type});
            }
        }
        return cases.toArray(new Object[0][]);
    }

    @Test(dataProvider = "errors")
    public void httpErrors(String style, int status, Class<?> type) throws Exception {
        String body = status == 401 ? "{\"error\":{\".tag\":\"invalid_access_token\"}}"
            : status == 409 ? (style.equals("upload") ? "{\"error\":{\".tag\":\"payload_too_large\"}}"
                : "{\"error\":{\".tag\":\"path\",\"path\":{\".tag\":\"not_found\"}}}") : OTHER;
        Response response = new Response(status, body, "request-id");
        HttpRequestor requestor = requestor(response.response);
        DbxException ex = invoke(client(requestor, 0), style);
        assertThat(ex.getClass()).isEqualTo(type);
        assertThat(response.closed).isTrue();
        assertThat(response.closeCount).isEqualTo(1);
        assertMetadata(ex, status, "request-id");
        if (ex instanceof RetryException) {
            assertThat(((RetryException) ex).getBackoffMillis()).isEqualTo(0);
        }
    }

    @Test
    public void retryExhaustionUsesFinalResponse() throws Exception {
        Response first = new Response(503, "", "first");
        Response last = new Response(503, "", "last");
        HttpRequestor requestor = requestor(first.response, last.response);
        DbxException ex = invoke(client(requestor, 1), "rpc");
        assertThat(ex.getClass()).isEqualTo(RetryException.class);
        assertMetadata(ex, 503, "last");
        assertThat(first.closed).isTrue();
        assertThat(last.closed).isTrue();
        assertThat(first.closeCount).isEqualTo(1);
        assertThat(last.closeCount).isEqualTo(1);
        verify(requestor, times(2)).startPost(anyString(), any());
    }

    @Test
    public void noResponseAndLegacyConstructors() throws Exception {
        IOException cause = new IOException("offline");
        for (DbxException ex : Arrays.asList(new DbxException("message"), new DbxException("id", "message"),
                new DbxException("message", cause), new DbxException("id", "message", cause),
                new DbxWrappedException(null, "id", null).withResponseMetadata(new DbxException("message")))) {
            assertThat(ex.getResponseStatusCode()).isNull();
            assertThat(ex.getResponseHeaders()).isEmpty();
        }
        HttpRequestor requestor = mock(HttpRequestor.class);
        when(requestor.startPost(anyString(), any())).thenThrow(cause);
        when(requestor.startPostInStreamingMode(anyString(), any())).thenThrow(cause);
        for (String style : Arrays.asList("rpc", "upload", "download")) {
            DbxException ex = invoke(client(requestor, 0), style);
            assertThat(ex.getClass()).isEqualTo(NetworkIOException.class);
            assertThat(ex.getCause()).isSameInstanceAs(cause);
            assertThat(ex.getRequestId()).isNull();
            assertThat(ex.getResponseStatusCode()).isNull();
            assertThat(ex.getResponseHeaders()).isEmpty();
        }
    }

    @Test
    public void responseWithoutHeaders() throws Exception {
        HttpRequestor.Response response = new HttpRequestor.Response(400, new ByteArrayInputStream(new byte[0]), Collections.emptyMap());
        DbxException ex = invoke(client(requestor(response), 0), "rpc");
        assertThat(ex.getRequestId()).isNull();
        assertThat(ex.getResponseStatusCode()).isEqualTo(400);
        assertThat(ex.getResponseHeaders()).isEmpty();
    }

    @Test
    public void malformedErrorsPreserveParsingFailure() throws Exception {
        for (String style : Arrays.asList("rpc", "upload", "download")) {
            for (int status : new int[]{401, 403, 409, 422}) {
                Response response = new Response(status, "not-json", "malformed");
                DbxException ex = invoke(client(requestor(response.response), 0), style);
                assertThat(ex.getClass()).isEqualTo(BadResponseException.class);
                assertThat(ex.getCause()).isInstanceOf(com.fasterxml.jackson.core.JsonProcessingException.class);
                assertMetadata(ex, status, "malformed");
                assertThat(response.closed).isTrue();
                assertThat(response.closeCount).isEqualTo(1);
            }
        }
    }


    @Test
    public void responseReadFailureRetainsCauseAndMetadata() throws Exception {
        IOException cause = new IOException("read failed");
        for (String style : Arrays.asList("rpc", "upload", "download")) {
            Response response = new Response(400, "", "read-failure");
            HttpRequestor.Response failing = new HttpRequestor.Response(400, new java.io.InputStream() {
                @Override
                public int read() throws IOException {
                    throw cause;
                }

                @Override
                public void close() {
                    response.close();
                }
            }, response.response.getHeaders());
            DbxException ex = invoke(client(requestor(failing), 0), style);
            assertThat(ex.getClass()).isEqualTo(NetworkIOException.class);
            assertThat(ex.getCause()).isSameInstanceAs(cause);
            assertMetadata(ex, 400, null); // NetworkIOException historically has no request ID.
            assertThat(ex.getResponseHeaders().get("X-Dropbox-Request-Id")).containsExactly("read-failure");
            assertThat(response.closed).isTrue();
        }
    }

    @Test
    public void missingDownloadResultDoesNotExposeHeaders() throws Exception {
        Response response = new Response(200, "", "missing-result");
        DbxException ex = invoke(client(requestor(response.response), 0), "download");
        assertThat(ex.getClass()).isEqualTo(BadResponseException.class);
        assertMetadata(ex, 200, "missing-result");
        assertThat(response.closed).isTrue();
    }

    @Test
    public void sharedResponseHandlerRetainsMetadata() throws Exception {
        Response response = new Response(400, "", "handler");
        DbxException original = new DbxException("original-id", "original-message");
        DbxException ex = expectThrows(DbxException.class, () -> DbxRequestUtil.finishResponse(response.response,
            new DbxRequestUtil.ResponseHandler<Object>() {
                @Override
                public Object handle(HttpRequestor.Response ignored) throws DbxException {
                    throw original;
                }
            }));
        assertThat(ex).isSameInstanceAs(original);
        assertMetadata(ex, 400, "original-id");
        assertThat(ex.getMessage()).isEqualTo("original-message");
        assertThat(response.closed).isTrue();
    }


    @Test
    public void differentlyCasedHeaderNamesPreserveAllValues() throws Exception {
        List<String> first = new ArrayList<String>(Arrays.asList("private-first", "second"));
        List<String> second = new ArrayList<String>(Arrays.asList("third", "fourth"));
        Map<String, List<String>> headers = new LinkedHashMap<String, List<String>>();
        headers.put("X-Test", first);
        headers.put("x-test", second);
        Response body = new Response(400, "", "unused");
        HttpRequestor.Response response = new HttpRequestor.Response(400, body, headers);
        first.clear();
        second.clear();
        headers.clear();

        DbxException ex = invoke(client(requestor(response), 0), "rpc");
        assertThat(body.closed).isTrue();
        assertThat(ex.getResponseHeaders()).hasSize(1);
        assertThat(ex.getResponseHeaders().get("X-TEST"))
            .containsExactly("third", "fourth", "private-first", "second").inOrder();
        expectThrows(UnsupportedOperationException.class, () -> ex.getResponseHeaders().get("x-test").set(0, "changed"));
        expectThrows(UnsupportedOperationException.class, () -> ex.getResponseHeaders().remove("X-Test"));
        assertThat(ex.toString()).doesNotContain("private-first");
    }

    private static HttpRequestor.Response downloadResponse(int status, InputStream body, Response source) {
        Map<String, List<String>> headers = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        headers.putAll(source.response.getHeaders());
        headers.put("Dropbox-API-Result", Collections.singletonList(FILE_METADATA));
        headers.put("Content-Type", Collections.singletonList("application/octet-stream"));
        return new HttpRequestor.Response(status, body, headers);
    }

    @DataProvider
    public Object[][] downloads() {
        return new Object[][]{{200, false}, {200, true}, {206, false}, {206, true}};
    }

    @Test(dataProvider = "downloads")
    public void downloadBodyReadFailureRetainsMetadata(int status, boolean progress) throws Exception {
        IOException cause = new IOException("connection reset");
        Response source = new Response(status, "", "download-read");
        InputStream body = new InputStream() {
            private boolean first = true;

            @Override
            public int read(byte[] buffer, int offset, int length) throws IOException {
                if (!first) throw cause;
                first = false;
                buffer[offset] = 'x';
                return 1;
            }

            @Override
            public int read() throws IOException {
                throw cause;
            }

            @Override
            public void close() {
                source.close();
            }
        };
        HttpRequestor requestor = requestor(downloadResponse(status, body, source));
        DbxDownloader<?> downloader = client(requestor, 1).files().download("/x.txt");
        assertThat(source.closed).isFalse();
        assertThat(downloader.getContentType()).isEqualTo("application/octet-stream");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        long[] reported = {0};
        NetworkIOException ex = expectThrows(NetworkIOException.class, () -> {
            if (progress) {
                downloader.download(out, bytes -> reported[0] = bytes);
            } else {
                downloader.download(out);
            }
        });
        assertThat(out.toByteArray()).isEqualTo(new byte[]{'x'});
        assertThat(reported[0]).isEqualTo(progress ? 1L : 0L);
        assertMetadata(ex, status, null);
        assertThat(ex.getResponseHeaders().get("X-Dropbox-Request-Id")).containsExactly("download-read");
        assertThat(ex.getCause()).isInstanceOf(com.dropbox.core.util.IOUtil.ReadException.class);
        assertThat(ex.getCause().getCause()).isSameInstanceAs(cause);
        assertThat(source.closed).isTrue();
        downloader.close();
        assertThat(source.closeCount).isEqualTo(1);
        verify(requestor, times(1)).startPost(anyString(), any());
    }

    @Test(dataProvider = "downloads")
    public void successfulDownloadKeepsBodyOpenUntilConsumed(int status, boolean progress) throws Exception {
        Response source = new Response(status, "content", "download-success");
        HttpRequestor requestor = requestor(downloadResponse(status, source, source));
        DbxDownloader<?> downloader = client(requestor, 0).files().download("/x.txt");
        assertThat(source.closed).isFalse();
        assertThat(downloader.getInputStream()).isSameInstanceAs(source);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        if (progress) {
            downloader.download(out, bytes -> { });
        } else {
            downloader.download(out);
        }
        assertThat(out.toString("UTF-8")).isEqualTo("content");
        assertThat(source.closed).isTrue();
        downloader.close();
        assertThat(source.closeCount).isEqualTo(1);
        verify(requestor, times(1)).startPost(anyString(), any());
    }

    @Test
    public void malformedDownloadResultClosesBody() throws Exception {
        Response source = new Response(200, "content", "malformed-result");
        Map<String, List<String>> headers = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        headers.putAll(source.response.getHeaders());
        headers.put("Dropbox-API-Result", Collections.singletonList("not-json"));
        HttpRequestor.Response response = new HttpRequestor.Response(200, source, headers);
        DbxException ex = invoke(client(requestor(response), 0), "download");
        assertThat(ex.getClass()).isEqualTo(BadResponseException.class);
        assertMetadata(ex, 200, "malformed-result");
        assertThat(source.closed).isTrue();
    }

    @Test
    public void downloadWriteFailuresRemainLocalIoExceptions() throws Exception {
        IOException cause = new IOException("disk full");
        Response source = new Response(200, "content", "download-write");
        DbxDownloader<?> downloader = client(requestor(downloadResponse(200, source, source)), 0)
            .files().download("/x.txt");
        IOException ex = expectThrows(IOException.class, () -> downloader.download(new OutputStream() {
            @Override
            public void write(int value) throws IOException {
                throw cause;
            }
        }));
        assertThat(ex).isSameInstanceAs(cause);
        assertThat(source.closed).isTrue();
    }

    @Test
    public void legacyDownloadersHaveNoHttpMetadata() throws Exception {
        for (boolean contentType : new boolean[]{false, true}) {
            InputStream body = new InputStream() {
                @Override
                public int read() throws IOException {
                    throw new IOException("read failed");
                }
            };
            DbxDownloader<?> downloader = contentType ? new DbxDownloader<Object>(null, body, "text/plain")
                : new DbxDownloader<Object>(null, body);
            NetworkIOException ex = expectThrows(NetworkIOException.class,
                () -> downloader.download(new ByteArrayOutputStream()));
            assertThat(ex.getRequestId()).isNull();
            assertThat(ex.getResponseStatusCode()).isNull();
            assertThat(ex.getResponseHeaders()).isEmpty();
        }
    }


    @Test
    public void duplicateHeaderNamesPreserveRequestIdAndRetryPrecedence() throws Exception {
        Map<String, List<String>> headers = new LinkedHashMap<String, List<String>>();
        headers.put("X-Dropbox-Request-Id", Collections.singletonList("first-id"));
        headers.put("x-dropbox-request-id", Collections.singletonList("last-id"));
        headers.put("Retry-After", Collections.singletonList("1"));
        headers.put("retry-after", Collections.singletonList("2"));
        HttpRequestor.Response response = new HttpRequestor.Response(429,
            new ByteArrayInputStream(new byte[0]), headers);
        DbxException ex = invoke(client(requestor(response), 0), "rpc");
        assertThat(ex.getRequestId()).isEqualTo("last-id");
        assertThat(((RateLimitException) ex).getBackoffMillis()).isEqualTo(2000);
        assertThat(ex.getResponseHeaders().get("X-Dropbox-Request-Id"))
            .containsExactly("last-id", "first-id").inOrder();
        assertThat(ex.getResponseHeaders().get("Retry-After")).containsExactly("2", "1").inOrder();
    }


    @Test
    public void structuredErrorSurvivesCleanupIOException() throws Exception {
        for (String style : Arrays.asList("rpc", "upload", "download")) {
            String body = style.equals("upload") ? "{\"error\":{\".tag\":\"payload_too_large\"}}"
                : "{\"error\":{\".tag\":\"path\",\"path\":{\".tag\":\"not_found\"}}}";
            Response source = new Response(409, body, "cleanup");
            InputStream stream = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8)) {
                @Override
                public void close() throws IOException {
                    source.close();
                    throw new IOException("cleanup failed");
                }
            };
            HttpRequestor.Response response = new HttpRequestor.Response(409, stream, source.response.getHeaders());
            DbxException ex = invoke(client(requestor(response), 0), style);
            assertThat(ex).isInstanceOf(DbxApiException.class);
            assertThat(source.closeCount).isEqualTo(1);
            assertMetadata(ex, 409, "cleanup");
        }
    }


    @Test
    public void callbackFailureIsNotReplacedByCleanup() throws Exception {
        Thread caller = Thread.currentThread();
        DbxGlobalCallbackFactory previous = DbxRequestUtil.sharedCallbackFactory;
        try {
            for (String style : Arrays.asList("rpc", "upload", "download")) {
                for (int status : new int[]{400, 409}) {
                    String body = style.equals("upload") ? "{\"error\":{\".tag\":\"payload_too_large\"}}"
                        : "{\"error\":{\".tag\":\"path\",\"path\":{\".tag\":\"not_found\"}}}";
                    Response source = new Response(status, body, "callback");
                    RuntimeException callbackFailure = new IllegalStateException("callback failed");
                    RuntimeException cleanupFailure = new IllegalArgumentException("cleanup failed");
                    DbxRequestUtil.sharedCallbackFactory = new DbxGlobalCallbackFactory() {
                        @Override
                        public <T> DbxRouteErrorCallback<T> createRouteErrorCallback(String userId, T value) {
                            if (Thread.currentThread() != caller) return null;
                            return new DbxRouteErrorCallback<T>() {
                                @Override
                                public void run() {
                                    assertThat(getRouteError()).isSameInstanceAs(value);
                                    throw callbackFailure;
                                }
                            };
                        }

                        @Override
                        public DbxNetworkErrorCallback createNetworkErrorCallback(String userId) {
                            return new DbxNetworkErrorCallback() {
                                @Override
                                public void onNetworkError(DbxException ex) {
                                    if (Thread.currentThread() != caller) return;
                                    assertMetadata(ex, status, "callback");
                                    throw callbackFailure;
                                }
                            };
                        }
                    };
                    InputStream stream = new ByteArrayInputStream(body.getBytes(StandardCharsets.UTF_8)) {
                        @Override
                        public void close() {
                            source.close();
                            throw cleanupFailure;
                        }
                    };
                    HttpRequestor.Response response = new HttpRequestor.Response(status, stream, source.response.getHeaders());
                    RuntimeException actual = expectThrows(RuntimeException.class,
                        () -> invoke(client(requestor(response), 0), style));
                    assertThat(actual).isSameInstanceAs(callbackFailure);
                    assertThat(actual.getSuppressed()).asList().containsExactly(cleanupFailure);
                    assertThat(source.closeCount).isEqualTo(1);
                }
            }
        } finally {
            DbxRequestUtil.sharedCallbackFactory = previous;
        }
    }


    @Test
    public void progressFailureSurvivesCleanupAndClosesOnlyOnce() throws Exception {
        RuntimeException listenerFailure = new IllegalStateException("progress failed");
        RuntimeException cleanupFailure = new IllegalArgumentException("close failed");
        Response source = new Response(200, "content", "progress");
        InputStream stream = new ByteArrayInputStream("content".getBytes(StandardCharsets.UTF_8)) {
            @Override
            public void close() {
                source.close();
                throw cleanupFailure;
            }
        };
        DbxDownloader<?> downloader = client(requestor(downloadResponse(200, stream, source)), 0)
            .files().download("/x.txt");
        RuntimeException actual = expectThrows(RuntimeException.class,
            () -> downloader.download(new ByteArrayOutputStream(), bytes -> { throw listenerFailure; }));
        assertThat(actual).isSameInstanceAs(listenerFailure);
        assertThat(actual.getSuppressed()).asList().containsExactly(cleanupFailure);
        downloader.close();
        assertThat(source.closeCount).isEqualTo(1);
    }

    @Test
    public void getHandlerFailureSurvivesCleanupIOException() throws Exception {
        IOException cleanupFailure = new IOException("close failed");
        Response source = new Response(400, "", "get");
        InputStream stream = new ByteArrayInputStream(new byte[0]) {
            @Override
            public void close() throws IOException {
                source.close();
                throw cleanupFailure;
            }
        };
        HttpRequestor.Response response = new HttpRequestor.Response(400, stream, source.response.getHeaders());
        HttpRequestor requestor = mock(HttpRequestor.class);
        when(requestor.doGet(anyString(), any())).thenReturn(response);
        DbxRequestConfig config = DbxRequestConfig.newBuilder("get-test").withHttpRequestor(requestor).build();
        DbxException original = new BadRequestException("original-id", "original-message");
        DbxException actual = expectThrows(DbxException.class, () -> DbxRequestUtil.doGet(config, "token", "sdk",
            "example.com", "test", null, null, new DbxRequestUtil.ResponseHandler<Object>() {
                @Override
                public Object handle(HttpRequestor.Response ignored) throws DbxException {
                    throw original;
                }
            }));
        assertThat(actual).isSameInstanceAs(original);
        assertThat(actual.getSuppressed()).asList().containsExactly(cleanupFailure);
        assertThat(actual.getMessage()).isEqualTo("original-message");
        assertMetadata(actual, 400, "original-id");
        assertThat(source.closeCount).isEqualTo(1);
    }

    @Test
    public void emptyLaterHeaderGroupPreservesLegacySelection() throws Exception {
        Map<String, List<String>> headers = new LinkedHashMap<String, List<String>>();
        headers.put("X-Dropbox-Request-Id", Collections.singletonList("earlier-id"));
        headers.put("x-dropbox-request-id", Collections.emptyList());
        headers.put("Retry-After", Collections.singletonList("5"));
        headers.put("retry-after", Collections.emptyList());
        HttpRequestor.Response response = new HttpRequestor.Response(429,
            new ByteArrayInputStream(new byte[0]), headers);
        DbxException ex = invoke(client(requestor(response), 0), "rpc");
        assertThat(ex.getClass()).isEqualTo(BadResponseException.class);
        assertThat(ex.getMessage()).isEqualTo("missing HTTP header \"Retry-After\"");
        assertThat(ex.getRequestId()).isNull();
        assertThat(ex.getResponseStatusCode()).isEqualTo(429);
    }

    @Test
    public void successfulRpcAndUploadCloseOnlyOnce() throws Exception {
        for (String style : Arrays.asList("rpc", "upload")) {
            String body = style.equals("rpc") ? "{\".tag\":\"file\"," + FILE_METADATA.substring(1) : FILE_METADATA;
            Response source = new Response(200, body, "success");
            DbxClientV2 client = client(requestor(source.response), 0);
            if (style.equals("rpc")) {
                client.files().getMetadata("/x.txt");
            } else {
                client.files().upload("/x.txt").finish();
            }
            assertThat(source.closeCount).isEqualTo(1);
        }
    }


    @Test
    public void rpcPreservesInputStreamSerializerOverride() throws Exception {
        Response source = new Response(200, "custom format", "serializer");
        DbxRequestConfig config = DbxRequestConfig.newBuilder("serializer-test")
            .withHttpRequestor(requestor(source.response)).build();
        com.dropbox.core.v2.DbxRawClientV2 raw = mock(com.dropbox.core.v2.DbxRawClientV2.class,
            withSettings().useConstructor(config, DbxHost.DEFAULT, null, null).defaultAnswer(CALLS_REAL_METHODS));
        com.dropbox.core.stone.StoneSerializer<String> serializer = new com.dropbox.core.stone.StoneSerializer<String>() {
            @Override
            public String deserialize(InputStream body) throws IOException {
                assertThat(source.closed).isFalse();
                return "custom result";
            }

            @Override
            public String deserialize(com.fasterxml.jackson.core.JsonParser parser) {
                throw new AssertionError("InputStream override was bypassed");
            }

            @Override
            public void serialize(String value, com.fasterxml.jackson.core.JsonGenerator generator) {
                throw new UnsupportedOperationException();
            }
        };
        String result = raw.rpcStyle("example.com", "test", null, true,
            com.dropbox.core.stone.StoneSerializers.void_(), serializer,
            com.dropbox.core.stone.StoneSerializers.void_());
        assertThat(result).isEqualTo("custom result");
        assertThat(source.closeCount).isEqualTo(1);
    }


    @Test
    public void oauthErrorClosesOnceAndRetainsMetadata() throws Exception {
        Response source = new Response(400, "{\"error\":\"invalid_grant\",\"error_description\":\"revoked\"}", "oauth");
        DbxRequestConfig config = DbxRequestConfig.newBuilder("oauth-test")
            .withHttpRequestor(requestor(source.response)).build();
        com.dropbox.core.oauth.DbxCredential credential = new com.dropbox.core.oauth.DbxCredential(
            "token", 0L, "refresh-token", "app-key", "app-secret");
        com.dropbox.core.oauth.DbxOAuthException ex = expectThrows(com.dropbox.core.oauth.DbxOAuthException.class,
            () -> credential.refresh(config));
        assertThat(ex.getDbxOAuthError().getError()).isEqualTo("invalid_grant");
        assertThat(ex.getCause()).isNull();
        assertMetadata(ex, 400, "oauth");
        assertThat(source.closeCount).isEqualTo(1);
    }

    @Test
    public void directDownloadStreamPreservesOrdinaryIOException() throws Exception {
        IOException original = new IOException("read failed");
        Response source = new Response(200, "", "direct");
        InputStream stream = new InputStream() {
            @Override
            public int read() throws IOException {
                throw original;
            }

            @Override
            public void close() {
                source.close();
            }
        };
        DbxDownloader<?> downloader = client(requestor(downloadResponse(200, stream, source)), 0)
            .files().download("/x.txt");
        IOException actual = expectThrows(IOException.class, () -> downloader.getInputStream().read());
        assertThat(actual).isSameInstanceAs(original);
        assertThat(source.closeCount).isEqualTo(0);
        downloader.close();
        assertThat(source.closeCount).isEqualTo(1);
    }

    @Test
    public void cleanupFailureDoesNotChangeRetryPolicy() throws Exception {
        RuntimeException cleanupFailure = new IllegalStateException("close failed");
        Response first = new Response(503, "", "retry-first") {
            @Override
            public void close() {
                super.close();
                throw cleanupFailure;
            }
        };
        Response last = new Response(503, "", "retry-last") {
            @Override
            public void close() {
                super.close();
                throw cleanupFailure;
            }
        };
        HttpRequestor requestor = requestor(first.response, last.response);
        DbxException ex = invoke(client(requestor, 1), "rpc");
        assertThat(ex.getClass()).isEqualTo(RetryException.class);
        assertMetadata(ex, 503, "retry-last");
        assertThat(ex.getSuppressed()).asList().containsExactly(cleanupFailure);
        assertThat(first.closeCount).isEqualTo(1);
        assertThat(last.closeCount).isEqualTo(1);
        verify(requestor, times(2)).startPost(anyString(), any());
    }
}
