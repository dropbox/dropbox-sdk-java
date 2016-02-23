/* DO NOT EDIT */
/* This file was generated from team_groups.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum GroupDeleteError {
    // union GroupDeleteError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * This group has already been deleted.
     */
    GROUP_ALREADY_DELETED;

    private static final java.util.HashMap<String, GroupDeleteError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, GroupDeleteError>();
        VALUES_.put("group_already_deleted", GROUP_ALREADY_DELETED);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupDeleteError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupDeleteError> _JSON_WRITER = new JsonWriter<GroupDeleteError>() {
        public void write(GroupDeleteError x, JsonGenerator g) throws IOException {
            switch (x) {
                case GROUP_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_not_found");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
                case GROUP_ALREADY_DELETED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_already_deleted");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GroupDeleteError> _JSON_READER = new JsonReader<GroupDeleteError>() {
        public final GroupDeleteError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
