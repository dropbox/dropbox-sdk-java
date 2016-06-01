/* DO NOT EDIT */
/* This file was generated from team_linked_apps.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link ListMembersAppsError}
 * error.
 */
public class ListMembersAppsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#linkedAppsListMembersLinkedApps()}.
     */
    public final ListMembersAppsError errorValue;

    public ListMembersAppsErrorException(String requestId, LocalizedText userMessage, ListMembersAppsError errorValue) {
        super(requestId, userMessage, buildMessage("linked_apps/list_members_linked_apps", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
