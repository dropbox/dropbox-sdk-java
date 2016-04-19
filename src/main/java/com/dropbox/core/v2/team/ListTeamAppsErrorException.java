/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link ListTeamAppsError}
 * error.
 */
public class ListTeamAppsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}.
     */
    public final ListTeamAppsError errorValue;

    public ListTeamAppsErrorException(String requestId, LocalizedText userMessage, ListTeamAppsError errorValue) {
        super(requestId, userMessage, buildMessage("linked_apps/list_team_linked_apps", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
