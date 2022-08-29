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

/**
 * Space limit alert policy
 */
public enum SpaceCapsType {
    // union team_log.SpaceCapsType (team_log_generated.stone)
    HARD,
    OFF,
    SOFT,
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
    static class Serializer extends UnionSerializer<SpaceCapsType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SpaceCapsType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case HARD: {
                    g.writeString("hard");
                    break;
                }
                case OFF: {
                    g.writeString("off");
                    break;
                }
                case SOFT: {
                    g.writeString("soft");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SpaceCapsType deserialize(JsonParser p) throws IOException, JsonParseException {
            SpaceCapsType value;
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
            else if ("hard".equals(tag)) {
                value = SpaceCapsType.HARD;
            }
            else if ("off".equals(tag)) {
                value = SpaceCapsType.OFF;
            }
            else if ("soft".equals(tag)) {
                value = SpaceCapsType.SOFT;
            }
            else {
                value = SpaceCapsType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
