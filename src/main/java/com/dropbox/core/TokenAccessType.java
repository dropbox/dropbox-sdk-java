package com.dropbox.core;

public enum TokenAccessType{
    ONLINE("online"),
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
