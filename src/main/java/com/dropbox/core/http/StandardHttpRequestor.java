package com.dropbox.core.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import com.dropbox.core.util.IOUtil;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * {@link HttpRequestor} implementation that uses Java's standard library
 * {@link HttpsURLConnection}.  If you just want a connection with the
 * default settings, use the predefined {@link #INSTANCE}.
 *
 * <p>
 * If you want to customize the way the connection is configured, create a
 * subclass that overrides {@link #configureConnection}.
 * </p>
 */
public class StandardHttpRequestor extends HttpRequestor
{
    /**
     * A thread-safe instance of {@code StandardHttpRequestor} that connects directly
     * (as opposed to using a proxy).
     */
    public static final StandardHttpRequestor INSTANCE = new StandardHttpRequestor(Config.DEFAULT_INSTANCE);

    private final Config config;

    /**
     * Creates an instance that connects through the given proxy.
     */
    public StandardHttpRequestor(Config config)
    {
        this.config = config;
    }

    private static Response toResponse(HttpsURLConnection conn)
        throws IOException
    {
        int responseCode = conn.getResponseCode();
        InputStream bodyStream;
        if (responseCode >= 400) {
            bodyStream = conn.getErrorStream();
        } else {
            bodyStream = conn.getInputStream();
        }
        return new Response(responseCode, bodyStream, conn.getHeaderFields());
    }

    @Override
    public Response doGet(String url, Iterable<Header> headers) throws IOException
    {
        HttpsURLConnection conn = prepRequest(url, headers);
        conn.setRequestMethod("GET");
        conn.connect();
        return toResponse(conn);
    }

    @Override
    public Uploader startPost(String url, Iterable<Header> headers) throws IOException
    {
        HttpsURLConnection conn = prepRequest(url, headers);
        conn.setRequestMethod("POST");
        return new Uploader(conn);
    }

    @Override
    public Uploader startPut(String url, Iterable<Header> headers) throws IOException
    {
        HttpsURLConnection conn = prepRequest(url, headers);
        conn.setRequestMethod("PUT");
        return new Uploader(conn);
    }

    /**
     * Can be overridden to configure the underlying {@link HttpsURLConnection} used to make
     * network requests.  If you override this method, you should probably call
     * {@code super.configureConnection(conn)} in your overridden method.
     */
    protected void configureConnection(HttpsURLConnection conn)
        throws IOException
    {
    }

    private static class Uploader extends HttpRequestor.Uploader
    {
        private /*@Nullable*/ HttpsURLConnection conn;

        public Uploader(HttpsURLConnection conn)
            throws IOException
        {
            super(getOutputStream(conn));
            conn.connect();
            this.conn = conn;
        }

        private static OutputStream getOutputStream(HttpsURLConnection conn)
            throws IOException
        {
            conn.setDoOutput(true);
            return conn.getOutputStream();
        }

        @Override
        public void abort()
        {
            if (conn == null) {
                throw new IllegalStateException("Can't abort().  Uploader already closed.");
            }
            // disconnecting is "harsh" in that it can close the underlying streams and socket. This
            // prevents connection re-use.
            conn.disconnect();
            conn = null;
        }

        @Override
        public void close()
        {
            if (conn == null) return;

            // close input and output streams to allow for connection re-use.
            if (conn.getDoOutput()) {
                try {
                    IOUtil.closeQuietly(conn.getOutputStream());
                } catch (IOException ex) {
                    // ignore
                }
            }

            // should not need to disconnect after closing the relevant streams
            conn = null;
        }

        @Override
        public Response finish() throws IOException
        {
            if (conn == null) {
                throw new IllegalStateException("Can't finish().  Uploader already closed.");
            }

            try {
                return toResponse(conn);
            } finally {
                conn = null;
            }
        }
    }

    private HttpsURLConnection prepRequest(String url, Iterable<Header> headers) throws IOException
    {
        URL urlObject = new URL(url);
        HttpsURLConnection conn = (HttpsURLConnection) urlObject.openConnection(config.getProxy());

        SSLConfig.apply(conn);
        conn.setConnectTimeout((int) config.getConnectTimeoutMillis());
        conn.setReadTimeout((int) config.getReadTimeoutMillis());
        conn.setUseCaches(false);
        conn.setAllowUserInteraction(false);

        configureConnection(conn);

        for (Header header : headers) {
            conn.addRequestProperty(header.getKey(), header.getValue());
        }

        return conn;
    }

    /**
     * Configuration for {@link StandardHttpRequestor} that determines
     * how network connections to the server are established.
     *
     * Use this class to configure timeouts and proxy settings.
     *
     * Some requests may require different connection settings than
     * others. Create multiple {@link StandardHttpRequestor} objects
     * with different configurations to handle these requests. For
     * example, calls to {@link
     * com.dropbox.core.v2.files.DbxUserFilesRequests#listFolderLongpoll(String,long)} should
     * use a {@code StandardHttpRequestor} with its read timeout (see
     * {@link Builder#withReadTimeout}) set longer than the longpoll
     * timeout.
     */
    public static final class Config {
        /**
         * {@link Config} with all its attributes set to their default
         * values.
         */
        public static final Config DEFAULT_INSTANCE = builder().build();

        private final Proxy proxy;
        private final long connectTimeoutMillis;
        private final long readTimeoutMillis;

        private Config(Proxy proxy,
                       long connectTimeoutMillis,
                       long readTimeoutMillis) {
            this.proxy = proxy;
            this.connectTimeoutMillis = connectTimeoutMillis;
            this.readTimeoutMillis = readTimeoutMillis;
        }

        /**
         * Returns the proxy configuration for network connections.
         *
         * @return proxy configuration to use for network connections.
         */
        public Proxy getProxy() {
            return proxy;
        }

        /**
         * Returns the timeout, in milliseconds, for opening a
         * connection to the servers.
         *
         * If the timeout is 0, then connect timeouts are disabled.
         *
         * @return timeout, in milliseconds, for opening connections
         * to the servers.
         */
        public long getConnectTimeoutMillis() {
            return connectTimeoutMillis;
        }

        /**
         * Returns the timeout, in milliseconds, for receiving a
         * response from the servers.
         *
         * If the timeout is 0, then read timeouts are disabled.
         *
         * @return timeout, in milliseconds, for receiving a response
         * from the server.
         */
        public long getReadTimeoutMillis() {
            return readTimeoutMillis;
        }

        /**
         * Returns a new builder for creating a copy of this
         * config. The builder is configured to use this config's
         * values as its default.
         *
         * @return builder for creating a copy of this config.
         */
        public Builder copy() {
            return new Builder(proxy, connectTimeoutMillis, readTimeoutMillis);
        }

        /**
         * Returns a new builder for creating a {@link Config}.
         *
         * @return builder for creating an instance of this class
         */
        public static Builder builder() {
            return new Builder();
        }

        /**
         * Builder for {@link Config}.
         */
        public static final class Builder {
            private Proxy proxy;
            private long connectTimeoutMillis;
            private long readTimeoutMillis;

            private Builder() {
                this(Proxy.NO_PROXY, DEFAULT_CONNECT_TIMEOUT_MILLIS, DEFAULT_READ_TIMEOUT_MILLIS);
            }

            private Builder(Proxy proxy, long connectTimeoutMillis, long readTimeoutMillis) {
                this.proxy = proxy;
                this.connectTimeoutMillis = connectTimeoutMillis;
                this.readTimeoutMillis = readTimeoutMillis;
            }

            /**
             * Set proxy configuration for network connections.
             *
             * @param proxy Proxy configuration
             *
             * @return this builder
             *
             * @throws NullPointerException if {@code proxy} is {@code null}
             */
            public Builder withProxy(Proxy proxy) {
                if (proxy == null) {
                    throw new NullPointerException("proxy");
                }
                this.proxy = proxy;
                return this;
            }

            /**
             * Disables timeouts for opening a connection to the
             * servers.
             *
             * @return this builder
             */
            public Builder withNoConnectTimeout() {
                return withConnectTimeout(0L, TimeUnit.MILLISECONDS);
            }

            /**
             * Set timeout for opening a connection to the servers.
             *
             * A timeout of 0 will disable any connnect timeouts.
             *
             * @param timeout time to wait for a network connection to open
             * @param unit unit of time
             *
             * @return this builder
             *
             * @throws IllegalArgumentException if {@code timeout} is negative
             * @throws NullPointerException if {@code unit} is {@code null}
             */
            public Builder withConnectTimeout(long timeout, TimeUnit unit) {
                this.connectTimeoutMillis = checkTimeoutMillis(timeout, unit);
                return this;
            }

            /**
             * Disables timeout for receiving a response from the servers.
             *
             * @return this builder
             */
            public Builder withNoReadTimeout() {
                return withReadTimeout(0L, TimeUnit.MILLISECONDS);
            }

            /**
             * Sets timeout for receiving a response from the servers.
             *
             * This timeout is not for receiving the entire server
             * response. A server that responds with bytes slowly will
             * not trigger the timeout, unless the specified amount of
             * time has passed between received bytes.
             *
             * A timeout of 0 will disable any read timeouts.
             *
             * @param timeout time to wait for a response from the server
             * @param unit unit of time
             *
             * @return this builder
             *
             * @throws IllegalArgumentException if {@code timeout} is negative
             * @throws NullPointerException if {@code unit} is {@code null}
             */
            public Builder withReadTimeout(long timeout, TimeUnit unit) {
                this.readTimeoutMillis = checkTimeoutMillis(timeout, unit);
                return this;
            }

            /**
             * Returns a {@link Config} with the values set by this builder.
             *
             * @return {@link Config} with this builder's values
             */
            public Config build() {
                return new Config(
                    proxy,
                    connectTimeoutMillis,
                    readTimeoutMillis
                );
            }

            private static long checkTimeoutMillis(long timeout, TimeUnit unit) {
                if (unit == null) {
                    throw new NullPointerException("unit");
                }
                if (timeout < 0) {
                    throw new IllegalArgumentException("timeout must be non-negative");
                }
                long millis = unit.toMillis(timeout);
                if (Integer.MAX_VALUE < millis) {
                    throw new IllegalArgumentException("timeout too large, must be less than: " + Integer.MAX_VALUE);
                }
                return millis;
            }
        }
    }
}
