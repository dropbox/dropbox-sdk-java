/* DO NOT EDIT */
/* This file was generated from file_properties.stone */

package com.dropbox.core.v2.fileproperties;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class ModifyTemplateError {
    // union file_properties.ModifyTemplateError (file_properties.stone)

    /**
     * Discriminating tag type for {@link ModifyTemplateError}.
     */
    public enum Tag {
        /**
         * Template does not exist for the given identifier.
         */
        TEMPLATE_NOT_FOUND, // String
        /**
         * You do not have permission to modify this template.
         */
        RESTRICTED_CONTENT,
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER,
        /**
         * A property field key with that name already exists in the template.
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
         * The template name, description or one or more of the property field
         * keys is too large.
         */
        TEMPLATE_ATTRIBUTE_TOO_LARGE;
    }

    /**
     * You do not have permission to modify this template.
     */
    public static final ModifyTemplateError RESTRICTED_CONTENT = new ModifyTemplateError().withTag(Tag.RESTRICTED_CONTENT);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final ModifyTemplateError OTHER = new ModifyTemplateError().withTag(Tag.OTHER);
    /**
     * A property field key with that name already exists in the template.
     */
    public static final ModifyTemplateError CONFLICTING_PROPERTY_NAMES = new ModifyTemplateError().withTag(Tag.CONFLICTING_PROPERTY_NAMES);
    /**
     * There are too many properties in the changed template. The maximum number
     * of properties per template is 32.
     */
    public static final ModifyTemplateError TOO_MANY_PROPERTIES = new ModifyTemplateError().withTag(Tag.TOO_MANY_PROPERTIES);
    /**
     * There are too many templates for the team.
     */
    public static final ModifyTemplateError TOO_MANY_TEMPLATES = new ModifyTemplateError().withTag(Tag.TOO_MANY_TEMPLATES);
    /**
     * The template name, description or one or more of the property field keys
     * is too large.
     */
    public static final ModifyTemplateError TEMPLATE_ATTRIBUTE_TOO_LARGE = new ModifyTemplateError().withTag(Tag.TEMPLATE_ATTRIBUTE_TOO_LARGE);

    private Tag _tag;
    private String templateNotFoundValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private ModifyTemplateError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private ModifyTemplateError withTag(Tag _tag) {
        ModifyTemplateError result = new ModifyTemplateError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param templateNotFoundValue  Template does not exist for the given
     *     identifier. Must have length of at least 1, match pattern "{@code
     *     (/|ptid:).*}", and not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ModifyTemplateError withTagAndTemplateNotFound(Tag _tag, String templateNotFoundValue) {
        ModifyTemplateError result = new ModifyTemplateError();
        result._tag = _tag;
        result.templateNotFoundValue = templateNotFoundValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ModifyTemplateError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEMPLATE_NOT_FOUND}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEMPLATE_NOT_FOUND}, {@code false} otherwise.
     */
    public boolean isTemplateNotFound() {
        return this._tag == Tag.TEMPLATE_NOT_FOUND;
    }

    /**
     * Returns an instance of {@code ModifyTemplateError} that has its tag set
     * to {@link Tag#TEMPLATE_NOT_FOUND}.
     *
     * <p> Template does not exist for the given identifier. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ModifyTemplateError} with its tag set to
     *     {@link Tag#TEMPLATE_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1,
     *     does not match pattern "{@code (/|ptid:).*}", or is {@code null}.
     */
    public static ModifyTemplateError templateNotFound(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new ModifyTemplateError().withTagAndTemplateNotFound(Tag.TEMPLATE_NOT_FOUND, value);
    }

    /**
     * Template does not exist for the given identifier.
     *
     * <p> This instance must be tagged as {@link Tag#TEMPLATE_NOT_FOUND}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isTemplateNotFound} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTemplateNotFound} is {@code
     *     false}.
     */
    public String getTemplateNotFoundValue() {
        if (this._tag != Tag.TEMPLATE_NOT_FOUND) {
            throw new IllegalStateException("Invalid tag: required Tag.TEMPLATE_NOT_FOUND, but was Tag." + this._tag.name());
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
        return this._tag == Tag.RESTRICTED_CONTENT;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONFLICTING_PROPERTY_NAMES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONFLICTING_PROPERTY_NAMES}, {@code false} otherwise.
     */
    public boolean isConflictingPropertyNames() {
        return this._tag == Tag.CONFLICTING_PROPERTY_NAMES;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_PROPERTIES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_PROPERTIES}, {@code false} otherwise.
     */
    public boolean isTooManyProperties() {
        return this._tag == Tag.TOO_MANY_PROPERTIES;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_TEMPLATES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_TEMPLATES}, {@code false} otherwise.
     */
    public boolean isTooManyTemplates() {
        return this._tag == Tag.TOO_MANY_TEMPLATES;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEMPLATE_ATTRIBUTE_TOO_LARGE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEMPLATE_ATTRIBUTE_TOO_LARGE}, {@code false} otherwise.
     */
    public boolean isTemplateAttributeTooLarge() {
        return this._tag == Tag.TEMPLATE_ATTRIBUTE_TOO_LARGE;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
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
        if (obj == null) {
            return false;
        }
        else if (obj instanceof ModifyTemplateError) {
            ModifyTemplateError other = (ModifyTemplateError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
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
    public static class Serializer extends UnionSerializer<ModifyTemplateError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ModifyTemplateError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case TEMPLATE_NOT_FOUND: {
                    g.writeStartObject();
                    writeTag("template_not_found", g);
                    g.writeFieldName("template_not_found");
                    StoneSerializers.string().serialize(value.templateNotFoundValue, g);
                    g.writeEndObject();
                    break;
                }
                case RESTRICTED_CONTENT: {
                    g.writeString("restricted_content");
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case CONFLICTING_PROPERTY_NAMES: {
                    g.writeString("conflicting_property_names");
                    break;
                }
                case TOO_MANY_PROPERTIES: {
                    g.writeString("too_many_properties");
                    break;
                }
                case TOO_MANY_TEMPLATES: {
                    g.writeString("too_many_templates");
                    break;
                }
                case TEMPLATE_ATTRIBUTE_TOO_LARGE: {
                    g.writeString("template_attribute_too_large");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public ModifyTemplateError deserialize(JsonParser p) throws IOException, JsonParseException {
            ModifyTemplateError value;
            boolean collapsed;
            String tag;
            if (p.getCurrentToken() == JsonToken.VALUE_STRING) {
                collapsed = true;
                tag = getStringValue(p);
                p.nextToken();
            }
            else {
                collapsed = false;
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                throw new JsonParseException(p, "Required field missing: " + TAG_FIELD);
            }
            else if ("template_not_found".equals(tag)) {
                String fieldValue = null;
                expectField("template_not_found", p);
                fieldValue = StoneSerializers.string().deserialize(p);
                value = ModifyTemplateError.templateNotFound(fieldValue);
            }
            else if ("restricted_content".equals(tag)) {
                value = ModifyTemplateError.RESTRICTED_CONTENT;
            }
            else if ("other".equals(tag)) {
                value = ModifyTemplateError.OTHER;
            }
            else if ("conflicting_property_names".equals(tag)) {
                value = ModifyTemplateError.CONFLICTING_PROPERTY_NAMES;
            }
            else if ("too_many_properties".equals(tag)) {
                value = ModifyTemplateError.TOO_MANY_PROPERTIES;
            }
            else if ("too_many_templates".equals(tag)) {
                value = ModifyTemplateError.TOO_MANY_TEMPLATES;
            }
            else if ("template_attribute_too_large".equals(tag)) {
                value = ModifyTemplateError.TEMPLATE_ATTRIBUTE_TOO_LARGE;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
