package com.dropbox.core;

/**
 * This is what is thrown when the Dropbox server tells us that it didn't like something about our
 * request.  This corresponds to the HTTP 400 status code.
 */
public class BadRequestException extends ProtocolException {
    private static final long serialVersionUID = 0;

    public BadRequestException(String requestId, String message) {
        super(requestId, message);
    }
}
