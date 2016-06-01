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
import java.util.List;

public class FolderMetadata extends Metadata {
    // struct FolderMetadata

    protected final String id;
    protected final String sharedFolderId;
    protected final FolderSharingInfo sharingInfo;
    protected final List<PropertyGroup> propertyGroups;

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
     * @param id  A unique identifier for the folder. Must have length of at
     *     least 1 and not be {@code null}.
     * @param parentSharedFolderId  Deprecated. Please use {@link
     *     FileSharingInfo#getParentSharedFolderId} or {@link
     *     FolderSharingInfo#getParentSharedFolderId} instead. Must match
     *     pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param sharedFolderId  Deprecated. Please use {@link
     *     FolderMetadata#getSharingInfo} instead. Must match pattern "{@code
     *     [-_0-9a-zA-Z:]+}".
     * @param sharingInfo  Set if the folder is contained in a shared folder or
     *     is a shared folder mount point.
     * @param propertyGroups  Additional information if the file has custom
     *     properties with the property template specified. Must not contain a
     *     {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderMetadata(String name, String pathLower, String pathDisplay, String id, String parentSharedFolderId, String sharedFolderId, FolderSharingInfo sharingInfo, List<PropertyGroup> propertyGroups) {
        super(name, pathLower, pathDisplay, parentSharedFolderId);
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
     * @param id  A unique identifier for the folder. Must have length of at
     *     least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderMetadata(String name, String pathLower, String pathDisplay, String id) {
        this(name, pathLower, pathDisplay, id, null, null, null, null);
    }

    /**
     * A unique identifier for the folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getId() {
        return id;
    }

    /**
     * Deprecated. Please use {@link FolderMetadata#getSharingInfo} instead.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * Set if the folder is contained in a shared folder or is a shared folder
     * mount point.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public FolderSharingInfo getSharingInfo() {
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
     * @param id  A unique identifier for the folder. Must have length of at
     *     least 1 and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name, String pathLower, String pathDisplay, String id) {
        return new Builder(name, pathLower, pathDisplay, id);
    }

    /**
     * Builder for {@link FolderMetadata}.
     */
    public static class Builder {
        protected final String name;
        protected final String pathLower;
        protected final String pathDisplay;
        protected final String id;

        protected String parentSharedFolderId;
        protected String sharedFolderId;
        protected FolderSharingInfo sharingInfo;
        protected List<PropertyGroup> propertyGroups;

        protected Builder(String name, String pathLower, String pathDisplay, String id) {
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
            this.parentSharedFolderId = null;
            this.sharedFolderId = null;
            this.sharingInfo = null;
            this.propertyGroups = null;
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
         * @param sharedFolderId  Deprecated. Please use {@link
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
         * Builds an instance of {@link FolderMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link FolderMetadata}
         */
        public FolderMetadata build() {
            return new FolderMetadata(name, pathLower, pathDisplay, id, parentSharedFolderId, sharedFolderId, sharingInfo, propertyGroups);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            id,
            sharedFolderId,
            sharingInfo,
            propertyGroups
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
            FolderMetadata other = (FolderMetadata) obj;
            return ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.pathLower == other.pathLower) || (this.pathLower.equals(other.pathLower)))
                && ((this.pathDisplay == other.pathDisplay) || (this.pathDisplay.equals(other.pathDisplay)))
                && ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
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
    static final class Serializer extends StructSerializer<FolderMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(FolderMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            writeTag("folder", g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("path_lower");
            StoneSerializers.string().serialize(value.pathLower, g);
            g.writeFieldName("path_display");
            StoneSerializers.string().serialize(value.pathDisplay, g);
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            if (value.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentSharedFolderId, g);
            }
            if (value.sharedFolderId != null) {
                g.writeFieldName("shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.sharedFolderId, g);
            }
            if (value.sharingInfo != null) {
                g.writeFieldName("sharing_info");
                StoneSerializers.nullable(FolderSharingInfo.Serializer.INSTANCE).serialize(value.sharingInfo, g);
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
                String f_pathLower = null;
                String f_pathDisplay = null;
                String f_id = null;
                String f_parentSharedFolderId = null;
                String f_sharedFolderId = null;
                FolderSharingInfo f_sharingInfo = null;
                List<PropertyGroup> f_propertyGroups = null;
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
                    else if ("parent_shared_folder_id".equals(field)) {
                        f_parentSharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("sharing_info".equals(field)) {
                        f_sharingInfo = StoneSerializers.nullable(FolderSharingInfo.Serializer.INSTANCE).deserialize(p);
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
                if (f_pathLower == null) {
                    throw new JsonParseException(p, "Required field \"path_lower\" missing.");
                }
                if (f_pathDisplay == null) {
                    throw new JsonParseException(p, "Required field \"path_display\" missing.");
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                value = new FolderMetadata(f_name, f_pathLower, f_pathDisplay, f_id, f_parentSharedFolderId, f_sharedFolderId, f_sharingInfo, f_propertyGroups);
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
