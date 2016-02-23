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

public enum ThumbnailFormat {
    // union ThumbnailFormat
    JPEG,
    PNG;

    private static final java.util.HashMap<String, ThumbnailFormat> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, ThumbnailFormat>();
        VALUES_.put("jpeg", JPEG);
        VALUES_.put("png", PNG);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ThumbnailFormat fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ThumbnailFormat> _JSON_WRITER = new JsonWriter<ThumbnailFormat>() {
        public void write(ThumbnailFormat x, JsonGenerator g) throws IOException {
            switch (x) {
                case JPEG:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("jpeg");
                    g.writeEndObject();
                    break;
                case PNG:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("png");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<ThumbnailFormat> _JSON_READER = new JsonReader<ThumbnailFormat>() {
        public final ThumbnailFormat read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
