/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * FileMemberActionError} error.
 *
 * <p> This exception is raised by {@link
 * DbxUserSharingRequests#changeFileMemberAccess(String,MemberSelector,AccessLevel)}
 * and {@link
 * DbxUserSharingRequests#updateFileMember(String,MemberSelector,AccessLevel)}.
 * </p>
 */
public class FileMemberActionErrorException extends DbxApiException {
    // exception for routes:
    //     2/sharing/change_file_member_access
    //     2/sharing/update_file_member

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#changeFileMemberAccess(String,MemberSelector,AccessLevel)}
     * and {@link
     * DbxUserSharingRequests#updateFileMember(String,MemberSelector,AccessLevel)}.
     */
    public final FileMemberActionError errorValue;

    public FileMemberActionErrorException(String routeName, String requestId, LocalizedText userMessage, FileMemberActionError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
