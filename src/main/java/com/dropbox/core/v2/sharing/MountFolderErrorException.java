/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link MountFolderError}
 * error.
 */
public class MountFolderErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserSharingRequests#mountFolder(String)}.
     */
    public final MountFolderError errorValue;

    public MountFolderErrorException(String requestId, LocalizedText userMessage, MountFolderError errorValue) {
        super(requestId, userMessage, buildMessage("mount_folder", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
