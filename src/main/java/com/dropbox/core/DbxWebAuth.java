package com.dropbox.core;

import com.dropbox.core.util.StringUtil;
import com.dropbox.core.v2.DbxClientV2;

import static com.dropbox.core.util.StringUtil.jq;

import java.security.SecureRandom;
import java.util.Map;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * Does the OAuth 2 "authorization code" flow.  (This SDK does not support the "token" flow.)
 *
 * <p>
 * Eventually yields an access token, which
 * can be used with {@link DbxClientV2} to make Dropbox API calls.  You typically only need
 * to do this for a user when they first use your application.  Once you have an access token
 * for that user, it remains valid for years.
 * </p>
 *
 * <p>
 * Setup:
 * </p>
 * <pre>
 * String userLocale = ...
 * {@link DbxRequestConfig} requestConfig = new DbxRequestConfig("text-edit/0.1", userLocale);
 * {@link DbxAppInfo} appInfo = DbxAppInfo.Reader.readFromFile("api.app");
 *
 * <b>// Select a spot in the session for DbxWebAuth to store the CSRF token.</b>
 * javax.servlet.http.HttpServletRequest request = ...
 * javax.servlet.http.HttpSession session = request.getSession(true);
 * String sessionKey = "dropbox-auth-csrf-token";
 * DbxSessionStore csrfTokenStore = new DbxStandardSessionStore(session, sessionKey);
 *
 * String redirectUri = "http://my-server.com/dropbox-auth-finish"
 * DbxWebAuth auth = new DbxWebAuth(requestConfig, appInfo, redirectUri, csrfTokenStore);
 * </pre>
 *
 * <p>
 * Part 1 (handler for "http://my-server.com/dropbox-auth-start").
 * </p>
 * <pre>
 * javax.servlet.http.HttpServletResponse response = ...
 *
 * <b>// Start authorization.</b>
 * String authorizePageUrl = auth.{@link #start start}();
 *
 * <b>// Redirect the user to the Dropbox website so they can approve our application.</b>
 * <b>// The Dropbox website will send them back to "http://my-server.com/dropbox-auth-finish"</b>
 * <b>// when they're done.</b>
 * response.sendRedirect(authorizePageUrl);
 * </pre>
 *
 * <p>
 * Part 2 (handler for "http://my-server.com/dropbox-auth-finish").
 * </p>
 * <pre>
 * javax.servlet.http.HttpServletResponse response = ...
 *
 * {@link DbxAuthFinish} authFinish;
 * try {
 *     authFinish = auth.{@link #finish finish}(request.getParameterMap());
 * }
 * catch (DbxWebAuth.BadRequestException ex) {
 *     log("On /dropbox-auth-finish: Bad request: " + ex.getMessage());
 *     response.sendError(400);
 *     return;
 * }
 * catch (DbxWebAuth.BadStateException ex) {
 *     // Send them back to the start of the auth flow.
 *     response.sendRedirect("http://my-server.com/dropbox-auth-start");
 *     return;
 * }
 * catch (DbxWebAuth.CsrfException ex) {
 *     log("On /dropbox-auth-finish: CSRF mismatch: " + ex.getMessage());
 *     return;
 * }
 * catch (DbxWebAuth.NotApprovedException ex) {
 *     <b>// When Dropbox asked "Do you want to allow this app to access your</b>
 *     <b>// Dropbox account?", the user clicked "No".</b>
 *     ...
 *     return;
 * }
 * catch (DbxWebAuth.ProviderException ex) {
 *     log("On /dropbox-auth-finish: Auth failed: " + ex.getMessage());
 *     response.sendError(503, "Error communicating with Dropbox.");
 *     return;
 * }
 * catch (DbxException ex) {
 *     log("On /dropbox-auth-finish: Error getting token: " + ex.getMessage());
 *     response.sendError(503, "Error communicating with Dropbox.");
 *     return;
 * }
 * String accessToken = authResponse.accessToken;
 *
 * <b>// Save the access token somewhere (probably in your database) so you</b>
 * <b>// don't need to send the user through the authorization process again.</b>
 * ...
 *
 * <b>// Now use the access token to make Dropbox API calls.</b>
 * {@link DbxClientV2} client = new DbxClientV2(requestConfig, accessToken);
 * ...
 * </pre>
 */
public class DbxWebAuth
{
    private final DbxRequestConfig requestConfig;
    private final DbxAppInfo appInfo;
    private final String redirectUri;
    private final DbxSessionStore csrfTokenStore;

    /**
     * @param appInfo
     *     Your application's Dropbox API information (the app key and secret).
     */
    public DbxWebAuth(DbxRequestConfig requestConfig, DbxAppInfo appInfo, String redirectUri, DbxSessionStore csrfTokenStore)
    {
        if (requestConfig == null) throw new IllegalArgumentException("'requestConfig' is null");
        if (appInfo == null) throw new IllegalArgumentException("'appInfo' is null");
        if (redirectUri == null) throw new IllegalArgumentException("'redirectUri' is null");
        if (csrfTokenStore == null) throw new IllegalArgumentException("'csrfTokenStore' is null");

        this.requestConfig = requestConfig;
        this.appInfo = appInfo;
        this.redirectUri = redirectUri;
        this.csrfTokenStore = csrfTokenStore;
    }

    /**
     * Start authorization.  Returns a "authorization URL" on the Dropbox website that gives the
     * lets the user grant your app access to their Dropbox account.
     *
     * <p>
     * If they choose to grant access, they will be shown an "authorization code", which they
     * need to copy/paste back into your app, at which point you can call {@link #finish} to get an
     * access token.
     * </p>
     */
    public String start(/*@Nullable*/String urlState)
    {
        SecureRandom r = new SecureRandom();
        byte[] csrfRaw = new byte[16];
        r.nextBytes(csrfRaw);
        String csrfAscii = StringUtil.urlSafeBase64Encode(csrfRaw);

        String state = csrfAscii;
        if (urlState != null) {
            state += "|" + urlState;
        }

        this.csrfTokenStore.set(csrfAscii);

        return DbxWebAuthHelper.getAuthorizeUrl(this.appInfo, this.requestConfig.userLocale, redirectUri, state);
    }

    /**
     * Start authorization.  Returns a "authorization URL" on the Dropbox website that gives the
     * lets the user grant your app access to their Dropbox account.
     *
     * <p>
     * If they choose to grant access, they will be shown an "authorization code", which they
     * need to copy/paste back into your app, at which point you can call {@link #finish} to get an
     * access token.
     * </p>
     */
    public String start()
    {
        return start(null);
    }

    /**
     * Call this after the user has visited the authorizaton URL and Dropbox has redirected them
     * back to you (using the {@code redirectUri} you passed in to {@link #start}.
     *
     * @param queryParams
     *    The query parameters on the GET request to your {@code redirectUri}.
     */
    public DbxAuthFinish finish(Map<String, String[]> queryParams)
            throws DbxException, BadRequestException, BadStateException, CsrfException, NotApprovedException, ProviderException
    {
        if (queryParams == null) throw new IllegalArgumentException("'queryParams' is null");

        // Check well-formedness of request.

        String state = getParam(queryParams, "state");
        if (state == null) throw new BadRequestException("missing 'state' parameter");

        String error = getParam(queryParams, "error");
        String code = getParam(queryParams, "code");
        String errorDescription = getParam(queryParams, "error_description");

        if (code == null && error == null) throw new BadRequestException("missing both 'code' and 'error'; one must be present");
        if (code != null && error != null) throw new BadRequestException("both 'code' and 'error' are set; only one must be present");
        if (code != null && errorDescription != null) throw new BadRequestException("both 'code' and 'error_description' are set");

        // Check CSRF token

        String csrfTokenFromSession = this.csrfTokenStore.get();
        if (csrfTokenFromSession == null) throw new BadStateException();
        if (csrfTokenFromSession.length() <= 20) throw new AssertionError("CSRF token too short: " + jq(csrfTokenFromSession));

        int divPos = state.indexOf('|');
        String givenCsrfToken;
        String givenUrlState;
        if (divPos < 0) {
            givenCsrfToken = state;
            givenUrlState = null;
        } else {
            givenCsrfToken = state.substring(0, divPos);
            givenUrlState = state.substring(divPos + 1);
        }
        if (!StringUtil.secureStringEquals(csrfTokenFromSession, givenCsrfToken)) {
            throw new CsrfException("expecting " + jq(csrfTokenFromSession) + ", got " + jq(givenCsrfToken));
        }

        this.csrfTokenStore.clear();

        // Check for error identifier

        if (error != null) {
            if (error.equals("access_denied")) {
                // When the user clicks "Deny"
                String exceptionMessage;
                if (errorDescription == null) {
                    exceptionMessage = "No additional description from Dropbox";
                } else {
                    exceptionMessage = "Additional description from Dropbox: " + errorDescription;
                }
                throw new NotApprovedException(exceptionMessage);
            }
            else {
                // All other errors.
                String exceptionMessage = error;
                if (errorDescription != null) {
                    exceptionMessage += ": " + errorDescription;
                }
                throw new ProviderException(exceptionMessage);
            }
        }

        assert code != null : "@AssumeAssertion(nullness)";

        DbxAuthFinish finish = DbxWebAuthHelper.finish(this.appInfo, this.requestConfig, code, this.redirectUri);
        return new DbxAuthFinish(finish.accessToken, finish.userId, givenUrlState);
    }

    private static /*@Nullable*/String getParam(Map<String,String[]> params, String name)
        throws BadRequestException
    {
        String[] v = params.get(name);
        if (v == null) return null;
        assert v.length != 0;

        if (v.length == 1) {
            return v[0];
        }
        else {
            throw new BadRequestException("multiple occurrences of '" + name + "' parameter");
        }
    }

    /**
     * The base class for authorization redirect errors.  You should catch each subclass
     * individually.
     */
    public static abstract class Exception extends java.lang.Exception
    {
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
    public static final class BadRequestException extends Exception
    {
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
    public static final class BadStateException extends Exception
    {
        public BadStateException() { super("Not expecting Dropbox auth redirect (session doesn't have CSRF token)"); }
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
    public static final class CsrfException extends Exception
    {
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
    public static final class NotApprovedException extends Exception
    {
        public NotApprovedException(String message) { super(message); }
    }

    /**
     * Thrown when Dropbox tells us that some other error occurred in the authorization process.
     *
     * <p>
     * IMPORTANT: The exception's message should not be shown the the user, but should be logged.
     * </p>
     */
    public static final class ProviderException extends Exception
    {
        public ProviderException(String message) { super(message); }
    }
}
