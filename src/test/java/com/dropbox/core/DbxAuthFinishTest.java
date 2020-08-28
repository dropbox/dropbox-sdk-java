package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

public class DbxAuthFinishTest extends DbxOAuthTestBase {
    private static final DbxRequestConfig CONFIG = DbxRequestConfig.newBuilder("DbxWebAuthTest/1.0")
            .withUserLocaleFrom(Locale.UK)
            .build();
    private static final DbxAppInfo APP = new DbxAppInfo("test-key", "test-secret");

    @Test
    public void testDbxAuthFinishLegacyToken() throws Exception{
        DbxAuthFinish expected = new DbxAuthFinish(
                "test-access-token", null, null, "test-user-id", null, "test", null, null
        );

        ByteArrayInputStream responseStream = new ByteArrayInputStream(
                (
                        "{" +
                                "\"token_type\":\"Bearer\"" +
                                ",\"access_token\":\"" + expected.getAccessToken() + "\"" +
                                ",\"uid\":\"" + expected.getUserId() + "\"" +
                                ",\"account_id\":\"" + expected.getAccountId() + "\"" +
                                "}"
                ).getBytes("UTF-8")
        );

        DbxAuthFinish actual = DbxAuthFinish.Reader.readFully(responseStream);
        assertEquals(actual.getAccessToken(), expected.getAccessToken());
        assertEquals(actual.getAccountId(), expected.getAccountId());
        assertEquals(actual.getRefreshToken(), expected.getRefreshToken());
        assertEquals(actual.getExpiresAt(), expected.getExpiresAt());
        assertEquals(actual.getTeamId(), expected.getTeamId());
        assertEquals(actual.getUserId(), expected.getUserId());
        assertEquals(actual.getUrlState(), expected.getUrlState());
    }

    @Test
    public void testDbxAuthFinishOnline() throws Exception{
        long now = System.currentTimeMillis();
        DbxAuthFinish expected = new DbxAuthFinish(
                "test-access-token", 3600L, null, "test-user-id", null, "test", null, null
        );
        expected.setIssueTime(now);

        ByteArrayInputStream responseStream = new ByteArrayInputStream(
                (
                        "{" +
                                "\"token_type\":\"Bearer\"" +
                                ",\"access_token\":\"" + expected.getAccessToken() + "\"" +
                                ",\"expires_in\":" + 3600 +
                                ",\"uid\":\"" + expected.getUserId() + "\"" +
                                ",\"account_id\":\"" + expected.getAccountId() + "\"" +
                                "}"
                ).getBytes("UTF-8")
        );



        DbxAuthFinish actual = DbxAuthFinish.Reader.readFully(responseStream);
        actual.setIssueTime(now);
        assertEquals(actual.getAccessToken(), expected.getAccessToken());
        assertEquals(actual.getAccountId(), expected.getAccountId());
        assertEquals(actual.getRefreshToken(), expected.getRefreshToken());
        assertEquals(actual.getExpiresAt(), expected.getExpiresAt());
        assertEquals(actual.getTeamId(), expected.getTeamId());
        assertEquals(actual.getUserId(), expected.getUserId());
        assertEquals(actual.getUrlState(), expected.getUrlState());
    }

    @Test
    public void testDbxAuthFinishOffline() throws Exception{
        long now = System.currentTimeMillis();
        DbxAuthFinish expected = new DbxAuthFinish(
                "test-access-token", 3600L, "test_refresh_token", "test-user-id", null, "test",
            null, null
        );
        expected.setIssueTime(now);

        ByteArrayInputStream responseStream = new ByteArrayInputStream(
                (
                        "{" +
                                "\"token_type\":\"Bearer\"" +
                                ",\"access_token\":\"" + expected.getAccessToken() + "\"" +
                                ",\"expires_in\":" + 3600 +
                                ",\"refresh_token\":\"" + expected.getRefreshToken() + "\"" +
                                ",\"uid\":\"" + expected.getUserId() + "\"" +
                                ",\"account_id\":\"" + expected.getAccountId() + "\"" +
                                "}"
                ).getBytes("UTF-8")
        );



        DbxAuthFinish actual = DbxAuthFinish.Reader.readFully(responseStream);
        actual.setIssueTime(now);
        assertEquals(actual.getAccessToken(), expected.getAccessToken());
        assertEquals(actual.getAccountId(), expected.getAccountId());
        assertEquals(actual.getRefreshToken(), expected.getRefreshToken());
        assertEquals(actual.getExpiresAt(), expected.getExpiresAt());
        assertEquals(actual.getTeamId(), expected.getTeamId());
        assertEquals(actual.getUserId(), expected.getUserId());
        assertEquals(actual.getUrlState(), expected.getUrlState());
    }

    @Test
    public void testDbxAuthFinishScope() throws Exception{
        long now = System.currentTimeMillis();
        DbxAuthFinish expected = new DbxAuthFinish(
            "test-access-token", 3600L, "test_refresh_token", "test-user-id", null, "test",
            null, "account_info.read"
        );
        expected.setIssueTime(now);

        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"token_type\":\"Bearer\"" +
                    ",\"access_token\":\"" + expected.getAccessToken() + "\"" +
                    ",\"expires_in\":" + 3600 +
                    ",\"refresh_token\":\"" + expected.getRefreshToken() + "\"" +
                    ",\"uid\":\"" + expected.getUserId() + "\"" +
                    ",\"account_id\":\"" + expected.getAccountId() + "\"" +
                    ",\"scope\":\"" + expected.getScope() + "\"" +
                    "}"
            ).getBytes("UTF-8")
        );



        DbxAuthFinish actual = DbxAuthFinish.Reader.readFully(responseStream);
        actual.setIssueTime(now);
        assertEquals(actual.getAccessToken(), expected.getAccessToken());
        assertEquals(actual.getAccountId(), expected.getAccountId());
        assertEquals(actual.getRefreshToken(), expected.getRefreshToken());
        assertEquals(actual.getExpiresAt(), expected.getExpiresAt());
        assertEquals(actual.getTeamId(), expected.getTeamId());
        assertEquals(actual.getUserId(), expected.getUserId());
        assertEquals(actual.getUrlState(), expected.getUrlState());
        assertEquals(actual.getScope(), expected.getScope());
    }

    @Test
    public void testDbxAuthFinishWithUrlState() throws Exception {
        DbxAuthFinish expected = new DbxAuthFinish(
                "test-access-token", 3600L, "test_refresh_token", "test-user-id", null, "test",
            null, null
        );

        DbxAuthFinish actual = expected.withUrlState("testState");

        assertEquals(actual.getAccessToken(), expected.getAccessToken());
        assertEquals(actual.getAccountId(), expected.getAccountId());
        assertEquals(actual.getRefreshToken(), expected.getRefreshToken());
        assertEquals(actual.getExpiresAt(), expected.getExpiresAt());
        assertEquals(actual.getTeamId(), expected.getTeamId());
        assertEquals(actual.getUserId(), expected.getUserId());
        assertEquals(actual.getUrlState(), "testState");
    }

    @Test
    public void testFinishWithState() throws Exception {
        String redirectUri = "http://localhost/finish/with/state/test";
        DbxSessionStore sessionStore = new DbxWebAuthTest.SimpleSessionStore();
        String state = "test-state";

        DbxWebAuth.Request request = DbxWebAuth.newRequestBuilder()
                .withRedirectUri(redirectUri, sessionStore)
                .withState(state)
                .build();

        // simulate a web server that will not keep the DbxWebAuth
        // instance across requests
        String authorizationUrl = new DbxWebAuth(CONFIG, APP).authorize(request);
        String code = "test-code";

        assertNotNull(sessionStore.get());

        DbxAuthFinish expected = new DbxAuthFinish(
                "test-access-token", null, null, "test-user-id", null, "test", state, null
        );
        ByteArrayOutputStream body = new ByteArrayOutputStream();
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
                (
                        "{" +
                                "\"token_type\":\"Bearer\"" +
                                ",\"access_token\":\"" + expected.getAccessToken() + "\"" +
                                ",\"uid\":\"" + expected.getUserId() + "\"" +
                                ",\"account_id\":\"" + expected.getAccountId() + "\"" +
                                "}"
                ).getBytes("UTF-8")
        );
        HttpRequestor.Response finishResponse = new HttpRequestor.Response(
                200, responseStream, new HashMap<String, List<String>>());

        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        HttpRequestor.Uploader mockUploader = mock(HttpRequestor.Uploader.class);
        ArgumentCaptor<String> urlCaptor = ArgumentCaptor.forClass(String.class);
        when(mockUploader.getBody())
                .thenReturn(body);
        when(mockUploader.finish())
                .thenReturn(finishResponse);
        when(mockRequestor.startPost(anyString(), anyListOf(HttpRequestor.Header.class)))
                .thenReturn(mockUploader);

        DbxRequestConfig mockConfig = CONFIG.copy()
                .withHttpRequestor(mockRequestor)
                .build();

        DbxAuthFinish actual = new DbxWebAuth(mockConfig, APP).finishFromRedirect(
                redirectUri,
                sessionStore,
                params("code", "test-code",
                        "state", extractQueryParam(authorizationUrl, "state"))
        );

        // verify the state param isn't send to the 'oauth2/token' endpoint
        String finishParams = new String(body.toByteArray(), "UTF-8");
        assertNull(toParamsMap(finishParams).get("state"));

        assertNotNull(actual);
        assertEquals(actual.getAccessToken(), expected.getAccessToken());
        assertEquals(actual.getUserId(), expected.getUserId());
        assertEquals(actual.getUrlState(), expected.getUrlState());
    }
}
