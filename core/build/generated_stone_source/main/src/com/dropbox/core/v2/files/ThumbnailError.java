/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

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

/**
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class ThumbnailError {
    // union files.ThumbnailError (files.stone)

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
    public static final ThumbnailError UNSUPPORTED_EXTENSION = new ThumbnailError().withTag(Tag.UNSUPPORTED_EXTENSION);
    /**
     * The image cannot be converted to a thumbnail.
     */
    public static final ThumbnailError UNSUPPORTED_IMAGE = new ThumbnailError().withTag(Tag.UNSUPPORTED_IMAGE);
    /**
     * An error occurs during thumbnail conversion.
     */
    public static final ThumbnailError CONVERSION_ERROR = new ThumbnailError().withTag(Tag.CONVERSION_ERROR);

    private Tag _tag;
    private LookupError pathValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private ThumbnailError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private ThumbnailError withTag(Tag _tag) {
        ThumbnailError result = new ThumbnailError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param pathValue  An error occurs when downloading metadata for the
     *     image. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ThumbnailError withTagAndPath(Tag _tag, LookupError pathValue) {
        ThumbnailError result = new ThumbnailError();
        result._tag = _tag;
        result.pathValue = pathValue;
        return result;
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
        return _tag;
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
        return new ThumbnailError().withTagAndPath(Tag.PATH, value);
    }

    /**
     * An error occurs when downloading metadata for the image.
     *
     * <p> This instance must be tagged as {@link Tag#PATH}. </p>
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
     * Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
     */
    public boolean isUnsupportedExtension() {
        return this._tag == Tag.UNSUPPORTED_EXTENSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNSUPPORTED_IMAGE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNSUPPORTED_IMAGE}, {@code false} otherwise.
     */
    public boolean isUnsupportedImage() {
        return this._tag == Tag.UNSUPPORTED_IMAGE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONVERSION_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CONVERSION_ERROR}, {@code false} otherwise.
     */
    public boolean isConversionError() {
        return this._tag == Tag.CONVERSION_ERROR;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.pathValue
        });
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
        else if (obj instanceof ThumbnailError) {
            ThumbnailError other = (ThumbnailError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
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
    static class Serializer extends UnionSerializer<ThumbnailError> {
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
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
