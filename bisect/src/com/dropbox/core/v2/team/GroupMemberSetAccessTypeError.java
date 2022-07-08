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

public enum GroupMemberSetAccessTypeError {
    // union team.GroupMemberSetAccessTypeError (team_groups.stone)
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    OTHER,
    /**
     * This operation is not supported on system-managed groups.
     */
    SYSTEM_MANAGED_GROUP_DISALLOWED,
    /**
     * The specified user is not a member of this group.
     */
    MEMBER_NOT_IN_GROUP,
    /**
     * A company managed group cannot be managed by a user.
     */
    USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP;

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<GroupMemberSetAccessTypeError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupMemberSetAccessTypeError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case GROUP_NOT_FOUND: {
                    g.writeString("group_not_found");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case SYSTEM_MANAGED_GROUP_DISALLOWED: {
                    g.writeString("system_managed_group_disallowed");
                    break;
                }
                case MEMBER_NOT_IN_GROUP: {
                    g.writeString("member_not_in_group");
                    break;
                }
                case USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP: {
                    g.writeString("user_cannot_be_manager_of_company_managed_group");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public GroupMemberSetAccessTypeError deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupMemberSetAccessTypeError value;
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
            else if ("group_not_found".equals(tag)) {
                value = GroupMemberSetAccessTypeError.GROUP_NOT_FOUND;
            }
            else if ("other".equals(tag)) {
                value = GroupMemberSetAccessTypeError.OTHER;
            }
            else if ("system_managed_group_disallowed".equals(tag)) {
                value = GroupMemberSetAccessTypeError.SYSTEM_MANAGED_GROUP_DISALLOWED;
            }
            else if ("member_not_in_group".equals(tag)) {
                value = GroupMemberSetAccessTypeError.MEMBER_NOT_IN_GROUP;
            }
            else if ("user_cannot_be_manager_of_company_managed_group".equals(tag)) {
                value = GroupMemberSetAccessTypeError.USER_CANNOT_BE_MANAGER_OF_COMPANY_MANAGED_GROUP;
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
