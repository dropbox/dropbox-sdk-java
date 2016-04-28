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
@JsonSerialize(using=SaveCopyReferenceError.Serializer.class)
@JsonDeserialize(using=SaveCopyReferenceError.Deserializer.class)
public final class SaveCopyReferenceError {
    // union SaveCopyReferenceError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link SaveCopyReferenceError}.
     */
    public enum Tag {
        PATH, // WriteError
        /**
         * The copy reference is invalid.
         */
        INVALID_COPY_REFERENCE,
        /**
         * The app has no permission to access another user's Dropbox.
         */
        NO_PERMISSION,
        /**
         * The file referenced by the copy reference cannot be found.
         */
        NOT_FOUND,
        /**
         * The operation would involve more than 10,000 files and folders.
         */
        TOO_MANY_FILES,
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
     * The copy reference is invalid.
     */
    public static final SaveCopyReferenceError INVALID_COPY_REFERENCE = new SaveCopyReferenceError(Tag.INVALID_COPY_REFERENCE, null);
    /**
     * The app has no permission to access another user's Dropbox.
     */
    public static final SaveCopyReferenceError NO_PERMISSION = new SaveCopyReferenceError(Tag.NO_PERMISSION, null);
    /**
     * The file referenced by the copy reference cannot be found.
     */
    public static final SaveCopyReferenceError NOT_FOUND = new SaveCopyReferenceError(Tag.NOT_FOUND, null);
    /**
     * The operation would involve more than 10,000 files and folders.
     */
    public static final SaveCopyReferenceError TOO_MANY_FILES = new SaveCopyReferenceError(Tag.TOO_MANY_FILES, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final SaveCopyReferenceError OTHER = new SaveCopyReferenceError(Tag.OTHER, null);

    private final Tag tag;
    private final WriteError pathValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private SaveCopyReferenceError(Tag tag, WriteError pathValue) {
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
     * values for this {@code SaveCopyReferenceError}. </p>
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
     * Returns an instance of {@code SaveCopyReferenceError} that has its tag
     * set to {@link Tag#PATH}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code SaveCopyReferenceError} with its tag set to
     *     {@link Tag#PATH}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static SaveCopyReferenceError path(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new SaveCopyReferenceError(Tag.PATH, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH}.
     *
     * @return The {@link SaveCopyReferenceError#path} value associated with
     *     this instance if {@link #isPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPath} is {@code false}.
     */
    public WriteError getPathValue() {
        if (this.tag != Tag.PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH, but was Tag." + tag.name());
        }
        return pathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_COPY_REFERENCE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_COPY_REFERENCE}, {@code false} otherwise.
     */
    public boolean isInvalidCopyReference() {
        return this.tag == Tag.INVALID_COPY_REFERENCE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this.tag == Tag.NO_PERMISSION;
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
     * Tag#TOO_MANY_FILES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_FILES}, {@code false} otherwise.
     */
    public boolean isTooManyFiles() {
        return this.tag == Tag.TOO_MANY_FILES;
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
            pathValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof SaveCopyReferenceError) {
            SaveCopyReferenceError other = (SaveCopyReferenceError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH:
                    return (this.pathValue == other.pathValue) || (this.pathValue.equals(other.pathValue));
                case INVALID_COPY_REFERENCE:
                    return true;
                case NO_PERMISSION:
                    return true;
                case NOT_FOUND:
                    return true;
                case TOO_MANY_FILES:
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

    static final class Serializer extends UnionJsonSerializer<SaveCopyReferenceError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SaveCopyReferenceError.class);
        }

        @Override
        public void serialize(SaveCopyReferenceError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case PATH:
                    g.writeStartObject();
                    g.writeStringField(".tag", "path");
                    g.writeObjectField("path", value.pathValue);
                    g.writeEndObject();
                    break;
                case INVALID_COPY_REFERENCE:
                    g.writeString("invalid_copy_reference");
                    break;
                case NO_PERMISSION:
                    g.writeString("no_permission");
                    break;
                case NOT_FOUND:
                    g.writeString("not_found");
                    break;
                case TOO_MANY_FILES:
                    g.writeString("too_many_files");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<SaveCopyReferenceError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SaveCopyReferenceError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public SaveCopyReferenceError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case PATH: {
                    WriteError value = null;
                    expectField(_p, "path");
                    value = _p.readValueAs(WriteError.class);
                    _p.nextToken();
                    return SaveCopyReferenceError.path(value);
                }
                case INVALID_COPY_REFERENCE: {
                    return SaveCopyReferenceError.INVALID_COPY_REFERENCE;
                }
                case NO_PERMISSION: {
                    return SaveCopyReferenceError.NO_PERMISSION;
                }
                case NOT_FOUND: {
                    return SaveCopyReferenceError.NOT_FOUND;
                }
                case TOO_MANY_FILES: {
                    return SaveCopyReferenceError.TOO_MANY_FILES;
                }
                case OTHER: {
                    return SaveCopyReferenceError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, SaveCopyReferenceError.Tag> getTagMapping() {
            Map<String, SaveCopyReferenceError.Tag> values = new HashMap<String, SaveCopyReferenceError.Tag>();
            values.put("path", SaveCopyReferenceError.Tag.PATH);
            values.put("invalid_copy_reference", SaveCopyReferenceError.Tag.INVALID_COPY_REFERENCE);
            values.put("no_permission", SaveCopyReferenceError.Tag.NO_PERMISSION);
            values.put("not_found", SaveCopyReferenceError.Tag.NOT_FOUND);
            values.put("too_many_files", SaveCopyReferenceError.Tag.TOO_MANY_FILES);
            values.put("other", SaveCopyReferenceError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
