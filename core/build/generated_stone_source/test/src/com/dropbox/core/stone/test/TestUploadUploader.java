/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.stone.test;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;

import java.io.IOException;

/**
 * The {@link DbxUploader} returned by {@link
 * DbxTestTestRequests#testUpload(UninitializedReason,String)}.
 *
 * <p> Use this class to upload data to the server and complete the request.
 * </p>
 *
 * <p> This class should be properly closed after use to prevent resource leaks
 * and allow network connection reuse. Always call {@link #close} when complete
 * (see {@link DbxUploader} for examples). </p>
 */
public class TestUploadUploader extends DbxUploader<Void, Void, DbxApiException> {

    /**
     * Creates a new instance of this uploader.
     *
     * @param httpUploader  Initiated HTTP upload request
     *
     * @throws NullPointerException  if {@code httpUploader} is {@code null}
     */
    public TestUploadUploader(HttpRequestor.Uploader httpUploader, String userId) {
        super(httpUploader, com.dropbox.core.stone.StoneSerializers.void_(), com.dropbox.core.stone.StoneSerializers.void_(), userId);
    }

    protected DbxApiException newException(DbxWrappedException error) {
        return new DbxApiException(error.getRequestId(), error.getUserMessage(), "Unexpected error response for \"test_upload\":" + error.getErrorValue());
    }
}