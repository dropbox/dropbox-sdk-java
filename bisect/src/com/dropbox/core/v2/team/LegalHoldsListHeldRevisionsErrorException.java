/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.LocalizedText;

/**
 * Exception thrown when the server responds with a {@link
 * LegalHoldsListHeldRevisionsError} error.
 *
 * <p> This exception is raised by {@link
 * DbxTeamTeamRequests#legalHoldsListHeldRevisions(String)} and {@link
 * DbxTeamTeamRequests#legalHoldsListHeldRevisionsContinue(String,String)}. </p>
 */
public class LegalHoldsListHeldRevisionsErrorException extends DbxApiException {
    // exception for routes:
    //     2/team/legal_holds/list_held_revisions
    //     2/team/legal_holds/list_held_revisions_continue

    private static final long serialVersionUID = 0L;

    /**
     * The error reported by {@link
     * DbxTeamTeamRequests#legalHoldsListHeldRevisions(String)} and {@link
     * DbxTeamTeamRequests#legalHoldsListHeldRevisionsContinue(String,String)}.
     */
    public final LegalHoldsListHeldRevisionsError errorValue;

    public LegalHoldsListHeldRevisionsErrorException(String routeName, String requestId, LocalizedText userMessage, LegalHoldsListHeldRevisionsError errorValue) {
        super(requestId, userMessage, buildMessage(routeName, userMessage, errorValue));
        if (errorValue == null) {
            throw new NullPointerException("errorValue");
        }
        this.errorValue = errorValue;
    }
}
