package com.dropbox.core.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.concurrent.TimeUnit;

/**
 * An interface that the Dropbox client library uses to make HTTP requests.
 * If you're fine with the standard Java {@link java.net.HttpURLConnection}
 * implementation, then just use {@link StandardHttpRequestor#INSTANCE}.
 */
public abstract class HttpRequestor
{
    /**
     * Default timeout, in milliseconds, for opening a connection to a network resource.
     *
     * A value of 0 indicates the timeout should be disabled.
     */
    public static final long DEFAULT_CONNECT_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(20);
    /**
     * Default timeout, in milliseconds, for receiving a response from a network resource.
     *
     * A value of 0 indicates the timeout should be disabled.
     */
    public static final long DEFAULT_READ_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(20);

    public abstract Response doGet(String url, Iterable<Header> headers) throws IOException;
    public abstract Uploader startPost(String url, Iterable<Header> headers) throws IOException;
    public abstract Uploader startPut(String url, Iterable<Header> headers) throws IOException;

    /**
     * A simple structure holding an HTTP header, which is key/value pair.
     * Used with {@link HttpRequestor}.
     */
    public static final class Header
    {
        public final String key;
        public final String value;

        public Header(String key, String value)
        {
            this.key = key;
            this.value = value;
        }
    }

    public static abstract class Uploader
    {
        private final OutputStream body;

        protected Uploader(OutputStream body) { this.body = body; }

        public OutputStream getBody() { return body; }
        public abstract void close();
        public abstract void abort();
        public abstract Response finish() throws IOException;
    }

    public static final class Response
    {
        /**
         * HTTP status response code.
         */
        public final int statusCode;
        /**
         * HTTP response body. Must be fully read before closing.
         */
        public final InputStream body;
        /**
         * Case-insensitive, unmodifiable mapping of header fields to their values.
         */
        public final Map<String, List<String>> headers;

        public Response(int statusCode, InputStream body, Map<String, ? extends List<String>> headers)
        {
            this.statusCode = statusCode;
            this.body = body;
            this.headers = asUnmodifiableCaseInsensitiveMap(headers);
        }

        private static final Map<String, List<String>> asUnmodifiableCaseInsensitiveMap(Map<String, ? extends List<String>> original) {
            Map<String, List<String>> insensitive = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
            for (Map.Entry<String, ? extends List<String>> entry : original.entrySet()) {
                // Java HttpURLConnection puts status line as the 'null' key, e.g.:
                //
                //    HTTP/1.1 409 bad_member/invalid_dropbox_id/...
                //
                if (entry.getKey() == null || entry.getKey().trim().length() == 0) {
                    continue;
                }
                insensitive.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
            }
            return Collections.unmodifiableMap(insensitive);
        }
    }
}
