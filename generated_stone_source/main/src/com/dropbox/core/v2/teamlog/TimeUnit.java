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

public enum TimeUnit {
    // union team_log.TimeUnit (team_log_generated.stone)
    DAYS,
    HOURS,
    MILLISECONDS,
    MINUTES,
    MONTHS,
    SECONDS,
    WEEKS,
    YEARS,
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
    static class Serializer extends UnionSerializer<TimeUnit> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TimeUnit value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DAYS: {
                    g.writeString("days");
                    break;
                }
                case HOURS: {
                    g.writeString("hours");
                    break;
                }
                case MILLISECONDS: {
                    g.writeString("milliseconds");
                    break;
                }
                case MINUTES: {
                    g.writeString("minutes");
                    break;
                }
                case MONTHS: {
                    g.writeString("months");
                    break;
                }
                case SECONDS: {
                    g.writeString("seconds");
                    break;
                }
                case WEEKS: {
                    g.writeString("weeks");
                    break;
                }
                case YEARS: {
                    g.writeString("years");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TimeUnit deserialize(JsonParser p) throws IOException, JsonParseException {
            TimeUnit value;
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
            else if ("days".equals(tag)) {
                value = TimeUnit.DAYS;
            }
            else if ("hours".equals(tag)) {
                value = TimeUnit.HOURS;
            }
            else if ("milliseconds".equals(tag)) {
                value = TimeUnit.MILLISECONDS;
            }
            else if ("minutes".equals(tag)) {
                value = TimeUnit.MINUTES;
            }
            else if ("months".equals(tag)) {
                value = TimeUnit.MONTHS;
            }
            else if ("seconds".equals(tag)) {
                value = TimeUnit.SECONDS;
            }
            else if ("weeks".equals(tag)) {
                value = TimeUnit.WEEKS;
            }
            else if ("years".equals(tag)) {
                value = TimeUnit.YEARS;
            }
            else {
                value = TimeUnit.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
