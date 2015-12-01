package com.dropbox.core.v2;

import com.dropbox.core.*;
import com.dropbox.core.http.HttpRequestor;

import java.util.ArrayList;

/*>>> import checkers.nullness.quals.NonNull; */
/*>>> import checkers.nullness.quals.Nullable; */
/*>>> import checkers.nullness.quals.MonotonicNonNull; */
/*>>> import checkers.initialization.quals.Initialized; */

/**
 * Use this class to make remote calls to the Dropbox API.  You'll need an access token first,
 * normally acquired via {@link DbxWebAuth}.
 *
 * <p>
 * This class has no mutable state, so it's thread safe as long as you pass in a thread safe
 * {@link HttpRequestor} implementation.
 * </p>
 */
public final class DbxClientV2 extends DbxRawClientV2 {

    public final DbxFiles files;
    public final DbxUsers users;
    public final DbxSharing sharing;

    /**
     * @param requestConfig
     * @param accessToken   The OAuth 2 access token (that you got from Dropbox) that gives your app the ability
     *                      to make Dropbox API calls against some particular user's account.  The standard way
     *                      to get one of these is to use {@link DbxWebAuth} to send your user through Dropbox's
     */
    public DbxClientV2(DbxRequestConfig requestConfig, String accessToken) {
        this(requestConfig, accessToken, DbxHost.Default);
    }

    /**
     * The same as {@link #DbxClientV2(DbxRequestConfig, String)} except you can also set the
     * hostnames of the Dropbox API servers.  This is used in testing.  You don't normally need
     * to call this.
     *
     * @param requestConfig
     * @param accessToken
     * @param host
     */
    public DbxClientV2(DbxRequestConfig requestConfig, String accessToken, DbxHost host) {
        super(requestConfig, accessToken, host);
        this.files = new DbxFiles(this);
        this.users = new DbxUsers(this);
        this.sharing = new DbxSharing(this);
    }
}