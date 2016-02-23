/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * ModifySharedLinkSettingsError} error.
 */
public class ModifySharedLinkSettingsErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * DbxSharing#modifySharedLinkSettings(String,SharedLinkSettings)}.
     */
    public final ModifySharedLinkSettingsError errorValue;

    public ModifySharedLinkSettingsErrorException(String requestId, LocalizedText userMessage, ModifySharedLinkSettingsError errorValue) {
        super(requestId, userMessage, buildMessage("modify_shared_link_settings", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
