/* DO NOT EDIT */
/* This file was generated from openid_openid_types.stone, openid_openid.stone */

package com.dropbox.core.v2.openid;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.Map;

/**
 * Routes in namespace "openid".
 */
public class DbxUserOpenidRequests {
    // namespace openid (openid_openid_types.stone, openid_openid.stone)

    private final DbxRawClientV2 client;

    public DbxUserOpenidRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/openid/userinfo
    //

    /**
     * This route is used for refreshing the info that is found in the id_token
     * during the OIDC flow. This route doesn't require any arguments and will
     * use the scopes approved for the given access token.
     *
     * @param arg  No Parameters
     */
    UserInfoResult userinfo(UserInfoArgs arg) throws UserInfoErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/openid/userinfo",
                                        arg,
                                        false,
                                        UserInfoArgs.Serializer.INSTANCE,
                                        UserInfoResult.Serializer.INSTANCE,
                                        UserInfoError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new UserInfoErrorException("2/openid/userinfo", ex.getRequestId(), ex.getUserMessage(), (UserInfoError) ex.getErrorValue());
        }
    }

    /**
     * This route is used for refreshing the info that is found in the id_token
     * during the OIDC flow. This route doesn't require any arguments and will
     * use the scopes approved for the given access token.
     */
    public UserInfoResult userinfo() throws UserInfoErrorException, DbxException {
        UserInfoArgs _arg = new UserInfoArgs();
        return userinfo(_arg);
    }
}
