/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link DeleteError} error.
 */
public class DeleteErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxFiles#permanentlyDelete(String)}.
     */
    public final DeleteError errorValue;

    public DeleteErrorException(String requestId, LocalizedText userMessage, DeleteError errorValue) {
        super(requestId, userMessage, buildMessage("permanently_delete", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
