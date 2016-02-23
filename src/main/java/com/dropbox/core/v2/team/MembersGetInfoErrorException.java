/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link MembersGetInfoError}
 * error.
 */
public class MembersGetInfoErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxTeam#membersGetInfo(java.util.List)}.
     */
    public final MembersGetInfoError errorValue;

    public MembersGetInfoErrorException(String requestId, LocalizedText userMessage, MembersGetInfoError errorValue) {
        super(requestId, userMessage, buildMessage("members/get_info", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
