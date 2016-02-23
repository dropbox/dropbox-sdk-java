/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * ListFolderContinueError} error.
 */
public class ListFolderContinueErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxFiles#listFolderContinue(String)}.
     */
    public final ListFolderContinueError errorValue;

    public ListFolderContinueErrorException(String requestId, LocalizedText userMessage, ListFolderContinueError errorValue) {
        super(requestId, userMessage, buildMessage("list_folder/continue", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
