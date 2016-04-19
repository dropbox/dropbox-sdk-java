/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * RemoveFolderMemberError} error.
 */
public class RemoveFolderMemberErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#removeFolderMember(String,MemberSelector,boolean)}.
     */
    public final RemoveFolderMemberError errorValue;

    public RemoveFolderMemberErrorException(String requestId, LocalizedText userMessage, RemoveFolderMemberError errorValue) {
        super(requestId, userMessage, buildMessage("remove_folder_member", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
