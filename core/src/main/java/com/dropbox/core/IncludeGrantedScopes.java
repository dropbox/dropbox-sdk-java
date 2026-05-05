package com.dropbox.core;

import javax.annotation.Nonnull;

/**
 *  If this field is present, Dropbox server will return a token with all scopes user previously
 *  granted your app.
 *  Non-mobile apps use it in {@link DbxWebAuth}.
 *  Mobile apps use it in {@link com.dropbox.core.android.Auth}
 */
public enum IncludeGrantedScopes {
    /**
     * Use it in user flow.
     */
    USER,
    /**
     * Use it in team flow.
     */
    TEAM;

    @Override
    public @Nonnull String toString() {
        return this.name().toLowerCase();
    }
}
