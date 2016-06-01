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

/**
 * Properties of the shared folder.
 */
public class SharedFolderMetadataBase {
    // struct SharedFolderMetadataBase

    protected final AccessLevel accessType;
    protected final boolean isTeamFolder;
    protected final FolderPolicy policy;
    protected final Team ownerTeam;
    protected final String parentSharedFolderId;

    /**
     * Properties of the shared folder.
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
     * @param ownerTeam  The team that owns the folder. This field is not
     *     present if the folder is not owned by a team.
     * @param parentSharedFolderId  The ID of the parent shared folder. This
     *     field is present only if the folder is contained within another
     *     shared folder. Must match pattern "{@code [-_0-9a-zA-Z:]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadataBase(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, Team ownerTeam, String parentSharedFolderId) {
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
        this.isTeamFolder = isTeamFolder;
        if (policy == null) {
            throw new IllegalArgumentException("Required value for 'policy' is null");
        }
        this.policy = policy;
        this.ownerTeam = ownerTeam;
        if (parentSharedFolderId != null) {
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
        }
        this.parentSharedFolderId = parentSharedFolderId;
    }

    /**
     * Properties of the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
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
    public SharedFolderMetadataBase(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy) {
        this(accessType, isTeamFolder, policy, null, null);
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
     * Whether this folder is a <a
     * href="https://www.dropbox.com/en/help/986">team folder</a>.
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
     * The team that owns the folder. This field is not present if the folder is
     * not owned by a team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public Team getOwnerTeam() {
        return ownerTeam;
    }

    /**
     * The ID of the parent shared folder. This field is present only if the
     * folder is contained within another shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
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
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy) {
        return new Builder(accessType, isTeamFolder, policy);
    }

    /**
     * Builder for {@link SharedFolderMetadataBase}.
     */
    public static class Builder {
        protected final AccessLevel accessType;
        protected final boolean isTeamFolder;
        protected final FolderPolicy policy;

        protected Team ownerTeam;
        protected String parentSharedFolderId;

        protected Builder(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy) {
            if (accessType == null) {
                throw new IllegalArgumentException("Required value for 'accessType' is null");
            }
            this.accessType = accessType;
            this.isTeamFolder = isTeamFolder;
            if (policy == null) {
                throw new IllegalArgumentException("Required value for 'policy' is null");
            }
            this.policy = policy;
            this.ownerTeam = null;
            this.parentSharedFolderId = null;
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
            this.ownerTeam = ownerTeam;
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
            if (parentSharedFolderId != null) {
                if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                    throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
                }
            }
            this.parentSharedFolderId = parentSharedFolderId;
            return this;
        }

        /**
         * Builds an instance of {@link SharedFolderMetadataBase} configured
         * with this builder's values
         *
         * @return new instance of {@link SharedFolderMetadataBase}
         */
        public SharedFolderMetadataBase build() {
            return new SharedFolderMetadataBase(accessType, isTeamFolder, policy, ownerTeam, parentSharedFolderId);
        }
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            accessType,
            isTeamFolder,
            policy,
            ownerTeam,
            parentSharedFolderId
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
            SharedFolderMetadataBase other = (SharedFolderMetadataBase) obj;
            return ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
                && (this.isTeamFolder == other.isTeamFolder)
                && ((this.policy == other.policy) || (this.policy.equals(other.policy)))
                && ((this.ownerTeam == other.ownerTeam) || (this.ownerTeam != null && this.ownerTeam.equals(other.ownerTeam)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
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
    static final class Serializer extends StructSerializer<SharedFolderMetadataBase> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderMetadataBase value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(value.accessType, g);
            g.writeFieldName("is_team_folder");
            StoneSerializers.boolean_().serialize(value.isTeamFolder, g);
            g.writeFieldName("policy");
            FolderPolicy.Serializer.INSTANCE.serialize(value.policy, g);
            if (value.ownerTeam != null) {
                g.writeFieldName("owner_team");
                StoneSerializers.nullable(Team.Serializer.INSTANCE).serialize(value.ownerTeam, g);
            }
            if (value.parentSharedFolderId != null) {
                g.writeFieldName("parent_shared_folder_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.parentSharedFolderId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SharedFolderMetadataBase deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SharedFolderMetadataBase value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                AccessLevel f_accessType = null;
                Boolean f_isTeamFolder = null;
                FolderPolicy f_policy = null;
                Team f_ownerTeam = null;
                String f_parentSharedFolderId = null;
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
                    else if ("owner_team".equals(field)) {
                        f_ownerTeam = StoneSerializers.nullable(Team.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("parent_shared_folder_id".equals(field)) {
                        f_parentSharedFolderId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
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
                value = new SharedFolderMetadataBase(f_accessType, f_isTeamFolder, f_policy, f_ownerTeam, f_parentSharedFolderId);
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
