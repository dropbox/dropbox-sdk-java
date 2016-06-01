/* DO NOT EDIT */
/* This file was generated from team_reports.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

import java.util.Date;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#reportsGetStorageBuilder()}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ReportsGetStorageBuilder {
    private final DbxTeamTeamRequests team_;
    private final DateRange.Builder dateRangeBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team_  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param dateRangeBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ReportsGetStorageBuilder(DbxTeamTeamRequests team_, DateRange.Builder dateRangeBuilder) {
        if (team_ == null) {
            throw new NullPointerException("team_");
        }
        this.team_ = team_;
        if (dateRangeBuilder == null) {
            throw new NullPointerException("dateRangeBuilder");
        }
        this.dateRangeBuilder = dateRangeBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param startDate  Optional starting date (inclusive).
     *
     * @return this builder
     */
    public ReportsGetStorageBuilder withStartDate(Date startDate) {
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
    public ReportsGetStorageBuilder withEndDate(Date endDate) {
        this.dateRangeBuilder.withEndDate(endDate);
        return this;
    }

    /**
     * Issues the request.
     */
    public GetStorageReport start() throws DateRangeErrorException, DbxException {
        DateRange arg_ = this.dateRangeBuilder.build();
        return team_.reportsGetStorage(arg_);
    }
}
