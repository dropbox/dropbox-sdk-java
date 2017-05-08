# Global Handlers Example

This repo contains an advanced use-case example (global route error and network error response callbacks).

Client can supply a callback factory, which allows for consistent, global handling of route-specific error types, as well as general network errors.

Normally, error handling is done on a request-by-request basis. However, it is convenient to handle some error behavior consistently, regardless of the request or the endpoint.

For implementing global error handling for general networking errors like an auth error, `getNetworkErrorCallback` should be implemented. For implementing global error handling for route-specific errors, one of the `getRouteErrorCallback` should be implemented.

To run this example, please replace `"<ACCESS TOKEN>"` in `Main.java` with your access token. See the online tutorial for more details on how to generate an access token.
