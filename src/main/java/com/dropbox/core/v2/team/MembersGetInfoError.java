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

public enum MembersGetInfoError {
    // union MembersGetInfoError
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, MembersGetInfoError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MembersGetInfoError>();
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MembersGetInfoError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MembersGetInfoError> _JSON_WRITER = new JsonWriter<MembersGetInfoError>() {
        public void write(MembersGetInfoError x, JsonGenerator g) throws IOException {
            switch (x) {
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<MembersGetInfoError> _JSON_READER = new JsonReader<MembersGetInfoError>() {
        public final MembersGetInfoError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
