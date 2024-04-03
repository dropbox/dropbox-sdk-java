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
public final class LockFileError {
    // union files.LockFileError (files.stone)

    /**
     * Discriminating tag type for {@link LockFileError}.
     */
    public enum Tag {
        /**
         * Could not find the specified resource.
         */
        PATH_LOOKUP, // LookupError
        /**
         * There are too many write operations in user's Dropbox. Please retry
         * this request.
         */
        TOO_MANY_WRITE_OPERATIONS,
        /**
         * There are too many files in one request. Please retry with fewer
         * files.
         */
        TOO_MANY_FILES,
        /**
         * The user does not have permissions to change the lock state or access
         * the file.
         */
        NO_WRITE_PERMISSION,
        /**
         * Item is a type that cannot be locked.
         */
        CANNOT_BE_LOCKED,
        /**
         * Requested file is not currently shared.
         */
        FILE_NOT_SHARED,
        /**
         * The user action conflicts with an existing lock on the file.
         */
        LOCK_CONFLICT, // LockConflictError
        /**
         * Something went wrong with the job on Dropbox's end. You'll need to
         * verify that the action you were taking succeeded, and if not, try
         * again. This should happen very rarely.
         */
        INTERNAL_ERROR,
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
     * There are too many write operations in user's Dropbox. Please retry this
     * request.
     */
    public static final LockFileError TOO_MANY_WRITE_OPERATIONS = new LockFileError().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);
    /**
     * There are too many files in one request. Please retry with fewer files.
     */
    public static final LockFileError TOO_MANY_FILES = new LockFileError().withTag(Tag.TOO_MANY_FILES);
    /**
     * The user does not have permissions to change the lock state or access the
     * file.
     */
    public static final LockFileError NO_WRITE_PERMISSION = new LockFileError().withTag(Tag.NO_WRITE_PERMISSION);
    /**
     * Item is a type that cannot be locked.
     */
    public static final LockFileError CANNOT_BE_LOCKED = new LockFileError().withTag(Tag.CANNOT_BE_LOCKED);
    /**
     * Requested file is not currently shared.
     */
    public static final LockFileError FILE_NOT_SHARED = new LockFileError().withTag(Tag.FILE_NOT_SHARED);
    /**
     * Something went wrong with the job on Dropbox's end. You'll need to verify
     * that the action you were taking succeeded, and if not, try again. This
     * should happen very rarely.
     */
    public static final LockFileError INTERNAL_ERROR = new LockFileError().withTag(Tag.INTERNAL_ERROR);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final LockFileError OTHER = new LockFileError().withTag(Tag.OTHER);

    private Tag _tag;
    private LookupError pathLookupValue;
    private LockConflictError lockConflictValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private LockFileError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private LockFileError withTag(Tag _tag) {
        LockFileError result = new LockFileError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param pathLookupValue  Could not find the specified resource. Must not
     *     be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private LockFileError withTagAndPathLookup(Tag _tag, LookupError pathLookupValue) {
        LockFileError result = new LockFileError();
        result._tag = _tag;
        result.pathLookupValue = pathLookupValue;
        return result;
    }

    /**
     *
     * @param lockConflictValue  The user action conflicts with an existing lock
     *     on the file. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private LockFileError withTagAndLockConflict(Tag _tag, LockConflictError lockConflictValue) {
        LockFileError result = new LockFileError();
        result._tag = _tag;
        result.lockConflictValue = lockConflictValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code LockFileError}. </p>
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
     * Tag#PATH_LOOKUP}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#PATH_LOOKUP}, {@code false} otherwise.
     */
    public boolean isPathLookup() {
        return this._tag == Tag.PATH_LOOKUP;
    }

    /**
     * Returns an instance of {@code LockFileError} that has its tag set to
     * {@link Tag#PATH_LOOKUP}.
     *
     * <p> Could not find the specified resource. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LockFileError} with its tag set to {@link
     *     Tag#PATH_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static LockFileError pathLookup(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LockFileError().withTagAndPathLookup(Tag.PATH_LOOKUP, value);
    }

    /**
     * Could not find the specified resource.
     *
     * <p> This instance must be tagged as {@link Tag#PATH_LOOKUP}. </p>
     *
     * @return The {@link LookupError} value associated with this instance if
     *     {@link #isPathLookup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isPathLookup} is {@code false}.
     */
    public LookupError getPathLookupValue() {
        if (this._tag != Tag.PATH_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.PATH_LOOKUP, but was Tag." + this._tag.name());
        }
        return pathLookupValue;
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
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TOO_MANY_FILES}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TOO_MANY_FILES}, {@code false} otherwise.
     */
    public boolean isTooManyFiles() {
        return this._tag == Tag.TOO_MANY_FILES;
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
     * Tag#CANNOT_BE_LOCKED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANNOT_BE_LOCKED}, {@code false} otherwise.
     */
    public boolean isCannotBeLocked() {
        return this._tag == Tag.CANNOT_BE_LOCKED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#FILE_NOT_SHARED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FILE_NOT_SHARED}, {@code false} otherwise.
     */
    public boolean isFileNotShared() {
        return this._tag == Tag.FILE_NOT_SHARED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#LOCK_CONFLICT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#LOCK_CONFLICT}, {@code false} otherwise.
     */
    public boolean isLockConflict() {
        return this._tag == Tag.LOCK_CONFLICT;
    }

    /**
     * Returns an instance of {@code LockFileError} that has its tag set to
     * {@link Tag#LOCK_CONFLICT}.
     *
     * <p> The user action conflicts with an existing lock on the file. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code LockFileError} with its tag set to {@link
     *     Tag#LOCK_CONFLICT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static LockFileError lockConflict(LockConflictError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new LockFileError().withTagAndLockConflict(Tag.LOCK_CONFLICT, value);
    }

    /**
     * The user action conflicts with an existing lock on the file.
     *
     * <p> This instance must be tagged as {@link Tag#LOCK_CONFLICT}. </p>
     *
     * @return The {@link LockConflictError} value associated with this instance
     *     if {@link #isLockConflict} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isLockConflict} is {@code
     *     false}.
     */
    public LockConflictError getLockConflictValue() {
        if (this._tag != Tag.LOCK_CONFLICT) {
            throw new IllegalStateException("Invalid tag: required Tag.LOCK_CONFLICT, but was Tag." + this._tag.name());
        }
        return lockConflictValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INTERNAL_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INTERNAL_ERROR}, {@code false} otherwise.
     */
    public boolean isInternalError() {
        return this._tag == Tag.INTERNAL_ERROR;
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
            this._tag,
            this.pathLookupValue,
            this.lockConflictValue
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
        else if (obj instanceof LockFileError) {
            LockFileError other = (LockFileError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case PATH_LOOKUP:
                    return (this.pathLookupValue == other.pathLookupValue) || (this.pathLookupValue.equals(other.pathLookupValue));
                case TOO_MANY_WRITE_OPERATIONS:
                    return true;
                case TOO_MANY_FILES:
                    return true;
                case NO_WRITE_PERMISSION:
                    return true;
                case CANNOT_BE_LOCKED:
                    return true;
                case FILE_NOT_SHARED:
                    return true;
                case LOCK_CONFLICT:
                    return (this.lockConflictValue == other.lockConflictValue) || (this.lockConflictValue.equals(other.lockConflictValue));
                case INTERNAL_ERROR:
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
    static class Serializer extends UnionSerializer<LockFileError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(LockFileError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case PATH_LOOKUP: {
                    g.writeStartObject();
                    writeTag("path_lookup", g);
                    g.writeFieldName("path_lookup");
                    LookupError.Serializer.INSTANCE.serialize(value.pathLookupValue, g);
                    g.writeEndObject();
                    break;
                }
                case TOO_MANY_WRITE_OPERATIONS: {
                    g.writeString("too_many_write_operations");
                    break;
                }
                case TOO_MANY_FILES: {
                    g.writeString("too_many_files");
                    break;
                }
                case NO_WRITE_PERMISSION: {
                    g.writeString("no_write_permission");
                    break;
                }
                case CANNOT_BE_LOCKED: {
                    g.writeString("cannot_be_locked");
                    break;
                }
                case FILE_NOT_SHARED: {
                    g.writeString("file_not_shared");
                    break;
                }
                case LOCK_CONFLICT: {
                    g.writeStartObject();
                    writeTag("lock_conflict", g);
                    LockConflictError.Serializer.INSTANCE.serialize(value.lockConflictValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case INTERNAL_ERROR: {
                    g.writeString("internal_error");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public LockFileError deserialize(JsonParser p) throws IOException, JsonParseException {
            LockFileError value;
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
            else if ("path_lookup".equals(tag)) {
                LookupError fieldValue = null;
                expectField("path_lookup", p);
                fieldValue = LookupError.Serializer.INSTANCE.deserialize(p);
                value = LockFileError.pathLookup(fieldValue);
            }
            else if ("too_many_write_operations".equals(tag)) {
                value = LockFileError.TOO_MANY_WRITE_OPERATIONS;
            }
            else if ("too_many_files".equals(tag)) {
                value = LockFileError.TOO_MANY_FILES;
            }
            else if ("no_write_permission".equals(tag)) {
                value = LockFileError.NO_WRITE_PERMISSION;
            }
            else if ("cannot_be_locked".equals(tag)) {
                value = LockFileError.CANNOT_BE_LOCKED;
            }
            else if ("file_not_shared".equals(tag)) {
                value = LockFileError.FILE_NOT_SHARED;
            }
            else if ("lock_conflict".equals(tag)) {
                LockConflictError fieldValue = null;
                fieldValue = LockConflictError.Serializer.INSTANCE.deserialize(p, true);
                value = LockFileError.lockConflict(fieldValue);
            }
            else if ("internal_error".equals(tag)) {
                value = LockFileError.INTERNAL_ERROR;
            }
            else {
                value = LockFileError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
