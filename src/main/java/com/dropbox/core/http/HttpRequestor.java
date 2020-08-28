package com.dropbox.core.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import java.util.concurrent.TimeUnit;

import com.dropbox.core.util.IOUtil;

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
    // Careful about lowering this value. Large file uploads can result in slow responses from the
    // server.
    public static final long DEFAULT_READ_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(2);

    public abstract Response doGet(String url, Iterable<Header> headers) throws IOException;
    public abstract Uploader startPost(String url, Iterable<Header> headers) throws IOException;
    public Uploader startPostInStreamingMode(String url, Iterable<Header> headers) throws IOException {
        return startPost(url, headers);
    }
    public abstract Uploader startPut(String url, Iterable<Header> headers) throws IOException;

    /**
     * A simple structure holding an HTTP header, which is key/value pair.
     * Used with {@link HttpRequestor}.
     */
    public static final class Header {
        private final String key;
        private final String value;

        public Header(String key, String value) {
            this.key = key;
            this.value = value;
        }

        /**
         * Returns header name.
         *
         * @return header name
         */
        public String getKey() {
            return key;
        }

        /**
         * Returns header value.
         *
         * @return header value
         */
        public String getValue() {
            return value;
        }
    }

    public static abstract class Uploader {
        protected IOUtil.ProgressListener progressListener;

        public abstract OutputStream getBody();
        public abstract void close();
        public abstract void abort();
        public abstract Response finish() throws IOException;

        public void upload(File file) throws IOException {
            try {
                upload(new FileInputStream(file));
            } catch (IOUtil.ReadException ex) {
                throw ex.getCause();
            } catch (IOUtil.WriteException ex) {
                throw ex.getCause();
            }
        }

        public void upload(InputStream in, long limit) throws IOException {
            upload(IOUtil.limit(in, limit));
        }

        public void upload(InputStream in) throws IOException {
            OutputStream out = getBody();
            try {
                IOUtil.copyStreamToStream(in, out);
            } finally {
                out.close();
            }
        }

        public void upload(byte [] body) throws IOException {
            OutputStream out = getBody();
            try {
                out.write(body);
            } finally {
                out.close();
            }
        }

        public void setProgressListener(IOUtil.ProgressListener progressListener) {
            this.progressListener = progressListener;
        }
    }

    public static final class Response {
        private final int statusCode;
        private final InputStream body;
        private final Map<String, List<String>> headers;

        public Response(int statusCode, InputStream body, Map<String, ? extends List<String>> headers) {
            this.statusCode = statusCode;
            this.body = body;
            this.headers = asUnmodifiableCaseInsensitiveMap(headers);
        }

        /**
         * Returns HTTP status response code.
         *
         * @return HTTP status code
         */
        public int getStatusCode() {
            return statusCode;
        }

        /**
         * Returns an {@link InputStream} for reading the HTTP response body.
         *
         * <p> The returned stream <b>must</b> be fully read before closing.
         *
         * @return HTTP response body
         */
        public InputStream getBody() {
            return body;
        }

        /**
         * Returns a case-insensitive, unmodifiable mapping of header fields to their values.
         *
         * @return case-insensitive, unmodifiable headers
         */
        public Map<String, List<String>> getHeaders() {
            return headers;
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
