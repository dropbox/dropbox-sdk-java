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

public enum RateLimitReason {
    // union auth.RateLimitReason (auth.stone)
    /**
     * You are making too many requests in the past few minutes.
     */
    TOO_MANY_REQUESTS,
    /**
     * There are currently too many write operations happening in the user's
     * Dropbox.
     */
    TOO_MANY_WRITE_OPERATIONS,
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
    public static class Serializer extends UnionSerializer<RateLimitReason> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RateLimitReason value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case TOO_MANY_REQUESTS: {
                    g.writeString("too_many_requests");
                    break;
                }
                case TOO_MANY_WRITE_OPERATIONS: {
                    g.writeString("too_many_write_operations");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public RateLimitReason deserialize(JsonParser p) throws IOException, JsonParseException {
            RateLimitReason value;
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
            else if ("too_many_requests".equals(tag)) {
                value = RateLimitReason.TOO_MANY_REQUESTS;
            }
            else if ("too_many_write_operations".equals(tag)) {
                value = RateLimitReason.TOO_MANY_WRITE_OPERATIONS;
            }
            else {
                value = RateLimitReason.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
