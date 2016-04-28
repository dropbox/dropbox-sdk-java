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

/**
 * Describe a single property field type which that can be part of a property
 * template.
 */
@JsonSerialize(using=PropertyFieldTemplate.Serializer.class)
@JsonDeserialize(using=PropertyFieldTemplate.Deserializer.class)
public class PropertyFieldTemplate {
    // struct PropertyFieldTemplate

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String name;
    protected final String description;
    protected final PropertyType type;

    /**
     * Describe a single property field type which that can be part of a
     * property template.
     *
     * @param name  This is the name or key of a custom property in a property
     *     template. File property names can be up to 256 bytes. Must not be
     *     {@code null}.
     * @param description  This is the description for a custom property in a
     *     property template. File property description can be up to 1024 bytes.
     *     Must not be {@code null}.
     * @param type  This is the data type of the value of this property. This
     *     type will be enforced upon property creation and modifications. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertyFieldTemplate(String name, String description, PropertyType type) {
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (description == null) {
            throw new IllegalArgumentException("Required value for 'description' is null");
        }
        this.description = description;
        if (type == null) {
            throw new IllegalArgumentException("Required value for 'type' is null");
        }
        this.type = type;
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
     * This is the description for a custom property in a property template.
     * File property description can be up to 1024 bytes.
     *
     * @return value for this field, never {@code null}.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is the data type of the value of this property. This type will be
     * enforced upon property creation and modifications.
     *
     * @return value for this field, never {@code null}.
     */
    public PropertyType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            name,
            description,
            type
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
            PropertyFieldTemplate other = (PropertyFieldTemplate) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.description == other.description) || (this.description.equals(other.description)))
                && ((this.type == other.type) || (this.type.equals(other.type)))
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

    static final class Serializer extends StructJsonSerializer<PropertyFieldTemplate> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PropertyFieldTemplate.class);
        }

        public Serializer(boolean unwrapping) {
            super(PropertyFieldTemplate.class, unwrapping);
        }

        @Override
        protected JsonSerializer<PropertyFieldTemplate> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(PropertyFieldTemplate value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("name", value.name);
            g.writeObjectField("description", value.description);
            g.writeObjectField("type", value.type);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<PropertyFieldTemplate> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PropertyFieldTemplate.class);
        }

        public Deserializer(boolean unwrapping) {
            super(PropertyFieldTemplate.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<PropertyFieldTemplate> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public PropertyFieldTemplate deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String name = null;
            String description = null;
            PropertyType type = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("name".equals(_field)) {
                    name = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("description".equals(_field)) {
                    description = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("type".equals(_field)) {
                    type = _p.readValueAs(PropertyType.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }
            if (description == null) {
                throw new JsonParseException(_p, "Required field \"description\" is missing.");
            }
            if (type == null) {
                throw new JsonParseException(_p, "Required field \"type\" is missing.");
            }

            return new PropertyFieldTemplate(name, description, type);
        }
    }
}
