/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

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
@JsonSerialize(using=TransferFolderError.Serializer.class)
@JsonDeserialize(using=TransferFolderError.Deserializer.class)
public final class TransferFolderError {
    // union TransferFolderError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link TransferFolderError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * the {@code toDropboxId} argument to {@link
         * DbxUserSharingRequests#transferFolder(String,String)} is invalid.
         */
        INVALID_DROPBOX_ID,
        /**
         * The new designated owner is not currently a member of the shared
         * folder.
         */
        NEW_OWNER_NOT_A_MEMBER,
        /**
         * The new designated owner does not have the shared folder mounted.
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
     * the {@code toDropboxId} argument to {@link
     * DbxUserSharingRequests#transferFolder(String,String)} is invalid.
     */
    public static final TransferFolderError INVALID_DROPBOX_ID = new TransferFolderError(Tag.INVALID_DROPBOX_ID, null);
    /**
     * The new designated owner is not currently a member of the shared folder.
     */
    public static final TransferFolderError NEW_OWNER_NOT_A_MEMBER = new TransferFolderError(Tag.NEW_OWNER_NOT_A_MEMBER, null);
    /**
     * The new designated owner does not have the shared folder mounted.
     */
    public static final TransferFolderError NEW_OWNER_UNMOUNTED = new TransferFolderError(Tag.NEW_OWNER_UNMOUNTED, null);
    /**
     * The new designated owner's e-mail address is unverified.
     */
    public static final TransferFolderError NEW_OWNER_EMAIL_UNVERIFIED = new TransferFolderError(Tag.NEW_OWNER_EMAIL_UNVERIFIED, null);
    /**
     * This action cannot be performed on a team shared folder.
     */
    public static final TransferFolderError TEAM_FOLDER = new TransferFolderError(Tag.TEAM_FOLDER, null);
    /**
     * The current user does not have permission to perform this action.
     */
    public static final TransferFolderError NO_PERMISSION = new TransferFolderError(Tag.NO_PERMISSION, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final TransferFolderError OTHER = new TransferFolderError(Tag.OTHER, null);

    private final Tag tag;
    private final SharedFolderAccessError accessErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private TransferFolderError(Tag tag, SharedFolderAccessError accessErrorValue) {
        this.tag = tag;
        this.accessErrorValue = accessErrorValue;
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
        return tag;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#ACCESS_ERROR}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this.tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code TransferFolderError} that has its tag set
     * to {@link Tag#ACCESS_ERROR}.
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
        return new TransferFolderError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link TransferFolderError#accessError} value associated with
     *     this instance if {@link #isAccessError} is {@code true}.
     *
     * @throws IllegalStateException  If {@link #isAccessError} is {@code
     *     false}.
     */
    public SharedFolderAccessError getAccessErrorValue() {
        if (this.tag != Tag.ACCESS_ERROR) {
            throw new IllegalStateException("Invalid tag: required Tag.ACCESS_ERROR, but was Tag." + tag.name());
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
        return this.tag == Tag.INVALID_DROPBOX_ID;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NEW_OWNER_NOT_A_MEMBER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NEW_OWNER_NOT_A_MEMBER}, {@code false} otherwise.
     */
    public boolean isNewOwnerNotAMember() {
        return this.tag == Tag.NEW_OWNER_NOT_A_MEMBER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NEW_OWNER_UNMOUNTED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NEW_OWNER_UNMOUNTED}, {@code false} otherwise.
     */
    public boolean isNewOwnerUnmounted() {
        return this.tag == Tag.NEW_OWNER_UNMOUNTED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NEW_OWNER_EMAIL_UNVERIFIED}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NEW_OWNER_EMAIL_UNVERIFIED}, {@code false} otherwise.
     */
    public boolean isNewOwnerEmailUnverified() {
        return this.tag == Tag.NEW_OWNER_EMAIL_UNVERIFIED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#TEAM_FOLDER}, {@code false} otherwise.
     */
    public boolean isTeamFolder() {
        return this.tag == Tag.TEAM_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this.tag == Tag.NO_PERMISSION;
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
            accessErrorValue
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if (obj instanceof TransferFolderError) {
            TransferFolderError other = (TransferFolderError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
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

    static final class Serializer extends UnionJsonSerializer<TransferFolderError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(TransferFolderError.class);
        }

        @Override
        public void serialize(TransferFolderError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeStringField(".tag", "access_error");
                    g.writeObjectField("access_error", value.accessErrorValue);
                    g.writeEndObject();
                    break;
                case INVALID_DROPBOX_ID:
                    g.writeString("invalid_dropbox_id");
                    break;
                case NEW_OWNER_NOT_A_MEMBER:
                    g.writeString("new_owner_not_a_member");
                    break;
                case NEW_OWNER_UNMOUNTED:
                    g.writeString("new_owner_unmounted");
                    break;
                case NEW_OWNER_EMAIL_UNVERIFIED:
                    g.writeString("new_owner_email_unverified");
                    break;
                case TEAM_FOLDER:
                    g.writeString("team_folder");
                    break;
                case NO_PERMISSION:
                    g.writeString("no_permission");
                    break;
                case OTHER:
                    g.writeString("other");
                    break;
            }
        }
    }

    static final class Deserializer extends UnionJsonDeserializer<TransferFolderError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(TransferFolderError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public TransferFolderError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case ACCESS_ERROR: {
                    SharedFolderAccessError value = null;
                    expectField(_p, "access_error");
                    value = _p.readValueAs(SharedFolderAccessError.class);
                    _p.nextToken();
                    return TransferFolderError.accessError(value);
                }
                case INVALID_DROPBOX_ID: {
                    return TransferFolderError.INVALID_DROPBOX_ID;
                }
                case NEW_OWNER_NOT_A_MEMBER: {
                    return TransferFolderError.NEW_OWNER_NOT_A_MEMBER;
                }
                case NEW_OWNER_UNMOUNTED: {
                    return TransferFolderError.NEW_OWNER_UNMOUNTED;
                }
                case NEW_OWNER_EMAIL_UNVERIFIED: {
                    return TransferFolderError.NEW_OWNER_EMAIL_UNVERIFIED;
                }
                case TEAM_FOLDER: {
                    return TransferFolderError.TEAM_FOLDER;
                }
                case NO_PERMISSION: {
                    return TransferFolderError.NO_PERMISSION;
                }
                case OTHER: {
                    return TransferFolderError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, TransferFolderError.Tag> getTagMapping() {
            Map<String, TransferFolderError.Tag> values = new HashMap<String, TransferFolderError.Tag>();
            values.put("access_error", TransferFolderError.Tag.ACCESS_ERROR);
            values.put("invalid_dropbox_id", TransferFolderError.Tag.INVALID_DROPBOX_ID);
            values.put("new_owner_not_a_member", TransferFolderError.Tag.NEW_OWNER_NOT_A_MEMBER);
            values.put("new_owner_unmounted", TransferFolderError.Tag.NEW_OWNER_UNMOUNTED);
            values.put("new_owner_email_unverified", TransferFolderError.Tag.NEW_OWNER_EMAIL_UNVERIFIED);
            values.put("team_folder", TransferFolderError.Tag.TEAM_FOLDER);
            values.put("no_permission", TransferFolderError.Tag.NO_PERMISSION);
            values.put("other", TransferFolderError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
