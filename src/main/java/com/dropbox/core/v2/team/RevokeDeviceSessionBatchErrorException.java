/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * RevokeDeviceSessionBatchError} error.
 */
public class RevokeDeviceSessionBatchErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#devicesRevokeDeviceSessionBatch(java.util.List)}.
     */
    public final RevokeDeviceSessionBatchError errorValue;

    public RevokeDeviceSessionBatchErrorException(String requestId, LocalizedText userMessage, RevokeDeviceSessionBatchError errorValue) {
        super(requestId, userMessage, buildMessage("devices/revoke_device_session_batch", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
