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

public enum IdentifierType {
    // union team_log.IdentifierType (team_log_generated.stone)
    EMAIL,
    FACEBOOK_PROFILE_NAME,
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
    static class Serializer extends UnionSerializer<IdentifierType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(IdentifierType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case EMAIL: {
                    g.writeString("email");
                    break;
                }
                case FACEBOOK_PROFILE_NAME: {
                    g.writeString("facebook_profile_name");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public IdentifierType deserialize(JsonParser p) throws IOException, JsonParseException {
            IdentifierType value;
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
            else if ("email".equals(tag)) {
                value = IdentifierType.EMAIL;
            }
            else if ("facebook_profile_name".equals(tag)) {
                value = IdentifierType.FACEBOOK_PROFILE_NAME;
            }
            else {
                value = IdentifierType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
