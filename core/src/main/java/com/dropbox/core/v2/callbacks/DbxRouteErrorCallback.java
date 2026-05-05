package com.dropbox.core.v2.callbacks;

import javax.annotation.Nullable;

/**
 * Interface for route error callback.
 */
public abstract class DbxRouteErrorCallback<T> implements Runnable {
    private @Nullable T routeError = null;

    public @Nullable T getRouteError() {
        return routeError;
    }

    public void setRouteError(@Nullable T routeError) {
        this.routeError = routeError;
    }
}
