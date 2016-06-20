/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * ListFilesContinueError} error.
 */
public class ListFilesContinueErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#listReceivedFilesContinue(String)}.
     */
    public final ListFilesContinueError errorValue;

    public ListFilesContinueErrorException(String requestId, LocalizedText userMessage, ListFilesContinueError errorValue) {
        super(requestId, userMessage, buildMessage("list_received_files/continue", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
