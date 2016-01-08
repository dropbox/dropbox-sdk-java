package com.dropbox.core.v2;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxUploader;
import com.dropbox.core.DbxWebAuth;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.util.LangUtil;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

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
    private final DbxRequestConfig requestConfig;
    private final String accessToken;
    private final DbxHost host;

    /**
     * @param accessToken The OAuth 2 access token (that you got from Dropbox) that gives your app the ability
     *                    to make Dropbox API calls against some particular user's account.  The standard way
     *                    to get one of these is to use {@link DbxWebAuth} to send your user through Dropbox's
     *                    OAuth 2 authorization flow.
     */
    public DbxRawClientV2(DbxRequestConfig requestConfig, String accessToken) {
        this(requestConfig, accessToken, DbxHost.Default);
    }

    /**
     * The same as {@link #DbxRawClientV2(DbxRequestConfig, String)} except you can also set the
     * hostnames of the Dropbox API servers.  This is used in testing.  You don't normally need
     * to call this.
     */
    public DbxRawClientV2(DbxRequestConfig requestConfig, String accessToken, DbxHost host) {
        if (requestConfig == null) throw new IllegalArgumentException("'requestConfig' is null");
        if (accessToken == null) throw new IllegalArgumentException("'accessToken' is null");
        if (host == null) throw new IllegalArgumentException("'host' is null");

        this.requestConfig = requestConfig;
        this.accessToken = accessToken;
        this.host = host;
    }

    // The HTTP status codes returned for errors specific to particular API calls.
    private final static List<Integer> functionSpecificErrorCodes = Arrays.asList(403, 404, 409);

    public static <ArgT,ResT,ErrT> ResT rpcStyle(DbxRequestConfig requestConfig, String accessToken,
                                                 String host, String path, ArgT arg,
                                                 JsonWriter<ArgT> argWriter,
                                                 JsonReader<ResT> resReader,
                                                 JsonReader<ErrT> errReader)
            throws DbxRequestUtil.ErrorWrapper, DbxException
    {
        HttpRequestor.Response response;
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            if (argWriter != null) {
                argWriter.writeToStream(arg, out);
            } else {
                out.write("null".getBytes("UTF-8"));
            }
            byte[] body = out.toByteArray();
            ArrayList<HttpRequestor.Header> headers = DbxRequestUtil.addAuthHeader(null, accessToken);
            headers.add(new HttpRequestor.Header("Content-Type", "application/json; charset=utf-8"));
            response = DbxRequestUtil.startPostRaw(requestConfig, host, path, body, headers);
            try {
                if (response.statusCode == 200) {
                    return resReader.readFully(response.body);
                } else if (functionSpecificErrorCodes.contains(response.statusCode)) {
                    throw DbxRequestUtil.ErrorWrapper.fromResponse(errReader, response);
                } else {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
            }
            catch(JsonReadException ex) {
                String requestId = DbxRequestUtil.getRequestId(response);
                throw new DbxException.BadResponse(requestId, "Bad JSON: " + ex.getMessage(), ex);
            }
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
    }

    public static <ArgT,ResT,ErrT> DbxDownloader<ResT> downloadStyle(
            DbxRequestConfig requestConfig, String accessToken,
            String host, String path, ArgT arg,
            JsonWriter<ArgT> argWriter,
            JsonReader<ResT> resReader,
            JsonReader<ErrT>errReader)
            throws DbxRequestUtil.ErrorWrapper, DbxException
    {
        HttpRequestor.Response response;
        try {
            ArrayList<HttpRequestor.Header> headers = DbxRequestUtil.addAuthHeader(null, accessToken);
            headers.add(new HttpRequestor.Header("Dropbox-API-Arg", headerSafeJson(arg, argWriter)));
            headers.add(new HttpRequestor.Header("Content-Type", ""));
            byte[] body = new byte[0];
            response = DbxRequestUtil.startPostRaw(requestConfig, host, path, body, headers);
            String requestId = DbxRequestUtil.getRequestId(response);

            try {
                if (response.statusCode == 200) {
                    List<String> resultHeaders = response.headers.get("dropbox-api-result");
                    if (resultHeaders == null) {
                        throw new DbxException.BadResponse(requestId, "Missing Dropbox-API-Result header; " + response.headers);
                    }
                    if (resultHeaders.size() == 0) {
                        throw new DbxException.BadResponse(requestId, "No Dropbox-API-Result header; " + response.headers);
                    }
                    String resultHeader = resultHeaders.get(0);
                    if (resultHeader == null) {
                        throw new DbxException.BadResponse(requestId, "Null Dropbox-API-Result header; " + response.headers);
                    }

                    ResT result = resReader.readFully(resultHeader);
                    return new DbxDownloader<ResT>(result, response.body);
                } else if (functionSpecificErrorCodes.contains(response.statusCode)) {
                    throw DbxRequestUtil.ErrorWrapper.fromResponse(errReader, response);
                } else {
                    throw DbxRequestUtil.unexpectedStatus(response);
                }
            }
            catch(JsonReadException ex) {
                throw new DbxException.BadResponse(requestId, "Bad JSON: " + ex.getMessage(), ex);
            }
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
    }

    private static final JsonFactory jsonFactory = new JsonFactory();

    private static <T> String headerSafeJson(T value, JsonWriter<T> writer)
    {
        if (writer == null) {
            assert value == null : value;
            return "null";
        }
        StringWriter out = new StringWriter();
        try {
            JsonGenerator g = jsonFactory.createGenerator(out);
            // Escape 0x7F, because it's not allowed in an HTTP header.
            // Escape all non-ASCII because the new HTTP spec recommends against non-ASCII in headers.
            g.setHighestNonEscapedChar(0x7E);
            writer.write(value, g);
            g.flush();
        }
        catch (IOException ex) {
            throw LangUtil.mkAssert("Impossible", ex);
        }
        return out.toString();
    }

    public static <ArgT,ResT,ErrT,X extends Throwable> DbxUploader<ResT,ErrT,X> uploadStyle(
            DbxRequestConfig requestConfig, String accessToken,
            String host, String path, ArgT arg,
            JsonWriter<ArgT>argWriter,
            DbxUploader.UploaderMaker<ResT,ErrT,X> uploaderMaker)
            throws DbxException
    {
        String uri = DbxRequestUtil.buildUri(host, path);
        ArrayList<HttpRequestor.Header> headers = DbxRequestUtil.addAuthHeader(null, accessToken);
        headers.add(new HttpRequestor.Header("Content-Type", "application/octet-stream"));
        headers = DbxRequestUtil.addUserAgentHeader(headers, requestConfig);
        headers.add(new HttpRequestor.Header("Dropbox-API-Arg", headerSafeJson(arg, argWriter)));
        try {
            HttpRequestor.Uploader httpUploader = requestConfig.httpRequestor.startPost(uri, headers);
            return uploaderMaker.makeUploader(httpUploader);
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
    }

    /**
     * Returns the {@code DbxRequestConfig} that was passed in to the constructor.
     */
    public DbxRequestConfig getRequestConfig() {
        return requestConfig;
    }

    /**
     * Returns the {@code DbxAccessToken} that was passed in to the constructor.
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * Returns the {@code DbxHost} that was passed in to the constructor.
     */
    public DbxHost getHost() {
        return host;
    }


}
