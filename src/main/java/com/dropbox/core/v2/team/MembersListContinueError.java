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

public enum MembersListContinueError {
    // union MembersListContinueError
    /**
     * The cursor is invalid.
     */
    INVALID_CURSOR,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, MembersListContinueError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MembersListContinueError>();
        VALUES_.put("invalid_cursor", INVALID_CURSOR);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MembersListContinueError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersListContinueError> _JSON_WRITER = new JsonWriter<MembersListContinueError>() {
        public void write(MembersListContinueError x, JsonGenerator g) throws IOException {
            switch (x) {
                case INVALID_CURSOR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_cursor");
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

    public static final JsonReader<MembersListContinueError> _JSON_READER = new JsonReader<MembersListContinueError>() {
        public final MembersListContinueError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
