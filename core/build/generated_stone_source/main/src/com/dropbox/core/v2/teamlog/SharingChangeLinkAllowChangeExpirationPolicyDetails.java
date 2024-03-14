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
 * Changed the allow remove or change expiration policy for the links shared
 * outside of the team.
 */
public class SharingChangeLinkAllowChangeExpirationPolicyDetails {
    // struct team_log.SharingChangeLinkAllowChangeExpirationPolicyDetails (team_log_generated.stone)

    protected final EnforceLinkPasswordPolicy newValue;
    protected final EnforceLinkPasswordPolicy previousValue;

    /**
     * Changed the allow remove or change expiration policy for the links shared
     * outside of the team.
     *
     * @param newValue  To. Must not be {@code null}.
     * @param previousValue  From.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharingChangeLinkAllowChangeExpirationPolicyDetails(EnforceLinkPasswordPolicy newValue, EnforceLinkPasswordPolicy previousValue) {
        if (newValue == null) {
            throw new IllegalArgumentException("Required value for 'newValue' is null");
        }
        this.newValue = newValue;
        this.previousValue = previousValue;
    }

    /**
     * Changed the allow remove or change expiration policy for the links shared
     * outside of the team.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param newValue  To. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharingChangeLinkAllowChangeExpirationPolicyDetails(EnforceLinkPasswordPolicy newValue) {
        this(newValue, null);
    }

    /**
     * To.
     *
     * @return value for this field, never {@code null}.
     */
    public EnforceLinkPasswordPolicy getNewValue() {
        return newValue;
    }

    /**
     * From.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public EnforceLinkPasswordPolicy getPreviousValue() {
        return previousValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            newValue,
            previousValue
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
            SharingChangeLinkAllowChangeExpirationPolicyDetails other = (SharingChangeLinkAllowChangeExpirationPolicyDetails) obj;
            return ((this.newValue == other.newValue) || (this.newValue.equals(other.newValue)))
                && ((this.previousValue == other.previousValue) || (this.previousValue != null && this.previousValue.equals(other.previousValue)))
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
    static class Serializer extends StructSerializer<SharingChangeLinkAllowChangeExpirationPolicyDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharingChangeLinkAllowChangeExpirationPolicyDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("new_value");
            EnforceLinkPasswordPolicy.Serializer.INSTANCE.serialize(value.newValue, g);
            if (value.previousValue != null) {
                g.writeFieldName("previous_value");
                StoneSerializers.nullable(EnforceLinkPasswordPolicy.Serializer.INSTANCE).serialize(value.previousValue, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharingChangeLinkAllowChangeExpirationPolicyDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharingChangeLinkAllowChangeExpirationPolicyDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                EnforceLinkPasswordPolicy f_newValue = null;
                EnforceLinkPasswordPolicy f_previousValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("new_value".equals(field)) {
                        f_newValue = EnforceLinkPasswordPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.nullable(EnforceLinkPasswordPolicy.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new SharingChangeLinkAllowChangeExpirationPolicyDetails(f_newValue, f_previousValue);
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
