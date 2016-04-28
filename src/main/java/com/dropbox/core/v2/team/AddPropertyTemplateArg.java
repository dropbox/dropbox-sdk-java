/* DO NOT EDIT */
/* This file was generated from team_property_templates.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;
import com.dropbox.core.v2.properties.PropertyFieldTemplate;
import com.dropbox.core.v2.properties.PropertyGroupTemplate;

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
 * Arguments for adding property templates.
 */
@JsonSerialize(using=AddPropertyTemplateArg.Serializer.class)
@JsonDeserialize(using=AddPropertyTemplateArg.Deserializer.class)
class AddPropertyTemplateArg extends PropertyGroupTemplate {
    // struct AddPropertyTemplateArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();


    /**
     * Arguments for adding property templates.
     *
     * @param name  A display name for the property template. Property template
     *     names can be up to 256 bytes. Must not be {@code null}.
     * @param description  Description for new property template. Property
     *     template descriptions can be up to 1024 bytes. Must not be {@code
     *     null}.
     * @param fields  This is a list of custom properties associated with a
     *     property template. There can be up to 64 properties in a single
     *     property template. Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddPropertyTemplateArg(String name, String description, List<PropertyFieldTemplate> fields) {
        super(name, description, fields);
    }

    @Override
    public int hashCode() {
        // attempt to deal with inheritance
        return getClass().toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            AddPropertyTemplateArg other = (AddPropertyTemplateArg) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.description == other.description) || (this.description.equals(other.description)))
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

    static final class Serializer extends StructJsonSerializer<AddPropertyTemplateArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(AddPropertyTemplateArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(AddPropertyTemplateArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<AddPropertyTemplateArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(AddPropertyTemplateArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("name", value.name);
            g.writeObjectField("description", value.description);
            g.writeObjectField("fields", value.fields);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<AddPropertyTemplateArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(AddPropertyTemplateArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(AddPropertyTemplateArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<AddPropertyTemplateArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public AddPropertyTemplateArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String name = null;
            String description = null;
            List<PropertyFieldTemplate> fields = null;

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
                else if ("fields".equals(_field)) {
                    expectArrayStart(_p);
                    fields = new java.util.ArrayList<PropertyFieldTemplate>();
                    while (!isArrayEnd(_p)) {
                        PropertyFieldTemplate _x = null;
                        _x = _p.readValueAs(PropertyFieldTemplate.class);
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

            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }
            if (description == null) {
                throw new JsonParseException(_p, "Required field \"description\" is missing.");
            }
            if (fields == null) {
                throw new JsonParseException(_p, "Required field \"fields\" is missing.");
            }

            return new AddPropertyTemplateArg(name, description, fields);
        }
    }
}
