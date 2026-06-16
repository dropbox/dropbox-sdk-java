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

import javax.annotation.Nonnull;

class TokenFromOAuth1Arg {
    // struct auth.TokenFromOAuth1Arg (auth.stone)

    @Nonnull
    protected final String oauth1Token;
    @Nonnull
    protected final String oauth1TokenSecret;

    /**
     *
     * @param oauth1Token  The supplied OAuth 1.0 access token. Must have length
     *     of at least 1 and not be {@code null}.
     * @param oauth1TokenSecret  The token secret associated with the supplied
     *     access token. Must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TokenFromOAuth1Arg(@Nonnull String oauth1Token, @Nonnull String oauth1TokenSecret) {
        if (oauth1Token == null) {
            throw new IllegalArgumentException("Required value for 'oauth1Token' is null");
        }
        if (oauth1Token.length() < 1) {
            throw new IllegalArgumentException("String 'oauth1Token' is shorter than 1");
        }
        this.oauth1Token = oauth1Token;
        if (oauth1TokenSecret == null) {
            throw new IllegalArgumentException("Required value for 'oauth1TokenSecret' is null");
        }
        if (oauth1TokenSecret.length() < 1) {
            throw new IllegalArgumentException("String 'oauth1TokenSecret' is shorter than 1");
        }
        this.oauth1TokenSecret = oauth1TokenSecret;
    }

    /**
     * The supplied OAuth 1.0 access token.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getOauth1Token() {
        return oauth1Token;
    }

    /**
     * The token secret associated with the supplied access token.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getOauth1TokenSecret() {
        return oauth1TokenSecret;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.oauth1Token,
            this.oauth1TokenSecret
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
            TokenFromOAuth1Arg other = (TokenFromOAuth1Arg) obj;
            return ((this.oauth1Token == other.oauth1Token) || (this.oauth1Token.equals(other.oauth1Token)))
                && ((this.oauth1TokenSecret == other.oauth1TokenSecret) || (this.oauth1TokenSecret.equals(other.oauth1TokenSecret)))
                ;
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
    static class Serializer extends StructSerializer<TokenFromOAuth1Arg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TokenFromOAuth1Arg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("oauth1_token");
            StoneSerializers.string().serialize(value.oauth1Token, g);
            g.writeFieldName("oauth1_token_secret");
            StoneSerializers.string().serialize(value.oauth1TokenSecret, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TokenFromOAuth1Arg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TokenFromOAuth1Arg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_oauth1Token = null;
                String f_oauth1TokenSecret = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("oauth1_token".equals(field)) {
                        f_oauth1Token = StoneSerializers.string().deserialize(p);
                    }
                    else if ("oauth1_token_secret".equals(field)) {
                        f_oauth1TokenSecret = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_oauth1Token == null) {
                    throw new JsonParseException(p, "Required field \"oauth1_token\" missing.");
                }
                if (f_oauth1TokenSecret == null) {
                    throw new JsonParseException(p, "Required field \"oauth1_token_secret\" missing.");
                }
                value = new TokenFromOAuth1Arg(f_oauth1Token, f_oauth1TokenSecret);
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
