package com.dropbox.core.v2;

import com.dropbox.core.*;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.DropboxContentHasher;

import java.io.Closeable;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.io.InputStream;

/**
 * The common interface for all builders associated with upload style methods. After setting any
 * optional request parameters, use {@link #start} or {@link #uploadAndFinish} to initiate the
 * request.
 *
 * <p>Supported generated builders compute an automatic content hash in their
 * {@code uploadAndFinish} convenience methods before opening HTTP. Calling {@link #start()}
 * uses the original streaming lifecycle; provide a content hash explicitly if needed.</p>
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
        return start(in, Long.MAX_VALUE).uploadAndFinish(in);
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
        return start(in, limit).uploadAndFinish(in, limit);
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
        return start(in, limit).uploadAndFinish(in, limit, progressListener);
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
        return start(in, Long.MAX_VALUE).uploadAndFinish(in, progressListener);
    }

    /** Generated builders override this to pass a request-local content hash before HTTP creation. */
    protected DbxUploader<R, E, X> start(InputStream input, long limit) throws DbxException, IOException {
        return start();
    }

    /**
     * Returns a hash after rewinding, or null when hashing is unnecessary or safe rewinding is unavailable.
     * Like Go's seekable-reader path, supported inputs need no payload buffering. Generic mark/reset
     * streams are skipped because setting a mark would overwrite caller state. A failed rewind
     * aborts before HTTP creation rather than uploading a consumed input.
     */
    protected static String calculateContentHash(InputStream input, long limit, String existing, boolean enabled)
            throws IOException {
        if (!enabled || existing != null) return null;
        if (limit < 0) throw new IllegalArgumentException("limit must be non-negative");
        Closeable rewind;
        if (input instanceof FileInputStream) {
            FileChannel channel = ((FileInputStream) input).getChannel();
            long position;
            try {
                position = channel.position();
            } catch (IOException ex) {
                return null; // For example a non-seekable file descriptor such as a pipe.
            }
            rewind = () -> channel.position(position);
        } else if (input instanceof ByteArrayInputStream) {
            // Subclasses may customize reads or skip(), but this rewind needs the original
            // exact available() count and reset() behavior to preserve the caller's mark.
            try {
                if (input.getClass().getMethod("available").getDeclaringClass() != ByteArrayInputStream.class
                        || input.getClass().getMethod("reset").getDeclaringClass() != ByteArrayInputStream.class) return null;
            } catch (NoSuchMethodException | SecurityException ex) {
                return null;
            }
            int remaining = input.available();
            rewind = () -> {
                input.reset();
                long skipped = input.available() - remaining;
                if (skipped < 0) throw new IOException("Input changed while calculating content hash");
                input.skipNBytes(skipped);
                if (input.available() != remaining) throw new IOException("Could not restore input position");
            };
        } else {
            return null; // Unknown subclasses and mark/reset streams cannot preserve caller state safely.
        }
        try (rewind) {
            return DropboxContentHasher.hashHex(IOUtil.limit(input, limit));
        }
    }

}
