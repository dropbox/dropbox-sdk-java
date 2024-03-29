/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link AddFolderMemberError}
 * error.
 *
 * <p> This exception is raised by {@link
 * DbxUserSharingRequests#addFolderMember(String,java.util.List)}. </p>
 */
public class AddFolderMemberErrorException extends DbxApiException {
    // exception for routes:
    //     2/sharing/add_folder_member

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#addFolderMember(String,java.util.List)}.
     */
    public final AddFolderMemberError errorValue;

    public AddFolderMemberErrorException(String routeName, String requestId, LocalizedText userMessage, AddFolderMemberError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
