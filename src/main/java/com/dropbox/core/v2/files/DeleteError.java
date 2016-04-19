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
@JsonSerialize(using=DeleteError.Serializer.class)
@JsonDeserialize(using=DeleteError.Deserializer.class)
public final class DeleteError {
    // union DeleteError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link DeleteError}.
     */
    public enum Tag {
        PATH_LOOKUP, // LookupError
        PATH_WRITE, // WriteError
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
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final DeleteError OTHER = new DeleteError(Tag.OTHER, null, null);

    private final Tag tag;
    private final LookupError pathLookupValue;
    private final WriteError pathWriteValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private DeleteError(Tag tag, LookupError pathLookupValue, WriteError pathWriteValue) {
        this.tag = tag;
        this.pathLookupValue = pathLookupValue;
        this.pathWriteValue = pathWriteValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code DeleteError}. </p>
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
     * Tag#PATH_LOOKUP}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PATH_LOOKUP}, {@code false} otherwise.
     */
    public boolean isPathLookup() {
        return this.tag == Tag.PATH_LOOKUP;
    }

    /**
     * Returns an instance of {@code DeleteError} that has its tag set to {@link
     * Tag#PATH_LOOKUP}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code DeleteError} with its tag set to {@link
     *     Tag#PATH_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static DeleteError pathLookup(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteError(Tag.PATH_LOOKUP, value, null);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH_LOOKUP}.
     *
     * @return The {@link DeleteError#pathLookup} value associated with this
     *     instance if {@link #isPathLookup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPathLookup} is {@code false}.
     */
    public LookupError getPathLookupValue() {
        if (this.tag != Tag.PATH_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_LOOKUP, but was Tag." + tag.name());
        }
        return pathLookupValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#PATH_WRITE},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PATH_WRITE}, {@code false} otherwise.
     */
    public boolean isPathWrite() {
        return this.tag == Tag.PATH_WRITE;
    }

    /**
     * Returns an instance of {@code DeleteError} that has its tag set to {@link
     * Tag#PATH_WRITE}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code DeleteError} with its tag set to {@link
     *     Tag#PATH_WRITE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static DeleteError pathWrite(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new DeleteError(Tag.PATH_WRITE, null, value);
    }

    /**
     * This instance must be tagged as {@link Tag#PATH_WRITE}.
     *
     * @return The {@link DeleteError#pathWrite} value associated with this
     *     instance if {@link #isPathWrite} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPathWrite} is {@code false}.
     */
    public WriteError getPathWriteValue() {
        if (this.tag != Tag.PATH_WRITE) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_WRITE, but was Tag." + tag.name());
        }
        return pathWriteValue;
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
            pathLookupValue,
            pathWriteValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof DeleteError) {
            DeleteError other = (DeleteError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH_LOOKUP:
                    return (this.pathLookupValue == other.pathLookupValue) || (this.pathLookupValue.equals(other.pathLookupValue));
                case PATH_WRITE:
                    return (this.pathWriteValue == other.pathWriteValue) || (this.pathWriteValue.equals(other.pathWriteValue));
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

    static final class Serializer extends UnionJsonSerializer<DeleteError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(DeleteError.class);
        }

        @Override
        public void serialize(DeleteError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case PATH_LOOKUP:
                    g.writeStartObject();
                    g.writeStringField(".tag", "path_lookup");
                    g.writeObjectField("path_lookup", value.pathLookupValue);
                    g.writeEndObject();
                    break;
                case PATH_WRITE:
                    g.writeStartObject();
                    g.writeStringField(".tag", "path_write");
                    g.writeObjectField("path_write", value.pathWriteValue);
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<DeleteError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(DeleteError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public DeleteError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case PATH_LOOKUP: {
                    LookupError value = null;
                    expectField(_p, "path_lookup");
                    value = _p.readValueAs(LookupError.class);
                    _p.nextToken();
                    return DeleteError.pathLookup(value);
                }
                case PATH_WRITE: {
                    WriteError value = null;
                    expectField(_p, "path_write");
                    value = _p.readValueAs(WriteError.class);
                    _p.nextToken();
                    return DeleteError.pathWrite(value);
                }
                case OTHER: {
                    return DeleteError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, DeleteError.Tag> getTagMapping() {
            Map<String, DeleteError.Tag> values = new HashMap<String, DeleteError.Tag>();
            values.put("path_lookup", DeleteError.Tag.PATH_LOOKUP);
            values.put("path_write", DeleteError.Tag.PATH_WRITE);
            values.put("other", DeleteError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
