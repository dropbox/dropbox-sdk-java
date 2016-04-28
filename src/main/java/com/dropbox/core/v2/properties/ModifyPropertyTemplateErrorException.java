/* DO NOT EDIT */
/* This file was generated from properties.babel */

package com.dropbox.core.v2.properties;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * ModifyPropertyTemplateError} error.
 */
public class ModifyPropertyTemplateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * com.dropbox.core.v2.team.DbxTeamTeamRequests#propertiesTemplateUpdate(String)}.
     */
    public final ModifyPropertyTemplateError errorValue;

    public ModifyPropertyTemplateErrorException(String requestId, LocalizedText userMessage, ModifyPropertyTemplateError errorValue) {
        super(requestId, userMessage, buildMessage("properties/template/update", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
