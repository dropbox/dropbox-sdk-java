/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * RelinquishFolderMembershipError} error.
 */
public class RelinquishFolderMembershipErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * DbxSharing#relinquishFolderMembership(String)}.
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
