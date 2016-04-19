package com.dropbox.core.v2;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxStreamReader;
import com.dropbox.core.NoThrowInputStream;
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
