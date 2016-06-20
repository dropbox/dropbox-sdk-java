/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link UnshareFileError}
 * error.
 */
public class UnshareFileErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserSharingRequests#unshareFile(String)}.
     */
    public final UnshareFileError errorValue;

    public UnshareFileErrorException(String requestId, LocalizedText userMessage, UnshareFileError errorValue) {
        super(requestId, userMessage, buildMessage("unshare_file", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
