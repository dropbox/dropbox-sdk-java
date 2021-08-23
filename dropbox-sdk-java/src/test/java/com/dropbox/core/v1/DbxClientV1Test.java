package com.dropbox.core.v1;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.mockito.Mockito.*;
import static com.dropbox.core.v1.DbxClientV1.Downloader;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.BadRequestException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.RetryException;
import com.dropbox.core.util.IOUtil;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.Matchers;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DbxClientV1Test {
    // default config
    private static DbxRequestConfig.Builder createRequestConfig() {
        return DbxRequestConfig.newBuilder("sdk-test");
    }

    @Test(expectedExceptions = RetryException.class)
    public void testRetryDisabled() throws DbxException, IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryDisabled()
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV1 client = new DbxClientV1(config, "fakeAccessToken");

        // 503 every time
        when(mockRequestor.doGet(anyString(), anyHeaders()))
            .thenReturn(createEmptyResponse(503));

        try {
            client.getAccountInfo();
        } finally {
            // should only have been called once since we disabled retry
            verify(mockRequestor, times(1)).doGet(anyString(), anyHeaders());
        }
    }

    @Test
    public void testRetrySuccess() throws DbxException, IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV1 client = new DbxClientV1(config, "fakeAccessToken");
        String json = "{\"reset\":true,\"entries\":[],\"cursor\":\"fakeCursor\",\"has_more\":true}";


        // 503 twice, then return result
        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createEmptyResponse(503))   // no backoff
            .thenReturn(createRateLimitResponse(1)) // backoff 1 sec
            .thenReturn(createRateLimitResponse(2)) // backoff 2 sec
            .thenReturn(createSuccessResponse(json));

        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        long start = System.currentTimeMillis();
        DbxDelta<DbxEntry> actual = client.getDelta(null);
        long end = System.currentTimeMillis();

        // no way easy way to properly test this, but request should
        // have taken AT LEAST 3 seconds due to backoff.
        assertWithMessage("duration: " + (end - start) + " millis").that((end - start) >= 3000L).isTrue();

        // should have been called 4 times: initial call + 3 retries
        verify(mockRequestor, times(4)).startPost(anyString(), anyHeaders());

        assertThat(actual.reset).isTrue();
        assertThat(actual.cursor).isEqualTo("fakeCursor");
    }

    @Test(expectedExceptions = RetryException.class)
    public void testRetryRetriesExceeded() throws DbxException, IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV1 client = new DbxClientV1(config, "fakeAccessToken");

        // 503 always and forever
        when(mockRequestor.doGet(anyString(), anyHeaders()))
            .thenReturn(createEmptyResponse(503));

        try {
            client.getAccountInfo();
        } finally {
            // should only have been called 4: initial call + max number of retries (3)
            verify(mockRequestor, times(4)).doGet(anyString(), anyHeaders());
        }
    }

    @Test(expectedExceptions = BadRequestException.class)
    public void testRetryOtherFailure() throws DbxException, IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV1 client = new DbxClientV1(config, "fakeAccessToken");

        // 503 once, then return 400
        when(mockRequestor.doGet(anyString(), anyHeaders()))
            .thenReturn(createEmptyResponse(503))
            .thenReturn(createEmptyResponse(400));

        try {
            client.getAccountInfo();
        } finally {
            // should only have been called 2 times: initial call + one retry
            verify(mockRequestor, times(2)).doGet(anyString(), anyHeaders());
        }
    }

    @Test
    public void testRetryDownload() throws DbxException, IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV1 client = new DbxClientV1(config, "fakeAccessToken");

        // load File metadata json
        InputStream in = getClass().getResourceAsStream("/file-with-photo-info.json");
        assertThat(in).isNotNull();
        String metadataJson = IOUtil.toUtf8String(in);

        byte [] expected = new byte [] { 1, 2, 3, 4 };

        // 503 once, then return 200
        when(mockRequestor.doGet(anyString(), anyHeaders()))
            .thenReturn(createEmptyResponse(503))
            .thenReturn(createDownloaderResponse(expected, "X-Dropbox-Metadata", metadataJson));

        Downloader downloader = client.startGetThumbnail(
            DbxThumbnailSize.w64h64,
            DbxThumbnailFormat.JPEG,
            "/foo/bar.jpg",
            null
        );

        // should have been attempted twice
        verify(mockRequestor, times(2)).doGet(anyString(), anyHeaders());

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        IOUtil.copyStreamToStream(downloader.body, bout);
        byte [] actual = bout.toByteArray();

        assertThat(actual).isEqualTo(expected);
        assertThat(downloader.metadata.path).isEqualTo("/Photos/Sample Album/Boston City Flow.jpg");
    }

    private static HttpRequestor.Response createEmptyResponse(int statusCode) {
        byte [] body = new byte[0];
        return new HttpRequestor.Response(
            statusCode,
            new ByteArrayInputStream(body),
            Collections.<String,List<String>>emptyMap()
        );
    }

    private static HttpRequestor.Response createRateLimitResponse(long backoffSeconds) {
        byte [] body = new byte[0];
        return new HttpRequestor.Response(
            503, // API v1 uses 503 for rate limits
            new ByteArrayInputStream(body),
            headers("Retry-After", Long.toString(backoffSeconds))
        );
    }

    private static HttpRequestor.Response createDownloaderResponse(byte [] body, String header, String json) {
        return new HttpRequestor.Response(
            200,
            new ByteArrayInputStream(body),
            headers(header, json)
        );
    }

    private static HttpRequestor.Response createSuccessResponse(String json) throws IOException {
        byte [] body = json.getBytes("UTF-8");
        return new HttpRequestor.Response(
            200,
            new ByteArrayInputStream(body),
            Collections.<String,List<String>>emptyMap()
        );
    }

    private static HttpRequestor.Uploader mockUploader() {
        HttpRequestor.Uploader uploader = mock(HttpRequestor.Uploader.class);
        when(uploader.getBody())
            .thenAnswer(new Answer<OutputStream>() {
                @Override
                public OutputStream answer(InvocationOnMock invocation) {
                    return new ByteArrayOutputStream();
                }
            });
        return uploader;
    }

    private static Map<String, List<String>> headers(String name, String value, String ... rest) {
        assertThat(rest.length % 2 == 0).isTrue();

        Map<String, List<String>> headers = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        List<String> values = new ArrayList<String>();
        headers.put(name, values);
        values.add(value);
        for (int i = 0; i < rest.length; i += 2) {
            name = rest[i];
            value = rest[i+1];
            values = headers.get(name);
            if (values == null) {
                values = new ArrayList<String>();
                headers.put(name, values);
            }
            values.add(value);
        }

        return headers;
    }

    private static Iterable<HttpRequestor.Header> anyHeaders() {
        return Matchers.<Iterable<HttpRequestor.Header>>any();
    }
}
