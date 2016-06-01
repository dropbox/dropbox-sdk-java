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

/**
 * The user's status as a member of a specific team.
 */
public enum TeamMemberStatus {
    // union TeamMemberStatus
    /**
     * User has successfully joined the team.
     */
    ACTIVE,
    /**
     * User has been invited to a team, but has not joined the team yet.
     */
    INVITED,
    /**
     * User is no longer a member of the team, but the account can be
     * un-suspended, re-establishing the user as a team member.
     */
    SUSPENDED;

    /**
     * For internal use only.
     */
    static final class Serializer extends UnionSerializer<TeamMemberStatus> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamMemberStatus value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value) {
                case ACTIVE: {
                    g.writeString("active");
                    break;
                }
                case INVITED: {
                    g.writeString("invited");
                    break;
                }
                case SUSPENDED: {
                    g.writeString("suspended");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value);
                }
            }
        }

        @Override
        public TeamMemberStatus deserialize(JsonParser p) throws IOException, JsonParseException {
            TeamMemberStatus value;
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
            else if ("active".equals(tag)) {
                value = TeamMemberStatus.ACTIVE;
            }
            else if ("invited".equals(tag)) {
                value = TeamMemberStatus.INVITED;
            }
            else if ("suspended".equals(tag)) {
                value = TeamMemberStatus.SUSPENDED;
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
