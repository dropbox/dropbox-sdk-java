/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link PaperUpdateError}
 * error.
 *
 * <p> This exception is raised by {@link
 * DbxUserFilesRequests#paperUpdate(String,ImportFormat,PaperDocUpdatePolicy,Long)}.
 * </p>
 */
public class PaperUpdateErrorException extends DbxApiException {
    // exception for routes:
    //     2/files/paper/update

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserFilesRequests#paperUpdate(String,ImportFormat,PaperDocUpdatePolicy,Long)}.
     */
    public final PaperUpdateError errorValue;

    public PaperUpdateErrorException(String routeName, String requestId, LocalizedText userMessage, PaperUpdateError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
