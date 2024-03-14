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

/**
 * Error that can be raised when {@link GroupSelector} is used.
 */
public enum GroupSelectorError {
    // union team.GroupSelectorError (team_groups.stone)
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
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static class Serializer extends UnionSerializer<GroupSelectorError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GroupSelectorError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case GROUP_NOT_FOUND: {
                    g.writeString("group_not_found");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public GroupSelectorError deserialize(JsonParser p) throws IOException, JsonParseException {
            GroupSelectorError value;
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
                value = GroupSelectorError.GROUP_NOT_FOUND;
            }
            else {
                value = GroupSelectorError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
