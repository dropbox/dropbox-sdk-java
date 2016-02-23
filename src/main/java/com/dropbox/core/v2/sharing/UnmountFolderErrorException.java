/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link UnmountFolderError}
 * error.
 */
public class UnmountFolderErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxSharing#unmountFolder(String)}.
     */
    public final UnmountFolderError errorValue;

    public UnmountFolderErrorException(String requestId, LocalizedText userMessage, UnmountFolderError errorValue) {
        super(requestId, userMessage, buildMessage("unmount_folder", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
