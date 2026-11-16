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
        return startWithContentHash(in, Long.MAX_VALUE).uploadAndFinish(in);
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
        return startWithContentHash(in, limit).uploadAndFinish(in, limit);
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
        return startWithContentHash(in, limit).uploadAndFinish(in, limit, progressListener);
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
        return startWithContentHash(in, Long.MAX_VALUE).uploadAndFinish(in, progressListener);
    }
    private DbxUploader<R, E, X> startWithContentHash(InputStream input, long limit) throws DbxException, IOException {
        if (!needsAutoContentHash()) return start();
        String hash = calculateContentHash(input, limit);
        if (hash == null) return start();
        withContentHash(hash);
        try {
            return start();
        } finally {
            withContentHash(null); // Do not retain an automatic hash when the builder is reused.
        }
    }

    /** Returns true when this generated builder supports hashing and no explicit hash was set. */
    protected boolean needsAutoContentHash() {
        return false;
    }

    /**
     * Sets a lowercase hexadecimal Dropbox content hash; an explicit value takes precedence over
     * automatic hashing. Supported generated builders override this with their existing setter.
     *
     * @param contentHash the 64-character hash, or null to clear it
     * @return this builder
     */
    protected DbxUploadStyleBuilder<R, E, X> withContentHash(String contentHash) {
        throw new UnsupportedOperationException("This upload does not accept content hashes");
    }

    /**
     * Returns a hash after rewinding the input, or null when safe, bounded rewinding is unavailable.
     * File and plain byte-array inputs need no payload buffering. Other mark/reset streams are supported
     * only for explicit limits up to 16 KiB, bounding any mark buffer growth. Their mark is replaced.
     * A failed read/reset aborts the request; a consumed input is never silently uploaded.
     */
    private static String calculateContentHash(InputStream input, long limit) throws IOException {
        if (limit < 0) throw new IllegalArgumentException("limit must be non-negative");
        if (limit == 0) return DropboxContentHasher.hashHex(new byte[0]);
        if (input instanceof FileInputStream) {
            FileChannel channel = ((FileInputStream) input).getChannel();
            long position;
            try {
                position = channel.position();
            } catch (IOException ex) {
                return null; // For example a non-seekable file descriptor such as a pipe.
            }
            try (Closeable rewind = () -> channel.position(position)) {
                return DropboxContentHasher.hashHex(IOUtil.limit(input, limit));
            }
        }
        if (input instanceof ByteArrayInputStream) {
            // A subclass can override available/reset/skip; then the position cannot be inferred safely.
            if (input.getClass() != ByteArrayInputStream.class) return null;
            int remaining = input.available();
            try (Closeable rewind = () -> {
                input.reset();
                input.skip(input.available() - remaining);
            }) {
                return DropboxContentHasher.hashHex(IOUtil.limit(input, limit));
            }
        }
        if (limit <= IOUtil.DEFAULT_COPY_BUFFER_SIZE && input.markSupported()) {
            input.mark((int) limit + 1);
            try (Closeable rewind = input::reset) {
                return DropboxContentHasher.hashHex(IOUtil.limit(input, limit));
            }
        }
        return null;
    }

}
