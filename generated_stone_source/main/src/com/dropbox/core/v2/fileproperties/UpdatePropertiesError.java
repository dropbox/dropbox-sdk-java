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
public final class UpdatePropertiesError {
    // union file_properties.UpdatePropertiesError (file_properties.stone)

    /**
     * Discriminating tag type for {@link UpdatePropertiesError}.
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
        PATH, // LookupError
        /**
         * This folder cannot be tagged. Tagging folders is not supported for
         * team-owned templates.
         */
        UNSUPPORTED_FOLDER,
        /**
         * One or more of the supplied property field values is too large.
         */
        PROPERTY_FIELD_TOO_LARGE,
        /**
         * One or more of the supplied property fields does not conform to the
         * template specifications.
         */
        DOES_NOT_FIT_TEMPLATE,
        /**
         * There are 2 or more property groups referring to the same templates
         * in the input.
         */
        DUPLICATE_PROPERTY_GROUPS,
        PROPERTY_GROUP_LOOKUP; // LookUpPropertiesError
    }

    /**
     * You do not have permission to modify this template.
     */
    public static final UpdatePropertiesError RESTRICTED_CONTENT = new UpdatePropertiesError().withTag(Tag.RESTRICTED_CONTENT);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final UpdatePropertiesError OTHER = new UpdatePropertiesError().withTag(Tag.OTHER);
    /**
     * This folder cannot be tagged. Tagging folders is not supported for
     * team-owned templates.
     */
    public static final UpdatePropertiesError UNSUPPORTED_FOLDER = new UpdatePropertiesError().withTag(Tag.UNSUPPORTED_FOLDER);
    /**
     * One or more of the supplied property field values is too large.
     */
    public static final UpdatePropertiesError PROPERTY_FIELD_TOO_LARGE = new UpdatePropertiesError().withTag(Tag.PROPERTY_FIELD_TOO_LARGE);
    /**
     * One or more of the supplied property fields does not conform to the
     * template specifications.
     */
    public static final UpdatePropertiesError DOES_NOT_FIT_TEMPLATE = new UpdatePropertiesError().withTag(Tag.DOES_NOT_FIT_TEMPLATE);
    /**
     * There are 2 or more property groups referring to the same templates in
     * the input.
     */
    public static final UpdatePropertiesError DUPLICATE_PROPERTY_GROUPS = new UpdatePropertiesError().withTag(Tag.DUPLICATE_PROPERTY_GROUPS);

    private Tag _tag;
    private String templateNotFoundValue;
    private LookupError pathValue;
    private LookUpPropertiesError propertyGroupLookupValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private UpdatePropertiesError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private UpdatePropertiesError withTag(Tag _tag) {
        UpdatePropertiesError result = new UpdatePropertiesError();
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
    private UpdatePropertiesError withTagAndTemplateNotFound(Tag _tag, String templateNotFoundValue) {
        UpdatePropertiesError result = new UpdatePropertiesError();
        result._tag = _tag;
        result.templateNotFoundValue = templateNotFoundValue;
        return result;
    }

    /**
     *
     * @param pathValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UpdatePropertiesError withTagAndPath(Tag _tag, LookupError pathValue) {
        UpdatePropertiesError result = new UpdatePropertiesError();
        result._tag = _tag;
        result.pathValue = pathValue;
        return result;
    }

    /**
     *
     * @param propertyGroupLookupValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private UpdatePropertiesError withTagAndPropertyGroupLookup(Tag _tag, LookUpPropertiesError propertyGroupLookupValue) {
        UpdatePropertiesError result = new UpdatePropertiesError();
        result._tag = _tag;
        result.propertyGroupLookupValue = propertyGroupLookupValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UpdatePropertiesError}. </p>
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
     * Returns an instance of {@code UpdatePropertiesError} that has its tag set
     * to {@link Tag#TEMPLATE_NOT_FOUND}.
     *
     * <p> Template does not exist for the given identifier. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UpdatePropertiesError} with its tag set to
     *     {@link Tag#TEMPLATE_NOT_FOUND}.
     *
     * @throws IllegalArgumentException  if {@code value} is shorter than 1,
     *     does not match pattern "{@code (/|ptid:).*}", or is {@code null}.
     */
    public static UpdatePropertiesError templateNotFound(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        if (value.length() < 1) {
            throw new IllegalArgumentException("String is shorter than 1");
        }
        if (!Pattern.matches("(/|ptid:).*", value)) {
            throw new IllegalArgumentException("String does not match pattern");
        }
        return new UpdatePropertiesError().withTagAndTemplateNotFound(Tag.TEMPLATE_NOT_FOUND, value);
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
     * Returns {@code true} if this instance has the tag {@link Tag#PATH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#PATH},
     *     {@code false} otherwise.
     */
    public boolean isPath() {
        return this._tag == Tag.PATH;
    }

    /**
     * Returns an instance of {@code UpdatePropertiesError} that has its tag set
     * to {@link Tag#PATH}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UpdatePropertiesError} with its tag set to
     *     {@link Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UpdatePropertiesError path(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdatePropertiesError().withTagAndPath(Tag.PATH, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
     *
     * @return The {@link LookupError} value associated with this instance if
     *     {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public LookupError getPathValue() {
        if (this._tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + this._tag.name());
        }
        return pathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNSUPPORTED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNSUPPORTED_FOLDER}, {@code false} otherwise.
     */
    public boolean isUnsupportedFolder() {
        return this._tag == Tag.UNSUPPORTED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PROPERTY_FIELD_TOO_LARGE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PROPERTY_FIELD_TOO_LARGE}, {@code false} otherwise.
     */
    public boolean isPropertyFieldTooLarge() {
        return this._tag == Tag.PROPERTY_FIELD_TOO_LARGE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DOES_NOT_FIT_TEMPLATE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DOES_NOT_FIT_TEMPLATE}, {@code false} otherwise.
     */
    public boolean isDoesNotFitTemplate() {
        return this._tag == Tag.DOES_NOT_FIT_TEMPLATE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DUPLICATE_PROPERTY_GROUPS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DUPLICATE_PROPERTY_GROUPS}, {@code false} otherwise.
     */
    public boolean isDuplicatePropertyGroups() {
        return this._tag == Tag.DUPLICATE_PROPERTY_GROUPS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#PROPERTY_GROUP_LOOKUP}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PROPERTY_GROUP_LOOKUP}, {@code false} otherwise.
     */
    public boolean isPropertyGroupLookup() {
        return this._tag == Tag.PROPERTY_GROUP_LOOKUP;
    }

    /**
     * Returns an instance of {@code UpdatePropertiesError} that has its tag set
     * to {@link Tag#PROPERTY_GROUP_LOOKUP}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UpdatePropertiesError} with its tag set to
     *     {@link Tag#PROPERTY_GROUP_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UpdatePropertiesError propertyGroupLookup(LookUpPropertiesError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UpdatePropertiesError().withTagAndPropertyGroupLookup(Tag.PROPERTY_GROUP_LOOKUP, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PROPERTY_GROUP_LOOKUP}.
     *
     * @return The {@link LookUpPropertiesError} value associated with this
     *     instance if {@link #isPropertyGroupLookup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPropertyGroupLookup} is
     *     {@code false}.
     */
    public LookUpPropertiesError getPropertyGroupLookupValue() {
        if (this._tag != Tag.PROPERTY_GROUP_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PROPERTY_GROUP_LOOKUP, but was Tag." + this._tag.name());
        }
        return propertyGroupLookupValue;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
            templateNotFoundValue,
            pathValue,
            propertyGroupLookupValue
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
        else if (obj instanceof UpdatePropertiesError) {
            UpdatePropertiesError other = (UpdatePropertiesError) obj;
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
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case UNSUPPORTED_FOLDER:
                    return true;
                case PROPERTY_FIELD_TOO_LARGE:
                    return true;
                case DOES_NOT_FIT_TEMPLATE:
                    return true;
                case DUPLICATE_PROPERTY_GROUPS:
                    return true;
                case PROPERTY_GROUP_LOOKUP:
                    return (this.propertyGroupLookupValue == other.propertyGroupLookupValue) || (this.propertyGroupLookupValue.equals(other.propertyGroupLookupValue));
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
    public static class Serializer extends UnionSerializer<UpdatePropertiesError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UpdatePropertiesError value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    LookupError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case UNSUPPORTED_FOLDER: {
                    g.writeString("unsupported_folder");
                    break;
                }
                case PROPERTY_FIELD_TOO_LARGE: {
                    g.writeString("property_field_too_large");
                    break;
                }
                case DOES_NOT_FIT_TEMPLATE: {
                    g.writeString("does_not_fit_template");
                    break;
                }
                case DUPLICATE_PROPERTY_GROUPS: {
                    g.writeString("duplicate_property_groups");
                    break;
                }
                case PROPERTY_GROUP_LOOKUP: {
                    g.writeStartObject();
                    writeTag("property_group_lookup", g);
                    g.writeFieldName("property_group_lookup");
                    LookUpPropertiesError.Serializer.INSTANCE.serialize(value.propertyGroupLookupValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public UpdatePropertiesError deserialize(JsonParser p) throws IOException, JsonParseException {
            UpdatePropertiesError value;
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
                value = UpdatePropertiesError.templateNotFound(fieldValue);
            }
            else if ("restricted_content".equals(tag)) {
                value = UpdatePropertiesError.RESTRICTED_CONTENT;
            }
            else if ("other".equals(tag)) {
                value = UpdatePropertiesError.OTHER;
            }
            else if ("path".equals(tag)) {
                LookupError fieldValue = null;
                expectField("path", p);
                fieldValue = LookupError.Serializer.INSTANCE.deserialize(p);
                value = UpdatePropertiesError.path(fieldValue);
            }
            else if ("unsupported_folder".equals(tag)) {
                value = UpdatePropertiesError.UNSUPPORTED_FOLDER;
            }
            else if ("property_field_too_large".equals(tag)) {
                value = UpdatePropertiesError.PROPERTY_FIELD_TOO_LARGE;
            }
            else if ("does_not_fit_template".equals(tag)) {
                value = UpdatePropertiesError.DOES_NOT_FIT_TEMPLATE;
            }
            else if ("duplicate_property_groups".equals(tag)) {
                value = UpdatePropertiesError.DUPLICATE_PROPERTY_GROUPS;
            }
            else if ("property_group_lookup".equals(tag)) {
                LookUpPropertiesError fieldValue = null;
                expectField("property_group_lookup", p);
                fieldValue = LookUpPropertiesError.Serializer.INSTANCE.deserialize(p);
                value = UpdatePropertiesError.propertyGroupLookup(fieldValue);
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
