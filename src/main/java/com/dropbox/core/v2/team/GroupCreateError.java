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

public enum GroupCreateError {
    // union GroupCreateError
    /**
     * There is already an existing group with the requested name.
     */
    GROUP_NAME_ALREADY_USED,
    /**
     * Group name is empty or has invalid characters.
     */
    GROUP_NAME_INVALID,
    /**
     * The new external ID is already being used by another group.
     */
    EXTERNAL_ID_ALREADY_IN_USE,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, GroupCreateError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, GroupCreateError>();
        VALUES_.put("group_name_already_used", GROUP_NAME_ALREADY_USED);
        VALUES_.put("group_name_invalid", GROUP_NAME_INVALID);
        VALUES_.put("external_id_already_in_use", EXTERNAL_ID_ALREADY_IN_USE);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupCreateError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupCreateError> _JSON_WRITER = new JsonWriter<GroupCreateError>() {
        public void write(GroupCreateError x, JsonGenerator g) throws IOException {
            switch (x) {
                case GROUP_NAME_ALREADY_USED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_name_already_used");
                    g.writeEndObject();
                    break;
                case GROUP_NAME_INVALID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_name_invalid");
                    g.writeEndObject();
                    break;
                case EXTERNAL_ID_ALREADY_IN_USE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("external_id_already_in_use");
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

    public static final JsonReader<GroupCreateError> _JSON_READER = new JsonReader<GroupCreateError>() {
        public final GroupCreateError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
