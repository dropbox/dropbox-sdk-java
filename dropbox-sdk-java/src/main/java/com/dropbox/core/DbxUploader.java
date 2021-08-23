package com.dropbox.core;

import java.io.Closeable;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.dropbox.core.stone.StoneSerializer;
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
public abstract class DbxUploader<R, E, X extends DbxApiException> implements Closeable {
    private final HttpRequestor.Uploader httpUploader;
    private final StoneSerializer<R> responseSerializer;
    private final StoneSerializer<E> errorSerializer;

    private boolean closed;
    private boolean finished;

    private final String userId;

    protected DbxUploader(HttpRequestor.Uploader httpUploader, StoneSerializer<R> responseSerializer, StoneSerializer<E> errorSerializer, String userId) {
        this.httpUploader = httpUploader;
        this.responseSerializer = responseSerializer;
        this.errorSerializer = errorSerializer;

        this.closed = false;
        this.finished = false;
        this.userId = userId;
    }

    protected abstract X newException(DbxWrappedException error);

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
        return uploadAndFinish(in, null);
    }

    /**
     * This method is the same as {@link #uploadAndFinish(InputStream, long)} except for it allow
     * tracking the upload progress.
     *
     * @param in {@code InputStream} containing data to upload
     * @param progressListener {@code OUtil.ProgressListener} to track the upload progress.
     *                                                       Only support  OKHttpRequester and StandardHttpRequester.
     *
     * @return Response from server
     *
     * @throws X if the server sent an error response for the request
     * @throws DbxException if an error occurs uploading the data or reading the response
     * @throws IOException if an error occurs reading the input stream.
     * @throws IllegalStateException if this uploader has already been closed (see {@link #close}) or finished (see {@link #finish})
     */
    public R uploadAndFinish(InputStream in, IOUtil.ProgressListener progressListener) throws X, DbxException, IOException {
        try {
            try {
                httpUploader.setProgressListener(progressListener);
                httpUploader.upload(in);
            } catch (IOUtil.ReadException ex) {
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
     * This method is the same as {@link #uploadAndFinish(InputStream, long)} except for it allows
     * tracking the upload progress.
     *
     * @param in    {@code InputStream} containing data to upload
     * @param limit Maximum number of bytes to read from the given {@code InputStream}
     * @param progressListener {@code OUtil.ProgressListener} to track the upload progress.
     *                                                       Only support  OKHttpRequester and StandardHttpRequester.
     *
     * @return Response from server
     *
     * @throws X if the server sent an error response for the request
     * @throws DbxException if an error occurs uploading the data or reading the response
     * @throws IOException if an error occurs reading the input stream.
     * @throws IllegalStateException if this uploader has already been closed (see {@link #close}) or finished (see {@link #finish})
     */
    public R uploadAndFinish(InputStream in, long limit, IOUtil.ProgressListener progressListener) throws X, DbxException, IOException {
        return uploadAndFinish(IOUtil.limit(in, limit), progressListener);
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
     * Data written to this stream will be uploaded.
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
                if (response.getStatusCode() == 200) {
                    return responseSerializer.deserialize(response.getBody());
                }
                else if (response.getStatusCode() == 409) {
                    DbxWrappedException wrapped =  DbxWrappedException.fromResponse(errorSerializer, response, this.userId);
                    throw newException(wrapped);
                }
                else {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
            } catch (JsonProcessingException ex) {
                String requestId = DbxRequestUtil.getRequestId(response);
                throw new BadResponseException(requestId, "Bad JSON in response: " + ex, ex);
            }
        } catch (IOException ex) {
            throw new NetworkIOException(ex);
        } finally {
            // Make sure input stream is closed
            if (response != null) {
                IOUtil.closeQuietly(response.getBody());
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
