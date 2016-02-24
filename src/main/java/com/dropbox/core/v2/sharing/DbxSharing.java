/* DO NOT EDIT */
/* This file was generated from shared_links.babel, sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.v2.DbxDownloadStyleBuilder;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.async.LaunchEmptyResult;
import com.dropbox.core.v2.async.PollArg;
import com.dropbox.core.v2.async.PollErrorException;

/**
 * Routes in namespace "sharing".
 */
public final class DbxSharing {
    // namespace sharing

    private final DbxRawClientV2 client;

    public DbxSharing(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route sharing/get_shared_link_metadata
    //

    /**
     * Get the shared link's metadata.
     *
     *
     * @return The metadata of a shared link
     */
     SharedLinkMetadata getSharedLinkMetadata(GetSharedLinkMetadataArg getSharedLinkMetadataArg) throws SharedLinkErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/get_shared_link_metadata",
                                   getSharedLinkMetadataArg,
                                   false,
                                   GetSharedLinkMetadataArg._JSON_WRITER,
                                   SharedLinkMetadata._JSON_READER,
                                   SharedLinkError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new SharedLinkErrorException(ew.getRequestId(), ew.getUserMessage(), (SharedLinkError) ew.getErrorValue());
        }
    }

    /**
     * Get the shared link's metadata.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link GetSharedLinkMetadataArg} for more details. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @return The metadata of a shared link
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata getSharedLinkMetadata(String url) throws SharedLinkErrorException, DbxException {
        GetSharedLinkMetadataArg arg = new GetSharedLinkMetadataArg(url);
        return getSharedLinkMetadata(arg);
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
        GetSharedLinkMetadataArg.Builder argBuilder = GetSharedLinkMetadataArg.newBuilder(url);
        return new GetSharedLinkMetadataBuilder(this, argBuilder);
    }

    //
    // route sharing/list_shared_links
    //

    /**
     * List shared links of this user. If no path is given or the path is empty,
     * returns a list of all shared links for the current user. If a non-empty
     * path is given, returns a list of all shared links that allow access to
     * the given path - direct links to the given path and links to parent
     * folders of the given path. Links to parent folders can be suppressed by
     * setting direct_only to true.
     *
     */
     ListSharedLinksResult listSharedLinks(ListSharedLinksArg listSharedLinksArg) throws ListSharedLinksErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/list_shared_links",
                                   listSharedLinksArg,
                                   false,
                                   ListSharedLinksArg._JSON_WRITER,
                                   ListSharedLinksResult._JSON_READER,
                                   ListSharedLinksError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListSharedLinksErrorException(ew.getRequestId(), ew.getUserMessage(), (ListSharedLinksError) ew.getErrorValue());
        }
    }

    /**
     * List shared links of this user. If no path is given or the path is empty,
     * returns a list of all shared links for the current user. If a non-empty
     * path is given, returns a list of all shared links that allow access to
     * the given path - direct links to the given path and links to parent
     * folders of the given path. Links to parent folders can be suppressed by
     * setting direct_only to true.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListSharedLinksArg} for more details. </p>
     */
    public ListSharedLinksResult listSharedLinks() throws ListSharedLinksErrorException, DbxException {
        ListSharedLinksArg arg = new ListSharedLinksArg();
        return listSharedLinks(arg);
    }

    /**
     * List shared links of this user. If no path is given or the path is empty,
     * returns a list of all shared links for the current user. If a non-empty
     * path is given, returns a list of all shared links that allow access to
     * the given path - direct links to the given path and links to parent
     * folders of the given path. Links to parent folders can be suppressed by
     * setting direct_only to true.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ListSharedLinksBuilder listSharedLinksBuilder() {
        ListSharedLinksArg.Builder argBuilder = ListSharedLinksArg.newBuilder();
        return new ListSharedLinksBuilder(this, argBuilder);
    }

    //
    // route sharing/modify_shared_link_settings
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
     * @return The metadata of a shared link
     */
     SharedLinkMetadata modifySharedLinkSettings(ModifySharedLinkSettingsArgs modifySharedLinkSettingsArgs) throws ModifySharedLinkSettingsErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/modify_shared_link_settings",
                                   modifySharedLinkSettingsArgs,
                                   false,
                                   ModifySharedLinkSettingsArgs._JSON_WRITER,
                                   SharedLinkMetadata._JSON_READER,
                                   ModifySharedLinkSettingsError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ModifySharedLinkSettingsErrorException(ew.getRequestId(), ew.getUserMessage(), (ModifySharedLinkSettingsError) ew.getErrorValue());
        }
    }

    /**
     * Modify the shared link's settings. If the requested visibility conflict
     * with the shared links policy of the team or the shared folder (in case
     * the linked file is part of a shared folder) then the {@link
     * LinkPermissions#getResolvedVisibility} of the returned {@link
     * SharedLinkMetadata} will reflect the actual visibility of the shared link
     * and the {@link LinkPermissions#getRequestedVisibility} will reflect the
     * requested visibility.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ModifySharedLinkSettingsArgs} for more details. </p>
     *
     * @param url  URL of the shared link to change its settings. Must not be
     *     {@code null}.
     * @param settings  Set of settings for the shared link. Must not be {@code
     *     null}.
     *
     * @return The metadata of a shared link
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata modifySharedLinkSettings(String url, SharedLinkSettings settings) throws ModifySharedLinkSettingsErrorException, DbxException {
        ModifySharedLinkSettingsArgs arg = new ModifySharedLinkSettingsArgs(url, settings);
        return modifySharedLinkSettings(arg);
    }

    //
    // route sharing/create_shared_link_with_settings
    //

    /**
     * Create a shared link with custom settings. If no settings are given then
     * the default visibility is {@link RequestedVisibility#PUBLIC} (The
     * resolved visibility, though, may depend on other aspects such as team and
     * shared folder settings).
     *
     *
     * @return The metadata of a shared link
     */
     SharedLinkMetadata createSharedLinkWithSettings(CreateSharedLinkWithSettingsArg createSharedLinkWithSettingsArg) throws CreateSharedLinkWithSettingsErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/create_shared_link_with_settings",
                                   createSharedLinkWithSettingsArg,
                                   false,
                                   CreateSharedLinkWithSettingsArg._JSON_WRITER,
                                   SharedLinkMetadata._JSON_READER,
                                   CreateSharedLinkWithSettingsError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CreateSharedLinkWithSettingsErrorException(ew.getRequestId(), ew.getUserMessage(), (CreateSharedLinkWithSettingsError) ew.getErrorValue());
        }
    }

    /**
     * Create a shared link with custom settings. If no settings are given then
     * the default visibility is {@link RequestedVisibility#PUBLIC} (The
     * resolved visibility, though, may depend on other aspects such as team and
     * shared folder settings).
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link CreateSharedLinkWithSettingsArg} for more details. </p>
     *
     * @param path  The path to be shared by the shared link. Must match pattern
     *     "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     *
     * @return The metadata of a shared link
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata createSharedLinkWithSettings(String path) throws CreateSharedLinkWithSettingsErrorException, DbxException {
        CreateSharedLinkWithSettingsArg arg = new CreateSharedLinkWithSettingsArg(path);
        return createSharedLinkWithSettings(arg);
    }

    /**
     * Create a shared link with custom settings. If no settings are given then
     * the default visibility is {@link RequestedVisibility#PUBLIC} (The
     * resolved visibility, though, may depend on other aspects such as team and
     * shared folder settings).
     *
     * @param path  The path to be shared by the shared link. Must match pattern
     *     "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     * @param settings  The requested settings for the newly created shared
     *     link.
     *
     * @return The metadata of a shared link
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedLinkMetadata createSharedLinkWithSettings(String path, SharedLinkSettings settings) throws CreateSharedLinkWithSettingsErrorException, DbxException {
        CreateSharedLinkWithSettingsArg arg = new CreateSharedLinkWithSettingsArg(path, settings);
        return createSharedLinkWithSettings(arg);
    }

    //
    // route sharing/revoke_shared_link
    //

    /**
     * Revoke a shared link. Note that even after revoking a shared link to a
     * file, the file may be accessible if there are shared links leading to any
     * of the file parent folders. To list all shared links that enable access
     * to a specific file, you can use the {@link DbxSharing#listSharedLinks()}
     * with the file as the {@link ListSharedLinksArg#getPath} argument.
     *
     */
     void revokeSharedLink(RevokeSharedLinkArg revokeSharedLinkArg) throws RevokeSharedLinkErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/sharing/revoke_shared_link",
                            revokeSharedLinkArg,
                            false,
                            RevokeSharedLinkArg._JSON_WRITER,
                            JsonReader.VoidReader,
                            RevokeSharedLinkError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RevokeSharedLinkErrorException(ew.getRequestId(), ew.getUserMessage(), (RevokeSharedLinkError) ew.getErrorValue());
        }
    }

    /**
     * Revoke a shared link. Note that even after revoking a shared link to a
     * file, the file may be accessible if there are shared links leading to any
     * of the file parent folders. To list all shared links that enable access
     * to a specific file, you can use the {@link DbxSharing#listSharedLinks()}
     * with the file as the {@link ListSharedLinksArg#getPath} argument.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link RevokeSharedLinkArg} for more details. </p>
     *
     * @param url  URL of the shared link. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void revokeSharedLink(String url) throws RevokeSharedLinkErrorException, DbxException {
        RevokeSharedLinkArg arg = new RevokeSharedLinkArg(url);
        revokeSharedLink(arg);
    }

    //
    // route sharing/get_shared_link_file
    //

    /**
     * Download the shared link's file from a user's Dropbox.
     *
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
     DbxDownloader<SharedLinkMetadata> getSharedLinkFile(GetSharedLinkMetadataArg getSharedLinkMetadataArg) throws GetSharedLinkFileErrorException, DbxException {
        try {
            return client.downloadStyle(client.getHost().getContent(),
                                        "2/sharing/get_shared_link_file",
                                        getSharedLinkMetadataArg,
                                        false,
                                        GetSharedLinkMetadataArg._JSON_WRITER,
                                        SharedLinkMetadata._JSON_READER,
                                        GetSharedLinkFileError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetSharedLinkFileErrorException(ew.getRequestId(), ew.getUserMessage(), (GetSharedLinkFileError) ew.getErrorValue());
        }
    }

    /**
     * Download the shared link's file from a user's Dropbox.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link GetSharedLinkMetadataArg} for more details. </p>
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
        GetSharedLinkMetadataArg arg = new GetSharedLinkMetadataArg(url);
        return getSharedLinkFile(arg);
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
        GetSharedLinkMetadataArg.Builder argBuilder = GetSharedLinkMetadataArg.newBuilder(url);
        return new GetSharedLinkFileBuilder(this, argBuilder);
    }

    //
    // route sharing/get_shared_links
    //

    /**
     * Returns a list of {@link LinkMetadata} objects for this user, including
     * collection links. If no path is given or the path is empty, returns a
     * list of all shared links for the current user, including collection
     * links. If a non-empty path is given, returns a list of all shared links
     * that allow access to the given path.  Collection links are never returned
     * in this case. Note that the url field in the response is never the
     * shortened URL.
     *
     */
     GetSharedLinksResult getSharedLinks(GetSharedLinksArg getSharedLinksArg) throws GetSharedLinksErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/get_shared_links",
                                   getSharedLinksArg,
                                   false,
                                   GetSharedLinksArg._JSON_WRITER,
                                   GetSharedLinksResult._JSON_READER,
                                   GetSharedLinksError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetSharedLinksErrorException(ew.getRequestId(), ew.getUserMessage(), (GetSharedLinksError) ew.getErrorValue());
        }
    }

    /**
     * Returns a list of {@link LinkMetadata} objects for this user, including
     * collection links. If no path is given or the path is empty, returns a
     * list of all shared links for the current user, including collection
     * links. If a non-empty path is given, returns a list of all shared links
     * that allow access to the given path.  Collection links are never returned
     * in this case. Note that the url field in the response is never the
     * shortened URL.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link GetSharedLinksArg} for more details. </p>
     */
    public GetSharedLinksResult getSharedLinks() throws GetSharedLinksErrorException, DbxException {
        GetSharedLinksArg arg = new GetSharedLinksArg();
        return getSharedLinks(arg);
    }

    /**
     * Returns a list of {@link LinkMetadata} objects for this user, including
     * collection links. If no path is given or the path is empty, returns a
     * list of all shared links for the current user, including collection
     * links. If a non-empty path is given, returns a list of all shared links
     * that allow access to the given path.  Collection links are never returned
     * in this case. Note that the url field in the response is never the
     * shortened URL.
     *
     * @param path  See {@link DbxSharing#getSharedLinks()} description.
     */
    public GetSharedLinksResult getSharedLinks(String path) throws GetSharedLinksErrorException, DbxException {
        GetSharedLinksArg arg = new GetSharedLinksArg(path);
        return getSharedLinks(arg);
    }

    //
    // route sharing/create_shared_link
    //

    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the {@link LinkMetadata#getUrl} field is the shortened
     * URL if {@link CreateSharedLinkArg#getShortUrl} argument is set to {@code
     * true}. Previously, it was technically possible to break a shared link by
     * moving or renaming the corresponding file or folder. In the future, this
     * will no longer be the case, so your app shouldn't rely on this behavior.
     * Instead, if your app needs to revoke a shared link, use {@link
     * DbxSharing#revokeSharedLink(String)}.
     *
     *
     * @return Metadata for a path-based shared link.
     */
     PathLinkMetadata createSharedLink(CreateSharedLinkArg createSharedLinkArg) throws CreateSharedLinkErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/create_shared_link",
                                   createSharedLinkArg,
                                   false,
                                   CreateSharedLinkArg._JSON_WRITER,
                                   PathLinkMetadata._JSON_READER,
                                   CreateSharedLinkError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CreateSharedLinkErrorException(ew.getRequestId(), ew.getUserMessage(), (CreateSharedLinkError) ew.getErrorValue());
        }
    }

    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the {@link LinkMetadata#getUrl} field is the shortened
     * URL if {@link CreateSharedLinkArg#getShortUrl} argument is set to {@code
     * true}. Previously, it was technically possible to break a shared link by
     * moving or renaming the corresponding file or folder. In the future, this
     * will no longer be the case, so your app shouldn't rely on this behavior.
     * Instead, if your app needs to revoke a shared link, use {@link
     * DbxSharing#revokeSharedLink(String)}.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link CreateSharedLinkArg} for more details. </p>
     *
     * @param path  The path to share. Must not be {@code null}.
     *
     * @return Metadata for a path-based shared link.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PathLinkMetadata createSharedLink(String path) throws CreateSharedLinkErrorException, DbxException {
        CreateSharedLinkArg arg = new CreateSharedLinkArg(path);
        return createSharedLink(arg);
    }

    /**
     * Create a shared link. If a shared link already exists for the given path,
     * that link is returned. Note that in the returned {@link
     * PathLinkMetadata}, the {@link LinkMetadata#getUrl} field is the shortened
     * URL if {@link CreateSharedLinkArg#getShortUrl} argument is set to {@code
     * true}. Previously, it was technically possible to break a shared link by
     * moving or renaming the corresponding file or folder. In the future, this
     * will no longer be the case, so your app shouldn't rely on this behavior.
     * Instead, if your app needs to revoke a shared link, use {@link
     * DbxSharing#revokeSharedLink(String)}.
     *
     * @param path  The path to share. Must not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateSharedLinkBuilder createSharedLinkBuilder(String path) {
        CreateSharedLinkArg.Builder argBuilder = CreateSharedLinkArg.newBuilder(path);
        return new CreateSharedLinkBuilder(this, argBuilder);
    }

    //
    // route sharing/list_folders
    //

    /**
     * Return the list of all shared folders the current user has access to.
     * Apps must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     *
     * @return Result for {@link DbxSharing#listFolders()}. Unmounted shared
     *     folders can be identified by the absence of {@link
     *     SharedFolderMetadata#getPathLower}.
     */
     ListFoldersResult listFolders(ListFoldersArgs listFoldersArgs) throws DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/list_folders",
                                   listFoldersArgs,
                                   false,
                                   ListFoldersArgs._JSON_WRITER,
                                   ListFoldersResult._JSON_READER,
                                   JsonReader.VoidReader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DbxApiException(ew.getRequestId(), ew.getUserMessage(), "Unexpected error response for \"list_folders\": ew.errValue");
        }
    }

    /**
     * Return the list of all shared folders the current user has access to.
     * Apps must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListFoldersArgs} for more details. </p>
     *
     * @return Result for {@link DbxSharing#listFolders()}. Unmounted shared
     *     folders can be identified by the absence of {@link
     *     SharedFolderMetadata#getPathLower}.
     */
    public ListFoldersResult listFolders() throws DbxException {
        ListFoldersArgs arg = new ListFoldersArgs();
        return listFolders(arg);
    }

    /**
     * Return the list of all shared folders the current user has access to.
     * Apps must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ListFoldersBuilder listFoldersBuilder() {
        ListFoldersArgs.Builder argBuilder = ListFoldersArgs.newBuilder();
        return new ListFoldersBuilder(this, argBuilder);
    }

    //
    // route sharing/list_folders/continue
    //

    /**
     * Once a cursor has been retrieved from {@link DbxSharing#listFolders()},
     * use this to paginate through all shared folders. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     *
     * @return Result for {@link DbxSharing#listFolders()}. Unmounted shared
     *     folders can be identified by the absence of {@link
     *     SharedFolderMetadata#getPathLower}.
     */
     ListFoldersResult listFoldersContinue(ListFoldersContinueArg listFoldersContinueArg) throws ListFoldersContinueErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/list_folders/continue",
                                   listFoldersContinueArg,
                                   false,
                                   ListFoldersContinueArg._JSON_WRITER,
                                   ListFoldersResult._JSON_READER,
                                   ListFoldersContinueError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFoldersContinueErrorException(ew.getRequestId(), ew.getUserMessage(), (ListFoldersContinueError) ew.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link DbxSharing#listFolders()},
     * use this to paginate through all shared folders. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListFoldersContinueArg} for more details. </p>
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxSharing#listFolders()} or {@link
     *     DbxSharing#listFoldersContinue(String)}. Must not be {@code null}.
     *
     * @return Result for {@link DbxSharing#listFolders()}. Unmounted shared
     *     folders can be identified by the absence of {@link
     *     SharedFolderMetadata#getPathLower}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFoldersResult listFoldersContinue(String cursor) throws ListFoldersContinueErrorException, DbxException {
        ListFoldersContinueArg arg = new ListFoldersContinueArg(cursor);
        return listFoldersContinue(arg);
    }

    //
    // route sharing/list_mountable_folders
    //

    /**
     * Return the list of all shared folders the current user can mount or
     * unmount. Apps must have full Dropbox access to use this endpoint.
     *
     *
     * @return Result for {@link DbxSharing#listFolders()}. Unmounted shared
     *     folders can be identified by the absence of {@link
     *     SharedFolderMetadata#getPathLower}.
     */
     ListFoldersResult listMountableFolders(ListFoldersArgs listFoldersArgs) throws DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/list_mountable_folders",
                                   listFoldersArgs,
                                   false,
                                   ListFoldersArgs._JSON_WRITER,
                                   ListFoldersResult._JSON_READER,
                                   JsonReader.VoidReader);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DbxApiException(ew.getRequestId(), ew.getUserMessage(), "Unexpected error response for \"list_mountable_folders\": ew.errValue");
        }
    }

    /**
     * Return the list of all shared folders the current user can mount or
     * unmount. Apps must have full Dropbox access to use this endpoint.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListFoldersArgs} for more details. </p>
     *
     * @return Result for {@link DbxSharing#listFolders()}. Unmounted shared
     *     folders can be identified by the absence of {@link
     *     SharedFolderMetadata#getPathLower}.
     */
    public ListFoldersResult listMountableFolders() throws DbxException {
        ListFoldersArgs arg = new ListFoldersArgs();
        return listMountableFolders(arg);
    }

    /**
     * Return the list of all shared folders the current user can mount or
     * unmount. Apps must have full Dropbox access to use this endpoint.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     */
    public ListMountableFoldersBuilder listMountableFoldersBuilder() {
        ListFoldersArgs.Builder argBuilder = ListFoldersArgs.newBuilder();
        return new ListMountableFoldersBuilder(this, argBuilder);
    }

    //
    // route sharing/list_mountable_folders/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxSharing#listMountableFolders()}, use this to paginate through all
     * mountable shared folders. Apps must have full Dropbox access to use this
     * endpoint.
     *
     *
     * @return Result for {@link DbxSharing#listFolders()}. Unmounted shared
     *     folders can be identified by the absence of {@link
     *     SharedFolderMetadata#getPathLower}.
     */
     ListFoldersResult listMountableFoldersContinue(ListFoldersContinueArg listFoldersContinueArg) throws ListFoldersContinueErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/list_mountable_folders/continue",
                                   listFoldersContinueArg,
                                   false,
                                   ListFoldersContinueArg._JSON_WRITER,
                                   ListFoldersResult._JSON_READER,
                                   ListFoldersContinueError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFoldersContinueErrorException(ew.getRequestId(), ew.getUserMessage(), (ListFoldersContinueError) ew.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxSharing#listMountableFolders()}, use this to paginate through all
     * mountable shared folders. Apps must have full Dropbox access to use this
     * endpoint.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListFoldersContinueArg} for more details. </p>
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxSharing#listFolders()} or {@link
     *     DbxSharing#listFoldersContinue(String)}. Must not be {@code null}.
     *
     * @return Result for {@link DbxSharing#listFolders()}. Unmounted shared
     *     folders can be identified by the absence of {@link
     *     SharedFolderMetadata#getPathLower}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFoldersResult listMountableFoldersContinue(String cursor) throws ListFoldersContinueErrorException, DbxException {
        ListFoldersContinueArg arg = new ListFoldersContinueArg(cursor);
        return listMountableFoldersContinue(arg);
    }

    //
    // route sharing/get_folder_metadata
    //

    /**
     * Returns shared folder metadata by its folder ID. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     */
     SharedFolderMetadata getFolderMetadata(GetMetadataArgs getMetadataArgs) throws SharedFolderAccessErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/get_folder_metadata",
                                   getMetadataArgs,
                                   false,
                                   GetMetadataArgs._JSON_WRITER,
                                   SharedFolderMetadata._JSON_READER,
                                   SharedFolderAccessError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new SharedFolderAccessErrorException(ew.getRequestId(), ew.getUserMessage(), (SharedFolderAccessError) ew.getErrorValue());
        }
    }

    /**
     * Returns shared folder metadata by its folder ID. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link GetMetadataArgs} for more details. </p>
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
        GetMetadataArgs arg = new GetMetadataArgs(sharedFolderId);
        return getFolderMetadata(arg);
    }

    /**
     * Returns shared folder metadata by its folder ID. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param actions  Folder actions to query. This field is optional. Must not
     *     contain a {@code null} item.
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMetadata getFolderMetadata(String sharedFolderId, java.util.List<FolderAction> actions) throws SharedFolderAccessErrorException, DbxException {
        if (actions != null) {
            for (FolderAction x : actions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'actions' is null");
                }
            }
        }
        GetMetadataArgs arg = new GetMetadataArgs(sharedFolderId, actions);
        return getFolderMetadata(arg);
    }

    //
    // route sharing/list_folder_members
    //

    /**
     * Returns shared folder membership by its folder ID. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     *
     * @return Shared folder user and group membership.
     */
     SharedFolderMembers listFolderMembers(ListFolderMembersArgs listFolderMembersArgs) throws SharedFolderAccessErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/list_folder_members",
                                   listFolderMembersArgs,
                                   false,
                                   ListFolderMembersArgs._JSON_WRITER,
                                   SharedFolderMembers._JSON_READER,
                                   SharedFolderAccessError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new SharedFolderAccessErrorException(ew.getRequestId(), ew.getUserMessage(), (SharedFolderAccessError) ew.getErrorValue());
        }
    }

    /**
     * Returns shared folder membership by its folder ID. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListFolderMembersArgs} for more details. </p>
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
        ListFolderMembersArgs arg = new ListFolderMembersArgs(sharedFolderId);
        return listFolderMembers(arg);
    }

    /**
     * Returns shared folder membership by its folder ID. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
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
        ListFolderMembersArgs.Builder argBuilder = ListFolderMembersArgs.newBuilder(sharedFolderId);
        return new ListFolderMembersBuilder(this, argBuilder);
    }

    //
    // route sharing/list_folder_members/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxSharing#listFolderMembers(String)}, use this to paginate through all
     * shared folder members. Apps must have full Dropbox access to use this
     * endpoint. Warning: This endpoint is in beta and is subject to minor but
     * possibly backwards-incompatible changes.
     *
     *
     * @return Shared folder user and group membership.
     */
     SharedFolderMembers listFolderMembersContinue(ListFolderMembersContinueArg listFolderMembersContinueArg) throws ListFolderMembersContinueErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/list_folder_members/continue",
                                   listFolderMembersContinueArg,
                                   false,
                                   ListFolderMembersContinueArg._JSON_WRITER,
                                   SharedFolderMembers._JSON_READER,
                                   ListFolderMembersContinueError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderMembersContinueErrorException(ew.getRequestId(), ew.getUserMessage(), (ListFolderMembersContinueError) ew.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxSharing#listFolderMembers(String)}, use this to paginate through all
     * shared folder members. Apps must have full Dropbox access to use this
     * endpoint. Warning: This endpoint is in beta and is subject to minor but
     * possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListFolderMembersContinueArg} for more details. </p>
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxSharing#listFolderMembers(String)} or {@link
     *     DbxSharing#listFolderMembersContinue(String)}. Must not be {@code
     *     null}.
     *
     * @return Shared folder user and group membership.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharedFolderMembers listFolderMembersContinue(String cursor) throws ListFolderMembersContinueErrorException, DbxException {
        ListFolderMembersContinueArg arg = new ListFolderMembersContinueArg(cursor);
        return listFolderMembersContinue(arg);
    }

    //
    // route sharing/share_folder
    //

    /**
     * Share a folder with collaborators. Most sharing will be completed
     * synchronously. Large folders will be completed asynchronously. To make
     * testing the async case repeatable, set `ShareFolderArg.force_async`. If a
     * {@link ShareFolderLaunch#asyncJobId} is returned, you'll need to call
     * {@link DbxSharing#checkShareJobStatus(String)} until the action completes
     * to get the metadata for the folder. Apps must have full Dropbox access to
     * use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     */
     ShareFolderLaunch shareFolder(ShareFolderArg shareFolderArg) throws ShareFolderErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/share_folder",
                                   shareFolderArg,
                                   false,
                                   ShareFolderArg._JSON_WRITER,
                                   ShareFolderLaunch._JSON_READER,
                                   ShareFolderError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ShareFolderErrorException(ew.getRequestId(), ew.getUserMessage(), (ShareFolderError) ew.getErrorValue());
        }
    }

    /**
     * Share a folder with collaborators. Most sharing will be completed
     * synchronously. Large folders will be completed asynchronously. To make
     * testing the async case repeatable, set `ShareFolderArg.force_async`. If a
     * {@link ShareFolderLaunch#asyncJobId} is returned, you'll need to call
     * {@link DbxSharing#checkShareJobStatus(String)} until the action completes
     * to get the metadata for the folder. Apps must have full Dropbox access to
     * use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ShareFolderArg} for more details. </p>
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. Must match pattern "{@code /.*}" and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderLaunch shareFolder(String path) throws ShareFolderErrorException, DbxException {
        ShareFolderArg arg = new ShareFolderArg(path);
        return shareFolder(arg);
    }

    /**
     * Share a folder with collaborators. Most sharing will be completed
     * synchronously. Large folders will be completed asynchronously. To make
     * testing the async case repeatable, set `ShareFolderArg.force_async`. If a
     * {@link ShareFolderLaunch#asyncJobId} is returned, you'll need to call
     * {@link DbxSharing#checkShareJobStatus(String)} until the action completes
     * to get the metadata for the folder. Apps must have full Dropbox access to
     * use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     * @param path  The path to the folder to share. If it does not exist, then
     *     a new one is created. Must match pattern "{@code /.*}" and not be
     *     {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderBuilder shareFolderBuilder(String path) {
        ShareFolderArg.Builder argBuilder = ShareFolderArg.newBuilder(path);
        return new ShareFolderBuilder(this, argBuilder);
    }

    //
    // route sharing/check_share_job_status
    //

    /**
     * Returns the status of an asynchronous job for sharing a folder. Apps must
     * have full Dropbox access to use this endpoint. Warning: This endpoint is
     * in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     *
     * @param pollArg  Arguments for methods that poll the status of an
     *     asynchronous job.
     */
     ShareFolderJobStatus checkShareJobStatus(PollArg pollArg) throws PollErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/check_share_job_status",
                                   pollArg,
                                   false,
                                   PollArg._JSON_WRITER,
                                   ShareFolderJobStatus._JSON_READER,
                                   com.dropbox.core.v2.async.PollError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new PollErrorException(ew.getRequestId(), ew.getUserMessage(), (com.dropbox.core.v2.async.PollError) ew.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for sharing a folder. Apps must
     * have full Dropbox access to use this endpoint. Warning: This endpoint is
     * in beta and is subject to minor but possibly backwards-incompatible
     * changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link PollArg} for more details. </p>
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ShareFolderJobStatus checkShareJobStatus(String asyncJobId) throws PollErrorException, DbxException {
        PollArg arg = new PollArg(asyncJobId);
        return checkShareJobStatus(arg);
    }

    //
    // route sharing/check_job_status
    //

    /**
     * Returns the status of an asynchronous job. Apps must have full Dropbox
     * access to use this endpoint. Warning: This endpoint is in beta and is
     * subject to minor but possibly backwards-incompatible changes.
     *
     * @param pollArg  Arguments for methods that poll the status of an
     *     asynchronous job.
     */
     JobStatus checkJobStatus(PollArg pollArg) throws PollErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/check_job_status",
                                   pollArg,
                                   false,
                                   PollArg._JSON_WRITER,
                                   JobStatus._JSON_READER,
                                   com.dropbox.core.v2.async.PollError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new PollErrorException(ew.getRequestId(), ew.getUserMessage(), (com.dropbox.core.v2.async.PollError) ew.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job. Apps must have full Dropbox
     * access to use this endpoint. Warning: This endpoint is in beta and is
     * subject to minor but possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link PollArg} for more details. </p>
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public JobStatus checkJobStatus(String asyncJobId) throws PollErrorException, DbxException {
        PollArg arg = new PollArg(asyncJobId);
        return checkJobStatus(arg);
    }

    //
    // route sharing/unshare_folder
    //

    /**
     * Allows a shared folder owner to unshare the folder. You'll need to call
     * {@link DbxSharing#checkJobStatus(String)} to determine if the action has
     * completed successfully. Apps must have full Dropbox access to use this
     * endpoint. Warning: This endpoint is in beta and is subject to minor but
     * possibly backwards-incompatible changes.
     *
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     */
     LaunchEmptyResult unshareFolder(UnshareFolderArg unshareFolderArg) throws UnshareFolderErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/unshare_folder",
                                   unshareFolderArg,
                                   false,
                                   UnshareFolderArg._JSON_WRITER,
                                   LaunchEmptyResult._JSON_READER,
                                   UnshareFolderError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UnshareFolderErrorException(ew.getRequestId(), ew.getUserMessage(), (UnshareFolderError) ew.getErrorValue());
        }
    }

    /**
     * Allows a shared folder owner to unshare the folder. You'll need to call
     * {@link DbxSharing#checkJobStatus(String)} to determine if the action has
     * completed successfully. Apps must have full Dropbox access to use this
     * endpoint. Warning: This endpoint is in beta and is subject to minor but
     * possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link UnshareFolderArg} for more details. </p>
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
        UnshareFolderArg arg = new UnshareFolderArg(sharedFolderId, leaveACopy);
        return unshareFolder(arg);
    }

    //
    // route sharing/transfer_folder
    //

    /**
     * Transfer ownership of a shared folder to a member of the shared folder.
     * Apps must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     */
     void transferFolder(TransferFolderArg transferFolderArg) throws TransferFolderErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/sharing/transfer_folder",
                            transferFolderArg,
                            false,
                            TransferFolderArg._JSON_WRITER,
                            JsonReader.VoidReader,
                            TransferFolderError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new TransferFolderErrorException(ew.getRequestId(), ew.getUserMessage(), (TransferFolderError) ew.getErrorValue());
        }
    }

    /**
     * Transfer ownership of a shared folder to a member of the shared folder.
     * Apps must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link TransferFolderArg} for more details. </p>
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
        TransferFolderArg arg = new TransferFolderArg(sharedFolderId, toDropboxId);
        transferFolder(arg);
    }

    //
    // route sharing/update_folder_policy
    //

    /**
     * Update the sharing policies for a shared folder. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * @param updateFolderPolicyArg  If any of the policy's are unset, then they
     *     retain their current setting.
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     */
     SharedFolderMetadata updateFolderPolicy(UpdateFolderPolicyArg updateFolderPolicyArg) throws UpdateFolderPolicyErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/update_folder_policy",
                                   updateFolderPolicyArg,
                                   false,
                                   UpdateFolderPolicyArg._JSON_WRITER,
                                   SharedFolderMetadata._JSON_READER,
                                   UpdateFolderPolicyError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UpdateFolderPolicyErrorException(ew.getRequestId(), ew.getUserMessage(), (UpdateFolderPolicyError) ew.getErrorValue());
        }
    }

    /**
     * Update the sharing policies for a shared folder. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link UpdateFolderPolicyArg} for more details. </p>
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
        UpdateFolderPolicyArg arg = new UpdateFolderPolicyArg(sharedFolderId);
        return updateFolderPolicy(arg);
    }

    /**
     * Update the sharing policies for a shared folder. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
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
        UpdateFolderPolicyArg.Builder argBuilder = UpdateFolderPolicyArg.newBuilder(sharedFolderId);
        return new UpdateFolderPolicyBuilder(this, argBuilder);
    }

    //
    // route sharing/add_folder_member
    //

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link
     * DbxSharing#mountFolder(String)} on their behalf. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     */
     void addFolderMember(AddFolderMemberArg addFolderMemberArg) throws AddFolderMemberErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/sharing/add_folder_member",
                            addFolderMemberArg,
                            false,
                            AddFolderMemberArg._JSON_WRITER,
                            JsonReader.VoidReader,
                            AddFolderMemberError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new AddFolderMemberErrorException(ew.getRequestId(), ew.getUserMessage(), (AddFolderMemberError) ew.getErrorValue());
        }
    }

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link
     * DbxSharing#mountFolder(String)} on their behalf. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link AddFolderMemberArg} for more details. </p>
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
    public void addFolderMember(String sharedFolderId, java.util.List<AddMember> members) throws AddFolderMemberErrorException, DbxException {
        AddFolderMemberArg arg = new AddFolderMemberArg(sharedFolderId, members);
        addFolderMember(arg);
    }

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to add another member. For the new member to get access to all the
     * functionality for this folder, you will need to call {@link
     * DbxSharing#mountFolder(String)} on their behalf. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
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
    public AddFolderMemberBuilder addFolderMemberBuilder(String sharedFolderId, java.util.List<AddMember> members) {
        AddFolderMemberArg.Builder argBuilder = AddFolderMemberArg.newBuilder(sharedFolderId, members);
        return new AddFolderMemberBuilder(this, argBuilder);
    }

    //
    // route sharing/remove_folder_member
    //

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to remove another member. Apps must have full Dropbox access to
     * use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     *
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     */
     LaunchEmptyResult removeFolderMember(RemoveFolderMemberArg removeFolderMemberArg) throws RemoveFolderMemberErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/remove_folder_member",
                                   removeFolderMemberArg,
                                   false,
                                   RemoveFolderMemberArg._JSON_WRITER,
                                   LaunchEmptyResult._JSON_READER,
                                   RemoveFolderMemberError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RemoveFolderMemberErrorException(ew.getRequestId(), ew.getUserMessage(), (RemoveFolderMemberError) ew.getErrorValue());
        }
    }

    /**
     * Allows an owner or editor (if the ACL update policy allows) of a shared
     * folder to remove another member. Apps must have full Dropbox access to
     * use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link RemoveFolderMemberArg} for more details. </p>
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
     * @return Result returned by methods that may either launch an asynchronous
     *     job or complete synchronously. Upon synchronous completion of the
     *     job, no additional information is returned.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LaunchEmptyResult removeFolderMember(String sharedFolderId, MemberSelector member, boolean leaveACopy) throws RemoveFolderMemberErrorException, DbxException {
        RemoveFolderMemberArg arg = new RemoveFolderMemberArg(sharedFolderId, member, leaveACopy);
        return removeFolderMember(arg);
    }

    //
    // route sharing/update_folder_member
    //

    /**
     * Allows an owner or editor of a shared folder to update another member's
     * permissions. Apps must have full Dropbox access to use this endpoint.
     * Warning: This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     */
     void updateFolderMember(UpdateFolderMemberArg updateFolderMemberArg) throws UpdateFolderMemberErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/sharing/update_folder_member",
                            updateFolderMemberArg,
                            false,
                            UpdateFolderMemberArg._JSON_WRITER,
                            JsonReader.VoidReader,
                            UpdateFolderMemberError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UpdateFolderMemberErrorException(ew.getRequestId(), ew.getUserMessage(), (UpdateFolderMemberError) ew.getErrorValue());
        }
    }

    /**
     * Allows an owner or editor of a shared folder to update another member's
     * permissions. Apps must have full Dropbox access to use this endpoint.
     * Warning: This endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link UpdateFolderMemberArg} for more details. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     * @param member  The member of the shared folder to update.  Only the
     *     {@link MemberSelector#dropboxId} may be set at this time. Must not be
     *     {@code null}.
     * @param accessLevel  The new access level for {@link
     *     UpdateFolderMemberArg#getMember}. {@link AccessLevel#OWNER} is
     *     disallowed. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void updateFolderMember(String sharedFolderId, MemberSelector member, AccessLevel accessLevel) throws UpdateFolderMemberErrorException, DbxException {
        UpdateFolderMemberArg arg = new UpdateFolderMemberArg(sharedFolderId, member, accessLevel);
        updateFolderMember(arg);
    }

    //
    // route sharing/mount_folder
    //

    /**
     * The current user mounts the designated folder. Mount a shared folder for
     * a user after they have been added as a member. Once mounted, the shared
     * folder will appear in their Dropbox. Apps must have full Dropbox access
     * to use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     *
     * @return The metadata which includes basic information about the shared
     *     folder.
     */
     SharedFolderMetadata mountFolder(MountFolderArg mountFolderArg) throws MountFolderErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/sharing/mount_folder",
                                   mountFolderArg,
                                   false,
                                   MountFolderArg._JSON_WRITER,
                                   SharedFolderMetadata._JSON_READER,
                                   MountFolderError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new MountFolderErrorException(ew.getRequestId(), ew.getUserMessage(), (MountFolderError) ew.getErrorValue());
        }
    }

    /**
     * The current user mounts the designated folder. Mount a shared folder for
     * a user after they have been added as a member. Once mounted, the shared
     * folder will appear in their Dropbox. Apps must have full Dropbox access
     * to use this endpoint. Warning: This endpoint is in beta and is subject to
     * minor but possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link MountFolderArg} for more details. </p>
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
        MountFolderArg arg = new MountFolderArg(sharedFolderId);
        return mountFolder(arg);
    }

    //
    // route sharing/unmount_folder
    //

    /**
     * The current user unmounts the designated folder. They can re-mount the
     * folder at a later time using {@link DbxSharing#mountFolder(String)}. Apps
     * must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     */
     void unmountFolder(UnmountFolderArg unmountFolderArg) throws UnmountFolderErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/sharing/unmount_folder",
                            unmountFolderArg,
                            false,
                            UnmountFolderArg._JSON_WRITER,
                            JsonReader.VoidReader,
                            UnmountFolderError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new UnmountFolderErrorException(ew.getRequestId(), ew.getUserMessage(), (UnmountFolderError) ew.getErrorValue());
        }
    }

    /**
     * The current user unmounts the designated folder. They can re-mount the
     * folder at a later time using {@link DbxSharing#mountFolder(String)}. Apps
     * must have full Dropbox access to use this endpoint. Warning: This
     * endpoint is in beta and is subject to minor but possibly
     * backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link UnmountFolderArg} for more details. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void unmountFolder(String sharedFolderId) throws UnmountFolderErrorException, DbxException {
        UnmountFolderArg arg = new UnmountFolderArg(sharedFolderId);
        unmountFolder(arg);
    }

    //
    // route sharing/relinquish_folder_membership
    //

    /**
     * The current user relinquishes their membership in the designated shared
     * folder and will no longer have access to the folder.  A folder owner
     * cannot relinquish membership in their own folder. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     */
     void relinquishFolderMembership(RelinquishFolderMembershipArg relinquishFolderMembershipArg) throws RelinquishFolderMembershipErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/sharing/relinquish_folder_membership",
                            relinquishFolderMembershipArg,
                            false,
                            RelinquishFolderMembershipArg._JSON_WRITER,
                            JsonReader.VoidReader,
                            RelinquishFolderMembershipError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RelinquishFolderMembershipErrorException(ew.getRequestId(), ew.getUserMessage(), (RelinquishFolderMembershipError) ew.getErrorValue());
        }
    }

    /**
     * The current user relinquishes their membership in the designated shared
     * folder and will no longer have access to the folder.  A folder owner
     * cannot relinquish membership in their own folder. Apps must have full
     * Dropbox access to use this endpoint. Warning: This endpoint is in beta
     * and is subject to minor but possibly backwards-incompatible changes.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link RelinquishFolderMembershipArg} for more details. </p>
     *
     * @param sharedFolderId  The ID for the shared folder. Must match pattern
     *     "{@code [-_0-9a-zA-Z:]+}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void relinquishFolderMembership(String sharedFolderId) throws RelinquishFolderMembershipErrorException, DbxException {
        RelinquishFolderMembershipArg arg = new RelinquishFolderMembershipArg(sharedFolderId);
        relinquishFolderMembership(arg);
    }
}
