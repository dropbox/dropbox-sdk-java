/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link ShareFolderError}
 * error.
 */
public class ShareFolderErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserSharingRequests#shareFolder(String)}.
     */
    public final ShareFolderError errorValue;

    public ShareFolderErrorException(String requestId, LocalizedText userMessage, ShareFolderError errorValue) {
        super(requestId, userMessage, buildMessage("share_folder", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
