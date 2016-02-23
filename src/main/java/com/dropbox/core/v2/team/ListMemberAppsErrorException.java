/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link ListMemberAppsError}
 * error.
 */
public class ListMemberAppsErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * DbxTeam#linkedAppsListMemberLinkedApps(String)}.
     */
    public final ListMemberAppsError errorValue;

    public ListMemberAppsErrorException(String requestId, LocalizedText userMessage, ListMemberAppsError errorValue) {
        super(requestId, userMessage, buildMessage("linked_apps/list_member_linked_apps", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
