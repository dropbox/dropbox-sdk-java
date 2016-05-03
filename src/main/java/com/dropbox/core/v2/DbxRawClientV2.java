package com.dropbox.core.v2;

import com.dropbox.core.BadResponseException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWebAuth;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.NetworkIOException;
import com.dropbox.core.RetryException;
import com.dropbox.core.babel.BabelSerializer;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.LangUtil;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;

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
public abstract class DbxRawClientV2 {
    // The HTTP status codes returned for errors specific to particular API calls.
    private static final List<Integer> FUNCTION_SPECIFIC_ERROR_CODES = Arrays.asList(403, 404, 409);
    private static final String USER_AGENT_ID = "OfficialDropboxJavaSDKv2";
    private static final JsonFactory JSON = new JsonFactory();

    private final DbxRequestConfig requestConfig;
    private final DbxHost host;

    /**
     * @param requestConfig Configuration controlling How requests should be issued to Dropbox
     * servers.
     * @param host Dropbox server hostnames (primarily for internal use)
     */
    protected DbxRawClientV2(DbxRequestConfig requestConfig, DbxHost host) {
        if (requestConfig == null) throw new NullPointerException("requestConfig");
        if (host == null) throw new NullPointerException("host");

        this.requestConfig = requestConfig;
        this.host = host;
    }

    /**
     * Add the appropriate authentication headers to the request, if any.
     *
     * @param headers List of request headers. Add authentication headers to this list.
     */
    protected abstract void addAuthHeaders(List<HttpRequestor.Header> headers);

    public <ArgT,ResT,ErrT> ResT rpcStyle(final String host,
                                          final String path,
                                          final ArgT arg,
                                          final boolean noAuth,
                                          final BabelSerializer<ArgT> argSerializer,
                                          final BabelSerializer<ResT> responseSerializer,
                                          final BabelSerializer<ErrT> errorSerializer)
        throws DbxWrappedException, DbxException {

        final byte [] body = writeAsBytes(argSerializer, arg);
        final List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        if (!noAuth) {
            addAuthHeaders(headers);
        }
        headers.add(new HttpRequestor.Header("Content-Type", "application/json; charset=utf-8"));

        return executeRetriable(requestConfig.getMaxRetries(), new RetriableExecution<ResT> () {
            @Override
            public ResT execute() throws DbxWrappedException, DbxException {
                HttpRequestor.Response response = DbxRequestUtil.startPostRaw(requestConfig, USER_AGENT_ID, host, path, body, headers);
                try {
                    if (response.getStatusCode() == 200) {
                        return responseSerializer.deserialize(response.getBody());
                    } else if (FUNCTION_SPECIFIC_ERROR_CODES.contains(response.getStatusCode())) {
                        throw DbxWrappedException.fromResponse(errorSerializer, response);
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
                                                              final List<HttpRequestor.Header> extraHeaders,
                                                              final BabelSerializer<ArgT> argSerializer,
                                                              final BabelSerializer<ResT> responseSerializer,
                                                              final BabelSerializer<ErrT> errorSerializer)
        throws DbxWrappedException, DbxException {

        final List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>(extraHeaders);
        if (!noAuth) {
            addAuthHeaders(headers);
        }
        headers.add(new HttpRequestor.Header("Dropbox-API-Arg", headerSafeJson(argSerializer, arg)));
        headers.add(new HttpRequestor.Header("Content-Type", ""));

        final byte[] body = new byte[0];

        return executeRetriable(requestConfig.getMaxRetries(), new RetriableExecution<DbxDownloader<ResT>>() {
            @Override
            public DbxDownloader<ResT> execute() throws DbxWrappedException, DbxException {
                HttpRequestor.Response response = DbxRequestUtil.startPostRaw(requestConfig, USER_AGENT_ID, host, path, body, headers);
                String requestId = DbxRequestUtil.getRequestId(response);

                try {
                    if (response.getStatusCode() == 200 || response.getStatusCode() == 206) {
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
                        return new DbxDownloader<ResT>(result, response.getBody());
                    } else if (FUNCTION_SPECIFIC_ERROR_CODES.contains(response.getStatusCode())) {
                        throw DbxWrappedException.fromResponse(errorSerializer, response);
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

    private static <T> byte [] writeAsBytes(BabelSerializer<T> serializer, T arg) throws DbxException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            serializer.serialize(arg, out);
        } catch (IOException ex) {
            throw LangUtil.mkAssert("Impossible", ex);
        }
        return out.toByteArray();
    }

    private static <T> String headerSafeJson(BabelSerializer<T> serializer, T value) {
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
                                                     BabelSerializer<ArgT> argSerializer)
        throws DbxException {

        String uri = DbxRequestUtil.buildUri(host, path);
        List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        if (!noAuth) {
            addAuthHeaders(headers);
        }
        headers.add(new HttpRequestor.Header("Content-Type", "application/octet-stream"));
        headers = DbxRequestUtil.addUserAgentHeader(headers, requestConfig, USER_AGENT_ID);
        headers.add(new HttpRequestor.Header("Dropbox-API-Arg", headerSafeJson(argSerializer, arg)));
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
        T execute() throws DbxWrappedException, DbxException;
    }
}
