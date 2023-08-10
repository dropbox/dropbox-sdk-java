/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

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
public final class MountFolderError {
    // union sharing.MountFolderError (sharing_folders.stone)

    /**
     * Discriminating tag type for {@link MountFolderError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * Mounting would cause a shared folder to be inside another, which is
         * disallowed.
         */
        INSIDE_SHARED_FOLDER,
        /**
         * The current user does not have enough space to mount the shared
         * folder.
         */
        INSUFFICIENT_QUOTA, // InsufficientQuotaAmounts
        /**
         * The shared folder is already mounted.
         */
        ALREADY_MOUNTED,
        /**
         * The current user does not have permission to perform this action.
         */
        NO_PERMISSION,
        /**
         * The shared folder is not mountable. One example where this can occur
         * is when the shared folder belongs within a team folder in the user's
         * Dropbox.
         */
        NOT_MOUNTABLE,
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
     * Mounting would cause a shared folder to be inside another, which is
     * disallowed.
     */
    public static final MountFolderError INSIDE_SHARED_FOLDER = new MountFolderError().withTag(Tag.INSIDE_SHARED_FOLDER);
    /**
     * The shared folder is already mounted.
     */
    public static final MountFolderError ALREADY_MOUNTED = new MountFolderError().withTag(Tag.ALREADY_MOUNTED);
    /**
     * The current user does not have permission to perform this action.
     */
    public static final MountFolderError NO_PERMISSION = new MountFolderError().withTag(Tag.NO_PERMISSION);
    /**
     * The shared folder is not mountable. One example where this can occur is
     * when the shared folder belongs within a team folder in the user's
     * Dropbox.
     */
    public static final MountFolderError NOT_MOUNTABLE = new MountFolderError().withTag(Tag.NOT_MOUNTABLE);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final MountFolderError OTHER = new MountFolderError().withTag(Tag.OTHER);

    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;
    private InsufficientQuotaAmounts insufficientQuotaValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private MountFolderError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private MountFolderError withTag(Tag _tag) {
        MountFolderError result = new MountFolderError();
        result._tag = _tag;
        return result;
    }

    /**
     *
     * @param accessErrorValue  Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private MountFolderError withTagAndAccessError(Tag _tag, SharedFolderAccessError accessErrorValue) {
        MountFolderError result = new MountFolderError();
        result._tag = _tag;
        result.accessErrorValue = accessErrorValue;
        return result;
    }

    /**
     *
     * @param insufficientQuotaValue  The current user does not have enough
     *     space to mount the shared folder. Must not be {@code null}.
     * @param _tag  Discriminating tag for this instance.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    private MountFolderError withTagAndInsufficientQuota(Tag _tag, InsufficientQuotaAmounts insufficientQuotaValue) {
        MountFolderError result = new MountFolderError();
        result._tag = _tag;
        result.insufficientQuotaValue = insufficientQuotaValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code MountFolderError}. </p>
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
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this._tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code MountFolderError} that has its tag set to
     * {@link Tag#ACCESS_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MountFolderError} with its tag set to {@link
     *     Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MountFolderError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MountFolderError().withTagAndAccessError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link SharedFolderAccessError} value associated with this
     *     instance if {@link #isAccessError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharedFolderAccessError getAccessErrorValue() {
        if (this._tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + this._tag.name());
        }
        return accessErrorValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#INSIDE_SHARED_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INSIDE_SHARED_FOLDER}, {@code false} otherwise.
     */
    public boolean isInsideSharedFolder() {
        return this._tag == Tag.INSIDE_SHARED_FOLDER;
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
     * Returns an instance of {@code MountFolderError} that has its tag set to
     * {@link Tag#INSUFFICIENT_QUOTA}.
     *
     * <p> The current user does not have enough space to mount the shared
     * folder. </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code MountFolderError} with its tag set to {@link
     *     Tag#INSUFFICIENT_QUOTA}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static MountFolderError insufficientQuota(InsufficientQuotaAmounts value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new MountFolderError().withTagAndInsufficientQuota(Tag.INSUFFICIENT_QUOTA, value);
    }

    /**
     * The current user does not have enough space to mount the shared folder.
     *
     * <p> This instance must be tagged as {@link Tag#INSUFFICIENT_QUOTA}. </p>
     *
     * @return The {@link InsufficientQuotaAmounts} value associated with this
     *     instance if {@link #isInsufficientQuota} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isInsufficientQuota} is {@code
     *     false}.
     */
    public InsufficientQuotaAmounts getInsufficientQuotaValue() {
        if (this._tag != Tag.INSUFFICIENT_QUOTA) {
            throw new IllegalStateException("Invalid tag: required Tag.INSUFFICIENT_QUOTA, but was Tag." + this._tag.name());
        }
        return insufficientQuotaValue;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ALREADY_MOUNTED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ALREADY_MOUNTED}, {@code false} otherwise.
     */
    public boolean isAlreadyMounted() {
        return this._tag == Tag.ALREADY_MOUNTED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NOT_MOUNTABLE}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NOT_MOUNTABLE}, {@code false} otherwise.
     */
    public boolean isNotMountable() {
        return this._tag == Tag.NOT_MOUNTABLE;
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
            accessErrorValue,
            insufficientQuotaValue
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
        else if (obj instanceof MountFolderError) {
            MountFolderError other = (MountFolderError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case INSIDE_SHARED_FOLDER:
                    return true;
                case INSUFFICIENT_QUOTA:
                    return (this.insufficientQuotaValue == other.insufficientQuotaValue) || (this.insufficientQuotaValue.equals(other.insufficientQuotaValue));
                case ALREADY_MOUNTED:
                    return true;
                case NO_PERMISSION:
                    return true;
                case NOT_MOUNTABLE:
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
    static class Serializer extends UnionSerializer<MountFolderError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(MountFolderError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ACCESS_ERROR: {
                    g.writeStartObject();
                    writeTag("access_error", g);
                    g.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(value.accessErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case INSIDE_SHARED_FOLDER: {
                    g.writeString("inside_shared_folder");
                    break;
                }
                case INSUFFICIENT_QUOTA: {
                    g.writeStartObject();
                    writeTag("insufficient_quota", g);
                    InsufficientQuotaAmounts.Serializer.INSTANCE.serialize(value.insufficientQuotaValue, g, true);
                    g.writeEndObject();
                    break;
                }
                case ALREADY_MOUNTED: {
                    g.writeString("already_mounted");
                    break;
                }
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                case NOT_MOUNTABLE: {
                    g.writeString("not_mountable");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public MountFolderError deserialize(JsonParser p) throws IOException, JsonParseException {
            MountFolderError value;
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
            else if ("access_error".equals(tag)) {
                SharedFolderAccessError fieldValue = null;
                expectField("access_error", p);
                fieldValue = SharedFolderAccessError.Serializer.INSTANCE.deserialize(p);
                value = MountFolderError.accessError(fieldValue);
            }
            else if ("inside_shared_folder".equals(tag)) {
                value = MountFolderError.INSIDE_SHARED_FOLDER;
            }
            else if ("insufficient_quota".equals(tag)) {
                InsufficientQuotaAmounts fieldValue = null;
                fieldValue = InsufficientQuotaAmounts.Serializer.INSTANCE.deserialize(p, true);
                value = MountFolderError.insufficientQuota(fieldValue);
            }
            else if ("already_mounted".equals(tag)) {
                value = MountFolderError.ALREADY_MOUNTED;
            }
            else if ("no_permission".equals(tag)) {
                value = MountFolderError.NO_PERMISSION;
            }
            else if ("not_mountable".equals(tag)) {
                value = MountFolderError.NOT_MOUNTABLE;
            }
            else {
                value = MountFolderError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
