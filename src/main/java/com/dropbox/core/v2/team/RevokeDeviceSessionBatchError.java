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

public enum RevokeDeviceSessionBatchError {
    // union RevokeDeviceSessionBatchError
    /**
     * An unspecified error.
     */
    UNSPECIFIED; // *catch_all

    private static final java.util.HashMap<String, RevokeDeviceSessionBatchError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, RevokeDeviceSessionBatchError>();
        VALUES_.put("unspecified", UNSPECIFIED);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RevokeDeviceSessionBatchError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeDeviceSessionBatchError> _JSON_WRITER = new JsonWriter<RevokeDeviceSessionBatchError>() {
        public void write(RevokeDeviceSessionBatchError x, JsonGenerator g) throws IOException {
            switch (x) {
                case UNSPECIFIED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unspecified");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<RevokeDeviceSessionBatchError> _JSON_READER = new JsonReader<RevokeDeviceSessionBatchError>() {
        public final RevokeDeviceSessionBatchError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, UNSPECIFIED);
        }
    };
}
