/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#createSharedLinkBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class CreateSharedLinkBuilder {
    private final DbxUserSharingRequests sharing_;
    private final CreateSharedLinkArg.Builder createSharedLinkArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing_  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param createSharedLinkArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    CreateSharedLinkBuilder(DbxUserSharingRequests sharing_, CreateSharedLinkArg.Builder createSharedLinkArgBuilder) {
        if (sharing_ == null) {
            throw new NullPointerException("sharing_");
        }
        this.sharing_ = sharing_;
        if (createSharedLinkArgBuilder == null) {
            throw new NullPointerException("createSharedLinkArgBuilder");
        }
        this.createSharedLinkArgBuilder = createSharedLinkArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param shortUrl  Whether to return a shortened URL. Defaults to {@code
     *     false} when set to {@code null}.
     *
     * @return this builder
     */
    public CreateSharedLinkBuilder withShortUrl(Boolean shortUrl) {
        this.createSharedLinkArgBuilder.withShortUrl(shortUrl);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param pendingUpload  If it's okay to share a path that does not yet
     *     exist, set this to either {@link PendingUploadMode#FILE} or {@link
     *     PendingUploadMode#FOLDER} to indicate whether to assume it's a file
     *     or folder.
     *
     * @return this builder
     */
    public CreateSharedLinkBuilder withPendingUpload(PendingUploadMode pendingUpload) {
        this.createSharedLinkArgBuilder.withPendingUpload(pendingUpload);
        return this;
    }

    /**
     * Issues the request.
     */
    @SuppressWarnings("deprecation")
    public PathLinkMetadata start() throws CreateSharedLinkErrorException, DbxException {
        CreateSharedLinkArg arg_ = this.createSharedLinkArgBuilder.build();
        return sharing_.createSharedLink(arg_);
    }
}
