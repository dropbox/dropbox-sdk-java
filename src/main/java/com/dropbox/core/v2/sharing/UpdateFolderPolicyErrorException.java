/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * UpdateFolderPolicyError} error.
 */
public class UpdateFolderPolicyErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#updateFolderPolicy(String)}.
     */
    public final UpdateFolderPolicyError errorValue;

    public UpdateFolderPolicyErrorException(String requestId, LocalizedText userMessage, UpdateFolderPolicyError errorValue) {
        super(requestId, userMessage, buildMessage("update_folder_policy", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
