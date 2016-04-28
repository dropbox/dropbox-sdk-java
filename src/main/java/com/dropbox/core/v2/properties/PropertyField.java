/* DO NOT EDIT */
/* This file was generated from properties.babel */

package com.dropbox.core.v2.properties;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using=PropertyField.Serializer.class)
@JsonDeserialize(using=PropertyField.Deserializer.class)
public class PropertyField {
    // struct PropertyField

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String name;
    protected final String value;

    /**
     *
     * @param name  This is the name or key of a custom property in a property
     *     template. File property names can be up to 256 bytes. Must not be
     *     {@code null}.
     * @param value  Value of a custom property attached to a file. Values can
     *     be up to 1024 bytes. Must not be {@code null}.
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
     * This is the name or key of a custom property in a property template. File
     * property names can be up to 256 bytes.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     * Value of a custom property attached to a file. Values can be up to 1024
     * bytes.
     *
     * @return value for this field, never {@code null}.
     */
    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<PropertyField> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PropertyField.class);
        }

        public Serializer(boolean unwrapping) {
            super(PropertyField.class, unwrapping);
        }

        @Override
        protected JsonSerializer<PropertyField> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(PropertyField value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("name", value.name);
            g.writeObjectField("value", value.value);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<PropertyField> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PropertyField.class);
        }

        public Deserializer(boolean unwrapping) {
            super(PropertyField.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<PropertyField> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public PropertyField deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String name = null;
            String value = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("name".equals(_field)) {
                    name = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("value".equals(_field)) {
                    value = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }
            if (value == null) {
                throw new JsonParseException(_p, "Required field \"value\" is missing.");
            }

            return new PropertyField(name, value);
        }
    }
}
