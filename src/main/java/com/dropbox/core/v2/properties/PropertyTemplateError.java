/* DO NOT EDIT */
/* This file was generated from properties.babel */

package com.dropbox.core.v2.properties;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.UnionJsonDeserializer;
import com.dropbox.core.json.UnionJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
@JsonSerialize(using=PropertyTemplateError.Serializer.class)
@JsonDeserialize(using=PropertyTemplateError.Deserializer.class)
public final class PropertyTemplateError {
    // union PropertyTemplateError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link PropertyTemplateError}.
     */
    public enum Tag {
        /**
         * Property template does not exist for given identifier.
         */
        TEMPLATE_NOT_FOUND, // String
        /**
         * You do not have the permissions to modify this property template.
         */
        RESTRICTED_CONTENT,
        /**
         * An unspecified error.
         */
        OTHER; // *catch_all
    }

    /**
     * You do not have the permissions to modify this property template.
     */
    public static final PropertyTemplateError RESTRICTED_CONTENT = new PropertyTemplateError(Tag.RESTRICTED_CONTENT, null);
    /**
     * An unspecified error.
     */
    public static final PropertyTemplateError OTHER = new PropertyTemplateError(Tag.OTHER, null);

    private final Tag tag;
    private final String templateNotFoundValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private PropertyTemplateError(Tag tag, String templateNotFoundValue) {
        this.tag = tag;
        this.templateNotFoundValue = templateNotFoundValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code PropertyTemplateError}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEMPLATE_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEMPLATE_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isTemplateNotFound() {
        return this.tag == Tag.TEMPLATE_NOT_FOUND;
    }

    /**
     * Returns an instance of {@code PropertyTemplateError} that has its tag set
     * to {@link Tag#TEMPLATE_NOT_FOUND}.
     *
     * <p> Property template does not exist for given identifier. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PropertyTemplateError} with its tag set to
     *     {@link Tag#TEMPLATE_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1,
     *     does not match pattern "{@code (/|ptid:).*}", or is {@code null}.
     */
    public static PropertyTemplateError templateNotFound(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        if (!java.util.regex.Pattern.matches("(/|ptid:).*", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new PropertyTemplateError(Tag.TEMPLATE_NOT_FOUND, value);
    }

    /**
     * Property template does not exist for given identifier.
     *
     * <p> This instance must be tagged as {@link Tag#TEMPLATE_NOT_FOUND}. </p>
     *
     * @return The {@link PropertyTemplateError#templateNotFound} value
     *     associated with this instance if {@link #isTemplateNotFound} is
     *     {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTemplateNotFound} is {@code
     *     false}.
     */
    public String getTemplateNotFoundValue() {
        if (this.tag != Tag.TEMPLATE_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.TEMPLATE_NOT_FOUND, but was Tag." + tag.name());
        }
        return templateNotFoundValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#RESTRICTED_CONTENT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#RESTRICTED_CONTENT}, {@code false} otherwise.
     */
    public boolean isRestrictedContent() {
        return this.tag == Tag.RESTRICTED_CONTENT;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this.tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            templateNotFoundValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof PropertyTemplateError) {
            PropertyTemplateError other = (PropertyTemplateError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case TEMPLATE_NOT_FOUND:
                    return (this.templateNotFoundValue == other.templateNotFoundValue) || (this.templateNotFoundValue.equals(other.templateNotFoundValue));
                case RESTRICTED_CONTENT:
                    return true;
                case OTHER:
                    return true;
                default:
                    return false;
            }
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

    static final class Serializer extends UnionJsonSerializer<PropertyTemplateError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PropertyTemplateError.class);
        }

        @Override
        public void serialize(PropertyTemplateError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case TEMPLATE_NOT_FOUND:
                    g.writeStartObject();
                    g.writeStringField(".tag", "template_not_found");
                    g.writeObjectField("template_not_found", value.templateNotFoundValue);
                    g.writeEndObject();
                    break;
                case RESTRICTED_CONTENT:
                    g.writeString("restricted_content");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<PropertyTemplateError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PropertyTemplateError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public PropertyTemplateError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case TEMPLATE_NOT_FOUND: {
                    String value = null;
                    expectField(_p, "template_not_found");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return PropertyTemplateError.templateNotFound(value);
                }
                case RESTRICTED_CONTENT: {
                    return PropertyTemplateError.RESTRICTED_CONTENT;
                }
                case OTHER: {
                    return PropertyTemplateError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, PropertyTemplateError.Tag> getTagMapping() {
            Map<String, PropertyTemplateError.Tag> values = new HashMap<String, PropertyTemplateError.Tag>();
            values.put("template_not_found", PropertyTemplateError.Tag.TEMPLATE_NOT_FOUND);
            values.put("restricted_content", PropertyTemplateError.Tag.RESTRICTED_CONTENT);
            values.put("other", PropertyTemplateError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
