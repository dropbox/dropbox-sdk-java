/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxSharing#createSharedLinkBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class CreateSharedLinkBuilder {
    private final DbxSharing sharing;
    private final CreateSharedLinkArg.Builder createSharedLinkArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param createSharedLinkArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    CreateSharedLinkBuilder(DbxSharing sharing, CreateSharedLinkArg.Builder createSharedLinkArgBuilder) {
        if (sharing == null) {
            throw new NullPointerException("sharing");
        }
        if (createSharedLinkArgBuilder == null) {
            throw new NullPointerException("createSharedLinkArgBuilder");
        }
        this.sharing = sharing;
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
    public PathLinkMetadata start() throws CreateSharedLinkErrorException, DbxException {
        CreateSharedLinkArg arg = this.createSharedLinkArgBuilder.build();
        return sharing.createSharedLink(arg);
    }
}
