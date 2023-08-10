/* DO NOT EDIT */
/* This file was generated from paper.stone */

package com.dropbox.core.v2.paper;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxDownloadStyleBuilder;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.sharing.MemberSelector;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "paper".
 */
public class DbxUserPaperRequests {
    // namespace paper (paper.stone)

    private final DbxRawClientV2 client;

    public DbxUserPaperRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/paper/docs/archive
    //

    /**
     * Marks the given Paper doc as archived. This action can be performed or
     * undone by anyone with edit permissions to the doc. Note that this
     * endpoint will continue to work for content created by users on the older
     * version of Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. This endpoint will be
     * retired in September 2020. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for more information.
     *
     */
    void docsArchive(RefPaperDoc arg) throws DocLookupErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/paper/docs/archive",
                                 arg,
                                 false,
                                 RefPaperDoc.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 DocLookupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DocLookupErrorException("2/paper/docs/archive", ex.getRequestId(), ex.getUserMessage(), (DocLookupError) ex.getErrorValue());
        }
    }

    /**
     * Marks the given Paper doc as archived.
     *
     * <p> This action can be performed or undone by anyone with edit
     * permissions to the doc. </p>
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> This endpoint will be retired in September 2020. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for more information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public void docsArchive(String docId) throws DocLookupErrorException, DbxException {
        RefPaperDoc _arg = new RefPaperDoc(docId);
        docsArchive(_arg);
    }

    //
    // route 2/paper/docs/create
    //

    /**
     * Creates a new Paper doc with the provided content. Note that this
     * endpoint will continue to work for content created by users on the older
     * version of Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. This endpoint will be
     * retired in September 2020. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for more information.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    DocsCreateUploader docsCreate(PaperDocCreateArgs arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getApi(),
                                                                   "2/paper/docs/create",
                                                                   arg,
                                                                   false,
                                                                   PaperDocCreateArgs.Serializer.INSTANCE);
        return new DocsCreateUploader(_uploader, this.client.getUserId());
    }

    /**
     * Creates a new Paper doc with the provided content.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> This endpoint will be retired in September 2020. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for more information. </p>
     *
     * @param importFormat  The format of provided data. Must not be {@code
     *     null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public DocsCreateUploader docsCreate(ImportFormat importFormat) throws DbxException {
        PaperDocCreateArgs _arg = new PaperDocCreateArgs(importFormat);
        return docsCreate(_arg);
    }

    /**
     * Creates a new Paper doc with the provided content.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> This endpoint will be retired in September 2020. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for more information. </p>
     *
     * @param importFormat  The format of provided data. Must not be {@code
     *     null}.
     * @param parentFolderId  The Paper folder ID where the Paper document
     *     should be created. The API user has to have write access to this
     *     folder or error is thrown.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public DocsCreateUploader docsCreate(ImportFormat importFormat, String parentFolderId) throws DbxException {
        PaperDocCreateArgs _arg = new PaperDocCreateArgs(importFormat, parentFolderId);
        return docsCreate(_arg);
    }

    //
    // route 2/paper/docs/download
    //

    /**
     * Exports and downloads Paper doc either as HTML or markdown. Note that
     * this endpoint will continue to work for content created by users on the
     * older version of Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<PaperDocExportResult> docsDownload(PaperDocExport arg, List<HttpRequestor.Header> _headers) throws DocLookupErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getApi(),
                                             "2/paper/docs/download",
                                             arg,
                                             false,
                                             _headers,
                                             PaperDocExport.Serializer.INSTANCE,
                                             PaperDocExportResult.Serializer.INSTANCE,
                                             DocLookupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DocLookupErrorException("2/paper/docs/download", ex.getRequestId(), ex.getUserMessage(), (DocLookupError) ex.getErrorValue());
        }
    }

    /**
     * Exports and downloads Paper doc either as HTML or markdown.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param exportFormat  Must not be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public DbxDownloader<PaperDocExportResult> docsDownload(String docId, ExportFormat exportFormat) throws DocLookupErrorException, DbxException {
        PaperDocExport _arg = new PaperDocExport(docId, exportFormat);
        return docsDownload(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Exports and downloads Paper doc either as HTML or markdown. Note that
     * this endpoint will continue to work for content created by users on the
     * older version of Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param exportFormat  Must not be {@code null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public DocsDownloadBuilder docsDownloadBuilder(String docId, ExportFormat exportFormat) {
        return new DocsDownloadBuilder(this, docId, exportFormat);
    }

    //
    // route 2/paper/docs/folder_users/list
    //

    /**
     * Lists the users who are explicitly invited to the Paper folder in which
     * the Paper doc is contained. For private folders all users (including
     * owner) shared on the folder are listed and for team folders all non-team
     * users shared on the folder are returned. Note that this endpoint will
     * continue to work for content created by users on the older version of
     * Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    ListUsersOnFolderResponse docsFolderUsersList(ListUsersOnFolderArgs arg) throws DocLookupErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/paper/docs/folder_users/list",
                                        arg,
                                        false,
                                        ListUsersOnFolderArgs.Serializer.INSTANCE,
                                        ListUsersOnFolderResponse.Serializer.INSTANCE,
                                        DocLookupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DocLookupErrorException("2/paper/docs/folder_users/list", ex.getRequestId(), ex.getUserMessage(), (DocLookupError) ex.getErrorValue());
        }
    }

    /**
     * Lists the users who are explicitly invited to the Paper folder in which
     * the Paper doc is contained. For private folders all users (including
     * owner) shared on the folder are listed and for team folders all non-team
     * users shared on the folder are returned.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * <p> The {@code limit} request parameter will default to {@code 1000} (see
     * {@link #docsFolderUsersList(String,int)}). </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public ListUsersOnFolderResponse docsFolderUsersList(String docId) throws DocLookupErrorException, DbxException {
        ListUsersOnFolderArgs _arg = new ListUsersOnFolderArgs(docId);
        return docsFolderUsersList(_arg);
    }

    /**
     * Lists the users who are explicitly invited to the Paper folder in which
     * the Paper doc is contained. For private folders all users (including
     * owner) shared on the folder are listed and for team folders all non-team
     * users shared on the folder are returned.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param limit  Size limit per batch. The maximum number of users that can
     *     be retrieved per batch is 1000. Higher value results in invalid
     *     arguments error. Must be greater than or equal to 1 and be less than
     *     or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public ListUsersOnFolderResponse docsFolderUsersList(String docId, int limit) throws DocLookupErrorException, DbxException {
        if (limit < 1) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1");
        }
        if (limit > 1000) {
            throw new IllegalArgumentException("Number 'limit' is larger than 1000");
        }
        ListUsersOnFolderArgs _arg = new ListUsersOnFolderArgs(docId, limit);
        return docsFolderUsersList(_arg);
    }

    //
    // route 2/paper/docs/folder_users/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserPaperRequests#docsFolderUsersList(String,int)}, use this to
     * paginate through all users on the Paper folder. Note that this endpoint
     * will continue to work for content created by users on the older version
     * of Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    ListUsersOnFolderResponse docsFolderUsersListContinue(ListUsersOnFolderContinueArgs arg) throws ListUsersCursorErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/paper/docs/folder_users/list/continue",
                                        arg,
                                        false,
                                        ListUsersOnFolderContinueArgs.Serializer.INSTANCE,
                                        ListUsersOnFolderResponse.Serializer.INSTANCE,
                                        ListUsersCursorError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListUsersCursorErrorException("2/paper/docs/folder_users/list/continue", ex.getRequestId(), ex.getUserMessage(), (ListUsersCursorError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserPaperRequests#docsFolderUsersList(String,int)}, use this to
     * paginate through all users on the Paper folder.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param cursor  The cursor obtained from {@link
     *     DbxUserPaperRequests#docsFolderUsersList(String,int)} or {@link
     *     DbxUserPaperRequests#docsFolderUsersListContinue(String,String)}.
     *     Allows for pagination. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public ListUsersOnFolderResponse docsFolderUsersListContinue(String docId, String cursor) throws ListUsersCursorErrorException, DbxException {
        ListUsersOnFolderContinueArgs _arg = new ListUsersOnFolderContinueArgs(docId, cursor);
        return docsFolderUsersListContinue(_arg);
    }

    //
    // route 2/paper/docs/get_folder_info
    //

    /**
     * Retrieves folder information for the given Paper doc. This includes: -
     * folder sharing policy; permissions for subfolders are set by the
     * top-level folder. - full 'filepath', i.e. the list of folders (both
     * folderId and folderName) from     the root folder to the folder directly
     * containing the Paper doc.
     *
     * <p> If the Paper doc is not in any folder (aka unfiled) the response will
     * be empty. Note that this endpoint will continue to work for content
     * created by users on the older version of Paper. To check which version of
     * Paper a user is on, use /users/features/get_values. If the paper_as_files
     * feature is enabled, then the user is running the new version of Paper.
     * Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     *
     * @return Metadata about Paper folders containing the specififed Paper doc.
     */
    FoldersContainingPaperDoc docsGetFolderInfo(RefPaperDoc arg) throws DocLookupErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/paper/docs/get_folder_info",
                                        arg,
                                        false,
                                        RefPaperDoc.Serializer.INSTANCE,
                                        FoldersContainingPaperDoc.Serializer.INSTANCE,
                                        DocLookupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DocLookupErrorException("2/paper/docs/get_folder_info", ex.getRequestId(), ex.getUserMessage(), (DocLookupError) ex.getErrorValue());
        }
    }

    /**
     * Retrieves folder information for the given Paper doc. This includes:
     *
     * <p> - folder sharing policy; permissions for subfolders are set by the
     * top-level folder. </p>
     *
     * <p> - full 'filepath', i.e. the list of folders (both folderId and
     * folderName) from the root folder to the folder directly containing the
     * Paper doc. </p>
     *
     * <p> If the Paper doc is not in any folder (aka unfiled) the response will
     * be empty. </p>
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     *
     * @return Metadata about Paper folders containing the specififed Paper doc.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public FoldersContainingPaperDoc docsGetFolderInfo(String docId) throws DocLookupErrorException, DbxException {
        RefPaperDoc _arg = new RefPaperDoc(docId);
        return docsGetFolderInfo(_arg);
    }

    //
    // route 2/paper/docs/list
    //

    /**
     * Return the list of all Paper docs according to the argument
     * specifications. To iterate over through the full pagination, pass the
     * cursor to {@link DbxUserPaperRequests#docsListContinue(String)}. Note
     * that this endpoint will continue to work for content created by users on
     * the older version of Paper. To check which version of Paper a user is on,
     * use /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    ListPaperDocsResponse docsList(ListPaperDocsArgs arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/paper/docs/list",
                                        arg,
                                        false,
                                        ListPaperDocsArgs.Serializer.INSTANCE,
                                        ListPaperDocsResponse.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"docs/list\":" + ex.getErrorValue());
        }
    }

    /**
     * Return the list of all Paper docs according to the argument
     * specifications. To iterate over through the full pagination, pass the
     * cursor to {@link DbxUserPaperRequests#docsListContinue(String)}.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DocsListBuilder} for more details. </p>
     *
     * @deprecated
     */
    @Deprecated
    public ListPaperDocsResponse docsList() throws DbxApiException, DbxException {
        ListPaperDocsArgs _arg = new ListPaperDocsArgs();
        return docsList(_arg);
    }

    /**
     * Return the list of all Paper docs according to the argument
     * specifications. To iterate over through the full pagination, pass the
     * cursor to {@link DbxUserPaperRequests#docsListContinue(String)}. Note
     * that this endpoint will continue to work for content created by users on
     * the older version of Paper. To check which version of Paper a user is on,
     * use /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @deprecated
     */
    @Deprecated
    public DocsListBuilder docsListBuilder() {
        ListPaperDocsArgs.Builder argBuilder_ = ListPaperDocsArgs.newBuilder();
        return new DocsListBuilder(this, argBuilder_);
    }

    //
    // route 2/paper/docs/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserPaperRequests#docsList}, use this to paginate through all Paper
     * doc. Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. Refer to
     * the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    ListPaperDocsResponse docsListContinue(ListPaperDocsContinueArgs arg) throws ListDocsCursorErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/paper/docs/list/continue",
                                        arg,
                                        false,
                                        ListPaperDocsContinueArgs.Serializer.INSTANCE,
                                        ListPaperDocsResponse.Serializer.INSTANCE,
                                        ListDocsCursorError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListDocsCursorErrorException("2/paper/docs/list/continue", ex.getRequestId(), ex.getUserMessage(), (ListDocsCursorError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserPaperRequests#docsList}, use this to paginate through all Paper
     * doc.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param cursor  The cursor obtained from {@link
     *     DbxUserPaperRequests#docsList} or {@link
     *     DbxUserPaperRequests#docsListContinue(String)}. Allows for
     *     pagination. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public ListPaperDocsResponse docsListContinue(String cursor) throws ListDocsCursorErrorException, DbxException {
        ListPaperDocsContinueArgs _arg = new ListPaperDocsContinueArgs(cursor);
        return docsListContinue(_arg);
    }

    //
    // route 2/paper/docs/permanently_delete
    //

    /**
     * Permanently deletes the given Paper doc. This operation is final as the
     * doc cannot be recovered. This action can be performed only by the doc
     * owner. Note that this endpoint will continue to work for content created
     * by users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. Refer to
     * the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    void docsPermanentlyDelete(RefPaperDoc arg) throws DocLookupErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/paper/docs/permanently_delete",
                                 arg,
                                 false,
                                 RefPaperDoc.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 DocLookupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DocLookupErrorException("2/paper/docs/permanently_delete", ex.getRequestId(), ex.getUserMessage(), (DocLookupError) ex.getErrorValue());
        }
    }

    /**
     * Permanently deletes the given Paper doc. This operation is final as the
     * doc cannot be recovered.
     *
     * <p> This action can be performed only by the doc owner. </p>
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public void docsPermanentlyDelete(String docId) throws DocLookupErrorException, DbxException {
        RefPaperDoc _arg = new RefPaperDoc(docId);
        docsPermanentlyDelete(_arg);
    }

    //
    // route 2/paper/docs/sharing_policy/get
    //

    /**
     * Gets the default sharing policy for the given Paper doc. Note that this
     * endpoint will continue to work for content created by users on the older
     * version of Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     *
     * @return Sharing policy of Paper doc.
     */
    SharingPolicy docsSharingPolicyGet(RefPaperDoc arg) throws DocLookupErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/paper/docs/sharing_policy/get",
                                        arg,
                                        false,
                                        RefPaperDoc.Serializer.INSTANCE,
                                        SharingPolicy.Serializer.INSTANCE,
                                        DocLookupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DocLookupErrorException("2/paper/docs/sharing_policy/get", ex.getRequestId(), ex.getUserMessage(), (DocLookupError) ex.getErrorValue());
        }
    }

    /**
     * Gets the default sharing policy for the given Paper doc.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     *
     * @return Sharing policy of Paper doc.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public SharingPolicy docsSharingPolicyGet(String docId) throws DocLookupErrorException, DbxException {
        RefPaperDoc _arg = new RefPaperDoc(docId);
        return docsSharingPolicyGet(_arg);
    }

    //
    // route 2/paper/docs/sharing_policy/set
    //

    /**
     * Sets the default sharing policy for the given Paper doc. The default
     * 'team_sharing_policy' can be changed only by teams, omit this field for
     * personal accounts. The 'public_sharing_policy' policy can't be set to the
     * value 'disabled' because this setting can be changed only via the team
     * admin console. Note that this endpoint will continue to work for content
     * created by users on the older version of Paper. To check which version of
     * Paper a user is on, use /users/features/get_values. If the paper_as_files
     * feature is enabled, then the user is running the new version of Paper.
     * Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    void docsSharingPolicySet(PaperDocSharingPolicy arg) throws DocLookupErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/paper/docs/sharing_policy/set",
                                 arg,
                                 false,
                                 PaperDocSharingPolicy.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 DocLookupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DocLookupErrorException("2/paper/docs/sharing_policy/set", ex.getRequestId(), ex.getUserMessage(), (DocLookupError) ex.getErrorValue());
        }
    }

    /**
     * Sets the default sharing policy for the given Paper doc. The default
     * 'team_sharing_policy' can be changed only by teams, omit this field for
     * personal accounts.
     *
     * <p> The 'public_sharing_policy' policy can't be set to the value
     * 'disabled' because this setting can be changed only via the team admin
     * console. </p>
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param sharingPolicy  The default sharing policy to be set for the Paper
     *     doc. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public void docsSharingPolicySet(String docId, SharingPolicy sharingPolicy) throws DocLookupErrorException, DbxException {
        PaperDocSharingPolicy _arg = new PaperDocSharingPolicy(docId, sharingPolicy);
        docsSharingPolicySet(_arg);
    }

    //
    // route 2/paper/docs/update
    //

    /**
     * Updates an existing Paper doc with the provided content. Note that this
     * endpoint will continue to work for content created by users on the older
     * version of Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. This endpoint will be
     * retired in September 2020. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for more information.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    DocsUpdateUploader docsUpdate(PaperDocUpdateArgs arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getApi(),
                                                                   "2/paper/docs/update",
                                                                   arg,
                                                                   false,
                                                                   PaperDocUpdateArgs.Serializer.INSTANCE);
        return new DocsUpdateUploader(_uploader, this.client.getUserId());
    }

    /**
     * Updates an existing Paper doc with the provided content.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> This endpoint will be retired in September 2020. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for more information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param docUpdatePolicy  The policy used for the current update call. Must
     *     not be {@code null}.
     * @param revision  The latest doc revision. This value must match the head
     *     revision or an error code will be returned. This is to prevent
     *     colliding writes.
     * @param importFormat  The format of provided data. Must not be {@code
     *     null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public DocsUpdateUploader docsUpdate(String docId, PaperDocUpdatePolicy docUpdatePolicy, long revision, ImportFormat importFormat) throws DbxException {
        PaperDocUpdateArgs _arg = new PaperDocUpdateArgs(docId, docUpdatePolicy, revision, importFormat);
        return docsUpdate(_arg);
    }

    //
    // route 2/paper/docs/users/add
    //

    /**
     * Allows an owner or editor to add users to a Paper doc or change their
     * permissions using their email address or Dropbox account ID. The doc
     * owner's permissions cannot be changed. Note that this endpoint will
     * continue to work for content created by users on the older version of
     * Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    List<AddPaperDocUserMemberResult> docsUsersAdd(AddPaperDocUser arg) throws DocLookupErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/paper/docs/users/add",
                                        arg,
                                        false,
                                        AddPaperDocUser.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.list(AddPaperDocUserMemberResult.Serializer.INSTANCE),
                                        DocLookupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DocLookupErrorException("2/paper/docs/users/add", ex.getRequestId(), ex.getUserMessage(), (DocLookupError) ex.getErrorValue());
        }
    }

    /**
     * Allows an owner or editor to add users to a Paper doc or change their
     * permissions using their email address or Dropbox account ID.
     *
     * <p> The doc owner's permissions cannot be changed. </p>
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DocsUsersAddBuilder} for more details. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param members  User which should be added to the Paper doc. Specify only
     *     email address or Dropbox account ID. Must contain at most 20 items,
     *     not contain a {@code null} item, and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public List<AddPaperDocUserMemberResult> docsUsersAdd(String docId, List<AddMember> members) throws DocLookupErrorException, DbxException {
        AddPaperDocUser _arg = new AddPaperDocUser(docId, members);
        return docsUsersAdd(_arg);
    }

    /**
     * Allows an owner or editor to add users to a Paper doc or change their
     * permissions using their email address or Dropbox account ID. The doc
     * owner's permissions cannot be changed. Note that this endpoint will
     * continue to work for content created by users on the older version of
     * Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param members  User which should be added to the Paper doc. Specify only
     *     email address or Dropbox account ID. Must contain at most 20 items,
     *     not contain a {@code null} item, and not be {@code null}.
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
    public DocsUsersAddBuilder docsUsersAddBuilder(String docId, List<AddMember> members) {
        AddPaperDocUser.Builder argBuilder_ = AddPaperDocUser.newBuilder(docId, members);
        return new DocsUsersAddBuilder(this, argBuilder_);
    }

    //
    // route 2/paper/docs/users/list
    //

    /**
     * Lists all users who visited the Paper doc or users with explicit access.
     * This call excludes users who have been removed. The list is sorted by the
     * date of the visit or the share date. The list will include both users,
     * the explicitly shared ones as well as those who came in using the Paper
     * url link. Note that this endpoint will continue to work for content
     * created by users on the older version of Paper. To check which version of
     * Paper a user is on, use /users/features/get_values. If the paper_as_files
     * feature is enabled, then the user is running the new version of Paper.
     * Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    ListUsersOnPaperDocResponse docsUsersList(ListUsersOnPaperDocArgs arg) throws DocLookupErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/paper/docs/users/list",
                                        arg,
                                        false,
                                        ListUsersOnPaperDocArgs.Serializer.INSTANCE,
                                        ListUsersOnPaperDocResponse.Serializer.INSTANCE,
                                        DocLookupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DocLookupErrorException("2/paper/docs/users/list", ex.getRequestId(), ex.getUserMessage(), (DocLookupError) ex.getErrorValue());
        }
    }

    /**
     * Lists all users who visited the Paper doc or users with explicit access.
     * This call excludes users who have been removed. The list is sorted by the
     * date of the visit or the share date.
     *
     * <p> The list will include both users, the explicitly shared ones as well
     * as those who came in using the Paper url link. </p>
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DocsUsersListBuilder} for more details. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public ListUsersOnPaperDocResponse docsUsersList(String docId) throws DocLookupErrorException, DbxException {
        ListUsersOnPaperDocArgs _arg = new ListUsersOnPaperDocArgs(docId);
        return docsUsersList(_arg);
    }

    /**
     * Lists all users who visited the Paper doc or users with explicit access.
     * This call excludes users who have been removed. The list is sorted by the
     * date of the visit or the share date. The list will include both users,
     * the explicitly shared ones as well as those who came in using the Paper
     * url link. Note that this endpoint will continue to work for content
     * created by users on the older version of Paper. To check which version of
     * Paper a user is on, use /users/features/get_values. If the paper_as_files
     * feature is enabled, then the user is running the new version of Paper.
     * Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
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
    public DocsUsersListBuilder docsUsersListBuilder(String docId) {
        ListUsersOnPaperDocArgs.Builder argBuilder_ = ListUsersOnPaperDocArgs.newBuilder(docId);
        return new DocsUsersListBuilder(this, argBuilder_);
    }

    //
    // route 2/paper/docs/users/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserPaperRequests#docsUsersList(String)}, use this to paginate through
     * all users on the Paper doc. Note that this endpoint will continue to work
     * for content created by users on the older version of Paper. To check
     * which version of Paper a user is on, use /users/features/get_values. If
     * the paper_as_files feature is enabled, then the user is running the new
     * version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    ListUsersOnPaperDocResponse docsUsersListContinue(ListUsersOnPaperDocContinueArgs arg) throws ListUsersCursorErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/paper/docs/users/list/continue",
                                        arg,
                                        false,
                                        ListUsersOnPaperDocContinueArgs.Serializer.INSTANCE,
                                        ListUsersOnPaperDocResponse.Serializer.INSTANCE,
                                        ListUsersCursorError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListUsersCursorErrorException("2/paper/docs/users/list/continue", ex.getRequestId(), ex.getUserMessage(), (ListUsersCursorError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserPaperRequests#docsUsersList(String)}, use this to paginate through
     * all users on the Paper doc.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param cursor  The cursor obtained from {@link
     *     DbxUserPaperRequests#docsUsersList(String)} or {@link
     *     DbxUserPaperRequests#docsUsersListContinue(String,String)}. Allows
     *     for pagination. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public ListUsersOnPaperDocResponse docsUsersListContinue(String docId, String cursor) throws ListUsersCursorErrorException, DbxException {
        ListUsersOnPaperDocContinueArgs _arg = new ListUsersOnPaperDocContinueArgs(docId, cursor);
        return docsUsersListContinue(_arg);
    }

    //
    // route 2/paper/docs/users/remove
    //

    /**
     * Allows an owner or editor to remove users from a Paper doc using their
     * email address or Dropbox account ID. The doc owner cannot be removed.
     * Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. Refer to
     * the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    void docsUsersRemove(RemovePaperDocUser arg) throws DocLookupErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/paper/docs/users/remove",
                                 arg,
                                 false,
                                 RemovePaperDocUser.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 DocLookupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DocLookupErrorException("2/paper/docs/users/remove", ex.getRequestId(), ex.getUserMessage(), (DocLookupError) ex.getErrorValue());
        }
    }

    /**
     * Allows an owner or editor to remove users from a Paper doc using their
     * email address or Dropbox account ID.
     *
     * <p> The doc owner cannot be removed. </p>
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param docId  The Paper doc ID. Must not be {@code null}.
     * @param member  User which should be removed from the Paper doc. Specify
     *     only email address or Dropbox account ID. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public void docsUsersRemove(String docId, MemberSelector member) throws DocLookupErrorException, DbxException {
        RemovePaperDocUser _arg = new RemovePaperDocUser(docId, member);
        docsUsersRemove(_arg);
    }

    //
    // route 2/paper/folders/create
    //

    /**
     * Create a new Paper folder with the provided info. Note that this endpoint
     * will continue to work for content created by users on the older version
     * of Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     */
    PaperFolderCreateResult foldersCreate(PaperFolderCreateArg arg) throws PaperFolderCreateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/paper/folders/create",
                                        arg,
                                        false,
                                        PaperFolderCreateArg.Serializer.INSTANCE,
                                        PaperFolderCreateResult.Serializer.INSTANCE,
                                        PaperFolderCreateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PaperFolderCreateErrorException("2/paper/folders/create", ex.getRequestId(), ex.getUserMessage(), (PaperFolderCreateError) ex.getErrorValue());
        }
    }

    /**
     * Create a new Paper folder with the provided info.
     *
     * <p> Note that this endpoint will continue to work for content created by
     * users on the older version of Paper. To check which version of Paper a
     * user is on, use /users/features/get_values. If the paper_as_files feature
     * is enabled, then the user is running the new version of Paper. </p>
     *
     * <p> Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information. </p>
     *
     * @param name  The name of the new Paper folder. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public PaperFolderCreateResult foldersCreate(String name) throws PaperFolderCreateErrorException, DbxException {
        PaperFolderCreateArg _arg = new PaperFolderCreateArg(name);
        return foldersCreate(_arg);
    }

    /**
     * Create a new Paper folder with the provided info. Note that this endpoint
     * will continue to work for content created by users on the older version
     * of Paper. To check which version of Paper a user is on, use
     * /users/features/get_values. If the paper_as_files feature is enabled,
     * then the user is running the new version of Paper. Refer to the <a
     * href="https://www.dropbox.com/lp/developers/reference/paper-migration-guide">Paper
     * Migration Guide</a> for migration information.
     *
     * @param name  The name of the new Paper folder. Must not be {@code null}.
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
    public FoldersCreateBuilder foldersCreateBuilder(String name) {
        PaperFolderCreateArg.Builder argBuilder_ = PaperFolderCreateArg.newBuilder(name);
        return new FoldersCreateBuilder(this, argBuilder_);
    }
}
