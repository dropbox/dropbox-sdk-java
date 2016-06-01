/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;

import java.io.IOException;

/**
 * The {@link DbxUploader} returned by {@link
 * DbxUserFilesRequests#uploadSessionAppend(String,long)}.
 *
 * <p> Use this class to upload data to the server and complete the request.
 * </p>
 *
 * <p> This class should be properly closed after use to prevent resource leaks
 * and allow network connection reuse. Always call {@link #close} when complete
 * (see {@link DbxUploader} for examples). </p>
 */
public class UploadSessionAppendUploader extends DbxUploader<Void, UploadSessionLookupError, UploadSessionLookupErrorException> {

    /**
     * Creates a new instance of this uploader.
     *
     * @param httpUploader  Initiated HTTP upload request
     *
     * @throws NullPointerException  if {@code httpUploader} is {@code null}
     */
    public UploadSessionAppendUploader(HttpRequestor.Uploader httpUploader) {
        super(httpUploader, com.dropbox.core.stone.StoneSerializers.void_(), UploadSessionLookupError.Serializer.INSTANCE);
    }

    protected UploadSessionLookupErrorException newException(DbxWrappedException error) {
        return new UploadSessionLookupErrorException(error.getRequestId(), error.getUserMessage(), (UploadSessionLookupError) error.getErrorValue());
    }
}
