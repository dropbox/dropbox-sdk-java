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
/*>>> import com.dropbox.core.v2.DbxClientV2; */

/**
 * When you successfully complete the authorization process, the Dropbox server returns
 * this information to you.
 */
public final class DbxAuthFinish {
    private final String accessToken;
    private final String userId;
    private final String accountId;
    private final String teamId;
    private final /*@Nullable*/String urlState;

    /**
     * @param accessToken OAuth access token
     * @param userId Dropbox user ID of user that approved access to this app
     * @param urlState State data passed in to {@link DbxWebAuth#start} or {@code null} if no state
     * was passed
     */
    public DbxAuthFinish(String accessToken, String userId, String accountId, String teamId, /*@Nullable*/String urlState) {
        this.accessToken = accessToken;
        this.userId = userId;
        this.accountId = accountId;
        this.teamId = teamId;
        this.urlState = urlState;
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
     * State is not returned from /oauth2/token call, so we must
     * append it after the JSON parsing.
     *
     * @param urlState Custom state passed into /oauth2/authorize
     */
    DbxAuthFinish withUrlState(/*@Nullable*/ String urlState) {
        if (this.urlState != null) {
            throw new IllegalStateException("Already have URL state.");
        }
        return new DbxAuthFinish(accessToken, userId, accountId, teamId, urlState);
    }

    /**
     * For JSON parsing.
     */
    public static final JsonReader<DbxAuthFinish> Reader = new JsonReader<DbxAuthFinish>() {
        public DbxAuthFinish read(JsonParser parser) throws IOException, JsonReadException {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String accessToken = null;
            String tokenType = null;
            String userId = null;
            String accountId = null;
            String teamId = null;
            String state = null;

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

            return new DbxAuthFinish(accessToken, userId, accountId, teamId, state);
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
