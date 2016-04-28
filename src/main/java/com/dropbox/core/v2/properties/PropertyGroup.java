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
import java.util.List;

/**
 * Collection of custom properties in filled property templates.
 */
@JsonSerialize(using=PropertyGroup.Serializer.class)
@JsonDeserialize(using=PropertyGroup.Deserializer.class)
public class PropertyGroup {
    // struct PropertyGroup

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String templateId;
    protected final List<PropertyField> fields;

    /**
     * Collection of custom properties in filled property templates.
     *
     * @param templateId  A unique identifier for a property template type. Must
     *     have length of at least 1, match pattern "{@code (/|ptid:).*}", and
     *     not be {@code null}.
     * @param fields  This is a list of custom properties associated with a
     *     file. There can be up to 32 properties for a template. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertyGroup(String templateId, List<PropertyField> fields) {
        if (templateId == null) {
            throw new IllegalArgumentException("Required value for 'templateId' is null");
        }
        if (templateId.length() < 1) {
            throw new IllegalArgumentException("String 'templateId' is shorter than 1");
        }
        if (!java.util.regex.Pattern.matches("(/|ptid:).*", templateId)) {
            throw new IllegalArgumentException("String 'templateId' does not match pattern");
        }
        this.templateId = templateId;
        if (fields == null) {
            throw new IllegalArgumentException("Required value for 'fields' is null");
        }
        for (PropertyField x : fields) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'fields' is null");
            }
        }
        this.fields = fields;
    }

    /**
     * A unique identifier for a property template type.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * This is a list of custom properties associated with a file. There can be
     * up to 32 properties for a template.
     *
     * @return value for this field, never {@code null}.
     */
    public List<PropertyField> getFields() {
        return fields;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            templateId,
            fields
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
            PropertyGroup other = (PropertyGroup) obj;
            return ((this.templateId == other.templateId) || (this.templateId.equals(other.templateId)))
                && ((this.fields == other.fields) || (this.fields.equals(other.fields)))
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

    static final class Serializer extends StructJsonSerializer<PropertyGroup> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PropertyGroup.class);
        }

        public Serializer(boolean unwrapping) {
            super(PropertyGroup.class, unwrapping);
        }

        @Override
        protected JsonSerializer<PropertyGroup> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(PropertyGroup value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("template_id", value.templateId);
            g.writeObjectField("fields", value.fields);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<PropertyGroup> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PropertyGroup.class);
        }

        public Deserializer(boolean unwrapping) {
            super(PropertyGroup.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<PropertyGroup> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public PropertyGroup deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String templateId = null;
            List<PropertyField> fields = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("template_id".equals(_field)) {
                    templateId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("fields".equals(_field)) {
                    expectArrayStart(_p);
                    fields = new java.util.ArrayList<PropertyField>();
                    while (!isArrayEnd(_p)) {
                        PropertyField _x = null;
                        _x = _p.readValueAs(PropertyField.class);
                        _p.nextToken();
                        fields.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (templateId == null) {
                throw new JsonParseException(_p, "Required field \"template_id\" is missing.");
            }
            if (fields == null) {
                throw new JsonParseException(_p, "Required field \"fields\" is missing.");
            }

            return new PropertyGroup(templateId, fields);
        }
    }
}
