package com.dropbox.core.v2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxStreamReader;
import com.dropbox.core.NoThrowInputStream;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.IOUtil;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The common interface for all builders associated with download style methods. After setting any
 * optional request parameters, use {@link #start} or {@link #download} to initiate the request.
 *
 * Example usage:
 *
 * <pre><code>
 *    // set our optional request parameters
 *    DbxDownloader&lt;FileMetadata&gt; downloader = client.files.getThumbnailBuilder("/test.png")
 *        .format(ThumbnailFormat.png())
 *        .size(ThumbnailSize.w64h64())
 *        .start();
 *    FileMetadata metadata = downloader.getResult();
 *
 *    FileOutputStream out = new FileOutputStream(outFile);
 *    try {
 *        // set our upload content
 *        InputStream in = downloader.getInputStream();
 *        // read from in, write to out
 *    } finally {
 *        downloader.close();
 *        out.close();
 *    }
 *</code></pre>
 *
 * Same example using the {@link #download} convenience method:
 *
 * <pre><code>
 *    FileOutputStream out = new FileOutputStream(outFile);
 *    try {
 *        // set our optional request parameters
 *        FileMetadata metadata = client.files.getThumbnailBuilder("/test.png")
 *            .format(ThumbnailFormat.png())
 *            .size(ThumbnailSize.w64h64())
 *            .download(out);
 *    } finally {
 *        out.close();
 *    }
 *</code></pre>
 *
 * @param <R> The return type of the {@link DbxDownloader}
 */
public abstract class DbxDownloadStyleBuilder<R> {
    private Long start;
    private Long length;

    protected DbxDownloadStyleBuilder() {
        this.start = null;
        this.length = null;
    }

    protected List<HttpRequestor.Header> getHeaders() {
        if (start == null) {
            return Collections.emptyList();
        }

        List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        String rangeValue = String.format("bytes=%d-", start.longValue());
        if (length != null) {
            // Range header is inclusive (e.g. bytes=0-499 means first 500 bytes)
            rangeValue += Long.toString(start.longValue() + length.longValue() - 1);
        }
        headers.add(new HttpRequestor.Header("Range", rangeValue));

        return headers;
    }

    /**
     * Issues the download request using this builder's request parameters and returns a {@link
     * DbxDownloader} for reading the response body.
     *
     * Callers should fully read the response body using {@link DbxDownloader#getInputStream} and
     * close the downloader afterwards (see {@link DbxDownloader#close}). This will allow for proper
     * resource deallocation and connection re-use..
     *
     * See {@link #download} convenience method for a simpler way to complete the request.
     *
     * @return {@link DbxDownloader} used to download data and read the response.
     *
     * @throws DbxException if an error occursing issuing the request
     */
    public abstract DbxDownloader<R> start() throws DbxException;

    /**
     * Sets the partial byte range to download.
     *
     * Only the specified bytes of the content will be downloaded. The HTTP Range header will be set
     * for this request. If {@code start} is greater than the length of the content, the range
     * request will be ignored and server will return the entire contents. If {@code length} extends
     * beyond the end of the cont`ent, the server will return all bytes from {@code start} until the
     * end of the content.
     *
     * @param start index of first byte in range (index starts at 0)
     * @param length number of bytes to download starting at {@code start}
     *
     * @return this builder
     *
     * @throws IllegalArgumentException if {@code start} or {@code length} are negative
     */
    public DbxDownloadStyleBuilder<R> range(long start, long length) {
        if (start < 0) throw new IllegalArgumentException("start must be non-negative");
        if (length < 1) throw new IllegalArgumentException("length must be positive");

        this.start = start;
        this.length = length;

        return this;
    }

    /**
     * Sets the partial byte range to download.
     *
     * Only bytes from {@code start} (inclusive) until the end of the content will be
     * downloaded. The HTTP Range header will be set for this request. If {@code start} is greater
     * than the length of the content, the range request will be ignored and server will return the
     * entire contents.
     *
     * @param start index of first byte in range (index starts at 0). All following bytes in the
     * content will be downloaded.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException if {@code start} is negative
     */
    public DbxDownloadStyleBuilder<R> range(long start) {
        if (start < 0) throw new IllegalArgumentException("start must be non-negative");

        this.start = start;
        this.length = null;

        return this;
    }

    /**
     * Convenience method for {@link DbxDownloader#download(OutputStream)}:
     *
     * <pre><code>
     *    builder.start().download(out);
     * </code></pre>
     *
     * @param out {@code OutputStream} to write response body to
     *
     * @return Response from server
     *
     * @throws DbxException if an error occurs reading the response or response body
     * @throws IOException if an error occurs writing the response body to the output stream.
     */
    public R download(OutputStream out) throws DbxException, IOException {
        return start().download(out);
    }
}
