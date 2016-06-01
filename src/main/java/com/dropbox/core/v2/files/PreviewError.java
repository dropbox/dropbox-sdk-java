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
public final class PreviewError {
    // union PreviewError

    /**
     * Discriminating tag type for {@link PreviewError}.
     */
    public enum Tag {
        /**
         * An error occurs when downloading metadata for the file.
         */
        PATH, // LookupError
        /**
         * This preview generation is still in progress and the file is not
         * ready  for preview yet.
         */
        IN_PROGRESS,
        /**
         * The file extension is not supported preview generation.
         */
        UNSUPPORTED_EXTENSION,
        /**
         * The file content is not supported for preview generation.
         */
        UNSUPPORTED_CONTENT;
    }

    /**
     * This preview generation is still in progress and the file is not ready
     * for preview yet.
     */
    public static final PreviewError IN_PROGRESS = new PreviewError(Tag.IN_PROGRESS, null);
    /**
     * The file extension is not supported preview generation.
     */
    public static final PreviewError UNSUPPORTED_EXTENSION = new PreviewError(Tag.UNSUPPORTED_EXTENSION, null);
    /**
     * The file content is not supported for preview generation.
     */
    public static final PreviewError UNSUPPORTED_CONTENT = new PreviewError(Tag.UNSUPPORTED_CONTENT, null);

    private final Tag tag;
    private final LookupError pathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private PreviewError(Tag tag, LookupError pathValue) {
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
     * values for this {@code PreviewError}. </p>
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
     * Returns an instance of {@code PreviewError} that has its tag set to
     * {@link Tag#PATH}.
     *
     * <p> An error occurs when downloading metadata for the file. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code PreviewError} with its tag set to {@link
     *     Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static PreviewError path(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new PreviewError(Tag.PATH, value);
    }

    /**
     * An error occurs when downloading metadata for the file.
     *
     * <p> This instance must be tagged as {@link Tag#PATH}. </p>
     *
     * @return The {@link PreviewError#path} value associated with this instance
     *     if {@link #isPath} is {@code true}.
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
     * Tag#IN_PROGRESS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#IN_PROGRESS}, {@code false} otherwise.
     */
    public boolean isInProgress() {
        return this.tag == Tag.IN_PROGRESS;
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
     * Tag#UNSUPPORTED_CONTENT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#UNSUPPORTED_CONTENT}, {@code false} otherwise.
     */
    public boolean isUnsupportedContent() {
        return this.tag == Tag.UNSUPPORTED_CONTENT;
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
        else if (obj instanceof PreviewError) {
            PreviewError other = (PreviewError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case IN_PROGRESS:
                    return true;
                case UNSUPPORTED_EXTENSION:
                    return true;
                case UNSUPPORTED_CONTENT:
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
    static final class Serializer extends UnionSerializer<PreviewError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(PreviewError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH: {
                    g.writeStartObject();
                    writeTag("path", g);
                    g.writeFieldName("path");
                    LookupError.Serializer.INSTANCE.serialize(value.pathValue, g);
                    g.writeEndObject();
                    break;
                }
                case IN_PROGRESS: {
                    g.writeString("in_progress");
                    break;
                }
                case UNSUPPORTED_EXTENSION: {
                    g.writeString("unsupported_extension");
                    break;
                }
                case UNSUPPORTED_CONTENT: {
                    g.writeString("unsupported_content");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public PreviewError deserialize(JsonParser p) throws IOException, JsonParseException {
            PreviewError value;
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
                value = PreviewError.path(fieldValue);
            }
            else if ("in_progress".equals(tag)) {
                value = PreviewError.IN_PROGRESS;
            }
            else if ("unsupported_extension".equals(tag)) {
                value = PreviewError.UNSUPPORTED_EXTENSION;
            }
            else if ("unsupported_content".equals(tag)) {
                value = PreviewError.UNSUPPORTED_CONTENT;
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
