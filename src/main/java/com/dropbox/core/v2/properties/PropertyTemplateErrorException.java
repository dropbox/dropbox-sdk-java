/* DO NOT EDIT */
/* This file was generated from properties.babel */

package com.dropbox.core.v2.properties;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * PropertyTemplateError} error.
 */
public class PropertyTemplateErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * com.dropbox.core.v2.team.DbxTeamTeamRequests#propertiesTemplateList()}.
     */
    public final PropertyTemplateError errorValue;

    public PropertyTemplateErrorException(String requestId, LocalizedText userMessage, PropertyTemplateError errorValue) {
        super(requestId, userMessage, buildMessage("properties/template/list", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
