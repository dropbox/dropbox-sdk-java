package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import org.mockito.ArgumentCaptor;
import org.testng.Assert.ThrowingRunnable;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.testng.Assert.assertThrows;

public class DbxPKCEWebAuthTest extends DbxOAuthTestBase {
    private static final DbxRequestConfig CONFIG = DbxRequestConfig.newBuilder("DbxWebAuthTest/1.0")
            .withUserLocaleFrom(Locale.UK)
            .build();
    private static final DbxAppInfo APP = new DbxAppInfo("test-key");
    private static final String PKCE_REGEX = "^[0-9a-zA-Z\\-._~]{43,128}$";

    @Test
    public void testCodeChallenge() throws Exception {
        String redirectUri = "https://localhost/compatibility/test";
        DbxSessionStore sessionStore = new SimpleSessionStore();
        String state = "test-state";

        DbxPKCEWebAuth auth = new DbxPKCEWebAuth(CONFIG, APP);

        String authUrl = auth.authorize(
                DbxWebAuth.newRequestBuilder()
                    .withRedirectUri(redirectUri, sessionStore)
                    .withState(state)
                    .build()
        );


        Map<String, List<String>> params = toParamsMap(new URL(authUrl));
        assertThat(params.containsKey("code_challenge")).isTrue();
        String codeChallenge = params.get("code_challenge").get(0);
        assertWithMessage(codeChallenge).that(Pattern.matches(PKCE_REGEX, codeChallenge)).isTrue();

        assertThat(params.containsKey("code_challenge_method")).isTrue();
        assertThat(params.get("code_challenge_method").get(0)).isEqualTo("S256");
    }

    @Test
    public void testCodeVerifier() throws Exception{
        String redirectUri = "http://localhost/finish/with/state/test";
        DbxSessionStore sessionStore = new SimpleSessionStore();
        String state = "test-state";

        DbxWebAuth.Request request = DbxWebAuth.newRequestBuilder()
                .withRedirectUri(redirectUri, sessionStore)
                .withState(state)
                .build();

        String code = "test-code";

        ByteArrayOutputStream body = new ByteArrayOutputStream();
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
                (
                        "{" +
                                "\"token_type\":\"Bearer\"" +
                                ",\"access_token\":\"sdfg\"" +
                                ",\"uid\":\"21345\"" +
                                ",\"account_id\":\"765\"" +
                                "}"
                ).getBytes("UTF-8")
        );
        HttpRequestor.Response finishResponse = new HttpRequestor.Response(
                200, responseStream, new HashMap<String, List<String>>());

        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        HttpRequestor.Uploader mockUploader = mock(HttpRequestor.Uploader.class);
        when(mockUploader.getBody())
                .thenReturn(body);
        when(mockUploader.finish())
                .thenReturn(finishResponse);
        when(mockRequestor.startPost(anyString(), anyListOf(HttpRequestor.Header.class)))
                .thenReturn(mockUploader);

        DbxRequestConfig mockConfig = CONFIG.copy()
                .withHttpRequestor(mockRequestor)
                .build();

        // PKCE flow should keep the same instance in both authorize and finish call.
        DbxPKCEWebAuth dbxPKCEWebAuth = new DbxPKCEWebAuth(mockConfig, APP);
        String authorizationUrl = dbxPKCEWebAuth.authorize(request);
        String code_challenge = toParamsMap(new URL(authorizationUrl)).get("code_challenge").get(0);

        dbxPKCEWebAuth.finishFromRedirect(
                redirectUri,
                sessionStore,
                params("code", code, "state", extractQueryParam(authorizationUrl, "state"))
        );

        ArgumentCaptor<byte[]> argumentCaptor = ArgumentCaptor.forClass(byte[].class);
        verify(mockUploader).upload(argumentCaptor.capture());
        Map<String, List<String>> finishParams = toParamsMap(new String(argumentCaptor.getValue(), "UTF-8"));
        String code_verifier = finishParams.get("code_verifier").get(0);
        assertThat(code_challenge).isEqualTo(DbxPKCEManager.generateCodeChallenge(code_verifier));
    }

    @Test
    public void testAppInfoWithSecret() {
        assertThrows(IllegalStateException.class, new ThrowingRunnable() {
            public void run() {
                DbxAppInfo appInfoWithSecret = new DbxAppInfo("test-key", "test-secret");
                new DbxPKCEWebAuth(CONFIG, appInfoWithSecret);
            }
        });
    }

    @Test
    public void testFinishWithoutAuthorize() {
        final DbxPKCEWebAuth dbxWebAuth = new DbxPKCEWebAuth(CONFIG, APP);
        assertThrows(IllegalStateException.class, new ThrowingRunnable() {
            @Override
            public void run() throws Throwable {
                dbxWebAuth.finish("any_code", null,  null);
            }
        });
    }

    @Test
    public void testScope() throws Exception {
        DbxPKCEWebAuth auth = new DbxPKCEWebAuth(CONFIG, APP);

        String authUrl = auth.authorize(
            DbxWebAuth.newRequestBuilder()
                .withNoRedirect()
                .withScope(Collections.singletonList("account.info.read"))
                .build()
        );

        Map<String, List<String>> params = toParamsMap(new URL(authUrl));
        assertThat(params.get("scope")).isEqualTo(Collections.singletonList("account.info.read"));
    }

    @Test
    public void testIncrementalOAuth() throws Exception {
        DbxPKCEWebAuth auth = new DbxPKCEWebAuth(CONFIG, APP);

        String authUrl = auth.authorize(
            DbxWebAuth.newRequestBuilder()
                .withNoRedirect()
                .withScope(Collections.singletonList("account.info.read"))
                .withIncludeGrantedScopes(IncludeGrantedScopes.USER)
                .build()
        );

        Map<String, List<String>> params = toParamsMap(new URL(authUrl));
        assertThat(params.get("client_id")).isEqualTo(Collections.singletonList(APP.getKey()));
        assertThat(params.get("response_type")).isEqualTo(Collections.singletonList("code"));
        assertThat(params.get("scope")).isEqualTo(Collections.singletonList("account.info.read"));
        assertThat(params.get("include_granted_scopes")).isEqualTo(Collections.singletonList("user"));
        assertThat(params.containsKey("redirect_uri")).isFalse();
        assertThat(params.containsKey("state")).isFalse();
        assertThat(params.containsKey("require_role")).isFalse();
        assertThat(params.containsKey("force_reapprove")).isFalse();
        assertThat(params.containsKey("disable_signup")).isFalse();
        assertThat(params.containsKey("token_access_type")).isFalse();
        assertThat(params.get("code_challenge")).isNotNull();
        assertThat(params.get("code_challenge_method")).isEqualTo(Collections.singletonList("S256"));
    }

    @Test
    public void testInvalidCodeVerifier() throws Exception{
        DbxWebAuth.Request request = DbxWebAuth.newRequestBuilder().build();

        String code = "test-code";

        ByteArrayOutputStream body = new ByteArrayOutputStream();
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
                "{" +
                    "\"error_description\":\"invalid code verifier\"" +
                    ",\"error\":\"invalid_grant\"" +
                    "}"
            ).getBytes("UTF-8")
        );
        HttpRequestor.Response finishResponse = new HttpRequestor.Response(
            400, responseStream, new HashMap<String, List<String>>());

        HttpRequestor mockRequestor = mock(HttpRequestor.class);
        HttpRequestor.Uploader mockUploader = mock(HttpRequestor.Uploader.class);
        when(mockUploader.finish())
            .thenReturn(finishResponse);
        when(mockRequestor.startPost(anyString(), anyListOf(HttpRequestor.Header.class)))
            .thenReturn(mockUploader);

        DbxRequestConfig mockConfig = CONFIG.copy()
            .withHttpRequestor(mockRequestor)
            .build();

        // PKCE flow should keep the same instance in both authorize and finish call.
        DbxPKCEWebAuth dbxPKCEWebAuth = new DbxPKCEWebAuth(mockConfig, APP);
        dbxPKCEWebAuth.authorize(request);
        assertThrows(BadRequestException.class, new ThrowingRunnable() {
            private DbxPKCEWebAuth dbxPKCEWebAuth;
            private String code;
            ThrowingRunnable load(DbxPKCEWebAuth dbxPKCEWebAuth, String code) {
                this.dbxPKCEWebAuth = dbxPKCEWebAuth;
                this.code = code;
                return this;
            }
            @Override
            public void run() throws Throwable {
                dbxPKCEWebAuth.finishFromCode(code);
            }
        }.load(dbxPKCEWebAuth, code));
    }
}
