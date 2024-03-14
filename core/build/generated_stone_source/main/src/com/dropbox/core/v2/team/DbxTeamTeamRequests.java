/* DO NOT EDIT */
/* This file was generated from team_devices.stone, team_secondary_mails.stone, team_members.stone, team_linked_apps.stone, team_reports.stone, team_folders.stone, team_member_space_limits.stone, team.stone, team_groups.stone, team_legal_holds.stone, team_namespaces.stone, team_sharing_allowlist.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.account.PhotoSourceArg;
import com.dropbox.core.v2.async.LaunchEmptyResult;
import com.dropbox.core.v2.async.PollArg;
import com.dropbox.core.v2.async.PollEmptyResult;
import com.dropbox.core.v2.async.PollError;
import com.dropbox.core.v2.async.PollErrorException;
import com.dropbox.core.v2.fileproperties.AddTemplateArg;
import com.dropbox.core.v2.fileproperties.AddTemplateResult;
import com.dropbox.core.v2.fileproperties.GetTemplateArg;
import com.dropbox.core.v2.fileproperties.GetTemplateResult;
import com.dropbox.core.v2.fileproperties.ListTemplateResult;
import com.dropbox.core.v2.fileproperties.ModifyTemplateError;
import com.dropbox.core.v2.fileproperties.ModifyTemplateErrorException;
import com.dropbox.core.v2.fileproperties.PropertyFieldTemplate;
import com.dropbox.core.v2.fileproperties.TemplateError;
import com.dropbox.core.v2.fileproperties.TemplateErrorException;
import com.dropbox.core.v2.fileproperties.UpdateTemplateArg;
import com.dropbox.core.v2.fileproperties.UpdateTemplateResult;
import com.dropbox.core.v2.files.SyncSettingArg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "team".
 */
public class DbxTeamTeamRequests {
    // namespace team (team_devices.stone, team_secondary_mails.stone, team_members.stone, team_linked_apps.stone, team_reports.stone, team_folders.stone, team_member_space_limits.stone, team.stone, team_groups.stone, team_legal_holds.stone, team_namespaces.stone, team_sharing_allowlist.stone)

    private final DbxRawClientV2 client;

    public DbxTeamTeamRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/team/devices/list_member_devices
    //

    /**
     * List all device sessions of a team's member.
     *
     */
    ListMemberDevicesResult devicesListMemberDevices(ListMemberDevicesArg arg) throws ListMemberDevicesErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/devices/list_member_devices",
                                        arg,
                                        false,
                                        ListMemberDevicesArg.Serializer.INSTANCE,
                                        ListMemberDevicesResult.Serializer.INSTANCE,
                                        ListMemberDevicesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListMemberDevicesErrorException("2/team/devices/list_member_devices", ex.getRequestId(), ex.getUserMessage(), (ListMemberDevicesError) ex.getErrorValue());
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
        ListMemberDevicesArg _arg = new ListMemberDevicesArg(teamMemberId);
        return devicesListMemberDevices(_arg);
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
        ListMemberDevicesArg.Builder argBuilder_ = ListMemberDevicesArg.newBuilder(teamMemberId);
        return new DevicesListMemberDevicesBuilder(this, argBuilder_);
    }

    //
    // route 2/team/devices/list_members_devices
    //

    /**
     * List all device sessions of a team. Permission : Team member file access.
     *
     */
    ListMembersDevicesResult devicesListMembersDevices(ListMembersDevicesArg arg) throws ListMembersDevicesErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/devices/list_members_devices",
                                        arg,
                                        false,
                                        ListMembersDevicesArg.Serializer.INSTANCE,
                                        ListMembersDevicesResult.Serializer.INSTANCE,
                                        ListMembersDevicesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListMembersDevicesErrorException("2/team/devices/list_members_devices", ex.getRequestId(), ex.getUserMessage(), (ListMembersDevicesError) ex.getErrorValue());
        }
    }

    /**
     * List all device sessions of a team.
     *
     * <p> Permission : Team member file access. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DevicesListMembersDevicesBuilder} for more details. </p>
     */
    public ListMembersDevicesResult devicesListMembersDevices() throws ListMembersDevicesErrorException, DbxException {
        ListMembersDevicesArg _arg = new ListMembersDevicesArg();
        return devicesListMembersDevices(_arg);
    }

    /**
     * List all device sessions of a team. Permission : Team member file access.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public DevicesListMembersDevicesBuilder devicesListMembersDevicesBuilder() {
        ListMembersDevicesArg.Builder argBuilder_ = ListMembersDevicesArg.newBuilder();
        return new DevicesListMembersDevicesBuilder(this, argBuilder_);
    }

    //
    // route 2/team/devices/list_team_devices
    //

    /**
     * List all device sessions of a team. Permission : Team member file access.
     *
     */
    ListTeamDevicesResult devicesListTeamDevices(ListTeamDevicesArg arg) throws ListTeamDevicesErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/devices/list_team_devices",
                                        arg,
                                        false,
                                        ListTeamDevicesArg.Serializer.INSTANCE,
                                        ListTeamDevicesResult.Serializer.INSTANCE,
                                        ListTeamDevicesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListTeamDevicesErrorException("2/team/devices/list_team_devices", ex.getRequestId(), ex.getUserMessage(), (ListTeamDevicesError) ex.getErrorValue());
        }
    }

    /**
     * List all device sessions of a team.
     *
     * <p> Permission : Team member file access. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DevicesListTeamDevicesBuilder} for more details. </p>
     *
     * @deprecated use {@link DbxTeamTeamRequests#devicesListMembersDevices}
     *     instead.
     */
    @Deprecated
    public ListTeamDevicesResult devicesListTeamDevices() throws ListTeamDevicesErrorException, DbxException {
        ListTeamDevicesArg _arg = new ListTeamDevicesArg();
        return devicesListTeamDevices(_arg);
    }

    /**
     * List all device sessions of a team. Permission : Team member file access.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @deprecated use {@link DbxTeamTeamRequests#devicesListMembersDevices}
     *     instead.
     */
    @Deprecated
    public DevicesListTeamDevicesBuilder devicesListTeamDevicesBuilder() {
        ListTeamDevicesArg.Builder argBuilder_ = ListTeamDevicesArg.newBuilder();
        return new DevicesListTeamDevicesBuilder(this, argBuilder_);
    }

    //
    // route 2/team/devices/revoke_device_session
    //

    /**
     * Revoke a device session of a team's member.
     *
     */
    public void devicesRevokeDeviceSession(RevokeDeviceSessionArg arg) throws RevokeDeviceSessionErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/team/devices/revoke_device_session",
                                 arg,
                                 false,
                                 RevokeDeviceSessionArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 RevokeDeviceSessionError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RevokeDeviceSessionErrorException("2/team/devices/revoke_device_session", ex.getRequestId(), ex.getUserMessage(), (RevokeDeviceSessionError) ex.getErrorValue());
        }
    }

    //
    // route 2/team/devices/revoke_device_session_batch
    //

    /**
     * Revoke a list of device sessions of team members.
     *
     */
    RevokeDeviceSessionBatchResult devicesRevokeDeviceSessionBatch(RevokeDeviceSessionBatchArg arg) throws RevokeDeviceSessionBatchErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/devices/revoke_device_session_batch",
                                        arg,
                                        false,
                                        RevokeDeviceSessionBatchArg.Serializer.INSTANCE,
                                        RevokeDeviceSessionBatchResult.Serializer.INSTANCE,
                                        RevokeDeviceSessionBatchError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RevokeDeviceSessionBatchErrorException("2/team/devices/revoke_device_session_batch", ex.getRequestId(), ex.getUserMessage(), (RevokeDeviceSessionBatchError) ex.getErrorValue());
        }
    }

    /**
     * Revoke a list of device sessions of team members.
     *
     * @param revokeDevices  Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeDeviceSessionBatchResult devicesRevokeDeviceSessionBatch(List<RevokeDeviceSessionArg> revokeDevices) throws RevokeDeviceSessionBatchErrorException, DbxException {
        RevokeDeviceSessionBatchArg _arg = new RevokeDeviceSessionBatchArg(revokeDevices);
        return devicesRevokeDeviceSessionBatch(_arg);
    }

    //
    // route 2/team/features/get_values
    //

    /**
     * Get the values for one or more featues. This route allows you to check
     * your account's capability for what feature you can access or what value
     * you have for certain features. Permission : Team information.
     *
     */
    FeaturesGetValuesBatchResult featuresGetValues(FeaturesGetValuesBatchArg arg) throws FeaturesGetValuesBatchErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/features/get_values",
                                        arg,
                                        false,
                                        FeaturesGetValuesBatchArg.Serializer.INSTANCE,
                                        FeaturesGetValuesBatchResult.Serializer.INSTANCE,
                                        FeaturesGetValuesBatchError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new FeaturesGetValuesBatchErrorException("2/team/features/get_values", ex.getRequestId(), ex.getUserMessage(), (FeaturesGetValuesBatchError) ex.getErrorValue());
        }
    }

    /**
     * Get the values for one or more featues. This route allows you to check
     * your account's capability for what feature you can access or what value
     * you have for certain features.
     *
     * <p> Permission : Team information. </p>
     *
     * @param features  A list of features in {@link Feature}. If the list is
     *     empty, this route will return {@link FeaturesGetValuesBatchError}.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FeaturesGetValuesBatchResult featuresGetValues(List<Feature> features) throws FeaturesGetValuesBatchErrorException, DbxException {
        FeaturesGetValuesBatchArg _arg = new FeaturesGetValuesBatchArg(features);
        return featuresGetValues(_arg);
    }

    //
    // route 2/team/get_info
    //

    /**
     * Retrieves information about a team.
     */
    public TeamGetInfoResult getInfo() throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/get_info",
                                        null,
                                        false,
                                        com.dropbox.core.stone.StoneSerializers.void_(),
                                        TeamGetInfoResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"get_info\":" + ex.getErrorValue());
        }
    }

    //
    // route 2/team/groups/create
    //

    /**
     * Creates a new, empty group, with a requested name. Permission : Team
     * member management.
     *
     *
     * @return Full description of a group.
     */
    GroupFullInfo groupsCreate(GroupCreateArg arg) throws GroupCreateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/create",
                                        arg,
                                        false,
                                        GroupCreateArg.Serializer.INSTANCE,
                                        GroupFullInfo.Serializer.INSTANCE,
                                        GroupCreateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupCreateErrorException("2/team/groups/create", ex.getRequestId(), ex.getUserMessage(), (GroupCreateError) ex.getErrorValue());
        }
    }

    /**
     * Creates a new, empty group, with a requested name.
     *
     * <p> Permission : Team member management. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link GroupsCreateBuilder} for more details. </p>
     *
     * @param groupName  Group name. Must not be {@code null}.
     *
     * @return Full description of a group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo groupsCreate(String groupName) throws GroupCreateErrorException, DbxException {
        GroupCreateArg _arg = new GroupCreateArg(groupName);
        return groupsCreate(_arg);
    }

    /**
     * Creates a new, empty group, with a requested name. Permission : Team
     * member management.
     *
     * @param groupName  Group name. Must not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsCreateBuilder groupsCreateBuilder(String groupName) {
        GroupCreateArg.Builder argBuilder_ = GroupCreateArg.newBuilder(groupName);
        return new GroupsCreateBuilder(this, argBuilder_);
    }

    //
    // route 2/team/groups/delete
    //

    /**
     * Deletes a group. The group is deleted immediately. However the revoking
     * of group-owned resources may take additional time. Use the {@link
     * DbxTeamTeamRequests#groupsJobStatusGet(String)} to determine whether this
     * process has completed. Permission : Team member management.
     *
     * @param arg  Argument for selecting a single group, either by group_id or
     *     by external group ID.
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     */
    public LaunchEmptyResult groupsDelete(GroupSelector arg) throws GroupDeleteErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/delete",
                                        arg,
                                        false,
                                        GroupSelector.Serializer.INSTANCE,
                                        LaunchEmptyResult.Serializer.INSTANCE,
                                        GroupDeleteError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupDeleteErrorException("2/team/groups/delete", ex.getRequestId(), ex.getUserMessage(), (GroupDeleteError) ex.getErrorValue());
        }
    }

    //
    // route 2/team/groups/get_info
    //

    /**
     * Retrieves information about one or more groups. Note that the optional
     * field  {@link GroupFullInfo#getMembers} is not returned for
     * system-managed groups. Permission : Team Information.
     *
     * @param arg  Argument for selecting a list of groups, either by group_ids,
     *     or external group IDs.
     */
    public List<GroupsGetInfoItem> groupsGetInfo(GroupsSelector arg) throws GroupsGetInfoErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/get_info",
                                        arg,
                                        false,
                                        GroupsSelector.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(GroupsGetInfoItem.Serializer.INSTANCE),
                                        GroupsGetInfoError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupsGetInfoErrorException("2/team/groups/get_info", ex.getRequestId(), ex.getUserMessage(), (GroupsGetInfoError) ex.getErrorValue());
        }
    }

    //
    // route 2/team/groups/job_status/get
    //

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#groupsDelete}, {@link
     * DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List,boolean)} , or
     * {@link
     * DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List,boolean)} use
     * this method to poll the status of granting/revoking group members' access
     * to group-owned resources. Permission : Team member management.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     *
     * @return Result returned by methods that poll for the status of an
     *     asynchronous job. Upon completion of the job, no additional
     *     information is returned.
     */
    PollEmptyResult groupsJobStatusGet(PollArg arg) throws GroupsPollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/job_status/get",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        PollEmptyResult.Serializer.INSTANCE,
                                        GroupsPollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupsPollErrorException("2/team/groups/job_status/get", ex.getRequestId(), ex.getUserMessage(), (GroupsPollError) ex.getErrorValue());
        }
    }

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#groupsDelete}, {@link
     * DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List,boolean)} , or
     * {@link
     * DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List,boolean)} use
     * this method to poll the status of granting/revoking group members' access
     * to group-owned resources.
     *
     * <p> Permission : Team member management. </p>
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
        PollArg _arg = new PollArg(asyncJobId);
        return groupsJobStatusGet(_arg);
    }

    //
    // route 2/team/groups/list
    //

    /**
     * Lists groups on a team. Permission : Team Information.
     *
     */
    GroupsListResult groupsList(GroupsListArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/list",
                                        arg,
                                        false,
                                        GroupsListArg.Serializer.INSTANCE,
                                        GroupsListResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"groups/list\":" + ex.getErrorValue());
        }
    }

    /**
     * Lists groups on a team.
     *
     * <p> Permission : Team Information. </p>
     *
     * <p> The {@code limit} request parameter will default to {@code 1000L}
     * (see {@link #groupsList(long)}). </p>
     */
    public GroupsListResult groupsList() throws DbxApiException, DbxException {
        GroupsListArg _arg = new GroupsListArg();
        return groupsList(_arg);
    }

    /**
     * Lists groups on a team.
     *
     * <p> Permission : Team Information. </p>
     *
     * @param limit  Number of results to return per call. Must be greater than
     *     or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsListResult groupsList(long limit) throws DbxApiException, DbxException {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        GroupsListArg _arg = new GroupsListArg(limit);
        return groupsList(_arg);
    }

    //
    // route 2/team/groups/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#groupsList(long)}, use this to paginate through all
     * groups. Permission : Team Information.
     *
     */
    GroupsListResult groupsListContinue(GroupsListContinueArg arg) throws GroupsListContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/list/continue",
                                        arg,
                                        false,
                                        GroupsListContinueArg.Serializer.INSTANCE,
                                        GroupsListResult.Serializer.INSTANCE,
                                        GroupsListContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupsListContinueErrorException("2/team/groups/list/continue", ex.getRequestId(), ex.getUserMessage(), (GroupsListContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#groupsList(long)}, use this to paginate through all
     * groups.
     *
     * <p> Permission : Team Information. </p>
     *
     * @param cursor  Indicates from what point to get the next set of groups.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsListResult groupsListContinue(String cursor) throws GroupsListContinueErrorException, DbxException {
        GroupsListContinueArg _arg = new GroupsListContinueArg(cursor);
        return groupsListContinue(_arg);
    }

    //
    // route 2/team/groups/members/add
    //

    /**
     * Adds members to a group. The members are added immediately. However the
     * granting of group-owned resources may take additional time. Use the
     * {@link DbxTeamTeamRequests#groupsJobStatusGet(String)} to determine
     * whether this process has completed. Permission : Team member management.
     *
     *
     * @return Result returned by {@link
     *     DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List,boolean)} and
     *     {@link
     *     DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List,boolean)}.
     */
    GroupMembersChangeResult groupsMembersAdd(GroupMembersAddArg arg) throws GroupMembersAddErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/members/add",
                                        arg,
                                        false,
                                        GroupMembersAddArg.Serializer.INSTANCE,
                                        GroupMembersChangeResult.Serializer.INSTANCE,
                                        GroupMembersAddError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupMembersAddErrorException("2/team/groups/members/add", ex.getRequestId(), ex.getUserMessage(), (GroupMembersAddError) ex.getErrorValue());
        }
    }

    /**
     * Adds members to a group.
     *
     * <p> The members are added immediately. However the granting of
     * group-owned resources may take additional time. Use the {@link
     * DbxTeamTeamRequests#groupsJobStatusGet(String)} to determine whether this
     * process has completed. </p>
     *
     * <p> Permission : Team member management. </p>
     *
     * <p> The {@code returnMembers} request parameter will default to {@code
     * true} (see {@link #groupsMembersAdd(GroupSelector,List,boolean)}). </p>
     *
     * @param group  Group to which users will be added. Must not be {@code
     *     null}.
     * @param members  List of users to be added to the group. Must not contain
     *     a {@code null} item and not be {@code null}.
     *
     * @return Result returned by {@link
     *     DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List,boolean)} and
     *     {@link
     *     DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List,boolean)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersChangeResult groupsMembersAdd(GroupSelector group, List<MemberAccess> members) throws GroupMembersAddErrorException, DbxException {
        GroupMembersAddArg _arg = new GroupMembersAddArg(group, members);
        return groupsMembersAdd(_arg);
    }

    /**
     * Adds members to a group.
     *
     * <p> The members are added immediately. However the granting of
     * group-owned resources may take additional time. Use the {@link
     * DbxTeamTeamRequests#groupsJobStatusGet(String)} to determine whether this
     * process has completed. </p>
     *
     * <p> Permission : Team member management. </p>
     *
     * @param group  Group to which users will be added. Must not be {@code
     *     null}.
     * @param members  List of users to be added to the group. Must not contain
     *     a {@code null} item and not be {@code null}.
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     *
     * @return Result returned by {@link
     *     DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List,boolean)} and
     *     {@link
     *     DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List,boolean)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersChangeResult groupsMembersAdd(GroupSelector group, List<MemberAccess> members, boolean returnMembers) throws GroupMembersAddErrorException, DbxException {
        GroupMembersAddArg _arg = new GroupMembersAddArg(group, members, returnMembers);
        return groupsMembersAdd(_arg);
    }

    //
    // route 2/team/groups/members/list
    //

    /**
     * Lists members of a group. Permission : Team Information.
     *
     */
    GroupsMembersListResult groupsMembersList(GroupsMembersListArg arg) throws GroupSelectorErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/members/list",
                                        arg,
                                        false,
                                        GroupsMembersListArg.Serializer.INSTANCE,
                                        GroupsMembersListResult.Serializer.INSTANCE,
                                        GroupSelectorError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupSelectorErrorException("2/team/groups/members/list", ex.getRequestId(), ex.getUserMessage(), (GroupSelectorError) ex.getErrorValue());
        }
    }

    /**
     * Lists members of a group.
     *
     * <p> Permission : Team Information. </p>
     *
     * <p> The {@code limit} request parameter will default to {@code 1000L}
     * (see {@link #groupsMembersList(GroupSelector,long)}). </p>
     *
     * @param group  The group whose members are to be listed. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsMembersListResult groupsMembersList(GroupSelector group) throws GroupSelectorErrorException, DbxException {
        GroupsMembersListArg _arg = new GroupsMembersListArg(group);
        return groupsMembersList(_arg);
    }

    /**
     * Lists members of a group.
     *
     * <p> Permission : Team Information. </p>
     *
     * @param group  The group whose members are to be listed. Must not be
     *     {@code null}.
     * @param limit  Number of results to return per call. Must be greater than
     *     or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsMembersListResult groupsMembersList(GroupSelector group, long limit) throws GroupSelectorErrorException, DbxException {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        GroupsMembersListArg _arg = new GroupsMembersListArg(group, limit);
        return groupsMembersList(_arg);
    }

    //
    // route 2/team/groups/members/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#groupsMembersList(GroupSelector,long)}, use this to
     * paginate through all members of the group. Permission : Team information.
     *
     */
    GroupsMembersListResult groupsMembersListContinue(GroupsMembersListContinueArg arg) throws GroupsMembersListContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/members/list/continue",
                                        arg,
                                        false,
                                        GroupsMembersListContinueArg.Serializer.INSTANCE,
                                        GroupsMembersListResult.Serializer.INSTANCE,
                                        GroupsMembersListContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupsMembersListContinueErrorException("2/team/groups/members/list/continue", ex.getRequestId(), ex.getUserMessage(), (GroupsMembersListContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#groupsMembersList(GroupSelector,long)}, use this to
     * paginate through all members of the group.
     *
     * <p> Permission : Team information. </p>
     *
     * @param cursor  Indicates from what point to get the next set of groups.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupsMembersListResult groupsMembersListContinue(String cursor) throws GroupsMembersListContinueErrorException, DbxException {
        GroupsMembersListContinueArg _arg = new GroupsMembersListContinueArg(cursor);
        return groupsMembersListContinue(_arg);
    }

    //
    // route 2/team/groups/members/remove
    //

    /**
     * Removes members from a group. The members are removed immediately.
     * However the revoking of group-owned resources may take additional time.
     * Use the {@link DbxTeamTeamRequests#groupsJobStatusGet(String)} to
     * determine whether this process has completed. This method permits
     * removing the only owner of a group, even in cases where this is not
     * possible via the web client. Permission : Team member management.
     *
     *
     * @return Result returned by {@link
     *     DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List,boolean)} and
     *     {@link
     *     DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List,boolean)}.
     */
    GroupMembersChangeResult groupsMembersRemove(GroupMembersRemoveArg arg) throws GroupMembersRemoveErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/members/remove",
                                        arg,
                                        false,
                                        GroupMembersRemoveArg.Serializer.INSTANCE,
                                        GroupMembersChangeResult.Serializer.INSTANCE,
                                        GroupMembersRemoveError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupMembersRemoveErrorException("2/team/groups/members/remove", ex.getRequestId(), ex.getUserMessage(), (GroupMembersRemoveError) ex.getErrorValue());
        }
    }

    /**
     * Removes members from a group.
     *
     * <p> The members are removed immediately. However the revoking of
     * group-owned resources may take additional time. Use the {@link
     * DbxTeamTeamRequests#groupsJobStatusGet(String)} to determine whether this
     * process has completed. </p>
     *
     * <p> This method permits removing the only owner of a group, even in cases
     * where this is not possible via the web client. </p>
     *
     * <p> Permission : Team member management. </p>
     *
     * <p> The {@code returnMembers} request parameter will default to {@code
     * true} (see {@link #groupsMembersRemove(GroupSelector,List,boolean)}).
     * </p>
     *
     * @param group  Group from which users will be removed. Must not be {@code
     *     null}.
     * @param users  List of users to be removed from the group. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @return Result returned by {@link
     *     DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List,boolean)} and
     *     {@link
     *     DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List,boolean)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersChangeResult groupsMembersRemove(GroupSelector group, List<UserSelectorArg> users) throws GroupMembersRemoveErrorException, DbxException {
        GroupMembersRemoveArg _arg = new GroupMembersRemoveArg(group, users);
        return groupsMembersRemove(_arg);
    }

    /**
     * Removes members from a group.
     *
     * <p> The members are removed immediately. However the revoking of
     * group-owned resources may take additional time. Use the {@link
     * DbxTeamTeamRequests#groupsJobStatusGet(String)} to determine whether this
     * process has completed. </p>
     *
     * <p> This method permits removing the only owner of a group, even in cases
     * where this is not possible via the web client. </p>
     *
     * <p> Permission : Team member management. </p>
     *
     * @param group  Group from which users will be removed. Must not be {@code
     *     null}.
     * @param users  List of users to be removed from the group. Must not
     *     contain a {@code null} item and not be {@code null}.
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     *
     * @return Result returned by {@link
     *     DbxTeamTeamRequests#groupsMembersAdd(GroupSelector,List,boolean)} and
     *     {@link
     *     DbxTeamTeamRequests#groupsMembersRemove(GroupSelector,List,boolean)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupMembersChangeResult groupsMembersRemove(GroupSelector group, List<UserSelectorArg> users, boolean returnMembers) throws GroupMembersRemoveErrorException, DbxException {
        GroupMembersRemoveArg _arg = new GroupMembersRemoveArg(group, users, returnMembers);
        return groupsMembersRemove(_arg);
    }

    //
    // route 2/team/groups/members/set_access_type
    //

    /**
     * Sets a member's access type in a group. Permission : Team member
     * management.
     *
     */
    List<GroupsGetInfoItem> groupsMembersSetAccessType(GroupMembersSetAccessTypeArg arg) throws GroupMemberSetAccessTypeErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/members/set_access_type",
                                        arg,
                                        false,
                                        GroupMembersSetAccessTypeArg.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(GroupsGetInfoItem.Serializer.INSTANCE),
                                        GroupMemberSetAccessTypeError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupMemberSetAccessTypeErrorException("2/team/groups/members/set_access_type", ex.getRequestId(), ex.getUserMessage(), (GroupMemberSetAccessTypeError) ex.getErrorValue());
        }
    }

    /**
     * Sets a member's access type in a group.
     *
     * <p> Permission : Team member management. </p>
     *
     * <p> The {@code returnMembers} request parameter will default to {@code
     * true} (see {@link
     * #groupsMembersSetAccessType(GroupSelector,UserSelectorArg,GroupAccessType,boolean)}).
     * </p>
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param user  Identity of a user that is a member of the {@code group}
     *     argument to {@link
     *     DbxTeamTeamRequests#groupsMembersSetAccessType(GroupSelector,UserSelectorArg,GroupAccessType,boolean)}.
     *     Must not be {@code null}.
     * @param accessType  New group access type the user will have. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<GroupsGetInfoItem> groupsMembersSetAccessType(GroupSelector group, UserSelectorArg user, GroupAccessType accessType) throws GroupMemberSetAccessTypeErrorException, DbxException {
        GroupMembersSetAccessTypeArg _arg = new GroupMembersSetAccessTypeArg(group, user, accessType);
        return groupsMembersSetAccessType(_arg);
    }

    /**
     * Sets a member's access type in a group.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param group  Specify a group. Must not be {@code null}.
     * @param user  Identity of a user that is a member of the {@code group}
     *     argument to {@link
     *     DbxTeamTeamRequests#groupsMembersSetAccessType(GroupSelector,UserSelectorArg,GroupAccessType,boolean)}.
     *     Must not be {@code null}.
     * @param accessType  New group access type the user will have. Must not be
     *     {@code null}.
     * @param returnMembers  Whether to return the list of members in the group.
     *     Note that the default value will cause all the group members  to be
     *     returned in the response. This may take a long time for large groups.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<GroupsGetInfoItem> groupsMembersSetAccessType(GroupSelector group, UserSelectorArg user, GroupAccessType accessType, boolean returnMembers) throws GroupMemberSetAccessTypeErrorException, DbxException {
        GroupMembersSetAccessTypeArg _arg = new GroupMembersSetAccessTypeArg(group, user, accessType, returnMembers);
        return groupsMembersSetAccessType(_arg);
    }

    //
    // route 2/team/groups/update
    //

    /**
     * Updates a group's name and/or external ID. Permission : Team member
     * management.
     *
     *
     * @return Full description of a group.
     */
    GroupFullInfo groupsUpdate(GroupUpdateArgs arg) throws GroupUpdateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/groups/update",
                                        arg,
                                        false,
                                        GroupUpdateArgs.Serializer.INSTANCE,
                                        GroupFullInfo.Serializer.INSTANCE,
                                        GroupUpdateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GroupUpdateErrorException("2/team/groups/update", ex.getRequestId(), ex.getUserMessage(), (GroupUpdateError) ex.getErrorValue());
        }
    }

    /**
     * Updates a group's name and/or external ID.
     *
     * <p> Permission : Team member management. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link GroupsUpdateBuilder} for more details. </p>
     *
     * @param group  Specify a group. Must not be {@code null}.
     *
     * @return Full description of a group.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GroupFullInfo groupsUpdate(GroupSelector group) throws GroupUpdateErrorException, DbxException {
        GroupUpdateArgs _arg = new GroupUpdateArgs(group);
        return groupsUpdate(_arg);
    }

    /**
     * Updates a group's name and/or external ID. Permission : Team member
     * management.
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
        GroupUpdateArgs.Builder argBuilder_ = GroupUpdateArgs.newBuilder(group);
        return new GroupsUpdateBuilder(this, argBuilder_);
    }

    //
    // route 2/team/legal_holds/create_policy
    //

    /**
     * Creates new legal hold policy. Note: Legal Holds is a paid add-on. Not
     * all teams have the feature. Permission : Team member file access.
     *
     */
    LegalHoldPolicy legalHoldsCreatePolicy(LegalHoldsPolicyCreateArg arg) throws LegalHoldsPolicyCreateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/legal_holds/create_policy",
                                        arg,
                                        false,
                                        LegalHoldsPolicyCreateArg.Serializer.INSTANCE,
                                        LegalHoldPolicy.Serializer.INSTANCE,
                                        LegalHoldsPolicyCreateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new LegalHoldsPolicyCreateErrorException("2/team/legal_holds/create_policy", ex.getRequestId(), ex.getUserMessage(), (LegalHoldsPolicyCreateError) ex.getErrorValue());
        }
    }

    /**
     * Creates new legal hold policy. Note: Legal Holds is a paid add-on. Not
     * all teams have the feature.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param name  Policy name. Must have length of at most 140 and not be
     *     {@code null}.
     * @param members  List of team member IDs added to the hold. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldPolicy legalHoldsCreatePolicy(String name, List<String> members) throws LegalHoldsPolicyCreateErrorException, DbxException {
        LegalHoldsPolicyCreateArg _arg = new LegalHoldsPolicyCreateArg(name, members);
        return legalHoldsCreatePolicy(_arg);
    }

    /**
     * Creates new legal hold policy. Note: Legal Holds is a paid add-on. Not
     * all teams have the feature. Permission : Team member file access.
     *
     * @param name  Policy name. Must have length of at most 140 and not be
     *     {@code null}.
     * @param members  List of team member IDs added to the hold. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsCreatePolicyBuilder legalHoldsCreatePolicyBuilder(String name, List<String> members) {
        LegalHoldsPolicyCreateArg.Builder argBuilder_ = LegalHoldsPolicyCreateArg.newBuilder(name, members);
        return new LegalHoldsCreatePolicyBuilder(this, argBuilder_);
    }

    //
    // route 2/team/legal_holds/get_policy
    //

    /**
     * Gets a legal hold by Id. Note: Legal Holds is a paid add-on. Not all
     * teams have the feature. Permission : Team member file access.
     *
     */
    LegalHoldPolicy legalHoldsGetPolicy(LegalHoldsGetPolicyArg arg) throws LegalHoldsGetPolicyErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/legal_holds/get_policy",
                                        arg,
                                        false,
                                        LegalHoldsGetPolicyArg.Serializer.INSTANCE,
                                        LegalHoldPolicy.Serializer.INSTANCE,
                                        LegalHoldsGetPolicyError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new LegalHoldsGetPolicyErrorException("2/team/legal_holds/get_policy", ex.getRequestId(), ex.getUserMessage(), (LegalHoldsGetPolicyError) ex.getErrorValue());
        }
    }

    /**
     * Gets a legal hold by Id. Note: Legal Holds is a paid add-on. Not all
     * teams have the feature.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldPolicy legalHoldsGetPolicy(String id) throws LegalHoldsGetPolicyErrorException, DbxException {
        LegalHoldsGetPolicyArg _arg = new LegalHoldsGetPolicyArg(id);
        return legalHoldsGetPolicy(_arg);
    }

    //
    // route 2/team/legal_holds/list_held_revisions
    //

    /**
     * List the file metadata that's under the hold. Note: Legal Holds is a paid
     * add-on. Not all teams have the feature. Permission : Team member file
     * access.
     *
     */
    LegalHoldsListHeldRevisionResult legalHoldsListHeldRevisions(LegalHoldsListHeldRevisionsArg arg) throws LegalHoldsListHeldRevisionsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/legal_holds/list_held_revisions",
                                        arg,
                                        false,
                                        LegalHoldsListHeldRevisionsArg.Serializer.INSTANCE,
                                        LegalHoldsListHeldRevisionResult.Serializer.INSTANCE,
                                        LegalHoldsListHeldRevisionsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new LegalHoldsListHeldRevisionsErrorException("2/team/legal_holds/list_held_revisions", ex.getRequestId(), ex.getUserMessage(), (LegalHoldsListHeldRevisionsError) ex.getErrorValue());
        }
    }

    /**
     * List the file metadata that's under the hold. Note: Legal Holds is a paid
     * add-on. Not all teams have the feature.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsListHeldRevisionResult legalHoldsListHeldRevisions(String id) throws LegalHoldsListHeldRevisionsErrorException, DbxException {
        LegalHoldsListHeldRevisionsArg _arg = new LegalHoldsListHeldRevisionsArg(id);
        return legalHoldsListHeldRevisions(_arg);
    }

    //
    // route 2/team/legal_holds/list_held_revisions_continue
    //

    /**
     * Continue listing the file metadata that's under the hold. Note: Legal
     * Holds is a paid add-on. Not all teams have the feature. Permission : Team
     * member file access.
     *
     */
    LegalHoldsListHeldRevisionResult legalHoldsListHeldRevisionsContinue(LegalHoldsListHeldRevisionsContinueArg arg) throws LegalHoldsListHeldRevisionsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/legal_holds/list_held_revisions_continue",
                                        arg,
                                        false,
                                        LegalHoldsListHeldRevisionsContinueArg.Serializer.INSTANCE,
                                        LegalHoldsListHeldRevisionResult.Serializer.INSTANCE,
                                        LegalHoldsListHeldRevisionsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new LegalHoldsListHeldRevisionsErrorException("2/team/legal_holds/list_held_revisions_continue", ex.getRequestId(), ex.getUserMessage(), (LegalHoldsListHeldRevisionsError) ex.getErrorValue());
        }
    }

    /**
     * Continue listing the file metadata that's under the hold. Note: Legal
     * Holds is a paid add-on. Not all teams have the feature.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsListHeldRevisionResult legalHoldsListHeldRevisionsContinue(String id) throws LegalHoldsListHeldRevisionsErrorException, DbxException {
        LegalHoldsListHeldRevisionsContinueArg _arg = new LegalHoldsListHeldRevisionsContinueArg(id);
        return legalHoldsListHeldRevisionsContinue(_arg);
    }

    /**
     * Continue listing the file metadata that's under the hold. Note: Legal
     * Holds is a paid add-on. Not all teams have the feature.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     * @param cursor  The cursor idicates where to continue reading file
     *     metadata entries for the next API call. When there are no more
     *     entries, the cursor will return none. Must have length of at least 1.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsListHeldRevisionResult legalHoldsListHeldRevisionsContinue(String id, String cursor) throws LegalHoldsListHeldRevisionsErrorException, DbxException {
        if (cursor != null) {
            if (cursor.length() < 1) {
                throw new IllegalArgumentException("String 'cursor' is shorter than 1");
            }
        }
        LegalHoldsListHeldRevisionsContinueArg _arg = new LegalHoldsListHeldRevisionsContinueArg(id, cursor);
        return legalHoldsListHeldRevisionsContinue(_arg);
    }

    //
    // route 2/team/legal_holds/list_policies
    //

    /**
     * Lists legal holds on a team. Note: Legal Holds is a paid add-on. Not all
     * teams have the feature. Permission : Team member file access.
     *
     */
    LegalHoldsListPoliciesResult legalHoldsListPolicies(LegalHoldsListPoliciesArg arg) throws LegalHoldsListPoliciesErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/legal_holds/list_policies",
                                        arg,
                                        false,
                                        LegalHoldsListPoliciesArg.Serializer.INSTANCE,
                                        LegalHoldsListPoliciesResult.Serializer.INSTANCE,
                                        LegalHoldsListPoliciesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new LegalHoldsListPoliciesErrorException("2/team/legal_holds/list_policies", ex.getRequestId(), ex.getUserMessage(), (LegalHoldsListPoliciesError) ex.getErrorValue());
        }
    }

    /**
     * Lists legal holds on a team. Note: Legal Holds is a paid add-on. Not all
     * teams have the feature.
     *
     * <p> Permission : Team member file access. </p>
     *
     * <p> The {@code includeReleased} request parameter will default to {@code
     * false} (see {@link #legalHoldsListPolicies(boolean)}). </p>
     */
    public LegalHoldsListPoliciesResult legalHoldsListPolicies() throws LegalHoldsListPoliciesErrorException, DbxException {
        LegalHoldsListPoliciesArg _arg = new LegalHoldsListPoliciesArg();
        return legalHoldsListPolicies(_arg);
    }

    /**
     * Lists legal holds on a team. Note: Legal Holds is a paid add-on. Not all
     * teams have the feature.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param includeReleased  Whether to return holds that were released.
     */
    public LegalHoldsListPoliciesResult legalHoldsListPolicies(boolean includeReleased) throws LegalHoldsListPoliciesErrorException, DbxException {
        LegalHoldsListPoliciesArg _arg = new LegalHoldsListPoliciesArg(includeReleased);
        return legalHoldsListPolicies(_arg);
    }

    //
    // route 2/team/legal_holds/release_policy
    //

    /**
     * Releases a legal hold by Id. Note: Legal Holds is a paid add-on. Not all
     * teams have the feature. Permission : Team member file access.
     *
     */
    void legalHoldsReleasePolicy(LegalHoldsPolicyReleaseArg arg) throws LegalHoldsPolicyReleaseErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/team/legal_holds/release_policy",
                                 arg,
                                 false,
                                 LegalHoldsPolicyReleaseArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 LegalHoldsPolicyReleaseError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new LegalHoldsPolicyReleaseErrorException("2/team/legal_holds/release_policy", ex.getRequestId(), ex.getUserMessage(), (LegalHoldsPolicyReleaseError) ex.getErrorValue());
        }
    }

    /**
     * Releases a legal hold by Id. Note: Legal Holds is a paid add-on. Not all
     * teams have the feature.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void legalHoldsReleasePolicy(String id) throws LegalHoldsPolicyReleaseErrorException, DbxException {
        LegalHoldsPolicyReleaseArg _arg = new LegalHoldsPolicyReleaseArg(id);
        legalHoldsReleasePolicy(_arg);
    }

    //
    // route 2/team/legal_holds/update_policy
    //

    /**
     * Updates a legal hold. Note: Legal Holds is a paid add-on. Not all teams
     * have the feature. Permission : Team member file access.
     *
     */
    LegalHoldPolicy legalHoldsUpdatePolicy(LegalHoldsPolicyUpdateArg arg) throws LegalHoldsPolicyUpdateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/legal_holds/update_policy",
                                        arg,
                                        false,
                                        LegalHoldsPolicyUpdateArg.Serializer.INSTANCE,
                                        LegalHoldPolicy.Serializer.INSTANCE,
                                        LegalHoldsPolicyUpdateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new LegalHoldsPolicyUpdateErrorException("2/team/legal_holds/update_policy", ex.getRequestId(), ex.getUserMessage(), (LegalHoldsPolicyUpdateError) ex.getErrorValue());
        }
    }

    /**
     * Updates a legal hold. Note: Legal Holds is a paid add-on. Not all teams
     * have the feature.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldPolicy legalHoldsUpdatePolicy(String id) throws LegalHoldsPolicyUpdateErrorException, DbxException {
        LegalHoldsPolicyUpdateArg _arg = new LegalHoldsPolicyUpdateArg(id);
        return legalHoldsUpdatePolicy(_arg);
    }

    /**
     * Updates a legal hold. Note: Legal Holds is a paid add-on. Not all teams
     * have the feature. Permission : Team member file access.
     *
     * @param id  The legal hold Id. Must match pattern "{@code ^pid_dbhid:.+}"
     *     and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LegalHoldsUpdatePolicyBuilder legalHoldsUpdatePolicyBuilder(String id) {
        LegalHoldsPolicyUpdateArg.Builder argBuilder_ = LegalHoldsPolicyUpdateArg.newBuilder(id);
        return new LegalHoldsUpdatePolicyBuilder(this, argBuilder_);
    }

    //
    // route 2/team/linked_apps/list_member_linked_apps
    //

    /**
     * List all linked applications of the team member. Note, this endpoint does
     * not list any team-linked applications.
     *
     */
    ListMemberAppsResult linkedAppsListMemberLinkedApps(ListMemberAppsArg arg) throws ListMemberAppsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/linked_apps/list_member_linked_apps",
                                        arg,
                                        false,
                                        ListMemberAppsArg.Serializer.INSTANCE,
                                        ListMemberAppsResult.Serializer.INSTANCE,
                                        ListMemberAppsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListMemberAppsErrorException("2/team/linked_apps/list_member_linked_apps", ex.getRequestId(), ex.getUserMessage(), (ListMemberAppsError) ex.getErrorValue());
        }
    }

    /**
     * List all linked applications of the team member.
     *
     * <p> Note, this endpoint does not list any team-linked applications. </p>
     *
     * @param teamMemberId  The team member id. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMemberAppsResult linkedAppsListMemberLinkedApps(String teamMemberId) throws ListMemberAppsErrorException, DbxException {
        ListMemberAppsArg _arg = new ListMemberAppsArg(teamMemberId);
        return linkedAppsListMemberLinkedApps(_arg);
    }

    //
    // route 2/team/linked_apps/list_members_linked_apps
    //

    /**
     * List all applications linked to the team members' accounts. Note, this
     * endpoint does not list any team-linked applications.
     *
     * @param arg  Arguments for {@link
     *     DbxTeamTeamRequests#linkedAppsListMembersLinkedApps(String)}.
     *
     * @return Information returned by {@link
     *     DbxTeamTeamRequests#linkedAppsListMembersLinkedApps(String)}.
     */
    ListMembersAppsResult linkedAppsListMembersLinkedApps(ListMembersAppsArg arg) throws ListMembersAppsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/linked_apps/list_members_linked_apps",
                                        arg,
                                        false,
                                        ListMembersAppsArg.Serializer.INSTANCE,
                                        ListMembersAppsResult.Serializer.INSTANCE,
                                        ListMembersAppsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListMembersAppsErrorException("2/team/linked_apps/list_members_linked_apps", ex.getRequestId(), ex.getUserMessage(), (ListMembersAppsError) ex.getErrorValue());
        }
    }

    /**
     * List all applications linked to the team members' accounts.
     *
     * <p> Note, this endpoint does not list any team-linked applications. </p>
     *
     * @return Information returned by {@link
     *     DbxTeamTeamRequests#linkedAppsListMembersLinkedApps(String)}.
     */
    public ListMembersAppsResult linkedAppsListMembersLinkedApps() throws ListMembersAppsErrorException, DbxException {
        ListMembersAppsArg _arg = new ListMembersAppsArg();
        return linkedAppsListMembersLinkedApps(_arg);
    }

    /**
     * List all applications linked to the team members' accounts.
     *
     * <p> Note, this endpoint does not list any team-linked applications. </p>
     *
     * @param cursor  At the first call to the {@link
     *     DbxTeamTeamRequests#linkedAppsListMembersLinkedApps(String)} the
     *     cursor shouldn't be passed. Then, if the result of the call includes
     *     a cursor, the following requests should include the received cursors
     *     in order to receive the next sub list of the team applications.
     *
     * @return Information returned by {@link
     *     DbxTeamTeamRequests#linkedAppsListMembersLinkedApps(String)}.
     */
    public ListMembersAppsResult linkedAppsListMembersLinkedApps(String cursor) throws ListMembersAppsErrorException, DbxException {
        ListMembersAppsArg _arg = new ListMembersAppsArg(cursor);
        return linkedAppsListMembersLinkedApps(_arg);
    }

    //
    // route 2/team/linked_apps/list_team_linked_apps
    //

    /**
     * List all applications linked to the team members' accounts. Note, this
     * endpoint doesn't list any team-linked applications.
     *
     * @param arg  Arguments for {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps(String)}.
     *
     * @return Information returned by {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps(String)}.
     */
    ListTeamAppsResult linkedAppsListTeamLinkedApps(ListTeamAppsArg arg) throws ListTeamAppsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/linked_apps/list_team_linked_apps",
                                        arg,
                                        false,
                                        ListTeamAppsArg.Serializer.INSTANCE,
                                        ListTeamAppsResult.Serializer.INSTANCE,
                                        ListTeamAppsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListTeamAppsErrorException("2/team/linked_apps/list_team_linked_apps", ex.getRequestId(), ex.getUserMessage(), (ListTeamAppsError) ex.getErrorValue());
        }
    }

    /**
     * List all applications linked to the team members' accounts.
     *
     * <p> Note, this endpoint doesn't list any team-linked applications. </p>
     *
     * @return Information returned by {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps(String)}.
     *
     * @deprecated use {@link
     *     DbxTeamTeamRequests#linkedAppsListMembersLinkedApps(String)} instead.
     */
    @Deprecated
    public ListTeamAppsResult linkedAppsListTeamLinkedApps() throws ListTeamAppsErrorException, DbxException {
        ListTeamAppsArg _arg = new ListTeamAppsArg();
        return linkedAppsListTeamLinkedApps(_arg);
    }

    /**
     * List all applications linked to the team members' accounts.
     *
     * <p> Note, this endpoint doesn't list any team-linked applications. </p>
     *
     * @param cursor  At the first call to the {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps(String)} the cursor
     *     shouldn't be passed. Then, if the result of the call includes a
     *     cursor, the following requests should include the received cursors in
     *     order to receive the next sub list of the team applications.
     *
     * @return Information returned by {@link
     *     DbxTeamTeamRequests#linkedAppsListTeamLinkedApps(String)}.
     *
     * @deprecated use {@link
     *     DbxTeamTeamRequests#linkedAppsListMembersLinkedApps(String)} instead.
     */
    @Deprecated
    public ListTeamAppsResult linkedAppsListTeamLinkedApps(String cursor) throws ListTeamAppsErrorException, DbxException {
        ListTeamAppsArg _arg = new ListTeamAppsArg(cursor);
        return linkedAppsListTeamLinkedApps(_arg);
    }

    //
    // route 2/team/linked_apps/revoke_linked_app
    //

    /**
     * Revoke a linked application of the team member.
     *
     */
    void linkedAppsRevokeLinkedApp(RevokeLinkedApiAppArg arg) throws RevokeLinkedAppErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/team/linked_apps/revoke_linked_app",
                                 arg,
                                 false,
                                 RevokeLinkedApiAppArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 RevokeLinkedAppError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RevokeLinkedAppErrorException("2/team/linked_apps/revoke_linked_app", ex.getRequestId(), ex.getUserMessage(), (RevokeLinkedAppError) ex.getErrorValue());
        }
    }

    /**
     * Revoke a linked application of the team member.
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
        RevokeLinkedApiAppArg _arg = new RevokeLinkedApiAppArg(appId, teamMemberId);
        linkedAppsRevokeLinkedApp(_arg);
    }

    /**
     * Revoke a linked application of the team member.
     *
     * @param appId  The application's unique id. Must not be {@code null}.
     * @param teamMemberId  The unique id of the member owning the device. Must
     *     not be {@code null}.
     * @param keepAppFolder  This flag is not longer supported, the application
     *     dedicated folder (in case the application uses  one) will be kept.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void linkedAppsRevokeLinkedApp(String appId, String teamMemberId, boolean keepAppFolder) throws RevokeLinkedAppErrorException, DbxException {
        RevokeLinkedApiAppArg _arg = new RevokeLinkedApiAppArg(appId, teamMemberId, keepAppFolder);
        linkedAppsRevokeLinkedApp(_arg);
    }

    //
    // route 2/team/linked_apps/revoke_linked_app_batch
    //

    /**
     * Revoke a list of linked applications of the team members.
     *
     */
    RevokeLinkedAppBatchResult linkedAppsRevokeLinkedAppBatch(RevokeLinkedApiAppBatchArg arg) throws RevokeLinkedAppBatchErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/linked_apps/revoke_linked_app_batch",
                                        arg,
                                        false,
                                        RevokeLinkedApiAppBatchArg.Serializer.INSTANCE,
                                        RevokeLinkedAppBatchResult.Serializer.INSTANCE,
                                        RevokeLinkedAppBatchError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RevokeLinkedAppBatchErrorException("2/team/linked_apps/revoke_linked_app_batch", ex.getRequestId(), ex.getUserMessage(), (RevokeLinkedAppBatchError) ex.getErrorValue());
        }
    }

    /**
     * Revoke a list of linked applications of the team members.
     *
     * @param revokeLinkedApp  Must not contain a {@code null} item and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RevokeLinkedAppBatchResult linkedAppsRevokeLinkedAppBatch(List<RevokeLinkedApiAppArg> revokeLinkedApp) throws RevokeLinkedAppBatchErrorException, DbxException {
        RevokeLinkedApiAppBatchArg _arg = new RevokeLinkedApiAppBatchArg(revokeLinkedApp);
        return linkedAppsRevokeLinkedAppBatch(_arg);
    }

    //
    // route 2/team/member_space_limits/excluded_users/add
    //

    /**
     * Add users to member space limits excluded users list.
     *
     * @param arg  Argument of excluded users update operation. Should include a
     *     list of users to add/remove (according to endpoint), Maximum size of
     *     the list is 1000 users.
     *
     * @return Excluded users update result.
     */
    ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersAdd(ExcludedUsersUpdateArg arg) throws ExcludedUsersUpdateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/member_space_limits/excluded_users/add",
                                        arg,
                                        false,
                                        ExcludedUsersUpdateArg.Serializer.INSTANCE,
                                        ExcludedUsersUpdateResult.Serializer.INSTANCE,
                                        ExcludedUsersUpdateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ExcludedUsersUpdateErrorException("2/team/member_space_limits/excluded_users/add", ex.getRequestId(), ex.getUserMessage(), (ExcludedUsersUpdateError) ex.getErrorValue());
        }
    }

    /**
     * Add users to member space limits excluded users list.
     *
     * @return Excluded users update result.
     */
    public ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersAdd() throws ExcludedUsersUpdateErrorException, DbxException {
        ExcludedUsersUpdateArg _arg = new ExcludedUsersUpdateArg();
        return memberSpaceLimitsExcludedUsersAdd(_arg);
    }

    /**
     * Add users to member space limits excluded users list.
     *
     * @param users  List of users to be added/removed. Must not contain a
     *     {@code null} item.
     *
     * @return Excluded users update result.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersAdd(List<UserSelectorArg> users) throws ExcludedUsersUpdateErrorException, DbxException {
        if (users != null) {
            for (UserSelectorArg x : users) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'users' is null");
                }
            }
        }
        ExcludedUsersUpdateArg _arg = new ExcludedUsersUpdateArg(users);
        return memberSpaceLimitsExcludedUsersAdd(_arg);
    }

    //
    // route 2/team/member_space_limits/excluded_users/list
    //

    /**
     * List member space limits excluded users.
     *
     * @param arg  Excluded users list argument.
     *
     * @return Excluded users list result.
     */
    ExcludedUsersListResult memberSpaceLimitsExcludedUsersList(ExcludedUsersListArg arg) throws ExcludedUsersListErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/member_space_limits/excluded_users/list",
                                        arg,
                                        false,
                                        ExcludedUsersListArg.Serializer.INSTANCE,
                                        ExcludedUsersListResult.Serializer.INSTANCE,
                                        ExcludedUsersListError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ExcludedUsersListErrorException("2/team/member_space_limits/excluded_users/list", ex.getRequestId(), ex.getUserMessage(), (ExcludedUsersListError) ex.getErrorValue());
        }
    }

    /**
     * List member space limits excluded users.
     *
     * <p> The {@code limit} request parameter will default to {@code 1000L}
     * (see {@link #memberSpaceLimitsExcludedUsersList(long)}). </p>
     *
     * @return Excluded users list result.
     */
    public ExcludedUsersListResult memberSpaceLimitsExcludedUsersList() throws ExcludedUsersListErrorException, DbxException {
        ExcludedUsersListArg _arg = new ExcludedUsersListArg();
        return memberSpaceLimitsExcludedUsersList(_arg);
    }

    /**
     * List member space limits excluded users.
     *
     * @param limit  Number of results to return per call. Must be greater than
     *     or equal to 1 and be less than or equal to 1000.
     *
     * @return Excluded users list result.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExcludedUsersListResult memberSpaceLimitsExcludedUsersList(long limit) throws ExcludedUsersListErrorException, DbxException {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        ExcludedUsersListArg _arg = new ExcludedUsersListArg(limit);
        return memberSpaceLimitsExcludedUsersList(_arg);
    }

    //
    // route 2/team/member_space_limits/excluded_users/list/continue
    //

    /**
     * Continue listing member space limits excluded users.
     *
     * @param arg  Excluded users list continue argument.
     *
     * @return Excluded users list result.
     */
    ExcludedUsersListResult memberSpaceLimitsExcludedUsersListContinue(ExcludedUsersListContinueArg arg) throws ExcludedUsersListContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/member_space_limits/excluded_users/list/continue",
                                        arg,
                                        false,
                                        ExcludedUsersListContinueArg.Serializer.INSTANCE,
                                        ExcludedUsersListResult.Serializer.INSTANCE,
                                        ExcludedUsersListContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ExcludedUsersListContinueErrorException("2/team/member_space_limits/excluded_users/list/continue", ex.getRequestId(), ex.getUserMessage(), (ExcludedUsersListContinueError) ex.getErrorValue());
        }
    }

    /**
     * Continue listing member space limits excluded users.
     *
     * @param cursor  Indicates from what point to get the next set of users.
     *     Must not be {@code null}.
     *
     * @return Excluded users list result.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExcludedUsersListResult memberSpaceLimitsExcludedUsersListContinue(String cursor) throws ExcludedUsersListContinueErrorException, DbxException {
        ExcludedUsersListContinueArg _arg = new ExcludedUsersListContinueArg(cursor);
        return memberSpaceLimitsExcludedUsersListContinue(_arg);
    }

    //
    // route 2/team/member_space_limits/excluded_users/remove
    //

    /**
     * Remove users from member space limits excluded users list.
     *
     * @param arg  Argument of excluded users update operation. Should include a
     *     list of users to add/remove (according to endpoint), Maximum size of
     *     the list is 1000 users.
     *
     * @return Excluded users update result.
     */
    ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersRemove(ExcludedUsersUpdateArg arg) throws ExcludedUsersUpdateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/member_space_limits/excluded_users/remove",
                                        arg,
                                        false,
                                        ExcludedUsersUpdateArg.Serializer.INSTANCE,
                                        ExcludedUsersUpdateResult.Serializer.INSTANCE,
                                        ExcludedUsersUpdateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ExcludedUsersUpdateErrorException("2/team/member_space_limits/excluded_users/remove", ex.getRequestId(), ex.getUserMessage(), (ExcludedUsersUpdateError) ex.getErrorValue());
        }
    }

    /**
     * Remove users from member space limits excluded users list.
     *
     * @return Excluded users update result.
     */
    public ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersRemove() throws ExcludedUsersUpdateErrorException, DbxException {
        ExcludedUsersUpdateArg _arg = new ExcludedUsersUpdateArg();
        return memberSpaceLimitsExcludedUsersRemove(_arg);
    }

    /**
     * Remove users from member space limits excluded users list.
     *
     * @param users  List of users to be added/removed. Must not contain a
     *     {@code null} item.
     *
     * @return Excluded users update result.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExcludedUsersUpdateResult memberSpaceLimitsExcludedUsersRemove(List<UserSelectorArg> users) throws ExcludedUsersUpdateErrorException, DbxException {
        if (users != null) {
            for (UserSelectorArg x : users) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'users' is null");
                }
            }
        }
        ExcludedUsersUpdateArg _arg = new ExcludedUsersUpdateArg(users);
        return memberSpaceLimitsExcludedUsersRemove(_arg);
    }

    //
    // route 2/team/member_space_limits/get_custom_quota
    //

    /**
     * Get users custom quota. A maximum of 1000 members can be specified in a
     * single call. Note: to apply a custom space limit, a team admin needs to
     * set a member space limit for the team first. (the team admin can check
     * the settings here: https://www.dropbox.com/team/admin/settings/space).
     *
     */
    List<CustomQuotaResult> memberSpaceLimitsGetCustomQuota(CustomQuotaUsersArg arg) throws CustomQuotaErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/member_space_limits/get_custom_quota",
                                        arg,
                                        false,
                                        CustomQuotaUsersArg.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(CustomQuotaResult.Serializer.INSTANCE),
                                        CustomQuotaError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new CustomQuotaErrorException("2/team/member_space_limits/get_custom_quota", ex.getRequestId(), ex.getUserMessage(), (CustomQuotaError) ex.getErrorValue());
        }
    }

    /**
     * Get users custom quota. A maximum of 1000 members can be specified in a
     * single call. Note: to apply a custom space limit, a team admin needs to
     * set a member space limit for the team first. (the team admin can check
     * the settings here: https://www.dropbox.com/team/admin/settings/space).
     *
     * @param users  List of users. Must not contain a {@code null} item and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<CustomQuotaResult> memberSpaceLimitsGetCustomQuota(List<UserSelectorArg> users) throws CustomQuotaErrorException, DbxException {
        CustomQuotaUsersArg _arg = new CustomQuotaUsersArg(users);
        return memberSpaceLimitsGetCustomQuota(_arg);
    }

    //
    // route 2/team/member_space_limits/remove_custom_quota
    //

    /**
     * Remove users custom quota. A maximum of 1000 members can be specified in
     * a single call. Note: to apply a custom space limit, a team admin needs to
     * set a member space limit for the team first. (the team admin can check
     * the settings here: https://www.dropbox.com/team/admin/settings/space).
     *
     */
    List<RemoveCustomQuotaResult> memberSpaceLimitsRemoveCustomQuota(CustomQuotaUsersArg arg) throws CustomQuotaErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/member_space_limits/remove_custom_quota",
                                        arg,
                                        false,
                                        CustomQuotaUsersArg.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(RemoveCustomQuotaResult.Serializer.INSTANCE),
                                        CustomQuotaError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new CustomQuotaErrorException("2/team/member_space_limits/remove_custom_quota", ex.getRequestId(), ex.getUserMessage(), (CustomQuotaError) ex.getErrorValue());
        }
    }

    /**
     * Remove users custom quota. A maximum of 1000 members can be specified in
     * a single call. Note: to apply a custom space limit, a team admin needs to
     * set a member space limit for the team first. (the team admin can check
     * the settings here: https://www.dropbox.com/team/admin/settings/space).
     *
     * @param users  List of users. Must not contain a {@code null} item and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<RemoveCustomQuotaResult> memberSpaceLimitsRemoveCustomQuota(List<UserSelectorArg> users) throws CustomQuotaErrorException, DbxException {
        CustomQuotaUsersArg _arg = new CustomQuotaUsersArg(users);
        return memberSpaceLimitsRemoveCustomQuota(_arg);
    }

    //
    // route 2/team/member_space_limits/set_custom_quota
    //

    /**
     * Set users custom quota. Custom quota has to be at least 15GB. A maximum
     * of 1000 members can be specified in a single call. Note: to apply a
     * custom space limit, a team admin needs to set a member space limit for
     * the team first. (the team admin can check the settings here:
     * https://www.dropbox.com/team/admin/settings/space).
     *
     */
    List<CustomQuotaResult> memberSpaceLimitsSetCustomQuota(SetCustomQuotaArg arg) throws SetCustomQuotaErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/member_space_limits/set_custom_quota",
                                        arg,
                                        false,
                                        SetCustomQuotaArg.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(CustomQuotaResult.Serializer.INSTANCE),
                                        SetCustomQuotaError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SetCustomQuotaErrorException("2/team/member_space_limits/set_custom_quota", ex.getRequestId(), ex.getUserMessage(), (SetCustomQuotaError) ex.getErrorValue());
        }
    }

    /**
     * Set users custom quota. Custom quota has to be at least 15GB. A maximum
     * of 1000 members can be specified in a single call. Note: to apply a
     * custom space limit, a team admin needs to set a member space limit for
     * the team first. (the team admin can check the settings here:
     * https://www.dropbox.com/team/admin/settings/space).
     *
     * @param usersAndQuotas  List of users and their custom quotas. Must not
     *     contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<CustomQuotaResult> memberSpaceLimitsSetCustomQuota(List<UserCustomQuotaArg> usersAndQuotas) throws SetCustomQuotaErrorException, DbxException {
        SetCustomQuotaArg _arg = new SetCustomQuotaArg(usersAndQuotas);
        return memberSpaceLimitsSetCustomQuota(_arg);
    }

    //
    // route 2/team/members/add_v2
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
    MembersAddLaunchV2Result membersAddV2(MembersAddV2Arg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/add_v2",
                                        arg,
                                        false,
                                        MembersAddV2Arg.Serializer.INSTANCE,
                                        MembersAddLaunchV2Result.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"members/add_v2\":" + ex.getErrorValue());
        }
    }

    /**
     * Adds members to a team.
     *
     * <p> Permission : Team member management </p>
     *
     * <p> A maximum of 20 members can be specified in a single call. </p>
     *
     * <p> If no Dropbox account exists with the email address specified, a new
     * Dropbox account will be created with the given email address, and that
     * account will be invited to the team. </p>
     *
     * <p> If a personal Dropbox account exists with the email address specified
     * in the call, this call will create a placeholder Dropbox account for the
     * user on the team and send an email inviting the user to migrate their
     * existing personal account onto the team. </p>
     *
     * <p> Team member management apps are required to set an initial given_name
     * and surname for a user to use in the team invitation and for 'Perform as
     * team member' actions taken on the user before they become 'active'. </p>
     *
     * <p> The {@code forceAsync} request parameter will default to {@code
     * false} (see {@link #membersAddV2(List,boolean)}). </p>
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddLaunchV2Result membersAddV2(List<MemberAddV2Arg> newMembers) throws DbxApiException, DbxException {
        MembersAddV2Arg _arg = new MembersAddV2Arg(newMembers);
        return membersAddV2(_arg);
    }

    /**
     * Adds members to a team.
     *
     * <p> Permission : Team member management </p>
     *
     * <p> A maximum of 20 members can be specified in a single call. </p>
     *
     * <p> If no Dropbox account exists with the email address specified, a new
     * Dropbox account will be created with the given email address, and that
     * account will be invited to the team. </p>
     *
     * <p> If a personal Dropbox account exists with the email address specified
     * in the call, this call will create a placeholder Dropbox account for the
     * user on the team and send an email inviting the user to migrate their
     * existing personal account onto the team. </p>
     *
     * <p> Team member management apps are required to set an initial given_name
     * and surname for a user to use in the team invitation and for 'Perform as
     * team member' actions taken on the user before they become 'active'. </p>
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param forceAsync  Whether to force the add to happen asynchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddLaunchV2Result membersAddV2(List<MemberAddV2Arg> newMembers, boolean forceAsync) throws DbxApiException, DbxException {
        MembersAddV2Arg _arg = new MembersAddV2Arg(newMembers, forceAsync);
        return membersAddV2(_arg);
    }

    //
    // route 2/team/members/add
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
    MembersAddLaunch membersAdd(MembersAddArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/add",
                                        arg,
                                        false,
                                        MembersAddArg.Serializer.INSTANCE,
                                        MembersAddLaunch.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"members/add\":" + ex.getErrorValue());
        }
    }

    /**
     * Adds members to a team.
     *
     * <p> Permission : Team member management </p>
     *
     * <p> A maximum of 20 members can be specified in a single call. </p>
     *
     * <p> If no Dropbox account exists with the email address specified, a new
     * Dropbox account will be created with the given email address, and that
     * account will be invited to the team. </p>
     *
     * <p> If a personal Dropbox account exists with the email address specified
     * in the call, this call will create a placeholder Dropbox account for the
     * user on the team and send an email inviting the user to migrate their
     * existing personal account onto the team. </p>
     *
     * <p> Team member management apps are required to set an initial given_name
     * and surname for a user to use in the team invitation and for 'Perform as
     * team member' actions taken on the user before they become 'active'. </p>
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
    public MembersAddLaunch membersAdd(List<MemberAddArg> newMembers) throws DbxApiException, DbxException {
        MembersAddArg _arg = new MembersAddArg(newMembers);
        return membersAdd(_arg);
    }

    /**
     * Adds members to a team.
     *
     * <p> Permission : Team member management </p>
     *
     * <p> A maximum of 20 members can be specified in a single call. </p>
     *
     * <p> If no Dropbox account exists with the email address specified, a new
     * Dropbox account will be created with the given email address, and that
     * account will be invited to the team. </p>
     *
     * <p> If a personal Dropbox account exists with the email address specified
     * in the call, this call will create a placeholder Dropbox account for the
     * user on the team and send an email inviting the user to migrate their
     * existing personal account onto the team. </p>
     *
     * <p> Team member management apps are required to set an initial given_name
     * and surname for a user to use in the team invitation and for 'Perform as
     * team member' actions taken on the user before they become 'active'. </p>
     *
     * @param newMembers  Details of new members to be added to the team. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param forceAsync  Whether to force the add to happen asynchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddLaunch membersAdd(List<MemberAddArg> newMembers, boolean forceAsync) throws DbxApiException, DbxException {
        MembersAddArg _arg = new MembersAddArg(newMembers, forceAsync);
        return membersAdd(_arg);
    }

    //
    // route 2/team/members/add/job_status/get_v2
    //

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersAddV2(List,boolean)} , use this to poll the
     * status of the asynchronous request. Permission : Team member management.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    MembersAddJobStatusV2Result membersAddJobStatusGetV2(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/add/job_status/get_v2",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        MembersAddJobStatusV2Result.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/team/members/add/job_status/get_v2", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersAddV2(List,boolean)} , use this to poll the
     * status of the asynchronous request.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddJobStatusV2Result membersAddJobStatusGetV2(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return membersAddJobStatusGetV2(_arg);
    }

    //
    // route 2/team/members/add/job_status/get
    //

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersAdd(List,boolean)} , use this to poll the
     * status of the asynchronous request. Permission : Team member management.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    MembersAddJobStatus membersAddJobStatusGet(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/add/job_status/get",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        MembersAddJobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/team/members/add/job_status/get", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersAdd(List,boolean)} , use this to poll the
     * status of the asynchronous request.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersAddJobStatus membersAddJobStatusGet(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return membersAddJobStatusGet(_arg);
    }

    //
    // route 2/team/members/delete_profile_photo_v2
    //

    /**
     * Deletes a team member's profile photo. Permission : Team member
     * management.
     *
     *
     * @return Information about a team member, after the change, like at {@link
     *     DbxTeamTeamRequests#membersSetProfileV2(UserSelectorArg)}.
     */
    TeamMemberInfoV2Result membersDeleteProfilePhotoV2(MembersDeleteProfilePhotoArg arg) throws MembersDeleteProfilePhotoErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/delete_profile_photo_v2",
                                        arg,
                                        false,
                                        MembersDeleteProfilePhotoArg.Serializer.INSTANCE,
                                        TeamMemberInfoV2Result.Serializer.INSTANCE,
                                        MembersDeleteProfilePhotoError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersDeleteProfilePhotoErrorException("2/team/members/delete_profile_photo_v2", ex.getRequestId(), ex.getUserMessage(), (MembersDeleteProfilePhotoError) ex.getErrorValue());
        }
    }

    /**
     * Deletes a team member's profile photo.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param user  Identity of the user whose profile photo will be deleted.
     *     Must not be {@code null}.
     *
     * @return Information about a team member, after the change, like at {@link
     *     DbxTeamTeamRequests#membersSetProfileV2(UserSelectorArg)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfoV2Result membersDeleteProfilePhotoV2(UserSelectorArg user) throws MembersDeleteProfilePhotoErrorException, DbxException {
        MembersDeleteProfilePhotoArg _arg = new MembersDeleteProfilePhotoArg(user);
        return membersDeleteProfilePhotoV2(_arg);
    }

    //
    // route 2/team/members/delete_profile_photo
    //

    /**
     * Deletes a team member's profile photo. Permission : Team member
     * management.
     *
     *
     * @return Information about a team member.
     */
    TeamMemberInfo membersDeleteProfilePhoto(MembersDeleteProfilePhotoArg arg) throws MembersDeleteProfilePhotoErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/delete_profile_photo",
                                        arg,
                                        false,
                                        MembersDeleteProfilePhotoArg.Serializer.INSTANCE,
                                        TeamMemberInfo.Serializer.INSTANCE,
                                        MembersDeleteProfilePhotoError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersDeleteProfilePhotoErrorException("2/team/members/delete_profile_photo", ex.getRequestId(), ex.getUserMessage(), (MembersDeleteProfilePhotoError) ex.getErrorValue());
        }
    }

    /**
     * Deletes a team member's profile photo.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param user  Identity of the user whose profile photo will be deleted.
     *     Must not be {@code null}.
     *
     * @return Information about a team member.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfo membersDeleteProfilePhoto(UserSelectorArg user) throws MembersDeleteProfilePhotoErrorException, DbxException {
        MembersDeleteProfilePhotoArg _arg = new MembersDeleteProfilePhotoArg(user);
        return membersDeleteProfilePhoto(_arg);
    }

    //
    // route 2/team/members/get_available_team_member_roles
    //

    /**
     * Get available TeamMemberRoles for the connected team. To be used with
     * {@link
     * DbxTeamTeamRequests#membersSetAdminPermissionsV2(UserSelectorArg,List)}.
     * Permission : Team member management.
     *
     * @return Available TeamMemberRole for the connected team. To be used with
     *     {@link
     *     DbxTeamTeamRequests#membersSetAdminPermissionsV2(UserSelectorArg,List)}.
     */
    public MembersGetAvailableTeamMemberRolesResult membersGetAvailableTeamMemberRoles() throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/get_available_team_member_roles",
                                        null,
                                        false,
                                        com.dropbox.core.stone.StoneSerializers.void_(),
                                        MembersGetAvailableTeamMemberRolesResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"members/get_available_team_member_roles\":" + ex.getErrorValue());
        }
    }

    //
    // route 2/team/members/get_info_v2
    //

    /**
     * Returns information about multiple team members. Permission : Team
     * information This endpoint will return {@link
     * MembersGetInfoItem#getIdNotFoundValue}, for IDs (or emails) that cannot
     * be matched to a valid team member.
     *
     */
    MembersGetInfoV2Result membersGetInfoV2(MembersGetInfoV2Arg arg) throws MembersGetInfoErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/get_info_v2",
                                        arg,
                                        false,
                                        MembersGetInfoV2Arg.Serializer.INSTANCE,
                                        MembersGetInfoV2Result.Serializer.INSTANCE,
                                        MembersGetInfoError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersGetInfoErrorException("2/team/members/get_info_v2", ex.getRequestId(), ex.getUserMessage(), (MembersGetInfoError) ex.getErrorValue());
        }
    }

    /**
     * Returns information about multiple team members.
     *
     * <p> Permission : Team information </p>
     *
     * <p> This endpoint will return {@link
     * MembersGetInfoItem#getIdNotFoundValue}, for IDs (or emails) that cannot
     * be matched to a valid team member. </p>
     *
     * @param members  List of team members. Must not contain a {@code null}
     *     item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersGetInfoV2Result membersGetInfoV2(List<UserSelectorArg> members) throws MembersGetInfoErrorException, DbxException {
        MembersGetInfoV2Arg _arg = new MembersGetInfoV2Arg(members);
        return membersGetInfoV2(_arg);
    }

    //
    // route 2/team/members/get_info
    //

    /**
     * Returns information about multiple team members. Permission : Team
     * information This endpoint will return {@link
     * MembersGetInfoItem#getIdNotFoundValue}, for IDs (or emails) that cannot
     * be matched to a valid team member.
     *
     */
    List<MembersGetInfoItem> membersGetInfo(MembersGetInfoArgs arg) throws MembersGetInfoErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/get_info",
                                        arg,
                                        false,
                                        MembersGetInfoArgs.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(MembersGetInfoItem.Serializer.INSTANCE),
                                        MembersGetInfoError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersGetInfoErrorException("2/team/members/get_info", ex.getRequestId(), ex.getUserMessage(), (MembersGetInfoError) ex.getErrorValue());
        }
    }

    /**
     * Returns information about multiple team members.
     *
     * <p> Permission : Team information </p>
     *
     * <p> This endpoint will return {@link
     * MembersGetInfoItem#getIdNotFoundValue}, for IDs (or emails) that cannot
     * be matched to a valid team member. </p>
     *
     * @param members  List of team members. Must not contain a {@code null}
     *     item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<MembersGetInfoItem> membersGetInfo(List<UserSelectorArg> members) throws MembersGetInfoErrorException, DbxException {
        MembersGetInfoArgs _arg = new MembersGetInfoArgs(members);
        return membersGetInfo(_arg);
    }

    //
    // route 2/team/members/list_v2
    //

    /**
     * Lists members of a team. Permission : Team information.
     *
     */
    MembersListV2Result membersListV2(MembersListArg arg) throws MembersListErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/list_v2",
                                        arg,
                                        false,
                                        MembersListArg.Serializer.INSTANCE,
                                        MembersListV2Result.Serializer.INSTANCE,
                                        MembersListError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersListErrorException("2/team/members/list_v2", ex.getRequestId(), ex.getUserMessage(), (MembersListError) ex.getErrorValue());
        }
    }

    /**
     * Lists members of a team.
     *
     * <p> Permission : Team information. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link MembersListV2Builder} for more details. </p>
     */
    public MembersListV2Result membersListV2() throws MembersListErrorException, DbxException {
        MembersListArg _arg = new MembersListArg();
        return membersListV2(_arg);
    }

    /**
     * Lists members of a team. Permission : Team information.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public MembersListV2Builder membersListV2Builder() {
        MembersListArg.Builder argBuilder_ = MembersListArg.newBuilder();
        return new MembersListV2Builder(this, argBuilder_);
    }

    //
    // route 2/team/members/list
    //

    /**
     * Lists members of a team. Permission : Team information.
     *
     */
    MembersListResult membersList(MembersListArg arg) throws MembersListErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/list",
                                        arg,
                                        false,
                                        MembersListArg.Serializer.INSTANCE,
                                        MembersListResult.Serializer.INSTANCE,
                                        MembersListError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersListErrorException("2/team/members/list", ex.getRequestId(), ex.getUserMessage(), (MembersListError) ex.getErrorValue());
        }
    }

    /**
     * Lists members of a team.
     *
     * <p> Permission : Team information. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link MembersListBuilder} for more details. </p>
     */
    public MembersListResult membersList() throws MembersListErrorException, DbxException {
        MembersListArg _arg = new MembersListArg();
        return membersList(_arg);
    }

    /**
     * Lists members of a team. Permission : Team information.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public MembersListBuilder membersListBuilder() {
        MembersListArg.Builder argBuilder_ = MembersListArg.newBuilder();
        return new MembersListBuilder(this, argBuilder_);
    }

    //
    // route 2/team/members/list/continue_v2
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#membersListV2}, use this to paginate through all team
     * members. Permission : Team information.
     *
     */
    MembersListV2Result membersListContinueV2(MembersListContinueArg arg) throws MembersListContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/list/continue_v2",
                                        arg,
                                        false,
                                        MembersListContinueArg.Serializer.INSTANCE,
                                        MembersListV2Result.Serializer.INSTANCE,
                                        MembersListContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersListContinueErrorException("2/team/members/list/continue_v2", ex.getRequestId(), ex.getUserMessage(), (MembersListContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#membersListV2}, use this to paginate through all team
     * members.
     *
     * <p> Permission : Team information. </p>
     *
     * @param cursor  Indicates from what point to get the next set of members.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersListV2Result membersListContinueV2(String cursor) throws MembersListContinueErrorException, DbxException {
        MembersListContinueArg _arg = new MembersListContinueArg(cursor);
        return membersListContinueV2(_arg);
    }

    //
    // route 2/team/members/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#membersList}, use this to paginate through all team
     * members. Permission : Team information.
     *
     */
    MembersListResult membersListContinue(MembersListContinueArg arg) throws MembersListContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/list/continue",
                                        arg,
                                        false,
                                        MembersListContinueArg.Serializer.INSTANCE,
                                        MembersListResult.Serializer.INSTANCE,
                                        MembersListContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersListContinueErrorException("2/team/members/list/continue", ex.getRequestId(), ex.getUserMessage(), (MembersListContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#membersList}, use this to paginate through all team
     * members.
     *
     * <p> Permission : Team information. </p>
     *
     * @param cursor  Indicates from what point to get the next set of members.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersListResult membersListContinue(String cursor) throws MembersListContinueErrorException, DbxException {
        MembersListContinueArg _arg = new MembersListContinueArg(cursor);
        return membersListContinue(_arg);
    }

    //
    // route 2/team/members/move_former_member_files
    //

    /**
     * Moves removed member's files to a different member. This endpoint
     * initiates an asynchronous job. To obtain the final result of the job, the
     * client should periodically poll {@link
     * DbxTeamTeamRequests#membersMoveFormerMemberFilesJobStatusCheck(String)}.
     * Permission : Team member management.
     *
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     */
    LaunchEmptyResult membersMoveFormerMemberFiles(MembersDataTransferArg arg) throws MembersTransferFormerMembersFilesErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/move_former_member_files",
                                        arg,
                                        false,
                                        MembersDataTransferArg.Serializer.INSTANCE,
                                        LaunchEmptyResult.Serializer.INSTANCE,
                                        MembersTransferFormerMembersFilesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersTransferFormerMembersFilesErrorException("2/team/members/move_former_member_files", ex.getRequestId(), ex.getUserMessage(), (MembersTransferFormerMembersFilesError) ex.getErrorValue());
        }
    }

    /**
     * Moves removed member's files to a different member. This endpoint
     * initiates an asynchronous job. To obtain the final result of the job, the
     * client should periodically poll {@link
     * DbxTeamTeamRequests#membersMoveFormerMemberFilesJobStatusCheck(String)}.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     * @param transferDestId  Files from the deleted member account will be
     *     transferred to this user. Must not be {@code null}.
     * @param transferAdminId  Errors during the transfer process will be sent
     *     via email to this user. Must not be {@code null}.
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LaunchEmptyResult membersMoveFormerMemberFiles(UserSelectorArg user, UserSelectorArg transferDestId, UserSelectorArg transferAdminId) throws MembersTransferFormerMembersFilesErrorException, DbxException {
        MembersDataTransferArg _arg = new MembersDataTransferArg(user, transferDestId, transferAdminId);
        return membersMoveFormerMemberFiles(_arg);
    }

    //
    // route 2/team/members/move_former_member_files/job_status/check
    //

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersMoveFormerMemberFiles(UserSelectorArg,UserSelectorArg,UserSelectorArg)}
     * , use this to poll the status of the asynchronous request. Permission :
     * Team member management.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     *
     * @return Result returned by methods that poll for the status of an
     *     asynchronous job. Upon completion of the job, no additional
     *     information is returned.
     */
    PollEmptyResult membersMoveFormerMemberFilesJobStatusCheck(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/move_former_member_files/job_status/check",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        PollEmptyResult.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/team/members/move_former_member_files/job_status/check", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersMoveFormerMemberFiles(UserSelectorArg,UserSelectorArg,UserSelectorArg)}
     * , use this to poll the status of the asynchronous request.
     *
     * <p> Permission : Team member management. </p>
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
    public PollEmptyResult membersMoveFormerMemberFilesJobStatusCheck(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return membersMoveFormerMemberFilesJobStatusCheck(_arg);
    }

    //
    // route 2/team/members/recover
    //

    /**
     * Recover a deleted member. Permission : Team member management Exactly one
     * of team_member_id, email, or external_id must be provided to identify the
     * user account.
     *
     * @param arg  Exactly one of team_member_id, email, or external_id must be
     *     provided to identify the user account.
     */
    void membersRecover(MembersRecoverArg arg) throws MembersRecoverErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/team/members/recover",
                                 arg,
                                 false,
                                 MembersRecoverArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 MembersRecoverError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersRecoverErrorException("2/team/members/recover", ex.getRequestId(), ex.getUserMessage(), (MembersRecoverError) ex.getErrorValue());
        }
    }

    /**
     * Recover a deleted member.
     *
     * <p> Permission : Team member management </p>
     *
     * <p> Exactly one of team_member_id, email, or external_id must be provided
     * to identify the user account. </p>
     *
     * @param user  Identity of user to recover. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void membersRecover(UserSelectorArg user) throws MembersRecoverErrorException, DbxException {
        MembersRecoverArg _arg = new MembersRecoverArg(user);
        membersRecover(_arg);
    }

    //
    // route 2/team/members/remove
    //

    /**
     * Removes a member from a team. Permission : Team member management Exactly
     * one of team_member_id, email, or external_id must be provided to identify
     * the user account. Accounts can be recovered via {@link
     * DbxTeamTeamRequests#membersRecover(UserSelectorArg)} for a 7 day period
     * or until the account has been permanently deleted or transferred to
     * another account (whichever comes first). Calling {@link
     * DbxTeamTeamRequests#membersAdd(List,boolean)} while a user is still
     * recoverable on your team will return with {@link
     * MemberAddResult#getUserAlreadyOnTeamValue}. Accounts can have their files
     * transferred via the admin console for a limited time, based on the
     * version history length associated with the team (180 days for most
     * teams). This endpoint may initiate an asynchronous job. To obtain the
     * final result of the job, the client should periodically poll {@link
     * DbxTeamTeamRequests#membersRemoveJobStatusGet(String)}.
     *
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     */
    LaunchEmptyResult membersRemove(MembersRemoveArg arg) throws MembersRemoveErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/remove",
                                        arg,
                                        false,
                                        MembersRemoveArg.Serializer.INSTANCE,
                                        LaunchEmptyResult.Serializer.INSTANCE,
                                        MembersRemoveError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersRemoveErrorException("2/team/members/remove", ex.getRequestId(), ex.getUserMessage(), (MembersRemoveError) ex.getErrorValue());
        }
    }

    /**
     * Removes a member from a team.
     *
     * <p> Permission : Team member management </p>
     *
     * <p> Exactly one of team_member_id, email, or external_id must be provided
     * to identify the user account. </p>
     *
     * <p> Accounts can be recovered via {@link
     * DbxTeamTeamRequests#membersRecover(UserSelectorArg)} for a 7 day period
     * or until the account has been permanently deleted or transferred to
     * another account (whichever comes first). Calling {@link
     * DbxTeamTeamRequests#membersAdd(List,boolean)} while a user is still
     * recoverable on your team will return with {@link
     * MemberAddResult#getUserAlreadyOnTeamValue}. </p>
     *
     * <p> Accounts can have their files transferred via the admin console for a
     * limited time, based on the version history length associated with the
     * team (180 days for most teams). </p>
     *
     * <p> This endpoint may initiate an asynchronous job. To obtain the final
     * result of the job, the client should periodically poll {@link
     * DbxTeamTeamRequests#membersRemoveJobStatusGet(String)}. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link MembersRemoveBuilder} for more details. </p>
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LaunchEmptyResult membersRemove(UserSelectorArg user) throws MembersRemoveErrorException, DbxException {
        MembersRemoveArg _arg = new MembersRemoveArg(user);
        return membersRemove(_arg);
    }

    /**
     * Removes a member from a team. Permission : Team member management Exactly
     * one of team_member_id, email, or external_id must be provided to identify
     * the user account. Accounts can be recovered via {@link
     * DbxTeamTeamRequests#membersRecover(UserSelectorArg)} for a 7 day period
     * or until the account has been permanently deleted or transferred to
     * another account (whichever comes first). Calling {@link
     * DbxTeamTeamRequests#membersAdd(List,boolean)} while a user is still
     * recoverable on your team will return with {@link
     * MemberAddResult#getUserAlreadyOnTeamValue}. Accounts can have their files
     * transferred via the admin console for a limited time, based on the
     * version history length associated with the team (180 days for most
     * teams). This endpoint may initiate an asynchronous job. To obtain the
     * final result of the job, the client should periodically poll {@link
     * DbxTeamTeamRequests#membersRemoveJobStatusGet(String)}.
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersRemoveBuilder membersRemoveBuilder(UserSelectorArg user) {
        MembersRemoveArg.Builder argBuilder_ = MembersRemoveArg.newBuilder(user);
        return new MembersRemoveBuilder(this, argBuilder_);
    }

    //
    // route 2/team/members/remove/job_status/get
    //

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersRemove(UserSelectorArg)} , use this to poll
     * the status of the asynchronous request. Permission : Team member
     * management.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     *
     * @return Result returned by methods that poll for the status of an
     *     asynchronous job. Upon completion of the job, no additional
     *     information is returned.
     */
    PollEmptyResult membersRemoveJobStatusGet(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/remove/job_status/get",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        PollEmptyResult.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/team/members/remove/job_status/get", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Once an async_job_id is returned from {@link
     * DbxTeamTeamRequests#membersRemove(UserSelectorArg)} , use this to poll
     * the status of the asynchronous request.
     *
     * <p> Permission : Team member management. </p>
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
        PollArg _arg = new PollArg(asyncJobId);
        return membersRemoveJobStatusGet(_arg);
    }

    //
    // route 2/team/members/secondary_emails/add
    //

    /**
     * Add secondary emails to users. Permission : Team member management.
     * Emails that are on verified domains will be verified automatically. For
     * each email address not on a verified domain a verification email will be
     * sent.
     *
     */
    AddSecondaryEmailsResult membersSecondaryEmailsAdd(AddSecondaryEmailsArg arg) throws AddSecondaryEmailsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/secondary_emails/add",
                                        arg,
                                        false,
                                        AddSecondaryEmailsArg.Serializer.INSTANCE,
                                        AddSecondaryEmailsResult.Serializer.INSTANCE,
                                        AddSecondaryEmailsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new AddSecondaryEmailsErrorException("2/team/members/secondary_emails/add", ex.getRequestId(), ex.getUserMessage(), (AddSecondaryEmailsError) ex.getErrorValue());
        }
    }

    /**
     * Add secondary emails to users.
     *
     * <p> Permission : Team member management. </p>
     *
     * <p> Emails that are on verified domains will be verified automatically.
     * For each email address not on a verified domain a verification email will
     * be sent. </p>
     *
     * @param newSecondaryEmails  List of users and secondary emails to add.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddSecondaryEmailsResult membersSecondaryEmailsAdd(List<UserSecondaryEmailsArg> newSecondaryEmails) throws AddSecondaryEmailsErrorException, DbxException {
        AddSecondaryEmailsArg _arg = new AddSecondaryEmailsArg(newSecondaryEmails);
        return membersSecondaryEmailsAdd(_arg);
    }

    //
    // route 2/team/members/secondary_emails/delete
    //

    /**
     * Delete secondary emails from users Permission : Team member management.
     * Users will be notified of deletions of verified secondary emails at both
     * the secondary email and their primary email.
     *
     */
    DeleteSecondaryEmailsResult membersSecondaryEmailsDelete(DeleteSecondaryEmailsArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/secondary_emails/delete",
                                        arg,
                                        false,
                                        DeleteSecondaryEmailsArg.Serializer.INSTANCE,
                                        DeleteSecondaryEmailsResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"members/secondary_emails/delete\":" + ex.getErrorValue());
        }
    }

    /**
     * Delete secondary emails from users
     *
     * <p> Permission : Team member management. </p>
     *
     * <p> Users will be notified of deletions of verified secondary emails at
     * both the secondary email and their primary email. </p>
     *
     * @param emailsToDelete  List of users and their secondary emails to
     *     delete. Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteSecondaryEmailsResult membersSecondaryEmailsDelete(List<UserSecondaryEmailsArg> emailsToDelete) throws DbxApiException, DbxException {
        DeleteSecondaryEmailsArg _arg = new DeleteSecondaryEmailsArg(emailsToDelete);
        return membersSecondaryEmailsDelete(_arg);
    }

    //
    // route 2/team/members/secondary_emails/resend_verification_emails
    //

    /**
     * Resend secondary email verification emails. Permission : Team member
     * management.
     *
     *
     * @return List of users and resend results.
     */
    ResendVerificationEmailResult membersSecondaryEmailsResendVerificationEmails(ResendVerificationEmailArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/secondary_emails/resend_verification_emails",
                                        arg,
                                        false,
                                        ResendVerificationEmailArg.Serializer.INSTANCE,
                                        ResendVerificationEmailResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"members/secondary_emails/resend_verification_emails\":" + ex.getErrorValue());
        }
    }

    /**
     * Resend secondary email verification emails.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param emailsToResend  List of users and secondary emails to resend
     *     verification emails to. Must not contain a {@code null} item and not
     *     be {@code null}.
     *
     * @return List of users and resend results.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ResendVerificationEmailResult membersSecondaryEmailsResendVerificationEmails(List<UserSecondaryEmailsArg> emailsToResend) throws DbxApiException, DbxException {
        ResendVerificationEmailArg _arg = new ResendVerificationEmailArg(emailsToResend);
        return membersSecondaryEmailsResendVerificationEmails(_arg);
    }

    //
    // route 2/team/members/send_welcome_email
    //

    /**
     * Sends welcome email to pending team member. Permission : Team member
     * management Exactly one of team_member_id, email, or external_id must be
     * provided to identify the user account. No-op if team member is not
     * pending.
     *
     * @param arg  Argument for selecting a single user, either by
     *     team_member_id, external_id or email.
     */
    public void membersSendWelcomeEmail(UserSelectorArg arg) throws MembersSendWelcomeErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/team/members/send_welcome_email",
                                 arg,
                                 false,
                                 UserSelectorArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 MembersSendWelcomeError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersSendWelcomeErrorException("2/team/members/send_welcome_email", ex.getRequestId(), ex.getUserMessage(), (MembersSendWelcomeError) ex.getErrorValue());
        }
    }

    //
    // route 2/team/members/set_admin_permissions_v2
    //

    /**
     * Updates a team member's permissions. Permission : Team member management.
     *
     * @param arg  Exactly one of team_member_id, email, or external_id must be
     *     provided to identify the user account.
     */
    MembersSetPermissions2Result membersSetAdminPermissionsV2(MembersSetPermissions2Arg arg) throws MembersSetPermissions2ErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/set_admin_permissions_v2",
                                        arg,
                                        false,
                                        MembersSetPermissions2Arg.Serializer.INSTANCE,
                                        MembersSetPermissions2Result.Serializer.INSTANCE,
                                        MembersSetPermissions2Error.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersSetPermissions2ErrorException("2/team/members/set_admin_permissions_v2", ex.getRequestId(), ex.getUserMessage(), (MembersSetPermissions2Error) ex.getErrorValue());
        }
    }

    /**
     * Updates a team member's permissions.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param user  Identity of user whose role will be set. Must not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissions2Result membersSetAdminPermissionsV2(UserSelectorArg user) throws MembersSetPermissions2ErrorException, DbxException {
        MembersSetPermissions2Arg _arg = new MembersSetPermissions2Arg(user);
        return membersSetAdminPermissionsV2(_arg);
    }

    /**
     * Updates a team member's permissions.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param user  Identity of user whose role will be set. Must not be {@code
     *     null}.
     * @param newRoles  The new roles for the member. Send empty list to make
     *     user member only. For now, only up to one role is allowed. Must
     *     contain at most 1 items and not contain a {@code null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissions2Result membersSetAdminPermissionsV2(UserSelectorArg user, List<String> newRoles) throws MembersSetPermissions2ErrorException, DbxException {
        if (newRoles != null) {
            if (newRoles.size() > 1) {
                throw new IllegalArgumentException("List 'newRoles' has more than 1 items");
            }
            for (String x : newRoles) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'newRoles' is null");
                }
                if (x.length() > 128) {
                    throw new IllegalArgumentException("Stringan item in list 'newRoles' is longer than 128");
                }
                if (!java.util.regex.Pattern.matches("pid_dbtmr:.*", x)) {
                    throw new IllegalArgumentException("Stringan item in list 'newRoles' does not match pattern");
                }
            }
        }
        MembersSetPermissions2Arg _arg = new MembersSetPermissions2Arg(user, newRoles);
        return membersSetAdminPermissionsV2(_arg);
    }

    //
    // route 2/team/members/set_admin_permissions
    //

    /**
     * Updates a team member's permissions. Permission : Team member management.
     *
     * @param arg  Exactly one of team_member_id, email, or external_id must be
     *     provided to identify the user account.
     */
    MembersSetPermissionsResult membersSetAdminPermissions(MembersSetPermissionsArg arg) throws MembersSetPermissionsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/set_admin_permissions",
                                        arg,
                                        false,
                                        MembersSetPermissionsArg.Serializer.INSTANCE,
                                        MembersSetPermissionsResult.Serializer.INSTANCE,
                                        MembersSetPermissionsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersSetPermissionsErrorException("2/team/members/set_admin_permissions", ex.getRequestId(), ex.getUserMessage(), (MembersSetPermissionsError) ex.getErrorValue());
        }
    }

    /**
     * Updates a team member's permissions.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param user  Identity of user whose role will be set. Must not be {@code
     *     null}.
     * @param newRole  The new role of the member. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MembersSetPermissionsResult membersSetAdminPermissions(UserSelectorArg user, AdminTier newRole) throws MembersSetPermissionsErrorException, DbxException {
        MembersSetPermissionsArg _arg = new MembersSetPermissionsArg(user, newRole);
        return membersSetAdminPermissions(_arg);
    }

    //
    // route 2/team/members/set_profile_v2
    //

    /**
     * Updates a team member's profile. Permission : Team member management.
     *
     * @param arg  Exactly one of team_member_id, email, or external_id must be
     *     provided to identify the user account. At least one of new_email,
     *     new_external_id, new_given_name, and/or new_surname must be provided.
     *
     * @return Information about a team member, after the change, like at {@link
     *     DbxTeamTeamRequests#membersSetProfileV2(UserSelectorArg)}.
     */
    TeamMemberInfoV2Result membersSetProfileV2(MembersSetProfileArg arg) throws MembersSetProfileErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/set_profile_v2",
                                        arg,
                                        false,
                                        MembersSetProfileArg.Serializer.INSTANCE,
                                        TeamMemberInfoV2Result.Serializer.INSTANCE,
                                        MembersSetProfileError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersSetProfileErrorException("2/team/members/set_profile_v2", ex.getRequestId(), ex.getUserMessage(), (MembersSetProfileError) ex.getErrorValue());
        }
    }

    /**
     * Updates a team member's profile.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param user  Identity of user whose profile will be set. Must not be
     *     {@code null}.
     *
     * @return Information about a team member, after the change, like at {@link
     *     DbxTeamTeamRequests#membersSetProfileV2(UserSelectorArg)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfoV2Result membersSetProfileV2(UserSelectorArg user) throws MembersSetProfileErrorException, DbxException {
        MembersSetProfileArg _arg = new MembersSetProfileArg(user);
        return membersSetProfileV2(_arg);
    }

    /**
     * Updates a team member's profile. Permission : Team member management.
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
    public MembersSetProfileV2Builder membersSetProfileV2Builder(UserSelectorArg user) {
        MembersSetProfileArg.Builder argBuilder_ = MembersSetProfileArg.newBuilder(user);
        return new MembersSetProfileV2Builder(this, argBuilder_);
    }

    //
    // route 2/team/members/set_profile
    //

    /**
     * Updates a team member's profile. Permission : Team member management.
     *
     * @param arg  Exactly one of team_member_id, email, or external_id must be
     *     provided to identify the user account. At least one of new_email,
     *     new_external_id, new_given_name, and/or new_surname must be provided.
     *
     * @return Information about a team member.
     */
    TeamMemberInfo membersSetProfile(MembersSetProfileArg arg) throws MembersSetProfileErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/set_profile",
                                        arg,
                                        false,
                                        MembersSetProfileArg.Serializer.INSTANCE,
                                        TeamMemberInfo.Serializer.INSTANCE,
                                        MembersSetProfileError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersSetProfileErrorException("2/team/members/set_profile", ex.getRequestId(), ex.getUserMessage(), (MembersSetProfileError) ex.getErrorValue());
        }
    }

    /**
     * Updates a team member's profile.
     *
     * <p> Permission : Team member management. </p>
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
        MembersSetProfileArg _arg = new MembersSetProfileArg(user);
        return membersSetProfile(_arg);
    }

    /**
     * Updates a team member's profile. Permission : Team member management.
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
        MembersSetProfileArg.Builder argBuilder_ = MembersSetProfileArg.newBuilder(user);
        return new MembersSetProfileBuilder(this, argBuilder_);
    }

    //
    // route 2/team/members/set_profile_photo_v2
    //

    /**
     * Updates a team member's profile photo. Permission : Team member
     * management.
     *
     *
     * @return Information about a team member, after the change, like at {@link
     *     DbxTeamTeamRequests#membersSetProfileV2(UserSelectorArg)}.
     */
    TeamMemberInfoV2Result membersSetProfilePhotoV2(MembersSetProfilePhotoArg arg) throws MembersSetProfilePhotoErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/set_profile_photo_v2",
                                        arg,
                                        false,
                                        MembersSetProfilePhotoArg.Serializer.INSTANCE,
                                        TeamMemberInfoV2Result.Serializer.INSTANCE,
                                        MembersSetProfilePhotoError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersSetProfilePhotoErrorException("2/team/members/set_profile_photo_v2", ex.getRequestId(), ex.getUserMessage(), (MembersSetProfilePhotoError) ex.getErrorValue());
        }
    }

    /**
     * Updates a team member's profile photo.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param user  Identity of the user whose profile photo will be set. Must
     *     not be {@code null}.
     * @param photo  Image to set as the member's new profile photo. Must not be
     *     {@code null}.
     *
     * @return Information about a team member, after the change, like at {@link
     *     DbxTeamTeamRequests#membersSetProfileV2(UserSelectorArg)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfoV2Result membersSetProfilePhotoV2(UserSelectorArg user, PhotoSourceArg photo) throws MembersSetProfilePhotoErrorException, DbxException {
        MembersSetProfilePhotoArg _arg = new MembersSetProfilePhotoArg(user, photo);
        return membersSetProfilePhotoV2(_arg);
    }

    //
    // route 2/team/members/set_profile_photo
    //

    /**
     * Updates a team member's profile photo. Permission : Team member
     * management.
     *
     *
     * @return Information about a team member.
     */
    TeamMemberInfo membersSetProfilePhoto(MembersSetProfilePhotoArg arg) throws MembersSetProfilePhotoErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/members/set_profile_photo",
                                        arg,
                                        false,
                                        MembersSetProfilePhotoArg.Serializer.INSTANCE,
                                        TeamMemberInfo.Serializer.INSTANCE,
                                        MembersSetProfilePhotoError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersSetProfilePhotoErrorException("2/team/members/set_profile_photo", ex.getRequestId(), ex.getUserMessage(), (MembersSetProfilePhotoError) ex.getErrorValue());
        }
    }

    /**
     * Updates a team member's profile photo.
     *
     * <p> Permission : Team member management. </p>
     *
     * @param user  Identity of the user whose profile photo will be set. Must
     *     not be {@code null}.
     * @param photo  Image to set as the member's new profile photo. Must not be
     *     {@code null}.
     *
     * @return Information about a team member.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamMemberInfo membersSetProfilePhoto(UserSelectorArg user, PhotoSourceArg photo) throws MembersSetProfilePhotoErrorException, DbxException {
        MembersSetProfilePhotoArg _arg = new MembersSetProfilePhotoArg(user, photo);
        return membersSetProfilePhoto(_arg);
    }

    //
    // route 2/team/members/suspend
    //

    /**
     * Suspend a member from a team. Permission : Team member management Exactly
     * one of team_member_id, email, or external_id must be provided to identify
     * the user account.
     *
     */
    void membersSuspend(MembersDeactivateArg arg) throws MembersSuspendErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/team/members/suspend",
                                 arg,
                                 false,
                                 MembersDeactivateArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 MembersSuspendError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersSuspendErrorException("2/team/members/suspend", ex.getRequestId(), ex.getUserMessage(), (MembersSuspendError) ex.getErrorValue());
        }
    }

    /**
     * Suspend a member from a team.
     *
     * <p> Permission : Team member management </p>
     *
     * <p> Exactly one of team_member_id, email, or external_id must be provided
     * to identify the user account. </p>
     *
     * <p> The {@code wipeData} request parameter will default to {@code true}
     * (see {@link #membersSuspend(UserSelectorArg,boolean)}). </p>
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void membersSuspend(UserSelectorArg user) throws MembersSuspendErrorException, DbxException {
        MembersDeactivateArg _arg = new MembersDeactivateArg(user);
        membersSuspend(_arg);
    }

    /**
     * Suspend a member from a team.
     *
     * <p> Permission : Team member management </p>
     *
     * <p> Exactly one of team_member_id, email, or external_id must be provided
     * to identify the user account. </p>
     *
     * @param user  Identity of user to remove/suspend/have their files moved.
     *     Must not be {@code null}.
     * @param wipeData  If provided, controls if the user's data will be deleted
     *     on their linked devices.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void membersSuspend(UserSelectorArg user, boolean wipeData) throws MembersSuspendErrorException, DbxException {
        MembersDeactivateArg _arg = new MembersDeactivateArg(user, wipeData);
        membersSuspend(_arg);
    }

    //
    // route 2/team/members/unsuspend
    //

    /**
     * Unsuspend a member from a team. Permission : Team member management
     * Exactly one of team_member_id, email, or external_id must be provided to
     * identify the user account.
     *
     * @param arg  Exactly one of team_member_id, email, or external_id must be
     *     provided to identify the user account.
     */
    void membersUnsuspend(MembersUnsuspendArg arg) throws MembersUnsuspendErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/team/members/unsuspend",
                                 arg,
                                 false,
                                 MembersUnsuspendArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 MembersUnsuspendError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MembersUnsuspendErrorException("2/team/members/unsuspend", ex.getRequestId(), ex.getUserMessage(), (MembersUnsuspendError) ex.getErrorValue());
        }
    }

    /**
     * Unsuspend a member from a team.
     *
     * <p> Permission : Team member management </p>
     *
     * <p> Exactly one of team_member_id, email, or external_id must be provided
     * to identify the user account. </p>
     *
     * @param user  Identity of user to unsuspend. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void membersUnsuspend(UserSelectorArg user) throws MembersUnsuspendErrorException, DbxException {
        MembersUnsuspendArg _arg = new MembersUnsuspendArg(user);
        membersUnsuspend(_arg);
    }

    //
    // route 2/team/namespaces/list
    //

    /**
     * Returns a list of all team-accessible namespaces. This list includes team
     * folders, shared folders containing team members, team members' home
     * namespaces, and team members' app folders. Home namespaces and app
     * folders are always owned by this team or members of the team, but shared
     * folders may be owned by other users or other teams. Duplicates may occur
     * in the list.
     *
     *
     * @return Result for {@link DbxTeamTeamRequests#namespacesList(long)}.
     */
    TeamNamespacesListResult namespacesList(TeamNamespacesListArg arg) throws TeamNamespacesListErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/namespaces/list",
                                        arg,
                                        false,
                                        TeamNamespacesListArg.Serializer.INSTANCE,
                                        TeamNamespacesListResult.Serializer.INSTANCE,
                                        TeamNamespacesListError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TeamNamespacesListErrorException("2/team/namespaces/list", ex.getRequestId(), ex.getUserMessage(), (TeamNamespacesListError) ex.getErrorValue());
        }
    }

    /**
     * Returns a list of all team-accessible namespaces. This list includes team
     * folders, shared folders containing team members, team members' home
     * namespaces, and team members' app folders. Home namespaces and app
     * folders are always owned by this team or members of the team, but shared
     * folders may be owned by other users or other teams. Duplicates may occur
     * in the list.
     *
     * <p> The {@code limit} request parameter will default to {@code 1000L}
     * (see {@link #namespacesList(long)}). </p>
     *
     * @return Result for {@link DbxTeamTeamRequests#namespacesList(long)}.
     */
    public TeamNamespacesListResult namespacesList() throws TeamNamespacesListErrorException, DbxException {
        TeamNamespacesListArg _arg = new TeamNamespacesListArg();
        return namespacesList(_arg);
    }

    /**
     * Returns a list of all team-accessible namespaces. This list includes team
     * folders, shared folders containing team members, team members' home
     * namespaces, and team members' app folders. Home namespaces and app
     * folders are always owned by this team or members of the team, but shared
     * folders may be owned by other users or other teams. Duplicates may occur
     * in the list.
     *
     * @param limit  Specifying a value here has no effect. Must be greater than
     *     or equal to 1 and be less than or equal to 1000.
     *
     * @return Result for {@link DbxTeamTeamRequests#namespacesList(long)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamNamespacesListResult namespacesList(long limit) throws TeamNamespacesListErrorException, DbxException {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        TeamNamespacesListArg _arg = new TeamNamespacesListArg(limit);
        return namespacesList(_arg);
    }

    //
    // route 2/team/namespaces/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#namespacesList(long)}, use this to paginate through
     * all team-accessible namespaces. Duplicates may occur in the list.
     *
     *
     * @return Result for {@link DbxTeamTeamRequests#namespacesList(long)}.
     */
    TeamNamespacesListResult namespacesListContinue(TeamNamespacesListContinueArg arg) throws TeamNamespacesListContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/namespaces/list/continue",
                                        arg,
                                        false,
                                        TeamNamespacesListContinueArg.Serializer.INSTANCE,
                                        TeamNamespacesListResult.Serializer.INSTANCE,
                                        TeamNamespacesListContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TeamNamespacesListContinueErrorException("2/team/namespaces/list/continue", ex.getRequestId(), ex.getUserMessage(), (TeamNamespacesListContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#namespacesList(long)}, use this to paginate through
     * all team-accessible namespaces. Duplicates may occur in the list.
     *
     * @param cursor  Indicates from what point to get the next set of
     *     team-accessible namespaces. Must not be {@code null}.
     *
     * @return Result for {@link DbxTeamTeamRequests#namespacesList(long)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamNamespacesListResult namespacesListContinue(String cursor) throws TeamNamespacesListContinueErrorException, DbxException {
        TeamNamespacesListContinueArg _arg = new TeamNamespacesListContinueArg(cursor);
        return namespacesListContinue(_arg);
    }

    //
    // route 2/team/properties/template/add
    //

    /**
     * Permission : Team member file access.
     *
     */
    AddTemplateResult propertiesTemplateAdd(AddTemplateArg arg) throws ModifyTemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/properties/template/add",
                                        arg,
                                        false,
                                        AddTemplateArg.Serializer.INSTANCE,
                                        AddTemplateResult.Serializer.INSTANCE,
                                        ModifyTemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ModifyTemplateErrorException("2/team/properties/template/add", ex.getRequestId(), ex.getUserMessage(), (ModifyTemplateError) ex.getErrorValue());
        }
    }

    /**
     * Permission : Team member file access.
     *
     * @param name  Display name for the template. Template names can be up to
     *     256 bytes. Must not be {@code null}.
     * @param description  Description for the template. Template descriptions
     *     can be up to 1024 bytes. Must not be {@code null}.
     * @param fields  Definitions of the property fields associated with this
     *     template. There can be up to 32 properties in a single template. Must
     *     not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public AddTemplateResult propertiesTemplateAdd(String name, String description, List<PropertyFieldTemplate> fields) throws ModifyTemplateErrorException, DbxException {
        AddTemplateArg _arg = new AddTemplateArg(name, description, fields);
        return propertiesTemplateAdd(_arg);
    }

    //
    // route 2/team/properties/template/get
    //

    /**
     * Permission : Team member file access. The scope for the route is
     * files.team_metadata.write.
     *
     */
    GetTemplateResult propertiesTemplateGet(GetTemplateArg arg) throws TemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/properties/template/get",
                                        arg,
                                        false,
                                        GetTemplateArg.Serializer.INSTANCE,
                                        GetTemplateResult.Serializer.INSTANCE,
                                        TemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TemplateErrorException("2/team/properties/template/get", ex.getRequestId(), ex.getUserMessage(), (TemplateError) ex.getErrorValue());
        }
    }

    /**
     * Permission : Team member file access. The scope for the route is
     * files.team_metadata.write.
     *
     * @param templateId  An identifier for template added by route  See {@link
     *     com.dropbox.core.v2.fileproperties.DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     com.dropbox.core.v2.fileproperties.DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must have length of at least 1, match pattern "{@code (/|ptid:).*}",
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public GetTemplateResult propertiesTemplateGet(String templateId) throws TemplateErrorException, DbxException {
        GetTemplateArg _arg = new GetTemplateArg(templateId);
        return propertiesTemplateGet(_arg);
    }

    //
    // route 2/team/properties/template/list
    //

    /**
     * Permission : Team member file access. The scope for the route is
     * files.team_metadata.write.
     *
     * @deprecated
     */
    @Deprecated
    public ListTemplateResult propertiesTemplateList() throws TemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/properties/template/list",
                                        null,
                                        false,
                                        com.dropbox.core.stone.StoneSerializers.void_(),
                                        ListTemplateResult.Serializer.INSTANCE,
                                        TemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TemplateErrorException("2/team/properties/template/list", ex.getRequestId(), ex.getUserMessage(), (TemplateError) ex.getErrorValue());
        }
    }

    //
    // route 2/team/properties/template/update
    //

    /**
     * Permission : Team member file access.
     *
     */
    UpdateTemplateResult propertiesTemplateUpdate(UpdateTemplateArg arg) throws ModifyTemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/properties/template/update",
                                        arg,
                                        false,
                                        UpdateTemplateArg.Serializer.INSTANCE,
                                        UpdateTemplateResult.Serializer.INSTANCE,
                                        ModifyTemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ModifyTemplateErrorException("2/team/properties/template/update", ex.getRequestId(), ex.getUserMessage(), (ModifyTemplateError) ex.getErrorValue());
        }
    }

    /**
     * Permission : Team member file access.
     *
     * @param templateId  An identifier for template added by  See {@link
     *     com.dropbox.core.v2.fileproperties.DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     com.dropbox.core.v2.fileproperties.DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must have length of at least 1, match pattern "{@code (/|ptid:).*}",
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public UpdateTemplateResult propertiesTemplateUpdate(String templateId) throws ModifyTemplateErrorException, DbxException {
        UpdateTemplateArg _arg = new UpdateTemplateArg(templateId);
        return propertiesTemplateUpdate(_arg);
    }

    /**
     * Permission : Team member file access.
     *
     * @param templateId  An identifier for template added by  See {@link
     *     com.dropbox.core.v2.fileproperties.DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@link
     *     com.dropbox.core.v2.fileproperties.DbxTeamFilePropertiesRequests#templatesAddForTeam(String,String,List)}.
     *     Must have length of at least 1, match pattern "{@code (/|ptid:).*}",
     *     and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public PropertiesTemplateUpdateBuilder propertiesTemplateUpdateBuilder(String templateId) {
        UpdateTemplateArg.Builder argBuilder_ = UpdateTemplateArg.newBuilder(templateId);
        return new PropertiesTemplateUpdateBuilder(this, argBuilder_);
    }

    //
    // route 2/team/reports/get_activity
    //

    /**
     * Retrieves reporting data about a team's user activity. Deprecated: Will
     * be removed on July 1st 2021.
     *
     * @param arg  Input arguments that can be provided for most reports.
     *
     * @return Activity Report Result. Each of the items in the storage report
     *     is an array of values, one value per day. If there is no data for a
     *     day, then the value will be None.
     */
    GetActivityReport reportsGetActivity(DateRange arg) throws DateRangeErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/reports/get_activity",
                                        arg,
                                        false,
                                        DateRange.Serializer.INSTANCE,
                                        GetActivityReport.Serializer.INSTANCE,
                                        DateRangeError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DateRangeErrorException("2/team/reports/get_activity", ex.getRequestId(), ex.getUserMessage(), (DateRangeError) ex.getErrorValue());
        }
    }

    /**
     * Retrieves reporting data about a team's user activity. Deprecated: Will
     * be removed on July 1st 2021.
     *
     * @return Activity Report Result. Each of the items in the storage report
     *     is an array of values, one value per day. If there is no data for a
     *     day, then the value will be None.
     *
     * @deprecated
     */
    @Deprecated
    public GetActivityReport reportsGetActivity() throws DateRangeErrorException, DbxException {
        DateRange _arg = new DateRange();
        return reportsGetActivity(_arg);
    }

    /**
     * Retrieves reporting data about a team's user activity. Deprecated: Will
     * be removed on July 1st 2021.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @deprecated
     */
    @Deprecated
    public ReportsGetActivityBuilder reportsGetActivityBuilder() {
        DateRange.Builder argBuilder_ = DateRange.newBuilder();
        return new ReportsGetActivityBuilder(this, argBuilder_);
    }

    //
    // route 2/team/reports/get_devices
    //

    /**
     * Retrieves reporting data about a team's linked devices. Deprecated: Will
     * be removed on July 1st 2021.
     *
     * @param arg  Input arguments that can be provided for most reports.
     *
     * @return Devices Report Result. Contains subsections for different time
     *     ranges of activity. Each of the items in each subsection of the
     *     storage report is an array of values, one value per day. If there is
     *     no data for a day, then the value will be None.
     */
    GetDevicesReport reportsGetDevices(DateRange arg) throws DateRangeErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/reports/get_devices",
                                        arg,
                                        false,
                                        DateRange.Serializer.INSTANCE,
                                        GetDevicesReport.Serializer.INSTANCE,
                                        DateRangeError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DateRangeErrorException("2/team/reports/get_devices", ex.getRequestId(), ex.getUserMessage(), (DateRangeError) ex.getErrorValue());
        }
    }

    /**
     * Retrieves reporting data about a team's linked devices. Deprecated: Will
     * be removed on July 1st 2021.
     *
     * @return Devices Report Result. Contains subsections for different time
     *     ranges of activity. Each of the items in each subsection of the
     *     storage report is an array of values, one value per day. If there is
     *     no data for a day, then the value will be None.
     *
     * @deprecated
     */
    @Deprecated
    public GetDevicesReport reportsGetDevices() throws DateRangeErrorException, DbxException {
        DateRange _arg = new DateRange();
        return reportsGetDevices(_arg);
    }

    /**
     * Retrieves reporting data about a team's linked devices. Deprecated: Will
     * be removed on July 1st 2021.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @deprecated
     */
    @Deprecated
    public ReportsGetDevicesBuilder reportsGetDevicesBuilder() {
        DateRange.Builder argBuilder_ = DateRange.newBuilder();
        return new ReportsGetDevicesBuilder(this, argBuilder_);
    }

    //
    // route 2/team/reports/get_membership
    //

    /**
     * Retrieves reporting data about a team's membership. Deprecated: Will be
     * removed on July 1st 2021.
     *
     * @param arg  Input arguments that can be provided for most reports.
     *
     * @return Membership Report Result. Each of the items in the storage report
     *     is an array of values, one value per day. If there is no data for a
     *     day, then the value will be None.
     */
    GetMembershipReport reportsGetMembership(DateRange arg) throws DateRangeErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/reports/get_membership",
                                        arg,
                                        false,
                                        DateRange.Serializer.INSTANCE,
                                        GetMembershipReport.Serializer.INSTANCE,
                                        DateRangeError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DateRangeErrorException("2/team/reports/get_membership", ex.getRequestId(), ex.getUserMessage(), (DateRangeError) ex.getErrorValue());
        }
    }

    /**
     * Retrieves reporting data about a team's membership. Deprecated: Will be
     * removed on July 1st 2021.
     *
     * @return Membership Report Result. Each of the items in the storage report
     *     is an array of values, one value per day. If there is no data for a
     *     day, then the value will be None.
     *
     * @deprecated
     */
    @Deprecated
    public GetMembershipReport reportsGetMembership() throws DateRangeErrorException, DbxException {
        DateRange _arg = new DateRange();
        return reportsGetMembership(_arg);
    }

    /**
     * Retrieves reporting data about a team's membership. Deprecated: Will be
     * removed on July 1st 2021.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @deprecated
     */
    @Deprecated
    public ReportsGetMembershipBuilder reportsGetMembershipBuilder() {
        DateRange.Builder argBuilder_ = DateRange.newBuilder();
        return new ReportsGetMembershipBuilder(this, argBuilder_);
    }

    //
    // route 2/team/reports/get_storage
    //

    /**
     * Retrieves reporting data about a team's storage usage. Deprecated: Will
     * be removed on July 1st 2021.
     *
     * @param arg  Input arguments that can be provided for most reports.
     *
     * @return Storage Report Result. Each of the items in the storage report is
     *     an array of values, one value per day. If there is no data for a day,
     *     then the value will be None.
     */
    GetStorageReport reportsGetStorage(DateRange arg) throws DateRangeErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/reports/get_storage",
                                        arg,
                                        false,
                                        DateRange.Serializer.INSTANCE,
                                        GetStorageReport.Serializer.INSTANCE,
                                        DateRangeError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DateRangeErrorException("2/team/reports/get_storage", ex.getRequestId(), ex.getUserMessage(), (DateRangeError) ex.getErrorValue());
        }
    }

    /**
     * Retrieves reporting data about a team's storage usage. Deprecated: Will
     * be removed on July 1st 2021.
     *
     * @return Storage Report Result. Each of the items in the storage report is
     *     an array of values, one value per day. If there is no data for a day,
     *     then the value will be None.
     *
     * @deprecated
     */
    @Deprecated
    public GetStorageReport reportsGetStorage() throws DateRangeErrorException, DbxException {
        DateRange _arg = new DateRange();
        return reportsGetStorage(_arg);
    }

    /**
     * Retrieves reporting data about a team's storage usage. Deprecated: Will
     * be removed on July 1st 2021.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @deprecated
     */
    @Deprecated
    public ReportsGetStorageBuilder reportsGetStorageBuilder() {
        DateRange.Builder argBuilder_ = DateRange.newBuilder();
        return new ReportsGetStorageBuilder(this, argBuilder_);
    }

    //
    // route 2/team/sharing_allowlist/add
    //

    /**
     * Endpoint adds Approve List entries. Changes are effective immediately.
     * Changes are committed in transaction. In case of single validation error
     * - all entries are rejected. Valid domains (RFC-1034/5) and emails
     * (RFC-5322/822) are accepted. Added entries cannot overflow limit of 10000
     * entries per team. Maximum 100 entries per call is allowed.
     *
     * @param arg  Structure representing Approve List entries. Domain and
     *     emails are supported. At least one entry of any supported type is
     *     required.
     *
     * @return This struct is empty. The comment here is intentionally emitted
     *     to avoid indentation issues with Stone.
     */
    SharingAllowlistAddResponse sharingAllowlistAdd(SharingAllowlistAddArgs arg) throws SharingAllowlistAddErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/sharing_allowlist/add",
                                        arg,
                                        false,
                                        SharingAllowlistAddArgs.Serializer.INSTANCE,
                                        SharingAllowlistAddResponse.Serializer.INSTANCE,
                                        SharingAllowlistAddError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharingAllowlistAddErrorException("2/team/sharing_allowlist/add", ex.getRequestId(), ex.getUserMessage(), (SharingAllowlistAddError) ex.getErrorValue());
        }
    }

    /**
     * Endpoint adds Approve List entries. Changes are effective immediately.
     * Changes are committed in transaction. In case of single validation error
     * - all entries are rejected. Valid domains (RFC-1034/5) and emails
     * (RFC-5322/822) are accepted. Added entries cannot overflow limit of 10000
     * entries per team. Maximum 100 entries per call is allowed.
     *
     * @return This struct is empty. The comment here is intentionally emitted
     *     to avoid indentation issues with Stone.
     */
    public SharingAllowlistAddResponse sharingAllowlistAdd() throws SharingAllowlistAddErrorException, DbxException {
        SharingAllowlistAddArgs _arg = new SharingAllowlistAddArgs();
        return sharingAllowlistAdd(_arg);
    }

    /**
     * Endpoint adds Approve List entries. Changes are effective immediately.
     * Changes are committed in transaction. In case of single validation error
     * - all entries are rejected. Valid domains (RFC-1034/5) and emails
     * (RFC-5322/822) are accepted. Added entries cannot overflow limit of 10000
     * entries per team. Maximum 100 entries per call is allowed.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public SharingAllowlistAddBuilder sharingAllowlistAddBuilder() {
        SharingAllowlistAddArgs.Builder argBuilder_ = SharingAllowlistAddArgs.newBuilder();
        return new SharingAllowlistAddBuilder(this, argBuilder_);
    }

    //
    // route 2/team/sharing_allowlist/list
    //

    /**
     * Lists Approve List entries for given team, from newest to oldest,
     * returning up to `limit` entries at a time. If there are more than `limit`
     * entries associated with the current team, more can be fetched by passing
     * the returned `cursor` to {@link
     * DbxTeamTeamRequests#sharingAllowlistListContinue(String)}.
     *
     */
    SharingAllowlistListResponse sharingAllowlistList(SharingAllowlistListArg arg) throws SharingAllowlistListErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/sharing_allowlist/list",
                                        arg,
                                        false,
                                        SharingAllowlistListArg.Serializer.INSTANCE,
                                        SharingAllowlistListResponse.Serializer.INSTANCE,
                                        SharingAllowlistListError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharingAllowlistListErrorException("2/team/sharing_allowlist/list", ex.getRequestId(), ex.getUserMessage(), (SharingAllowlistListError) ex.getErrorValue());
        }
    }

    /**
     * Lists Approve List entries for given team, from newest to oldest,
     * returning up to `limit` entries at a time. If there are more than `limit`
     * entries associated with the current team, more can be fetched by passing
     * the returned `cursor` to {@link
     * DbxTeamTeamRequests#sharingAllowlistListContinue(String)}.
     *
     * <p> The {@code limit} request parameter will default to {@code 1000L}
     * (see {@link #sharingAllowlistList(long)}). </p>
     */
    public SharingAllowlistListResponse sharingAllowlistList() throws SharingAllowlistListErrorException, DbxException {
        SharingAllowlistListArg _arg = new SharingAllowlistListArg();
        return sharingAllowlistList(_arg);
    }

    /**
     * Lists Approve List entries for given team, from newest to oldest,
     * returning up to `limit` entries at a time. If there are more than `limit`
     * entries associated with the current team, more can be fetched by passing
     * the returned `cursor` to {@link
     * DbxTeamTeamRequests#sharingAllowlistListContinue(String)}.
     *
     * @param limit  The number of entries to fetch at one time. Must be greater
     *     than or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharingAllowlistListResponse sharingAllowlistList(long limit) throws SharingAllowlistListErrorException, DbxException {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        SharingAllowlistListArg _arg = new SharingAllowlistListArg(limit);
        return sharingAllowlistList(_arg);
    }

    //
    // route 2/team/sharing_allowlist/list/continue
    //

    /**
     * Lists entries associated with given team, starting from a the cursor. See
     * {@link DbxTeamTeamRequests#sharingAllowlistList(long)}.
     *
     */
    SharingAllowlistListResponse sharingAllowlistListContinue(SharingAllowlistListContinueArg arg) throws SharingAllowlistListContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/sharing_allowlist/list/continue",
                                        arg,
                                        false,
                                        SharingAllowlistListContinueArg.Serializer.INSTANCE,
                                        SharingAllowlistListResponse.Serializer.INSTANCE,
                                        SharingAllowlistListContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharingAllowlistListContinueErrorException("2/team/sharing_allowlist/list/continue", ex.getRequestId(), ex.getUserMessage(), (SharingAllowlistListContinueError) ex.getErrorValue());
        }
    }

    /**
     * Lists entries associated with given team, starting from a the cursor. See
     * {@link DbxTeamTeamRequests#sharingAllowlistList(long)}.
     *
     * @param cursor  The cursor returned from a previous call to {@link
     *     DbxTeamTeamRequests#sharingAllowlistList(long)} or {@link
     *     DbxTeamTeamRequests#sharingAllowlistListContinue(String)}. Must not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharingAllowlistListResponse sharingAllowlistListContinue(String cursor) throws SharingAllowlistListContinueErrorException, DbxException {
        SharingAllowlistListContinueArg _arg = new SharingAllowlistListContinueArg(cursor);
        return sharingAllowlistListContinue(_arg);
    }

    //
    // route 2/team/sharing_allowlist/remove
    //

    /**
     * Endpoint removes Approve List entries. Changes are effective immediately.
     * Changes are committed in transaction. In case of single validation error
     * - all entries are rejected. Valid domains (RFC-1034/5) and emails
     * (RFC-5322/822) are accepted. Entries being removed have to be present on
     * the list. Maximum 1000 entries per call is allowed.
     *
     *
     * @return This struct is empty. The comment here is intentionally emitted
     *     to avoid indentation issues with Stone.
     */
    SharingAllowlistRemoveResponse sharingAllowlistRemove(SharingAllowlistRemoveArgs arg) throws SharingAllowlistRemoveErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/sharing_allowlist/remove",
                                        arg,
                                        false,
                                        SharingAllowlistRemoveArgs.Serializer.INSTANCE,
                                        SharingAllowlistRemoveResponse.Serializer.INSTANCE,
                                        SharingAllowlistRemoveError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharingAllowlistRemoveErrorException("2/team/sharing_allowlist/remove", ex.getRequestId(), ex.getUserMessage(), (SharingAllowlistRemoveError) ex.getErrorValue());
        }
    }

    /**
     * Endpoint removes Approve List entries. Changes are effective immediately.
     * Changes are committed in transaction. In case of single validation error
     * - all entries are rejected. Valid domains (RFC-1034/5) and emails
     * (RFC-5322/822) are accepted. Entries being removed have to be present on
     * the list. Maximum 1000 entries per call is allowed.
     *
     * @return This struct is empty. The comment here is intentionally emitted
     *     to avoid indentation issues with Stone.
     */
    public SharingAllowlistRemoveResponse sharingAllowlistRemove() throws SharingAllowlistRemoveErrorException, DbxException {
        SharingAllowlistRemoveArgs _arg = new SharingAllowlistRemoveArgs();
        return sharingAllowlistRemove(_arg);
    }

    /**
     * Endpoint removes Approve List entries. Changes are effective immediately.
     * Changes are committed in transaction. In case of single validation error
     * - all entries are rejected. Valid domains (RFC-1034/5) and emails
     * (RFC-5322/822) are accepted. Entries being removed have to be present on
     * the list. Maximum 1000 entries per call is allowed.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public SharingAllowlistRemoveBuilder sharingAllowlistRemoveBuilder() {
        SharingAllowlistRemoveArgs.Builder argBuilder_ = SharingAllowlistRemoveArgs.newBuilder();
        return new SharingAllowlistRemoveBuilder(this, argBuilder_);
    }

    //
    // route 2/team/team_folder/activate
    //

    /**
     * Sets an archived team folder's status to active. Permission : Team member
     * file access.
     *
     *
     * @return Properties of a team folder.
     */
    TeamFolderMetadata teamFolderActivate(TeamFolderIdArg arg) throws TeamFolderActivateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/team_folder/activate",
                                        arg,
                                        false,
                                        TeamFolderIdArg.Serializer.INSTANCE,
                                        TeamFolderMetadata.Serializer.INSTANCE,
                                        TeamFolderActivateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TeamFolderActivateErrorException("2/team/team_folder/activate", ex.getRequestId(), ex.getUserMessage(), (TeamFolderActivateError) ex.getErrorValue());
        }
    }

    /**
     * Sets an archived team folder's status to active.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return Properties of a team folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderMetadata teamFolderActivate(String teamFolderId) throws TeamFolderActivateErrorException, DbxException {
        TeamFolderIdArg _arg = new TeamFolderIdArg(teamFolderId);
        return teamFolderActivate(_arg);
    }

    //
    // route 2/team/team_folder/archive
    //

    /**
     * Sets an active team folder's status to archived and removes all folder
     * and file members. This endpoint cannot be used for teams that have a
     * shared team space. Permission : Team member file access.
     *
     */
    TeamFolderArchiveLaunch teamFolderArchive(TeamFolderArchiveArg arg) throws TeamFolderArchiveErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/team_folder/archive",
                                        arg,
                                        false,
                                        TeamFolderArchiveArg.Serializer.INSTANCE,
                                        TeamFolderArchiveLaunch.Serializer.INSTANCE,
                                        TeamFolderArchiveError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TeamFolderArchiveErrorException("2/team/team_folder/archive", ex.getRequestId(), ex.getUserMessage(), (TeamFolderArchiveError) ex.getErrorValue());
        }
    }

    /**
     * Sets an active team folder's status to archived and removes all folder
     * and file members. This endpoint cannot be used for teams that have a
     * shared team space.
     *
     * <p> Permission : Team member file access. </p>
     *
     * <p> The {@code forceAsyncOff} request parameter will default to {@code
     * false} (see {@link #teamFolderArchive(String,boolean)}). </p>
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderArchiveLaunch teamFolderArchive(String teamFolderId) throws TeamFolderArchiveErrorException, DbxException {
        TeamFolderArchiveArg _arg = new TeamFolderArchiveArg(teamFolderId);
        return teamFolderArchive(_arg);
    }

    /**
     * Sets an active team folder's status to archived and removes all folder
     * and file members. This endpoint cannot be used for teams that have a
     * shared team space.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param forceAsyncOff  Whether to force the archive to happen
     *     synchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderArchiveLaunch teamFolderArchive(String teamFolderId, boolean forceAsyncOff) throws TeamFolderArchiveErrorException, DbxException {
        TeamFolderArchiveArg _arg = new TeamFolderArchiveArg(teamFolderId, forceAsyncOff);
        return teamFolderArchive(_arg);
    }

    //
    // route 2/team/team_folder/archive/check
    //

    /**
     * Returns the status of an asynchronous job for archiving a team folder.
     * Permission : Team member file access.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    TeamFolderArchiveJobStatus teamFolderArchiveCheck(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/team_folder/archive/check",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        TeamFolderArchiveJobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/team/team_folder/archive/check", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for archiving a team folder.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderArchiveJobStatus teamFolderArchiveCheck(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return teamFolderArchiveCheck(_arg);
    }

    //
    // route 2/team/team_folder/create
    //

    /**
     * Creates a new, active, team folder with no members. This endpoint can
     * only be used for teams that do not already have a shared team space.
     * Permission : Team member file access.
     *
     *
     * @return Properties of a team folder.
     */
    TeamFolderMetadata teamFolderCreate(TeamFolderCreateArg arg) throws TeamFolderCreateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/team_folder/create",
                                        arg,
                                        false,
                                        TeamFolderCreateArg.Serializer.INSTANCE,
                                        TeamFolderMetadata.Serializer.INSTANCE,
                                        TeamFolderCreateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TeamFolderCreateErrorException("2/team/team_folder/create", ex.getRequestId(), ex.getUserMessage(), (TeamFolderCreateError) ex.getErrorValue());
        }
    }

    /**
     * Creates a new, active, team folder with no members. This endpoint can
     * only be used for teams that do not already have a shared team space.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param name  Name for the new team folder. Must not be {@code null}.
     *
     * @return Properties of a team folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderMetadata teamFolderCreate(String name) throws TeamFolderCreateErrorException, DbxException {
        TeamFolderCreateArg _arg = new TeamFolderCreateArg(name);
        return teamFolderCreate(_arg);
    }

    /**
     * Creates a new, active, team folder with no members. This endpoint can
     * only be used for teams that do not already have a shared team space.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param name  Name for the new team folder. Must not be {@code null}.
     * @param syncSetting  The sync setting to apply to this team folder. Only
     *     permitted if the team has team selective sync enabled.
     *
     * @return Properties of a team folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderMetadata teamFolderCreate(String name, SyncSettingArg syncSetting) throws TeamFolderCreateErrorException, DbxException {
        TeamFolderCreateArg _arg = new TeamFolderCreateArg(name, syncSetting);
        return teamFolderCreate(_arg);
    }

    //
    // route 2/team/team_folder/get_info
    //

    /**
     * Retrieves metadata for team folders. Permission : Team member file
     * access.
     *
     */
    List<TeamFolderGetInfoItem> teamFolderGetInfo(TeamFolderIdListArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/team_folder/get_info",
                                        arg,
                                        false,
                                        TeamFolderIdListArg.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(TeamFolderGetInfoItem.Serializer.INSTANCE),
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"team_folder/get_info\":" + ex.getErrorValue());
        }
    }

    /**
     * Retrieves metadata for team folders.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param teamFolderIds  The list of team folder IDs. Must contain at least
     *     1 items, not contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<TeamFolderGetInfoItem> teamFolderGetInfo(List<String> teamFolderIds) throws DbxApiException, DbxException {
        TeamFolderIdListArg _arg = new TeamFolderIdListArg(teamFolderIds);
        return teamFolderGetInfo(_arg);
    }

    //
    // route 2/team/team_folder/list
    //

    /**
     * Lists all team folders. Permission : Team member file access.
     *
     *
     * @return Result for {@link DbxTeamTeamRequests#teamFolderList(long)} and
     *     {@link DbxTeamTeamRequests#teamFolderListContinue(String)}.
     */
    TeamFolderListResult teamFolderList(TeamFolderListArg arg) throws TeamFolderListErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/team_folder/list",
                                        arg,
                                        false,
                                        TeamFolderListArg.Serializer.INSTANCE,
                                        TeamFolderListResult.Serializer.INSTANCE,
                                        TeamFolderListError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TeamFolderListErrorException("2/team/team_folder/list", ex.getRequestId(), ex.getUserMessage(), (TeamFolderListError) ex.getErrorValue());
        }
    }

    /**
     * Lists all team folders.
     *
     * <p> Permission : Team member file access. </p>
     *
     * <p> The {@code limit} request parameter will default to {@code 1000L}
     * (see {@link #teamFolderList(long)}). </p>
     *
     * @return Result for {@link DbxTeamTeamRequests#teamFolderList(long)} and
     *     {@link DbxTeamTeamRequests#teamFolderListContinue(String)}.
     */
    public TeamFolderListResult teamFolderList() throws TeamFolderListErrorException, DbxException {
        TeamFolderListArg _arg = new TeamFolderListArg();
        return teamFolderList(_arg);
    }

    /**
     * Lists all team folders.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param limit  The maximum number of results to return per request. Must
     *     be greater than or equal to 1 and be less than or equal to 1000.
     *
     * @return Result for {@link DbxTeamTeamRequests#teamFolderList(long)} and
     *     {@link DbxTeamTeamRequests#teamFolderListContinue(String)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderListResult teamFolderList(long limit) throws TeamFolderListErrorException, DbxException {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 1000L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000L");
        }
        TeamFolderListArg _arg = new TeamFolderListArg(limit);
        return teamFolderList(_arg);
    }

    //
    // route 2/team/team_folder/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#teamFolderList(long)}, use this to paginate through
     * all team folders. Permission : Team member file access.
     *
     *
     * @return Result for {@link DbxTeamTeamRequests#teamFolderList(long)} and
     *     {@link DbxTeamTeamRequests#teamFolderListContinue(String)}.
     */
    TeamFolderListResult teamFolderListContinue(TeamFolderListContinueArg arg) throws TeamFolderListContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/team_folder/list/continue",
                                        arg,
                                        false,
                                        TeamFolderListContinueArg.Serializer.INSTANCE,
                                        TeamFolderListResult.Serializer.INSTANCE,
                                        TeamFolderListContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TeamFolderListContinueErrorException("2/team/team_folder/list/continue", ex.getRequestId(), ex.getUserMessage(), (TeamFolderListContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxTeamTeamRequests#teamFolderList(long)}, use this to paginate through
     * all team folders.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param cursor  Indicates from what point to get the next set of team
     *     folders. Must not be {@code null}.
     *
     * @return Result for {@link DbxTeamTeamRequests#teamFolderList(long)} and
     *     {@link DbxTeamTeamRequests#teamFolderListContinue(String)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderListResult teamFolderListContinue(String cursor) throws TeamFolderListContinueErrorException, DbxException {
        TeamFolderListContinueArg _arg = new TeamFolderListContinueArg(cursor);
        return teamFolderListContinue(_arg);
    }

    //
    // route 2/team/team_folder/permanently_delete
    //

    /**
     * Permanently deletes an archived team folder. This endpoint cannot be used
     * for teams that have a shared team space. Permission : Team member file
     * access.
     *
     */
    void teamFolderPermanentlyDelete(TeamFolderIdArg arg) throws TeamFolderPermanentlyDeleteErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/team/team_folder/permanently_delete",
                                 arg,
                                 false,
                                 TeamFolderIdArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 TeamFolderPermanentlyDeleteError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TeamFolderPermanentlyDeleteErrorException("2/team/team_folder/permanently_delete", ex.getRequestId(), ex.getUserMessage(), (TeamFolderPermanentlyDeleteError) ex.getErrorValue());
        }
    }

    /**
     * Permanently deletes an archived team folder. This endpoint cannot be used
     * for teams that have a shared team space.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void teamFolderPermanentlyDelete(String teamFolderId) throws TeamFolderPermanentlyDeleteErrorException, DbxException {
        TeamFolderIdArg _arg = new TeamFolderIdArg(teamFolderId);
        teamFolderPermanentlyDelete(_arg);
    }

    //
    // route 2/team/team_folder/rename
    //

    /**
     * Changes an active team folder's name. Permission : Team member file
     * access.
     *
     *
     * @return Properties of a team folder.
     */
    TeamFolderMetadata teamFolderRename(TeamFolderRenameArg arg) throws TeamFolderRenameErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/team_folder/rename",
                                        arg,
                                        false,
                                        TeamFolderRenameArg.Serializer.INSTANCE,
                                        TeamFolderMetadata.Serializer.INSTANCE,
                                        TeamFolderRenameError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TeamFolderRenameErrorException("2/team/team_folder/rename", ex.getRequestId(), ex.getUserMessage(), (TeamFolderRenameError) ex.getErrorValue());
        }
    }

    /**
     * Changes an active team folder's name.
     *
     * <p> Permission : Team member file access. </p>
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param name  New team folder name. Must not be {@code null}.
     *
     * @return Properties of a team folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderMetadata teamFolderRename(String teamFolderId, String name) throws TeamFolderRenameErrorException, DbxException {
        TeamFolderRenameArg _arg = new TeamFolderRenameArg(teamFolderId, name);
        return teamFolderRename(_arg);
    }

    //
    // route 2/team/team_folder/update_sync_settings
    //

    /**
     * Updates the sync settings on a team folder or its contents.  Use of this
     * endpoint requires that the team has team selective sync enabled.
     *
     *
     * @return Properties of a team folder.
     */
    TeamFolderMetadata teamFolderUpdateSyncSettings(TeamFolderUpdateSyncSettingsArg arg) throws TeamFolderUpdateSyncSettingsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/team_folder/update_sync_settings",
                                        arg,
                                        false,
                                        TeamFolderUpdateSyncSettingsArg.Serializer.INSTANCE,
                                        TeamFolderMetadata.Serializer.INSTANCE,
                                        TeamFolderUpdateSyncSettingsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TeamFolderUpdateSyncSettingsErrorException("2/team/team_folder/update_sync_settings", ex.getRequestId(), ex.getUserMessage(), (TeamFolderUpdateSyncSettingsError) ex.getErrorValue());
        }
    }

    /**
     * Updates the sync settings on a team folder or its contents.  Use of this
     * endpoint requires that the team has team selective sync enabled.
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return Properties of a team folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderMetadata teamFolderUpdateSyncSettings(String teamFolderId) throws TeamFolderUpdateSyncSettingsErrorException, DbxException {
        TeamFolderUpdateSyncSettingsArg _arg = new TeamFolderUpdateSyncSettingsArg(teamFolderId);
        return teamFolderUpdateSyncSettings(_arg);
    }

    /**
     * Updates the sync settings on a team folder or its contents.  Use of this
     * endpoint requires that the team has team selective sync enabled.
     *
     * @param teamFolderId  The ID of the team folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public TeamFolderUpdateSyncSettingsBuilder teamFolderUpdateSyncSettingsBuilder(String teamFolderId) {
        TeamFolderUpdateSyncSettingsArg.Builder argBuilder_ = TeamFolderUpdateSyncSettingsArg.newBuilder(teamFolderId);
        return new TeamFolderUpdateSyncSettingsBuilder(this, argBuilder_);
    }

    //
    // route 2/team/token/get_authenticated_admin
    //

    /**
     * Returns the member profile of the admin who generated the team access
     * token used to make the call.
     *
     * @return Results for {@link
     *     DbxTeamTeamRequests#tokenGetAuthenticatedAdmin}.
     */
    public TokenGetAuthenticatedAdminResult tokenGetAuthenticatedAdmin() throws TokenGetAuthenticatedAdminErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/team/token/get_authenticated_admin",
                                        null,
                                        false,
                                        com.dropbox.core.stone.StoneSerializers.void_(),
                                        TokenGetAuthenticatedAdminResult.Serializer.INSTANCE,
                                        TokenGetAuthenticatedAdminError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TokenGetAuthenticatedAdminErrorException("2/team/token/get_authenticated_admin", ex.getRequestId(), ex.getUserMessage(), (TokenGetAuthenticatedAdminError) ex.getErrorValue());
        }
    }
}
