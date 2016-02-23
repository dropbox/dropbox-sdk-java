/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum EmmState {
    // union EmmState
    /**
     * Emm token is disabled
     */
    DISABLED,
    /**
     * Emm token is optional
     */
    OPTIONAL,
    /**
     * Emm token is required
     */
    REQUIRED,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, EmmState> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, EmmState>();
        VALUES_.put("disabled", DISABLED);
        VALUES_.put("optional", OPTIONAL);
        VALUES_.put("required", REQUIRED);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static EmmState fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<EmmState> _JSON_WRITER = new JsonWriter<EmmState>() {
        public void write(EmmState x, JsonGenerator g) throws IOException {
            switch (x) {
                case DISABLED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("disabled");
                    g.writeEndObject();
                    break;
                case OPTIONAL:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("optional");
                    g.writeEndObject();
                    break;
                case REQUIRED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("required");
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

    public static final JsonReader<EmmState> _JSON_READER = new JsonReader<EmmState>() {
        public final EmmState read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
