/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

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

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("path", Tag.PATH);
        VALUES_.put("unsupported_extension", Tag.UNSUPPORTED_EXTENSION);
        VALUES_.put("unsupported_image", Tag.UNSUPPORTED_IMAGE);
        VALUES_.put("conversion_error", Tag.CONVERSION_ERROR);
    }

    public static final ThumbnailError UNSUPPORTED_EXTENSION = new ThumbnailError(Tag.UNSUPPORTED_EXTENSION, null);
    public static final ThumbnailError UNSUPPORTED_IMAGE = new ThumbnailError(Tag.UNSUPPORTED_IMAGE, null);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code ThumbnailError}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#PATH},
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
     * @param value  {@link ThumbnailError#path} value to assign to this
     *     instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#UNSUPPORTED_EXTENSION}, {@code false} otherwise.
     */
    public boolean isUnsupportedExtension() {
        return this.tag == Tag.UNSUPPORTED_EXTENSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#UNSUPPORTED_IMAGE}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#UNSUPPORTED_IMAGE}, {@code false} otherwise.
     */
    public boolean isUnsupportedImage() {
        return this.tag == Tag.UNSUPPORTED_IMAGE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CONVERSION_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static ThumbnailError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<ThumbnailError> _JSON_WRITER = new JsonWriter<ThumbnailError>() {
        public final void write(ThumbnailError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case PATH:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("path");
                    g.writeFieldName("path");
                    LookupError._JSON_WRITER.write(x.getPathValue(), g);
                    g.writeEndObject();
                    break;
                case UNSUPPORTED_EXTENSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unsupported_extension");
                    g.writeEndObject();
                    break;
                case UNSUPPORTED_IMAGE:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("unsupported_image");
                    g.writeEndObject();
                    break;
                case CONVERSION_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("conversion_error");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<ThumbnailError> _JSON_READER = new JsonReader<ThumbnailError>() {

        public final ThumbnailError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    throw new JsonReadException("Unanticipated tag " + text + " without catch-all", parser.getTokenLocation());
                }
                switch (tag) {
                    case UNSUPPORTED_EXTENSION: return ThumbnailError.UNSUPPORTED_EXTENSION;
                    case UNSUPPORTED_IMAGE: return ThumbnailError.UNSUPPORTED_IMAGE;
                    case CONVERSION_ERROR: return ThumbnailError.CONVERSION_ERROR;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            ThumbnailError value = null;
            if (tag != null) {
                switch (tag) {
                    case PATH: {
                        LookupError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = LookupError._JSON_READER
                            .readField(parser, "path", v);
                        value = ThumbnailError.path(v);
                        break;
                    }
                    case UNSUPPORTED_EXTENSION: {
                        value = ThumbnailError.UNSUPPORTED_EXTENSION;
                        break;
                    }
                    case UNSUPPORTED_IMAGE: {
                        value = ThumbnailError.UNSUPPORTED_IMAGE;
                        break;
                    }
                    case CONVERSION_ERROR: {
                        value = ThumbnailError.CONVERSION_ERROR;
                        break;
                    }
                }
            }
            if (value == null) {
                throw new JsonReadException("Unanticipated tag " + text, parser.getTokenLocation());
            }
            JsonReader.expectObjectEnd(parser);
            return value;
        }

    };
}
