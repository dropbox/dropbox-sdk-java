/* DO NOT EDIT */
/* This file was generated from auth.babel */

package com.dropbox.core.v2.auth;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Errors occurred during authentication.
 */
public enum AuthError {
    // union AuthError
    /**
     * The access token is invalid.
     */
    INVALID_ACCESS_TOKEN,
    /**
     * The user specified in 'Dropbox-API-Select-User' is no longer on the team.
     */
    INVALID_SELECT_USER,
    /**
     * An unspecified error.
     */
    OTHER; // *catch_all

    private static final java.util.HashMap<String, AuthError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, AuthError>();
        VALUES_.put("invalid_access_token", INVALID_ACCESS_TOKEN);
        VALUES_.put("invalid_select_user", INVALID_SELECT_USER);
        VALUES_.put("other", OTHER);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static AuthError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<AuthError> _JSON_WRITER = new JsonWriter<AuthError>() {
        public void write(AuthError x, JsonGenerator g) throws IOException {
            switch (x) {
                case INVALID_ACCESS_TOKEN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_access_token");
                    g.writeEndObject();
                    break;
                case INVALID_SELECT_USER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("invalid_select_user");
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

    public static final JsonReader<AuthError> _JSON_READER = new JsonReader<AuthError>() {
        public final AuthError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, OTHER);
        }
    };
}
