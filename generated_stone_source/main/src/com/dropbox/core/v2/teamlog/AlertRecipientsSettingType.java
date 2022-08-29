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
 * Alert recipients setting type
 */
public enum AlertRecipientsSettingType {
    // union team_log.AlertRecipientsSettingType (team_log_generated.stone)
    CUSTOM_LIST,
    INVALID,
    NONE,
    TEAM_ADMINS,
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
    static class Serializer extends UnionSerializer<AlertRecipientsSettingType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AlertRecipientsSettingType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case CUSTOM_LIST: {
                    g.writeString("custom_list");
                    break;
                }
                case INVALID: {
                    g.writeString("invalid");
                    break;
                }
                case NONE: {
                    g.writeString("none");
                    break;
                }
                case TEAM_ADMINS: {
                    g.writeString("team_admins");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AlertRecipientsSettingType deserialize(JsonParser p) throws IOException, JsonParseException {
            AlertRecipientsSettingType value;
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
            else if ("custom_list".equals(tag)) {
                value = AlertRecipientsSettingType.CUSTOM_LIST;
            }
            else if ("invalid".equals(tag)) {
                value = AlertRecipientsSettingType.INVALID;
            }
            else if ("none".equals(tag)) {
                value = AlertRecipientsSettingType.NONE;
            }
            else if ("team_admins".equals(tag)) {
                value = AlertRecipientsSettingType.TEAM_ADMINS;
            }
            else {
                value = AlertRecipientsSettingType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
