/* DO NOT EDIT */
/* This file was generated from users.babel */

package com.dropbox.core.v2.users;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GetAccountBatchError}
 * error.
 */
public class GetAccountBatchErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxUserUsersRequests#getAccountBatch(java.util.List)}.
     */
    public final GetAccountBatchError errorValue;

    public GetAccountBatchErrorException(String requestId, LocalizedText userMessage, GetAccountBatchError errorValue) {
        super(requestId, userMessage, buildMessage("get_account_batch", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
