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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
            HttpRequestor.Response response = DbxRequestUtil.startPostRaw(requestConfig, host, path, body, headers);
            if (response.statusCode == 200) {
                return resReader.readFully(response.body);
            } else if (functionSpecificErrorCodes.contains(response.statusCode)) {
                throw new DbxRequestUtil.ErrorWrapper(errReader, response.body);
            } else {
                throw DbxRequestUtil.unexpectedStatus(response);
            }
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
        catch(JsonReadException ex) {
            throw new DbxException.BadResponse("Bad JSON: " + ex.getMessage(), ex);
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
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            argWriter.writeToStream(arg, out, false);
            String argJson = new String(out.toByteArray(), "UTF-8");
            ArrayList<HttpRequestor.Header> headers = DbxRequestUtil.addAuthHeader(null, accessToken);
            headers.add(new HttpRequestor.Header("Dropbox-API-Arg", argJson));
            headers.add(new HttpRequestor.Header("Content-Type", ""));
            byte[] body = new byte[0];
            HttpRequestor.Response response = DbxRequestUtil.startPostRaw(requestConfig, host, path, body, headers);
            if (response.statusCode == 200) {
                List<String> resultHeaders = response.headers.get("dropbox-api-result");
                if (resultHeaders == null)
                    throw new DbxException.BadResponse("Missing Dropbox-API-Result header; " + response.headers);
                if (resultHeaders.size() == 0)
                    throw new DbxException.BadResponse("No Dropbox-API-Result header; " + response.headers);
                String resultHeader = resultHeaders.get(0);
                if (resultHeader == null)
                    throw new DbxException.BadResponse("Null Dropbox-API-Result header; " + response.headers);
                ResT result = resReader.readFully(resultHeader);
                return new DbxDownloader<ResT>(result, response.body);
            } else if (functionSpecificErrorCodes.contains(response.statusCode)) {
                throw new DbxRequestUtil.ErrorWrapper(errReader, response.body);
            } else {
                throw DbxRequestUtil.unexpectedStatus(response);
            }
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
        catch(JsonReadException ex) {
            throw new DbxException.BadResponse("Bad JSON: " + ex.getMessage(), ex);
        }
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
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            if (arg != null) {
                argWriter.writeToStream(arg, out, false);
            }
            else {
                out.write("null".getBytes("UTF-8"));
            }
        } catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
        String argJson = out.toString();
        headers.add(new HttpRequestor.Header("Dropbox-API-Arg", argJson));
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