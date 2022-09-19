/* DO NOT EDIT */
/* This file was generated from team_common.stone */

package com.dropbox.core.v2.teamcommon;

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
 * The group type determines how a group is managed.
 */
public enum GroupManagementType {
    // union team_common.GroupManagementType (team_common.stone)
    /**
     * A group which is managed by selected users.
     */
    USER_MANAGED,
    /**
     * A group which is managed by team admins only.
     */
    COMPANY_MANAGED,
    /**
     * A group which is managed automatically by Dropbox.
     */
    SYSTEM_MANAGED,
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
    public static class Serializer extends UnionSerializer<GroupManagementType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupManagementType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case USER_MANAGED: {
                    g.writeString("user_managed");
                    break;
                }
                case COMPANY_MANAGED: {
                    g.writeString("company_managed");
                    break;
                }
                case SYSTEM_MANAGED: {
                    g.writeString("system_managed");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GroupManagementType deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupManagementType value;
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
            else if ("user_managed".equals(tag)) {
                value = GroupManagementType.USER_MANAGED;
            }
            else if ("company_managed".equals(tag)) {
                value = GroupManagementType.COMPANY_MANAGED;
            }
            else if ("system_managed".equals(tag)) {
                value = GroupManagementType.SYSTEM_MANAGED;
            }
            else {
                value = GroupManagementType.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
