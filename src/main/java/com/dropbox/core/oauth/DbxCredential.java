package com.dropbox.core.oauth;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.util.StringUtil;
import com.dropbox.core.v2.DbxRawClientV2;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.dropbox.core.oauth.DbxOAuthError.INVALID_REQUEST;

/*>>> import checkers.nullness.quals.NonNull; */
/*>>> import checkers.nullness.quals.Nullable; */

/**
 *
 *
 * Use this class to store the OAuth2 result. It wraps the access token, refresh token, token
 * expiration time as well app key and app secret, which is used for refreshing call. The object
 * can be serialized to or deserialized from persistent storage.
 *
 * {@link com.dropbox.core.v2.DbxClientV2} and {@link com.dropbox.core.v2.DbxTeamClientV2} use
 * this class to construct clients supporting short-live token and refresh token.
 */
public class DbxCredential {
    /**
     * The margin that we think access token is "about to" expire. Within this margin, dropbox
     * client would think the token is already expired and automatically refresh if possible.
     */
    public final static long EXPIRE_MARGIN = 5 * 60 * 1000; // 5 minutes

    private String accessToken;
    private /*@Nullable*/Long expiresAt;
    private final String refreshToken;
    private final String appKey;
    private final String appSecret;

    /**
     * Create a DbxCredential object that doesn't support refreshing.
     *
     * @param accessToken Short live token or legacty long live token.
     */
    public DbxCredential(String accessToken) {
        this(accessToken, null, null, null, null);
    }

    /**
     * Create a DbxCredential object if your app uses PKCE. PKCE flow doesn't requrie app secret.
     * @see com.dropbox.core.DbxPKCEWebAuth to learn what is PKCE.
     *
     * @param accessToken Short-lived access token from OAuth flow.
     * @param expiresAt Expiration time in millisecond from OAuth flow.
     * @param refreshToken Refresh token from OAuth flow.
     * @param appKey You app's client id.
     */
    public DbxCredential(String accessToken, /*Nullable*/Long expiresAt, String refreshToken, String
        appKey) {
        this(accessToken, expiresAt, refreshToken, appKey, null);
    }

    /**
     * Create a DbxCredential object supporting refreshing short live tokens.
     *
     * @param accessToken Short-lived access token from OAuth flow.
     * @param expiresAt Expiration time in millisecond from OAuth flow.
     * @param refreshToken Refresh token from OAuth flow
     * @param appKey You app's client id.
     * @param appSecret You app's client secret.
     */
    public DbxCredential(String accessToken, /*@Nullable*/Long expiresAt, String refreshToken, String appKey, String appSecret) {
        if (accessToken == null) {
            throw new IllegalArgumentException("Missing access token.");
        }

        if (refreshToken != null && appKey == null) {
            throw new IllegalArgumentException("Can't refresh without app Key.");
        }

        if (refreshToken != null && expiresAt == null) {
            throw new IllegalArgumentException("Missing expireAt.");
        }

        this.accessToken = accessToken;
        this.expiresAt = expiresAt;
        this.refreshToken = refreshToken;
        this.appKey = appKey;
        this.appSecret = appSecret;
    }

    /**
     * Returns the OAuth access token to use for authorization with Dropbox servers.
     *
     * @return OAuth access token
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     *
     * Return the millisecond when accessToken is going to expire.
     *
     * @return ExpiresAt in millisecond.
     */
    public Long getExpiresAt() {
        return this.expiresAt;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    /**
     *
     * Return the refresh token which can be used to obtain new access token.
     *
     * @return Refresh Token.
     */
    public String getRefreshToken() {
        return this.refreshToken;
    }

    /**
     * @return true if access token is already expired or current time is within the \{@value
     * EXPIRE_MARGIN} to expiration time.
     */
    public boolean aboutToExpire() {
        if (this.getExpiresAt() == null) {
            return false;
        }

        return System.currentTimeMillis() + EXPIRE_MARGIN > this.getExpiresAt();
    }

    /**
     * This should be used only in internal testing. Same as {@link #refresh(DbxRequestConfig)}
     * but just add host.
     * @param requestConfig request config used to make http request.
     * @param host which host to call, only used in internal testing.
     * @param scope space-delimited scope list. Must be subset of scope in current oauth2 grant.
     * @return DbxRefreshResult which contains app key and app secret.
     * @throws DbxOAuthException If refresh failed becasue of invalid refresh parameter or
     * refresh token is revoked.
     * @throws DbxException If refresh failed for general errors.
     */
    public DbxRefreshResult refresh(DbxRequestConfig requestConfig, DbxHost host,
                                    Collection<String> scope)
        throws DbxException {
        if (this.refreshToken == null) {
            throw new DbxOAuthException(null, new DbxOAuthError(INVALID_REQUEST, "Cannot refresh becasue there is no refresh token"));
        }

        if (this.appKey == null) {
            throw new IllegalStateException("DbxCredential's constructor should always guarantee " +
                "appKey is not null if refreshToken is not null.");
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

        if (scope != null) {
            String scopeString = StringUtil.join(scope, " ");
            params.put("scope", scopeString);
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

        synchronized (this) {
            this.accessToken = dbxRefreshResult.getAccessToken();
            this.expiresAt = dbxRefreshResult.getExpiresAt();
        }
        return dbxRefreshResult;
    }

    /**
     * Refresh the short live access token. If succeeds, the access token and expiration time
     * value inside this object will be overwritten to new values.
     *
     * @param requestConfig request config used to make http request.
     * @return DbxRefreshResult which contains app key and app secret.
     * @throws DbxOAuthException If refresh failed because of invalid refresh parameter or
     * refresh token is invalid or revoked.
     * @throws DbxException If refresh failed for general errors.
     */
    public DbxRefreshResult refresh(DbxRequestConfig requestConfig) throws DbxException {
        return refresh(requestConfig, DbxHost.DEFAULT, null);
    }

    /**
     * Refresh the short live access token. If succeeds, the access token and expiration time
     * value inside this object will be overwritten to new values.
     *
     * @param requestConfig request config used to make http request.
     * @param scope Must be a subset of original scopes requested with this OAuth2 grant. You can
     *             use this method to obtain a new short lived token with less access than the
     *              original one.
     * @return DbxRefreshResult which contains app key and app secret.
     * @throws DbxOAuthException If refresh failed because of invalid refresh parameter or
     * refresh token is invalid or revoked.
     * @throws DbxException If refresh failed for general errors.
     */
    public DbxRefreshResult refresh(DbxRequestConfig requestConfig, Collection<String> scope) throws
        DbxException {
        return refresh(requestConfig, DbxHost.DEFAULT, scope);
    }

    /**
     * @return The json string containing all fields.
     */
    @Override
    public String toString() {
        return Writer.writeToString(this);
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
