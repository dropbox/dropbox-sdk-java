/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link MembersSuspendError}
 * error.
 */
public class MembersSuspendErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#membersSuspend(UserSelectorArg)}.
     */
    public final MembersSuspendError errorValue;

    public MembersSuspendErrorException(String requestId, LocalizedText userMessage, MembersSuspendError errorValue) {
        super(requestId, userMessage, buildMessage("members/suspend", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
