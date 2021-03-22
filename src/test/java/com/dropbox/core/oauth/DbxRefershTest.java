package com.dropbox.core.oauth;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxOAuthTestBase;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.InvalidAccessTokenException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.DbxTeamClientV2;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.testng.Assert.fail;

public class DbxRefershTest extends DbxOAuthTestBase {
    private static final DbxRequestConfig CONFIG = DbxRequestConfig.newBuilder("DbxWebAuthTest/1.0")
        .withUserLocaleFrom(Locale.UK)
        .build();
    private static final DbxAppInfo APP = new DbxAppInfo("test-key", "test-secret");
    private static final String EXPIRED_TOKEN = "expired_token";
    private static final String REFRESH_TOKEN = "refresh____token";
    private static final String NEW_TOKEN = "new_token";
    private static final long EXPIRES_IN = 14400;


    @Test
    public void testRefreshResult() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"token_type\":\"Bearer\"" +
                    ",\"access_token\":\"" + NEW_TOKEN + "\"" +
                    ",\"expires_in\":" + EXPIRES_IN +
                "}"
            ).getBytes("UTF-8")
        );

        DbxRefreshResult actual = DbxRefreshResult.Reader.readFully(responseStream);
        actual.setIssueTime(0);

        assertThat(actual.getAccessToken()).isEqualTo(NEW_TOKEN);
        assertThat(actual.getExpiresAt()).isEqualTo(new Long(EXPIRES_IN * 1000));
    }

    @Test
    public void testExpire() {
        Long now = System.currentTimeMillis();
        assertThat(new DbxCredential(EXPIRED_TOKEN, 0L, REFRESH_TOKEN, APP.getKey(), APP
            .getSecret()).aboutToExpire()).isTrue();
        assertThat(new DbxCredential(EXPIRED_TOKEN, now, REFRESH_TOKEN, APP.getKey(), APP
            .getSecret()).aboutToExpire()).isTrue();
        assertThat(new DbxCredential(EXPIRED_TOKEN, now + EXPIRES_IN, REFRESH_TOKEN, APP.getKey()
            , APP.getSecret()).aboutToExpire()).isTrue();
        try {
            new DbxCredential(EXPIRED_TOKEN, null, "refresh", "appkey", null).aboutToExpire();
        } catch (IllegalArgumentException ex) {
            return;
        }
        fail("NPE should be thrown.");
    }

    @Test
    public static DbxRequestConfig setupMockRequestConfig(
        HttpRequestor.Response response,  HttpRequestor.Uploader mockUploader) throws
        IOException {
        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        when(mockUploader.finish()).thenReturn(response);
        when(mockRequestor.startPost(anyString(), anyListOf(HttpRequestor.Header.class)))
            .thenReturn(mockUploader);

        return CONFIG.copy().withHttpRequestor(mockRequestor).build();
    }

    @Test
    public void testRefreshUserClient() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"token_type\":\"Bearer\"" +
                    ",\"access_token\":\"" + NEW_TOKEN + "\"" +
                    ",\"expires_in\":" + EXPIRES_IN +
                "}"
            ).getBytes("UTF-8")
        );
        HttpRequestor.Response finishResponse = new HttpRequestor.Response(
            200, responseStream, new HashMap<String, List<String>>());
        long currentMilllis = System.currentTimeMillis();

        // Mock requester and uploader
        HttpRequestor.Uploader mockUploader = mock(HttpRequestor.Uploader.class);
        DbxRequestConfig mockConfig = setupMockRequestConfig(finishResponse, mockUploader);

        // Execute Refreshing
        DbxCredential credential = new DbxCredential(EXPIRED_TOKEN, EXPIRES_IN, REFRESH_TOKEN,
            APP.getKey(), APP.getSecret());
        DbxClientV2 client = new DbxClientV2(mockConfig, credential);
        client.refreshAccessToken();

        // Get URL Param
        ArgumentCaptor<byte[]> paramCaptor = ArgumentCaptor.forClass(byte[].class);
        verify(mockUploader).upload(paramCaptor.capture());
        Map<String, List<String>> refreshParams = toParamsMap(new String(paramCaptor.getValue(), "UTF-8"));

        // Verification
        assertThat(refreshParams.get("grant_type").get(0)).isEqualTo("refresh_token");
        assertThat(refreshParams.get("refresh_token").get(0)).isEqualTo(REFRESH_TOKEN);
        assertThat(refreshParams.containsKey("client_id")).isFalse();
        assertThat(credential.getAccessToken()).isEqualTo(NEW_TOKEN);
        assertThat(currentMilllis + EXPIRES_IN < credential.getExpiresAt()).isTrue();
    }

    @Test
    public void testRefreshTeamClient() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"token_type\":\"Bearer\"" +
                    ",\"access_token\":\"" + NEW_TOKEN + "\"" +
                    ",\"expires_in\":" + EXPIRES_IN +
                    "}"
            ).getBytes("UTF-8")
        );
        HttpRequestor.Response finishResponse = new HttpRequestor.Response(
            200, responseStream, new HashMap<String, List<String>>());
        long currentMilllis = System.currentTimeMillis();

        // Mock requester and uploader
        HttpRequestor.Uploader mockUploader = mock(HttpRequestor.Uploader.class);
        DbxRequestConfig mockConfig = setupMockRequestConfig(finishResponse, mockUploader);

        // Execute Refreshing
        DbxCredential credential = new DbxCredential(EXPIRED_TOKEN, EXPIRES_IN, REFRESH_TOKEN,
            APP.getKey(), APP.getSecret());
        DbxTeamClientV2 client = new DbxTeamClientV2(mockConfig, credential);
        client.refreshAccessToken();

        // Get URL Param
        ArgumentCaptor<byte[]> paramCaptor = ArgumentCaptor.forClass(byte[].class);
        verify(mockUploader).upload(paramCaptor.capture());
        Map<String, List<String>> refreshParams = toParamsMap(new String(paramCaptor.getValue(), "UTF-8"));

        // Verification
        assertThat(refreshParams.get("grant_type").get(0)).isEqualTo("refresh_token");
        assertThat(refreshParams.get("refresh_token").get(0)).isEqualTo(REFRESH_TOKEN);
        assertThat(refreshParams.containsKey("client_id")).isFalse();
        assertThat(credential.getAccessToken()).isEqualTo(NEW_TOKEN);
        assertThat(currentMilllis + EXPIRES_IN < credential.getExpiresAt()).isTrue();
    }

    @Test
    public void testRefreshPKCE() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"token_type\":\"Bearer\"" +
                    ",\"access_token\":\"" + NEW_TOKEN + "\"" +
                    ",\"expires_in\":" + EXPIRES_IN +
                    "}"
            ).getBytes("UTF-8")
        );
        HttpRequestor.Response finishResponse = new HttpRequestor.Response(
            200, responseStream, new HashMap<String, List<String>>());
        long currentMilllis = System.currentTimeMillis();

        // Mock requester and uploader
        HttpRequestor.Uploader mockUploader = mock(HttpRequestor.Uploader.class);
        DbxRequestConfig mockConfig = setupMockRequestConfig(finishResponse, mockUploader);

        // Execute Refreshing
        DbxCredential credential = new DbxCredential(EXPIRED_TOKEN, EXPIRES_IN, REFRESH_TOKEN,
            APP.getKey());
        credential.refresh(mockConfig);

        // Get URL Param
        ArgumentCaptor<byte[]> paramCaptor = ArgumentCaptor.forClass(byte[].class);
        verify(mockUploader).upload(paramCaptor.capture());
        Map<String, List<String>> refreshParams = toParamsMap(new String(paramCaptor.getValue(), "UTF-8"));

        // Verification
        assertThat(refreshParams.get("grant_type").get(0)).isEqualTo("refresh_token");
        assertThat(refreshParams.get("refresh_token").get(0)).isEqualTo(REFRESH_TOKEN);
        assertThat(refreshParams.get("client_id").get(0)).isEqualTo(APP.getKey());
        assertThat(credential.getAccessToken()).isEqualTo(NEW_TOKEN);
        assertThat(currentMilllis + EXPIRES_IN < credential.getExpiresAt()).isTrue();
    }

    @Test
    public void testDownScoping() throws Exception {
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"token_type\":\"Bearer\"" +
                    ",\"access_token\":\"" + NEW_TOKEN + "\"" +
                    ",\"expires_in\":" + EXPIRES_IN +
                    ",\"scope\":" + "\"myscope1\"" +
                "}"
            ).getBytes("UTF-8")
        );
        HttpRequestor.Response finishResponse = new HttpRequestor.Response(
            200, responseStream, new HashMap<String, List<String>>());
        long currentMilllis = System.currentTimeMillis();

        // Mock requester and uploader
        HttpRequestor.Uploader mockUploader = mock(HttpRequestor.Uploader.class);
        DbxRequestConfig mockConfig = setupMockRequestConfig(finishResponse, mockUploader);

        // Execute Refreshing
        DbxCredential credential = new DbxCredential(EXPIRED_TOKEN, EXPIRES_IN, REFRESH_TOKEN,
            APP.getKey());
        DbxRefreshResult refreshResult = credential.refresh(mockConfig, Arrays.asList("myscope1", "myscope2"));

        // Get URL Param
        ArgumentCaptor<byte[]> paramCaptor = ArgumentCaptor.forClass(byte[].class);
        verify(mockUploader).upload(paramCaptor.capture());
        Map<String, List<String>> refreshParams = toParamsMap(new String(paramCaptor.getValue(), "UTF-8"));

        // Verification
        assertThat(refreshParams.get("grant_type").get(0)).isEqualTo("refresh_token");
        assertThat(refreshParams.get("refresh_token").get(0)).isEqualTo(REFRESH_TOKEN);
        assertThat(refreshParams.get("client_id").get(0)).isEqualTo(APP.getKey());
        assertThat(refreshParams.get("scope").get(0)).isEqualTo("myscope1 myscope2");
        assertThat(credential.getAccessToken()).isEqualTo(NEW_TOKEN);
        assertThat(currentMilllis + EXPIRES_IN < credential.getExpiresAt()).isTrue();
        assertThat(refreshResult.getScope()).isEqualTo("myscope1");
    }

    @Test
    public void testGrantRevoked() throws Exception{
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

        // Mock requester and uploader
        HttpRequestor.Uploader mockUploader = mock(HttpRequestor.Uploader.class);
        DbxRequestConfig mockConfig = setupMockRequestConfig(finishResponse, mockUploader);

        // Execute Refresh
        DbxCredential credential = new DbxCredential(EXPIRED_TOKEN, 100L, REFRESH_TOKEN,
            APP.getKey(), APP.getSecret());
        DbxClientV2 client = new DbxClientV2(mockConfig, credential);

        try {
            client.refreshAccessToken();
        } catch (DbxOAuthException e) {
            assertThat(e.getDbxOAuthError().getError()).isEqualTo("invalid_grant");
            return;
        }

        fail("Should not reach here.");
    }

    @Test
    public void testMissingScope() throws Exception {
        Long now = System.currentTimeMillis();
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"error_summary\":\"missing_scope/.\" ,\"error\":{\".tag\": \"missing_scope\", \"required_scope\": \"account.info.read\"}" +
                    "}"
            ).getBytes("UTF-8")
        );
        HttpRequestor.Response finishResponse = new HttpRequestor.Response(
            401, responseStream, new HashMap<String, List<String>>());

        // Mock requester and uploader
        HttpRequestor.Uploader mockUploader = mock(HttpRequestor.Uploader.class);
        DbxRequestConfig mockConfig = setupMockRequestConfig(finishResponse, mockUploader);

        DbxCredential credential = new DbxCredential(NEW_TOKEN, now +2 * DbxCredential.EXPIRE_MARGIN,
            REFRESH_TOKEN,
            APP.getKey(), APP.getSecret());
        DbxClientV2 client = new DbxClientV2(mockConfig, credential);

        try {
            client.users().getCurrentAccount();
            fail("Should raise exception before reaching here");
        } catch (InvalidAccessTokenException ex) {
            assertThat(ex.getAuthError().isMissingScope()).isTrue();
            String missingScope = ex.getAuthError().getMissingScopeValue().getRequiredScope();
            assertWithMessage("expect account.info.read, get " + missingScope).that("account.info.read").isEqualTo(missingScope);
        }
    }
}
