package com.dropbox.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.util.StringUtil;

public class DbxRequestUtil
{
    public static String encodeUrlParam(String s)
    {
        try {
            return URLEncoder.encode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            AssertionError ae = new AssertionError("UTF-8 not supported?  Should never happen, right?");
            ae.initCause(ex);
            throw ae;
        }
    }

    public static String buildUrlWithParams(String userLocale, String host, String path, String[] params)
    {
        return buildUri(host, path) + "?" + encodeUrlParams(userLocale, params);
    }

    public static String buildUri(String host, String path)
    {
        try {
            return new URI("https", host, "/" + path, null).toURL().toExternalForm();
        }
        catch (MalformedURLException ex) {
            AssertionError ae = new AssertionError();
            ae.initCause(ex);
            throw ae;
        }
        catch (URISyntaxException ex) {
            AssertionError ae = new AssertionError();
            ae.initCause(ex);
            throw ae;
        }
    }

    private static String encodeUrlParams(String userLocale, String[] params)
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
                String key = params[i++];
                String value = params[i++];
                if (value != null) {
                    buf.append(sep); sep = "&";
                    buf.append(encodeUrlParam(key));
                    buf.append("=");
                    buf.append(encodeUrlParam(value));
                }
            }
        }

        return buf.toString();
    }

    private static ArrayList<HttpRequestor.Header> addAuthHeader(ArrayList<HttpRequestor.Header> headers, String accessToken)
    {
        if (headers == null) headers = new ArrayList<HttpRequestor.Header>();
        headers.add(new HttpRequestor.Header("Authorization", "Bearer " + accessToken));
        return headers;
    }

    public static ArrayList<HttpRequestor.Header> addUserAgentHeader(ArrayList<HttpRequestor.Header> headers, DbxRequestConfig requestConfig)
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
    public static HttpRequestor.Response startGet(DbxRequestConfig requestConfig, String accessToken, String host, String path, String[] params, ArrayList<HttpRequestor.Header> headers)
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
    public static HttpRequestor.Uploader startPut(DbxRequestConfig requestConfig, String accessToken, String host, String path, String[] params, ArrayList<HttpRequestor.Header> headers)
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
    public static HttpRequestor.Response startPostNoAuth(DbxRequestConfig requestConfig, String host, String path, String[] params, ArrayList<HttpRequestor.Header> headers)
        throws DbxException.NetworkIO
    {
        String uri = buildUri(host, path);
        byte[] encodedParams = StringUtil.stringToUtf8(encodeUrlParams(requestConfig.userLocale, params));

        headers = addUserAgentHeader(headers, requestConfig);
        headers.add(new HttpRequestor.Header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));
        headers.add(new HttpRequestor.Header("Content-Length", Integer.toString(encodedParams.length)));

        try {
            HttpRequestor.Uploader uploader = requestConfig.httpRequestor.startPost(uri, headers);
            try {
                uploader.body.write(encodedParams);
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

    public static Map<String,String> parseAsQueryString(InputStream in)
        throws DbxException
    {
        // TODO: Maybe just slurp string up to a max limit.
        Scanner scanner = new Scanner(in).useDelimiter("&");
        Map<String,String> result = new HashMap<String,String>();
        while (scanner.hasNext()) {
            String pair = scanner.next();

            // The 'Scanner' class masks any IOExceptions that happen on '.next()', so we
            // have to check for them explicitly.
            IOException ioe = scanner.ioException();
            if (ioe != null) {
                throw new DbxException.NetworkIO(ioe);
            }

            String[] parts = pair.split("=");
            if (parts.length < 2) {
                throw new DbxException.BadResponse("expecting a name-value pair, but there's no '=': \"" + pair + "\"");
            }
            else if (parts.length > 2) {
                throw new DbxException.BadResponse("expecting a single name-value pair, but there's more than one '=': \"" + pair + "\"");
            }
            String displaced = result.put(parts[0], parts[1]);
            if (displaced != null) {
                throw new DbxException.BadResponse("duplicate query parameter name: \"" + parts[0] + "\"");
            }
        }
        return result;
    }

    public static <T> T doGet(DbxRequestConfig requestConfig, String accessToken, String host, String path, String[] params, ArrayList<HttpRequestor.Header> headers, ResponseHandler<T> handler)
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

    public static <T> T doPost(DbxRequestConfig requestConfig, String accessToken, String host, String path, String[] params, ArrayList<HttpRequestor.Header> headers, ResponseHandler<T> handler)
            throws DbxException
    {
        headers = addAuthHeader(headers, accessToken);
        return doPostNoAuth(requestConfig, host, path, params, headers, handler);
    }

    public static <T> T doPostNoAuth(DbxRequestConfig requestConfig, String host, String path, String[] params, ArrayList<HttpRequestor.Header> headers, ResponseHandler<T> handler)
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

    public static String getFirstHeaderMaybe(HttpRequestor.Response response, String name)
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
