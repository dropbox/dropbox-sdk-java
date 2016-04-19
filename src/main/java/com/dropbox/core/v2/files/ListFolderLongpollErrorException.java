/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * ListFolderLongpollError} error.
 */
public class ListFolderLongpollErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserFilesRequests#listFolderLongpoll(String)}.
     */
    public final ListFolderLongpollError errorValue;

    public ListFolderLongpollErrorException(String requestId, LocalizedText userMessage, ListFolderLongpollError errorValue) {
        super(requestId, userMessage, buildMessage("list_folder/longpoll", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
