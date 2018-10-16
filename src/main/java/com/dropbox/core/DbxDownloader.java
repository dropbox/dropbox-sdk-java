package com.dropbox.core;

import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.ProgressOutputStream;

import java.io.Closeable;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Class for handling download requests.
 *
 * This class provides methods for downloading a request body and reading the server response.
 *
 * Example usage:
 *
 * <pre><code>
 *    FileOutputStream out = new FileOutputStream("test.txt");
 *    try {
 *        response = downloader.download(out);
 *    } finally {
 *        out.close();
 *    }
 *</code></pre>
 *
 * Example using {@link #getInputStream}:
 *
 * <pre><code>
 *    FileOutputStream out = new FileOutputStream("test.txt");
 *    response = downloader.getResult();
 *    try {
 *        InputStream in = downloader.getInputStream();
 *        // read from in, write to out
 *    } finally {
 *        downloader.close();
 *    }
 *</code></pre>
 */
public class DbxDownloader<R> implements Closeable {
    private final R result;
    private final InputStream body;
    private final String contentType;

    private boolean closed;

    public DbxDownloader(R result, InputStream body, String contentType) {
        this.result = result;
        this.body = body;
        this.contentType = contentType;

        this.closed = false;
    }

    public DbxDownloader(R result, InputStream body) {
        this(result, body, null);
    }

    /**
     * Returns the server response.
     *
     * Returns the response from the server that is separate from the response body (data to be
     * downloaded).
     *
     * @return Response from server
     */
    public R getResult() {
        return result;
    }

    /**
     * Returns the value of the content-type header field.
     *
     * @return the content type, or null if not known.
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Returns the {@link InputStream} containing the response body bytes. Remember to call {@link
     * #close} after reading the stream to properly free up resources.
     *
     * @return Response body input stream.
     *
     * @see #download(OutputStream)
     *
     * @throws IllegalStateException if this downloader has already been closed (see {@link #close})
     */
    public InputStream getInputStream() {
        assertOpen();
        return body;
    }

    /**
     * Downloads the response body to the given {@link OutputStream} and returns the server
     * response.
     *
     * This method manages closing this downloader's resources, so no further calls to {@link
     * #close} are necessary. The underlying {@code InputStream} returned by {@link #getInputStream}
     * will be closed by this method.
     *
     * This method is the equivalent of
     *
     * <pre><code>
     *    try {
     *        InputStream in = downloader.getInputStream();
     *        // read from in, write to out
     *        return downloader.getResult();
     *    } finally {
     *        downloader.close();
     *    }
     * </code></pre>
     *
     * @param out {@code OutputStream} to write response body to
     *
     * @return Response from server
     *
     * @throws DbxException if an error occurs reading the response or response body
     * @throws IOException if an error occurs writing the response body to the output stream.
     * @throws IllegalStateException if this downloader has already been closed (see {@link #close})
     */
    public R download(OutputStream out) throws DbxException,  IOException {
        try {
            IOUtil.copyStreamToStream(getInputStream(), out);
        } catch (IOUtil.WriteException ex) {
            // write exceptions should be IOException
            throw ex.getCause();
        } catch (IOException ex) {
            // everything else is a Network I/O problem
            throw new NetworkIOException(ex);
        } finally {
            close();
        }

        return result;
    }

    /**
     * This method is the same as {@link #download(OutputStream)} except for allowing to track
     * download progress.
     *
     * @param out {@code OutputStream} to write response body to
     * @param progressListener {@code IOUtil.ProgressListener} to track the download progress.
     * @return Response from server
     * @throws DbxException if an error occurs reading the response or response body.
     * @throws IOException if an error occurs writing the response body to the output stream.
     */
    public R download(OutputStream out, IOUtil.ProgressListener progressListener)
            throws DbxException,  IOException {
        return download(new ProgressOutputStream(out, progressListener));
    }

    /**
     * Closes this downloader and releases its underlying resources.
     *
     * After calling this method, calls to {@link getInputStream} will fail.
     */
    @Override
    public void close() {
        if (!closed) {
            IOUtil.closeQuietly(body);
            closed = true;
        }
    }

    private void assertOpen() {
        if (closed) {
            throw new IllegalStateException("This downloader is already closed.");
        }
    }
}
