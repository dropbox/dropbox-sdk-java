/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link RestoreError} error.
 */
public class RestoreErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxFiles#restore(String,String)}.
     */
    public final RestoreError errorValue;

    public RestoreErrorException(String requestId, LocalizedText userMessage, RestoreError errorValue) {
        super(requestId, userMessage, buildMessage("restore", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
