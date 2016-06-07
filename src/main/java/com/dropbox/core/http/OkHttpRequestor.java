package com.dropbox.core.http;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.internal.Util;

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
 * v2</a>.  You can only use this if your project includes the OkHttp v2 library.
 *
 * <p> To use OkHttp v3, see {@link OkHttp3Requestor}.
 *
 * <p> To use this, pass {@link #INSTANCE} to the {@link com.dropbox.core.DbxRequestConfig} constructor.
 *
 * @see OkHttp3Requestor
 */
public class OkHttpRequestor extends HttpRequestor {
    /**
     * A thread-safe instance of {@code OkHttpRequestor} that connects directly
     * (as opposed to using a proxy).
     */
    public static final OkHttpRequestor INSTANCE = new OkHttpRequestor(defaultOkHttpClient());

    private final OkHttpClient client;

    private static OkHttpClient defaultOkHttpClient() {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        client.setReadTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        client.setWriteTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
        // enables certificate pinning
        client.setSslSocketFactory(SSLConfig.getSSLSocketFactory());
        return client;
    }

    /**
     * Creates a new instance of this requestor that uses {@code client} for its requests.
     *
     * <p> The {@code OkHttpClient} will be cloned to prevent further modification.
     *
     * <p> NOTE: This constructor will not enable certificate pinning on the client. If you want
     * certificate pinning, use the default instance, {@link #INSTANCE}, or clone the default client
     * and modify it accordingly:
     *
     * <pre>
     *     OkHttpClient client = OkHttpRequestor.INSTANCE.getClient(); // returns a clone
     *     client.setReadTimeout(2, TimeUnit.MINUTES);
     *     // ... other modifications
     *     HttpRequestor requestor = new OkHttpRequestor(client);
     * </pre>
     *
     * @param client {@code OkHttpClient} to use for requests (will be cloned), never {@code null}
     */
    public OkHttpRequestor(OkHttpClient client) {
        if (client == null) throw new NullPointerException("client");
        this.client = client.clone();
    }

    /**
     * Returns a clone of the underlying {@code OkHttpClient} used to make requests.
     *
     * If you want to modify the client for a particular request, create a new instance of this
     * requestor with the modified client.
     *
     * @return clone of the underlying {@code OkHttpClient} used by this requestor.
     */
    public OkHttpClient getClient() {
        return client;
    }

    @Override
    public Response doGet(String url, Iterable<Header> headers) throws IOException {
        Request.Builder builder = new Request.Builder().get().url(url);
        toOkHttpHeaders(headers, builder);
        com.squareup.okhttp.Response response = client.newCall(builder.build()).execute();
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
    private static class BufferUploader extends HttpRequestor.Uploader {
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
            com.squareup.okhttp.Response response = call.execute();
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
