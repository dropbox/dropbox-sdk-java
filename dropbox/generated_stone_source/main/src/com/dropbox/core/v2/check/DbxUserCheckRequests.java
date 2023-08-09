/* DO NOT EDIT */
/* This file was generated from check_api_v2_types.stone, check_api_v2_service.stone */

package com.dropbox.core.v2.check;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.Map;

/**
 * Routes in namespace "check".
 */
public class DbxUserCheckRequests {
    // namespace check (check_api_v2_types.stone, check_api_v2_service.stone)

    private final DbxRawClientV2 client;

    public DbxUserCheckRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/check/user
    //

    /**
     * This endpoint performs User Authentication, validating the supplied
     * access token, and returns the supplied string, to allow you to test your
     * code and connection to the Dropbox API. It has no other effect. If you
     * receive an HTTP 200 response with the supplied query, it indicates at
     * least part of the Dropbox API infrastructure is working and that the
     * access token is valid.
     *
     * @param arg  EchoArg contains the arguments to be sent to the Dropbox
     *     servers.
     *
     * @return EchoResult contains the result returned from the Dropbox servers.
     */
    EchoResult user(EchoArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/check/user",
                                        arg,
                                        false,
                                        EchoArg.Serializer.INSTANCE,
                                        EchoResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"user\":" + ex.getErrorValue());
        }
    }

    /**
     * This endpoint performs User Authentication, validating the supplied
     * access token, and returns the supplied string, to allow you to test your
     * code and connection to the Dropbox API. It has no other effect. If you
     * receive an HTTP 200 response with the supplied query, it indicates at
     * least part of the Dropbox API infrastructure is working and that the
     * access token is valid.
     *
     * <p> The {@code query} request parameter will default to {@code ""} (see
     * {@link #user(String)}). </p>
     *
     * @return EchoResult contains the result returned from the Dropbox servers.
     */
    public EchoResult user() throws DbxApiException, DbxException {
        EchoArg _arg = new EchoArg();
        return user(_arg);
    }

    /**
     * This endpoint performs User Authentication, validating the supplied
     * access token, and returns the supplied string, to allow you to test your
     * code and connection to the Dropbox API. It has no other effect. If you
     * receive an HTTP 200 response with the supplied query, it indicates at
     * least part of the Dropbox API infrastructure is working and that the
     * access token is valid.
     *
     * @param query  The string that you'd like to be echoed back to you. Must
     *     have length of at most 500 and not be {@code null}.
     *
     * @return EchoResult contains the result returned from the Dropbox servers.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public EchoResult user(String query) throws DbxApiException, DbxException {
        if (query == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        if (query.length() > 500) {
            throw new IllegalArgumentException("String 'query' is longer than 500");
        }
        EchoArg _arg = new EchoArg(query);
        return user(_arg);
    }
}
