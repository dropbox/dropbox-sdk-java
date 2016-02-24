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
public class SharedFolderMetadata extends SharedFolderMetadataBase {
    // struct SharedFolderMetadata

    private final String pathLower;
    private final String name;
    private final String sharedFolderId;

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
            return ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.getAccessType() == other.getAccessType()) || (this.getAccessType().equals(other.getAccessType())))
                && (this.getIsTeamFolder() == other.getIsTeamFolder())
                && ((this.getPolicy() == other.getPolicy()) || (this.getPolicy().equals(other.getPolicy())))
                && ((this.getPermissions() == other.getPermissions()) || (this.getPermissions() != null && this.getPermissions().equals(other.getPermissions())))
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
            SharedFolderMetadataBase._JSON_WRITER.writeFields(x, g);
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
            AccessLevel accessType = null;
            Boolean isTeamFolder = null;
            FolderPolicy policy = null;
            String name = null;
            String sharedFolderId = null;
            List<FolderPermission> permissions = null;
            String pathLower = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("access_type".equals(fieldName)) {
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
                else if ("name".equals(fieldName)) {
                    name = JsonReader.StringReader
                        .readField(parser, "name", name);
                }
                else if ("shared_folder_id".equals(fieldName)) {
                    sharedFolderId = JsonReader.StringReader
                        .readField(parser, "shared_folder_id", sharedFolderId);
                }
                else if ("permissions".equals(fieldName)) {
                    permissions = JsonArrayReader.mk(FolderPermission._JSON_READER)
                        .readField(parser, "permissions", permissions);
                }
                else if ("path_lower".equals(fieldName)) {
                    pathLower = JsonReader.StringReader
                        .readField(parser, "path_lower", pathLower);
                }
                else {
                    JsonReader.skipValue(parser);
                }
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
            if (name == null) {
                throw new JsonReadException("Required field \"name\" is missing.", parser.getTokenLocation());
            }
            if (sharedFolderId == null) {
                throw new JsonReadException("Required field \"shared_folder_id\" is missing.", parser.getTokenLocation());
            }
            return new SharedFolderMetadata(accessType, isTeamFolder, policy, name, sharedFolderId, permissions, pathLower);
        }
    };
}
