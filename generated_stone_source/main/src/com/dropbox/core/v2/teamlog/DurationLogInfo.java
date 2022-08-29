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
 * Represents a time duration: unit and amount
 */
public class DurationLogInfo {
    // struct team_log.DurationLogInfo (team_log_generated.stone)

    protected final TimeUnit unit;
    protected final long amount;

    /**
     * Represents a time duration: unit and amount
     *
     * @param unit  Time unit. Must not be {@code null}.
     * @param amount  Amount of time.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DurationLogInfo(TimeUnit unit, long amount) {
        if (unit == null) {
            throw new IllegalArgumentException("Required value for 'unit' is null");
        }
        this.unit = unit;
        this.amount = amount;
    }

    /**
     * Time unit.
     *
     * @return value for this field, never {@code null}.
     */
    public TimeUnit getUnit() {
        return unit;
    }

    /**
     * Amount of time.
     *
     * @return value for this field.
     */
    public long getAmount() {
        return amount;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            unit,
            amount
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
            DurationLogInfo other = (DurationLogInfo) obj;
            return ((this.unit == other.unit) || (this.unit.equals(other.unit)))
                && (this.amount == other.amount)
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
    static class Serializer extends StructSerializer<DurationLogInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DurationLogInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("unit");
            TimeUnit.Serializer.INSTANCE.serialize(value.unit, g);
            g.writeFieldName("amount");
            StoneSerializers.uInt64().serialize(value.amount, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DurationLogInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DurationLogInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                TimeUnit f_unit = null;
                Long f_amount = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("unit".equals(field)) {
                        f_unit = TimeUnit.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("amount".equals(field)) {
                        f_amount = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_unit == null) {
                    throw new JsonParseException(p, "Required field \"unit\" missing.");
                }
                if (f_amount == null) {
                    throw new JsonParseException(p, "Required field \"amount\" missing.");
                }
                value = new DurationLogInfo(f_unit, f_amount);
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
