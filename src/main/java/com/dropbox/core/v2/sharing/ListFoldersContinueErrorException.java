/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * ListFoldersContinueError} error.
 */
public class ListFoldersContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#listMountableFoldersContinue(String)}.
     */
    public final ListFoldersContinueError errorValue;

    public ListFoldersContinueErrorException(String requestId, LocalizedText userMessage, ListFoldersContinueError errorValue) {
        super(requestId, userMessage, buildMessage("list_mountable_folders/continue", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
