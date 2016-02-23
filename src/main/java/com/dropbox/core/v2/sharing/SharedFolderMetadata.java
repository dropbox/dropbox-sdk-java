/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * The metadata which includes basic information about the shared folder.
 */
public class SharedFolderMetadata {
    // struct SharedFolderMetadata

    private final String pathLower;
    private final String name;
    private final String sharedFolderId;
    private final AccessLevel accessType;
    private final boolean isTeamFolder;
    private final FolderPolicy policy;
    private final List<FolderPermission> permissions;

    /**
     * The metadata which includes basic information about the shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param name  The name of the this shared folder. Must not be {@code
     *     null}.
     * @param sharedFolderId  The ID of the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     * @param policy  Policies governing this shared folder. Must not be {@code
     *     null}.
     * @param pathLower  The lower-cased full path of this shared folder. Absent
     *     for unmounted folders.
     * @param permissions  Actions the current user may perform on the folder
     *     and its contents. The set of permissions corresponds to the
     *     MemberActions in the request. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata(String name, String sharedFolderId, AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String pathLower, List<FolderPermission> permissions) {
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
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
        this.isTeamFolder = isTeamFolder;
        if (policy == null) {
            throw new IllegalArgumentException("Required value for 'policy' is null");
        }
        this.policy = policy;
        if (permissions != null) {
            for (FolderPermission x : permissions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'permissions' is null");
                }
            }
        }
        this.permissions = permissions;
    }

    /**
     * The metadata which includes basic information about the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param name  The name of the this shared folder. Must not be {@code
     *     null}.
     * @param sharedFolderId  The ID of the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     * @param policy  Policies governing this shared folder. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata(String name, String sharedFolderId, AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy) {
        this(name, sharedFolderId, accessType, isTeamFolder, policy, null, null);
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
     * The current user's access level for this shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public AccessLevel getAccessType() {
        return accessType;
    }

    /**
     * Whether this folder is a &lt;a
     * href="https://www.dropbox.com/en/help/986"&gt;team folder&lt;/a&gt;.
     *
     * @return value for this field.
     */
    public boolean getIsTeamFolder() {
        return isTeamFolder;
    }

    /**
     * Policies governing this shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public FolderPolicy getPolicy() {
        return policy;
    }

    /**
     * Actions the current user may perform on the folder and its contents. The
     * set of permissions corresponds to the MemberActions in the request.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<FolderPermission> getPermissions() {
        return permissions;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param name  The name of the this shared folder. Must not be {@code
     *     null}.
     * @param sharedFolderId  The ID of the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     * @param policy  Policies governing this shared folder. Must not be {@code
     *     null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String name, String sharedFolderId, AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy) {
        return new Builder(name, sharedFolderId, accessType, isTeamFolder, policy);
    }

    /**
     * Builder for {@link SharedFolderMetadata}.
     */
    public static class Builder {
        protected final String name;
        protected final String sharedFolderId;
        protected final AccessLevel accessType;
        protected final boolean isTeamFolder;
        protected final FolderPolicy policy;

        protected String pathLower;
        protected List<FolderPermission> permissions;

        protected Builder(String name, String sharedFolderId, AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy) {
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
            if (accessType == null) {
                throw new IllegalArgumentException("Required value for 'accessType' is null");
            }
            this.accessType = accessType;
            this.isTeamFolder = isTeamFolder;
            if (policy == null) {
                throw new IllegalArgumentException("Required value for 'policy' is null");
            }
            this.policy = policy;
            this.pathLower = null;
            this.permissions = null;
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
         * Set value for optional field.
         *
         * @param permissions  Actions the current user may perform on the
         *     folder and its contents. The set of permissions corresponds to
         *     the MemberActions in the request. Must not contain a {@code null}
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
         * Builds an instance of {@link SharedFolderMetadata} configured with
         * this builder's values
         *
         * @return new instance of {@link SharedFolderMetadata}
         */
        public SharedFolderMetadata build() {
            return new SharedFolderMetadata(name, sharedFolderId, accessType, isTeamFolder, policy, pathLower, permissions);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            pathLower,
            name,
            sharedFolderId,
            accessType,
            isTeamFolder,
            policy,
            permissions
        });
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
            return ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
                && (this.isTeamFolder == other.isTeamFolder)
                && ((this.policy == other.policy) || (this.policy.equals(other.policy)))
                && ((this.permissions == other.permissions) || (this.permissions != null && this.permissions.equals(other.permissions)))
                ;
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

    public static SharedFolderMetadata fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedFolderMetadata> _JSON_WRITER = new JsonWriter<SharedFolderMetadata>() {
        public final void write(SharedFolderMetadata x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SharedFolderMetadata._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(SharedFolderMetadata x, JsonGenerator g) throws IOException {
            if (x.pathLower != null) {
                g.writeFieldName("path_lower");
                g.writeString(x.pathLower);
            }
            g.writeFieldName("name");
            g.writeString(x.name);
            g.writeFieldName("shared_folder_id");
            g.writeString(x.sharedFolderId);
            g.writeFieldName("access_type");
            AccessLevel._JSON_WRITER.write(x.accessType, g);
            g.writeFieldName("is_team_folder");
            g.writeBoolean(x.isTeamFolder);
            g.writeFieldName("policy");
            FolderPolicy._JSON_WRITER.write(x.policy, g);
            if (x.permissions != null) {
                g.writeFieldName("permissions");
                g.writeStartArray();
                for (FolderPermission item: x.permissions) {
                    if (item != null) {
                        FolderPermission._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
        }
    };

    public static final JsonReader<SharedFolderMetadata> _JSON_READER = new JsonReader<SharedFolderMetadata>() {
        public final SharedFolderMetadata read(JsonParser parser) throws IOException, JsonReadException {
            SharedFolderMetadata result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final SharedFolderMetadata readFields(JsonParser parser) throws IOException, JsonReadException {
            String name = null;
            String sharedFolderId = null;
            AccessLevel accessType = null;
            Boolean isTeamFolder = null;
            FolderPolicy policy = null;
            String pathLower = null;
            List<FolderPermission> permissions = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("name".equals(fieldName)) {
                    name = JsonReader.StringReader
                        .readField(parser, "name", name);
                }
                else if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else if ("access_type".equals(fieldName)) {
                    accessType = AccessLevel._JSON_READER
                        .readField(parser, "access_type", accessType);
                }
                else if ("is_team_folder".equals(fieldName)) {
                    isTeamFolder = JsonReader.BooleanReader
                        .readField(parser, "is_team_folder", isTeamFolder);
                }
                else if ("policy".equals(fieldName)) {
                    policy = FolderPolicy._JSON_READER
                        .readField(parser, "policy", policy);
                }
                else if ("path_lower".equals(fieldName)) {
                    pathLower = JsonReader.StringReader
                        .readField(parser, "path_lower", pathLower);
                }
                else if ("permissions".equals(fieldName)) {
                    permissions = JsonArrayReader.mk(FolderPermission._JSON_READER)
                        .readField(parser, "permissions", permissions);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (name == null) {
                throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
            }
            if (sharedFolderId == null) {
                throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
            }
            if (accessType == null) {
                throw new JsonReadException("Required field \"access_type\" is missing.", parser.getTokenLocation());
            }
            if (isTeamFolder == null) {
                throw new JsonReadException("Required field \"is_team_folder\" is missing.", parser.getTokenLocation());
            }
            if (policy == null) {
                throw new JsonReadException("Required field \"policy\" is missing.", parser.getTokenLocation());
            }
            return new SharedFolderMetadata(name, sharedFolderId, accessType, isTeamFolder, policy, pathLower, permissions);
        }
    };
}
