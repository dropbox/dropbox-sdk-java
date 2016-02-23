/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * ListFoldersContinueError} error.
 */
public class ListFoldersContinueErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxSharing#listFoldersContinue(String)}.
     */
    public final ListFoldersContinueError errorValue;

    public ListFoldersContinueErrorException(String requestId, LocalizedText userMessage, ListFoldersContinueError errorValue) {
        super(requestId, userMessage, buildMessage("list_folders/continue", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
