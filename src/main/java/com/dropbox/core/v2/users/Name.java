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
 * Representations for a person's name to assist with internationalization.
 */
public class Name {
    // struct Name

    private final String givenName;
    private final String surname;
    private final String familiarName;
    private final String displayName;

    /**
     * Representations for a person's name to assist with internationalization.
     *
     * @param givenName  Also known as a first name. Must not be {@code null}.
     * @param surname  Also known as a last name or family name. Must not be
     *     {@code null}.
     * @param familiarName  Locale-dependent name. In the US, a person's
     *     familiar name is their {@link Name#getGivenName}, but elsewhere, it
     *     could be any combination of a person's {@link Name#getGivenName} and
     *     {@link Name#getSurname}. Must not be {@code null}.
     * @param displayName  A name that can be used directly to represent the
     *     name of a user's Dropbox account. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Name(String givenName, String surname, String familiarName, String displayName) {
        if (givenName == null) {
            throw new IllegalArgumentException("Required value for 'givenName' is null");
        }
        this.givenName = givenName;
        if (surname == null) {
            throw new IllegalArgumentException("Required value for 'surname' is null");
        }
        this.surname = surname;
        if (familiarName == null) {
            throw new IllegalArgumentException("Required value for 'familiarName' is null");
        }
        this.familiarName = familiarName;
        if (displayName == null) {
            throw new IllegalArgumentException("Required value for 'displayName' is null");
        }
        this.displayName = displayName;
    }

    /**
     * Also known as a first name.
     *
     * @return value for this field, never {@code null}.
     */
    public String getGivenName() {
        return givenName;
    }

    /**
     * Also known as a last name or family name.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Locale-dependent name. In the US, a person's familiar name is their
     * {@link Name#getGivenName}, but elsewhere, it could be any combination of
     * a person's {@link Name#getGivenName} and {@link Name#getSurname}.
     *
     * @return value for this field, never {@code null}.
     */
    public String getFamiliarName() {
        return familiarName;
    }

    /**
     * A name that can be used directly to represent the name of a user's
     * Dropbox account.
     *
     * @return value for this field, never {@code null}.
     */
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            givenName,
            surname,
            familiarName,
            displayName
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            Name other = (Name) obj;
            return ((this.givenName == other.givenName) || (this.givenName.equals(other.givenName)))
                && ((this.surname == other.surname) || (this.surname.equals(other.surname)))
                && ((this.familiarName == other.familiarName) || (this.familiarName.equals(other.familiarName)))
                && ((this.displayName == other.displayName) || (this.displayName.equals(other.displayName)))
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

    public static Name fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<Name> _JSON_WRITER = new JsonWriter<Name>() {
        public final void write(Name x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            Name._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(Name x, JsonGenerator g) throws IOException {
            g.writeFieldName("given_name");
            g.writeString(x.givenName);
            g.writeFieldName("surname");
            g.writeString(x.surname);
            g.writeFieldName("familiar_name");
            g.writeString(x.familiarName);
            g.writeFieldName("display_name");
            g.writeString(x.displayName);
        }
    };

    public static final JsonReader<Name> _JSON_READER = new JsonReader<Name>() {
        public final Name read(JsonParser parser) throws IOException, JsonReadException {
            Name result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final Name readFields(JsonParser parser) throws IOException, JsonReadException {
            String givenName = null;
            String surname = null;
            String familiarName = null;
            String displayName = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("given_name".equals(fieldName)) {
                    givenName = JsonReader.StringReader
                        .readField(parser, "given_name", givenName);
                }
                else if ("surname".equals(fieldName)) {
                    surname = JsonReader.StringReader
                        .readField(parser, "surname", surname);
                }
                else if ("familiar_name".equals(fieldName)) {
                    familiarName = JsonReader.StringReader
                        .readField(parser, "familiar_name", familiarName);
                }
                else if ("display_name".equals(fieldName)) {
                    displayName = JsonReader.StringReader
                        .readField(parser, "display_name", displayName);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (givenName == null) {
                throw new JsonReadException("Required field \"given_name\" is missing.", parser.getTokenLocation());
            }
            if (surname == null) {
                throw new JsonReadException("Required field \"surname\" is missing.", parser.getTokenLocation());
            }
            if (familiarName == null) {
                throw new JsonReadException("Required field \"familiar_name\" is missing.", parser.getTokenLocation());
            }
            if (displayName == null) {
                throw new JsonReadException("Required field \"display_name\" is missing.", parser.getTokenLocation());
            }
            return new Name(givenName, surname, familiarName, displayName);
        }
    };
}
