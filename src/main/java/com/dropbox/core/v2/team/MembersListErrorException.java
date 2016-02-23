/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link MembersListError}
 * error.
 */
public class MembersListErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxTeam#membersList()}.
     */
    public final MembersListError errorValue;

    public MembersListErrorException(String requestId, LocalizedText userMessage, MembersListError errorValue) {
        super(requestId, userMessage, buildMessage("members/list", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
