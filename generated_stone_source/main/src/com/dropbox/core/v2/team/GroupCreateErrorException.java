/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GroupCreateError}
 * error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamRequests#groupsCreate(String)}. </p>
 */
public class GroupCreateErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/groups/create

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxTeamTeamRequests#groupsCreate(String)}.
     */
    public final GroupCreateError errorValue;

    public GroupCreateErrorException(String routeName, String requestId, LocalizedText userMessage, GroupCreateError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
