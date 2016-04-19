/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * UploadSessionFinishError} error.
 */
public class UploadSessionFinishErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserFilesRequests#uploadSessionFinish(UploadSessionCursor,CommitInfo)}.
     */
    public final UploadSessionFinishError errorValue;

    public UploadSessionFinishErrorException(String requestId, LocalizedText userMessage, UploadSessionFinishError errorValue) {
        super(requestId, userMessage, buildMessage("upload_session/finish", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
