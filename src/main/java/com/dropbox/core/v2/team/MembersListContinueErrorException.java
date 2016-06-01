/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * MembersListContinueError} error.
 */
public class MembersListContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#membersListContinue(String)}.
     */
    public final MembersListContinueError errorValue;

    public MembersListContinueErrorException(String requestId, LocalizedText userMessage, MembersListContinueError errorValue) {
        super(requestId, userMessage, buildMessage("members/list/continue", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
