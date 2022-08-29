/* DO NOT EDIT */
/* This file was generated from file_tagging.stone, files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxDownloadStyleBuilder;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "files".
 */
public class DbxAppFilesRequests {
    // namespace files (file_tagging.stone, files.stone)

    private final DbxRawClientV2 client;

    public DbxAppFilesRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/files/get_thumbnail_v2
    //

    /**
     * Get a thumbnail for an image. This method currently supports files with
     * the following file extensions: jpg, jpeg, png, tiff, tif, gif, webp, ppm
     * and bmp. Photos that are larger than 20MB in size won't be converted to a
     * thumbnail.
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<PreviewResult> getThumbnailV2(ThumbnailV2Arg arg, List<HttpRequestor.Header> _headers) throws ThumbnailV2ErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/files/get_thumbnail_v2",
                                             arg,
                                             false,
                                             _headers,
                                             ThumbnailV2Arg.Serializer.INSTANCE,
                                             PreviewResult.Serializer.INSTANCE,
                                             ThumbnailV2Error.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ThumbnailV2ErrorException("2/files/get_thumbnail_v2", ex.getRequestId(), ex.getUserMessage(), (ThumbnailV2Error) ex.getErrorValue());
        }
    }

    /**
     * Get a thumbnail for an image.
     *
     * <p> This method currently supports files with the following file
     * extensions: jpg, jpeg, png, tiff, tif, gif, webp, ppm and bmp. Photos
     * that are larger than 20MB in size won't be converted to a thumbnail. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DbxAppGetThumbnailV2Builder} for more details. </p>
     *
     * @param resource  Information specifying which file to preview. This could
     *     be a path to a file, a shared link pointing to a file, or a shared
     *     link pointing to a folder, with a relative path. Must not be {@code
     *     null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<PreviewResult> getThumbnailV2(PathOrLink resource) throws ThumbnailV2ErrorException, DbxException {
        ThumbnailV2Arg _arg = new ThumbnailV2Arg(resource);
        return getThumbnailV2(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Get a thumbnail for an image. This method currently supports files with
     * the following file extensions: jpg, jpeg, png, tiff, tif, gif, webp, ppm
     * and bmp. Photos that are larger than 20MB in size won't be converted to a
     * thumbnail.
     *
     * @param resource  Information specifying which file to preview. This could
     *     be a path to a file, a shared link pointing to a file, or a shared
     *     link pointing to a folder, with a relative path. Must not be {@code
     *     null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxAppGetThumbnailV2Builder getThumbnailV2Builder(PathOrLink resource) {
        ThumbnailV2Arg.Builder argBuilder_ = ThumbnailV2Arg.newBuilder(resource);
        return new DbxAppGetThumbnailV2Builder(this, argBuilder_);
    }

    //
    // route 2/files/list_folder
    //

    /**
     * Starts returning the contents of a folder. If the result's {@link
     * ListFolderResult#getHasMore} field is {@code true}, call {@link
     * DbxAppFilesRequests#listFolderContinue(String)} with the returned {@link
     * ListFolderResult#getCursor} to retrieve more entries. If you're using
     * {@link ListFolderArg#getRecursive} set to {@code true} to keep a local
     * cache of the contents of a Dropbox account, iterate through each entry in
     * order and process them as follows to keep your local state in sync: For
     * each {@link FileMetadata}, store the new entry at the given path in your
     * local state. If the required parent folders don't exist yet, create them.
     * If there's already something else at the given path, replace it and
     * remove all its children. For each {@link FolderMetadata}, store the new
     * entry at the given path in your local state. If the required parent
     * folders don't exist yet, create them. If there's already something else
     * at the given path, replace it but leave the children as they are. Check
     * the new entry's {@link FolderSharingInfo#getReadOnly} and set all its
     * children's read-only statuses to match. For each {@link DeletedMetadata},
     * if your local state has something at the given path, remove it and all
     * its children. If there's nothing at the given path, ignore this entry.
     * Note: {@link com.dropbox.core.v2.auth.RateLimitError} may be returned if
     * multiple {@link DbxAppFilesRequests#listFolder(String)} or {@link
     * DbxAppFilesRequests#listFolderContinue(String)} calls with same
     * parameters are made simultaneously by same API app for same user. If your
     * app implements retry logic, please hold off the retry until the previous
     * request finishes.
     *
     */
    ListFolderResult listFolder(ListFolderArg arg) throws ListFolderErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/list_folder",
                                        arg,
                                        false,
                                        ListFolderArg.Serializer.INSTANCE,
                                        ListFolderResult.Serializer.INSTANCE,
                                        ListFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFolderErrorException("2/files/list_folder", ex.getRequestId(), ex.getUserMessage(), (ListFolderError) ex.getErrorValue());
        }
    }

    /**
     * Starts returning the contents of a folder. If the result's {@link
     * ListFolderResult#getHasMore} field is {@code true}, call {@link
     * DbxAppFilesRequests#listFolderContinue(String)} with the returned {@link
     * ListFolderResult#getCursor} to retrieve more entries.
     *
     * <p> If you're using {@link ListFolderArg#getRecursive} set to {@code
     * true} to keep a local cache of the contents of a Dropbox account, iterate
     * through each entry in order and process them as follows to keep your
     * local state in sync: </p>
     *
     * <p> For each {@link FileMetadata}, store the new entry at the given path
     * in your local state. If the required parent folders don't exist yet,
     * create them. If there's already something else at the given path, replace
     * it and remove all its children. </p>
     *
     * <p> For each {@link FolderMetadata}, store the new entry at the given
     * path in your local state. If the required parent folders don't exist yet,
     * create them. If there's already something else at the given path, replace
     * it but leave the children as they are. Check the new entry's {@link
     * FolderSharingInfo#getReadOnly} and set all its children's read-only
     * statuses to match. </p>
     *
     * <p> For each {@link DeletedMetadata}, if your local state has something
     * at the given path, remove it and all its children. If there's nothing at
     * the given path, ignore this entry. </p>
     *
     * <p> Note: {@link com.dropbox.core.v2.auth.RateLimitError} may be returned
     * if multiple {@link DbxAppFilesRequests#listFolder(String)} or {@link
     * DbxAppFilesRequests#listFolderContinue(String)} calls with same
     * parameters are made simultaneously by same API app for same user. If your
     * app implements retry logic, please hold off the retry until the previous
     * request finishes. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DbxAppListFolderBuilder} for more details. </p>
     *
     * @param path  A unique identifier for the file. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderResult listFolder(String path) throws ListFolderErrorException, DbxException {
        ListFolderArg _arg = new ListFolderArg(path);
        return listFolder(_arg);
    }

    /**
     * Starts returning the contents of a folder. If the result's {@link
     * ListFolderResult#getHasMore} field is {@code true}, call {@link
     * DbxAppFilesRequests#listFolderContinue(String)} with the returned {@link
     * ListFolderResult#getCursor} to retrieve more entries. If you're using
     * {@link ListFolderArg#getRecursive} set to {@code true} to keep a local
     * cache of the contents of a Dropbox account, iterate through each entry in
     * order and process them as follows to keep your local state in sync: For
     * each {@link FileMetadata}, store the new entry at the given path in your
     * local state. If the required parent folders don't exist yet, create them.
     * If there's already something else at the given path, replace it and
     * remove all its children. For each {@link FolderMetadata}, store the new
     * entry at the given path in your local state. If the required parent
     * folders don't exist yet, create them. If there's already something else
     * at the given path, replace it but leave the children as they are. Check
     * the new entry's {@link FolderSharingInfo#getReadOnly} and set all its
     * children's read-only statuses to match. For each {@link DeletedMetadata},
     * if your local state has something at the given path, remove it and all
     * its children. If there's nothing at the given path, ignore this entry.
     * Note: {@link com.dropbox.core.v2.auth.RateLimitError} may be returned if
     * multiple {@link DbxAppFilesRequests#listFolder(String)} or {@link
     * DbxAppFilesRequests#listFolderContinue(String)} calls with same
     * parameters are made simultaneously by same API app for same user. If your
     * app implements retry logic, please hold off the retry until the previous
     * request finishes.
     *
     * @param path  A unique identifier for the file. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxAppListFolderBuilder listFolderBuilder(String path) {
        ListFolderArg.Builder argBuilder_ = ListFolderArg.newBuilder(path);
        return new DbxAppListFolderBuilder(this, argBuilder_);
    }

    //
    // route 2/files/list_folder/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxAppFilesRequests#listFolder(String)}, use this to paginate through all
     * files and retrieve updates to the folder, following the same rules as
     * documented for {@link DbxAppFilesRequests#listFolder(String)}.
     *
     */
    ListFolderResult listFolderContinue(ListFolderContinueArg arg) throws ListFolderContinueErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/list_folder/continue",
                                        arg,
                                        false,
                                        ListFolderContinueArg.Serializer.INSTANCE,
                                        ListFolderResult.Serializer.INSTANCE,
                                        ListFolderContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFolderContinueErrorException("2/files/list_folder/continue", ex.getRequestId(), ex.getUserMessage(), (ListFolderContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxAppFilesRequests#listFolder(String)}, use this to paginate through all
     * files and retrieve updates to the folder, following the same rules as
     * documented for {@link DbxAppFilesRequests#listFolder(String)}.
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxAppFilesRequests#listFolder(String)} or {@link
     *     DbxAppFilesRequests#listFolderContinue(String)}. Must have length of
     *     at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderResult listFolderContinue(String cursor) throws ListFolderContinueErrorException, DbxException {
        ListFolderContinueArg _arg = new ListFolderContinueArg(cursor);
        return listFolderContinue(_arg);
    }
}
