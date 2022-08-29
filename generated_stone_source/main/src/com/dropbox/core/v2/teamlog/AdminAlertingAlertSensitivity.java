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
 * Alert sensitivity
 */
public enum AdminAlertingAlertSensitivity {
    // union team_log.AdminAlertingAlertSensitivity (team_log_generated.stone)
    HIGH,
    HIGHEST,
    INVALID,
    LOW,
    LOWEST,
    MEDIUM,
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
    static class Serializer extends UnionSerializer<AdminAlertingAlertSensitivity> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminAlertingAlertSensitivity value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case HIGH: {
                    g.writeString("high");
                    break;
                }
                case HIGHEST: {
                    g.writeString("highest");
                    break;
                }
                case INVALID: {
                    g.writeString("invalid");
                    break;
                }
                case LOW: {
                    g.writeString("low");
                    break;
                }
                case LOWEST: {
                    g.writeString("lowest");
                    break;
                }
                case MEDIUM: {
                    g.writeString("medium");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AdminAlertingAlertSensitivity deserialize(JsonParser p) throws IOException, JsonParseException {
            AdminAlertingAlertSensitivity value;
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
                value = AdminAlertingAlertSensitivity.HIGH;
            }
            else if ("highest".equals(tag)) {
                value = AdminAlertingAlertSensitivity.HIGHEST;
            }
            else if ("invalid".equals(tag)) {
                value = AdminAlertingAlertSensitivity.INVALID;
            }
            else if ("low".equals(tag)) {
                value = AdminAlertingAlertSensitivity.LOW;
            }
            else if ("lowest".equals(tag)) {
                value = AdminAlertingAlertSensitivity.LOWEST;
            }
            else if ("medium".equals(tag)) {
                value = AdminAlertingAlertSensitivity.MEDIUM;
            }
            else {
                value = AdminAlertingAlertSensitivity.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
