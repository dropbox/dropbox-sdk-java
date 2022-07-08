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
public final class TransferFolderError {
    // union sharing.TransferFolderError (sharing_folders.stone)

    /**
     * Discriminating tag type for {@link TransferFolderError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * {@link TransferFolderArg#getToDropboxId} is invalid.
         */
        INVALID_DROPBOX_ID,
        /**
         * The new designated owner is not currently a member of the shared
         * folder.
         */
        NEW_OWNER_NOT_A_MEMBER,
        /**
         * The new designated owner has not added the folder to their Dropbox.
         */
        NEW_OWNER_UNMOUNTED,
        /**
         * The new designated owner's e-mail address is unverified.
         */
        NEW_OWNER_EMAIL_UNVERIFIED,
        /**
         * This action cannot be performed on a team shared folder.
         */
        TEAM_FOLDER,
        /**
         * The current user does not have permission to perform this action.
         */
        NO_PERMISSION,
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
     * {@link TransferFolderArg#getToDropboxId} is invalid.
     */
    public static final TransferFolderError INVALID_DROPBOX_ID = new TransferFolderError().withTag(Tag.INVALID_DROPBOX_ID);
    /**
     * The new designated owner is not currently a member of the shared folder.
     */
    public static final TransferFolderError NEW_OWNER_NOT_A_MEMBER = new TransferFolderError().withTag(Tag.NEW_OWNER_NOT_A_MEMBER);
    /**
     * The new designated owner has not added the folder to their Dropbox.
     */
    public static final TransferFolderError NEW_OWNER_UNMOUNTED = new TransferFolderError().withTag(Tag.NEW_OWNER_UNMOUNTED);
    /**
     * The new designated owner's e-mail address is unverified.
     */
    public static final TransferFolderError NEW_OWNER_EMAIL_UNVERIFIED = new TransferFolderError().withTag(Tag.NEW_OWNER_EMAIL_UNVERIFIED);
    /**
     * This action cannot be performed on a team shared folder.
     */
    public static final TransferFolderError TEAM_FOLDER = new TransferFolderError().withTag(Tag.TEAM_FOLDER);
    /**
     * The current user does not have permission to perform this action.
     */
    public static final TransferFolderError NO_PERMISSION = new TransferFolderError().withTag(Tag.NO_PERMISSION);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final TransferFolderError OTHER = new TransferFolderError().withTag(Tag.OTHER);

    private Tag _tag;
    private SharedFolderAccessError accessErrorValue;

    /**
     * Private default constructor, so that object is uninitializable publicly.
     */
    private TransferFolderError() {
    }


    /**
     *
     * @param _tag  Discriminating tag for this instance.
     */
    private TransferFolderError withTag(Tag _tag) {
        TransferFolderError result = new TransferFolderError();
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
    private TransferFolderError withTagAndAccessError(Tag _tag, SharedFolderAccessError accessErrorValue) {
        TransferFolderError result = new TransferFolderError();
        result._tag = _tag;
        result.accessErrorValue = accessErrorValue;
        return result;
    }

    /**
     * Returns the tag for this instance.
     *
     * <p> This class is a tagged union.  Tagged unions instances are always
     * associated to a specific tag.  This means only one of the {@code isXyz()}
     * methods will return {@code true}. Callers are recommended to use the tag
     * value in a {@code switch} statement to properly handle the different
     * values for this {@code TransferFolderError}. </p>
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
     * Returns an instance of {@code TransferFolderError} that has its tag set
     * to {@link Tag#ACCESS_ERROR}.
     *
     * <p> None </p>
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code TransferFolderError} with its tag set to
     *     {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static TransferFolderError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new TransferFolderError().withTagAndAccessError(Tag.ACCESS_ERROR, value);
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
     * Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#INVALID_DROPBOX_ID}, {@code false} otherwise.
     */
    public boolean isInvalidDropboxId() {
        return this._tag == Tag.INVALID_DROPBOX_ID;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NEW_OWNER_NOT_A_MEMBER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NEW_OWNER_NOT_A_MEMBER}, {@code false} otherwise.
     */
    public boolean isNewOwnerNotAMember() {
        return this._tag == Tag.NEW_OWNER_NOT_A_MEMBER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NEW_OWNER_UNMOUNTED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NEW_OWNER_UNMOUNTED}, {@code false} otherwise.
     */
    public boolean isNewOwnerUnmounted() {
        return this._tag == Tag.NEW_OWNER_UNMOUNTED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NEW_OWNER_EMAIL_UNVERIFIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NEW_OWNER_EMAIL_UNVERIFIED}, {@code false} otherwise.
     */
    public boolean isNewOwnerEmailUnverified() {
        return this._tag == Tag.NEW_OWNER_EMAIL_UNVERIFIED;
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
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this._tag == Tag.NO_PERMISSION;
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
            accessErrorValue
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
        else if (obj instanceof TransferFolderError) {
            TransferFolderError other = (TransferFolderError) obj;
            if (this._tag != other._tag) {
                return false;
            }
            switch (_tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case INVALID_DROPBOX_ID:
                    return true;
                case NEW_OWNER_NOT_A_MEMBER:
                    return true;
                case NEW_OWNER_UNMOUNTED:
                    return true;
                case NEW_OWNER_EMAIL_UNVERIFIED:
                    return true;
                case TEAM_FOLDER:
                    return true;
                case NO_PERMISSION:
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
    static class Serializer extends UnionSerializer<TransferFolderError> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TransferFolderError value, JsonGenerator g) throws IOException, JsonGenerationException {
            switch (value.tag()) {
                case ACCESS_ERROR: {
                    g.writeStartObject();
                    writeTag("access_error", g);
                    g.writeFieldName("access_error");
                    SharedFolderAccessError.Serializer.INSTANCE.serialize(value.accessErrorValue, g);
                    g.writeEndObject();
                    break;
                }
                case INVALID_DROPBOX_ID: {
                    g.writeString("invalid_dropbox_id");
                    break;
                }
                case NEW_OWNER_NOT_A_MEMBER: {
                    g.writeString("new_owner_not_a_member");
                    break;
                }
                case NEW_OWNER_UNMOUNTED: {
                    g.writeString("new_owner_unmounted");
                    break;
                }
                case NEW_OWNER_EMAIL_UNVERIFIED: {
                    g.writeString("new_owner_email_unverified");
                    break;
                }
                case TEAM_FOLDER: {
                    g.writeString("team_folder");
                    break;
                }
                case NO_PERMISSION: {
                    g.writeString("no_permission");
                    break;
                }
                default: {
                    g.writeString("other");
                }
            }
        }

        @Override
        public TransferFolderError deserialize(JsonParser p) throws IOException, JsonParseException {
            TransferFolderError value;
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
                value = TransferFolderError.accessError(fieldValue);
            }
            else if ("invalid_dropbox_id".equals(tag)) {
                value = TransferFolderError.INVALID_DROPBOX_ID;
            }
            else if ("new_owner_not_a_member".equals(tag)) {
                value = TransferFolderError.NEW_OWNER_NOT_A_MEMBER;
            }
            else if ("new_owner_unmounted".equals(tag)) {
                value = TransferFolderError.NEW_OWNER_UNMOUNTED;
            }
            else if ("new_owner_email_unverified".equals(tag)) {
                value = TransferFolderError.NEW_OWNER_EMAIL_UNVERIFIED;
            }
            else if ("team_folder".equals(tag)) {
                value = TransferFolderError.TEAM_FOLDER;
            }
            else if ("no_permission".equals(tag)) {
                value = TransferFolderError.NO_PERMISSION;
            }
            else {
                value = TransferFolderError.OTHER;
            }
            if (!collapsed) {
                skipFields(p);
                expectEndObject(p);
            }
            return value;
        }
    }
}
