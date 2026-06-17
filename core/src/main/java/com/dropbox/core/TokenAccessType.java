package com.dropbox.core;

import javax.annotation.Nonnull;

/**
 *  Whether or not to include refresh token in {@link DbxAuthFinish}
 *  Non-mobile apps use it in {@link DbxWebAuth}.
 *  Mobile apps use it in {@link com.dropbox.core.android.Auth}
 */
public enum TokenAccessType{
    /**
     * Auth result only contains short live token.
     */
    ONLINE("online"),
    /**
     * auth result includes both short live token.
     */
    OFFLINE("offline");

    private @Nonnull String string;

    TokenAccessType(@Nonnull String string) {
        this.string = string;
    }

    @Override
    public @Nonnull String toString() {
        return string;
    }
}
