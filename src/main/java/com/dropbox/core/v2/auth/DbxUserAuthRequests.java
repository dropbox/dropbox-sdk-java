/* DO NOT EDIT */
/* This file was generated from auth.stone */

package com.dropbox.core.v2.auth;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.Map;

/**
 * Routes in namespace "auth" that support user auth.
 */
public final class DbxUserAuthRequests {
    // namespace auth

    private final DbxRawClientV2 client;

    public DbxUserAuthRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route auth/token/revoke
    //

    /**
     * Disables the access token used to authenticate the call.
     */
    public void tokenRevoke() throws DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/auth/token/revoke",
                            null,
                            false,
                            com.dropbox.core.stone.StoneSerializers.void_(),
                            com.dropbox.core.stone.StoneSerializers.void_(),
                            com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"token/revoke\":" + ex.getErrorValue());
        }
    }
}
