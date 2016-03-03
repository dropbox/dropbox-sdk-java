/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link ThumbnailError}
 * error.
 */
public class ThumbnailErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserFilesRequests#getThumbnail(String)}.
     */
    public final ThumbnailError errorValue;

    public ThumbnailErrorException(String requestId, LocalizedText userMessage, ThumbnailError errorValue) {
        super(requestId, userMessage, buildMessage("get_thumbnail", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
