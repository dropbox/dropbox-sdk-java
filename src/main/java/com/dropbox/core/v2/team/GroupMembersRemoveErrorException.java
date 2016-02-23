/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * GroupMembersRemoveError} error.
 */
public class GroupMembersRemoveErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * DbxTeam#groupsMembersRemove(GroupSelector,java.util.List)}.
     */
    public final GroupMembersRemoveError errorValue;

    public GroupMembersRemoveErrorException(String requestId, LocalizedText userMessage, GroupMembersRemoveError errorValue) {
        super(requestId, userMessage, buildMessage("groups/members/remove", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
