/* DO NOT EDIT */
/* This file was generated from team_reports.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Errors that can originate from problems in input arguments to reports.
 */
public enum DateRangeError {
    // union DateRangeError
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, DateRangeError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, DateRangeError>();
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static DateRangeError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<DateRangeError> _JSON_WRITER = new JsonWriter<DateRangeError>() {
        public void write(DateRangeError x, JsonGenerator g) throws IOException {
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

    public static final JsonReader<DateRangeError> _JSON_READER = new JsonReader<DateRangeError>() {
        public final DateRangeError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
