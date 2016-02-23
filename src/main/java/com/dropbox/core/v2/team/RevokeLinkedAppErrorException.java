/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link RevokeLinkedAppError}
 * error.
 */
public class RevokeLinkedAppErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * DbxTeam#linkedAppsRevokeLinkedApp(String,String)}.
     */
    public final RevokeLinkedAppError errorValue;

    public RevokeLinkedAppErrorException(String requestId, LocalizedText userMessage, RevokeLinkedAppError errorValue) {
        super(requestId, userMessage, buildMessage("linked_apps/revoke_linked_app", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
