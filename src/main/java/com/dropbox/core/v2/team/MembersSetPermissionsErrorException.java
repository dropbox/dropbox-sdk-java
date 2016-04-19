/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * MembersSetPermissionsError} error.
 */
public class MembersSetPermissionsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#membersSetAdminPermissions(UserSelectorArg,AdminTier)}.
     */
    public final MembersSetPermissionsError errorValue;

    public MembersSetPermissionsErrorException(String requestId, LocalizedText userMessage, MembersSetPermissionsError errorValue) {
        super(requestId, userMessage, buildMessage("members/set_admin_permissions", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
