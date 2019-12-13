package com.dropbox.core.oauth;

import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/*>>> import checkers.nullness.quals.NonNull; */

/**
 * <b>Beta</b>: This feature is not available to all developers. Please do NOT use it unless you are
 * early access partner of this feature. The function signature is subject to change
 * in next minor version release.
 *
 * This is the return value of {@link DbxCredential#refresh(DbxRequestConfig)}. It contains new
 * access token and expiration time.
 */
public class DbxRefreshResult {
    private final String accessToken;
    private final long expiresIn;
    private long issueTime;

    /**
     * @param accessToken OAuth access token.
     * @param expiresIn Duration time of accessToken in second.
     * was passed
     */
    public DbxRefreshResult(/*@NotNull*/String accessToken, long expiresIn) {
        if (accessToken == null) {
            throw new IllegalArgumentException("access token can't be null.");
        }
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.issueTime = System.currentTimeMillis();
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
     * Returns the time when {@link DbxAuthFinish#accessToken} expires in millisecond. If null then
     * it won't expire. Pass this in to the {@link com.dropbox.core.v2.DbxClientV2} constructor.
     *
     * @return OAuth access token used for authorization with Dropbox servers
     */
    public Long getExpiresAt() {
        return issueTime + expiresIn * 1000;
    }

    /**
     *  Setting issue time should only be used to copy current object.
     * */
    void setIssueTime(long issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * For JSON parsing.
     */
    public static final JsonReader<DbxRefreshResult> Reader = new JsonReader<DbxRefreshResult>() {
        public DbxRefreshResult read(JsonParser parser) throws IOException, JsonReadException {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String tokenType = null;
            String accessToken = null;
            Long expiresIn = null;

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
                    else if (fieldName.equals("expires_in")) {
                        expiresIn = JsonReader.UInt64Reader.readField(parser, fieldName, expiresIn);
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
            if (expiresIn == null) {
                throw new JsonReadException("missing field \"expires_in\"", top);
            }

            return new DbxRefreshResult(accessToken, expiresIn);
        }
    };
}
