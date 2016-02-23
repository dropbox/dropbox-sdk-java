/* DO NOT EDIT */
/* This file was generated from team.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * Error that can be returned whenever a struct derived from {@link
 * UserSelectorArg} is used.
 */
public enum UserSelectorError {
    // union UserSelectorError
    /**
     * No matching user found. The provided team_member_id, email, or
     * external_id does not exist on this team.
     */
    USER_NOT_FOUND;

    private static final java.util.HashMap<String, UserSelectorError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, UserSelectorError>();
        VALUES_.put("user_not_found", USER_NOT_FOUND);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static UserSelectorError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<UserSelectorError> _JSON_WRITER = new JsonWriter<UserSelectorError>() {
        public void write(UserSelectorError x, JsonGenerator g) throws IOException {
            switch (x) {
                case USER_NOT_FOUND:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("user_not_found");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<UserSelectorError> _JSON_READER = new JsonReader<UserSelectorError>() {
        public final UserSelectorError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
