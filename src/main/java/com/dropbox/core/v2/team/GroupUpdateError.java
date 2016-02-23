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

public enum GroupUpdateError {
    // union GroupUpdateError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER,
    /**
     * The new external ID is already being used by another group.
     */
    EXTERNAL_ID_ALREADY_IN_USE;

    private static final java.util.HashMap<String, GroupUpdateError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, GroupUpdateError>();
        VALUES_.put("external_id_already_in_use", EXTERNAL_ID_ALREADY_IN_USE);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupUpdateError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupUpdateError> _JSON_WRITER = new JsonWriter<GroupUpdateError>() {
        public void write(GroupUpdateError x, JsonGenerator g) throws IOException {
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
                case EXTERNAL_ID_ALREADY_IN_USE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("external_id_already_in_use");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GroupUpdateError> _JSON_READER = new JsonReader<GroupUpdateError>() {
        public final GroupUpdateError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
