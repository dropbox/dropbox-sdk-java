package com.dropbox.core;

import com.dropbox.core.v2.auth.AccessError;

/**
 * Gets thrown when invalid access occurs.
 */
public class AccessErrorException extends DbxException {
    private static final long serialVersionUID = 0;

    private final AccessError accessError;

    public AccessError getAccessError() {
        return accessError;
    }

    public AccessErrorException(String requestId, String message, AccessError accessError) {
        super(requestId, message);
        this.accessError = accessError;
    }
}
