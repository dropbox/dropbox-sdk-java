package com.dropbox.core.v2;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;
import static com.dropbox.core.v2.files.FilesSerializers.serializer;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.util.IOUtil;
import com.dropbox.core.BadRequestException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.RetryException;

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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DbxClientV2Test {

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

        DbxClientV2 client = new DbxClientV2(config, "fakeAccessToken");

        // 503 every time
        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createEmptyResponse(503));
        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        try {
            client.users().getCurrentAccount();
        } finally {
            // should only have been called once since we disabled retry
            verify(mockRequestor, times(1)).startPost(anyString(), anyHeaders());
        }
    }

    @Test
    public void testRetrySuccess() throws DbxException, IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV2 client = new DbxClientV2(config, "fakeAccessToken");
        FileMetadata expected = new FileMetadata(
            "bar.txt",
            "id:1HkLjqifwMAAAAAAAAAAAQ",
            new Date(1456169040985L),
            new Date(1456169040985L),
            "2e0c38735597",
            2091603,
                "20MB",
                "text.png",
                "text/plain"
        );

        // 503 twice, then return result
        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createEmptyResponse(503))
            .thenReturn(createEmptyResponse(503))
            .thenReturn(createSuccessResponse(serialize(expected)));

        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        Metadata actual = client.files().getMetadata(expected.getId());

        // should have only been called 3 times: initial call + 2 retries
        verify(mockRequestor, times(3)).startPost(anyString(), anyHeaders());

        assertEquals(actual.getName(), expected.getName());
        assertTrue(actual instanceof FileMetadata, actual.getClass().toString());
        assertEquals(((FileMetadata) actual).getId(), expected.getId());
    }

    @Test(expectedExceptions = RetryException.class)
    public void testRetryRetriesExceeded() throws DbxException, IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV2 client = new DbxClientV2(config, "fakeAccessToken");

        // 503 always and forever
        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createEmptyResponse(503));
        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        try {
            client.users().getCurrentAccount();
        } finally {
            // should only have been called 4 times: initial call plus our maximum retry limit
            verify(mockRequestor, times(1 + 3)).startPost(anyString(), anyHeaders());
        }
    }

    @Test(expectedExceptions = BadRequestException.class)
    public void testRetryOtherFailure() throws DbxException, IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV2 client = new DbxClientV2(config, "fakeAccessToken");

        // 503 once, then return 400
        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createEmptyResponse(503))
            .thenReturn(createEmptyResponse(400));
        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        try {
            client.users().getCurrentAccount();
        } finally {
            // should only have been called 2 times: initial call + retry
            verify(mockRequestor, times(2)).startPost(anyString(), anyHeaders());
        }
    }

    @Test
    public void testRetryDownload() throws DbxException, IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV2 client = new DbxClientV2(config, "fakeAccessToken");

        FileMetadata expectedMetadata = new FileMetadata(
            "download_me.txt",
            "id:KLavC4viCDAAAAAAAAAAAQ",
            new Date(1456169692501L),
            new Date(1456169692501L),
            "341438735597",
            2626,
                "20MB",
                "text.png",
                "text/plain"
        );
        byte [] expectedBytes = new byte [] { 1, 2, 3, 4 };

        // 503 once, then return 200
        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createEmptyResponse(503))
            .thenReturn(createDownloaderResponse(expectedBytes, serialize(expectedMetadata)));
        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        DbxDownloader<FileMetadata> downloader = client.files().download(expectedMetadata.getId());

        // should have been attempted twice
        verify(mockRequestor, times(2)).startPost(anyString(), anyHeaders());

        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        FileMetadata actualMetadata = downloader.download(bout);
        byte [] actualBytes = bout.toByteArray();

        assertEquals(actualBytes, expectedBytes);
        assertEquals(actualMetadata, expectedMetadata);
    }

    @Test
    public void testRetrySuccessWithBackoff() throws DbxException, IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV2 client = new DbxClientV2(config, "fakeAccessToken");
        FileMetadata expected = new FileMetadata(
            "banana.png",
            "id:eRsVsAya9YAAAAAAAAAAAQ",
            new Date(1456173312172L),
            new Date(1456173312172L),
            "89df885732c38",
            12345L,
                "20MB",
                "text.png",
                "text/plain"
        );

        // 503 twice, then return result
        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createEmptyResponse(503))   // no backoff
            .thenReturn(createRateLimitResponse(1)) // backoff 1 sec
            .thenReturn(createRateLimitResponse(2)) // backoff 2 sec
            .thenReturn(createSuccessResponse(serialize(expected)));

        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        long start = System.currentTimeMillis();
        Metadata actual = client.files().getMetadata(expected.getId());
        long end = System.currentTimeMillis();

        // no way easy way to properly test this, but request should
        // have taken AT LEAST 3 seconds due to backoff.
        assertTrue((end - start) >= 3000L, "duration: " + (end - start) + " millis");

        // should have been called 4 times: initial call + 3 retries
        verify(mockRequestor, times(4)).startPost(anyString(), anyHeaders());

        assertEquals(actual.getName(), expected.getName());
        assertTrue(actual instanceof FileMetadata, actual.getClass().toString());
    }

    private static HttpRequestor.Response createRateLimitResponse(long backoffSeconds) {
        byte [] body = new byte[0];
        return new HttpRequestor.Response(
            429,
            new ByteArrayInputStream(body),
            headers("Retry-After", Long.toString(backoffSeconds))
        );
    }

    private static HttpRequestor.Response createEmptyResponse(int statusCode) {
        byte [] body = new byte[0];
        return new HttpRequestor.Response(
            statusCode,
            new ByteArrayInputStream(body),
            Collections.<String,List<String>>emptyMap()
        );
    }

    private static HttpRequestor.Response createDownloaderResponse(byte [] body, byte [] jsonResponse) {
        try {
            return new HttpRequestor.Response(
                200,
                new ByteArrayInputStream(body),
                headers("Dropbox-Api-Result", new String(jsonResponse, "UTF-8"))
            );
        } catch (IOException ex) {
            // character encoding exception is impossible for UTF-8
            fail("UTF-8 missing (impossible)", ex);
            return null;
        }
    }

    private static HttpRequestor.Response createSuccessResponse(byte [] body) throws IOException {
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
        assertTrue(rest.length % 2 == 0);

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

    private static byte [] serialize(Metadata metadata) {
        assertNotNull(metadata);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            serializer(Metadata.class).serialize(metadata, out);
        } catch (Exception ex) {
            fail("unserializable type: " + metadata.getClass(), ex);
            return null;
        }
        return out.toByteArray();
    }
}
