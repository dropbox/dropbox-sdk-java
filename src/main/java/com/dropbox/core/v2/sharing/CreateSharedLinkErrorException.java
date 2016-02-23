/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * CreateSharedLinkError} error.
 */
public class CreateSharedLinkErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxSharing#createSharedLink(String)}.
     */
    public final CreateSharedLinkError errorValue;

    public CreateSharedLinkErrorException(String requestId, LocalizedText userMessage, CreateSharedLinkError errorValue) {
        super(requestId, userMessage, buildMessage("create_shared_link", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
