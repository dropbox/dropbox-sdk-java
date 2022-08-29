/* DO NOT EDIT */
/* This file was generated from auth.stone */

package com.dropbox.core.v2.auth;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

public enum TokenFromOAuth1Error {
    // union auth.TokenFromOAuth1Error (auth.stone)
    /**
     * Part or all of the OAuth 1.0 access token info is invalid.
     */
    INVALID_OAUTH1_TOKEN_INFO,
    /**
     * The authorized app does not match the app associated with the supplied
     * access token.
     */
    APP_ID_MISMATCH,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<TokenFromOAuth1Error> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TokenFromOAuth1Error value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVALID_OAUTH1_TOKEN_INFO: {
                    g.writeString("invalid_oauth1_token_info");
                    break;
                }
                case APP_ID_MISMATCH: {
                    g.writeString("app_id_mismatch");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TokenFromOAuth1Error deserialize(JsonParser p) throws IOException, JsonParseException {
            TokenFromOAuth1Error value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("invalid_oauth1_token_info".equals(tag)) {
                value = TokenFromOAuth1Error.INVALID_OAUTH1_TOKEN_INFO;
            }
            else if ("app_id_mismatch".equals(tag)) {
                value = TokenFromOAuth1Error.APP_ID_MISMATCH;
            }
            else {
                value = TokenFromOAuth1Error.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
