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

public enum SearchMode {
    // union SearchMode
    /**
     * Search file and folder names.
     */
    FILENAME,
    /**
     * Search file and folder names as well as file contents.
     */
    FILENAME_AND_CONTENT,
    /**
     * Search for deleted file and folder names.
     */
    DELETED_FILENAME;

    private static final java.util.HashMap<String, SearchMode> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, SearchMode>();
        VALUES_.put("filename", FILENAME);
        VALUES_.put("filename_and_content", FILENAME_AND_CONTENT);
        VALUES_.put("deleted_filename", DELETED_FILENAME);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SearchMode fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SearchMode> _JSON_WRITER = new JsonWriter<SearchMode>() {
        public void write(SearchMode x, JsonGenerator g) throws IOException {
            switch (x) {
                case FILENAME:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("filename");
                    g.writeEndObject();
                    break;
                case FILENAME_AND_CONTENT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("filename_and_content");
                    g.writeEndObject();
                    break;
                case DELETED_FILENAME:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("deleted_filename");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<SearchMode> _JSON_READER = new JsonReader<SearchMode>() {
        public final SearchMode read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
