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
 * Alert severity
 */
public enum AdminAlertSeverityEnum {
    // union team_log.AdminAlertSeverityEnum (team_log_generated.stone)
    HIGH,
    INFO,
    LOW,
    MEDIUM,
    NA,
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
    static class Serializer extends UnionSerializer<AdminAlertSeverityEnum> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminAlertSeverityEnum value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case HIGH: {
                    g.writeString("high");
                    break;
                }
                case INFO: {
                    g.writeString("info");
                    break;
                }
                case LOW: {
                    g.writeString("low");
                    break;
                }
                case MEDIUM: {
                    g.writeString("medium");
                    break;
                }
                case NA: {
                    g.writeString("na");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AdminAlertSeverityEnum deserialize(JsonParser p) throws IOException, JsonParseException {
            AdminAlertSeverityEnum value;
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
            else if ("high".equals(tag)) {
                value = AdminAlertSeverityEnum.HIGH;
            }
            else if ("info".equals(tag)) {
                value = AdminAlertSeverityEnum.INFO;
            }
            else if ("low".equals(tag)) {
                value = AdminAlertSeverityEnum.LOW;
            }
            else if ("medium".equals(tag)) {
                value = AdminAlertSeverityEnum.MEDIUM;
            }
            else if ("na".equals(tag)) {
                value = AdminAlertSeverityEnum.NA;
            }
            else {
                value = AdminAlertSeverityEnum.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
