/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link SharingUserError}
 * error.
 */
public class SharingUserErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserSharingRequests#listReceivedFiles()}.
     */
    public final SharingUserError errorValue;

    public SharingUserErrorException(String requestId, LocalizedText userMessage, SharingUserError errorValue) {
        super(requestId, userMessage, buildMessage("list_received_files", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
