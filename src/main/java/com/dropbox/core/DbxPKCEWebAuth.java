package com.dropbox.core;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.DbxRawClientV2;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import static com.dropbox.core.util.StringUtil.urlSafeBase64Encode;

/**
 *
 *
 * This class does the OAuth2 "authorization code" flow with Proof Key for Code Exchange(PKCE).
 *
 * PKCE allows "authorization code" flow without "client_secret". It enables "native
 * application", which is ensafe to hardcode client_secret in code, to use "authorization
 * code". If you application has a server, please use regular {@link DbxWebAuth} instead.
 *
 * PKCE is more secure than "token" flow. If authorization code is compromised during
 * transmission, it can't be used to exchange for access token without random generated
 * code_verifier, which is stored inside SDK.
 *
 * DbxPKCEWebAuth and {@link DbxWebAuth} has the same interface and slightly different behavior:
 * <ol>
 *     <li>The constructor should take {@link DbxAppInfo} without app secret.</li>
 *     <li>Two step of OAuth2: {@link #authorize(DbxWebAuth.Request)} and
 *     {@link #finishFromRedirect(String, DbxSessionStore, Map)}, should be called on the same
 *     object.</li>
 * </ol>
 *
 * @see <a href="https://tools.ietf.org/html/rfc7636">https://tools.ietf.org/html/rfc7636</a> and
 * new <a href="https://www.dropbox.com/lp/developers/reference/oauth-guide.html">dropbox oauth guide</a>
 */
public class DbxPKCEWebAuth {
    private final DbxRequestConfig requestConfig;
    private final DbxAppInfo appInfo;
    private final DbxWebAuth dbxWebAuth;
    private final DbxPKCEManager dbxPKCEManager;
    private boolean started;
    private boolean consumed;

    /**
     * Creates a new instance that will perform the OAuth2 PKCE authorization flow using the given
     * OAuth request configuration.
     *
     * @param requestConfig HTTP request configuration, never {@code null}.
     * @param appInfo Your application's Dropbox API information (the app key), never {@code null}.
     *
     * @throws IllegalStateException if appInfo contains app secret.
     */
    public DbxPKCEWebAuth(DbxRequestConfig requestConfig, DbxAppInfo appInfo) {
        if (appInfo.hasSecret()) {
            throw new IllegalStateException("PKCE cdoe flow doesn't require app secret, if you " +
                "decide to embed it in your app, please use regular DbxWebAuth instead.");
        }

        this.requestConfig = requestConfig;
        this.appInfo = appInfo;
        this.dbxWebAuth = new DbxWebAuth(requestConfig, appInfo);
        this.dbxPKCEManager = new DbxPKCEManager();
        this.started = false;
        this.consumed = false;
    }

    /**
     * Starts authorization and returns an "authorization URL" on the Dropbox website that let
     * the user grant your app access to their Dropbox account.
     *
     * <p> If a redirect URI was specified ({@link DbxWebAuth.Request.Builder#withRedirectUri}). The
     * redirect URI should bring user back to your app on end device. Call {@link
     * #finishFromRedirect} using the same {@link DbxPKCEWebAuth} instance with the query
     * parameters received from the redirect.
     *
     * <p> If no redirect URI was specified ({@link DbxWebAuth.Request.Builder#withNoRedirect}),
     * then users who grant access will be shown an "authorization code". The user must copy/paste the
     * authorization code back into your app, at which point you can call {@link
     * #finishFromCode(String)} with the same {@link DbxPKCEWebAuth} instance from to get an access
     * token.
     *
     * @param request OAuth 2.0 web-based authorization flow request configuration
     *
     * @return Authorization URL of website user can use to authorize your app.
     *
     */
    public String authorize(DbxWebAuth.Request request) {
        if (consumed) {
            throw new IllegalStateException("This DbxPKCEWebAuth instance has been consumed " +
                "already. To start a new PKCE OAuth flow, please create a new instance.");
        }

        this.started = true;

        Map<String, String> pkceParams = new HashMap<String, String>();
        pkceParams.put("code_challenge", dbxPKCEManager.getCodeChallenge());
        pkceParams.put("code_challenge_method", DbxPKCEManager.CODE_CHALLENGE_METHODS);

        return dbxWebAuth.authorizeImpl(request, pkceParams);
    }

    /**
     * Call this after the user has visited the authorizaton URL and copy/pasted the authorization
     * code that Dropbox gave them, with the SAME {@link DbxPKCEWebAuth} instance that generated
     * the authorization URL.
     *
     * @throws DbxException if the instance is not the same one used to generate authorization
     * URL, or if an error occurs communicating with Dropbox.
     * @see DbxWebAuth#finishFromCode(String)
     */
    public DbxAuthFinish finishFromCode(String code) throws DbxException {
        return finish(code, null, null);
    }

    /**
     * Call this after the user has visited the authorizaton URL and Dropbox has redirected them
     * back to your native app, with the SAME {@link DbxPKCEWebAuth} instance that generated
     * the authorization URL.
     *
     * @throws BadRequestException If the redirect request is missing required query parameters,
     * contains duplicate parameters, or includes mutually exclusive parameters (e.g. {@code
     * "error"} and {@code "code"}).
     * @throws DbxWebAuth.BadStateException If the CSRF token retrieved from {@code sessionStore}
     * is {@code null} or malformed.
     * @throws DbxWebAuth.CsrfException If the CSRF token passed in {@code params} does not match
     * the CSRF token from {@code sessionStore}. This implies the redirect request may be forged.
     * @throws DbxWebAuth.NotApprovedException If the user chose to deny the authorization request.
     * @throws DbxWebAuth.ProviderException If an OAuth2 error response besides {@code
     * "access_denied"} is set.
     * @throws DbxException if the instance is not the same one used to generate authorization
     * URL, or if an error occurs communicating with Dropbox.
     */
    public DbxAuthFinish finishFromRedirect(String redirectUri,
                                            DbxSessionStore sessionStore,
                                            Map<String, String[]> params)
        throws DbxException, DbxWebAuth.BadRequestException, DbxWebAuth.BadStateException,
        DbxWebAuth.CsrfException, DbxWebAuth.NotApprovedException, DbxWebAuth.ProviderException {

        String strippedState = DbxWebAuth.validateRedirectUri(redirectUri, sessionStore, params);
        String code = DbxWebAuth.getParam(params, "code");
        return finish(code, redirectUri, strippedState);
    }

    DbxAuthFinish finish(String code, String redirectUri, final String state) throws DbxException {
        if (code == null) throw new NullPointerException("code");
        if (!this.started) {
            throw new IllegalStateException("Must initialize the PKCE flow by calling authorize " +
                    "first.");
        }

        if (this.consumed) {
            throw new IllegalStateException("This DbxPKCEWebAuth instance has been consumed " +
                "already. To start a new PKCE OAuth flow, please create a new instance.");
        }



        DbxAuthFinish authFinish = dbxPKCEManager.makeTokenRequest(
            requestConfig, code, appInfo.getKey(), redirectUri, appInfo.getHost()
        );

        this.consumed = true;
        return authFinish.withUrlState(state);
    }

}
