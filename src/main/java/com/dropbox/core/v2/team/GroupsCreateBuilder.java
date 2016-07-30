/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.teamcommon.GroupManagementType;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#groupsCreateBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class GroupsCreateBuilder {
    private final DbxTeamTeamRequests team_;
    private final GroupCreateArg.Builder groupCreateArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team_  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param groupCreateArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    GroupsCreateBuilder(DbxTeamTeamRequests team_, GroupCreateArg.Builder groupCreateArgBuilder) {
        if (team_ == null) {
            throw new NullPointerException("team_");
        }
        this.team_ = team_;
        if (groupCreateArgBuilder == null) {
            throw new NullPointerException("groupCreateArgBuilder");
        }
        this.groupCreateArgBuilder = groupCreateArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param groupExternalId  The creator of a team can associate an arbitrary
     *     external ID to the group.
     *
     * @return this builder
     */
    public GroupsCreateBuilder withGroupExternalId(String groupExternalId) {
        this.groupCreateArgBuilder.withGroupExternalId(groupExternalId);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param groupManagementType  Whether the team can be managed by selected
     *     users, or only by team admins.
     *
     * @return this builder
     */
    public GroupsCreateBuilder withGroupManagementType(GroupManagementType groupManagementType) {
        this.groupCreateArgBuilder.withGroupManagementType(groupManagementType);
        return this;
    }

    /**
     * Issues the request.
     */
    public GroupFullInfo start() throws GroupCreateErrorException, DbxException {
        GroupCreateArg arg_ = this.groupCreateArgBuilder.build();
        return team_.groupsCreate(arg_);
    }
}
