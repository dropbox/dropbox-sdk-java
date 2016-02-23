/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum WriteConflictError {
    // union WriteConflictError
    /**
     * There's a file in the way.
     */
    FILE,
    /**
     * There's a folder in the way.
     */
    FOLDER,
    /**
     * There's a file at an ancestor path, so we couldn't create the required
     * parent folders.
     */
    FILE_ANCESTOR,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, WriteConflictError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, WriteConflictError>();
        VALUES_.put("file", FILE);
        VALUES_.put("folder", FOLDER);
        VALUES_.put("file_ancestor", FILE_ANCESTOR);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static WriteConflictError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<WriteConflictError> _JSON_WRITER = new JsonWriter<WriteConflictError>() {
        public void write(WriteConflictError x, JsonGenerator g) throws IOException {
            switch (x) {
                case FILE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("file");
                    g.writeEndObject();
                    break;
                case FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("folder");
                    g.writeEndObject();
                    break;
                case FILE_ANCESTOR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("file_ancestor");
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

    public static final JsonReader<WriteConflictError> _JSON_READER = new JsonReader<WriteConflictError>() {
        public final WriteConflictError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
