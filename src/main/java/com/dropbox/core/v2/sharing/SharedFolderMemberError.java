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

public enum SharedFolderMemberError {
    // union SharedFolderMemberError
    /**
     * The target dropbox_id is invalid.
     */
    INVALID_DROPBOX_ID,
    /**
     * The target dropbox_id is not a member of the shared folder.
     */
    NOT_A_MEMBER,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, SharedFolderMemberError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, SharedFolderMemberError>();
        VALUES_.put("invalid_dropbox_id", INVALID_DROPBOX_ID);
        VALUES_.put("not_a_member", NOT_A_MEMBER);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedFolderMemberError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedFolderMemberError> _JSON_WRITER = new JsonWriter<SharedFolderMemberError>() {
        public void write(SharedFolderMemberError x, JsonGenerator g) throws IOException {
            switch (x) {
                case INVALID_DROPBOX_ID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_dropbox_id");
                    g.writeEndObject();
                    break;
                case NOT_A_MEMBER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("not_a_member");
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

    public static final JsonReader<SharedFolderMemberError> _JSON_READER = new JsonReader<SharedFolderMemberError>() {
        public final SharedFolderMemberError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
