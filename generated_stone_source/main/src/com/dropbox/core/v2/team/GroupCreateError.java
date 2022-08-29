/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

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

public enum GroupCreateError {
    // union team.GroupCreateError (team_groups.stone)
    /**
     * The requested group name is already being used by another group.
     */
    GROUP_NAME_ALREADY_USED,
    /**
     * Group name is empty or has invalid characters.
     */
    GROUP_NAME_INVALID,
    /**
     * The requested external ID is already being used by another group.
     */
    EXTERNAL_ID_ALREADY_IN_USE,
    /**
     * System-managed group cannot be manually created.
     */
    SYSTEM_MANAGED_GROUP_DISALLOWED,
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
    static class Serializer extends UnionSerializer<GroupCreateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupCreateError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case GROUP_NAME_ALREADY_USED: {
                    g.writeString("group_name_already_used");
                    break;
                }
                case GROUP_NAME_INVALID: {
                    g.writeString("group_name_invalid");
                    break;
                }
                case EXTERNAL_ID_ALREADY_IN_USE: {
                    g.writeString("external_id_already_in_use");
                    break;
                }
                case SYSTEM_MANAGED_GROUP_DISALLOWED: {
                    g.writeString("system_managed_group_disallowed");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GroupCreateError deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupCreateError value;
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
            else if ("group_name_already_used".equals(tag)) {
                value = GroupCreateError.GROUP_NAME_ALREADY_USED;
            }
            else if ("group_name_invalid".equals(tag)) {
                value = GroupCreateError.GROUP_NAME_INVALID;
            }
            else if ("external_id_already_in_use".equals(tag)) {
                value = GroupCreateError.EXTERNAL_ID_ALREADY_IN_USE;
            }
            else if ("system_managed_group_disallowed".equals(tag)) {
                value = GroupCreateError.SYSTEM_MANAGED_GROUP_DISALLOWED;
            }
            else {
                value = GroupCreateError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
