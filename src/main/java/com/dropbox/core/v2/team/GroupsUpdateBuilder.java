/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.teamcommon.GroupManagementType;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#groupsUpdateBuilder(GroupSelector)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class GroupsUpdateBuilder {
    private final DbxTeamTeamRequests team_;
    private final GroupUpdateArgs.Builder groupUpdateArgsBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team_  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param groupUpdateArgsBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    GroupsUpdateBuilder(DbxTeamTeamRequests team_, GroupUpdateArgs.Builder groupUpdateArgsBuilder) {
        if (team_ == null) {
            throw new NullPointerException("team_");
        }
        this.team_ = team_;
        if (groupUpdateArgsBuilder == null) {
            throw new NullPointerException("groupUpdateArgsBuilder");
        }
        this.groupUpdateArgsBuilder = groupUpdateArgsBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     *     Defaults to {@code true} when set to {@code null}.
     *
     * @return this builder
     */
    public GroupsUpdateBuilder withReturnMembers(Boolean returnMembers) {
        this.groupUpdateArgsBuilder.withReturnMembers(returnMembers);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param newGroupName  Optional argument. Set group name to this if
     *     provided.
     *
     * @return this builder
     */
    public GroupsUpdateBuilder withNewGroupName(String newGroupName) {
        this.groupUpdateArgsBuilder.withNewGroupName(newGroupName);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param newGroupExternalId  Optional argument. New group external ID. If
     *     the argument is None, the group's external_id won't be updated. If
     *     the argument is empty string, the group's external id will be
     *     cleared.
     *
     * @return this builder
     */
    public GroupsUpdateBuilder withNewGroupExternalId(String newGroupExternalId) {
        this.groupUpdateArgsBuilder.withNewGroupExternalId(newGroupExternalId);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param newGroupManagementType  Set new group management type, if
     *     provided.
     *
     * @return this builder
     */
    public GroupsUpdateBuilder withNewGroupManagementType(GroupManagementType newGroupManagementType) {
        this.groupUpdateArgsBuilder.withNewGroupManagementType(newGroupManagementType);
        return this;
    }

    /**
     * Issues the request.
     */
    public GroupFullInfo start() throws GroupUpdateErrorException, DbxException {
        GroupUpdateArgs arg_ = this.groupUpdateArgsBuilder.build();
        return team_.groupsUpdate(arg_);
    }
}
