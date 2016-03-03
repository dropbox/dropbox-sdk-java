/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link CreateFolderError}
 * error.
 */
public class CreateFolderErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserFilesRequests#createFolder(String)}.
     */
    public final CreateFolderError errorValue;

    public CreateFolderErrorException(String requestId, LocalizedText userMessage, CreateFolderError errorValue) {
        super(requestId, userMessage, buildMessage("create_folder", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
