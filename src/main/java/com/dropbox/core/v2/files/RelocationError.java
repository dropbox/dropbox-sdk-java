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
@JsonSerialize(using=RelocationError.Serializer.class)
@JsonDeserialize(using=RelocationError.Deserializer.class)
public final class RelocationError {
    // union RelocationError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link RelocationError}.
     */
    public enum Tag {
        FROM_LOOKUP, // LookupError
        FROM_WRITE, // WriteError
        TO, // WriteError
        /**
         * Shared folders can't be copied.
         */
        CANT_COPY_SHARED_FOLDER,
        /**
         * Your move operation would result in nested shared folders.  This is
         * not allowed.
         */
        CANT_NEST_SHARED_FOLDER,
        /**
         * You cannot move a folder into itself.
         */
        CANT_MOVE_FOLDER_INTO_ITSELF,
        /**
         * The operation would involve more than 10,000 files and folders.
         */
        TOO_MANY_FILES,
        /**
         * An unspecified error.
         */
        OTHER; // *catch_all
    }

    /**
     * Shared folders can't be copied.
     */
    public static final RelocationError CANT_COPY_SHARED_FOLDER = new RelocationError(Tag.CANT_COPY_SHARED_FOLDER, null, null, null);
    /**
     * Your move operation would result in nested shared folders.  This is not
     * allowed.
     */
    public static final RelocationError CANT_NEST_SHARED_FOLDER = new RelocationError(Tag.CANT_NEST_SHARED_FOLDER, null, null, null);
    /**
     * You cannot move a folder into itself.
     */
    public static final RelocationError CANT_MOVE_FOLDER_INTO_ITSELF = new RelocationError(Tag.CANT_MOVE_FOLDER_INTO_ITSELF, null, null, null);
    /**
     * The operation would involve more than 10,000 files and folders.
     */
    public static final RelocationError TOO_MANY_FILES = new RelocationError(Tag.TOO_MANY_FILES, null, null, null);
    /**
     * An unspecified error.
     */
    public static final RelocationError OTHER = new RelocationError(Tag.OTHER, null, null, null);

    private final Tag tag;
    private final LookupError fromLookupValue;
    private final WriteError fromWriteValue;
    private final WriteError toValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private RelocationError(Tag tag, LookupError fromLookupValue, WriteError fromWriteValue, WriteError toValue) {
        this.tag = tag;
        this.fromLookupValue = fromLookupValue;
        this.fromWriteValue = fromWriteValue;
        this.toValue = toValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code RelocationError}. </p>
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
     * Returns {@code true} if this instance has the tag {@link
     * Tag#FROM_LOOKUP}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FROM_LOOKUP}, {@code false} otherwise.
     */
    public boolean isFromLookup() {
        return this.tag == Tag.FROM_LOOKUP;
    }

    /**
     * Returns an instance of {@code RelocationError} that has its tag set to
     * {@link Tag#FROM_LOOKUP}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationError} with its tag set to {@link
     *     Tag#FROM_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationError fromLookup(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationError(Tag.FROM_LOOKUP, value, null, null);
    }

    /**
     * This instance must be tagged as {@link Tag#FROM_LOOKUP}.
     *
     * @return The {@link RelocationError#fromLookup} value associated with this
     *     instance if {@link #isFromLookup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFromLookup} is {@code false}.
     */
    public LookupError getFromLookupValue() {
        if (this.tag != Tag.FROM_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.FROM_LOOKUP, but was Tag." + tag.name());
        }
        return fromLookupValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#FROM_WRITE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FROM_WRITE}, {@code false} otherwise.
     */
    public boolean isFromWrite() {
        return this.tag == Tag.FROM_WRITE;
    }

    /**
     * Returns an instance of {@code RelocationError} that has its tag set to
     * {@link Tag#FROM_WRITE}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationError} with its tag set to {@link
     *     Tag#FROM_WRITE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationError fromWrite(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationError(Tag.FROM_WRITE, null, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#FROM_WRITE}.
     *
     * @return The {@link RelocationError#fromWrite} value associated with this
     *     instance if {@link #isFromWrite} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFromWrite} is {@code false}.
     */
    public WriteError getFromWriteValue() {
        if (this.tag != Tag.FROM_WRITE) {
            throw new IllegalStateException("Invalid tag: required Tag.FROM_WRITE, but was Tag." + tag.name());
        }
        return fromWriteValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#TO}, {@code
     * false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#TO}, {@code
     *     false} otherwise.
     */
    public boolean isTo() {
        return this.tag == Tag.TO;
    }

    /**
     * Returns an instance of {@code RelocationError} that has its tag set to
     * {@link Tag#TO}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationError} with its tag set to {@link
     *     Tag#TO}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationError to(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationError(Tag.TO, null, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#TO}.
     *
     * @return The {@link RelocationError#to} value associated with this
     *     instance if {@link #isTo} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTo} is {@code false}.
     */
    public WriteError getToValue() {
        if (this.tag != Tag.TO) {
            throw new IllegalStateException("Invalid tag: required Tag.TO, but was Tag." + tag.name());
        }
        return toValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_COPY_SHARED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANT_COPY_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isCantCopySharedFolder() {
        return this.tag == Tag.CANT_COPY_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_NEST_SHARED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANT_NEST_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isCantNestSharedFolder() {
        return this.tag == Tag.CANT_NEST_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_MOVE_FOLDER_INTO_ITSELF}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANT_MOVE_FOLDER_INTO_ITSELF}, {@code false} otherwise.
     */
    public boolean isCantMoveFolderIntoItself() {
        return this.tag == Tag.CANT_MOVE_FOLDER_INTO_ITSELF;
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
            fromLookupValue,
            fromWriteValue,
            toValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof RelocationError) {
            RelocationError other = (RelocationError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case FROM_LOOKUP:
                    return (this.fromLookupValue == other.fromLookupValue) || (this.fromLookupValue.equals(other.fromLookupValue));
                case FROM_WRITE:
                    return (this.fromWriteValue == other.fromWriteValue) || (this.fromWriteValue.equals(other.fromWriteValue));
                case TO:
                    return (this.toValue == other.toValue) || (this.toValue.equals(other.toValue));
                case CANT_COPY_SHARED_FOLDER:
                    return true;
                case CANT_NEST_SHARED_FOLDER:
                    return true;
                case CANT_MOVE_FOLDER_INTO_ITSELF:
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

    static final class Serializer extends UnionJsonSerializer<RelocationError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RelocationError.class);
        }

        @Override
        public void serialize(RelocationError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case FROM_LOOKUP:
                    g.writeStartObject();
                    g.writeStringField(".tag", "from_lookup");
                    g.writeObjectField("from_lookup", value.fromLookupValue);
                    g.writeEndObject();
                    break;
                case FROM_WRITE:
                    g.writeStartObject();
                    g.writeStringField(".tag", "from_write");
                    g.writeObjectField("from_write", value.fromWriteValue);
                    g.writeEndObject();
                    break;
                case TO:
                    g.writeStartObject();
                    g.writeStringField(".tag", "to");
                    g.writeObjectField("to", value.toValue);
                    g.writeEndObject();
                    break;
                case CANT_COPY_SHARED_FOLDER:
                    g.writeString("cant_copy_shared_folder");
                    break;
                case CANT_NEST_SHARED_FOLDER:
                    g.writeString("cant_nest_shared_folder");
                    break;
                case CANT_MOVE_FOLDER_INTO_ITSELF:
                    g.writeString("cant_move_folder_into_itself");
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

    static final class Deserializer extends UnionJsonDeserializer<RelocationError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RelocationError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public RelocationError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case FROM_LOOKUP: {
                    LookupError value = null;
                    expectField(_p, "from_lookup");
                    value = _p.readValueAs(LookupError.class);
                    _p.nextToken();
                    return RelocationError.fromLookup(value);
                }
                case FROM_WRITE: {
                    WriteError value = null;
                    expectField(_p, "from_write");
                    value = _p.readValueAs(WriteError.class);
                    _p.nextToken();
                    return RelocationError.fromWrite(value);
                }
                case TO: {
                    WriteError value = null;
                    expectField(_p, "to");
                    value = _p.readValueAs(WriteError.class);
                    _p.nextToken();
                    return RelocationError.to(value);
                }
                case CANT_COPY_SHARED_FOLDER: {
                    return RelocationError.CANT_COPY_SHARED_FOLDER;
                }
                case CANT_NEST_SHARED_FOLDER: {
                    return RelocationError.CANT_NEST_SHARED_FOLDER;
                }
                case CANT_MOVE_FOLDER_INTO_ITSELF: {
                    return RelocationError.CANT_MOVE_FOLDER_INTO_ITSELF;
                }
                case TOO_MANY_FILES: {
                    return RelocationError.TOO_MANY_FILES;
                }
                case OTHER: {
                    return RelocationError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, RelocationError.Tag> getTagMapping() {
            Map<String, RelocationError.Tag> values = new HashMap<String, RelocationError.Tag>();
            values.put("from_lookup", RelocationError.Tag.FROM_LOOKUP);
            values.put("from_write", RelocationError.Tag.FROM_WRITE);
            values.put("to", RelocationError.Tag.TO);
            values.put("cant_copy_shared_folder", RelocationError.Tag.CANT_COPY_SHARED_FOLDER);
            values.put("cant_nest_shared_folder", RelocationError.Tag.CANT_NEST_SHARED_FOLDER);
            values.put("cant_move_folder_into_itself", RelocationError.Tag.CANT_MOVE_FOLDER_INTO_ITSELF);
            values.put("too_many_files", RelocationError.Tag.TOO_MANY_FILES);
            values.put("other", RelocationError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
