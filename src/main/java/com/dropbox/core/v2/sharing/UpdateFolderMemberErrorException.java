/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * UpdateFolderMemberError} error.
 */
public class UpdateFolderMemberErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * DbxSharing#updateFolderMember(String,MemberSelector,AccessLevel)}.
     */
    public final UpdateFolderMemberError errorValue;

    public UpdateFolderMemberErrorException(String requestId, LocalizedText userMessage, UpdateFolderMemberError errorValue) {
        super(requestId, userMessage, buildMessage("update_folder_member", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
