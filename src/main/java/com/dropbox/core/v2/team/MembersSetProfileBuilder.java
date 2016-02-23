/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxTeam#membersSetProfileBuilder(UserSelectorArg)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class MembersSetProfileBuilder {
    private final DbxTeam team;
    private final MembersSetProfileArg.Builder membersSetProfileArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param membersSetProfileArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    MembersSetProfileBuilder(DbxTeam team, MembersSetProfileArg.Builder membersSetProfileArgBuilder) {
        if (team == null) {
            throw new NullPointerException("team");
        }
        if (membersSetProfileArgBuilder == null) {
            throw new NullPointerException("membersSetProfileArgBuilder");
        }
        this.team = team;
        this.membersSetProfileArgBuilder = membersSetProfileArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param newEmail  New email for member.
     *
     * @return this builder
     */
    public MembersSetProfileBuilder withNewEmail(String newEmail) {
        this.membersSetProfileArgBuilder.withNewEmail(newEmail);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param newExternalId  New external ID for member.
     *
     * @return this builder
     */
    public MembersSetProfileBuilder withNewExternalId(String newExternalId) {
        this.membersSetProfileArgBuilder.withNewExternalId(newExternalId);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param newGivenName  New given name for member.
     *
     * @return this builder
     */
    public MembersSetProfileBuilder withNewGivenName(String newGivenName) {
        this.membersSetProfileArgBuilder.withNewGivenName(newGivenName);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param newSurname  New surname for member.
     *
     * @return this builder
     */
    public MembersSetProfileBuilder withNewSurname(String newSurname) {
        this.membersSetProfileArgBuilder.withNewSurname(newSurname);
        return this;
    }

    /**
     * Issues the request.
     */
    public TeamMemberInfo start() throws MembersSetProfileErrorException, DbxException {
        MembersSetProfileArg arg = this.membersSetProfileArgBuilder.build();
        return team.membersSetProfile(arg);
    }
}
