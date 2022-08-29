/* DO NOT EDIT */
/* This file was generated from team_policies.stone */

package com.dropbox.core.v2.teampolicies;

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

public enum RolloutMethod {
    // union team_policies.RolloutMethod (team_policies.stone)
    /**
     * Unlink all.
     */
    UNLINK_ALL,
    /**
     * Unlink devices with the most inactivity.
     */
    UNLINK_MOST_INACTIVE,
    /**
     * Add member to Exceptions.
     */
    ADD_MEMBER_TO_EXCEPTIONS;

    /**
     * For internal use only.
     */
    public static class Serializer extends UnionSerializer<RolloutMethod> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RolloutMethod value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case UNLINK_ALL: {
                    g.writeString("unlink_all");
                    break;
                }
                case UNLINK_MOST_INACTIVE: {
                    g.writeString("unlink_most_inactive");
                    break;
                }
                case ADD_MEMBER_TO_EXCEPTIONS: {
                    g.writeString("add_member_to_exceptions");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public RolloutMethod deserialize(JsonParser p) throws IOException, JsonParseException {
            RolloutMethod value;
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
            else if ("unlink_all".equals(tag)) {
                value = RolloutMethod.UNLINK_ALL;
            }
            else if ("unlink_most_inactive".equals(tag)) {
                value = RolloutMethod.UNLINK_MOST_INACTIVE;
            }
            else if ("add_member_to_exceptions".equals(tag)) {
                value = RolloutMethod.ADD_MEMBER_TO_EXCEPTIONS;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
