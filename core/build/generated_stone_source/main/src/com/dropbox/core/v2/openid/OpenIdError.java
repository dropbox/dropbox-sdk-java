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

public enum OpenIdError {
    // union openid.OpenIdError (openid_openid_types.stone)
    /**
     * Missing openid claims for the associated access token.
     */
    INCORRECT_OPENID_SCOPES,
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
    static class Serializer extends UnionSerializer<OpenIdError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(OpenIdError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INCORRECT_OPENID_SCOPES: {
                    g.writeString("incorrect_openid_scopes");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public OpenIdError deserialize(JsonParser p) throws IOException, JsonParseException {
            OpenIdError value;
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
            else if ("incorrect_openid_scopes".equals(tag)) {
                value = OpenIdError.INCORRECT_OPENID_SCOPES;
            }
            else {
                value = OpenIdError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
