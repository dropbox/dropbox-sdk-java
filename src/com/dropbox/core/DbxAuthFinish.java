package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import static com.dropbox.core.util.StringUtil.jq;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * When you successfully complete the authorization process, the Dropbox server returns
 * this information to you.
 */
public final class DbxAuthFinish implements java.io.Serializable
{
    public static final long serialVersionUID = 0;

    /**
     * An <em>access token</em> that can be used to make Dropbox API calls.
     * Pass this in to the {@link DbxClient} constructor.
     */
    public final String accessToken;

    /**
     * The Dropbox user ID of the user who just approved your app for access to
     * their Dropbox account.
     */
    public final String userId;

    /**
     * The state data you passed in to {@link DbxWebAuth#start}.  If you didn't pass anything
     * in, or you used {@link DbxWebAuthNoRedirect}, this will be {@code null}.
     */
    public final String urlState;

    /**
     * @param accessToken {@link #accessToken}
     * @param userId {@link #userId}
     */
    public DbxAuthFinish(String accessToken, String userId, String urlState)
    {
        this.accessToken = accessToken;
        this.userId = userId;
        this.urlState = urlState;
    }

    /**
     * For JSON parsing.
     */
    public static final JsonReader<DbxAuthFinish> Reader = new JsonReader<DbxAuthFinish>()
    {
        public DbxAuthFinish read(JsonParser parser) throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String accessToken = null;
            String tokenType = null;
            String userId = null;

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

            return new DbxAuthFinish(accessToken, userId, null);
        }
    };

    public static final JsonReader<String> BearerTokenTypeReader = new JsonReader<String>()
    {
        @Override
        public String read(JsonParser parser) throws IOException, JsonReadException
        {
            try {
                String v = parser.getText();
                if (!v.equals("Bearer") && !v.equals("bearer")) {
                    throw new JsonReadException("expecting \"Bearer\": got " + jq(v), parser.getTokenLocation());
                }
                parser.nextToken();
                return v;
            }
            catch (JsonParseException ex) {
                throw JsonReadException.fromJackson(ex);
            }
        }

    };

    public static final JsonReader<String> AccessTokenReader = new JsonReader<String>()
    {
        @Override
        public String read(JsonParser parser) throws IOException, JsonReadException
        {
            try {
                String v = parser.getText();
                String error = DbxAppInfo.getTokenPartError(v);
                if (error != null) {
                    throw new JsonReadException(error, parser.getTokenLocation());
                }
                parser.nextToken();
                return v;
            }
            catch (JsonParseException ex) {
                throw JsonReadException.fromJackson(ex);
            }
        }

    };
}
