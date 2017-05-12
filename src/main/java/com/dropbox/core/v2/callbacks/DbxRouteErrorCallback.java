package com.dropbox.core.v2.callbacks;

/**
 * Interface for route error callback.
 */
public abstract class DbxRouteErrorCallback<T> implements Runnable {
    private T routeError = null;

    public T getRouteError() {
        return routeError;
    }

    public void setRouteError(T routeError) {
        this.routeError = routeError;
    }
}
