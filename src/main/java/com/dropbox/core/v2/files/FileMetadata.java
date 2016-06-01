/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.properties.PropertyGroup;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class FileMetadata extends Metadata {
    // struct FileMetadata

    protected final String id;
    protected final Date clientModified;
    protected final Date serverModified;
    protected final String rev;
    protected final long size;
    protected final MediaInfo mediaInfo;
    protected final FileSharingInfo sharingInfo;
    protected final List<PropertyGroup> propertyGroups;
    protected final Boolean hasExplicitSharedMembers;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Changes to the casing of paths won't be returned by
     *     {@link DbxUserFilesRequests#listFolderContinue(String)}. Must not be
     *     {@code null}.
     * @param id  A unique identifier for the file. Must have length of at least
     *     1 and not be {@code null}.
     * @param clientModified  For files, this is the modification time set by
     *     the desktop client when the file was added to Dropbox. Since this
     *     time is not verified (the Dropbox server stores whatever the desktop
     *     client sends up), this should only be used for display purposes (such
     *     as sorting) and not, for example, to determine if a file has changed
     *     or not. Must not be {@code null}.
     * @param serverModified  The last time the file was modified on Dropbox.
     *     Must not be {@code null}.
     * @param rev  A unique identifier for the current revision of a file. This
     *     field is the same rev as elsewhere in the API and can be used to
     *     detect changes and avoid conflicts. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     * @param size  The file size in bytes.
     * @param parentSharedFolderId  Deprecated. Please use {@link
     *     FileSharingInfo#getParentSharedFolderId} or {@link
     *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
     *     pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param mediaInfo  Additional information if the file is a photo or video.
     * @param sharingInfo  Set if this file is contained in a shared folder.
     * @param propertyGroups  Additional information if the file has custom
     *     properties with the property template specified. Must not contain a
     *     {@code null} item.
     * @param hasExplicitSharedMembers  This flag will only be present if
     *     include_has_explicit_shared_members  is true in {@link
     *     DbxUserFilesRequests#listFolder(String)} or {@link
     *     DbxUserFilesRequests#getMetadata(String)}. If this  flag is present,
     *     it will be true if this file has any explicit shared  members. This
     *     is different from sharing_info in that this could be true  in the
     *     case where a file has explicit members but is not contained within  a
     *     shared folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileMetadata(String name, String pathLower, String pathDisplay, String id, Date clientModified, Date serverModified, String rev, long size, String parentSharedFolderId, MediaInfo mediaInfo, FileSharingInfo sharingInfo, List<PropertyGroup> propertyGroups, Boolean hasExplicitSharedMembers) {
        super(name, pathLower, pathDisplay, parentSharedFolderId);
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (id.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        this.id = id;
        if (clientModified == null) {
            throw new IllegalArgumentException("Required value for 'clientModified' is null");
        }
        this.clientModified = com.dropbox.core.util.LangUtil.truncateMillis(clientModified);
        if (serverModified == null) {
            throw new IllegalArgumentException("Required value for 'serverModified' is null");
        }
        this.serverModified = com.dropbox.core.util.LangUtil.truncateMillis(serverModified);
        if (rev == null) {
            throw new IllegalArgumentException("Required value for 'rev' is null");
        }
        if (rev.length() < 9) {
            throw new IllegalArgumentException("String 'rev' is shorter than 9");
        }
        if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
            throw new IllegalArgumentException("String 'rev' does not match pattern");
        }
        this.rev = rev;
        this.size = size;
        this.mediaInfo = mediaInfo;
        this.sharingInfo = sharingInfo;
        if (propertyGroups != null) {
            for (PropertyGroup x : propertyGroups) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                }
            }
        }
        this.propertyGroups = propertyGroups;
        this.hasExplicitSharedMembers = hasExplicitSharedMembers;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Changes to the casing of paths won't be returned by
     *     {@link DbxUserFilesRequests#listFolderContinue(String)}. Must not be
     *     {@code null}.
     * @param id  A unique identifier for the file. Must have length of at least
     *     1 and not be {@code null}.
     * @param clientModified  For files, this is the modification time set by
     *     the desktop client when the file was added to Dropbox. Since this
     *     time is not verified (the Dropbox server stores whatever the desktop
     *     client sends up), this should only be used for display purposes (such
     *     as sorting) and not, for example, to determine if a file has changed
     *     or not. Must not be {@code null}.
     * @param serverModified  The last time the file was modified on Dropbox.
     *     Must not be {@code null}.
     * @param rev  A unique identifier for the current revision of a file. This
     *     field is the same rev as elsewhere in the API and can be used to
     *     detect changes and avoid conflicts. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     * @param size  The file size in bytes.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileMetadata(String name, String pathLower, String pathDisplay, String id, Date clientModified, Date serverModified, String rev, long size) {
        this(name, pathLower, pathDisplay, id, clientModified, serverModified, rev, size, null, null, null, null, null);
    }

    /**
     * A unique identifier for the file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getId() {
        return id;
    }

    /**
     * For files, this is the modification time set by the desktop client when
     * the file was added to Dropbox. Since this time is not verified (the
     * Dropbox server stores whatever the desktop client sends up), this should
     * only be used for display purposes (such as sorting) and not, for example,
     * to determine if a file has changed or not.
     *
     * @return value for this field, never {@code null}.
     */
    public Date getClientModified() {
        return clientModified;
    }

    /**
     * The last time the file was modified on Dropbox.
     *
     * @return value for this field, never {@code null}.
     */
    public Date getServerModified() {
        return serverModified;
    }

    /**
     * A unique identifier for the current revision of a file. This field is the
     * same rev as elsewhere in the API and can be used to detect changes and
     * avoid conflicts.
     *
     * @return value for this field, never {@code null}.
     */
    public String getRev() {
        return rev;
    }

    /**
     * The file size in bytes.
     *
     * @return value for this field.
     */
    public long getSize() {
        return size;
    }

    /**
     * Additional information if the file is a photo or video.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public MediaInfo getMediaInfo() {
        return mediaInfo;
    }

    /**
     * Set if this file is contained in a shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public FileSharingInfo getSharingInfo() {
        return sharingInfo;
    }

    /**
     * Additional information if the file has custom properties with the
     * property template specified.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<PropertyGroup> getPropertyGroups() {
        return propertyGroups;
    }

    /**
     * This flag will only be present if include_has_explicit_shared_members  is
     * true in {@link DbxUserFilesRequests#listFolder(String)} or {@link
     * DbxUserFilesRequests#getMetadata(String)}. If this  flag is present, it
     * will be true if this file has any explicit shared  members. This is
     * different from sharing_info in that this could be true  in the case where
     * a file has explicit members but is not contained within  a shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Boolean getHasExplicitSharedMembers() {
        return hasExplicitSharedMembers;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. Must not be {@code null}.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Changes to the casing of paths won't be returned by
     *     {@link DbxUserFilesRequests#listFolderContinue(String)}. Must not be
     *     {@code null}.
     * @param id  A unique identifier for the file. Must have length of at least
     *     1 and not be {@code null}.
     * @param clientModified  For files, this is the modification time set by
     *     the desktop client when the file was added to Dropbox. Since this
     *     time is not verified (the Dropbox server stores whatever the desktop
     *     client sends up), this should only be used for display purposes (such
     *     as sorting) and not, for example, to determine if a file has changed
     *     or not. Must not be {@code null}.
     * @param serverModified  The last time the file was modified on Dropbox.
     *     Must not be {@code null}.
     * @param rev  A unique identifier for the current revision of a file. This
     *     field is the same rev as elsewhere in the API and can be used to
     *     detect changes and avoid conflicts. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     * @param size  The file size in bytes.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name, String pathLower, String pathDisplay, String id, Date clientModified, Date serverModified, String rev, long size) {
        return new Builder(name, pathLower, pathDisplay, id, clientModified, serverModified, rev, size);
    }

    /**
     * Builder for {@link FileMetadata}.
     */
    public static class Builder {
        protected final String name;
        protected final String pathLower;
        protected final String pathDisplay;
        protected final String id;
        protected final Date clientModified;
        protected final Date serverModified;
        protected final String rev;
        protected final long size;

        protected String parentSharedFolderId;
        protected MediaInfo mediaInfo;
        protected FileSharingInfo sharingInfo;
        protected List<PropertyGroup> propertyGroups;
        protected Boolean hasExplicitSharedMembers;

        protected Builder(String name, String pathLower, String pathDisplay, String id, Date clientModified, Date serverModified, String rev, long size) {
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (pathLower == null) {
                throw new IllegalArgumentException("Required value for 'pathLower' is null");
            }
            this.pathLower = pathLower;
            if (pathDisplay == null) {
                throw new IllegalArgumentException("Required value for 'pathDisplay' is null");
            }
            this.pathDisplay = pathDisplay;
            if (id == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (id.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            this.id = id;
            if (clientModified == null) {
                throw new IllegalArgumentException("Required value for 'clientModified' is null");
            }
            this.clientModified = com.dropbox.core.util.LangUtil.truncateMillis(clientModified);
            if (serverModified == null) {
                throw new IllegalArgumentException("Required value for 'serverModified' is null");
            }
            this.serverModified = com.dropbox.core.util.LangUtil.truncateMillis(serverModified);
            if (rev == null) {
                throw new IllegalArgumentException("Required value for 'rev' is null");
            }
            if (rev.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
            this.rev = rev;
            this.size = size;
            this.parentSharedFolderId = null;
            this.mediaInfo = null;
            this.sharingInfo = null;
            this.propertyGroups = null;
            this.hasExplicitSharedMembers = null;
        }

        /**
         * Set value for optional field.
         *
         * @param parentSharedFolderId  Deprecated. Please use {@link
         *     FileSharingInfo#getParentSharedFolderId} or {@link
         *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
         *     pattern "{@code [-_0-9a-zA-Z:]+}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withParentSharedFolderId(String parentSharedFolderId) {
            if (parentSharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                    throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
                }
            }
            this.parentSharedFolderId = parentSharedFolderId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param mediaInfo  Additional information if the file is a photo or
         *     video.
         *
         * @return this builder
         */
        public Builder withMediaInfo(MediaInfo mediaInfo) {
            this.mediaInfo = mediaInfo;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param sharingInfo  Set if this file is contained in a shared folder.
         *
         * @return this builder
         */
        public Builder withSharingInfo(FileSharingInfo sharingInfo) {
            this.sharingInfo = sharingInfo;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param propertyGroups  Additional information if the file has custom
         *     properties with the property template specified. Must not contain
         *     a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPropertyGroups(List<PropertyGroup> propertyGroups) {
            if (propertyGroups != null) {
                for (PropertyGroup x : propertyGroups) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                    }
                }
            }
            this.propertyGroups = propertyGroups;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param hasExplicitSharedMembers  This flag will only be present if
         *     include_has_explicit_shared_members  is true in {@link
         *     DbxUserFilesRequests#listFolder(String)} or {@link
         *     DbxUserFilesRequests#getMetadata(String)}. If this  flag is
         *     present, it will be true if this file has any explicit shared
         *     members. This is different from sharing_info in that this could
         *     be true  in the case where a file has explicit members but is not
         *     contained within  a shared folder.
         *
         * @return this builder
         */
        public Builder withHasExplicitSharedMembers(Boolean hasExplicitSharedMembers) {
            this.hasExplicitSharedMembers = hasExplicitSharedMembers;
            return this;
        }

        /**
         * Builds an instance of {@link FileMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link FileMetadata}
         */
        public FileMetadata build() {
            return new FileMetadata(name, pathLower, pathDisplay, id, clientModified, serverModified, rev, size, parentSharedFolderId, mediaInfo, sharingInfo, propertyGroups, hasExplicitSharedMembers);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            id,
            clientModified,
            serverModified,
            rev,
            size,
            mediaInfo,
            sharingInfo,
            propertyGroups,
            hasExplicitSharedMembers
        });
        hash = (31 * super.hashCode()) + hash;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            FileMetadata other = (FileMetadata) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.pathLower == other.pathLower) || (this.pathLower.equals(other.pathLower)))
                && ((this.pathDisplay == other.pathDisplay) || (this.pathDisplay.equals(other.pathDisplay)))
                && ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.clientModified == other.clientModified) || (this.clientModified.equals(other.clientModified)))
                && ((this.serverModified == other.serverModified) || (this.serverModified.equals(other.serverModified)))
                && ((this.rev == other.rev) || (this.rev.equals(other.rev)))
                && (this.size == other.size)
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.mediaInfo == other.mediaInfo) || (this.mediaInfo != null && this.mediaInfo.equals(other.mediaInfo)))
                && ((this.sharingInfo == other.sharingInfo) || (this.sharingInfo != null && this.sharingInfo.equals(other.sharingInfo)))
                && ((this.propertyGroups == other.propertyGroups) || (this.propertyGroups != null && this.propertyGroups.equals(other.propertyGroups)))
                && ((this.hasExplicitSharedMembers == other.hasExplicitSharedMembers) || (this.hasExplicitSharedMembers != null && this.hasExplicitSharedMembers.equals(other.hasExplicitSharedMembers)))
                ;
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
    static final class Serializer extends StructSerializer<FileMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FileMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("file", g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("path_lower");
            StoneSerializers.string().serialize(value.pathLower, g);
            g.writeFieldName("path_display");
            StoneSerializers.string().serialize(value.pathDisplay, g);
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            g.writeFieldName("client_modified");
            StoneSerializers.timestamp().serialize(value.clientModified, g);
            g.writeFieldName("server_modified");
            StoneSerializers.timestamp().serialize(value.serverModified, g);
            g.writeFieldName("rev");
            StoneSerializers.string().serialize(value.rev, g);
            g.writeFieldName("size");
            StoneSerializers.uInt64().serialize(value.size, g);
            if (value.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentSharedFolderId, g);
            }
            if (value.mediaInfo != null) {
                g.writeFieldName("media_info");
                StoneSerializers.nullable(MediaInfo.Serializer.INSTANCE).serialize(value.mediaInfo, g);
            }
            if (value.sharingInfo != null) {
                g.writeFieldName("sharing_info");
                StoneSerializers.nullable(FileSharingInfo.Serializer.INSTANCE).serialize(value.sharingInfo, g);
            }
            if (value.propertyGroups != null) {
                g.writeFieldName("property_groups");
                StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).serialize(value.propertyGroups, g);
            }
            if (value.hasExplicitSharedMembers != null) {
                g.writeFieldName("has_explicit_shared_members");
                StoneSerializers.nullable(StoneSerializers.boolean_()).serialize(value.hasExplicitSharedMembers, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FileMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FileMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("file".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_name = null;
                String f_pathLower = null;
                String f_pathDisplay = null;
                String f_id = null;
                Date f_clientModified = null;
                Date f_serverModified = null;
                String f_rev = null;
                Long f_size = null;
                String f_parentSharedFolderId = null;
                MediaInfo f_mediaInfo = null;
                FileSharingInfo f_sharingInfo = null;
                List<PropertyGroup> f_propertyGroups = null;
                Boolean f_hasExplicitSharedMembers = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("path_lower".equals(field)) {
                        f_pathLower = StoneSerializers.string().deserialize(p);
                    }
                    else if ("path_display".equals(field)) {
                        f_pathDisplay = StoneSerializers.string().deserialize(p);
                    }
                    else if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("client_modified".equals(field)) {
                        f_clientModified = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("server_modified".equals(field)) {
                        f_serverModified = StoneSerializers.timestamp().deserialize(p);
                    }
                    else if ("rev".equals(field)) {
                        f_rev = StoneSerializers.string().deserialize(p);
                    }
                    else if ("size".equals(field)) {
                        f_size = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("parent_shared_folder_id".equals(field)) {
                        f_parentSharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("media_info".equals(field)) {
                        f_mediaInfo = StoneSerializers.nullable(MediaInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("sharing_info".equals(field)) {
                        f_sharingInfo = StoneSerializers.nullable(FileSharingInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("property_groups".equals(field)) {
                        f_propertyGroups = StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("has_explicit_shared_members".equals(field)) {
                        f_hasExplicitSharedMembers = StoneSerializers.nullable(StoneSerializers.boolean_()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_pathLower == null) {
                    throw new JsonParseException(p, "Required field \"path_lower\" missing.");
                }
                if (f_pathDisplay == null) {
                    throw new JsonParseException(p, "Required field \"path_display\" missing.");
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                if (f_clientModified == null) {
                    throw new JsonParseException(p, "Required field \"client_modified\" missing.");
                }
                if (f_serverModified == null) {
                    throw new JsonParseException(p, "Required field \"server_modified\" missing.");
                }
                if (f_rev == null) {
                    throw new JsonParseException(p, "Required field \"rev\" missing.");
                }
                if (f_size == null) {
                    throw new JsonParseException(p, "Required field \"size\" missing.");
                }
                value = new FileMetadata(f_name, f_pathLower, f_pathDisplay, f_id, f_clientModified, f_serverModified, f_rev, f_size, f_parentSharedFolderId, f_mediaInfo, f_sharingInfo, f_propertyGroups, f_hasExplicitSharedMembers);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
