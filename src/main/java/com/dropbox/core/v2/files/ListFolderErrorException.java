/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link ListFolderError}
 * error.
 */
public class ListFolderErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserFilesRequests#listFolderGetLatestCursor(String)}.
     */
    public final ListFolderError errorValue;

    public ListFolderErrorException(String requestId, LocalizedText userMessage, ListFolderError errorValue) {
        super(requestId, userMessage, buildMessage("list_folder/get_latest_cursor", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
