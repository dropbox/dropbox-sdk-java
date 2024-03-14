/* DO NOT EDIT */
/* This file was generated from team_folders.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;
import com.dropbox.core.v2.files.ContentSyncSettingArg;
import com.dropbox.core.v2.files.SyncSettingArg;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

class TeamFolderUpdateSyncSettingsArg extends TeamFolderIdArg {
    // struct team.TeamFolderUpdateSyncSettingsArg (team_folders.stone)

    protected final SyncSettingArg syncSetting;
    protected final List<ContentSyncSettingArg> contentSyncSettings;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param syncSetting  Sync setting to apply to the team folder itself. Only
     *     meaningful if the team folder is not a shared team root.
     * @param contentSyncSettings  Sync settings to apply to contents of this
     *     team folder. Must not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderUpdateSyncSettingsArg(@Nonnull String teamFolderId, @Nullable SyncSettingArg syncSetting, @Nullable List<ContentSyncSettingArg> contentSyncSettings) {
        super(teamFolderId);
        this.syncSetting = syncSetting;
        if (contentSyncSettings != null) {
            for (ContentSyncSettingArg x : contentSyncSettings) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'contentSyncSettings' is null");
                }
            }
        }
        this.contentSyncSettings = contentSyncSettings;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderUpdateSyncSettingsArg(String teamFolderId) {
        this(teamFolderId, null, null);
    }

    /**
     * The ID of the team folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getTeamFolderId() {
        return teamFolderId;
    }

    /**
     * Sync setting to apply to the team folder itself. Only meaningful if the
     * team folder is not a shared team root.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public SyncSettingArg getSyncSetting() {
        return syncSetting;
    }

    /**
     * Sync settings to apply to contents of this team folder.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @Nullable
    public List<ContentSyncSettingArg> getContentSyncSettings() {
        return contentSyncSettings;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String teamFolderId) {
        return new Builder(teamFolderId);
    }

    /**
     * Builder for {@link TeamFolderUpdateSyncSettingsArg}.
     */
    public static class Builder {
        protected final String teamFolderId;

        protected SyncSettingArg syncSetting;
        protected List<ContentSyncSettingArg> contentSyncSettings;

        protected Builder(String teamFolderId) {
            if (teamFolderId == null) {
                throw new IllegalArgumentException("Required value for 'teamFolderId' is null");
            }
            if (!Pattern.matches("[-_0-9a-zA-Z:]+", teamFolderId)) {
                throw new IllegalArgumentException("String 'teamFolderId' does not match pattern");
            }
            this.teamFolderId = teamFolderId;
            this.syncSetting = null;
            this.contentSyncSettings = null;
        }

        /**
         * Set value for optional field.
         *
         * @param syncSetting  Sync setting to apply to the team folder itself.
         *     Only meaningful if the team folder is not a shared team root.
         *
         * @return this builder
         */
        public Builder withSyncSetting(SyncSettingArg syncSetting) {
            this.syncSetting = syncSetting;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param contentSyncSettings  Sync settings to apply to contents of
         *     this team folder. Must not contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withContentSyncSettings(List<ContentSyncSettingArg> contentSyncSettings) {
            if (contentSyncSettings != null) {
                for (ContentSyncSettingArg x : contentSyncSettings) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'contentSyncSettings' is null");
                    }
                }
            }
            this.contentSyncSettings = contentSyncSettings;
            return this;
        }

        /**
         * Builds an instance of {@link TeamFolderUpdateSyncSettingsArg}
         * configured with this builder's values
         *
         * @return new instance of {@link TeamFolderUpdateSyncSettingsArg}
         */
        public TeamFolderUpdateSyncSettingsArg build() {
            return new TeamFolderUpdateSyncSettingsArg(teamFolderId, syncSetting, contentSyncSettings);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            syncSetting,
            contentSyncSettings
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
            TeamFolderUpdateSyncSettingsArg other = (TeamFolderUpdateSyncSettingsArg) obj;
            return ((this.teamFolderId == other.teamFolderId) || (this.teamFolderId.equals(other.teamFolderId)))
                && ((this.syncSetting == other.syncSetting) || (this.syncSetting != null && this.syncSetting.equals(other.syncSetting)))
                && ((this.contentSyncSettings == other.contentSyncSettings) || (this.contentSyncSettings != null && this.contentSyncSettings.equals(other.contentSyncSettings)))
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
    static class Serializer extends StructSerializer<TeamFolderUpdateSyncSettingsArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(TeamFolderUpdateSyncSettingsArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("team_folder_id");
            StoneSerializers.string().serialize(value.teamFolderId, g);
            if (value.syncSetting != null) {
                g.writeFieldName("sync_setting");
                StoneSerializers.nullable(SyncSettingArg.Serializer.INSTANCE).serialize(value.syncSetting, g);
            }
            if (value.contentSyncSettings != null) {
                g.writeFieldName("content_sync_settings");
                StoneSerializers.nullable(StoneSerializers.list(ContentSyncSettingArg.Serializer.INSTANCE)).serialize(value.contentSyncSettings, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public TeamFolderUpdateSyncSettingsArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            TeamFolderUpdateSyncSettingsArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_teamFolderId = null;
                SyncSettingArg f_syncSetting = null;
                List<ContentSyncSettingArg> f_contentSyncSettings = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("team_folder_id".equals(field)) {
                        f_teamFolderId = StoneSerializers.string().deserialize(p);
                    }
                    else if ("sync_setting".equals(field)) {
                        f_syncSetting = StoneSerializers.nullable(SyncSettingArg.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("content_sync_settings".equals(field)) {
                        f_contentSyncSettings = StoneSerializers.nullable(StoneSerializers.list(ContentSyncSettingArg.Serializer.INSTANCE)).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_teamFolderId == null) {
                    throw new JsonParseException(p, "Required field \"team_folder_id\" missing.");
                }
                value = new TeamFolderUpdateSyncSettingsArg(f_teamFolderId, f_syncSetting, f_contentSyncSettings);
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
