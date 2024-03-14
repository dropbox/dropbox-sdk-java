/* DO NOT EDIT */
/* This file was generated from file_tagging.stone, files.stone */

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
import com.dropbox.core.v2.async.PollError;
import com.dropbox.core.v2.async.PollErrorException;
import com.dropbox.core.v2.fileproperties.AddPropertiesArg;
import com.dropbox.core.v2.fileproperties.AddPropertiesError;
import com.dropbox.core.v2.fileproperties.AddPropertiesErrorException;
import com.dropbox.core.v2.fileproperties.GetTemplateArg;
import com.dropbox.core.v2.fileproperties.GetTemplateResult;
import com.dropbox.core.v2.fileproperties.InvalidPropertyGroupError;
import com.dropbox.core.v2.fileproperties.InvalidPropertyGroupErrorException;
import com.dropbox.core.v2.fileproperties.ListTemplateResult;
import com.dropbox.core.v2.fileproperties.OverwritePropertyGroupArg;
import com.dropbox.core.v2.fileproperties.PropertyGroup;
import com.dropbox.core.v2.fileproperties.PropertyGroupUpdate;
import com.dropbox.core.v2.fileproperties.RemovePropertiesArg;
import com.dropbox.core.v2.fileproperties.RemovePropertiesError;
import com.dropbox.core.v2.fileproperties.RemovePropertiesErrorException;
import com.dropbox.core.v2.fileproperties.TemplateError;
import com.dropbox.core.v2.fileproperties.TemplateErrorException;
import com.dropbox.core.v2.fileproperties.UpdatePropertiesArg;
import com.dropbox.core.v2.fileproperties.UpdatePropertiesError;
import com.dropbox.core.v2.fileproperties.UpdatePropertiesErrorException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "files".
 */
public class DbxUserFilesRequests {
    // namespace files (file_tagging.stone, files.stone)

    private final DbxRawClientV2 client;

    public DbxUserFilesRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/files/alpha/get_metadata
    //

    /**
     * Returns the metadata for a file or folder. This is an alpha endpoint
     * compatible with the properties API. Note: Metadata for the root folder is
     * unsupported.
     *
     *
     * @return Metadata for a file or folder.
     */
    Metadata alphaGetMetadata(AlphaGetMetadataArg arg) throws AlphaGetMetadataErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/alpha/get_metadata",
                                        arg,
                                        false,
                                        AlphaGetMetadataArg.Serializer.INSTANCE,
                                        Metadata.Serializer.INSTANCE,
                                        AlphaGetMetadataError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new AlphaGetMetadataErrorException("2/files/alpha/get_metadata", ex.getRequestId(), ex.getUserMessage(), (AlphaGetMetadataError) ex.getErrorValue());
        }
    }

    /**
     * Returns the metadata for a file or folder. This is an alpha endpoint
     * compatible with the properties API.
     *
     * <p> Note: Metadata for the root folder is unsupported. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link AlphaGetMetadataBuilder} for more details. </p>
     *
     * @param path  The path of a file or folder on Dropbox. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @return Metadata for a file or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#getMetadata(String)} instead.
     */
    @Deprecated
    public Metadata alphaGetMetadata(String path) throws AlphaGetMetadataErrorException, DbxException {
        AlphaGetMetadataArg _arg = new AlphaGetMetadataArg(path);
        return alphaGetMetadata(_arg);
    }

    /**
     * Returns the metadata for a file or folder. This is an alpha endpoint
     * compatible with the properties API. Note: Metadata for the root folder is
     * unsupported.
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
     *
     * @deprecated use {@link DbxUserFilesRequests#getMetadata(String)} instead.
     */
    @Deprecated
    public AlphaGetMetadataBuilder alphaGetMetadataBuilder(String path) {
        AlphaGetMetadataArg.Builder argBuilder_ = AlphaGetMetadataArg.newBuilder(path);
        return new AlphaGetMetadataBuilder(this, argBuilder_);
    }

    //
    // route 2/files/alpha/upload
    //

    /**
     * Create a new file with the contents provided in the request. Note that
     * the behavior of this alpha endpoint is unstable and subject to change. Do
     * not use this to upload a file larger than 150 MB. Instead, create an
     * upload session with {@link DbxUserFilesRequests#uploadSessionStart}.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    AlphaUploadUploader alphaUpload(UploadArg arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getContent(),
                                                                   "2/files/alpha/upload",
                                                                   arg,
                                                                   false,
                                                                   UploadArg.Serializer.INSTANCE);
        return new AlphaUploadUploader(_uploader, this.client.getUserId());
    }

    /**
     * Create a new file with the contents provided in the request. Note that
     * the behavior of this alpha endpoint is unstable and subject to change.
     *
     * <p> Do not use this to upload a file larger than 150 MB. Instead, create
     * an upload session with {@link DbxUserFilesRequests#uploadSessionStart}.
     * </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link AlphaUploadBuilder} for more details. </p>
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#upload(String)} instead.
     */
    @Deprecated
    public AlphaUploadUploader alphaUpload(String path) throws DbxException {
        UploadArg _arg = new UploadArg(path);
        return alphaUpload(_arg);
    }

    /**
     * Create a new file with the contents provided in the request. Note that
     * the behavior of this alpha endpoint is unstable and subject to change. Do
     * not use this to upload a file larger than 150 MB. Instead, create an
     * upload session with {@link DbxUserFilesRequests#uploadSessionStart}.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
     *
     * @return Uploader builder for configuring request parameters and
     *     instantiating an uploader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#upload(String)} instead.
     */
    @Deprecated
    public AlphaUploadBuilder alphaUploadBuilder(String path) {
        UploadArg.Builder argBuilder_ = UploadArg.newBuilder(path);
        return new AlphaUploadBuilder(this, argBuilder_);
    }

    //
    // route 2/files/copy_v2
    //

    /**
     * Copy a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be copied.
     *
     */
    RelocationResult copyV2(RelocationArg arg) throws RelocationErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/copy_v2",
                                        arg,
                                        false,
                                        RelocationArg.Serializer.INSTANCE,
                                        RelocationResult.Serializer.INSTANCE,
                                        RelocationError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RelocationErrorException("2/files/copy_v2", ex.getRequestId(), ex.getUserMessage(), (RelocationError) ex.getErrorValue());
        }
    }

    /**
     * Copy a file or folder to a different location in the user's Dropbox.
     *
     * <p> If the source path is a folder all its contents will be copied. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link CopyV2Builder} for more details. </p>
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationResult copyV2(String fromPath, String toPath) throws RelocationErrorException, DbxException {
        RelocationArg _arg = new RelocationArg(fromPath, toPath);
        return copyV2(_arg);
    }

    /**
     * Copy a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be copied.
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CopyV2Builder copyV2Builder(String fromPath, String toPath) {
        RelocationArg.Builder argBuilder_ = RelocationArg.newBuilder(fromPath, toPath);
        return new CopyV2Builder(this, argBuilder_);
    }

    //
    // route 2/files/copy
    //

    /**
     * Copy a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be copied.
     *
     *
     * @return Metadata for a file or folder.
     */
    Metadata copy(RelocationArg arg) throws RelocationErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/copy",
                                        arg,
                                        false,
                                        RelocationArg.Serializer.INSTANCE,
                                        Metadata.Serializer.INSTANCE,
                                        RelocationError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RelocationErrorException("2/files/copy", ex.getRequestId(), ex.getUserMessage(), (RelocationError) ex.getErrorValue());
        }
    }

    /**
     * Copy a file or folder to a different location in the user's Dropbox.
     *
     * <p> If the source path is a folder all its contents will be copied. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link CopyBuilder} for more details. </p>
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     *
     * @return Metadata for a file or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#copyV2(String,String)}
     *     instead.
     */
    @Deprecated
    public Metadata copy(String fromPath, String toPath) throws RelocationErrorException, DbxException {
        RelocationArg _arg = new RelocationArg(fromPath, toPath);
        return copy(_arg);
    }

    /**
     * Copy a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be copied.
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#copyV2(String,String)}
     *     instead.
     */
    @Deprecated
    public CopyBuilder copyBuilder(String fromPath, String toPath) {
        RelocationArg.Builder argBuilder_ = RelocationArg.newBuilder(fromPath, toPath);
        return new CopyBuilder(this, argBuilder_);
    }

    //
    // route 2/files/copy_batch_v2
    //

    /**
     * Copy multiple files or folders to different locations at once in the
     * user's Dropbox. This route will replace {@code copyBatch:1}. The main
     * difference is this route will return status for each entry, while {@code
     * copyBatch:1} raises failure if any entry fails. This route will either
     * finish synchronously, or return a job ID and do the async copy job in
     * background. Please use {@link
     * DbxUserFilesRequests#copyBatchCheckV2(String)} to check the job status.
     *
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#copyBatchV2(List,boolean)} or {@link
     *     DbxUserFilesRequests#moveBatchV2(List)} that may either launch an
     *     asynchronous job or complete synchronously.
     */
    RelocationBatchV2Launch copyBatchV2(RelocationBatchArgBase arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/copy_batch_v2",
                                        arg,
                                        false,
                                        RelocationBatchArgBase.Serializer.INSTANCE,
                                        RelocationBatchV2Launch.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"copy_batch_v2\":" + ex.getErrorValue());
        }
    }

    /**
     * Copy multiple files or folders to different locations at once in the
     * user's Dropbox.
     *
     * <p> This route will replace {@code copyBatch:1}. The main difference is
     * this route will return status for each entry, while {@code copyBatch:1}
     * raises failure if any entry fails. </p>
     *
     * <p> This route will either finish synchronously, or return a job ID and
     * do the async copy job in background. Please use {@link
     * DbxUserFilesRequests#copyBatchCheckV2(String)} to check the job status.
     * </p>
     *
     * <p> The {@code autorename} request parameter will default to {@code
     * false} (see {@link #copyBatchV2(List,boolean)}). </p>
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#copyBatchV2(List,boolean)} or {@link
     *     DbxUserFilesRequests#moveBatchV2(List)} that may either launch an
     *     asynchronous job or complete synchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationBatchV2Launch copyBatchV2(List<RelocationPath> entries) throws DbxApiException, DbxException {
        RelocationBatchArgBase _arg = new RelocationBatchArgBase(entries);
        return copyBatchV2(_arg);
    }

    /**
     * Copy multiple files or folders to different locations at once in the
     * user's Dropbox.
     *
     * <p> This route will replace {@code copyBatch:1}. The main difference is
     * this route will return status for each entry, while {@code copyBatch:1}
     * raises failure if any entry fails. </p>
     *
     * <p> This route will either finish synchronously, or return a job ID and
     * do the async copy job in background. Please use {@link
     * DbxUserFilesRequests#copyBatchCheckV2(String)} to check the job status.
     * </p>
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     * @param autorename  If there's a conflict with any file, have the Dropbox
     *     server try to autorename that file to avoid the conflict.
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#copyBatchV2(List,boolean)} or {@link
     *     DbxUserFilesRequests#moveBatchV2(List)} that may either launch an
     *     asynchronous job or complete synchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationBatchV2Launch copyBatchV2(List<RelocationPath> entries, boolean autorename) throws DbxApiException, DbxException {
        RelocationBatchArgBase _arg = new RelocationBatchArgBase(entries, autorename);
        return copyBatchV2(_arg);
    }

    //
    // route 2/files/copy_batch
    //

    /**
     * Copy multiple files or folders to different locations at once in the
     * user's Dropbox. This route will return job ID immediately and do the
     * async copy job in background. Please use {@code copyBatchCheck:1} to
     * check the job status.
     *
     *
     * @return Result returned by {@link DbxUserFilesRequests#copyBatch(List)}
     *     or {@link DbxUserFilesRequests#moveBatch(List)} that may either
     *     launch an asynchronous job or complete synchronously.
     */
    RelocationBatchLaunch copyBatch(RelocationBatchArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/copy_batch",
                                        arg,
                                        false,
                                        RelocationBatchArg.Serializer.INSTANCE,
                                        RelocationBatchLaunch.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"copy_batch\":" + ex.getErrorValue());
        }
    }

    /**
     * Copy multiple files or folders to different locations at once in the
     * user's Dropbox.
     *
     * <p> This route will return job ID immediately and do the async copy job
     * in background. Please use {@code copyBatchCheck:1} to check the job
     * status. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link CopyBatchBuilder} for more details. </p>
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     *
     * @return Result returned by {@link DbxUserFilesRequests#copyBatch(List)}
     *     or {@link DbxUserFilesRequests#moveBatch(List)} that may either
     *     launch an asynchronous job or complete synchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#copyBatchV2(List,boolean)}
     *     instead.
     */
    @Deprecated
    public RelocationBatchLaunch copyBatch(List<RelocationPath> entries) throws DbxApiException, DbxException {
        RelocationBatchArg _arg = new RelocationBatchArg(entries);
        return copyBatch(_arg);
    }

    /**
     * Copy multiple files or folders to different locations at once in the
     * user's Dropbox. This route will return job ID immediately and do the
     * async copy job in background. Please use {@code copyBatchCheck:1} to
     * check the job status.
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#copyBatchV2(List,boolean)}
     *     instead.
     */
    @Deprecated
    public CopyBatchBuilder copyBatchBuilder(List<RelocationPath> entries) {
        RelocationBatchArg.Builder argBuilder_ = RelocationBatchArg.newBuilder(entries);
        return new CopyBatchBuilder(this, argBuilder_);
    }

    //
    // route 2/files/copy_batch/check_v2
    //

    /**
     * Returns the status of an asynchronous job for {@link
     * DbxUserFilesRequests#copyBatchV2(List,boolean)}. It returns list of
     * results for each entry.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#copyBatchCheckV2(String)} or {@link
     *     DbxUserFilesRequests#moveBatchCheckV2(String)} that may either be in
     *     progress or completed with result for each entry.
     */
    RelocationBatchV2JobStatus copyBatchCheckV2(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/copy_batch/check_v2",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        RelocationBatchV2JobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/files/copy_batch/check_v2", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for {@link
     * DbxUserFilesRequests#copyBatchV2(List,boolean)}. It returns list of
     * results for each entry.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#copyBatchCheckV2(String)} or {@link
     *     DbxUserFilesRequests#moveBatchCheckV2(String)} that may either be in
     *     progress or completed with result for each entry.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationBatchV2JobStatus copyBatchCheckV2(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return copyBatchCheckV2(_arg);
    }

    //
    // route 2/files/copy_batch/check
    //

    /**
     * Returns the status of an asynchronous job for {@code copyBatch:1}. If
     * success, it returns list of results for each entry.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    RelocationBatchJobStatus copyBatchCheck(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/copy_batch/check",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        RelocationBatchJobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/files/copy_batch/check", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for {@code copyBatch:1}. If
     * success, it returns list of results for each entry.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#copyBatchCheckV2(String)}
     *     instead.
     */
    @Deprecated
    public RelocationBatchJobStatus copyBatchCheck(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return copyBatchCheck(_arg);
    }

    //
    // route 2/files/copy_reference/get
    //

    /**
     * Get a copy reference to a file or folder. This reference string can be
     * used to save that file or folder to another user's Dropbox by passing it
     * to {@link DbxUserFilesRequests#copyReferenceSave(String,String)}.
     *
     */
    GetCopyReferenceResult copyReferenceGet(GetCopyReferenceArg arg) throws GetCopyReferenceErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/copy_reference/get",
                                        arg,
                                        false,
                                        GetCopyReferenceArg.Serializer.INSTANCE,
                                        GetCopyReferenceResult.Serializer.INSTANCE,
                                        GetCopyReferenceError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetCopyReferenceErrorException("2/files/copy_reference/get", ex.getRequestId(), ex.getUserMessage(), (GetCopyReferenceError) ex.getErrorValue());
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
        GetCopyReferenceArg _arg = new GetCopyReferenceArg(path);
        return copyReferenceGet(_arg);
    }

    //
    // route 2/files/copy_reference/save
    //

    /**
     * Save a copy reference returned by {@link
     * DbxUserFilesRequests#copyReferenceGet(String)} to the user's Dropbox.
     *
     */
    SaveCopyReferenceResult copyReferenceSave(SaveCopyReferenceArg arg) throws SaveCopyReferenceErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/copy_reference/save",
                                        arg,
                                        false,
                                        SaveCopyReferenceArg.Serializer.INSTANCE,
                                        SaveCopyReferenceResult.Serializer.INSTANCE,
                                        SaveCopyReferenceError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SaveCopyReferenceErrorException("2/files/copy_reference/save", ex.getRequestId(), ex.getUserMessage(), (SaveCopyReferenceError) ex.getErrorValue());
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
        SaveCopyReferenceArg _arg = new SaveCopyReferenceArg(copyReference, path);
        return copyReferenceSave(_arg);
    }

    //
    // route 2/files/create_folder_v2
    //

    /**
     * Create a folder at a given path.
     *
     */
    CreateFolderResult createFolderV2(CreateFolderArg arg) throws CreateFolderErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/create_folder_v2",
                                        arg,
                                        false,
                                        CreateFolderArg.Serializer.INSTANCE,
                                        CreateFolderResult.Serializer.INSTANCE,
                                        CreateFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new CreateFolderErrorException("2/files/create_folder_v2", ex.getRequestId(), ex.getUserMessage(), (CreateFolderError) ex.getErrorValue());
        }
    }

    /**
     * Create a folder at a given path.
     *
     * <p> The {@code autorename} request parameter will default to {@code
     * false} (see {@link #createFolderV2(String,boolean)}). </p>
     *
     * @param path  Path in the user's Dropbox to create. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateFolderResult createFolderV2(String path) throws CreateFolderErrorException, DbxException {
        CreateFolderArg _arg = new CreateFolderArg(path);
        return createFolderV2(_arg);
    }

    /**
     * Create a folder at a given path.
     *
     * @param path  Path in the user's Dropbox to create. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     * @param autorename  If there's a conflict, have the Dropbox server try to
     *     autorename the folder to avoid the conflict.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateFolderResult createFolderV2(String path, boolean autorename) throws CreateFolderErrorException, DbxException {
        CreateFolderArg _arg = new CreateFolderArg(path, autorename);
        return createFolderV2(_arg);
    }

    //
    // route 2/files/create_folder
    //

    /**
     * Create a folder at a given path.
     *
     */
    FolderMetadata createFolder(CreateFolderArg arg) throws CreateFolderErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/create_folder",
                                        arg,
                                        false,
                                        CreateFolderArg.Serializer.INSTANCE,
                                        FolderMetadata.Serializer.INSTANCE,
                                        CreateFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new CreateFolderErrorException("2/files/create_folder", ex.getRequestId(), ex.getUserMessage(), (CreateFolderError) ex.getErrorValue());
        }
    }

    /**
     * Create a folder at a given path.
     *
     * <p> The {@code autorename} request parameter will default to {@code
     * false} (see {@link #createFolder(String,boolean)}). </p>
     *
     * @param path  Path in the user's Dropbox to create. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link
     *     DbxUserFilesRequests#createFolderV2(String,boolean)} instead.
     */
    @Deprecated
    public FolderMetadata createFolder(String path) throws CreateFolderErrorException, DbxException {
        CreateFolderArg _arg = new CreateFolderArg(path);
        return createFolder(_arg);
    }

    /**
     * Create a folder at a given path.
     *
     * @param path  Path in the user's Dropbox to create. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     * @param autorename  If there's a conflict, have the Dropbox server try to
     *     autorename the folder to avoid the conflict.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link
     *     DbxUserFilesRequests#createFolderV2(String,boolean)} instead.
     */
    @Deprecated
    public FolderMetadata createFolder(String path, boolean autorename) throws CreateFolderErrorException, DbxException {
        CreateFolderArg _arg = new CreateFolderArg(path, autorename);
        return createFolder(_arg);
    }

    //
    // route 2/files/create_folder_batch
    //

    /**
     * Create multiple folders at once. This route is asynchronous for large
     * batches, which returns a job ID immediately and runs the create folder
     * batch asynchronously. Otherwise, creates the folders and returns the
     * result synchronously for smaller inputs. You can force asynchronous
     * behaviour by using the {@link CreateFolderBatchArg#getForceAsync} flag.
     * Use {@link DbxUserFilesRequests#createFolderBatchCheck(String)} to check
     * the job status.
     *
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#createFolderBatch(List)} that may either launch
     *     an asynchronous job or complete synchronously.
     */
    CreateFolderBatchLaunch createFolderBatch(CreateFolderBatchArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/create_folder_batch",
                                        arg,
                                        false,
                                        CreateFolderBatchArg.Serializer.INSTANCE,
                                        CreateFolderBatchLaunch.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"create_folder_batch\":" + ex.getErrorValue());
        }
    }

    /**
     * Create multiple folders at once.
     *
     * <p> This route is asynchronous for large batches, which returns a job ID
     * immediately and runs the create folder batch asynchronously. Otherwise,
     * creates the folders and returns the result synchronously for smaller
     * inputs. You can force asynchronous behaviour by using the {@link
     * CreateFolderBatchArg#getForceAsync} flag.  Use {@link
     * DbxUserFilesRequests#createFolderBatchCheck(String)} to check the job
     * status. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link CreateFolderBatchBuilder} for more details. </p>
     *
     * @param paths  List of paths to be created in the user's Dropbox.
     *     Duplicate path arguments in the batch are considered only once. Must
     *     contain at most 10000 items, not contain a {@code null} item, and not
     *     be {@code null}.
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#createFolderBatch(List)} that may either launch
     *     an asynchronous job or complete synchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateFolderBatchLaunch createFolderBatch(List<String> paths) throws DbxApiException, DbxException {
        CreateFolderBatchArg _arg = new CreateFolderBatchArg(paths);
        return createFolderBatch(_arg);
    }

    /**
     * Create multiple folders at once. This route is asynchronous for large
     * batches, which returns a job ID immediately and runs the create folder
     * batch asynchronously. Otherwise, creates the folders and returns the
     * result synchronously for smaller inputs. You can force asynchronous
     * behaviour by using the {@link CreateFolderBatchArg#getForceAsync} flag.
     * Use {@link DbxUserFilesRequests#createFolderBatchCheck(String)} to check
     * the job status.
     *
     * @param paths  List of paths to be created in the user's Dropbox.
     *     Duplicate path arguments in the batch are considered only once. Must
     *     contain at most 10000 items, not contain a {@code null} item, and not
     *     be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateFolderBatchBuilder createFolderBatchBuilder(List<String> paths) {
        CreateFolderBatchArg.Builder argBuilder_ = CreateFolderBatchArg.newBuilder(paths);
        return new CreateFolderBatchBuilder(this, argBuilder_);
    }

    //
    // route 2/files/create_folder_batch/check
    //

    /**
     * Returns the status of an asynchronous job for {@link
     * DbxUserFilesRequests#createFolderBatch(List)}. If success, it returns
     * list of result for each entry.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    CreateFolderBatchJobStatus createFolderBatchCheck(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/create_folder_batch/check",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        CreateFolderBatchJobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/files/create_folder_batch/check", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for {@link
     * DbxUserFilesRequests#createFolderBatch(List)}. If success, it returns
     * list of result for each entry.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public CreateFolderBatchJobStatus createFolderBatchCheck(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return createFolderBatchCheck(_arg);
    }

    //
    // route 2/files/delete_v2
    //

    /**
     * Delete the file or folder at a given path. If the path is a folder, all
     * its contents will be deleted too. A successful response indicates that
     * the file or folder was deleted. The returned metadata will be the
     * corresponding {@link FileMetadata} or {@link FolderMetadata} for the item
     * at time of deletion, and not a {@link DeletedMetadata} object.
     *
     */
    DeleteResult deleteV2(DeleteArg arg) throws DeleteErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/delete_v2",
                                        arg,
                                        false,
                                        DeleteArg.Serializer.INSTANCE,
                                        DeleteResult.Serializer.INSTANCE,
                                        DeleteError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DeleteErrorException("2/files/delete_v2", ex.getRequestId(), ex.getUserMessage(), (DeleteError) ex.getErrorValue());
        }
    }

    /**
     * Delete the file or folder at a given path.
     *
     * <p> If the path is a folder, all its contents will be deleted too. </p>
     *
     * <p> A successful response indicates that the file or folder was deleted.
     * The returned metadata will be the corresponding {@link FileMetadata} or
     * {@link FolderMetadata} for the item at time of deletion, and not a {@link
     * DeletedMetadata} object. </p>
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteResult deleteV2(String path) throws DeleteErrorException, DbxException {
        DeleteArg _arg = new DeleteArg(path);
        return deleteV2(_arg);
    }

    /**
     * Delete the file or folder at a given path.
     *
     * <p> If the path is a folder, all its contents will be deleted too. </p>
     *
     * <p> A successful response indicates that the file or folder was deleted.
     * The returned metadata will be the corresponding {@link FileMetadata} or
     * {@link FolderMetadata} for the item at time of deletion, and not a {@link
     * DeletedMetadata} object. </p>
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be
     *     {@code null}.
     * @param parentRev  Perform delete if given "rev" matches the existing
     *     file's latest "rev". This field does not support deleting a folder.
     *     Must have length of at least 9 and match pattern "{@code [0-9a-f]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteResult deleteV2(String path, String parentRev) throws DeleteErrorException, DbxException {
        if (parentRev != null) {
            if (parentRev.length() < 9) {
                throw new IllegalArgumentException("String 'parentRev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", parentRev)) {
                throw new IllegalArgumentException("String 'parentRev' does not match pattern");
            }
        }
        DeleteArg _arg = new DeleteArg(path, parentRev);
        return deleteV2(_arg);
    }

    //
    // route 2/files/delete
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
    Metadata delete(DeleteArg arg) throws DeleteErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/delete",
                                        arg,
                                        false,
                                        DeleteArg.Serializer.INSTANCE,
                                        Metadata.Serializer.INSTANCE,
                                        DeleteError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DeleteErrorException("2/files/delete", ex.getRequestId(), ex.getUserMessage(), (DeleteError) ex.getErrorValue());
        }
    }

    /**
     * Delete the file or folder at a given path.
     *
     * <p> If the path is a folder, all its contents will be deleted too. </p>
     *
     * <p> A successful response indicates that the file or folder was deleted.
     * The returned metadata will be the corresponding {@link FileMetadata} or
     * {@link FolderMetadata} for the item at time of deletion, and not a {@link
     * DeletedMetadata} object. </p>
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be
     *     {@code null}.
     *
     * @return Metadata for a file or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#deleteV2(String,String)}
     *     instead.
     */
    @Deprecated
    public Metadata delete(String path) throws DeleteErrorException, DbxException {
        DeleteArg _arg = new DeleteArg(path);
        return delete(_arg);
    }

    /**
     * Delete the file or folder at a given path.
     *
     * <p> If the path is a folder, all its contents will be deleted too. </p>
     *
     * <p> A successful response indicates that the file or folder was deleted.
     * The returned metadata will be the corresponding {@link FileMetadata} or
     * {@link FolderMetadata} for the item at time of deletion, and not a {@link
     * DeletedMetadata} object. </p>
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be
     *     {@code null}.
     * @param parentRev  Perform delete if given "rev" matches the existing
     *     file's latest "rev". This field does not support deleting a folder.
     *     Must have length of at least 9 and match pattern "{@code [0-9a-f]+}".
     *
     * @return Metadata for a file or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#deleteV2(String,String)}
     *     instead.
     */
    @Deprecated
    public Metadata delete(String path, String parentRev) throws DeleteErrorException, DbxException {
        if (parentRev != null) {
            if (parentRev.length() < 9) {
                throw new IllegalArgumentException("String 'parentRev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", parentRev)) {
                throw new IllegalArgumentException("String 'parentRev' does not match pattern");
            }
        }
        DeleteArg _arg = new DeleteArg(path, parentRev);
        return delete(_arg);
    }

    //
    // route 2/files/delete_batch
    //

    /**
     * Delete multiple files/folders at once. This route is asynchronous, which
     * returns a job ID immediately and runs the delete batch asynchronously.
     * Use {@link DbxUserFilesRequests#deleteBatchCheck(String)} to check the
     * job status.
     *
     *
     * @return Result returned by {@link DbxUserFilesRequests#deleteBatch(List)}
     *     that may either launch an asynchronous job or complete synchronously.
     */
    DeleteBatchLaunch deleteBatch(DeleteBatchArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/delete_batch",
                                        arg,
                                        false,
                                        DeleteBatchArg.Serializer.INSTANCE,
                                        DeleteBatchLaunch.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"delete_batch\":" + ex.getErrorValue());
        }
    }

    /**
     * Delete multiple files/folders at once.
     *
     * <p> This route is asynchronous, which returns a job ID immediately and
     * runs the delete batch asynchronously. Use {@link
     * DbxUserFilesRequests#deleteBatchCheck(String)} to check the job status.
     * </p>
     *
     * @param entries  Must contain at most 1000 items, not contain a {@code
     *     null} item, and not be {@code null}.
     *
     * @return Result returned by {@link DbxUserFilesRequests#deleteBatch(List)}
     *     that may either launch an asynchronous job or complete synchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteBatchLaunch deleteBatch(List<DeleteArg> entries) throws DbxApiException, DbxException {
        DeleteBatchArg _arg = new DeleteBatchArg(entries);
        return deleteBatch(_arg);
    }

    //
    // route 2/files/delete_batch/check
    //

    /**
     * Returns the status of an asynchronous job for {@link
     * DbxUserFilesRequests#deleteBatch(List)}. If success, it returns list of
     * result for each entry.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    DeleteBatchJobStatus deleteBatchCheck(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/delete_batch/check",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        DeleteBatchJobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/files/delete_batch/check", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for {@link
     * DbxUserFilesRequests#deleteBatch(List)}. If success, it returns list of
     * result for each entry.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DeleteBatchJobStatus deleteBatchCheck(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return deleteBatchCheck(_arg);
    }

    //
    // route 2/files/download
    //

    /**
     * Download a file from a user's Dropbox.
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<FileMetadata> download(DownloadArg arg, List<HttpRequestor.Header> _headers) throws DownloadErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/files/download",
                                             arg,
                                             false,
                                             _headers,
                                             DownloadArg.Serializer.INSTANCE,
                                             FileMetadata.Serializer.INSTANCE,
                                             DownloadError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DownloadErrorException("2/files/download", ex.getRequestId(), ex.getUserMessage(), (DownloadError) ex.getErrorValue());
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
        DownloadArg _arg = new DownloadArg(path);
        return download(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Download a file from a user's Dropbox.
     *
     * @param path  The path of the file to download. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     * @param rev  Please specify revision in the {@code path} argument to
     *     {@link DbxUserFilesRequests#download(String,String)} instead. Must
     *     have length of at least 9 and match pattern "{@code [0-9a-f]+}".
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
        DownloadArg _arg = new DownloadArg(path, rev);
        return download(_arg, Collections.<HttpRequestor.Header>emptyList());
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
        return new DownloadBuilder(this, path);
    }

    //
    // route 2/files/download_zip
    //

    /**
     * Download a folder from the user's Dropbox, as a zip file. The folder must
     * be less than 20 GB in size and any single file within must be less than 4
     * GB in size. The resulting zip must have fewer than 10,000 total file and
     * folder entries, including the top level folder. The input cannot be a
     * single file. Note: this endpoint does not support HTTP range requests.
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<DownloadZipResult> downloadZip(DownloadZipArg arg, List<HttpRequestor.Header> _headers) throws DownloadZipErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/files/download_zip",
                                             arg,
                                             false,
                                             _headers,
                                             DownloadZipArg.Serializer.INSTANCE,
                                             DownloadZipResult.Serializer.INSTANCE,
                                             DownloadZipError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DownloadZipErrorException("2/files/download_zip", ex.getRequestId(), ex.getUserMessage(), (DownloadZipError) ex.getErrorValue());
        }
    }

    /**
     * Download a folder from the user's Dropbox, as a zip file. The folder must
     * be less than 20 GB in size and any single file within must be less than 4
     * GB in size. The resulting zip must have fewer than 10,000 total file and
     * folder entries, including the top level folder. The input cannot be a
     * single file.
     *
     * <p> Note: this endpoint does not support HTTP range requests. </p>
     *
     * @param path  The path of the folder to download. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<DownloadZipResult> downloadZip(String path) throws DownloadZipErrorException, DbxException {
        DownloadZipArg _arg = new DownloadZipArg(path);
        return downloadZip(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Download a folder from the user's Dropbox, as a zip file. The folder must
     * be less than 20 GB in size and any single file within must be less than 4
     * GB in size. The resulting zip must have fewer than 10,000 total file and
     * folder entries, including the top level folder. The input cannot be a
     * single file. Note: this endpoint does not support HTTP range requests.
     *
     * @param path  The path of the folder to download. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DownloadZipBuilder downloadZipBuilder(String path) {
        return new DownloadZipBuilder(this, path);
    }

    //
    // route 2/files/export
    //

    /**
     * Export a file from a user's Dropbox. This route only supports exporting
     * files that cannot be downloaded directly  and whose {@link
     * ExportResult#getFileMetadata} has {@link ExportInfo#getExportAs}
     * populated.
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<ExportResult> export(ExportArg arg, List<HttpRequestor.Header> _headers) throws ExportErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/files/export",
                                             arg,
                                             false,
                                             _headers,
                                             ExportArg.Serializer.INSTANCE,
                                             ExportResult.Serializer.INSTANCE,
                                             ExportError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ExportErrorException("2/files/export", ex.getRequestId(), ex.getUserMessage(), (ExportError) ex.getErrorValue());
        }
    }

    /**
     * Export a file from a user's Dropbox. This route only supports exporting
     * files that cannot be downloaded directly and whose {@link
     * ExportResult#getFileMetadata} has {@link ExportInfo#getExportAs}
     * populated.
     *
     * @param path  The path of the file to be exported. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<ExportResult> export(String path) throws ExportErrorException, DbxException {
        ExportArg _arg = new ExportArg(path);
        return export(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Export a file from a user's Dropbox. This route only supports exporting
     * files that cannot be downloaded directly and whose {@link
     * ExportResult#getFileMetadata} has {@link ExportInfo#getExportAs}
     * populated.
     *
     * @param path  The path of the file to be exported. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     * @param exportFormat  The file format to which the file should be
     *     exported. This must be one of the formats listed in the file's
     *     export_options returned by {@link
     *     DbxUserFilesRequests#getMetadata(String)}. If none is specified, the
     *     default format (specified in export_as in file metadata) will be
     *     used.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<ExportResult> export(String path, String exportFormat) throws ExportErrorException, DbxException {
        ExportArg _arg = new ExportArg(path, exportFormat);
        return export(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Export a file from a user's Dropbox. This route only supports exporting
     * files that cannot be downloaded directly  and whose {@link
     * ExportResult#getFileMetadata} has {@link ExportInfo#getExportAs}
     * populated.
     *
     * @param path  The path of the file to be exported. Must match pattern
     *     "{@code (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}"
     *     and not be {@code null}.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ExportBuilder exportBuilder(String path) {
        return new ExportBuilder(this, path);
    }

    //
    // route 2/files/get_file_lock_batch
    //

    /**
     * Return the lock metadata for the given list of paths.
     *
     */
    LockFileBatchResult getFileLockBatch(LockFileBatchArg arg) throws LockFileErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/get_file_lock_batch",
                                        arg,
                                        false,
                                        LockFileBatchArg.Serializer.INSTANCE,
                                        LockFileBatchResult.Serializer.INSTANCE,
                                        LockFileError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new LockFileErrorException("2/files/get_file_lock_batch", ex.getRequestId(), ex.getUserMessage(), (LockFileError) ex.getErrorValue());
        }
    }

    /**
     * Return the lock metadata for the given list of paths.
     *
     * @param entries  List of 'entries'. Each 'entry' contains a path of the
     *     file which will be locked or queried. Duplicate path arguments in the
     *     batch are considered only once. Must not contain a {@code null} item
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LockFileBatchResult getFileLockBatch(List<LockFileArg> entries) throws LockFileErrorException, DbxException {
        LockFileBatchArg _arg = new LockFileBatchArg(entries);
        return getFileLockBatch(_arg);
    }

    //
    // route 2/files/get_metadata
    //

    /**
     * Returns the metadata for a file or folder. Note: Metadata for the root
     * folder is unsupported.
     *
     *
     * @return Metadata for a file or folder.
     */
    Metadata getMetadata(GetMetadataArg arg) throws GetMetadataErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/get_metadata",
                                        arg,
                                        false,
                                        GetMetadataArg.Serializer.INSTANCE,
                                        Metadata.Serializer.INSTANCE,
                                        GetMetadataError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetMetadataErrorException("2/files/get_metadata", ex.getRequestId(), ex.getUserMessage(), (GetMetadataError) ex.getErrorValue());
        }
    }

    /**
     * Returns the metadata for a file or folder.
     *
     * <p> Note: Metadata for the root folder is unsupported. </p>
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
        GetMetadataArg _arg = new GetMetadataArg(path);
        return getMetadata(_arg);
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
    // route 2/files/get_preview
    //

    /**
     * Get a preview for a file. Currently, PDF previews are generated for files
     * with the following extensions: .ai, .doc, .docm, .docx, .eps, .gdoc,
     * .gslides, .odp, .odt, .pps, .ppsm, .ppsx, .ppt, .pptm, .pptx, .rtf. HTML
     * previews are generated for files with the following extensions: .csv,
     * .ods, .xls, .xlsm, .gsheet, .xlsx. Other formats will return an
     * unsupported extension error.
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<FileMetadata> getPreview(PreviewArg arg, List<HttpRequestor.Header> _headers) throws PreviewErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/files/get_preview",
                                             arg,
                                             false,
                                             _headers,
                                             PreviewArg.Serializer.INSTANCE,
                                             FileMetadata.Serializer.INSTANCE,
                                             PreviewError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PreviewErrorException("2/files/get_preview", ex.getRequestId(), ex.getUserMessage(), (PreviewError) ex.getErrorValue());
        }
    }

    /**
     * Get a preview for a file.
     *
     * <p> Currently, PDF previews are generated for files with the following
     * extensions: .ai, .doc, .docm, .docx, .eps, .gdoc, .gslides, .odp, .odt,
     * .pps, .ppsm, .ppsx, .ppt, .pptm, .pptx, .rtf. </p>
     *
     * <p> HTML previews are generated for files with the following extensions:
     * .csv, .ods, .xls, .xlsm, .gsheet, .xlsx. </p>
     *
     * <p> Other formats will return an unsupported extension error. </p>
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
        PreviewArg _arg = new PreviewArg(path);
        return getPreview(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Get a preview for a file.
     *
     * <p> Currently, PDF previews are generated for files with the following
     * extensions: .ai, .doc, .docm, .docx, .eps, .gdoc, .gslides, .odp, .odt,
     * .pps, .ppsm, .ppsx, .ppt, .pptm, .pptx, .rtf. </p>
     *
     * <p> HTML previews are generated for files with the following extensions:
     * .csv, .ods, .xls, .xlsm, .gsheet, .xlsx. </p>
     *
     * <p> Other formats will return an unsupported extension error. </p>
     *
     * @param path  The path of the file to preview. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     * @param rev  Please specify revision in the {@code path} argument to
     *     {@link DbxUserFilesRequests#getPreview(String,String)} instead. Must
     *     have length of at least 9 and match pattern "{@code [0-9a-f]+}".
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
        PreviewArg _arg = new PreviewArg(path, rev);
        return getPreview(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Get a preview for a file. Currently, PDF previews are generated for files
     * with the following extensions: .ai, .doc, .docm, .docx, .eps, .gdoc,
     * .gslides, .odp, .odt, .pps, .ppsm, .ppsx, .ppt, .pptm, .pptx, .rtf. HTML
     * previews are generated for files with the following extensions: .csv,
     * .ods, .xls, .xlsm, .gsheet, .xlsx. Other formats will return an
     * unsupported extension error.
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
        return new GetPreviewBuilder(this, path);
    }

    //
    // route 2/files/get_temporary_link
    //

    /**
     * Get a temporary link to stream content of a file. This link will expire
     * in four hours and afterwards you will get 410 Gone. This URL should not
     * be used to display content directly in the browser. The Content-Type of
     * the link is determined automatically by the file's mime type.
     *
     */
    GetTemporaryLinkResult getTemporaryLink(GetTemporaryLinkArg arg) throws GetTemporaryLinkErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/get_temporary_link",
                                        arg,
                                        false,
                                        GetTemporaryLinkArg.Serializer.INSTANCE,
                                        GetTemporaryLinkResult.Serializer.INSTANCE,
                                        GetTemporaryLinkError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetTemporaryLinkErrorException("2/files/get_temporary_link", ex.getRequestId(), ex.getUserMessage(), (GetTemporaryLinkError) ex.getErrorValue());
        }
    }

    /**
     * Get a temporary link to stream content of a file. This link will expire
     * in four hours and afterwards you will get 410 Gone. This URL should not
     * be used to display content directly in the browser. The Content-Type of
     * the link is determined automatically by the file's mime type.
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
        GetTemporaryLinkArg _arg = new GetTemporaryLinkArg(path);
        return getTemporaryLink(_arg);
    }

    //
    // route 2/files/get_temporary_upload_link
    //

    /**
     * Get a one-time use temporary upload link to upload a file to a Dropbox
     * location.
     *
     * <p> This endpoint acts as a delayed {@link
     * DbxUserFilesRequests#upload(String)}. The returned temporary upload link
     * may be used to make a POST request with the data to be uploaded. The
     * upload will then be perfomed with the {@link CommitInfo} previously
     * provided to {@link
     * DbxUserFilesRequests#getTemporaryUploadLink(CommitInfo,double)} but
     * evaluated only upon consumption. Hence, errors stemming from invalid
     * {@link CommitInfo} with respect to the state of the user's Dropbox will
     * only be communicated at consumption time. Additionally, these errors are
     * surfaced as generic HTTP 409 Conflict responses, potentially hiding issue
     * details. The maximum temporary upload link duration is 4 hours. Upon
     * consumption or expiration, a new link will have to be generated. Multiple
     * links may exist for a specific upload path at any given time. </p>
     *
     * <p> The POST request on the temporary upload link must have its
     * Content-Type set to "application/octet-stream". </p>
     *
     * <p> Example temporary upload link consumption request: </p>
     *
     * <p> curl -X POST https://content.dropboxapi.com/apitul/1/bNi2uIYF51cVBND
     * --header "Content-Type: application/octet-stream" --data-binary
     * @local_file.txt </p>
     *
     * <p> A successful temporary upload link consumption request returns the
     * content hash of the uploaded data in JSON format. </p>
     *
     * <p> Example successful temporary upload link consumption response:
     * {"content-hash": "599d71033d700ac892a0e48fa61b125d2f5994"} </p>
     *
     * <p> An unsuccessful temporary upload link consumption request returns any
     * of the following status codes: </p>
     *
     * <p> HTTP 400 Bad Request: Content-Type is not one of
     * application/octet-stream and text/plain or request is invalid. HTTP 409
     * Conflict: The temporary upload link does not exist or is currently
     * unavailable, the upload failed, or another error happened. HTTP 410 Gone:
     * The temporary upload link is expired or consumed. </p>
     *
     * <p> Example unsuccessful temporary upload link consumption response:
     * Temporary upload link has been recently consumed. </p>
     *
     */
    GetTemporaryUploadLinkResult getTemporaryUploadLink(GetTemporaryUploadLinkArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/get_temporary_upload_link",
                                        arg,
                                        false,
                                        GetTemporaryUploadLinkArg.Serializer.INSTANCE,
                                        GetTemporaryUploadLinkResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"get_temporary_upload_link\":" + ex.getErrorValue());
        }
    }

    /**
     * Get a one-time use temporary upload link to upload a file to a Dropbox
     * location.
     *
     * <p> This endpoint acts as a delayed {@link
     * DbxUserFilesRequests#upload(String)}. The returned temporary upload link
     * may be used to make a POST request with the data to be uploaded. The
     * upload will then be perfomed with the {@link CommitInfo} previously
     * provided to {@link
     * DbxUserFilesRequests#getTemporaryUploadLink(CommitInfo,double)} but
     * evaluated only upon consumption. Hence, errors stemming from invalid
     * {@link CommitInfo} with respect to the state of the user's Dropbox will
     * only be communicated at consumption time. Additionally, these errors are
     * surfaced as generic HTTP 409 Conflict responses, potentially hiding issue
     * details. The maximum temporary upload link duration is 4 hours. Upon
     * consumption or expiration, a new link will have to be generated. Multiple
     * links may exist for a specific upload path at any given time. </p>
     *
     * <p> The POST request on the temporary upload link must have its
     * Content-Type set to "application/octet-stream". </p>
     *
     * <p> Example temporary upload link consumption request: </p>
     *
     * <p> curl -X POST https://content.dropboxapi.com/apitul/1/bNi2uIYF51cVBND
     * </p>
     *
     * <p> --header "Content-Type: application/octet-stream" </p>
     *
     * <p> --data-binary @local_file.txt </p>
     *
     * <p> A successful temporary upload link consumption request returns the
     * content hash of the uploaded data in JSON format. </p>
     *
     * <p> Example successful temporary upload link consumption response: </p>
     *
     * <p> {"content-hash": "599d71033d700ac892a0e48fa61b125d2f5994"} </p>
     *
     * <p> An unsuccessful temporary upload link consumption request returns any
     * of the following status codes: </p>
     *
     * <p> HTTP 400 Bad Request: Content-Type is not one of
     * application/octet-stream and text/plain or request is invalid. </p>
     *
     * <p> HTTP 409 Conflict: The temporary upload link does not exist or is
     * currently unavailable, the upload failed, or another error happened. </p>
     *
     * <p> HTTP 410 Gone: The temporary upload link is expired or consumed. </p>
     *
     * <p> Example unsuccessful temporary upload link consumption response: </p>
     *
     * <p> Temporary upload link has been recently consumed. </p>
     *
     * <p> The {@code duration} request parameter will default to {@code
     * 14400.0} (see {@link #getTemporaryUploadLink(CommitInfo,double)}). </p>
     *
     * @param commitInfo  Contains the path and other optional modifiers for the
     *     future upload commit. Equivalent to the parameters provided to {@link
     *     DbxUserFilesRequests#upload(String)}. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTemporaryUploadLinkResult getTemporaryUploadLink(CommitInfo commitInfo) throws DbxApiException, DbxException {
        GetTemporaryUploadLinkArg _arg = new GetTemporaryUploadLinkArg(commitInfo);
        return getTemporaryUploadLink(_arg);
    }

    /**
     * Get a one-time use temporary upload link to upload a file to a Dropbox
     * location.
     *
     * <p> This endpoint acts as a delayed {@link
     * DbxUserFilesRequests#upload(String)}. The returned temporary upload link
     * may be used to make a POST request with the data to be uploaded. The
     * upload will then be perfomed with the {@link CommitInfo} previously
     * provided to {@link
     * DbxUserFilesRequests#getTemporaryUploadLink(CommitInfo,double)} but
     * evaluated only upon consumption. Hence, errors stemming from invalid
     * {@link CommitInfo} with respect to the state of the user's Dropbox will
     * only be communicated at consumption time. Additionally, these errors are
     * surfaced as generic HTTP 409 Conflict responses, potentially hiding issue
     * details. The maximum temporary upload link duration is 4 hours. Upon
     * consumption or expiration, a new link will have to be generated. Multiple
     * links may exist for a specific upload path at any given time. </p>
     *
     * <p> The POST request on the temporary upload link must have its
     * Content-Type set to "application/octet-stream". </p>
     *
     * <p> Example temporary upload link consumption request: </p>
     *
     * <p> curl -X POST https://content.dropboxapi.com/apitul/1/bNi2uIYF51cVBND
     * </p>
     *
     * <p> --header "Content-Type: application/octet-stream" </p>
     *
     * <p> --data-binary @local_file.txt </p>
     *
     * <p> A successful temporary upload link consumption request returns the
     * content hash of the uploaded data in JSON format. </p>
     *
     * <p> Example successful temporary upload link consumption response: </p>
     *
     * <p> {"content-hash": "599d71033d700ac892a0e48fa61b125d2f5994"} </p>
     *
     * <p> An unsuccessful temporary upload link consumption request returns any
     * of the following status codes: </p>
     *
     * <p> HTTP 400 Bad Request: Content-Type is not one of
     * application/octet-stream and text/plain or request is invalid. </p>
     *
     * <p> HTTP 409 Conflict: The temporary upload link does not exist or is
     * currently unavailable, the upload failed, or another error happened. </p>
     *
     * <p> HTTP 410 Gone: The temporary upload link is expired or consumed. </p>
     *
     * <p> Example unsuccessful temporary upload link consumption response: </p>
     *
     * <p> Temporary upload link has been recently consumed. </p>
     *
     * @param commitInfo  Contains the path and other optional modifiers for the
     *     future upload commit. Equivalent to the parameters provided to {@link
     *     DbxUserFilesRequests#upload(String)}. Must not be {@code null}.
     * @param duration  How long before this link expires, in seconds.
     *     Attempting to start an upload with this link longer than this period
     *     of time after link creation will result in an error. Must be greater
     *     than or equal to 60.0 and be less than or equal to 14400.0.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTemporaryUploadLinkResult getTemporaryUploadLink(CommitInfo commitInfo, double duration) throws DbxApiException, DbxException {
        if (duration < 60.0) {
            throw new IllegalArgumentException("Number 'duration' is smaller than 60.0");
        }
        if (duration > 14400.0) {
            throw new IllegalArgumentException("Number 'duration' is larger than 14400.0");
        }
        GetTemporaryUploadLinkArg _arg = new GetTemporaryUploadLinkArg(commitInfo, duration);
        return getTemporaryUploadLink(_arg);
    }

    //
    // route 2/files/get_thumbnail
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
    DbxDownloader<FileMetadata> getThumbnail(ThumbnailArg arg, List<HttpRequestor.Header> _headers) throws ThumbnailErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/files/get_thumbnail",
                                             arg,
                                             false,
                                             _headers,
                                             ThumbnailArg.Serializer.INSTANCE,
                                             FileMetadata.Serializer.INSTANCE,
                                             ThumbnailError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ThumbnailErrorException("2/files/get_thumbnail", ex.getRequestId(), ex.getUserMessage(), (ThumbnailError) ex.getErrorValue());
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
        ThumbnailArg _arg = new ThumbnailArg(path);
        return getThumbnail(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * Get a thumbnail for an image. This method currently supports files with
     * the following file extensions: jpg, jpeg, png, tiff, tif, gif, webp, ppm
     * and bmp. Photos that are larger than 20MB in size won't be converted to a
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
     * See {@link DbxUserGetThumbnailV2Builder} for more details. </p>
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
    public DbxUserGetThumbnailV2Builder getThumbnailV2Builder(PathOrLink resource) {
        ThumbnailV2Arg.Builder argBuilder_ = ThumbnailV2Arg.newBuilder(resource);
        return new DbxUserGetThumbnailV2Builder(this, argBuilder_);
    }

    //
    // route 2/files/get_thumbnail_batch
    //

    /**
     * Get thumbnails for a list of images. We allow up to 25 thumbnails in a
     * single batch. This method currently supports files with the following
     * file extensions: jpg, jpeg, png, tiff, tif, gif, webp, ppm and bmp.
     * Photos that are larger than 20MB in size won't be converted to a
     * thumbnail.
     *
     * @param arg  Arguments for {@link
     *     DbxUserFilesRequests#getThumbnailBatch(List)}.
     */
    GetThumbnailBatchResult getThumbnailBatch(GetThumbnailBatchArg arg) throws GetThumbnailBatchErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getContent(),
                                        "2/files/get_thumbnail_batch",
                                        arg,
                                        false,
                                        GetThumbnailBatchArg.Serializer.INSTANCE,
                                        GetThumbnailBatchResult.Serializer.INSTANCE,
                                        GetThumbnailBatchError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new GetThumbnailBatchErrorException("2/files/get_thumbnail_batch", ex.getRequestId(), ex.getUserMessage(), (GetThumbnailBatchError) ex.getErrorValue());
        }
    }

    /**
     * Get thumbnails for a list of images. We allow up to 25 thumbnails in a
     * single batch.
     *
     * <p> This method currently supports files with the following file
     * extensions: jpg, jpeg, png, tiff, tif, gif, webp, ppm and bmp. Photos
     * that are larger than 20MB in size won't be converted to a thumbnail. </p>
     *
     * @param entries  List of files to get thumbnails. Must not contain a
     *     {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetThumbnailBatchResult getThumbnailBatch(List<ThumbnailArg> entries) throws GetThumbnailBatchErrorException, DbxException {
        GetThumbnailBatchArg _arg = new GetThumbnailBatchArg(entries);
        return getThumbnailBatch(_arg);
    }

    //
    // route 2/files/list_folder
    //

    /**
     * Starts returning the contents of a folder. If the result's {@link
     * ListFolderResult#getHasMore} field is {@code true}, call {@link
     * DbxUserFilesRequests#listFolderContinue(String)} with the returned {@link
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
     * multiple {@link DbxUserFilesRequests#listFolder(String)} or {@link
     * DbxUserFilesRequests#listFolderContinue(String)} calls with same
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
     * DbxUserFilesRequests#listFolderContinue(String)} with the returned {@link
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
     * if multiple {@link DbxUserFilesRequests#listFolder(String)} or {@link
     * DbxUserFilesRequests#listFolderContinue(String)} calls with same
     * parameters are made simultaneously by same API app for same user. If your
     * app implements retry logic, please hold off the retry until the previous
     * request finishes. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link DbxUserListFolderBuilder} for more details. </p>
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
     * DbxUserFilesRequests#listFolderContinue(String)} with the returned {@link
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
     * multiple {@link DbxUserFilesRequests#listFolder(String)} or {@link
     * DbxUserFilesRequests#listFolderContinue(String)} calls with same
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
    public DbxUserListFolderBuilder listFolderBuilder(String path) {
        ListFolderArg.Builder argBuilder_ = ListFolderArg.newBuilder(path);
        return new DbxUserListFolderBuilder(this, argBuilder_);
    }

    //
    // route 2/files/list_folder/continue
    //

    /**
     * Once a cursor has been retrieved from {@link
     * DbxUserFilesRequests#listFolder(String)}, use this to paginate through
     * all files and retrieve updates to the folder, following the same rules as
     * documented for {@link DbxUserFilesRequests#listFolder(String)}.
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
     * DbxUserFilesRequests#listFolder(String)}, use this to paginate through
     * all files and retrieve updates to the folder, following the same rules as
     * documented for {@link DbxUserFilesRequests#listFolder(String)}.
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
        ListFolderContinueArg _arg = new ListFolderContinueArg(cursor);
        return listFolderContinue(_arg);
    }

    //
    // route 2/files/list_folder/get_latest_cursor
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
    ListFolderGetLatestCursorResult listFolderGetLatestCursor(ListFolderArg arg) throws ListFolderErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/list_folder/get_latest_cursor",
                                        arg,
                                        false,
                                        ListFolderArg.Serializer.INSTANCE,
                                        ListFolderGetLatestCursorResult.Serializer.INSTANCE,
                                        ListFolderError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFolderErrorException("2/files/list_folder/get_latest_cursor", ex.getRequestId(), ex.getUserMessage(), (ListFolderError) ex.getErrorValue());
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
     * @param path  A unique identifier for the file. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderGetLatestCursorResult listFolderGetLatestCursor(String path) throws ListFolderErrorException, DbxException {
        ListFolderArg _arg = new ListFolderArg(path);
        return listFolderGetLatestCursor(_arg);
    }

    /**
     * A way to quickly get a cursor for the folder's state. Unlike {@link
     * DbxUserFilesRequests#listFolder(String)}, {@link
     * DbxUserFilesRequests#listFolderGetLatestCursor(String)} doesn't return
     * any entries. This endpoint is for app which only needs to know about new
     * files and modifications and doesn't need to know about files that already
     * exist in Dropbox.
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
    public ListFolderGetLatestCursorBuilder listFolderGetLatestCursorBuilder(String path) {
        ListFolderArg.Builder argBuilder_ = ListFolderArg.newBuilder(path);
        return new ListFolderGetLatestCursorBuilder(this, argBuilder_);
    }

    //
    // route 2/files/list_folder/longpoll
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
    ListFolderLongpollResult listFolderLongpoll(ListFolderLongpollArg arg) throws ListFolderLongpollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getNotify(),
                                        "2/files/list_folder/longpoll",
                                        arg,
                                        true,
                                        ListFolderLongpollArg.Serializer.INSTANCE,
                                        ListFolderLongpollResult.Serializer.INSTANCE,
                                        ListFolderLongpollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListFolderLongpollErrorException("2/files/list_folder/longpoll", ex.getRequestId(), ex.getUserMessage(), (ListFolderLongpollError) ex.getErrorValue());
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
        ListFolderLongpollArg _arg = new ListFolderLongpollArg(cursor);
        return listFolderLongpoll(_arg);
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
        ListFolderLongpollArg _arg = new ListFolderLongpollArg(cursor, timeout);
        return listFolderLongpoll(_arg);
    }

    //
    // route 2/files/list_revisions
    //

    /**
     * Returns revisions for files based on a file path or a file id. The file
     * path or file id is identified from the latest file entry at the given
     * file path or id. This end point allows your app to query either by file
     * path or file id by setting the mode parameter appropriately. In the
     * {@link ListRevisionsMode#PATH} (default) mode, all revisions at the same
     * file path as the latest file entry are returned. If revisions with the
     * same file id are desired, then mode must be set to {@link
     * ListRevisionsMode#ID}. The {@link ListRevisionsMode#ID} mode is useful to
     * retrieve revisions for a given file across moves or renames.
     *
     */
    ListRevisionsResult listRevisions(ListRevisionsArg arg) throws ListRevisionsErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/list_revisions",
                                        arg,
                                        false,
                                        ListRevisionsArg.Serializer.INSTANCE,
                                        ListRevisionsResult.Serializer.INSTANCE,
                                        ListRevisionsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new ListRevisionsErrorException("2/files/list_revisions", ex.getRequestId(), ex.getUserMessage(), (ListRevisionsError) ex.getErrorValue());
        }
    }

    /**
     * Returns revisions for files based on a file path or a file id. The file
     * path or file id is identified from the latest file entry at the given
     * file path or id. This end point allows your app to query either by file
     * path or file id by setting the mode parameter appropriately.
     *
     * <p> In the {@link ListRevisionsMode#PATH} (default) mode, all revisions
     * at the same file path as the latest file entry are returned. If revisions
     * with the same file id are desired, then mode must be set to {@link
     * ListRevisionsMode#ID}. The {@link ListRevisionsMode#ID} mode is useful to
     * retrieve revisions for a given file across moves or renames. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link ListRevisionsBuilder} for more details. </p>
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsResult listRevisions(String path) throws ListRevisionsErrorException, DbxException {
        ListRevisionsArg _arg = new ListRevisionsArg(path);
        return listRevisions(_arg);
    }

    /**
     * Returns revisions for files based on a file path or a file id. The file
     * path or file id is identified from the latest file entry at the given
     * file path or id. This end point allows your app to query either by file
     * path or file id by setting the mode parameter appropriately. In the
     * {@link ListRevisionsMode#PATH} (default) mode, all revisions at the same
     * file path as the latest file entry are returned. If revisions with the
     * same file id are desired, then mode must be set to {@link
     * ListRevisionsMode#ID}. The {@link ListRevisionsMode#ID} mode is useful to
     * retrieve revisions for a given file across moves or renames.
     *
     * @param path  The path to the file you want to see the revisions of. Must
     *     match pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and
     *     not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListRevisionsBuilder listRevisionsBuilder(String path) {
        ListRevisionsArg.Builder argBuilder_ = ListRevisionsArg.newBuilder(path);
        return new ListRevisionsBuilder(this, argBuilder_);
    }

    //
    // route 2/files/lock_file_batch
    //

    /**
     * Lock the files at the given paths. A locked file will be writable only by
     * the lock holder. A successful response indicates that the file has been
     * locked. Returns a list of the locked file paths and their metadata after
     * this operation.
     *
     */
    LockFileBatchResult lockFileBatch(LockFileBatchArg arg) throws LockFileErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/lock_file_batch",
                                        arg,
                                        false,
                                        LockFileBatchArg.Serializer.INSTANCE,
                                        LockFileBatchResult.Serializer.INSTANCE,
                                        LockFileError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new LockFileErrorException("2/files/lock_file_batch", ex.getRequestId(), ex.getUserMessage(), (LockFileError) ex.getErrorValue());
        }
    }

    /**
     * Lock the files at the given paths. A locked file will be writable only by
     * the lock holder. A successful response indicates that the file has been
     * locked. Returns a list of the locked file paths and their metadata after
     * this operation.
     *
     * @param entries  List of 'entries'. Each 'entry' contains a path of the
     *     file which will be locked or queried. Duplicate path arguments in the
     *     batch are considered only once. Must not contain a {@code null} item
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LockFileBatchResult lockFileBatch(List<LockFileArg> entries) throws LockFileErrorException, DbxException {
        LockFileBatchArg _arg = new LockFileBatchArg(entries);
        return lockFileBatch(_arg);
    }

    //
    // route 2/files/move_v2
    //

    /**
     * Move a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be moved. Note that we
     * do not currently support case-only renaming.
     *
     */
    RelocationResult moveV2(RelocationArg arg) throws RelocationErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/move_v2",
                                        arg,
                                        false,
                                        RelocationArg.Serializer.INSTANCE,
                                        RelocationResult.Serializer.INSTANCE,
                                        RelocationError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RelocationErrorException("2/files/move_v2", ex.getRequestId(), ex.getUserMessage(), (RelocationError) ex.getErrorValue());
        }
    }

    /**
     * Move a file or folder to a different location in the user's Dropbox.
     *
     * <p> If the source path is a folder all its contents will be moved. </p>
     *
     * <p> Note that we do not currently support case-only renaming. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link MoveV2Builder} for more details. </p>
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationResult moveV2(String fromPath, String toPath) throws RelocationErrorException, DbxException {
        RelocationArg _arg = new RelocationArg(fromPath, toPath);
        return moveV2(_arg);
    }

    /**
     * Move a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be moved. Note that we
     * do not currently support case-only renaming.
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MoveV2Builder moveV2Builder(String fromPath, String toPath) {
        RelocationArg.Builder argBuilder_ = RelocationArg.newBuilder(fromPath, toPath);
        return new MoveV2Builder(this, argBuilder_);
    }

    //
    // route 2/files/move
    //

    /**
     * Move a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be moved.
     *
     *
     * @return Metadata for a file or folder.
     */
    Metadata move(RelocationArg arg) throws RelocationErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/move",
                                        arg,
                                        false,
                                        RelocationArg.Serializer.INSTANCE,
                                        Metadata.Serializer.INSTANCE,
                                        RelocationError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RelocationErrorException("2/files/move", ex.getRequestId(), ex.getUserMessage(), (RelocationError) ex.getErrorValue());
        }
    }

    /**
     * Move a file or folder to a different location in the user's Dropbox.
     *
     * <p> If the source path is a folder all its contents will be moved. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link MoveBuilder} for more details. </p>
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     *
     * @return Metadata for a file or folder.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#moveV2(String,String)}
     *     instead.
     */
    @Deprecated
    public Metadata move(String fromPath, String toPath) throws RelocationErrorException, DbxException {
        RelocationArg _arg = new RelocationArg(fromPath, toPath);
        return move(_arg);
    }

    /**
     * Move a file or folder to a different location in the user's Dropbox. If
     * the source path is a folder all its contents will be moved.
     *
     * @param fromPath  Path in the user's Dropbox to be copied or moved. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     * @param toPath  Path in the user's Dropbox that is the destination. Must
     *     match pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}"
     *     and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#moveV2(String,String)}
     *     instead.
     */
    @Deprecated
    public MoveBuilder moveBuilder(String fromPath, String toPath) {
        RelocationArg.Builder argBuilder_ = RelocationArg.newBuilder(fromPath, toPath);
        return new MoveBuilder(this, argBuilder_);
    }

    //
    // route 2/files/move_batch_v2
    //

    /**
     * Move multiple files or folders to different locations at once in the
     * user's Dropbox. Note that we do not currently support case-only renaming.
     * This route will replace {@code moveBatch:1}. The main difference is this
     * route will return status for each entry, while {@code moveBatch:1} raises
     * failure if any entry fails. This route will either finish synchronously,
     * or return a job ID and do the async move job in background. Please use
     * {@link DbxUserFilesRequests#moveBatchCheckV2(String)} to check the job
     * status.
     *
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#copyBatchV2(List,boolean)} or {@link
     *     DbxUserFilesRequests#moveBatchV2(List)} that may either launch an
     *     asynchronous job or complete synchronously.
     */
    RelocationBatchV2Launch moveBatchV2(MoveBatchArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/move_batch_v2",
                                        arg,
                                        false,
                                        MoveBatchArg.Serializer.INSTANCE,
                                        RelocationBatchV2Launch.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"move_batch_v2\":" + ex.getErrorValue());
        }
    }

    /**
     * Move multiple files or folders to different locations at once in the
     * user's Dropbox. Note that we do not currently support case-only renaming.
     *
     * <p> This route will replace {@code moveBatch:1}. The main difference is
     * this route will return status for each entry, while {@code moveBatch:1}
     * raises failure if any entry fails. </p>
     *
     * <p> This route will either finish synchronously, or return a job ID and
     * do the async move job in background. Please use {@link
     * DbxUserFilesRequests#moveBatchCheckV2(String)} to check the job status.
     * </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link MoveBatchV2Builder} for more details. </p>
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#copyBatchV2(List,boolean)} or {@link
     *     DbxUserFilesRequests#moveBatchV2(List)} that may either launch an
     *     asynchronous job or complete synchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationBatchV2Launch moveBatchV2(List<RelocationPath> entries) throws DbxApiException, DbxException {
        MoveBatchArg _arg = new MoveBatchArg(entries);
        return moveBatchV2(_arg);
    }

    /**
     * Move multiple files or folders to different locations at once in the
     * user's Dropbox. Note that we do not currently support case-only renaming.
     * This route will replace {@code moveBatch:1}. The main difference is this
     * route will return status for each entry, while {@code moveBatch:1} raises
     * failure if any entry fails. This route will either finish synchronously,
     * or return a job ID and do the async move job in background. Please use
     * {@link DbxUserFilesRequests#moveBatchCheckV2(String)} to check the job
     * status.
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public MoveBatchV2Builder moveBatchV2Builder(List<RelocationPath> entries) {
        MoveBatchArg.Builder argBuilder_ = MoveBatchArg.newBuilder(entries);
        return new MoveBatchV2Builder(this, argBuilder_);
    }

    //
    // route 2/files/move_batch
    //

    /**
     * Move multiple files or folders to different locations at once in the
     * user's Dropbox. This route will return job ID immediately and do the
     * async moving job in background. Please use {@code moveBatchCheck:1} to
     * check the job status.
     *
     *
     * @return Result returned by {@link DbxUserFilesRequests#copyBatch(List)}
     *     or {@link DbxUserFilesRequests#moveBatch(List)} that may either
     *     launch an asynchronous job or complete synchronously.
     */
    RelocationBatchLaunch moveBatch(RelocationBatchArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/move_batch",
                                        arg,
                                        false,
                                        RelocationBatchArg.Serializer.INSTANCE,
                                        RelocationBatchLaunch.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"move_batch\":" + ex.getErrorValue());
        }
    }

    /**
     * Move multiple files or folders to different locations at once in the
     * user's Dropbox.
     *
     * <p> This route will return job ID immediately and do the async moving job
     * in background. Please use {@code moveBatchCheck:1} to check the job
     * status. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link MoveBatchBuilder} for more details. </p>
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     *
     * @return Result returned by {@link DbxUserFilesRequests#copyBatch(List)}
     *     or {@link DbxUserFilesRequests#moveBatch(List)} that may either
     *     launch an asynchronous job or complete synchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#moveBatchV2(List)} instead.
     */
    @Deprecated
    public RelocationBatchLaunch moveBatch(List<RelocationPath> entries) throws DbxApiException, DbxException {
        RelocationBatchArg _arg = new RelocationBatchArg(entries);
        return moveBatch(_arg);
    }

    /**
     * Move multiple files or folders to different locations at once in the
     * user's Dropbox. This route will return job ID immediately and do the
     * async moving job in background. Please use {@code moveBatchCheck:1} to
     * check the job status.
     *
     * @param entries  List of entries to be moved or copied. Each entry is
     *     {@link RelocationPath}. Must contain at least 1 items, contain at
     *     most 1000 items, not contain a {@code null} item, and not be {@code
     *     null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#moveBatchV2(List)} instead.
     */
    @Deprecated
    public MoveBatchBuilder moveBatchBuilder(List<RelocationPath> entries) {
        RelocationBatchArg.Builder argBuilder_ = RelocationBatchArg.newBuilder(entries);
        return new MoveBatchBuilder(this, argBuilder_);
    }

    //
    // route 2/files/move_batch/check_v2
    //

    /**
     * Returns the status of an asynchronous job for {@link
     * DbxUserFilesRequests#moveBatchV2(List)}. It returns list of results for
     * each entry.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#copyBatchCheckV2(String)} or {@link
     *     DbxUserFilesRequests#moveBatchCheckV2(String)} that may either be in
     *     progress or completed with result for each entry.
     */
    RelocationBatchV2JobStatus moveBatchCheckV2(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/move_batch/check_v2",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        RelocationBatchV2JobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/files/move_batch/check_v2", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for {@link
     * DbxUserFilesRequests#moveBatchV2(List)}. It returns list of results for
     * each entry.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#copyBatchCheckV2(String)} or {@link
     *     DbxUserFilesRequests#moveBatchCheckV2(String)} that may either be in
     *     progress or completed with result for each entry.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public RelocationBatchV2JobStatus moveBatchCheckV2(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return moveBatchCheckV2(_arg);
    }

    //
    // route 2/files/move_batch/check
    //

    /**
     * Returns the status of an asynchronous job for {@code moveBatch:1}. If
     * success, it returns list of results for each entry.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    RelocationBatchJobStatus moveBatchCheck(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/move_batch/check",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        RelocationBatchJobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/files/move_batch/check", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for {@code moveBatch:1}. If
     * success, it returns list of results for each entry.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#moveBatchCheckV2(String)}
     *     instead.
     */
    @Deprecated
    public RelocationBatchJobStatus moveBatchCheck(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return moveBatchCheck(_arg);
    }

    //
    // route 2/files/paper/create
    //

    /**
     * Creates a new Paper doc with the provided content.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    PaperCreateUploader paperCreate(PaperCreateArg arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getApi(),
                                                                   "2/files/paper/create",
                                                                   arg,
                                                                   false,
                                                                   PaperCreateArg.Serializer.INSTANCE);
        return new PaperCreateUploader(_uploader, this.client.getUserId());
    }

    /**
     * Creates a new Paper doc with the provided content.
     *
     * @param path  The fully qualified path to the location in the user's
     *     Dropbox where the Paper Doc should be created. This should include
     *     the document's title and end with .paper. Must match pattern "{@code
     *     /(.|[\\r\\n])*}" and not be {@code null}.
     * @param importFormat  The format of the provided data. Must not be {@code
     *     null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperCreateUploader paperCreate(String path, ImportFormat importFormat) throws DbxException {
        PaperCreateArg _arg = new PaperCreateArg(path, importFormat);
        return paperCreate(_arg);
    }

    //
    // route 2/files/paper/update
    //

    /**
     * Updates an existing Paper doc with the provided content.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    PaperUpdateUploader paperUpdate(PaperUpdateArg arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getApi(),
                                                                   "2/files/paper/update",
                                                                   arg,
                                                                   false,
                                                                   PaperUpdateArg.Serializer.INSTANCE);
        return new PaperUpdateUploader(_uploader, this.client.getUserId());
    }

    /**
     * Updates an existing Paper doc with the provided content.
     *
     * @param path  Path in the user's Dropbox to update. The path must
     *     correspond to a Paper doc or an error will be returned. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
     * @param importFormat  The format of the provided data. Must not be {@code
     *     null}.
     * @param docUpdatePolicy  How the provided content should be applied to the
     *     doc. Must not be {@code null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperUpdateUploader paperUpdate(String path, ImportFormat importFormat, PaperDocUpdatePolicy docUpdatePolicy) throws DbxException {
        PaperUpdateArg _arg = new PaperUpdateArg(path, importFormat, docUpdatePolicy);
        return paperUpdate(_arg);
    }

    /**
     * Updates an existing Paper doc with the provided content.
     *
     * @param path  Path in the user's Dropbox to update. The path must
     *     correspond to a Paper doc or an error will be returned. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
     * @param importFormat  The format of the provided data. Must not be {@code
     *     null}.
     * @param docUpdatePolicy  How the provided content should be applied to the
     *     doc. Must not be {@code null}.
     * @param paperRevision  The latest doc revision. Required when
     *     doc_update_policy is update. This value must match the current
     *     revision of the doc or error revision_mismatch will be returned.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public PaperUpdateUploader paperUpdate(String path, ImportFormat importFormat, PaperDocUpdatePolicy docUpdatePolicy, Long paperRevision) throws DbxException {
        PaperUpdateArg _arg = new PaperUpdateArg(path, importFormat, docUpdatePolicy, paperRevision);
        return paperUpdate(_arg);
    }

    //
    // route 2/files/permanently_delete
    //

    /**
     * Permanently delete the file or folder at a given path (see
     * https://www.dropbox.com/en/help/40). If the given file or folder is not
     * yet deleted, this route will first delete it. It is possible for this
     * route to successfully delete, then fail to permanently delete. Note: This
     * endpoint is only available for Dropbox Business apps.
     *
     */
    void permanentlyDelete(DeleteArg arg) throws DeleteErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/files/permanently_delete",
                                 arg,
                                 false,
                                 DeleteArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 DeleteError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DeleteErrorException("2/files/permanently_delete", ex.getRequestId(), ex.getUserMessage(), (DeleteError) ex.getErrorValue());
        }
    }

    /**
     * Permanently delete the file or folder at a given path (see
     * https://www.dropbox.com/en/help/40).
     *
     * <p> If the given file or folder is not yet deleted, this route will first
     * delete it. It is possible for this route to successfully delete, then
     * fail to permanently delete. </p>
     *
     * <p> Note: This endpoint is only available for Dropbox Business apps. </p>
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void permanentlyDelete(String path) throws DeleteErrorException, DbxException {
        DeleteArg _arg = new DeleteArg(path);
        permanentlyDelete(_arg);
    }

    /**
     * Permanently delete the file or folder at a given path (see
     * https://www.dropbox.com/en/help/40).
     *
     * <p> If the given file or folder is not yet deleted, this route will first
     * delete it. It is possible for this route to successfully delete, then
     * fail to permanently delete. </p>
     *
     * <p> Note: This endpoint is only available for Dropbox Business apps. </p>
     *
     * @param path  Path in the user's Dropbox to delete. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not be
     *     {@code null}.
     * @param parentRev  Perform delete if given "rev" matches the existing
     *     file's latest "rev". This field does not support deleting a folder.
     *     Must have length of at least 9 and match pattern "{@code [0-9a-f]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void permanentlyDelete(String path, String parentRev) throws DeleteErrorException, DbxException {
        if (parentRev != null) {
            if (parentRev.length() < 9) {
                throw new IllegalArgumentException("String 'parentRev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", parentRev)) {
                throw new IllegalArgumentException("String 'parentRev' does not match pattern");
            }
        }
        DeleteArg _arg = new DeleteArg(path, parentRev);
        permanentlyDelete(_arg);
    }

    //
    // route 2/files/properties/add
    //

    /**
     *
     */
    void propertiesAdd(AddPropertiesArg arg) throws AddPropertiesErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/files/properties/add",
                                 arg,
                                 false,
                                 AddPropertiesArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 AddPropertiesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new AddPropertiesErrorException("2/files/properties/add", ex.getRequestId(), ex.getUserMessage(), (AddPropertiesError) ex.getErrorValue());
        }
    }

    /**
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param propertyGroups  The property groups which are to be added to a
     *     Dropbox file. No two groups in the input should  refer to the same
     *     template. Must not contain a {@code null} item and not be {@code
     *     null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public void propertiesAdd(String path, List<PropertyGroup> propertyGroups) throws AddPropertiesErrorException, DbxException {
        AddPropertiesArg _arg = new AddPropertiesArg(path, propertyGroups);
        propertiesAdd(_arg);
    }

    //
    // route 2/files/properties/overwrite
    //

    /**
     *
     */
    void propertiesOverwrite(OverwritePropertyGroupArg arg) throws InvalidPropertyGroupErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/files/properties/overwrite",
                                 arg,
                                 false,
                                 OverwritePropertyGroupArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 InvalidPropertyGroupError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new InvalidPropertyGroupErrorException("2/files/properties/overwrite", ex.getRequestId(), ex.getUserMessage(), (InvalidPropertyGroupError) ex.getErrorValue());
        }
    }

    /**
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param propertyGroups  The property groups "snapshot" updates to force
     *     apply. No two groups in the input should  refer to the same template.
     *     Must contain at least 1 items, not contain a {@code null} item, and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public void propertiesOverwrite(String path, List<PropertyGroup> propertyGroups) throws InvalidPropertyGroupErrorException, DbxException {
        OverwritePropertyGroupArg _arg = new OverwritePropertyGroupArg(path, propertyGroups);
        propertiesOverwrite(_arg);
    }

    //
    // route 2/files/properties/remove
    //

    /**
     *
     */
    void propertiesRemove(RemovePropertiesArg arg) throws RemovePropertiesErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/files/properties/remove",
                                 arg,
                                 false,
                                 RemovePropertiesArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 RemovePropertiesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RemovePropertiesErrorException("2/files/properties/remove", ex.getRequestId(), ex.getUserMessage(), (RemovePropertiesError) ex.getErrorValue());
        }
    }

    /**
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param propertyTemplateIds  A list of identifiers for a template created
     *     by {@link
     *     com.dropbox.core.v2.fileproperties.DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@code templatesAddForTeam}. Must not contain a {@code null} item
     *     and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public void propertiesRemove(String path, List<String> propertyTemplateIds) throws RemovePropertiesErrorException, DbxException {
        RemovePropertiesArg _arg = new RemovePropertiesArg(path, propertyTemplateIds);
        propertiesRemove(_arg);
    }

    //
    // route 2/files/properties/template/get
    //

    /**
     *
     */
    GetTemplateResult propertiesTemplateGet(GetTemplateArg arg) throws TemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/properties/template/get",
                                        arg,
                                        false,
                                        GetTemplateArg.Serializer.INSTANCE,
                                        GetTemplateResult.Serializer.INSTANCE,
                                        TemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TemplateErrorException("2/files/properties/template/get", ex.getRequestId(), ex.getUserMessage(), (TemplateError) ex.getErrorValue());
        }
    }

    /**
     *
     * @param templateId  An identifier for template added by route  See {@link
     *     com.dropbox.core.v2.fileproperties.DbxUserFilePropertiesRequests#templatesAddForUser(String,String,List)}
     *     or {@code templatesAddForTeam}. Must have length of at least 1, match
     *     pattern "{@code (/|ptid:).*}", and not be {@code null}.
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
    // route 2/files/properties/template/list
    //

    /**
     *
     * @deprecated
     */
    @Deprecated
    public ListTemplateResult propertiesTemplateList() throws TemplateErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/properties/template/list",
                                        null,
                                        false,
                                        com.dropbox.core.stone.StoneSerializers.void_(),
                                        ListTemplateResult.Serializer.INSTANCE,
                                        TemplateError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new TemplateErrorException("2/files/properties/template/list", ex.getRequestId(), ex.getUserMessage(), (TemplateError) ex.getErrorValue());
        }
    }

    //
    // route 2/files/properties/update
    //

    /**
     *
     */
    void propertiesUpdate(UpdatePropertiesArg arg) throws UpdatePropertiesErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/files/properties/update",
                                 arg,
                                 false,
                                 UpdatePropertiesArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 UpdatePropertiesError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new UpdatePropertiesErrorException("2/files/properties/update", ex.getRequestId(), ex.getUserMessage(), (UpdatePropertiesError) ex.getErrorValue());
        }
    }

    /**
     *
     * @param path  A unique identifier for the file or folder. Must match
     *     pattern "{@code /(.|[\\r\\n])*|id:.*|(ns:[0-9]+(/.*)?)}" and not be
     *     {@code null}.
     * @param updatePropertyGroups  The property groups "delta" updates to
     *     apply. Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated
     */
    @Deprecated
    public void propertiesUpdate(String path, List<PropertyGroupUpdate> updatePropertyGroups) throws UpdatePropertiesErrorException, DbxException {
        UpdatePropertiesArg _arg = new UpdatePropertiesArg(path, updatePropertyGroups);
        propertiesUpdate(_arg);
    }

    //
    // route 2/files/restore
    //

    /**
     * Restore a specific revision of a file to the given path.
     *
     */
    FileMetadata restore(RestoreArg arg) throws RestoreErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/restore",
                                        arg,
                                        false,
                                        RestoreArg.Serializer.INSTANCE,
                                        FileMetadata.Serializer.INSTANCE,
                                        RestoreError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RestoreErrorException("2/files/restore", ex.getRequestId(), ex.getUserMessage(), (RestoreError) ex.getErrorValue());
        }
    }

    /**
     * Restore a specific revision of a file to the given path.
     *
     * @param path  The path to save the restored file. Must match pattern
     *     "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     * @param rev  The revision to restore. Must have length of at least 9,
     *     match pattern "{@code [0-9a-f]+}", and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public FileMetadata restore(String path, String rev) throws RestoreErrorException, DbxException {
        RestoreArg _arg = new RestoreArg(path, rev);
        return restore(_arg);
    }

    //
    // route 2/files/save_url
    //

    /**
     * Save the data from a specified URL into a file in user's Dropbox. Note
     * that the transfer from the URL must complete within 15 minutes, or the
     * operation will time out and the job will fail. If the given path already
     * exists, the file will be renamed to avoid the conflict (e.g. myfile
     * (1).txt).
     *
     */
    SaveUrlResult saveUrl(SaveUrlArg arg) throws SaveUrlErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/save_url",
                                        arg,
                                        false,
                                        SaveUrlArg.Serializer.INSTANCE,
                                        SaveUrlResult.Serializer.INSTANCE,
                                        SaveUrlError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SaveUrlErrorException("2/files/save_url", ex.getRequestId(), ex.getUserMessage(), (SaveUrlError) ex.getErrorValue());
        }
    }

    /**
     * Save the data from a specified URL into a file in user's Dropbox.
     *
     * <p> Note that the transfer from the URL must complete within 15 minutes,
     * or the operation will time out and the job will fail. </p>
     *
     * <p> If the given path already exists, the file will be renamed to avoid
     * the conflict (e.g. myfile (1).txt). </p>
     *
     * @param path  The path in Dropbox where the URL will be saved to. Must
     *     match pattern "{@code /(.|[\\r\\n])*}" and not be {@code null}.
     * @param url  The URL to be saved. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SaveUrlResult saveUrl(String path, String url) throws SaveUrlErrorException, DbxException {
        SaveUrlArg _arg = new SaveUrlArg(path, url);
        return saveUrl(_arg);
    }

    //
    // route 2/files/save_url/check_job_status
    //

    /**
     * Check the status of a {@link DbxUserFilesRequests#saveUrl(String,String)}
     * job.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    SaveUrlJobStatus saveUrlCheckJobStatus(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/save_url/check_job_status",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        SaveUrlJobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/files/save_url/check_job_status", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
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
        PollArg _arg = new PollArg(asyncJobId);
        return saveUrlCheckJobStatus(_arg);
    }

    //
    // route 2/files/search
    //

    /**
     * Searches for files and folders. Note: Recent changes will be reflected in
     * search results within a few seconds and older revisions of existing files
     * may still match your query for up to a few days.
     *
     */
    SearchResult search(SearchArg arg) throws SearchErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/search",
                                        arg,
                                        false,
                                        SearchArg.Serializer.INSTANCE,
                                        SearchResult.Serializer.INSTANCE,
                                        SearchError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SearchErrorException("2/files/search", ex.getRequestId(), ex.getUserMessage(), (SearchError) ex.getErrorValue());
        }
    }

    /**
     * Searches for files and folders.
     *
     * <p> Note: Recent changes will be reflected in search results within a few
     * seconds and older revisions of existing files may still match your query
     * for up to a few days. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link SearchBuilder} for more details. </p>
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     * @param query  The string to search for. Query string may be rewritten to
     *     improve relevance of results. The string is split on spaces into
     *     multiple tokens. For file name searching, the last token is used for
     *     prefix matching (i.e. "bat c" matches "bat cave" but not "batman
     *     car"). Must have length of at most 1000 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#searchV2(String)} instead.
     */
    @Deprecated
    public SearchResult search(String path, String query) throws SearchErrorException, DbxException {
        SearchArg _arg = new SearchArg(path, query);
        return search(_arg);
    }

    /**
     * Searches for files and folders. Note: Recent changes will be reflected in
     * search results within a few seconds and older revisions of existing files
     * may still match your query for up to a few days.
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     * @param query  The string to search for. Query string may be rewritten to
     *     improve relevance of results. The string is split on spaces into
     *     multiple tokens. For file name searching, the last token is used for
     *     prefix matching (i.e. "bat c" matches "bat cave" but not "batman
     *     car"). Must have length of at most 1000 and not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link DbxUserFilesRequests#searchV2(String)} instead.
     */
    @Deprecated
    public SearchBuilder searchBuilder(String path, String query) {
        SearchArg.Builder argBuilder_ = SearchArg.newBuilder(path, query);
        return new SearchBuilder(this, argBuilder_);
    }

    //
    // route 2/files/search_v2
    //

    /**
     * Searches for files and folders. Note: {@link
     * DbxUserFilesRequests#searchV2(String)} along with {@link
     * DbxUserFilesRequests#searchContinueV2(String)} can only be used to
     * retrieve a maximum of 10,000 matches. Recent changes may not immediately
     * be reflected in search results due to a short delay in indexing.
     * Duplicate results may be returned across pages. Some results may not be
     * returned.
     *
     */
    SearchV2Result searchV2(SearchV2Arg arg) throws SearchErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/search_v2",
                                        arg,
                                        false,
                                        SearchV2Arg.Serializer.INSTANCE,
                                        SearchV2Result.Serializer.INSTANCE,
                                        SearchError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SearchErrorException("2/files/search_v2", ex.getRequestId(), ex.getUserMessage(), (SearchError) ex.getErrorValue());
        }
    }

    /**
     * Searches for files and folders.
     *
     * <p> Note: {@link DbxUserFilesRequests#searchV2(String)} along with {@link
     * DbxUserFilesRequests#searchContinueV2(String)} can only be used to
     * retrieve a maximum of 10,000 matches. </p>
     *
     * <p> Recent changes may not immediately be reflected in search results due
     * to a short delay in indexing. Duplicate results may be returned across
     * pages. Some results may not be returned. </p>
     *
     * @param query  The string to search for. May match across multiple fields
     *     based on the request arguments. Must have length of at most 1000 and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchV2Result searchV2(String query) throws SearchErrorException, DbxException {
        SearchV2Arg _arg = new SearchV2Arg(query);
        return searchV2(_arg);
    }

    /**
     * Searches for files and folders. Note: {@link
     * DbxUserFilesRequests#searchV2(String)} along with {@link
     * DbxUserFilesRequests#searchContinueV2(String)} can only be used to
     * retrieve a maximum of 10,000 matches. Recent changes may not immediately
     * be reflected in search results due to a short delay in indexing.
     * Duplicate results may be returned across pages. Some results may not be
     * returned.
     *
     * @param query  The string to search for. May match across multiple fields
     *     based on the request arguments. Must have length of at most 1000 and
     *     not be {@code null}.
     *
     * @return Request builder for configuring request parameters and completing
     *     the request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchV2Builder searchV2Builder(String query) {
        SearchV2Arg.Builder argBuilder_ = SearchV2Arg.newBuilder(query);
        return new SearchV2Builder(this, argBuilder_);
    }

    //
    // route 2/files/search/continue_v2
    //

    /**
     * Fetches the next page of search results returned from {@link
     * DbxUserFilesRequests#searchV2(String)}. Note: {@link
     * DbxUserFilesRequests#searchV2(String)} along with {@link
     * DbxUserFilesRequests#searchContinueV2(String)} can only be used to
     * retrieve a maximum of 10,000 matches. Recent changes may not immediately
     * be reflected in search results due to a short delay in indexing.
     * Duplicate results may be returned across pages. Some results may not be
     * returned.
     *
     */
    SearchV2Result searchContinueV2(SearchV2ContinueArg arg) throws SearchErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/search/continue_v2",
                                        arg,
                                        false,
                                        SearchV2ContinueArg.Serializer.INSTANCE,
                                        SearchV2Result.Serializer.INSTANCE,
                                        SearchError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SearchErrorException("2/files/search/continue_v2", ex.getRequestId(), ex.getUserMessage(), (SearchError) ex.getErrorValue());
        }
    }

    /**
     * Fetches the next page of search results returned from {@link
     * DbxUserFilesRequests#searchV2(String)}.
     *
     * <p> Note: {@link DbxUserFilesRequests#searchV2(String)} along with {@link
     * DbxUserFilesRequests#searchContinueV2(String)} can only be used to
     * retrieve a maximum of 10,000 matches. </p>
     *
     * <p> Recent changes may not immediately be reflected in search results due
     * to a short delay in indexing. Duplicate results may be returned across
     * pages. Some results may not be returned. </p>
     *
     * @param cursor  The cursor returned by your last call to {@link
     *     DbxUserFilesRequests#searchV2(String)}. Used to fetch the next page
     *     of results. Must have length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchV2Result searchContinueV2(String cursor) throws SearchErrorException, DbxException {
        SearchV2ContinueArg _arg = new SearchV2ContinueArg(cursor);
        return searchContinueV2(_arg);
    }

    //
    // route 2/files/tags/add
    //

    /**
     * Add a tag to an item. A tag is a string. The strings are automatically
     * converted to lowercase letters. No more than 20 tags can be added to a
     * given item.
     *
     */
    void tagsAdd(AddTagArg arg) throws AddTagErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/files/tags/add",
                                 arg,
                                 false,
                                 AddTagArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 AddTagError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new AddTagErrorException("2/files/tags/add", ex.getRequestId(), ex.getUserMessage(), (AddTagError) ex.getErrorValue());
        }
    }

    /**
     * Add a tag to an item. A tag is a string. The strings are automatically
     * converted to lowercase letters. No more than 20 tags can be added to a
     * given item.
     *
     * @param path  Path to the item to be tagged. Must match pattern "{@code
     *     /(.|[\\r\\n])*}" and not be {@code null}.
     * @param tagText  The value of the tag to add. Will be automatically
     *     converted to lowercase letters. Must have length of at least 1, have
     *     length of at most 32, match pattern "{@code [\\w]+}", and not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void tagsAdd(String path, String tagText) throws AddTagErrorException, DbxException {
        AddTagArg _arg = new AddTagArg(path, tagText);
        tagsAdd(_arg);
    }

    //
    // route 2/files/tags/get
    //

    /**
     * Get list of tags assigned to items.
     *
     */
    GetTagsResult tagsGet(GetTagsArg arg) throws BaseTagErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/tags/get",
                                        arg,
                                        false,
                                        GetTagsArg.Serializer.INSTANCE,
                                        GetTagsResult.Serializer.INSTANCE,
                                        BaseTagError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new BaseTagErrorException("2/files/tags/get", ex.getRequestId(), ex.getUserMessage(), (BaseTagError) ex.getErrorValue());
        }
    }

    /**
     * Get list of tags assigned to items.
     *
     * @param paths  Path to the items. Must not contain a {@code null} item and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetTagsResult tagsGet(List<String> paths) throws BaseTagErrorException, DbxException {
        GetTagsArg _arg = new GetTagsArg(paths);
        return tagsGet(_arg);
    }

    //
    // route 2/files/tags/remove
    //

    /**
     * Remove a tag from an item.
     *
     */
    void tagsRemove(RemoveTagArg arg) throws RemoveTagErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/files/tags/remove",
                                 arg,
                                 false,
                                 RemoveTagArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 RemoveTagError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new RemoveTagErrorException("2/files/tags/remove", ex.getRequestId(), ex.getUserMessage(), (RemoveTagError) ex.getErrorValue());
        }
    }

    /**
     * Remove a tag from an item.
     *
     * @param path  Path to the item to tag. Must match pattern "{@code
     *     /(.|[\\r\\n])*}" and not be {@code null}.
     * @param tagText  The tag to remove. Will be automatically converted to
     *     lowercase letters. Must have length of at least 1, have length of at
     *     most 32, match pattern "{@code [\\w]+}", and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void tagsRemove(String path, String tagText) throws RemoveTagErrorException, DbxException {
        RemoveTagArg _arg = new RemoveTagArg(path, tagText);
        tagsRemove(_arg);
    }

    //
    // route 2/files/unlock_file_batch
    //

    /**
     * Unlock the files at the given paths. A locked file can only be unlocked
     * by the lock holder or, if a business account, a team admin. A successful
     * response indicates that the file has been unlocked. Returns a list of the
     * unlocked file paths and their metadata after this operation.
     *
     */
    LockFileBatchResult unlockFileBatch(UnlockFileBatchArg arg) throws LockFileErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/unlock_file_batch",
                                        arg,
                                        false,
                                        UnlockFileBatchArg.Serializer.INSTANCE,
                                        LockFileBatchResult.Serializer.INSTANCE,
                                        LockFileError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new LockFileErrorException("2/files/unlock_file_batch", ex.getRequestId(), ex.getUserMessage(), (LockFileError) ex.getErrorValue());
        }
    }

    /**
     * Unlock the files at the given paths. A locked file can only be unlocked
     * by the lock holder or, if a business account, a team admin. A successful
     * response indicates that the file has been unlocked. Returns a list of the
     * unlocked file paths and their metadata after this operation.
     *
     * @param entries  List of 'entries'. Each 'entry' contains a path of the
     *     file which will be unlocked. Duplicate path arguments in the batch
     *     are considered only once. Must not contain a {@code null} item and
     *     not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public LockFileBatchResult unlockFileBatch(List<UnlockFileArg> entries) throws LockFileErrorException, DbxException {
        UnlockFileBatchArg _arg = new UnlockFileBatchArg(entries);
        return unlockFileBatch(_arg);
    }

    //
    // route 2/files/upload
    //

    /**
     * Create a new file with the contents provided in the request. Do not use
     * this to upload a file larger than 150 MB. Instead, create an upload
     * session with {@link DbxUserFilesRequests#uploadSessionStart}. Calls to
     * this endpoint will count as data transport calls for any Dropbox Business
     * teams with a limit on the number of data transport calls allowed per
     * month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    UploadUploader upload(UploadArg arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getContent(),
                                                                   "2/files/upload",
                                                                   arg,
                                                                   false,
                                                                   UploadArg.Serializer.INSTANCE);
        return new UploadUploader(_uploader, this.client.getUserId());
    }

    /**
     * Create a new file with the contents provided in the request.
     *
     * <p> Do not use this to upload a file larger than 150 MB. Instead, create
     * an upload session with {@link DbxUserFilesRequests#uploadSessionStart}.
     * </p>
     *
     * <p> Calls to this endpoint will count as data transport calls for any
     * Dropbox Business teams with a limit on the number of data transport calls
     * allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link UploadBuilder} for more details. </p>
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadUploader upload(String path) throws DbxException {
        UploadArg _arg = new UploadArg(path);
        return upload(_arg);
    }

    /**
     * Create a new file with the contents provided in the request. Do not use
     * this to upload a file larger than 150 MB. Instead, create an upload
     * session with {@link DbxUserFilesRequests#uploadSessionStart}. Calls to
     * this endpoint will count as data transport calls for any Dropbox Business
     * teams with a limit on the number of data transport calls allowed per
     * month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>.
     *
     * @param path  Path in the user's Dropbox to save the file. Must match
     *     pattern "{@code (/(.|[\\r\\n])*)|(ns:[0-9]+(/.*)?)|(id:.*)}" and not
     *     be {@code null}.
     *
     * @return Uploader builder for configuring request parameters and
     *     instantiating an uploader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadBuilder uploadBuilder(String path) {
        UploadArg.Builder argBuilder_ = UploadArg.newBuilder(path);
        return new UploadBuilder(this, argBuilder_);
    }

    //
    // route 2/files/upload_session/append_v2
    //

    /**
     * Append more data to an upload session. When the parameter close is set,
     * this call will close the session. A single request should not upload more
     * than 150 MB. The maximum size of a file one can upload to an upload
     * session is 350 GB. Calls to this endpoint will count as data transport
     * calls for any Dropbox Business teams with a limit on the number of data
     * transport calls allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    UploadSessionAppendV2Uploader uploadSessionAppendV2(UploadSessionAppendArg arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getContent(),
                                                                   "2/files/upload_session/append_v2",
                                                                   arg,
                                                                   false,
                                                                   UploadSessionAppendArg.Serializer.INSTANCE);
        return new UploadSessionAppendV2Uploader(_uploader, this.client.getUserId());
    }

    /**
     * Append more data to an upload session.
     *
     * <p> When the parameter close is set, this call will close the session.
     * </p>
     *
     * <p> A single request should not upload more than 150 MB. The maximum size
     * of a file one can upload to an upload session is 350 GB. </p>
     *
     * <p> Calls to this endpoint will count as data transport calls for any
     * Dropbox Business teams with a limit on the number of data transport calls
     * allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>. </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link UploadSessionAppendV2Builder} for more details. </p>
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
        UploadSessionAppendArg _arg = new UploadSessionAppendArg(cursor);
        return uploadSessionAppendV2(_arg);
    }

    /**
     * Append more data to an upload session. When the parameter close is set,
     * this call will close the session. A single request should not upload more
     * than 150 MB. The maximum size of a file one can upload to an upload
     * session is 350 GB. Calls to this endpoint will count as data transport
     * calls for any Dropbox Business teams with a limit on the number of data
     * transport calls allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>.
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     *
     * @return Uploader builder for configuring request parameters and
     *     instantiating an uploader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionAppendV2Builder uploadSessionAppendV2Builder(UploadSessionCursor cursor) {
        UploadSessionAppendArg.Builder argBuilder_ = UploadSessionAppendArg.newBuilder(cursor);
        return new UploadSessionAppendV2Builder(this, argBuilder_);
    }

    //
    // route 2/files/upload_session/append
    //

    /**
     * Append more data to an upload session. A single request should not upload
     * more than 150 MB. The maximum size of a file one can upload to an upload
     * session is 350 GB. Calls to this endpoint will count as data transport
     * calls for any Dropbox Business teams with a limit on the number of data
     * transport calls allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    UploadSessionAppendUploader uploadSessionAppend(UploadSessionCursor arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getContent(),
                                                                   "2/files/upload_session/append",
                                                                   arg,
                                                                   false,
                                                                   UploadSessionCursor.Serializer.INSTANCE);
        return new UploadSessionAppendUploader(_uploader, this.client.getUserId());
    }

    /**
     * Append more data to an upload session.
     *
     * <p> A single request should not upload more than 150 MB. The maximum size
     * of a file one can upload to an upload session is 350 GB. </p>
     *
     * <p> Calls to this endpoint will count as data transport calls for any
     * Dropbox Business teams with a limit on the number of data transport calls
     * allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>. </p>
     *
     * @param sessionId  The upload session ID (returned by {@link
     *     DbxUserFilesRequests#uploadSessionStart}). Must not be {@code null}.
     * @param offset  Offset in bytes at which data should be appended. We use
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
        UploadSessionCursor _arg = new UploadSessionCursor(sessionId, offset);
        return uploadSessionAppend(_arg);
    }

    //
    // route 2/files/upload_session/finish
    //

    /**
     * Finish an upload session and save the uploaded data to the given file
     * path. A single request should not upload more than 150 MB. The maximum
     * size of a file one can upload to an upload session is 350 GB. Calls to
     * this endpoint will count as data transport calls for any Dropbox Business
     * teams with a limit on the number of data transport calls allowed per
     * month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>.
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    UploadSessionFinishUploader uploadSessionFinish(UploadSessionFinishArg arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getContent(),
                                                                   "2/files/upload_session/finish",
                                                                   arg,
                                                                   false,
                                                                   UploadSessionFinishArg.Serializer.INSTANCE);
        return new UploadSessionFinishUploader(_uploader, this.client.getUserId());
    }

    /**
     * Finish an upload session and save the uploaded data to the given file
     * path.
     *
     * <p> A single request should not upload more than 150 MB. The maximum size
     * of a file one can upload to an upload session is 350 GB. </p>
     *
     * <p> Calls to this endpoint will count as data transport calls for any
     * Dropbox Business teams with a limit on the number of data transport calls
     * allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>. </p>
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
        UploadSessionFinishArg _arg = new UploadSessionFinishArg(cursor, commit);
        return uploadSessionFinish(_arg);
    }

    /**
     * Finish an upload session and save the uploaded data to the given file
     * path.
     *
     * <p> A single request should not upload more than 150 MB. The maximum size
     * of a file one can upload to an upload session is 350 GB. </p>
     *
     * <p> Calls to this endpoint will count as data transport calls for any
     * Dropbox Business teams with a limit on the number of data transport calls
     * allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>. </p>
     *
     * @param cursor  Contains the upload session ID and the offset. Must not be
     *     {@code null}.
     * @param commit  Contains the path and other optional modifiers for the
     *     commit. Must not be {@code null}.
     * @param contentHash  A hash of the file content uploaded in this call. If
     *     provided and the uploaded content does not match this hash, an error
     *     will be returned. For more information see our <a
     *     href="https://www.dropbox.com/developers/reference/content-hash">Content
     *     hash</a> page. Must have length of at least 64 and have length of at
     *     most 64.
     *
     * @return Uploader used to upload the request body and finish request.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionFinishUploader uploadSessionFinish(UploadSessionCursor cursor, CommitInfo commit, String contentHash) throws DbxException {
        if (contentHash != null) {
            if (contentHash.length() < 64) {
                throw new IllegalArgumentException("String 'contentHash' is shorter than 64");
            }
            if (contentHash.length() > 64) {
                throw new IllegalArgumentException("String 'contentHash' is longer than 64");
            }
        }
        UploadSessionFinishArg _arg = new UploadSessionFinishArg(cursor, commit, contentHash);
        return uploadSessionFinish(_arg);
    }

    //
    // route 2/files/upload_session/finish_batch
    //

    /**
     * This route helps you commit many files at once into a user's Dropbox. Use
     * {@link DbxUserFilesRequests#uploadSessionStart} and {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} to
     * upload file contents. We recommend uploading many files in parallel to
     * increase throughput. Once the file contents have been uploaded, rather
     * than calling {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)},
     * use this route to finish all your upload sessions in a single request.
     * {@link UploadSessionStartArg#getClose} or {@link
     * UploadSessionAppendArg#getClose} needs to be true for the last {@link
     * DbxUserFilesRequests#uploadSessionStart} or {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} call.
     * The maximum size of a file one can upload to an upload session is 350 GB.
     * This route will return a job_id immediately and do the async commit job
     * in background. Use {@link
     * DbxUserFilesRequests#uploadSessionFinishBatchCheck(String)} to check the
     * job status. For the same account, this route should be executed serially.
     * That means you should not start the next job before current job finishes.
     * We allow up to 1000 entries in a single request. Calls to this endpoint
     * will count as data transport calls for any Dropbox Business teams with a
     * limit on the number of data transport calls allowed per month. For more
     * information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>.
     *
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#uploadSessionFinishBatch(List)} that may either
     *     launch an asynchronous job or complete synchronously.
     */
    UploadSessionFinishBatchLaunch uploadSessionFinishBatch(UploadSessionFinishBatchArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/upload_session/finish_batch",
                                        arg,
                                        false,
                                        UploadSessionFinishBatchArg.Serializer.INSTANCE,
                                        UploadSessionFinishBatchLaunch.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"upload_session/finish_batch\":" + ex.getErrorValue());
        }
    }

    /**
     * This route helps you commit many files at once into a user's Dropbox. Use
     * {@link DbxUserFilesRequests#uploadSessionStart} and {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} to
     * upload file contents. We recommend uploading many files in parallel to
     * increase throughput. Once the file contents have been uploaded, rather
     * than calling {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)},
     * use this route to finish all your upload sessions in a single request.
     *
     * <p> {@link UploadSessionStartArg#getClose} or {@link
     * UploadSessionAppendArg#getClose} needs to be true for the last {@link
     * DbxUserFilesRequests#uploadSessionStart} or {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} call.
     * The maximum size of a file one can upload to an upload session is 350 GB.
     * </p>
     *
     * <p> This route will return a job_id immediately and do the async commit
     * job in background. Use {@link
     * DbxUserFilesRequests#uploadSessionFinishBatchCheck(String)} to check the
     * job status. </p>
     *
     * <p> For the same account, this route should be executed serially. That
     * means you should not start the next job before current job finishes. We
     * allow up to 1000 entries in a single request. </p>
     *
     * <p> Calls to this endpoint will count as data transport calls for any
     * Dropbox Business teams with a limit on the number of data transport calls
     * allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>. </p>
     *
     * @param entries  Commit information for each file in the batch. Must
     *     contain at most 1000 items, not contain a {@code null} item, and not
     *     be {@code null}.
     *
     * @return Result returned by {@link
     *     DbxUserFilesRequests#uploadSessionFinishBatch(List)} that may either
     *     launch an asynchronous job or complete synchronously.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     *
     * @deprecated use {@link
     *     DbxUserFilesRequests#uploadSessionFinishBatchV2(List)} instead.
     */
    @Deprecated
    public UploadSessionFinishBatchLaunch uploadSessionFinishBatch(List<UploadSessionFinishArg> entries) throws DbxApiException, DbxException {
        UploadSessionFinishBatchArg _arg = new UploadSessionFinishBatchArg(entries);
        return uploadSessionFinishBatch(_arg);
    }

    //
    // route 2/files/upload_session/finish_batch_v2
    //

    /**
     * This route helps you commit many files at once into a user's Dropbox. Use
     * {@link DbxUserFilesRequests#uploadSessionStart} and {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} to
     * upload file contents. We recommend uploading many files in parallel to
     * increase throughput. Once the file contents have been uploaded, rather
     * than calling {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)},
     * use this route to finish all your upload sessions in a single request.
     * {@link UploadSessionStartArg#getClose} or {@link
     * UploadSessionAppendArg#getClose} needs to be true for the last {@link
     * DbxUserFilesRequests#uploadSessionStart} or {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} call of
     * each upload session. The maximum size of a file one can upload to an
     * upload session is 350 GB. We allow up to 1000 entries in a single
     * request. Calls to this endpoint will count as data transport calls for
     * any Dropbox Business teams with a limit on the number of data transport
     * calls allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>.
     *
     */
    UploadSessionFinishBatchResult uploadSessionFinishBatchV2(UploadSessionFinishBatchArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/upload_session/finish_batch_v2",
                                        arg,
                                        false,
                                        UploadSessionFinishBatchArg.Serializer.INSTANCE,
                                        UploadSessionFinishBatchResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"upload_session/finish_batch_v2\":" + ex.getErrorValue());
        }
    }

    /**
     * This route helps you commit many files at once into a user's Dropbox. Use
     * {@link DbxUserFilesRequests#uploadSessionStart} and {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} to
     * upload file contents. We recommend uploading many files in parallel to
     * increase throughput. Once the file contents have been uploaded, rather
     * than calling {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)},
     * use this route to finish all your upload sessions in a single request.
     *
     * <p> {@link UploadSessionStartArg#getClose} or {@link
     * UploadSessionAppendArg#getClose} needs to be true for the last {@link
     * DbxUserFilesRequests#uploadSessionStart} or {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} call of
     * each upload session. The maximum size of a file one can upload to an
     * upload session is 350 GB. </p>
     *
     * <p> We allow up to 1000 entries in a single request. </p>
     *
     * <p> Calls to this endpoint will count as data transport calls for any
     * Dropbox Business teams with a limit on the number of data transport calls
     * allowed per month. For more information, see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>. </p>
     *
     * @param entries  Commit information for each file in the batch. Must
     *     contain at most 1000 items, not contain a {@code null} item, and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionFinishBatchResult uploadSessionFinishBatchV2(List<UploadSessionFinishArg> entries) throws DbxApiException, DbxException {
        UploadSessionFinishBatchArg _arg = new UploadSessionFinishBatchArg(entries);
        return uploadSessionFinishBatchV2(_arg);
    }

    //
    // route 2/files/upload_session/finish_batch/check
    //

    /**
     * Returns the status of an asynchronous job for {@link
     * DbxUserFilesRequests#uploadSessionFinishBatch(List)}. If success, it
     * returns list of result for each entry.
     *
     * @param arg  Arguments for methods that poll the status of an asynchronous
     *     job.
     */
    UploadSessionFinishBatchJobStatus uploadSessionFinishBatchCheck(PollArg arg) throws PollErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/upload_session/finish_batch/check",
                                        arg,
                                        false,
                                        PollArg.Serializer.INSTANCE,
                                        UploadSessionFinishBatchJobStatus.Serializer.INSTANCE,
                                        PollError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new PollErrorException("2/files/upload_session/finish_batch/check", ex.getRequestId(), ex.getUserMessage(), (PollError) ex.getErrorValue());
        }
    }

    /**
     * Returns the status of an asynchronous job for {@link
     * DbxUserFilesRequests#uploadSessionFinishBatch(List)}. If success, it
     * returns list of result for each entry.
     *
     * @param asyncJobId  Id of the asynchronous job. This is the value of a
     *     response returned from the method that launched the job. Must have
     *     length of at least 1 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionFinishBatchJobStatus uploadSessionFinishBatchCheck(String asyncJobId) throws PollErrorException, DbxException {
        PollArg _arg = new PollArg(asyncJobId);
        return uploadSessionFinishBatchCheck(_arg);
    }

    //
    // route 2/files/upload_session/start
    //

    /**
     * Upload sessions allow you to upload a single file in one or more
     * requests, for example where the size of the file is greater than 150 MB.
     * This call starts a new upload session with the given data. You can then
     * use {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} to add
     * more data and {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * to save all the data to a file in Dropbox. A single request should not
     * upload more than 150 MB. The maximum size of a file one can upload to an
     * upload session is 350 GB. An upload session can be used for a maximum of
     * 7 days. Attempting to use an {@link
     * UploadSessionStartResult#getSessionId} with {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} or
     * {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * more than 7 days after its creation will return a {@link
     * UploadSessionLookupError#NOT_FOUND}. Calls to this endpoint will count as
     * data transport calls for any Dropbox Business teams with a limit on the
     * number of data transport calls allowed per month. For more information,
     * see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>. By default, upload sessions require you to send
     * content of the file in sequential order via consecutive {@link
     * DbxUserFilesRequests#uploadSessionStart}, {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}, {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * calls. For better performance, you can instead optionally use a {@link
     * UploadSessionType#CONCURRENT} upload session. To start a new concurrent
     * session, set {@link UploadSessionStartArg#getSessionType} to {@link
     * UploadSessionType#CONCURRENT}. After that, you can send file data in
     * concurrent {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}
     * requests. Finally finish the session with {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}.
     * There are couple of constraints with concurrent sessions to make them
     * work. You can not send data with {@link
     * DbxUserFilesRequests#uploadSessionStart} or {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * call, only with {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} call.
     * Also data uploaded in {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} call
     * must be multiple of 4194304 bytes (except for last {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} with
     * {@link UploadSessionStartArg#getClose} to {@code true}, that may contain
     * any remaining data).
     *
     *
     * @return Uploader used to upload the request body and finish request.
     */
    UploadSessionStartUploader uploadSessionStart(UploadSessionStartArg arg) throws DbxException {
        HttpRequestor.Uploader _uploader = this.client.uploadStyle(this.client.getHost().getContent(),
                                                                   "2/files/upload_session/start",
                                                                   arg,
                                                                   false,
                                                                   UploadSessionStartArg.Serializer.INSTANCE);
        return new UploadSessionStartUploader(_uploader, this.client.getUserId());
    }

    /**
     * Upload sessions allow you to upload a single file in one or more
     * requests, for example where the size of the file is greater than 150 MB.
     * This call starts a new upload session with the given data. You can then
     * use {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} to add
     * more data and {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * to save all the data to a file in Dropbox.
     *
     * <p> A single request should not upload more than 150 MB. The maximum size
     * of a file one can upload to an upload session is 350 GB. </p>
     *
     * <p> An upload session can be used for a maximum of 7 days. Attempting to
     * use an {@link UploadSessionStartResult#getSessionId} with {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} or
     * {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * more than 7 days after its creation will return a {@link
     * UploadSessionLookupError#NOT_FOUND}. </p>
     *
     * <p> Calls to this endpoint will count as data transport calls for any
     * Dropbox Business teams with a limit on the number of data transport calls
     * allowed per month. For more information, see the :link:`Data transport
     * limit page
     * https://www.dropbox.com/developers/reference/data-transport-limit`. </p>
     *
     * <p> By default, upload sessions require you to send content of the file
     * in sequential order via consecutive {@link
     * DbxUserFilesRequests#uploadSessionStart}, {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}, {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * calls. For better performance, you can instead optionally use a {@link
     * UploadSessionType#CONCURRENT} upload session. To start a new concurrent
     * session, set {@link UploadSessionStartArg#getSessionType} to {@link
     * UploadSessionType#CONCURRENT}. After that, you can send file data in
     * concurrent {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}
     * requests. Finally finish the session with {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}.
     * </p>
     *
     * <p> There are couple of constraints with concurrent sessions to make them
     * work. You can not send data with {@link
     * DbxUserFilesRequests#uploadSessionStart} or {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * call, only with {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} call.
     * Also data uploaded in {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} call
     * must be multiple of 4194304 bytes (except for last {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} with
     * {@link UploadSessionStartArg#getClose} to {@code true}, that may contain
     * any remaining data). </p>
     *
     * <p> The default values for the optional request parameters will be used.
     * See {@link UploadSessionStartBuilder} for more details. </p>
     *
     * @return Uploader used to upload the request body and finish request.
     */
    public UploadSessionStartUploader uploadSessionStart() throws DbxException {
        UploadSessionStartArg _arg = new UploadSessionStartArg();
        return uploadSessionStart(_arg);
    }

    /**
     * Upload sessions allow you to upload a single file in one or more
     * requests, for example where the size of the file is greater than 150 MB.
     * This call starts a new upload session with the given data. You can then
     * use {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} to add
     * more data and {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * to save all the data to a file in Dropbox. A single request should not
     * upload more than 150 MB. The maximum size of a file one can upload to an
     * upload session is 350 GB. An upload session can be used for a maximum of
     * 7 days. Attempting to use an {@link
     * UploadSessionStartResult#getSessionId} with {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} or
     * {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * more than 7 days after its creation will return a {@link
     * UploadSessionLookupError#NOT_FOUND}. Calls to this endpoint will count as
     * data transport calls for any Dropbox Business teams with a limit on the
     * number of data transport calls allowed per month. For more information,
     * see the <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>. By default, upload sessions require you to send
     * content of the file in sequential order via consecutive {@link
     * DbxUserFilesRequests#uploadSessionStart}, {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}, {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * calls. For better performance, you can instead optionally use a {@link
     * UploadSessionType#CONCURRENT} upload session. To start a new concurrent
     * session, set {@link UploadSessionStartArg#getSessionType} to {@link
     * UploadSessionType#CONCURRENT}. After that, you can send file data in
     * concurrent {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)}
     * requests. Finally finish the session with {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}.
     * There are couple of constraints with concurrent sessions to make them
     * work. You can not send data with {@link
     * DbxUserFilesRequests#uploadSessionStart} or {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo,String)}
     * call, only with {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} call.
     * Also data uploaded in {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} call
     * must be multiple of 4194304 bytes (except for last {@link
     * DbxUserFilesRequests#uploadSessionAppendV2(UploadSessionCursor)} with
     * {@link UploadSessionStartArg#getClose} to {@code true}, that may contain
     * any remaining data).
     *
     * @return Uploader builder for configuring request parameters and
     *     instantiating an uploader.
     */
    public UploadSessionStartBuilder uploadSessionStartBuilder() {
        UploadSessionStartArg.Builder argBuilder_ = UploadSessionStartArg.newBuilder();
        return new UploadSessionStartBuilder(this, argBuilder_);
    }

    //
    // route 2/files/upload_session/start_batch
    //

    /**
     * This route starts batch of upload_sessions. Please refer to
     * `upload_session/start` usage. Calls to this endpoint will count as data
     * transport calls for any Dropbox Business teams with a limit on the number
     * of data transport calls allowed per month. For more information, see the
     * <a
     * href="https://www.dropbox.com/developers/reference/data-transport-limit">Data
     * transport limit page</a>.
     *
     */
    UploadSessionStartBatchResult uploadSessionStartBatch(UploadSessionStartBatchArg arg) throws DbxApiException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/files/upload_session/start_batch",
                                        arg,
                                        false,
                                        UploadSessionStartBatchArg.Serializer.INSTANCE,
                                        UploadSessionStartBatchResult.Serializer.INSTANCE,
                                        com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"upload_session/start_batch\":" + ex.getErrorValue());
        }
    }

    /**
     * This route starts batch of upload_sessions. Please refer to
     * `upload_session/start` usage.
     *
     * <p> Calls to this endpoint will count as data transport calls for any
     * Dropbox Business teams with a limit on the number of data transport calls
     * allowed per month. For more information, see the :link:`Data transport
     * limit page
     * https://www.dropbox.com/developers/reference/data-transport-limit`. </p>
     *
     * @param numSessions  The number of upload sessions to start. Must be
     *     greater than or equal to 1 and be less than or equal to 1000.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionStartBatchResult uploadSessionStartBatch(long numSessions) throws DbxApiException, DbxException {
        UploadSessionStartBatchArg _arg = new UploadSessionStartBatchArg(numSessions);
        return uploadSessionStartBatch(_arg);
    }

    /**
     * This route starts batch of upload_sessions. Please refer to
     * `upload_session/start` usage.
     *
     * <p> Calls to this endpoint will count as data transport calls for any
     * Dropbox Business teams with a limit on the number of data transport calls
     * allowed per month. For more information, see the :link:`Data transport
     * limit page
     * https://www.dropbox.com/developers/reference/data-transport-limit`. </p>
     *
     * @param numSessions  The number of upload sessions to start. Must be
     *     greater than or equal to 1 and be less than or equal to 1000.
     * @param sessionType  Type of upload session you want to start. If not
     *     specified, default is {@link UploadSessionType#SEQUENTIAL}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UploadSessionStartBatchResult uploadSessionStartBatch(long numSessions, UploadSessionType sessionType) throws DbxApiException, DbxException {
        UploadSessionStartBatchArg _arg = new UploadSessionStartBatchArg(numSessions, sessionType);
        return uploadSessionStartBatch(_arg);
    }
}
