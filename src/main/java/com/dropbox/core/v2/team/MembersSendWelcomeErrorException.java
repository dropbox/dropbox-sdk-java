/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * MembersSendWelcomeError} error.
 */
public class MembersSendWelcomeErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * DbxTeam#membersSendWelcomeEmail(UserSelectorArg)}.
     */
    public final MembersSendWelcomeError errorValue;

    public MembersSendWelcomeErrorException(String requestId, LocalizedText userMessage, MembersSendWelcomeError errorValue) {
        super(requestId, userMessage, buildMessage("members/send_welcome_email", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
