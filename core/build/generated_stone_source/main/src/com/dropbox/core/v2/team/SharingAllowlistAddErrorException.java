/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * SharingAllowlistAddError} error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamRequests#sharingAllowlistAdd}. </p>
 */
public class SharingAllowlistAddErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/sharing_allowlist/add

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxTeamTeamRequests#sharingAllowlistAdd}.
     */
    public final SharingAllowlistAddError errorValue;

    public SharingAllowlistAddErrorException(String routeName, String requestId, LocalizedText userMessage, SharingAllowlistAddError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
