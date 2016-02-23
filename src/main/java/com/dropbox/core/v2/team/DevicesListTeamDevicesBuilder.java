/* DO NOT EDIT */
/* This file was generated from team_devices.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxTeam#devicesListTeamDevicesBuilder()}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class DevicesListTeamDevicesBuilder {
    private final DbxTeam team;
    private final ListTeamDevicesArg.Builder listTeamDevicesArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param listTeamDevicesArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    DevicesListTeamDevicesBuilder(DbxTeam team, ListTeamDevicesArg.Builder listTeamDevicesArgBuilder) {
        if (team == null) {
            throw new NullPointerException("team");
        }
        if (listTeamDevicesArgBuilder == null) {
            throw new NullPointerException("listTeamDevicesArgBuilder");
        }
        this.team = team;
        this.listTeamDevicesArgBuilder = listTeamDevicesArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param cursor  At the first call to the {@link
     *     DbxTeam#devicesListTeamDevices()} the cursor shouldn't be passed.
     *     Then, if the result of the call includes a cursor, the following
     *     requests should include the received cursors in order to receive the
     *     next sub list of team devices.
     *
     * @return this builder
     */
    public DevicesListTeamDevicesBuilder withCursor(String cursor) {
        this.listTeamDevicesArgBuilder.withCursor(cursor);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param includeWebSessions  Whether to list web sessions of the team
     *     members. Defaults to {@code true} when set to {@code null}.
     *
     * @return this builder
     */
    public DevicesListTeamDevicesBuilder withIncludeWebSessions(Boolean includeWebSessions) {
        this.listTeamDevicesArgBuilder.withIncludeWebSessions(includeWebSessions);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param includeDesktopClients  Whether to list desktop clients of the team
     *     members. Defaults to {@code true} when set to {@code null}.
     *
     * @return this builder
     */
    public DevicesListTeamDevicesBuilder withIncludeDesktopClients(Boolean includeDesktopClients) {
        this.listTeamDevicesArgBuilder.withIncludeDesktopClients(includeDesktopClients);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param includeMobileClients  Whether to list mobile clients of the team
     *     members. Defaults to {@code true} when set to {@code null}.
     *
     * @return this builder
     */
    public DevicesListTeamDevicesBuilder withIncludeMobileClients(Boolean includeMobileClients) {
        this.listTeamDevicesArgBuilder.withIncludeMobileClients(includeMobileClients);
        return this;
    }

    /**
     * Issues the request.
     */
    public ListTeamDevicesResult start() throws ListTeamDevicesErrorException, DbxException {
        ListTeamDevicesArg arg = this.listTeamDevicesArgBuilder.build();
        return team.devicesListTeamDevices(arg);
    }
}
