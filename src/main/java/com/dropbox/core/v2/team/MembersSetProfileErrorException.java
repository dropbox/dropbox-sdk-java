/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * MembersSetProfileError} error.
 */
public class MembersSetProfileErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#membersSetProfile(UserSelectorArg)}.
     */
    public final MembersSetProfileError errorValue;

    public MembersSetProfileErrorException(String requestId, LocalizedText userMessage, MembersSetProfileError errorValue) {
        super(requestId, userMessage, buildMessage("members/set_profile", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
