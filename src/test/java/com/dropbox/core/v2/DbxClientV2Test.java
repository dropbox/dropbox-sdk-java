package com.dropbox.core.v2;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.mockito.Mockito.*;
import static com.dropbox.core.v2.files.FilesSerializers.serializer;
import static org.testng.Assert.fail;

import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.InvalidAccessTokenException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.v2.auth.AuthError;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.BadRequestException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.RetryException;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.Matchers;

import org.testng.annotations.Test;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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

    private FileMetadata constructFileMetadate() throws Exception {
        Class builderClass = FileMetadata.Builder.class;
        Constructor constructor = builderClass.getDeclaredConstructors()[0];
        constructor.setAccessible(true);

        List<Object> arguments = new ArrayList<Object>(Arrays.asList(
                "bar.txt",
                "id:1HkLjqifwMAAAAAAAAAAAQ",
                new Date(1456169040985L),
                new Date(1456169040985L),
                "2e0c38735597",
                2091603
        ));

        // hack for internal version of SDK
        if (constructor.getParameterTypes().length > 6) {
            arguments.addAll(Arrays.asList("20MB", "text.png", "text/plain"));
        }

        FileMetadata.Builder builder = (FileMetadata.Builder) constructor.newInstance(arguments.toArray());
        return builder.build();
    }

    @Test
    public void testRetrySuccess() throws Exception {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV2 client = new DbxClientV2(config, "fakeAccessToken");
        FileMetadata expected = constructFileMetadate();

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

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertWithMessage(actual.getClass().toString()).that(actual instanceof FileMetadata).isTrue();
        assertThat(((FileMetadata) actual).getId()).isEqualTo(expected.getId());
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
    public void testRetryDownload() throws Exception {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV2 client = new DbxClientV2(config, "fakeAccessToken");
        FileMetadata expectedMetadata = constructFileMetadate();
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

        assertThat(actualBytes).isEqualTo(expectedBytes);
        assertThat(actualMetadata).isEqualTo(expectedMetadata);
    }

    @Test
    public void testRetrySuccessWithBackoff() throws Exception {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled(3)
            .withHttpRequestor(mockRequestor)
            .build();

        DbxClientV2 client = new DbxClientV2(config, "fakeAccessToken");
        FileMetadata expected = constructFileMetadate();

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
        assertWithMessage("duration: " + (end - start) + " millis").that(end - start >= 3000L).isTrue();

        // should have been called 4 times: initial call + 3 retries
        verify(mockRequestor, times(4)).startPost(anyString(), anyHeaders());

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertWithMessage(actual.getClass().toString()).that(actual instanceof FileMetadata).isTrue();
    }

    @Test
    public void testRefreshBeforeCall() throws Exception {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withHttpRequestor(mockRequestor)
            .build();

        DbxCredential credential = new DbxCredential("accesstoken", 10L, "refresh_token",
            "appkey", "app_secret");

        DbxClientV2 client = new DbxClientV2(config, credential);
        FileMetadata expected = constructFileMetadate();

        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createSuccessRefreshResponse("newToken", 10L))
            .thenReturn(createSuccessResponse(serialize(expected)));

        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        long now = System.currentTimeMillis();

        Metadata actual = client.files().getMetadata(expected.getId());

        verify(mockRequestor, times(2)).startPost(anyString(), anyHeaders());

        assertThat(credential.getAccessToken()).isEqualTo("newToken");
        assertThat(credential.getExpiresAt() > now).isTrue();

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertWithMessage(actual.getClass().toString()).that(actual instanceof FileMetadata).isTrue();
        assertThat(((FileMetadata) actual).getId()).isEqualTo(expected.getId());
    }

    @Test
    public void testDontRefreshBeforeCallIfNotExpired() throws Exception {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withHttpRequestor(mockRequestor)
            .build();

        long now = System.currentTimeMillis();

        DbxCredential credential = new DbxCredential("accesstoken", now + 2*DbxCredential
            .EXPIRE_MARGIN,
            "refresh_token",
            "appkey", "app_secret");

        DbxClientV2 client = new DbxClientV2(config, credential);
        FileMetadata expected = constructFileMetadate();

        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish()).thenReturn(createSuccessResponse(serialize(expected)));

        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        Metadata actual = client.files().getMetadata(expected.getId());

        verify(mockRequestor, times(1)).startPost(anyString(), anyHeaders());
        assertThat(credential.getAccessToken()).isEqualTo("accesstoken");

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertWithMessage(actual.getClass().toString()).that(actual instanceof FileMetadata).isTrue();
        assertThat(((FileMetadata) actual).getId()).isEqualTo( expected.getId());
    }

    @Test
    public void testDontRefreshForInvalidGrant() throws Exception {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withHttpRequestor(mockRequestor)
            .build();

        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"error_description\":\"refresh token is invalid or revoked\"" +
                    ",\"error\":\"invalid_grant\"" +
                    "}"
            ).getBytes("UTF-8")
        );
        HttpRequestor.Response finishResponse = new HttpRequestor.Response(
            400, responseStream, new HashMap<String, List<String>>());

        DbxCredential credential = new DbxCredential("accesstoken", 10L, "refresh_token",
            "appkey", "app_secret");

        DbxClientV2 client = new DbxClientV2(config, credential);
        FileMetadata expected = constructFileMetadate();

        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(finishResponse)
            .thenReturn(createSuccessResponse(serialize(expected)));

        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        Metadata actual = client.files().getMetadata(expected.getId());

        verify(mockRequestor, times(2)).startPost(anyString(), anyHeaders());

        assertThat(credential.getAccessToken()).isEqualTo("accesstoken");
        assertThat(credential.getExpiresAt()).isEqualTo(new Long(10));

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertWithMessage(actual.getClass().toString()).that(actual instanceof FileMetadata).isTrue();
        assertThat(((FileMetadata) actual).getId()).isEqualTo(expected.getId());
    }

    @Test
    public void testRefreshAndRetryAfterTokenExpired() throws Exception {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withHttpRequestor(mockRequestor)
            .build();

        long now = System.currentTimeMillis();

        DbxCredential credential = new DbxCredential("accesstoken", now + 2*DbxCredential
            .EXPIRE_MARGIN,
            "refresh_token",
            "appkey", "app_secret");

        DbxClientV2 client = new DbxClientV2(config, credential);
        FileMetadata expected = constructFileMetadate();

        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createTokenExpiredResponse())
            .thenReturn(createSuccessRefreshResponse("new_token", 14400L))
            .thenReturn(createSuccessResponse(serialize(expected)));

        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        Metadata actual = client.files().getMetadata(expected.getId());

        verify(mockRequestor, times(3)).startPost(anyString(), anyHeaders());
        assertThat(credential.getAccessToken()).isEqualTo("new_token");

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertWithMessage(actual.getClass().toString()).that(actual instanceof FileMetadata).isTrue();
        assertThat(((FileMetadata) actual).getId()).isEqualTo(expected.getId());
    }

    @Test
    public void testRefreshAndRetryAfterTokenExpiredForDownload() throws Exception {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withHttpRequestor(mockRequestor)
            .build();

        long now = System.currentTimeMillis();

        DbxCredential credential = new DbxCredential("accesstoken", now + 2*DbxCredential
            .EXPIRE_MARGIN,
            "refresh_token",
            "appkey", "app_secret");

        DbxClientV2 client = new DbxClientV2(config, credential);
        FileMetadata expected = constructFileMetadate();

        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createTokenExpiredResponse())
            .thenReturn(createSuccessRefreshResponse("new_token", 14400L))
            .thenReturn(createDownloadSuccessResponse("data".getBytes(), new String(serialize(expected))));

        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        DbxDownloader<FileMetadata> downloader = client.files().download("/path");

        try {
            downloader.download(out);
        } finally {
            downloader.close();
        }

        assertThat(out.toString()).isEqualTo("data");

        Metadata actual = downloader.getResult();

        verify(mockRequestor, times(3)).startPost(anyString(), anyHeaders());
        assertThat(credential.getAccessToken()).isEqualTo("new_token");

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertThat(((FileMetadata) actual).getId()).isEqualTo(expected.getId());
    }

    @Test
    public void testRefreshAndRetryWith503Retry() throws Exception {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withAutoRetryEnabled()
            .withHttpRequestor(mockRequestor)
            .build();

        long now = System.currentTimeMillis();

        DbxCredential credential = new DbxCredential("accesstoken", now + 2*DbxCredential
            .EXPIRE_MARGIN,
            "refresh_token",
            "appkey", "app_secret");

        DbxClientV2 client = new DbxClientV2(config, credential);
        FileMetadata expected = constructFileMetadate();

        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish())
            .thenReturn(createTokenExpiredResponse())
            .thenReturn(createSuccessRefreshResponse("new_token", 14400L))
            .thenReturn(createEmptyResponse(503))
            .thenReturn(createSuccessResponse(serialize(expected)));

        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        Metadata actual = client.files().getMetadata(expected.getId());

        verify(mockRequestor, times(4)).startPost(anyString(), anyHeaders());
        assertThat(credential.getAccessToken()).isEqualTo("new_token");

        assertThat(actual.getName()).isEqualTo(expected.getName());
        assertWithMessage(actual.getClass().toString()).that(actual instanceof FileMetadata).isTrue();
        assertThat(((FileMetadata) actual).getId()).isEqualTo(expected.getId());
    }

    @Test
    public void testOnlineWontRefresh() throws Exception {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        DbxRequestConfig config = createRequestConfig()
            .withHttpRequestor(mockRequestor)
            .build();

        DbxCredential credential = new DbxCredential("accesstoken");

        DbxClientV2 client = new DbxClientV2(config, credential);
        FileMetadata expected = constructFileMetadate();

        HttpRequestor.Uploader mockUploader = mockUploader();
        when(mockUploader.finish()).thenReturn(createTokenExpiredResponse());

        when(mockRequestor.startPost(anyString(), anyHeaders()))
            .thenReturn(mockUploader);

        try {
            client.files().getMetadata(expected.getId());
        } catch (InvalidAccessTokenException ex) {
            verify(mockRequestor, times(1)).startPost(anyString(), anyHeaders());
            assertThat(credential.getAccessToken()).isEqualTo("accesstoken");

            AuthError authError = DbxRequestUtil.readJsonFromErrorMessage(AuthError.Serializer
                .INSTANCE, ex.getMessage(), ex.getRequestId());
            assertThat(authError).isEqualTo(AuthError.EXPIRED_ACCESS_TOKEN);
            return;
        }

        fail("API v2 call should throw exception");
    }

    private static HttpRequestor.Response createSuccessRefreshResponse(String newToken, long
        newExpiresIn)  throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"token_type\":\"Bearer\"" +
                    ",\"access_token\":\"" + newToken + "\"" +
                    ",\"expires_in\":" + newExpiresIn +
                    "}"
            ).getBytes("UTF-8")
        );
        return new HttpRequestor.Response(200, responseStream, new HashMap<String, List<String>>());
    }

    private static HttpRequestor.Response createTokenExpiredResponse() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"error_summary\":\"expired_access_token/..\"" +
                    ",\"error\":{\".tag\": \"expired_access_token\"}" +
                "}"
            ).getBytes("UTF-8")
        );
        return new HttpRequestor.Response(401, responseStream, new HashMap<String, List<String>>());
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

    private static HttpRequestor.Response createDownloadSuccessResponse(byte [] body, final String
        metadata) {
        return new HttpRequestor.Response(
            200,
            new ByteArrayInputStream(body),
            new HashMap<String, List<String>>() {{
                put("dropbox-api-result", Collections.singletonList(metadata));
            }}
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

    private static byte [] serialize(Metadata metadata) {
        assertThat(metadata).isNotNull();

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
