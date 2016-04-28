/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * GetCopyReferenceError} error.
 */
public class GetCopyReferenceErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserFilesRequests#copyReferenceGet(String)}.
     */
    public final GetCopyReferenceError errorValue;

    public GetCopyReferenceErrorException(String requestId, LocalizedText userMessage, GetCopyReferenceError errorValue) {
        super(requestId, userMessage, buildMessage("copy_reference/get", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
