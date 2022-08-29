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

public enum PlacementRestriction {
    // union team_log.PlacementRestriction (team_log_generated.stone)
    AUSTRALIA_ONLY,
    EUROPE_ONLY,
    JAPAN_ONLY,
    NONE,
    UK_ONLY,
    US_S3_ONLY,
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
    static class Serializer extends UnionSerializer<PlacementRestriction> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PlacementRestriction value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case AUSTRALIA_ONLY: {
                    g.writeString("australia_only");
                    break;
                }
                case EUROPE_ONLY: {
                    g.writeString("europe_only");
                    break;
                }
                case JAPAN_ONLY: {
                    g.writeString("japan_only");
                    break;
                }
                case NONE: {
                    g.writeString("none");
                    break;
                }
                case UK_ONLY: {
                    g.writeString("uk_only");
                    break;
                }
                case US_S3_ONLY: {
                    g.writeString("us_s3_only");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public PlacementRestriction deserialize(JsonParser p) throws IOException, JsonParseException {
            PlacementRestriction value;
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
            else if ("australia_only".equals(tag)) {
                value = PlacementRestriction.AUSTRALIA_ONLY;
            }
            else if ("europe_only".equals(tag)) {
                value = PlacementRestriction.EUROPE_ONLY;
            }
            else if ("japan_only".equals(tag)) {
                value = PlacementRestriction.JAPAN_ONLY;
            }
            else if ("none".equals(tag)) {
                value = PlacementRestriction.NONE;
            }
            else if ("uk_only".equals(tag)) {
                value = PlacementRestriction.UK_ONLY;
            }
            else if ("us_s3_only".equals(tag)) {
                value = PlacementRestriction.US_S3_ONLY;
            }
            else {
                value = PlacementRestriction.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
