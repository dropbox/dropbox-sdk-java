package com.dropbox.core;

/**
 * Gets thrown when the access token you're using to make API calls is invalid.
 *
 * <p>
 * A more typical situation is that your access token <em>was</em> valid, but the
 * user has since "unlinked" your application via the Dropbox website
 * (<a href="http://www.dropbox.com/account#applications">http://www.dropbox.com/account#applications</a>).
 * When a user unlinks your application, your access tokens for that user become
 * invalid.  You can re-run the authorization process to obtain a new access token.
 * </p>
 */
public class InvalidAccessTokenException extends DbxException {
    private static final long serialVersionUID = 0;

    public InvalidAccessTokenException(String requestId, String message) {
        super(requestId, message);
    }
}
