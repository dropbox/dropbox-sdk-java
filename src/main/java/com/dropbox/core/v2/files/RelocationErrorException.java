/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link RelocationError}
 * error.
 */
public class RelocationErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxFiles#move(String,String)}.
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
