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
 * This class is a tagged union.  Tagged unions instances are always associated
 * to a specific tag.  This means only one of the {@code isAbc()} methods will
 * return {@code true}. You can use {@link #tag()} to determine the tag
 * associated with this instance.
 */
public final class RelocationBatchError {
    // union files.RelocationBatchError (files.stone)

    /**
     * Discriminating tag type for {@link RelocationBatchError}.
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
         * There are duplicated/nested paths among {@link
         * RelocationArg#getFromPath} and {@link RelocationArg#getToPath}.
         */
        DUPLICATED_OR_NESTED_PATHS,
        /**
         * Your move operation would result in an ownership transfer. You may
         * reissue the request with the field {@link
         * RelocationArg#getAllowOwnershipTransfer} to true.
         */
        CANT_TRANSFER_OWNERSHIP,
        /**
         * The current user does not have enough space to move or copy the
         * files.
         */
        INSUFFICIENT_QUOTA,
        /**
         * Something went wrong with the job on Dropbox's end. You'll need to
         * verify that the action you were taking succeeded, and if not, try
         * again. This should happen very rarely.
         */
        INTERNAL_ERROR,
        /**
         * Can't move the shared folder to the given destination.
         */
        CANT_MOVE_SHARED_FOLDER,
        /**
         * Some content cannot be moved into Vault under certain circumstances,
         * see detailed error.
         */
        CANT_MOVE_INTO_VAULT, // MoveIntoVaultError
        /**
         * Some content cannot be moved into the Family Room folder under
         * certain circumstances, see detailed error.
         */
        CANT_MOVE_INTO_FAMILY, // MoveIntoFamilyError
        /**
         * Catch-all used for unknown tag values returned by the Dropbox
         * servers.
         *
         * <p> Receiving a catch-all value typically indicates this SDK version
         * is not up to date. Consider updating your SDK version to handle the
         * new tags. </p>
         */
        OTHER,
        /**
         * There are too many write operations in user's Dropbox. Please retry
         * this request.
         */
        TOO_MANY_WRITE_OPERATIONS;
    }

    /**
     * Shared folders can't be copied.
     */
    public static final RelocationBatchError CANT_COPY_SHARED_FOLDER = new RelocationBatchError().withTag(Tag.CANT_COPY_SHARED_FOLDER);
    /**
     * Your move operation would result in nested shared folders.  This is not
     * allowed.
     */
    public static final RelocationBatchError CANT_NEST_SHARED_FOLDER = new RelocationBatchError().withTag(Tag.CANT_NEST_SHARED_FOLDER);
    /**
     * You cannot move a folder into itself.
     */
    public static final RelocationBatchError CANT_MOVE_FOLDER_INTO_ITSELF = new RelocationBatchError().withTag(Tag.CANT_MOVE_FOLDER_INTO_ITSELF);
    /**
     * The operation would involve more than 10,000 files and folders.
     */
    public static final RelocationBatchError TOO_MANY_FILES = new RelocationBatchError().withTag(Tag.TOO_MANY_FILES);
    /**
     * There are duplicated/nested paths among {@link RelocationArg#getFromPath}
     * and {@link RelocationArg#getToPath}.
     */
    public static final RelocationBatchError DUPLICATED_OR_NESTED_PATHS = new RelocationBatchError().withTag(Tag.DUPLICATED_OR_NESTED_PATHS);
    /**
     * Your move operation would result in an ownership transfer. You may
     * reissue the request with the field {@link
     * RelocationArg#getAllowOwnershipTransfer} to true.
     */
    public static final RelocationBatchError CANT_TRANSFER_OWNERSHIP = new RelocationBatchError().withTag(Tag.CANT_TRANSFER_OWNERSHIP);
    /**
     * The current user does not have enough space to move or copy the files.
     */
    public static final RelocationBatchError INSUFFICIENT_QUOTA = new RelocationBatchError().withTag(Tag.INSUFFICIENT_QUOTA);
    /**
     * Something went wrong with the job on Dropbox's end. You'll need to verify
     * that the action you were taking succeeded, and if not, try again. This
     * should happen very rarely.
     */
    public static final RelocationBatchError INTERNAL_ERROR = new RelocationBatchError().withTag(Tag.INTERNAL_ERROR);
    /**
     * Can't move the shared folder to the given destination.
     */
    public static final RelocationBatchError CANT_MOVE_SHARED_FOLDER = new RelocationBatchError().withTag(Tag.CANT_MOVE_SHARED_FOLDER);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final RelocationBatchError OTHER = new RelocationBatchError().withTag(Tag.OTHER);
    /**
     * There are too many write operations in user's Dropbox. Please retry this
     * request.
     */
    public static final RelocationBatchError TOO_MANY_WRITE_OPERATIONS = new RelocationBatchError().withTag(Tag.TOO_MANY_WRITE_OPERATIONS);

    private Tag _tag;
    private LookupError fromLookupValue;
    private WriteError fromWriteValue;
    private WriteError toValue;
    private MoveIntoVaultError cantMoveIntoVaultValue;
    private MoveIntoFamilyError cantMoveIntoFamilyValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private RelocationBatchError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private RelocationBatchError withTag(Tag _tag) {
        RelocationBatchError result = new RelocationBatchError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param fromLookupValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RelocationBatchError withTagAndFromLookup(Tag _tag, LookupError fromLookupValue) {
        RelocationBatchError result = new RelocationBatchError();
        result._tag = _tag;
        result.fromLookupValue = fromLookupValue;
        return result;
    }

    /**
     *
     * @param fromWriteValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RelocationBatchError withTagAndFromWrite(Tag _tag, WriteError fromWriteValue) {
        RelocationBatchError result = new RelocationBatchError();
        result._tag = _tag;
        result.fromWriteValue = fromWriteValue;
        return result;
    }

    /**
     *
     * @param toValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RelocationBatchError withTagAndTo(Tag _tag, WriteError toValue) {
        RelocationBatchError result = new RelocationBatchError();
        result._tag = _tag;
        result.toValue = toValue;
        return result;
    }

    /**
     *
     * @param cantMoveIntoVaultValue  Some content cannot be moved into Vault
     *     under certain circumstances, see detailed error. Must not be {@code
     *     null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RelocationBatchError withTagAndCantMoveIntoVault(Tag _tag, MoveIntoVaultError cantMoveIntoVaultValue) {
        RelocationBatchError result = new RelocationBatchError();
        result._tag = _tag;
        result.cantMoveIntoVaultValue = cantMoveIntoVaultValue;
        return result;
    }

    /**
     *
     * @param cantMoveIntoFamilyValue  Some content cannot be moved into the
     *     Family Room folder under certain circumstances, see detailed error.
     *     Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private RelocationBatchError withTagAndCantMoveIntoFamily(Tag _tag, MoveIntoFamilyError cantMoveIntoFamilyValue) {
        RelocationBatchError result = new RelocationBatchError();
        result._tag = _tag;
        result.cantMoveIntoFamilyValue = cantMoveIntoFamilyValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code RelocationBatchError}. </p>
     *
     * @return the tag for this instance.
     */
    public Tag tag() {
        return _tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#FROM_LOOKUP}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FROM_LOOKUP}, {@code false} otherwise.
     */
    public boolean isFromLookup() {
        return this._tag == Tag.FROM_LOOKUP;
    }

    /**
     * Returns an instance of {@code RelocationBatchError} that has its tag set
     * to {@link Tag#FROM_LOOKUP}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchError} with its tag set to
     *     {@link Tag#FROM_LOOKUP}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationBatchError fromLookup(LookupError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchError().withTagAndFromLookup(Tag.FROM_LOOKUP, value);
    }

    /**
     * This instance must be tagged as {@link Tag#FROM_LOOKUP}.
     *
     * @return The {@link LookupError} value associated with this instance if
     *     {@link #isFromLookup} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFromLookup} is {@code false}.
     */
    public LookupError getFromLookupValue() {
        if (this._tag != Tag.FROM_LOOKUP) {
            throw new IllegalStateException("Invalid tag: required Tag.FROM_LOOKUP, but was Tag." + this._tag.name());
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
        return this._tag == Tag.FROM_WRITE;
    }

    /**
     * Returns an instance of {@code RelocationBatchError} that has its tag set
     * to {@link Tag#FROM_WRITE}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchError} with its tag set to
     *     {@link Tag#FROM_WRITE}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationBatchError fromWrite(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchError().withTagAndFromWrite(Tag.FROM_WRITE, value);
    }

    /**
     * This instance must be tagged as {@link Tag#FROM_WRITE}.
     *
     * @return The {@link WriteError} value associated with this instance if
     *     {@link #isFromWrite} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isFromWrite} is {@code false}.
     */
    public WriteError getFromWriteValue() {
        if (this._tag != Tag.FROM_WRITE) {
            throw new IllegalStateException("Invalid tag: required Tag.FROM_WRITE, but was Tag." + this._tag.name());
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
        return this._tag == Tag.TO;
    }

    /**
     * Returns an instance of {@code RelocationBatchError} that has its tag set
     * to {@link Tag#TO}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchError} with its tag set to
     *     {@link Tag#TO}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationBatchError to(WriteError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchError().withTagAndTo(Tag.TO, value);
    }

    /**
     * This instance must be tagged as {@link Tag#TO}.
     *
     * @return The {@link WriteError} value associated with this instance if
     *     {@link #isTo} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isTo} is {@code false}.
     */
    public WriteError getToValue() {
        if (this._tag != Tag.TO) {
            throw new IllegalStateException("Invalid tag: required Tag.TO, but was Tag." + this._tag.name());
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
        return this._tag == Tag.CANT_COPY_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_NEST_SHARED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANT_NEST_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isCantNestSharedFolder() {
        return this._tag == Tag.CANT_NEST_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_MOVE_FOLDER_INTO_ITSELF}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANT_MOVE_FOLDER_INTO_ITSELF}, {@code false} otherwise.
     */
    public boolean isCantMoveFolderIntoItself() {
        return this._tag == Tag.CANT_MOVE_FOLDER_INTO_ITSELF;
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
     * Tag#DUPLICATED_OR_NESTED_PATHS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#DUPLICATED_OR_NESTED_PATHS}, {@code false} otherwise.
     */
    public boolean isDuplicatedOrNestedPaths() {
        return this._tag == Tag.DUPLICATED_OR_NESTED_PATHS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_TRANSFER_OWNERSHIP}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANT_TRANSFER_OWNERSHIP}, {@code false} otherwise.
     */
    public boolean isCantTransferOwnership() {
        return this._tag == Tag.CANT_TRANSFER_OWNERSHIP;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSUFFICIENT_QUOTA}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSUFFICIENT_QUOTA}, {@code false} otherwise.
     */
    public boolean isInsufficientQuota() {
        return this._tag == Tag.INSUFFICIENT_QUOTA;
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
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_MOVE_SHARED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANT_MOVE_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isCantMoveSharedFolder() {
        return this._tag == Tag.CANT_MOVE_SHARED_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_MOVE_INTO_VAULT}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANT_MOVE_INTO_VAULT}, {@code false} otherwise.
     */
    public boolean isCantMoveIntoVault() {
        return this._tag == Tag.CANT_MOVE_INTO_VAULT;
    }

    /**
     * Returns an instance of {@code RelocationBatchError} that has its tag set
     * to {@link Tag#CANT_MOVE_INTO_VAULT}.
     *
     * <p> Some content cannot be moved into Vault under certain circumstances,
     * see detailed error. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchError} with its tag set to
     *     {@link Tag#CANT_MOVE_INTO_VAULT}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationBatchError cantMoveIntoVault(MoveIntoVaultError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchError().withTagAndCantMoveIntoVault(Tag.CANT_MOVE_INTO_VAULT, value);
    }

    /**
     * Some content cannot be moved into Vault under certain circumstances, see
     * detailed error.
     *
     * <p> This instance must be tagged as {@link Tag#CANT_MOVE_INTO_VAULT}.
     * </p>
     *
     * @return The {@link MoveIntoVaultError} value associated with this
     *     instance if {@link #isCantMoveIntoVault} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isCantMoveIntoVault} is {@code
     *     false}.
     */
    public MoveIntoVaultError getCantMoveIntoVaultValue() {
        if (this._tag != Tag.CANT_MOVE_INTO_VAULT) {
            throw new IllegalStateException("Invalid tag: required Tag.CANT_MOVE_INTO_VAULT, but was Tag." + this._tag.name());
        }
        return cantMoveIntoVaultValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#CANT_MOVE_INTO_FAMILY}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#CANT_MOVE_INTO_FAMILY}, {@code false} otherwise.
     */
    public boolean isCantMoveIntoFamily() {
        return this._tag == Tag.CANT_MOVE_INTO_FAMILY;
    }

    /**
     * Returns an instance of {@code RelocationBatchError} that has its tag set
     * to {@link Tag#CANT_MOVE_INTO_FAMILY}.
     *
     * <p> Some content cannot be moved into the Family Room folder under
     * certain circumstances, see detailed error. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelocationBatchError} with its tag set to
     *     {@link Tag#CANT_MOVE_INTO_FAMILY}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelocationBatchError cantMoveIntoFamily(MoveIntoFamilyError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelocationBatchError().withTagAndCantMoveIntoFamily(Tag.CANT_MOVE_INTO_FAMILY, value);
    }

    /**
     * Some content cannot be moved into the Family Room folder under certain
     * circumstances, see detailed error.
     *
     * <p> This instance must be tagged as {@link Tag#CANT_MOVE_INTO_FAMILY}.
     * </p>
     *
     * @return The {@link MoveIntoFamilyError} value associated with this
     *     instance if {@link #isCantMoveIntoFamily} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isCantMoveIntoFamily} is {@code
     *     false}.
     */
    public MoveIntoFamilyError getCantMoveIntoFamilyValue() {
        if (this._tag != Tag.CANT_MOVE_INTO_FAMILY) {
            throw new IllegalStateException("Invalid tag: required Tag.CANT_MOVE_INTO_FAMILY, but was Tag." + this._tag.name());
        }
        return cantMoveIntoFamilyValue;
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

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this._tag,
            this.fromLookupValue,
            this.fromWriteValue,
            this.toValue,
            this.cantMoveIntoVaultValue,
            this.cantMoveIntoFamilyValue
        });
        hash = (31 * super.hashCode()) + hash;
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
        else if (obj instanceof RelocationBatchError) {
            RelocationBatchError other = (RelocationBatchError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
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
                case DUPLICATED_OR_NESTED_PATHS:
                    return true;
                case CANT_TRANSFER_OWNERSHIP:
                    return true;
                case INSUFFICIENT_QUOTA:
                    return true;
                case INTERNAL_ERROR:
                    return true;
                case CANT_MOVE_SHARED_FOLDER:
                    return true;
                case CANT_MOVE_INTO_VAULT:
                    return (this.cantMoveIntoVaultValue == other.cantMoveIntoVaultValue) || (this.cantMoveIntoVaultValue.equals(other.cantMoveIntoVaultValue));
                case CANT_MOVE_INTO_FAMILY:
                    return (this.cantMoveIntoFamilyValue == other.cantMoveIntoFamilyValue) || (this.cantMoveIntoFamilyValue.equals(other.cantMoveIntoFamilyValue));
                case OTHER:
                    return true;
                case TOO_MANY_WRITE_OPERATIONS:
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
    static class Serializer extends UnionSerializer<RelocationBatchError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(RelocationBatchError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case FROM_LOOKUP: {
                    g.writeStartObject();
                    writeTag("from_lookup", g);
                    g.writeFieldName("from_lookup");
                    LookupError.Serializer.INSTANCE.serialize(value.fromLookupValue, g);
                    g.writeEndObject();
                    break;
                }
                case FROM_WRITE: {
                    g.writeStartObject();
                    writeTag("from_write", g);
                    g.writeFieldName("from_write");
                    WriteError.Serializer.INSTANCE.serialize(value.fromWriteValue, g);
                    g.writeEndObject();
                    break;
                }
                case TO: {
                    g.writeStartObject();
                    writeTag("to", g);
                    g.writeFieldName("to");
                    WriteError.Serializer.INSTANCE.serialize(value.toValue, g);
                    g.writeEndObject();
                    break;
                }
                case CANT_COPY_SHARED_FOLDER: {
                    g.writeString("cant_copy_shared_folder");
                    break;
                }
                case CANT_NEST_SHARED_FOLDER: {
                    g.writeString("cant_nest_shared_folder");
                    break;
                }
                case CANT_MOVE_FOLDER_INTO_ITSELF: {
                    g.writeString("cant_move_folder_into_itself");
                    break;
                }
                case TOO_MANY_FILES: {
                    g.writeString("too_many_files");
                    break;
                }
                case DUPLICATED_OR_NESTED_PATHS: {
                    g.writeString("duplicated_or_nested_paths");
                    break;
                }
                case CANT_TRANSFER_OWNERSHIP: {
                    g.writeString("cant_transfer_ownership");
                    break;
                }
                case INSUFFICIENT_QUOTA: {
                    g.writeString("insufficient_quota");
                    break;
                }
                case INTERNAL_ERROR: {
                    g.writeString("internal_error");
                    break;
                }
                case CANT_MOVE_SHARED_FOLDER: {
                    g.writeString("cant_move_shared_folder");
                    break;
                }
                case CANT_MOVE_INTO_VAULT: {
                    g.writeStartObject();
                    writeTag("cant_move_into_vault", g);
                    g.writeFieldName("cant_move_into_vault");
                    MoveIntoVaultError.Serializer.INSTANCE.serialize(value.cantMoveIntoVaultValue, g);
                    g.writeEndObject();
                    break;
                }
                case CANT_MOVE_INTO_FAMILY: {
                    g.writeStartObject();
                    writeTag("cant_move_into_family", g);
                    g.writeFieldName("cant_move_into_family");
                    MoveIntoFamilyError.Serializer.INSTANCE.serialize(value.cantMoveIntoFamilyValue, g);
                    g.writeEndObject();
                    break;
                }
                case OTHER: {
                    g.writeString("other");
                    break;
                }
                case TOO_MANY_WRITE_OPERATIONS: {
                    g.writeString("too_many_write_operations");
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unrecognized tag: " + value.tag());
                }
            }
        }

        @Override
        public RelocationBatchError deserialize(JsonParser p) throws IOException, JsonParseException {
            RelocationBatchError value;
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
            else if ("from_lookup".equals(tag)) {
                LookupError fieldValue = null;
                expectField("from_lookup", p);
                fieldValue = LookupError.Serializer.INSTANCE.deserialize(p);
                value = RelocationBatchError.fromLookup(fieldValue);
            }
            else if ("from_write".equals(tag)) {
                WriteError fieldValue = null;
                expectField("from_write", p);
                fieldValue = WriteError.Serializer.INSTANCE.deserialize(p);
                value = RelocationBatchError.fromWrite(fieldValue);
            }
            else if ("to".equals(tag)) {
                WriteError fieldValue = null;
                expectField("to", p);
                fieldValue = WriteError.Serializer.INSTANCE.deserialize(p);
                value = RelocationBatchError.to(fieldValue);
            }
            else if ("cant_copy_shared_folder".equals(tag)) {
                value = RelocationBatchError.CANT_COPY_SHARED_FOLDER;
            }
            else if ("cant_nest_shared_folder".equals(tag)) {
                value = RelocationBatchError.CANT_NEST_SHARED_FOLDER;
            }
            else if ("cant_move_folder_into_itself".equals(tag)) {
                value = RelocationBatchError.CANT_MOVE_FOLDER_INTO_ITSELF;
            }
            else if ("too_many_files".equals(tag)) {
                value = RelocationBatchError.TOO_MANY_FILES;
            }
            else if ("duplicated_or_nested_paths".equals(tag)) {
                value = RelocationBatchError.DUPLICATED_OR_NESTED_PATHS;
            }
            else if ("cant_transfer_ownership".equals(tag)) {
                value = RelocationBatchError.CANT_TRANSFER_OWNERSHIP;
            }
            else if ("insufficient_quota".equals(tag)) {
                value = RelocationBatchError.INSUFFICIENT_QUOTA;
            }
            else if ("internal_error".equals(tag)) {
                value = RelocationBatchError.INTERNAL_ERROR;
            }
            else if ("cant_move_shared_folder".equals(tag)) {
                value = RelocationBatchError.CANT_MOVE_SHARED_FOLDER;
            }
            else if ("cant_move_into_vault".equals(tag)) {
                MoveIntoVaultError fieldValue = null;
                expectField("cant_move_into_vault", p);
                fieldValue = MoveIntoVaultError.Serializer.INSTANCE.deserialize(p);
                value = RelocationBatchError.cantMoveIntoVault(fieldValue);
            }
            else if ("cant_move_into_family".equals(tag)) {
                MoveIntoFamilyError fieldValue = null;
                expectField("cant_move_into_family", p);
                fieldValue = MoveIntoFamilyError.Serializer.INSTANCE.deserialize(p);
                value = RelocationBatchError.cantMoveIntoFamily(fieldValue);
            }
            else if ("other".equals(tag)) {
                value = RelocationBatchError.OTHER;
            }
            else if ("too_many_write_operations".equals(tag)) {
                value = RelocationBatchError.TOO_MANY_WRITE_OPERATIONS;
            }
            else {
                throw new JsonParseException(p, "Unknown tag: " + tag);
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
