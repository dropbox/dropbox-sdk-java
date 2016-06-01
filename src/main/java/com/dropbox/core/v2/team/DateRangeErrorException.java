/* DO NOT EDIT */
/* This file was generated from team_reports.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link DateRangeError}
 * error.
 */
public class DateRangeErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxTeamTeamRequests#reportsGetStorage()}.
     */
    public final DateRangeError errorValue;

    public DateRangeErrorException(String requestId, LocalizedText userMessage, DateRangeError errorValue) {
        super(requestId, userMessage, buildMessage("reports/get_storage", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
