/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#groupsUpdateBuilder(GroupSelector)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class GroupsUpdateBuilder {
    private final DbxTeamTeamRequests team;
    private final GroupUpdateArgs.Builder groupUpdateArgsBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param groupUpdateArgsBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    GroupsUpdateBuilder(DbxTeamTeamRequests team, GroupUpdateArgs.Builder groupUpdateArgsBuilder) {
        if (team == null) {
            throw new NullPointerException("team");
        }
        if (groupUpdateArgsBuilder == null) {
            throw new NullPointerException("groupUpdateArgsBuilder");
        }
        this.team = team;
        this.groupUpdateArgsBuilder = groupUpdateArgsBuilder;
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
     * Issues the request.
     */
    public GroupFullInfo start() throws GroupUpdateErrorException, DbxException {
        GroupUpdateArgs arg = this.groupUpdateArgsBuilder.build();
        return team.groupsUpdate(arg);
    }
}
