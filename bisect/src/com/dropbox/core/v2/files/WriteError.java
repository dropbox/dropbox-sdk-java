/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.UnionSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;

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
    // union files.WriteError (files.stone)

    /**
     * Discriminating tag type for {@link WriteError}.
     */
    public enum Tag {
        /**
         * The given path does not satisfy the required path format. Please
         * refer to the <a
         * href="https://www.dropbox.com/developers/documentation/http/documentation#path-formats">Path
         * formats documentation</a> for more information.
         */
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
         * This endpoint cannot move or delete team folders.
         */
        TEAM_FOLDER,
        /**
         * There are too many write operations in user's Dropbox. Please retry
         * this request.
         */
        TOO_MANY_WRITE_OPERATIONS,
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
    public static final WriteError NO_WRITE_PERMISSION = new WriteError().withTag(Tag.NO_WRITE_PERMISSION);
    /**
     * The user doesn't have enough available space (bytes) to write more data.
     */
    public static final WriteError INSUFFICIENT_SPACE = new WriteError().withTag(Tag.INSUFFICIENT_SPACE);
    /**
     * Dropbox will not save the file or folder because of its name.
     */
    public static final WriteError DISALLOWED_NAME = new WriteError().withTag(Tag.DISALLOWED_NAME);
    /**
     * This endpoint cannot move or delete team folders.
     */
    public static final WriteError TEAM_FOLDER = new WriteError().withTag(Tag.TEAM_FOLDER);
    /**
     * There are too many write operations in user's Dropbox. Please retry this
     * request.
     */
    public static final WriteError TOO_MANY_WRITE_OPERATIONS = new WriteError().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final WriteError OTHER = new WriteError().withTag(Tag.OTHER);

    private Tag _tag;
    private String malformedPathValue;
    private WriteConflictError conflictValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private WriteError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private WriteError withTag(Tag _tag) {
        WriteError result = new WriteError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param malformedPathValue  The given path does not satisfy the required
     *     path format. Please refer to the <a
     *     href="https://www.dropbox.com/developers/documentation/http/documentation#path-formats">Path
     *     formats documentation</a> for more information.
     * @param _tag  Discriminating tag for this instance.
     */
    private WriteError withTagAndMalformedPath(Tag _tag, String malformedPathValue) {
        WriteError result = new WriteError();
        result._tag = _tag;
        result.malformedPathValue = malformedPathValue;
        return result;
    }

    /**
     *
     * @param conflictValue  Couldn't write to the target path because there was
     *     something in the way. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private WriteError withTagAndConflict(Tag _tag, WriteConflictError conflictValue) {
        WriteError result = new WriteError();
        result._tag = _tag;
        result.conflictValue = conflictValue;
        return result;
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
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#MALFORMED_PATH}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#MALFORMED_PATH}, {@code false} otherwise.
     */
    public boolean isMalformedPath() {
        return this._tag == Tag.MALFORMED_PATH;
    }

    /**
     * Returns an instance of {@code WriteError} that has its tag set to {@link
     * Tag#MALFORMED_PATH}.
     *
     * <p> The given path does not satisfy the required path format. Please
     * refer to the <a
     * href="https://www.dropbox.com/developers/documentation/http/documentation#path-formats">Path
     * formats documentation</a> for more information. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code WriteError} with its tag set to {@link
     *     Tag#MALFORMED_PATH}.
     */
    public static WriteError malformedPath(String value) {
        return new WriteError().withTagAndMalformedPath(Tag.MALFORMED_PATH, value);
    }

    /**
     * Returns an instance of {@code WriteError} that has its tag set to {@link
     * Tag#MALFORMED_PATH}.
     *
     * <p> The given path does not satisfy the required path format. Please
     * refer to the <a
     * href="https://www.dropbox.com/developers/documentation/http/documentation#path-formats">Path
     * formats documentation</a> for more information. </p>
     *
     * @return Instance of {@code WriteError} with its tag set to {@link
     *     Tag#MALFORMED_PATH}.
     */
    public static WriteError malformedPath() {
        return malformedPath(null);
    }

    /**
     * The given path does not satisfy the required path format. Please refer to
     * the <a
     * href="https://www.dropbox.com/developers/documentation/http/documentation#path-formats">Path
     * formats documentation</a> for more information.
     *
     * <p> This instance must be tagged as {@link Tag#MALFORMED_PATH}. </p>
     *
     * @return The {@link String} value associated with this instance if {@link
     *     #isMalformedPath} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isMalformedPath} is {@code
     *     false}.
     */
    public String getMalformedPathValue() {
        if (this._tag != Tag.MALFORMED_PATH) {
            throw new IllegalStateException("Invalid tag: required Tag.MALFORMED_PATH, but was Tag." + this._tag.name());
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
        return this._tag == Tag.CONFLICT;
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
        return new WriteError().withTagAndConflict(Tag.CONFLICT, value);
    }

    /**
     * Couldn't write to the target path because there was something in the way.
     *
     * <p> This instance must be tagged as {@link Tag#CONFLICT}. </p>
     *
     * @return The {@link WriteConflictError} value associated with this
     *     instance if {@link #isConflict} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isConflict} is {@code false}.
     */
    public WriteConflictError getConflictValue() {
        if (this._tag != Tag.CONFLICT) {
            throw new IllegalStateException("Invalid tag: required Tag.CONFLICT, but was Tag." + this._tag.name());
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
        return this._tag == Tag.NO_WRITE_PERMISSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_SPACE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSUFFICIENT_SPACE}, {@code false} otherwise.
     */
    public boolean isInsufficientSpace() {
        return this._tag == Tag.INSUFFICIENT_SPACE;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#DISALLOWED_NAME}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DISALLOWED_NAME}, {@code false} otherwise.
     */
    public boolean isDisallowedName() {
        return this._tag == Tag.DISALLOWED_NAME;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_FOLDER}, {@code false} otherwise.
     */
    public boolean isTeamFolder() {
        return this._tag == Tag.TEAM_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_WRITE_OPERATIONS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_WRITE_OPERATIONS}, {@code false} otherwise.
     */
    public boolean isTooManyWriteOperations() {
        return this._tag == Tag.TOO_MANY_WRITE_OPERATIONS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#OTHER},
     *     {@code false} otherwise.
     */
    public boolean isOther() {
        return this._tag == Tag.OTHER;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            _tag,
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
        if (obj == null) {
            return false;
        }
        else if (obj instanceof WriteError) {
            WriteError other = (WriteError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
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
                case TEAM_FOLDER:
                    return true;
                case TOO_MANY_WRITE_OPERATIONS:
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
    static class Serializer extends UnionSerializer<WriteError> {
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
                case TEAM_FOLDER: {
                    g.writeString("team_folder");
                    break;
                }
                case TOO_MANY_WRITE_OPERATIONS: {
                    g.writeString("too_many_write_operations");
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
            else if ("team_folder".equals(tag)) {
                value = WriteError.TEAM_FOLDER;
            }
            else if ("too_many_write_operations".equals(tag)) {
                value = WriteError.TOO_MANY_WRITE_OPERATIONS;
            }
            else {
                value = WriteError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
