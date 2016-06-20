/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * RemoveFileMemberError} error.
 */
public class RemoveFileMemberErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
     */
    public final RemoveFileMemberError errorValue;

    public RemoveFileMemberErrorException(String requestId, LocalizedText userMessage, RemoveFileMemberError errorValue) {
        super(requestId, userMessage, buildMessage("remove_file_member_2", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
