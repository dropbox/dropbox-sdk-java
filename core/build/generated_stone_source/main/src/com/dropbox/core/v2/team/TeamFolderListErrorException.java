/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link TeamFolderListError}
 * error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamRequests#teamFolderList(long)}. </p>
 */
public class TeamFolderListErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/team_folder/list

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxTeamTeamRequests#teamFolderList(long)}.
     */
    public final TeamFolderListError errorValue;

    public TeamFolderListErrorException(String routeName, String requestId, LocalizedText userMessage, TeamFolderListError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}