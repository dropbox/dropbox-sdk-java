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

public class WithByte {
    // struct test.WithByte (test.stone)

    protected final byte[] field1;

    public WithByte(byte[] field1) {
        this.field1 = field1;
    }

    /**
     *
     * @return value for this field.
     */
    public byte[] getField1() {
        return field1;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            field1
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
            WithByte other = (WithByte) obj;
            return this.field1 == other.field1;
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
    public static class Serializer extends StructSerializer<WithByte> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(WithByte value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("field1");
            StoneSerializers.bytes().serialize(value.field1, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public WithByte deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            WithByte value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                byte[] f_field1 = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("field1".equals(field)) {
                        f_field1 = StoneSerializers.bytes().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_field1 == null) {
                    throw new JsonParseException(p, "Required field \"field1\" missing.");
                }
                value = new WithByte(f_field1);
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
