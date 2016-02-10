package com.dropbox.core;

/**
 * Use with {@link DbxOAuth1Upgrader} to convert old OAuth 1 access tokens
 * to OAuth 2 access tokens.  This SDK doesn't support using OAuth 1 access
 * tokens for regular API calls.
 */
public final class DbxOAuth1AccessToken
{
    /**
     * The OAuth 1 access token key.
     */
    public final String key;

    /**
     * The OAuth 1 access token secret.
     */
    public final String secret;

    /**
     * @param key {@link #key}
     * @param secret {@link #secret}
     */
    public DbxOAuth1AccessToken(String key, String secret)
    {
        this.key = key;
        this.secret = secret;
    }
}
