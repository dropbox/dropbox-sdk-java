package com.dropbox.core;

import javax.servlet.http.HttpSession;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * A {@link DbxSessionStore} implementation that stores the value using the standard
 * {@link HttpSession} interface from the Java Servlet API.
 *
 * Example:
 * <pre>
 * DbxWebAuth getDbxWebAuth(HttpServletRequest request)
 * {
 *     HttpSession session = request.getSession(true);
 *     String key = "dropbox-auth-csrf-token";
 *     DbxSessionStore csrfStore = new DbxStandardSessionStore(session, key);
 *     return new DbxWebAuth(..., csrfStore);
 * }
 * </pre>
 */
public final class DbxStandardSessionStore implements DbxSessionStore {
    private final HttpSession session;
    private final String key;

    public DbxStandardSessionStore(HttpSession session, String key) {
        this.session = session;
        this.key = key;
    }

    public HttpSession getSession() {
        return session;
    }

    public String getKey() {
        return key;
    }

    @Override
    public /*@Nullable*/String get() {
        Object v = session.getAttribute(key);
        if (v instanceof String) return (String) v;
        return null;
    }

    @Override
    public void set(String value) {
        session.setAttribute(key, value);
    }

    @Override
    public void clear() {
        session.removeAttribute(key);
    }
}
