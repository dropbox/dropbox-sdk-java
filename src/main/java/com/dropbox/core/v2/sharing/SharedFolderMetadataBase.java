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
 * Properties of the shared folder.
 */
public class SharedFolderMetadataBase {
    // struct SharedFolderMetadataBase

    private final AccessLevel accessType;
    private final boolean isTeamFolder;
    private final FolderPolicy policy;
    private final List<FolderPermission> permissions;

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
     * Whether this folder is a &lt;a
     * href="https://www.dropbox.com/en/help/986"&gt;team folder&lt;/a&gt;.
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SharedFolderMetadataBase fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SharedFolderMetadataBase> _JSON_WRITER = new JsonWriter<SharedFolderMetadataBase>() {
        public final void write(SharedFolderMetadataBase x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SharedFolderMetadataBase._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(SharedFolderMetadataBase x, JsonGenerator g) throws IOException {
            g.writeFieldName("access_type");
            AccessLevel._JSON_WRITER.write(x.accessType, g);
            g.writeFieldName("is_team_folder");
            g.writeBoolean(x.isTeamFolder);
            g.writeFieldName("policy");
            FolderPolicy._JSON_WRITER.write(x.policy, g);
            if (x.permissions != null) {
                g.writeFieldName("permissions");
                g.writeStartArray();
                for (FolderPermission item: x.permissions) {
                    if (item != null) {
                        FolderPermission._JSON_WRITER.write(item, g);
                    }
                }
                g.writeEndArray();
            }
        }
    };

    public static final JsonReader<SharedFolderMetadataBase> _JSON_READER = new JsonReader<SharedFolderMetadataBase>() {
        public final SharedFolderMetadataBase read(JsonParser parser) throws IOException, JsonReadException {
            SharedFolderMetadataBase result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final SharedFolderMetadataBase readFields(JsonParser parser) throws IOException, JsonReadException {
            AccessLevel accessType = null;
            Boolean isTeamFolder = null;
            FolderPolicy policy = null;
            List<FolderPermission> permissions = null;
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
                else if ("permissions".equals(fieldName)) {
                    permissions = JsonArrayReader.mk(FolderPermission._JSON_READER)
                        .readField(parser, "permissions", permissions);
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
            return new SharedFolderMetadataBase(accessType, isTeamFolder, policy, permissions);
        }
    };
}
