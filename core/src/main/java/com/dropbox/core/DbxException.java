package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * The base exception thrown by Dropbox API calls.  Normally, you'll need to do something specific
 * for {@link InvalidAccessTokenException} and possibly for {@link RetryException}.  The rest you
 * should probably just log and investigate manually.
 */
public class DbxException extends Exception {
    private static final long serialVersionUID = 0L;

    private final String requestId;
    private Integer responseStatusCode;
    private Map<String, List<String>> responseHeaders = Collections.emptyMap();

    public DbxException(String message) {
        this(null, message);
    }

    public DbxException(String requestId, String message) {
        super(message);
        this.requestId = requestId;
    }

    public DbxException(String message, Throwable cause) {
        this(null, message, cause);
    }

    public DbxException(String requestId, String message, Throwable cause) {
        super(message, cause);
        this.requestId = requestId;
    }

    /**
     * Returns the HTTP response status, or {@code null} when no response is available.
     *
     * @return HTTP status code, or {@code null}
     */
    @Nullable
    public Integer getResponseStatusCode() {
        return responseStatusCode;
    }

    /**
     * Returns a deeply immutable snapshot of the response headers. Lookup is case-insensitive
     * and all values are preserved. The snapshot remains available after the response is closed.
     *
     * @return response headers, or an empty map when no response is available
     */
    public Map<String, List<String>> getResponseHeaders() {
        // Also handles exceptions deserialized from older SDK versions.
        return responseHeaders == null ? Collections.<String, List<String>>emptyMap() : responseHeaders;
    }

    void setResponseMetadata(HttpRequestor.Response response) {
        responseStatusCode = response.getStatusCode();
        responseHeaders = response.getHeaders();
    }

    void setResponseMetadata(Integer statusCode, Map<String, List<String>> headers) {
        responseStatusCode = statusCode;
        responseHeaders = headers;
    }

    /**
     * Return the unique ID associated with the request that triggered this exception.
     *
     * <p> The ID may be {@code null} if we could not receive a response from the Dropbox servers
     * (e.g. from a {@link NetworkIOException}).
     *
     * <p> Please use this ID when filing bug reports.
     *
     * @return unique ID associated with the request that caused this exception, or {@code null} if
     * one is not available.
     */
    public String getRequestId() {
        return requestId;
    }
}
