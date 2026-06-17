package com.dropbox.core.oauth;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *
 * This class provides deserialization for the error response returned from OAuth endpoint.
 *
 * @see <a href="https://tools.ietf.org/html/rfc6749#section-5.2">https://tools.ietf.org/html/rfc6749#section-5.2</a>
 */
public class DbxOAuthError {
    public final static @Nonnull String INVALID_REQUEST = "invalid_request";
    public final static @Nonnull String INVALID_GRANT = "invalid_grant";
    public final static @Nonnull String UNSUPPORTED_GRANT_TYPE = "unsupported_grant_type";
    public final static @Nonnull String UNKNOWN = "unknown";
    public final static @Nonnull Set<String> ERRORS = new HashSet<String>(Arrays.asList(INVALID_REQUEST,
        INVALID_GRANT, UNSUPPORTED_GRANT_TYPE));

    private final @Nonnull String error;
    private final @Nullable String errorDescription;

    public DbxOAuthError(@Nonnull String error, @Nullable String errorDescription) {
        if (ERRORS.contains(error)) {
            this.error = error;
        } else {
            this.error = UNKNOWN;
        }

        this.errorDescription = errorDescription;
    }

    public @Nonnull String getError() {
        return this.error;
    }

    public @Nullable String getErrorDescription() {
        return this.errorDescription;
    }

    public static final @Nonnull JsonReader<DbxOAuthError> Reader = new JsonReader<DbxOAuthError>()
    {
        @Override
        public final @Nonnull DbxOAuthError read(@Nonnull JsonParser parser)
            throws IOException, JsonReadException
        {
            JsonLocation top = JsonReader.expectObjectStart(parser);

            String error = null;
            String errorDescription = null;

            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();

                try {
                    if (fieldName.equals("error")) {
                        error = StringReader.readField(parser, fieldName, error);
                    }
                    else if (fieldName.equals("error_description")) {
                        errorDescription = StringReader.readField(parser, fieldName, errorDescription);
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

            if (error == null) {
                throw new JsonReadException("missing field \"error\"", top);
            }

            return new DbxOAuthError(error, errorDescription);
        }
    };
}
