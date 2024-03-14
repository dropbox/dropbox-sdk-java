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
 * Added pending secondary email.
 */
public class PendingSecondaryEmailAddedDetails {
    // struct team_log.PendingSecondaryEmailAddedDetails (team_log_generated.stone)

    protected final String secondaryEmail;

    /**
     * Added pending secondary email.
     *
     * @param secondaryEmail  New pending secondary email. Must have length of
     *     at most 255 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PendingSecondaryEmailAddedDetails(String secondaryEmail) {
        if (secondaryEmail == null) {
            throw new IllegalArgumentException("Required value for 'secondaryEmail' is null");
        }
        if (secondaryEmail.length() > 255) {
            throw new IllegalArgumentException("String 'secondaryEmail' is longer than 255");
        }
        this.secondaryEmail = secondaryEmail;
    }

    /**
     * New pending secondary email.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
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
            PendingSecondaryEmailAddedDetails other = (PendingSecondaryEmailAddedDetails) obj;
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
    static class Serializer extends StructSerializer<PendingSecondaryEmailAddedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PendingSecondaryEmailAddedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
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
        public PendingSecondaryEmailAddedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PendingSecondaryEmailAddedDetails value;
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
                value = new PendingSecondaryEmailAddedDetails(f_secondaryEmail);
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
