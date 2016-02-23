/* DO NOT EDIT */
/* This file was generated from async.babel */

package com.dropbox.core.v2.async;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link PollError} error.
 */
public class PollErrorException extends DbxApiException {

    /**
     * The error reported by {@link
     * com.dropbox.core.v2.team.DbxTeam#membersRemoveJobStatusGet(String)}.
     */
    public final PollError errorValue;

    public PollErrorException(String requestId, LocalizedText userMessage, PollError errorValue) {
        super(requestId, userMessage, buildMessage("members/remove/job_status/get", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
