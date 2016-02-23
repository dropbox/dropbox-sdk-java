/* DO NOT EDIT */
/* This file was generated from shared_links.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Flag to indicate pending upload default (for linking to not-yet-existing
 * paths).
 */
public enum PendingUploadMode {
    // union PendingUploadMode
    /**
     * Assume pending uploads are files.
     */
    FILE,
    /**
     * Assume pending uploads are folders.
     */
    FOLDER;

    private static final java.util.HashMap<String, PendingUploadMode> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, PendingUploadMode>();
        VALUES_.put("file", FILE);
        VALUES_.put("folder", FOLDER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static PendingUploadMode fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<PendingUploadMode> _JSON_WRITER = new JsonWriter<PendingUploadMode>() {
        public void write(PendingUploadMode x, JsonGenerator g) throws IOException {
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
            }
        }
    };

    public static final JsonReader<PendingUploadMode> _JSON_READER = new JsonReader<PendingUploadMode>() {
        public final PendingUploadMode read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
