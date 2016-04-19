/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#getSharedLinkFileBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class GetSharedLinkFileBuilder extends com.dropbox.core.v2.DbxDownloadStyleBuilder<SharedLinkMetadata> {
    private final DbxUserSharingRequests sharing;
    private final GetSharedLinkMetadataArg.Builder getSharedLinkMetadataArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param getSharedLinkMetadataArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    GetSharedLinkFileBuilder(DbxUserSharingRequests sharing, GetSharedLinkMetadataArg.Builder getSharedLinkMetadataArgBuilder) {
        if (sharing == null) {
            throw new NullPointerException("sharing");
        }
        if (getSharedLinkMetadataArgBuilder == null) {
            throw new NullPointerException("getSharedLinkMetadataArgBuilder");
        }
        this.sharing = sharing;
        this.getSharedLinkMetadataArgBuilder = getSharedLinkMetadataArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param path  If the shared link is to a folder, this parameter can be
     *     used to retrieve the metadata for a specific file or sub-folder in
     *     this folder. A relative path should be used. Must match pattern
     *     "{@code /.*}".
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetSharedLinkFileBuilder withPath(String path) {
        this.getSharedLinkMetadataArgBuilder.withPath(path);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param linkPassword  If the shared link has a password, this parameter
     *     can be used.
     *
     * @return this builder
     */
    public GetSharedLinkFileBuilder withLinkPassword(String linkPassword) {
        this.getSharedLinkMetadataArgBuilder.withLinkPassword(linkPassword);
        return this;
    }

    @Override
    public com.dropbox.core.DbxDownloader<SharedLinkMetadata> start() throws GetSharedLinkFileErrorException, DbxException {
        GetSharedLinkMetadataArg arg = this.getSharedLinkMetadataArgBuilder.build();
        return sharing.getSharedLinkFile(arg);
    }
}
