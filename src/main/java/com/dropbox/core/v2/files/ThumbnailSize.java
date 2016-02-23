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

public enum ThumbnailSize {
    // union ThumbnailSize
    /**
     * 32 by 32 px.
     */
    W32H32,
    /**
     * 64 by 64 px.
     */
    W64H64,
    /**
     * 128 by 128 px.
     */
    W128H128,
    /**
     * 640 by 480 px.
     */
    W640H480,
    /**
     * 1024 by 768
     */
    W1024H768;

    private static final java.util.HashMap<String, ThumbnailSize> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, ThumbnailSize>();
        VALUES_.put("w32h32", W32H32);
        VALUES_.put("w64h64", W64H64);
        VALUES_.put("w128h128", W128H128);
        VALUES_.put("w640h480", W640H480);
        VALUES_.put("w1024h768", W1024H768);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ThumbnailSize fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ThumbnailSize> _JSON_WRITER = new JsonWriter<ThumbnailSize>() {
        public void write(ThumbnailSize x, JsonGenerator g) throws IOException {
            switch (x) {
                case W32H32:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("w32h32");
                    g.writeEndObject();
                    break;
                case W64H64:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("w64h64");
                    g.writeEndObject();
                    break;
                case W128H128:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("w128h128");
                    g.writeEndObject();
                    break;
                case W640H480:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("w640h480");
                    g.writeEndObject();
                    break;
                case W1024H768:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("w1024h768");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<ThumbnailSize> _JSON_READER = new JsonReader<ThumbnailSize>() {
        public final ThumbnailSize read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
