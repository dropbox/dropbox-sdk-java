/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.paper;

import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;

import java.io.IOException;

/**
 * The {@link DbxUploader} returned by {@link
 * DbxUserPaperRequests#docsCreate(ImportFormat,String)}.
 *
 * <p> Use this class to upload data to the server and complete the request.
 * </p>
 *
 * <p> This class should be properly closed after use to prevent resource leaks
 * and allow network connection reuse. Always call {@link #close} when complete
 * (see {@link DbxUploader} for examples). </p>
 */
public class DocsCreateUploader extends DbxUploader<PaperDocCreateUpdateResult, PaperDocCreateError, PaperDocCreateErrorException> {

    /**
     * Creates a new instance of this uploader.
     *
     * @param httpUploader  Initiated HTTP upload request
     *
     * @throws NullPointerException  if {@code httpUploader} is {@code null}
     */
    public DocsCreateUploader(HttpRequestor.Uploader httpUploader, String userId) {
        super(httpUploader, PaperDocCreateUpdateResult.Serializer.INSTANCE, PaperDocCreateError.Serializer.INSTANCE, userId);
    }

    protected PaperDocCreateErrorException newException(DbxWrappedException error) {
        return new PaperDocCreateErrorException("2/paper/docs/create", error.getRequestId(), error.getUserMessage(), (PaperDocCreateError) error.getErrorValue());
    }
}
