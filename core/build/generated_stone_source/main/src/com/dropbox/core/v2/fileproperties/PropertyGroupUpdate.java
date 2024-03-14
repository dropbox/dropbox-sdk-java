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
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class PropertyGroupUpdate {
    // struct file_properties.PropertyGroupUpdate (file_properties.stone)

    protected final String templateId;
    protected final List<PropertyField> addOrUpdateFields;
    protected final List<String> removeFields;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param templateId  A unique identifier for a property template. Must have
     *     length of at least 1, match pattern "{@code (/|ptid:).*}", and not be
     *     {@code null}.
     * @param addOrUpdateFields  Property fields to update. If the property
     *     field already exists, it is updated. If the property field doesn't
     *     exist, the property group is added. Must not contain a {@code null}
     *     item.
     * @param removeFields  Property fields to remove (by name), provided they
     *     exist. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertyGroupUpdate(@Nonnull String templateId, @Nullable List<PropertyField> addOrUpdateFields, @Nullable List<String> removeFields) {
        if (templateId == null) {
            throw new IllegalArgumentException("Required value for 'templateId' is null");
        }
        if (templateId.length() < 1) {
            throw new IllegalArgumentException("String 'templateId' is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", templateId)) {
            throw new IllegalArgumentException("String 'templateId' does not match pattern");
        }
        this.templateId = templateId;
        if (addOrUpdateFields != null) {
            for (PropertyField x : addOrUpdateFields) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'addOrUpdateFields' is null");
                }
            }
        }
        this.addOrUpdateFields = addOrUpdateFields;
        if (removeFields != null) {
            for (String x : removeFields) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'removeFields' is null");
                }
            }
        }
        this.removeFields = removeFields;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param templateId  A unique identifier for a property template. Must have
     *     length of at least 1, match pattern "{@code (/|ptid:).*}", and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertyGroupUpdate(String templateId) {
        this(templateId, null, null);
    }

    /**
     * A unique identifier for a property template.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getTemplateId() {
        return templateId;
    }

    /**
     * Property fields to update. If the property field already exists, it is
     * updated. If the property field doesn't exist, the property group is
     * added.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<PropertyField> getAddOrUpdateFields() {
        return addOrUpdateFields;
    }

    /**
     * Property fields to remove (by name), provided they exist.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<String> getRemoveFields() {
        return removeFields;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param templateId  A unique identifier for a property template. Must have
     *     length of at least 1, match pattern "{@code (/|ptid:).*}", and not be
     *     {@code null}.
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
     * Builder for {@link PropertyGroupUpdate}.
     */
    public static class Builder {
        protected final String templateId;

        protected List<PropertyField> addOrUpdateFields;
        protected List<String> removeFields;

        protected Builder(String templateId) {
            if (templateId == null) {
                throw new IllegalArgumentException("Required value for 'templateId' is null");
            }
            if (templateId.length() < 1) {
                throw new IllegalArgumentException("String 'templateId' is shorter than 1");
            }
            if (!Pattern.matches("(/|ptid:).*", templateId)) {
                throw new IllegalArgumentException("String 'templateId' does not match pattern");
            }
            this.templateId = templateId;
            this.addOrUpdateFields = null;
            this.removeFields = null;
        }

        /**
         * Set value for optional field.
         *
         * @param addOrUpdateFields  Property fields to update. If the property
         *     field already exists, it is updated. If the property field
         *     doesn't exist, the property group is added. Must not contain a
         *     {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAddOrUpdateFields(List<PropertyField> addOrUpdateFields) {
            if (addOrUpdateFields != null) {
                for (PropertyField x : addOrUpdateFields) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'addOrUpdateFields' is null");
                    }
                }
            }
            this.addOrUpdateFields = addOrUpdateFields;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param removeFields  Property fields to remove (by name), provided
         *     they exist. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withRemoveFields(List<String> removeFields) {
            if (removeFields != null) {
                for (String x : removeFields) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'removeFields' is null");
                    }
                }
            }
            this.removeFields = removeFields;
            return this;
        }

        /**
         * Builds an instance of {@link PropertyGroupUpdate} configured with
         * this builder's values
         *
         * @return new instance of {@link PropertyGroupUpdate}
         */
        public PropertyGroupUpdate build() {
            return new PropertyGroupUpdate(templateId, addOrUpdateFields, removeFields);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            templateId,
            addOrUpdateFields,
            removeFields
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
            PropertyGroupUpdate other = (PropertyGroupUpdate) obj;
            return ((this.templateId == other.templateId) || (this.templateId.equals(other.templateId)))
                && ((this.addOrUpdateFields == other.addOrUpdateFields) || (this.addOrUpdateFields != null && this.addOrUpdateFields.equals(other.addOrUpdateFields)))
                && ((this.removeFields == other.removeFields) || (this.removeFields != null && this.removeFields.equals(other.removeFields)))
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
    static class Serializer extends StructSerializer<PropertyGroupUpdate> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertyGroupUpdate value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("template_id");
            StoneSerializers.string().serialize(value.templateId, g);
            if (value.addOrUpdateFields != null) {
                g.writeFieldName("add_or_update_fields");
                StoneSerializers.nullable(StoneSerializers.list(PropertyField.Serializer.INSTANCE)).serialize(value.addOrUpdateFields, g);
            }
            if (value.removeFields != null) {
                g.writeFieldName("remove_fields");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.removeFields, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PropertyGroupUpdate deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PropertyGroupUpdate value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_templateId = null;
                List<PropertyField> f_addOrUpdateFields = null;
                List<String> f_removeFields = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("template_id".equals(field)) {
                        f_templateId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("add_or_update_fields".equals(field)) {
                        f_addOrUpdateFields = StoneSerializers.nullable(StoneSerializers.list(PropertyField.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("remove_fields".equals(field)) {
                        f_removeFields = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_templateId == null) {
                    throw new JsonParseException(p, "Required field \"template_id\" missing.");
                }
                value = new PropertyGroupUpdate(f_templateId, f_addOrUpdateFields, f_removeFields);
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
