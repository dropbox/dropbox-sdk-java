package com.dropbox.core.oauth;

import com.dropbox.core.DbxException;

/**
 * <b>Beta</b>: This feature is not available to all developers. Please do NOT use it unless you are
 * early access partner of this feature. The function signature is subject to change
 * in next minor version release.
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
