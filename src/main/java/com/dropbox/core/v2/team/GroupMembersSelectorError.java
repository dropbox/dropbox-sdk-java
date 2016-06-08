/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Error that can be raised when {@code GroupMembersSelector} is used, and the
 * users are required to be members of the specified group.
 */
public enum GroupMembersSelectorError {
    // union GroupMembersSelectorError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * At least one of the specified users is not a member of the group.
     */
    MEMBER_NOT_IN_GROUP;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<GroupMembersSelectorError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupMembersSelectorError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case GROUP_NOT_FOUND: {
                    g.writeString("group_not_found");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case MEMBER_NOT_IN_GROUP: {
                    g.writeString("member_not_in_group");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public GroupMembersSelectorError deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupMembersSelectorError value;
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
                value = GroupMembersSelectorError.GROUP_NOT_FOUND;
            }
            else if ("other".equals(tag)) {
                value = GroupMembersSelectorError.OTHER;
            }
            else if ("member_not_in_group".equals(tag)) {
                value = GroupMembersSelectorError.MEMBER_NOT_IN_GROUP;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
