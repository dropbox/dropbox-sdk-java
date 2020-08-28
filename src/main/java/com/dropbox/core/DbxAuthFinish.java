package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

import static com.dropbox.core.util.StringUtil.jq;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * When you successfully complete the authorization process, the Dropbox server returns
 * this information to you.
 */
public final class DbxAuthFinish {
    private final String accessToken;
    private final Long expiresIn;
    private final String refreshToken;
    private final String userId;
    private final String accountId;
    private final String teamId;
    private final /*@Nullable*/String urlState;
    private long issueTime;
    private final String scope;

    /**
     * @param accessToken OAuth access token
     * @param userId Dropbox user ID of user that approved access to this app
     * @param urlState State data passed in to {@link DbxWebAuth#start} or {@code null} if no state
     * was passed
     */
    @Deprecated
    public DbxAuthFinish(String accessToken, String userId, String accountId, String teamId, /*@Nullable*/String urlState) {
        this(accessToken, null, null, userId, teamId, accountId, urlState);
    }

    /**
     *
     *
     *
     * @param accessToken OAuth access token.
     * @param expiresIn Duration time of accessToken in second.
     * @param refreshToken A token used to obtain new accessToken.
     * @param userId Dropbox user ID of user that authorized this app.
     * @param teamId Dropbox team ID of team that authorized this app.
     * @param accountId Obfusticated user or team id. Keep it safe.
     * @param urlState State data passed in to {@link DbxWebAuth#start} or {@code null} if no state
     * was passed
     */
    public DbxAuthFinish(String accessToken, Long expiresIn, String refreshToken, String userId,
                         String teamId, String accountId, /*@Nullable*/String urlState) {
        this(accessToken, expiresIn, refreshToken, userId, teamId, accountId, urlState, null);
    }

    /**
     *
     *
     *
     * @param accessToken OAuth access token.
     * @param expiresIn Duration time of accessToken in second.
     * @param refreshToken A token used to obtain new accessToken.
     * @param userId Dropbox user ID of user that authorized this app.
     * @param teamId Dropbox team ID of team that authorized this app.
     * @param accountId Obfusticated user or team id. Keep it safe.
     * @param urlState State data passed in to {@link DbxWebAuth#start} or {@code null} if no state
     * was passed
     * @param scope A list of scope returned by Dropbox server. Each scope correspond to a group of
     * API endpoints. To call one API endpoint you have to obtains the scope first otherwise you
     * will get HTTP 401.
     */
    public DbxAuthFinish(String accessToken, Long expiresIn, String refreshToken, String userId,
                         String teamId, String accountId, /*@Nullable*/String urlState, String
                             scope) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
        this.userId = userId;
        this.accountId = accountId;
        this.teamId = teamId;
        this.urlState = urlState;
        this.issueTime = System.currentTimeMillis();
        this.scope = scope;
    }

    /**
     * Returns an <em>access token</em> that can be used to make Dropbox API calls.  Pass this in to
     * the {@link com.dropbox.core.v2.DbxClientV2} constructor.
     *
     * @return OAuth access token used for authorization with Dropbox servers
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     *
     *
     *
     * Returns the time when {@link DbxAuthFinish#accessToken} expires in millisecond. If null then
     * it won't expire. Pass this in to the {@link com.dropbox.core.v2.DbxClientV2} constructor.
     *
     * @return OAuth access token used for authorization with Dropbox servers
     */
    public Long getExpiresAt() {
        if (expiresIn == null) {
            return null;
        }
        return issueTime + expiresIn * 1000;
    }

    /**
     *
     *
     * Returns an <em>refresh token</em> which can be used to obtain new
     * {@link DbxAuthFinish#accessToken} . Pass this in to the
     * {@link com.dropbox.core.v2.DbxClientV2} constructor.
     *
     * @return OAuth access token used for authorization with Dropbox servers
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Returns the Dropbox user ID of the user who just approved your app for access to their
     * Dropbox account. We use user ID to identify user in API V1.
     *
     * @return Dropbox user ID of user that approved your app for access to their account
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Returns the Dropbox account ID of the user who just approved your app for access to their
     * Dropbox account. We use account ID to identify user in API V2.
     *
     * @return Dropbox account ID of user that approved your app for access to their account
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Returns the Dropbox team ID of the team's user who just approved your app for access to their
     * Dropbox account. We use team ID to identify team in API V2.
     *
     * @return Dropbox team ID of team's that approved your app for access to their account
     */
    public String getTeamId() {
        return teamId;
    }

    /**
     *
     *
     *
     * Return the <em>scopes</em> of current OAuth flow. Each scope correspond to a group of
     * API endpoints. To call one API endpoint you have to obtains the scope first otherwise you
     * will get HTTP 401.
     */
    public String getScope() {
        return scope;
    }

    /**
     * Returns the state data you passed in to {@link DbxWebAuth#start}.  If you didn't pass
     * anything in, or you used {@link DbxWebAuthNoRedirect}, this will be {@code null}.
     *
     * @return state data passed into {@link DbxWebAuth#start}, or {@code null} if no state was
     * passed
     */
    public /*@Nullable*/ String getUrlState() {
        return urlState;
    }

    /**
    *  Setting issue time should only be used to copy current object.
    * */
    void setIssueTime(long issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * State is not returned from /oauth2/token call, so we must
     * append it after the JSON parsing.
     *
     * @param urlState Custom state passed into /oauth2/authorize
     */
    DbxAuthFinish withUrlState(/*@Nullable*/ String urlState) {
        if (this.urlState != null) {
            throw new IllegalStateException("Already have URL state.");
        }

        DbxAuthFinish result =  new DbxAuthFinish(accessToken, expiresIn, refreshToken, userId,
                teamId, accountId, urlState, scope);
        result.setIssueTime(issueTime);

        return result;
    }

    /**
     * For JSON parsing.
     */
    public static final JsonReader<DbxAuthFinish> Reader = new JsonReader<DbxAuthFinish>() {
        public DbxAuthFinish read(JsonParser parser) throws IOException, JsonReadException {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String accessToken = null;
            Long expiresIn = null;
            String refreshToken = null;
            String tokenType = null;
            String userId = null;
            String accountId = null;
            String teamId = null;
            String state = null;
            String scope = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                JsonReader.nextToken(parser);

                try {
                    if (fieldName.equals("token_type")) {
                        tokenType = BearerTokenTypeReader.readField(parser, fieldName, tokenType);
                    }
                    else if (fieldName.equals("access_token")) {
                        accessToken = AccessTokenReader.readField(parser, fieldName, accessToken);
                    }
                    else if (fieldName.equals("expires_in")) {
                        expiresIn = JsonReader.UInt64Reader.readField(parser, fieldName, expiresIn);
                    }
                    else if (fieldName.equals("refresh_token")) {
                        refreshToken = JsonReader.StringReader.readField(parser, fieldName, refreshToken);
                    }
                    else if (fieldName.equals("uid")) {
                        userId = JsonReader.StringReader.readField(parser, fieldName, userId);
                    }
                    else if (fieldName.equals("account_id")) {
                        accountId = JsonReader.StringReader.readField(parser, fieldName, accountId);
                    }
                    else if (fieldName.equals("team_id")) {
                        teamId = JsonReader.StringReader.readField(parser, fieldName, teamId);
                    }
                    else if (fieldName.equals("state")) {
                        state = JsonReader.StringReader.readField(parser, fieldName, state);
                    }
                    else if (fieldName.equals("scope")) {
                        scope = JsonReader.StringReader.readField(parser, fieldName, scope);
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
            if (userId == null) throw new JsonReadException("missing field \"uid\"", top);
            //We want one of these two to be populated and we want the error to be include both if they're both null
            if (accountId == null && teamId == null) {
                throw new JsonReadException("missing field \"account_id\" and missing field \"team_id\"", top);
            }
            if (refreshToken != null && expiresIn == null) {
                throw new JsonReadException("missing field \"expires_in\"", top);
            }

            return new DbxAuthFinish(accessToken, expiresIn, refreshToken, userId, teamId,
                    accountId, state, scope);
        }
    };

    public static final JsonReader<String> BearerTokenTypeReader = new JsonReader<String>() {
        @Override
        public String read(JsonParser parser) throws IOException, JsonReadException {
            try {
                String v = parser.getText();
                if (!v.equals("Bearer") && !v.equals("bearer")) {
                    throw new JsonReadException("expecting \"Bearer\": got " + jq(v), parser.getTokenLocation());
                }
                parser.nextToken();
                return v;
            } catch (JsonParseException ex) {
                throw JsonReadException.fromJackson(ex);
            }
        }

    };

    public static final JsonReader<String> AccessTokenReader = new JsonReader<String>() {
        @Override
        public String read(JsonParser parser) throws IOException, JsonReadException {
            try {
                String v = parser.getText();
                String error = DbxAppInfo.getTokenPartError(v);
                if (error != null) {
                    throw new JsonReadException(error, parser.getTokenLocation());
                }
                parser.nextToken();
                return v;
            } catch (JsonParseException ex) {
                throw JsonReadException.fromJackson(ex);
            }
        }

    };
}
