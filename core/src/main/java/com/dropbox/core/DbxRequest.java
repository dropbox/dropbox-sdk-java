package com.dropbox.core;

/**
 * A functional interface representing a request that produces a result and may throw a checked
 * exception. Similar to {@link java.util.concurrent.Callable}, but intended for use in contexts
 * where the operation represents an API request.
 *
 * @param <T> the type of result produced by this request
 */
@FunctionalInterface
public interface DbxRequest<T> {
    /**
     * Executes the request and returns the result.
     *
     * @return the result of the request
     * @throws Exception if the request fails
     */
    T call() throws Exception;
}
