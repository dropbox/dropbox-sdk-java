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

public enum ListFolderLongpollError {
    // union ListFolderLongpollError
    /**
     * Indicates that the cursor has been invalidated. Call {@link
     * DbxFiles#listFolder(String)} to obtain a new cursor.
     */
    RESET,
    OTHER; // *catch_all

    private static final java.util.HashMap<String, ListFolderLongpollError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, ListFolderLongpollError>();
        VALUES_.put("reset", RESET);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ListFolderLongpollError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ListFolderLongpollError> _JSON_WRITER = new JsonWriter<ListFolderLongpollError>() {
        public void write(ListFolderLongpollError x, JsonGenerator g) throws IOException {
            switch (x) {
                case RESET:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("reset");
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

    public static final JsonReader<ListFolderLongpollError> _JSON_READER = new JsonReader<ListFolderLongpollError>() {
        public final ListFolderLongpollError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
