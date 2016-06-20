/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link ListFileMembersError}
 * error.
 */
public class ListFileMembersErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#listFileMembers(String)}.
     */
    public final ListFileMembersError errorValue;

    public ListFileMembersErrorException(String requestId, LocalizedText userMessage, ListFileMembersError errorValue) {
        super(requestId, userMessage, buildMessage("list_file_members", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
