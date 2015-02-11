package com.dropbox.core;

/**
 * Base class for API-specific exceptions raised by API v2 routes.
 * This does intentionally not extend {@link DbxException}.
 */
public class DbxApiError extends Exception
{
    public DbxApiError(String message) { super(message); }
    public DbxApiError(String message, Throwable cause) { super(message, cause); }
}
