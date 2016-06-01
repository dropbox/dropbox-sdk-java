/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GroupSelectorError}
 * error.
 */
public class GroupSelectorErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#groupsMembersList(GroupSelector)}.
     */
    public final GroupSelectorError errorValue;

    public GroupSelectorErrorException(String requestId, LocalizedText userMessage, GroupSelectorError errorValue) {
        super(requestId, userMessage, buildMessage("groups/members/list", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
