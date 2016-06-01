/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link MembersRemoveError}
 * error.
 */
public class MembersRemoveErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#membersRemove(UserSelectorArg)}.
     */
    public final MembersRemoveError errorValue;

    public MembersRemoveErrorException(String requestId, LocalizedText userMessage, MembersRemoveError errorValue) {
        super(requestId, userMessage, buildMessage("members/remove", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
