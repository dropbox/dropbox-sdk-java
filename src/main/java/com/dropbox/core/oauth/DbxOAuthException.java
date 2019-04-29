package com.dropbox.core.oauth;

import com.dropbox.core.DbxException;

public class DbxOAuthException extends DbxException {
    private static final long serialVersionUID = 0L;
    private final DbxOAuthError dbxOAuthError;

    public DbxOAuthException(String requestId, DbxOAuthError dbxOAuthError) {
        super(requestId, dbxOAuthError.getErrorDescription());
        this.dbxOAuthError = dbxOAuthError;
    }

    public DbxOAuthError getDbxOAuthError() {
        return dbxOAuthError;
    }
}
