/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * ListMembersDevicesError} error.
 */
public class ListMembersDevicesErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#devicesListMembersDevices()}.
     */
    public final ListMembersDevicesError errorValue;

    public ListMembersDevicesErrorException(String requestId, LocalizedText userMessage, ListMembersDevicesError errorValue) {
        super(requestId, userMessage, buildMessage("devices/list_members_devices", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
