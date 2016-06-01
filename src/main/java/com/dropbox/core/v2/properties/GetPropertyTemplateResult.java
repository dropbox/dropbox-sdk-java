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
 * The Property template for the specified template.
 */
public class GetPropertyTemplateResult extends PropertyGroupTemplate {
    // struct GetPropertyTemplateResult


    /**
     * The Property template for the specified template.
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
    public GetPropertyTemplateResult(String name, String description, List<PropertyFieldTemplate> fields) {
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
            GetPropertyTemplateResult other = (GetPropertyTemplateResult) obj;
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
    static final class Serializer extends StructSerializer<GetPropertyTemplateResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(GetPropertyTemplateResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("description");
            StoneSerializers.string().serialize(value.description, g);
            g.writeFieldName("fields");
            StoneSerializers.list(PropertyFieldTemplate.Serializer.INSTANCE).serialize(value.fields, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public GetPropertyTemplateResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            GetPropertyTemplateResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_name = null;
                String f_description = null;
                List<PropertyFieldTemplate> f_fields = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("description".equals(field)) {
                        f_description = StoneSerializers.string().deserialize(p);
                    }
                    else if ("fields".equals(field)) {
                        f_fields = StoneSerializers.list(PropertyFieldTemplate.Serializer.INSTANCE).deserialize(p);
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
                if (f_fields == null) {
                    throw new JsonParseException(p, "Required field \"fields\" missing.");
                }
                value = new GetPropertyTemplateResult(f_name, f_description, f_fields);
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
