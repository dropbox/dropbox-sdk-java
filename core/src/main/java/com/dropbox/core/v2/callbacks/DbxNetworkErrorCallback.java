package com.dropbox.core.v2.callbacks;

import com.dropbox.core.DbxException;

import javax.annotation.Nonnull;

/**
 * Abstract class for network error callback.
 */
public abstract class DbxNetworkErrorCallback {
    public abstract void onNetworkError(@Nonnull DbxException networkError);
}
