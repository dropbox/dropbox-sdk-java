/* DO NOT EDIT */
/* This file was generated from auth.babel */

package com.dropbox.core.v2.auth;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.v2.DbxRawClientV2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;

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
                            JsonUtil.createType(Void.class),
                            JsonUtil.createType(Void.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DbxApiException(ew.getRequestId(), ew.getUserMessage(), "Unexpected error response for \"token/revoke\": ew.errValue");
        }
    }
}
