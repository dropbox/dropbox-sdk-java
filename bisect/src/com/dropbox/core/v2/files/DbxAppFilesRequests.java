/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxDownloadStyleBuilder;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "files".
 */
public class DbxAppFilesRequests {
    // namespace files (files.stone)

    private final DbxRawClientV2 client;

    public DbxAppFilesRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/files/get_thumbnail_v2
    //

    /**
     * Get a thumbnail for a file.
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<PreviewResult> getThumbnailV2(ThumbnailV2Arg arg, List<HttpRequestor.Header> _headers) throws ThumbnailV2ErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/files/get_thumbnail_v2",
                                             arg,
                                             false,
                                             _headers,
                                             ThumbnailV2Arg.Serializer.INSTANCE,
                                             PreviewResult.Serializer.INSTANCE,
                                             ThumbnailV2Error.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ThumbnailV2ErrorException("2/files/get_thumbnail_v2", ex.getRequestId(), ex.getUserMessage(), (ThumbnailV2Error) ex.getErrorValue());
        }
    }

    /**
     * Get a thumbnail for a file.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DbxAppGetThumbnailV2Builder} for more details. </p>
     *
     * @param resource  Information specifying which file to preview. This could
     *     be a path to a file, a shared link pointing to a file, or a shared
     *     link pointing to a folder, with a relative path. Must not be {@code
     *     null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<PreviewResult> getThumbnailV2(PathOrLink resource) throws ThumbnailV2ErrorException, DbxException {
        ThumbnailV2Arg _arg = new ThumbnailV2Arg(resource);
        return getThumbnailV2(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Get a thumbnail for a file.
     *
     * @param resource  Information specifying which file to preview. This could
     *     be a path to a file, a shared link pointing to a file, or a shared
     *     link pointing to a folder, with a relative path. Must not be {@code
     *     null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxAppGetThumbnailV2Builder getThumbnailV2Builder(PathOrLink resource) {
        ThumbnailV2Arg.Builder argBuilder_ = ThumbnailV2Arg.newBuilder(resource);
        return new DbxAppGetThumbnailV2Builder(this, argBuilder_);
    }
}
