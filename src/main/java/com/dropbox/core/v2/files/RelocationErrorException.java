/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link RelocationError}
 * error.
 */
public class RelocationErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserFilesRequests#move(String,String)}.
     */
    public final RelocationError errorValue;

    public RelocationErrorException(String requestId, LocalizedText userMessage, RelocationError errorValue) {
        super(requestId, userMessage, buildMessage("move", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
