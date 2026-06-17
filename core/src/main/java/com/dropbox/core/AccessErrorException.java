package com.dropbox.core;

import com.dropbox.core.v2.auth.AccessError;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Gets thrown when invalid access occurs.
 */
public class AccessErrorException extends DbxException {
    private static final long serialVersionUID = 0;

    private final @Nonnull AccessError accessError;

    public @Nonnull AccessError getAccessError() {
        return accessError;
    }

    public AccessErrorException(@Nullable String requestId,
                                @Nullable String message,
                                @Nonnull AccessError accessError) {
        super(requestId, message);
        this.accessError = accessError;
    }
}
