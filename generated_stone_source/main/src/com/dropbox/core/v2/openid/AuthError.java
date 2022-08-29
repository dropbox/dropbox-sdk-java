/* DO NOT EDIT */
/* This file was generated from openid_openid_types.stone */

package com.dropbox.core.v2.openid;

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

public enum AuthError {
    // union openid.AuthError (openid_openid_types.stone)
    INVALID_TOKEN,
    NO_OPENID_AUTH,
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
    public static class Serializer extends UnionSerializer<AuthError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AuthError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVALID_TOKEN: {
                    g.writeString("invalid_token");
                    break;
                }
                case NO_OPENID_AUTH: {
                    g.writeString("no_openid_auth");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AuthError deserialize(JsonParser p) throws IOException, JsonParseException {
            AuthError value;
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
            else if ("invalid_token".equals(tag)) {
                value = AuthError.INVALID_TOKEN;
            }
            else if ("no_openid_auth".equals(tag)) {
                value = AuthError.NO_OPENID_AUTH;
            }
            else {
                value = AuthError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
