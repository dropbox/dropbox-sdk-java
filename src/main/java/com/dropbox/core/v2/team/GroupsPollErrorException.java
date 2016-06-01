/* DO NOT EDIT */
/* This file was generated from team_groups.stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link GroupsPollError}
 * error.
 */
public class GroupsPollErrorException extends DbxApiException {
    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#groupsJobStatusGet(String)}.
     */
    public final GroupsPollError errorValue;

    public GroupsPollErrorException(String requestId, LocalizedText userMessage, GroupsPollError errorValue) {
        super(requestId, userMessage, buildMessage("groups/job_status/get", userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
