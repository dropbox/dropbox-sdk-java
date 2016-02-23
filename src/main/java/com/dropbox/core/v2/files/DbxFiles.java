/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.v2.DbxDownloadStyleBuilder;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.DbxUploadStyleBuilder;

/**
 * Routes in namespace "files".
 */
public final class DbxFiles {
    // namespace files

    private final DbxRawClientV2 client;

    public DbxFiles(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route files/get_metadata
    //

    /**
     * Returns the metadata for a file or folder.
     *
     *
     * @return Metadata for a file or folder.
     */
     Metadata getMetadata(GetMetadataArg getMetadataArg) throws GetMetadataErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/get_metadata",
                                   getMetadataArg,
                                   false,
                                   GetMetadataArg._JSON_WRITER,
                                   Metadata._JSON_READER,
                                   GetMetadataError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new GetMetadataErrorException(ew.getRequestId(), ew.getUserMessage(), (GetMetadataError) ew.getErrorValue());
        }
    }

    /**
     * Returns the metadata for a file or folder.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link GetMetadataArg} for more details. </p>
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     *
     * @return Metadata for a file or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Metadata getMetadata(String path) throws GetMetadataErrorException, DbxException {
        GetMetadataArg arg = new GetMetadataArg(path);
        return getMetadata(arg);
    }

    /**
     * Returns the metadata for a file or folder.
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     * @param includeMediaInfo  If true, :field:'FileMetadata.media_info' is set
     *     for photo and video.
     *
     * @return Metadata for a file or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Metadata getMetadata(String path, boolean includeMediaInfo) throws GetMetadataErrorException, DbxException {
        GetMetadataArg arg = new GetMetadataArg(path, includeMediaInfo);
        return getMetadata(arg);
    }

    //
    // route files/list_folder/longpoll
    //

    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link DbxFiles#listFolder(String)}, this call gives you a
     * low-latency way to monitor an account for file changes. The connection
     * will block until there are changes available or a timeout occurs. This
     * endpoint is useful mostly for client-side apps. If you're looking for
     * server-side notifications, check out our &lt;a
     * href="https://www.dropbox.com/developers/reference/webhooks"&gt;webhooks
     * documentation&lt;/a&gt;.
     *
     */
     ListFolderLongpollResult listFolderLongpoll(ListFolderLongpollArg listFolderLongpollArg) throws ListFolderLongpollErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getNotify(),
                                   "2/files/list_folder/longpoll",
                                   listFolderLongpollArg,
                                   true,
                                   ListFolderLongpollArg._JSON_WRITER,
                                   ListFolderLongpollResult._JSON_READER,
                                   ListFolderLongpollError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderLongpollErrorException(ew.getRequestId(), ew.getUserMessage(), (ListFolderLongpollError) ew.getErrorValue());
        }
    }

    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link DbxFiles#listFolder(String)}, this call gives you a
     * low-latency way to monitor an account for file changes. The connection
     * will block until there are changes available or a timeout occurs. This
     * endpoint is useful mostly for client-side apps. If you're looking for
     * server-side notifications, check out our &lt;a
     * href="https://www.dropbox.com/developers/reference/webhooks"&gt;webhooks
     * documentation&lt;/a&gt;.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListFolderLongpollArg} for more details. </p>
     *
     * @param cursor  A cursor as returned by {@link
     *     DbxFiles#listFolder(String)} or {@link
     *     DbxFiles#listFolderContinue(String)}. Must have length of at least 1
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderLongpollResult listFolderLongpoll(String cursor) throws ListFolderLongpollErrorException, DbxException {
        ListFolderLongpollArg arg = new ListFolderLongpollArg(cursor);
        return listFolderLongpoll(arg);
    }

    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link DbxFiles#listFolder(String)}, this call gives you a
     * low-latency way to monitor an account for file changes. The connection
     * will block until there are changes available or a timeout occurs. This
     * endpoint is useful mostly for client-side apps. If you're looking for
     * server-side notifications, check out our &lt;a
     * href="https://www.dropbox.com/developers/reference/webhooks"&gt;webhooks
     * documentation&lt;/a&gt;.
     *
     * @param cursor  A cursor as returned by {@link
     *     DbxFiles#listFolder(String)} or {@link
     *     DbxFiles#listFolderContinue(String)}. Must have length of at least 1
     *     and not be {@code null}.
     * @param timeout  A timeout in seconds. The request will block for at most
     *     this length of time, plus up to 90 seconds of random jitter added to
     *     avoid the thundering herd problem. Care should be taken when using
     *     this parameter, as some network infrastructure does not support long
     *     timeouts. Must be greater than or equal to 30 and be less than or
     *     equal to 480.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderLongpollResult listFolderLongpoll(String cursor, long timeout) throws ListFolderLongpollErrorException, DbxException {
        if (timeout < 30L) {
            throw new IllegalArgumentException("Number 'timeout' is smaller than 30L");
        }
        if (timeout > 480L) {
            throw new IllegalArgumentException("Number 'timeout' is larger than 480L");
        }
        ListFolderLongpollArg arg = new ListFolderLongpollArg(cursor, timeout);
        return listFolderLongpoll(arg);
    }

    //
    // route files/list_folder
    //

    /**
     * Returns the contents of a folder.
     *
     */
     ListFolderResult listFolder(ListFolderArg listFolderArg) throws ListFolderErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/list_folder",
                                   listFolderArg,
                                   false,
                                   ListFolderArg._JSON_WRITER,
                                   ListFolderResult._JSON_READER,
                                   ListFolderError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderErrorException(ew.getRequestId(), ew.getUserMessage(), (ListFolderError) ew.getErrorValue());
        }
    }

    /**
     * Returns the contents of a folder.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListFolderArg} for more details. </p>
     *
     * @param path  The path to the folder you want to see the contents of. Must
     *     match pattern "{@code (/.*)?}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderResult listFolder(String path) throws ListFolderErrorException, DbxException {
        ListFolderArg arg = new ListFolderArg(path);
        return listFolder(arg);
    }

    /**
     * Returns the contents of a folder.
     *
     * @param path  The path to the folder you want to see the contents of. Must
     *     match pattern "{@code (/.*)?}" and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderBuilder listFolderBuilder(String path) {
        ListFolderArg.Builder argBuilder = ListFolderArg.newBuilder(path);
        return new ListFolderBuilder(this, argBuilder);
    }

    //
    // route files/list_folder/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxFiles#listFolder(String)}, use this to paginate through all files and
     * retrieve updates to the folder.
     *
     */
     ListFolderResult listFolderContinue(ListFolderContinueArg listFolderContinueArg) throws ListFolderContinueErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/list_folder/continue",
                                   listFolderContinueArg,
                                   false,
                                   ListFolderContinueArg._JSON_WRITER,
                                   ListFolderResult._JSON_READER,
                                   ListFolderContinueError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderContinueErrorException(ew.getRequestId(), ew.getUserMessage(), (ListFolderContinueError) ew.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxFiles#listFolder(String)}, use this to paginate through all files and
     * retrieve updates to the folder.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListFolderContinueArg} for more details. </p>
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxFiles#listFolder(String)} or {@link
     *     DbxFiles#listFolderContinue(String)}. Must have length of at least 1
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderResult listFolderContinue(String cursor) throws ListFolderContinueErrorException, DbxException {
        ListFolderContinueArg arg = new ListFolderContinueArg(cursor);
        return listFolderContinue(arg);
    }

    //
    // route files/list_folder/get_latest_cursor
    //

    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * DbxFiles#listFolder(String)}, {@link
     * DbxFiles#listFolderGetLatestCursor(String)} doesn't return any entries.
     * This endpoint is for app which only needs to know about new files and
     * modifications and doesn't need to know about files that already exist in
     * Dropbox.
     *
     */
     ListFolderGetLatestCursorResult listFolderGetLatestCursor(ListFolderArg listFolderArg) throws ListFolderErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/list_folder/get_latest_cursor",
                                   listFolderArg,
                                   false,
                                   ListFolderArg._JSON_WRITER,
                                   ListFolderGetLatestCursorResult._JSON_READER,
                                   ListFolderError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListFolderErrorException(ew.getRequestId(), ew.getUserMessage(), (ListFolderError) ew.getErrorValue());
        }
    }

    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * DbxFiles#listFolder(String)}, {@link
     * DbxFiles#listFolderGetLatestCursor(String)} doesn't return any entries.
     * This endpoint is for app which only needs to know about new files and
     * modifications and doesn't need to know about files that already exist in
     * Dropbox.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListFolderArg} for more details. </p>
     *
     * @param path  The path to the folder you want to see the contents of. Must
     *     match pattern "{@code (/.*)?}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderGetLatestCursorResult listFolderGetLatestCursor(String path) throws ListFolderErrorException, DbxException {
        ListFolderArg arg = new ListFolderArg(path);
        return listFolderGetLatestCursor(arg);
    }

    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * DbxFiles#listFolder(String)}, {@link
     * DbxFiles#listFolderGetLatestCursor(String)} doesn't return any entries.
     * This endpoint is for app which only needs to know about new files and
     * modifications and doesn't need to know about files that already exist in
     * Dropbox.
     *
     * @param path  The path to the folder you want to see the contents of. Must
     *     match pattern "{@code (/.*)?}" and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderGetLatestCursorBuilder listFolderGetLatestCursorBuilder(String path) {
        ListFolderArg.Builder argBuilder = ListFolderArg.newBuilder(path);
        return new ListFolderGetLatestCursorBuilder(this, argBuilder);
    }

    //
    // route files/download
    //

    /**
     * Download a file from a user's Dropbox.
     *
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
     DbxDownloader<FileMetadata> download(DownloadArg downloadArg) throws DownloadErrorException, DbxException {
        try {
            return client.downloadStyle(client.getHost().getContent(),
                                        "2/files/download",
                                        downloadArg,
                                        false,
                                        DownloadArg._JSON_WRITER,
                                        FileMetadata._JSON_READER,
                                        DownloadError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DownloadErrorException(ew.getRequestId(), ew.getUserMessage(), (DownloadError) ew.getErrorValue());
        }
    }

    /**
     * Download a file from a user's Dropbox.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link DownloadArg} for more details. </p>
     *
     * @param path  The path of the file to download. Must match pattern "{@code
     *     ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<FileMetadata> download(String path) throws DownloadErrorException, DbxException {
        DownloadArg arg = new DownloadArg(path);
        return download(arg);
    }

    /**
     * Download a file from a user's Dropbox.
     *
     * @param path  The path of the file to download. Must match pattern "{@code
     *     ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     * @param rev  Deprecated. Please specify revision in :field:'path' instead.
     *     Must have length of at least 9 and match pattern "{@code [0-9a-f]+}".
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<FileMetadata> download(String path, String rev) throws DownloadErrorException, DbxException {
        if (rev != null) {
            if (rev.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
        }
        DownloadArg arg = new DownloadArg(path, rev);
        return download(arg);
    }

    //
    // route files/upload_session/start
    //

    /**
     * Upload sessions allow you to upload a single file using multiple
     * requests. This call starts a new upload session with the given data.  You
     * can then use {@link DbxFiles#uploadSessionAppend(String,long)} to add
     * more data and {@link
     * DbxFiles#uploadSessionFinish(UploadSessionCursor,CommitInfo)} to save all
     * the data to a file in Dropbox. A single request should not upload more
     * than 150 MB of file contents.
     *
     * @return Uploader used to upload the request body and finish request.
     */
    public UploadSessionStartUploader uploadSessionStart() throws DbxException {
        HttpRequestor.Uploader uploader = client.uploadStyle(client.getHost().getContent(),
                                                             "2/files/upload_session/start",
                                                             null,
                                                             false,
                                                             null);
        return new UploadSessionStartUploader(uploader);
    }

    //
    // route files/upload_session/append
    //

    /**
     * Append more data to an upload session. A single request should not upload
     * more than 150 MB of file contents.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
     UploadSessionAppendUploader uploadSessionAppend(UploadSessionCursor uploadSessionCursor) throws DbxException {
        HttpRequestor.Uploader uploader = client.uploadStyle(client.getHost().getContent(),
                                                             "2/files/upload_session/append",
                                                             uploadSessionCursor,
                                                             false,
                                                             UploadSessionCursor._JSON_WRITER);
        return new UploadSessionAppendUploader(uploader);
    }

    /**
     * Append more data to an upload session. A single request should not upload
     * more than 150 MB of file contents.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link UploadSessionCursor} for more details. </p>
     *
     * @param sessionId  The upload session ID (returned by {@link
     *     DbxFiles#uploadSessionStart()}). Must not be {@code null}.
     * @param offset  The amount of data that has been uploaded so far. We use
     *     this to make sure upload data isn't lost or duplicated in the event
     *     of a network error.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionAppendUploader uploadSessionAppend(String sessionId, long offset) throws DbxException {
        UploadSessionCursor arg = new UploadSessionCursor(sessionId, offset);
        return uploadSessionAppend(arg);
    }

    //
    // route files/upload_session/finish
    //

    /**
     * Finish an upload session and save the uploaded data to the given file
     * path. A single request should not upload more than 150 MB of file
     * contents.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
     UploadSessionFinishUploader uploadSessionFinish(UploadSessionFinishArg uploadSessionFinishArg) throws DbxException {
        HttpRequestor.Uploader uploader = client.uploadStyle(client.getHost().getContent(),
                                                             "2/files/upload_session/finish",
                                                             uploadSessionFinishArg,
                                                             false,
                                                             UploadSessionFinishArg._JSON_WRITER);
        return new UploadSessionFinishUploader(uploader);
    }

    /**
     * Finish an upload session and save the uploaded data to the given file
     * path. A single request should not upload more than 150 MB of file
     * contents.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link UploadSessionFinishArg} for more details. </p>
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     * @param commit  Contains the path and other optional modifiers for the
     *     commit. Must not be {@code null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionFinishUploader uploadSessionFinish(UploadSessionCursor cursor, CommitInfo commit) throws DbxException {
        UploadSessionFinishArg arg = new UploadSessionFinishArg(cursor, commit);
        return uploadSessionFinish(arg);
    }

    //
    // route files/upload
    //

    /**
     * Create a new file with the contents provided in the request. Do not use
     * this to upload a file larger than 150 MB. Instead, create an upload
     * session with {@link DbxFiles#uploadSessionStart()}.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
     UploadUploader upload(CommitInfo commitInfo) throws DbxException {
        HttpRequestor.Uploader uploader = client.uploadStyle(client.getHost().getContent(),
                                                             "2/files/upload",
                                                             commitInfo,
                                                             false,
                                                             CommitInfo._JSON_WRITER);
        return new UploadUploader(uploader);
    }

    /**
     * Create a new file with the contents provided in the request. Do not use
     * this to upload a file larger than 150 MB. Instead, create an upload
     * session with {@link DbxFiles#uploadSessionStart()}.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link CommitInfo} for more details. </p>
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code /.*}" and not be {@code null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadUploader upload(String path) throws DbxException {
        CommitInfo arg = new CommitInfo(path);
        return upload(arg);
    }

    /**
     * Create a new file with the contents provided in the request. Do not use
     * this to upload a file larger than 150 MB. Instead, create an upload
     * session with {@link DbxFiles#uploadSessionStart()}.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code /.*}" and not be {@code null}.
     *
     * @return Uploader builder for configuring request parameters and
     *     instantiating an uploader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadBuilder uploadBuilder(String path) {
        CommitInfo.Builder argBuilder = CommitInfo.newBuilder(path);
        return new UploadBuilder(this, argBuilder);
    }

    //
    // route files/search
    //

    /**
     * Searches for files and folders.
     *
     */
     SearchResult search(SearchArg searchArg) throws SearchErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/search",
                                   searchArg,
                                   false,
                                   SearchArg._JSON_WRITER,
                                   SearchResult._JSON_READER,
                                   SearchError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new SearchErrorException(ew.getRequestId(), ew.getUserMessage(), (SearchError) ew.getErrorValue());
        }
    }

    /**
     * Searches for files and folders.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link SearchArg} for more details. </p>
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code (/.*)?}" and not be {@code
     *     null}.
     * @param query  The string to search for. The search string is split on
     *     spaces into multiple tokens. For file name searching, the last token
     *     is used for prefix matching (i.e. "bat c" matches "bat cave" but not
     *     "batman car"). Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchResult search(String path, String query) throws SearchErrorException, DbxException {
        SearchArg arg = new SearchArg(path, query);
        return search(arg);
    }

    /**
     * Searches for files and folders.
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code (/.*)?}" and not be {@code
     *     null}.
     * @param query  The string to search for. The search string is split on
     *     spaces into multiple tokens. For file name searching, the last token
     *     is used for prefix matching (i.e. "bat c" matches "bat cave" but not
     *     "batman car"). Must not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchBuilder searchBuilder(String path, String query) {
        SearchArg.Builder argBuilder = SearchArg.newBuilder(path, query);
        return new SearchBuilder(this, argBuilder);
    }

    //
    // route files/create_folder
    //

    /**
     * Create a folder at a given path.
     *
     */
     FolderMetadata createFolder(CreateFolderArg createFolderArg) throws CreateFolderErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/create_folder",
                                   createFolderArg,
                                   false,
                                   CreateFolderArg._JSON_WRITER,
                                   FolderMetadata._JSON_READER,
                                   CreateFolderError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new CreateFolderErrorException(ew.getRequestId(), ew.getUserMessage(), (CreateFolderError) ew.getErrorValue());
        }
    }

    /**
     * Create a folder at a given path.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link CreateFolderArg} for more details. </p>
     *
     * @param path  Path in the user's Dropbox to create. Must match pattern
     *     "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FolderMetadata createFolder(String path) throws CreateFolderErrorException, DbxException {
        CreateFolderArg arg = new CreateFolderArg(path);
        return createFolder(arg);
    }

    //
    // route files/delete
    //

    /**
     * Delete the file or folder at a given path. If the path is a folder, all
     * its contents will be deleted too.
     *
     *
     * @return Metadata for a file or folder.
     */
     Metadata delete(DeleteArg deleteArg) throws DeleteErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/delete",
                                   deleteArg,
                                   false,
                                   DeleteArg._JSON_WRITER,
                                   Metadata._JSON_READER,
                                   DeleteError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DeleteErrorException(ew.getRequestId(), ew.getUserMessage(), (DeleteError) ew.getErrorValue());
        }
    }

    /**
     * Delete the file or folder at a given path. If the path is a folder, all
     * its contents will be deleted too.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link DeleteArg} for more details. </p>
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code /.*}" and not be {@code null}.
     *
     * @return Metadata for a file or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Metadata delete(String path) throws DeleteErrorException, DbxException {
        DeleteArg arg = new DeleteArg(path);
        return delete(arg);
    }

    //
    // route files/permanently_delete
    //

    /**
     * Permanently delete the file or folder at a given path (see
     * https://www.dropbox.com/en/help/40). Note: This endpoint is only
     * available for Dropbox Business apps.
     *
     */
     void permanentlyDelete(DeleteArg deleteArg) throws DeleteErrorException, DbxException {
        try {
            client.rpcStyle(client.getHost().getApi(),
                            "2/files/permanently_delete",
                            deleteArg,
                            false,
                            DeleteArg._JSON_WRITER,
                            JsonReader.VoidReader,
                            DeleteError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new DeleteErrorException(ew.getRequestId(), ew.getUserMessage(), (DeleteError) ew.getErrorValue());
        }
    }

    /**
     * Permanently delete the file or folder at a given path (see
     * https://www.dropbox.com/en/help/40). Note: This endpoint is only
     * available for Dropbox Business apps.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link DeleteArg} for more details. </p>
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void permanentlyDelete(String path) throws DeleteErrorException, DbxException {
        DeleteArg arg = new DeleteArg(path);
        permanentlyDelete(arg);
    }

    //
    // route files/copy
    //

    /**
     * Copy a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be copied.
     *
     *
     * @return Metadata for a file or folder.
     */
     Metadata copy(RelocationArg relocationArg) throws RelocationErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/copy",
                                   relocationArg,
                                   false,
                                   RelocationArg._JSON_WRITER,
                                   Metadata._JSON_READER,
                                   RelocationError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RelocationErrorException(ew.getRequestId(), ew.getUserMessage(), (RelocationError) ew.getErrorValue());
        }
    }

    /**
     * Copy a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be copied.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link RelocationArg} for more details. </p>
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     *
     * @return Metadata for a file or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Metadata copy(String fromPath, String toPath) throws RelocationErrorException, DbxException {
        RelocationArg arg = new RelocationArg(fromPath, toPath);
        return copy(arg);
    }

    //
    // route files/move
    //

    /**
     * Move a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be moved.
     *
     *
     * @return Metadata for a file or folder.
     */
     Metadata move(RelocationArg relocationArg) throws RelocationErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/move",
                                   relocationArg,
                                   false,
                                   RelocationArg._JSON_WRITER,
                                   Metadata._JSON_READER,
                                   RelocationError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RelocationErrorException(ew.getRequestId(), ew.getUserMessage(), (RelocationError) ew.getErrorValue());
        }
    }

    /**
     * Move a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be moved.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link RelocationArg} for more details. </p>
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     *
     * @return Metadata for a file or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public Metadata move(String fromPath, String toPath) throws RelocationErrorException, DbxException {
        RelocationArg arg = new RelocationArg(fromPath, toPath);
        return move(arg);
    }

    //
    // route files/get_thumbnail
    //

    /**
     * Get a thumbnail for an image. This method currently supports files with
     * the following file extensions: jpg, jpeg, png, tiff, tif, gif and bmp.
     * Photos that are larger than 20MB in size won't be converted to a
     * thumbnail.
     *
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
     DbxDownloader<FileMetadata> getThumbnail(ThumbnailArg thumbnailArg) throws ThumbnailErrorException, DbxException {
        try {
            return client.downloadStyle(client.getHost().getContent(),
                                        "2/files/get_thumbnail",
                                        thumbnailArg,
                                        false,
                                        ThumbnailArg._JSON_WRITER,
                                        FileMetadata._JSON_READER,
                                        ThumbnailError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ThumbnailErrorException(ew.getRequestId(), ew.getUserMessage(), (ThumbnailError) ew.getErrorValue());
        }
    }

    /**
     * Get a thumbnail for an image. This method currently supports files with
     * the following file extensions: jpg, jpeg, png, tiff, tif, gif and bmp.
     * Photos that are larger than 20MB in size won't be converted to a
     * thumbnail.
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ThumbnailArg} for more details. </p>
     *
     * @param path  The path to the image file you want to thumbnail. Must match
     *     pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code
     *     null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<FileMetadata> getThumbnail(String path) throws ThumbnailErrorException, DbxException {
        ThumbnailArg arg = new ThumbnailArg(path);
        return getThumbnail(arg);
    }

    /**
     * Get a thumbnail for an image. This method currently supports files with
     * the following file extensions: jpg, jpeg, png, tiff, tif, gif and bmp.
     * Photos that are larger than 20MB in size won't be converted to a
     * thumbnail.
     *
     * @param path  The path to the image file you want to thumbnail. Must match
     *     pattern "{@code ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code
     *     null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetThumbnailBuilder getThumbnailBuilder(String path) {
        ThumbnailArg.Builder argBuilder = ThumbnailArg.newBuilder(path);
        return new GetThumbnailBuilder(this, argBuilder);
    }

    //
    // route files/get_preview
    //

    /**
     * Get a preview for a file. Currently previews are only generated for the
     * files with  the following extensions: .doc, .docx, .docm, .ppt, .pps,
     * .ppsx, .ppsm, .pptx, .pptm,  .xls, .xlsx, .xlsm, .rtf
     *
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
     DbxDownloader<FileMetadata> getPreview(PreviewArg previewArg) throws PreviewErrorException, DbxException {
        try {
            return client.downloadStyle(client.getHost().getContent(),
                                        "2/files/get_preview",
                                        previewArg,
                                        false,
                                        PreviewArg._JSON_WRITER,
                                        FileMetadata._JSON_READER,
                                        PreviewError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new PreviewErrorException(ew.getRequestId(), ew.getUserMessage(), (PreviewError) ew.getErrorValue());
        }
    }

    /**
     * Get a preview for a file. Currently previews are only generated for the
     * files with  the following extensions: .doc, .docx, .docm, .ppt, .pps,
     * .ppsx, .ppsm, .pptx, .pptm,  .xls, .xlsx, .xlsm, .rtf
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link PreviewArg} for more details. </p>
     *
     * @param path  The path of the file to preview. Must match pattern "{@code
     *     ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<FileMetadata> getPreview(String path) throws PreviewErrorException, DbxException {
        PreviewArg arg = new PreviewArg(path);
        return getPreview(arg);
    }

    /**
     * Get a preview for a file. Currently previews are only generated for the
     * files with  the following extensions: .doc, .docx, .docm, .ppt, .pps,
     * .ppsx, .ppsm, .pptx, .pptm,  .xls, .xlsx, .xlsm, .rtf
     *
     * @param path  The path of the file to preview. Must match pattern "{@code
     *     ((/|id:).*)|(rev:[0-9a-f]{9,})}" and not be {@code null}.
     * @param rev  Deprecated. Please specify revision in :field:'path' instead.
     *     Must have length of at least 9 and match pattern "{@code [0-9a-f]+}".
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<FileMetadata> getPreview(String path, String rev) throws PreviewErrorException, DbxException {
        if (rev != null) {
            if (rev.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
        }
        PreviewArg arg = new PreviewArg(path, rev);
        return getPreview(arg);
    }

    //
    // route files/list_revisions
    //

    /**
     * Return revisions of a file
     *
     */
     ListRevisionsResult listRevisions(ListRevisionsArg listRevisionsArg) throws ListRevisionsErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/list_revisions",
                                   listRevisionsArg,
                                   false,
                                   ListRevisionsArg._JSON_WRITER,
                                   ListRevisionsResult._JSON_READER,
                                   ListRevisionsError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new ListRevisionsErrorException(ew.getRequestId(), ew.getUserMessage(), (ListRevisionsError) ew.getErrorValue());
        }
    }

    /**
     * Return revisions of a file
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link ListRevisionsArg} for more details. </p>
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsResult listRevisions(String path) throws ListRevisionsErrorException, DbxException {
        ListRevisionsArg arg = new ListRevisionsArg(path);
        return listRevisions(arg);
    }

    /**
     * Return revisions of a file
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /.*}" and not be {@code null}.
     * @param limit  The maximum number of revision entries returned. Must be
     *     greater than or equal to 1 and be less than or equal to 100.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsResult listRevisions(String path, long limit) throws ListRevisionsErrorException, DbxException {
        if (limit < 1L) {
            throw new IllegalArgumentException("Number 'limit' is smaller than 1L");
        }
        if (limit > 100L) {
            throw new IllegalArgumentException("Number 'limit' is larger than 100L");
        }
        ListRevisionsArg arg = new ListRevisionsArg(path, limit);
        return listRevisions(arg);
    }

    //
    // route files/restore
    //

    /**
     * Restore a file to a specific revision
     *
     */
     FileMetadata restore(RestoreArg restoreArg) throws RestoreErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/restore",
                                   restoreArg,
                                   false,
                                   RestoreArg._JSON_WRITER,
                                   FileMetadata._JSON_READER,
                                   RestoreError._JSON_READER);
        }
        catch (DbxRequestUtil.ErrorWrapper ew) {
            throw new RestoreErrorException(ew.getRequestId(), ew.getUserMessage(), (RestoreError) ew.getErrorValue());
        }
    }

    /**
     * Restore a file to a specific revision
     *
     * <p> The default values for the remaining request parameters will be used.
     * See {@link RestoreArg} for more details. </p>
     *
     * @param path  The path to the file you want to restore. Must match pattern
     *     "{@code /.*}" and not be {@code null}.
     * @param rev  The revision to restore for the file. Must have length of at
     *     least 9, match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileMetadata restore(String path, String rev) throws RestoreErrorException, DbxException {
        RestoreArg arg = new RestoreArg(path, rev);
        return restore(arg);
    }
}
