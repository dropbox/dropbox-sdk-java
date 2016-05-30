package com.dropbox.core.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * {@link HttpRequestor} implementation that uses <a href="http://square.github.io/okhttp/">OkHttp</a>.
 * You can only use this if your project includes the OkHttp library.
 *
 * <p>
 * To use this, pass {@link #INSTANCE} to the {@link com.dropbox.core.DbxRequestConfig} constructor.
 * </p>
 */
public class OkHttp3Requestor extends HttpRequestor
{
    /**
     * A thread-safe instance of {@code OkHttpRequestor} that connects directly
     * (as opposed to using a proxy).
     */
    public static final OkHttp3Requestor INSTANCE = new OkHttp3Requestor(defaultOkHttpClient());

    private final OkHttpClient client;

    private static OkHttpClient defaultOkHttpClient()
    {
        OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(DEFAULT_CONNECT_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .writeTimeout(DEFAULT_READ_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS)
            .build();
        return client;
    }

    public OkHttp3Requestor(OkHttpClient client)
    {
        this.client = client;
    }

    @Override
    public Response doGet(String url, Iterable<Header> headers)
        throws IOException
    {
        Request.Builder builder = new Request.Builder().get().url(url);
        toOkHttpHeaders(headers, builder);
        okhttp3.Response response = client.newCall(builder.build()).execute();
        Map<String, List<String>> responseHeaders = fromOkHttpHeaders(response.headers());
        return new Response(response.code(), response.body().byteStream(), responseHeaders);
    }

    @Override
    public BufferUploader startPost(String url, Iterable<Header> headers)
        throws IOException
    {
        return startUpload(url, headers, "POST");
    }

    @Override
    public BufferUploader startPut(String url, Iterable<Header> headers)
        throws IOException
    {
        return startUpload(url, headers, "PUT");
    }

    private BufferUploader startUpload(String url, Iterable<Header> headers, String method)
    {
        Buffer requestBuffer = new Buffer();
        RequestBody requestBody = new BufferRequestBody(requestBuffer, null);
        Request.Builder builder = new Request.Builder().method(method, requestBody).url(url);
        toOkHttpHeaders(headers, builder);
        return new BufferUploader(client.newCall(builder.build()), requestBuffer);
    }

    private static void toOkHttpHeaders(Iterable<Header> headers, Request.Builder builder)
    {
        for (Header header : headers) {
            builder.addHeader(header.getKey(), header.getValue());
        }
    }

    private static Map<String, List<String>> fromOkHttpHeaders(Headers headers)
    {
        Map<String, List<String>> responseHeaders = new HashMap<String, List<String>>(headers.size());
        for (String name : headers.names()) {
            responseHeaders.put(name, headers.values(name));
        }
        return responseHeaders;
    }

    /**
     * Implementation of {@link Uploader} that exposes
     * the {@link java.io.OutputStream} from an Okio {@link Buffer} that is connected to an OkHttp
     * {@link RequestBody}.  Calling {@link #finish()} will execute the request with OkHttp
     */
    private static class BufferUploader extends Uploader
    {
        private final Call call;
        private final Buffer requestBuffer;

        public BufferUploader(Call call, Buffer requestBuffer)
        {
            super(requestBuffer.outputStream());
            this.call = call;
            this.requestBuffer = requestBuffer;
        }

        @Override
        public void close()
        {
            requestBuffer.clear();
        }

        @Override
        public void abort()
        {
            call.cancel();
        }

        @Override
        public Response finish()
            throws IOException
        {
            okhttp3.Response response = call.execute();
            Map<String, List<String>> responseHeaders = fromOkHttpHeaders(response.headers());
            return new Response(response.code(), response.body().byteStream(), responseHeaders);
        }
    }

    /**
     * Implementation of {@link RequestBody} that uses a {@link Buffer} for internal storage
     */
    private static class BufferRequestBody extends RequestBody
    {
        private Buffer buffer;
        private /*@Nullable*/MediaType mediaType;

        private BufferRequestBody(final Buffer buffer, /*@Nullable*/MediaType mediaType)
        {
            this.buffer = buffer;
            this.mediaType = mediaType;
        }

        @Override
        public /*@Nullable*/MediaType contentType()
        {
            return mediaType;
        }

        @Override
        public long contentLength()
        {
            return buffer.size();
        }

        @Override
        public void writeTo(BufferedSink sink)
            throws IOException
        {
            try {
                sink.writeAll(buffer);
            } finally {
                Util.closeQuietly(buffer);
            }
        }
    }
}
