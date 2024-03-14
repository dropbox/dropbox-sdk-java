/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.users.Team;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Properties of the shared folder.
 */
public class SharedFolderMetadataBase {
    // struct sharing.SharedFolderMetadataBase (sharing_folders.stone)

    protected final AccessLevel accessType;
    protected final boolean isInsideTeamFolder;
    protected final boolean isTeamFolder;
    protected final List<String> ownerDisplayNames;
    protected final Team ownerTeam;
    protected final String parentSharedFolderId;
    protected final String pathDisplay;
    protected final String pathLower;
    protected final String parentFolderName;

    /**
     * Properties of the shared folder.
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
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadataBase(@javax.annotation.Nonnull AccessLevel accessType, boolean isInsideTeamFolder, boolean isTeamFolder, @javax.annotation.Nullable List<String> ownerDisplayNames, @javax.annotation.Nullable Team ownerTeam, @javax.annotation.Nullable String parentSharedFolderId, @javax.annotation.Nullable String pathDisplay, @javax.annotation.Nullable String pathLower, @javax.annotation.Nullable String parentFolderName) {
        if (accessType == null) {
            throw new IllegalArgumentException("Required value for 'accessType' is null");
        }
        this.accessType = accessType;
        this.isInsideTeamFolder = isInsideTeamFolder;
        this.isTeamFolder = isTeamFolder;
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
            if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", parentSharedFolderId)) {
                throw new IllegalArgumentException("String 'parentSharedFolderId' does not match pattern");
            }
        }
        this.parentSharedFolderId = parentSharedFolderId;
        this.pathDisplay = pathDisplay;
        this.pathLower = pathLower;
        this.parentFolderName = parentFolderName;
    }

    /**
     * Properties of the shared folder.
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isInsideTeamFolder  Whether this folder is inside of a team
     *     folder.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadataBase(AccessLevel accessType, boolean isInsideTeamFolder, boolean isTeamFolder) {
        this(accessType, isInsideTeamFolder, isTeamFolder, null, null, null, null, null, null);
    }

    /**
     * The current user's access level for this shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
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
     * The display names of the users that own the folder. If the folder is part
     * of a team folder, the display names of the team admins are also included.
     * Absent if the owner display names cannot be fetched.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<String> getOwnerDisplayNames() {
        return ownerDisplayNames;
    }

    /**
     * The team that owns the folder. This field is not present if the folder is
     * not owned by a team.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public Team getOwnerTeam() {
        return ownerTeam;
    }

    /**
     * The ID of the parent shared folder. This field is present only if the
     * folder is contained within another shared folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getParentSharedFolderId() {
        return parentSharedFolderId;
    }

    /**
     * The full path of this shared folder. Absent for unmounted folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPathDisplay() {
        return pathDisplay;
    }

    /**
     * The lower-cased full path of this shared folder. Absent for unmounted
     * folders.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPathLower() {
        return pathLower;
    }

    /**
     * Display name for the parent folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getParentFolderName() {
        return parentFolderName;
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
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(AccessLevel accessType, boolean isInsideTeamFolder, boolean isTeamFolder) {
        return new Builder(accessType, isInsideTeamFolder, isTeamFolder);
    }

    /**
     * Builder for {@link SharedFolderMetadataBase}.
     */
    public static class Builder {
        protected final AccessLevel accessType;
        protected final boolean isInsideTeamFolder;
        protected final boolean isTeamFolder;

        protected List<String> ownerDisplayNames;
        protected Team ownerTeam;
        protected String parentSharedFolderId;
        protected String pathDisplay;
        protected String pathLower;
        protected String parentFolderName;

        protected Builder(AccessLevel accessType, boolean isInsideTeamFolder, boolean isTeamFolder) {
            if (accessType == null) {
                throw new IllegalArgumentException("Required value for 'accessType' is null");
            }
            this.accessType = accessType;
            this.isInsideTeamFolder = isInsideTeamFolder;
            this.isTeamFolder = isTeamFolder;
            this.ownerDisplayNames = null;
            this.ownerTeam = null;
            this.parentSharedFolderId = null;
            this.pathDisplay = null;
            this.pathLower = null;
            this.parentFolderName = null;
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
         * Set value for optional field.
         *
         * @param pathDisplay  The full path of this shared folder. Absent for
         *     unmounted folders.
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
         * @param parentFolderName  Display name for the parent folder.
         *
         * @return this builder
         */
        public Builder withParentFolderName(String parentFolderName) {
            this.parentFolderName = parentFolderName;
            return this;
        }

        /**
         * Builds an instance of {@link SharedFolderMetadataBase} configured
         * with this builder's values
         *
         * @return new instance of {@link SharedFolderMetadataBase}
         */
        public SharedFolderMetadataBase build() {
            return new SharedFolderMetadataBase(accessType, isInsideTeamFolder, isTeamFolder, ownerDisplayNames, ownerTeam, parentSharedFolderId, pathDisplay, pathLower, parentFolderName);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            accessType,
            isInsideTeamFolder,
            isTeamFolder,
            ownerDisplayNames,
            ownerTeam,
            parentSharedFolderId,
            pathDisplay,
            pathLower,
            parentFolderName
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
            SharedFolderMetadataBase other = (SharedFolderMetadataBase) obj;
            return ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
                && (this.isInsideTeamFolder == other.isInsideTeamFolder)
                && (this.isTeamFolder == other.isTeamFolder)
                && ((this.ownerDisplayNames == other.ownerDisplayNames) || (this.ownerDisplayNames != null && this.ownerDisplayNames.equals(other.ownerDisplayNames)))
                && ((this.ownerTeam == other.ownerTeam) || (this.ownerTeam != null && this.ownerTeam.equals(other.ownerTeam)))
                && ((this.parentSharedFolderId == other.parentSharedFolderId) || (this.parentSharedFolderId != null && this.parentSharedFolderId.equals(other.parentSharedFolderId)))
                && ((this.pathDisplay == other.pathDisplay) || (this.pathDisplay != null && this.pathDisplay.equals(other.pathDisplay)))
                && ((this.pathLower == other.pathLower) || (this.pathLower != null && this.pathLower.equals(other.pathLower)))
                && ((this.parentFolderName == other.parentFolderName) || (this.parentFolderName != null && this.parentFolderName.equals(other.parentFolderName)))
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
    private static class Serializer extends StructSerializer<SharedFolderMetadataBase> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SharedFolderMetadataBase value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("access_type");
            AccessLevel.Serializer.INSTANCE.serialize(value.accessType, g);
            g.writeFieldName("is_inside_team_folder");
            StoneSerializers.boolean_().serialize(value.isInsideTeamFolder, g);
            g.writeFieldName("is_team_folder");
            StoneSerializers.boolean_().serialize(value.isTeamFolder, g);
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
                Boolean f_isInsideTeamFolder = null;
                Boolean f_isTeamFolder = null;
                List<String> f_ownerDisplayNames = null;
                Team f_ownerTeam = null;
                String f_parentSharedFolderId = null;
                String f_pathDisplay = null;
                String f_pathLower = null;
                String f_parentFolderName = null;
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
                value = new SharedFolderMetadataBase(f_accessType, f_isInsideTeamFolder, f_isTeamFolder, f_ownerDisplayNames, f_ownerTeam, f_parentSharedFolderId, f_pathDisplay, f_pathLower, f_parentFolderName);
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
