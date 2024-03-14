/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

public enum ExtendedVersionHistoryPolicy {
    // union team_log.ExtendedVersionHistoryPolicy (team_log_generated.stone)
    EXPLICITLY_LIMITED,
    EXPLICITLY_UNLIMITED,
    IMPLICITLY_LIMITED,
    IMPLICITLY_UNLIMITED,
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
    static class Serializer extends UnionSerializer<ExtendedVersionHistoryPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ExtendedVersionHistoryPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case EXPLICITLY_LIMITED: {
                    g.writeString("explicitly_limited");
                    break;
                }
                case EXPLICITLY_UNLIMITED: {
                    g.writeString("explicitly_unlimited");
                    break;
                }
                case IMPLICITLY_LIMITED: {
                    g.writeString("implicitly_limited");
                    break;
                }
                case IMPLICITLY_UNLIMITED: {
                    g.writeString("implicitly_unlimited");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ExtendedVersionHistoryPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            ExtendedVersionHistoryPolicy value;
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
            else if ("explicitly_limited".equals(tag)) {
                value = ExtendedVersionHistoryPolicy.EXPLICITLY_LIMITED;
            }
            else if ("explicitly_unlimited".equals(tag)) {
                value = ExtendedVersionHistoryPolicy.EXPLICITLY_UNLIMITED;
            }
            else if ("implicitly_limited".equals(tag)) {
                value = ExtendedVersionHistoryPolicy.IMPLICITLY_LIMITED;
            }
            else if ("implicitly_unlimited".equals(tag)) {
                value = ExtendedVersionHistoryPolicy.IMPLICITLY_UNLIMITED;
            }
            else {
                value = ExtendedVersionHistoryPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
