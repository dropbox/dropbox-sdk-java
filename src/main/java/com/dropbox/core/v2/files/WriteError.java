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
@JsonSerialize(using=WriteError.Serializer.class)
@JsonDeserialize(using=WriteError.Deserializer.class)
public final class WriteError {
    // union WriteError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link WriteError}.
     */
    public enum Tag {
        MALFORMED_PATH, // String
        /**
         * Couldn't write to the target path because there was something in the
         * way.
         */
        CONFLICT, // WriteConflictError
        /**
         * The user doesn't have permissions to write to the target location.
         */
        NO_WRITE_PERMISSION,
        /**
         * The user doesn't have enough available space (bytes) to write more
         * data.
         */
        INSUFFICIENT_SPACE,
        /**
         * Dropbox will not save the file or folder because of its name.
         */
        DISALLOWED_NAME,
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
     * The user doesn't have permissions to write to the target location.
     */
    public static final WriteError NO_WRITE_PERMISSION = new WriteError(Tag.NO_WRITE_PERMISSION, null, null);
    /**
     * The user doesn't have enough available space (bytes) to write more data.
     */
    public static final WriteError INSUFFICIENT_SPACE = new WriteError(Tag.INSUFFICIENT_SPACE, null, null);
    /**
     * Dropbox will not save the file or folder because of its name.
     */
    public static final WriteError DISALLOWED_NAME = new WriteError(Tag.DISALLOWED_NAME, null, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final WriteError OTHER = new WriteError(Tag.OTHER, null, null);

    private final Tag tag;
    private final String malformedPathValue;
    private final WriteConflictError conflictValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private WriteError(Tag tag, String malformedPathValue, WriteConflictError conflictValue) {
        this.tag = tag;
        this.malformedPathValue = malformedPathValue;
        this.conflictValue = conflictValue;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code WriteError}. </p>
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
     * Tag#MALFORMED_PATH}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MALFORMED_PATH}, {@code false} otherwise.
     */
    public boolean isMalformedPath() {
        return this.tag == Tag.MALFORMED_PATH;
    }

    /**
     * Returns an instance of {@code WriteError} that has its tag set to {@link
     * Tag#MALFORMED_PATH}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code WriteError} with its tag set to {@link
     *     Tag#MALFORMED_PATH}.
     */
    public static WriteError malformedPath(String value) {
        return new WriteError(Tag.MALFORMED_PATH, value, null);
    }

    /**
     * Returns an instance of {@code WriteError} that has its tag set to {@link
     * Tag#MALFORMED_PATH}.
     *
     * @return Instance of {@code WriteError} with its tag set to {@link
     *     Tag#MALFORMED_PATH}.
     */
    public static WriteError malformedPath() {
        return malformedPath(null);
    }

    /**
     * This instance must be tagged as {@link Tag#MALFORMED_PATH}.
     *
     * @return The {@link WriteError#malformedPath} value associated with this
     *     instance if {@link #isMalformedPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMalformedPath} is {@code
     *     false}.
     */
    public String getMalformedPathValue() {
        if (this.tag != Tag.MALFORMED_PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.MALFORMED_PATH, but was Tag." + tag.name());
        }
        return malformedPathValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#CONFLICT},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#CONFLICT},
     *     {@code false} otherwise.
     */
    public boolean isConflict() {
        return this.tag == Tag.CONFLICT;
    }

    /**
     * Returns an instance of {@code WriteError} that has its tag set to {@link
     * Tag#CONFLICT}.
     *
     * <p> Couldn't write to the target path because there was something in the
     * way. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code WriteError} with its tag set to {@link
     *     Tag#CONFLICT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static WriteError conflict(WriteConflictError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new WriteError(Tag.CONFLICT, null, value);
    }

    /**
     * Couldn't write to the target path because there was something in the way.
     *
     * <p> This instance must be tagged as {@link Tag#CONFLICT}. </p>
     *
     * @return The {@link WriteError#conflict} value associated with this
     *     instance if {@link #isConflict} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isConflict} is {@code false}.
     */
    public WriteConflictError getConflictValue() {
        if (this.tag != Tag.CONFLICT) {
            throw new IllegalStateException("Invalid tag: required Tag.CONFLICT, but was Tag." + tag.name());
        }
        return conflictValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_WRITE_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_WRITE_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoWritePermission() {
        return this.tag == Tag.NO_WRITE_PERMISSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_SPACE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSUFFICIENT_SPACE}, {@code false} otherwise.
     */
    public boolean isInsufficientSpace() {
        return this.tag == Tag.INSUFFICIENT_SPACE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DISALLOWED_NAME}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DISALLOWED_NAME}, {@code false} otherwise.
     */
    public boolean isDisallowedName() {
        return this.tag == Tag.DISALLOWED_NAME;
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
            malformedPathValue,
            conflictValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof WriteError) {
            WriteError other = (WriteError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case MALFORMED_PATH:
                    return (this.malformedPathValue == other.malformedPathValue) || (this.malformedPathValue != null && this.malformedPathValue.equals(other.malformedPathValue));
                case CONFLICT:
                    return (this.conflictValue == other.conflictValue) || (this.conflictValue.equals(other.conflictValue));
                case NO_WRITE_PERMISSION:
                    return true;
                case INSUFFICIENT_SPACE:
                    return true;
                case DISALLOWED_NAME:
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

    static final class Serializer extends UnionJsonSerializer<WriteError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(WriteError.class);
        }

        @Override
        public void serialize(WriteError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case MALFORMED_PATH:
                    g.writeStartObject();
                    g.writeStringField(".tag", "malformed_path");
                    if (value.malformedPathValue != null) {
                        g.writeObjectField("malformed_path", value.malformedPathValue);
                    }
                    g.writeEndObject();
                    break;
                case CONFLICT:
                    g.writeStartObject();
                    g.writeStringField(".tag", "conflict");
                    g.writeObjectField("conflict", value.conflictValue);
                    g.writeEndObject();
                    break;
                case NO_WRITE_PERMISSION:
                    g.writeString("no_write_permission");
                    break;
                case INSUFFICIENT_SPACE:
                    g.writeString("insufficient_space");
                    break;
                case DISALLOWED_NAME:
                    g.writeString("disallowed_name");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<WriteError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(WriteError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public WriteError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case MALFORMED_PATH: {
                    if (isObjectEnd(_p)) {
                        return WriteError.malformedPath();
                    }
                    String value = null;
                    expectField(_p, "malformed_path");
                    value = getStringValue(_p);
                    _p.nextToken();
                    return WriteError.malformedPath(value);
                }
                case CONFLICT: {
                    WriteConflictError value = null;
                    expectField(_p, "conflict");
                    value = _p.readValueAs(WriteConflictError.class);
                    _p.nextToken();
                    return WriteError.conflict(value);
                }
                case NO_WRITE_PERMISSION: {
                    return WriteError.NO_WRITE_PERMISSION;
                }
                case INSUFFICIENT_SPACE: {
                    return WriteError.INSUFFICIENT_SPACE;
                }
                case DISALLOWED_NAME: {
                    return WriteError.DISALLOWED_NAME;
                }
                case OTHER: {
                    return WriteError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, WriteError.Tag> getTagMapping() {
            Map<String, WriteError.Tag> values = new HashMap<String, WriteError.Tag>();
            values.put("malformed_path", WriteError.Tag.MALFORMED_PATH);
            values.put("conflict", WriteError.Tag.CONFLICT);
            values.put("no_write_permission", WriteError.Tag.NO_WRITE_PERMISSION);
            values.put("insufficient_space", WriteError.Tag.INSUFFICIENT_SPACE);
            values.put("disallowed_name", WriteError.Tag.DISALLOWED_NAME);
            values.put("other", WriteError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
