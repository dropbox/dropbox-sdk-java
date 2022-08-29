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
 * Defines who has access to a shared link.
 */
public enum SharedLinkVisibility {
    // union team_log.SharedLinkVisibility (team_log_generated.stone)
    NO_ONE,
    PASSWORD,
    PUBLIC,
    TEAM_ONLY,
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
    static class Serializer extends UnionSerializer<SharedLinkVisibility> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedLinkVisibility value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case NO_ONE: {
                    g.writeString("no_one");
                    break;
                }
                case PASSWORD: {
                    g.writeString("password");
                    break;
                }
                case PUBLIC: {
                    g.writeString("public");
                    break;
                }
                case TEAM_ONLY: {
                    g.writeString("team_only");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharedLinkVisibility deserialize(JsonParser p) throws IOException, JsonParseException {
            SharedLinkVisibility value;
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
            else if ("no_one".equals(tag)) {
                value = SharedLinkVisibility.NO_ONE;
            }
            else if ("password".equals(tag)) {
                value = SharedLinkVisibility.PASSWORD;
            }
            else if ("public".equals(tag)) {
                value = SharedLinkVisibility.PUBLIC;
            }
            else if ("team_only".equals(tag)) {
                value = SharedLinkVisibility.TEAM_ONLY;
            }
            else {
                value = SharedLinkVisibility.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
