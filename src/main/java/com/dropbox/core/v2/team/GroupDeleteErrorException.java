/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GroupDeleteError}
 * error.
 */
public class GroupDeleteErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#groupsDelete(GroupSelector)}.
     */
    public final GroupDeleteError errorValue;

    public GroupDeleteErrorException(String requestId, LocalizedText userMessage, GroupDeleteError errorValue) {
        super(requestId, userMessage, buildMessage("groups/delete", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
