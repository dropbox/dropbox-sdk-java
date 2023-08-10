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
 * Policy for controlling if team members can share links externally
 */
public enum SharingLinkPolicy {
    // union team_log.SharingLinkPolicy (team_log_generated.stone)
    DEFAULT_NO_ONE,
    DEFAULT_PRIVATE,
    DEFAULT_PUBLIC,
    ONLY_PRIVATE,
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
    static class Serializer extends UnionSerializer<SharingLinkPolicy> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingLinkPolicy value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case DEFAULT_NO_ONE: {
                    g.writeString("default_no_one");
                    break;
                }
                case DEFAULT_PRIVATE: {
                    g.writeString("default_private");
                    break;
                }
                case DEFAULT_PUBLIC: {
                    g.writeString("default_public");
                    break;
                }
                case ONLY_PRIVATE: {
                    g.writeString("only_private");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public SharingLinkPolicy deserialize(JsonParser p) throws IOException, JsonParseException {
            SharingLinkPolicy value;
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
            else if ("default_no_one".equals(tag)) {
                value = SharingLinkPolicy.DEFAULT_NO_ONE;
            }
            else if ("default_private".equals(tag)) {
                value = SharingLinkPolicy.DEFAULT_PRIVATE;
            }
            else if ("default_public".equals(tag)) {
                value = SharingLinkPolicy.DEFAULT_PUBLIC;
            }
            else if ("only_private".equals(tag)) {
                value = SharingLinkPolicy.ONLY_PRIVATE;
            }
            else {
                value = SharingLinkPolicy.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
