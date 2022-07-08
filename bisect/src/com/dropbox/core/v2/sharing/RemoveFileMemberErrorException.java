/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * RemoveFileMemberError} error.
 *
 * <p> This exception is raised by {@link
 * DbxUserSharingRequests#removeFileMember(String,MemberSelector)} and {@link
 * DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}. </p>
 */
public class RemoveFileMemberErrorException extends DbxApiException {
    // exception for routes:
    //     2/sharing/remove_file_member
    //     2/sharing/remove_file_member_2

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#removeFileMember(String,MemberSelector)} and
     * {@link DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
     */
    public final RemoveFileMemberError errorValue;

    public RemoveFileMemberErrorException(String routeName, String requestId, LocalizedText userMessage, RemoveFileMemberError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
