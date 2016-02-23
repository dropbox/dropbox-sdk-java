/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxSharing#shareFolderBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ShareFolderBuilder {
    private final DbxSharing sharing;
    private final ShareFolderArg.Builder shareFolderArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param shareFolderArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ShareFolderBuilder(DbxSharing sharing, ShareFolderArg.Builder shareFolderArgBuilder) {
        if (sharing == null) {
            throw new NullPointerException("sharing");
        }
        if (shareFolderArgBuilder == null) {
            throw new NullPointerException("shareFolderArgBuilder");
        }
        this.sharing = sharing;
        this.shareFolderArgBuilder = shareFolderArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code
     * MemberPolicy.ANYONE}. </p>
     *
     * @param memberPolicy  Who can be a member of this shared folder. Defaults
     *     to {@code MemberPolicy.ANYONE} when set to {@code null}.
     *
     * @return this builder
     */
    public ShareFolderBuilder withMemberPolicy(MemberPolicy memberPolicy) {
        this.shareFolderArgBuilder.withMemberPolicy(memberPolicy);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code
     * AclUpdatePolicy.OWNER}. </p>
     *
     * @param aclUpdatePolicy  Who can add and remove members of this shared
     *     folder. Defaults to {@code AclUpdatePolicy.OWNER} when set to {@code
     *     null}.
     *
     * @return this builder
     */
    public ShareFolderBuilder withAclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy) {
        this.shareFolderArgBuilder.withAclUpdatePolicy(aclUpdatePolicy);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code
     * SharedLinkPolicy.ANYONE}. </p>
     *
     * @param sharedLinkPolicy  The policy to apply to shared links created for
     *     content inside this shared folder. Defaults to {@code
     *     SharedLinkPolicy.ANYONE} when set to {@code null}.
     *
     * @return this builder
     */
    public ShareFolderBuilder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
        this.shareFolderArgBuilder.withSharedLinkPolicy(sharedLinkPolicy);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param forceAsync  Whether to force the share to happen asynchronously.
     *     Defaults to {@code false} when set to {@code null}.
     *
     * @return this builder
     */
    public ShareFolderBuilder withForceAsync(Boolean forceAsync) {
        this.shareFolderArgBuilder.withForceAsync(forceAsync);
        return this;
    }

    /**
     * Issues the request.
     */
    public ShareFolderLaunch start() throws ShareFolderErrorException, DbxException {
        ShareFolderArg arg = this.shareFolderArgBuilder.build();
        return sharing.shareFolder(arg);
    }
}
