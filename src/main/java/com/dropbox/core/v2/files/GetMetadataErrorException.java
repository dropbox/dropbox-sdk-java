/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GetMetadataError}
 * error.
 */
public class GetMetadataErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxFiles#getMetadata(String)}.
     */
    public final GetMetadataError errorValue;

    public GetMetadataErrorException(String requestId, LocalizedText userMessage, GetMetadataError errorValue) {
        super(requestId, userMessage, buildMessage("get_metadata", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
