/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;
import com.dropbox.core.v2.properties.PropertyGroup;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.List;

@JsonSerialize(using=FolderMetadata.Serializer.class)
@JsonDeserialize(using=FolderMetadata.Deserializer.class)
public class FolderMetadata extends Metadata {
    // struct FolderMetadata

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends StructJsonSerializer<FolderMetadata> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(FolderMetadata.class);
        }

        public Serializer(boolean unwrapping) {
            super(FolderMetadata.class, unwrapping);
        }

        @Override
        protected void serializeFields(FolderMetadata value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeStringField(".tag", "folder");
            g.writeObjectField("name", value.name);
            g.writeObjectField("path_lower", value.pathLower);
            g.writeObjectField("path_display", value.pathDisplay);
            g.writeObjectField("id", value.id);
            if (value.parentSharedFolderId != null) {
                g.writeObjectField("parent_shared_folder_id", value.parentSharedFolderId);
            }
            if (value.sharedFolderId != null) {
                g.writeObjectField("shared_folder_id", value.sharedFolderId);
            }
            if (value.sharingInfo != null) {
                g.writeObjectField("sharing_info", value.sharingInfo);
            }
            if (value.propertyGroups != null) {
                g.writeObjectField("property_groups", value.propertyGroups);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<FolderMetadata> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(FolderMetadata.class);
        }

        public Deserializer(boolean unwrapping) {
            super(FolderMetadata.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<FolderMetadata> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public FolderMetadata deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {
            String _subtype_tag = readEnumeratedSubtypeTag(_p, "folder");

            String name = null;
            String pathLower = null;
            String pathDisplay = null;
            String id = null;
            String parentSharedFolderId = null;
            String sharedFolderId = null;
            FolderSharingInfo sharingInfo = null;
            List<PropertyGroup> propertyGroups = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("name".equals(_field)) {
                    name = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("path_lower".equals(_field)) {
                    pathLower = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("path_display".equals(_field)) {
                    pathDisplay = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("id".equals(_field)) {
                    id = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("parent_shared_folder_id".equals(_field)) {
                    parentSharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("shared_folder_id".equals(_field)) {
                    sharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("sharing_info".equals(_field)) {
                    sharingInfo = _p.readValueAs(FolderSharingInfo.class);
                    _p.nextToken();
                }
                else if ("property_groups".equals(_field)) {
                    expectArrayStart(_p);
                    propertyGroups = new java.util.ArrayList<PropertyGroup>();
                    while (!isArrayEnd(_p)) {
                        PropertyGroup _x = null;
                        _x = _p.readValueAs(PropertyGroup.class);
                        _p.nextToken();
                        propertyGroups.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }
            if (pathLower == null) {
                throw new JsonParseException(_p, "Required field \"path_lower\" is missing.");
            }
            if (pathDisplay == null) {
                throw new JsonParseException(_p, "Required field \"path_display\" is missing.");
            }
            if (id == null) {
                throw new JsonParseException(_p, "Required field \"id\" is missing.");
            }

            return new FolderMetadata(name, pathLower, pathDisplay, id, parentSharedFolderId, sharedFolderId, sharingInfo, propertyGroups);
        }
    }
}
