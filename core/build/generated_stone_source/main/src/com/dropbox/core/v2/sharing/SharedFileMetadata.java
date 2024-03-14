/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.users.Team;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Properties of the shared file.
 */
public class SharedFileMetadata {
    // struct sharing.SharedFileMetadata (sharing_files.stone)

    protected final AccessLevel accessType;
    protected final String id;
    protected final ExpectedSharedContentLinkMetadata expectedLinkMetadata;
    protected final SharedContentLinkMetadata linkMetadata;
    protected final String name;
    protected final List<String> ownerDisplayNames;
    protected final Team ownerTeam;
    protected final String parentSharedFolderId;
    protected final String pathDisplay;
    protected final String pathLower;
    protected final List<FilePermission> permissions;
    protected final FolderPolicy policy;
    protected final String previewUrl;
    protected final Date timeInvited;

    /**
     * Properties of the shared file.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param id  The ID of the file. Must have length of at least 4, match
     *     pattern "{@code id:.+}", and not be {@code null}.
     * @param name  The name of this file. Must not be {@code null}.
     * @param policy  Policies governing this shared file. Must not be {@code
     *     null}.
     * @param previewUrl  URL for displaying a web preview of the shared file.
     *     Must not be {@code null}.
     * @param accessType  The current user's access level for this shared file.
     * @param expectedLinkMetadata  The expected metadata of the link associated
     *     for the file when it is first shared. Absent if the link already
     *     exists. This is for an unreleased feature so it may not be returned
     *     yet.
     * @param linkMetadata  The metadata of the link associated for the file.
     *     This is for an unreleased feature so it may not be returned yet.
     * @param ownerDisplayNames  The display names of the users that own the
     *     file. If the file is part of a team folder, the display names of the
     *     team admins are also included. Absent if the owner display names
     *     cannot be fetched. Must not contain a {@code null} item.
     * @param ownerTeam  The team that owns the file. This field is not present
     *     if the file is not owned by a team.
     * @param parentSharedFolderId  The ID of the parent shared folder. This
     *     field is present only if the file is contained within a shared
     *     folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param pathDisplay  The cased path to be used for display purposes only.
     *     In rare instances the casing will not correctly match the user's
     *     filesystem, but this behavior will match the path provided in the
     *     Core API v1. Absent for unmounted files.
     * @param pathLower  The lower-case full path of this file. Absent for
     *     unmounted files.
     * @param permissions  The sharing permissions that requesting user has on
     *     this file. This corresponds to the entries given in the {@code
     *     actions} argument to {@link
     *     DbxUserSharingRequests#getFileMetadataBatch(List,List)} or the {@code
     *     actions} argument to {@link
     *     DbxUserSharingRequests#getFileMetadata(String,List)}. Must not
     *     contain a {@code null} item.
     * @param timeInvited  Timestamp indicating when the current user was
     *     invited to this shared file. If the user was not invited to the
     *     shared file, the timestamp will indicate when the user was invited to
     *     the parent shared folder. This value may be absent.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFileMetadata(@javax.annotation.Nonnull String id, @javax.annotation.Nonnull String name, @javax.annotation.Nonnull FolderPolicy policy, @javax.annotation.Nonnull String previewUrl, @javax.annotation.Nullable AccessLevel accessType, @javax.annotation.Nullable ExpectedSharedContentLinkMetadata expectedLinkMetadata, @javax.annotation.Nullable SharedContentLinkMetadata linkMetadata, @javax.annotation.Nullable List<String> ownerDisplayNames, @javax.annotation.Nullable Team ownerTeam, @javax.annotation.Nullable String parentSharedFolderId, @javax.annotation.Nullable String pathDisplay, @javax.annotation.Nullable String pathLower, @javax.annotation.Nullable List<FilePermission> permissions, @javax.annotation.Nullable Date timeInvited) {
        this.accessType = accessType;
        if (id == null) {
            throw new IllegalArgumentException("Required value for 'id' is null");
        }
        if (id.length() < 4) {
            throw new IllegalArgumentException("String 'id' is shorter than 4");
        }
        if (!Pattern.matches("id:.+", id)) {
            throw new IllegalArgumentException("String 'id' does not match pattern");
        }
        this.id = id;
        this.expectedLinkMetadata = expectedLinkMetadata;
        this.linkMetadata = linkMetadata;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (ownerDisplayNames != null) {
            for (String x : ownerDisplayNames) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'ownerDisplayNames' is null");
                }
            }
        }
        this.ownerDisplayNames = ownerDisplayNames;
        this.ownerTeam = ownerTeam;
        if (parentSharedFolderId != null) {
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
        }
        this.parentSharedFolderId = parentSharedFolderId;
        this.pathDisplay = pathDisplay;
        this.pathLower = pathLower;
        if (permissions != null) {
            for (FilePermission x : permissions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'permissions' is null");
                }
            }
        }
        this.permissions = permissions;
        if (policy == null) {
            throw new IllegalArgumentException("Required value for 'policy' is null");
        }
        this.policy = policy;
        if (previewUrl == null) {
            throw new IllegalArgumentException("Required value for 'previewUrl' is null");
        }
        this.previewUrl = previewUrl;
        this.timeInvited = LangUtil.truncateMillis(timeInvited);
    }

    /**
     * Properties of the shared file.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param id  The ID of the file. Must have length of at least 4, match
     *     pattern "{@code id:.+}", and not be {@code null}.
     * @param name  The name of this file. Must not be {@code null}.
     * @param policy  Policies governing this shared file. Must not be {@code
     *     null}.
     * @param previewUrl  URL for displaying a web preview of the shared file.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFileMetadata(String id, String name, FolderPolicy policy, String previewUrl) {
        this(id, name, policy, previewUrl, null, null, null, null, null, null, null, null, null, null);
    }

    /**
     * The ID of the file.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getId() {
        return id;
    }

    /**
     * The name of this file.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    /**
     * Policies governing this shared file.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public FolderPolicy getPolicy() {
        return policy;
    }

    /**
     * URL for displaying a web preview of the shared file.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * The current user's access level for this shared file.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public AccessLevel getAccessType() {
        return accessType;
    }

    /**
     * The expected metadata of the link associated for the file when it is
     * first shared. Absent if the link already exists. This is for an
     * unreleased feature so it may not be returned yet.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public ExpectedSharedContentLinkMetadata getExpectedLinkMetadata() {
        return expectedLinkMetadata;
    }

    /**
     * The metadata of the link associated for the file. This is for an
     * unreleased feature so it may not be returned yet.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public SharedContentLinkMetadata getLinkMetadata() {
        return linkMetadata;
    }

    /**
     * The display names of the users that own the file. If the file is part of
     * a team folder, the display names of the team admins are also included.
     * Absent if the owner display names cannot be fetched.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<String> getOwnerDisplayNames() {
        return ownerDisplayNames;
    }

    /**
     * The team that owns the file. This field is not present if the file is not
     * owned by a team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Team getOwnerTeam() {
        return ownerTeam;
    }

    /**
     * The ID of the parent shared folder. This field is present only if the
     * file is contained within a shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * The cased path to be used for display purposes only. In rare instances
     * the casing will not correctly match the user's filesystem, but this
     * behavior will match the path provided in the Core API v1. Absent for
     * unmounted files.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPathDisplay() {
        return pathDisplay;
    }

    /**
     * The lower-case full path of this file. Absent for unmounted files.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPathLower() {
        return pathLower;
    }

    /**
     * The sharing permissions that requesting user has on this file. This
     * corresponds to the entries given in the {@code actions} argument to
     * {@link DbxUserSharingRequests#getFileMetadataBatch(List,List)} or the
     * {@code actions} argument to {@link
     * DbxUserSharingRequests#getFileMetadata(String,List)}.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<FilePermission> getPermissions() {
        return permissions;
    }

    /**
     * Timestamp indicating when the current user was invited to this shared
     * file. If the user was not invited to the shared file, the timestamp will
     * indicate when the user was invited to the parent shared folder. This
     * value may be absent.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Date getTimeInvited() {
        return timeInvited;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param id  The ID of the file. Must have length of at least 4, match
     *     pattern "{@code id:.+}", and not be {@code null}.
     * @param name  The name of this file. Must not be {@code null}.
     * @param policy  Policies governing this shared file. Must not be {@code
     *     null}.
     * @param previewUrl  URL for displaying a web preview of the shared file.
     *     Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String id, String name, FolderPolicy policy, String previewUrl) {
        return new Builder(id, name, policy, previewUrl);
    }

    /**
     * Builder for {@link SharedFileMetadata}.
     */
    public static class Builder {
        protected final String id;
        protected final String name;
        protected final FolderPolicy policy;
        protected final String previewUrl;

        protected AccessLevel accessType;
        protected ExpectedSharedContentLinkMetadata expectedLinkMetadata;
        protected SharedContentLinkMetadata linkMetadata;
        protected List<String> ownerDisplayNames;
        protected Team ownerTeam;
        protected String parentSharedFolderId;
        protected String pathDisplay;
        protected String pathLower;
        protected List<FilePermission> permissions;
        protected Date timeInvited;

        protected Builder(String id, String name, FolderPolicy policy, String previewUrl) {
            if (id == null) {
                throw new IllegalArgumentException("Required value for 'id' is null");
            }
            if (id.length() < 4) {
                throw new IllegalArgumentException("String 'id' is shorter than 4");
            }
            if (!Pattern.matches("id:.+", id)) {
                throw new IllegalArgumentException("String 'id' does not match pattern");
            }
            this.id = id;
            if (name == null) {
                throw new IllegalArgumentException("Required value for 'name' is null");
            }
            this.name = name;
            if (policy == null) {
                throw new IllegalArgumentException("Required value for 'policy' is null");
            }
            this.policy = policy;
            if (previewUrl == null) {
                throw new IllegalArgumentException("Required value for 'previewUrl' is null");
            }
            this.previewUrl = previewUrl;
            this.accessType = null;
            this.expectedLinkMetadata = null;
            this.linkMetadata = null;
            this.ownerDisplayNames = null;
            this.ownerTeam = null;
            this.parentSharedFolderId = null;
            this.pathDisplay = null;
            this.pathLower = null;
            this.permissions = null;
            this.timeInvited = null;
        }

        /**
         * Set value for optional field.
         *
         * @param accessType  The current user's access level for this shared
         *     file.
         *
         * @return this builder
         */
        public Builder withAccessType(AccessLevel accessType) {
            this.accessType = accessType;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param expectedLinkMetadata  The expected metadata of the link
         *     associated for the file when it is first shared. Absent if the
         *     link already exists. This is for an unreleased feature so it may
         *     not be returned yet.
         *
         * @return this builder
         */
        public Builder withExpectedLinkMetadata(ExpectedSharedContentLinkMetadata expectedLinkMetadata) {
            this.expectedLinkMetadata = expectedLinkMetadata;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param linkMetadata  The metadata of the link associated for the
         *     file. This is for an unreleased feature so it may not be returned
         *     yet.
         *
         * @return this builder
         */
        public Builder withLinkMetadata(SharedContentLinkMetadata linkMetadata) {
            this.linkMetadata = linkMetadata;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param ownerDisplayNames  The display names of the users that own the
         *     file. If the file is part of a team folder, the display names of
         *     the team admins are also included. Absent if the owner display
         *     names cannot be fetched. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withOwnerDisplayNames(List<String> ownerDisplayNames) {
            if (ownerDisplayNames != null) {
                for (String x : ownerDisplayNames) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'ownerDisplayNames' is null");
                    }
                }
            }
            this.ownerDisplayNames = ownerDisplayNames;
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
                if (!Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                    throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
                }
            }
            this.parentSharedFolderId = parentSharedFolderId;
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
         * @param permissions  The sharing permissions that requesting user has
         *     on this file. This corresponds to the entries given in the {@code
         *     actions} argument to {@link
         *     DbxUserSharingRequests#getFileMetadataBatch(List,List)} or the
         *     {@code actions} argument to {@link
         *     DbxUserSharingRequests#getFileMetadata(String,List)}. Must not
         *     contain a {@code null} item.
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
         * @param timeInvited  Timestamp indicating when the current user was
         *     invited to this shared file. If the user was not invited to the
         *     shared file, the timestamp will indicate when the user was
         *     invited to the parent shared folder. This value may be absent.
         *
         * @return this builder
         */
        public Builder withTimeInvited(Date timeInvited) {
            this.timeInvited = LangUtil.truncateMillis(timeInvited);
            return this;
        }

        /**
         * Builds an instance of {@link SharedFileMetadata} configured with this
         * builder's values
         *
         * @return new instance of {@link SharedFileMetadata}
         */
        public SharedFileMetadata build() {
            return new SharedFileMetadata(id, name, policy, previewUrl, accessType, expectedLinkMetadata, linkMetadata, ownerDisplayNames, ownerTeam, parentSharedFolderId, pathDisplay, pathLower, permissions, timeInvited);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            accessType,
            id,
            expectedLinkMetadata,
            linkMetadata,
            name,
            ownerDisplayNames,
            ownerTeam,
            parentSharedFolderId,
            pathDisplay,
            pathLower,
            permissions,
            policy,
            previewUrl,
            timeInvited
        });
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
            SharedFileMetadata other = (SharedFileMetadata) obj;
            return ((this.id == other.id) || (this.id.equals(other.id)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.policy == other.policy) || (this.policy.equals(other.policy)))
                && ((this.previewUrl == other.previewUrl) || (this.previewUrl.equals(other.previewUrl)))
                && ((this.accessType == other.accessType) || (this.accessType != null && this.accessType.equals(other.accessType)))
                && ((this.expectedLinkMetadata == other.expectedLinkMetadata) || (this.expectedLinkMetadata != null && this.expectedLinkMetadata.equals(other.expectedLinkMetadata)))
                && ((this.linkMetadata == other.linkMetadata) || (this.linkMetadata != null && this.linkMetadata.equals(other.linkMetadata)))
                && ((this.ownerDisplayNames == other.ownerDisplayNames) || (this.ownerDisplayNames != null && this.ownerDisplayNames.equals(other.ownerDisplayNames)))
                && ((this.ownerTeam == other.ownerTeam) || (this.ownerTeam != null && this.ownerTeam.equals(other.ownerTeam)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.pathDisplay == other.pathDisplay) || (this.pathDisplay != null && this.pathDisplay.equals(other.pathDisplay)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.permissions == other.permissions) || (this.permissions != null && this.permissions.equals(other.permissions)))
                && ((this.timeInvited == other.timeInvited) || (this.timeInvited != null && this.timeInvited.equals(other.timeInvited)))
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
    static class Serializer extends StructSerializer<SharedFileMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFileMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("id");
            StoneSerializers.string().serialize(value.id, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("policy");
            FolderPolicy.Serializer.INSTANCE.serialize(value.policy, g);
            g.writeFieldName("preview_url");
            StoneSerializers.string().serialize(value.previewUrl, g);
            if (value.accessType != null) {
                g.writeFieldName("access_type");
                StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).serialize(value.accessType, g);
            }
            if (value.expectedLinkMetadata != null) {
                g.writeFieldName("expected_link_metadata");
                StoneSerializers.nullableStruct(ExpectedSharedContentLinkMetadata.Serializer.INSTANCE).serialize(value.expectedLinkMetadata, g);
            }
            if (value.linkMetadata != null) {
                g.writeFieldName("link_metadata");
                StoneSerializers.nullableStruct(SharedContentLinkMetadata.Serializer.INSTANCE).serialize(value.linkMetadata, g);
            }
            if (value.ownerDisplayNames != null) {
                g.writeFieldName("owner_display_names");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.ownerDisplayNames, g);
            }
            if (value.ownerTeam != null) {
                g.writeFieldName("owner_team");
                StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).serialize(value.ownerTeam, g);
            }
            if (value.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentSharedFolderId, g);
            }
            if (value.pathDisplay != null) {
                g.writeFieldName("path_display");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathDisplay, g);
            }
            if (value.pathLower != null) {
                g.writeFieldName("path_lower");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.pathLower, g);
            }
            if (value.permissions != null) {
                g.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(FilePermission.Serializer.INSTANCE)).serialize(value.permissions, g);
            }
            if (value.timeInvited != null) {
                g.writeFieldName("time_invited");
                StoneSerializers.nullable(StoneSerializers.timestamp()).serialize(value.timeInvited, g);
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
                String f_id = null;
                String f_name = null;
                FolderPolicy f_policy = null;
                String f_previewUrl = null;
                AccessLevel f_accessType = null;
                ExpectedSharedContentLinkMetadata f_expectedLinkMetadata = null;
                SharedContentLinkMetadata f_linkMetadata = null;
                List<String> f_ownerDisplayNames = null;
                Team f_ownerTeam = null;
                String f_parentSharedFolderId = null;
                String f_pathDisplay = null;
                String f_pathLower = null;
                List<FilePermission> f_permissions = null;
                Date f_timeInvited = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("id".equals(field)) {
                        f_id = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("policy".equals(field)) {
                        f_policy = FolderPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("preview_url".equals(field)) {
                        f_previewUrl = StoneSerializers.string().deserialize(p);
                    }
                    else if ("access_type".equals(field)) {
                        f_accessType = StoneSerializers.nullable(AccessLevel.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("expected_link_metadata".equals(field)) {
                        f_expectedLinkMetadata = StoneSerializers.nullableStruct(ExpectedSharedContentLinkMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("link_metadata".equals(field)) {
                        f_linkMetadata = StoneSerializers.nullableStruct(SharedContentLinkMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("owner_display_names".equals(field)) {
                        f_ownerDisplayNames = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else if ("owner_team".equals(field)) {
                        f_ownerTeam = StoneSerializers.nullableStruct(Team.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("parent_shared_folder_id".equals(field)) {
                        f_parentSharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("path_display".equals(field)) {
                        f_pathDisplay = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("path_lower".equals(field)) {
                        f_pathLower = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("permissions".equals(field)) {
                        f_permissions = StoneSerializers.nullable(StoneSerializers.list(FilePermission.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("time_invited".equals(field)) {
                        f_timeInvited = StoneSerializers.nullable(StoneSerializers.timestamp()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_id == null) {
                    throw new JsonParseException(p, "Required field \"id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_policy == null) {
                    throw new JsonParseException(p, "Required field \"policy\" missing.");
                }
                if (f_previewUrl == null) {
                    throw new JsonParseException(p, "Required field \"preview_url\" missing.");
                }
                value = new SharedFileMetadata(f_id, f_name, f_policy, f_previewUrl, f_accessType, f_expectedLinkMetadata, f_linkMetadata, f_ownerDisplayNames, f_ownerTeam, f_parentSharedFolderId, f_pathDisplay, f_pathLower, f_permissions, f_timeInvited);
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
