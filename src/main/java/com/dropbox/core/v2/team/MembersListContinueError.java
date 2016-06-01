/* DO NOT EDIT */
/* This file was generated from team_members.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum MembersListContinueError {
    // union MembersListContinueError
    /**
     * The cursor is invalid.
     */
    INVALID_CURSOR,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<MembersListContinueError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MembersListContinueError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case INVALID_CURSOR: {
                    g.writeString("invalid_cursor");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MembersListContinueError deserialize(JsonParser p) throws IOException, JsonParseException {
            MembersListContinueError value;
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
            else if ("invalid_cursor".equals(tag)) {
                value = MembersListContinueError.INVALID_CURSOR;
            }
            else {
                value = MembersListContinueError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
