/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#updateFolderPolicyBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class UpdateFolderPolicyBuilder {
    private final DbxUserSharingRequests sharing;
    private final UpdateFolderPolicyArg.Builder updateFolderPolicyArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param updateFolderPolicyArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    UpdateFolderPolicyBuilder(DbxUserSharingRequests sharing, UpdateFolderPolicyArg.Builder updateFolderPolicyArgBuilder) {
        if (sharing == null) {
            throw new NullPointerException("sharing");
        }
        if (updateFolderPolicyArgBuilder == null) {
            throw new NullPointerException("updateFolderPolicyArgBuilder");
        }
        this.sharing = sharing;
        this.updateFolderPolicyArgBuilder = updateFolderPolicyArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param memberPolicy  Who can be a member of this shared folder. Only
     *     applicable if the current user is on a team.
     *
     * @return this builder
     */
    public UpdateFolderPolicyBuilder withMemberPolicy(MemberPolicy memberPolicy) {
        this.updateFolderPolicyArgBuilder.withMemberPolicy(memberPolicy);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param aclUpdatePolicy  Who can add and remove members of this shared
     *     folder.
     *
     * @return this builder
     */
    public UpdateFolderPolicyBuilder withAclUpdatePolicy(AclUpdatePolicy aclUpdatePolicy) {
        this.updateFolderPolicyArgBuilder.withAclUpdatePolicy(aclUpdatePolicy);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param sharedLinkPolicy  The policy to apply to shared links created for
     *     content inside this shared folder. The current user must be on a team
     *     to set this policy to {@link SharedLinkPolicy#MEMBERS}.
     *
     * @return this builder
     */
    public UpdateFolderPolicyBuilder withSharedLinkPolicy(SharedLinkPolicy sharedLinkPolicy) {
        this.updateFolderPolicyArgBuilder.withSharedLinkPolicy(sharedLinkPolicy);
        return this;
    }

    /**
     * Issues the request.
     */
    public SharedFolderMetadata start() throws UpdateFolderPolicyErrorException, DbxException {
        UpdateFolderPolicyArg arg = this.updateFolderPolicyArgBuilder.build();
        return sharing.updateFolderPolicy(arg);
    }
}
