/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * GroupMemberSelectorError} error.
 */
public class GroupMemberSelectorErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * DbxTeam#groupsMembersSetAccessType(GroupSelector,UserSelectorArg,GroupAccessType)}.
     */
    public final GroupMemberSelectorError errorValue;

    public GroupMemberSelectorErrorException(String requestId, LocalizedText userMessage, GroupMemberSelectorError errorValue) {
        super(requestId, userMessage, buildMessage("groups/members/set_access_type", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
