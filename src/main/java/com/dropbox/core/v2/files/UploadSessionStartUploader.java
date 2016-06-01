/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;

import java.io.IOException;

/**
 * The {@link DbxUploader} returned by {@link
 * DbxUserFilesRequests#uploadSessionStart()}.
 *
 * <p> Use this class to upload data to the server and complete the request.
 * </p>
 *
 * <p> This class should be properly closed after use to prevent resource leaks
 * and allow network connection reuse. Always call {@link #close} when complete
 * (see {@link DbxUploader} for examples). </p>
 */
public class UploadSessionStartUploader extends DbxUploader<UploadSessionStartResult, Void, DbxApiException> {

    /**
     * Creates a new instance of this uploader.
     *
     * @param httpUploader  Initiated HTTP upload request
     *
     * @throws NullPointerException  if {@code httpUploader} is {@code null}
     */
    public UploadSessionStartUploader(HttpRequestor.Uploader httpUploader) {
        super(httpUploader, UploadSessionStartResult.Serializer.INSTANCE, com.dropbox.core.stone.StoneSerializers.void_());
    }

    protected DbxApiException newException(DbxWrappedException error) {
        return new DbxApiException(error.getRequestId(), error.getUserMessage(), "Unexpected error response for \"upload_session/start\":" + error.getErrorValue());
    }
}
