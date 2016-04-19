package com.dropbox.core.examples.web_file_browser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4;

/**
 * Placeholders for protection against CSRF and UI Redress.  The protection isn't actually
 * implemented -- see TODOs below.
 */
public class FormProtection
{
    private static final String antiCsrfTokenName = "anti-csrf-token";
    private boolean insertedAntiRedressHtml = false;

    private FormProtection(HttpServletResponse response)
    {
        response.setHeader("X-Frame-Options", "DENY");
    }

    public static FormProtection start(HttpServletResponse response)
    {
        return new FormProtection(response);
    }

    // Call this on every page that has a POST form.
    // Call this right after you print the opening "<body>" tag.
    public void insertAntiRedressHtml(PrintWriter out)
    {
        if (insertedAntiRedressHtml) {
            throw new IllegalStateException("Already called insertAntiRedressHtml().");
        }
        insertedAntiRedressHtml = true;

        // SECURITY TODO: Actually insert anti-redress HTML.
    }

    // Call this for every POST form.
    // Call this right after you print the opening "<form>" tag.
    public void insertAntiCsrfFormField(PrintWriter out)
    {
        if (!insertedAntiRedressHtml) {
            throw new IllegalStateException("Must call insertAntiRedressHtml() before calling this.");
        }

        // SECURITY TODO: Generate a real token.  This dummy token is obviously insecure.
        String token = "dummy";

        out.println("<input type='hidden' name='" + antiCsrfTokenName + "' value='" + escapeHtml4(token) + "' />");
    }

    // Call this when handling any form POST request.  If it returns
    // null, the CSRF token is ok.  If it returns some other string,
    // display that error message to the user.
    public static String checkAntiCsrfToken(HttpServletRequest request)
    {
        String antiCsrfToken = request.getParameter("anti-csrf-token");
        if (antiCsrfToken == null) {
            return "missing \"" + antiCsrfTokenName + "\" POST parameter";
        }

        // SECURITY TODO: Actually validate anti-CSRF token.
        return null;
    }
}
