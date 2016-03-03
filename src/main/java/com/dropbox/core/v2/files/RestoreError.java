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
@JsonSerialize(using=RestoreError.Serializer.class)
@JsonDeserialize(using=RestoreError.Deserializer.class)
public final class RestoreError {
    // union RestoreError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link RestoreError}.
     */
    public enum Tag {
        /**
         * An error occurs when downloading metadata for the file.
         */
        PATH_LOOKUP, // LookupError
        /**
         * An error occurs when trying to restore the file to that path.
         */
        PATH_WRITE, // WriteError
        /**
         * The revision is invalid. It may point to a different file.
         */
        INVALID_REVISION,
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
     * The revision is invalid. It may point to a different file.
     */
    public static final RestoreError INVALID_REVISION = new RestoreError(Tag.INVALID_REVISION, null, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final RestoreError OTHER = new RestoreError(Tag.OTHER, null, null);

    private final Tag tag;
    private final LookupError pathLookupValue;
    private final WriteError pathWriteValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private RestoreError(Tag tag, LookupError pathLookupValue, WriteError pathWriteValue) {
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
     * values for this {@code RestoreError}. </p>
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
     * Returns an instance of {@code RestoreError} that has its tag set to
     * {@link Tag#PATH_LOOKUP}.
     *
     * <p> An error occurs when downloading metadata for the file. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RestoreError} with its tag set to {@link
     *     Tag#PATH_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RestoreError pathLookup(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RestoreError(Tag.PATH_LOOKUP, value, null);
    }

    /**
     * An error occurs when downloading metadata for the file.
     *
     * <p> This instance must be tagged as {@link Tag#PATH_LOOKUP}. </p>
     *
     * @return The {@link RestoreError#pathLookup} value associated with this
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
     * Returns an instance of {@code RestoreError} that has its tag set to
     * {@link Tag#PATH_WRITE}.
     *
     * <p> An error occurs when trying to restore the file to that path. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RestoreError} with its tag set to {@link
     *     Tag#PATH_WRITE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RestoreError pathWrite(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RestoreError(Tag.PATH_WRITE, null, value);
    }

    /**
     * An error occurs when trying to restore the file to that path.
     *
     * <p> This instance must be tagged as {@link Tag#PATH_WRITE}. </p>
     *
     * @return The {@link RestoreError#pathWrite} value associated with this
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
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INVALID_REVISION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_REVISION}, {@code false} otherwise.
     */
    public boolean isInvalidRevision() {
        return this.tag == Tag.INVALID_REVISION;
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
        else if (obj instanceof RestoreError) {
            RestoreError other = (RestoreError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case PATH_LOOKUP:
                    return (this.pathLookupValue == other.pathLookupValue) || (this.pathLookupValue.equals(other.pathLookupValue));
                case PATH_WRITE:
                    return (this.pathWriteValue == other.pathWriteValue) || (this.pathWriteValue.equals(other.pathWriteValue));
                case INVALID_REVISION:
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

    static final class Serializer extends UnionJsonSerializer<RestoreError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RestoreError.class);
        }

        @Override
        public void serialize(RestoreError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
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
                case INVALID_REVISION:
                    g.writeString("invalid_revision");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<RestoreError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RestoreError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public RestoreError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case PATH_LOOKUP: {
                    LookupError value = null;
                    expectField(_p, "path_lookup");
                    value = _p.readValueAs(LookupError.class);
                    _p.nextToken();
                    return RestoreError.pathLookup(value);
                }
                case PATH_WRITE: {
                    WriteError value = null;
                    expectField(_p, "path_write");
                    value = _p.readValueAs(WriteError.class);
                    _p.nextToken();
                    return RestoreError.pathWrite(value);
                }
                case INVALID_REVISION: {
                    return RestoreError.INVALID_REVISION;
                }
                case OTHER: {
                    return RestoreError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, RestoreError.Tag> getTagMapping() {
            Map<String, RestoreError.Tag> values = new HashMap<String, RestoreError.Tag>();
            values.put("path_lookup", RestoreError.Tag.PATH_LOOKUP);
            values.put("path_write", RestoreError.Tag.PATH_WRITE);
            values.put("invalid_revision", RestoreError.Tag.INVALID_REVISION);
            values.put("other", RestoreError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
