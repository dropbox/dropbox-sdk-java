package com.dropbox.core.v2.callbacks;

/**
 * Client should implement methods in this class to allow for consistent, global handling of route-specific error types,
 * as well as general network errors. Normally, error handling is done on a request-by-request basis.
 * However, it is convenient to handle some error behavior consistently, regardless of the request or the endpoint.
 * For implementing global error handling for general networking errors like an auth error, `createNetworkErrorCallback`
 * should be implemented. For implementing global error handling for route-specific errors, the
 * `createRouteErrorCallback` should be implemented.
 */
public interface DbxGlobalCallbackFactory {
    // Should instantiate separate callback object on each method invocation
    <T> DbxRouteErrorCallback<T> createRouteErrorCallback(String userId, T routeError);

    // Should instantiate separate callback object on each method invocation
    DbxNetworkErrorCallback createNetworkErrorCallback(String userId);
}
