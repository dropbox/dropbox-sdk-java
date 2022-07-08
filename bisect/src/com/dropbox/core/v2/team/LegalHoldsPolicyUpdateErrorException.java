/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * LegalHoldsPolicyUpdateError} error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamRequests#legalHoldsUpdatePolicy(String,java.util.List)}. </p>
 */
public class LegalHoldsPolicyUpdateErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/legal_holds/update_policy

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#legalHoldsUpdatePolicy(String,java.util.List)}.
     */
    public final LegalHoldsPolicyUpdateError errorValue;

    public LegalHoldsPolicyUpdateErrorException(String routeName, String requestId, LocalizedText userMessage, LegalHoldsPolicyUpdateError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}