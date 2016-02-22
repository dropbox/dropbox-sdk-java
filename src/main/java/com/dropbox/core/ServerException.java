package com.dropbox.core;

/**
 * The server said that something went wrong on its end (HTTP 500 error code).
 * This indicates bug on the Dropbox server, but there are multiple potential causes.
 *
 * <ul>
 * <li>Sometimes it's just a bug and there's nothing you can
 *     do about it until its fixed.  Report it on the Dropbox API forums.
 *     </li>
 * <li>Sometimes you're actually making an invalid request, but for some reason
 *     the server's validation logic isn't catching the problem and it's
 *     causing the server to error-out somewhere down the line.  You may be able to
 *     fix your request and get things working.  This is still a bug on Dropbox's end,
 *     so you should still report it on the Dropbox API forums.</li>
 * <li>Sometimes the error is intermittent.  It may only happen once every few
 *     requests, in which case you can temporarily work around the issue by
 *     retrying the request.  Again, this still counts as a bug so report it on
 *     the forums.</li>
 * <li>Sometimes the error is temporary.  For example, Dropbox might be experiencing
 *     a temporary network or hardware issue.  If you wait a few minutes, the error
 *     might stop happening.  You might want to check the forums to see if other
 *     people are seeing the same thing.</li>
 * </ul>
 */
public class ServerException extends DbxException {
    private static final long serialVersionUID = 0;

    public ServerException(String requestId, String message) {
        super(requestId, message);
    }
}

