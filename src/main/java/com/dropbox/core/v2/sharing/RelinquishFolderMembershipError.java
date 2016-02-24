/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public final class RelinquishFolderMembershipError {
    // union RelinquishFolderMembershipError

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
        OTHER; // *catch_all
    }

    private static final java.util.HashMap<String, Tag> VALUES_;
    static {
        VALUES_ = new java.util.HashMap<String, Tag>();
        VALUES_.put("access_error", Tag.ACCESS_ERROR);
        VALUES_.put("folder_owner", Tag.FOLDER_OWNER);
        VALUES_.put("mounted", Tag.MOUNTED);
        VALUES_.put("group_access", Tag.GROUP_ACCESS);
        VALUES_.put("team_folder", Tag.TEAM_FOLDER);
        VALUES_.put("no_permission", Tag.NO_PERMISSION);
        VALUES_.put("other", Tag.OTHER);
    }

    public static final RelinquishFolderMembershipError FOLDER_OWNER = new RelinquishFolderMembershipError(Tag.FOLDER_OWNER, null);
    public static final RelinquishFolderMembershipError MOUNTED = new RelinquishFolderMembershipError(Tag.MOUNTED, null);
    public static final RelinquishFolderMembershipError GROUP_ACCESS = new RelinquishFolderMembershipError(Tag.GROUP_ACCESS, null);
    public static final RelinquishFolderMembershipError TEAM_FOLDER = new RelinquishFolderMembershipError(Tag.TEAM_FOLDER, null);
    public static final RelinquishFolderMembershipError NO_PERMISSION = new RelinquishFolderMembershipError(Tag.NO_PERMISSION, null);
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
     * associated to a specific tag.  Callers are recommended to use the tag
     * value in a {@code switch} statement to determine how to properly handle
     * this {@code RelinquishFolderMembershipError}. </p>
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#ACCESS_ERROR}, {@code false} otherwise.
     */
    public boolean isAccessError() {
        return this.tag == Tag.ACCESS_ERROR;
    }

    /**
     * Returns an instance of {@code RelinquishFolderMembershipError} that has
     * its tag set to {@link Tag#ACCESS_ERROR}.
     *
     * @param value  {@link RelinquishFolderMembershipError#accessError} value
     *     to assign to this instance.
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
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#FOLDER_OWNER}, {@code false} otherwise.
     */
    public boolean isFolderOwner() {
        return this.tag == Tag.FOLDER_OWNER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#MOUNTED},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#MOUNTED},
     *     {@code false} otherwise.
     */
    public boolean isMounted() {
        return this.tag == Tag.MOUNTED;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#GROUP_ACCESS}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#GROUP_ACCESS}, {@code false} otherwise.
     */
    public boolean isGroupAccess() {
        return this.tag == Tag.GROUP_ACCESS;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#TEAM_FOLDER}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#TEAM_FOLDER}, {@code false} otherwise.
     */
    public boolean isTeamFolder() {
        return this.tag == Tag.TEAM_FOLDER;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link
     * Tag#NO_PERMISSION}, {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link
     *     Tag#NO_PERMISSION}, {@code false} otherwise.
     */
    public boolean isNoPermission() {
        return this.tag == Tag.NO_PERMISSION;
    }

    /**
     * Returns {@code true} if this instance has the tag {@link Tag#OTHER},
     * {@code false} otherwise.
     *
     * @return {@code true} if this insta5Bnce is tagged as {@link Tag#OTHER},
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static RelinquishFolderMembershipError fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<RelinquishFolderMembershipError> _JSON_WRITER = new JsonWriter<RelinquishFolderMembershipError>() {
        public final void write(RelinquishFolderMembershipError x, JsonGenerator g) throws IOException {
            switch (x.tag) {
                case ACCESS_ERROR:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("access_error");
                    g.writeFieldName("access_error");
                    SharedFolderAccessError._JSON_WRITER.write(x.getAccessErrorValue(), g);
                    g.writeEndObject();
                    break;
                case FOLDER_OWNER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("folder_owner");
                    g.writeEndObject();
                    break;
                case MOUNTED:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("mounted");
                    g.writeEndObject();
                    break;
                case GROUP_ACCESS:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("group_access");
                    g.writeEndObject();
                    break;
                case TEAM_FOLDER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("team_folder");
                    g.writeEndObject();
                    break;
                case NO_PERMISSION:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("no_permission");
                    g.writeEndObject();
                    break;
                case OTHER:
                    g.writeStartObject();
                    g.writeFieldName(".tag");
                    g.writeString("other");
                    g.writeEndObject();
                    break;
            }
        }
    };

    public static final JsonReader<RelinquishFolderMembershipError> _JSON_READER = new JsonReader<RelinquishFolderMembershipError>() {

        public final RelinquishFolderMembershipError read(JsonParser parser) throws IOException, JsonReadException {
            if (parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String text = parser.getText();
                parser.nextToken();
                Tag tag = VALUES_.get(text);
                if (tag == null) {
                    return RelinquishFolderMembershipError.OTHER;
                }
                switch (tag) {
                    case FOLDER_OWNER: return RelinquishFolderMembershipError.FOLDER_OWNER;
                    case MOUNTED: return RelinquishFolderMembershipError.MOUNTED;
                    case GROUP_ACCESS: return RelinquishFolderMembershipError.GROUP_ACCESS;
                    case TEAM_FOLDER: return RelinquishFolderMembershipError.TEAM_FOLDER;
                    case NO_PERMISSION: return RelinquishFolderMembershipError.NO_PERMISSION;
                    case OTHER: return RelinquishFolderMembershipError.OTHER;
                }
                throw new JsonReadException("Tag " + tag + " requires a value", parser.getTokenLocation());
            }
            JsonReader.expectObjectStart(parser);
            String[] tags = readTags(parser);
            assert tags != null && tags.length == 1;
            String text = tags[0];
            Tag tag = VALUES_.get(text);
            RelinquishFolderMembershipError value = null;
            if (tag != null) {
                switch (tag) {
                    case ACCESS_ERROR: {
                        SharedFolderAccessError v = null;
                        assert parser.getCurrentToken() == JsonToken.FIELD_NAME;
                        text = parser.getText();
                        assert tags[0].equals(text);
                        parser.nextToken();
                        v = SharedFolderAccessError._JSON_READER
                            .readField(parser, "access_error", v);
                        value = RelinquishFolderMembershipError.accessError(v);
                        break;
                    }
                    case FOLDER_OWNER: {
                        value = RelinquishFolderMembershipError.FOLDER_OWNER;
                        break;
                    }
                    case MOUNTED: {
                        value = RelinquishFolderMembershipError.MOUNTED;
                        break;
                    }
                    case GROUP_ACCESS: {
                        value = RelinquishFolderMembershipError.GROUP_ACCESS;
                        break;
                    }
                    case TEAM_FOLDER: {
                        value = RelinquishFolderMembershipError.TEAM_FOLDER;
                        break;
                    }
                    case NO_PERMISSION: {
                        value = RelinquishFolderMembershipError.NO_PERMISSION;
                        break;
                    }
                    case OTHER: {
                        value = RelinquishFolderMembershipError.OTHER;
                        break;
                    }
                }
            }
            JsonReader.expectObjectEnd(parser);
            if (value == null) {
                return RelinquishFolderMembershipError.OTHER;
            }
            return value;
        }

    };
}
