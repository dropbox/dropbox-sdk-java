/* DO NOT EDIT */
/* This file was generated from team_devices.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#devicesListMemberDevicesBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class DevicesListMemberDevicesBuilder {
    private final DbxTeamTeamRequests team_;
    private final ListMemberDevicesArg.Builder listMemberDevicesArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param team_  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param listMemberDevicesArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    DevicesListMemberDevicesBuilder(DbxTeamTeamRequests team_, ListMemberDevicesArg.Builder listMemberDevicesArgBuilder) {
        if (team_ == null) {
            throw new NullPointerException("team_");
        }
        this.team_ = team_;
        if (listMemberDevicesArgBuilder == null) {
            throw new NullPointerException("listMemberDevicesArgBuilder");
        }
        this.listMemberDevicesArgBuilder = listMemberDevicesArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param includeWebSessions  Whether to list web sessions of the team's
     *     member. Defaults to {@code true} when set to {@code null}.
     *
     * @return this builder
     */
    public DevicesListMemberDevicesBuilder withIncludeWebSessions(Boolean includeWebSessions) {
        this.listMemberDevicesArgBuilder.withIncludeWebSessions(includeWebSessions);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param includeDesktopClients  Whether to list linked desktop devices of
     *     the team's member. Defaults to {@code true} when set to {@code null}.
     *
     * @return this builder
     */
    public DevicesListMemberDevicesBuilder withIncludeDesktopClients(Boolean includeDesktopClients) {
        this.listMemberDevicesArgBuilder.withIncludeDesktopClients(includeDesktopClients);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param includeMobileClients  Whether to list linked mobile devices of the
     *     team's member. Defaults to {@code true} when set to {@code null}.
     *
     * @return this builder
     */
    public DevicesListMemberDevicesBuilder withIncludeMobileClients(Boolean includeMobileClients) {
        this.listMemberDevicesArgBuilder.withIncludeMobileClients(includeMobileClients);
        return this;
    }

    /**
     * Issues the request.
     */
    public ListMemberDevicesResult start() throws ListMemberDevicesErrorException, DbxException {
        ListMemberDevicesArg arg_ = this.listMemberDevicesArgBuilder.build();
        return team_.devicesListMemberDevices(arg_);
    }
}
