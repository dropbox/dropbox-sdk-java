/* DO NOT EDIT */
/* This file was generated from team.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum TeamMembershipType {
    // union TeamMembershipType
    /**
     * User uses a license and has full access to team resources like the shared
     * quota.
     */
    FULL,
    /**
     * User does not have access to the shared quota and team admins have
     * restricted administrative control.
     */
    LIMITED;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<TeamMembershipType> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMembershipType value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case FULL: {
                    g.writeString("full");
                    break;
                }
                case LIMITED: {
                    g.writeString("limited");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public TeamMembershipType deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamMembershipType value;
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
            else if ("full".equals(tag)) {
                value = TeamMembershipType.FULL;
            }
            else if ("limited".equals(tag)) {
                value = TeamMembershipType.LIMITED;
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
