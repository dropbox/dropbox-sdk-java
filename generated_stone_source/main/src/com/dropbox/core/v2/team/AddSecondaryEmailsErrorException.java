/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * AddSecondaryEmailsError} error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamRequests#membersSecondaryEmailsAdd(java.util.List)}. </p>
 */
public class AddSecondaryEmailsErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/members/secondary_emails/add

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#membersSecondaryEmailsAdd(java.util.List)}.
     */
    public final AddSecondaryEmailsError errorValue;

    public AddSecondaryEmailsErrorException(String routeName, String requestId, LocalizedText userMessage, AddSecondaryEmailsError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
