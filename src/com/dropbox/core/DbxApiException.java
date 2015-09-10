package com.dropbox.core;

/**
 * Base class for API-specific exceptions raised by API v2 routes.
 */
public class DbxApiException extends DbxException
{
    public DbxApiException(String message) { super(message); }
    public DbxApiException(String message, Throwable cause) { super(message, cause); }
}
