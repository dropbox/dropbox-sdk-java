/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GetSharedLinksError}
 * error.
 */
public class GetSharedLinksErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserSharingRequests#getSharedLinks()}.
     */
    public final GetSharedLinksError errorValue;

    public GetSharedLinksErrorException(String requestId, LocalizedText userMessage, GetSharedLinksError errorValue) {
        super(requestId, userMessage, buildMessage("get_shared_links", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
