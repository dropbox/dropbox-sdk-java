/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GroupCreateError}
 * error.
 */
public class GroupCreateErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxTeam#groupsCreate(String)}.
     */
    public final GroupCreateError errorValue;

    public GroupCreateErrorException(String requestId, LocalizedText userMessage, GroupCreateError errorValue) {
        super(requestId, userMessage, buildMessage("groups/create", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
