package com.dropbox.core;

import java.io.Closeable;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.IOUtil;

/**
 * Class for completing upload requests.
 *
 * This class provides methods for uploading a request body and handling the server response.
 *
 * Example usage:
 *
 * <pre><code>
 *    FileInputStream in = new FileInputStream("test.txt");
 *    try {
 *        response = uploader.uploadAndFinish(in);
 *    } finally {
 *        in.close();
 *    }
 *</code></pre>
 *
 * Example using {@link #getOutputStream}:
 *
 * <pre><code>
 *    try {
 *        OutputStream out = uploader.getOutputStream();
 *        out.write(data);
 *        response = uploader.finish();
 *    } finally {
 *        uploader.close();
 *    }
 *</code></pre>
 *
 * @param <R> response type returned by server on request success
 * @param <X> exception type returned by server on request failure
 */
public abstract class DbxUploader<R, X extends DbxApiException> implements Closeable {
    private final HttpRequestor.Uploader httpUploader;

    private boolean closed;
    private boolean finished;

    protected DbxUploader(HttpRequestor.Uploader httpUploader) {
        this.httpUploader = httpUploader;

        this.closed = false;
        this.finished = false;
    }

    /**
     * Parse and return the server response as the appropriate Java object.
     *
     * @param response Successful response from the server
     *
     * @return server response object
     *
     * @throws JsonReadException if unable to parse the response
     * @throws IOException if an error occurs reading the response
     */
    protected abstract R parseResponse(HttpRequestor.Response response) throws JsonReadException, IOException;

    /**
     * Parse and return the server error response as the appropriate Java object.
     *
     * Implementations should throw the appropriate {@link DbxApiException} for their route.
     *
     * @param response error response from the server
     *
     * @return specific exception thrown by route
     *
     * @throws JsonReadException if unable to parse the response
     * @throws IOException if an error occurs reading the response
     */
    protected abstract X parseError(HttpRequestor.Response response) throws JsonReadException, IOException;

    /**
     * Uploads all bytes read from the given {@link InputStream} and returns the response.
     *
     * This method manages closing this uploader's resources, so no further calls to {@link #close}
     * are necessary. The underlying {@code OutputStream} returned by {@link #getOutputStream}
     * will be closed by this method.
     *
     * This method is the equivalent of
     *
     * <pre><code>
     *    try {
     *        OutputStream out = uploader.getOutputStream();
     *        // read from in, write to out
     *        response = uploader.finish();
     *    } finally {
     *        uploader.close();
     *    }
     * </code></pre>
     *
     * @param in {@code InputStream} containing data to upload
     *
     * @return Response from server
     *
     * @throws X if the server sent an error response for the request
     * @throws DbxException if an error occurs uploading the data or reading the response
     * @throws IOException if an error occurs reading the input stream.
     * @throws IllegalStateException if this uploader has already been closed (see {@link #close}) or finished (see {@link #finish})
     */
    public R uploadAndFinish(InputStream in) throws X, DbxException, IOException {
        try {
            try {
                IOUtil.copyStreamToStream(in, getOutputStream());
            } catch (IOUtil.ReadException ex) {
                // read exceptions should be IOException
                throw ex.getCause();
            } catch (IOException ex) {
                // write exceptions and everything else is a Network I/O problem
                throw new NetworkIOException(ex);
            }

            return finish();
        } finally {
            close();
        }
    }

    /**
     * Uploads up to {@code limit} bytes read from the given {@link InputStream} and returns the
     * response.
     *
     * This method upload bytes from the given {@link InputStream} until {@code limit} bytes have
     * been read or end-of-stream is detected. Use {@link #uploadAndFinish(InputStream)} to upload the entire
     * stream.
     *
     * This method manages closing this uploader's resources, so no further calls to {@link #close}
     * are necessary. The underlying {@code OutputStream} returned by {@link #getOutputStream}
     * will be closed by this method.
     *
     * This method is the equivalent of
     *
     * <pre><code>
     *    try {
     *        OutputStream out = uploader.getOutputStream();
     *        // read at most `limit` bytes from in, write to out
     *        response = uploader.finish();
     *    } finally {
     *        uploader.close();
     *    }
     * </code></pre>
     *
     * @param in    {@code InputStream} containing data to upload
     * @param limit Maximum number of bytes to read from the given {@code InputStream}
     *
     * @return Response from server
     *
     * @throws X if the server sent an error response for the request
     * @throws DbxException if an error occurs uploading the data or reading the response
     * @throws IOException if an error occurs reading the input stream.
     * @throws IllegalStateException if this uploader has already been closed (see {@link #close}) or finished (see {@link #finish})
     */
    public R uploadAndFinish(InputStream in, long limit) throws X, DbxException, IOException {
        return uploadAndFinish(IOUtil.limit(in, limit));
    }

    /**
     * Closes this upload request and releases its underlying resources.
     *
     * This method should always be called to allow for proper resource deallocation.
     *
     * <pre><code>
     *    try {
     *        OutputStream out = uploader.getOutputStream();
     *        out.write(data);
     *        response = uploader.finish();
     *    } finally {
     *        uploader.close();
     *    }
     * </code></pre>
     */
    @Override
    public void close() {
        if (!closed) {
            httpUploader.close();
            closed = true;
        }
    }

    /**
     * Aborts this upload request and closes its underlying connection.
     */
    public void abort() {
        httpUploader.abort();
    }

    /**
     * Returns an {@link OutputStream} that writes to the request body. Remember to call {@link
     * #finish} to complete the request and retrieve the response.
     *
     * Data writen to this stream will be uploaded.
     *
     * Typically you will not need this method and can use the more convenient {@link
     * #uploadAndFinish(InputStream)}.
     *
     * @return Request body output stream.
     *
     * @throws IllegalStateException if this uploader has already been closed (see {@link #close}) or finished (see {@link #finish})
     *
     * @see #uploadAndFinish(InputStream)
     */
    public OutputStream getOutputStream() {
        assertOpenAndUnfinished();
        return this.httpUploader.getBody();
    }

    /**
     * Completes the request and returns response from the server.
     *
     * This method should be called after writing data to the upload {@link OutputStream} (see
     * {@link #getOutputStream}).
     *
     * @return Response from server
     *
     * @throws X if the server sent an error response for the request
     * @throws DbxException if an error occurs sending the upload or reading the response
     * @throws IllegalStateException if this uploader has already been closed (see {@link #close}) or finished (see {@link #finish})
     */
    public R finish() throws X, DbxException {
        assertOpenAndUnfinished();

        HttpRequestor.Response response = null;
        try {
            response = httpUploader.finish();

            try {
                if (response.statusCode == 200) {
                    return parseResponse(response);
                }
                else if (response.statusCode == 409) {
                    throw parseError(response);
                }
                else {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
            } catch (JsonReadException ex) {
                String requestId = DbxRequestUtil.getRequestId(response);
                throw new BadResponseException(requestId, "Bad JSON in response " + ex, ex);
            }
        } catch (IOException ex) {
            throw new NetworkIOException(ex);
        } finally {
            // Make sure input stream is closed
            if (response != null) {
                IOUtil.closeQuietly(response.body);
            }
            finished = true;
        }
    }

    private void assertOpenAndUnfinished() {
        if (closed) {
            throw new IllegalStateException("This uploader is already closed.");
        }
        if (finished) {
            throw new IllegalStateException("This uploader is already finished and cannot be used to upload more data.");
        }
    }
}
