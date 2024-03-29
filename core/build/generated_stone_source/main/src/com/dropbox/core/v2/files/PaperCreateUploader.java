/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;

import java.io.IOException;

/**
 * The {@link DbxUploader} returned by {@link
 * DbxUserFilesRequests#paperCreate(String,ImportFormat)}.
 *
 * <p> Use this class to upload data to the server and complete the request.
 * </p>
 *
 * <p> This class should be properly closed after use to prevent resource leaks
 * and allow network connection reuse. Always call {@link #close} when complete
 * (see {@link DbxUploader} for examples). </p>
 */
public class PaperCreateUploader extends DbxUploader<PaperCreateResult, PaperCreateError, PaperCreateErrorException> {

    /**
     * Creates a new instance of this uploader.
     *
     * @param httpUploader  Initiated HTTP upload request
     *
     * @throws NullPointerException  if {@code httpUploader} is {@code null}
     */
    public PaperCreateUploader(HttpRequestor.Uploader httpUploader, String userId) {
        super(httpUploader, PaperCreateResult.Serializer.INSTANCE, PaperCreateError.Serializer.INSTANCE, userId);
    }

    protected PaperCreateErrorException newException(DbxWrappedException error) {
        return new PaperCreateErrorException("2/files/paper/create", error.getRequestId(), error.getUserMessage(), (PaperCreateError) error.getErrorValue());
    }
}
