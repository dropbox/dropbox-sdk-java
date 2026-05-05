/* DO NOT EDIT */
/* This file was generated from sharing_apiv2_sharing_folders_types.stone, sharing_apiv2_sharing_common_types.stone, sharing_apiv2_sharing_folders_base.stone, sharing_apiv2_sharing_files_types.stone, sharing_apiv2_shared_links_types.stone, sharing_apiv2_shared_content_links.stone, sharing_apiv2_shared_link_file_api_v2.stone, sharing_apiv2_shared_links_api_v2.stone */

package com.dropbox.core.v2.sharing;

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
 * Routes in namespace "sharing".
 */
public class DbxAppSharingRequests {
    // namespace sharing (sharing_apiv2_sharing_folders_types.stone, sharing_apiv2_sharing_common_types.stone, sharing_apiv2_sharing_folders_base.stone, sharing_apiv2_sharing_files_types.stone, sharing_apiv2_shared_links_types.stone, sharing_apiv2_shared_content_links.stone, sharing_apiv2_shared_link_file_api_v2.stone, sharing_apiv2_shared_links_api_v2.stone)

    private final DbxRawClientV2 client;

    public DbxAppSharingRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/sharing/get_shared_link_file
    //

    /**
     * Download the shared link's file from a user's Dropbox. This is a
     * download-style endpoint that returns the file content.
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<SharedLinkMetadata> getSharedLinkFile(GetSharedLinkMetadataArg arg, List<HttpRequestor.Header> _headers) throws GetSharedLinkFileErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/sharing/get_shared_link_file",
                                             arg,
                                             false,
                                             _headers,
                                             GetSharedLinkMetadataArg.Serializer.INSTANCE,
                                             SharedLinkMetadata.Serializer.INSTANCE,
                                             GetSharedLinkFileError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetSharedLinkFileErrorException("2/sharing/get_shared_link_file", ex.getRequestId(), ex.getUserMessage(), (GetSharedLinkFileError) ex.getErrorValue());
        }
    }

    /**
     * Download the shared link's file from a user's Dropbox. This is a
     * download-style endpoint that returns the file content.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<SharedLinkMetadata> getSharedLinkFile(String url) throws GetSharedLinkFileErrorException, DbxException {
        GetSharedLinkMetadataArg _arg = new GetSharedLinkMetadataArg(url);
        return getSharedLinkFile(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Download the shared link's file from a user's Dropbox. This is a
     * download-style endpoint that returns the file content.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxAppGetSharedLinkFileBuilder getSharedLinkFileBuilder(String url) {
        GetSharedLinkMetadataArg.Builder argBuilder_ = GetSharedLinkMetadataArg.newBuilder(url);
        return new DbxAppGetSharedLinkFileBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/get_shared_link_metadata
    //

    /**
     * Get the shared link's metadata.
     *
     *
     * @return The metadata of a shared link.
     */
    SharedLinkMetadata getSharedLinkMetadata(GetSharedLinkMetadataArg arg) throws SharedLinkMetadataErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/get_shared_link_metadata",
                                        arg,
                                        false,
                                        GetSharedLinkMetadataArg.Serializer.INSTANCE,
                                        SharedLinkMetadata.Serializer.INSTANCE,
                                        SharedLinkMetadataError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharedLinkMetadataErrorException("2/sharing/get_shared_link_metadata", ex.getRequestId(), ex.getUserMessage(), (SharedLinkMetadataError) ex.getErrorValue());
        }
    }

    /**
     * Get the shared link's metadata.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @return The metadata of a shared link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata getSharedLinkMetadata(String url) throws SharedLinkMetadataErrorException, DbxException {
        GetSharedLinkMetadataArg _arg = new GetSharedLinkMetadataArg(url);
        return getSharedLinkMetadata(_arg);
    }

    /**
     * Get the shared link's metadata.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxAppGetSharedLinkMetadataBuilder getSharedLinkMetadataBuilder(String url) {
        GetSharedLinkMetadataArg.Builder argBuilder_ = GetSharedLinkMetadataArg.newBuilder(url);
        return new DbxAppGetSharedLinkMetadataBuilder(this, argBuilder_);
    }
}
