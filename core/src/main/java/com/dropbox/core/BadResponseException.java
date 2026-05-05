package com.dropbox.core;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Thrown when we the response from the Dropbox server isn't something we expect.
 * For example, if the JSON returned by the server is malformed or missing fields.
 */
public class BadResponseException extends ProtocolException {
    private static final long serialVersionUID = 0;

    public BadResponseException(@Nullable String requestId, @Nullable String message) {
        super(requestId, message);
    }

    public BadResponseException(@Nullable String requestId, @Nullable String message, @Nonnull Throwable cause) {
        super(requestId, message, cause);
    }
}
