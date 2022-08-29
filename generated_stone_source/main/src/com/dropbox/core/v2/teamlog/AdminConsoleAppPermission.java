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

public enum AdminConsoleAppPermission {
    // union team_log.AdminConsoleAppPermission (team_log_generated.stone)
    DEFAULT_FOR_LISTED_APPS,
    DEFAULT_FOR_UNLISTED_APPS,
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
    static class Serializer extends UnionSerializer<AdminConsoleAppPermission> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AdminConsoleAppPermission value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DEFAULT_FOR_LISTED_APPS: {
                    g.writeString("default_for_listed_apps");
                    break;
                }
                case DEFAULT_FOR_UNLISTED_APPS: {
                    g.writeString("default_for_unlisted_apps");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public AdminConsoleAppPermission deserialize(JsonParser p) throws IOException, JsonParseException {
            AdminConsoleAppPermission value;
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
            else if ("default_for_listed_apps".equals(tag)) {
                value = AdminConsoleAppPermission.DEFAULT_FOR_LISTED_APPS;
            }
            else if ("default_for_unlisted_apps".equals(tag)) {
                value = AdminConsoleAppPermission.DEFAULT_FOR_UNLISTED_APPS;
            }
            else {
                value = AdminConsoleAppPermission.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
