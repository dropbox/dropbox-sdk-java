package com.dropbox.core;

import java.util.concurrent.TimeUnit;

/**
 * A transient exception has occurred and the request should be retried. Clients should only retry
 * requests after waiting the requested backoff duration (see {@link #getBackoffMillis}).
 */
public class RetryException extends DbxException {
    private static final long serialVersionUID = 0L;

    private final long backoffMillis;

    /**
     * Creates an instance of this exception with no retry backoff.
     *
     * @param requestId ID assigned to request by Dropbox servers
     * @param message Error message
     */
    public RetryException(String requestId, String message) {
        this(requestId, message, 0L, TimeUnit.MILLISECONDS);
    }

    /**
     * Creates an instance of this exception with the given retry backoff.
     *
     * @param requestId ID assigned to request by Dropbox servers
     * @param message Error message
     * @param backoff amount of time to backoff before retrying the request
     * @param unit unit of time for {@code backoff}
     */
    public RetryException(String requestId, String message, long backoff, TimeUnit unit) {
        super(requestId, message);

        this.backoffMillis = unit.toMillis(backoff);
    }

    /**
     * Returns the number of milliseconds the client should backoff before retrying the request.
     *
     * @return backoff time, in seconds, before retrying the request, or {@code 0} if the request
     * can be retried immediately.
     */
    public long getBackoffMillis() {
        return backoffMillis;
    }
}

