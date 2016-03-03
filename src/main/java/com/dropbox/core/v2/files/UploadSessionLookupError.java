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
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
@JsonSerialize(using=UploadSessionLookupError.Serializer.class)
@JsonDeserialize(using=UploadSessionLookupError.Deserializer.class)
public final class UploadSessionLookupError {
    // union UploadSessionLookupError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link UploadSessionLookupError}.
     */
    public enum Tag {
        /**
         * The upload session id was not found.
         */
        NOT_FOUND,
        /**
         * The specified offset was incorrect. See the value for the correct
         * offset. (This error may occur when a previous request was received
         * and processed successfully but the client did not receive the
         * response, e.g. due to a network error.)
         */
        INCORRECT_OFFSET, // UploadSessionOffsetError
        /**
         * You are attempting to append data to an upload session that has
         * alread been closed (i.e. committed).
         */
        CLOSED,
        /**
         * An unspecified error.
         */
        OTHER; // *catch_all
    }

    /**
     * The upload session id was not found.
     */
    public static final UploadSessionLookupError NOT_FOUND = new UploadSessionLookupError(Tag.NOT_FOUND, null);
    /**
     * You are attempting to append data to an upload session that has alread
     * been closed (i.e. committed).
     */
    public static final UploadSessionLookupError CLOSED = new UploadSessionLookupError(Tag.CLOSED, null);
    /**
     * An unspecified error.
     */
    public static final UploadSessionLookupError OTHER = new UploadSessionLookupError(Tag.OTHER, null);

    private final Tag tag;
    private final UploadSessionOffsetError incorrectOffsetValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private UploadSessionLookupError(Tag tag, UploadSessionOffsetError incorrectOffsetValue) {
        this.tag = tag;
        this.incorrectOffsetValue = incorrectOffsetValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code UploadSessionLookupError}. </p>
     *
     * <p> If a tag returned by the server is unrecognized by this SDK, the
     * {@link Tag#OTHER} value will be used. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#NOT_FOUND},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#NOT_FOUND},
     *     {@code false} otherwise.
     */
    public boolean isNotFound() {
        return this.tag == Tag.NOT_FOUND;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INCORRECT_OFFSET}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INCORRECT_OFFSET}, {@code false} otherwise.
     */
    public boolean isIncorrectOffset() {
        return this.tag == Tag.INCORRECT_OFFSET;
    }

    /**
     * Returns an instance of {@code UploadSessionLookupError} that has its tag
     * set to {@link Tag#INCORRECT_OFFSET}.
     *
     * <p> The specified offset was incorrect. See the value for the correct
     * offset. (This error may occur when a previous request was received and
     * processed successfully but the client did not receive the response, e.g.
     * due to a network error.) </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code UploadSessionLookupError} with its tag set to
     *     {@link Tag#INCORRECT_OFFSET}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static UploadSessionLookupError incorrectOffset(UploadSessionOffsetError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new UploadSessionLookupError(Tag.INCORRECT_OFFSET, value);
    }

    /**
     * The specified offset was incorrect. See the value for the correct offset.
     * (This error may occur when a previous request was received and processed
     * successfully but the client did not receive the response, e.g. due to a
     * network error.)
     *
     * <p> This instance must be tagged as {@link Tag#INCORRECT_OFFSET}. </p>
     *
     * @return The {@link UploadSessionLookupError#incorrectOffset} value
     *     associated with this instance if {@link #isIncorrectOffset} is {@code
     *     true}.
     *
     * @throws IllegalStateException  If {@link #isIncorrectOffset} is {@code
     *     false}.
     */
    public UploadSessionOffsetError getIncorrectOffsetValue() {
        if (this.tag != Tag.INCORRECT_OFFSET) {
            throw new IllegalStateException("Invalid tag: required Tag.INCORRECT_OFFSET, but was Tag." + tag.name());
        }
        return incorrectOffsetValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#CLOSED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#CLOSED},
     *     {@code false} otherwise.
     */
    public boolean isClosed() {
        return this.tag == Tag.CLOSED;
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

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            tag,
            incorrectOffsetValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof UploadSessionLookupError) {
            UploadSessionLookupError other = (UploadSessionLookupError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case NOT_FOUND:
                    return true;
                case INCORRECT_OFFSET:
                    return (this.incorrectOffsetValue == other.incorrectOffsetValue) || (this.incorrectOffsetValue.equals(other.incorrectOffsetValue));
                case CLOSED:
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

    static final class Serializer extends UnionJsonSerializer<UploadSessionLookupError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(UploadSessionLookupError.class, UploadSessionOffsetError.class);
        }

        @Override
        public void serialize(UploadSessionLookupError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case NOT_FOUND:
                    g.writeString("not_found");
                    break;
                case INCORRECT_OFFSET:
                    g.writeStartObject();
                    g.writeStringField(".tag", "incorrect_offset");
                    getUnwrappingSerializer(UploadSessionOffsetError.class).serialize(value.incorrectOffsetValue, g, provider);
                    g.writeEndObject();
                    break;
                case CLOSED:
                    g.writeString("closed");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<UploadSessionLookupError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(UploadSessionLookupError.class, getTagMapping(), Tag.OTHER, UploadSessionOffsetError.class);
        }

        @Override
        public UploadSessionLookupError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case NOT_FOUND: {
                    return UploadSessionLookupError.NOT_FOUND;
                }
                case INCORRECT_OFFSET: {
                    UploadSessionOffsetError value = null;
                    value = readCollapsedStructValue(UploadSessionOffsetError.class, _p, _ctx);
                    return UploadSessionLookupError.incorrectOffset(value);
                }
                case CLOSED: {
                    return UploadSessionLookupError.CLOSED;
                }
                case OTHER: {
                    return UploadSessionLookupError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, UploadSessionLookupError.Tag> getTagMapping() {
            Map<String, UploadSessionLookupError.Tag> values = new HashMap<String, UploadSessionLookupError.Tag>();
            values.put("not_found", UploadSessionLookupError.Tag.NOT_FOUND);
            values.put("incorrect_offset", UploadSessionLookupError.Tag.INCORRECT_OFFSET);
            values.put("closed", UploadSessionLookupError.Tag.CLOSED);
            values.put("other", UploadSessionLookupError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
