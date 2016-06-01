/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * MembersUnsuspendError} error.
 */
public class MembersUnsuspendErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#membersUnsuspend(UserSelectorArg)}.
     */
    public final MembersUnsuspendError errorValue;

    public MembersUnsuspendErrorException(String requestId, LocalizedText userMessage, MembersUnsuspendError errorValue) {
        super(requestId, userMessage, buildMessage("members/unsuspend", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
