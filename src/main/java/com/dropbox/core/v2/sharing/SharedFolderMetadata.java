/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

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

/**
 * The metadata which includes basic information about the shared folder.
 */
@JsonSerialize(using=SharedFolderMetadata.Serializer.class)
@JsonDeserialize(using=SharedFolderMetadata.Deserializer.class)
public class SharedFolderMetadata extends SharedFolderMetadataBase {
    // struct SharedFolderMetadata

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String pathLower;
    protected final String name;
    protected final String sharedFolderId;

    /**
     * The metadata which includes basic information about the shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     * @param policy  Policies governing this shared folder. Must not be {@code
     *     null}.
     * @param name  The name of the this shared folder. Must not be {@code
     *     null}.
     * @param sharedFolderId  The ID of the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param permissions  Actions the current user may perform on the folder
     *     and its contents. The set of permissions corresponds to the
     *     FolderActions in the request. Must not contain a {@code null} item.
     * @param pathLower  The lower-cased full path of this shared folder. Absent
     *     for unmounted folders.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String name, String sharedFolderId, List<FolderPermission> permissions, String pathLower) {
        super(accessType, isTeamFolder, policy, permissions);
        this.pathLower = pathLower;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
    }

    /**
     * The metadata which includes basic information about the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     * @param policy  Policies governing this shared folder. Must not be {@code
     *     null}.
     * @param name  The name of the this shared folder. Must not be {@code
     *     null}.
     * @param sharedFolderId  The ID of the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String name, String sharedFolderId) {
        this(accessType, isTeamFolder, policy, name, sharedFolderId, null, null);
    }

    /**
     * The lower-cased full path of this shared folder. Absent for unmounted
     * folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPathLower() {
        return pathLower;
    }

    /**
     * The name of the this shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     * The ID of the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     * @param policy  Policies governing this shared folder. Must not be {@code
     *     null}.
     * @param name  The name of the this shared folder. Must not be {@code
     *     null}.
     * @param sharedFolderId  The ID of the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String name, String sharedFolderId) {
        return new Builder(accessType, isTeamFolder, policy, name, sharedFolderId);
    }

    /**
     * Builder for {@link SharedFolderMetadata}.
     */
    public static class Builder {
        protected final AccessLevel accessType;
        protected final boolean isTeamFolder;
        protected final FolderPolicy policy;
        protected final String name;
        protected final String sharedFolderId;

        protected List<FolderPermission> permissions;
        protected String pathLower;

        protected Builder(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String name, String sharedFolderId) {
            if (accessType == null) {
                throw new IllegalArgumentException("Required value for 'accessType' is null");
            }
            this.accessType = accessType;
            this.isTeamFolder = isTeamFolder;
            if (policy == null) {
                throw new IllegalArgumentException("Required value for 'policy' is null");
            }
            this.policy = policy;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = sharedFolderId;
            this.permissions = null;
            this.pathLower = null;
        }

        /**
         * Set value for optional field.
         *
         * @param permissions  Actions the current user may perform on the
         *     folder and its contents. The set of permissions corresponds to
         *     the FolderActions in the request. Must not contain a {@code null}
         *     item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPermissions(List<FolderPermission> permissions) {
            if (permissions != null) {
                for (FolderPermission x : permissions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'permissions' is null");
                    }
                }
            }
            this.permissions = permissions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param pathLower  The lower-cased full path of this shared folder.
         *     Absent for unmounted folders.
         *
         * @return this builder
         */
        public Builder withPathLower(String pathLower) {
            this.pathLower = pathLower;
            return this;
        }

        /**
         * Builds an instance of {@link SharedFolderMetadata} configured with
         * this builder's values
         *
         * @return new instance of {@link SharedFolderMetadata}
         */
        public SharedFolderMetadata build() {
            return new SharedFolderMetadata(accessType, isTeamFolder, policy, name, sharedFolderId, permissions, pathLower);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            pathLower,
            name,
            sharedFolderId
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
            SharedFolderMetadata other = (SharedFolderMetadata) obj;
            return ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
                && (this.isTeamFolder == other.isTeamFolder)
                && ((this.policy == other.policy) || (this.policy.equals(other.policy)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.permissions == other.permissions) || (this.permissions != null && this.permissions.equals(other.permissions)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
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

    static final class Serializer extends StructJsonSerializer<SharedFolderMetadata> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedFolderMetadata.class);
        }

        public Serializer(boolean unwrapping) {
            super(SharedFolderMetadata.class, unwrapping);
        }

        @Override
        protected JsonSerializer<SharedFolderMetadata> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(SharedFolderMetadata value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("access_type", value.accessType);
            g.writeObjectField("is_team_folder", value.isTeamFolder);
            g.writeObjectField("policy", value.policy);
            g.writeObjectField("name", value.name);
            g.writeObjectField("shared_folder_id", value.sharedFolderId);
            if (value.permissions != null) {
                g.writeObjectField("permissions", value.permissions);
            }
            if (value.pathLower != null) {
                g.writeObjectField("path_lower", value.pathLower);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<SharedFolderMetadata> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedFolderMetadata.class);
        }

        public Deserializer(boolean unwrapping) {
            super(SharedFolderMetadata.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<SharedFolderMetadata> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public SharedFolderMetadata deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            AccessLevel accessType = null;
            Boolean isTeamFolder = null;
            FolderPolicy policy = null;
            String name = null;
            String sharedFolderId = null;
            List<FolderPermission> permissions = null;
            String pathLower = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("access_type".equals(_field)) {
                    accessType = _p.readValueAs(AccessLevel.class);
                    _p.nextToken();
                }
                else if ("is_team_folder".equals(_field)) {
                    isTeamFolder = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("policy".equals(_field)) {
                    policy = _p.readValueAs(FolderPolicy.class);
                    _p.nextToken();
                }
                else if ("name".equals(_field)) {
                    name = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("shared_folder_id".equals(_field)) {
                    sharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("permissions".equals(_field)) {
                    expectArrayStart(_p);
                    permissions = new java.util.ArrayList<FolderPermission>();
                    while (!isArrayEnd(_p)) {
                        FolderPermission _x = null;
                        _x = _p.readValueAs(FolderPermission.class);
                        _p.nextToken();
                        permissions.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("path_lower".equals(_field)) {
                    pathLower = getStringValue(_p);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (accessType == null) {
                throw new JsonParseException(_p, "Required field \"access_type\" is missing.");
            }
            if (isTeamFolder == null) {
                throw new JsonParseException(_p, "Required field \"is_team_folder\" is missing.");
            }
            if (policy == null) {
                throw new JsonParseException(_p, "Required field \"policy\" is missing.");
            }
            if (name == null) {
                throw new JsonParseException(_p, "Required field \"name\" is missing.");
            }
            if (sharedFolderId == null) {
                throw new JsonParseException(_p, "Required field \"shared_folder_id\" is missing.");
            }

            return new SharedFolderMetadata(accessType, isTeamFolder, policy, name, sharedFolderId, permissions, pathLower);
        }
    }
}
