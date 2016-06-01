/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * RelinquishFolderMembershipError} error.
 */
public class RelinquishFolderMembershipErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#relinquishFolderMembership(String)}.
     */
    public final RelinquishFolderMembershipError errorValue;

    public RelinquishFolderMembershipErrorException(String requestId, LocalizedText userMessage, RelinquishFolderMembershipError errorValue) {
        super(requestId, userMessage, buildMessage("relinquish_folder_membership", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
