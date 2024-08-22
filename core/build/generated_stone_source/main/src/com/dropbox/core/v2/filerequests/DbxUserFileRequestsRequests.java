/* DO NOT EDIT */
/* This file was generated from file_requests.stone */

package com.dropbox.core.v2.filerequests;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "file_requests".
 */
public class DbxUserFileRequestsRequests {
    // namespace file_requests (file_requests.stone)

    private final DbxRawClientV2 client;

    public DbxUserFileRequestsRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/file_requests/count
    //

    /**
     * Returns the total number of file requests owned by this user. Includes
     * both open and closed file requests.
     *
     * @return Result for {@link DbxUserFileRequestsRequests#count}.
     */
    public CountFileRequestsResult count() throws CountFileRequestsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_requests/count",
                                        null,
                                        false,
                                        com.dropbox.core.stone.StoneSerializers.void_(),
                                        CountFileRequestsResult.Serializer.INSTANCE,
                                        CountFileRequestsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new CountFileRequestsErrorException("2/file_requests/count", ex.getRequestId(), ex.getUserMessage(), (CountFileRequestsError) ex.getErrorValue());
        }
    }

    //
    // route 2/file_requests/create
    //

    /**
     * Creates a file request for this user.
     *
     * @param arg  Arguments for {@link
     *     DbxUserFileRequestsRequests#create(String,String)}.
     *
     * @return A <a href="https://www.dropbox.com/help/9090">file request</a>
     *     for receiving files into the user's Dropbox account.
     */
    FileRequest create(CreateFileRequestArgs arg) throws CreateFileRequestErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_requests/create",
                                        arg,
                                        false,
                                        CreateFileRequestArgs.Serializer.INSTANCE,
                                        FileRequest.Serializer.INSTANCE,
                                        CreateFileRequestError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new CreateFileRequestErrorException("2/file_requests/create", ex.getRequestId(), ex.getUserMessage(), (CreateFileRequestError) ex.getErrorValue());
        }
    }

    /**
     * Creates a file request for this user.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link CreateBuilder} for more details. </p>
     *
     * @param title  The title of the file request. Must not be empty. Must have
     *     length of at least 1 and not be {@code null}.
     * @param destination  The path of the folder in the Dropbox where uploaded
     *     files will be sent. For apps with the app folder permission, this
     *     will be relative to the app folder. Must match pattern "{@code
     *     /(.|[\\r\\n])*}" and not be {@code null}.
     *
     * @return A <a href="https://www.dropbox.com/help/9090">file request</a>
     *     for receiving files into the user's Dropbox account.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequest create(String title, String destination) throws CreateFileRequestErrorException, DbxException {
        CreateFileRequestArgs _arg = new CreateFileRequestArgs(title, destination);
        return create(_arg);
    }

    /**
     * Creates a file request for this user.
     *
     * @param title  The title of the file request. Must not be empty. Must have
     *     length of at least 1 and not be {@code null}.
     * @param destination  The path of the folder in the Dropbox where uploaded
     *     files will be sent. For apps with the app folder permission, this
     *     will be relative to the app folder. Must match pattern "{@code
     *     /(.|[\\r\\n])*}" and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateBuilder createBuilder(String title, String destination) {
        CreateFileRequestArgs.Builder argBuilder_ = CreateFileRequestArgs.newBuilder(title, destination);
        return new CreateBuilder(this, argBuilder_);
    }

    //
    // route 2/file_requests/delete
    //

    /**
     * Delete a batch of closed file requests.
     *
     * @param arg  Arguments for {@link
     *     DbxUserFileRequestsRequests#delete(List)}.
     *
     * @return Result for {@link DbxUserFileRequestsRequests#delete(List)}.
     */
    DeleteFileRequestsResult delete(DeleteFileRequestArgs arg) throws DeleteFileRequestErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_requests/delete",
                                        arg,
                                        false,
                                        DeleteFileRequestArgs.Serializer.INSTANCE,
                                        DeleteFileRequestsResult.Serializer.INSTANCE,
                                        DeleteFileRequestError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DeleteFileRequestErrorException("2/file_requests/delete", ex.getRequestId(), ex.getUserMessage(), (DeleteFileRequestError) ex.getErrorValue());
        }
    }

    /**
     * Delete a batch of closed file requests.
     *
     * @param ids  List IDs of the file requests to delete. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @return Result for {@link DbxUserFileRequestsRequests#delete(List)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteFileRequestsResult delete(List<String> ids) throws DeleteFileRequestErrorException, DbxException {
        DeleteFileRequestArgs _arg = new DeleteFileRequestArgs(ids);
        return delete(_arg);
    }

    //
    // route 2/file_requests/delete_all_closed
    //

    /**
     * Delete all closed file requests owned by this user.
     *
     * @return Result for {@link DbxUserFileRequestsRequests#deleteAllClosed}.
     */
    public DeleteAllClosedFileRequestsResult deleteAllClosed() throws DeleteAllClosedFileRequestsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_requests/delete_all_closed",
                                        null,
                                        false,
                                        com.dropbox.core.stone.StoneSerializers.void_(),
                                        DeleteAllClosedFileRequestsResult.Serializer.INSTANCE,
                                        DeleteAllClosedFileRequestsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DeleteAllClosedFileRequestsErrorException("2/file_requests/delete_all_closed", ex.getRequestId(), ex.getUserMessage(), (DeleteAllClosedFileRequestsError) ex.getErrorValue());
        }
    }

    //
    // route 2/file_requests/get
    //

    /**
     * Returns the specified file request.
     *
     * @param arg  Arguments for {@link
     *     DbxUserFileRequestsRequests#get(String)}.
     *
     * @return A <a href="https://www.dropbox.com/help/9090">file request</a>
     *     for receiving files into the user's Dropbox account.
     */
    FileRequest get(GetFileRequestArgs arg) throws GetFileRequestErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_requests/get",
                                        arg,
                                        false,
                                        GetFileRequestArgs.Serializer.INSTANCE,
                                        FileRequest.Serializer.INSTANCE,
                                        GetFileRequestError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetFileRequestErrorException("2/file_requests/get", ex.getRequestId(), ex.getUserMessage(), (GetFileRequestError) ex.getErrorValue());
        }
    }

    /**
     * Returns the specified file request.
     *
     * @param id  The ID of the file request to retrieve. Must have length of at
     *     least 1, match pattern "{@code [-_0-9a-zA-Z]+}", and not be {@code
     *     null}.
     *
     * @return A <a href="https://www.dropbox.com/help/9090">file request</a>
     *     for receiving files into the user's Dropbox account.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequest get(String id) throws GetFileRequestErrorException, DbxException {
        GetFileRequestArgs _arg = new GetFileRequestArgs(id);
        return get(_arg);
    }

    //
    // route 2/file_requests/list
    //

    /**
     * Returns a list of file requests owned by this user. For apps with the app
     * folder permission, this will only return file requests with destinations
     * in the app folder.
     *
     * @return Result for {@link DbxUserFileRequestsRequests#list}.
     */
    public ListFileRequestsResult list() throws ListFileRequestsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_requests/list",
                                        null,
                                        false,
                                        com.dropbox.core.stone.StoneSerializers.void_(),
                                        ListFileRequestsResult.Serializer.INSTANCE,
                                        ListFileRequestsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFileRequestsErrorException("2/file_requests/list", ex.getRequestId(), ex.getUserMessage(), (ListFileRequestsError) ex.getErrorValue());
        }
    }

    //
    // route 2/file_requests/list_v2
    //

    /**
     * Returns a list of file requests owned by this user. For apps with the app
     * folder permission, this will only return file requests with destinations
     * in the app folder.
     *
     * @param arg  Arguments for {@link
     *     DbxUserFileRequestsRequests#listV2(long)}.
     *
     * @return Result for {@link DbxUserFileRequestsRequests#listV2(long)} and
     *     {@link DbxUserFileRequestsRequests#listContinue(String)}.
     */
    ListFileRequestsV2Result listV2(ListFileRequestsArg arg) throws ListFileRequestsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_requests/list_v2",
                                        arg,
                                        false,
                                        ListFileRequestsArg.Serializer.INSTANCE,
                                        ListFileRequestsV2Result.Serializer.INSTANCE,
                                        ListFileRequestsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFileRequestsErrorException("2/file_requests/list_v2", ex.getRequestId(), ex.getUserMessage(), (ListFileRequestsError) ex.getErrorValue());
        }
    }

    /**
     * Returns a list of file requests owned by this user. For apps with the app
     * folder permission, this will only return file requests with destinations
     * in the app folder.
     *
     * <p> The {@code limit} request parameter will default to {@code 1000L}
     * (see {@link #listV2(long)}). </p>
     *
     * @return Result for {@link DbxUserFileRequestsRequests#listV2(long)} and
     *     {@link DbxUserFileRequestsRequests#listContinue(String)}.
     */
    public ListFileRequestsV2Result listV2() throws ListFileRequestsErrorException, DbxException {
        ListFileRequestsArg _arg = new ListFileRequestsArg();
        return listV2(_arg);
    }

    /**
     * Returns a list of file requests owned by this user. For apps with the app
     * folder permission, this will only return file requests with destinations
     * in the app folder.
     *
     * @param limit  The maximum number of file requests that should be returned
     *     per request.
     *
     * @return Result for {@link DbxUserFileRequestsRequests#listV2(long)} and
     *     {@link DbxUserFileRequestsRequests#listContinue(String)}.
     */
    public ListFileRequestsV2Result listV2(long limit) throws ListFileRequestsErrorException, DbxException {
        ListFileRequestsArg _arg = new ListFileRequestsArg(limit);
        return listV2(_arg);
    }

    //
    // route 2/file_requests/list/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserFileRequestsRequests#listV2(long)}, use this to paginate through
     * all file requests. The cursor must come from a previous call to {@link
     * DbxUserFileRequestsRequests#listV2(long)} or {@link
     * DbxUserFileRequestsRequests#listContinue(String)}.
     *
     *
     * @return Result for {@link DbxUserFileRequestsRequests#listV2(long)} and
     *     {@link DbxUserFileRequestsRequests#listContinue(String)}.
     */
    ListFileRequestsV2Result listContinue(ListFileRequestsContinueArg arg) throws ListFileRequestsContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_requests/list/continue",
                                        arg,
                                        false,
                                        ListFileRequestsContinueArg.Serializer.INSTANCE,
                                        ListFileRequestsV2Result.Serializer.INSTANCE,
                                        ListFileRequestsContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFileRequestsContinueErrorException("2/file_requests/list/continue", ex.getRequestId(), ex.getUserMessage(), (ListFileRequestsContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserFileRequestsRequests#listV2(long)}, use this to paginate through
     * all file requests. The cursor must come from a previous call to {@link
     * DbxUserFileRequestsRequests#listV2(long)} or {@link
     * DbxUserFileRequestsRequests#listContinue(String)}.
     *
     * @param cursor  The cursor returned by the previous API call specified in
     *     the endpoint description. Must not be {@code null}.
     *
     * @return Result for {@link DbxUserFileRequestsRequests#listV2(long)} and
     *     {@link DbxUserFileRequestsRequests#listContinue(String)}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFileRequestsV2Result listContinue(String cursor) throws ListFileRequestsContinueErrorException, DbxException {
        ListFileRequestsContinueArg _arg = new ListFileRequestsContinueArg(cursor);
        return listContinue(_arg);
    }

    //
    // route 2/file_requests/update
    //

    /**
     * Update a file request.
     *
     * @param arg  Arguments for {@link
     *     DbxUserFileRequestsRequests#update(String)}.
     *
     * @return A <a href="https://www.dropbox.com/help/9090">file request</a>
     *     for receiving files into the user's Dropbox account.
     */
    FileRequest update(UpdateFileRequestArgs arg) throws UpdateFileRequestErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/file_requests/update",
                                        arg,
                                        false,
                                        UpdateFileRequestArgs.Serializer.INSTANCE,
                                        FileRequest.Serializer.INSTANCE,
                                        UpdateFileRequestError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new UpdateFileRequestErrorException("2/file_requests/update", ex.getRequestId(), ex.getUserMessage(), (UpdateFileRequestError) ex.getErrorValue());
        }
    }

    /**
     * Update a file request.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link UpdateBuilder} for more details. </p>
     *
     * @param id  The ID of the file request to update. Must have length of at
     *     least 1, match pattern "{@code [-_0-9a-zA-Z]+}", and not be {@code
     *     null}.
     *
     * @return A <a href="https://www.dropbox.com/help/9090">file request</a>
     *     for receiving files into the user's Dropbox account.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileRequest update(String id) throws UpdateFileRequestErrorException, DbxException {
        UpdateFileRequestArgs _arg = new UpdateFileRequestArgs(id);
        return update(_arg);
    }

    /**
     * Update a file request.
     *
     * @param id  The ID of the file request to update. Must have length of at
     *     least 1, match pattern "{@code [-_0-9a-zA-Z]+}", and not be {@code
     *     null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UpdateBuilder updateBuilder(String id) {
        UpdateFileRequestArgs.Builder argBuilder_ = UpdateFileRequestArgs.newBuilder(id);
        return new UpdateBuilder(this, argBuilder_);
    }
}
