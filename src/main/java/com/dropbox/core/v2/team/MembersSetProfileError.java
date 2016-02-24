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

public enum MembersSetProfileError {
    // union MembersSetProfileError
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
     * It is unsafe to use both external_id and new_external_id
     */
    EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE,
    /**
     * None of new_email, new_given_name, new_surname, or new_external_id are
     * specified
     */
    NO_NEW_DATA_SPECIFIED,
    /**
     * Email is already reserved for another user.
     */
    EMAIL_RESERVED_FOR_OTHER_USER,
    /**
     * The external ID is already in use by another team member.
     */
    EXTERNAL_ID_USED_BY_OTHER_USER,
    /**
     * Setting profile disallowed
     */
    SET_PROFILE_DISALLOWED,
    /**
     * Parameter new_email cannot be empty.
     */
    PARAM_CANNOT_BE_EMPTY,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, MembersSetProfileError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MembersSetProfileError>();
        VALUES_.put("external_id_and_new_external_id_unsafe", EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE);
        VALUES_.put("no_new_data_specified", NO_NEW_DATA_SPECIFIED);
        VALUES_.put("email_reserved_for_other_user", EMAIL_RESERVED_FOR_OTHER_USER);
        VALUES_.put("external_id_used_by_other_user", EXTERNAL_ID_USED_BY_OTHER_USER);
        VALUES_.put("set_profile_disallowed", SET_PROFILE_DISALLOWED);
        VALUES_.put("param_cannot_be_empty", PARAM_CANNOT_BE_EMPTY);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MembersSetProfileError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersSetProfileError> _JSON_WRITER = new JsonWriter<MembersSetProfileError>() {
        public void write(MembersSetProfileError x, JsonGenerator g) throws IOException {
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
                case EXTERNAL_ID_AND_NEW_EXTERNAL_ID_UNSAFE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("external_id_and_new_external_id_unsafe");
                    g.writeEndObject();
                    break;
                case NO_NEW_DATA_SPECIFIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_new_data_specified");
                    g.writeEndObject();
                    break;
                case EMAIL_RESERVED_FOR_OTHER_USER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("email_reserved_for_other_user");
                    g.writeEndObject();
                    break;
                case EXTERNAL_ID_USED_BY_OTHER_USER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("external_id_used_by_other_user");
                    g.writeEndObject();
                    break;
                case SET_PROFILE_DISALLOWED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("set_profile_disallowed");
                    g.writeEndObject();
                    break;
                case PARAM_CANNOT_BE_EMPTY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("param_cannot_be_empty");
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

    public static final JsonReader<MembersSetProfileError> _JSON_READER = new JsonReader<MembersSetProfileError>() {
        public final MembersSetProfileError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
