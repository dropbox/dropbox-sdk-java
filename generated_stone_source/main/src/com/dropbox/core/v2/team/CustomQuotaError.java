/* DO NOT EDIT */
/* This file was generated from team_member_space_limits.stone */

package com.dropbox.core.v2.team;

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
 * Error returned when getting member custom quota.
 */
public enum CustomQuotaError {
    // union team.CustomQuotaError (team_member_space_limits.stone)
    /**
     * A maximum of 1000 users can be set for a single call.
     */
    TOO_MANY_USERS,
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
    static class Serializer extends UnionSerializer<CustomQuotaError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(CustomQuotaError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case TOO_MANY_USERS: {
                    g.writeString("too_many_users");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public CustomQuotaError deserialize(JsonParser p) throws IOException, JsonParseException {
            CustomQuotaError value;
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
            else if ("too_many_users".equals(tag)) {
                value = CustomQuotaError.TOO_MANY_USERS;
            }
            else {
                value = CustomQuotaError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
