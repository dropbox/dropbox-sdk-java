package com.dropbox.core.v2;

import com.dropbox.core.*;
import com.dropbox.core.util.IOUtil;

import java.io.IOException;
import java.io.InputStream;

/**
 * The common interface for all builders associated with upload style methods. After setting any
 * optional request parameters, use {@link #start} or {@link #uploadAndFinish} to initiate the
 * request.
 *
 * Example usage:
 *
 * <pre><code>
 *    // set our optional request parameters
 *    UploadUploader uploader = client.files.uploadBuilder("/test.txt")
 *        .autorename(true)
 *        .mute(true)
 *        .clientModified(new Date())
 *        .start();
 *
 *    byte [] data = // ... your data here
 *    try {
 *        // set our upload content
 *        OutputStream out = uploader.getOutputStream();
 *        out.write(data);
 *
 *        // complete request and get server response
 *        response = uploader.finish();
 *    } finally {
 *        uploader.close();
 *    }
 *</code></pre>
 *
 * Same example using the {@link #uploadAndFinish} convenience method:
 *
 * <pre><code>
 *    FileInputStream in = new FileInputStream(file);
 *    try {
 *        // set our optional request parameters
 *        response = client.files.uploadBuilder("/test.txt")
 *            .autorename(true)
 *            .mute(true)
 *            .clientModified(new Date())
 *            .uploadAndFinish(in);
 *    } finally {
 *        in.close();
 *    }
 *</code></pre>
 *
 * @param <R> response type returned by server on request success
 * @param <E> error type returned by server on request failure
 * @param <X> exception type thrown by server on request failure (wraps error type)
 */
public abstract class DbxUploadStyleBuilder<R,E, X extends DbxApiException> {

    /**
     * Begins the upload request using this builder's request parameters and returns a {@link
     * DbxUploader} for writing the request body.
     *
     * Callers can complete the request by writing the upload data to the {@link java.io.OutputStream}
     * returned by {@link DbxUploader#getOutputStream} and receiving the server response using
     * {@link DbxUploader#finish}.
     *
     * See {@link #uploadAndFinish} convenience method for a simpler way to complete the request.
     *
     * @return {@link DbxUploader} used to upload data and complete the request
     *
     * @throws DbxException if an error occursing initializing the request
     */
    public abstract DbxUploader<R, E, X> start() throws DbxException;

    /**
     * Convenience method for {@link DbxUploader#uploadAndFinish(InputStream)}:
     *
     * <pre><code>
     *    builder.start().uploadAndFinish(in);
     * </code></pre>
     *
     * @param in {@code InputStream} containing data to upload
     *
     * @return Response from server
     *
     * @throws X if the server sent an error response for the request
     * @throws DbxException if an error occurs uploading the data or reading the response
     * @throws IOException if an error occurs reading the input stream.
     */
    public R uploadAndFinish(InputStream in) throws X, DbxException, IOException
    {
        return start().uploadAndFinish(in);
    }

    /**
     * Convenience method for {@link DbxUploader#uploadAndFinish(InputStream, long)}:
     *
     * <pre><code>
     *    builder.start().uploadAndFinish(in, limit);
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
     */
    public R uploadAndFinish(InputStream in, long limit) throws X, DbxException, IOException
    {
        return start().uploadAndFinish(in, limit);
    }

    /**
     * Convenience method for {@link DbxUploader#uploadAndFinish(InputStream, long, IOUtil.ProgressListener)}:
     *
     * <pre><code>
     *    builder.start().uploadAndFinish(in, limit, progressListener);
     * </code></pre>
     *
     * @param in    {@code InputStream} containing data to upload
     * @param limit Maximum number of bytes to read from the given {@code InputStream}
     * @param progressListener {@code ProgressListener} to track the upload progress. Only support
     *  OKHttpRequester and StandardHttpRequester
     *
     * @return Response from server
     *
     * @throws X if the server sent an error response for the request
     * @throws DbxException if an error occurs uploading the data or reading the response
     * @throws IOException if an error occurs reading the input stream.
     */
    public R uploadAndFinish(InputStream in, long limit, IOUtil.ProgressListener progressListener)
            throws X, DbxException, IOException
    {
        return start().uploadAndFinish(in, limit, progressListener);
    }

    /**
     * Convenience method for {@link DbxUploader#uploadAndFinish(InputStream, IOUtil.ProgressListener)}:
     *
     * <pre><code>
     *    builder.start().uploadAndFinish(in, progressListener);
     * </code></pre>
     *
     * @param in {@code InputStream} containing data to upload
     * @param progressListener {@code ProgressListener} to track the upload progress. Only support
     *  OKHttpRequester and StandardHttpRequester
     *
     * @return Response from server
     *
     * @throws X if the server sent an error response for the request
     * @throws DbxException if an error occurs uploading the data or reading the response
     * @throws IOException if an error occurs reading the input stream.
     */
    public R uploadAndFinish(InputStream in, IOUtil.ProgressListener progressListener)
            throws X, DbxException, IOException
    {
        return start().uploadAndFinish(in, progressListener);
    }
}
