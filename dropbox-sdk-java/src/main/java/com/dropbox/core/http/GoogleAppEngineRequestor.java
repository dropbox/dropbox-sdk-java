package com.dropbox.core.http;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.google.appengine.api.urlfetch.FetchOptions;
import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * {@link HttpRequestor} implementation that uses Google App Engine URL fetch service.
 * You can only use this if your project includes the App Engine libraries.
 *
 * <p> If your app runs in Google App Engine, it is strongly recommended to use this Requestor to
 * ensure certificate validation is performed on all requests.
 *
 * <p> To use this, pass an instance to the {@link com.dropbox.core.DbxRequestConfig} constructor:
 *
 * <pre>
 *     DbxRequestConfig config = DbxRequestConfig.newBuilder("MyAppEngineApp/1.0")
 *         .withHttpRequestor(new GoogleAppEngineRequestor())
 *         .build();
 *
 *     String accessToken = ...;
 *     DbxClientV2 client = new DbxClientV2(config, accessToken);
 * </pre>
 */
public class GoogleAppEngineRequestor extends HttpRequestor {
    private final URLFetchService service;
    private final FetchOptions options;

    public GoogleAppEngineRequestor() {
        this(newDefaultOptions());
    }

    public GoogleAppEngineRequestor(FetchOptions options) {
        this(options, URLFetchServiceFactory.getURLFetchService());
    }

    public GoogleAppEngineRequestor(FetchOptions options, URLFetchService service) {
        if (options == null) throw new NullPointerException("options");
        if (service == null) throw new NullPointerException("service");
        this.options = options;
        this.service = service;
    }

    public FetchOptions getOptions() {
        return options;
    }

    public URLFetchService getService() {
        return service;
    }

    @Override
    public Response doGet(String url, Iterable<Header> headers) throws IOException {
        HTTPRequest request = newRequest(url, HTTPMethod.GET, headers);
        HTTPResponse response = service.fetch(request);
        return toRequestorResponse(response);
    }

    @Override
    public Uploader startPost(String url, Iterable<Header> headers) throws IOException {
        HTTPRequest request = newRequest(url, HTTPMethod.POST, headers);
        return new FetchServiceUploader(service, request, new ByteArrayOutputStream());
    }

    @Override
    public Uploader startPut(String url, Iterable<Header> headers) throws IOException {
        HTTPRequest request = newRequest(url, HTTPMethod.POST, headers);
        return new FetchServiceUploader(service, request, new ByteArrayOutputStream());
    }

    private HTTPRequest newRequest(String url, HTTPMethod method, Iterable<Header> headers) throws IOException {
        HTTPRequest request = new HTTPRequest(new URL(url), method, options);
        for (Header header : headers) {
            request.addHeader(new HTTPHeader(header.getKey(), header.getValue()));
        }
        return request;
    }

    /**
     * Returns a new instance of the default {@link FetchOptions} used by this requestor. This
     * method exists primarily since {@link FetchOptions} provides no copy methods.
     *
     * @return new instance of default fetch options used by this requestor.
     */
    public static FetchOptions newDefaultOptions() {
        return FetchOptions.Builder.withDefaults()
            .validateCertificate()
            .doNotFollowRedirects()
            .disallowTruncate()
            // seconds
            .setDeadline((DEFAULT_CONNECT_TIMEOUT_MILLIS + DEFAULT_READ_TIMEOUT_MILLIS)/1000.0);
    }

    private static Response toRequestorResponse(HTTPResponse response) {
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        for (HTTPHeader header : response.getHeadersUncombined()) {
            List<String> existing = headers.get(header.getName());
            if (existing == null) {
                existing = new ArrayList<String>();
                headers.put(header.getName(), existing);
            }
            existing.add(header.getValue());
        }

        return new Response(response.getResponseCode(),
                            new ByteArrayInputStream(response.getContent()),
                            headers);
    }

    private static class FetchServiceUploader extends Uploader {
        private final URLFetchService service;
        private final ByteArrayOutputStream body;

        private HTTPRequest request;

        public FetchServiceUploader(URLFetchService service, HTTPRequest request, ByteArrayOutputStream body) {
            this.service = service;
            this.request = request;
            this.body = body;
        }

        @Override
        public OutputStream getBody() {
            return body;
        }

        @Override
        public void close() {
            if (request != null) {
                try {
                    body.close();
                } catch (IOException ex) {
                    // impossible
                }
                request = null;
            }
        }

        /**
         * Equivalent to calling {@link #close}. This upload does not provide a streaming API.
         */
        @Override
        public void abort() {
            if (request == null) {
                throw new IllegalStateException("Uploader already closed.");
            }
            close();
        }

        @Override
        public Response finish() throws IOException {
            if (request == null) {
                throw new IllegalStateException("Uploader already closed.");
            }
            request.setPayload(body.toByteArray());
            HTTPResponse response = service.fetch(request);
            Response requestorResponse = toRequestorResponse(response);
            close();
            if (progressListener != null) {
                progressListener.onProgress(request.getPayload().length);
            }
            return requestorResponse;
        }
    }
}
