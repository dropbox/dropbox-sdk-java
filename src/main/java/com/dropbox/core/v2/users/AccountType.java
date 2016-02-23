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

/**
 * What type of account this user has.
 */
public enum AccountType {
    // union AccountType
    /**
     * The basic account type.
     */
    BASIC,
    /**
     * The Dropbox Pro account type.
     */
    PRO,
    /**
     * The Dropbox Business account type.
     */
    BUSINESS;

    private static final java.util.HashMap<String, AccountType> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, AccountType>();
        VALUES_.put("basic", BASIC);
        VALUES_.put("pro", PRO);
        VALUES_.put("business", BUSINESS);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static AccountType fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<AccountType> _JSON_WRITER = new JsonWriter<AccountType>() {
        public void write(AccountType x, JsonGenerator g) throws IOException {
            switch (x) {
                case BASIC:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("basic");
                    g.writeEndObject();
                    break;
                case PRO:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("pro");
                    g.writeEndObject();
                    break;
                case BUSINESS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("business");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<AccountType> _JSON_READER = new JsonReader<AccountType>() {
        public final AccountType read(JsonParser parser) throws IOException, JsonReadException {
            return JsonReader.readEnum(parser, VALUES_, null);
        }
    };
}
