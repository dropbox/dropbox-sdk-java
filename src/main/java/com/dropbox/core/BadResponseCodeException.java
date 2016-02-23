package com.dropbox.core;

/**
 * Thrown when the Dropbox server responds with an HTTP status code we didn't expect.
 */
public class BadResponseCodeException extends BadResponseException {
    private static final long serialVersionUID = 0L;

    private final int statusCode;

    public BadResponseCodeException(String requestId, String message, int statusCode) {
        super(requestId, message);
        this.statusCode = statusCode;
    }

    public BadResponseCodeException(String requestId, String message, int statusCode, Throwable cause) {
        super(requestId, message, cause);
        this.statusCode = statusCode;
    }

    /**
     * Returns HTTP status code received from the Dropbox server.
     *
     * @return HTTP status code returned by Dropbox server
     */
    public int getStatusCode() {
        return statusCode;
    }
}

