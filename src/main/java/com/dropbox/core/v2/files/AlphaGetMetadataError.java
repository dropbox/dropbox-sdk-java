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
public final class AlphaGetMetadataError {
    // union AlphaGetMetadataError

    /**
     * Discriminating tag type for {@link AlphaGetMetadataError}.
     */
    public enum Tag {
        PATH, // LookupError
        PROPERTIES_ERROR; // LookUpPropertiesError
    }

    private final Tag tag;
    private final LookupError pathValue;
    private final LookUpPropertiesError propertiesErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private AlphaGetMetadataError(Tag tag, LookupError pathValue, LookUpPropertiesError propertiesErrorValue) {
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
     * values for this {@code AlphaGetMetadataError}. </p>
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
     * Returns an instance of {@code AlphaGetMetadataError} that has its tag set
     * to {@link Tag#PATH}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AlphaGetMetadataError} with its tag set to
     *     {@link Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AlphaGetMetadataError path(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AlphaGetMetadataError(Tag.PATH, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
     *
     * @return The {@link AlphaGetMetadataError#path} value associated with this
     *     instance if {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public LookupError getPathValue() {
        if (this.tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + tag.name());
        }
        return pathValue;
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
     * Returns an instance of {@code AlphaGetMetadataError} that has its tag set
     * to {@link Tag#PROPERTIES_ERROR}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code AlphaGetMetadataError} with its tag set to
     *     {@link Tag#PROPERTIES_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static AlphaGetMetadataError propertiesError(LookUpPropertiesError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new AlphaGetMetadataError(Tag.PROPERTIES_ERROR, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PROPERTIES_ERROR}.
     *
     * @return The {@link AlphaGetMetadataError#propertiesError} value
     *     associated with this instance if {@link #isPropertiesError} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isPropertiesError} is {@code
     *     false}.
     */
    public LookUpPropertiesError getPropertiesErrorValue() {
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
        else if (obj instanceof AlphaGetMetadataError) {
            AlphaGetMetadataError other = (AlphaGetMetadataError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
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
    static final class Serializer extends UnionSerializer<AlphaGetMetadataError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(AlphaGetMetadataError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    LookupError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case PROPERTIES_ERROR: {
                    g.writeStartObject();
                    writeTag("properties_error", g);
                    g.writeFieldName("properties_error");
                    LookUpPropertiesError.Serializer.INSTANCE.serialize(value.propertiesErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public AlphaGetMetadataError deserialize(JsonParser p) throws IOException, JsonParseException {
            AlphaGetMetadataError value;
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
                LookupError fieldValue = null;
                expectField("path", p);
                fieldValue = LookupError.Serializer.INSTANCE.deserialize(p);
                value = AlphaGetMetadataError.path(fieldValue);
            }
            else if ("properties_error".equals(tag)) {
                LookUpPropertiesError fieldValue = null;
                expectField("properties_error", p);
                fieldValue = LookUpPropertiesError.Serializer.INSTANCE.deserialize(p);
                value = AlphaGetMetadataError.propertiesError(fieldValue);
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
