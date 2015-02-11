package com.dropbox.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.List;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.StringUtil;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import static com.dropbox.core.util.StringUtil.jq;
import static com.dropbox.core.util.LangUtil.mkAssert;

/*>>> import checkers.nullness.quals.Nullable; */

public class DbxRequestUtil
{
    public static String encodeUrlParam(String s)
    {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            throw mkAssert("UTF-8 should always be supported", ex);
        }
    }

    public static String buildUrlWithParams(/*@Nullable*/String userLocale, String host, String path,
                                            /*@Nullable*/String/*@Nullable*/[] params)
    {
        return buildUri(host, path) + "?" + encodeUrlParams(userLocale, params);
    }

    public static String buildUri(String host, String path)
    {
        try {
            return new URI("https", host, "/" + path, null).toASCIIString();
        }
        catch (URISyntaxException ex) {
            throw mkAssert("URI creation failed, host=" + jq(host) + ", path=" + jq(path), ex);
        }
    }

    private static String encodeUrlParams(/*@Nullable*/String userLocale,
                                          /*@Nullable*/String/*@Nullable*/[] params)
    {
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

    private static ArrayList<HttpRequestor.Header> addAuthHeader(/*@Nullable*/ArrayList<HttpRequestor.Header> headers,
                                                                 String accessToken)
    {
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();
        headers.add(new HttpRequestor.Header("Authorization", "Bearer " + accessToken));
        return headers;
    }

    public static ArrayList<HttpRequestor.Header> addUserAgentHeader(/*@Nullable*/ArrayList<HttpRequestor.Header> headers,
                                                                     DbxRequestConfig requestConfig)
    {
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();
        headers.add(buildUserAgentHeader(requestConfig));
        return headers;
    }

    public static HttpRequestor.Header buildUserAgentHeader(DbxRequestConfig requestConfig)
    {
        return new HttpRequestor.Header("User-Agent", requestConfig.clientIdentifier + " Dropbox-Java-SDK/" + DbxSdkVersion.Version);
    }

    /**
     * Convenience function for making HTTP GET requests.
     */
    public static HttpRequestor.Response startGet(DbxRequestConfig requestConfig, String accessToken, String host, String path,
                                                  /*@Nullable*/String/*@Nullable*/[] params,
                                                  /*@Nullable*/ArrayList<HttpRequestor.Header> headers)
        throws DbxException.NetworkIO
    {
        headers = addUserAgentHeader(headers, requestConfig);
        headers = addAuthHeader(headers, accessToken);

        String url = buildUrlWithParams(requestConfig.userLocale, host, path, params);
        try {
            return requestConfig.httpRequestor.doGet(url, headers);
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
    }

    /**
     * Convenience function for making HTTP PUT requests.
     */
    public static HttpRequestor.Uploader startPut(DbxRequestConfig requestConfig, String accessToken,
                                                  String host, String path,
                                                  /*@Nullable*/String/*@Nullable*/[] params,
                                                  /*@Nullable*/ArrayList<HttpRequestor.Header> headers)
        throws DbxException.NetworkIO
    {
        headers = addUserAgentHeader(headers, requestConfig);
        headers = addAuthHeader(headers, accessToken);

        String url = buildUrlWithParams(requestConfig.userLocale, host, path, params);
        try {
            return requestConfig.httpRequestor.startPut(url, headers);
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
    }

    /**
     * Convenience function for making HTTP POST requests.
     */
    public static HttpRequestor.Response startPostNoAuth(DbxRequestConfig requestConfig, String host,
                                                         String path,
                                                         /*@Nullable*/String/*@Nullable*/[] params,
                                                         /*@Nullable*/ArrayList<HttpRequestor.Header> headers)
        throws DbxException.NetworkIO
    {
        byte[] encodedParams = StringUtil.stringToUtf8(encodeUrlParams(requestConfig.userLocale, params));

        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();
        headers.add(new HttpRequestor.Header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));

        return startPostRaw(requestConfig, host, path, encodedParams, headers);
    }

    /**
     * Convenience function for making HTTP POST requests.  Like startPostNoAuth but takes byte[] instead of params.
     */
    public static HttpRequestor.Response startPostRaw(DbxRequestConfig requestConfig, String host,
                                                      String path,
                                                      byte[] body,
                                                      /*@Nullable*/ArrayList<HttpRequestor.Header> headers)
        throws DbxException.NetworkIO
    {
        String uri = buildUri(host, path);

        headers = addUserAgentHeader(headers, requestConfig);
        headers.add(new HttpRequestor.Header("Content-Length", Integer.toString(body.length)));

        try {
            HttpRequestor.Uploader uploader = requestConfig.httpRequestor.startPost(uri, headers);
            try {
                uploader.body.write(body);
                return uploader.finish();
            }
            finally {
                uploader.close();
            }
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
    }

    // XXX This duplicates JsonReader.jsonFactory. Maybe make that public, or move this code there?
    static final JsonFactory jsonFactory = new JsonFactory();

    public static class ErrorWrapper extends Throwable {
        public java.lang.Object errValue;  // Really an ErrT instance, but Throwable does not allow generic subclasses.

        public ErrorWrapper(JsonReader reader, InputStream body)
                throws IOException, JsonReadException
        {
            errValue = null;
            JsonParser parser = jsonFactory.createParser(body);
            parser.nextToken();
            reader.expectObjectStart(parser);
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if (fieldName == "reason") {
                    errValue = reader.read(parser);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
        }
    }

    public static abstract class RouteSpecificErrorMaker<T extends Throwable>
    {
        public abstract T makeError(DbxRequestUtil.ErrorWrapper ew);
    }

    public static <ArgT,ResT,ErrT> ResT rpcStyle(DbxRequestConfig requestConfig, String accessToken,
                                                 String host, String path, ArgT arg,
                                                 JsonWriter<ArgT> argWriter,
                                                 JsonReader<ResT> resReader,
                                                 JsonReader<ErrT> errReader)
            throws ErrorWrapper, DbxException
    {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            if (argWriter != null) {
                argWriter.writeToStream(arg, out);
            } else {
                out.write("null".getBytes("UTF-8"));
            }
            byte[] body = out.toByteArray();
            ArrayList<HttpRequestor.Header> headers = addAuthHeader(null, accessToken);
            headers.add(new HttpRequestor.Header("Content-Type", "application/json; charset=utf-8"));
            HttpRequestor.Response response = startPostRaw(requestConfig, host, path, body, headers);
            if (response.statusCode == 200) {
                return resReader.readFully(response.body);
            } else if (response.statusCode == 409) {
                throw new ErrorWrapper(errReader, response.body);
            } else {
                throw unexpectedStatus(response);
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
            throws ErrorWrapper, DbxException
    {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            argWriter.writeToStream(arg, out, false);
            String argJson = new String(out.toByteArray(), "UTF-8");
            ArrayList<HttpRequestor.Header> headers = addAuthHeader(null, accessToken);
            headers.add(new HttpRequestor.Header("Dropbox-API-Arg", argJson));
            headers.add(new HttpRequestor.Header("Content-Type", ""));
            byte[] body = new byte[0];
            HttpRequestor.Response response = startPostRaw(requestConfig, host, path, body, headers);
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
            } else if (response.statusCode == 409 || response.statusCode == 404) {
                throw new ErrorWrapper(errReader, response.body);
            } else {
                throw unexpectedStatus(response);
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
        String uri = buildUri(host, path);
        ArrayList<HttpRequestor.Header> headers = addAuthHeader(null, accessToken);
        headers.add(new HttpRequestor.Header("Content-Type", "application/octet-stream"));
        headers = addUserAgentHeader(headers, requestConfig);
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

    public static byte[] loadErrorBody(HttpRequestor.Response response)
        throws DbxException.NetworkIO
    {
        // Slurp the body into memory (up to 4k; anything past that is probably not useful).
        try {
            return IOUtil.slurp(response.body, 4096);
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }

    }

    public static String parseErrorBody(int statusCode, byte[] body)
        throws DbxException.BadResponse
    {
        // Read the error message from the body.
        // TODO: Get charset from the HTTP Content-Type header.  It's wrong to just assume UTF-8.
        // TODO: Maybe try parsing the message as JSON and do something more structured?
        try {
            return StringUtil.utf8ToString(body);
        } catch (CharacterCodingException e) {
            throw new DbxException.BadResponse("Got non-UTF8 response body: " + statusCode + ": " + e.getMessage());
        }
    }

    public static DbxException unexpectedStatus(HttpRequestor.Response response)
        throws DbxException.NetworkIO, DbxException.BadResponse
    {
        byte[] body = loadErrorBody(response);
        String message = parseErrorBody(response.statusCode, body);

        if (response.statusCode == 400) return new DbxException.BadRequest(message);
        if (response.statusCode == 401) return new DbxException.InvalidAccessToken(message);
        if (response.statusCode == 500) return new DbxException.ServerError(message);
        if (response.statusCode == 503) return new DbxException.RetryLater(message);

        return new DbxException.BadResponseCode("unexpected HTTP status code: " + response.statusCode + ": " + message, response.statusCode);
    }

    public static <T> T readJsonFromResponse(JsonReader<T> reader, InputStream body)
        throws DbxException.BadResponse, DbxException.NetworkIO
    {
        try {
            return reader.readFully(body);
        }
        catch (JsonReadException ex) {
            throw new DbxException.BadResponse("error in response JSON: " + ex.getMessage(), ex);
        }
        catch (IOException ex) {
            throw new DbxException.NetworkIO(ex);
        }
    }

    public static abstract class ResponseHandler<T>
    {
        public abstract T handle(HttpRequestor.Response response) throws DbxException;
    }

    public static <T> T doGet(DbxRequestConfig requestConfig, String accessToken, String host, String path,
                             /*@Nullable*/String/*@Nullable*/[] params,
                             /*@Nullable*/ArrayList<HttpRequestor.Header> headers,
                             ResponseHandler<T> handler)
        throws DbxException
    {
        HttpRequestor.Response response = startGet(requestConfig, accessToken, host, path, params, headers);
        try {
            return handler.handle(response);
        }
        finally {
            try {
                response.body.close();
            }
            catch (IOException ex) {
                //noinspection ThrowFromFinallyBlock
                throw new DbxException.NetworkIO(ex);
            }
        }
    }

    public static <T> T doPost(DbxRequestConfig requestConfig, String accessToken, String host, String path,
                               /*@Nullable*/String/*@Nullable*/[] params,
                               /*@Nullable*/ArrayList<HttpRequestor.Header> headers,
                               ResponseHandler<T> handler)
            throws DbxException
    {
        headers = addAuthHeader(headers, accessToken);
        return doPostNoAuth(requestConfig, host, path, params, headers, handler);
    }

    public static <T> T doPostNoAuth(DbxRequestConfig requestConfig, String host, String path,
                                     /*@Nullable*/String/*@Nullable*/[] params,
                                     /*@Nullable*/ArrayList<HttpRequestor.Header> headers,
                                     ResponseHandler<T> handler)
        throws DbxException
    {
        HttpRequestor.Response response = startPostNoAuth(requestConfig, host, path, params, headers);
        return finishResponse(response, handler);
    }

    public static <T> T finishResponse(HttpRequestor.Response response, ResponseHandler<T> handler)
        throws DbxException
    {
        try {
            return handler.handle(response);
        }
        finally {
            IOUtil.closeInput(response.body);
        }
    }

    public static String getFirstHeader(HttpRequestor.Response response, String name)
        throws DbxException
    {
        List<String> values = response.headers.get(name);
        if (values == null) {
            throw new DbxException.BadResponse("missing HTTP header \"" + name + "\"");
        }
        assert !values.isEmpty();
        return values.get(0);
    }

    public static /*@Nullable*/String getFirstHeaderMaybe(HttpRequestor.Response response, String name)
        throws DbxException
    {
        List<String> values = response.headers.get(name);
        if (values == null) return null;
        assert !values.isEmpty();
        return values.get(0);
    }

    public static abstract class RequestMaker<T, E extends Throwable>
    {
        public abstract T run() throws DbxException, E;
    }

    public static <T, E extends Throwable> T runAndRetry(int maxTries, RequestMaker<T,E> requestMaker)
        throws DbxException, E
    {
        int numTries = 0;
        while (true) {
            try {
                numTries++;
                return requestMaker.run();
            }
            catch (DbxException ex) {
                // If we can't retry, just let this exception through.
                if (!isRetriableException(ex) || numTries >= maxTries) throw ex;
                // Otherwise, run through the loop again.
            }
        }
    }

    private static boolean isRetriableException(DbxException ex)
    {
        return ex instanceof DbxException.RetryLater || ex instanceof DbxException.ServerError;
    }
}
