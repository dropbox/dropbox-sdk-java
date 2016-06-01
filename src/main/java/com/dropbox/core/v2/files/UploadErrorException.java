/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link UploadError} error.
 */
public class UploadErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserFilesRequests#upload(String)}.
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
