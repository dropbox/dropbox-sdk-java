/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * TeamFolderUpdateSyncSettingsError} error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamRequests#teamFolderUpdateSyncSettings(String)}. </p>
 */
public class TeamFolderUpdateSyncSettingsErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/team_folder/update_sync_settings

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#teamFolderUpdateSyncSettings(String)}.
     */
    public final TeamFolderUpdateSyncSettingsError errorValue;

    public TeamFolderUpdateSyncSettingsErrorException(String routeName, String requestId, LocalizedText userMessage, TeamFolderUpdateSyncSettingsError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
