/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link AddFileMemberError}
 * error.
 */
public class AddFileMemberErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#addFileMember(String,java.util.List)}.
     */
    public final AddFileMemberError errorValue;

    public AddFileMemberErrorException(String requestId, LocalizedText userMessage, AddFileMemberError errorValue) {
        super(requestId, userMessage, buildMessage("add_file_member", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
