package com.dropbox.core;

import java.util.concurrent.TimeUnit;

/**
 * The server is overloaded, or you have hit a rate limit.  Try again later after the designated
 * backoff (see {@link #getBackoffMillis}).
 */
public class RateLimitException extends RetryException {
    private static final long serialVersionUID = 0L;

    public RateLimitException(String requestId, String message, long backoff, TimeUnit unit) {
        super(requestId, message, backoff, unit);
    }
}

