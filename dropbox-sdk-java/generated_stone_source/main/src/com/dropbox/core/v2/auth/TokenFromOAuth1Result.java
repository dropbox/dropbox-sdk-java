/* DO NOT EDIT */
/* This file was generated from auth.stone */

package com.dropbox.core.v2.auth;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

public class TokenFromOAuth1Result {
    // struct auth.TokenFromOAuth1Result (auth.stone)

    protected final String oauth2Token;

    /**
     *
     * @param oauth2Token  The OAuth 2.0 token generated from the supplied OAuth
     *     1.0 token. Must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TokenFromOAuth1Result(String oauth2Token) {
        if (oauth2Token == null) {
            throw new IllegalArgumentException("Required value for 'oauth2Token' is null");
        }
        if (oauth2Token.length() < 1) {
            throw new IllegalArgumentException("String 'oauth2Token' is shorter than 1");
        }
        this.oauth2Token = oauth2Token;
    }

    /**
     * The OAuth 2.0 token generated from the supplied OAuth 1.0 token.
     *
     * @return value for this field, never {@code null}.
     */
    public String getOauth2Token() {
        return oauth2Token;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            oauth2Token
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            TokenFromOAuth1Result other = (TokenFromOAuth1Result) obj;
            return (this.oauth2Token == other.oauth2Token) || (this.oauth2Token.equals(other.oauth2Token));
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<TokenFromOAuth1Result> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TokenFromOAuth1Result value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("oauth2_token");
            StoneSerializers.string().serialize(value.oauth2Token, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TokenFromOAuth1Result deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TokenFromOAuth1Result value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_oauth2Token = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("oauth2_token".equals(field)) {
                        f_oauth2Token = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_oauth2Token == null) {
                    throw new JsonParseException(p, "Required field \"oauth2_token\" missing.");
                }
                value = new TokenFromOAuth1Result(f_oauth2Token);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
