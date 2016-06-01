/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link SharedLinkError}
 * error.
 */
public class SharedLinkErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#getSharedLinkMetadata(String)}.
     */
    public final SharedLinkError errorValue;

    public SharedLinkErrorException(String requestId, LocalizedText userMessage, SharedLinkError errorValue) {
        super(requestId, userMessage, buildMessage("get_shared_link_metadata", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
