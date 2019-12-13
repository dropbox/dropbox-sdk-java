package com.dropbox.core.v2;

import static com.dropbox.core.DbxRequestUtil.addUserLocaleHeader;
import static com.dropbox.core.DbxRequestUtil.addPathRootHeader;

import com.dropbox.core.BadResponseException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxWebAuth;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.InvalidAccessTokenException;
import com.dropbox.core.NetworkIOException;
import com.dropbox.core.RetryException;
import com.dropbox.core.oauth.DbxOAuthError;
import com.dropbox.core.oauth.DbxOAuthException;
import com.dropbox.core.oauth.DbxRefreshResult;
import com.dropbox.core.stone.StoneSerializer;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.auth.AuthError;
import com.dropbox.core.v2.common.PathRoot;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
public abstract class DbxRawClientV2 {
    public static final String USER_AGENT_ID = "OfficialDropboxJavaSDKv2";

    private static final JsonFactory JSON = new JsonFactory();
    private static final Random RAND = new Random();

    private final DbxRequestConfig requestConfig;
    private final DbxHost host;

    /* for multiple Dropbox account use-case */
    private final String userId;

    private final PathRoot pathRoot;

    /**
     * @param requestConfig Configuration controlling How requests should be issued to Dropbox
     * servers.
     * @param host Dropbox server hostnames (primarily for internal use)
     * @param userId The user ID of the current Dropbox account. Used for multi-Dropbox account use-case.
     * @param pathRoot We will send this value in Dropbox-API-Path-Root header if it presents.
     */
    protected DbxRawClientV2(DbxRequestConfig requestConfig, DbxHost host, String userId, PathRoot pathRoot) {
        if (requestConfig == null) throw new NullPointerException("requestConfig");
        if (host == null) throw new NullPointerException("host");

        this.requestConfig = requestConfig;
        this.host = host;
        this.userId = userId;
        this.pathRoot = pathRoot;
    }

    /**
     * Add the appropriate authentication headers to the request, if any.
     *
     * @param headers List of request headers. Add authentication headers to this list.
     */
    protected abstract void addAuthHeaders(List<HttpRequestor.Header> headers);

    public abstract DbxRefreshResult refreshAccessToken() throws DbxException;

    abstract boolean canRefreshAccessToken();

    abstract boolean needsRefreshAccessToken();

    private void refreshAccessTokenIfNeeded() throws DbxException {
        if (needsRefreshAccessToken()) {
            try {
                refreshAccessToken();
            } catch (DbxOAuthException e) {
                if (!DbxOAuthError.INVALID_GRANT.equals(e.getDbxOAuthError().getError())) {
                    throw e;
                }
            }
        }
    }

    /**
     * Clone a new DbxRawClientV2 with Dropbox-API-Path-Root header.
     *
     * @param pathRoot {@code pathRoot} object containing the content for Dropbox-API-Path-Root header.
     */
    protected abstract DbxRawClientV2 withPathRoot(PathRoot pathRoot);

    public <ArgT,ResT,ErrT> ResT rpcStyle(final String host,
                                          final String path,
                                          final ArgT arg,
                                          final boolean noAuth,
                                          final StoneSerializer<ArgT> argSerializer,
                                          final StoneSerializer<ResT> responseSerializer,
                                          final StoneSerializer<ErrT> errorSerializer)
        throws DbxWrappedException, DbxException {

        final byte [] body = writeAsBytes(argSerializer, arg);
        final List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        if (!noAuth) {
            refreshAccessTokenIfNeeded();
        }
        if (!this.host.getNotify().equals(host)) {
            // TODO(krieb): fix this ugliness
            addUserLocaleHeader(headers, requestConfig);
            addPathRootHeader(headers, this.pathRoot);
        }

        headers.add(new HttpRequestor.Header("Content-Type", "application/json; charset=utf-8"));

        return executeRetriableWithRefresh(requestConfig.getMaxRetries(), new RetriableExecution<ResT> () {
            private String userIdAnon;

            @Override
            public ResT execute() throws DbxWrappedException, DbxException {
                if (!noAuth) {
                    addAuthHeaders(headers);
                }

                HttpRequestor.Response response = DbxRequestUtil.startPostRaw(requestConfig, USER_AGENT_ID, host, path, body, headers);
                try {
                    switch (response.getStatusCode()) {
                        case 200:
                            return responseSerializer.deserialize(response.getBody());
                        case 409:
                            throw DbxWrappedException.fromResponse(errorSerializer, response, userIdAnon);
                        default:
                            throw DbxRequestUtil.unexpectedStatus(response, userIdAnon);
                    }
                } catch (JsonProcessingException ex) {
                    String requestId = DbxRequestUtil.getRequestId(response);
                    throw new BadResponseException(requestId, "Bad JSON: " + ex.getMessage(), ex);
                } catch (IOException ex) {
                    throw new NetworkIOException(ex);
                }
            }

            private RetriableExecution<ResT> init(String userId){
                this.userIdAnon = userId;
                return this;
            }
        }.init(this.userId));
    }

    public <ArgT,ResT,ErrT> DbxDownloader<ResT> downloadStyle(final String host,
                                                              final String path,
                                                              final ArgT arg,
                                                              final boolean noAuth,
                                                              final List<HttpRequestor.Header> extraHeaders,
                                                              final StoneSerializer<ArgT> argSerializer,
                                                              final StoneSerializer<ResT> responseSerializer,
                                                              final StoneSerializer<ErrT> errorSerializer)
        throws DbxWrappedException, DbxException {

        final List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>(extraHeaders);
        if (!noAuth) {
            refreshAccessTokenIfNeeded();
        }
        addUserLocaleHeader(headers, requestConfig);
        addPathRootHeader(headers, this.pathRoot);
        headers.add(new HttpRequestor.Header("Dropbox-API-Arg", headerSafeJson(argSerializer, arg)));
        headers.add(new HttpRequestor.Header("Content-Type", ""));

        final byte[] body = new byte[0];

        return executeRetriableWithRefresh(requestConfig.getMaxRetries(), new RetriableExecution<DbxDownloader<ResT>>() {
            private String userIdAnon;

            @Override
            public DbxDownloader<ResT> execute() throws DbxWrappedException, DbxException {
                if (!noAuth) {
                    addAuthHeaders(headers);
                }
                HttpRequestor.Response response = DbxRequestUtil.startPostRaw(requestConfig, USER_AGENT_ID, host, path, body, headers);
                String requestId = DbxRequestUtil.getRequestId(response);
                String contentType = DbxRequestUtil.getContentType(response);

                try {
                    switch (response.getStatusCode()) {
                        case 200:
                            // fall-through
                        case 206:
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

                            ResT result = responseSerializer.deserialize(resultHeader);
                            return new DbxDownloader<ResT>(result, response.getBody(), contentType);
                        case 409:
                            throw DbxWrappedException.fromResponse(errorSerializer, response, userIdAnon);
                        default:
                            throw DbxRequestUtil.unexpectedStatus(response, userIdAnon);
                    }
                } catch(JsonProcessingException ex) {
                    throw new BadResponseException(requestId, "Bad JSON: " + ex.getMessage(), ex);
                } catch (IOException ex) {
                    throw new NetworkIOException(ex);
                }
            }

            private RetriableExecution<DbxDownloader<ResT>> init(String userId){
                this.userIdAnon = userId;
                return this;
            }
        }.init(this.userId));
    }

    private static <T> byte [] writeAsBytes(StoneSerializer<T> serializer, T arg) throws DbxException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            serializer.serialize(arg, out);
        } catch (IOException ex) {
            throw LangUtil.mkAssert("Impossible", ex);
        }
        return out.toByteArray();
    }

    private static <T> String headerSafeJson(StoneSerializer<T> serializer, T value) {
        StringWriter out = new StringWriter();
        try {
            JsonGenerator g = JSON.createGenerator(out);
            // Escape 0x7F, because it's not allowed in an HTTP header.
            // Escape all non-ASCII because the new HTTP spec recommends against non-ASCII in headers.
            g.setHighestNonEscapedChar(0x7E);
            serializer.serialize(value, g);
            g.flush();
        } catch (IOException ex) {
            throw LangUtil.mkAssert("Impossible", ex);
        }
        return out.toString();
    }

    public <ArgT> HttpRequestor.Uploader uploadStyle(String host,
                                                     String path,
                                                     ArgT arg,
                                                     boolean noAuth,
                                                     StoneSerializer<ArgT> argSerializer)
        throws DbxException {

        String uri = DbxRequestUtil.buildUri(host, path);
        List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        if (!noAuth) {
            refreshAccessTokenIfNeeded();
            addAuthHeaders(headers);
        }
        addUserLocaleHeader(headers, requestConfig);
        addPathRootHeader(headers, this.pathRoot);
        headers.add(new HttpRequestor.Header("Content-Type", "application/octet-stream"));
        headers = DbxRequestUtil.addUserAgentHeader(headers, requestConfig, USER_AGENT_ID);
        headers.add(new HttpRequestor.Header("Dropbox-API-Arg", headerSafeJson(argSerializer, arg)));
        try {
            return requestConfig.getHttpRequestor().startPostInStreamingMode(uri, headers);
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
     * Returns the {@code DbxHost} that was passed in to the constructor.
     *
     * @return Dropbox hosts to use for requests.
     */
    public DbxHost getHost() {
        return host;
    }

    /**
     * Returns the {@code userId} that was passed in to the constructor.
     *
     * @return The user ID of the current Dropbox account.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Retries the execution at most a maximum number of times.
     *
     * <p> This method is an alternative implementation to {@code DbxRequestUtil.runAndRetry(..)}
     * that does <b>not</b> retry 500 errors ({@link com.dropbox.core.ServerException}). To maintain
     * behavior backwards compatibility in v1, we leave the old implementation in {@code
     * DbxRequestUtil} unchanged.
     */
    private static <T> T executeRetriable(int maxRetries, RetriableExecution<T> execution) throws DbxWrappedException, DbxException {
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
                    sleepQuietlyWithJitter(ex.getBackoffMillis());
                } else {
                    throw ex;
                }
            }
        }
    }

    private <T> T executeRetriableWithRefresh(int maxRetries, RetriableExecution<T>
        execution) throws DbxWrappedException, DbxException {
        try {
            return executeRetriable(maxRetries, execution);
        } catch (InvalidAccessTokenException ex) {
            if (ex.getMessage() == null) {
                // Java built-in URLConnection would terminate 401 response before receiving body
                // in streaming mode. Give up.
                throw ex;
            }

            AuthError authError = ex.getAuthError();

            if (AuthError.EXPIRED_ACCESS_TOKEN.equals(authError) && canRefreshAccessToken()) {
                // retry with new access token.
                refreshAccessToken();
                return executeRetriable(maxRetries, execution);
            } else {
                // Doesn't need refresh.
                throw ex;
            }
        }

    }

    private static void sleepQuietlyWithJitter(long millis) {
        // add a small jitter to the sleep to avoid stampeding herd problem, especially when millis
        // is 0.
        long jitter = RAND.nextInt(1000);
        long sleepMillis = millis + jitter;

        if (sleepMillis <= 0) {
            return;
        }

        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException ex) {
            // preserve interrupt
            Thread.currentThread().interrupt();
        }
    }

    private interface RetriableExecution<T> {
        T execute() throws DbxWrappedException, DbxException;
    }
}
