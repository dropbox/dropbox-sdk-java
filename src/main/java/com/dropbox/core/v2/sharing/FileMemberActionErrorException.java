/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * FileMemberActionError} error.
 */
public class FileMemberActionErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#changeFileMemberAccess(String,MemberSelector,AccessLevel)}.
     */
    public final FileMemberActionError errorValue;

    public FileMemberActionErrorException(String requestId, LocalizedText userMessage, FileMemberActionError errorValue) {
        super(requestId, userMessage, buildMessage("change_file_member_access", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
