package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Used by the example code to remember auth information.
 */
public final class DbxAuthInfo {
    private final String accessToken;
    private final Long expiresAt;
    private final String refreshToken;
    private final DbxHost host;

    /**
     * Creates a new instance with the given parameters.
     *
     * @param accessToken OAuth access token for authorization with Dropbox servers
     * @param host Dropbox host configuration used to select Dropbox servers
     */
    public DbxAuthInfo(String accessToken, DbxHost host) {
        this(accessToken, null, null, host);
    }

    /**
     *
     * Creates a new instance with the given parameters.
     *
     * @param accessToken OAuth access token for authorization with Dropbox servers
     * @param expiresAt When accessToken is going to expire in millisecond
     * @param refreshToken Refresh token which can bu used to obtain new accessToken
     * @param host Dropbox host configuration used to select Dropbox servers
     */
    public DbxAuthInfo(String accessToken, Long expiresAt, String refreshToken, DbxHost host) {
        if (accessToken == null) throw new IllegalArgumentException("'accessToken' can't be null");
        if (host == null) throw new IllegalArgumentException("'host' can't be null");

        this.accessToken = accessToken;
        this.expiresAt = expiresAt;
        this.refreshToken = refreshToken;
        this.host = host;
    }

    /**
     * Returns the OAuth access token to use for authorization with Dropbox servers.
     *
     * @return OAuth access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     *
     * Return the millisecond when accessToken is going to expire.
     *
     * @return ExpiresAt in millisecond.
     */
    public Long getExpiresAt() {
        return expiresAt;
    }

    /**
     *
     * Return the refresh token which can be used to obtain new access token.
     *
     * @return Refresh Token.
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Returns Dropbox host configuration used to map requests to the appropriate Dropbox servers.
     *
     * @return Dropbox host configuration
     */
    public DbxHost getHost() {
        return host;
    }

    public static final JsonReader<DbxAuthInfo> Reader = new JsonReader<DbxAuthInfo>()
    {
        @Override
        public final DbxAuthInfo read(JsonParser parser)
            throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            DbxHost host = null;
            String accessToken = null;
            Long expiresAt = null;
            String refreshToken = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();

                try {
                    if (fieldName.equals("host")) {
                        host = DbxHost.Reader.readField(parser, fieldName, host);
                    }
                    else if (fieldName.equals("expires_at")) {
                        expiresAt = Int64Reader.readField(parser, fieldName, expiresAt);
                    }
                    else if (fieldName.equals("refresh_token")) {
                        refreshToken = StringReader.readField(parser, fieldName, refreshToken);
                    }
                    else if (fieldName.equals("access_token")) {
                        accessToken = StringReader.readField(parser, fieldName, accessToken);
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
            if (host == null) host = DbxHost.DEFAULT;

            return new DbxAuthInfo(accessToken, expiresAt, refreshToken, host);
        }
    };

    public static final JsonWriter<DbxAuthInfo> Writer = new JsonWriter<DbxAuthInfo>()
    {
        @Override
        public void write(DbxAuthInfo authInfo, JsonGenerator g) throws IOException
        {
            g.writeStartObject();
            g.writeStringField("access_token", authInfo.accessToken);
            if (authInfo.expiresAt != null) {
                g.writeNumberField("expires_at", authInfo.expiresAt);
            }
            if (authInfo.refreshToken != null) {
                g.writeStringField("refresh_token", authInfo.refreshToken);
            }
            if (!authInfo.host.equals(DbxHost.DEFAULT)) {
                g.writeFieldName("host");
                DbxHost.Writer.write(authInfo.host, g);
            }
            g.writeEndObject();
        }
    };
}
