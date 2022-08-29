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
 * Policy for the default number of days until an externally shared link expires
 */
public enum DefaultLinkExpirationDaysPolicy {
    // union team_log.DefaultLinkExpirationDaysPolicy (team_log_generated.stone)
    DAY_1,
    DAY_180,
    DAY_3,
    DAY_30,
    DAY_7,
    DAY_90,
    NONE,
    YEAR_1,
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
    static class Serializer extends UnionSerializer<DefaultLinkExpirationDaysPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DefaultLinkExpirationDaysPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DAY_1: {
                    g.writeString("day_1");
                    break;
                }
                case DAY_180: {
                    g.writeString("day_180");
                    break;
                }
                case DAY_3: {
                    g.writeString("day_3");
                    break;
                }
                case DAY_30: {
                    g.writeString("day_30");
                    break;
                }
                case DAY_7: {
                    g.writeString("day_7");
                    break;
                }
                case DAY_90: {
                    g.writeString("day_90");
                    break;
                }
                case NONE: {
                    g.writeString("none");
                    break;
                }
                case YEAR_1: {
                    g.writeString("year_1");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public DefaultLinkExpirationDaysPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            DefaultLinkExpirationDaysPolicy value;
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
            else if ("day_1".equals(tag)) {
                value = DefaultLinkExpirationDaysPolicy.DAY_1;
            }
            else if ("day_180".equals(tag)) {
                value = DefaultLinkExpirationDaysPolicy.DAY_180;
            }
            else if ("day_3".equals(tag)) {
                value = DefaultLinkExpirationDaysPolicy.DAY_3;
            }
            else if ("day_30".equals(tag)) {
                value = DefaultLinkExpirationDaysPolicy.DAY_30;
            }
            else if ("day_7".equals(tag)) {
                value = DefaultLinkExpirationDaysPolicy.DAY_7;
            }
            else if ("day_90".equals(tag)) {
                value = DefaultLinkExpirationDaysPolicy.DAY_90;
            }
            else if ("none".equals(tag)) {
                value = DefaultLinkExpirationDaysPolicy.NONE;
            }
            else if ("year_1".equals(tag)) {
                value = DefaultLinkExpirationDaysPolicy.YEAR_1;
            }
            else {
                value = DefaultLinkExpirationDaysPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
