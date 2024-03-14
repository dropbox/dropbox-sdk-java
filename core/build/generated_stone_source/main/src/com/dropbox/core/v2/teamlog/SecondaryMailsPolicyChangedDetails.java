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
 * Secondary mails policy changed.
 */
public class SecondaryMailsPolicyChangedDetails {
    // struct team_log.SecondaryMailsPolicyChangedDetails (team_log_generated.stone)

    protected final SecondaryMailsPolicy previousValue;
    protected final SecondaryMailsPolicy newValue;

    /**
     * Secondary mails policy changed.
     *
     * @param previousValue  Previous secondary mails policy. Must not be {@code
     *     null}.
     * @param newValue  New secondary mails policy. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SecondaryMailsPolicyChangedDetails(SecondaryMailsPolicy previousValue, SecondaryMailsPolicy newValue) {
        if (previousValue == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = previousValue;
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
    }

    /**
     * Previous secondary mails policy.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public SecondaryMailsPolicy getPreviousValue() {
        return previousValue;
    }

    /**
     * New secondary mails policy.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public SecondaryMailsPolicy getNewValue() {
        return newValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            previousValue,
            newValue
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
            SecondaryMailsPolicyChangedDetails other = (SecondaryMailsPolicyChangedDetails) obj;
            return ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
                && ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
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
    static class Serializer extends StructSerializer<SecondaryMailsPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SecondaryMailsPolicyChangedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("previous_value");
            SecondaryMailsPolicy.Serializer.INSTANCE.serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            SecondaryMailsPolicy.Serializer.INSTANCE.serialize(value.newValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SecondaryMailsPolicyChangedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SecondaryMailsPolicyChangedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                SecondaryMailsPolicy f_previousValue = null;
                SecondaryMailsPolicy f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = SecondaryMailsPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = SecondaryMailsPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new SecondaryMailsPolicyChangedDetails(f_previousValue, f_newValue);
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
