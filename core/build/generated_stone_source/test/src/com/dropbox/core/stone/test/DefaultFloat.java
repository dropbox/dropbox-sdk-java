/* DO NOT EDIT */
/* This file was generated from test.stone */

package com.dropbox.core.stone.test;

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

public class DefaultFloat {
    // struct test.DefaultFloat (test.stone)

    protected final double duration;

    /**
     *
     * @param duration  Must be greater than or equal to 60.0 and be less than
     *     or equal to 14400.0.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DefaultFloat(double duration) {
        if (duration < 60.0) {
            throw new IllegalArgumentException("Number 'duration' is smaller than 60.0");
        }
        if (duration > 14400.0) {
            throw new IllegalArgumentException("Number 'duration' is larger than 14400.0");
        }
        this.duration = duration;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public DefaultFloat() {
        this(14400.0);
    }

    /**
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     14400.0.
     */
    public double getDuration() {
        return duration;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.duration
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
            DefaultFloat other = (DefaultFloat) obj;
            return this.duration == other.duration;
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
    public static class Serializer extends StructSerializer<DefaultFloat> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DefaultFloat value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("duration");
            StoneSerializers.float64().serialize(value.duration, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DefaultFloat deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DefaultFloat value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                Double f_duration = 14400.0;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("duration".equals(field)) {
                        f_duration = StoneSerializers.float64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new DefaultFloat(f_duration);
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
