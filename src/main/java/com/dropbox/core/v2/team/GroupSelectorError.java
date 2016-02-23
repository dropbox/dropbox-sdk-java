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

/**
 * Error that can be raised when {@link GroupSelector}is used.
 */
public enum GroupSelectorError {
    // union GroupSelectorError
    /**
     * No matching group found. No groups match the specified group ID.
     */
    GROUP_NOT_FOUND,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, GroupSelectorError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, GroupSelectorError>();
        VALUES_.put("group_not_found", GROUP_NOT_FOUND);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GroupSelectorError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GroupSelectorError> _JSON_WRITER = new JsonWriter<GroupSelectorError>() {
        public void write(GroupSelectorError x, JsonGenerator g) throws IOException {
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
            }
        }
    };

    public static final JsonReader<GroupSelectorError> _JSON_READER = new JsonReader<GroupSelectorError>() {
        public final GroupSelectorError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
