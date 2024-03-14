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
 * Renamed a hold.
 */
public class LegalHoldsChangeHoldNameDetails {
    // struct team_log.LegalHoldsChangeHoldNameDetails (team_log_generated.stone)

    protected final String legalHoldId;
    protected final String previousValue;
    protected final String newValue;

    /**
     * Renamed a hold.
     *
     * @param legalHoldId  Hold ID. Must not be {@code null}.
     * @param previousValue  Previous Name. Must not be {@code null}.
     * @param newValue  New Name. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsChangeHoldNameDetails(@Nonnull String legalHoldId, @Nonnull String previousValue, @Nonnull String newValue) {
        if (legalHoldId == null) {
            throw new IllegalArgumentException("Required value for 'legalHoldId' is null");
        }
        this.legalHoldId = legalHoldId;
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
     * Hold ID.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getLegalHoldId() {
        return legalHoldId;
    }

    /**
     * Previous Name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPreviousValue() {
        return previousValue;
    }

    /**
     * New Name.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getNewValue() {
        return newValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            legalHoldId,
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
            LegalHoldsChangeHoldNameDetails other = (LegalHoldsChangeHoldNameDetails) obj;
            return ((this.legalHoldId == other.legalHoldId) || (this.legalHoldId.equals(other.legalHoldId)))
                && ((this.previousValue == other.previousValue) || (this.previousValue.equals(other.previousValue)))
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
    static class Serializer extends StructSerializer<LegalHoldsChangeHoldNameDetails> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LegalHoldsChangeHoldNameDetails value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("legal_hold_id");
            StoneSerializers.string().serialize(value.legalHoldId, g);
            g.writeFieldName("previous_value");
            StoneSerializers.string().serialize(value.previousValue, g);
            g.writeFieldName("new_value");
            StoneSerializers.string().serialize(value.newValue, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public LegalHoldsChangeHoldNameDetails deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            LegalHoldsChangeHoldNameDetails value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_legalHoldId = null;
                String f_previousValue = null;
                String f_newValue = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("legal_hold_id".equals(field)) {
                        f_legalHoldId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("previous_value".equals(field)) {
                        f_previousValue = StoneSerializers.string().deserialize(p);
                    }
                    else if ("new_value".equals(field)) {
                        f_newValue = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_legalHoldId == null) {
                    throw new JsonParseException(p, "Required field \"legal_hold_id\" missing.");
                }
                if (f_previousValue == null) {
                    throw new JsonParseException(p, "Required field \"previous_value\" missing.");
                }
                if (f_newValue == null) {
                    throw new JsonParseException(p, "Required field \"new_value\" missing.");
                }
                value = new LegalHoldsChangeHoldNameDetails(f_legalHoldId, f_previousValue, f_newValue);
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
