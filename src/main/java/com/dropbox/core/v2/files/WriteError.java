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
 * This class is an open tagged union.  Tagged unions instances are always
 * associated to a specific tag.  This means only one of the {@code isAbc()}
 * methods will return {@code true}. You can use {@link #tag()} to determine the
 * tag associated with this instance.
 *
 * <p> Open unions may be extended in the future with additional tags. If a new
 * tag is introduced that this SDK does not recognized, the {@link #OTHER} value
 * will be used. </p>
 */
public final class WriteError {
    // union WriteError

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
    static final class Serializer extends UnionSerializer<WriteError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(WriteError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case MALFORMED_PATH: {
                    g.writeStartObject();
                    writeTag("malformed_path", g);
                    g.writeFieldName("malformed_path");
                    StoneSerializers.nullable(StoneSerializers.string()).serialize(value.malformedPathValue, g);
                    g.writeEndObject();
                    break;
                }
                case CONFLICT: {
                    g.writeStartObject();
                    writeTag("conflict", g);
                    g.writeFieldName("conflict");
                    WriteConflictError.Serializer.INSTANCE.serialize(value.conflictValue, g);
                    g.writeEndObject();
                    break;
                }
                case NO_WRITE_PERMISSION: {
                    g.writeString("no_write_permission");
                    break;
                }
                case INSUFFICIENT_SPACE: {
                    g.writeString("insufficient_space");
                    break;
                }
                case DISALLOWED_NAME: {
                    g.writeString("disallowed_name");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public WriteError deserialize(JsonParser p) throws IOException, JsonParseException {
            WriteError value;
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
            else if ("malformed_path".equals(tag)) {
                String fieldValue = null;
                if (p.getCurrentToken() != JsonToken.END_OBJECT) {
                    expectField("malformed_path", p);
                    fieldValue = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                }
                if (fieldValue == null) {
                    value = WriteError.malformedPath();
                }
                else {
                    value = WriteError.malformedPath(fieldValue);
                }
            }
            else if ("conflict".equals(tag)) {
                WriteConflictError fieldValue = null;
                expectField("conflict", p);
                fieldValue = WriteConflictError.Serializer.INSTANCE.deserialize(p);
                value = WriteError.conflict(fieldValue);
            }
            else if ("no_write_permission".equals(tag)) {
                value = WriteError.NO_WRITE_PERMISSION;
            }
            else if ("insufficient_space".equals(tag)) {
                value = WriteError.INSUFFICIENT_SPACE;
            }
            else if ("disallowed_name".equals(tag)) {
                value = WriteError.DISALLOWED_NAME;
            }
            else {
                value = WriteError.OTHER;
                skipFields(p);
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
