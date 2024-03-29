/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.files.ContentSyncSettingArg;
import com.dropbox.core.v2.files.SyncSettingArg;

import java.util.List;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#teamFolderUpdateSyncSettingsBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class TeamFolderUpdateSyncSettingsBuilder {
    private final DbxTeamTeamRequests _client;
    private final TeamFolderUpdateSyncSettingsArg.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    TeamFolderUpdateSyncSettingsBuilder(DbxTeamTeamRequests _client, TeamFolderUpdateSyncSettingsArg.Builder _builder) {
        if (_client == null) {
            throw new NullPointerException("_client");
        }
        this._client = _client;
        if (_builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = _builder;
    }

    /**
     * Set value for optional field.
     *
     * @param syncSetting  Sync setting to apply to the team folder itself. Only
     *     meaningful if the team folder is not a shared team root.
     *
     * @return this builder
     */
    public TeamFolderUpdateSyncSettingsBuilder withSyncSetting(SyncSettingArg syncSetting) {
        this._builder.withSyncSetting(syncSetting);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param contentSyncSettings  Sync settings to apply to contents of this
     *     team folder. Must not contain a {@code null} item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderUpdateSyncSettingsBuilder withContentSyncSettings(List<ContentSyncSettingArg> contentSyncSettings) {
        this._builder.withContentSyncSettings(contentSyncSettings);
        return this;
    }

    /**
     * Issues the request.
     */
    public TeamFolderMetadata start() throws TeamFolderUpdateSyncSettingsErrorException, DbxException {
        TeamFolderUpdateSyncSettingsArg arg_ = this._builder.build();
        return _client.teamFolderUpdateSyncSettings(arg_);
    }
}
