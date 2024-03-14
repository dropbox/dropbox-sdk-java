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
 * Opted team into Smart Sync.
 */
public class SmartSyncNotOptOutDetails {
    // struct team_log.SmartSyncNotOptOutDetails (team_log_generated.stone)

    protected final SmartSyncOptOutPolicy previousValue;
    protected final SmartSyncOptOutPolicy newValue;

    /**
     * Opted team into Smart Sync.
     *
     * @param previousValue  Previous Smart Sync opt out policy. Must not be
     *     {@code null}.
     * @param newValue  New Smart Sync opt out policy. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SmartSyncNotOptOutDetails(SmartSyncOptOutPolicy previousValue, SmartSyncOptOutPolicy newValue) {
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
     * Previous Smart Sync opt out policy.
     *
     * @return value for this field, never {@code null}.
     */
    public SmartSyncOptOutPolicy getPreviousValue() {
        return previousValue;
    }

    /**
     * New Smart Sync opt out policy.
     *
     * @return value for this field, never {@code null}.
     */
    public SmartSyncOptOutPolicy getNewValue() {
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
            SmartSyncNotOptOutDetails other = (SmartSyncNotOptOutDetails) obj;
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
    static class Serializer extends StructSerializer<SmartSyncNotOptOutDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SmartSyncNotOptOutDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("previous_value");
            SmartSyncOptOutPolicy.Serializer.INSTANCE.serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            SmartSyncOptOutPolicy.Serializer.INSTANCE.serialize(value.newValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SmartSyncNotOptOutDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SmartSyncNotOptOutDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                SmartSyncOptOutPolicy f_previousValue = null;
                SmartSyncOptOutPolicy f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("previous_value".equals(field)) {
                        f_previousValue = SmartSyncOptOutPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = SmartSyncOptOutPolicy.Serializer.INSTANCE.deserialize(p);
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
                value = new SmartSyncNotOptOutDetails(f_previousValue, f_newValue);
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
