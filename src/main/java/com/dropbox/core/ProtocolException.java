package com.dropbox.core;

/**
 * Something unexpected happened with either the request or the response.
 * This can happen if there's a bug in the client code (including this
 * library), if there's a bug in on the Dropbox server, or if Dropbox
 * made a change to the API that changed the behavior of something and
 * we haven't upgraded our SDK yet.
 *
 * <p>
 * Typically, these kinds of exceptions should be logged, so you can
 * investigate later.
 * </p>
 */
public abstract class ProtocolException extends DbxException {
    private static final long serialVersionUID = 0;

    public ProtocolException(String requestId, String message) {
        super(requestId, message);
    }

    public ProtocolException(String requestId, String message, Throwable cause) {
        super(requestId, message, cause);
    }
}

