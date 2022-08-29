/* DO NOT EDIT */
/* This file was generated from file_properties.stone */

package com.dropbox.core.v2.fileproperties;

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
 * Raw key/value data to be associated with a Dropbox file. Property fields are
 * added to Dropbox files as a {@link PropertyGroup}.
 */
public class PropertyField {
    // struct file_properties.PropertyField (file_properties.stone)

    protected final String name;
    protected final String value;

    /**
     * Raw key/value data to be associated with a Dropbox file. Property fields
     * are added to Dropbox files as a {@link PropertyGroup}.
     *
     * @param name  Key of the property field associated with a file and
     *     template. Keys can be up to 256 bytes. Must not be {@code null}.
     * @param value  Value of the property field associated with a file and
     *     template. Values can be up to 1024 bytes. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertyField(String name, String value) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (value == null) {
            throw new IllegalArgumentException("Required value for 'value' is null");
        }
        this.value = value;
    }

    /**
     * Key of the property field associated with a file and template. Keys can
     * be up to 256 bytes.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     * Value of the property field associated with a file and template. Values
     * can be up to 1024 bytes.
     *
     * @return value for this field, never {@code null}.
     */
    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            name,
            value
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
            PropertyField other = (PropertyField) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.value == other.value) || (this.value.equals(other.value)))
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
    static class Serializer extends StructSerializer<PropertyField> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertyField value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("value");
            StoneSerializers.string().serialize(value.value, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PropertyField deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PropertyField value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_name = null;
                String f_value = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("value".equals(field)) {
                        f_value = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_value == null) {
                    throw new JsonParseException(p, "Required field \"value\" missing.");
                }
                value = new PropertyField(f_name, f_value);
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
