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

public enum GroupDeleteError {
    // union GroupDeleteError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * This group has already been deleted.
     */
    GROUP_ALREADY_DELETED;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<GroupDeleteError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupDeleteError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case GROUP_NOT_FOUND: {
                    g.writeString("group_not_found");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case GROUP_ALREADY_DELETED: {
                    g.writeString("group_already_deleted");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public GroupDeleteError deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupDeleteError value;
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
                value = GroupDeleteError.GROUP_NOT_FOUND;
            }
            else if ("other".equals(tag)) {
                value = GroupDeleteError.OTHER;
            }
            else if ("group_already_deleted".equals(tag)) {
                value = GroupDeleteError.GROUP_ALREADY_DELETED;
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
