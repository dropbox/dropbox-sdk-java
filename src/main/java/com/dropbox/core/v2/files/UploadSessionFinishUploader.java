/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;

import java.io.IOException;

/**
 * The {@link DbxUploader} returned by {@link
 * DbxFiles#uploadSessionFinish(UploadSessionCursor,CommitInfo)}.
 *
 * <p> Use this class to upload data to the server and complete the request.
 * </p>
 *
 * <p> This class should be properly closed after use to prevent resource leaks
 * and allow network connection reuse. Always call {@link #close} when complete
 * (see {@link DbxUploader} for examples). </p>
 */
public class UploadSessionFinishUploader extends DbxUploader<FileMetadata, UploadSessionFinishErrorException> {

    /**
     * Creates a new instance of this uploader.
     *
     * @param httpUploader  Initiated HTTP upload request
     *
     * @throws NullPointerException  if {@code httpUploader} is {@code null}
     */
    public UploadSessionFinishUploader(HttpRequestor.Uploader httpUploader) {
        super(httpUploader);
    }

    @Override
    protected FileMetadata parseResponse(HttpRequestor.Response response) throws JsonReadException, IOException {
        return FileMetadata._JSON_READER.readFully(response.getBody());
    }

    @Override
    protected UploadSessionFinishErrorException parseError(HttpRequestor.Response response) throws JsonReadException, IOException {
        DbxRequestUtil.ErrorWrapper wrapper = DbxRequestUtil.ErrorWrapper.fromResponse(UploadSessionFinishError._JSON_READER, response);
        return new UploadSessionFinishErrorException(wrapper.getRequestId(), wrapper.getUserMessage(), (UploadSessionFinishError) wrapper.getErrorValue());
    }
}
