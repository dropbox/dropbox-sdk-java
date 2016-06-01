/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * GroupsMembersListContinueError} error.
 */
public class GroupsMembersListContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#groupsMembersListContinue(String)}.
     */
    public final GroupsMembersListContinueError errorValue;

    public GroupsMembersListContinueErrorException(String requestId, LocalizedText userMessage, GroupsMembersListContinueError errorValue) {
        super(requestId, userMessage, buildMessage("groups/members/list/continue", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
