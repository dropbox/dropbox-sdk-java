/* DO NOT EDIT */
/* This file was generated from auth.stone */

package com.dropbox.core.v2.auth;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.Map;

/**
 * Routes in namespace "auth".
 */
public class DbxAppAuthRequests {
    // namespace auth (auth.stone)

    private final DbxRawClientV2 client;

    public DbxAppAuthRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/auth/token/from_oauth1
    //

    /**
     * Creates an OAuth 2.0 access token from the supplied OAuth 1.0 access
     * token.
     *
     */
    TokenFromOAuth1Result tokenFromOauth1(TokenFromOAuth1Arg arg) throws TokenFromOAuth1ErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/auth/token/from_oauth1",
                                        arg,
                                        false,
                                        TokenFromOAuth1Arg.Serializer.INSTANCE,
                                        TokenFromOAuth1Result.Serializer.INSTANCE,
                                        TokenFromOAuth1Error.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TokenFromOAuth1ErrorException("2/auth/token/from_oauth1", ex.getRequestId(), ex.getUserMessage(), (TokenFromOAuth1Error) ex.getErrorValue());
        }
    }

    /**
     * Creates an OAuth 2.0 access token from the supplied OAuth 1.0 access
     * token.
     *
     * @param oauth1Token  The supplied OAuth 1.0 access token. Must have length
     *     of at least 1 and not be {@code null}.
     * @param oauth1TokenSecret  The token secret associated with the supplied
     *     access token. Must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TokenFromOAuth1Result tokenFromOauth1(String oauth1Token, String oauth1TokenSecret) throws TokenFromOAuth1ErrorException, DbxException {
        TokenFromOAuth1Arg _arg = new TokenFromOAuth1Arg(oauth1Token, oauth1TokenSecret);
        return tokenFromOauth1(_arg);
    }
}
