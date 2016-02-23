/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * RevokeSharedLinkError} error.
 */
public class RevokeSharedLinkErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxSharing#revokeSharedLink(String)}.
     */
    public final RevokeSharedLinkError errorValue;

    public RevokeSharedLinkErrorException(String requestId, LocalizedText userMessage, RevokeSharedLinkError errorValue) {
        super(requestId, userMessage, buildMessage("revoke_shared_link", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
