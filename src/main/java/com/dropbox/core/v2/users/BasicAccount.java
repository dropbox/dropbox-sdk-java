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
 * Basic information about any account.
 */
public class BasicAccount extends Account {
    // struct BasicAccount

    private final boolean isTeammate;

    /**
     * Basic information about any account.
     *
     * @param accountId  The user's unique Dropbox ID. Must have length of at
     *     least 40, have length of at most 40, and not be {@code null}.
     * @param name  Details of a user's name. Must not be {@code null}.
     * @param isTeammate  Whether this user is a teammate of the current user.
     *     If this account is the current user's account, then this will be
     *     {@code true}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public BasicAccount(String accountId, Name name, boolean isTeammate) {
        super(accountId, name);
        this.isTeammate = isTeammate;
    }

    /**
     * Whether this user is a teammate of the current user. If this account is
     * the current user's account, then this will be {@code true}.
     *
     * @return value for this field.
     */
    public boolean getIsTeammate() {
        return isTeammate;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            isTeammate
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            BasicAccount other = (BasicAccount) obj;
            return (this.isTeammate == other.isTeammate)
                && ((this.getAccountId() == other.getAccountId()) || (this.getAccountId().equals(other.getAccountId())))
                && ((this.getName() == other.getName()) || (this.getName().equals(other.getName())))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static BasicAccount fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<BasicAccount> _JSON_WRITER = new JsonWriter<BasicAccount>() {
        public final void write(BasicAccount x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            Account._JSON_WRITER.writeFields(x, g);
            BasicAccount._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(BasicAccount x, JsonGenerator g) throws IOException {
            g.writeFieldName("is_teammate");
            g.writeBoolean(x.isTeammate);
        }
    };

    public static final JsonReader<BasicAccount> _JSON_READER = new JsonReader<BasicAccount>() {
        public final BasicAccount read(JsonParser parser) throws IOException, JsonReadException {
            BasicAccount result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final BasicAccount readFields(JsonParser parser) throws IOException, JsonReadException {
            String accountId = null;
            Name name = null;
            Boolean isTeammate = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("account_id".equals(fieldName)) {
                    accountId = JsonReader.StringReader
                        .readField(parser, "account_id", accountId);
                }
                else if ("name".equals(fieldName)) {
                    name = Name._JSON_READER
                        .readField(parser, "name", name);
                }
                else if ("is_teammate".equals(fieldName)) {
                    isTeammate = JsonReader.BooleanReader
                        .readField(parser, "is_teammate", isTeammate);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (accountId == null) {
                throw new JsonReadException("Required field \"account_id\" is missing.", parser.getTokenLocation());
            }
            if (name == null) {
                throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
            }
            if (isTeammate == null) {
                throw new JsonReadException("Required field \"is_teammate\" is missing.", parser.getTokenLocation());
            }
            return new BasicAccount(accountId, name, isTeammate);
        }
    };
}
