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

public enum SpaceLimitsStatus {
    // union team_log.SpaceLimitsStatus (team_log_generated.stone)
    NEAR_QUOTA,
    OVER_QUOTA,
    WITHIN_QUOTA,
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
    static class Serializer extends UnionSerializer<SpaceLimitsStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SpaceLimitsStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case NEAR_QUOTA: {
                    g.writeString("near_quota");
                    break;
                }
                case OVER_QUOTA: {
                    g.writeString("over_quota");
                    break;
                }
                case WITHIN_QUOTA: {
                    g.writeString("within_quota");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SpaceLimitsStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            SpaceLimitsStatus value;
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
            else if ("near_quota".equals(tag)) {
                value = SpaceLimitsStatus.NEAR_QUOTA;
            }
            else if ("over_quota".equals(tag)) {
                value = SpaceLimitsStatus.OVER_QUOTA;
            }
            else if ("within_quota".equals(tag)) {
                value = SpaceLimitsStatus.WITHIN_QUOTA;
            }
            else {
                value = SpaceLimitsStatus.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
