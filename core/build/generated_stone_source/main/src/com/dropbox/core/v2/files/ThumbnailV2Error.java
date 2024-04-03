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
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class ThumbnailV2Error {
    // union files.ThumbnailV2Error (files.stone)

    /**
     * Discriminating tag type for {@link ThumbnailV2Error}.
     */
    public enum Tag {
        /**
         * An error occurred when downloading metadata for the image.
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
         * An error occurred during thumbnail conversion.
         */
        CONVERSION_ERROR,
        /**
         * Access to this shared link is forbidden.
         */
        ACCESS_DENIED,
        /**
         * The shared link does not exist.
         */
        NOT_FOUND,
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER; // *catch_all
    }

    /**
     * The file extension doesn't allow conversion to a thumbnail.
     */
    public static final ThumbnailV2Error UNSUPPORTED_EXTENSION = new ThumbnailV2Error().withTag(Tag.UNSUPPORTED_EXTENSION);
    /**
     * The image cannot be converted to a thumbnail.
     */
    public static final ThumbnailV2Error UNSUPPORTED_IMAGE = new ThumbnailV2Error().withTag(Tag.UNSUPPORTED_IMAGE);
    /**
     * An error occurred during thumbnail conversion.
     */
    public static final ThumbnailV2Error CONVERSION_ERROR = new ThumbnailV2Error().withTag(Tag.CONVERSION_ERROR);
    /**
     * Access to this shared link is forbidden.
     */
    public static final ThumbnailV2Error ACCESS_DENIED = new ThumbnailV2Error().withTag(Tag.ACCESS_DENIED);
    /**
     * The shared link does not exist.
     */
    public static final ThumbnailV2Error NOT_FOUND = new ThumbnailV2Error().withTag(Tag.NOT_FOUND);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final ThumbnailV2Error OTHER = new ThumbnailV2Error().withTag(Tag.OTHER);

    private Tag _tag;
    private LookupError pathValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private ThumbnailV2Error() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private ThumbnailV2Error withTag(Tag _tag) {
        ThumbnailV2Error result = new ThumbnailV2Error();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param pathValue  An error occurred when downloading metadata for the
     *     image. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private ThumbnailV2Error withTagAndPath(Tag _tag, LookupError pathValue) {
        ThumbnailV2Error result = new ThumbnailV2Error();
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
     * values for this {@code ThumbnailV2Error}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
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
     * Returns an instance of {@code ThumbnailV2Error} that has its tag set to
     * {@link Tag#PATH}.
     *
     * <p> An error occurred when downloading metadata for the image. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code ThumbnailV2Error} with its tag set to {@link
     *     Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static ThumbnailV2Error path(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new ThumbnailV2Error().withTagAndPath(Tag.PATH, value);
    }

    /**
     * An error occurred when downloading metadata for the image.
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

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_DENIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_DENIED}, {@code false} otherwise.
     */
    public boolean isAccessDenied() {
        return this._tag == Tag.ACCESS_DENIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_FOUND},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#NOT_FOUND},
     *     {@code false} otherwise.
     */
    public boolean isNotFound() {
        return this._tag == Tag.NOT_FOUND;
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
        else if (obj instanceof ThumbnailV2Error) {
            ThumbnailV2Error other = (ThumbnailV2Error) obj;
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
                case ACCESS_DENIED:
                    return true;
                case NOT_FOUND:
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
    static class Serializer extends UnionSerializer<ThumbnailV2Error> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ThumbnailV2Error value, JsonGenerator g) throws IOException, JsonGenerationException {
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
                case ACCESS_DENIED: {
                    g.writeString("access_denied");
                    break;
                }
                case NOT_FOUND: {
                    g.writeString("not_found");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public ThumbnailV2Error deserialize(JsonParser p) throws IOException, JsonParseException {
            ThumbnailV2Error value;
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
                value = ThumbnailV2Error.path(fieldValue);
            }
            else if ("unsupported_extension".equals(tag)) {
                value = ThumbnailV2Error.UNSUPPORTED_EXTENSION;
            }
            else if ("unsupported_image".equals(tag)) {
                value = ThumbnailV2Error.UNSUPPORTED_IMAGE;
            }
            else if ("conversion_error".equals(tag)) {
                value = ThumbnailV2Error.CONVERSION_ERROR;
            }
            else if ("access_denied".equals(tag)) {
                value = ThumbnailV2Error.ACCESS_DENIED;
            }
            else if ("not_found".equals(tag)) {
                value = ThumbnailV2Error.NOT_FOUND;
            }
            else {
                value = ThumbnailV2Error.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
