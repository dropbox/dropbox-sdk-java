/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
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

    private static final java.util.HashMap<String, TeamMemberStatus> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, TeamMemberStatus>();
        VALUES_.put("active", ACTIVE);
        VALUES_.put("invited", INVITED);
        VALUES_.put("suspended", SUSPENDED);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static TeamMemberStatus fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<TeamMemberStatus> _JSON_WRITER = new JsonWriter<TeamMemberStatus>() {
        public void write(TeamMemberStatus x, JsonGenerator g) throws IOException {
            switch (x) {
                case ACTIVE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("active");
                    g.writeEndObject();
                    break;
                case INVITED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invited");
                    g.writeEndObject();
                    break;
                case SUSPENDED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("suspended");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<TeamMemberStatus> _JSON_READER = new JsonReader<TeamMemberStatus>() {
        public final TeamMemberStatus read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
