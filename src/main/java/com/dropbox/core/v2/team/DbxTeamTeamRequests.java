/* DO NOT EDIT */
/* This file was generated from team_devices.babel, team_members.babel, team_linked_apps.babel, team_reports.babel, team.babel, team_groups.babel, team_common.babel */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.async.LaunchEmptyResult;
import com.dropbox.core.v2.async.PollArg;
import com.dropbox.core.v2.async.PollEmptyResult;
import com.dropbox.core.v2.async.PollErrorException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "team" that support team auth.
 */
public final class DbxTeamTeamRequests {
    // namespace team

    private final DbxRawClientV2 client;

    public DbxTeamTeamRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route team/devices/list_member_devices
    //

    /**
     * List all device sessions of a team's member.
     *
     */
    ListMemberDevicesResult devicesListMemberDevices(ListMemberDevicesArg listMemberDevicesArg) throws ListMemberDevicesErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/devices/list_member_devices",
                                   listMemberDevicesArg,
                                   false,
                                   JsonUtil.createType(ListMemberDevicesResult.class),
                                   JsonUtil.createType(ListMemberDevicesError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListMemberDevicesErrorException(ew.getRequestId(), ew.getUserMessage(), (ListMemberDevicesError) ew.getErrorValue());
        }
    }

    /**
     * List all device sessions of a team's member.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DevicesListMemberDevicesBuilder} for more details. </p>
     *
     * @param teamMemberId  The team's member id. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMemberDevicesResult devicesListMemberDevices(String teamMemberId) throws ListMemberDevicesErrorException, DbxException {
        ListMemberDevicesArg arg = new ListMemberDevicesArg(teamMemberId);
        return devicesListMemberDevices(arg);
    }

    /**
     * List all device sessions of a team's member.
     *
     * @param teamMemberId  The team's member id. Must not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DevicesListMemberDevicesBuilder devicesListMemberDevicesBuilder(String teamMemberId) {
        ListMemberDevicesArg.Builder argBuilder = ListMemberDevicesArg.newBuilder(teamMemberId);
        return new DevicesListMemberDevicesBuilder(this, argBuilder);
    }

    //
    // route team/devices/list_team_devices
    //

    /**
     * List all device sessions of a team.
     *
     */
    ListTeamDevicesResult devicesListTeamDevices(ListTeamDevicesArg listTeamDevicesArg) throws ListTeamDevicesErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/devices/list_team_devices",
                                   listTeamDevicesArg,
                                   false,
                                   JsonUtil.createType(ListTeamDevicesResult.class),
                                   JsonUtil.createType(ListTeamDevicesError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListTeamDevicesErrorException(ew.getRequestId(), ew.getUserMessage(), (ListTeamDevicesError) ew.getErrorValue());
        }
    }

    /**
     * List all device sessions of a team.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DevicesListTeamDevicesBuilder} for more details. </p>
     */
    public ListTeamDevicesResult devicesListTeamDevices() throws ListTeamDevicesErrorException, DbxException {
        ListTeamDevicesArg arg = new ListTeamDevicesArg();
        return devicesListTeamDevices(arg);
    }

    /**
     * List all device sessions of a team.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public DevicesListTeamDevicesBuilder devicesListTeamDevicesBuilder() {
        ListTeamDevicesArg.Builder argBuilder = ListTeamDevicesArg.newBuilder();
        return new DevicesListTeamDevicesBuilder(this, argBuilder);
    }

    //
    // route team/devices/revoke_device_session
    //

    /**
     * Revoke a device session of a team's member
     *
     */
    public void devicesRevokeDeviceSession(RevokeDeviceSessionArg revokeDeviceSessionArg) throws RevokeDeviceSessionErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/team/devices/revoke_device_session",
                            revokeDeviceSessionArg,
                            false,
                            JsonUtil.createType(Void.class),
                            JsonUtil.createType(RevokeDeviceSessionError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RevokeDeviceSessionErrorException(ew.getRequestId(), ew.getUserMessage(), (RevokeDeviceSessionError) ew.getErrorValue());
        }
    }

    //
    // route team/devices/revoke_device_session_batch
    //

    /**
     * Revoke a list of device sessions of team members
     *
     */
    RevokeDeviceSessionBatchResult devicesRevokeDeviceSessionBatch(RevokeDeviceSessionBatchArg revokeDeviceSessionBatchArg) throws RevokeDeviceSessionBatchErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/devices/revoke_device_session_batch",
                                   revokeDeviceSessionBatchArg,
                                   false,
                                   JsonUtil.createType(RevokeDeviceSessionBatchResult.class),
                                   JsonUtil.createType(RevokeDeviceSessionBatchError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RevokeDeviceSessionBatchErrorException(ew.getRequestId(), ew.getUserMessage(), (RevokeDeviceSessionBatchError) ew.getErrorValue());
        }
    }

    /**
     * Revoke a list of device sessions of team members
     *
     * @param revokeDevices  Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDeviceSessionBatchResult devicesRevokeDeviceSessionBatch(List<RevokeDeviceSessionArg> revokeDevices) throws RevokeDeviceSessionBatchErrorException, DbxException {
        RevokeDeviceSessionBatchArg arg = new RevokeDeviceSessionBatchArg(revokeDevices);
        return devicesRevokeDeviceSessionBatch(arg);
    }

    //
    // route team/get_info
    //

    /**
     * Retrieves information about a team.
     */
    public TeamGetInfoResult getInfo() throws DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/get_info",
                                   null,
                                   false,
                                   JsonUtil.createType(TeamGetInfoResult.class),
                                   JsonUtil.createType(Void.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DbxApiException(ew.getRequestId(), ew.getUserMessage(), "Unexpected error response for \"get_info\": ew.errValue");
        }
    }

    //
    // route team/groups/create
    //

    /**
     * Creates a new, empty group, with a requested name. Permission : Team
     * member management
     *
     *
     * @return Full description of a group.
     */
    GroupFullInfo groupsCreate(GroupCreateArg groupCreateArg) throws GroupCreateErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/groups/create",
                                   groupCreateArg,
                                   false,
                                   JsonUtil.createType(GroupFullInfo.class),
                                   JsonUtil.createType(GroupCreateError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GroupCreateErrorException(ew.getRequestId(), ew.getUserMessage(), (GroupCreateError) ew.getErrorValue());
        }
    }

    /**
     * Creates a new, empty group, with a requested name. Permission : Team
     * member management
     *
     * @param groupName  Group name. Must not be {@code null}.
     *
     * @return Full description of a group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo groupsCreate(String groupName) throws GroupCreateErrorException, DbxException {
        GroupCreateArg arg = new GroupCreateArg(groupName);
        return groupsCreate(arg);
    }

    /**
     * Creates a new, empty group, with a requested name. Permission : Team
     * member management
     *
     * @param groupName  Group name. Must not be {@code null}.
     * @param groupExternalId  Optional argument. The creator of a team can
     *     associate an arbitrary external ID to the group.
     *
     * @return Full description of a group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo groupsCreate(String groupName, String groupExternalId) throws GroupCreateErrorException, DbxException {
        GroupCreateArg arg = new GroupCreateArg(groupName, groupExternalId);
        return groupsCreate(arg);
    }

    //
    // route team/groups/delete
    //

    /**
     * Deletes a group. The group is deleted immediately. However the revoking
     * of group-owned resources may take additional time. Use the {@link
     * DbxTeamTeamRequests#groupsJobStatusGet(String)} to determine whether this
     * process has completed. Permission : Team member management
     *
     * @param groupSelector  Argument for selecting a single group, either by
     *     group_id or by external group ID.
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     */
    public LaunchEmptyResult groupsDelete(GroupSelector groupSelector) throws GroupDeleteErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/groups/delete",
                                   groupSelector,
                                   false,
                                   JsonUtil.createType(LaunchEmptyResult.class),
                                   JsonUtil.createType(GroupDeleteError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GroupDeleteErrorException(ew.getRequestId(), ew.getUserMessage(), (GroupDeleteError) ew.getErrorValue());
        }
    }

    //
    // route team/groups/get_info
    //

    /**
     * Retrieves information about one or more groups. Permission : Team
     * Information
     *
     * @param groupsSelector  Argument for selecting a list of groups, either by
     *     group_ids, or external group IDs.
     */
    public List<GroupsGetInfoItem> groupsGetInfo(GroupsSelector groupsSelector) throws GroupsGetInfoErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/groups/get_info",
                                   groupsSelector,
                                   false,
                                   JsonUtil.createType(new TypeReference<List<GroupsGetInfoItem>>() {}),
                                   JsonUtil.createType(GroupsGetInfoError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GroupsGetInfoErrorException(ew.getRequestId(), ew.getUserMessage(), (GroupsGetInfoError) ew.getErrorValue());
        }
    }

    //
    // route team/groups/job_status/get
    //

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#groupsDelete(GroupSelector)}, {@link
     * DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List)} , or {@link
     * DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List)} use this
     * method to poll the status of granting/revoking group members' access to
     * group-owned resources. Permission : Team member management
     *
     * @param pollArg  Arguments for methods that poll the status of an
     *     asynchronous job.
     *
     * @return Result returned by methods that poll for the status of an
     *     asynchronous job. Upon completion of the job, no additional
     *     information is returned.
     */
    PollEmptyResult groupsJobStatusGet(PollArg pollArg) throws GroupsPollErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/groups/job_status/get",
                                   pollArg,
                                   false,
                                   JsonUtil.createType(PollEmptyResult.class),
                                   JsonUtil.createType(GroupsPollError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GroupsPollErrorException(ew.getRequestId(), ew.getUserMessage(), (GroupsPollError) ew.getErrorValue());
        }
    }

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#groupsDelete(GroupSelector)}, {@link
     * DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List)} , or {@link
     * DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List)} use this
     * method to poll the status of granting/revoking group members' access to
     * group-owned resources. Permission : Team member management
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @return Result returned by methods that poll for the status of an
     *     asynchronous job. Upon completion of the job, no additional
     *     information is returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PollEmptyResult groupsJobStatusGet(String asyncJobId) throws GroupsPollErrorException, DbxException {
        PollArg arg = new PollArg(asyncJobId);
        return groupsJobStatusGet(arg);
    }

    //
    // route team/groups/list
    //

    /**
     * Lists groups on a team. Permission : Team Information
     *
     */
    GroupsListResult groupsList(GroupsListArg groupsListArg) throws DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/groups/list",
                                   groupsListArg,
                                   false,
                                   JsonUtil.createType(GroupsListResult.class),
                                   JsonUtil.createType(Void.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DbxApiException(ew.getRequestId(), ew.getUserMessage(), "Unexpected error response for \"groups/list\": ew.errValue");
        }
    }

    /**
     * Lists groups on a team. Permission : Team Information
     *
     * <p> The {@code limit} request parameter will default to {@code 1000L}
     * (see {@link #groupsList(long)}). </p>
     */
    public GroupsListResult groupsList() throws DbxException {
        GroupsListArg arg = new GroupsListArg();
        return groupsList(arg);
    }

    /**
     * Lists groups on a team. Permission : Team Information
     *
     * @param limit  Number of results to return per call. Must be greater than
     *     or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsListResult groupsList(long limit) throws DbxException {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        GroupsListArg arg = new GroupsListArg(limit);
        return groupsList(arg);
    }

    //
    // route team/groups/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#groupsList()}, use this to paginate through all
     * groups. Permission : Team information
     *
     */
    GroupsListResult groupsListContinue(GroupsListContinueArg groupsListContinueArg) throws GroupsListContinueErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/groups/list/continue",
                                   groupsListContinueArg,
                                   false,
                                   JsonUtil.createType(GroupsListResult.class),
                                   JsonUtil.createType(GroupsListContinueError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GroupsListContinueErrorException(ew.getRequestId(), ew.getUserMessage(), (GroupsListContinueError) ew.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#groupsList()}, use this to paginate through all
     * groups. Permission : Team information
     *
     * @param cursor  Indicates from what point to get the next set of groups.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsListResult groupsListContinue(String cursor) throws GroupsListContinueErrorException, DbxException {
        GroupsListContinueArg arg = new GroupsListContinueArg(cursor);
        return groupsListContinue(arg);
    }

    //
    // route team/groups/members/add
    //

    /**
     * Adds members to a group. The members are added immediately. However the
     * granting of group-owned resources may take additional time. Use the
     * {@link DbxTeamTeamRequests#groupsJobStatusGet(String)} to determine
     * whether this process has completed. Permission : Team member management
     *
     *
     * @return Result returned by {@link
     *     DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List)} and {@link
     *     DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List)}.
     */
    GroupMembersChangeResult groupsMembersAdd(GroupMembersAddArg groupMembersAddArg) throws GroupMembersAddErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/groups/members/add",
                                   groupMembersAddArg,
                                   false,
                                   JsonUtil.createType(GroupMembersChangeResult.class),
                                   JsonUtil.createType(GroupMembersAddError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GroupMembersAddErrorException(ew.getRequestId(), ew.getUserMessage(), (GroupMembersAddError) ew.getErrorValue());
        }
    }

    /**
     * Adds members to a group. The members are added immediately. However the
     * granting of group-owned resources may take additional time. Use the
     * {@link DbxTeamTeamRequests#groupsJobStatusGet(String)} to determine
     * whether this process has completed. Permission : Team member management
     *
     * @param group  Group to which users will be added. Must not be {@code
     *     null}.
     * @param members  List of users to be added to the group. Must not contain
     *     a {@code null} item and not be {@code null}.
     *
     * @return Result returned by {@link
     *     DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List)} and {@link
     *     DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersChangeResult groupsMembersAdd(GroupSelector group, List<MemberAccess> members) throws GroupMembersAddErrorException, DbxException {
        GroupMembersAddArg arg = new GroupMembersAddArg(group, members);
        return groupsMembersAdd(arg);
    }

    //
    // route team/groups/members/remove
    //

    /**
     * Removes members from a group. The members are removed immediately.
     * However the revoking of group-owned resources may take additional time.
     * Use the {@link DbxTeamTeamRequests#groupsJobStatusGet(String)} to
     * determine whether this process has completed. Permission : Team member
     * management
     *
     *
     * @return Result returned by {@link
     *     DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List)} and {@link
     *     DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List)}.
     */
    GroupMembersChangeResult groupsMembersRemove(GroupMembersRemoveArg groupMembersRemoveArg) throws GroupMembersRemoveErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/groups/members/remove",
                                   groupMembersRemoveArg,
                                   false,
                                   JsonUtil.createType(GroupMembersChangeResult.class),
                                   JsonUtil.createType(GroupMembersRemoveError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GroupMembersRemoveErrorException(ew.getRequestId(), ew.getUserMessage(), (GroupMembersRemoveError) ew.getErrorValue());
        }
    }

    /**
     * Removes members from a group. The members are removed immediately.
     * However the revoking of group-owned resources may take additional time.
     * Use the {@link DbxTeamTeamRequests#groupsJobStatusGet(String)} to
     * determine whether this process has completed. Permission : Team member
     * management
     *
     * @param group  Must not be {@code null}.
     * @param users  Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @return Result returned by {@link
     *     DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List)} and {@link
     *     DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersChangeResult groupsMembersRemove(GroupSelector group, List<UserSelectorArg> users) throws GroupMembersRemoveErrorException, DbxException {
        GroupMembersRemoveArg arg = new GroupMembersRemoveArg(group, users);
        return groupsMembersRemove(arg);
    }

    //
    // route team/groups/members/set_access_type
    //

    /**
     * Sets a member's access type in a group. Permission : Team member
     * management
     *
     */
    List<GroupsGetInfoItem> groupsMembersSetAccessType(GroupMembersSetAccessTypeArg groupMembersSetAccessTypeArg) throws GroupMemberSelectorErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/groups/members/set_access_type",
                                   groupMembersSetAccessTypeArg,
                                   false,
                                   JsonUtil.createType(new TypeReference<List<GroupsGetInfoItem>>() {}),
                                   JsonUtil.createType(GroupMemberSelectorError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GroupMemberSelectorErrorException(ew.getRequestId(), ew.getUserMessage(), (GroupMemberSelectorError) ew.getErrorValue());
        }
    }

    /**
     * Sets a member's access type in a group. Permission : Team member
     * management
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param user  Identity of a user that is a member of {@link
     *     GroupMemberSelector#getGroup}. Must not be {@code null}.
     * @param accessType  New group access type the user will have. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<GroupsGetInfoItem> groupsMembersSetAccessType(GroupSelector group, UserSelectorArg user, GroupAccessType accessType) throws GroupMemberSelectorErrorException, DbxException {
        GroupMembersSetAccessTypeArg arg = new GroupMembersSetAccessTypeArg(group, user, accessType);
        return groupsMembersSetAccessType(arg);
    }

    //
    // route team/groups/update
    //

    /**
     * Updates a group's name and/or external ID. Permission : Team member
     * management
     *
     *
     * @return Full description of a group.
     */
    GroupFullInfo groupsUpdate(GroupUpdateArgs groupUpdateArgs) throws GroupUpdateErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/groups/update",
                                   groupUpdateArgs,
                                   false,
                                   JsonUtil.createType(GroupFullInfo.class),
                                   JsonUtil.createType(GroupUpdateError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GroupUpdateErrorException(ew.getRequestId(), ew.getUserMessage(), (GroupUpdateError) ew.getErrorValue());
        }
    }

    /**
     * Updates a group's name and/or external ID. Permission : Team member
     * management
     *
     * @param group  Specify a group. Must not be {@code null}.
     *
     * @return Full description of a group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo groupsUpdate(GroupSelector group) throws GroupUpdateErrorException, DbxException {
        GroupUpdateArgs arg = new GroupUpdateArgs(group);
        return groupsUpdate(arg);
    }

    /**
     * Updates a group's name and/or external ID. Permission : Team member
     * management
     *
     * @param group  Specify a group. Must not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsUpdateBuilder groupsUpdateBuilder(GroupSelector group) {
        GroupUpdateArgs.Builder argBuilder = GroupUpdateArgs.newBuilder(group);
        return new GroupsUpdateBuilder(this, argBuilder);
    }

    //
    // route team/linked_apps/list_member_linked_apps
    //

    /**
     * List all linked applications of the team member. Note, this endpoint
     * doesn't list any team-linked applications.
     *
     */
    ListMemberAppsResult linkedAppsListMemberLinkedApps(ListMemberAppsArg listMemberAppsArg) throws ListMemberAppsErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/linked_apps/list_member_linked_apps",
                                   listMemberAppsArg,
                                   false,
                                   JsonUtil.createType(ListMemberAppsResult.class),
                                   JsonUtil.createType(ListMemberAppsError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListMemberAppsErrorException(ew.getRequestId(), ew.getUserMessage(), (ListMemberAppsError) ew.getErrorValue());
        }
    }

    /**
     * List all linked applications of the team member. Note, this endpoint
     * doesn't list any team-linked applications.
     *
     * @param teamMemberId  The team member id. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMemberAppsResult linkedAppsListMemberLinkedApps(String teamMemberId) throws ListMemberAppsErrorException, DbxException {
        ListMemberAppsArg arg = new ListMemberAppsArg(teamMemberId);
        return linkedAppsListMemberLinkedApps(arg);
    }

    //
    // route team/linked_apps/list_team_linked_apps
    //

    /**
     * List all applications linked to the team members' accounts. Note, this
     * endpoint doesn't list any team-linked applications.
     *
     * @param listTeamAppsArg  Arguments for {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}.
     *
     * @return Information returned by {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}.
     */
    ListTeamAppsResult linkedAppsListTeamLinkedApps(ListTeamAppsArg listTeamAppsArg) throws ListTeamAppsErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/linked_apps/list_team_linked_apps",
                                   listTeamAppsArg,
                                   false,
                                   JsonUtil.createType(ListTeamAppsResult.class),
                                   JsonUtil.createType(ListTeamAppsError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListTeamAppsErrorException(ew.getRequestId(), ew.getUserMessage(), (ListTeamAppsError) ew.getErrorValue());
        }
    }

    /**
     * List all applications linked to the team members' accounts. Note, this
     * endpoint doesn't list any team-linked applications.
     *
     * @return Information returned by {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}.
     */
    public ListTeamAppsResult linkedAppsListTeamLinkedApps() throws ListTeamAppsErrorException, DbxException {
        ListTeamAppsArg arg = new ListTeamAppsArg();
        return linkedAppsListTeamLinkedApps(arg);
    }

    /**
     * List all applications linked to the team members' accounts. Note, this
     * endpoint doesn't list any team-linked applications.
     *
     * @param cursor  At the first call to the {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()} the cursor
     *     shouldn't be passed. Then, if the result of the call includes a
     *     cursor, the following requests should include the received cursors in
     *     order to receive the next sub list of the team applications.
     *
     * @return Information returned by {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps()}.
     */
    public ListTeamAppsResult linkedAppsListTeamLinkedApps(String cursor) throws ListTeamAppsErrorException, DbxException {
        ListTeamAppsArg arg = new ListTeamAppsArg(cursor);
        return linkedAppsListTeamLinkedApps(arg);
    }

    //
    // route team/linked_apps/revoke_linked_app
    //

    /**
     * Revoke a linked application of the team member
     *
     */
    void linkedAppsRevokeLinkedApp(RevokeLinkedApiAppArg revokeLinkedApiAppArg) throws RevokeLinkedAppErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/team/linked_apps/revoke_linked_app",
                            revokeLinkedApiAppArg,
                            false,
                            JsonUtil.createType(Void.class),
                            JsonUtil.createType(RevokeLinkedAppError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RevokeLinkedAppErrorException(ew.getRequestId(), ew.getUserMessage(), (RevokeLinkedAppError) ew.getErrorValue());
        }
    }

    /**
     * Revoke a linked application of the team member
     *
     * <p> The {@code keepAppFolder} request parameter will default to {@code
     * true} (see {@link #linkedAppsRevokeLinkedApp(String,String,boolean)}).
     * </p>
     *
     * @param appId  The application's unique id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void linkedAppsRevokeLinkedApp(String appId, String teamMemberId) throws RevokeLinkedAppErrorException, DbxException {
        RevokeLinkedApiAppArg arg = new RevokeLinkedApiAppArg(appId, teamMemberId);
        linkedAppsRevokeLinkedApp(arg);
    }

    /**
     * Revoke a linked application of the team member
     *
     * @param appId  The application's unique id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     * @param keepAppFolder  Whether to keep the application dedicated folder
     *     (in case the application uses  one).
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void linkedAppsRevokeLinkedApp(String appId, String teamMemberId, boolean keepAppFolder) throws RevokeLinkedAppErrorException, DbxException {
        RevokeLinkedApiAppArg arg = new RevokeLinkedApiAppArg(appId, teamMemberId, keepAppFolder);
        linkedAppsRevokeLinkedApp(arg);
    }

    //
    // route team/linked_apps/revoke_linked_app_batch
    //

    /**
     * Revoke a list of linked applications of the team members
     *
     */
    RevokeLinkedAppBatchResult linkedAppsRevokeLinkedAppBatch(RevokeLinkedApiAppBatchArg revokeLinkedApiAppBatchArg) throws RevokeLinkedAppBatchErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/linked_apps/revoke_linked_app_batch",
                                   revokeLinkedApiAppBatchArg,
                                   false,
                                   JsonUtil.createType(RevokeLinkedAppBatchResult.class),
                                   JsonUtil.createType(RevokeLinkedAppBatchError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RevokeLinkedAppBatchErrorException(ew.getRequestId(), ew.getUserMessage(), (RevokeLinkedAppBatchError) ew.getErrorValue());
        }
    }

    /**
     * Revoke a list of linked applications of the team members
     *
     * @param revokeLinkedApp  Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeLinkedAppBatchResult linkedAppsRevokeLinkedAppBatch(List<RevokeLinkedApiAppArg> revokeLinkedApp) throws RevokeLinkedAppBatchErrorException, DbxException {
        RevokeLinkedApiAppBatchArg arg = new RevokeLinkedApiAppBatchArg(revokeLinkedApp);
        return linkedAppsRevokeLinkedAppBatch(arg);
    }

    //
    // route team/members/add
    //

    /**
     * Adds members to a team. Permission : Team member management A maximum of
     * 20 members can be specified in a single call. If no Dropbox account
     * exists with the email address specified, a new Dropbox account will be
     * created with the given email address, and that account will be invited to
     * the team. If a personal Dropbox account exists with the email address
     * specified in the call, this call will create a placeholder Dropbox
     * account for the user on the team and send an email inviting the user to
     * migrate their existing personal account onto the team. Team member
     * management apps are required to set an initial given_name and surname for
     * a user to use in the team invitation and for 'Perform as team member'
     * actions taken on the user before they become 'active'.
     *
     */
    MembersAddLaunch membersAdd(MembersAddArg membersAddArg) throws DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/members/add",
                                   membersAddArg,
                                   false,
                                   JsonUtil.createType(MembersAddLaunch.class),
                                   JsonUtil.createType(Void.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DbxApiException(ew.getRequestId(), ew.getUserMessage(), "Unexpected error response for \"members/add\": ew.errValue");
        }
    }

    /**
     * Adds members to a team. Permission : Team member management A maximum of
     * 20 members can be specified in a single call. If no Dropbox account
     * exists with the email address specified, a new Dropbox account will be
     * created with the given email address, and that account will be invited to
     * the team. If a personal Dropbox account exists with the email address
     * specified in the call, this call will create a placeholder Dropbox
     * account for the user on the team and send an email inviting the user to
     * migrate their existing personal account onto the team. Team member
     * management apps are required to set an initial given_name and surname for
     * a user to use in the team invitation and for 'Perform as team member'
     * actions taken on the user before they become 'active'.
     *
     * <p> The {@code forceAsync} request parameter will default to {@code
     * false} (see {@link #membersAdd(List,boolean)}). </p>
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddLaunch membersAdd(List<MemberAddArg> newMembers) throws DbxException {
        MembersAddArg arg = new MembersAddArg(newMembers);
        return membersAdd(arg);
    }

    /**
     * Adds members to a team. Permission : Team member management A maximum of
     * 20 members can be specified in a single call. If no Dropbox account
     * exists with the email address specified, a new Dropbox account will be
     * created with the given email address, and that account will be invited to
     * the team. If a personal Dropbox account exists with the email address
     * specified in the call, this call will create a placeholder Dropbox
     * account for the user on the team and send an email inviting the user to
     * migrate their existing personal account onto the team. Team member
     * management apps are required to set an initial given_name and surname for
     * a user to use in the team invitation and for 'Perform as team member'
     * actions taken on the user before they become 'active'.
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param forceAsync  Whether to force the add to happen asynchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddLaunch membersAdd(List<MemberAddArg> newMembers, boolean forceAsync) throws DbxException {
        MembersAddArg arg = new MembersAddArg(newMembers, forceAsync);
        return membersAdd(arg);
    }

    //
    // route team/members/add/job_status/get
    //

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersAdd(List)} , use this to poll the status of
     * the asynchronous request. Permission : Team member management
     *
     * @param pollArg  Arguments for methods that poll the status of an
     *     asynchronous job.
     */
    MembersAddJobStatus membersAddJobStatusGet(PollArg pollArg) throws PollErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/members/add/job_status/get",
                                   pollArg,
                                   false,
                                   JsonUtil.createType(MembersAddJobStatus.class),
                                   JsonUtil.createType(com.dropbox.core.v2.async.PollError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new PollErrorException(ew.getRequestId(), ew.getUserMessage(), (com.dropbox.core.v2.async.PollError) ew.getErrorValue());
        }
    }

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersAdd(List)} , use this to poll the status of
     * the asynchronous request. Permission : Team member management
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddJobStatus membersAddJobStatusGet(String asyncJobId) throws PollErrorException, DbxException {
        PollArg arg = new PollArg(asyncJobId);
        return membersAddJobStatusGet(arg);
    }

    //
    // route team/members/get_info
    //

    /**
     * Returns information about multiple team members. Permission : Team
     * information This endpoint will return an empty member_info item, for IDs
     * (or emails) that cannot be matched to a valid team member.
     *
     */
    List<MembersGetInfoItem> membersGetInfo(MembersGetInfoArgs membersGetInfoArgs) throws MembersGetInfoErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/members/get_info",
                                   membersGetInfoArgs,
                                   false,
                                   JsonUtil.createType(new TypeReference<List<MembersGetInfoItem>>() {}),
                                   JsonUtil.createType(MembersGetInfoError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MembersGetInfoErrorException(ew.getRequestId(), ew.getUserMessage(), (MembersGetInfoError) ew.getErrorValue());
        }
    }

    /**
     * Returns information about multiple team members. Permission : Team
     * information This endpoint will return an empty member_info item, for IDs
     * (or emails) that cannot be matched to a valid team member.
     *
     * @param members  List of team members. Must not contain a {@code null}
     *     item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<MembersGetInfoItem> membersGetInfo(List<UserSelectorArg> members) throws MembersGetInfoErrorException, DbxException {
        MembersGetInfoArgs arg = new MembersGetInfoArgs(members);
        return membersGetInfo(arg);
    }

    //
    // route team/members/list
    //

    /**
     * Lists members of a team. Permission : Team information
     *
     */
    MembersListResult membersList(MembersListArg membersListArg) throws MembersListErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/members/list",
                                   membersListArg,
                                   false,
                                   JsonUtil.createType(MembersListResult.class),
                                   JsonUtil.createType(MembersListError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MembersListErrorException(ew.getRequestId(), ew.getUserMessage(), (MembersListError) ew.getErrorValue());
        }
    }

    /**
     * Lists members of a team. Permission : Team information
     *
     * <p> The {@code limit} request parameter will default to {@code 1000L}
     * (see {@link #membersList(long)}). </p>
     */
    public MembersListResult membersList() throws MembersListErrorException, DbxException {
        MembersListArg arg = new MembersListArg();
        return membersList(arg);
    }

    /**
     * Lists members of a team. Permission : Team information
     *
     * @param limit  Number of results to return per call. Must be greater than
     *     or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersListResult membersList(long limit) throws MembersListErrorException, DbxException {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        MembersListArg arg = new MembersListArg(limit);
        return membersList(arg);
    }

    //
    // route team/members/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#membersList()}, use this to paginate through all team
     * members. Permission : Team information
     *
     */
    MembersListResult membersListContinue(MembersListContinueArg membersListContinueArg) throws MembersListContinueErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/members/list/continue",
                                   membersListContinueArg,
                                   false,
                                   JsonUtil.createType(MembersListResult.class),
                                   JsonUtil.createType(MembersListContinueError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MembersListContinueErrorException(ew.getRequestId(), ew.getUserMessage(), (MembersListContinueError) ew.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#membersList()}, use this to paginate through all team
     * members. Permission : Team information
     *
     * @param cursor  Indicates from what point to get the next set of members.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersListResult membersListContinue(String cursor) throws MembersListContinueErrorException, DbxException {
        MembersListContinueArg arg = new MembersListContinueArg(cursor);
        return membersListContinue(arg);
    }

    //
    // route team/members/remove
    //

    /**
     * Removes a member from a team. Permission : Team member management Exactly
     * one of team_member_id, email, or external_id must be provided to identify
     * the user account. This is not a deactivation where the account can be
     * re-activated again. Calling {@link DbxTeamTeamRequests#membersAdd(List)}
     * with the removed user's email address will create a new account with a
     * new team_member_id that will not have access to any content that was
     * shared with the initial account. This endpoint may initiate an
     * asynchronous job. To obtain the final result of the job, the client
     * should periodically poll {@link
     * DbxTeamTeamRequests#membersRemoveJobStatusGet(String)}.
     *
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     */
    LaunchEmptyResult membersRemove(MembersRemoveArg membersRemoveArg) throws MembersRemoveErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/members/remove",
                                   membersRemoveArg,
                                   false,
                                   JsonUtil.createType(LaunchEmptyResult.class),
                                   JsonUtil.createType(MembersRemoveError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MembersRemoveErrorException(ew.getRequestId(), ew.getUserMessage(), (MembersRemoveError) ew.getErrorValue());
        }
    }

    /**
     * Removes a member from a team. Permission : Team member management Exactly
     * one of team_member_id, email, or external_id must be provided to identify
     * the user account. This is not a deactivation where the account can be
     * re-activated again. Calling {@link DbxTeamTeamRequests#membersAdd(List)}
     * with the removed user's email address will create a new account with a
     * new team_member_id that will not have access to any content that was
     * shared with the initial account. This endpoint may initiate an
     * asynchronous job. To obtain the final result of the job, the client
     * should periodically poll {@link
     * DbxTeamTeamRequests#membersRemoveJobStatusGet(String)}.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link MembersRemoveBuilder} for more details. </p>
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LaunchEmptyResult membersRemove(UserSelectorArg user) throws MembersRemoveErrorException, DbxException {
        MembersRemoveArg arg = new MembersRemoveArg(user);
        return membersRemove(arg);
    }

    /**
     * Removes a member from a team. Permission : Team member management Exactly
     * one of team_member_id, email, or external_id must be provided to identify
     * the user account. This is not a deactivation where the account can be
     * re-activated again. Calling {@link DbxTeamTeamRequests#membersAdd(List)}
     * with the removed user's email address will create a new account with a
     * new team_member_id that will not have access to any content that was
     * shared with the initial account. This endpoint may initiate an
     * asynchronous job. To obtain the final result of the job, the client
     * should periodically poll {@link
     * DbxTeamTeamRequests#membersRemoveJobStatusGet(String)}.
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersRemoveBuilder membersRemoveBuilder(UserSelectorArg user) {
        MembersRemoveArg.Builder argBuilder = MembersRemoveArg.newBuilder(user);
        return new MembersRemoveBuilder(this, argBuilder);
    }

    //
    // route team/members/remove/job_status/get
    //

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersRemove(UserSelectorArg)} , use this to poll
     * the status of the asynchronous request. Permission : Team member
     * management
     *
     * @param pollArg  Arguments for methods that poll the status of an
     *     asynchronous job.
     *
     * @return Result returned by methods that poll for the status of an
     *     asynchronous job. Upon completion of the job, no additional
     *     information is returned.
     */
    PollEmptyResult membersRemoveJobStatusGet(PollArg pollArg) throws PollErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/members/remove/job_status/get",
                                   pollArg,
                                   false,
                                   JsonUtil.createType(PollEmptyResult.class),
                                   JsonUtil.createType(com.dropbox.core.v2.async.PollError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new PollErrorException(ew.getRequestId(), ew.getUserMessage(), (com.dropbox.core.v2.async.PollError) ew.getErrorValue());
        }
    }

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersRemove(UserSelectorArg)} , use this to poll
     * the status of the asynchronous request. Permission : Team member
     * management
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @return Result returned by methods that poll for the status of an
     *     asynchronous job. Upon completion of the job, no additional
     *     information is returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PollEmptyResult membersRemoveJobStatusGet(String asyncJobId) throws PollErrorException, DbxException {
        PollArg arg = new PollArg(asyncJobId);
        return membersRemoveJobStatusGet(arg);
    }

    //
    // route team/members/send_welcome_email
    //

    /**
     * Sends welcome email to pending team member. Permission : Team member
     * management Exactly one of team_member_id, email, or external_id must be
     * provided to identify the user account. No-op if team member is not
     * pending.
     *
     * @param userSelectorArg  Argument for selecting a single user, either by
     *     team_member_id, external_id or email.
     */
    public void membersSendWelcomeEmail(UserSelectorArg userSelectorArg) throws MembersSendWelcomeErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/team/members/send_welcome_email",
                            userSelectorArg,
                            false,
                            JsonUtil.createType(Void.class),
                            JsonUtil.createType(MembersSendWelcomeError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MembersSendWelcomeErrorException(ew.getRequestId(), ew.getUserMessage(), (MembersSendWelcomeError) ew.getErrorValue());
        }
    }

    //
    // route team/members/set_admin_permissions
    //

    /**
     * Updates a team member's permissions. Permission : Team member management
     *
     * @param membersSetPermissionsArg  Exactly one of team_member_id, email, or
     *     external_id must be provided to identify the user account.
     */
    MembersSetPermissionsResult membersSetAdminPermissions(MembersSetPermissionsArg membersSetPermissionsArg) throws MembersSetPermissionsErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/members/set_admin_permissions",
                                   membersSetPermissionsArg,
                                   false,
                                   JsonUtil.createType(MembersSetPermissionsResult.class),
                                   JsonUtil.createType(MembersSetPermissionsError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MembersSetPermissionsErrorException(ew.getRequestId(), ew.getUserMessage(), (MembersSetPermissionsError) ew.getErrorValue());
        }
    }

    /**
     * Updates a team member's permissions. Permission : Team member management
     *
     * @param user  Identity of user whose role will be set. Must not be {@code
     *     null}.
     * @param newRole  The new role of the member. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissionsResult membersSetAdminPermissions(UserSelectorArg user, AdminTier newRole) throws MembersSetPermissionsErrorException, DbxException {
        MembersSetPermissionsArg arg = new MembersSetPermissionsArg(user, newRole);
        return membersSetAdminPermissions(arg);
    }

    //
    // route team/members/set_profile
    //

    /**
     * Updates a team member's profile. Permission : Team member management
     *
     * @param membersSetProfileArg  Exactly one of team_member_id, email, or
     *     external_id must be provided to identify the user account. At least
     *     one of new_email, new_external_id, new_given_name, and/or new_surname
     *     must be provided.
     *
     * @return Information about a team member.
     */
    TeamMemberInfo membersSetProfile(MembersSetProfileArg membersSetProfileArg) throws MembersSetProfileErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/members/set_profile",
                                   membersSetProfileArg,
                                   false,
                                   JsonUtil.createType(TeamMemberInfo.class),
                                   JsonUtil.createType(MembersSetProfileError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MembersSetProfileErrorException(ew.getRequestId(), ew.getUserMessage(), (MembersSetProfileError) ew.getErrorValue());
        }
    }

    /**
     * Updates a team member's profile. Permission : Team member management
     *
     * @param user  Identity of user whose profile will be set. Must not be
     *     {@code null}.
     *
     * @return Information about a team member.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfo membersSetProfile(UserSelectorArg user) throws MembersSetProfileErrorException, DbxException {
        MembersSetProfileArg arg = new MembersSetProfileArg(user);
        return membersSetProfile(arg);
    }

    /**
     * Updates a team member's profile. Permission : Team member management
     *
     * @param user  Identity of user whose profile will be set. Must not be
     *     {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetProfileBuilder membersSetProfileBuilder(UserSelectorArg user) {
        MembersSetProfileArg.Builder argBuilder = MembersSetProfileArg.newBuilder(user);
        return new MembersSetProfileBuilder(this, argBuilder);
    }

    //
    // route team/members/suspend
    //

    /**
     * Suspend a member from a team. Permission : Team member management Exactly
     * one of team_member_id, email, or external_id must be provided to identify
     * the user account.
     *
     * @param membersDeactivateArg  Exactly one of team_member_id, email, or
     *     external_id must be provided to identify the user account.
     */
    void membersSuspend(MembersDeactivateArg membersDeactivateArg) throws MembersSuspendErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/team/members/suspend",
                            membersDeactivateArg,
                            false,
                            JsonUtil.createType(Void.class),
                            JsonUtil.createType(MembersSuspendError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MembersSuspendErrorException(ew.getRequestId(), ew.getUserMessage(), (MembersSuspendError) ew.getErrorValue());
        }
    }

    /**
     * Suspend a member from a team. Permission : Team member management Exactly
     * one of team_member_id, email, or external_id must be provided to identify
     * the user account.
     *
     * <p> The {@code wipeData} request parameter will default to {@code true}
     * (see {@link #membersSuspend(UserSelectorArg,boolean)}). </p>
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void membersSuspend(UserSelectorArg user) throws MembersSuspendErrorException, DbxException {
        MembersDeactivateArg arg = new MembersDeactivateArg(user);
        membersSuspend(arg);
    }

    /**
     * Suspend a member from a team. Permission : Team member management Exactly
     * one of team_member_id, email, or external_id must be provided to identify
     * the user account.
     *
     * @param user  Identity of user to remove/suspend. Must not be {@code
     *     null}.
     * @param wipeData  If provided, controls if the user's data will be deleted
     *     on their linked devices.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void membersSuspend(UserSelectorArg user, boolean wipeData) throws MembersSuspendErrorException, DbxException {
        MembersDeactivateArg arg = new MembersDeactivateArg(user, wipeData);
        membersSuspend(arg);
    }

    //
    // route team/members/unsuspend
    //

    /**
     * Unsuspend a member from a team. Permission : Team member management
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * @param membersUnsuspendArg  Exactly one of team_member_id, email, or
     *     external_id must be provided to identify the user account.
     */
    void membersUnsuspend(MembersUnsuspendArg membersUnsuspendArg) throws MembersUnsuspendErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/team/members/unsuspend",
                            membersUnsuspendArg,
                            false,
                            JsonUtil.createType(Void.class),
                            JsonUtil.createType(MembersUnsuspendError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MembersUnsuspendErrorException(ew.getRequestId(), ew.getUserMessage(), (MembersUnsuspendError) ew.getErrorValue());
        }
    }

    /**
     * Unsuspend a member from a team. Permission : Team member management
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * @param user  Identity of user to unsuspend. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void membersUnsuspend(UserSelectorArg user) throws MembersUnsuspendErrorException, DbxException {
        MembersUnsuspendArg arg = new MembersUnsuspendArg(user);
        membersUnsuspend(arg);
    }

    //
    // route team/reports/get_activity
    //

    /**
     * Retrieves reporting data about a team's user activity.
     *
     * @param dateRange  Input arguments that can be provided for most reports.
     *
     * @return Activity Report Result. Each of the items in the storage report
     *     is an array of values, one value per day. If there is no data for a
     *     day, then the value will be None.
     */
    GetActivityReport reportsGetActivity(DateRange dateRange) throws DateRangeErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/reports/get_activity",
                                   dateRange,
                                   false,
                                   JsonUtil.createType(GetActivityReport.class),
                                   JsonUtil.createType(DateRangeError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DateRangeErrorException(ew.getRequestId(), ew.getUserMessage(), (DateRangeError) ew.getErrorValue());
        }
    }

    /**
     * Retrieves reporting data about a team's user activity.
     *
     * @return Activity Report Result. Each of the items in the storage report
     *     is an array of values, one value per day. If there is no data for a
     *     day, then the value will be None.
     */
    public GetActivityReport reportsGetActivity() throws DateRangeErrorException, DbxException {
        DateRange arg = new DateRange();
        return reportsGetActivity(arg);
    }

    /**
     * Retrieves reporting data about a team's user activity.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ReportsGetActivityBuilder reportsGetActivityBuilder() {
        DateRange.Builder argBuilder = DateRange.newBuilder();
        return new ReportsGetActivityBuilder(this, argBuilder);
    }

    //
    // route team/reports/get_devices
    //

    /**
     * Retrieves reporting data about a team's linked devices.
     *
     * @param dateRange  Input arguments that can be provided for most reports.
     *
     * @return Devices Report Result. Contains subsections for different time
     *     ranges of activity. Each of the items in each subsection of the
     *     storage report is an array of values, one value per day. If there is
     *     no data for a day, then the value will be None.
     */
    GetDevicesReport reportsGetDevices(DateRange dateRange) throws DateRangeErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/reports/get_devices",
                                   dateRange,
                                   false,
                                   JsonUtil.createType(GetDevicesReport.class),
                                   JsonUtil.createType(DateRangeError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DateRangeErrorException(ew.getRequestId(), ew.getUserMessage(), (DateRangeError) ew.getErrorValue());
        }
    }

    /**
     * Retrieves reporting data about a team's linked devices.
     *
     * @return Devices Report Result. Contains subsections for different time
     *     ranges of activity. Each of the items in each subsection of the
     *     storage report is an array of values, one value per day. If there is
     *     no data for a day, then the value will be None.
     */
    public GetDevicesReport reportsGetDevices() throws DateRangeErrorException, DbxException {
        DateRange arg = new DateRange();
        return reportsGetDevices(arg);
    }

    /**
     * Retrieves reporting data about a team's linked devices.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ReportsGetDevicesBuilder reportsGetDevicesBuilder() {
        DateRange.Builder argBuilder = DateRange.newBuilder();
        return new ReportsGetDevicesBuilder(this, argBuilder);
    }

    //
    // route team/reports/get_membership
    //

    /**
     * Retrieves reporting data about a team's membership.
     *
     * @param dateRange  Input arguments that can be provided for most reports.
     *
     * @return Membership Report Result. Each of the items in the storage report
     *     is an array of values, one value per day. If there is no data for a
     *     day, then the value will be None.
     */
    GetMembershipReport reportsGetMembership(DateRange dateRange) throws DateRangeErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/reports/get_membership",
                                   dateRange,
                                   false,
                                   JsonUtil.createType(GetMembershipReport.class),
                                   JsonUtil.createType(DateRangeError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DateRangeErrorException(ew.getRequestId(), ew.getUserMessage(), (DateRangeError) ew.getErrorValue());
        }
    }

    /**
     * Retrieves reporting data about a team's membership.
     *
     * @return Membership Report Result. Each of the items in the storage report
     *     is an array of values, one value per day. If there is no data for a
     *     day, then the value will be None.
     */
    public GetMembershipReport reportsGetMembership() throws DateRangeErrorException, DbxException {
        DateRange arg = new DateRange();
        return reportsGetMembership(arg);
    }

    /**
     * Retrieves reporting data about a team's membership.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ReportsGetMembershipBuilder reportsGetMembershipBuilder() {
        DateRange.Builder argBuilder = DateRange.newBuilder();
        return new ReportsGetMembershipBuilder(this, argBuilder);
    }

    //
    // route team/reports/get_storage
    //

    /**
     * Retrieves reporting data about a team's storage usage.
     *
     * @param dateRange  Input arguments that can be provided for most reports.
     *
     * @return Storage Report Result. Each of the items in the storage report is
     *     an array of values, one value per day. If there is no data for a day,
     *     then the value will be None.
     */
    GetStorageReport reportsGetStorage(DateRange dateRange) throws DateRangeErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/team/reports/get_storage",
                                   dateRange,
                                   false,
                                   JsonUtil.createType(GetStorageReport.class),
                                   JsonUtil.createType(DateRangeError.class));
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DateRangeErrorException(ew.getRequestId(), ew.getUserMessage(), (DateRangeError) ew.getErrorValue());
        }
    }

    /**
     * Retrieves reporting data about a team's storage usage.
     *
     * @return Storage Report Result. Each of the items in the storage report is
     *     an array of values, one value per day. If there is no data for a day,
     *     then the value will be None.
     */
    public GetStorageReport reportsGetStorage() throws DateRangeErrorException, DbxException {
        DateRange arg = new DateRange();
        return reportsGetStorage(arg);
    }

    /**
     * Retrieves reporting data about a team's storage usage.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ReportsGetStorageBuilder reportsGetStorageBuilder() {
        DateRange.Builder argBuilder = DateRange.newBuilder();
        return new ReportsGetStorageBuilder(this, argBuilder);
    }
}
