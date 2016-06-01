/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link ListTeamDevicesError}
 * error.
 */
public class ListTeamDevicesErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#devicesListTeamDevices()}.
     */
    public final ListTeamDevicesError errorValue;

    public ListTeamDevicesErrorException(String requestId, LocalizedText userMessage, ListTeamDevicesError errorValue) {
        super(requestId, userMessage, buildMessage("devices/list_team_devices", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
