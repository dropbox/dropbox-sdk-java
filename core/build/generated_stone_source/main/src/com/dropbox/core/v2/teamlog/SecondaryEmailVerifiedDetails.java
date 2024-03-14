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

/**
 * Verified secondary email.
 */
public class SecondaryEmailVerifiedDetails {
    // struct team_log.SecondaryEmailVerifiedDetails (team_log_generated.stone)

    protected final String secondaryEmail;

    /**
     * Verified secondary email.
     *
     * @param secondaryEmail  Verified secondary email. Must have length of at
     *     most 255 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SecondaryEmailVerifiedDetails(String secondaryEmail) {
        if (secondaryEmail == null) {
            throw new IllegalArgumentException("Required value for 'secondaryEmail' is null");
        }
        if (secondaryEmail.length() > 255) {
            throw new IllegalArgumentException("String 'secondaryEmail' is longer than 255");
        }
        this.secondaryEmail = secondaryEmail;
    }

    /**
     * Verified secondary email.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            secondaryEmail
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
            SecondaryEmailVerifiedDetails other = (SecondaryEmailVerifiedDetails) obj;
            return (this.secondaryEmail == other.secondaryEmail) || (this.secondaryEmail.equals(other.secondaryEmail));
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
    static class Serializer extends StructSerializer<SecondaryEmailVerifiedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SecondaryEmailVerifiedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("secondary_email");
            StoneSerializers.string().serialize(value.secondaryEmail, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SecondaryEmailVerifiedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SecondaryEmailVerifiedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_secondaryEmail = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("secondary_email".equals(field)) {
                        f_secondaryEmail = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_secondaryEmail == null) {
                    throw new JsonParseException(p, "Required field \"secondary_email\" missing.");
                }
                value = new SecondaryEmailVerifiedDetails(f_secondaryEmail);
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
