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

public enum RevokeDeviceSessionError {
    // union RevokeDeviceSessionError
    /**
     * Device session not found.
     */
    DEVICE_SESSION_NOT_FOUND,
    /**
     * Member not found.
     */
    MEMBER_NOT_FOUND,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, RevokeDeviceSessionError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, RevokeDeviceSessionError>();
        VALUES_.put("device_session_not_found", DEVICE_SESSION_NOT_FOUND);
        VALUES_.put("member_not_found", MEMBER_NOT_FOUND);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RevokeDeviceSessionError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeDeviceSessionError> _JSON_WRITER = new JsonWriter<RevokeDeviceSessionError>() {
        public void write(RevokeDeviceSessionError x, JsonGenerator g) throws IOException {
            switch (x) {
                case DEVICE_SESSION_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("device_session_not_found");
                    g.writeEndObject();
                    break;
                case MEMBER_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("member_not_found");
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

    public static final JsonReader<RevokeDeviceSessionError> _JSON_READER = new JsonReader<RevokeDeviceSessionError>() {
        public final RevokeDeviceSessionError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
