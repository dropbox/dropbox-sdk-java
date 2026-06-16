/* DO NOT EDIT */
/* This file was generated from secondary_emails.stone */

package com.dropbox.core.v2.secondaryemails;

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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

public class SecondaryEmail {
    // struct secondary_emails.SecondaryEmail (secondary_emails.stone)

    @Nonnull
    protected final String email;
    protected final boolean isVerified;

    /**
     *
     * @param email  Secondary email address. Must have length of at most 255,
     *     match pattern "{@code
     *     ^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$}",
     *     and not be {@code null}.
     * @param isVerified  Whether or not the secondary email address is verified
     *     to be owned by a user.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SecondaryEmail(@Nonnull String email, boolean isVerified) {
        if (email == null) {
            throw new IllegalArgumentException("Required value for 'email' is null");
        }
        if (email.length() > 255) {
            throw new IllegalArgumentException("String 'email' is longer than 255");
        }
        if (!Pattern.matches("^['#&A-Za-z0-9._%+-]+@[A-Za-z0-9-][A-Za-z0-9.-]*\\.[A-Za-z]{2,15}$", email)) {
            throw new IllegalArgumentException("String 'email' does not match pattern");
        }
        this.email = email;
        this.isVerified = isVerified;
    }

    /**
     * Secondary email address.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getEmail() {
        return email;
    }

    /**
     * Whether or not the secondary email address is verified to be owned by a
     * user.
     *
     * @return value for this field.
     */
    public boolean getIsVerified() {
        return isVerified;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.email,
            this.isVerified
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
            SecondaryEmail other = (SecondaryEmail) obj;
            return ((this.email == other.email) || (this.email.equals(other.email)))
                && (this.isVerified == other.isVerified)
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
    public static class Serializer extends StructSerializer<SecondaryEmail> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SecondaryEmail value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("email");
            StoneSerializers.string().serialize(value.email, g);
            g.writeFieldName("is_verified");
            StoneSerializers.boolean_().serialize(value.isVerified, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SecondaryEmail deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SecondaryEmail value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_email = null;
                Boolean f_isVerified = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("email".equals(field)) {
                        f_email = StoneSerializers.string().deserialize(p);
                    }
                    else if ("is_verified".equals(field)) {
                        f_isVerified = StoneSerializers.boolean_().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_email == null) {
                    throw new JsonParseException(p, "Required field \"email\" missing.");
                }
                if (f_isVerified == null) {
                    throw new JsonParseException(p, "Required field \"is_verified\" missing.");
                }
                value = new SecondaryEmail(f_email, f_isVerified);
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
