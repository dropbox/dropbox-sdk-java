/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link ListFolderError}
 * error.
 *
 * <p> This exception is raised by {@link
 * DbxAppFilesRequests#listFolder(String)} and {@link
 * DbxUserFilesRequests#listFolderGetLatestCursor(String)}. </p>
 */
public class ListFolderErrorException extends DbxApiException {
    // exception for routes:
    //     2/files/list_folder
    //     2/files/list_folder/get_latest_cursor

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxAppFilesRequests#listFolder(String)} and
     * {@link DbxUserFilesRequests#listFolderGetLatestCursor(String)}.
     */
    public final ListFolderError errorValue;

    public ListFolderErrorException(String routeName, String requestId, LocalizedText userMessage, ListFolderError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
