/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * TeamNamespacesListContinueError} error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamRequests#namespacesListContinue(String)}. </p>
 */
public class TeamNamespacesListContinueErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/namespaces/list/continue

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#namespacesListContinue(String)}.
     */
    public final TeamNamespacesListContinueError errorValue;

    public TeamNamespacesListContinueErrorException(String routeName, String requestId, LocalizedText userMessage, TeamNamespacesListContinueError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
