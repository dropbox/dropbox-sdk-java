/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#devicesListMembersDevicesBuilder()}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class DevicesListMembersDevicesBuilder {
    private final DbxTeamTeamRequests team_;
    private final ListMembersDevicesArg.Builder listMembersDevicesArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team_  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param listMembersDevicesArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    DevicesListMembersDevicesBuilder(DbxTeamTeamRequests team_, ListMembersDevicesArg.Builder listMembersDevicesArgBuilder) {
        if (team_ == null) {
            throw new NullPointerException("team_");
        }
        this.team_ = team_;
        if (listMembersDevicesArgBuilder == null) {
            throw new NullPointerException("listMembersDevicesArgBuilder");
        }
        this.listMembersDevicesArgBuilder = listMembersDevicesArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param cursor  At the first call to the {@link
     *     DbxTeamTeamRequests#devicesListMembersDevices()} the cursor shouldn't
     *     be passed. Then, if the result of the call includes a cursor, the
     *     following requests should include the received cursors in order to
     *     receive the next sub list of team devices.
     *
     * @return this builder
     */
    public DevicesListMembersDevicesBuilder withCursor(String cursor) {
        this.listMembersDevicesArgBuilder.withCursor(cursor);
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
    public DevicesListMembersDevicesBuilder withIncludeWebSessions(Boolean includeWebSessions) {
        this.listMembersDevicesArgBuilder.withIncludeWebSessions(includeWebSessions);
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
    public DevicesListMembersDevicesBuilder withIncludeDesktopClients(Boolean includeDesktopClients) {
        this.listMembersDevicesArgBuilder.withIncludeDesktopClients(includeDesktopClients);
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
    public DevicesListMembersDevicesBuilder withIncludeMobileClients(Boolean includeMobileClients) {
        this.listMembersDevicesArgBuilder.withIncludeMobileClients(includeMobileClients);
        return this;
    }

    /**
     * Issues the request.
     */
    public ListMembersDevicesResult start() throws ListMembersDevicesErrorException, DbxException {
        ListMembersDevicesArg arg_ = this.listMembersDevicesArgBuilder.build();
        return team_.devicesListMembersDevices(arg_);
    }
}
