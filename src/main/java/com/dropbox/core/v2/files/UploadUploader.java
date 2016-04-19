/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonUtil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;

import java.io.IOException;

/**
 * The {@link DbxUploader} returned by {@link
 * DbxUserFilesRequests#upload(String)}.
 *
 * <p> Use this class to upload data to the server and complete the request.
 * </p>
 *
 * <p> This class should be properly closed after use to prevent resource leaks
 * and allow network connection reuse. Always call {@link #close} when complete
 * (see {@link DbxUploader} for examples). </p>
 */
public class UploadUploader extends DbxUploader<FileMetadata, UploadError, UploadErrorException> {
    private static final JavaType _RESULT_TYPE = JsonUtil.createType(new TypeReference<FileMetadata>() {});
    private static final JavaType _ERROR_TYPE = JsonUtil.createType(new TypeReference<UploadError>() {});

    /**
     * Creates a new instance of this uploader.
     *
     * @param httpUploader  Initiated HTTP upload request
     *
     * @throws NullPointerException  if {@code httpUploader} is {@code null}
     */
    public UploadUploader(HttpRequestor.Uploader httpUploader) {
        super(httpUploader, _RESULT_TYPE, _ERROR_TYPE);
    }
    protected UploadErrorException newException(DbxRequestUtil.ErrorWrapper error) {
        return new UploadErrorException(error.getRequestId(), error.getUserMessage(), (UploadError) error.getErrorValue());
    }
}
