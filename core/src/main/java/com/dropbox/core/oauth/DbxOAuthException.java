package com.dropbox.core.oauth;

import com.dropbox.core.DbxException;

/**
 *
 * This exception means OAuth endpoint has thrown error.
 */
public class DbxOAuthException extends DbxException {
    private static final long serialVersionUID = 0L;
    private final DbxOAuthError dbxOAuthError;

    public DbxOAuthException(String requestId, DbxOAuthError dbxOAuthError) {
        super(requestId, dbxOAuthError.getErrorDescription());
        this.dbxOAuthError = dbxOAuthError;
    }

    /**
     * Get the wrapped {@link DbxOAuthError} to tell what error has been thrown.
     * @return {@link DbxOAuthError} contains what error has been thrown.
     */
    public DbxOAuthError getDbxOAuthError() {
        return dbxOAuthError;
    }
}
