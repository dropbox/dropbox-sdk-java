/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

/**
 * Contains information about a parent folder that a member has access to.
 */
public class ParentFolderAccessInfo {
    // struct ParentFolderAccessInfo

    protected final String folderName;
    protected final String sharedFolderId;
    protected final List<MemberPermission> permissions;

    /**
     * Contains information about a parent folder that a member has access to.
     *
     * @param folderName  Display name for the folder. Must not be {@code null}.
     * @param sharedFolderId  The identifier of the parent shared folder. Must
     *     match pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param permissions  The user's permissions for the parent shared folder.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ParentFolderAccessInfo(String folderName, String sharedFolderId, List<MemberPermission> permissions) {
        if (folderName == null) {
            throw new IllegalArgumentException("Required value for 'folderName' is null");
        }
        this.folderName = folderName;
        if (sharedFolderId == null) {
            throw new IllegalArgumentException("Required value for 'sharedFolderId' is null");
        }
        if (!java.util.regex.Pattern.matches("[-_0-9a-zA-Z:]+", sharedFolderId)) {
            throw new IllegalArgumentException("String 'sharedFolderId' does not match pattern");
        }
        this.sharedFolderId = sharedFolderId;
        if (permissions == null) {
            throw new IllegalArgumentException("Required value for 'permissions' is null");
        }
        for (MemberPermission x : permissions) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'permissions' is null");
            }
        }
        this.permissions = permissions;
    }

    /**
     * Display name for the folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getFolderName() {
        return folderName;
    }

    /**
     * The identifier of the parent shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getSharedFolderId() {
        return sharedFolderId;
    }

    /**
     * The user's permissions for the parent shared folder.
     *
     * @return value for this field, never {@code null}.
     */
    public List<MemberPermission> getPermissions() {
        return permissions;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            folderName,
            sharedFolderId,
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
            ParentFolderAccessInfo other = (ParentFolderAccessInfo) obj;
            return ((this.folderName == other.folderName) || (this.folderName.equals(other.folderName)))
                && ((this.sharedFolderId == other.sharedFolderId) || (this.sharedFolderId.equals(other.sharedFolderId)))
                && ((this.permissions == other.permissions) || (this.permissions.equals(other.permissions)))
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
    static final class Serializer extends StructSerializer<ParentFolderAccessInfo> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(ParentFolderAccessInfo value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("folder_name");
            StoneSerializers.string().serialize(value.folderName, g);
            g.writeFieldName("shared_folder_id");
            StoneSerializers.string().serialize(value.sharedFolderId, g);
            g.writeFieldName("permissions");
            StoneSerializers.list(MemberPermission.Serializer.INSTANCE).serialize(value.permissions, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public ParentFolderAccessInfo deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            ParentFolderAccessInfo value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_folderName = null;
                String f_sharedFolderId = null;
                List<MemberPermission> f_permissions = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("folder_name".equals(field)) {
                        f_folderName = StoneSerializers.string().deserialize(p);
                    }
                    else if ("shared_folder_id".equals(field)) {
                        f_sharedFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("permissions".equals(field)) {
                        f_permissions = StoneSerializers.list(MemberPermission.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_folderName == null) {
                    throw new JsonParseException(p, "Required field \"folder_name\" missing.");
                }
                if (f_sharedFolderId == null) {
                    throw new JsonParseException(p, "Required field \"shared_folder_id\" missing.");
                }
                if (f_permissions == null) {
                    throw new JsonParseException(p, "Required field \"permissions\" missing.");
                }
                value = new ParentFolderAccessInfo(f_folderName, f_sharedFolderId, f_permissions);
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
