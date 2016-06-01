/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link AddFolderMemberError}
 * error.
 */
public class AddFolderMemberErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#addFolderMember(String,java.util.List)}.
     */
    public final AddFolderMemberError errorValue;

    public AddFolderMemberErrorException(String requestId, LocalizedText userMessage, AddFolderMemberError errorValue) {
        super(requestId, userMessage, buildMessage("add_folder_member", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
