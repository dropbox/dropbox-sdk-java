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

public enum MembersUnsuspendError {
    // union MembersUnsuspendError
    /**
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    USER_NOT_FOUND,
    /**
     * The user is not a member of the team.
     */
    USER_NOT_IN_TEAM,
    /**
     * An unspecified error.
     */
    OTHER,
    /**
     * The user is unsuspended, so it cannot be unsuspended again.
     */
    UNSUSPEND_NON_SUSPENDED_MEMBER;

    private static final java.util.HashMap<String, MembersUnsuspendError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MembersUnsuspendError>();
        VALUES_.put("unsuspend_non_suspended_member", UNSUSPEND_NON_SUSPENDED_MEMBER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MembersUnsuspendError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersUnsuspendError> _JSON_WRITER = new JsonWriter<MembersUnsuspendError>() {
        public void write(MembersUnsuspendError x, JsonGenerator g) throws IOException {
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
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
                case UNSUSPEND_NON_SUSPENDED_MEMBER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unsuspend_non_suspended_member");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<MembersUnsuspendError> _JSON_READER = new JsonReader<MembersUnsuspendError>() {
        public final MembersUnsuspendError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
