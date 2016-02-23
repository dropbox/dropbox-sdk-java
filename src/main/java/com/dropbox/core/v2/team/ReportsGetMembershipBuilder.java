/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

import java.util.Date;

/**
 * The request builder returned by {@link
 * DbxTeam#reportsGetMembershipBuilder()}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ReportsGetMembershipBuilder {
    private final DbxTeam team;
    private final DateRange.Builder dateRangeBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param dateRangeBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ReportsGetMembershipBuilder(DbxTeam team, DateRange.Builder dateRangeBuilder) {
        if (team == null) {
            throw new NullPointerException("team");
        }
        if (dateRangeBuilder == null) {
            throw new NullPointerException("dateRangeBuilder");
        }
        this.team = team;
        this.dateRangeBuilder = dateRangeBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param startDate  Optional starting date (inclusive).
     *
     * @return this builder
     */
    public ReportsGetMembershipBuilder withStartDate(Date startDate) {
        this.dateRangeBuilder.withStartDate(startDate);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param endDate  Optional ending date (exclusive).
     *
     * @return this builder
     */
    public ReportsGetMembershipBuilder withEndDate(Date endDate) {
        this.dateRangeBuilder.withEndDate(endDate);
        return this;
    }

    /**
     * Issues the request.
     */
    public GetMembershipReport start() throws DateRangeErrorException, DbxException {
        DateRange arg = this.dateRangeBuilder.build();
        return team.reportsGetMembership(arg);
    }
}
