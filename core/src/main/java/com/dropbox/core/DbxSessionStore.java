package com.dropbox.core;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * An interface that lets you save, retrieve, and clear a single value in the user's web
 * session.
 *
 * <pre>
 * If your web app uses the standard Java Servlet API, just use
 * {@link DbxStandardSessionStore}.
 * </pre>
 */
public interface DbxSessionStore {
    public @Nullable String get();
    public void set(@Nonnull String value);
    public void clear();
}
