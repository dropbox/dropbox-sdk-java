/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#membersListBuilder()}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class MembersListBuilder {
    private final DbxTeamTeamRequests team_;
    private final MembersListArg.Builder membersListArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team_  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param membersListArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    MembersListBuilder(DbxTeamTeamRequests team_, MembersListArg.Builder membersListArgBuilder) {
        if (team_ == null) {
            throw new NullPointerException("team_");
        }
        this.team_ = team_;
        if (membersListArgBuilder == null) {
            throw new NullPointerException("membersListArgBuilder");
        }
        this.membersListArgBuilder = membersListArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code 1000L}. </p>
     *
     * @param limit  Number of results to return per call. Must be greater than
     *     or equal to 1 and be less than or equal to 1000. Defaults to {@code
     *     1000L} when set to {@code null}.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersListBuilder withLimit(Long limit) {
        this.membersListArgBuilder.withLimit(limit);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param includeRemoved  Whether to return removed members. Defaults to
     *     {@code false} when set to {@code null}.
     *
     * @return this builder
     */
    public MembersListBuilder withIncludeRemoved(Boolean includeRemoved) {
        this.membersListArgBuilder.withIncludeRemoved(includeRemoved);
        return this;
    }

    /**
     * Issues the request.
     */
    public MembersListResult start() throws MembersListErrorException, DbxException {
        MembersListArg arg_ = this.membersListArgBuilder.build();
        return team_.membersList(arg_);
    }
}
