package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.StringUtil;

import java.util.ArrayList;

abstract class DbxWebAuthHelper
{
    public static String getAuthorizeUrl(DbxAppInfo appInfo, String userLocale,
                                         String redirectUri, String state)
    {
        return DbxRequestUtil.buildUrlWithParams(userLocale,
            appInfo.host.web, "1/oauth2/authorize", new String[] {
                "client_id", appInfo.key,
                "response_type", "code",
                "redirect_uri", redirectUri,
                "state", state,
            });
    }

    public static DbxAuthFinish finish(DbxAppInfo appInfo, DbxRequestConfig requestConfig,
                                       String code, String originalRedirectUri)
            throws DbxException
    {
        if (code == null) throw new IllegalArgumentException("'code' can't be null");

        String[] params = {
            "grant_type", "authorization_code",
            "code", code,
            "redirect_uri", originalRedirectUri,
            "locale", requestConfig.userLocale,
        };

        ArrayList<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        String credentials = appInfo.key + ":" + appInfo.secret;
        String base64Credentials = StringUtil.base64Encode(StringUtil.stringToUtf8(credentials));
        headers.add(new HttpRequestor.Header("Authorization", "Basic " + base64Credentials));

        return DbxRequestUtil.doPostNoAuth(requestConfig, appInfo.host.api, "1/oauth2/token",
                                           params, headers, new DbxRequestUtil.ResponseHandler<DbxAuthFinish>()
        {
            @Override
            public DbxAuthFinish handle(HttpRequestor.Response response) throws DbxException
            {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.readJsonFromResponse(DbxAuthFinish.Reader, response.body);
            }
        });
    }
}
