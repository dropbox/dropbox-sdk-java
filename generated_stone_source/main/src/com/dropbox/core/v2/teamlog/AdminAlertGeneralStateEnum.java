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
 * Alert state
 */
public enum AdminAlertGeneralStateEnum {
    // union team_log.AdminAlertGeneralStateEnum (team_log_generated.stone)
    ACTIVE,
    DISMISSED,
    IN_PROGRESS,
    NA,
    RESOLVED,
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
    static class Serializer extends UnionSerializer<AdminAlertGeneralStateEnum> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminAlertGeneralStateEnum value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACTIVE: {
                    g.writeString("active");
                    break;
                }
                case DISMISSED: {
                    g.writeString("dismissed");
                    break;
                }
                case IN_PROGRESS: {
                    g.writeString("in_progress");
                    break;
                }
                case NA: {
                    g.writeString("na");
                    break;
                }
                case RESOLVED: {
                    g.writeString("resolved");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AdminAlertGeneralStateEnum deserialize(JsonParser p) throws IOException, JsonParseException {
            AdminAlertGeneralStateEnum value;
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
            else if ("active".equals(tag)) {
                value = AdminAlertGeneralStateEnum.ACTIVE;
            }
            else if ("dismissed".equals(tag)) {
                value = AdminAlertGeneralStateEnum.DISMISSED;
            }
            else if ("in_progress".equals(tag)) {
                value = AdminAlertGeneralStateEnum.IN_PROGRESS;
            }
            else if ("na".equals(tag)) {
                value = AdminAlertGeneralStateEnum.NA;
            }
            else if ("resolved".equals(tag)) {
                value = AdminAlertGeneralStateEnum.RESOLVED;
            }
            else {
                value = AdminAlertGeneralStateEnum.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
