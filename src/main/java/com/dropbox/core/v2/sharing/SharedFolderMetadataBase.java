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

/**
 * Properties of the shared folder.
 */
@JsonSerialize(using=SharedFolderMetadataBase.Serializer.class)
@JsonDeserialize(using=SharedFolderMetadataBase.Deserializer.class)
public class SharedFolderMetadataBase {
    // struct SharedFolderMetadataBase

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

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

    static final class Serializer extends StructJsonSerializer<SharedFolderMetadataBase> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SharedFolderMetadataBase.class);
        }

        public Serializer(boolean unwrapping) {
            super(SharedFolderMetadataBase.class, unwrapping);
        }

        @Override
        protected JsonSerializer<SharedFolderMetadataBase> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(SharedFolderMetadataBase value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("access_type", value.accessType);
            g.writeObjectField("is_team_folder", value.isTeamFolder);
            g.writeObjectField("policy", value.policy);
            if (value.ownerTeam != null) {
                g.writeObjectField("owner_team", value.ownerTeam);
            }
            if (value.parentSharedFolderId != null) {
                g.writeObjectField("parent_shared_folder_id", value.parentSharedFolderId);
            }
        }
    }

    static final class Deserializer extends StructJsonDeserializer<SharedFolderMetadataBase> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SharedFolderMetadataBase.class);
        }

        public Deserializer(boolean unwrapping) {
            super(SharedFolderMetadataBase.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<SharedFolderMetadataBase> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public SharedFolderMetadataBase deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            AccessLevel accessType = null;
            Boolean isTeamFolder = null;
            FolderPolicy policy = null;
            Team ownerTeam = null;
            String parentSharedFolderId = null;

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
                else if ("owner_team".equals(_field)) {
                    ownerTeam = _p.readValueAs(Team.class);
                    _p.nextToken();
                }
                else if ("parent_shared_folder_id".equals(_field)) {
                    parentSharedFolderId = getStringValue(_p);
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

            return new SharedFolderMetadataBase(accessType, isTeamFolder, policy, ownerTeam, parentSharedFolderId);
        }
    }
}
