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

public enum InvalidAccountTypeError {
    // union auth.InvalidAccountTypeError (auth.stone)
    /**
     * Current account type doesn't have permission to access this route
     * endpoint.
     */
    ENDPOINT,
    /**
     * Current account type doesn't have permission to access this feature.
     */
    FEATURE,
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
    public static class Serializer extends UnionSerializer<InvalidAccountTypeError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(InvalidAccountTypeError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ENDPOINT: {
                    g.writeString("endpoint");
                    break;
                }
                case FEATURE: {
                    g.writeString("feature");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public InvalidAccountTypeError deserialize(JsonParser p) throws IOException, JsonParseException {
            InvalidAccountTypeError value;
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
            else if ("endpoint".equals(tag)) {
                value = InvalidAccountTypeError.ENDPOINT;
            }
            else if ("feature".equals(tag)) {
                value = InvalidAccountTypeError.FEATURE;
            }
            else {
                value = InvalidAccountTypeError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
