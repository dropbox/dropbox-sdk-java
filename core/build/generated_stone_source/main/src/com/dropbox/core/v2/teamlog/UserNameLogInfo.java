/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * User's name logged information
 */
public class UserNameLogInfo {
    // struct team_log.UserNameLogInfo (team_log_generated.stone)

    protected final String givenName;
    protected final String surname;
    protected final String locale;

    /**
     * User's name logged information
     *
     * @param givenName  Given name. Must not be {@code null}.
     * @param surname  Surname. Must not be {@code null}.
     * @param locale  Locale. Might be missing due to historical data gap.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserNameLogInfo(@Nonnull String givenName, @Nonnull String surname, @Nullable String locale) {
        if (givenName == null) {
            throw new IllegalArgumentException("Required value for 'givenName' is null");
        }
        this.givenName = givenName;
        if (surname == null) {
            throw new IllegalArgumentException("Required value for 'surname' is null");
        }
        this.surname = surname;
        this.locale = locale;
    }

    /**
     * User's name logged information
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param givenName  Given name. Must not be {@code null}.
     * @param surname  Surname. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserNameLogInfo(String givenName, String surname) {
        this(givenName, surname, null);
    }

    /**
     * Given name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getGivenName() {
        return givenName;
    }

    /**
     * Surname.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSurname() {
        return surname;
    }

    /**
     * Locale. Might be missing due to historical data gap.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getLocale() {
        return locale;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            givenName,
            surname,
            locale
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
            UserNameLogInfo other = (UserNameLogInfo) obj;
            return ((this.givenName == other.givenName) || (this.givenName.equals(other.givenName)))
                && ((this.surname == other.surname) || (this.surname.equals(other.surname)))
                && ((this.locale == other.locale) || (this.locale != null && this.locale.equals(other.locale)))
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
    static class Serializer extends StructSerializer<UserNameLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserNameLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("given_name");
            StoneSerializers.string().serialize(value.givenName, g);
            g.writeFieldName("surname");
            StoneSerializers.string().serialize(value.surname, g);
            if (value.locale != null) {
                g.writeFieldName("locale");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.locale, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UserNameLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserNameLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_givenName = null;
                String f_surname = null;
                String f_locale = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("given_name".equals(field)) {
                        f_givenName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("surname".equals(field)) {
                        f_surname = StoneSerializers.string().deserialize(p);
                    }
                    else if ("locale".equals(field)) {
                        f_locale = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                value = new UserNameLogInfo(f_givenName, f_surname, f_locale);
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
