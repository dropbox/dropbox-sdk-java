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
@JsonSerialize(using=RelinquishFolderMembershipError.Serializer.class)
@JsonDeserialize(using=RelinquishFolderMembershipError.Deserializer.class)
public final class RelinquishFolderMembershipError {
    // union RelinquishFolderMembershipError

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    /**
     * Discriminating tag type for {@link RelinquishFolderMembershipError}.
     */
    public enum Tag {
        ACCESS_ERROR, // SharedFolderAccessError
        /**
         * The current user is the owner of the shared folder. Owners cannot
         * relinquish membership to their own folders. Try unsharing or
         * transferring ownership first.
         */
        FOLDER_OWNER,
        /**
         * The shared folder is currently mounted.  Unmount the shared folder
         * before relinquishing membership.
         */
        MOUNTED,
        /**
         * The current user has access to the shared folder via a group.  You
         * can't relinquish membership to folders shared via groups.
         */
        GROUP_ACCESS,
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
     * The current user is the owner of the shared folder. Owners cannot
     * relinquish membership to their own folders. Try unsharing or transferring
     * ownership first.
     */
    public static final RelinquishFolderMembershipError FOLDER_OWNER = new RelinquishFolderMembershipError(Tag.FOLDER_OWNER, null);
    /**
     * The shared folder is currently mounted.  Unmount the shared folder before
     * relinquishing membership.
     */
    public static final RelinquishFolderMembershipError MOUNTED = new RelinquishFolderMembershipError(Tag.MOUNTED, null);
    /**
     * The current user has access to the shared folder via a group.  You can't
     * relinquish membership to folders shared via groups.
     */
    public static final RelinquishFolderMembershipError GROUP_ACCESS = new RelinquishFolderMembershipError(Tag.GROUP_ACCESS, null);
    /**
     * This action cannot be performed on a team shared folder.
     */
    public static final RelinquishFolderMembershipError TEAM_FOLDER = new RelinquishFolderMembershipError(Tag.TEAM_FOLDER, null);
    /**
     * The current user does not have permission to perform this action.
     */
    public static final RelinquishFolderMembershipError NO_PERMISSION = new RelinquishFolderMembershipError(Tag.NO_PERMISSION, null);
    /**
     * Catch-all used for unknown tag values returned by the Dropbox servers.
     *
     * <p> Receiving a catch-all value typically indicates this SDK version is
     * not up to date. Consider updating your SDK version to handle the new
     * tags. </p>
     */
    public static final RelinquishFolderMembershipError OTHER = new RelinquishFolderMembershipError(Tag.OTHER, null);

    private final Tag tag;
    private final SharedFolderAccessError accessErrorValue;

    /**
     *
     * @param tag  Discriminating tag for this instance.
     */
    private RelinquishFolderMembershipError(Tag tag, SharedFolderAccessError accessErrorValue) {
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
     * values for this {@code RelinquishFolderMembershipError}. </p>
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
     * Returns an instance of {@code RelinquishFolderMembershipError} that has
     * its tag set to {@link Tag#ACCESS_ERROR}.
     *
     * @param value  value to assign to this instance.
     *
     * @return Instance of {@code RelinquishFolderMembershipError} with its tag
     *     set to {@link Tag#ACCESS_ERROR}.
     *
     * @throws IllegalArgumentException  if {@code value} is {@code null}.
     */
    public static RelinquishFolderMembershipError accessError(SharedFolderAccessError value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }
        return new RelinquishFolderMembershipError(Tag.ACCESS_ERROR, value);
    }

    /**
     * This instance must be tagged as {@link Tag#ACCESS_ERROR}.
     *
     * @return The {@link RelinquishFolderMembershipError#accessError} value
     *     associated with this instance if {@link #isAccessError} is {@code
     *     true}.
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
     * Tag#FOLDER_OWNER}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#FOLDER_OWNER}, {@code false} otherwise.
     */
    public boolean isFolderOwner() {
        return this.tag == Tag.FOLDER_OWNER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#MOUNTED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link Tag#MOUNTED},
     *     {@code false} otherwise.
     */
    public boolean isMounted() {
        return this.tag == Tag.MOUNTED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_ACCESS}, {@code false} otherwise.
     *
     * @return {@code true} if this instance is tagged as {@link
     *     Tag#GROUP_ACCESS}, {@code false} otherwise.
     */
    public boolean isGroupAccess() {
        return this.tag == Tag.GROUP_ACCESS;
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
        else if (obj instanceof RelinquishFolderMembershipError) {
            RelinquishFolderMembershipError other = (RelinquishFolderMembershipError) obj;
            if (this.tag != other.tag) {
                return false;
            }
            switch (tag) {
                case ACCESS_ERROR:
                    return (this.accessErrorValue == other.accessErrorValue) || (this.accessErrorValue.equals(other.accessErrorValue));
                case FOLDER_OWNER:
                    return true;
                case MOUNTED:
                    return true;
                case GROUP_ACCESS:
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

    static final class Serializer extends UnionJsonSerializer<RelinquishFolderMembershipError> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(RelinquishFolderMembershipError.class);
        }

        @Override
        public void serialize(RelinquishFolderMembershipError value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            switch (value.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeStringField(".tag", "access_error");
                    g.writeObjectField("access_error", value.accessErrorValue);
                    g.writeEndObject();
                    break;
                case FOLDER_OWNER:
                    g.writeString("folder_owner");
                    break;
                case MOUNTED:
                    g.writeString("mounted");
                    break;
                case GROUP_ACCESS:
                    g.writeString("group_access");
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

    static final class Deserializer extends UnionJsonDeserializer<RelinquishFolderMembershipError, Tag> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(RelinquishFolderMembershipError.class, getTagMapping(), Tag.OTHER);
        }

        @Override
        public RelinquishFolderMembershipError deserialize(Tag _tag, JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            switch (_tag) {
                case ACCESS_ERROR: {
                    SharedFolderAccessError value = null;
                    expectField(_p, "access_error");
                    value = _p.readValueAs(SharedFolderAccessError.class);
                    _p.nextToken();
                    return RelinquishFolderMembershipError.accessError(value);
                }
                case FOLDER_OWNER: {
                    return RelinquishFolderMembershipError.FOLDER_OWNER;
                }
                case MOUNTED: {
                    return RelinquishFolderMembershipError.MOUNTED;
                }
                case GROUP_ACCESS: {
                    return RelinquishFolderMembershipError.GROUP_ACCESS;
                }
                case TEAM_FOLDER: {
                    return RelinquishFolderMembershipError.TEAM_FOLDER;
                }
                case NO_PERMISSION: {
                    return RelinquishFolderMembershipError.NO_PERMISSION;
                }
                case OTHER: {
                    return RelinquishFolderMembershipError.OTHER;
                }
            }
            // should be impossible to get here
            throw new IllegalStateException("Unparsed tag: \"" + _tag + "\"");
        }

        private static Map<String, RelinquishFolderMembershipError.Tag> getTagMapping() {
            Map<String, RelinquishFolderMembershipError.Tag> values = new HashMap<String, RelinquishFolderMembershipError.Tag>();
            values.put("access_error", RelinquishFolderMembershipError.Tag.ACCESS_ERROR);
            values.put("folder_owner", RelinquishFolderMembershipError.Tag.FOLDER_OWNER);
            values.put("mounted", RelinquishFolderMembershipError.Tag.MOUNTED);
            values.put("group_access", RelinquishFolderMembershipError.Tag.GROUP_ACCESS);
            values.put("team_folder", RelinquishFolderMembershipError.Tag.TEAM_FOLDER);
            values.put("no_permission", RelinquishFolderMembershipError.Tag.NO_PERMISSION);
            values.put("other", RelinquishFolderMembershipError.Tag.OTHER);
            return Collections.unmodifiableMap(values);
        }
    }
}
