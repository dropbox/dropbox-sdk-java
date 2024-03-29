/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link PaperCreateError}
 * error.
 *
 * <p> This exception is raised by {@link
 * DbxUserFilesRequests#paperCreate(String,ImportFormat)}. </p>
 */
public class PaperCreateErrorException extends DbxApiException {
    // exception for routes:
    //     2/files/paper/create

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserFilesRequests#paperCreate(String,ImportFormat)}.
     */
    public final PaperCreateError errorValue;

    public PaperCreateErrorException(String routeName, String requestId, LocalizedText userMessage, PaperCreateError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
