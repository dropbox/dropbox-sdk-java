/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link MembersListError}
 * error.
 *
 * <p> This exception is raised by {@link DbxTeamTeamRequests#membersList} and
 * {@link DbxTeamTeamRequests#membersListV2}. </p>
 */
public class MembersListErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/members/list
    //     2/team/members/list_v2

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxTeamTeamRequests#membersList} and {@link
     * DbxTeamTeamRequests#membersListV2}.
     */
    public final MembersListError errorValue;

    public MembersListErrorException(String routeName, String requestId, LocalizedText userMessage, MembersListError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
