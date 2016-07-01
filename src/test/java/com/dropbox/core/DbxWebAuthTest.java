package com.dropbox.core;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.mockito.ArgumentCaptor;

import org.testng.annotations.Test;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.StringUtil;

public class DbxWebAuthTest {
    private static final DbxRequestConfig CONFIG = DbxRequestConfig.newBuilder("DbxWebAuthTest/1.0")
            .withUserLocaleFrom(Locale.UK)
            .build();
    private static final DbxAppInfo APP = new DbxAppInfo("test-key", "test-secret");

    @Test
    @SuppressWarnings("deprecation")
    public void testCompatibility() {
        String redirectUri = "https://localhost/compatibility/test";
        DbxSessionStore sessionStore = new SimpleSessionStore();
        String state = "test-state";

        DbxWebAuth deprecated = new DbxWebAuth(CONFIG, APP, redirectUri, sessionStore);
        DbxWebAuth auth = new DbxWebAuth(CONFIG, APP);

        String deprecatedAuthUrl = deprecated.start(state);
        String authUrl = auth.authorize(
            DbxWebAuth.newRequestBuilder()
                .withRedirectUri(redirectUri, sessionStore)
                .withState(state)
                .build()
        );

        assertAuthorizationUrls(deprecatedAuthUrl, authUrl);

        deprecatedAuthUrl = deprecated.start(null);
        authUrl = auth.authorize(
            DbxWebAuth.newRequestBuilder()
                .withRedirectUri(redirectUri, sessionStore)
                .build()
        );

        // ignores state param since it includes a CSRF nonce
        assertAuthorizationUrls(deprecatedAuthUrl, authUrl);
    }

    @Test(expectedExceptions={IllegalArgumentException.class})
    @SuppressWarnings("deprecation")
    public void testDeprecatedStateTooLarge() {
        StringBuilder state = new StringBuilder();
        for (int i = 0; i < 476; ++i) {
            state.append(".");
        }
        try {
            new DbxWebAuth(CONFIG, APP, "https://localhost", new SimpleSessionStore())
                .start(state.toString());
        } catch (IllegalArgumentException ex) {
            fail("Unable to create authorization URL with max state bytes.");
        }

        state.append("."); // one too many, should throw exception
        new DbxWebAuth(CONFIG, APP, "https://localhost", new SimpleSessionStore())
            .start(state.toString());
    }

    @Test(expectedExceptions={IllegalArgumentException.class})
    public void testStateTooLarge() {
        StringBuilder state = new StringBuilder();
        for (int i = 0; i < 476; ++i) {
            state.append(".");
        }
        try {
            DbxWebAuth.newRequestBuilder()
                .withRedirectUri("http://localhost/bar", new SimpleSessionStore())
                .withState(state.toString())
                .build();
        } catch (IllegalArgumentException ex) {
            fail("Unable to create OAuth request with max state bytes.");
        }

        state.append("."); // one too many, should throw exception
        DbxWebAuth.newRequestBuilder()
            .withRedirectUri("http://localhost/bar", new SimpleSessionStore())
            .withState(state.toString())
            .build();
    }

    @Test(expectedExceptions={IllegalStateException.class})
    @SuppressWarnings("deprecation")
    public void testDeprecatedBadStartCall() {
        new DbxWebAuth(CONFIG, APP).start("some-state");
    }

    @Test(expectedExceptions={IllegalStateException.class})
    @SuppressWarnings("deprecation")
    public void testBadStartCall() {
        new DbxWebAuth(CONFIG, APP, "http://localhost/banana", new SimpleSessionStore())
            .authorize(DbxWebAuth.newRequestBuilder().build());
    }

    @Test(expectedExceptions={IllegalStateException.class})
    public void testStateWithNoRedirect() {
        DbxWebAuth.newRequestBuilder()
            .withNoRedirect()
            .withState("foo-state")
            .build();
    }

    @Test(expectedExceptions={DbxWebAuth.CsrfException.class})
    public void testCsrfVerifyException() throws Exception {
        DbxSessionStore sessionStore = new SimpleSessionStore();
        sessionStore.set(StringUtil.urlSafeBase64Encode(new byte[16]));

        new DbxWebAuth(CONFIG, APP).finishFromRedirect(
            "http://localhost/redirect",
            sessionStore,
            params("code", "test-code",
                   "state", "_no_csrf_available_or_bad_token_|test-state")
        );
    }

    @Test
    public void testFinishWithState() throws Exception {
        String redirectUri = "http://localhost/finish/with/state/test";
        DbxSessionStore sessionStore = new SimpleSessionStore();
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

        DbxAuthFinish expected = new DbxAuthFinish("test-access-token", "test-user-id", state);
        ByteArrayOutputStream body = new ByteArrayOutputStream();
        ByteArrayInputStream responseStream = new ByteArrayInputStream(
            (
             "{" +
             "\"token_type\":\"Bearer\"" +
             ",\"access_token\":\"" + expected.getAccessToken() + "\"" +
             ",\"uid\":\"" + expected.getUserId() + "\"" +
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

    private static String extractQueryParam(URL url, String param) {
        assertNotNull(url.getQuery());
        return extractQueryParam(url.getQuery(), param);
    }

    private static String extractQueryParam(String query, String param) {
        Map<String, List<String>> params = toParamsMap(query);

        if (!params.containsKey(param)) {
            fail("Param \"" + param + "\" not found in: " + query);
            return null;
        }

        List<String> values = params.get(param);
        if (values.size() > 1) {
            fail("Param \"" + param + "\" appears more than once in: " + query);
            return null;
        }

        return values.get(0);
    }

    private static void assertAuthorizationUrls(String actual, String expected) {
        try {
            URL a = new URL(actual);
            URL b = new URL(expected);

            assertEquals(a.getProtocol(), b.getProtocol());
            assertEquals(a.getAuthority(), b.getAuthority());
            assertEquals(a.getPath(), b.getPath());
            assertEquals(a.getRef(), b.getRef());

            Map<String, List<String>> pa = toParamsMap(new URL(actual));
            Map<String, List<String>> pb = toParamsMap(new URL(actual));

            assertEquals(pa.keySet(), pb.keySet());
            for (String key : pa.keySet()) {
                if ("state".equals(key)) {
                    continue;
                }
                assertEquals(pa.get(key), pb.get(key));
            }
        } catch (Exception ex) {
            fail("Couldn't compare authorization URLs", ex);
        }
    }

    private static Map<String, String[]> params(String ... pairs) {
        if ((pairs.length % 2) != 0) {
            fail("pairs must be a multiple of 2.");
        }

        Map<String, String[]> query = new HashMap<String, String[]>();
        for (int i = 0; i < pairs.length; i += 2) {
            query.put(pairs[i], new String [] { pairs[i + 1] });
        }
        return query;
    }

    private static Map<String, List<String>> toParamsMap(URL url) {
        return toParamsMap(url.getQuery());
    }

    private static Map<String, List<String>> toParamsMap(String query) {
        try {
            String [] pairs = query.split("&");
            Map<String, List<String>> params = new HashMap<String, List<String>>(pairs.length);

            for (String pair : pairs) {
                String [] keyValue = pair.split("=", 2);
                String key = keyValue[0];
                String value = keyValue.length == 2 ? keyValue[1] : "";

                List<String> others = params.get(key);
                if (others == null) {
                    others = new ArrayList<String>();
                    params.put(key, others);
                }

                others.add(URLDecoder.decode(value, "UTF-8"));
            }

            return params;
        } catch (Exception ex) {
            fail("Couldn't build query parameter map from: " + query, ex);
            return null;
        }
    }

    private static final class SimpleSessionStore implements DbxSessionStore {
        private String token;

        public SimpleSessionStore() {
            this.token = null;
        }

        @Override
        public String get() {
            return token;
        }

        @Override
        public void set(String value) {
            this.token = value;
        }

        @Override
        public void clear() {
            this.token = null;
        }
    }
}
