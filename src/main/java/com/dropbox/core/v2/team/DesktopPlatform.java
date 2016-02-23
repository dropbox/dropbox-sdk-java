/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum DesktopPlatform {
    // union DesktopPlatform
    /**
     * Official Windows Dropbox desktop client
     */
    WINDOWS,
    /**
     * Official Mac Dropbox desktop client
     */
    MAC,
    /**
     * Official Linux Dropbox desktop client
     */
    LINUX,
    /**
     * Official Dropbox desktop client for another platform
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, DesktopPlatform> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, DesktopPlatform>();
        VALUES_.put("windows", WINDOWS);
        VALUES_.put("mac", MAC);
        VALUES_.put("linux", LINUX);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static DesktopPlatform fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<DesktopPlatform> _JSON_WRITER = new JsonWriter<DesktopPlatform>() {
        public void write(DesktopPlatform x, JsonGenerator g) throws IOException {
            switch (x) {
                case WINDOWS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("windows");
                    g.writeEndObject();
                    break;
                case MAC:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("mac");
                    g.writeEndObject();
                    break;
                case LINUX:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("linux");
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

    public static final JsonReader<DesktopPlatform> _JSON_READER = new JsonReader<DesktopPlatform>() {
        public final DesktopPlatform read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
