/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * ListMemberDevicesError} error.
 */
public class ListMemberDevicesErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#devicesListMemberDevices(String)}.
     */
    public final ListMemberDevicesError errorValue;

    public ListMemberDevicesErrorException(String requestId, LocalizedText userMessage, ListMemberDevicesError errorValue) {
        super(requestId, userMessage, buildMessage("devices/list_member_devices", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
