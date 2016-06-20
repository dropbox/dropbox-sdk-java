/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.users.Team;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Properties of the shared file.
 */
public class SharedFileMetadata {
    // struct SharedFileMetadata

    protected final FolderPolicy policy;
    protected final List<FilePermission> permissions;
    protected final Team ownerTeam;
    protected final String parentSharedFolderId;
    protected final String previewUrl;
    protected final String pathLower;
    protected final String pathDisplay;
    protected final String name;
    protected final String id;

    /**
     * Properties of the shared file.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param policy  Policies governing this shared file. Must not be {@code
     *     null}.
     * @param previewUrl  URL for displaying a web preview of the shared file.
     *     Must not be {@code null}.
     * @param name  The name of this file. Must not be {@code null}.
     * @param id  The ID of the file. Must have length of at least 1, match
     *     pattern "{@code id:.*}", and not be {@code null}.
     * @param permissions  The sharing permissions that requesting user has on
     *     this file. This corresponds to the entries given in the {@code
     *     actions} argument to {@link
     *     DbxUserSharingRequests#getFileMetadataBatch(List)} or the {@code
     *     actions} argument to {@link
     *     DbxUserSharingRequests#getFileMetadata(String)}. Must not contain a
     *     {@code null} item.
     * @param ownerTeam  The team that owns the file. This field is not present
     *     if the file is not owned by a team.
     * @param parentSharedFolderId  The ID of the parent shared folder. This
     *     field is present only if the file is contained within a shared
     *     folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param pathLower  The lower-case full path of this file. Absent for
     *     unmounted files.
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Absent for unmounted files.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFileMetadata(FolderPolicy policy, String previewUrl, String name, String id, List<FilePermission> permissions, Team ownerTeam, String parentSharedFolderId, String pathLower, String pathDisplay) {
        if (policy == null) {
            throw new IllegalArgumentException("Required value for 'policy' is null");
        }
        this.policy = policy;
        if (permissions != null) {
            for (FilePermission x : permissions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'permissions' is null");
                }
            }
        }
        this.permissions = permissions;
        this.ownerTeam = ownerTeam;
        if (parentSharedFolderId != null) {
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
        }
        this.parentSharedFolderId = parentSharedFolderId;
        if (previewUrl == null) {
            throw new IllegalArgumentException("Required value for 'previewUrl' is null");
        }
        this.previewUrl = previewUrl;
        this.pathLower = pathLower;
        this.pathDisplay = pathDisplay;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (id.length() < 1) {
            throw new IllegalArgumentException("String 'id' is shorter than 1");
        }
        if (!java.util.regex.Pattern.matches("id:.*", id)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.id = id;
    }

    /**
     * Properties of the shared file.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param policy  Policies governing this shared file. Must not be {@code
     *     null}.
     * @param previewUrl  URL for displaying a web preview of the shared file.
     *     Must not be {@code null}.
     * @param name  The name of this file. Must not be {@code null}.
     * @param id  The ID of the file. Must have length of at least 1, match
     *     pattern "{@code id:.*}", and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFileMetadata(FolderPolicy policy, String previewUrl, String name, String id) {
        this(policy, previewUrl, name, id, null, null, null, null, null);
    }

    /**
     * Policies governing this shared file.
     *
     * @return value for this field, never {@code null}.
     */
    public FolderPolicy getPolicy() {
        return policy;
    }

    /**
     * The sharing permissions that requesting user has on this file. This
     * corresponds to the entries given in the {@code actions} argument to
     * {@link DbxUserSharingRequests#getFileMetadataBatch(List)} or the {@code
     * actions} argument to {@link
     * DbxUserSharingRequests#getFileMetadata(String)}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<FilePermission> getPermissions() {
        return permissions;
    }

    /**
     * The team that owns the file. This field is not present if the file is not
     * owned by a team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Team getOwnerTeam() {
        return ownerTeam;
    }

    /**
     * The ID of the parent shared folder. This field is present only if the
     * file is contained within a shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * URL for displaying a web preview of the shared file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * The lower-case full path of this file. Absent for unmounted files.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPathLower() {
        return pathLower;
    }

    /**
     * The cased path to be used for display purposes only. In rare instances
     * the casing will not correctly match the user's filesystem, but this
     * behavior will match the path provided in the Core API v1. Absent for
     * unmounted files.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getPathDisplay() {
        return pathDisplay;
    }

    /**
     * The name of this file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getName() {
        return name;
    }

    /**
     * The ID of the file.
     *
     * @return value for this field, never {@code null}.
     */
    public String getId() {
        return id;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param policy  Policies governing this shared file. Must not be {@code
     *     null}.
     * @param previewUrl  URL for displaying a web preview of the shared file.
     *     Must not be {@code null}.
     * @param name  The name of this file. Must not be {@code null}.
     * @param id  The ID of the file. Must have length of at least 1, match
     *     pattern "{@code id:.*}", and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(FolderPolicy policy, String previewUrl, String name, String id) {
        return new Builder(policy, previewUrl, name, id);
    }

    /**
     * Builder for {@link SharedFileMetadata}.
     */
    public static class Builder {
        protected final FolderPolicy policy;
        protected final String previewUrl;
        protected final String name;
        protected final String id;

        protected List<FilePermission> permissions;
        protected Team ownerTeam;
        protected String parentSharedFolderId;
        protected String pathLower;
        protected String pathDisplay;

        protected Builder(FolderPolicy policy, String previewUrl, String name, String id) {
            if (policy == null) {
                throw new IllegalArgumentException("Required value for 'policy' is null");
            }
            this.policy = policy;
            if (previewUrl == null) {
                throw new IllegalArgumentException("Required value for 'previewUrl' is null");
            }
            this.previewUrl = previewUrl;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (id == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (id.length() < 1) {
                throw new IllegalArgumentException("String 'id' is shorter than 1");
            }
            if (!java.util.regex.Pattern.matches("id:.*", id)) {
                throw new IllegalArgumentException("String 'id' does not match pattern");
            }
            this.id = id;
            this.permissions = null;
            this.ownerTeam = null;
            this.parentSharedFolderId = null;
            this.pathLower = null;
            this.pathDisplay = null;
        }

        /**
         * Set value for optional field.
         *
         * @param permissions  The sharing permissions that requesting user has
         *     on this file. This corresponds to the entries given in the {@code
         *     actions} argument to {@link
         *     DbxUserSharingRequests#getFileMetadataBatch(List)} or the {@code
         *     actions} argument to {@link
         *     DbxUserSharingRequests#getFileMetadata(String)}. Must not contain
         *     a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPermissions(List<FilePermission> permissions) {
            if (permissions != null) {
                for (FilePermission x : permissions) {
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
         * @param ownerTeam  The team that owns the file. This field is not
         *     present if the file is not owned by a team.
         *
         * @return this builder
         */
        public Builder withOwnerTeam(Team ownerTeam) {
            this.ownerTeam = ownerTeam;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param parentSharedFolderId  The ID of the parent shared folder. This
         *     field is present only if the file is contained within a shared
         *     folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
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
         * @param pathLower  The lower-case full path of this file. Absent for
         *     unmounted files.
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
         * @param pathDisplay  The cased path to be used for display purposes
         *     only. In rare instances the casing will not correctly match the
         *     user's filesystem, but this behavior will match the path provided
         *     in the Core API v1. Absent for unmounted files.
         *
         * @return this builder
         */
        public Builder withPathDisplay(String pathDisplay) {
            this.pathDisplay = pathDisplay;
            return this;
        }

        /**
         * Builds an instance of {@link SharedFileMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link SharedFileMetadata}
         */
        public SharedFileMetadata build() {
            return new SharedFileMetadata(policy, previewUrl, name, id, permissions, ownerTeam, parentSharedFolderId, pathLower, pathDisplay);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            policy,
            permissions,
            ownerTeam,
            parentSharedFolderId,
            previewUrl,
            pathLower,
            pathDisplay,
            name,
            id
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
            SharedFileMetadata other = (SharedFileMetadata) obj;
            return ((this.policy == other.policy) || (this.policy.equals(other.policy)))
                && ((this.previewUrl == other.previewUrl) || (this.previewUrl.equals(other.previewUrl)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.permissions == other.permissions) || (this.permissions != null && this.permissions.equals(other.permissions)))
                && ((this.ownerTeam == other.ownerTeam) || (this.ownerTeam != null && this.ownerTeam.equals(other.ownerTeam)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.pathDisplay == other.pathDisplay) || (this.pathDisplay != null && this.pathDisplay.equals(other.pathDisplay)))
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
    static final class Serializer extends StructSerializer<SharedFileMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFileMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("policy");
            FolderPolicy.Serializer.INSTANCE.serialize(value.policy, g);
            g.writeFieldName("preview_url");
            StoneSerializers.string().serialize(value.previewUrl, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            if (value.permissions != null) {
                g.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(FilePermission.Serializer.INSTANCE)).serialize(value.permissions, g);
            }
            if (value.ownerTeam != null) {
                g.writeFieldName("owner_team");
                StoneSerializers.nullable(Team.Serializer.INSTANCE).serialize(value.ownerTeam, g);
            }
            if (value.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentSharedFolderId, g);
            }
            if (value.pathLower != null) {
                g.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathLower, g);
            }
            if (value.pathDisplay != null) {
                g.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathDisplay, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedFileMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedFileMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                FolderPolicy f_policy = null;
                String f_previewUrl = null;
                String f_name = null;
                String f_id = null;
                List<FilePermission> f_permissions = null;
                Team f_ownerTeam = null;
                String f_parentSharedFolderId = null;
                String f_pathLower = null;
                String f_pathDisplay = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("policy".equals(field)) {
                        f_policy = FolderPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("preview_url".equals(field)) {
                        f_previewUrl = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("permissions".equals(field)) {
                        f_permissions = StoneSerializers.nullable(StoneSerializers.list(FilePermission.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("owner_team".equals(field)) {
                        f_ownerTeam = StoneSerializers.nullable(Team.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("parent_shared_folder_id".equals(field)) {
                        f_parentSharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("path_lower".equals(field)) {
                        f_pathLower = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("path_display".equals(field)) {
                        f_pathDisplay = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_policy == null) {
                    throw new JsonParseException(p, "Required field \"policy\" missing.");
                }
                if (f_previewUrl == null) {
                    throw new JsonParseException(p, "Required field \"preview_url\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                value = new SharedFileMetadata(f_policy, f_previewUrl, f_name, f_id, f_permissions, f_ownerTeam, f_parentSharedFolderId, f_pathLower, f_pathDisplay);
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
