/* DO NOT EDIT */
/* This file was generated from team_folders.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.files.ContentSyncSetting;
import com.dropbox.core.v2.files.SyncSetting;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Properties of a team folder.
 */
public class TeamFolderMetadata {
    // struct team.TeamFolderMetadata (team_folders.stone)

    protected final String teamFolderId;
    protected final String name;
    protected final TeamFolderStatus status;
    protected final boolean isTeamSharedDropbox;
    protected final SyncSetting syncSetting;
    protected final List<ContentSyncSetting> contentSyncSettings;

    /**
     * Properties of a team folder.
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param name  The name of the team folder. Must not be {@code null}.
     * @param status  The status of the team folder. Must not be {@code null}.
     * @param isTeamSharedDropbox  True if this team folder is a shared team
     *     root.
     * @param syncSetting  The sync setting applied to this team folder. Must
     *     not be {@code null}.
     * @param contentSyncSettings  Sync settings applied to contents of this
     *     team folder. Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderMetadata(@javax.annotation.Nonnull String teamFolderId, @javax.annotation.Nonnull String name, @javax.annotation.Nonnull TeamFolderStatus status, boolean isTeamSharedDropbox, @javax.annotation.Nonnull SyncSetting syncSetting, @javax.annotation.Nonnull List<ContentSyncSetting> contentSyncSettings) {
        if (teamFolderId == null) {
            throw new IllegalArgumentException("Required value for 'teamFolderId' is null");
        }
        if (!Pattern.matches("[-_0-9a-zA-Z:]+", teamFolderId)) {
            throw new IllegalArgumentException("String 'teamFolderId' does not match pattern");
        }
        this.teamFolderId = teamFolderId;
        if (name == null) {
            throw new IllegalArgumentException("Required value for 'name' is null");
        }
        this.name = name;
        if (status == null) {
            throw new IllegalArgumentException("Required value for 'status' is null");
        }
        this.status = status;
        this.isTeamSharedDropbox = isTeamSharedDropbox;
        if (syncSetting == null) {
            throw new IllegalArgumentException("Required value for 'syncSetting' is null");
        }
        this.syncSetting = syncSetting;
        if (contentSyncSettings == null) {
            throw new IllegalArgumentException("Required value for 'contentSyncSettings' is null");
        }
        for (ContentSyncSetting x : contentSyncSettings) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'contentSyncSettings' is null");
            }
        }
        this.contentSyncSettings = contentSyncSettings;
    }

    /**
     * The ID of the team folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getTeamFolderId() {
        return teamFolderId;
    }

    /**
     * The name of the team folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public String getName() {
        return name;
    }

    /**
     * The status of the team folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public TeamFolderStatus getStatus() {
        return status;
    }

    /**
     * True if this team folder is a shared team root.
     *
     * @return value for this field.
     */
    public boolean getIsTeamSharedDropbox() {
        return isTeamSharedDropbox;
    }

    /**
     * The sync setting applied to this team folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public SyncSetting getSyncSetting() {
        return syncSetting;
    }

    /**
     * Sync settings applied to contents of this team folder.
     *
     * @return value for this field, never {@code null}.
     */
    @javax.annotation.Nonnull
    public List<ContentSyncSetting> getContentSyncSettings() {
        return contentSyncSettings;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            teamFolderId,
            name,
            status,
            isTeamSharedDropbox,
            syncSetting,
            contentSyncSettings
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
            TeamFolderMetadata other = (TeamFolderMetadata) obj;
            return ((this.teamFolderId == other.teamFolderId) || (this.teamFolderId.equals(other.teamFolderId)))
                && ((this.name == other.name) || (this.name.equals(other.name)))
                && ((this.status == other.status) || (this.status.equals(other.status)))
                && (this.isTeamSharedDropbox == other.isTeamSharedDropbox)
                && ((this.syncSetting == other.syncSetting) || (this.syncSetting.equals(other.syncSetting)))
                && ((this.contentSyncSettings == other.contentSyncSettings) || (this.contentSyncSettings.equals(other.contentSyncSettings)))
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
    static class Serializer extends StructSerializer<TeamFolderMetadata> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderMetadata value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_folder_id");
            StoneSerializers.string().serialize(value.teamFolderId, g);
            g.writeFieldName("name");
            StoneSerializers.string().serialize(value.name, g);
            g.writeFieldName("status");
            TeamFolderStatus.Serializer.INSTANCE.serialize(value.status, g);
            g.writeFieldName("is_team_shared_dropbox");
            StoneSerializers.boolean_().serialize(value.isTeamSharedDropbox, g);
            g.writeFieldName("sync_setting");
            SyncSetting.Serializer.INSTANCE.serialize(value.syncSetting, g);
            g.writeFieldName("content_sync_settings");
            StoneSerializers.list(ContentSyncSetting.Serializer.INSTANCE).serialize(value.contentSyncSettings, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamFolderMetadata deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamFolderMetadata value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamFolderId = null;
                String f_name = null;
                TeamFolderStatus f_status = null;
                Boolean f_isTeamSharedDropbox = null;
                SyncSetting f_syncSetting = null;
                List<ContentSyncSetting> f_contentSyncSettings = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_folder_id".equals(field)) {
                        f_teamFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("name".equals(field)) {
                        f_name = StoneSerializers.string().deserialize(p);
                    }
                    else if ("status".equals(field)) {
                        f_status = TeamFolderStatus.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("is_team_shared_dropbox".equals(field)) {
                        f_isTeamSharedDropbox = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("sync_setting".equals(field)) {
                        f_syncSetting = SyncSetting.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("content_sync_settings".equals(field)) {
                        f_contentSyncSettings = StoneSerializers.list(ContentSyncSetting.Serializer.INSTANCE).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamFolderId == null) {
                    throw new JsonParseException(p, "Required field \"team_folder_id\" missing.");
                }
                if (f_name == null) {
                    throw new JsonParseException(p, "Required field \"name\" missing.");
                }
                if (f_status == null) {
                    throw new JsonParseException(p, "Required field \"status\" missing.");
                }
                if (f_isTeamSharedDropbox == null) {
                    throw new JsonParseException(p, "Required field \"is_team_shared_dropbox\" missing.");
                }
                if (f_syncSetting == null) {
                    throw new JsonParseException(p, "Required field \"sync_setting\" missing.");
                }
                if (f_contentSyncSettings == null) {
                    throw new JsonParseException(p, "Required field \"content_sync_settings\" missing.");
                }
                value = new TeamFolderMetadata(f_teamFolderId, f_name, f_status, f_isTeamSharedDropbox, f_syncSetting, f_contentSyncSettings);
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
