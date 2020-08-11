package com.dropbox.core;

import static com.dropbox.core.util.StringUtil.jq;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.util.StringUtil;
import com.dropbox.core.v2.DbxRawClientV2;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * Does the OAuth 2 "authorization code" flow.  (This SDK does not support the "token" flow.)
 *
 * <p> Eventually yields an access token, which can be used with {@link
 * com.dropbox.core.v2.DbxClientV2} to make Dropbox API calls.  You typically only need to do this
 * for a user when they first use your application.  Once you have an access token for that user, it
 * remains valid for years.
 *
 * <h1> Redirect example </h1>
 * <p> One-time setup typically done on server initialization: </p>
 * <pre>
 *     {@link DbxRequestConfig} requestConfig = new DbxRequestConfig("text-edit/0.1");
 *     {@link DbxAppInfo} appInfo = DbxAppInfo.Reader.readFromFile("api.app");
 *     DbxWebAuth auth = new DbxWebAuth(requestConfig, appInfo);
 *
 *     String redirectUri = "http://my-server.com/dropbox-auth-finish";
 * </pre>
 *
 * <h2> Part 1 </h2>
 * <p> Handler for "http://my-server.com/dropbox-auth-start": </p>
 * <pre>
 *     {@link javax.servlet.http.HttpServletRequest} request = ...
 *     {@link javax.servlet.http.HttpServletResponse} response = ...
 *
 *     <b>// Select a spot in the session for DbxWebAuth to store the CSRF token.</b>
 *     {@link javax.servlet.http.HttpSession} session = request.getSession(true);
 *     String sessionKey = "dropbox-auth-csrf-token";
 *     {@link DbxSessionStore} csrfTokenStore = new DbxStandardSessionStore(session, sessionKey);
 *
 *     <b>// Build an auth request</b>
 *     {@link DbxWebAuth.Request} authRequest = DbxWebAuth.newRequestBuilder()
 *         .withRedirectUri(redirectUri, csrfTokenStore)
 *         .build();
 *
 *     <b>// Start authorization.</b>
 *     String authorizePageUrl = auth.{@link #authorize authorize}(authRequest);
 *
 *     <b>// Redirect the user to the Dropbox website so they can approve our application.</b>
 *     <b>// The Dropbox website will send them back to "http://my-server.com/dropbox-auth-finish"</b>
 *     <b>// when they're done.</b>
 *     response.sendRedirect(authorizePageUrl);
 * </pre>
 *
 * <h2> Part 2 </h2>
 * <p> Handler for "http://my-server.com/dropbox-auth-finish": </p>
 * <pre>
 *     {@link javax.servlet.http.HttpServletRequest} request = ...
 *     {@link javax.servlet.http.HttpServletResponse} response = ...
 *
 *     <b>// Fetch the session to verify our CSRF token</b>
 *     {@link javax.servlet.http.HttpSession} session = request.getSession(true);
 *     String sessionKey = "dropbox-auth-csrf-token";
 *     {@link DbxSessionStore} csrfTokenStore = new DbxStandardSessionStore(session, sessionKey);
 *     String redirectUri = "http://my-server.com/dropbox-auth-finish";
 *
 *     {@link DbxAuthFinish} authFinish;
 *     try {
 *         authFinish = auth.{@link #finishFromRedirect finishFromRedirect}(redirectUri, csrfTokenStore, request.getParameterMap());
 *     } catch (DbxWebAuth.BadRequestException ex) {
 *         log("On /dropbox-auth-finish: Bad request: " + ex.getMessage());
 *         response.sendError(400);
 *         return;
 *     } catch (DbxWebAuth.BadStateException ex) {
 *         // Send them back to the start of the auth flow.
 *         response.sendRedirect("http://my-server.com/dropbox-auth-start");
 *         return;
 *     } catch (DbxWebAuth.CsrfException ex) {
 *         log("On /dropbox-auth-finish: CSRF mismatch: " + ex.getMessage());
 *         response.sendError(403, "Forbidden.");
 *         return;
 *     } catch (DbxWebAuth.NotApprovedException ex) {
 *         <b>// When Dropbox asked "Do you want to allow this app to access your</b>
 *         <b>// Dropbox account?", the user clicked "No".</b>
 *         ...
 *         return;
 *     } catch (DbxWebAuth.ProviderException ex) {
 *         log("On /dropbox-auth-finish: Auth failed: " + ex.getMessage());
 *         response.sendError(503, "Error communicating with Dropbox.");
 *         return;
 *     } catch (DbxException ex) {
 *         log("On /dropbox-auth-finish: Error getting token: " + ex.getMessage());
 *         response.sendError(503, "Error communicating with Dropbox.");
 *         return;
 *     }
 *     String accessToken = authFinish.getAccessToken();
 *
 *     <b>// Save the access token somewhere (probably in your database) so you</b>
 *     <b>// don't need to send the user through the authorization process again.</b>
 *     ...
 *
 *     <b>// Now use the access token to make Dropbox API calls.</b>
 *     {@link com.dropbox.core.v2.DbxClientV2} client = new DbxClientV2(requestConfig, accessToken);
 *     ...
 * </pre>
 *
 * <h1> No Redirect Example </h1>
 *
 * <pre>
 *     {@link DbxRequestConfig} requestConfig = new DbxRequestConfig("text-edit/0.1");
 *     {@link DbxAppInfo} appInfo = DbxAppInfo.Reader.readFromFile("api.app");
 *     DbxWebAuth auth = new DbxWebAuth(requestConfig, appInfo);
 *
 *     {@link DbxWebAuth.Request} authRequest = DbxWebAuth.newRequestBuilder()
 *         .withNoRedirect()
 *         .build();
 *     String authorizeUrl = auth.authorize(authRequest);
 *     System.out.println("1. Go to " + authorizeUrl);
 *     System.out.println("2. Click \"Allow\" (you might have to log in first).");
 *     System.out.println("3. Copy the authorization code.");
 *     System.out.print("Enter the authorization code here: ");
 *
 *     String code = System.console().readLine();
 *     if (code != null) {
 *         code = code.trim();
 *         {@link DbxAuthFinish} authFinish = webAuth.{@link #finishFromCode finishFromCode}(code);
 *         {@link com.dropbox.core.v2.DbxClientV2} client = new DbxClientV2(requestConfig, authFinish.getAccessToken());
 *     }
 * </pre>
 */
public class DbxWebAuth {
    private static final SecureRandom RAND = new SecureRandom();
    private static final int CSRF_BYTES_SIZE = 16;
    private static final int CSRF_STRING_SIZE = StringUtil.urlSafeBase64Encode(new byte[CSRF_BYTES_SIZE]).length();

    /** Role representing the team account associated with a user. Used by {@link Request.Builder#withRequireRole}. */
    public static final String ROLE_WORK = "work";
    /** Role representing the personal account associated with a user. Used by {@link Request.Builder#withRequireRole}. */
    public static final String ROLE_PERSONAL = "personal";

    final DbxRequestConfig requestConfig;
    final DbxAppInfo appInfo;
    final Request deprecatedRequest;

    /**
     * Creates a new instance that will perform the OAuth2 authorization flow using a redirect URI.
     *
     * @param requestConfig HTTP request configuration, never {@code null}.
     * @param appInfo Your application's Dropbox API information (the app key and secret), never
     * {@code nulL}.
     * @param redirectUri Where to redirect the user after authorization has completed, never {@code null}.
     * @param sessionStore Session store to use for storing CSRF nonces across requests, never {@code null}.
     *
     * @deprecated use {@link #DbxWebAuth(DbxRequestConfig,DbxAppInfo)} and {@link #authorize}
     * instead
     */
    @Deprecated
    public DbxWebAuth(DbxRequestConfig requestConfig, DbxAppInfo appInfo, String redirectUri, DbxSessionStore sessionStore) {
        if (requestConfig == null) throw new NullPointerException("requestConfig");
        if (appInfo == null) throw new NullPointerException("appInfo");


        this.requestConfig = requestConfig;
        this.appInfo = appInfo;
        this.deprecatedRequest = newRequestBuilder()
            .withRedirectUri(redirectUri, sessionStore)
            .build();
    }

    /**
     * Creates a new instance that will perform the OAuth2 authorization flow using the given OAuth
     * request configuration.
     *
     * @param requestConfig HTTP request configuration, never {@code null}.
     * @param appInfo Your application's Dropbox API information (the app key and secret), never
     * {@code null}.
     */
    public DbxWebAuth(DbxRequestConfig requestConfig, DbxAppInfo appInfo) {
        if (requestConfig == null) throw new NullPointerException("requestConfig");
        if (appInfo == null) throw new NullPointerException("appInfo");

        this.requestConfig = requestConfig;
        this.appInfo = appInfo;
        this.deprecatedRequest = null;
    }

    /**
     * Starts authorization and returns a "authorization URL" on the Dropbox website that gives the
     * lets the user grant your app access to their Dropbox account.
     *
     * <p> If a redirect URI was specified, then users will be redirected to the redirect URI after
     * completing the authorization flow. Call {@link #finishFromRedirect finishFromRedirect(..)} with the query parameters
     * received from the redirect.
     *
     * <p> If no redirect URI was specified, then users who grant access will be shown an
     * "authorization code". The user must copy/paste the authorization code back into your app, at
     * which point you can call {@link #finishFromCode(String)} to get an access token.
     *
     * @param urlState additional state to add to the flow that will be returned upon redirect
     *
     * @throws IllegalArgumentException if urlState exceeds maximum size of 476 bytes
     * @throws IllegalStateException if this instance was not created using the deprecated {@link #DbxWebAuth(DbxRequestConfig,DbxAppInfo,String,DbxSessionStore)} constructor
     *
     * @return Authorization URL of website user can use to authorize your app.
     *
     * @deprecated use {@link #DbxWebAuth(DbxRequestConfig,DbxAppInfo)} and {@link #authorize}
     * instead.
     */
    @Deprecated
    public String start(/*@Nullable*/String urlState) {
        if (deprecatedRequest == null) {
            throw new IllegalStateException("Must use DbxWebAuth.authorize instead.");
        }

        return authorizeImpl(
            deprecatedRequest.copy()
                .withState(urlState)
                .build()
        );
    }

    /**
     * Starts authorization and returns an "authorization URL" on the Dropbox website that
     * let the user grant your app access to their Dropbox account.
     *
     * <p> If a redirect URI was specified ({@link Request.Builder#withRedirectUri}), then users
     * will be redirected to the redirect URI after completing the authorization flow. Call {@link
     * #finishFromRedirect} with the query parameters received from the redirect.
     *
     * <p> If no redirect URI was specified ({@link Request.Builder#withNoRedirect}), then users who
     * grant access will be shown an "authorization code". The user must copy/paste the
     * authorization code back into your app, at which point you can call {@link
     * #finishFromCode(String)} to get an access token.
     *
     * @param request OAuth 2.0 web-based authorization flow request configuration
     *
     * @return Authorization URL of website user can use to authorize your app.
     *
     * @throws IllegalStateException if this {@link DbxWebAuth} instance was created using the
     * deprecated {@link #DbxWebAuth(DbxRequestConfig,DbxAppInfo,String,DbxSessionStore)}
     * constructor, or if this (@link DbxWebAuth} instance was created with {@link DbxAppInfo}
     * without app secret.
     */
    public String authorize(Request request) {
        if (deprecatedRequest != null) {
            throw new IllegalStateException("Must create this instance using DbxWebAuth(DbxRequestConfig,DbxAppInfo) to call this method.");
        }

        if (!appInfo.hasSecret()) {
            throw new IllegalStateException("For native apps, please use DbxPKCEWebAuth");
        }

        return authorizeImpl(request);
    }

    private String authorizeImpl(Request request) {
        return authorizeImpl(request, null);
    }

    String authorizeImpl(Request request, Map<String, String> pkceParams) {
        Map<String, String> params = new HashMap<String, String>();

        params.put("client_id", appInfo.getKey());
        params.put("response_type", "code");

        if (request.redirectUri != null) {
            params.put("redirect_uri", request.redirectUri);
            params.put("state", appendCsrfToken(request));
        }

        if (request.requireRole != null) {
            params.put("require_role", request.requireRole);
        }
        if (request.forceReapprove != null) {
            params.put("force_reapprove", Boolean.toString(request.forceReapprove).toLowerCase());
        }
        if (request.disableSignup != null) {
            params.put("disable_signup", Boolean.toString(request.disableSignup).toLowerCase());
        }
        if (request.tokenAccessType != null) {
            params.put("token_access_type", request.tokenAccessType.toString());
        }

        if (request.scope != null) {
            params.put("scope", request.scope);
        }

        if (request.includeGrantedScopes != null) {
            params.put("include_granted_scopes", request.includeGrantedScopes.toString());
        }

        if (pkceParams != null) {
            for (String key: pkceParams.keySet()) {
                params.put(key, pkceParams.get(key));
            }
        }

        return DbxRequestUtil.buildUrlWithParams(
            requestConfig.getUserLocale(),
            appInfo.getHost().getWeb(),
            "oauth2/authorize",
            DbxRequestUtil.toParamsArray(params)
        );
    }

    /**
     * Call this after the user has visited the authorizaton URL and copy/pasted the authorization
     * code that Dropbox gave them.
     *
     * @param code The authorization code shown to the user when they clicked "Allow" on the
     *    authorization, page on the Dropbox website, never {@code null}.
     *
     * @throws DbxException if an error occurs communicating with Dropbox.
     */
    public DbxAuthFinish finishFromCode(String code) throws DbxException {
        return finish(code);
    }

    /**
     * Call this after the user has visited the authorizaton URL with a redirectUrl and copy/pasted
     * the authorization code that Dropbox gave them.
     *
     * @param code The authorization code shown to the user when they clicked "Allow" on the
     *    authorization, page on the Dropbox website, never {@code null}.
     * @param redirectUri The original redirect URI used by {@link #authorize}, never {@code null}.
     *
     * @throws DbxException if an error occurs communicating with Dropbox.
     */
    public DbxAuthFinish finishFromCode(String code, String redirectUri) throws DbxException {
        return finish(code, redirectUri, null);
    }

    /**
     * Call this after the user has visited the authorizaton URL and Dropbox has redirected them
     * back to you at the redirect URI.
     *
     * @param redirectUri The original redirect URI used by {@link #authorize}, never {@code null}.
     * @param sessionStore Session store used by {@link #authorize} to store CSRF tokens, never
     * {@code null}.
     * @param params The query parameters on the GET request to your redirect URI, never {@code
     * null}.
     *
     * @throws BadRequestException If the redirect request is missing required query parameters,
     * contains duplicate parameters, or includes mutually exclusive parameters (e.g. {@code
     * "error"} and {@code "code"}).
     * @throws BadStateException If the CSRF token retrieved from {@code sessionStore} is {@code
     * null} or malformed.
     * @throws CsrfException If the CSRF token passed in {@code params} does not match the CSRF
     * token from {@code sessionStore}. This implies the redirect request may be forged.
     * @throws NotApprovedException If the user chose to deny the authorization request.
     * @throws ProviderException If an OAuth2 error response besides {@code "access_denied"} is
     * set.
     * @throws DbxException If an error occurs communicating with Dropbox.
     */
    public DbxAuthFinish finishFromRedirect(String redirectUri,
                                            DbxSessionStore sessionStore,
                                            Map<String, String[]> params)
        throws DbxException, BadRequestException, BadStateException, CsrfException, NotApprovedException, ProviderException {

        String strippedState = validateRedirectUri(redirectUri, sessionStore, params);
        String code = getParam(params, "code");
        return finish(code, redirectUri, strippedState);
    }

    static String validateRedirectUri(String redirectUri, DbxSessionStore sessionStore, Map<String, String[]> params)
        throws BadRequestException, BadStateException, CsrfException, NotApprovedException, ProviderException
    {
        if (redirectUri == null) throw new NullPointerException("redirectUri");
        if (sessionStore == null) throw new NullPointerException("sessionStore");
        if (params == null) throw new NullPointerException("params");

        String state = getParam(params, "state");
        if (state == null) {
            throw new BadRequestException("Missing required parameter: \"state\".");
        }

        String error = getParam(params, "error");
        String code = getParam(params, "code");
        String errorDescription = getParam(params, "error_description");

        if (code == null && error == null) {
            throw new BadRequestException("Missing both \"code\" and \"error\".");
        }
        if (code != null && error != null) {
            throw new BadRequestException("Both \"code\" and \"error\" are set.");
        }
        if (code != null && errorDescription != null) {
            throw new BadRequestException("Both \"code\" and \"error_description\" are set.");
        }

        state = verifyAndStripCsrfToken(state, sessionStore);

        if (error != null) {
            if (error.equals("access_denied")) {
                // User clicked "Deny"
                String exceptionMessage = errorDescription == null ?
                    "No additional description from Dropbox" :
                    "Additional description from Dropbox: " + errorDescription;
                throw new NotApprovedException(exceptionMessage);
            } else {
                // All other errors
                String exceptionMessage = errorDescription == null ?
                    error :
                    String.format("%s: %s", error, errorDescription);
                throw new ProviderException(exceptionMessage);
            }
        }

        return state;
    }

    private DbxAuthFinish finish(String code) throws DbxException {
        return finish(code, null, null);
    }

    DbxAuthFinish finish(String code, String redirectUri, final String state) throws
            DbxException {
        if (code == null) throw new NullPointerException("code");
        if (!appInfo.hasSecret()) {
            throw new IllegalStateException("For native apps, please use DbxPKCEWebAuth");
        }

        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "authorization_code");
        params.put("code", code);
        params.put("locale", requestConfig.getUserLocale());

        if (redirectUri != null) {
            params.put("redirect_uri", redirectUri);
        }

        List<HttpRequestor.Header> headers = new ArrayList<HttpRequestor.Header>();
        DbxRequestUtil.addBasicAuthHeader(headers, appInfo.getKey(), appInfo.getSecret());

        return DbxRequestUtil.doPostNoAuth(
            requestConfig,
            DbxRawClientV2.USER_AGENT_ID,
            appInfo.getHost().getApi(),
            "oauth2/token",
            DbxRequestUtil.toParamsArray(params),
            headers,
            new DbxRequestUtil.ResponseHandler<DbxAuthFinish>() {
                @Override
                public DbxAuthFinish handle(HttpRequestor.Response response) throws DbxException {
                    if (response.getStatusCode() != 200) {
                        throw DbxRequestUtil.unexpectedStatus(response);
                    }
                    return DbxRequestUtil.readJsonFromResponse(DbxAuthFinish.Reader, response)
                        .withUrlState(state);
                }
            }
        );
    }

    /**
     * Call this after the user has visited the authorizaton URL and Dropbox has redirected them
     * back to you (using the {@code redirectUri} you passed in to {@link #start}.
     *
     * @param queryParams The query parameters on the GET request to your {@code redirectUri}.
     *
     * @throws IllegalStateException if this instance was not created using the deprecated {@link #DbxWebAuth(DbxRequestConfig,DbxAppInfo,String,DbxSessionStore)} constructor
     * @throws BadRequestException If the redirect request is missing required query parameters,
     * contains duplicate parameters, or includes mutually exclusive parameters (e.g. {@code
     * "error"} and {@code "code"})
     * @throws BadStateException If the CSRF token retrieved from {@code sessionStore} is missing or
     * malformed. Missing tokens often imply the user session has expired.
     * @throws CsrfException If the CSRF token passed in {@code params} does not match the CSRF
     * token from {@code sessionStore}. This implies the redirect request may be forged.
     * @throws NotApprovedException If the user chose to deny the authorization request
     * @throws ProviderException If an OAuth 2.0 error response besides {@code "access_denied"} is
     * set.
     * @throws DbxException If an error occurs communicating with Dropbox
     *
     * @deprecated use {@link #finishFromRedirect finishFromRedirect(..)} instead.
     */
    @Deprecated
    public DbxAuthFinish finish(Map<String, String[]> queryParams)
        throws DbxException, BadRequestException, BadStateException, CsrfException, NotApprovedException, ProviderException {
        if (deprecatedRequest == null) {
            throw new IllegalStateException("Must use DbxWebAuth.finishFromRedirect(..) instead.");
        }
        return finishFromRedirect(
            deprecatedRequest.redirectUri,
            deprecatedRequest.sessionStore,
            queryParams
        );
    }

    private static String appendCsrfToken(Request request) {
        // add a CSRF nonce for security
        byte[] csrf = new byte[CSRF_BYTES_SIZE];
        RAND.nextBytes(csrf);
        String prefix = StringUtil.urlSafeBase64Encode(csrf);

        if (prefix.length() != CSRF_STRING_SIZE) {
            throw new AssertionError("unexpected CSRF token length: " + prefix.length());
        }

        if (request.sessionStore != null) {
            request.sessionStore.set(prefix);
        }

        if (request.state == null) {
            return prefix;
        } else {
            String combined = prefix + request.state;
            if (combined.length() > Request.MAX_STATE_SIZE) {
                throw new AssertionError("unexpected combined state length: " + combined.length());
            }
            return combined;
        }
    }

    private static String verifyAndStripCsrfToken(String state, DbxSessionStore sessionStore)
        throws CsrfException, BadStateException {
        String expected = sessionStore.get();
        if (expected == null) {
            throw new BadStateException("No CSRF Token loaded from session store.");
        }
        if (expected.length() < CSRF_STRING_SIZE) {
            throw new BadStateException("Token retrieved from session store is too small: " + expected);
        }

        if (state.length() < CSRF_STRING_SIZE) {
            throw new CsrfException("Token too small: " + state);
        }

        String actual = state.substring(0, CSRF_STRING_SIZE);
        if (!StringUtil.secureStringEquals(expected, actual)) {
            throw new CsrfException("expecting " + jq(expected) + ", got " + jq(actual));
        }

        String stripped = state.substring(CSRF_STRING_SIZE, state.length());

        sessionStore.clear();

        return stripped.isEmpty() ? null : stripped;
    }

    static /*@Nullable*/String getParam(Map<String,String[]> params, String name) throws BadRequestException {
        String[] v = params.get(name);

        if (v == null) {
            return null;
        } else if (v.length == 0) {
            throw new IllegalArgumentException("Parameter \"" + name + "\" missing value.");
        } else if (v.length == 1) {
            return v[0];
        } else {
            throw new BadRequestException("multiple occurrences of \"" + name + "\" parameter");
        }
    }

    /**
     * The base class for authorization redirect errors.  You should catch each subclass
     * individually.
     */
    public static abstract class Exception extends java.lang.Exception {
        private static final long serialVersionUID = 0L;
        public Exception(String message) { super(message); }
    }

    /**
     * Thrown when the parameters passed to your redirect URI are not well-formed.
     *
     * <p>
     * IMPORTANT: The exception's message must not be shown the the user, but may be logged.
     * </p>
     *
     * <p>
     * The recommended action is to show an HTTP 400 error page.
     * </p>
     */
    public static final class BadRequestException extends Exception {
        private static final long serialVersionUID = 0L;
        public BadRequestException(String message) { super(message); }
    }

    /**
     * Thrown if all the parameters to your redirect URI are well-formed, but there's no CSRF token
     * in the session.  This probably means that the user's session expired and they must restart
     * the OAuth 2 process.
     *
     * <p>
     * IMPORTANT: The exception's message must not be shown the the user, but may be logged.
     * </p>
     *
     * <p>
     * The recommended action is to redirect the user's browser to try the approval process again.
     * </p>
     */
    public static final class BadStateException extends Exception {
        private static final long serialVersionUID = 0L;
        public BadStateException(String message) { super(message); }
    }

    /**
     * Thrown if the given 'state' parameter doesn't contain the expected CSRF token.  This request
     * should be blocked to prevent CSRF attacks.
     *
     * <p>
     * IMPORTANT: The exception's message must not be shown the the user, but may be logged.
     * </p>
     *
     * <p>
     * The recommended action is to show an HTTP 403 error page.
     * </p>
     */
    public static final class CsrfException extends Exception {
        private static final long serialVersionUID = 0L;
        public CsrfException(String message) { super(message); }
    }

    /**
     * Thrown when Dropbox tells us that the user chose not to grant your app access to their
     * Dropbox account (i.e. the user clicked the "Deny" button).
     *
     * <p>
     * IMPORTANT: The exception's message must not be shown the the user, but may be logged.
     * </p>
     */
    public static final class NotApprovedException extends Exception {
        private static final long serialVersionUID = 0L;
        public NotApprovedException(String message) { super(message); }
    }

    /**
     * Thrown when Dropbox tells us that some other error occurred in the authorization process.
     *
     * <p>
     * IMPORTANT: The exception's message should not be shown the the user, but should be logged.
     * </p>
     */
    public static final class ProviderException extends Exception {
        private static final long serialVersionUID = 0L;
        public ProviderException(String message) { super(message); }
    }

    /**
     * Returns a new request builder with default values (e.g. no redirect).
     *
     * @return new request builder with default values
     */
    public static Request.Builder newRequestBuilder() {
        return Request.newBuilder();
    }

    /**
     * OAuth web-based authorization flow request.
     *
     * Used by {@link #authorize} for initiating OAuth web-based authorization flows.
     */
    public static final class Request {
        private static final Charset UTF8 = Charset.forName("UTF-8");
        private static final int MAX_STATE_SIZE = 500;

        private final String redirectUri;
        private final String state;
        private final String requireRole;
        private final Boolean forceReapprove;
        private final Boolean disableSignup;
        private final DbxSessionStore sessionStore;
        private final TokenAccessType tokenAccessType;
        private final String scope;
        private final IncludeGrantedScopes includeGrantedScopes;


        private Request(String redirectUri,
                        String state,
                        String requireRole,
                        Boolean forceReapprove,
                        Boolean disableSignup,
                        DbxSessionStore sessionStore,
                        TokenAccessType tokenAccessType,
                        String scope,
                        IncludeGrantedScopes includeGrantedScopes) {
            this.redirectUri = redirectUri;
            this.state = state;
            this.requireRole = requireRole;
            this.forceReapprove = forceReapprove;
            this.disableSignup = disableSignup;
            this.sessionStore = sessionStore;
            this.tokenAccessType = tokenAccessType;
            this.scope = scope;
            this.includeGrantedScopes = includeGrantedScopes;
        }

        /**
         * Returns a copy of this request.
         *
         * @return copy of this request
         */
        public Builder copy() {
            return new Builder(
                    redirectUri,
                    state,
                    requireRole,
                    forceReapprove,
                    disableSignup,
                    sessionStore,
                    tokenAccessType,
                    scope,
                includeGrantedScopes
                );
        }

        /**
         * Returns a new request builder with default values (e.g. no redirect).
         *
         * @return new request builder with default values
         */
        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Builder for OAuth2 requests. Use this builder to configure the OAuth authorization flow.
         */
        public static final class Builder {
            private String redirectUri;
            private String state;
            private String requireRole;
            private Boolean forceReapprove;
            private Boolean disableSignup;
            private DbxSessionStore sessionStore;
            private TokenAccessType tokenAccessType;
            private String scope;
            private IncludeGrantedScopes includeGrantedScopes;

            private Builder() {
                this(null, null, null, null, null, null, null, null, null);
            }

            private Builder(String redirectUri,
                            String state,
                            String requireRole,
                            Boolean forceReapprove,
                            Boolean disableSignup,
                            DbxSessionStore sessionStore,
                            TokenAccessType tokenAccessType,
                            String scope,
                            IncludeGrantedScopes includeGrantedScopes) {
                this.redirectUri = redirectUri;
                this.state = state;
                this.requireRole = requireRole;
                this.forceReapprove = forceReapprove;
                this.disableSignup = disableSignup;
                this.sessionStore = sessionStore;
                this.tokenAccessType = tokenAccessType;
                this.scope = scope;
                this.includeGrantedScopes = includeGrantedScopes;
            }

            /**
             * Do not redirect the user after authorization has completed (default).
             *
             * <p> After a user authorizes the app using the authorization URL, a code will be
             * displayed that they must copy and paste into your app. If you want users to be
             * redirected after authorization back to your app, use {@link #withRedirectUri}
             * instead. Websites should always provide a redirect URI.
             *
             * @return this builder
             */
            public Builder withNoRedirect() {
                this.redirectUri = null;
                this.sessionStore = null;
                return this;
            }

            /**
             * Where to redirect the user after authorization has completed.
             *
             * <p> This must be the exact URI registered in the <a href="https://www.dropbox.com/developers/apps">App Console</a>;
             * even {@code "localhost"} must be listed if it is used for testing. All redirect URIs must be
             * HTTPS except for localhost URIs. If the redirect URI is omitted, the code will be
             * presented directly to the user and they will be invited to enter the information in
             * your app.
             *
             * <p> The given session store will be used for storing the Cross-Site Request Forgery
             * (CSRF) nonce generated during the authorization flow. To prevent CSRF attacks, {@link
             * DbxWebAuth} appends a nonce to each authorization request. When the authorization
             * flow is complete, the returned nonce is compared with the one in the store to ensure
             * the response is valid. A session store <b>must</b> be specified if a redirect URI is
             * set.
             *
             * @param redirectUri URI to redirect authorization response, never {@code null}.
             * @param sessionStore Session store to use for storing CSRF nonces across requests, never {@code null}.
             *
             * @return this builder
             *
             * @throws NullPointerException if either redirectUri or sessionStore is {@code null}
             */
            public Builder withRedirectUri(String redirectUri, DbxSessionStore sessionStore) {
                if (redirectUri == null) throw new NullPointerException("redirectUri");
                if (sessionStore == null) throw new NullPointerException("sessionStore");

                this.redirectUri = redirectUri;
                this.sessionStore = sessionStore;

                return this;
            }

            /**
             * Up to 476 bytes of arbitrary data that will be passed back to your redirect URI.
             *
             * <p> Note that {@link DbxWebAuth} will always automatically append a nonce to the
             * state to protect against cross-site request forgery. This is true even if no state is
             * provided.
             *
             * <p> State should only be provided if a redirect URI is provided as well, otherwise
             * {@link #build} will throw an {@link IllegalStateException}.
             *
             * @param state additional state to pass back to the redirect URI, or {@code null} to
             * pass back no additional state.
             *
             * @return this builder
             *
             * @throws IllegalArgumentException if state is greater than 476 bytes
             */
            public Builder withState(String state) {
                if (state != null && (state.getBytes(UTF8).length + CSRF_STRING_SIZE) > MAX_STATE_SIZE) {
                    throw new IllegalArgumentException("UTF-8 encoded state cannot be greater than " + (MAX_STATE_SIZE - CSRF_STRING_SIZE) + " bytes.");
                }
                this.state = state;
                return this;
            }

            /**
             * Request the user authorize with the particular type of Dropbox account.
             *
             * If specified, the user will be asked to authorize with a particular type of Dropbox
             * account (e.g. a team account or personal account).
             *
             * @param requireRole which role should authorize this app, or {@code null} for any
             * role.
             *
             * @return this builder
             *
             * @see DbxWebAuth#ROLE_WORK
             * @see DbxWebAuth#ROLE_PERSONAL
             */
            public Builder withRequireRole(String requireRole) {
                this.requireRole = requireRole;
                return this;
            }

            /**
             * Whether or not to force the user to approve the app again if they've already done so.
             *
             * <p> If {@code false} (default), a user who has already approved the application may
             * be automatically redirected to the URI specified by {@link #withRedirectUri}. If
             * {@code true}, the user will not be automatically redirected and will have to approve
             * the app again.
             *
             * @return this builder
             *
             * @param forceReapprove whether to force a user to re-approve this app, or {@code null}
             * for default behavior
             */
            public Builder withForceReapprove(Boolean forceReapprove) {
                this.forceReapprove = forceReapprove;
                return this;
            }

            /**
             * Whether or not to allow non-users to sign up for a Dropbox account via the authorization page.
             *
             * <p> When {@code true} (default is {@code false}) users will not be able to sign up
             * for a Dropbox account via the authorization page. Instead, the authorization page
             * will show a link to install Dropbox (typically through a mobile app store). This is
             * only intended for use when necessary for compliance with App Store policies.
             *
             * @param disableSignup whether or not to allow users to sign up in the authorization
             * flow, or {@code null} for default behavior
             *
             * @return this builder
             */
            public Builder withDisableSignup(Boolean disableSignup) {
                this.disableSignup = disableSignup;
                return this;
            }

            /**
             *
             * Whether or not to include refresh token in {@link DbxAuthFinish}
             *
             * For {@link TokenAccessType#ONLINE}, auth result only contains short live token.
             * For {@link TokenAccessType#OFFLINE}, auth result includes both short live token
             * and refresh token.
             * For {@code null}, auth result is either legacy long live token or short live token
             * only, depending on the app setting.
             *
             * @param tokenAccessType Whether or not to include refresh token in
             * {@link DbxAuthFinish}
             *
             * @return this builder
             */
            public Builder withTokenAccessType(TokenAccessType tokenAccessType) {
                this.tokenAccessType = tokenAccessType;
                return this;
            }

            /**
             *
             *
             * @param scope Space-delimited scope string. Each scope corresponds to a group of
             * API endpoints. To call one API endpoint you have to obtains the scope first otherwise you
             * will get HTTP 401. Example: "account_info.read files.content.read"
             */
            public Builder withScope(Collection<String> scope) {
                if (scope != null) {
                    this.scope = StringUtil.join(scope, " ");
                }
                return this;
            }


            /**
             *
             * @param includeGrantedScopes This field is optional. If not presented, Dropbox will
             *                            give you the scopes in
             *                            {@link #withScope(Collection)}.
             *                            Otherwise Dropbox server will return a token with all
             *                            scopes user previously granted your app together with
             *                             the new scopes.
             */
            public Builder withIncludeGrantedScopes(IncludeGrantedScopes includeGrantedScopes) {
                this.includeGrantedScopes = includeGrantedScopes;
                return this;
            }

            /**
             * Returns a new OAuth {@link Request} that can be used in
             * {@link DbxWebAuth#DbxWebAuth(DbxRequestConfig,DbxAppInfo)} to authorize a user.
             *
             * @return new OAuth {@link Request} configuration.
             *
             * @throws IllegalStateException if {@link #withState} was called with a non-{@code
             * null} value, but no redirect URI was specified.
             */
            public Request build() {
                if (redirectUri == null && state != null) {
                    throw new IllegalStateException("Cannot specify a state without a redirect URI.");
                }

                if (includeGrantedScopes != null && scope == null) {
                    throw new IllegalArgumentException("If you are using includeGrantedScopes, " +
                        "you must ask for specific new scopes");
                }

                return new Request(
                        redirectUri,
                        state,
                        requireRole,
                        forceReapprove,
                        disableSignup,
                        sessionStore,
                        tokenAccessType,
                        scope,
                    includeGrantedScopes);
            }
        }
    }
}
