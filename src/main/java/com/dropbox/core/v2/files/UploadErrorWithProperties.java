/* DO NOT EDIT */
/* This file was generated from files_properties.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class UploadErrorWithProperties {
    // union UploadErrorWithProperties

    /**
     * Discriminating tag type for {@link UploadErrorWithProperties}.
     */
    public enum Tag {
        /**
         * Unable to save the uploaded contents to a file.
         */
        PATH, // UploadWriteFailed
        /**
         * An unspecified error.
         */
        OTHER,
        PROPERTIES_ERROR; // InvalidPropertyGroupError
    }

    /**
     * An unspecified error.
     */
    public static final UploadErrorWithProperties OTHER = new UploadErrorWithProperties(Tag.OTHER, null, null);

    private final Tag tag;
    private final UploadWriteFailed pathValue;
    private final InvalidPropertyGroupError propertiesErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UploadErrorWithProperties(Tag tag, UploadWriteFailed pathValue, InvalidPropertyGroupError propertiesErrorValue) {
        this.tag = tag;
        this.pathValue = pathValue;
        this.propertiesErrorValue = propertiesErrorValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UploadErrorWithProperties}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PATH},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#PATH},
     *     {@code false} otherwise.
     */
    public boolean isPath() {
        return this.tag == Tag.PATH;
    }

    /**
     * Returns an instance of {@code UploadErrorWithProperties} that has its tag
     * set to {@link Tag#PATH}.
     *
     * <p> Unable to save the uploaded contents to a file. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadErrorWithProperties} with its tag set to
     *     {@link Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadErrorWithProperties path(UploadWriteFailed value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadErrorWithProperties(Tag.PATH, value, null);
    }

    /**
     * Unable to save the uploaded contents to a file.
     *
     * <p> This instance must be tagged as {@link Tag#PATH}. </p>
     *
     * @return The {@link UploadErrorWithProperties#path} value associated with
     *     this instance if {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public UploadWriteFailed getPathValue() {
        if (this.tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + tag.name());
        }
        return pathValue;
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
     * Tag#PROPERTIES_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PROPERTIES_ERROR}, {@code false} otherwise.
     */
    public boolean isPropertiesError() {
        return this.tag == Tag.PROPERTIES_ERROR;
    }

    /**
     * Returns an instance of {@code UploadErrorWithProperties} that has its tag
     * set to {@link Tag#PROPERTIES_ERROR}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadErrorWithProperties} with its tag set to
     *     {@link Tag#PROPERTIES_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadErrorWithProperties propertiesError(InvalidPropertyGroupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadErrorWithProperties(Tag.PROPERTIES_ERROR, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PROPERTIES_ERROR}.
     *
     * @return The {@link UploadErrorWithProperties#propertiesError} value
     *     associated with this instance if {@link #isPropertiesError} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isPropertiesError} is {@code
     *     false}.
     */
    public InvalidPropertyGroupError getPropertiesErrorValue() {
        if (this.tag != Tag.PROPERTIES_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.PROPERTIES_ERROR, but was Tag." + tag.name());
        }
        return propertiesErrorValue;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            pathValue,
            propertiesErrorValue
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof UploadErrorWithProperties) {
            UploadErrorWithProperties other = (UploadErrorWithProperties) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case OTHER:
                    return true;
                case PROPERTIES_ERROR:
                    return (this.propertiesErrorValue == other.propertiesErrorValue) || (this.propertiesErrorValue.equals(other.propertiesErrorValue));
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
    static final class Serializer extends UnionSerializer<UploadErrorWithProperties> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UploadErrorWithProperties value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    UploadWriteFailed.Serializer.INSTANCE.serialize(value.pathValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case PROPERTIES_ERROR: {
                    g.writeStartObject();
                    writeTag("properties_error", g);
                    g.writeFieldName("properties_error");
                    InvalidPropertyGroupError.Serializer.INSTANCE.serialize(value.propertiesErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public UploadErrorWithProperties deserialize(JsonParser p) throws IOException, JsonParseException {
            UploadErrorWithProperties value;
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
            else if ("path".equals(tag)) {
                UploadWriteFailed fieldValue = null;
                fieldValue = UploadWriteFailed.Serializer.INSTANCE.deserialize(p, true);
                value = UploadErrorWithProperties.path(fieldValue);
            }
            else if ("other".equals(tag)) {
                value = UploadErrorWithProperties.OTHER;
            }
            else if ("properties_error".equals(tag)) {
                InvalidPropertyGroupError fieldValue = null;
                expectField("properties_error", p);
                fieldValue = InvalidPropertyGroupError.Serializer.INSTANCE.deserialize(p);
                value = UploadErrorWithProperties.propertiesError(fieldValue);
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
