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

/**
 * Indicates what type of match was found for a given item.
 */
public enum SearchMatchType {
    // union SearchMatchType
    /**
     * This item was matched on its file or folder name.
     */
    FILENAME,
    /**
     * This item was matched based on its file contents.
     */
    CONTENT,
    /**
     * This item was matched based on both its contents and its file name.
     */
    BOTH;

    private static final java.util.HashMap<String, SearchMatchType> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, SearchMatchType>();
        VALUES_.put("filename", FILENAME);
        VALUES_.put("content", CONTENT);
        VALUES_.put("both", BOTH);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SearchMatchType fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SearchMatchType> _JSON_WRITER = new JsonWriter<SearchMatchType>() {
        public void write(SearchMatchType x, JsonGenerator g) throws IOException {
            switch (x) {
                case FILENAME:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("filename");
                    g.writeEndObject();
                    break;
                case CONTENT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("content");
                    g.writeEndObject();
                    break;
                case BOTH:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("both");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<SearchMatchType> _JSON_READER = new JsonReader<SearchMatchType>() {
        public final SearchMatchType read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
