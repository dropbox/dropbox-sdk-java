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

public enum MembersSetPermissionsError {
    // union MembersSetPermissionsError
    /**
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    USER_NOT_FOUND,
    /**
     * Cannot remove the admin setting of the last admin.
     */
    LAST_ADMIN,
    /**
     * The user is not a member of the team.
     */
    USER_NOT_IN_TEAM,
    /**
     * Cannot remove/grant permissions.
     */
    CANNOT_SET_PERMISSIONS,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, MembersSetPermissionsError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MembersSetPermissionsError>();
        VALUES_.put("last_admin", LAST_ADMIN);
        VALUES_.put("user_not_in_team", USER_NOT_IN_TEAM);
        VALUES_.put("cannot_set_permissions", CANNOT_SET_PERMISSIONS);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MembersSetPermissionsError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersSetPermissionsError> _JSON_WRITER = new JsonWriter<MembersSetPermissionsError>() {
        public void write(MembersSetPermissionsError x, JsonGenerator g) throws IOException {
            switch (x) {
                case USER_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("user_not_found");
                    g.writeEndObject();
                    break;
                case LAST_ADMIN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("last_admin");
                    g.writeEndObject();
                    break;
                case USER_NOT_IN_TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("user_not_in_team");
                    g.writeEndObject();
                    break;
                case CANNOT_SET_PERMISSIONS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("cannot_set_permissions");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<MembersSetPermissionsError> _JSON_READER = new JsonReader<MembersSetPermissionsError>() {
        public final MembersSetPermissionsError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
