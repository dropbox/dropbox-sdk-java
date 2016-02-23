/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * SharedFolderAccessError} error.
 */
public class SharedFolderAccessErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxSharing#listFolderMembers(String)}.
     */
    public final SharedFolderAccessError errorValue;

    public SharedFolderAccessErrorException(String requestId, LocalizedText userMessage, SharedFolderAccessError errorValue) {
        super(requestId, userMessage, buildMessage("list_folder_members", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
