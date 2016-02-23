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

public enum MembersSuspendError {
    // union MembersSuspendError
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
     * The user is not active, so it cannot be suspended.
     */
    SUSPEND_INACTIVE_USER,
    /**
     * The user is the last admin of the team, so it cannot be suspended.
     */
    SUSPEND_LAST_ADMIN;

    private static final java.util.HashMap<String, MembersSuspendError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MembersSuspendError>();
        VALUES_.put("suspend_inactive_user", SUSPEND_INACTIVE_USER);
        VALUES_.put("suspend_last_admin", SUSPEND_LAST_ADMIN);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MembersSuspendError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersSuspendError> _JSON_WRITER = new JsonWriter<MembersSuspendError>() {
        public void write(MembersSuspendError x, JsonGenerator g) throws IOException {
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
                case SUSPEND_INACTIVE_USER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("suspend_inactive_user");
                    g.writeEndObject();
                    break;
                case SUSPEND_LAST_ADMIN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("suspend_last_admin");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<MembersSuspendError> _JSON_READER = new JsonReader<MembersSuspendError>() {
        public final MembersSuspendError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
