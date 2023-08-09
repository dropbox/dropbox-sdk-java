package com.dropbox.core;

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

    private String string;

    TokenAccessType(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
