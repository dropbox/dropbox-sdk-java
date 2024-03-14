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

public enum TrustedNonTeamMemberType {
    // union team_log.TrustedNonTeamMemberType (team_log_generated.stone)
    ENTERPRISE_ADMIN,
    MULTI_INSTANCE_ADMIN,
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
    static class Serializer extends UnionSerializer<TrustedNonTeamMemberType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TrustedNonTeamMemberType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ENTERPRISE_ADMIN: {
                    g.writeString("enterprise_admin");
                    break;
                }
                case MULTI_INSTANCE_ADMIN: {
                    g.writeString("multi_instance_admin");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TrustedNonTeamMemberType deserialize(JsonParser p) throws IOException, JsonParseException {
            TrustedNonTeamMemberType value;
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
            else if ("enterprise_admin".equals(tag)) {
                value = TrustedNonTeamMemberType.ENTERPRISE_ADMIN;
            }
            else if ("multi_instance_admin".equals(tag)) {
                value = TrustedNonTeamMemberType.MULTI_INSTANCE_ADMIN;
            }
            else {
                value = TrustedNonTeamMemberType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
