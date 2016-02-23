/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * GetSharedLinkFileError} error.
 */
public class GetSharedLinkFileErrorException extends DbxApiException {

    /**
     * The error reported by {@link DbxSharing#getSharedLinkFile(String)}.
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
