/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public enum GetAccountError {
    // union GetAccountError
    /**
     * The specified {@link GetAccountArg#getAccountId} does not exist.
     */
    NO_ACCOUNT,
    UNKNOWN; // *catch_all

    private static final java.util.HashMap<String, GetAccountError> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, GetAccountError>();
        VALUES_.put("no_account", NO_ACCOUNT);
        VALUES_.put("unknown", UNKNOWN);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static GetAccountError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<GetAccountError> _JSON_WRITER = new JsonWriter<GetAccountError>() {
        public void write(GetAccountError x, JsonGenerator g) throws IOException {
            switch (x) {
                case NO_ACCOUNT:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_account");
                    g.writeEndObject();
                    break;
                case UNKNOWN:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unknown");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<GetAccountError> _JSON_READER = new JsonReader<GetAccountError>() {
        public final GetAccountError read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, UNKNOWN);
        }
    };
}
