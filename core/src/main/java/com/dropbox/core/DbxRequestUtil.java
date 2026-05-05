package com.dropbox.core;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.CharacterCodingException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.dropbox.core.stone.StoneSerializer;
import com.dropbox.core.v2.auth.AuthError;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.StringUtil;
import com.dropbox.core.v2.auth.AccessError;
import com.dropbox.core.v2.callbacks.DbxGlobalCallbackFactory;
import com.dropbox.core.v2.callbacks.DbxNetworkErrorCallback;
import com.dropbox.core.v2.common.PathRoot;
import com.dropbox.core.v2.common.PathRootError;
import com.dropbox.core.v2.common.PathRootError.Serializer;

import static com.dropbox.core.util.StringUtil.jq;
import static com.dropbox.core.util.LangUtil.mkAssert;


public final class DbxRequestUtil {
    private static final Random RAND = new Random();

    public static @Nullable DbxGlobalCallbackFactory sharedCallbackFactory;

    public static @Nonnull String encodeUrlParam(@Nonnull String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw mkAssert("UTF-8 should always be supported", ex);
        }
    }

    public static @Nonnull String buildUrlWithParams(@Nullable String userLocale,
                                            @Nonnull String host,
                                            @Nonnull String path,
                                            @Nullable String[] params) {
        return buildUri(host, path) + "?" + encodeUrlParams(userLocale, params);
    }

    public static @Nonnull String [] toParamsArray(@Nonnull Map<String, String> params) {
        String [] arr = new String[2 * params.size()];
        int i = 0;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            arr[i] = entry.getKey();
            arr[i + 1] = entry.getValue();
            i += 2;
        }
        return arr;
    }

    public static @Nonnull String buildUri(@Nonnull String host, @Nonnull String path) {
        try {
            return new URI("https", host, "/" + path, null).toASCIIString();
        }
        catch (URISyntaxException ex) {
            throw mkAssert("URI creation failed, host=" + jq(host) + ", path=" + jq(path), ex);
        }
    }

    private static @Nonnull String encodeUrlParams(@Nullable String userLocale,
                                          @Nullable String[] params) {
        StringBuilder buf = new StringBuilder();
        String sep = "";
        if (userLocale != null) {
            buf.append("locale=").append(encodeUrlParam(userLocale));
            sep = "&";
        }

        if (params != null) {
            if (params.length % 2 != 0) {
                throw new IllegalArgumentException("'params.length' is " + params.length + "; expecting a multiple of two");
            }
            for (int i = 0; i < params.length; ) {
                String key = params[i];
                String value = params[i+1];
                if (key == null) throw new IllegalArgumentException("params[" + i + "] is null");
                if (value != null) {
                    buf.append(sep); sep = "&";
                    buf.append(encodeUrlParam(key));
                    buf.append("=");
                    buf.append(encodeUrlParam(value));
                }
                i += 2;
            }
        }

        return buf.toString();
    }

    public static @Nonnull List<HttpRequestor.Header> addAuthHeader(@Nullable List<HttpRequestor.Header> headers,
                                                                    @Nonnull String accessToken) {
        if (accessToken == null) throw new NullPointerException("accessToken");
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();

        headers.add(new HttpRequestor.Header("Authorization", "Bearer " + accessToken));
        return headers;
    }

    public static @Nonnull List<HttpRequestor.Header> addSelectUserHeader(@Nullable List<HttpRequestor.Header> headers,
                                                                          @Nonnull String memberId) {
        if (memberId == null) throw new NullPointerException("memberId");
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();

        headers.add(new HttpRequestor.Header("Dropbox-API-Select-User", memberId));
        return headers;
    }

    public static @Nonnull List<HttpRequestor.Header> addSelectAdminHeader(@Nullable List<HttpRequestor.Header> headers,
                                                                           @Nonnull String adminId) {
        if (adminId == null) throw new NullPointerException("adminId");
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();

        headers.add(new HttpRequestor.Header("Dropbox-API-Select-Admin", adminId));
        return headers;
    }

    public static @Nonnull List<HttpRequestor.Header> addBasicAuthHeader(@Nullable List<HttpRequestor.Header> headers,
                                                                         @Nonnull String username,
                                                                         @Nonnull String password) {
        if (username == null) throw new NullPointerException("username");
        if (password == null) throw new NullPointerException("password");
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();

        String credentials = username + ":" + password;
        String base64Credentials = StringUtil.base64Encode(StringUtil.stringToUtf8(credentials));
        headers.add(new HttpRequestor.Header("Authorization", "Basic " + base64Credentials));
        return headers;
    }

    public static @Nonnull List<HttpRequestor.Header> addUserAgentHeader(
        @Nullable List<HttpRequestor.Header> headers,
        @Nonnull DbxRequestConfig requestConfig,
        @Nonnull String sdkUserAgentIdentifier
    ) {
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();
        headers.add(buildUserAgentHeader(requestConfig, sdkUserAgentIdentifier));
        return headers;
    }

    public static @Nullable List<HttpRequestor.Header> addUserLocaleHeader(@Nullable List<HttpRequestor.Header> headers,
                                                                           @Nonnull DbxRequestConfig requestConfig) {
        if (requestConfig.getUserLocale() == null) {
            return headers;
        }

        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();
        headers.add(new HttpRequestor.Header("Dropbox-API-User-Locale", requestConfig.getUserLocale()));
        return headers;
    }

    public static @Nonnull HttpRequestor.Header buildUserAgentHeader(@Nonnull DbxRequestConfig requestConfig,
                                                                     @Nonnull String sdkUserAgentIdentifier) {
        return new HttpRequestor.Header("User-Agent",  requestConfig.getClientIdentifier() + " " + sdkUserAgentIdentifier + "/" + DbxSdkVersion.Version);
    }

    public static @Nullable List<HttpRequestor.Header> addPathRootHeader(@Nullable List<HttpRequestor.Header> headers,
                                                                         @Nullable PathRoot pathRoot) {
        if (pathRoot == null) {
            return headers;
        }

        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();
        headers.add(new HttpRequestor.Header("Dropbox-API-Path-Root",  pathRoot.toString()));
        return headers;
    }

    public static @Nonnull List<HttpRequestor.Header> removeAuthHeader(@Nullable List<HttpRequestor.Header> headers) {
        if (headers == null) {
            return new ArrayList<HttpRequestor.Header>();
        }

        List<HttpRequestor.Header> authHeaders = new ArrayList<HttpRequestor.Header>();

        for (HttpRequestor.Header header: headers) {
            if ("Authorization".equals(header.getKey())) {
                authHeaders.add(header);
            }
        }

        headers.removeAll(authHeaders);
        return headers;
    }

    /**
     * Convenience function for making HTTP GET requests.
     */
    public static @Nonnull HttpRequestor.Response startGet(@Nonnull DbxRequestConfig requestConfig,
                                                  @Nonnull String accessToken,
                                                  @Nonnull String sdkUserAgentIdentifier,
                                                  @Nonnull String host,
                                                  @Nonnull String path,
                                                  @Nullable String[] params,
                                                  @Nullable List<HttpRequestor.Header> headers)
        throws NetworkIOException {
        headers = copyHeaders(headers);
        headers = addUserAgentHeader(headers, requestConfig, sdkUserAgentIdentifier);
        headers = addAuthHeader(headers, accessToken);

        String url = buildUrlWithParams(requestConfig.getUserLocale(), host, path, params);
        try {
            return requestConfig.getHttpRequestor().doGet(url, headers);
        }
        catch (IOException ex) {
            throw new NetworkIOException(ex);
        }
    }

    /**
     * Convenience function for making HTTP PUT requests.
     */
    public static @Nonnull HttpRequestor.Uploader startPut(@Nonnull DbxRequestConfig requestConfig,
                                                  @Nonnull String accessToken,
                                                  @Nonnull String sdkUserAgentIdentifier,
                                                  @Nonnull String host, @Nonnull String path,
                                                  @Nullable String[] params,
                                                  @Nullable List<HttpRequestor.Header> headers)
        throws NetworkIOException {
        headers = copyHeaders(headers);
        headers = addUserAgentHeader(headers, requestConfig, sdkUserAgentIdentifier);
        headers = addAuthHeader(headers, accessToken);

        String url = buildUrlWithParams(requestConfig.getUserLocale(), host, path, params);
        try {
            return requestConfig.getHttpRequestor().startPut(url, headers);
        }
        catch (IOException ex) {
            throw new NetworkIOException(ex);
        }
    }

    /**
     * Convenience function for making HTTP POST requests.
     */
    public static @Nonnull HttpRequestor.Response startPostNoAuth(@Nonnull DbxRequestConfig requestConfig,
                                                         @Nonnull String sdkUserAgentIdentifier,
                                                         @Nonnull String host,
                                                         @Nonnull String path,
                                                         @Nullable String[] params,
                                                         @Nullable List<HttpRequestor.Header> headers)
        throws NetworkIOException {
        byte[] encodedParams = StringUtil.stringToUtf8(encodeUrlParams(requestConfig.getUserLocale(), params));

        headers = copyHeaders(headers);
        headers.add(new HttpRequestor.Header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));

        return startPostRaw(requestConfig, sdkUserAgentIdentifier, host, path, encodedParams, headers);
    }


    /**
     * Convenience function for making HTTP POST requests.  Like startPostNoAuth but takes byte[] instead of params.
     */
    public static @Nonnull HttpRequestor.Response startPostRaw(@Nonnull DbxRequestConfig requestConfig,
                                                      @Nonnull String sdkUserAgentIdentifier,
                                                      @Nonnull String host,
                                                      @Nonnull String path,
                                                      @Nonnull byte[] body,
                                                      @Nullable List<HttpRequestor.Header> headers)
        throws NetworkIOException {
        String uri = buildUri(host, path);

        headers = copyHeaders(headers);
        headers = addUserAgentHeader(headers, requestConfig, sdkUserAgentIdentifier);
        headers.add(new HttpRequestor.Header("Content-Length", Integer.toString(body.length)));

        try {
            HttpRequestor.Uploader uploader = requestConfig.getHttpRequestor().startPost(uri, headers);
            try {
                uploader.upload(body);
                return uploader.finish();
            } finally {
                uploader.close();
            }
        } catch (IOException ex) {
            throw new NetworkIOException(ex);
        }
    }

    private static @Nonnull List<HttpRequestor.Header> copyHeaders(@Nullable List<HttpRequestor.Header> headers) {
        if (headers == null) {
            return new ArrayList<HttpRequestor.Header>();
        } else {
            return new ArrayList<HttpRequestor.Header>(headers);
        }
    }

    public static @Nonnull byte[] loadErrorBody(@Nonnull HttpRequestor.Response response)
        throws NetworkIOException {
        if (response.getBody() == null) {
            return new byte[0];
        }

        // Slurp the body into memory (up to 4k; anything past that is probably not useful).
        try {
            return IOUtil.slurp(response.getBody(), 4096);
        } catch (IOException ex) {
            throw new NetworkIOException(ex);
        }

    }

    public static @Nonnull String parseErrorBody(@Nullable String requestId, int statusCode, @Nonnull byte[] body)
        throws BadResponseException {
        // Read the error message from the body.
        // TODO: Get charset from the HTTP Content-Type header.  It's wrong to just assume UTF-8.
        // TODO: Maybe try parsing the message as JSON and do something more structured?
        try {
            return StringUtil.utf8ToString(body);
        } catch (CharacterCodingException e) {
            throw new BadResponseException(requestId, "Got non-UTF8 response body: " + statusCode + ": " + e.getMessage());
        }
    }

    public static @Nonnull DbxException unexpectedStatus(@Nonnull HttpRequestor.Response response) throws NetworkIOException, BadResponseException {
        return DbxRequestUtil.unexpectedStatus(response, null);
    }

    public static @Nonnull DbxException unexpectedStatus(@Nonnull HttpRequestor.Response response, @Nullable String userId)
        throws NetworkIOException, BadResponseException {

        String requestId = getRequestId(response);
        String message = null;
        DbxException networkError;

        switch (response.getStatusCode()) {
            case 400:
                message = DbxRequestUtil.messageFromResponse(response, requestId);
                networkError = new BadRequestException(requestId, message);
                break;
            case 401:
                message = DbxRequestUtil.messageFromResponse(response, requestId);
                if (message.isEmpty()) {
                    networkError = new InvalidAccessTokenException(requestId, message, AuthError.INVALID_ACCESS_TOKEN);
                } else {
                    try {
                        ApiErrorResponse<AuthError> authErrorReponse = new ApiErrorResponse
                                .Serializer<AuthError>(AuthError.Serializer.INSTANCE).deserialize(message);
                        AuthError authError = authErrorReponse.getError();
                        networkError = new InvalidAccessTokenException(requestId, message, authError);
                    } catch (JsonParseException ex) {
                        throw new BadResponseException(requestId, "Bad JSON: " + ex.getMessage(), ex);
                    }
                }
                break;
            case 403:
                try {
                    ApiErrorResponse<AccessError> accessErrorResponse = new ApiErrorResponse.Serializer<AccessError>(AccessError.Serializer.INSTANCE)
                            .deserialize(response.getBody());
                    if (accessErrorResponse.getUserMessage() != null) {
                        message = accessErrorResponse.getUserMessage().toString();
                    }
                    AccessError accessError = accessErrorResponse.getError();
                    networkError = new AccessErrorException(requestId, message, accessError);
                } catch (JsonProcessingException ex) {
                    throw new BadResponseException(requestId, "Bad JSON: " + ex.getMessage(), ex);
                } catch (IOException ex) {
                    throw new NetworkIOException(ex);
                }
                break;
            case 422:
                try {
                    ApiErrorResponse<PathRootError> pathRootErrorResponse = new ApiErrorResponse.Serializer<PathRootError>(Serializer.INSTANCE)
                            .deserialize(response.getBody());
                    if (pathRootErrorResponse.getUserMessage() != null) {
                        message = pathRootErrorResponse.getUserMessage().toString();
                    }
                    PathRootError pathRootError = pathRootErrorResponse.getError();
                    networkError = new PathRootErrorException(requestId, message, pathRootError);
                } catch (JsonProcessingException ex) {
                    throw new BadResponseException(requestId, "Bad JSON: " + ex.getMessage(), ex);
                } catch (IOException ex) {
                    throw new NetworkIOException(ex);
                }
                break;
            case 429:
                try {
                    int backoffSecs = Integer.parseInt(getFirstHeader(response, "Retry-After"));
                    networkError = new RateLimitException(requestId, message, backoffSecs, TimeUnit.SECONDS);
                    break;
                } catch (NumberFormatException ex) {
                    networkError = new BadResponseException(requestId, "Invalid value for HTTP header: \"Retry-After\"");
                    break;
                }
            case 500:
                networkError = new ServerException(requestId, message);
                break;
            case 503:
                // API v1 may include Retry-After in 503 responses, v2 does not
                String retryAfter = getFirstHeaderMaybe(response, "Retry-After");
                try {
                    if (retryAfter != null && !retryAfter.trim().isEmpty()) {
                        int backoffSecs = Integer.parseInt(retryAfter);
                        networkError = new RetryException(requestId, message, backoffSecs, TimeUnit.SECONDS);
                        break;
                    } else {
                        networkError = new RetryException(requestId, message);
                        break;
                    }
                } catch (NumberFormatException ex) {
                    networkError = new BadResponseException(requestId, "Invalid value for HTTP header: \"Retry-After\"");
                    break;
                }
            default:
                networkError = new BadResponseCodeException(
                    requestId,
                    "unexpected HTTP status code: " + response.getStatusCode() + ": " + message,
                    response.getStatusCode()
                );
        }

        DbxGlobalCallbackFactory factory = DbxRequestUtil.sharedCallbackFactory;
        if (factory != null) {
            DbxNetworkErrorCallback callback = factory.createNetworkErrorCallback(userId);
            callback.onNetworkError(networkError);
        }

        return networkError;
    }

    private static @Nonnull String messageFromResponse(@Nonnull HttpRequestor.Response response,
                                                       @Nullable String requestId) throws NetworkIOException, BadResponseException {
        byte[] body = loadErrorBody(response);
        String message = parseErrorBody(requestId, response.getStatusCode(), body);
        return message;
    }

    public static <T> @Nullable T readJsonFromResponse(@Nonnull JsonReader<T> reader,
                                                       @Nonnull HttpRequestor.Response response)
        throws BadResponseException, NetworkIOException {
        try {
            return reader.readFully(response.getBody());
        } catch (JsonReadException ex) {
            String requestId = getRequestId(response);
            throw new BadResponseException(requestId, "error in response JSON: " + ex.getMessage(), ex);
        } catch (IOException ex) {
            throw new NetworkIOException(ex);
        }
    }

    public static <T> @Nonnull T readJsonFromErrorMessage(@Nonnull StoneSerializer<T> serializer,
                                                          @Nonnull String message,
                                                          @Nullable String requestId)
        throws JsonParseException {
        ApiErrorResponse<T> errorResponse = new ApiErrorResponse.Serializer<T>(serializer).deserialize(message);
        return errorResponse.getError();
    }

    public static abstract class ResponseHandler<T> {
        public abstract @Nullable T handle(@Nonnull HttpRequestor.Response response) throws DbxException;
    }

    public static <T> @Nullable T doGet(final @Nonnull DbxRequestConfig requestConfig,
                              final @Nonnull String accessToken,
                              final @Nonnull String sdkUserAgentIdentifier,
                              final @Nonnull String host,
                              final @Nonnull String path,
                              final @Nullable String[] params,
                              final @Nullable List<HttpRequestor.Header> headers,
                              final @Nonnull ResponseHandler<T> handler)
        throws DbxException {
        return runAndRetry(requestConfig.getMaxRetries(), new RequestMaker<T, DbxException>() {
            @Override
            public @Nullable T run() throws DbxException {
                HttpRequestor.Response response = startGet(requestConfig, accessToken, sdkUserAgentIdentifier, host, path, params, headers);
                try {
                    return handler.handle(response);
                } finally {
                    IOUtil.closeInput(response.getBody());
                }
            }
        });
    }

    public static <T> @Nullable T doPost(@Nonnull DbxRequestConfig requestConfig,
                               @Nonnull String accessToken,
                               @Nonnull String sdkUserAgentIdentifier,
                               @Nonnull String host,
                               @Nonnull String path,
                               @Nullable String[] params,
                               @Nullable List<HttpRequestor.Header> headers,
                               @Nonnull ResponseHandler<T> handler)
        throws DbxException {
        headers = copyHeaders(headers);
        headers = addAuthHeader(headers, accessToken);
        return doPostNoAuth(requestConfig, sdkUserAgentIdentifier, host, path, params, headers, handler);
    }

    public static <T> @Nullable T doPostNoAuth(final @Nonnull DbxRequestConfig requestConfig,
                                     final @Nonnull String sdkUserAgentIdentifier,
                                     final @Nonnull String host,
                                     final @Nonnull String path,
                                     final @Nullable String[] params,
                                     final @Nullable List<HttpRequestor.Header> headers,
                                     final @Nonnull ResponseHandler<T> handler)
        throws DbxException {
        return runAndRetry(requestConfig.getMaxRetries(), new RequestMaker<T, DbxException>() {
            @Override
            public @Nullable T run() throws DbxException {
                HttpRequestor.Response response = startPostNoAuth(requestConfig, sdkUserAgentIdentifier, host, path, params, headers);
                return finishResponse(response, handler);
            }
        });
    }

    public static <T> @Nullable T finishResponse(@Nonnull HttpRequestor.Response response,
                                                 @Nonnull ResponseHandler<T> handler) throws DbxException {
        try {
            return handler.handle(response);
        } finally {
            if (response != null) {
                IOUtil.closeInput(response.getBody());
            }
        }
    }

    public static @Nonnull String getFirstHeader(@Nonnull HttpRequestor.Response response,
                                                 @Nonnull String name) throws BadResponseException {
        List<String> values = response.getHeaders().get(name);
        if (values == null || values.isEmpty()) {
            throw new BadResponseException(getRequestId(response), "missing HTTP header \"" + name + "\"");
        }
        return values.get(0);
    }

    public static @Nullable String getFirstHeaderMaybe(@Nonnull HttpRequestor.Response response, @Nonnull String name) {
        List<String> values = response.getHeaders().get(name);
        if (values == null || values.isEmpty()) {
            return null;
        }
        return values.get(0);
    }

    public static @Nullable String getRequestId(@Nonnull HttpRequestor.Response response) {
        return DbxRequestUtil.getFirstHeaderMaybe(response, "X-Dropbox-Request-Id");
    }

    public static @Nullable String getContentType(@Nonnull HttpRequestor.Response response) {
        return DbxRequestUtil.getFirstHeaderMaybe(response, "Content-Type");
    }

    public static abstract class RequestMaker<T, E extends Throwable> {
        public abstract @Nullable T run() throws DbxException, E;
    }

    public static <T, E extends Throwable> @Nullable T runAndRetry(int maxRetries,
                                                                   @Nonnull RequestMaker<T,E> requestMaker)
        throws DbxException, E {
        int numRetries = 0;
        while (true) {
            long backoff;
            DbxException thrown = null;
            try {
                return requestMaker.run();
            } catch (RetryException ex) {
                backoff = ex.getBackoffMillis();
                thrown = ex;
            } catch (ServerException ex) {
                backoff = 0L;
                thrown = ex;
            }

            if (numRetries >= maxRetries) {
                throw thrown;
            }

            // add a random jitter to the backoff to avoid stampeding herd. This is especially
            // useful for ServerExceptions, where backoff is 0.
            backoff += RAND.nextInt(1000);

            if (backoff > 0L) {
                try {
                    Thread.sleep(backoff);
                } catch (InterruptedException ex) {
                    // preserve interrupt
                    Thread.currentThread().interrupt();
                }
            }

            ++numRetries;
        }
    }
}
