/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GetMetadataError}
 * error.
 *
 * <p> This exception is raised by {@link
 * DbxUserFilesRequests#getMetadata(String)}. </p>
 */
public class GetMetadataErrorException extends DbxApiException {
    // exception for routes:
    //     2/files/get_metadata

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserFilesRequests#getMetadata(String)}.
     */
    public final GetMetadataError errorValue;

    public GetMetadataErrorException(String routeName, String requestId, LocalizedText userMessage, GetMetadataError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
