package com.dropbox.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.CharacterCodingException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.StringUtil;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import static com.dropbox.core.util.StringUtil.jq;
import static com.dropbox.core.util.LangUtil.mkAssert;

/*>>> import checkers.nullness.quals.Nullable; */

public final class DbxRequestUtil {
    private static final ObjectMapper JSON = JsonUtil.getMapper();

    public static String encodeUrlParam(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            throw mkAssert("UTF-8 should always be supported", ex);
        }
    }

    public static String buildUrlWithParams(/*@Nullable*/String userLocale,
                                            String host,
                                            String path,
                                            /*@Nullable*/String/*@Nullable*/[] params) {
        return buildUri(host, path) + "?" + encodeUrlParams(userLocale, params);
    }

    public static String buildUri(String host, String path) {
        try {
            return new URI("https", host, "/" + path, null).toASCIIString();
        }
        catch (URISyntaxException ex) {
            throw mkAssert("URI creation failed, host=" + jq(host) + ", path=" + jq(path), ex);
        }
    }

    private static String encodeUrlParams(/*@Nullable*/String userLocale,
                                          /*@Nullable*/String/*@Nullable*/[] params) {
        StringBuilder buf = new StringBuilder();
        String sep = "";
        if (userLocale != null) {
            buf.append("locale=").append(userLocale);
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

    public static List<HttpRequestor.Header> addAuthHeader(/*@Nullable*/List<HttpRequestor.Header> headers, String accessToken) {
        if (accessToken == null) throw new NullPointerException("accessToken");
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();

        headers.add(new HttpRequestor.Header("Authorization", "Bearer " + accessToken));
        return headers;
    }

    public static List<HttpRequestor.Header> addSelectUserHeader(/*@Nullable*/List<HttpRequestor.Header> headers, String memberId) {
        if (memberId == null) throw new NullPointerException("memberId");
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();

        headers.add(new HttpRequestor.Header("Dropbox-API-Select-User", memberId));
        return headers;
    }

    public static List<HttpRequestor.Header> addBasicAuthHeader(/*@Nullable*/List<HttpRequestor.Header> headers, String username, String password) {
        if (username == null) throw new NullPointerException("username");
        if (password == null) throw new NullPointerException("password");
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();

        String credentials = username + ":" + password;
        String base64Credentials = StringUtil.base64Encode(StringUtil.stringToUtf8(credentials));
        headers.add(new HttpRequestor.Header("Authorization", "Basic " + base64Credentials));
        return headers;
    }

    public static List<HttpRequestor.Header> addUserAgentHeader(
        /*@Nullable*/List<HttpRequestor.Header> headers,
        DbxRequestConfig requestConfig,
        String sdkUserAgentIdentifier
    ) {
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();
        headers.add(buildUserAgentHeader(requestConfig, sdkUserAgentIdentifier));
        return headers;
    }

    public static HttpRequestor.Header buildUserAgentHeader(DbxRequestConfig requestConfig, String sdkUserAgentIdentifier) {
        return new HttpRequestor.Header("User-Agent",  requestConfig.getClientIdentifier() + " " + sdkUserAgentIdentifier + "/" + DbxSdkVersion.Version);
    }

    /**
     * Convenience function for making HTTP GET requests.
     */
    public static HttpRequestor.Response startGet(DbxRequestConfig requestConfig,
                                                  String accessToken,
                                                  String sdkUserAgentIdentifier,
                                                  String host,
                                                  String path,
                                                  /*@Nullable*/String/*@Nullable*/[] params,
                                                  /*@Nullable*/List<HttpRequestor.Header> headers)
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
    public static HttpRequestor.Uploader startPut(DbxRequestConfig requestConfig,
                                                  String accessToken,
                                                  String sdkUserAgentIdentifier,
                                                  String host, String path,
                                                  /*@Nullable*/String/*@Nullable*/[] params,
                                                  /*@Nullable*/List<HttpRequestor.Header> headers)
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
    public static HttpRequestor.Response startPostNoAuth(DbxRequestConfig requestConfig,
                                                         String sdkUserAgentIdentifier,
                                                         String host,
                                                         String path,
                                                         /*@Nullable*/String/*@Nullable*/[] params,
                                                         /*@Nullable*/List<HttpRequestor.Header> headers)
        throws NetworkIOException {
        byte[] encodedParams = StringUtil.stringToUtf8(encodeUrlParams(requestConfig.getUserLocale(), params));

        headers = copyHeaders(headers);
        headers.add(new HttpRequestor.Header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));

        return startPostRaw(requestConfig, sdkUserAgentIdentifier, host, path, encodedParams, headers);
    }


    /**
     * Convenience function for making HTTP POST requests.  Like startPostNoAuth but takes byte[] instead of params.
     */
    public static HttpRequestor.Response startPostRaw(DbxRequestConfig requestConfig,
                                                      String sdkUserAgentIdentifier,
                                                      String host,
                                                      String path,
                                                      byte[] body,
                                                      /*@Nullable*/List<HttpRequestor.Header> headers)
        throws NetworkIOException {
        String uri = buildUri(host, path);

        headers = copyHeaders(headers);
        headers = addUserAgentHeader(headers, requestConfig, sdkUserAgentIdentifier);
        headers.add(new HttpRequestor.Header("Content-Length", Integer.toString(body.length)));

        try {
            HttpRequestor.Uploader uploader = requestConfig.getHttpRequestor().startPost(uri, headers);
            try {
                uploader.getBody().write(body);
                return uploader.finish();
            } finally {
                uploader.close();
            }
        } catch (IOException ex) {
            throw new NetworkIOException(ex);
        }
    }

    private static List<HttpRequestor.Header> copyHeaders(List<HttpRequestor.Header> headers) {
        if (headers == null) {
            return new ArrayList<HttpRequestor.Header>();
        } else {
            return new ArrayList<HttpRequestor.Header>(headers);
        }
    }

    public static class ErrorWrapper extends Exception {
        private static final long serialVersionUID = 0L;

        private final Object errValue;  // Really an ErrT instance, but Throwable does not allow generic subclasses.
        private final String requestId;
        private final LocalizedText userMessage;

        public ErrorWrapper(Object errValue, String requestId, LocalizedText userMessage) {
            this.errValue = errValue;
            this.requestId = requestId;
            this.userMessage = userMessage;
        }

        public Object getErrorValue() {
            return errValue;
        }

        public String getRequestId() {
            return requestId;
        }

        public LocalizedText getUserMessage() {
            return userMessage;
        }

        public static ErrorWrapper fromResponse(Type errType, HttpRequestor.Response response)
            throws IOException, JsonParseException {
            String requestId = DbxRequestUtil.getRequestId(response);

            JavaType type = JSON.getTypeFactory()
                .constructParametricType(
                    ApiErrorResponse.class,
                    JSON.getTypeFactory().constructType(errType)
                );
            ApiErrorResponse<?> apiResponse = JSON.readValue(response.getBody(), type);

            return new ErrorWrapper(apiResponse.getError(), requestId, apiResponse.getUserMessage());
        }

        @JsonIgnoreProperties(ignoreUnknown=true)
        private static final class ApiErrorResponse<T> {
            private final T error;
            private LocalizedText userMessage;

            @JsonCreator
            public ApiErrorResponse(
                @JsonProperty(value="error", required=true) T error,
                @JsonProperty("user_message") LocalizedText userMessage
            ) {
                if (error == null) {
                    throw new NullPointerException("error");
                }
                this.error = error;
                this.userMessage = userMessage;
            }

            public T getError() {
                return error;
            }

            public LocalizedText getUserMessage() {
                return userMessage;
            }
        }
    }

    public static byte[] loadErrorBody(HttpRequestor.Response response)
        throws NetworkIOException {
        // Slurp the body into memory (up to 4k; anything past that is probably not useful).
        try {
            return IOUtil.slurp(response.getBody(), 4096);
        } catch (IOException ex) {
            throw new NetworkIOException(ex);
        }

    }

    public static String parseErrorBody(String requestId, int statusCode, byte[] body)
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

    public static DbxException unexpectedStatus(HttpRequestor.Response response)
        throws NetworkIOException, BadResponseException {
        String requestId = getRequestId(response);
        byte[] body = loadErrorBody(response);
        String message = parseErrorBody(requestId, response.getStatusCode(), body);

        switch (response.getStatusCode()) {
            case 400:
                return new BadRequestException(requestId, message);
            case 401:
                return new InvalidAccessTokenException(requestId, message);
            case 429:
                try {
                    int backoffSecs = Integer.parseInt(getFirstHeader(response, "Retry-After"));
                    return new RateLimitException(requestId, message, backoffSecs, TimeUnit.SECONDS);
                } catch (NumberFormatException ex) {
                    return new BadResponseException(requestId, "Invalid value for HTTP header: \"Retry-After\"");
                }
            case 500:
                return new ServerException(requestId, message);
            case 503:
                // API v1 may include Retry-After in 503 responses, v2 does not
                String retryAfter = getFirstHeaderMaybe(response, "Retry-After");
                try {
                    if (retryAfter != null && !retryAfter.trim().isEmpty()) {
                        int backoffSecs = Integer.parseInt(retryAfter);
                        return new RetryException(requestId, message, backoffSecs, TimeUnit.SECONDS);
                    } else {
                        return new RetryException(requestId, message);
                    }
                } catch (NumberFormatException ex) {
                    return new BadResponseException(requestId, "Invalid value for HTTP header: \"Retry-After\"");
                }
            default:
                return new BadResponseCodeException(
                    requestId,
                    "unexpected HTTP status code: " + response.getStatusCode() + ": " + message,
                    response.getStatusCode()
                );
        }
    }

    public static <T> T readJsonFromResponse(JsonReader<T> reader, HttpRequestor.Response response)
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

    public static abstract class ResponseHandler<T> {
        public abstract T handle(HttpRequestor.Response response) throws DbxException;
    }

    public static <T> T doGet(final DbxRequestConfig requestConfig,
                              final String accessToken,
                              final String sdkUserAgentIdentifier,
                              final String host,
                              final String path,
                              final /*@Nullable*/String/*@Nullable*/[] params,
                              final /*@Nullable*/List<HttpRequestor.Header> headers,
                              final ResponseHandler<T> handler)
        throws DbxException {
        return runAndRetry(requestConfig.getMaxRetries(), new RequestMaker<T, DbxException>() {
            @Override
            public T run() throws DbxException {
                HttpRequestor.Response response = startGet(requestConfig, accessToken, sdkUserAgentIdentifier, host, path, params, headers);
                try {
                    return handler.handle(response);
                } finally {
                    try {
                        response.getBody().close();
                    } catch (IOException ex) {
                        //noinspection ThrowFromFinallyBlock
                        throw new NetworkIOException(ex);
                    }
                }
            }
        });
    }

    public static <T> T doPost(DbxRequestConfig requestConfig,
                               String accessToken,
                               String sdkUserAgentIdentifier,
                               String host,
                               String path,
                               /*@Nullable*/String/*@Nullable*/[] params,
                               /*@Nullable*/List<HttpRequestor.Header> headers,
                               ResponseHandler<T> handler)
        throws DbxException {
        headers = copyHeaders(headers);
        headers = addAuthHeader(headers, accessToken);
        return doPostNoAuth(requestConfig, sdkUserAgentIdentifier, host, path, params, headers, handler);
    }

    public static <T> T doPostNoAuth(final DbxRequestConfig requestConfig,
                                     final String sdkUserAgentIdentifier,
                                     final String host,
                                     final String path,
                                     final /*@Nullable*/String/*@Nullable*/[] params,
                                     final /*@Nullable*/List<HttpRequestor.Header> headers,
                                     final ResponseHandler<T> handler)
        throws DbxException {
        return runAndRetry(requestConfig.getMaxRetries(), new RequestMaker<T, DbxException>() {
            @Override
            public T run() throws DbxException {
                HttpRequestor.Response response = startPostNoAuth(requestConfig, sdkUserAgentIdentifier, host, path, params, headers);
                return finishResponse(response, handler);
            }
        });
    }

    public static <T> T finishResponse(HttpRequestor.Response response, ResponseHandler<T> handler) throws DbxException {
        try {
            return handler.handle(response);
        } finally {
            IOUtil.closeInput(response.getBody());
        }
    }

    public static String getFirstHeader(HttpRequestor.Response response, String name) throws BadResponseException {
        List<String> values = response.getHeaders().get(name);
        if (values == null || values.isEmpty()) {
            throw new BadResponseException(getRequestId(response), "missing HTTP header \"" + name + "\"");
        }
        return values.get(0);
    }

    public static /*@Nullable*/String getFirstHeaderMaybe(HttpRequestor.Response response, String name) {
        List<String> values = response.getHeaders().get(name);
        if (values == null || values.isEmpty()) {
            return null;
        }
        return values.get(0);
    }

    public static /*@Nullable*/ String getRequestId(HttpRequestor.Response response) {
        return DbxRequestUtil.getFirstHeaderMaybe(response, "X-Dropbox-Request-Id");
    }

    public static abstract class RequestMaker<T, E extends Throwable> {
        public abstract T run() throws DbxException, E;
    }

    public static <T, E extends Throwable> T runAndRetry(int maxRetries, RequestMaker<T,E> requestMaker)
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
