package com.dropbox.core;

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
    USER("user"),
    /**
     * Use it in team flow.
     */
    TEAM("team");

    private String string;

    IncludeGrantedScopes(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
