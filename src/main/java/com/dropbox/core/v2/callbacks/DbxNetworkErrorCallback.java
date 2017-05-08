package com.dropbox.core.v2.callbacks;

import com.dropbox.core.DbxException;

/**
 * Abstract class for network error callback.
 */
public abstract class DbxNetworkErrorCallback implements Runnable {
    private DbxException networkError = null;

    public DbxException getNetworkError() {
        return networkError;
    }

    public void setNetworkError(DbxException networkError) {
        this.networkError = networkError;
    }
}
