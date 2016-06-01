/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link ListSharedLinksError}
 * error.
 */
public class ListSharedLinksErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserSharingRequests#listSharedLinks()}.
     */
    public final ListSharedLinksError errorValue;

    public ListSharedLinksErrorException(String requestId, LocalizedText userMessage, ListSharedLinksError errorValue) {
        super(requestId, userMessage, buildMessage("list_shared_links", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
