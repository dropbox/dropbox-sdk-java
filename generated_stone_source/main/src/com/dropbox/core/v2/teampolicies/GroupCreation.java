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

public enum GroupCreation {
    // union team_policies.GroupCreation (team_policies.stone)
    /**
     * Team admins and members can create groups.
     */
    ADMINS_AND_MEMBERS,
    /**
     * Only team admins can create groups.
     */
    ADMINS_ONLY;

    /**
     * For internal use only.
     */
    public static class Serializer extends UnionSerializer<GroupCreation> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupCreation value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ADMINS_AND_MEMBERS: {
                    g.writeString("admins_and_members");
                    break;
                }
                case ADMINS_ONLY: {
                    g.writeString("admins_only");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public GroupCreation deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupCreation value;
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
            else if ("admins_and_members".equals(tag)) {
                value = GroupCreation.ADMINS_AND_MEMBERS;
            }
            else if ("admins_only".equals(tag)) {
                value = GroupCreation.ADMINS_ONLY;
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
