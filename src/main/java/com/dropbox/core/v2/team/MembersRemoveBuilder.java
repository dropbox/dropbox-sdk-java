/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#membersRemoveBuilder(UserSelectorArg)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class MembersRemoveBuilder {
    private final DbxTeamTeamRequests team_;
    private final MembersRemoveArg.Builder membersRemoveArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team_  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param membersRemoveArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    MembersRemoveBuilder(DbxTeamTeamRequests team_, MembersRemoveArg.Builder membersRemoveArgBuilder) {
        if (team_ == null) {
            throw new NullPointerException("team_");
        }
        this.team_ = team_;
        if (membersRemoveArgBuilder == null) {
            throw new NullPointerException("membersRemoveArgBuilder");
        }
        this.membersRemoveArgBuilder = membersRemoveArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param wipeData  If provided, controls if the user's data will be deleted
     *     on their linked devices. Defaults to {@code true} when set to {@code
     *     null}.
     *
     * @return this builder
     */
    public MembersRemoveBuilder withWipeData(Boolean wipeData) {
        this.membersRemoveArgBuilder.withWipeData(wipeData);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param transferDestId  If provided, files from the deleted member account
     *     will be transferred to this user.
     *
     * @return this builder
     */
    public MembersRemoveBuilder withTransferDestId(UserSelectorArg transferDestId) {
        this.membersRemoveArgBuilder.withTransferDestId(transferDestId);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param transferAdminId  If provided, errors during the transfer process
     *     will be sent via email to this user. If the transfer_dest_id argument
     *     was provided, then this argument must be provided as well.
     *
     * @return this builder
     */
    public MembersRemoveBuilder withTransferAdminId(UserSelectorArg transferAdminId) {
        this.membersRemoveArgBuilder.withTransferAdminId(transferAdminId);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param keepAccount  Downgrade the member to a Basic account. The user
     *     will retain the email address associated with their Dropbox  account
     *     and data in their account that is not restricted to team members.
     *     Defaults to {@code false} when set to {@code null}.
     *
     * @return this builder
     */
    public MembersRemoveBuilder withKeepAccount(Boolean keepAccount) {
        this.membersRemoveArgBuilder.withKeepAccount(keepAccount);
        return this;
    }

    /**
     * Issues the request.
     */
    public com.dropbox.core.v2.async.LaunchEmptyResult start() throws MembersRemoveErrorException, DbxException {
        MembersRemoveArg arg_ = this.membersRemoveArgBuilder.build();
        return team_.membersRemove(arg_);
    }
}
