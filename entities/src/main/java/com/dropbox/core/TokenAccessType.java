package com.dropbox.core;

/**
 *  Whether to include refresh token in {@code DbxAuthFinish}
 *  Non-mobile apps use it in {@link DbxWebAuth}.
 *  Mobile apps use it in {@code com.dropbox.core.android.Auth}
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

    private String string;

    TokenAccessType(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
