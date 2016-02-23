/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;

import java.io.IOException;

/**
 * The {@link DbxUploader} returned by {@link
 * DbxFiles#uploadSessionAppend(String,long)}.
 *
 * <p> Use this class to upload data to the server and complete the request.
 * </p>
 *
 * <p> This class should be properly closed after use to prevent resource leaks
 * and allow network connection reuse. Always call {@link #close} when complete
 * (see {@link DbxUploader} for examples). </p>
 */
public class UploadSessionAppendUploader extends DbxUploader<Void, UploadSessionLookupErrorException> {

    /**
     * Creates a new instance of this uploader.
     *
     * @param httpUploader  Initiated HTTP upload request
     *
     * @throws NullPointerException  if {@code httpUploader} is {@code null}
     */
    public UploadSessionAppendUploader(HttpRequestor.Uploader httpUploader) {
        super(httpUploader);
    }

    @Override
    protected Void parseResponse(HttpRequestor.Response response) throws JsonReadException, IOException {
        JsonReader.VoidReader.readFully(response.getBody());
        return null;
    }

    @Override
    protected UploadSessionLookupErrorException parseError(HttpRequestor.Response response) throws JsonReadException, IOException {
        DbxRequestUtil.ErrorWrapper wrapper = DbxRequestUtil.ErrorWrapper.fromResponse(UploadSessionLookupError._JSON_READER, response);
        return new UploadSessionLookupErrorException(wrapper.getRequestId(), wrapper.getUserMessage(), (UploadSessionLookupError) wrapper.getErrorValue());
    }
}
