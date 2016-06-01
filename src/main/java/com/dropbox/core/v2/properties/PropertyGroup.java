/* DO NOT EDIT */
/* This file was generated from properties.stone */

package com.dropbox.core.v2.properties;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Collection of custom properties in filled property templates.
 */
public class PropertyGroup {
    // struct PropertyGroup

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
    public static final class Serializer extends StructSerializer<PropertyGroup> {
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
            return value;
        }
    }
}
