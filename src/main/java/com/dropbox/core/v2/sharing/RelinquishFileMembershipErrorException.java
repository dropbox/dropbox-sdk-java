/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * RelinquishFileMembershipError} error.
 */
public class RelinquishFileMembershipErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#relinquishFileMembership(String)}.
     */
    public final RelinquishFileMembershipError errorValue;

    public RelinquishFileMembershipErrorException(String requestId, LocalizedText userMessage, RelinquishFileMembershipError errorValue) {
        super(requestId, userMessage, buildMessage("relinquish_file_membership", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
