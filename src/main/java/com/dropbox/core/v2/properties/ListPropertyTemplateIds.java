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

public class ListPropertyTemplateIds {
    // struct ListPropertyTemplateIds

    protected final List<String> templateIds;

    /**
     *
     * @param templateIds  List of identifiers for templates added by route
     *     properties/template/add. Must not contain a {@code null} item and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListPropertyTemplateIds(List<String> templateIds) {
        if (templateIds == null) {
            throw new IllegalArgumentException("Required value for 'templateIds' is null");
        }
        for (String x : templateIds) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'templateIds' is null");
            }
            if (x.length() < 1) {
                throw new IllegalArgumentException("Stringan item in list 'templateIds' is shorter than 1");
            }
            if (!java.util.regex.Pattern.matches("(/|ptid:).*", x)) {
                throw new IllegalArgumentException("Stringan item in list 'templateIds' does not match pattern");
            }
        }
        this.templateIds = templateIds;
    }

    /**
     * List of identifiers for templates added by route properties/template/add.
     *
     * @return value for this field, never {@code null}.
     */
    public List<String> getTemplateIds() {
        return templateIds;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            templateIds
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
            ListPropertyTemplateIds other = (ListPropertyTemplateIds) obj;
            return (this.templateIds == other.templateIds) || (this.templateIds.equals(other.templateIds));
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
    static final class Serializer extends StructSerializer<ListPropertyTemplateIds> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ListPropertyTemplateIds value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("template_ids");
            StoneSerializers.list(StoneSerializers.string()).serialize(value.templateIds, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ListPropertyTemplateIds deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ListPropertyTemplateIds value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<String> f_templateIds = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("template_ids".equals(field)) {
                        f_templateIds = StoneSerializers.list(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_templateIds == null) {
                    throw new JsonParseException(p, "Required field \"template_ids\" missing.");
                }
                value = new ListPropertyTemplateIds(f_templateIds);
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
