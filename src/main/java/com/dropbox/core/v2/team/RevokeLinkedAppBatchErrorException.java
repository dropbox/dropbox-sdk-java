/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * RevokeLinkedAppBatchError} error.
 */
public class RevokeLinkedAppBatchErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * DbxTeam#linkedAppsRevokeLinkedAppBatch(java.util.List)}.
     */
    public final RevokeLinkedAppBatchError errorValue;

    public RevokeLinkedAppBatchErrorException(String requestId, LocalizedText userMessage, RevokeLinkedAppBatchError errorValue) {
        super(requestId, userMessage, buildMessage("linked_apps/revoke_linked_app_batch", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
