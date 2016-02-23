/* DO NOT EDIT */
/* This file was generated from team_linked_apps.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Error returned by {@link
 * DbxTeam#linkedAppsRevokeLinkedAppBatch(java.util.List)}.
 */
public enum RevokeLinkedAppBatchError {
    // union RevokeLinkedAppBatchError
    /**
     * An unspecified error.
     */
    UNSPECIFIED; // *catch_all

    private static final java.util.HashMap<String, RevokeLinkedAppBatchError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, RevokeLinkedAppBatchError>();
        VALUES_.put("unspecified", UNSPECIFIED);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RevokeLinkedAppBatchError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeLinkedAppBatchError> _JSON_WRITER = new JsonWriter<RevokeLinkedAppBatchError>() {
        public void write(RevokeLinkedAppBatchError x, JsonGenerator g) throws IOException {
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

    public static final JsonReader<RevokeLinkedAppBatchError> _JSON_READER = new JsonReader<RevokeLinkedAppBatchError>() {
        public final RevokeLinkedAppBatchError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, UNSPECIFIED);
        }
    };
}
