package com.dropbox.core;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Used by the example code to remember auth information.
 */
public final class DbxAuthInfo {
    private final @Nonnull String accessToken;
    private final @Nullable Long expiresAt;
    private final @Nullable String refreshToken;
    private final @Nonnull DbxHost host;

    /**
     * Creates a new instance with the given parameters.
     *
     * @param accessToken OAuth access token for authorization with Dropbox servers
     * @param host Dropbox host configuration used to select Dropbox servers
     */
    public DbxAuthInfo(@Nonnull String accessToken, @Nonnull DbxHost host) {
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
    public DbxAuthInfo(@Nonnull String accessToken,
                       @Nullable Long expiresAt,
                       @Nullable String refreshToken,
                       @Nonnull DbxHost host) {
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
    public @Nonnull String getAccessToken() {
        return accessToken;
    }

    /**
     *
     * Return the millisecond when accessToken is going to expire.
     *
     * @return ExpiresAt in millisecond.
     */
    public @Nullable Long getExpiresAt() {
        return expiresAt;
    }

    /**
     *
     * Return the refresh token which can be used to obtain new access token.
     *
     * @return Refresh Token.
     */
    public @Nullable String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Returns Dropbox host configuration used to map requests to the appropriate Dropbox servers.
     *
     * @return Dropbox host configuration
     */
    public @Nonnull DbxHost getHost() {
        return host;
    }

    public static final @Nonnull JsonReader<DbxAuthInfo> Reader = new JsonReader<DbxAuthInfo>()
    {
        @Override
        public final @Nonnull DbxAuthInfo read(@Nonnull JsonParser parser)
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

    public static final @Nonnull JsonWriter<DbxAuthInfo> Writer = new JsonWriter<DbxAuthInfo>()
    {
        @Override
        public void write(@Nonnull DbxAuthInfo authInfo, @Nonnull JsonGenerator g) throws IOException
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
