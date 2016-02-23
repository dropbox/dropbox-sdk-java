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
 * Error returned by {@link DbxTeam#linkedAppsRevokeLinkedApp(String,String)}.
 */
public enum RevokeLinkedAppError {
    // union RevokeLinkedAppError
    /**
     * Application not found.
     */
    APP_NOT_FOUND,
    /**
     * Member not found.
     */
    MEMBER_NOT_FOUND,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, RevokeLinkedAppError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, RevokeLinkedAppError>();
        VALUES_.put("app_not_found", APP_NOT_FOUND);
        VALUES_.put("member_not_found", MEMBER_NOT_FOUND);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RevokeLinkedAppError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RevokeLinkedAppError> _JSON_WRITER = new JsonWriter<RevokeLinkedAppError>() {
        public void write(RevokeLinkedAppError x, JsonGenerator g) throws IOException {
            switch (x) {
                case APP_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("app_not_found");
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

    public static final JsonReader<RevokeLinkedAppError> _JSON_READER = new JsonReader<RevokeLinkedAppError>() {
        public final RevokeLinkedAppError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
