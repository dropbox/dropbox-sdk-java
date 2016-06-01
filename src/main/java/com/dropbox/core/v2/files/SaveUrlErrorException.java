/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link SaveUrlError} error.
 */
public class SaveUrlErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserFilesRequests#saveUrl(String,String)}.
     */
    public final SaveUrlError errorValue;

    public SaveUrlErrorException(String requestId, LocalizedText userMessage, SaveUrlError errorValue) {
        super(requestId, userMessage, buildMessage("save_url", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
