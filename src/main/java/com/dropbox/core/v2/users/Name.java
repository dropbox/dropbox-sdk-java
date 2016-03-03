/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

/**
 * Representations for a person's name to assist with internationalization.
 */
@JsonSerialize(using=Name.Serializer.class)
@JsonDeserialize(using=Name.Deserializer.class)
public class Name {
    // struct Name

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String givenName;
    protected final String surname;
    protected final String familiarName;
    protected final String displayName;

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
        return serialize(false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<Name> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(Name.class);
        }

        public Serializer(boolean unwrapping) {
            super(Name.class, unwrapping);
        }

        @Override
        protected JsonSerializer<Name> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(Name value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("given_name", value.givenName);
            g.writeObjectField("surname", value.surname);
            g.writeObjectField("familiar_name", value.familiarName);
            g.writeObjectField("display_name", value.displayName);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<Name> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(Name.class);
        }

        public Deserializer(boolean unwrapping) {
            super(Name.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<Name> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public Name deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String givenName = null;
            String surname = null;
            String familiarName = null;
            String displayName = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("given_name".equals(_field)) {
                    givenName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("surname".equals(_field)) {
                    surname = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("familiar_name".equals(_field)) {
                    familiarName = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("display_name".equals(_field)) {
                    displayName = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (givenName == null) {
                throw new JsonParseException(_p, "Required field \"given_name\" is missing.");
            }
            if (surname == null) {
                throw new JsonParseException(_p, "Required field \"surname\" is missing.");
            }
            if (familiarName == null) {
                throw new JsonParseException(_p, "Required field \"familiar_name\" is missing.");
            }
            if (displayName == null) {
                throw new JsonParseException(_p, "Required field \"display_name\" is missing.");
            }

            return new Name(givenName, surname, familiarName, displayName);
        }
    }
}
