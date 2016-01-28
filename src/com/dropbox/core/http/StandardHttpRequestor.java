package com.dropbox.core.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.dropbox.core.util.IOUtil;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * {@link HttpRequestor} implementation that uses Java's standard library
 * {@link HttpsURLConnection}.  If you just want a connection with the
 * default settings, use the predefined {@link #Instance}.
 *
 * <p>
 * If you want to customize the way the connection is configured, create a
 * subclass that overrides {@link #configureConnection}.
 * </p>
 */
public class StandardHttpRequestor extends HttpRequestor
{
    private final Proxy proxy;

    /**
     * Creates an instance that uses a direct HTTP connection (as opposed to
     * using a proxy).
     */
    public StandardHttpRequestor()
    {
        this(Proxy.NO_PROXY);
    }

    /**
     * Creates an instance that connects through the given proxy.
     */
    public StandardHttpRequestor(Proxy proxy)
    {
        this.proxy = proxy;
    }

    /**
     * A thread-safe instance of {@code StandardHttpRequestor} that connects directly
     * (as opposed to using a proxy).
     */
    public static final StandardHttpRequestor Instance = new StandardHttpRequestor();

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
        HttpsURLConnection conn = (HttpsURLConnection) urlObject.openConnection(this.proxy);

        SSLConfig.apply(conn);
        conn.setConnectTimeout(DefaultTimeoutMillis);
        conn.setReadTimeout(DefaultTimeoutMillis);
        conn.setUseCaches(false);
        conn.setAllowUserInteraction(false);

        configureConnection(conn);

        for (Header header : headers) {
            conn.addRequestProperty(header.key, header.value);
        }

        return conn;
    }
}
