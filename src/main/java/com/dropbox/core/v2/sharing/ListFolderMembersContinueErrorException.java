/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * ListFolderMembersContinueError} error.
 */
public class ListFolderMembersContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#listFolderMembersContinue(String)}.
     */
    public final ListFolderMembersContinueError errorValue;

    public ListFolderMembersContinueErrorException(String requestId, LocalizedText userMessage, ListFolderMembersContinueError errorValue) {
        super(requestId, userMessage, buildMessage("list_folder_members/continue", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
