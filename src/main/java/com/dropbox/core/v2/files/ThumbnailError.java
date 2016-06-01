/* DO NOT EDIT */
/* This file was generated from files.stone */

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
public final class ThumbnailError {
    // union ThumbnailError

    /**
     * Discriminating tag type for {@link ThumbnailError}.
     */
    public enum Tag {
        /**
         * An error occurs when downloading metadata for the image.
         */
        PATH, // LookupError
        /**
         * The file extension doesn't allow conversion to a thumbnail.
         */
        UNSUPPORTED_EXTENSION,
        /**
         * The image cannot be converted to a thumbnail.
         */
        UNSUPPORTED_IMAGE,
        /**
         * An error occurs during thumbnail conversion.
         */
        CONVERSION_ERROR;
    }

    /**
     * The file extension doesn't allow conversion to a thumbnail.
     */
    public static final ThumbnailError UNSUPPORTED_EXTENSION = new ThumbnailError(Tag.UNSUPPORTED_EXTENSION, null);
    /**
     * The image cannot be converted to a thumbnail.
     */
    public static final ThumbnailError UNSUPPORTED_IMAGE = new ThumbnailError(Tag.UNSUPPORTED_IMAGE, null);
    /**
     * An error occurs during thumbnail conversion.
     */
    public static final ThumbnailError CONVERSION_ERROR = new ThumbnailError(Tag.CONVERSION_ERROR, null);

    private final Tag tag;
    private final LookupError pathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private ThumbnailError(Tag tag, LookupError pathValue) {
        this.tag = tag;
        this.pathValue = pathValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code ThumbnailError}. </p>
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
     * Returns an instance of {@code ThumbnailError} that has its tag set to
     * {@link Tag#PATH}.
     *
     * <p> An error occurs when downloading metadata for the image. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ThumbnailError} with its tag set to {@link
     *     Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ThumbnailError path(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ThumbnailError(Tag.PATH, value);
    }

    /**
     * An error occurs when downloading metadata for the image.
     *
     * <p> This instance must be tagged as {@link Tag#PATH}. </p>
     *
     * @return The {@link ThumbnailError#path} value associated with this
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
     * Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
     */
    public boolean isUnsupportedExtension() {
        return this.tag == Tag.UNSUPPORTED_EXTENSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNSUPPORTED_IMAGE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNSUPPORTED_IMAGE}, {@code false} otherwise.
     */
    public boolean isUnsupportedImage() {
        return this.tag == Tag.UNSUPPORTED_IMAGE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONVERSION_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONVERSION_ERROR}, {@code false} otherwise.
     */
    public boolean isConversionError() {
        return this.tag == Tag.CONVERSION_ERROR;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            pathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof ThumbnailError) {
            ThumbnailError other = (ThumbnailError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case UNSUPPORTED_EXTENSION:
                    return true;
                case UNSUPPORTED_IMAGE:
                    return true;
                case CONVERSION_ERROR:
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
    static final class Serializer extends UnionSerializer<ThumbnailError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ThumbnailError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    LookupError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case UNSUPPORTED_EXTENSION: {
                    g.writeString("unsupported_extension");
                    break;
                }
                case UNSUPPORTED_IMAGE: {
                    g.writeString("unsupported_image");
                    break;
                }
                case CONVERSION_ERROR: {
                    g.writeString("conversion_error");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public ThumbnailError deserialize(JsonParser p) throws IOException, JsonParseException {
            ThumbnailError value;
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
                value = ThumbnailError.path(fieldValue);
            }
            else if ("unsupported_extension".equals(tag)) {
                value = ThumbnailError.UNSUPPORTED_EXTENSION;
            }
            else if ("unsupported_image".equals(tag)) {
                value = ThumbnailError.UNSUPPORTED_IMAGE;
            }
            else if ("conversion_error".equals(tag)) {
                value = ThumbnailError.CONVERSION_ERROR;
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
