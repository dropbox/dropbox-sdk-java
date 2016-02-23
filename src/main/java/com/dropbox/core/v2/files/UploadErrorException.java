/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link UploadError} error.
 */
public class UploadErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxFiles#upload(String)}.
     */
    public final UploadError errorValue;

    public UploadErrorException(String requestId, LocalizedText userMessage, UploadError errorValue) {
        super(requestId, userMessage, buildMessage("upload", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
