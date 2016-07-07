package com.dropbox.core.http;

import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.Util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okio.Buffer;
import okio.BufferedSink;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * {@link HttpRequestor} implementation that uses <a href="http://square.github.io/okhttp/">OkHttp
 * v3</a>.  You can only use this if your project includes the OkHttp v3 library.
 *
 * <p>
 * To use this, pass {@link #INSTANCE} to the {@link com.dropbox.core.DbxRequestConfig} constructor.
 * </p>
 */
public class OkHttp3Requestor extends HttpRequestor {
    /**
     * A thread-safe instance of {@code OkHttp3Requestor} that connects directly
     * (as opposed to using a proxy).
     */
    public static final OkHttp3Requestor INSTANCE = new OkHttp3Requestor(defaultOkHttpClient());

    private final OkHttpClient client;

    private static OkHttpClient defaultOkHttpClient() {
        return new OkHttpClient.Builder()
            .connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .writeTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            // enables certificate pinning
            .sslSocketFactory(SSLConfig.getSSLSocketFactory(), SSLConfig.getTrustManager())
            .build();
    }

    /**
     * Creates a new instance of this requestor that uses {@code client} for its requests.
     *
     * <p> NOTE: This constructor will not enable certificate pinning on the client. If you want
     * certificate pinning, use the default instance, {@link #INSTANCE}, or clone the default client
     * and modify it accordingly:
     *
     * <pre>
     *     OkHttpClient client = OkHttpRequestor.INSTANCE.getClient()
     *         .readTimeout(2, TimeUnit.MINUTES)
     *         // ... other modifications
     *         .build();
     *     HttpRequestor requestor = new OkHttpRequestor(client);
     * </pre>
     *
     * @param client {@code OkHttpClient} to use for requests, never {@code null}
     */
    public OkHttp3Requestor(OkHttpClient client) {
        if (client == null) throw new NullPointerException("client");
        this.client = client;
    }

    /**
     * Returns the underlying {@code OkHttpClient} used to make requests.
     *
     * If you want to modify the client for a particular request, create a new instance of this
     * requestor with the modified client.
     *
     * @return underlying {@code OkHttpClient} used by this requestor.
     */
    public OkHttpClient getClient() {
        return client;
    }

    /**
     * Called beforing building the request and executing it.
     *
     * <p> This method should be used by subclasses to make any changes or additions to the request
     * before it is issued.
     *
     * @param request Builder of request to be executed
     */
    protected void configureRequest(Request.Builder request) { }

    /**
     * Called before returning {@link Response} from a request.
     *
     * <p> This method should be used by subclasses to add any logging, analytics, or cleanup
     * necessary.
     *
     * <p> If the response body is consumed, it should be replaced.
     *
     * @param response OkHttp response
     *
     * @return OkHttp response
     */
    protected okhttp3.Response interceptResponse(okhttp3.Response response) {
        return response;
    }

    @Override
    public Response doGet(String url, Iterable<Header> headers) throws IOException {
        Request.Builder builder = new Request.Builder().get().url(url);
        toOkHttpHeaders(headers, builder);
        configureRequest(builder);
        okhttp3.Response response = client.newCall(builder.build()).execute();
        response = interceptResponse(response);
        Map<String, List<String>> responseHeaders = fromOkHttpHeaders(response.headers());
        return new Response(response.code(), response.body().byteStream(), responseHeaders);
    }

    @Override
    public HttpRequestor.Uploader startPost(String url, Iterable<Header> headers) throws IOException {
        return startUpload(url, headers, "POST");
    }

    @Override
    public HttpRequestor.Uploader startPut(String url, Iterable<Header> headers) throws IOException {
        return startUpload(url, headers, "PUT");
    }

    private BufferUploader startUpload(String url, Iterable<Header> headers, String method) {
        Buffer requestBuffer = new Buffer();
        RequestBody requestBody = new BufferRequestBody(requestBuffer, null);
        Request.Builder builder = new Request.Builder().method(method, requestBody).url(url);
        toOkHttpHeaders(headers, builder);
        configureRequest(builder);
        return new BufferUploader(client.newCall(builder.build()), requestBuffer);
    }

    private static void toOkHttpHeaders(Iterable<Header> headers, Request.Builder builder) {
        for (Header header : headers) {
            builder.addHeader(header.getKey(), header.getValue());
        }
    }

    private static Map<String, List<String>> fromOkHttpHeaders(Headers headers) {
        Map<String, List<String>> responseHeaders = new HashMap<String, List<String>>(headers.size());
        for (String name : headers.names()) {
            responseHeaders.put(name, headers.values(name));
        }
        return responseHeaders;
    }

    /**
     * Implementation of {@link com.dropbox.core.http.HttpRequestor.Uploader} that exposes
     * the {@link java.io.OutputStream} from an Okio {@link Buffer} that is connected to an OkHttp
     * {@link RequestBody}.  Calling {@link #finish()} will execute the request with OkHttp
     */
    private class BufferUploader extends HttpRequestor.Uploader {
        private final Call call;
        private final Buffer requestBuffer;

        public BufferUploader(Call call, Buffer requestBuffer) {
            super(requestBuffer.outputStream());
            this.call = call;
            this.requestBuffer = requestBuffer;
        }

        @Override
        public void close() {
            requestBuffer.clear();
        }

        @Override
        public void abort() {
            call.cancel();
        }

        @Override
        public Response finish() throws IOException {
            okhttp3.Response response = call.execute();
            response = interceptResponse(response);
            Map<String, List<String>> responseHeaders = fromOkHttpHeaders(response.headers());
            return new Response(response.code(), response.body().byteStream(), responseHeaders);
        }
    }

    /**
     * Implementation of {@link RequestBody} that uses a {@link Buffer}
     * for internal storage.
     */
    private static class BufferRequestBody extends RequestBody {
        private Buffer buffer;
        private /*@Nullable*/MediaType mediaType;

        public BufferRequestBody(final Buffer buffer, /*@Nullable*/MediaType mediaType) {
            this.buffer = buffer;
            this.mediaType = mediaType;
        }

        @Override
        public /*@Nullable*/MediaType contentType() {
            return mediaType;
        }

        @Override
        public long contentLength() {
            return buffer.size();
        }

        @Override
        public void writeTo(BufferedSink sink) throws IOException {
            try {
                sink.writeAll(buffer);
            } finally {
                Util.closeQuietly(buffer);
            }
        }
    }
}
