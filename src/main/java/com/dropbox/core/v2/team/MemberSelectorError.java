/* DO NOT EDIT */
/* This file was generated from team_members.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
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

    private static final java.util.HashMap<String, MemberSelectorError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MemberSelectorError>();
        VALUES_.put("user_not_in_team", USER_NOT_IN_TEAM);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MemberSelectorError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MemberSelectorError> _JSON_WRITER = new JsonWriter<MemberSelectorError>() {
        public void write(MemberSelectorError x, JsonGenerator g) throws IOException {
            switch (x) {
                case USER_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("user_not_found");
                    g.writeEndObject();
                    break;
                case USER_NOT_IN_TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("user_not_in_team");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<MemberSelectorError> _JSON_READER = new JsonReader<MemberSelectorError>() {
        public final MemberSelectorError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
