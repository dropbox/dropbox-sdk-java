/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GroupsGetInfoError}
 * error.
 */
public class GroupsGetInfoErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxTeam#groupsGetInfo(GroupsSelector)}.
     */
    public final GroupsGetInfoError errorValue;

    public GroupsGetInfoErrorException(String requestId, LocalizedText userMessage, GroupsGetInfoError errorValue) {
        super(requestId, userMessage, buildMessage("groups/get_info", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
