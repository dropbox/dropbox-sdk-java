/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

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
import java.util.List;

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
    protected final List<FolderPermission> permissions;

    /**
     * Properties of the shared folder.
     *
     * @param accessType  The current user's access level for this shared
     *     folder. Must not be {@code null}.
     * @param isTeamFolder  Whether this folder is a <a
     *     href="https://www.dropbox.com/en/help/986">team folder</a>.
     * @param policy  Policies governing this shared folder. Must not be {@code
     *     null}.
     * @param permissions  Actions the current user may perform on the folder
     *     and its contents. The set of permissions corresponds to the
     *     FolderActions in the request. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadataBase(AccessLevel accessType, boolean isTeamFolder, FolderPolicy policy, List<FolderPermission> permissions) {
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
        this(accessType, isTeamFolder, policy, null);
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
     * Actions the current user may perform on the folder and its contents. The
     * set of permissions corresponds to the FolderActions in the request.
     *
     * @return value for this field, or {@code null} if not present.
     */
    public List<FolderPermission> getPermissions() {
        return permissions;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
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
            SharedFolderMetadataBase other = (SharedFolderMetadataBase) obj;
            return ((this.accessType == other.accessType) || (this.accessType.equals(other.accessType)))
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
            if (value.permissions != null) {
                g.writeObjectField("permissions", value.permissions);
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

            return new SharedFolderMetadataBase(accessType, isTeamFolder, policy, permissions);
        }
    }
}
