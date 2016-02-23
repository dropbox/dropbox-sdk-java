/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * RevokeDeviceSessionError} error.
 */
public class RevokeDeviceSessionErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * DbxTeam#devicesRevokeDeviceSession(RevokeDeviceSessionArg)}.
     */
    public final RevokeDeviceSessionError errorValue;

    public RevokeDeviceSessionErrorException(String requestId, LocalizedText userMessage, RevokeDeviceSessionError errorValue) {
        super(requestId, userMessage, buildMessage("devices/revoke_device_session", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
