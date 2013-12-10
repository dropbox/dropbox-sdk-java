package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Lets you convert OAuth 1 access tokens to OAuth 2 access tokens. First call {@link
 * #createOAuth2AccessToken} to get an OAuth 2 access token.  If that succeeds, call {@link
 * #disableOAuth1AccessToken} to disable the OAuth 1 access token.
 */
public final class DbxOAuth1Upgrader
{
    private final DbxRequestConfig requestConfig;
    private final DbxAppInfo appInfo;

    /**
     * @param appInfo
     *     Your application's Dropbox API information (the app key and secret).
     */
    public DbxOAuth1Upgrader(DbxRequestConfig requestConfig, DbxAppInfo appInfo)
    {
        if (requestConfig == null) throw new IllegalArgumentException("'requestConfig' is null");
        if (appInfo == null) throw new IllegalArgumentException("'appInfo' is null");

        this.requestConfig = requestConfig;
        this.appInfo = appInfo;
    }

    /**
     * Given an existing active OAuth 1 access token, make a Dropbox API call to get a new OAuth 2
     * access token that represents the same user and app.
     */
    public String createOAuth2AccessToken(DbxOAuth1AccessToken token)
        throws DbxException
    {
        if (token == null) throw new IllegalArgumentException("'token' can't be null");
        return DbxRequestUtil.doPostNoAuth(
                requestConfig, appInfo.host.api, "1/oauth2/token_from_oauth1",
                null, getHeaders(token), new DbxRequestUtil.ResponseHandler<String>() {
            public String handle(HttpRequestor.Response response) throws DbxException {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return DbxRequestUtil.readJsonFromResponse(ResponseReader, response.body);
            }
        });
    }

    /**
     * Tell the Dropbox API server to disable an OAuth 1 access token.
     */
    public void disableOAuth1AccessToken(DbxOAuth1AccessToken token)
        throws DbxException
    {
        if (token == null) throw new IllegalArgumentException("'token' can't be null");
        DbxRequestUtil.doPostNoAuth(
                requestConfig, appInfo.host.api, "1/disable_access_token",
                null, getHeaders(token), new DbxRequestUtil.ResponseHandler<Void>() {
            public Void handle(HttpRequestor.Response response) throws DbxException {
                if (response.statusCode != 200) throw DbxRequestUtil.unexpectedStatus(response);
                return null;
            }
        });
    }

    private ArrayList<HttpRequestor.Header> getHeaders(DbxOAuth1AccessToken token)
    {
        ArrayList<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>(1);
        headers.add(new HttpRequestor.Header("Authorization", buildOAuth1Header(token)));
        return headers;
    }

    private String buildOAuth1Header(DbxOAuth1AccessToken token)
    {
        StringBuilder buf = new StringBuilder();
        buf.append("OAuth oauth_version=\"1.0\", oauth_signature_method=\"PLAINTEXT\"");
        buf.append(", oauth_consumer_key=\"").append(encode(this.appInfo.key)).append("\"");
        buf.append(", oauth_token=\"").append(encode(token.key)).append("\"");
        buf.append(", oauth_signature=\"").append(encode(this.appInfo.secret)).append("&").append(encode(token.secret)).append("\"");
        return buf.toString();
    }

    private static String encode(String s)
    {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            AssertionError ae = new AssertionError("UTF-8 isn't available");
            ae.initCause(ex);
            throw ae;
        }
    }

    /**
     * For JSON parsing.
     */
    public static final JsonReader<String> ResponseReader = new JsonReader<String>()
    {
        public String read(JsonParser parser) throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String accessToken = null;
            String tokenType = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                JsonReader.nextToken(parser);

                try {
                    if (fieldName.equals("token_type")) {
                        tokenType = DbxAuthFinish.BearerTokenTypeReader.readField(parser, fieldName, tokenType);
                    }
                    else if (fieldName.equals("access_token")) {
                        accessToken = DbxAuthFinish.AccessTokenReader.readField(parser, fieldName, accessToken);
                    }
                    else {
                        // Unknown field.  Skip over it.
                        JsonReader.skipValue(parser);
                    }
                }
                catch (JsonReadException ex) {
                    throw ex.addFieldContext(fieldName);
                }
            }

            JsonReader.expectObjectEnd(parser);

            if (tokenType == null) throw new JsonReadException("missing field \"token_type\"", top);
            if (accessToken == null) throw new JsonReadException("missing field \"access_token\"", top);

            return accessToken;
        }
    };
}
