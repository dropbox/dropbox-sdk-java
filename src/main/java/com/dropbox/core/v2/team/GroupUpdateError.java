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

public enum GroupUpdateError {
    // union GroupUpdateError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * The new external ID is already being used by another group.
     */
    EXTERNAL_ID_ALREADY_IN_USE;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<GroupUpdateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupUpdateError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case GROUP_NOT_FOUND: {
                    g.writeString("group_not_found");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case EXTERNAL_ID_ALREADY_IN_USE: {
                    g.writeString("external_id_already_in_use");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public GroupUpdateError deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupUpdateError value;
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
                value = GroupUpdateError.GROUP_NOT_FOUND;
            }
            else if ("other".equals(tag)) {
                value = GroupUpdateError.OTHER;
            }
            else if ("external_id_already_in_use".equals(tag)) {
                value = GroupUpdateError.EXTERNAL_ID_ALREADY_IN_USE;
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
