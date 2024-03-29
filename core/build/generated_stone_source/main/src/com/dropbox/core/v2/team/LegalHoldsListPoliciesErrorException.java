/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * LegalHoldsListPoliciesError} error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamRequests#legalHoldsListPolicies(boolean)}. </p>
 */
public class LegalHoldsListPoliciesErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/legal_holds/list_policies

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#legalHoldsListPolicies(boolean)}.
     */
    public final LegalHoldsListPoliciesError errorValue;

    public LegalHoldsListPoliciesErrorException(String routeName, String requestId, LocalizedText userMessage, LegalHoldsListPoliciesError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
