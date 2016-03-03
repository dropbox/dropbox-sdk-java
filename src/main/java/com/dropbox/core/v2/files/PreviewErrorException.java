/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link PreviewError} error.
 */
public class PreviewErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserFilesRequests#getPreview(String)}.
     */
    public final PreviewError errorValue;

    public PreviewErrorException(String requestId, LocalizedText userMessage, PreviewError errorValue) {
        super(requestId, userMessage, buildMessage("get_preview", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
