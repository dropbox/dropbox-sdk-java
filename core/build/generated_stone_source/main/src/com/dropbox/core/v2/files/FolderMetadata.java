/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.fileproperties.PropertyGroup;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class FolderMetadata extends Metadata {
    // struct files.FolderMetadata (files.stone)

    @Nonnull
    protected final String id;
    @Nullable
    protected final String sharedFolderId;
    @Nullable
    protected final FolderSharingInfo sharingInfo;
    @Nullable
    protected final List<PropertyGroup> propertyGroups;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param id  A unique identifier for the folder. Must have length of at
     *     least 1 and not be {@code null}.
     * @param pathLower  The lowercased full path in the user's Dropbox. This
     *     always starts with a slash. This field will be null if the file or
     *     folder is not mounted.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1, and at least the last path component will have the
     *     correct casing. Changes to only the casing of paths won't be returned
     *     by {@link DbxAppFilesRequests#listFolderContinue(String)}. This field
     *     will be null if the file or folder is not mounted.
     * @param parentSharedFolderId  Please use {@link
     *     FileSharingInfo#getParentSharedFolderId} or {@link
     *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
     *     pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param previewUrl  The preview URL of the file.
     * @param sharedFolderId  Please use {@link FolderMetadata#getSharingInfo}
     *     instead. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param sharingInfo  Set if the folder is contained in a shared folder or
     *     is a shared folder mount point.
     * @param propertyGroups  Additional information if the file has custom
     *     properties with the property template specified. Note that only
     *     properties associated with user-owned templates, not team-owned
     *     templates, can be attached to folders. Must not contain a {@code
     *     null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderMetadata(@Nonnull String name, @Nonnull String id, @Nullable String pathLower, @Nullable String pathDisplay, @Nullable String parentSharedFolderId, @Nullable String previewUrl, @Nullable String sharedFolderId, @Nullable FolderSharingInfo sharingInfo, @Nullable List<PropertyGroup> propertyGroups) {
        super(name, pathLower, pathDisplay, parentSharedFolderId, previewUrl);
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (id.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        this.id = id;
        if (sharedFolderId != null) {
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
        }
        this.sharedFolderId = sharedFolderId;
        this.sharingInfo = sharingInfo;
        if (propertyGroups != null) {
            for (PropertyGroup x : propertyGroups) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'propertyGroups' is null");
                }
            }
        }
        this.propertyGroups = propertyGroups;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param id  A unique identifier for the folder. Must have length of at
     *     least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderMetadata(@Nonnull String name, @Nonnull String id) {
        this(name, id, null, null, null, null, null, null, null);
    }

    /**
     * The last component of the path (including extension). This never contains
     * a slash.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * A unique identifier for the folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getId() {
        return id;
    }

    /**
     * The lowercased full path in the user's Dropbox. This always starts with a
     * slash. This field will be null if the file or folder is not mounted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPathLower() {
        return pathLower;
    }

    /**
     * The cased path to be used for display purposes only. In rare instances
     * the casing will not correctly match the user's filesystem, but this
     * behavior will match the path provided in the Core API v1, and at least
     * the last path component will have the correct casing. Changes to only the
     * casing of paths won't be returned by {@link
     * DbxAppFilesRequests#listFolderContinue(String)}. This field will be null
     * if the file or folder is not mounted.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPathDisplay() {
        return pathDisplay;
    }

    /**
     * Please use {@link FileSharingInfo#getParentSharedFolderId} or {@link
     * FolderSharingInfo#getParentSharedFolderId} instead.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * The preview URL of the file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * Please use {@link FolderMetadata#getSharingInfo} instead.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * Set if the folder is contained in a shared folder or is a shared folder
     * mount point.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public FolderSharingInfo getSharingInfo() {
        return sharingInfo;
    }

    /**
     * Additional information if the file has custom properties with the
     * property template specified. Note that only properties associated with
     * user-owned templates, not team-owned templates, can be attached to
     * folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<PropertyGroup> getPropertyGroups() {
        return propertyGroups;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  The last component of the path (including extension). This
     *     never contains a slash. Must not be {@code null}.
     * @param id  A unique identifier for the folder. Must have length of at
     *     least 1 and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name, String id) {
        return new Builder(name, id);
    }

    /**
     * Builder for {@link FolderMetadata}.
     */
    public static class Builder extends Metadata.Builder {
        protected final String id;

        protected String sharedFolderId;
        protected FolderSharingInfo sharingInfo;
        protected List<PropertyGroup> propertyGroups;

        protected Builder(String name, String id) {
            super(name);
            if (id == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (id.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            this.id = id;
            this.sharedFolderId = null;
            this.sharingInfo = null;
            this.propertyGroups = null;
        }

        /**
         * Set value for optional field.
         *
         * @param sharedFolderId  Please use {@link
         *     FolderMetadata#getSharingInfo} instead. Must match pattern
         *     "{@code [-_0-9a-zA-Z:]+}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withSharedFolderId(String sharedFolderId) {
            if (sharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                    throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
                }
            }
            this.sharedFolderId = sharedFolderId;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param sharingInfo  Set if the folder is contained in a shared folder
         *     or is a shared folder mount point.
         *
         * @return this builder
         */
        public Builder withSharingInfo(FolderSharingInfo sharingInfo) {
            this.sharingInfo = sharingInfo;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param propertyGroups  Additional information if the file has custom
         *     properties with the property template specified. Note that only
         *     properties associated with user-owned templates, not team-owned
         *     templates, can be attached to folders. Must not contain a {@code
         *     null} item.
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
         * @param pathLower  The lowercased full path in the user's Dropbox.
         *     This always starts with a slash. This field will be null if the
         *     file or folder is not mounted.
         *
         * @return this builder
         */
        public Builder withPathLower(String pathLower) {
            super.withPathLower(pathLower);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param pathDisplay  The cased path to be used for display purposes
         *     only. In rare instances the casing will not correctly match the
         *     user's filesystem, but this behavior will match the path provided
         *     in the Core API v1, and at least the last path component will
         *     have the correct casing. Changes to only the casing of paths
         *     won't be returned by {@link
         *     DbxAppFilesRequests#listFolderContinue(String)}. This field will
         *     be null if the file or folder is not mounted.
         *
         * @return this builder
         */
        public Builder withPathDisplay(String pathDisplay) {
            super.withPathDisplay(pathDisplay);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param parentSharedFolderId  Please use {@link
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
            super.withParentSharedFolderId(parentSharedFolderId);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param previewUrl  The preview URL of the file.
         *
         * @return this builder
         */
        public Builder withPreviewUrl(String previewUrl) {
            super.withPreviewUrl(previewUrl);
            return this;
        }

        /**
         * Builds an instance of {@link FolderMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link FolderMetadata}
         */
        public FolderMetadata build() {
            return new FolderMetadata(name, id, pathLower, pathDisplay, parentSharedFolderId, previewUrl, sharedFolderId, sharingInfo, propertyGroups);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            this.id,
            this.sharedFolderId,
            this.sharingInfo,
            this.propertyGroups
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
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            FolderMetadata other = (FolderMetadata) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.pathDisplay == other.pathDisplay) || (this.pathDisplay != null && this.pathDisplay.equals(other.pathDisplay)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.previewUrl == other.previewUrl) || (this.previewUrl != null && this.previewUrl.equals(other.previewUrl)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId != null && this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.sharingInfo == other.sharingInfo) || (this.sharingInfo != null && this.sharingInfo.equals(other.sharingInfo)))
                && ((this.propertyGroups == other.propertyGroups) || (this.propertyGroups != null && this.propertyGroups.equals(other.propertyGroups)))
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
    static class Serializer extends StructSerializer<FolderMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("folder", g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            if (value.pathLower != null) {
                g.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathLower, g);
            }
            if (value.pathDisplay != null) {
                g.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathDisplay, g);
            }
            if (value.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentSharedFolderId, g);
            }
            if (value.previewUrl != null) {
                g.writeFieldName("preview_url");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.previewUrl, g);
            }
            if (value.sharedFolderId != null) {
                g.writeFieldName("shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharedFolderId, g);
            }
            if (value.sharingInfo != null) {
                g.writeFieldName("sharing_info");
                StoneSerializers.nullableStruct(FolderSharingInfo.Serializer.INSTANCE).serialize(value.sharingInfo, g);
            }
            if (value.propertyGroups != null) {
                g.writeFieldName("property_groups");
                StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).serialize(value.propertyGroups, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public FolderMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            FolderMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
                if ("folder".equals(tag)) {
                    tag = null;
                }
            }
            if (tag == null) {
                String f_name = null;
                String f_id = null;
                String f_pathLower = null;
                String f_pathDisplay = null;
                String f_parentSharedFolderId = null;
                String f_previewUrl = null;
                String f_sharedFolderId = null;
                FolderSharingInfo f_sharingInfo = null;
                List<PropertyGroup> f_propertyGroups = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("path_lower".equals(field)) {
                        f_pathLower = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("path_display".equals(field)) {
                        f_pathDisplay = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("parent_shared_folder_id".equals(field)) {
                        f_parentSharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("preview_url".equals(field)) {
                        f_previewUrl = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("sharing_info".equals(field)) {
                        f_sharingInfo = StoneSerializers.nullableStruct(FolderSharingInfo.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("property_groups".equals(field)) {
                        f_propertyGroups = StoneSerializers.nullable(StoneSerializers.list(PropertyGroup.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                value = new FolderMetadata(f_name, f_id, f_pathLower, f_pathDisplay, f_parentSharedFolderId, f_previewUrl, f_sharedFolderId, f_sharingInfo, f_propertyGroups);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
