/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

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
import java.util.Date;
import java.util.List;

/**
 * The metadata which includes basic information about the shared folder.
 */
public class SharedFolderMetadata extends SharedFolderMetadataBase {
    // struct SharedFolderMetadata

    protected final String pathLower;
    protected final String name;
    protected final String sharedFolderId;
    protected final List<FolderPermission> permissions;
    protected final Date timeInvited;

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
     * @param timeInvited  Timestamp indicating when the current user was
     *     invited to this shared folder. Must not be {@code null}.
     * @param ownerTeam  The team that owns the folder. This field is not
     *     present if the folder is not owned by a team.
     * @param parentSharedFolderId  The ID of the parent shared folder. This
     *     field is present only if the folder is contained within another
     *     shared folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
     * @param pathLower  The lower-cased full path of this shared folder. Absent
     *     for unmounted folders.
     * @param permissions  Actions the current user may perform on the folder
     *     and its contents. The set of permissions corresponds to the
     *     FolderActions in the request. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String name, String sharedFolderId, Date timeInvited, Team ownerTeam, String parentSharedFolderId, String pathLower, List<FolderPermission> permissions) {
        super(accessType, isTeamFolder, policy, ownerTeam, parentSharedFolderId);
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
        if (permissions != null) {
            for (FolderPermission x : permissions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'permissions' is null");
                }
            }
        }
        this.permissions = permissions;
        if (timeInvited == null) {
            throw new IllegalArgumentException("Required value for 'timeInvited' is null");
        }
        this.timeInvited = com.dropbox.core.util.LangUtil.truncateMillis(timeInvited);
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
     * @param timeInvited  Timestamp indicating when the current user was
     *     invited to this shared folder. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String name, String sharedFolderId, Date timeInvited) {
        this(accessType, isTeamFolder, policy, name, sharedFolderId, timeInvited, null, null, null, null);
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
     * Actions the current user may perform on the folder and its contents. The
     * set of permissions corresponds to the FolderActions in the request.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<FolderPermission> getPermissions() {
        return permissions;
    }

    /**
     * Timestamp indicating when the current user was invited to this shared
     * folder.
     *
     * @return value for this field, never {@code null}.
     */
    public Date getTimeInvited() {
        return timeInvited;
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
     * @param timeInvited  Timestamp indicating when the current user was
     *     invited to this shared folder. Must not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String name, String sharedFolderId, Date timeInvited) {
        return new Builder(accessType, isTeamFolder, policy, name, sharedFolderId, timeInvited);
    }

    /**
     * Builder for {@link SharedFolderMetadata}.
     */
    public static class Builder extends SharedFolderMetadataBase.Builder {
        protected final String name;
        protected final String sharedFolderId;
        protected final Date timeInvited;

        protected String pathLower;
        protected List<FolderPermission> permissions;

        protected Builder(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, String name, String sharedFolderId, Date timeInvited) {
            super(accessType, isTeamFolder, policy);
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
            if (timeInvited == null) {
                throw new IllegalArgumentException("Required value for 'timeInvited' is null");
            }
            this.timeInvited = com.dropbox.core.util.LangUtil.truncateMillis(timeInvited);
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
         * Builds an instance of {@link SharedFolderMetadata} configured with
         * this builder's values
         *
         * @return new instance of {@link SharedFolderMetadata}
         */
        public SharedFolderMetadata build() {
            return new SharedFolderMetadata(accessType, isTeamFolder, policy, name, sharedFolderId, timeInvited, ownerTeam, parentSharedFolderId, pathLower, permissions);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            pathLower,
            name,
            sharedFolderId,
            permissions,
            timeInvited
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
                && ((this.timeInvited == other.timeInvited) || (this.timeInvited.equals(other.timeInvited)))
                && ((this.ownerTeam == other.ownerTeam) || (this.ownerTeam != null && this.ownerTeam.equals(other.ownerTeam)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.permissions == other.permissions) || (this.permissions != null && this.permissions.equals(other.permissions)))
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
    static final class Serializer extends StructSerializer<SharedFolderMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(value.accessType, g);
            g.writeFieldName("is_team_folder");
            StoneSerializers.boolean_().serialize(value.isTeamFolder, g);
            g.writeFieldName("policy");
            FolderPolicy.Serializer.INSTANCE.serialize(value.policy, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
            g.writeFieldName("time_invited");
            StoneSerializers.timestamp().serialize(value.timeInvited, g);
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
            if (value.permissions != null) {
                g.writeFieldName("permissions");
                StoneSerializers.nullable(StoneSerializers.list(FolderPermission.Serializer.INSTANCE)).serialize(value.permissions, g);
            }
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
                Boolean f_isTeamFolder = null;
                FolderPolicy f_policy = null;
                String f_name = null;
                String f_sharedFolderId = null;
                Date f_timeInvited = null;
                Team f_ownerTeam = null;
                String f_parentSharedFolderId = null;
                String f_pathLower = null;
                List<FolderPermission> f_permissions = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("access_type".equals(field)) {
                        f_accessType = AccessLevel.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("is_team_folder".equals(field)) {
                        f_isTeamFolder = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("policy".equals(field)) {
                        f_policy = FolderPolicy.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("time_invited".equals(field)) {
                        f_timeInvited = StoneSerializers.timestamp().deserialize(p);
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
                    else if ("permissions".equals(field)) {
                        f_permissions = StoneSerializers.nullable(StoneSerializers.list(FolderPermission.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_accessType == null) {
                    throw new JsonParseException(p, "Required field \"access_type\" missing.");
                }
                if (f_isTeamFolder == null) {
                    throw new JsonParseException(p, "Required field \"is_team_folder\" missing.");
                }
                if (f_policy == null) {
                    throw new JsonParseException(p, "Required field \"policy\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_sharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_id\" missing.");
                }
                if (f_timeInvited == null) {
                    throw new JsonParseException(p, "Required field \"time_invited\" missing.");
                }
                value = new SharedFolderMetadata(f_accessType, f_isTeamFolder, f_policy, f_name, f_sharedFolderId, f_timeInvited, f_ownerTeam, f_parentSharedFolderId, f_pathLower, f_permissions);
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
