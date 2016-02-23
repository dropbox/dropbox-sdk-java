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

public enum MembersRemoveError {
    // union MembersRemoveError
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
     * The user is the last admin of the team, so it cannot be removed from it.
     */
    REMOVE_LAST_ADMIN,
    /**
     * Expected removed user and transfer_dest user to be different
     */
    REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER,
    /**
     * Expected removed user and transfer_admin user to be different.
     */
    REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER,
    /**
     * No matching user found for the argument transfer_dest_id.
     */
    TRANSFER_DEST_USER_NOT_FOUND,
    /**
     * The provided transfer_dest_id does not exist on this team.
     */
    TRANSFER_DEST_USER_NOT_IN_TEAM,
    /**
     * No matching user found for the argument transfer_admin_id.
     */
    TRANSFER_ADMIN_USER_NOT_FOUND,
    /**
     * The provided transfer_admin_id does not exist on this team.
     */
    TRANSFER_ADMIN_USER_NOT_IN_TEAM,
    /**
     * The transfer_admin_id argument must be provided when file transfer is
     * requested.
     */
    UNSPECIFIED_TRANSFER_ADMIN_ID,
    /**
     * Specified transfer_admin user is not a team admin.
     */
    TRANSFER_ADMIN_IS_NOT_ADMIN;

    private static final java.util.HashMap<String, MembersRemoveError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MembersRemoveError>();
        VALUES_.put("remove_last_admin", REMOVE_LAST_ADMIN);
        VALUES_.put("removed_and_transfer_dest_should_differ", REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER);
        VALUES_.put("removed_and_transfer_admin_should_differ", REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER);
        VALUES_.put("transfer_dest_user_not_found", TRANSFER_DEST_USER_NOT_FOUND);
        VALUES_.put("transfer_dest_user_not_in_team", TRANSFER_DEST_USER_NOT_IN_TEAM);
        VALUES_.put("transfer_admin_user_not_found", TRANSFER_ADMIN_USER_NOT_FOUND);
        VALUES_.put("transfer_admin_user_not_in_team", TRANSFER_ADMIN_USER_NOT_IN_TEAM);
        VALUES_.put("unspecified_transfer_admin_id", UNSPECIFIED_TRANSFER_ADMIN_ID);
        VALUES_.put("transfer_admin_is_not_admin", TRANSFER_ADMIN_IS_NOT_ADMIN);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MembersRemoveError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersRemoveError> _JSON_WRITER = new JsonWriter<MembersRemoveError>() {
        public void write(MembersRemoveError x, JsonGenerator g) throws IOException {
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
                case REMOVE_LAST_ADMIN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("remove_last_admin");
                    g.writeEndObject();
                    break;
                case REMOVED_AND_TRANSFER_DEST_SHOULD_DIFFER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("removed_and_transfer_dest_should_differ");
                    g.writeEndObject();
                    break;
                case REMOVED_AND_TRANSFER_ADMIN_SHOULD_DIFFER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("removed_and_transfer_admin_should_differ");
                    g.writeEndObject();
                    break;
                case TRANSFER_DEST_USER_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("transfer_dest_user_not_found");
                    g.writeEndObject();
                    break;
                case TRANSFER_DEST_USER_NOT_IN_TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("transfer_dest_user_not_in_team");
                    g.writeEndObject();
                    break;
                case TRANSFER_ADMIN_USER_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("transfer_admin_user_not_found");
                    g.writeEndObject();
                    break;
                case TRANSFER_ADMIN_USER_NOT_IN_TEAM:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("transfer_admin_user_not_in_team");
                    g.writeEndObject();
                    break;
                case UNSPECIFIED_TRANSFER_ADMIN_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unspecified_transfer_admin_id");
                    g.writeEndObject();
                    break;
                case TRANSFER_ADMIN_IS_NOT_ADMIN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("transfer_admin_is_not_admin");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<MembersRemoveError> _JSON_READER = new JsonReader<MembersRemoveError>() {
        public final MembersRemoveError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
