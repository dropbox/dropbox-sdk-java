package com.dropbox.core;

import java.io.IOException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The base exception thrown by Dropbox API calls.  Normally, you'll need to do something specific
 * for {@link InvalidAccessTokenException} and possibly for {@link RetryException}.  The rest you
 * should probably just log and investigate manually.
 */
public class DbxException extends Exception {
    private static final long serialVersionUID = 0L;

    private final @Nullable String requestId;

    public DbxException(@Nullable String message) {
        this(null, message);
    }

    public DbxException(@Nullable String requestId, @Nullable String message) {
        super(message);
        this.requestId = requestId;
    }

    public DbxException(@Nullable String message, @Nonnull Throwable cause) {
        this(null, message, cause);
    }

    public DbxException(@Nullable String requestId, @Nullable String message, @Nonnull Throwable cause) {
        super(message, cause);
        this.requestId = requestId;
    }

    /**
     * Return the unique ID associated with the request that triggered this exception.
     *
     * <p> The ID may be {@code null} if we could not receive a response from the Dropbox servers
     * (e.g. from a {@link NetworkIOException}).
     *
     * <p> Please use this ID when filing bug reports.
     *
     * @return unique ID associated with the request that caused this exception, or {@code null} if
     * one is not available.
     */
    public @Nullable String getRequestId() {
        return requestId;
    }
}
