/* DO NOT EDIT */
/* This file was generated from shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * GetSharedLinkFileError} error.
 */
public class GetSharedLinkFileErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#getSharedLinkFile(String)}.
     */
    public final GetSharedLinkFileError errorValue;

    public GetSharedLinkFileErrorException(String requestId, LocalizedText userMessage, GetSharedLinkFileError errorValue) {
        super(requestId, userMessage, buildMessage("get_shared_link_file", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
