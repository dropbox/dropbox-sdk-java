/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;
import com.dropbox.core.v2.users.Team;

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
import java.util.Date;
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
            g.writeObjectField("time_invited", value.timeInvited);
            if (value.ownerTeam != null) {
                g.writeObjectField("owner_team", value.ownerTeam);
            }
            if (value.parentSharedFolderId != null) {
                g.writeObjectField("parent_shared_folder_id", value.parentSharedFolderId);
            }
            if (value.pathLower != null) {
                g.writeObjectField("path_lower", value.pathLower);
            }
            if (value.permissions != null) {
                g.writeObjectField("permissions", value.permissions);
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
            Date timeInvited = null;
            Team ownerTeam = null;
            String parentSharedFolderId = null;
            String pathLower = null;
            List<FolderPermission> permissions = null;

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
                else if ("time_invited".equals(_field)) {
                    timeInvited = _ctx.parseDate(getStringValue(_p));
                    _p.nextToken();
                }
                else if ("owner_team".equals(_field)) {
                    ownerTeam = _p.readValueAs(Team.class);
                    _p.nextToken();
                }
                else if ("parent_shared_folder_id".equals(_field)) {
                    parentSharedFolderId = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("path_lower".equals(_field)) {
                    pathLower = getStringValue(_p);
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
            if (timeInvited == null) {
                throw new JsonParseException(_p, "Required field \"time_invited\" is missing.");
            }

            return new SharedFolderMetadata(accessType, isTeamFolder, policy, name, sharedFolderId, timeInvited, ownerTeam, parentSharedFolderId, pathLower, permissions);
        }
    }
}
