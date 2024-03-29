/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * GetTeamEventsContinueError} error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamLogRequests#getEventsContinue(String)}. </p>
 */
public class GetTeamEventsContinueErrorException extends DbxApiException {
    // exception for routes:
    //     2/team_log/get_events/continue

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamLogRequests#getEventsContinue(String)}.
     */
    public final GetTeamEventsContinueError errorValue;

    public GetTeamEventsContinueErrorException(String routeName, String requestId, LocalizedText userMessage, GetTeamEventsContinueError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
