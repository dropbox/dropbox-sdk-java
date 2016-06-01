/* DO NOT EDIT */
/* This file was generated from users.stone */

package com.dropbox.core.v2.users;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GetAccountError}
 * error.
 */
public class GetAccountErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link DbxUserUsersRequests#getAccount(String)}.
     */
    public final GetAccountError errorValue;

    public GetAccountErrorException(String requestId, LocalizedText userMessage, GetAccountError errorValue) {
        super(requestId, userMessage, buildMessage("get_account", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
