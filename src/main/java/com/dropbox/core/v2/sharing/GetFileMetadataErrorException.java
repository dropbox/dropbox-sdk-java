/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GetFileMetadataError}
 * error.
 */
public class GetFileMetadataErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#getFileMetadata(String)}.
     */
    public final GetFileMetadataError errorValue;

    public GetFileMetadataErrorException(String requestId, LocalizedText userMessage, GetFileMetadataError errorValue) {
        super(requestId, userMessage, buildMessage("get_file_metadata", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
