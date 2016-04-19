package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.StringUtil;
import com.dropbox.core.v1.DbxClientV1;

import java.util.ArrayList;

/*>>> import checkers.nullness.quals.Nullable; */
/*>>> import checkers.nullness.quals.NonNull; */

abstract class DbxWebAuthHelper
{
    public static String getAuthorizeUrl(DbxAppInfo appInfo,
                                         /*@Nullable*/String userLocale,
                                         /*@Nullable*/String redirectUri,
                                         /*@Nullable*/String state)
    {
        return DbxRequestUtil.buildUrlWithParams(userLocale,
            appInfo.getHost().getWeb(), "1/oauth2/authorize", new String[] {
                "client_id", appInfo.getKey(),
                "response_type", "code",
                "redirect_uri", redirectUri,
                "state", state,
            });
    }

    public static DbxAuthFinish finish(DbxAppInfo appInfo,
                                       DbxRequestConfig requestConfig,
                                       String code,
                                       /*@Nullable*/String originalRedirectUri)
        throws DbxException
    {
        if (code == null) throw new IllegalArgumentException("'code' can't be null");

        /*@Nullable*/String[] params = {
            "grant_type", "authorization_code",
            "code", code,
            "redirect_uri", originalRedirectUri,
            "locale", requestConfig.getUserLocale(),
        };

        ArrayList<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        DbxRequestUtil.addBasicAuthHeader(headers, appInfo.getKey(), appInfo.getSecret());

        return DbxRequestUtil.doPostNoAuth(
            requestConfig,
            DbxClientV1.USER_AGENT_ID,
            appInfo.getHost().getApi(),
            "1/oauth2/token",
            params,
            headers,
            new DbxRequestUtil.ResponseHandler<DbxAuthFinish>() {
                @Override
                public DbxAuthFinish handle(HttpRequestor.Response response) throws DbxException
                {
                    if (response.getStatusCode() != 200) throw DbxRequestUtil.unexpectedStatus(response);
                    return DbxRequestUtil.readJsonFromResponse(DbxAuthFinish.Reader, response);
                }
            }
        );
    }
}
