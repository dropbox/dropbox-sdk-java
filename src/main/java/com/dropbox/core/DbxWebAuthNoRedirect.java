package com.dropbox.core;

import com.dropbox.core.v2.DbxClientV2;

/**
 * Does the OAuth web-based authorization flow for apps that can't provide a redirect URI (such as
 * the command-line example apps that come with this SDK).  If you're a normal website, use the
 * {@link DbxWebAuth} class instead with a {@link DbxWebAuth.Request} configured to use a redirect
 * URI.
 *
 * <p><b>This class is deprecated and should no longer be used.</b> Instead use {@link DbxWebAuth}
 * and {@link DbxWebAuth.Request.Builder#withNoRedirect} to start an OAuth web-based authorization
 * flow without redirects.
 *
 * <p>
 * Eventually yields an access token that can be used with {@link DbxClientV2} to make
 * Dropbox API calls.  You typically only need to do this for a user when they first use your
 * application.  Once you have an access token for that user, it remains valid for years.
 * </p>
 *
 * <p>
 * Example:
 * </p>
 * <pre>
 * String userLocale = ...
 * {@link DbxRequestConfig} requestConfig = new DbxRequestConfig("text-edit/0.1", userLocale);
 * {@link DbxAppInfo} appInfo = DbxAppInfo.Reader.readFromFile("api.app");
 * DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(requestConfig, appInfo);
 *
 * String authorizeUrl = webAuth.start();
 * System.out.println("1. Go to " + authorizeUrl);
 * System.out.println("2. Click \"Allow\" (you might have to log in first).");
 * System.out.println("3. Copy the authorization code.");
 * System.out.print("Enter the authorization code here: ");
 *
 * String code = new BufferedReader(new InputStreamReader(System.in)).readLine();
 * if (code == null) return;
 * code = code.trim();
 *
 * {@link DbxAuthFinish} authFinish = webAuth.finish(code);
 *
 * {@link DbxClientV2} client = new DbxClientV2(requestConfig, authFinish.accessToken);
 * </pre>
 *
 * @deprecated use {@link DbxWebAuth} instead with a {@link DbxWebAuth.Request} configured with no
 * redirect URI (see {@link DbxWebAuth.Request.Builder#withNoRedirect}).
 */
@Deprecated
public class DbxWebAuthNoRedirect {
    private final DbxWebAuth auth;

    /**
     * @param appInfo
     *     Your application's Dropbox API information (the app key and secret).
     */
    public DbxWebAuthNoRedirect(DbxRequestConfig requestConfig, DbxAppInfo appInfo) {
        this.auth = new DbxWebAuth(requestConfig, appInfo);
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
    public String start() {
        DbxWebAuth.Request request = DbxWebAuth.newRequestBuilder()
            .withNoRedirect()
            .build();
        return auth.authorize(request);
    }

    /**
     * Call this after the user has visited the authorizaton URL and copy/pasted the authorization
     * code that Dropbox gave them.
     *
     * @param code
     *    The authorization code shown to the user when they clicked "Allow" on the authorization
     *    page on the Dropbox website.
     */
    public DbxAuthFinish finish(String code) throws DbxException {
        return auth.finishFromCode(code);
    }
}
