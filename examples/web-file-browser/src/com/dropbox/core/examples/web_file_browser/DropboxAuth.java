package com.dropbox.core.examples.web_file_browser;

import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxSessionStore;
import com.dropbox.core.DbxStandardSessionStore;
import com.dropbox.core.DbxWebAuth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Handles the endpoints related to authorizing this app with the Dropbox API
 * via OAuth 2.
 */
public class DropboxAuth
{
    private final Common common;

    public DropboxAuth(Common common)
    {
        this.common = common;
    }

    // -------------------------------------------------------------------------------------------
    // POST /dropbox-auth-start
    // -------------------------------------------------------------------------------------------
    // Start the process of getting a Dropbox API access token for the user's Dropbox account.

    public void doStart(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        if (!common.checkPost(request, response)) return;
        User user = common.requireLoggedInUser(request, response);
        if (user == null) return;

        // Start the authorization process with Dropbox.
        String authorizeUrl = getWebAuth(request).start();

        // Redirect the user to the Dropbox website so they can approve our application.
        // The Dropbox website will send them back to /dropbox-auth-finish when they're done.
        response.sendRedirect(authorizeUrl);
    }

    // -------------------------------------------------------------------------------------------
    // GET /dropbox-auth-finish
    // -------------------------------------------------------------------------------------------
    // The Dropbox API authorization page will redirect the user's browser to this page.
    //
    // This is a GET (even though it modifies state) because we get here via a browser
    // redirect (Dropbox redirects the user here).  You can't do a browser redirect to
    // an HTTP POST.

    public void doFinish(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        if (!common.checkGet(request, response)) return;

        User user = common.requireLoggedInUser(request, response);
        if (user == null) {
            common.pageSoftError(response, "Can't do /dropbox-auth-finish.  Nobody is logged in.");
            return;
        }

        DbxAuthFinish authFinish;
        try {
            authFinish = getWebAuth(request).finish(request.getParameterMap());
        }
        catch (DbxWebAuth.BadRequestException e) {
            common.log.println("On /dropbox-auth-finish: Bad request: " + e.getMessage());
            response.sendError(400);
            return;
        }
        catch (DbxWebAuth.BadStateException e) {
            // Send them back to the start of the auth flow.
            response.sendRedirect(common.getUrl(request, "/dropbox-auth-start"));
            return;
        }
        catch (DbxWebAuth.CsrfException e) {
            common.log.println("On /dropbox-auth-finish: CSRF mismatch: " + e.getMessage());
            response.sendError(403);
            return;
        }
        catch (DbxWebAuth.NotApprovedException e) {
            common.page(response, 200, "Not approved?", "Why not, bro?");
            return;
        }
        catch (DbxWebAuth.ProviderException e) {
            common.log.println("On /dropbox-auth-finish: Auth failed: " + e.getMessage());
            response.sendError(503, "Error communicating with Dropbox.");
            return;
        }
        catch (DbxException e) {
            common.log.println("On /dropbox-auth-finish: Error getting token: " + e);
            response.sendError(503, "Error communicating with Dropbox.");
            return;
        }

        // We have an Dropbox API access token now.  This is what will let us make Dropbox API
        // calls.  Save it in the database entry for the current user.
        user.dropboxAccessToken = authFinish.accessToken;
        common.saveUserDb();

        response.sendRedirect("/");
    }

    // -------------------------------------------------------------------------------------------
    // POST /dropbox-unlink
    // -------------------------------------------------------------------------------------------

    public void doUnlink(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException
    {
        if (!common.checkPost(request, response)) return;
        User user = common.requireLoggedInUser(request, response);
        if (user == null) return;

        // Remove the access token from the database.
        user.dropboxAccessToken = null;
        common.saveUserDb();

        response.sendRedirect("/");
    }

    // -------------------------------------------------------------------------------------------

    private DbxWebAuth getWebAuth(final HttpServletRequest request)
    {
        // After we redirect the user to the Dropbox website for authorization,
        // Dropbox will redirect them back here.
        String redirectUrl = common.getUrl(request, "/dropbox-auth-finish");

        // Select a spot in the session for DbxWebAuth to store the CSRF token.
        HttpSession session = request.getSession(true);
        String sessionKey = "dropbox-auth-csrf-token";
        DbxSessionStore csrfTokenStore = new DbxStandardSessionStore(session, sessionKey);

        return new DbxWebAuth(common.getRequestConfig(request), common.dbxAppInfo, redirectUrl, csrfTokenStore);
    }
}
