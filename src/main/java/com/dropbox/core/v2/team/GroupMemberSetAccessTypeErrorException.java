/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * GroupMemberSetAccessTypeError} error.
 */
public class GroupMemberSetAccessTypeErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#groupsMembersSetAccessType(GroupSelector,UserSelectorArg,GroupAccessType)}.
     */
    public final GroupMemberSetAccessTypeError errorValue;

    public GroupMemberSetAccessTypeErrorException(String requestId, LocalizedText userMessage, GroupMemberSetAccessTypeError errorValue) {
        super(requestId, userMessage, buildMessage("groups/members/set_access_type", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
