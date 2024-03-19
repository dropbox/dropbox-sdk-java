/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * The metadata which includes basic information about the shared folder.
 */
public class SharedFolderMetadata extends SharedFolderMetadataBase {
    // struct sharing.SharedFolderMetadata (sharing_folders.stone)

    @Nullable
    protected final SharedContentLinkMetadata linkMetadata;
    @Nonnull
    protected final String name;
    @Nullable
    protected final List<FolderPermission> permissions;
    @Nonnull
    protected final FolderPolicy policy;
    @Nonnull
    protected final String previewUrl;
    @Nonnull
    protected final String sharedFolderId;
    @Nonnull
    protected final Date timeInvited;
    @Nonnull
    protected final AccessInheritance accessInheritance;

    /**
     * The metadata which includes basic information about the shared folder.
     *
     * <p> Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields. </p>
     *
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isInsideTeamFolder  Whether this folder is inside of a team
     *     folder.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     * @param name  The name of the this shared folder. Must not be {@code
     *     null}.
     * @param policy  Policies governing this shared folder. Must not be {@code
     *     null}.
     * @param previewUrl  URL for displaying a web preview of the shared folder.
     *     Must not be {@code null}.
     * @param sharedFolderId  The ID of the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param timeInvited  Timestamp indicating when the current user was
     *     invited to this shared folder. Must not be {@code null}.
     * @param ownerDisplayNames  The display names of the users that own the
     *     folder. If the folder is part of a team folder, the display names of
     *     the team admins are also included. Absent if the owner display names
     *     cannot be fetched. Must not contain a {@code null} item.
     * @param ownerTeam  The team that owns the folder. This field is not
     *     present if the folder is not owned by a team.
     * @param parentSharedFolderId  The ID of the parent shared folder. This
     *     field is present only if the folder is contained within another
     *     shared folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param pathDisplay  The full path of this shared folder. Absent for
     *     unmounted folders.
     * @param pathLower  The lower-cased full path of this shared folder. Absent
     *     for unmounted folders.
     * @param parentFolderName  Display name for the parent folder.
     * @param linkMetadata  The metadata of the shared content link to this
     *     shared folder. Absent if there is no link on the folder. This is for
     *     an unreleased feature so it may not be returned yet.
     * @param permissions  Actions the current user may perform on the folder
     *     and its contents. The set of permissions corresponds to the
     *     FolderActions in the request. Must not contain a {@code null} item.
     * @param accessInheritance  Whether the folder inherits its members from
     *     its parent. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata(@Nonnull AccessLevel accessType, boolean isInsideTeamFolder, boolean isTeamFolder, @Nonnull String name, @Nonnull FolderPolicy policy, @Nonnull String previewUrl, @Nonnull String sharedFolderId, @Nonnull Date timeInvited, @Nullable List<String> ownerDisplayNames, @Nullable Team ownerTeam, @Nullable String parentSharedFolderId, @Nullable String pathDisplay, @Nullable String pathLower, @Nullable String parentFolderName, @Nullable SharedContentLinkMetadata linkMetadata, @Nullable List<FolderPermission> permissions, @Nonnull AccessInheritance accessInheritance) {
        super(accessType, isInsideTeamFolder, isTeamFolder, ownerDisplayNames, ownerTeam, parentSharedFolderId, pathDisplay, pathLower, parentFolderName);
        this.linkMetadata = linkMetadata;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (permissions != null) {
            for (FolderPermission x : permissions) {
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
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        if (timeInvited == null) {
            throw new IllegalArgumentException("Required value for 'timeInvited' is null");
        }
        this.timeInvited = LangUtil.truncateMillis(timeInvited);
        if (accessInheritance == null) {
            throw new IllegalArgumentException("Required value for 'accessInheritance' is null");
        }
        this.accessInheritance = accessInheritance;
    }

    /**
     * The metadata which includes basic information about the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isInsideTeamFolder  Whether this folder is inside of a team
     *     folder.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     * @param name  The name of the this shared folder. Must not be {@code
     *     null}.
     * @param policy  Policies governing this shared folder. Must not be {@code
     *     null}.
     * @param previewUrl  URL for displaying a web preview of the shared folder.
     *     Must not be {@code null}.
     * @param sharedFolderId  The ID of the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param timeInvited  Timestamp indicating when the current user was
     *     invited to this shared folder. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata(@Nonnull AccessLevel accessType, boolean isInsideTeamFolder, boolean isTeamFolder, @Nonnull String name, @Nonnull FolderPolicy policy, @Nonnull String previewUrl, @Nonnull String sharedFolderId, @Nonnull Date timeInvited) {
        this(accessType, isInsideTeamFolder, isTeamFolder, name, policy, previewUrl, sharedFolderId, timeInvited, null, null, null, null, null, null, null, null, AccessInheritance.INHERIT);
    }

    /**
     * The current user's access level for this shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public AccessLevel getAccessType() {
        return accessType;
    }

    /**
     * Whether this folder is inside of a team folder.
     *
     * @return value for this field.
     */
    public boolean getIsInsideTeamFolder() {
        return isInsideTeamFolder;
    }

    /**
     * Whether this folder is a <a
     * href="https://www.dropbox.com/en/help/986">team folder</a>.
     *
     * @return value for this field.
     */
    public boolean getIsTeamFolder() {
        return isTeamFolder;
    }

    /**
     * The name of the this shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getName() {
        return name;
    }

    /**
     * Policies governing this shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public FolderPolicy getPolicy() {
        return policy;
    }

    /**
     * URL for displaying a web preview of the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPreviewUrl() {
        return previewUrl;
    }

    /**
     * The ID of the shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * Timestamp indicating when the current user was invited to this shared
     * folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public Date getTimeInvited() {
        return timeInvited;
    }

    /**
     * The display names of the users that own the folder. If the folder is part
     * of a team folder, the display names of the team admins are also included.
     * Absent if the owner display names cannot be fetched.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<String> getOwnerDisplayNames() {
        return ownerDisplayNames;
    }

    /**
     * The team that owns the folder. This field is not present if the folder is
     * not owned by a team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public Team getOwnerTeam() {
        return ownerTeam;
    }

    /**
     * The ID of the parent shared folder. This field is present only if the
     * folder is contained within another shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * The full path of this shared folder. Absent for unmounted folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPathDisplay() {
        return pathDisplay;
    }

    /**
     * The lower-cased full path of this shared folder. Absent for unmounted
     * folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getPathLower() {
        return pathLower;
    }

    /**
     * Display name for the parent folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public String getParentFolderName() {
        return parentFolderName;
    }

    /**
     * The metadata of the shared content link to this shared folder. Absent if
     * there is no link on the folder. This is for an unreleased feature so it
     * may not be returned yet.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SharedContentLinkMetadata getLinkMetadata() {
        return linkMetadata;
    }

    /**
     * Actions the current user may perform on the folder and its contents. The
     * set of permissions corresponds to the FolderActions in the request.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<FolderPermission> getPermissions() {
        return permissions;
    }

    /**
     * Whether the folder inherits its members from its parent.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     AccessInheritance.INHERIT.
     */
    @Nonnull
    public AccessInheritance getAccessInheritance() {
        return accessInheritance;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isInsideTeamFolder  Whether this folder is inside of a team
     *     folder.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     * @param name  The name of the this shared folder. Must not be {@code
     *     null}.
     * @param policy  Policies governing this shared folder. Must not be {@code
     *     null}.
     * @param previewUrl  URL for displaying a web preview of the shared folder.
     *     Must not be {@code null}.
     * @param sharedFolderId  The ID of the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param timeInvited  Timestamp indicating when the current user was
     *     invited to this shared folder. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel accessType, boolean isInsideTeamFolder, boolean isTeamFolder, String name, FolderPolicy policy, String previewUrl, String sharedFolderId, Date timeInvited) {
        return new Builder(accessType, isInsideTeamFolder, isTeamFolder, name, policy, previewUrl, sharedFolderId, timeInvited);
    }

    /**
     * Builder for {@link SharedFolderMetadata}.
     */
    public static class Builder extends SharedFolderMetadataBase.Builder {
        protected final String name;
        protected final FolderPolicy policy;
        protected final String previewUrl;
        protected final String sharedFolderId;
        protected final Date timeInvited;

        protected SharedContentLinkMetadata linkMetadata;
        protected List<FolderPermission> permissions;
        protected AccessInheritance accessInheritance;

        protected Builder(AccessLevel accessType, boolean isInsideTeamFolder, boolean isTeamFolder, String name, FolderPolicy policy, String previewUrl, String sharedFolderId, Date timeInvited) {
            super(accessType, isInsideTeamFolder, isTeamFolder);
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
            if (sharedFolderId == null) {
                throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
                throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
            }
            this.sharedFolderId = sharedFolderId;
            if (timeInvited == null) {
                throw new IllegalArgumentException("Required value for 'timeInvited' is null");
            }
            this.timeInvited = LangUtil.truncateMillis(timeInvited);
            this.linkMetadata = null;
            this.permissions = null;
            this.accessInheritance = AccessInheritance.INHERIT;
        }

        /**
         * Set value for optional field.
         *
         * @param linkMetadata  The metadata of the shared content link to this
         *     shared folder. Absent if there is no link on the folder. This is
         *     for an unreleased feature so it may not be returned yet.
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
         * <p> If left unset or set to {@code null}, defaults to {@code
         * AccessInheritance.INHERIT}. </p>
         *
         * @param accessInheritance  Whether the folder inherits its members
         *     from its parent. Must not be {@code null}. Defaults to {@code
         *     AccessInheritance.INHERIT} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAccessInheritance(AccessInheritance accessInheritance) {
            if (accessInheritance != null) {
                this.accessInheritance = accessInheritance;
            }
            else {
                this.accessInheritance = AccessInheritance.INHERIT;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param ownerDisplayNames  The display names of the users that own the
         *     folder. If the folder is part of a team folder, the display names
         *     of the team admins are also included. Absent if the owner display
         *     names cannot be fetched. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withOwnerDisplayNames(List<String> ownerDisplayNames) {
            super.withOwnerDisplayNames(ownerDisplayNames);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param ownerTeam  The team that owns the folder. This field is not
         *     present if the folder is not owned by a team.
         *
         * @return this builder
         */
        public Builder withOwnerTeam(Team ownerTeam) {
            super.withOwnerTeam(ownerTeam);
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param parentSharedFolderId  The ID of the parent shared folder. This
         *     field is present only if the folder is contained within another
         *     shared folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
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
         * @param pathDisplay  The full path of this shared folder. Absent for
         *     unmounted folders.
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
         * @param pathLower  The lower-cased full path of this shared folder.
         *     Absent for unmounted folders.
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
         * @param parentFolderName  Display name for the parent folder.
         *
         * @return this builder
         */
        public Builder withParentFolderName(String parentFolderName) {
            super.withParentFolderName(parentFolderName);
            return this;
        }

        /**
         * Builds an instance of {@link SharedFolderMetadata} configured with
         * this builder's values
         *
         * @return new instance of {@link SharedFolderMetadata}
         */
        public SharedFolderMetadata build() {
            return new SharedFolderMetadata(accessType, isInsideTeamFolder, isTeamFolder, name, policy, previewUrl, sharedFolderId, timeInvited, ownerDisplayNames, ownerTeam, parentSharedFolderId, pathDisplay, pathLower, parentFolderName, linkMetadata, permissions, accessInheritance);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            linkMetadata,
            name,
            permissions,
            policy,
            previewUrl,
            sharedFolderId,
            timeInvited,
            accessInheritance
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
            SharedFolderMetadata other = (SharedFolderMetadata) obj;
            return ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
                && (this.isInsideTeamFolder == other.isInsideTeamFolder)
                && (this.isTeamFolder == other.isTeamFolder)
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.policy == other.policy) || (this.policy.equals(other.policy)))
                && ((this.previewUrl == other.previewUrl) || (this.previewUrl.equals(other.previewUrl)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.timeInvited == other.timeInvited) || (this.timeInvited.equals(other.timeInvited)))
                && ((this.ownerDisplayNames == other.ownerDisplayNames) || (this.ownerDisplayNames != null && this.ownerDisplayNames.equals(other.ownerDisplayNames)))
                && ((this.ownerTeam == other.ownerTeam) || (this.ownerTeam != null && this.ownerTeam.equals(other.ownerTeam)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.pathDisplay == other.pathDisplay) || (this.pathDisplay != null && this.pathDisplay.equals(other.pathDisplay)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.parentFolderName == other.parentFolderName) || (this.parentFolderName != null && this.parentFolderName.equals(other.parentFolderName)))
                && ((this.linkMetadata == other.linkMetadata) || (this.linkMetadata != null && this.linkMetadata.equals(other.linkMetadata)))
                && ((this.permissions == other.permissions) || (this.permissions != null && this.permissions.equals(other.permissions)))
                && ((this.accessInheritance == other.accessInheritance) || (this.accessInheritance.equals(other.accessInheritance)))
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
    static class Serializer extends StructSerializer<SharedFolderMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(value.accessType, g);
            g.writeFieldName("is_inside_team_folder");
            StoneSerializers.boolean_().serialize(value.isInsideTeamFolder, g);
            g.writeFieldName("is_team_folder");
            StoneSerializers.boolean_().serialize(value.isTeamFolder, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("policy");
            FolderPolicy.Serializer.INSTANCE.serialize(value.policy, g);
            g.writeFieldName("preview_url");
            StoneSerializers.string().serialize(value.previewUrl, g);
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
            g.writeFieldName("time_invited");
            StoneSerializers.timestamp().serialize(value.timeInvited, g);
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
            if (value.parentFolderName != null) {
                g.writeFieldName("parent_folder_name");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentFolderName, g);
            }
            if (value.linkMetadata != null) {
                g.writeFieldName("link_metadata");
                StoneSerializers.nullableStruct(SharedContentLinkMetadata.Serializer.INSTANCE).serialize(value.linkMetadata, g);
            }
            if (value.permissions != null) {
                g.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(FolderPermission.Serializer.INSTANCE)).serialize(value.permissions, g);
            }
            g.writeFieldName("access_inheritance");
            AccessInheritance.Serializer.INSTANCE.serialize(value.accessInheritance, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedFolderMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedFolderMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_accessType = null;
                Boolean f_isInsideTeamFolder = null;
                Boolean f_isTeamFolder = null;
                String f_name = null;
                FolderPolicy f_policy = null;
                String f_previewUrl = null;
                String f_sharedFolderId = null;
                Date f_timeInvited = null;
                List<String> f_ownerDisplayNames = null;
                Team f_ownerTeam = null;
                String f_parentSharedFolderId = null;
                String f_pathDisplay = null;
                String f_pathLower = null;
                String f_parentFolderName = null;
                SharedContentLinkMetadata f_linkMetadata = null;
                List<FolderPermission> f_permissions = null;
                AccessInheritance f_accessInheritance = AccessInheritance.INHERIT;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("access_type".equals(field)) {
                        f_accessType = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("is_inside_team_folder".equals(field)) {
                        f_isInsideTeamFolder = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("is_team_folder".equals(field)) {
                        f_isTeamFolder = StoneSerializers.boolean_().deserialize(p);
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
                    else if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("time_invited".equals(field)) {
                        f_timeInvited = StoneSerializers.timestamp().deserialize(p);
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
                    else if ("parent_folder_name".equals(field)) {
                        f_parentFolderName = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("link_metadata".equals(field)) {
                        f_linkMetadata = StoneSerializers.nullableStruct(SharedContentLinkMetadata.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("permissions".equals(field)) {
                        f_permissions = StoneSerializers.nullable(StoneSerializers.list(FolderPermission.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("access_inheritance".equals(field)) {
                        f_accessInheritance = AccessInheritance.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_accessType == null) {
                    throw new JsonParseException(p, "Required field \"access_type\" missing.");
                }
                if (f_isInsideTeamFolder == null) {
                    throw new JsonParseException(p, "Required field \"is_inside_team_folder\" missing.");
                }
                if (f_isTeamFolder == null) {
                    throw new JsonParseException(p, "Required field \"is_team_folder\" missing.");
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
                if (f_sharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_id\" missing.");
                }
                if (f_timeInvited == null) {
                    throw new JsonParseException(p, "Required field \"time_invited\" missing.");
                }
                value = new SharedFolderMetadata(f_accessType, f_isInsideTeamFolder, f_isTeamFolder, f_name, f_policy, f_previewUrl, f_sharedFolderId, f_timeInvited, f_ownerDisplayNames, f_ownerTeam, f_parentSharedFolderId, f_pathDisplay, f_pathLower, f_parentFolderName, f_linkMetadata, f_permissions, f_accessInheritance);
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
