package com.dropbox.core;

/*>>> import checkers.nullness.quals.Nullable; */

/**
 * An interface that lets you save, retrieve, and clear a single value in the user's web
 * session.
 *
 * <pre>
 * If your web app uses the standard Java Servlet API, just use
 * {@link DbxStandardSessionStore}.
 * </pre>
 */
public interface DbxSessionStore
{
    public /*@Nullable*/String get();
    public void set(String value);
    public void clear();
}
