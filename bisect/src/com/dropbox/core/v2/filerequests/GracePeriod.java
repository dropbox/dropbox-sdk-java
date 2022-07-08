/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

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

public enum GracePeriod {
    // union file_requests.GracePeriod (file_requests.stone)
    ONE_DAY,
    TWO_DAYS,
    SEVEN_DAYS,
    THIRTY_DAYS,
    ALWAYS,
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
    static class Serializer extends UnionSerializer<GracePeriod> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GracePeriod value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ONE_DAY: {
                    g.writeString("one_day");
                    break;
                }
                case TWO_DAYS: {
                    g.writeString("two_days");
                    break;
                }
                case SEVEN_DAYS: {
                    g.writeString("seven_days");
                    break;
                }
                case THIRTY_DAYS: {
                    g.writeString("thirty_days");
                    break;
                }
                case ALWAYS: {
                    g.writeString("always");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GracePeriod deserialize(JsonParser p) throws IOException, JsonParseException {
            GracePeriod value;
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
            else if ("one_day".equals(tag)) {
                value = GracePeriod.ONE_DAY;
            }
            else if ("two_days".equals(tag)) {
                value = GracePeriod.TWO_DAYS;
            }
            else if ("seven_days".equals(tag)) {
                value = GracePeriod.SEVEN_DAYS;
            }
            else if ("thirty_days".equals(tag)) {
                value = GracePeriod.THIRTY_DAYS;
            }
            else if ("always".equals(tag)) {
                value = GracePeriod.ALWAYS;
            }
            else {
                value = GracePeriod.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
