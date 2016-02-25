package com.dropbox.core.v2;

import com.dropbox.core.BadResponseException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWebAuth;
import com.dropbox.core.NetworkIOException;
import com.dropbox.core.RetryException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*>>> import checkers.nullness.quals.NonNull; */
/*>>> import checkers.nullness.quals.Nullable; */
/*>>> import checkers.nullness.quals.MonotonicNonNull; */
/*>>> import checkers.initialization.quals.Initialized; */

/**
 * Use this class to make remote calls to the Dropbox API.  You'll need an access token first,
 * normally acquired via {@link DbxWebAuth}.
 *
 * <p>
 * This class has no mutable state, so it's thread safe as long as you pass in a thread safe
 * {@link HttpRequestor} implementation.
 * </p>
 */
public class DbxRawClientV2 {
    private static final JsonFactory JSON_FACTORY = new JsonFactory();
    // The HTTP status codes returned for errors specific to particular API calls.
    private final static List<Integer> FUNCTION_SPECIFIC_ERROR_CODES = Arrays.asList(403, 404, 409);
    private static final String USER_AGENT_ID = "OfficialDropboxJavaSDKv2";
    private static final ObjectMapper JSON = JsonUtil.getMapper();

    private final DbxRequestConfig requestConfig;
    private final String accessToken;
    private final DbxHost host;

    /**
     * The same as {@link #DbxRawClientV2(DbxRequestConfig, String)} except you can also set the
     * hostnames of the Dropbox API servers.  This is used in testing.  You don't normally need
     * to call this.
     */
    public DbxRawClientV2(DbxRequestConfig requestConfig, String accessToken, DbxHost host) {
        if (requestConfig == null) throw new NullPointerException("requestConfig");
        if (accessToken == null) throw new NullPointerException("accessToken");
        if (host == null) throw new NullPointerException("host");

        this.requestConfig = requestConfig;
        this.accessToken = accessToken;
        this.host = host;
    }

    /**
     * @param accessToken The OAuth 2 access token (that you got from Dropbox) that gives your app the ability
     *                    to make Dropbox API calls against some particular user's account.  The standard way
     *                    to get one of these is to use {@link DbxWebAuth} to send your user through Dropbox's
     *                    OAuth 2 authorization flow.
     */
    public DbxRawClientV2(DbxRequestConfig requestConfig, String accessToken) {
        this(requestConfig, accessToken, DbxHost.DEFAULT);
    }

    // package-private
    DbxRawClientV2(DbxRawClientV2 copy) {
        this.requestConfig = copy.requestConfig;
        this.accessToken = copy.accessToken;
        this.host = copy.host;
    }

    protected void addAuthHeaders(List<HttpRequestor.Header> headers) {
        DbxRequestUtil.addAuthHeader(headers, accessToken);
    }

    public <ArgT,ResT,ErrT> ResT rpcStyle(final String host,
                                          final String path,
                                          final ArgT arg,
                                          final boolean noAuth,
                                          final JavaType responseType,
                                          final JavaType errorType)
        throws DbxRequestUtil.ErrorWrapper, DbxException {

        final byte [] body = writeAsBytes(arg);
        final List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        if (!noAuth) {
            addAuthHeaders(headers);
        }
        headers.add(new HttpRequestor.Header("Content-Type", "application/json; charset=utf-8"));

        return executeRetriable(requestConfig.getMaxRetries(), new RetriableExecution<ResT> () {
            @Override
            public ResT execute() throws DbxRequestUtil.ErrorWrapper, DbxException {
                HttpRequestor.Response response = DbxRequestUtil.startPostRaw(requestConfig, USER_AGENT_ID, host, path, body, headers);
                try {
                    if (response.getStatusCode() == 200) {
                        return JSON.readValue(response.getBody(), responseType);
                    } else if (FUNCTION_SPECIFIC_ERROR_CODES.contains(response.getStatusCode())) {
                        throw DbxRequestUtil.ErrorWrapper.fromResponse(errorType, response);
                    } else {
                        throw DbxRequestUtil.unexpectedStatus(response);
                    }
                } catch (JsonProcessingException ex) {
                    String requestId = DbxRequestUtil.getRequestId(response);
                    throw new BadResponseException(requestId, "Bad JSON: " + ex.getMessage(), ex);
                } catch (IOException ex) {
                    throw new NetworkIOException(ex);
                }
            }
        });
    }

    public <ArgT,ResT,ErrT> DbxDownloader<ResT> downloadStyle(final String host,
                                                              final String path,
                                                              final ArgT arg,
                                                              final boolean noAuth,
                                                              final JavaType responseType,
                                                              final JavaType errorType)
        throws DbxRequestUtil.ErrorWrapper, DbxException {

        final List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        if (!noAuth) {
            addAuthHeaders(headers);
        }
        headers.add(new HttpRequestor.Header("Dropbox-API-Arg", headerSafeJson(arg)));
        headers.add(new HttpRequestor.Header("Content-Type", ""));

        final byte[] body = new byte[0];

        return executeRetriable(requestConfig.getMaxRetries(), new RetriableExecution<DbxDownloader<ResT>>() {
            @Override
            public DbxDownloader<ResT> execute() throws DbxRequestUtil.ErrorWrapper, DbxException {
                HttpRequestor.Response response = DbxRequestUtil.startPostRaw(requestConfig, USER_AGENT_ID, host, path, body, headers);
                String requestId = DbxRequestUtil.getRequestId(response);

                try {
                    if (response.getStatusCode() == 200) {
                        List<String> resultHeaders = response.getHeaders().get("dropbox-api-result");
                        if (resultHeaders == null) {
                            throw new BadResponseException(requestId, "Missing Dropbox-API-Result header; " + response.getHeaders());
                        }
                        if (resultHeaders.size() == 0) {
                            throw new BadResponseException(requestId, "No Dropbox-API-Result header; " + response.getHeaders());
                        }
                        String resultHeader = resultHeaders.get(0);
                        if (resultHeader == null) {
                            throw new BadResponseException(requestId, "Null Dropbox-API-Result header; " + response.getHeaders());
                        }

                        ResT result = JSON.readValue(resultHeader, responseType);
                        return new DbxDownloader<ResT>(result, response.getBody());
                    } else if (FUNCTION_SPECIFIC_ERROR_CODES.contains(response.getStatusCode())) {
                        throw DbxRequestUtil.ErrorWrapper.fromResponse(errorType, response);
                    } else {
                        throw DbxRequestUtil.unexpectedStatus(response);
                    }
                } catch(JsonProcessingException ex) {
                    throw new BadResponseException(requestId, "Bad JSON: " + ex.getMessage(), ex);
                } catch (IOException ex) {
                    throw new NetworkIOException(ex);
                }
            }
        });
    }

    private static <T> byte [] writeAsBytes(T arg) throws DbxException {
        try {
            return JSON.writeValueAsBytes(arg);
        } catch (JsonProcessingException ex) {
            // should never happen
            throw LangUtil.mkAssert("Failed to serialize argument", ex);
        } catch (IOException ex) {
            throw new NetworkIOException(ex);
        }
    }

    private static <T> String headerSafeJson(T value) {
        StringWriter out = new StringWriter();
        try {
            JsonGenerator g = JSON.getFactory().createGenerator(out);
            // Escape 0x7F, because it's not allowed in an HTTP header.
            // Escape all non-ASCII because the new HTTP spec recommends against non-ASCII in headers.
            g.setHighestNonEscapedChar(0x7E);
            JSON.writeValue(g, value);
            g.flush();
        } catch (IOException ex) {
            throw LangUtil.mkAssert("Impossible", ex);
        }
        return out.toString();
    }

    public <ArgT> HttpRequestor.Uploader uploadStyle(String host, String path, ArgT arg, boolean noAuth)
        throws DbxException {

        String uri = DbxRequestUtil.buildUri(host, path);
        List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        if (!noAuth) {
            addAuthHeaders(headers);
        }
        headers.add(new HttpRequestor.Header("Content-Type", "application/octet-stream"));
        headers = DbxRequestUtil.addUserAgentHeader(headers, requestConfig, USER_AGENT_ID);
        headers.add(new HttpRequestor.Header("Dropbox-API-Arg", headerSafeJson(arg)));
        try {
            return requestConfig.getHttpRequestor().startPost(uri, headers);
        }
        catch (IOException ex) {
            throw new NetworkIOException(ex);
        }
    }

    /**
     * Returns the {@code DbxRequestConfig} that was passed in to the constructor.
     *
     * @return configuration to use for issuing requests.
     */
    public DbxRequestConfig getRequestConfig() {
        return requestConfig;
    }

    /**
     * Returns the {@code DbxAccessToken} that was passed in to the constructor.
     *
     * @return OAuth2 access token used for request authorization.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Returns the {@code DbxHost} that was passed in to the constructor.
     *
     * @return Dropbox hosts to use for requests.
     */
    public DbxHost getHost() {
        return host;
    }

    /**
     * Retries the execution at most a maximum number of times.
     *
     * <p> This method is an alternative implementation to {@code DbxRequestUtil.runAndRetry(..)}
     * that does <b>not</b> retry 500 errors ({@link com.dropbox.core.ServerException}). To maintain
     * behavior backwards compatibility in v1, we leave the old implementation in {@code
     * DbxRequestUtil} unchanged.
     */
    private static <T> T executeRetriable(int maxRetries, RetriableExecution<T> execution) throws DbxRequestUtil.ErrorWrapper, DbxException {
        if (maxRetries == 0) {
            return execution.execute();
        }

        int retries = 0;
        while (true) {
            try {
                return execution.execute();
            } catch (RetryException ex) {
                if (retries < maxRetries) {
                    ++retries;
                    sleepQuietly(ex.getBackoffMillis());
                } else {
                    throw ex;
                }
            }
        }
    }

    private static void sleepQuietly(long millis) {
        if (millis <= 0) {
            return;
        }

        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
            // preserve interrupt
            Thread.currentThread().interrupt();
        }
    }

    private interface RetriableExecution<T> {
        T execute() throws DbxRequestUtil.ErrorWrapper, DbxException;
    }
}
