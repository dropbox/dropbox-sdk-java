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

public enum MemberSelectorError {
    // union MemberSelectorError
    /**
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    USER_NOT_FOUND,
    /**
     * The user is not a member of the team.
     */
    USER_NOT_IN_TEAM;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<MemberSelectorError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MemberSelectorError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case USER_NOT_FOUND: {
                    g.writeString("user_not_found");
                    break;
                }
                case USER_NOT_IN_TEAM: {
                    g.writeString("user_not_in_team");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public MemberSelectorError deserialize(JsonParser p) throws IOException, JsonParseException {
            MemberSelectorError value;
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
            else if ("user_not_found".equals(tag)) {
                value = MemberSelectorError.USER_NOT_FOUND;
            }
            else if ("user_not_in_team".equals(tag)) {
                value = MemberSelectorError.USER_NOT_IN_TEAM;
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
