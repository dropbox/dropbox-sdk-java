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

public enum MobileClientPlatform {
    // union MobileClientPlatform
    /**
     * Official Dropbox iPhone client
     */
    IPHONE,
    /**
     * Official Dropbox iPad client
     */
    IPAD,
    /**
     * Official Dropbox Android client
     */
    ANDROID,
    /**
     * Official Dropbox Windows phone client
     */
    WINDOWS_PHONE,
    /**
     * Official Dropbox Blackberry client
     */
    BLACKBERRY,
    /**
     * Official Dropbox client for another platform
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, MobileClientPlatform> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, MobileClientPlatform>();
        VALUES_.put("iphone", IPHONE);
        VALUES_.put("ipad", IPAD);
        VALUES_.put("android", ANDROID);
        VALUES_.put("windows_phone", WINDOWS_PHONE);
        VALUES_.put("blackberry", BLACKBERRY);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static MobileClientPlatform fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<MobileClientPlatform> _JSON_WRITER = new JsonWriter<MobileClientPlatform>() {
        public void write(MobileClientPlatform x, JsonGenerator g) throws IOException {
            switch (x) {
                case IPHONE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("iphone");
                    g.writeEndObject();
                    break;
                case IPAD:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("ipad");
                    g.writeEndObject();
                    break;
                case ANDROID:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("android");
                    g.writeEndObject();
                    break;
                case WINDOWS_PHONE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("windows_phone");
                    g.writeEndObject();
                    break;
                case BLACKBERRY:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("blackberry");
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

    public static final JsonReader<MobileClientPlatform> _JSON_READER = new JsonReader<MobileClientPlatform>() {
        public final MobileClientPlatform read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
