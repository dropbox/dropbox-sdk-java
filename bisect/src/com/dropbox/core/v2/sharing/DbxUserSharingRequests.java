/* DO NOT EDIT */
/* This file was generated from sharing_folders.stone, sharing_files.stone, shared_content_links.stone, shared_links.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxDownloadStyleBuilder;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.async.LaunchEmptyResult;
import com.dropbox.core.v2.async.LaunchResultBase;
import com.dropbox.core.v2.async.PollArg;
import com.dropbox.core.v2.async.PollError;
import com.dropbox.core.v2.async.PollErrorException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "sharing".
 */
public class DbxUserSharingRequests {
    // namespace sharing (sharing_folders.stone, sharing_files.stone, shared_content_links.stone, shared_links.stone)

    private final DbxRawClientV2 client;

    public DbxUserSharingRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/sharing/add_file_member
    //

    /**
     * Adds specified members to a file.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#addFileMember(String,List)}.
     */
    List<FileMemberActionResult> addFileMember(AddFileMemberArgs arg) throws AddFileMemberErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/add_file_member",
                                        arg,
                                        false,
                                        AddFileMemberArgs.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(FileMemberActionResult.Serializer.INSTANCE),
                                        AddFileMemberError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new AddFileMemberErrorException("2/sharing/add_file_member", ex.getRequestId(), ex.getUserMessage(), (AddFileMemberError) ex.getErrorValue());
        }
    }

    /**
     * Adds specified members to a file.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link AddFileMemberBuilder} for more details. </p>
     *
     * @param file  File to which to add members. Must have length of at least
     *     1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     * @param members  Members to add. Note that even an email address is given,
     *     this may result in a user being directy added to the membership if
     *     that email is the user's main account email. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<FileMemberActionResult> addFileMember(String file, List<MemberSelector> members) throws AddFileMemberErrorException, DbxException {
        AddFileMemberArgs _arg = new AddFileMemberArgs(file, members);
        return addFileMember(_arg);
    }

    /**
     * Adds specified members to a file.
     *
     * @param file  File to which to add members. Must have length of at least
     *     1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     * @param members  Members to add. Note that even an email address is given,
     *     this may result in a user being directy added to the membership if
     *     that email is the user's main account email. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddFileMemberBuilder addFileMemberBuilder(String file, List<MemberSelector> members) {
        AddFileMemberArgs.Builder argBuilder_ = AddFileMemberArgs.newBuilder(file, members);
        return new AddFileMemberBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/add_folder_member
    //

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link
     * DbxUserSharingRequests#mountFolder(String)} on their behalf.
     *
     */
    void addFolderMember(AddFolderMemberArg arg) throws AddFolderMemberErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/sharing/add_folder_member",
                                 arg,
                                 false,
                                 AddFolderMemberArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 AddFolderMemberError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new AddFolderMemberErrorException("2/sharing/add_folder_member", ex.getRequestId(), ex.getUserMessage(), (AddFolderMemberError) ex.getErrorValue());
        }
    }

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member.
     *
     * <p> For the new member to get access to all the functionality for this
     * folder, you will need to call {@link
     * DbxUserSharingRequests#mountFolder(String)} on their behalf. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link AddFolderMemberBuilder} for more details. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param members  The intended list of members to add.  Added members will
     *     receive invites to join the shared folder. Must not contain a {@code
     *     null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void addFolderMember(String sharedFolderId, List<AddMember> members) throws AddFolderMemberErrorException, DbxException {
        AddFolderMemberArg _arg = new AddFolderMemberArg(sharedFolderId, members);
        addFolderMember(_arg);
    }

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link
     * DbxUserSharingRequests#mountFolder(String)} on their behalf.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param members  The intended list of members to add.  Added members will
     *     receive invites to join the shared folder. Must not contain a {@code
     *     null} item and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AddFolderMemberBuilder addFolderMemberBuilder(String sharedFolderId, List<AddMember> members) {
        AddFolderMemberArg.Builder argBuilder_ = AddFolderMemberArg.newBuilder(sharedFolderId, members);
        return new AddFolderMemberBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/change_file_member_access
    //

    /**
     * Identical to update_file_member but with less information returned.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#changeFileMemberAccess(String,MemberSelector,AccessLevel)}.
     *
     * @return Per-member result for {@link
     *     DbxUserSharingRequests#addFileMember(String,List)} or {@link
     *     DbxUserSharingRequests#changeFileMemberAccess(String,MemberSelector,AccessLevel)}.
     */
    FileMemberActionResult changeFileMemberAccess(ChangeFileMemberAccessArgs arg) throws FileMemberActionErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/change_file_member_access",
                                        arg,
                                        false,
                                        ChangeFileMemberAccessArgs.Serializer.INSTANCE,
                                        FileMemberActionResult.Serializer.INSTANCE,
                                        FileMemberActionError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new FileMemberActionErrorException("2/sharing/change_file_member_access", ex.getRequestId(), ex.getUserMessage(), (FileMemberActionError) ex.getErrorValue());
        }
    }

    /**
     * Identical to update_file_member but with less information returned.
     *
     * @param file  File for which we are changing a member's access. Must have
     *     length of at least 1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     * @param member  The member whose access we are changing. Must not be
     *     {@code null}.
     * @param accessLevel  The new access level for the member. Must not be
     *     {@code null}.
     *
     * @return Per-member result for {@link
     *     DbxUserSharingRequests#addFileMember(String,List)} or {@link
     *     DbxUserSharingRequests#changeFileMemberAccess(String,MemberSelector,AccessLevel)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link
     *     DbxUserSharingRequests#updateFileMember(String,MemberSelector,AccessLevel)}
     *     instead.
     */
    @Deprecated
    public FileMemberActionResult changeFileMemberAccess(String file, MemberSelector member, AccessLevel accessLevel) throws FileMemberActionErrorException, DbxException {
        ChangeFileMemberAccessArgs _arg = new ChangeFileMemberAccessArgs(file, member, accessLevel);
        return changeFileMemberAccess(_arg);
    }

    //
    // route 2/sharing/check_job_status
    //

    /**
     * Returns the status of an asynchronous job.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    JobStatus checkJobStatus(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/check_job_status",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        JobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/sharing/check_job_status", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public JobStatus checkJobStatus(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return checkJobStatus(_arg);
    }

    //
    // route 2/sharing/check_remove_member_job_status
    //

    /**
     * Returns the status of an asynchronous job for sharing a folder.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    RemoveMemberJobStatus checkRemoveMemberJobStatus(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/check_remove_member_job_status",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        RemoveMemberJobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/sharing/check_remove_member_job_status", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for sharing a folder.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RemoveMemberJobStatus checkRemoveMemberJobStatus(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return checkRemoveMemberJobStatus(_arg);
    }

    //
    // route 2/sharing/check_share_job_status
    //

    /**
     * Returns the status of an asynchronous job for sharing a folder.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    ShareFolderJobStatus checkShareJobStatus(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/check_share_job_status",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        ShareFolderJobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/sharing/check_share_job_status", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for sharing a folder.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderJobStatus checkShareJobStatus(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return checkShareJobStatus(_arg);
    }

    //
    // route 2/sharing/create_shared_link
    //

    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the {@link PathLinkMetadata#getUrl} field is the
     * shortened URL if {@link CreateSharedLinkArg#getShortUrl} argument is set
     * to {@code true}. Previously, it was technically possible to break a
     * shared link by moving or renaming the corresponding file or folder. In
     * the future, this will no longer be the case, so your app shouldn't rely
     * on this behavior. Instead, if your app needs to revoke a shared link, use
     * {@link DbxUserSharingRequests#revokeSharedLink(String)}.
     *
     *
     * @return Metadata for a path-based shared link.
     */
    PathLinkMetadata createSharedLink(CreateSharedLinkArg arg) throws CreateSharedLinkErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/create_shared_link",
                                        arg,
                                        false,
                                        CreateSharedLinkArg.Serializer.INSTANCE,
                                        PathLinkMetadata.Serializer.INSTANCE,
                                        CreateSharedLinkError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new CreateSharedLinkErrorException("2/sharing/create_shared_link", ex.getRequestId(), ex.getUserMessage(), (CreateSharedLinkError) ex.getErrorValue());
        }
    }

    /**
     * Create a shared link.
     *
     * <p> If a shared link already exists for the given path, that link is
     * returned. </p>
     *
     * <p> Note that in the returned {@link PathLinkMetadata}, the {@link
     * PathLinkMetadata#getUrl} field is the shortened URL if {@link
     * CreateSharedLinkArg#getShortUrl} argument is set to {@code true}. </p>
     *
     * <p> Previously, it was technically possible to break a shared link by
     * moving or renaming the corresponding file or folder. In the future, this
     * will no longer be the case, so your app shouldn't rely on this behavior.
     * Instead, if your app needs to revoke a shared link, use {@link
     * DbxUserSharingRequests#revokeSharedLink(String)}. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link CreateSharedLinkBuilder} for more details. </p>
     *
     * @param path  The path to share. Must not be {@code null}.
     *
     * @return Metadata for a path-based shared link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link
     *     DbxUserSharingRequests#createSharedLinkWithSettings(String,SharedLinkSettings)}
     *     instead.
     */
    @Deprecated
    public PathLinkMetadata createSharedLink(String path) throws CreateSharedLinkErrorException, DbxException {
        CreateSharedLinkArg _arg = new CreateSharedLinkArg(path);
        return createSharedLink(_arg);
    }

    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the {@link PathLinkMetadata#getUrl} field is the
     * shortened URL if {@link CreateSharedLinkArg#getShortUrl} argument is set
     * to {@code true}. Previously, it was technically possible to break a
     * shared link by moving or renaming the corresponding file or folder. In
     * the future, this will no longer be the case, so your app shouldn't rely
     * on this behavior. Instead, if your app needs to revoke a shared link, use
     * {@link DbxUserSharingRequests#revokeSharedLink(String)}.
     *
     * @param path  The path to share. Must not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link
     *     DbxUserSharingRequests#createSharedLinkWithSettings(String,SharedLinkSettings)}
     *     instead.
     */
    @Deprecated
    public CreateSharedLinkBuilder createSharedLinkBuilder(String path) {
        CreateSharedLinkArg.Builder argBuilder_ = CreateSharedLinkArg.newBuilder(path);
        return new CreateSharedLinkBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/create_shared_link_with_settings
    //

    /**
     * Create a shared link with custom settings. If no settings are given then
     * the default visibility is {@link RequestedVisibility#PUBLIC} (The
     * resolved visibility, though, may depend on other aspects such as team and
     * shared folder settings).
     *
     *
     * @return The metadata of a shared link.
     */
    SharedLinkMetadata createSharedLinkWithSettings(CreateSharedLinkWithSettingsArg arg) throws CreateSharedLinkWithSettingsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/create_shared_link_with_settings",
                                        arg,
                                        false,
                                        CreateSharedLinkWithSettingsArg.Serializer.INSTANCE,
                                        SharedLinkMetadata.Serializer.INSTANCE,
                                        CreateSharedLinkWithSettingsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new CreateSharedLinkWithSettingsErrorException("2/sharing/create_shared_link_with_settings", ex.getRequestId(), ex.getUserMessage(), (CreateSharedLinkWithSettingsError) ex.getErrorValue());
        }
    }

    /**
     * Create a shared link with custom settings. If no settings are given then
     * the default visibility is {@link RequestedVisibility#PUBLIC} (The
     * resolved visibility, though, may depend on other aspects such as team and
     * shared folder settings).
     *
     * @param path  The path to be shared by the shared link. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @return The metadata of a shared link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata createSharedLinkWithSettings(String path) throws CreateSharedLinkWithSettingsErrorException, DbxException {
        CreateSharedLinkWithSettingsArg _arg = new CreateSharedLinkWithSettingsArg(path);
        return createSharedLinkWithSettings(_arg);
    }

    /**
     * Create a shared link with custom settings. If no settings are given then
     * the default visibility is {@link RequestedVisibility#PUBLIC} (The
     * resolved visibility, though, may depend on other aspects such as team and
     * shared folder settings).
     *
     * @param path  The path to be shared by the shared link. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     * @param settings  The requested settings for the newly created shared
     *     link.
     *
     * @return The metadata of a shared link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata createSharedLinkWithSettings(String path, SharedLinkSettings settings) throws CreateSharedLinkWithSettingsErrorException, DbxException {
        CreateSharedLinkWithSettingsArg _arg = new CreateSharedLinkWithSettingsArg(path, settings);
        return createSharedLinkWithSettings(_arg);
    }

    //
    // route 2/sharing/get_file_metadata
    //

    /**
     * Returns shared file metadata.
     *
     * @param arg  Arguments of {@link
     *     DbxUserSharingRequests#getFileMetadata(String,List)}.
     *
     * @return Properties of the shared file.
     */
    SharedFileMetadata getFileMetadata(GetFileMetadataArg arg) throws GetFileMetadataErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/get_file_metadata",
                                        arg,
                                        false,
                                        GetFileMetadataArg.Serializer.INSTANCE,
                                        SharedFileMetadata.Serializer.INSTANCE,
                                        GetFileMetadataError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetFileMetadataErrorException("2/sharing/get_file_metadata", ex.getRequestId(), ex.getUserMessage(), (GetFileMetadataError) ex.getErrorValue());
        }
    }

    /**
     * Returns shared file metadata.
     *
     * @param file  The file to query. Must have length of at least 1, match
     *     pattern "{@code ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and
     *     not be {@code null}.
     *
     * @return Properties of the shared file.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFileMetadata getFileMetadata(String file) throws GetFileMetadataErrorException, DbxException {
        GetFileMetadataArg _arg = new GetFileMetadataArg(file);
        return getFileMetadata(_arg);
    }

    /**
     * Returns shared file metadata.
     *
     * @param file  The file to query. Must have length of at least 1, match
     *     pattern "{@code ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and
     *     not be {@code null}.
     * @param actions  A list of `FileAction`s corresponding to
     *     `FilePermission`s that should appear in the  response's {@link
     *     SharedFileMetadata#getPermissions} field describing the actions the
     *     authenticated user can perform on the file. Must not contain a {@code
     *     null} item.
     *
     * @return Properties of the shared file.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFileMetadata getFileMetadata(String file, List<FileAction> actions) throws GetFileMetadataErrorException, DbxException {
        if (actions != null) {
            for (FileAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        GetFileMetadataArg _arg = new GetFileMetadataArg(file, actions);
        return getFileMetadata(_arg);
    }

    //
    // route 2/sharing/get_file_metadata/batch
    //

    /**
     * Returns shared file metadata.
     *
     * @param arg  Arguments of {@link
     *     DbxUserSharingRequests#getFileMetadataBatch(List,List)}.
     */
    List<GetFileMetadataBatchResult> getFileMetadataBatch(GetFileMetadataBatchArg arg) throws SharingUserErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/get_file_metadata/batch",
                                        arg,
                                        false,
                                        GetFileMetadataBatchArg.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(GetFileMetadataBatchResult.Serializer.INSTANCE),
                                        SharingUserError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharingUserErrorException("2/sharing/get_file_metadata/batch", ex.getRequestId(), ex.getUserMessage(), (SharingUserError) ex.getErrorValue());
        }
    }

    /**
     * Returns shared file metadata.
     *
     * @param files  The files to query. Must contain at most 100 items, not
     *     contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<GetFileMetadataBatchResult> getFileMetadataBatch(List<String> files) throws SharingUserErrorException, DbxException {
        GetFileMetadataBatchArg _arg = new GetFileMetadataBatchArg(files);
        return getFileMetadataBatch(_arg);
    }

    /**
     * Returns shared file metadata.
     *
     * @param files  The files to query. Must contain at most 100 items, not
     *     contain a {@code null} item, and not be {@code null}.
     * @param actions  A list of `FileAction`s corresponding to
     *     `FilePermission`s that should appear in the  response's {@link
     *     SharedFileMetadata#getPermissions} field describing the actions the
     *     authenticated user can perform on the file. Must not contain a {@code
     *     null} item.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<GetFileMetadataBatchResult> getFileMetadataBatch(List<String> files, List<FileAction> actions) throws SharingUserErrorException, DbxException {
        if (actions != null) {
            for (FileAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        GetFileMetadataBatchArg _arg = new GetFileMetadataBatchArg(files, actions);
        return getFileMetadataBatch(_arg);
    }

    //
    // route 2/sharing/get_folder_metadata
    //

    /**
     * Returns shared folder metadata by its folder ID.
     *
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     */
    SharedFolderMetadata getFolderMetadata(GetMetadataArgs arg) throws SharedFolderAccessErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/get_folder_metadata",
                                        arg,
                                        false,
                                        GetMetadataArgs.Serializer.INSTANCE,
                                        SharedFolderMetadata.Serializer.INSTANCE,
                                        SharedFolderAccessError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharedFolderAccessErrorException("2/sharing/get_folder_metadata", ex.getRequestId(), ex.getUserMessage(), (SharedFolderAccessError) ex.getErrorValue());
        }
    }

    /**
     * Returns shared folder metadata by its folder ID.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata getFolderMetadata(String sharedFolderId) throws SharedFolderAccessErrorException, DbxException {
        GetMetadataArgs _arg = new GetMetadataArgs(sharedFolderId);
        return getFolderMetadata(_arg);
    }

    /**
     * Returns shared folder metadata by its folder ID.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param actions  A list of `FolderAction`s corresponding to
     *     `FolderPermission`s that should appear in the  response's {@link
     *     SharedFolderMetadata#getPermissions} field describing the actions the
     *     authenticated user can perform on the folder. Must not contain a
     *     {@code null} item.
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata getFolderMetadata(String sharedFolderId, List<FolderAction> actions) throws SharedFolderAccessErrorException, DbxException {
        if (actions != null) {
            for (FolderAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        GetMetadataArgs _arg = new GetMetadataArgs(sharedFolderId, actions);
        return getFolderMetadata(_arg);
    }

    //
    // route 2/sharing/get_shared_link_file
    //

    /**
     * Download the shared link's file from a user's Dropbox.
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<SharedLinkMetadata> getSharedLinkFile(GetSharedLinkMetadataArg arg, List<HttpRequestor.Header> _headers) throws GetSharedLinkFileErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/sharing/get_shared_link_file",
                                             arg,
                                             false,
                                             _headers,
                                             GetSharedLinkMetadataArg.Serializer.INSTANCE,
                                             SharedLinkMetadata.Serializer.INSTANCE,
                                             GetSharedLinkFileError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetSharedLinkFileErrorException("2/sharing/get_shared_link_file", ex.getRequestId(), ex.getUserMessage(), (GetSharedLinkFileError) ex.getErrorValue());
        }
    }

    /**
     * Download the shared link's file from a user's Dropbox.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<SharedLinkMetadata> getSharedLinkFile(String url) throws GetSharedLinkFileErrorException, DbxException {
        GetSharedLinkMetadataArg _arg = new GetSharedLinkMetadataArg(url);
        return getSharedLinkFile(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Download the shared link's file from a user's Dropbox.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetSharedLinkFileBuilder getSharedLinkFileBuilder(String url) {
        GetSharedLinkMetadataArg.Builder argBuilder_ = GetSharedLinkMetadataArg.newBuilder(url);
        return new GetSharedLinkFileBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/get_shared_link_metadata
    //

    /**
     * Get the shared link's metadata.
     *
     *
     * @return The metadata of a shared link.
     */
    SharedLinkMetadata getSharedLinkMetadata(GetSharedLinkMetadataArg arg) throws SharedLinkErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/get_shared_link_metadata",
                                        arg,
                                        false,
                                        GetSharedLinkMetadataArg.Serializer.INSTANCE,
                                        SharedLinkMetadata.Serializer.INSTANCE,
                                        SharedLinkError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharedLinkErrorException("2/sharing/get_shared_link_metadata", ex.getRequestId(), ex.getUserMessage(), (SharedLinkError) ex.getErrorValue());
        }
    }

    /**
     * Get the shared link's metadata.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @return The metadata of a shared link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata getSharedLinkMetadata(String url) throws SharedLinkErrorException, DbxException {
        GetSharedLinkMetadataArg _arg = new GetSharedLinkMetadataArg(url);
        return getSharedLinkMetadata(_arg);
    }

    /**
     * Get the shared link's metadata.
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetSharedLinkMetadataBuilder getSharedLinkMetadataBuilder(String url) {
        GetSharedLinkMetadataArg.Builder argBuilder_ = GetSharedLinkMetadataArg.newBuilder(url);
        return new GetSharedLinkMetadataBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/get_shared_links
    //

    /**
     * Returns a list of {@link LinkMetadata} objects for this user, including
     * collection links. If no path is given, returns a list of all shared links
     * for the current user, including collection links, up to a maximum of 1000
     * links. If a non-empty path is given, returns a list of all shared links
     * that allow access to the given path.  Collection links are never returned
     * in this case. Note that the url field in the response is never the
     * shortened URL.
     *
     */
    GetSharedLinksResult getSharedLinks(GetSharedLinksArg arg) throws GetSharedLinksErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/get_shared_links",
                                        arg,
                                        false,
                                        GetSharedLinksArg.Serializer.INSTANCE,
                                        GetSharedLinksResult.Serializer.INSTANCE,
                                        GetSharedLinksError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetSharedLinksErrorException("2/sharing/get_shared_links", ex.getRequestId(), ex.getUserMessage(), (GetSharedLinksError) ex.getErrorValue());
        }
    }

    /**
     * Returns a list of {@link LinkMetadata} objects for this user, including
     * collection links.
     *
     * <p> If no path is given, returns a list of all shared links for the
     * current user, including collection links, up to a maximum of 1000 links.
     * </p>
     *
     * <p> If a non-empty path is given, returns a list of all shared links that
     * allow access to the given path.  Collection links are never returned in
     * this case. </p>
     *
     * <p> Note that the url field in the response is never the shortened URL.
     * </p>
     *
     * @deprecated use {@link DbxUserSharingRequests#listSharedLinks} instead.
     */
    @Deprecated
    public GetSharedLinksResult getSharedLinks() throws GetSharedLinksErrorException, DbxException {
        GetSharedLinksArg _arg = new GetSharedLinksArg();
        return getSharedLinks(_arg);
    }

    /**
     * Returns a list of {@link LinkMetadata} objects for this user, including
     * collection links.
     *
     * <p> If no path is given, returns a list of all shared links for the
     * current user, including collection links, up to a maximum of 1000 links.
     * </p>
     *
     * <p> If a non-empty path is given, returns a list of all shared links that
     * allow access to the given path.  Collection links are never returned in
     * this case. </p>
     *
     * <p> Note that the url field in the response is never the shortened URL.
     * </p>
     *
     * @param path  See {@link DbxUserSharingRequests#getSharedLinks(String)}
     *     description.
     *
     * @deprecated use {@link DbxUserSharingRequests#listSharedLinks} instead.
     */
    @Deprecated
    public GetSharedLinksResult getSharedLinks(String path) throws GetSharedLinksErrorException, DbxException {
        GetSharedLinksArg _arg = new GetSharedLinksArg(path);
        return getSharedLinks(_arg);
    }

    //
    // route 2/sharing/list_file_members
    //

    /**
     * Use to obtain the members who have been invited to a file, both inherited
     * and uninherited members.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#listFileMembers(String)}.
     *
     * @return Shared file user, group, and invitee membership. Used for the
     *     results of {@link DbxUserSharingRequests#listFileMembers(String)} and
     *     {@link DbxUserSharingRequests#listFileMembersContinue(String)}, and
     *     used as part of the results for {@link
     *     DbxUserSharingRequests#listFileMembersBatch(List,long)}.
     */
    SharedFileMembers listFileMembers(ListFileMembersArg arg) throws ListFileMembersErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_file_members",
                                        arg,
                                        false,
                                        ListFileMembersArg.Serializer.INSTANCE,
                                        SharedFileMembers.Serializer.INSTANCE,
                                        ListFileMembersError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFileMembersErrorException("2/sharing/list_file_members", ex.getRequestId(), ex.getUserMessage(), (ListFileMembersError) ex.getErrorValue());
        }
    }

    /**
     * Use to obtain the members who have been invited to a file, both inherited
     * and uninherited members.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link ListFileMembersBuilder} for more details. </p>
     *
     * @param file  The file for which you want to see members. Must have length
     *     of at least 1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     *
     * @return Shared file user, group, and invitee membership. Used for the
     *     results of {@link DbxUserSharingRequests#listFileMembers(String)} and
     *     {@link DbxUserSharingRequests#listFileMembersContinue(String)}, and
     *     used as part of the results for {@link
     *     DbxUserSharingRequests#listFileMembersBatch(List,long)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFileMembers listFileMembers(String file) throws ListFileMembersErrorException, DbxException {
        ListFileMembersArg _arg = new ListFileMembersArg(file);
        return listFileMembers(_arg);
    }

    /**
     * Use to obtain the members who have been invited to a file, both inherited
     * and uninherited members.
     *
     * @param file  The file for which you want to see members. Must have length
     *     of at least 1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileMembersBuilder listFileMembersBuilder(String file) {
        ListFileMembersArg.Builder argBuilder_ = ListFileMembersArg.newBuilder(file);
        return new ListFileMembersBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/list_file_members/batch
    //

    /**
     * Get members of multiple files at once. The arguments to this route are
     * more limited, and the limit on query result size per file is more strict.
     * To customize the results more, use the individual file endpoint.
     * Inherited users and groups are not included in the result, and
     * permissions are not returned for this endpoint.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#listFileMembersBatch(List,long)}.
     */
    List<ListFileMembersBatchResult> listFileMembersBatch(ListFileMembersBatchArg arg) throws SharingUserErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_file_members/batch",
                                        arg,
                                        false,
                                        ListFileMembersBatchArg.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(ListFileMembersBatchResult.Serializer.INSTANCE),
                                        SharingUserError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharingUserErrorException("2/sharing/list_file_members/batch", ex.getRequestId(), ex.getUserMessage(), (SharingUserError) ex.getErrorValue());
        }
    }

    /**
     * Get members of multiple files at once. The arguments to this route are
     * more limited, and the limit on query result size per file is more strict.
     * To customize the results more, use the individual file endpoint.
     *
     * <p> Inherited users and groups are not included in the result, and
     * permissions are not returned for this endpoint. </p>
     *
     * <p> The {@code limit} request parameter will default to {@code 10L} (see
     * {@link #listFileMembersBatch(List,long)}). </p>
     *
     * @param files  Files for which to return members. Must contain at most 100
     *     items, not contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<ListFileMembersBatchResult> listFileMembersBatch(List<String> files) throws SharingUserErrorException, DbxException {
        ListFileMembersBatchArg _arg = new ListFileMembersBatchArg(files);
        return listFileMembersBatch(_arg);
    }

    /**
     * Get members of multiple files at once. The arguments to this route are
     * more limited, and the limit on query result size per file is more strict.
     * To customize the results more, use the individual file endpoint.
     *
     * <p> Inherited users and groups are not included in the result, and
     * permissions are not returned for this endpoint. </p>
     *
     * @param files  Files for which to return members. Must contain at most 100
     *     items, not contain a {@code null} item, and not be {@code null}.
     * @param limit  Number of members to return max per query. Defaults to 10
     *     if no limit is specified. Must be less than or equal to 20.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public List<ListFileMembersBatchResult> listFileMembersBatch(List<String> files, long limit) throws SharingUserErrorException, DbxException {
        if (limit > 20L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 20L");
        }
        ListFileMembersBatchArg _arg = new ListFileMembersBatchArg(files, limit);
        return listFileMembersBatch(_arg);
    }

    //
    // route 2/sharing/list_file_members/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserSharingRequests#listFileMembers(String)} or {@link
     * DbxUserSharingRequests#listFileMembersBatch(List,long)}, use this to
     * paginate through all shared file members.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#listFileMembersContinue(String)}.
     *
     * @return Shared file user, group, and invitee membership. Used for the
     *     results of {@link DbxUserSharingRequests#listFileMembers(String)} and
     *     {@link DbxUserSharingRequests#listFileMembersContinue(String)}, and
     *     used as part of the results for {@link
     *     DbxUserSharingRequests#listFileMembersBatch(List,long)}.
     */
    SharedFileMembers listFileMembersContinue(ListFileMembersContinueArg arg) throws ListFileMembersContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_file_members/continue",
                                        arg,
                                        false,
                                        ListFileMembersContinueArg.Serializer.INSTANCE,
                                        SharedFileMembers.Serializer.INSTANCE,
                                        ListFileMembersContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFileMembersContinueErrorException("2/sharing/list_file_members/continue", ex.getRequestId(), ex.getUserMessage(), (ListFileMembersContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserSharingRequests#listFileMembers(String)} or {@link
     * DbxUserSharingRequests#listFileMembersBatch(List,long)}, use this to
     * paginate through all shared file members.
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxUserSharingRequests#listFileMembers(String)}, {@link
     *     DbxUserSharingRequests#listFileMembersContinue(String)}, or {@link
     *     DbxUserSharingRequests#listFileMembersBatch(List,long)}. Must not be
     *     {@code null}.
     *
     * @return Shared file user, group, and invitee membership. Used for the
     *     results of {@link DbxUserSharingRequests#listFileMembers(String)} and
     *     {@link DbxUserSharingRequests#listFileMembersContinue(String)}, and
     *     used as part of the results for {@link
     *     DbxUserSharingRequests#listFileMembersBatch(List,long)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFileMembers listFileMembersContinue(String cursor) throws ListFileMembersContinueErrorException, DbxException {
        ListFileMembersContinueArg _arg = new ListFileMembersContinueArg(cursor);
        return listFileMembersContinue(_arg);
    }

    //
    // route 2/sharing/list_folder_members
    //

    /**
     * Returns shared folder membership by its folder ID.
     *
     *
     * @return Shared folder user and group membership.
     */
    SharedFolderMembers listFolderMembers(ListFolderMembersArgs arg) throws SharedFolderAccessErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_folder_members",
                                        arg,
                                        false,
                                        ListFolderMembersArgs.Serializer.INSTANCE,
                                        SharedFolderMembers.Serializer.INSTANCE,
                                        SharedFolderAccessError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharedFolderAccessErrorException("2/sharing/list_folder_members", ex.getRequestId(), ex.getUserMessage(), (SharedFolderAccessError) ex.getErrorValue());
        }
    }

    /**
     * Returns shared folder membership by its folder ID.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link ListFolderMembersBuilder} for more details. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return Shared folder user and group membership.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMembers listFolderMembers(String sharedFolderId) throws SharedFolderAccessErrorException, DbxException {
        ListFolderMembersArgs _arg = new ListFolderMembersArgs(sharedFolderId);
        return listFolderMembers(_arg);
    }

    /**
     * Returns shared folder membership by its folder ID.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderMembersBuilder listFolderMembersBuilder(String sharedFolderId) {
        ListFolderMembersArgs.Builder argBuilder_ = ListFolderMembersArgs.newBuilder(sharedFolderId);
        return new ListFolderMembersBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/list_folder_members/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserSharingRequests#listFolderMembers(String)}, use this to paginate
     * through all shared folder members.
     *
     *
     * @return Shared folder user and group membership.
     */
    SharedFolderMembers listFolderMembersContinue(ListFolderMembersContinueArg arg) throws ListFolderMembersContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_folder_members/continue",
                                        arg,
                                        false,
                                        ListFolderMembersContinueArg.Serializer.INSTANCE,
                                        SharedFolderMembers.Serializer.INSTANCE,
                                        ListFolderMembersContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFolderMembersContinueErrorException("2/sharing/list_folder_members/continue", ex.getRequestId(), ex.getUserMessage(), (ListFolderMembersContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserSharingRequests#listFolderMembers(String)}, use this to paginate
     * through all shared folder members.
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxUserSharingRequests#listFolderMembers(String)} or {@link
     *     DbxUserSharingRequests#listFolderMembersContinue(String)}. Must not
     *     be {@code null}.
     *
     * @return Shared folder user and group membership.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMembers listFolderMembersContinue(String cursor) throws ListFolderMembersContinueErrorException, DbxException {
        ListFolderMembersContinueArg _arg = new ListFolderMembersContinueArg(cursor);
        return listFolderMembersContinue(_arg);
    }

    //
    // route 2/sharing/list_folders
    //

    /**
     * Return the list of all shared folders the current user has access to.
     *
     *
     * @return Result for {@link DbxUserSharingRequests#listFolders} or {@link
     *     DbxUserSharingRequests#listMountableFolders}, depending on which
     *     endpoint was requested. Unmounted shared folders can be identified by
     *     the absence of {@link SharedFolderMetadata#getPathLower}.
     */
    ListFoldersResult listFolders(ListFoldersArgs arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_folders",
                                        arg,
                                        false,
                                        ListFoldersArgs.Serializer.INSTANCE,
                                        ListFoldersResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"list_folders\":" + ex.getErrorValue());
        }
    }

    /**
     * Return the list of all shared folders the current user has access to.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link ListFoldersBuilder} for more details. </p>
     *
     * @return Result for {@link DbxUserSharingRequests#listFolders} or {@link
     *     DbxUserSharingRequests#listMountableFolders}, depending on which
     *     endpoint was requested. Unmounted shared folders can be identified by
     *     the absence of {@link SharedFolderMetadata#getPathLower}.
     */
    public ListFoldersResult listFolders() throws DbxApiException, DbxException {
        ListFoldersArgs _arg = new ListFoldersArgs();
        return listFolders(_arg);
    }

    /**
     * Return the list of all shared folders the current user has access to.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ListFoldersBuilder listFoldersBuilder() {
        ListFoldersArgs.Builder argBuilder_ = ListFoldersArgs.newBuilder();
        return new ListFoldersBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/list_folders/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserSharingRequests#listFolders}, use this to paginate through all
     * shared folders. The cursor must come from a previous call to {@link
     * DbxUserSharingRequests#listFolders} or {@link
     * DbxUserSharingRequests#listFoldersContinue(String)}.
     *
     *
     * @return Result for {@link DbxUserSharingRequests#listFolders} or {@link
     *     DbxUserSharingRequests#listMountableFolders}, depending on which
     *     endpoint was requested. Unmounted shared folders can be identified by
     *     the absence of {@link SharedFolderMetadata#getPathLower}.
     */
    ListFoldersResult listFoldersContinue(ListFoldersContinueArg arg) throws ListFoldersContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_folders/continue",
                                        arg,
                                        false,
                                        ListFoldersContinueArg.Serializer.INSTANCE,
                                        ListFoldersResult.Serializer.INSTANCE,
                                        ListFoldersContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFoldersContinueErrorException("2/sharing/list_folders/continue", ex.getRequestId(), ex.getUserMessage(), (ListFoldersContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserSharingRequests#listFolders}, use this to paginate through all
     * shared folders. The cursor must come from a previous call to {@link
     * DbxUserSharingRequests#listFolders} or {@link
     * DbxUserSharingRequests#listFoldersContinue(String)}.
     *
     * @param cursor  The cursor returned by the previous API call specified in
     *     the endpoint description. Must not be {@code null}.
     *
     * @return Result for {@link DbxUserSharingRequests#listFolders} or {@link
     *     DbxUserSharingRequests#listMountableFolders}, depending on which
     *     endpoint was requested. Unmounted shared folders can be identified by
     *     the absence of {@link SharedFolderMetadata#getPathLower}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFoldersResult listFoldersContinue(String cursor) throws ListFoldersContinueErrorException, DbxException {
        ListFoldersContinueArg _arg = new ListFoldersContinueArg(cursor);
        return listFoldersContinue(_arg);
    }

    //
    // route 2/sharing/list_mountable_folders
    //

    /**
     * Return the list of all shared folders the current user can mount or
     * unmount.
     *
     *
     * @return Result for {@link DbxUserSharingRequests#listFolders} or {@link
     *     DbxUserSharingRequests#listMountableFolders}, depending on which
     *     endpoint was requested. Unmounted shared folders can be identified by
     *     the absence of {@link SharedFolderMetadata#getPathLower}.
     */
    ListFoldersResult listMountableFolders(ListFoldersArgs arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_mountable_folders",
                                        arg,
                                        false,
                                        ListFoldersArgs.Serializer.INSTANCE,
                                        ListFoldersResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"list_mountable_folders\":" + ex.getErrorValue());
        }
    }

    /**
     * Return the list of all shared folders the current user can mount or
     * unmount.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link ListMountableFoldersBuilder} for more details. </p>
     *
     * @return Result for {@link DbxUserSharingRequests#listFolders} or {@link
     *     DbxUserSharingRequests#listMountableFolders}, depending on which
     *     endpoint was requested. Unmounted shared folders can be identified by
     *     the absence of {@link SharedFolderMetadata#getPathLower}.
     */
    public ListFoldersResult listMountableFolders() throws DbxApiException, DbxException {
        ListFoldersArgs _arg = new ListFoldersArgs();
        return listMountableFolders(_arg);
    }

    /**
     * Return the list of all shared folders the current user can mount or
     * unmount.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ListMountableFoldersBuilder listMountableFoldersBuilder() {
        ListFoldersArgs.Builder argBuilder_ = ListFoldersArgs.newBuilder();
        return new ListMountableFoldersBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/list_mountable_folders/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserSharingRequests#listMountableFolders}, use this to paginate
     * through all mountable shared folders. The cursor must come from a
     * previous call to {@link DbxUserSharingRequests#listMountableFolders} or
     * {@link DbxUserSharingRequests#listMountableFoldersContinue(String)}.
     *
     *
     * @return Result for {@link DbxUserSharingRequests#listFolders} or {@link
     *     DbxUserSharingRequests#listMountableFolders}, depending on which
     *     endpoint was requested. Unmounted shared folders can be identified by
     *     the absence of {@link SharedFolderMetadata#getPathLower}.
     */
    ListFoldersResult listMountableFoldersContinue(ListFoldersContinueArg arg) throws ListFoldersContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_mountable_folders/continue",
                                        arg,
                                        false,
                                        ListFoldersContinueArg.Serializer.INSTANCE,
                                        ListFoldersResult.Serializer.INSTANCE,
                                        ListFoldersContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFoldersContinueErrorException("2/sharing/list_mountable_folders/continue", ex.getRequestId(), ex.getUserMessage(), (ListFoldersContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserSharingRequests#listMountableFolders}, use this to paginate
     * through all mountable shared folders. The cursor must come from a
     * previous call to {@link DbxUserSharingRequests#listMountableFolders} or
     * {@link DbxUserSharingRequests#listMountableFoldersContinue(String)}.
     *
     * @param cursor  The cursor returned by the previous API call specified in
     *     the endpoint description. Must not be {@code null}.
     *
     * @return Result for {@link DbxUserSharingRequests#listFolders} or {@link
     *     DbxUserSharingRequests#listMountableFolders}, depending on which
     *     endpoint was requested. Unmounted shared folders can be identified by
     *     the absence of {@link SharedFolderMetadata#getPathLower}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFoldersResult listMountableFoldersContinue(String cursor) throws ListFoldersContinueErrorException, DbxException {
        ListFoldersContinueArg _arg = new ListFoldersContinueArg(cursor);
        return listMountableFoldersContinue(_arg);
    }

    //
    // route 2/sharing/list_received_files
    //

    /**
     * Returns a list of all files shared with current user. Does not include
     * files the user has received via shared folders, and does  not include
     * unclaimed invitations.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#listReceivedFiles}.
     *
     * @return Success results for {@link
     *     DbxUserSharingRequests#listReceivedFiles}.
     */
    ListFilesResult listReceivedFiles(ListFilesArg arg) throws SharingUserErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_received_files",
                                        arg,
                                        false,
                                        ListFilesArg.Serializer.INSTANCE,
                                        ListFilesResult.Serializer.INSTANCE,
                                        SharingUserError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SharingUserErrorException("2/sharing/list_received_files", ex.getRequestId(), ex.getUserMessage(), (SharingUserError) ex.getErrorValue());
        }
    }

    /**
     * Returns a list of all files shared with current user.
     *
     * <p> Does not include files the user has received via shared folders, and
     * does not include unclaimed invitations. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link ListReceivedFilesBuilder} for more details. </p>
     *
     * @return Success results for {@link
     *     DbxUserSharingRequests#listReceivedFiles}.
     */
    public ListFilesResult listReceivedFiles() throws SharingUserErrorException, DbxException {
        ListFilesArg _arg = new ListFilesArg();
        return listReceivedFiles(_arg);
    }

    /**
     * Returns a list of all files shared with current user. Does not include
     * files the user has received via shared folders, and does  not include
     * unclaimed invitations.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ListReceivedFilesBuilder listReceivedFilesBuilder() {
        ListFilesArg.Builder argBuilder_ = ListFilesArg.newBuilder();
        return new ListReceivedFilesBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/list_received_files/continue
    //

    /**
     * Get more results with a cursor from {@link
     * DbxUserSharingRequests#listReceivedFiles}.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#listReceivedFilesContinue(String)}.
     *
     * @return Success results for {@link
     *     DbxUserSharingRequests#listReceivedFiles}.
     */
    ListFilesResult listReceivedFilesContinue(ListFilesContinueArg arg) throws ListFilesContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_received_files/continue",
                                        arg,
                                        false,
                                        ListFilesContinueArg.Serializer.INSTANCE,
                                        ListFilesResult.Serializer.INSTANCE,
                                        ListFilesContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFilesContinueErrorException("2/sharing/list_received_files/continue", ex.getRequestId(), ex.getUserMessage(), (ListFilesContinueError) ex.getErrorValue());
        }
    }

    /**
     * Get more results with a cursor from {@link
     * DbxUserSharingRequests#listReceivedFiles}.
     *
     * @param cursor  Cursor in {@link ListFilesResult#getCursor}. Must not be
     *     {@code null}.
     *
     * @return Success results for {@link
     *     DbxUserSharingRequests#listReceivedFiles}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFilesResult listReceivedFilesContinue(String cursor) throws ListFilesContinueErrorException, DbxException {
        ListFilesContinueArg _arg = new ListFilesContinueArg(cursor);
        return listReceivedFilesContinue(_arg);
    }

    //
    // route 2/sharing/list_shared_links
    //

    /**
     * List shared links of this user. If no path is given, returns a list of
     * all shared links for the current user. If a non-empty path is given,
     * returns a list of all shared links that allow access to the given path -
     * direct links to the given path and links to parent folders of the given
     * path. Links to parent folders can be suppressed by setting direct_only to
     * true.
     *
     */
    ListSharedLinksResult listSharedLinks(ListSharedLinksArg arg) throws ListSharedLinksErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/list_shared_links",
                                        arg,
                                        false,
                                        ListSharedLinksArg.Serializer.INSTANCE,
                                        ListSharedLinksResult.Serializer.INSTANCE,
                                        ListSharedLinksError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListSharedLinksErrorException("2/sharing/list_shared_links", ex.getRequestId(), ex.getUserMessage(), (ListSharedLinksError) ex.getErrorValue());
        }
    }

    /**
     * List shared links of this user.
     *
     * <p> If no path is given, returns a list of all shared links for the
     * current user. </p>
     *
     * <p> If a non-empty path is given, returns a list of all shared links that
     * allow access to the given path - direct links to the given path and links
     * to parent folders of the given path. Links to parent folders can be
     * suppressed by setting direct_only to true. </p>
     */
    public ListSharedLinksResult listSharedLinks() throws ListSharedLinksErrorException, DbxException {
        ListSharedLinksArg _arg = new ListSharedLinksArg();
        return listSharedLinks(_arg);
    }

    /**
     * List shared links of this user. If no path is given, returns a list of
     * all shared links for the current user. If a non-empty path is given,
     * returns a list of all shared links that allow access to the given path -
     * direct links to the given path and links to parent folders of the given
     * path. Links to parent folders can be suppressed by setting direct_only to
     * true.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ListSharedLinksBuilder listSharedLinksBuilder() {
        ListSharedLinksArg.Builder argBuilder_ = ListSharedLinksArg.newBuilder();
        return new ListSharedLinksBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/modify_shared_link_settings
    //

    /**
     * Modify the shared link's settings. If the requested visibility conflict
     * with the shared links policy of the team or the shared folder (in case
     * the linked file is part of a shared folder) then the {@link
     * LinkPermissions#getResolvedVisibility} of the returned {@link
     * SharedLinkMetadata} will reflect the actual visibility of the shared link
     * and the {@link LinkPermissions#getRequestedVisibility} will reflect the
     * requested visibility.
     *
     *
     * @return The metadata of a shared link.
     */
    SharedLinkMetadata modifySharedLinkSettings(ModifySharedLinkSettingsArgs arg) throws ModifySharedLinkSettingsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/modify_shared_link_settings",
                                        arg,
                                        false,
                                        ModifySharedLinkSettingsArgs.Serializer.INSTANCE,
                                        SharedLinkMetadata.Serializer.INSTANCE,
                                        ModifySharedLinkSettingsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ModifySharedLinkSettingsErrorException("2/sharing/modify_shared_link_settings", ex.getRequestId(), ex.getUserMessage(), (ModifySharedLinkSettingsError) ex.getErrorValue());
        }
    }

    /**
     * Modify the shared link's settings.
     *
     * <p> If the requested visibility conflict with the shared links policy of
     * the team or the shared folder (in case the linked file is part of a
     * shared folder) then the {@link LinkPermissions#getResolvedVisibility} of
     * the returned {@link SharedLinkMetadata} will reflect the actual
     * visibility of the shared link and the {@link
     * LinkPermissions#getRequestedVisibility} will reflect the requested
     * visibility. </p>
     *
     * <p> The {@code removeExpiration} request parameter will default to {@code
     * false} (see {@link
     * #modifySharedLinkSettings(String,SharedLinkSettings,boolean)}). </p>
     *
     * @param url  URL of the shared link to change its settings. Must not be
     *     {@code null}.
     * @param settings  Set of settings for the shared link. Must not be {@code
     *     null}.
     *
     * @return The metadata of a shared link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata modifySharedLinkSettings(String url, SharedLinkSettings settings) throws ModifySharedLinkSettingsErrorException, DbxException {
        ModifySharedLinkSettingsArgs _arg = new ModifySharedLinkSettingsArgs(url, settings);
        return modifySharedLinkSettings(_arg);
    }

    /**
     * Modify the shared link's settings.
     *
     * <p> If the requested visibility conflict with the shared links policy of
     * the team or the shared folder (in case the linked file is part of a
     * shared folder) then the {@link LinkPermissions#getResolvedVisibility} of
     * the returned {@link SharedLinkMetadata} will reflect the actual
     * visibility of the shared link and the {@link
     * LinkPermissions#getRequestedVisibility} will reflect the requested
     * visibility. </p>
     *
     * @param url  URL of the shared link to change its settings. Must not be
     *     {@code null}.
     * @param settings  Set of settings for the shared link. Must not be {@code
     *     null}.
     * @param removeExpiration  If set to true, removes the expiration of the
     *     shared link.
     *
     * @return The metadata of a shared link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata modifySharedLinkSettings(String url, SharedLinkSettings settings, boolean removeExpiration) throws ModifySharedLinkSettingsErrorException, DbxException {
        ModifySharedLinkSettingsArgs _arg = new ModifySharedLinkSettingsArgs(url, settings, removeExpiration);
        return modifySharedLinkSettings(_arg);
    }

    //
    // route 2/sharing/mount_folder
    //

    /**
     * The current user mounts the designated folder. Mount a shared folder for
     * a user after they have been added as a member. Once mounted, the shared
     * folder will appear in their Dropbox.
     *
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     */
    SharedFolderMetadata mountFolder(MountFolderArg arg) throws MountFolderErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/mount_folder",
                                        arg,
                                        false,
                                        MountFolderArg.Serializer.INSTANCE,
                                        SharedFolderMetadata.Serializer.INSTANCE,
                                        MountFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new MountFolderErrorException("2/sharing/mount_folder", ex.getRequestId(), ex.getUserMessage(), (MountFolderError) ex.getErrorValue());
        }
    }

    /**
     * The current user mounts the designated folder.
     *
     * <p> Mount a shared folder for a user after they have been added as a
     * member. Once mounted, the shared folder will appear in their Dropbox.
     * </p>
     *
     * @param sharedFolderId  The ID of the shared folder to mount. Must match
     *     pattern "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata mountFolder(String sharedFolderId) throws MountFolderErrorException, DbxException {
        MountFolderArg _arg = new MountFolderArg(sharedFolderId);
        return mountFolder(_arg);
    }

    //
    // route 2/sharing/relinquish_file_membership
    //

    /**
     * The current user relinquishes their membership in the designated file.
     * Note that the current user may still have inherited access to this file
     * through the parent folder.
     *
     */
    void relinquishFileMembership(RelinquishFileMembershipArg arg) throws RelinquishFileMembershipErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/sharing/relinquish_file_membership",
                                 arg,
                                 false,
                                 RelinquishFileMembershipArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 RelinquishFileMembershipError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RelinquishFileMembershipErrorException("2/sharing/relinquish_file_membership", ex.getRequestId(), ex.getUserMessage(), (RelinquishFileMembershipError) ex.getErrorValue());
        }
    }

    /**
     * The current user relinquishes their membership in the designated file.
     * Note that the current user may still have inherited access to this file
     * through the parent folder.
     *
     * @param file  The path or id for the file. Must have length of at least 1,
     *     match pattern "{@code ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}",
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void relinquishFileMembership(String file) throws RelinquishFileMembershipErrorException, DbxException {
        RelinquishFileMembershipArg _arg = new RelinquishFileMembershipArg(file);
        relinquishFileMembership(_arg);
    }

    //
    // route 2/sharing/relinquish_folder_membership
    //

    /**
     * The current user relinquishes their membership in the designated shared
     * folder and will no longer have access to the folder.  A folder owner
     * cannot relinquish membership in their own folder. This will run
     * synchronously if leave_a_copy is false, and asynchronously if
     * leave_a_copy is true.
     *
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     */
    LaunchEmptyResult relinquishFolderMembership(RelinquishFolderMembershipArg arg) throws RelinquishFolderMembershipErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/relinquish_folder_membership",
                                        arg,
                                        false,
                                        RelinquishFolderMembershipArg.Serializer.INSTANCE,
                                        LaunchEmptyResult.Serializer.INSTANCE,
                                        RelinquishFolderMembershipError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RelinquishFolderMembershipErrorException("2/sharing/relinquish_folder_membership", ex.getRequestId(), ex.getUserMessage(), (RelinquishFolderMembershipError) ex.getErrorValue());
        }
    }

    /**
     * The current user relinquishes their membership in the designated shared
     * folder and will no longer have access to the folder.  A folder owner
     * cannot relinquish membership in their own folder.
     *
     * <p> This will run synchronously if leave_a_copy is false, and
     * asynchronously if leave_a_copy is true. </p>
     *
     * <p> The {@code leaveACopy} request parameter will default to {@code
     * false} (see {@link #relinquishFolderMembership(String,boolean)}). </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LaunchEmptyResult relinquishFolderMembership(String sharedFolderId) throws RelinquishFolderMembershipErrorException, DbxException {
        RelinquishFolderMembershipArg _arg = new RelinquishFolderMembershipArg(sharedFolderId);
        return relinquishFolderMembership(_arg);
    }

    /**
     * The current user relinquishes their membership in the designated shared
     * folder and will no longer have access to the folder.  A folder owner
     * cannot relinquish membership in their own folder.
     *
     * <p> This will run synchronously if leave_a_copy is false, and
     * asynchronously if leave_a_copy is true. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param leaveACopy  Keep a copy of the folder's contents upon
     *     relinquishing membership.
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LaunchEmptyResult relinquishFolderMembership(String sharedFolderId, boolean leaveACopy) throws RelinquishFolderMembershipErrorException, DbxException {
        RelinquishFolderMembershipArg _arg = new RelinquishFolderMembershipArg(sharedFolderId, leaveACopy);
        return relinquishFolderMembership(_arg);
    }

    //
    // route 2/sharing/remove_file_member
    //

    /**
     * Identical to remove_file_member_2 but with less information returned.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
     */
    FileMemberActionIndividualResult removeFileMember(RemoveFileMemberArg arg) throws RemoveFileMemberErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/remove_file_member",
                                        arg,
                                        false,
                                        RemoveFileMemberArg.Serializer.INSTANCE,
                                        FileMemberActionIndividualResult.Serializer.INSTANCE,
                                        RemoveFileMemberError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RemoveFileMemberErrorException("2/sharing/remove_file_member", ex.getRequestId(), ex.getUserMessage(), (RemoveFileMemberError) ex.getErrorValue());
        }
    }

    /**
     * Identical to remove_file_member_2 but with less information returned.
     *
     * @param file  File from which to remove members. Must have length of at
     *     least 1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     * @param member  Member to remove from this file. Note that even if an
     *     email is specified, it may result in the removal of a user (not an
     *     invitee) if the user's main account corresponds to that email
     *     address. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link
     *     DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}
     *     instead.
     */
    @Deprecated
    public FileMemberActionIndividualResult removeFileMember(String file, MemberSelector member) throws RemoveFileMemberErrorException, DbxException {
        RemoveFileMemberArg _arg = new RemoveFileMemberArg(file, member);
        return removeFileMember(_arg);
    }

    //
    // route 2/sharing/remove_file_member_2
    //

    /**
     * Removes a specified member from the file.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#removeFileMember2(String,MemberSelector)}.
     */
    FileMemberRemoveActionResult removeFileMember2(RemoveFileMemberArg arg) throws RemoveFileMemberErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/remove_file_member_2",
                                        arg,
                                        false,
                                        RemoveFileMemberArg.Serializer.INSTANCE,
                                        FileMemberRemoveActionResult.Serializer.INSTANCE,
                                        RemoveFileMemberError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RemoveFileMemberErrorException("2/sharing/remove_file_member_2", ex.getRequestId(), ex.getUserMessage(), (RemoveFileMemberError) ex.getErrorValue());
        }
    }

    /**
     * Removes a specified member from the file.
     *
     * @param file  File from which to remove members. Must have length of at
     *     least 1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     * @param member  Member to remove from this file. Note that even if an
     *     email is specified, it may result in the removal of a user (not an
     *     invitee) if the user's main account corresponds to that email
     *     address. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileMemberRemoveActionResult removeFileMember2(String file, MemberSelector member) throws RemoveFileMemberErrorException, DbxException {
        RemoveFileMemberArg _arg = new RemoveFileMemberArg(file, member);
        return removeFileMember2(_arg);
    }

    //
    // route 2/sharing/remove_folder_member
    //

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to remove another member.
     *
     *
     * @return Result returned by methods that launch an asynchronous job. A
     *     method who may either launch an asynchronous job, or complete the
     *     request synchronously, can use this union by extending it, and adding
     *     a 'complete' field with the type of the synchronous response. See
     *     {@link LaunchEmptyResult} for an example.
     */
    LaunchResultBase removeFolderMember(RemoveFolderMemberArg arg) throws RemoveFolderMemberErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/remove_folder_member",
                                        arg,
                                        false,
                                        RemoveFolderMemberArg.Serializer.INSTANCE,
                                        LaunchResultBase.Serializer.INSTANCE,
                                        RemoveFolderMemberError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RemoveFolderMemberErrorException("2/sharing/remove_folder_member", ex.getRequestId(), ex.getUserMessage(), (RemoveFolderMemberError) ex.getErrorValue());
        }
    }

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to remove another member.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param member  The member to remove from the folder. Must not be {@code
     *     null}.
     * @param leaveACopy  If true, the removed user will keep their copy of the
     *     folder after it's unshared, assuming it was mounted. Otherwise, it
     *     will be removed from their Dropbox. Also, this must be set to false
     *     when kicking a group.
     *
     * @return Result returned by methods that launch an asynchronous job. A
     *     method who may either launch an asynchronous job, or complete the
     *     request synchronously, can use this union by extending it, and adding
     *     a 'complete' field with the type of the synchronous response. See
     *     {@link LaunchEmptyResult} for an example.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LaunchResultBase removeFolderMember(String sharedFolderId, MemberSelector member, boolean leaveACopy) throws RemoveFolderMemberErrorException, DbxException {
        RemoveFolderMemberArg _arg = new RemoveFolderMemberArg(sharedFolderId, member, leaveACopy);
        return removeFolderMember(_arg);
    }

    //
    // route 2/sharing/revoke_shared_link
    //

    /**
     * Revoke a shared link. Note that even after revoking a shared link to a
     * file, the file may be accessible if there are shared links leading to any
     * of the file parent folders. To list all shared links that enable access
     * to a specific file, you can use the {@link
     * DbxUserSharingRequests#listSharedLinks} with the file as the {@link
     * ListSharedLinksArg#getPath} argument.
     *
     */
    void revokeSharedLink(RevokeSharedLinkArg arg) throws RevokeSharedLinkErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/sharing/revoke_shared_link",
                                 arg,
                                 false,
                                 RevokeSharedLinkArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 RevokeSharedLinkError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RevokeSharedLinkErrorException("2/sharing/revoke_shared_link", ex.getRequestId(), ex.getUserMessage(), (RevokeSharedLinkError) ex.getErrorValue());
        }
    }

    /**
     * Revoke a shared link.
     *
     * <p> Note that even after revoking a shared link to a file, the file may
     * be accessible if there are shared links leading to any of the file parent
     * folders. To list all shared links that enable access to a specific file,
     * you can use the {@link DbxUserSharingRequests#listSharedLinks} with the
     * file as the {@link ListSharedLinksArg#getPath} argument. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void revokeSharedLink(String url) throws RevokeSharedLinkErrorException, DbxException {
        RevokeSharedLinkArg _arg = new RevokeSharedLinkArg(url);
        revokeSharedLink(_arg);
    }

    //
    // route 2/sharing/set_access_inheritance
    //

    /**
     * Change the inheritance policy of an existing Shared Folder. Only
     * permitted for shared folders in a shared team root. If a {@link
     * ShareFolderLaunch#getAsyncJobIdValue} is returned, you'll need to call
     * {@link DbxUserSharingRequests#checkShareJobStatus(String)} until the
     * action completes to get the metadata for the folder.
     *
     */
    ShareFolderLaunch setAccessInheritance(SetAccessInheritanceArg arg) throws SetAccessInheritanceErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/set_access_inheritance",
                                        arg,
                                        false,
                                        SetAccessInheritanceArg.Serializer.INSTANCE,
                                        ShareFolderLaunch.Serializer.INSTANCE,
                                        SetAccessInheritanceError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SetAccessInheritanceErrorException("2/sharing/set_access_inheritance", ex.getRequestId(), ex.getUserMessage(), (SetAccessInheritanceError) ex.getErrorValue());
        }
    }

    /**
     * Change the inheritance policy of an existing Shared Folder. Only
     * permitted for shared folders in a shared team root.
     *
     * <p> If a {@link ShareFolderLaunch#getAsyncJobIdValue} is returned, you'll
     * need to call {@link DbxUserSharingRequests#checkShareJobStatus(String)}
     * until the action completes to get the metadata for the folder. </p>
     *
     * <p> The {@code accessInheritance} request parameter will default to
     * {@code AccessInheritance.INHERIT} (see {@link
     * #setAccessInheritance(String,AccessInheritance)}). </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderLaunch setAccessInheritance(String sharedFolderId) throws SetAccessInheritanceErrorException, DbxException {
        SetAccessInheritanceArg _arg = new SetAccessInheritanceArg(sharedFolderId);
        return setAccessInheritance(_arg);
    }

    /**
     * Change the inheritance policy of an existing Shared Folder. Only
     * permitted for shared folders in a shared team root.
     *
     * <p> If a {@link ShareFolderLaunch#getAsyncJobIdValue} is returned, you'll
     * need to call {@link DbxUserSharingRequests#checkShareJobStatus(String)}
     * until the action completes to get the metadata for the folder. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param accessInheritance  The access inheritance settings for the folder.
     *     Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderLaunch setAccessInheritance(String sharedFolderId, AccessInheritance accessInheritance) throws SetAccessInheritanceErrorException, DbxException {
        if (accessInheritance == null) {
            throw new IllegalArgumentException("Required value for 'accessInheritance' is null");
        }
        SetAccessInheritanceArg _arg = new SetAccessInheritanceArg(sharedFolderId, accessInheritance);
        return setAccessInheritance(_arg);
    }

    //
    // route 2/sharing/share_folder
    //

    /**
     * Share a folder with collaborators. Most sharing will be completed
     * synchronously. Large folders will be completed asynchronously. To make
     * testing the async case repeatable, set `ShareFolderArg.force_async`. If a
     * {@link ShareFolderLaunch#getAsyncJobIdValue} is returned, you'll need to
     * call {@link DbxUserSharingRequests#checkShareJobStatus(String)} until the
     * action completes to get the metadata for the folder.
     *
     */
    ShareFolderLaunch shareFolder(ShareFolderArg arg) throws ShareFolderErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/share_folder",
                                        arg,
                                        false,
                                        ShareFolderArg.Serializer.INSTANCE,
                                        ShareFolderLaunch.Serializer.INSTANCE,
                                        ShareFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ShareFolderErrorException("2/sharing/share_folder", ex.getRequestId(), ex.getUserMessage(), (ShareFolderError) ex.getErrorValue());
        }
    }

    /**
     * Share a folder with collaborators.
     *
     * <p> Most sharing will be completed synchronously. Large folders will be
     * completed asynchronously. To make testing the async case repeatable, set
     * `ShareFolderArg.force_async`. </p>
     *
     * <p> If a {@link ShareFolderLaunch#getAsyncJobIdValue} is returned, you'll
     * need to call {@link DbxUserSharingRequests#checkShareJobStatus(String)}
     * until the action completes to get the metadata for the folder. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link ShareFolderBuilder} for more details. </p>
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderLaunch shareFolder(String path) throws ShareFolderErrorException, DbxException {
        ShareFolderArg _arg = new ShareFolderArg(path);
        return shareFolder(_arg);
    }

    /**
     * Share a folder with collaborators. Most sharing will be completed
     * synchronously. Large folders will be completed asynchronously. To make
     * testing the async case repeatable, set `ShareFolderArg.force_async`. If a
     * {@link ShareFolderLaunch#getAsyncJobIdValue} is returned, you'll need to
     * call {@link DbxUserSharingRequests#checkShareJobStatus(String)} until the
     * action completes to get the metadata for the folder.
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderBuilder shareFolderBuilder(String path) {
        ShareFolderArg.Builder argBuilder_ = ShareFolderArg.newBuilder(path);
        return new ShareFolderBuilder(this, argBuilder_);
    }

    //
    // route 2/sharing/transfer_folder
    //

    /**
     * Transfer ownership of a shared folder to a member of the shared folder.
     * User must have {@link AccessLevel#OWNER} access to the shared folder to
     * perform a transfer.
     *
     */
    void transferFolder(TransferFolderArg arg) throws TransferFolderErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/sharing/transfer_folder",
                                 arg,
                                 false,
                                 TransferFolderArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 TransferFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TransferFolderErrorException("2/sharing/transfer_folder", ex.getRequestId(), ex.getUserMessage(), (TransferFolderError) ex.getErrorValue());
        }
    }

    /**
     * Transfer ownership of a shared folder to a member of the shared folder.
     *
     * <p> User must have {@link AccessLevel#OWNER} access to the shared folder
     * to perform a transfer. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param toDropboxId  A account or team member ID to transfer ownership to.
     *     Must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void transferFolder(String sharedFolderId, String toDropboxId) throws TransferFolderErrorException, DbxException {
        TransferFolderArg _arg = new TransferFolderArg(sharedFolderId, toDropboxId);
        transferFolder(_arg);
    }

    //
    // route 2/sharing/unmount_folder
    //

    /**
     * The current user unmounts the designated folder. They can re-mount the
     * folder at a later time using {@link
     * DbxUserSharingRequests#mountFolder(String)}.
     *
     */
    void unmountFolder(UnmountFolderArg arg) throws UnmountFolderErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/sharing/unmount_folder",
                                 arg,
                                 false,
                                 UnmountFolderArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 UnmountFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new UnmountFolderErrorException("2/sharing/unmount_folder", ex.getRequestId(), ex.getUserMessage(), (UnmountFolderError) ex.getErrorValue());
        }
    }

    /**
     * The current user unmounts the designated folder. They can re-mount the
     * folder at a later time using {@link
     * DbxUserSharingRequests#mountFolder(String)}.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void unmountFolder(String sharedFolderId) throws UnmountFolderErrorException, DbxException {
        UnmountFolderArg _arg = new UnmountFolderArg(sharedFolderId);
        unmountFolder(_arg);
    }

    //
    // route 2/sharing/unshare_file
    //

    /**
     * Remove all members from this file. Does not remove inherited members.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#unshareFile(String)}.
     */
    void unshareFile(UnshareFileArg arg) throws UnshareFileErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/sharing/unshare_file",
                                 arg,
                                 false,
                                 UnshareFileArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 UnshareFileError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new UnshareFileErrorException("2/sharing/unshare_file", ex.getRequestId(), ex.getUserMessage(), (UnshareFileError) ex.getErrorValue());
        }
    }

    /**
     * Remove all members from this file. Does not remove inherited members.
     *
     * @param file  The file to unshare. Must have length of at least 1, match
     *     pattern "{@code ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void unshareFile(String file) throws UnshareFileErrorException, DbxException {
        UnshareFileArg _arg = new UnshareFileArg(file);
        unshareFile(_arg);
    }

    //
    // route 2/sharing/unshare_folder
    //

    /**
     * Allows a shared folder owner to unshare the folder. You'll need to call
     * {@link DbxUserSharingRequests#checkJobStatus(String)} to determine if the
     * action has completed successfully.
     *
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     */
    LaunchEmptyResult unshareFolder(UnshareFolderArg arg) throws UnshareFolderErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/unshare_folder",
                                        arg,
                                        false,
                                        UnshareFolderArg.Serializer.INSTANCE,
                                        LaunchEmptyResult.Serializer.INSTANCE,
                                        UnshareFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new UnshareFolderErrorException("2/sharing/unshare_folder", ex.getRequestId(), ex.getUserMessage(), (UnshareFolderError) ex.getErrorValue());
        }
    }

    /**
     * Allows a shared folder owner to unshare the folder.
     *
     * <p> You'll need to call {@link
     * DbxUserSharingRequests#checkJobStatus(String)} to determine if the action
     * has completed successfully. </p>
     *
     * <p> The {@code leaveACopy} request parameter will default to {@code
     * false} (see {@link #unshareFolder(String,boolean)}). </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LaunchEmptyResult unshareFolder(String sharedFolderId) throws UnshareFolderErrorException, DbxException {
        UnshareFolderArg _arg = new UnshareFolderArg(sharedFolderId);
        return unshareFolder(_arg);
    }

    /**
     * Allows a shared folder owner to unshare the folder.
     *
     * <p> You'll need to call {@link
     * DbxUserSharingRequests#checkJobStatus(String)} to determine if the action
     * has completed successfully. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param leaveACopy  If true, members of this shared folder will get a copy
     *     of this folder after it's unshared. Otherwise, it will be removed
     *     from their Dropbox. The current user, who is an owner, will always
     *     retain their copy.
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LaunchEmptyResult unshareFolder(String sharedFolderId, boolean leaveACopy) throws UnshareFolderErrorException, DbxException {
        UnshareFolderArg _arg = new UnshareFolderArg(sharedFolderId, leaveACopy);
        return unshareFolder(_arg);
    }

    //
    // route 2/sharing/update_file_member
    //

    /**
     * Changes a member's access on a shared file.
     *
     * @param arg  Arguments for {@link
     *     DbxUserSharingRequests#updateFileMember(String,MemberSelector,AccessLevel)}.
     *
     * @return Contains information about a member's access level to content
     *     after an operation.
     */
    MemberAccessLevelResult updateFileMember(UpdateFileMemberArgs arg) throws FileMemberActionErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/update_file_member",
                                        arg,
                                        false,
                                        UpdateFileMemberArgs.Serializer.INSTANCE,
                                        MemberAccessLevelResult.Serializer.INSTANCE,
                                        FileMemberActionError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new FileMemberActionErrorException("2/sharing/update_file_member", ex.getRequestId(), ex.getUserMessage(), (FileMemberActionError) ex.getErrorValue());
        }
    }

    /**
     * Changes a member's access on a shared file.
     *
     * @param file  File for which we are changing a member's access. Must have
     *     length of at least 1, match pattern "{@code
     *     ((/|id:).*|nspath:[0-9]+:.*)|ns:[0-9]+(/.*)?}", and not be {@code
     *     null}.
     * @param member  The member whose access we are changing. Must not be
     *     {@code null}.
     * @param accessLevel  The new access level for the member. Must not be
     *     {@code null}.
     *
     * @return Contains information about a member's access level to content
     *     after an operation.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAccessLevelResult updateFileMember(String file, MemberSelector member, AccessLevel accessLevel) throws FileMemberActionErrorException, DbxException {
        UpdateFileMemberArgs _arg = new UpdateFileMemberArgs(file, member, accessLevel);
        return updateFileMember(_arg);
    }

    //
    // route 2/sharing/update_folder_member
    //

    /**
     * Allows an owner or editor of a shared folder to update another member's
     * permissions.
     *
     *
     * @return Contains information about a member's access level to content
     *     after an operation.
     */
    MemberAccessLevelResult updateFolderMember(UpdateFolderMemberArg arg) throws UpdateFolderMemberErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/update_folder_member",
                                        arg,
                                        false,
                                        UpdateFolderMemberArg.Serializer.INSTANCE,
                                        MemberAccessLevelResult.Serializer.INSTANCE,
                                        UpdateFolderMemberError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new UpdateFolderMemberErrorException("2/sharing/update_folder_member", ex.getRequestId(), ex.getUserMessage(), (UpdateFolderMemberError) ex.getErrorValue());
        }
    }

    /**
     * Allows an owner or editor of a shared folder to update another member's
     * permissions.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param member  The member of the shared folder to update.  Only the
     *     {@link MemberSelector#getDropboxIdValue} may be set at this time.
     *     Must not be {@code null}.
     * @param accessLevel  The new access level for {@link
     *     UpdateFolderMemberArg#getMember}. {@link AccessLevel#OWNER} is
     *     disallowed. Must not be {@code null}.
     *
     * @return Contains information about a member's access level to content
     *     after an operation.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MemberAccessLevelResult updateFolderMember(String sharedFolderId, MemberSelector member, AccessLevel accessLevel) throws UpdateFolderMemberErrorException, DbxException {
        UpdateFolderMemberArg _arg = new UpdateFolderMemberArg(sharedFolderId, member, accessLevel);
        return updateFolderMember(_arg);
    }

    //
    // route 2/sharing/update_folder_policy
    //

    /**
     * Update the sharing policies for a shared folder. User must have {@link
     * AccessLevel#OWNER} access to the shared folder to update its policies.
     *
     * @param arg  If any of the policies are unset, then they retain their
     *     current setting.
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     */
    SharedFolderMetadata updateFolderPolicy(UpdateFolderPolicyArg arg) throws UpdateFolderPolicyErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/sharing/update_folder_policy",
                                        arg,
                                        false,
                                        UpdateFolderPolicyArg.Serializer.INSTANCE,
                                        SharedFolderMetadata.Serializer.INSTANCE,
                                        UpdateFolderPolicyError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new UpdateFolderPolicyErrorException("2/sharing/update_folder_policy", ex.getRequestId(), ex.getUserMessage(), (UpdateFolderPolicyError) ex.getErrorValue());
        }
    }

    /**
     * Update the sharing policies for a shared folder.
     *
     * <p> User must have {@link AccessLevel#OWNER} access to the shared folder
     * to update its policies. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata updateFolderPolicy(String sharedFolderId) throws UpdateFolderPolicyErrorException, DbxException {
        UpdateFolderPolicyArg _arg = new UpdateFolderPolicyArg(sharedFolderId);
        return updateFolderPolicy(_arg);
    }

    /**
     * Update the sharing policies for a shared folder. User must have {@link
     * AccessLevel#OWNER} access to the shared folder to update its policies.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateFolderPolicyBuilder updateFolderPolicyBuilder(String sharedFolderId) {
        UpdateFolderPolicyArg.Builder argBuilder_ = UpdateFolderPolicyArg.newBuilder(sharedFolderId);
        return new UpdateFolderPolicyBuilder(this, argBuilder_);
    }
}
