/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * SaveCopyReferenceError} error.
 */
public class SaveCopyReferenceErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserFilesRequests#copyReferenceSave(String,String)}.
     */
    public final SaveCopyReferenceError errorValue;

    public SaveCopyReferenceErrorException(String requestId, LocalizedText userMessage, SaveCopyReferenceError errorValue) {
        super(requestId, userMessage, buildMessage("copy_reference/save", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
