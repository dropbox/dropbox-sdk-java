/* DO NOT EDIT */
/* This file was generated from team_property_templates.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;
import com.dropbox.core.v2.properties.PropertyFieldTemplate;

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

@JsonSerialize(using=UpdatePropertyTemplateArg.Serializer.class)
@JsonDeserialize(using=UpdatePropertyTemplateArg.Deserializer.class)
class UpdatePropertyTemplateArg {
    // struct UpdatePropertyTemplateArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String templateId;
    protected final String name;
    protected final String description;
    protected final List<PropertyFieldTemplate> addFields;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param templateId  An identifier for property template added by {@link
     *     DbxTeamTeamRequests#propertiesTemplateAdd(String,String,List)}. Must
     *     have length of at least 1, match pattern "{@code (/|ptid:).*}", and
     *     not be {@code null}.
     * @param name  A display name for the property template. Property template
     *     names can be up to 256 bytes.
     * @param description  Description for new property template. Property
     *     template descriptions can be up to 1024 bytes.
     * @param addFields  This is a list of custom properties to add to the
     *     property template. There can be up to 64 properties in a single
     *     property template. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdatePropertyTemplateArg(String templateId, String name, String description, List<PropertyFieldTemplate> addFields) {
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
        this.name = name;
        this.description = description;
        if (addFields != null) {
            for (PropertyFieldTemplate x : addFields) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'addFields' is null");
                }
            }
        }
        this.addFields = addFields;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param templateId  An identifier for property template added by {@link
     *     DbxTeamTeamRequests#propertiesTemplateAdd(String,String,List)}. Must
     *     have length of at least 1, match pattern "{@code (/|ptid:).*}", and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdatePropertyTemplateArg(String templateId) {
        this(templateId, null, null, null);
    }

    /**
     * An identifier for property template added by {@link
     * DbxTeamTeamRequests#propertiesTemplateAdd(String,String,List)}.
     *
     * @return value for this field, never {@code null}.
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * A display name for the property template. Property template names can be
     * up to 256 bytes.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getName() {
        return name;
    }

    /**
     * Description for new property template. Property template descriptions can
     * be up to 1024 bytes.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getDescription() {
        return description;
    }

    /**
     * This is a list of custom properties to add to the property template.
     * There can be up to 64 properties in a single property template.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<PropertyFieldTemplate> getAddFields() {
        return addFields;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param templateId  An identifier for property template added by {@link
     *     DbxTeamTeamRequests#propertiesTemplateAdd(String,String,List)}. Must
     *     have length of at least 1, match pattern "{@code (/|ptid:).*}", and
     *     not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String templateId) {
        return new Builder(templateId);
    }

    /**
     * Builder for {@link UpdatePropertyTemplateArg}.
     */
    public static class Builder {
        protected final String templateId;

        protected String name;
        protected String description;
        protected List<PropertyFieldTemplate> addFields;

        protected Builder(String templateId) {
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
            this.name = null;
            this.description = null;
            this.addFields = null;
        }

        /**
         * Set value for optional field.
         *
         * @param name  A display name for the property template. Property
         *     template names can be up to 256 bytes.
         *
         * @return this builder
         */
        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param description  Description for new property template. Property
         *     template descriptions can be up to 1024 bytes.
         *
         * @return this builder
         */
        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param addFields  This is a list of custom properties to add to the
         *     property template. There can be up to 64 properties in a single
         *     property template. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAddFields(List<PropertyFieldTemplate> addFields) {
            if (addFields != null) {
                for (PropertyFieldTemplate x : addFields) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'addFields' is null");
                    }
                }
            }
            this.addFields = addFields;
            return this;
        }

        /**
         * Builds an instance of {@link UpdatePropertyTemplateArg} configured
         * with this builder's values
         *
         * @return new instance of {@link UpdatePropertyTemplateArg}
         */
        public UpdatePropertyTemplateArg build() {
            return new UpdatePropertyTemplateArg(templateId, name, description, addFields);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            templateId,
            name,
            description,
            addFields
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
            UpdatePropertyTemplateArg other = (UpdatePropertyTemplateArg) obj;
            return ((this.templateId == other.templateId) || (this.templateId.equals(other.templateId)))
                && ((this.name == other.name) || (this.name != null && this.name.equals(other.name)))
                && ((this.description == other.description) || (this.description != null && this.description.equals(other.description)))
                && ((this.addFields == other.addFields) || (this.addFields != null && this.addFields.equals(other.addFields)))
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

    static final class Serializer extends StructJsonSerializer<UpdatePropertyTemplateArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UpdatePropertyTemplateArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(UpdatePropertyTemplateArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<UpdatePropertyTemplateArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(UpdatePropertyTemplateArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("template_id", value.templateId);
            if (value.name != null) {
                g.writeObjectField("name", value.name);
            }
            if (value.description != null) {
                g.writeObjectField("description", value.description);
            }
            if (value.addFields != null) {
                g.writeObjectField("add_fields", value.addFields);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<UpdatePropertyTemplateArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UpdatePropertyTemplateArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(UpdatePropertyTemplateArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<UpdatePropertyTemplateArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public UpdatePropertyTemplateArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String templateId = null;
            String name = null;
            String description = null;
            List<PropertyFieldTemplate> addFields = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("template_id".equals(_field)) {
                    templateId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("name".equals(_field)) {
                    name = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("description".equals(_field)) {
                    description = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("add_fields".equals(_field)) {
                    expectArrayStart(_p);
                    addFields = new java.util.ArrayList<PropertyFieldTemplate>();
                    while (!isArrayEnd(_p)) {
                        PropertyFieldTemplate _x = null;
                        _x = _p.readValueAs(PropertyFieldTemplate.class);
                        _p.nextToken();
                        addFields.add(_x);
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

            return new UpdatePropertyTemplateArg(templateId, name, description, addFields);
        }
    }
}
