/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * MembersSetPermissions2Error} error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamRequests#membersSetAdminPermissionsV2(UserSelectorArg,java.util.List)}.
 * </p>
 */
public class MembersSetPermissions2ErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/members/set_admin_permissions_v2

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#membersSetAdminPermissionsV2(UserSelectorArg,java.util.List)}.
     */
    public final MembersSetPermissions2Error errorValue;

    public MembersSetPermissions2ErrorException(String routeName, String requestId, LocalizedText userMessage, MembersSetPermissions2Error errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
