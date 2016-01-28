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
 * @param <R> The return type of the {@link DbxUploader}
 * @param <E> The error type of the {@link DbxUploader}
 * @param <X> The exception type of the {@link DbxUploader}
 */
public abstract class DbxUploadStyleBuilder<R,E,X extends Throwable> {

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
    public abstract DbxUploader<R,E,X> start() throws DbxException;

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
     * @throws DbxException if an error occurs uploading the data or reading the response
     * @throws IOException if an error occurs reading the input stream.
     */
    public R uploadAndFinish(InputStream in) throws DbxException, IOException, X
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
     * @throws DbxException if an error occurs uploading the data or reading the response
     * @throws IOException if an error occurs reading the input stream.
     */
    public R uploadAndFinish(InputStream in, long limit) throws DbxException, IOException, X
    {
        return start().uploadAndFinish(in, limit);
    }
}
