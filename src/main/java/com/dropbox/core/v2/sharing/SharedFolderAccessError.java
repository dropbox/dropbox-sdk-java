/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * There is an error accessing the shared folder.
 */
public enum SharedFolderAccessError {
    // union SharedFolderAccessError
    /**
     * This shared folder ID is invalid.
     */
    INVALID_ID,
    /**
     * The user is not a member of the shared folder thus cannot access it.
     */
    NOT_A_MEMBER,
    /**
     * The current user does not have sufficient privileges to perform the
     * desired action.
     */
    NO_PERMISSION,
    /**
     * The current account's e-mail address is unverified.
     */
    EMAIL_UNVERIFIED,
    /**
     * The current user cannot perform this action on a team shared folder.
     */
    TEAM_FOLDER,
    /**
     * The shared folder is unmounted.
     */
    UNMOUNTED,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, SharedFolderAccessError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, SharedFolderAccessError>();
        VALUES_.put("invalid_id", INVALID_ID);
        VALUES_.put("not_a_member", NOT_A_MEMBER);
        VALUES_.put("no_permission", NO_PERMISSION);
        VALUES_.put("email_unverified", EMAIL_UNVERIFIED);
        VALUES_.put("team_folder", TEAM_FOLDER);
        VALUES_.put("unmounted", UNMOUNTED);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedFolderAccessError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedFolderAccessError> _JSON_WRITER = new JsonWriter<SharedFolderAccessError>() {
        public void write(SharedFolderAccessError x, JsonGenerator g) throws IOException {
            switch (x) {
                case INVALID_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_id");
                    g.writeEndObject();
                    break;
                case NOT_A_MEMBER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("not_a_member");
                    g.writeEndObject();
                    break;
                case NO_PERMISSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_permission");
                    g.writeEndObject();
                    break;
                case EMAIL_UNVERIFIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("email_unverified");
                    g.writeEndObject();
                    break;
                case TEAM_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_folder");
                    g.writeEndObject();
                    break;
                case UNMOUNTED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unmounted");
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

    public static final JsonReader<SharedFolderAccessError> _JSON_READER = new JsonReader<SharedFolderAccessError>() {
        public final SharedFolderAccessError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
