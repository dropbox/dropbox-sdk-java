/* DO NOT EDIT */
/* This file was generated from files_properties.stone, files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxDownloadStyleBuilder;
import com.dropbox.core.v2.DbxRawClientV2;
import com.dropbox.core.v2.DbxUploadStyleBuilder;
import com.dropbox.core.v2.async.PollArg;
import com.dropbox.core.v2.async.PollErrorException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "files" that support user auth.
 */
public final class DbxUserFilesRequests {
    // namespace files

    private final DbxRawClientV2 client;

    public DbxUserFilesRequests(DbxRawClientV2 client) {
        this.client = client;
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
                                   RelocationArg.Serializer.INSTANCE,
                                   Metadata.Serializer.INSTANCE,
                                   RelocationError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RelocationErrorException(ex.getRequestId(), ex.getUserMessage(), (RelocationError) ex.getErrorValue());
        }
    }

    /**
     * Copy a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be copied.
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
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
    // route files/copy_reference/get
    //

    /**
     * Get a copy reference to a file or folder. This reference string can be
     * used to save that file or folder to another user's Dropbox by passing it
     * to {@link DbxUserFilesRequests#copyReferenceSave(String,String)}.
     *
     */
    GetCopyReferenceResult copyReferenceGet(GetCopyReferenceArg getCopyReferenceArg) throws GetCopyReferenceErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/copy_reference/get",
                                   getCopyReferenceArg,
                                   false,
                                   GetCopyReferenceArg.Serializer.INSTANCE,
                                   GetCopyReferenceResult.Serializer.INSTANCE,
                                   GetCopyReferenceError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetCopyReferenceErrorException(ex.getRequestId(), ex.getUserMessage(), (GetCopyReferenceError) ex.getErrorValue());
        }
    }

    /**
     * Get a copy reference to a file or folder. This reference string can be
     * used to save that file or folder to another user's Dropbox by passing it
     * to {@link DbxUserFilesRequests#copyReferenceSave(String,String)}.
     *
     * @param path  The path to the file or folder you want to get a copy
     *     reference to. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetCopyReferenceResult copyReferenceGet(String path) throws GetCopyReferenceErrorException, DbxException {
        GetCopyReferenceArg arg = new GetCopyReferenceArg(path);
        return copyReferenceGet(arg);
    }

    //
    // route files/copy_reference/save
    //

    /**
     * Save a copy reference returned by {@link
     * DbxUserFilesRequests#copyReferenceGet(String)} to the user's Dropbox.
     *
     */
    SaveCopyReferenceResult copyReferenceSave(SaveCopyReferenceArg saveCopyReferenceArg) throws SaveCopyReferenceErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/copy_reference/save",
                                   saveCopyReferenceArg,
                                   false,
                                   SaveCopyReferenceArg.Serializer.INSTANCE,
                                   SaveCopyReferenceResult.Serializer.INSTANCE,
                                   SaveCopyReferenceError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SaveCopyReferenceErrorException(ex.getRequestId(), ex.getUserMessage(), (SaveCopyReferenceError) ex.getErrorValue());
        }
    }

    /**
     * Save a copy reference returned by {@link
     * DbxUserFilesRequests#copyReferenceGet(String)} to the user's Dropbox.
     *
     * @param copyReference  A copy reference returned by {@link
     *     DbxUserFilesRequests#copyReferenceGet(String)}. Must not be {@code
     *     null}.
     * @param path  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SaveCopyReferenceResult copyReferenceSave(String copyReference, String path) throws SaveCopyReferenceErrorException, DbxException {
        SaveCopyReferenceArg arg = new SaveCopyReferenceArg(copyReference, path);
        return copyReferenceSave(arg);
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
                                   CreateFolderArg.Serializer.INSTANCE,
                                   FolderMetadata.Serializer.INSTANCE,
                                   CreateFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new CreateFolderErrorException(ex.getRequestId(), ex.getUserMessage(), (CreateFolderError) ex.getErrorValue());
        }
    }

    /**
     * Create a folder at a given path.
     *
     * @param path  Path in the user's Dropbox to create. Must match pattern
     *     "{@code /(.|[\\r\\n])*}" and not be {@code null}.
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
     * its contents will be deleted too. A successful response indicates that
     * the file or folder was deleted. The returned metadata will be the
     * corresponding {@link FileMetadata} or {@link FolderMetadata} for the item
     * at time of deletion, and not a {@link DeletedMetadata} object.
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
                                   DeleteArg.Serializer.INSTANCE,
                                   Metadata.Serializer.INSTANCE,
                                   DeleteError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DeleteErrorException(ex.getRequestId(), ex.getUserMessage(), (DeleteError) ex.getErrorValue());
        }
    }

    /**
     * Delete the file or folder at a given path. If the path is a folder, all
     * its contents will be deleted too. A successful response indicates that
     * the file or folder was deleted. The returned metadata will be the
     * corresponding {@link FileMetadata} or {@link FolderMetadata} for the item
     * at time of deletion, and not a {@link DeletedMetadata} object.
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code /(.|[\\r\\n])*}" and not be {@code null}.
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
    // route files/download
    //

    /**
     * Download a file from a user's Dropbox.
     *
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<FileMetadata> download(DownloadArg downloadArg, List<HttpRequestor.Header> headers_) throws DownloadErrorException, DbxException {
        try {
            return client.downloadStyle(client.getHost().getContent(),
                                        "2/files/download",
                                        downloadArg,
                                        false,
                                        headers_,
                                        DownloadArg.Serializer.INSTANCE,
                                        FileMetadata.Serializer.INSTANCE,
                                        DownloadError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DownloadErrorException(ex.getRequestId(), ex.getUserMessage(), (DownloadError) ex.getErrorValue());
        }
    }

    /**
     * Download a file from a user's Dropbox.
     *
     * @param path  The path of the file to download. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<FileMetadata> download(String path) throws DownloadErrorException, DbxException {
        DownloadArg arg = new DownloadArg(path);
        return download(arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Download a file from a user's Dropbox.
     *
     * @param path  The path of the file to download. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     * @param rev  Deprecated. Please specify revision in the {@code path}
     *     argument to {@link DbxUserFilesRequests#download(String)} instead.
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
        return download(arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Download a file from a user's Dropbox.
     *
     * @param path  The path of the file to download. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DownloadBuilder downloadBuilder(String path) {
        DownloadArg arg_ = new DownloadArg(path);
        return new DownloadBuilder(this, path);
    }

    //
    // route files/get_metadata
    //

    /**
     * Returns the metadata for a file or folder. Note: Metadata for the root
     * folder is unsupported.
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
                                   GetMetadataArg.Serializer.INSTANCE,
                                   Metadata.Serializer.INSTANCE,
                                   GetMetadataError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetMetadataErrorException(ex.getRequestId(), ex.getUserMessage(), (GetMetadataError) ex.getErrorValue());
        }
    }

    /**
     * Returns the metadata for a file or folder. Note: Metadata for the root
     * folder is unsupported.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link GetMetadataBuilder} for more details. </p>
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
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
     * Returns the metadata for a file or folder. Note: Metadata for the root
     * folder is unsupported.
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetMetadataBuilder getMetadataBuilder(String path) {
        GetMetadataArg.Builder argBuilder_ = GetMetadataArg.newBuilder(path);
        return new GetMetadataBuilder(this, argBuilder_);
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
    DbxDownloader<FileMetadata> getPreview(PreviewArg previewArg, List<HttpRequestor.Header> headers_) throws PreviewErrorException, DbxException {
        try {
            return client.downloadStyle(client.getHost().getContent(),
                                        "2/files/get_preview",
                                        previewArg,
                                        false,
                                        headers_,
                                        PreviewArg.Serializer.INSTANCE,
                                        FileMetadata.Serializer.INSTANCE,
                                        PreviewError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PreviewErrorException(ex.getRequestId(), ex.getUserMessage(), (PreviewError) ex.getErrorValue());
        }
    }

    /**
     * Get a preview for a file. Currently previews are only generated for the
     * files with  the following extensions: .doc, .docx, .docm, .ppt, .pps,
     * .ppsx, .ppsm, .pptx, .pptm,  .xls, .xlsx, .xlsm, .rtf
     *
     * @param path  The path of the file to preview. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<FileMetadata> getPreview(String path) throws PreviewErrorException, DbxException {
        PreviewArg arg = new PreviewArg(path);
        return getPreview(arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Get a preview for a file. Currently previews are only generated for the
     * files with  the following extensions: .doc, .docx, .docm, .ppt, .pps,
     * .ppsx, .ppsm, .pptx, .pptm,  .xls, .xlsx, .xlsm, .rtf
     *
     * @param path  The path of the file to preview. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     * @param rev  Deprecated. Please specify revision in the {@code path}
     *     argument to {@link DbxUserFilesRequests#getPreview(String)} instead.
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
        return getPreview(arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Get a preview for a file. Currently previews are only generated for the
     * files with  the following extensions: .doc, .docx, .docm, .ppt, .pps,
     * .ppsx, .ppsm, .pptx, .pptm,  .xls, .xlsx, .xlsm, .rtf
     *
     * @param path  The path of the file to preview. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetPreviewBuilder getPreviewBuilder(String path) {
        PreviewArg arg_ = new PreviewArg(path);
        return new GetPreviewBuilder(this, path);
    }

    //
    // route files/get_temporary_link
    //

    /**
     * Get a temporary link to stream content of a file. This link will expire
     * in four hours and afterwards you will get 410 Gone. Content-Type of the
     * link is determined automatically by the file's mime type.
     *
     */
    GetTemporaryLinkResult getTemporaryLink(GetTemporaryLinkArg getTemporaryLinkArg) throws GetTemporaryLinkErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/get_temporary_link",
                                   getTemporaryLinkArg,
                                   false,
                                   GetTemporaryLinkArg.Serializer.INSTANCE,
                                   GetTemporaryLinkResult.Serializer.INSTANCE,
                                   GetTemporaryLinkError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetTemporaryLinkErrorException(ex.getRequestId(), ex.getUserMessage(), (GetTemporaryLinkError) ex.getErrorValue());
        }
    }

    /**
     * Get a temporary link to stream content of a file. This link will expire
     * in four hours and afterwards you will get 410 Gone. Content-Type of the
     * link is determined automatically by the file's mime type.
     *
     * @param path  The path to the file you want a temporary link to. Must
     *     match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTemporaryLinkResult getTemporaryLink(String path) throws GetTemporaryLinkErrorException, DbxException {
        GetTemporaryLinkArg arg = new GetTemporaryLinkArg(path);
        return getTemporaryLink(arg);
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
    DbxDownloader<FileMetadata> getThumbnail(ThumbnailArg thumbnailArg, List<HttpRequestor.Header> headers_) throws ThumbnailErrorException, DbxException {
        try {
            return client.downloadStyle(client.getHost().getContent(),
                                        "2/files/get_thumbnail",
                                        thumbnailArg,
                                        false,
                                        headers_,
                                        ThumbnailArg.Serializer.INSTANCE,
                                        FileMetadata.Serializer.INSTANCE,
                                        ThumbnailError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ThumbnailErrorException(ex.getRequestId(), ex.getUserMessage(), (ThumbnailError) ex.getErrorValue());
        }
    }

    /**
     * Get a thumbnail for an image. This method currently supports files with
     * the following file extensions: jpg, jpeg, png, tiff, tif, gif and bmp.
     * Photos that are larger than 20MB in size won't be converted to a
     * thumbnail.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link GetThumbnailBuilder} for more details. </p>
     *
     * @param path  The path to the image file you want to thumbnail. Must match
     *     pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<FileMetadata> getThumbnail(String path) throws ThumbnailErrorException, DbxException {
        ThumbnailArg arg = new ThumbnailArg(path);
        return getThumbnail(arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Get a thumbnail for an image. This method currently supports files with
     * the following file extensions: jpg, jpeg, png, tiff, tif, gif and bmp.
     * Photos that are larger than 20MB in size won't be converted to a
     * thumbnail.
     *
     * @param path  The path to the image file you want to thumbnail. Must match
     *     pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetThumbnailBuilder getThumbnailBuilder(String path) {
        ThumbnailArg.Builder argBuilder_ = ThumbnailArg.newBuilder(path);
        return new GetThumbnailBuilder(this, argBuilder_);
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
                                   ListFolderArg.Serializer.INSTANCE,
                                   ListFolderResult.Serializer.INSTANCE,
                                   ListFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFolderErrorException(ex.getRequestId(), ex.getUserMessage(), (ListFolderError) ex.getErrorValue());
        }
    }

    /**
     * Returns the contents of a folder.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link ListFolderBuilder} for more details. </p>
     *
     * @param path  The path to the folder you want to see the contents of. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)?}" and not be {@code null}.
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
     *     match pattern "{@code (/(.|[\\r\\n])*)?}" and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderBuilder listFolderBuilder(String path) {
        ListFolderArg.Builder argBuilder_ = ListFolderArg.newBuilder(path);
        return new ListFolderBuilder(this, argBuilder_);
    }

    //
    // route files/list_folder/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserFilesRequests#listFolder(String)}, use this to paginate through
     * all files and retrieve updates to the folder.
     *
     */
    ListFolderResult listFolderContinue(ListFolderContinueArg listFolderContinueArg) throws ListFolderContinueErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/list_folder/continue",
                                   listFolderContinueArg,
                                   false,
                                   ListFolderContinueArg.Serializer.INSTANCE,
                                   ListFolderResult.Serializer.INSTANCE,
                                   ListFolderContinueError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFolderContinueErrorException(ex.getRequestId(), ex.getUserMessage(), (ListFolderContinueError) ex.getErrorValue());
        }
    }

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserFilesRequests#listFolder(String)}, use this to paginate through
     * all files and retrieve updates to the folder.
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxUserFilesRequests#listFolder(String)} or {@link
     *     DbxUserFilesRequests#listFolderContinue(String)}. Must have length of
     *     at least 1 and not be {@code null}.
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
     * DbxUserFilesRequests#listFolder(String)}, {@link
     * DbxUserFilesRequests#listFolderGetLatestCursor(String)} doesn't return
     * any entries. This endpoint is for app which only needs to know about new
     * files and modifications and doesn't need to know about files that already
     * exist in Dropbox.
     *
     */
    ListFolderGetLatestCursorResult listFolderGetLatestCursor(ListFolderArg listFolderArg) throws ListFolderErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/list_folder/get_latest_cursor",
                                   listFolderArg,
                                   false,
                                   ListFolderArg.Serializer.INSTANCE,
                                   ListFolderGetLatestCursorResult.Serializer.INSTANCE,
                                   ListFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFolderErrorException(ex.getRequestId(), ex.getUserMessage(), (ListFolderError) ex.getErrorValue());
        }
    }

    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * DbxUserFilesRequests#listFolder(String)}, {@link
     * DbxUserFilesRequests#listFolderGetLatestCursor(String)} doesn't return
     * any entries. This endpoint is for app which only needs to know about new
     * files and modifications and doesn't need to know about files that already
     * exist in Dropbox.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link ListFolderGetLatestCursorBuilder} for more details. </p>
     *
     * @param path  The path to the folder you want to see the contents of. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)?}" and not be {@code null}.
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
     * DbxUserFilesRequests#listFolder(String)}, {@link
     * DbxUserFilesRequests#listFolderGetLatestCursor(String)} doesn't return
     * any entries. This endpoint is for app which only needs to know about new
     * files and modifications and doesn't need to know about files that already
     * exist in Dropbox.
     *
     * @param path  The path to the folder you want to see the contents of. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)?}" and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderGetLatestCursorBuilder listFolderGetLatestCursorBuilder(String path) {
        ListFolderArg.Builder argBuilder_ = ListFolderArg.newBuilder(path);
        return new ListFolderGetLatestCursorBuilder(this, argBuilder_);
    }

    //
    // route files/list_folder/longpoll
    //

    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link DbxUserFilesRequests#listFolderContinue(String)}, this call
     * gives you a low-latency way to monitor an account for file changes. The
     * connection will block until there are changes available or a timeout
     * occurs. This endpoint is useful mostly for client-side apps. If you're
     * looking for server-side notifications, check out our <a
     * href="https://www.dropbox.com/developers/reference/webhooks">webhooks
     * documentation</a>.
     *
     */
    ListFolderLongpollResult listFolderLongpoll(ListFolderLongpollArg listFolderLongpollArg) throws ListFolderLongpollErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getNotify(),
                                   "2/files/list_folder/longpoll",
                                   listFolderLongpollArg,
                                   true,
                                   ListFolderLongpollArg.Serializer.INSTANCE,
                                   ListFolderLongpollResult.Serializer.INSTANCE,
                                   ListFolderLongpollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFolderLongpollErrorException(ex.getRequestId(), ex.getUserMessage(), (ListFolderLongpollError) ex.getErrorValue());
        }
    }

    /**
     * A longpoll endpoint to wait for changes on an account. In conjunction
     * with {@link DbxUserFilesRequests#listFolderContinue(String)}, this call
     * gives you a low-latency way to monitor an account for file changes. The
     * connection will block until there are changes available or a timeout
     * occurs. This endpoint is useful mostly for client-side apps. If you're
     * looking for server-side notifications, check out our <a
     * href="https://www.dropbox.com/developers/reference/webhooks">webhooks
     * documentation</a>.
     *
     * <p> The {@code timeout} request parameter will default to {@code 30L}
     * (see {@link #listFolderLongpoll(String,long)}). </p>
     *
     * @param cursor  A cursor as returned by {@link
     *     DbxUserFilesRequests#listFolder(String)} or {@link
     *     DbxUserFilesRequests#listFolderContinue(String)}. Cursors retrieved
     *     by setting {@link ListFolderArg#getIncludeMediaInfo} to {@code true}
     *     are not supported. Must have length of at least 1 and not be {@code
     *     null}.
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
     * with {@link DbxUserFilesRequests#listFolderContinue(String)}, this call
     * gives you a low-latency way to monitor an account for file changes. The
     * connection will block until there are changes available or a timeout
     * occurs. This endpoint is useful mostly for client-side apps. If you're
     * looking for server-side notifications, check out our <a
     * href="https://www.dropbox.com/developers/reference/webhooks">webhooks
     * documentation</a>.
     *
     * @param cursor  A cursor as returned by {@link
     *     DbxUserFilesRequests#listFolder(String)} or {@link
     *     DbxUserFilesRequests#listFolderContinue(String)}. Cursors retrieved
     *     by setting {@link ListFolderArg#getIncludeMediaInfo} to {@code true}
     *     are not supported. Must have length of at least 1 and not be {@code
     *     null}.
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
                                   ListRevisionsArg.Serializer.INSTANCE,
                                   ListRevisionsResult.Serializer.INSTANCE,
                                   ListRevisionsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListRevisionsErrorException(ex.getRequestId(), ex.getUserMessage(), (ListRevisionsError) ex.getErrorValue());
        }
    }

    /**
     * Return revisions of a file
     *
     * <p> The {@code limit} request parameter will default to {@code 10L} (see
     * {@link #listRevisions(String,long)}). </p>
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
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
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
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
                                   RelocationArg.Serializer.INSTANCE,
                                   Metadata.Serializer.INSTANCE,
                                   RelocationError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RelocationErrorException(ex.getRequestId(), ex.getUserMessage(), (RelocationError) ex.getErrorValue());
        }
    }

    /**
     * Move a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be moved.
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
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
                            DeleteArg.Serializer.INSTANCE,
                            com.dropbox.core.stone.StoneSerializers.void_(),
                            DeleteError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DeleteErrorException(ex.getRequestId(), ex.getUserMessage(), (DeleteError) ex.getErrorValue());
        }
    }

    /**
     * Permanently delete the file or folder at a given path (see
     * https://www.dropbox.com/en/help/40). Note: This endpoint is only
     * available for Dropbox Business apps.
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void permanentlyDelete(String path) throws DeleteErrorException, DbxException {
        DeleteArg arg = new DeleteArg(path);
        permanentlyDelete(arg);
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
                                   RestoreArg.Serializer.INSTANCE,
                                   FileMetadata.Serializer.INSTANCE,
                                   RestoreError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RestoreErrorException(ex.getRequestId(), ex.getUserMessage(), (RestoreError) ex.getErrorValue());
        }
    }

    /**
     * Restore a file to a specific revision
     *
     * @param path  The path to the file you want to restore. Must match pattern
     *     "{@code /(.|[\\r\\n])*}" and not be {@code null}.
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

    //
    // route files/save_url
    //

    /**
     * Save a specified URL into a file in user's Dropbox. If the given path
     * already exists, the file will be renamed to avoid the conflict (e.g.
     * myfile (1).txt).
     *
     */
    SaveUrlResult saveUrl(SaveUrlArg saveUrlArg) throws SaveUrlErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/save_url",
                                   saveUrlArg,
                                   false,
                                   SaveUrlArg.Serializer.INSTANCE,
                                   SaveUrlResult.Serializer.INSTANCE,
                                   SaveUrlError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SaveUrlErrorException(ex.getRequestId(), ex.getUserMessage(), (SaveUrlError) ex.getErrorValue());
        }
    }

    /**
     * Save a specified URL into a file in user's Dropbox. If the given path
     * already exists, the file will be renamed to avoid the conflict (e.g.
     * myfile (1).txt).
     *
     * @param path  The path in Dropbox where the URL will be saved to. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     * @param url  The URL to be saved. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SaveUrlResult saveUrl(String path, String url) throws SaveUrlErrorException, DbxException {
        SaveUrlArg arg = new SaveUrlArg(path, url);
        return saveUrl(arg);
    }

    //
    // route files/save_url/check_job_status
    //

    /**
     * Check the status of a {@link DbxUserFilesRequests#saveUrl(String,String)}
     * job.
     *
     * @param pollArg  Arguments for methods that poll the status of an
     *     asynchronous job.
     */
    SaveUrlJobStatus saveUrlCheckJobStatus(PollArg pollArg) throws PollErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/save_url/check_job_status",
                                   pollArg,
                                   false,
                                   PollArg.Serializer.INSTANCE,
                                   SaveUrlJobStatus.Serializer.INSTANCE,
                                   com.dropbox.core.v2.async.PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException(ex.getRequestId(), ex.getUserMessage(), (com.dropbox.core.v2.async.PollError) ex.getErrorValue());
        }
    }

    /**
     * Check the status of a {@link DbxUserFilesRequests#saveUrl(String,String)}
     * job.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SaveUrlJobStatus saveUrlCheckJobStatus(String asyncJobId) throws PollErrorException, DbxException {
        PollArg arg = new PollArg(asyncJobId);
        return saveUrlCheckJobStatus(arg);
    }

    //
    // route files/search
    //

    /**
     * Searches for files and folders. Note: Recent changes may not immediately
     * be reflected in search results due to a short delay in indexing.
     *
     */
    SearchResult search(SearchArg searchArg) throws SearchErrorException, DbxException {
        try {
            return client.rpcStyle(client.getHost().getApi(),
                                   "2/files/search",
                                   searchArg,
                                   false,
                                   SearchArg.Serializer.INSTANCE,
                                   SearchResult.Serializer.INSTANCE,
                                   SearchError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SearchErrorException(ex.getRequestId(), ex.getUserMessage(), (SearchError) ex.getErrorValue());
        }
    }

    /**
     * Searches for files and folders. Note: Recent changes may not immediately
     * be reflected in search results due to a short delay in indexing.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link SearchBuilder} for more details. </p>
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code (/(.|[\\r\\n])*)?}" and not be
     *     {@code null}.
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
     * Searches for files and folders. Note: Recent changes may not immediately
     * be reflected in search results due to a short delay in indexing.
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code (/(.|[\\r\\n])*)?}" and not be
     *     {@code null}.
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
        SearchArg.Builder argBuilder_ = SearchArg.newBuilder(path, query);
        return new SearchBuilder(this, argBuilder_);
    }

    //
    // route files/upload
    //

    /**
     * Create a new file with the contents provided in the request. Do not use
     * this to upload a file larger than 150 MB. Instead, create an upload
     * session with {@link DbxUserFilesRequests#uploadSessionStart()}.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    UploadUploader upload(CommitInfo commitInfo) throws DbxException {
        HttpRequestor.Uploader uploader = client.uploadStyle(client.getHost().getContent(),
                                                             "2/files/upload",
                                                             commitInfo,
                                                             false,
                                                             CommitInfo.Serializer.INSTANCE);
        return new UploadUploader(uploader);
    }

    /**
     * Create a new file with the contents provided in the request. Do not use
     * this to upload a file larger than 150 MB. Instead, create an upload
     * session with {@link DbxUserFilesRequests#uploadSessionStart()}.
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link UploadBuilder} for more details. </p>
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
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
     * session with {@link DbxUserFilesRequests#uploadSessionStart()}.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     *
     * @return Uploader builder for configuring request parameters and
     *     instantiating an uploader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadBuilder uploadBuilder(String path) {
        CommitInfo.Builder argBuilder_ = CommitInfo.newBuilder(path);
        return new UploadBuilder(this, argBuilder_);
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
     *
     * @deprecated use {@link
     *     DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}
     *     instead.
     */
    @Deprecated
    UploadSessionAppendUploader uploadSessionAppend(UploadSessionCursor uploadSessionCursor) throws DbxException {
        HttpRequestor.Uploader uploader = client.uploadStyle(client.getHost().getContent(),
                                                             "2/files/upload_session/append",
                                                             uploadSessionCursor,
                                                             false,
                                                             UploadSessionCursor.Serializer.INSTANCE);
        return new UploadSessionAppendUploader(uploader);
    }

    /**
     * Append more data to an upload session. A single request should not upload
     * more than 150 MB of file contents.
     *
     * @param sessionId  The upload session ID (returned by {@link
     *     DbxUserFilesRequests#uploadSessionStart()}). Must not be {@code
     *     null}.
     * @param offset  The amount of data that has been uploaded so far. We use
     *     this to make sure upload data isn't lost or duplicated in the event
     *     of a network error.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link
     *     DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}
     *     instead.
     */
    @Deprecated
    public UploadSessionAppendUploader uploadSessionAppend(String sessionId, long offset) throws DbxException {
        UploadSessionCursor arg = new UploadSessionCursor(sessionId, offset);
        return uploadSessionAppend(arg);
    }

    //
    // route files/upload_session/append_v2
    //

    /**
     * Append more data to an upload session. When the parameter close is set,
     * this call will close the session. A single request should not upload more
     * than 150 MB of file contents.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    UploadSessionAppendV2Uploader uploadSessionAppendV2(UploadSessionAppendArg uploadSessionAppendArg) throws DbxException {
        HttpRequestor.Uploader uploader = client.uploadStyle(client.getHost().getContent(),
                                                             "2/files/upload_session/append_v2",
                                                             uploadSessionAppendArg,
                                                             false,
                                                             UploadSessionAppendArg.Serializer.INSTANCE);
        return new UploadSessionAppendV2Uploader(uploader);
    }

    /**
     * Append more data to an upload session. When the parameter close is set,
     * this call will close the session. A single request should not upload more
     * than 150 MB of file contents.
     *
     * <p> The {@code close} request parameter will default to {@code false}
     * (see {@link #uploadSessionAppendV2(UploadSessionCursor,boolean)}). </p>
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionAppendV2Uploader uploadSessionAppendV2(UploadSessionCursor cursor) throws DbxException {
        UploadSessionAppendArg arg = new UploadSessionAppendArg(cursor);
        return uploadSessionAppendV2(arg);
    }

    /**
     * Append more data to an upload session. When the parameter close is set,
     * this call will close the session. A single request should not upload more
     * than 150 MB of file contents.
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     * @param close  If true, the current session will be closed, at which point
     *     you won't be able to call {@link
     *     DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}
     *     anymore with the current session.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionAppendV2Uploader uploadSessionAppendV2(UploadSessionCursor cursor, boolean close) throws DbxException {
        UploadSessionAppendArg arg = new UploadSessionAppendArg(cursor, close);
        return uploadSessionAppendV2(arg);
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
                                                             UploadSessionFinishArg.Serializer.INSTANCE);
        return new UploadSessionFinishUploader(uploader);
    }

    /**
     * Finish an upload session and save the uploaded data to the given file
     * path. A single request should not upload more than 150 MB of file
     * contents.
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
    // route files/upload_session/start
    //

    /**
     * Upload sessions allow you to upload a single file using multiple
     * requests. This call starts a new upload session with the given data.  You
     * can then use {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} to add
     * more data and {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo)}
     * to save all the data to a file in Dropbox. A single request should not
     * upload more than 150 MB of file contents.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    UploadSessionStartUploader uploadSessionStart(UploadSessionStartArg uploadSessionStartArg) throws DbxException {
        HttpRequestor.Uploader uploader = client.uploadStyle(client.getHost().getContent(),
                                                             "2/files/upload_session/start",
                                                             uploadSessionStartArg,
                                                             false,
                                                             UploadSessionStartArg.Serializer.INSTANCE);
        return new UploadSessionStartUploader(uploader);
    }

    /**
     * Upload sessions allow you to upload a single file using multiple
     * requests. This call starts a new upload session with the given data.  You
     * can then use {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} to add
     * more data and {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo)}
     * to save all the data to a file in Dropbox. A single request should not
     * upload more than 150 MB of file contents.
     *
     * <p> The {@code close} request parameter will default to {@code false}
     * (see {@link #uploadSessionStart(boolean)}). </p>
     *
     * @return Uploader used to upload the request body and finish request.
     */
    public UploadSessionStartUploader uploadSessionStart() throws DbxException {
        UploadSessionStartArg arg = new UploadSessionStartArg();
        return uploadSessionStart(arg);
    }

    /**
     * Upload sessions allow you to upload a single file using multiple
     * requests. This call starts a new upload session with the given data.  You
     * can then use {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} to add
     * more data and {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo)}
     * to save all the data to a file in Dropbox. A single request should not
     * upload more than 150 MB of file contents.
     *
     * @param close  If true, the current session will be closed, at which point
     *     you won't be able to call {@link
     *     DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}
     *     anymore with the current session.
     *
     * @return Uploader used to upload the request body and finish request.
     */
    public UploadSessionStartUploader uploadSessionStart(boolean close) throws DbxException {
        UploadSessionStartArg arg = new UploadSessionStartArg(close);
        return uploadSessionStart(arg);
    }
}
