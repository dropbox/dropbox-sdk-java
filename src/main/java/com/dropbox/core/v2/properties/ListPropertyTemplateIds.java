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

@JsonSerialize(using=ListPropertyTemplateIds.Serializer.class)
@JsonDeserialize(using=ListPropertyTemplateIds.Deserializer.class)
public class ListPropertyTemplateIds {
    // struct ListPropertyTemplateIds

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends StructJsonSerializer<ListPropertyTemplateIds> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ListPropertyTemplateIds.class);
        }

        public Serializer(boolean unwrapping) {
            super(ListPropertyTemplateIds.class, unwrapping);
        }

        @Override
        protected JsonSerializer<ListPropertyTemplateIds> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(ListPropertyTemplateIds value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("template_ids", value.templateIds);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<ListPropertyTemplateIds> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ListPropertyTemplateIds.class);
        }

        public Deserializer(boolean unwrapping) {
            super(ListPropertyTemplateIds.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<ListPropertyTemplateIds> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public ListPropertyTemplateIds deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<String> templateIds = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("template_ids".equals(_field)) {
                    expectArrayStart(_p);
                    templateIds = new java.util.ArrayList<String>();
                    while (!isArrayEnd(_p)) {
                        String _x = null;
                        _x = getStringValue(_p);
                        _p.nextToken();
                        templateIds.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (templateIds == null) {
                throw new JsonParseException(_p, "Required field \"template_ids\" is missing.");
            }

            return new ListPropertyTemplateIds(templateIds);
        }
    }
}
