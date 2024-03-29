/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.filerequests;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * DeleteAllClosedFileRequestsError} error.
 *
 * <p> This exception is raised by {@link
 * DbxUserFileRequestsRequests#deleteAllClosed}. </p>
 */
public class DeleteAllClosedFileRequestsErrorException extends DbxApiException {
    // exception for routes:
    //     2/file_requests/delete_all_closed

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserFileRequestsRequests#deleteAllClosed}.
     */
    public final DeleteAllClosedFileRequestsError errorValue;

    public DeleteAllClosedFileRequestsErrorException(String routeName, String requestId, LocalizedText userMessage, DeleteAllClosedFileRequestsError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
