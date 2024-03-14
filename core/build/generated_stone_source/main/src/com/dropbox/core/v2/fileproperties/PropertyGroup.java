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

/**
 * A subset of the property fields described by the corresponding {@link
 * PropertyGroupTemplate}. Properties are always added to a Dropbox file as a
 * {@link PropertyGroup}. The possible key names and value types in this group
 * are defined by the corresponding {@link PropertyGroupTemplate}.
 */
public class PropertyGroup {
    // struct file_properties.PropertyGroup (file_properties.stone)

    protected final String templateId;
    protected final List<PropertyField> fields;

    /**
     * A subset of the property fields described by the corresponding {@link
     * PropertyGroupTemplate}. Properties are always added to a Dropbox file as
     * a {@link PropertyGroup}. The possible key names and value types in this
     * group are defined by the corresponding {@link PropertyGroupTemplate}.
     *
     * @param templateId  A unique identifier for the associated template. Must
     *     have length of at least 1, match pattern "{@code (/|ptid:).*}", and
     *     not be {@code null}.
     * @param fields  The actual properties associated with the template. There
     *     can be up to 32 property types per template. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PropertyGroup(@javax.annotation.Nonnull String templateId, @javax.annotation.Nonnull List<PropertyField> fields) {
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
     * A unique identifier for the associated template.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTemplateId() {
        return templateId;
    }

    /**
     * The actual properties associated with the template. There can be up to 32
     * property types per template.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<PropertyField> getFields() {
        return fields;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    public static class Serializer extends StructSerializer<PropertyGroup> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertyGroup value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("template_id");
            StoneSerializers.string().serialize(value.templateId, g);
            g.writeFieldName("fields");
            StoneSerializers.list(PropertyField.Serializer.INSTANCE).serialize(value.fields, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PropertyGroup deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PropertyGroup value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_templateId = null;
                List<PropertyField> f_fields = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("template_id".equals(field)) {
                        f_templateId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("fields".equals(field)) {
                        f_fields = StoneSerializers.list(PropertyField.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_templateId == null) {
                    throw new JsonParseException(p, "Required field \"template_id\" missing.");
                }
                if (f_fields == null) {
                    throw new JsonParseException(p, "Required field \"fields\" missing.");
                }
                value = new PropertyGroup(f_templateId, f_fields);
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
