/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GroupUpdateError}
 * error.
 */
public class GroupUpdateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#groupsUpdate(GroupSelector)}.
     */
    public final GroupUpdateError errorValue;

    public GroupUpdateErrorException(String requestId, LocalizedText userMessage, GroupUpdateError errorValue) {
        super(requestId, userMessage, buildMessage("groups/update", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
