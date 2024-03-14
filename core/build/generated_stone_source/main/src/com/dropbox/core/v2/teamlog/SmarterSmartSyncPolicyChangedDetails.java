/* DO NOT EDIT */
/* This file was generated from team_log_generated.stone */

package com.dropbox.core.v2.teamlog;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.teampolicies.SmarterSmartSyncPolicyState;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

/**
 * Changed automatic Smart Sync setting for team.
 */
public class SmarterSmartSyncPolicyChangedDetails {
    // struct team_log.SmarterSmartSyncPolicyChangedDetails (team_log_generated.stone)

    protected final SmarterSmartSyncPolicyState previousValue;
    protected final SmarterSmartSyncPolicyState newValue;

    /**
     * Changed automatic Smart Sync setting for team.
     *
     * @param previousValue  Previous automatic Smart Sync setting. Must not be
     *     {@code null}.
     * @param newValue  New automatic Smart Sync setting. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SmarterSmartSyncPolicyChangedDetails(SmarterSmartSyncPolicyState previousValue, SmarterSmartSyncPolicyState newValue) {
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
     * Previous automatic Smart Sync setting.
     *
     * @return value for this field, never {@code null}.
     */
    public SmarterSmartSyncPolicyState getPreviousValue() {
        return previousValue;
    }

    /**
     * New automatic Smart Sync setting.
     *
     * @return value for this field, never {@code null}.
     */
    public SmarterSmartSyncPolicyState getNewValue() {
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
            SmarterSmartSyncPolicyChangedDetails other = (SmarterSmartSyncPolicyChangedDetails) obj;
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
    static class Serializer extends StructSerializer<SmarterSmartSyncPolicyChangedDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SmarterSmartSyncPolicyChangedDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("previous_value");
            SmarterSmartSyncPolicyState.Serializer.INSTANCE.serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            SmarterSmartSyncPolicyState.Serializer.INSTANCE.serialize(value.newValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SmarterSmartSyncPolicyChangedDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SmarterSmartSyncPolicyChangedDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                SmarterSmartSyncPolicyState f_previousValue = null;
                SmarterSmartSyncPolicyState f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = SmarterSmartSyncPolicyState.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = SmarterSmartSyncPolicyState.Serializer.INSTANCE.deserialize(p);
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
                value = new SmarterSmartSyncPolicyChangedDetails(f_previousValue, f_newValue);
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
