/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link DownloadError} error.
 */
public class DownloadErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserFilesRequests#download(String)}.
     */
    public final DownloadError errorValue;

    public DownloadErrorException(String requestId, LocalizedText userMessage, DownloadError errorValue) {
        super(requestId, userMessage, buildMessage("download", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
