/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Representations for a person's name to assist with internationalization.
 */
public class Name {
    // struct users.Name (users.stone)

    protected final String givenName;
    protected final String surname;
    protected final String familiarName;
    protected final String displayName;
    protected final String abbreviatedName;

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
     * @param abbreviatedName  An abbreviated form of the person's name. Their
     *     initials in most locales. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Name(String givenName, String surname, String familiarName, String displayName, String abbreviatedName) {
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
        if (abbreviatedName == null) {
            throw new IllegalArgumentException("Required value for 'abbreviatedName' is null");
        }
        this.abbreviatedName = abbreviatedName;
    }

    /**
     * Also known as a first name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getGivenName() {
        return givenName;
    }

    /**
     * Also known as a last name or family name.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
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
    @javax.annotation.Nonnull
    public String getFamiliarName() {
        return familiarName;
    }

    /**
     * A name that can be used directly to represent the name of a user's
     * Dropbox account.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getDisplayName() {
        return displayName;
    }

    /**
     * An abbreviated form of the person's name. Their initials in most locales.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getAbbreviatedName() {
        return abbreviatedName;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            givenName,
            surname,
            familiarName,
            displayName,
            abbreviatedName
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            Name other = (Name) obj;
            return ((this.givenName == other.givenName) || (this.givenName.equals(other.givenName)))
                && ((this.surname == other.surname) || (this.surname.equals(other.surname)))
                && ((this.familiarName == other.familiarName) || (this.familiarName.equals(other.familiarName)))
                && ((this.displayName == other.displayName) || (this.displayName.equals(other.displayName)))
                && ((this.abbreviatedName == other.abbreviatedName) || (this.abbreviatedName.equals(other.abbreviatedName)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
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
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    public static class Serializer extends StructSerializer<Name> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(Name value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("given_name");
            StoneSerializers.string().serialize(value.givenName, g);
            g.writeFieldName("surname");
            StoneSerializers.string().serialize(value.surname, g);
            g.writeFieldName("familiar_name");
            StoneSerializers.string().serialize(value.familiarName, g);
            g.writeFieldName("display_name");
            StoneSerializers.string().serialize(value.displayName, g);
            g.writeFieldName("abbreviated_name");
            StoneSerializers.string().serialize(value.abbreviatedName, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public Name deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            Name value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_givenName = null;
                String f_surname = null;
                String f_familiarName = null;
                String f_displayName = null;
                String f_abbreviatedName = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("given_name".equals(field)) {
                        f_givenName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("surname".equals(field)) {
                        f_surname = StoneSerializers.string().deserialize(p);
                    }
                    else if ("familiar_name".equals(field)) {
                        f_familiarName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("display_name".equals(field)) {
                        f_displayName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("abbreviated_name".equals(field)) {
                        f_abbreviatedName = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_givenName == null) {
                    throw new JsonParseException(p, "Required field \"given_name\" missing.");
                }
                if (f_surname == null) {
                    throw new JsonParseException(p, "Required field \"surname\" missing.");
                }
                if (f_familiarName == null) {
                    throw new JsonParseException(p, "Required field \"familiar_name\" missing.");
                }
                if (f_displayName == null) {
                    throw new JsonParseException(p, "Required field \"display_name\" missing.");
                }
                if (f_abbreviatedName == null) {
                    throw new JsonParseException(p, "Required field \"abbreviated_name\" missing.");
                }
                value = new Name(f_givenName, f_surname, f_familiarName, f_displayName, f_abbreviatedName);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
