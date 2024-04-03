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

/**
 * Removed sign-in URL for SSO.
 */
public class SsoRemoveLoginUrlDetails {
    // struct team_log.SsoRemoveLoginUrlDetails (team_log_generated.stone)

    @Nonnull
    protected final String previousValue;

    /**
     * Removed sign-in URL for SSO.
     *
     * @param previousValue  Previous single sign-on login URL. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SsoRemoveLoginUrlDetails(@Nonnull String previousValue) {
        if (previousValue == null) {
            throw new IllegalArgumentException("Required value for 'previousValue' is null");
        }
        this.previousValue = previousValue;
    }

    /**
     * Previous single sign-on login URL.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPreviousValue() {
        return previousValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.previousValue
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
            SsoRemoveLoginUrlDetails other = (SsoRemoveLoginUrlDetails) obj;
            return (this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue));
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
    static class Serializer extends StructSerializer<SsoRemoveLoginUrlDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SsoRemoveLoginUrlDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("previous_value");
            StoneSerializers.string().serialize(value.previousValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SsoRemoveLoginUrlDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SsoRemoveLoginUrlDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                value = new SsoRemoveLoginUrlDetails(f_previousValue);
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
