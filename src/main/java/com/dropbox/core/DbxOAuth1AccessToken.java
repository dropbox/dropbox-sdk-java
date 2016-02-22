package com.dropbox.core;

/**
 * Use with {@link DbxOAuth1Upgrader} to convert old OAuth 1 access tokens
 * to OAuth 2 access tokens.  This SDK doesn't support using OAuth 1 access
 * tokens for regular API calls.
 */
public final class DbxOAuth1AccessToken {
    private final String key;
    private final String secret;

    /**
     * @param key OAuth 1 access token key
     * @param secret OAuth 2 access token secret
     */
    public DbxOAuth1AccessToken(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }

    /**
     * Returns the OAuth 1 access token key.
     *
     * @return OAuth 1 access token key
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the OAuth 1 access token secret.
     *
     * @return OAuth 1 access token secret
     */
    public String getSecret() {
        return secret;
    }
}
