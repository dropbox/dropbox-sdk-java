/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone, sharing_files.stone, shared_links.stone, shared_content_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.Map;

/**
 * Routes in namespace "sharing".
 */
public class DbxAppSharingRequests {
    // namespace sharing (sharing_folders.stone, sharing_files.stone, shared_links.stone, shared_content_links.stone)

    private final DbxRawClientV2 client;

    public DbxAppSharingRequests(DbxRawClientV2 client) {
        this.client = client;
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
    SharedLinkMetadata getSharedLinkMetadata(GetSharedLinkMetadataArg arg) throws SharedLinkErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/get_shared_link_metadata",
                                        arg,
                                        false,
                                        GetSharedLinkMetadataArg.Serializer.INSTANCE,
                                        SharedLinkMetadata.Serializer.INSTANCE,
                                        SharedLinkError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharedLinkErrorException("2/sharing/get_shared_link_metadata", ex.getRequestId(), ex.getUserMessage(), (SharedLinkError) ex.getErrorValue());
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
    public SharedLinkMetadata getSharedLinkMetadata(String url) throws SharedLinkErrorException, DbxException {
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
