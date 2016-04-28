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
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
@JsonSerialize(using=ModifyPropertyTemplateError.Serializer.class)
@JsonDeserialize(using=ModifyPropertyTemplateError.Deserializer.class)
public final class ModifyPropertyTemplateError {
    // union ModifyPropertyTemplateError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link ModifyPropertyTemplateError}.
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
        OTHER,
        /**
         * A property field name already exists in the template.
         */
        CONFLICTING_PROPERTY_NAMES,
        /**
         * There are too many properties in the changed template. The maximum
         * number of properties per template is 32.
         */
        TOO_MANY_PROPERTIES,
        /**
         * There are too many templates for the team.
         */
        TOO_MANY_TEMPLATES,
        /**
         * The template name, description or field names is too large.
         */
        TEMPLATE_ATTRIBUTE_TOO_LARGE;
    }

    /**
     * You do not have the permissions to modify this property template.
     */
    public static final ModifyPropertyTemplateError RESTRICTED_CONTENT = new ModifyPropertyTemplateError(Tag.RESTRICTED_CONTENT, null);
    /**
     * An unspecified error.
     */
    public static final ModifyPropertyTemplateError OTHER = new ModifyPropertyTemplateError(Tag.OTHER, null);
    /**
     * A property field name already exists in the template.
     */
    public static final ModifyPropertyTemplateError CONFLICTING_PROPERTY_NAMES = new ModifyPropertyTemplateError(Tag.CONFLICTING_PROPERTY_NAMES, null);
    /**
     * There are too many properties in the changed template. The maximum number
     * of properties per template is 32.
     */
    public static final ModifyPropertyTemplateError TOO_MANY_PROPERTIES = new ModifyPropertyTemplateError(Tag.TOO_MANY_PROPERTIES, null);
    /**
     * There are too many templates for the team.
     */
    public static final ModifyPropertyTemplateError TOO_MANY_TEMPLATES = new ModifyPropertyTemplateError(Tag.TOO_MANY_TEMPLATES, null);
    /**
     * The template name, description or field names is too large.
     */
    public static final ModifyPropertyTemplateError TEMPLATE_ATTRIBUTE_TOO_LARGE = new ModifyPropertyTemplateError(Tag.TEMPLATE_ATTRIBUTE_TOO_LARGE, null);

    private final Tag tag;
    private final String templateNotFoundValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ModifyPropertyTemplateError(Tag tag, String templateNotFoundValue) {
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
     * values for this {@code ModifyPropertyTemplateError}. </p>
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
     * Returns an instance of {@code ModifyPropertyTemplateError} that has its
     * tag set to {@link Tag#TEMPLATE_NOT_FOUND}.
     *
     * <p> Property template does not exist for given identifier. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ModifyPropertyTemplateError} with its tag set
     *     to {@link Tag#TEMPLATE_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1,
     *     does not match pattern "{@code (/|ptid:).*}", or is {@code null}.
     */
    public static ModifyPropertyTemplateError templateNotFound(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        if (!java.util.regex.Pattern.matches("(/|ptid:).*", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new ModifyPropertyTemplateError(Tag.TEMPLATE_NOT_FOUND, value);
    }

    /**
     * Property template does not exist for given identifier.
     *
     * <p> This instance must be tagged as {@link Tag#TEMPLATE_NOT_FOUND}. </p>
     *
     * @return The {@link ModifyPropertyTemplateError#templateNotFound} value
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

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONFLICTING_PROPERTY_NAMES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONFLICTING_PROPERTY_NAMES}, {@code false} otherwise.
     */
    public boolean isConflictingPropertyNames() {
        return this.tag == Tag.CONFLICTING_PROPERTY_NAMES;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_PROPERTIES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_PROPERTIES}, {@code false} otherwise.
     */
    public boolean isTooManyProperties() {
        return this.tag == Tag.TOO_MANY_PROPERTIES;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_TEMPLATES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_TEMPLATES}, {@code false} otherwise.
     */
    public boolean isTooManyTemplates() {
        return this.tag == Tag.TOO_MANY_TEMPLATES;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEMPLATE_ATTRIBUTE_TOO_LARGE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEMPLATE_ATTRIBUTE_TOO_LARGE}, {@code false} otherwise.
     */
    public boolean isTemplateAttributeTooLarge() {
        return this.tag == Tag.TEMPLATE_ATTRIBUTE_TOO_LARGE;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            templateNotFoundValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ModifyPropertyTemplateError) {
            ModifyPropertyTemplateError other = (ModifyPropertyTemplateError) obj;
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
                case CONFLICTING_PROPERTY_NAMES:
                    return true;
                case TOO_MANY_PROPERTIES:
                    return true;
                case TOO_MANY_TEMPLATES:
                    return true;
                case TEMPLATE_ATTRIBUTE_TOO_LARGE:
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

    static final class Serializer extends UnionJsonSerializer<ModifyPropertyTemplateError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(ModifyPropertyTemplateError.class);
        }

        @Override
        public void serialize(ModifyPropertyTemplateError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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
                case CONFLICTING_PROPERTY_NAMES:
                    g.writeString("conflicting_property_names");
                    break;
                case TOO_MANY_PROPERTIES:
                    g.writeString("too_many_properties");
                    break;
                case TOO_MANY_TEMPLATES:
                    g.writeString("too_many_templates");
                    break;
                case TEMPLATE_ATTRIBUTE_TOO_LARGE:
                    g.writeString("template_attribute_too_large");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<ModifyPropertyTemplateError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(ModifyPropertyTemplateError.class, getTagMapping(), null);
        }

        @Override
        public ModifyPropertyTemplateError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case TEMPLATE_NOT_FOUND: {
                    String value = null;
                    expectField(_p, "template_not_found");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return ModifyPropertyTemplateError.templateNotFound(value);
                }
                case RESTRICTED_CONTENT: {
                    return ModifyPropertyTemplateError.RESTRICTED_CONTENT;
                }
                case OTHER: {
                    return ModifyPropertyTemplateError.OTHER;
                }
                case CONFLICTING_PROPERTY_NAMES: {
                    return ModifyPropertyTemplateError.CONFLICTING_PROPERTY_NAMES;
                }
                case TOO_MANY_PROPERTIES: {
                    return ModifyPropertyTemplateError.TOO_MANY_PROPERTIES;
                }
                case TOO_MANY_TEMPLATES: {
                    return ModifyPropertyTemplateError.TOO_MANY_TEMPLATES;
                }
                case TEMPLATE_ATTRIBUTE_TOO_LARGE: {
                    return ModifyPropertyTemplateError.TEMPLATE_ATTRIBUTE_TOO_LARGE;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, ModifyPropertyTemplateError.Tag> getTagMapping() {
            Map<String, ModifyPropertyTemplateError.Tag> values = new HashMap<String, ModifyPropertyTemplateError.Tag>();
            values.put("conflicting_property_names", ModifyPropertyTemplateError.Tag.CONFLICTING_PROPERTY_NAMES);
            values.put("too_many_properties", ModifyPropertyTemplateError.Tag.TOO_MANY_PROPERTIES);
            values.put("too_many_templates", ModifyPropertyTemplateError.Tag.TOO_MANY_TEMPLATES);
            values.put("template_attribute_too_large", ModifyPropertyTemplateError.Tag.TEMPLATE_ATTRIBUTE_TOO_LARGE);
            return Collections.unmodifiableMap(values);
        }
    }
}
