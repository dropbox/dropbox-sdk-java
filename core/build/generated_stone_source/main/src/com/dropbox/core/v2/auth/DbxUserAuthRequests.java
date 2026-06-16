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
 * Routes in namespace "auth".
 */
public class DbxUserAuthRequests {
    // namespace auth (auth.stone)

    private final DbxRawClientV2 client;

    public DbxUserAuthRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/auth/token/revoke
    //

    /**
     * Disables the access token used to authenticate the call. If there is a
     * corresponding refresh token for the access token, this disables that
     * refresh token, as well as any other access tokens for that refresh token.
     */
    public void tokenRevoke() throws DbxApiException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
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
