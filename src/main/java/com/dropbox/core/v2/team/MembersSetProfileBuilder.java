/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#membersSetProfileBuilder(UserSelectorArg)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class MembersSetProfileBuilder {
    private final DbxTeamTeamRequests team;
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
    MembersSetProfileBuilder(DbxTeamTeamRequests team, MembersSetProfileArg.Builder membersSetProfileArgBuilder) {
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
     * @param newEmail  New email for member. Must have length of at most 255
     *     and match pattern "{@code
     *     ^['&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*.[A-Za-z]{2,15}$}".
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetProfileBuilder withNewEmail(String newEmail) {
        this.membersSetProfileArgBuilder.withNewEmail(newEmail);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param newExternalId  New external ID for member. Must have length of at
     *     most 64.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetProfileBuilder withNewExternalId(String newExternalId) {
        this.membersSetProfileArgBuilder.withNewExternalId(newExternalId);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param newGivenName  New given name for member. Must have length of at
     *     least 1, have length of at most 100, and match pattern "{@code
     *     [^/:?*<>\"|]*}".
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetProfileBuilder withNewGivenName(String newGivenName) {
        this.membersSetProfileArgBuilder.withNewGivenName(newGivenName);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param newSurname  New surname for member. Must have length of at least
     *     1, have length of at most 100, and match pattern "{@code
     *     [^/:?*<>\"|]*}".
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
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
