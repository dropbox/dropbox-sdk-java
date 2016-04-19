/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

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
@JsonSerialize(using=PreviewError.Serializer.class)
@JsonDeserialize(using=PreviewError.Deserializer.class)
public final class PreviewError {
    // union PreviewError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends UnionJsonSerializer<PreviewError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(PreviewError.class);
        }

        @Override
        public void serialize(PreviewError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case PATH:
                    g.writeStartObject();
                    g.writeStringField(".tag", "path");
                    g.writeObjectField("path", value.pathValue);
                    g.writeEndObject();
                    break;
                case IN_PROGRESS:
                    g.writeString("in_progress");
                    break;
                case UNSUPPORTED_EXTENSION:
                    g.writeString("unsupported_extension");
                    break;
                case UNSUPPORTED_CONTENT:
                    g.writeString("unsupported_content");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<PreviewError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(PreviewError.class, getTagMapping(), null);
        }

        @Override
        public PreviewError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case PATH: {
                    LookupError value = null;
                    expectField(_p, "path");
                    value = _p.readValueAs(LookupError.class);
                    _p.nextToken();
                    return PreviewError.path(value);
                }
                case IN_PROGRESS: {
                    return PreviewError.IN_PROGRESS;
                }
                case UNSUPPORTED_EXTENSION: {
                    return PreviewError.UNSUPPORTED_EXTENSION;
                }
                case UNSUPPORTED_CONTENT: {
                    return PreviewError.UNSUPPORTED_CONTENT;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, PreviewError.Tag> getTagMapping() {
            Map<String, PreviewError.Tag> values = new HashMap<String, PreviewError.Tag>();
            values.put("path", PreviewError.Tag.PATH);
            values.put("in_progress", PreviewError.Tag.IN_PROGRESS);
            values.put("unsupported_extension", PreviewError.Tag.UNSUPPORTED_EXTENSION);
            values.put("unsupported_content", PreviewError.Tag.UNSUPPORTED_CONTENT);
            return Collections.unmodifiableMap(values);
        }
    }
}
