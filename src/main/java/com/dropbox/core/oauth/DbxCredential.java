package com.dropbox.core.oauth;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.v2.DbxRawClientV2;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbxCredential {
    private final long EXPIRE_MARGIN = 5 * 60 * 1000; // 5 minutes

    private String accessToken;
    private Long expiresAt;
    private final String refreshToken;
    private final String appKey;
    private final String appSecret;

    public DbxCredential(String accessToken) {
        this(accessToken, null, null, null, null);
    }

    public DbxCredential(String accessToken, Long expiresAt, String refreshToken, String appKey) {
        this(accessToken, expiresAt, refreshToken, appKey, null);
    }

    public DbxCredential(String accessToken, Long expiresAt, String refreshToken, String appKey, String appSecret) {
        if (refreshToken != null && appKey == null) {
            throw new NullPointerException("Can't refresh without app Key");
        }

        if (accessToken == null) {
            throw new NullPointerException("access token");
        }

        this.accessToken = accessToken;
        this.expiresAt = expiresAt;
        this.refreshToken = refreshToken;
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Long getExpiresAt() {
        return this.expiresAt;
    }

    String getAppKey() {
        return this.appKey;
    }

    String getAppSecret() {
        return this.appSecret;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public boolean needRefresh() {
        if (this.getRefreshToken() == null) {
            return false;
        }

        return this.aboutToExpire();
    }

    private boolean aboutToExpire() {
        if (this.getExpiresAt() == null) {
            return true;
        }

        return System.currentTimeMillis() + EXPIRE_MARGIN > this.getExpiresAt();
    }

    public DbxRefreshResult refresh(DbxRequestConfig requestConfig, DbxHost host) throws DbxException {
        if (this.refreshToken == null) {
            throw new NullPointerException("Cannot refresh becasue there is no refresh token");
        }

        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "refresh_token");
        params.put("refresh_token", refreshToken);
        params.put("locale", requestConfig.getUserLocale());


        List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        if (this.appSecret == null) {
            //PKCE flow
            params.put("client_id", this.appKey);
        } else {
            DbxRequestUtil.addBasicAuthHeader(headers, this.appKey, this.appSecret);
        }

        DbxRefreshResult dbxRefreshResult = DbxRequestUtil.doPostNoAuth(
            requestConfig,
            DbxRawClientV2.USER_AGENT_ID,
            host.getApi(),
            "oauth2/token",
            DbxRequestUtil.toParamsArray(params),
            headers,
            new DbxRequestUtil.ResponseHandler<DbxRefreshResult>() {
                @Override
                public DbxRefreshResult handle(HttpRequestor.Response response) throws DbxException {
                    if (response.getStatusCode() != 200) {
                        String requestId = DbxRequestUtil.getRequestId(response);
                        DbxOAuthError dbxOAuthError = DbxRequestUtil.readJsonFromResponse(
                            DbxOAuthError.Reader, response
                        );
                        throw new DbxOAuthException(requestId, dbxOAuthError);
                    }
                    return DbxRequestUtil.readJsonFromResponse(DbxRefreshResult.Reader, response);
                }
            }
        );

        this.accessToken = dbxRefreshResult.getAccessToken();
        this.expiresAt = dbxRefreshResult.getExpiresAt();
        return dbxRefreshResult;
    }

    synchronized public DbxRefreshResult refresh(DbxRequestConfig requestConfig) throws DbxException {
        return refresh(requestConfig, DbxHost.DEFAULT);
    }

    public static final JsonReader<DbxCredential> Reader = new JsonReader<DbxCredential>()
    {
        @Override
        public final DbxCredential read(JsonParser parser)
            throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String accessToken = null;
            Long expiresAt = null;
            String refreshToken = null;
            String appKey = null;
            String appSecret = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();

                try {
                    if (fieldName.equals("access_token")) {
                        accessToken = StringReader.readField(parser, fieldName, accessToken);
                    }
                    else if (fieldName.equals("expires_at")) {
                        expiresAt = Int64Reader.readField(parser, fieldName, expiresAt);
                    }
                    else if (fieldName.equals("refresh_token")) {
                        refreshToken = StringReader.readField(parser, fieldName, refreshToken);
                    }
                    else if (fieldName.equals("app_key")) {
                        appKey = StringReader.readField(parser, fieldName, appKey);
                    }
                    else if (fieldName.equals("app_secret")) {
                        appSecret = StringReader.readField(parser, fieldName, appSecret);
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

            if (accessToken == null) throw new JsonReadException("missing field \"access_token\"", top);

            return new DbxCredential(accessToken, expiresAt, refreshToken, appKey, appSecret);
        }
    };

    public static final JsonWriter<DbxCredential> Writer = new JsonWriter<DbxCredential>()
    {
        @Override
        public void write(DbxCredential credential, JsonGenerator g) throws IOException
        {
            g.writeStartObject();
            g.writeStringField("access_token", credential.accessToken);
            if (credential.expiresAt != null) {
                g.writeNumberField("expires_at", credential.expiresAt);
            }
            if (credential.refreshToken != null) {
                g.writeStringField("refresh_token", credential.refreshToken);
            }
            if (credential.appKey != null) {
                g.writeStringField("app_key", credential.appKey);
            }
            if (credential.appSecret != null) {
                g.writeStringField("app_secret", credential.appSecret);
            }
            g.writeEndObject();
        }
    };
}
