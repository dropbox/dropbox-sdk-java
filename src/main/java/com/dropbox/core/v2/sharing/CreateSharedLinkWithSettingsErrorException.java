/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * CreateSharedLinkWithSettingsError} error.
 */
public class CreateSharedLinkWithSettingsErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserSharingRequests#createSharedLinkWithSettings(String)}.
     */
    public final CreateSharedLinkWithSettingsError errorValue;

    public CreateSharedLinkWithSettingsErrorException(String requestId, LocalizedText userMessage, CreateSharedLinkWithSettingsError errorValue) {
        super(requestId, userMessage, buildMessage("create_shared_link_with_settings", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
