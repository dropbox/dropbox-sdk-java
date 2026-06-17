package com.dropbox.core.oauth;

import com.dropbox.core.DbxException;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *
 * This exception means OAuth endpoint has thrown error.
 */
public class DbxOAuthException extends DbxException {
    private static final long serialVersionUID = 0L;
    private final @Nonnull DbxOAuthError dbxOAuthError;

    public DbxOAuthException(@Nullable String requestId, @Nonnull DbxOAuthError dbxOAuthError) {
        super(requestId, dbxOAuthError.getErrorDescription());
        this.dbxOAuthError = dbxOAuthError;
    }

    /**
     * Get the wrapped {@link DbxOAuthError} to tell what error has been thrown.
     * @return {@link DbxOAuthError} contains what error has been thrown.
     */
    public @Nonnull DbxOAuthError getDbxOAuthError() {
        return dbxOAuthError;
    }
}
