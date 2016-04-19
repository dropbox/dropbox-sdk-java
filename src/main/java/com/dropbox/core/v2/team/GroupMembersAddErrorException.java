/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GroupMembersAddError}
 * error.
 */
public class GroupMembersAddErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,java.util.List)}.
     */
    public final GroupMembersAddError errorValue;

    public GroupMembersAddErrorException(String requestId, LocalizedText userMessage, GroupMembersAddError errorValue) {
        super(requestId, userMessage, buildMessage("groups/members/add", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
