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
 * Defines how a single property field may be structured. Used exclusively by
 * {@link PropertyGroupTemplate}.
 */
public class PropertyFieldTemplate {
    // struct file_properties.PropertyFieldTemplate (file_properties.stone)

    protected final String name;
    protected final String description;
    protected final PropertyType type;

    /**
     * Defines how a single property field may be structured. Used exclusively
     * by {@link PropertyGroupTemplate}.
     *
     * @param name  Key of the property field being described. Property field
     *     keys can be up to 256 bytes. Must not be {@code null}.
     * @param description  Description of the property field. Property field
     *     descriptions can be up to 1024 bytes. Must not be {@code null}.
     * @param type  Data type of the value of this property field. This type
     *     will be enforced upon property creation and modifications. Must not
     *     be {@code null}.
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
     * Key of the property field being described. Property field keys can be up
     * to 256 bytes.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     * Description of the property field. Property field descriptions can be up
     * to 1024 bytes.
     *
     * @return value for this field, never {@code null}.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Data type of the value of this property field. This type will be enforced
     * upon property creation and modifications.
     *
     * @return value for this field, never {@code null}.
     */
    public PropertyType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<PropertyFieldTemplate> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PropertyFieldTemplate value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("description");
            StoneSerializers.string().serialize(value.description, g);
            g.writeFieldName("type");
            PropertyType.Serializer.INSTANCE.serialize(value.type, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public PropertyFieldTemplate deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            PropertyFieldTemplate value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_name = null;
                String f_description = null;
                PropertyType f_type = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("description".equals(field)) {
                        f_description = StoneSerializers.string().deserialize(p);
                    }
                    else if ("type".equals(field)) {
                        f_type = PropertyType.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_description == null) {
                    throw new JsonParseException(p, "Required field \"description\" missing.");
                }
                if (f_type == null) {
                    throw new JsonParseException(p, "Required field \"type\" missing.");
                }
                value = new PropertyFieldTemplate(f_name, f_description, f_type);
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
