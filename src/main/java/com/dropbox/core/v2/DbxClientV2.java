package com.dropbox.core.v2;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.oauth.DbxOAuthException;
import com.dropbox.core.oauth.DbxRefreshResult;
import com.dropbox.core.v2.common.PathRoot;

import java.util.List;

/**
 * Use this class to make remote calls to the Dropbox API user endpoints.  User
 * endpoints expose actions you can perform as a Dropbox user.  You'll need an
 * access token first, normally acquired by directing a Dropbox user through the
 * auth flow using {@link com.dropbox.core.DbxWebAuth}.
 *
 * <p> This class has no mutable state, so it's thread safe as long as you pass
 * in a thread safe {@link HttpRequestor} implementation. </p>
 */
public class DbxClientV2 extends DbxClientV2Base {

    /**
     * Creates a client that uses the given OAuth 2 access token as
     * authorization when performing requests against the default Dropbox hosts.
     *
     * @param requestConfig  Default attributes to use for each request
     * @param accessToken  OAuth 2 access token (that you got from Dropbox) that
     *     gives your app the ability to make Dropbox API calls. Typically
     *     acquired through {@link com.dropbox.core.DbxWebAuth}
     */
    public DbxClientV2(DbxRequestConfig requestConfig, String accessToken) {
        this(requestConfig, accessToken, DbxHost.DEFAULT, null);
    }

    /**
     * Creates a client that uses the given OAuth 2 access token as
     * authorization when performing requests against the default Dropbox hosts.
     *
     * @param requestConfig  Default attributes to use for each request
     * @param accessToken  OAuth 2 access token (that you got from Dropbox) that
     *     gives your app the ability to make Dropbox API calls. Typically
     *     acquired through {@link com.dropbox.core.DbxWebAuth}
     * @param userId The user ID of the current Dropbox account. Used for
     *               multi-Dropbox account use-case.
     */
    public DbxClientV2(DbxRequestConfig requestConfig, String accessToken, String userId) {
        this(requestConfig, accessToken, DbxHost.DEFAULT, userId);
    }

    /**
     *
     *
     * Create a client that uses {@link com.dropbox.core.oauth.DbxCredential} instead of raw
     * access token. The credential object include access token as well as refresh token,
     * expiration time, app key and app secret. Using credential enables dropbox client to support
     * short live token feature.
     *
     * @param requestConfig Default attributes to use for each request
     * @param credential The credential object containing all the information for authentication.
     */
    public DbxClientV2(DbxRequestConfig requestConfig, DbxCredential credential) {
        this(requestConfig, credential, DbxHost.DEFAULT, null, null);
    }

    /**
     * Same as {@link #DbxClientV2(DbxRequestConfig, String)} except you can
     * also set the hostnames of the Dropbox API servers. This is used in
     * testing. You don't normally need to call this.
     *
     * @param requestConfig  Default attributes to use for each request
     * @param accessToken  OAuth 2 access token (that you got from Dropbox) that
     *     gives your app the ability to make Dropbox API calls. Typically
     *     acquired through {@link com.dropbox.core.DbxWebAuth}
     * @param host  Dropbox hosts to send requests to (used for mocking and
     *     testing)
     */
    public DbxClientV2(DbxRequestConfig requestConfig, String accessToken, DbxHost host) {
        this(requestConfig, accessToken, host, null);
    }

    /**
     * Same as {@link #DbxClientV2(DbxRequestConfig, String, DbxHost)} except you can
     * also set the userId for multiple Dropbox accounts.
     *
     * @param requestConfig  Default attributes to use for each request
     * @param accessToken  OAuth 2 access token (that you got from Dropbox) that
     *     gives your app the ability to make Dropbox API calls. Typically
     *     acquired through {@link com.dropbox.core.DbxWebAuth}
     * @param host  Dropbox hosts to send requests to (used for mocking and
     *     testing)
     * @param userId The user ID of the current Dropbox account. Used for multi-Dropbox
     *               account use-case.
     */
    public DbxClientV2(DbxRequestConfig requestConfig, String accessToken, DbxHost host, String userId) {
        this(requestConfig, new DbxCredential(accessToken), host, userId, null);
    }

    private DbxClientV2(
        DbxRequestConfig requestConfig,
        DbxCredential credential,
        DbxHost host,
        String userId,
        PathRoot pathRoot) {
        super(new DbxUserRawClientV2(requestConfig, credential, host, userId, pathRoot));
    }

    /**
     * For internal use only.
     *
     * <p> Used by other clients to provide functionality like DbxTeamClientV2.asMember(..)
     *
     * @param client Raw v2 client ot use for issuing requests
     */
    DbxClientV2(DbxRawClientV2 client) {
        super(client);
    }

    /**
     * Returns a new {@link DbxClientV2} that performs requests against Dropbox API
     * user endpoints relative to a namespace without including the namespace as
     * part of the path variable for every request.
     * (<a href="https://www.dropbox.com/developers/reference/namespace-guide#pathrootmodes">https://www.dropbox.com/developers/reference/namespace-guide#pathrootmodes</a>).
     *
     * <p> This method performs no validation of the namespace ID. </p>
     *
     * @param pathRoot  the path root for this client, never {@code null}.
     *
     * @return Dropbox client that issues requests with Dropbox-API-Path-Root header.
     *
     * @throws IllegalArgumentException  If {@code pathRoot} is {@code null}
     */
    public DbxClientV2 withPathRoot(PathRoot pathRoot) {
        if (pathRoot == null) {
            throw new IllegalArgumentException("'pathRoot' should not be null");
        }
        return new DbxClientV2(_client.withPathRoot(pathRoot));
    }

    /**
     *
     *
     * Refresh the access token inside {@link DbxCredential}. It has the same behavior as
     * {@link DbxCredential#refresh(DbxRequestConfig)}.
     * @return The result contains new short-live access token and expiration time.
     * @throws DbxOAuthException If refresh failed because of invalid parameter or invalid refresh
     * token.
     * @throws DbxException If refresh failed before of general problems like network issue.
     */
    public DbxRefreshResult refreshAccessToken() throws DbxException {
        return this._client.refreshAccessToken();
    }

    /**
     * {@link DbxRawClientV2} raw client that adds user OAuth2 auth headers to all requests.
     */
    private static final class DbxUserRawClientV2 extends DbxRawClientV2 {
        private final DbxCredential credential;

        DbxUserRawClientV2(DbxRequestConfig requestConfig, DbxCredential credential, DbxHost host,
                           String userId, PathRoot pathRoot) {
            super(requestConfig, host, userId, pathRoot);

            if (credential == null) throw new NullPointerException("credential");
            this.credential = credential;
        }

        @Override
        public DbxRefreshResult refreshAccessToken() throws DbxException {
            credential.refresh(this.getRequestConfig());
            return new DbxRefreshResult(credential.getAccessToken(), credential.getExpiresAt());
        }

        @Override
        boolean canRefreshAccessToken() {
            return credential.getRefreshToken() != null;
        }

        @Override
        boolean needsRefreshAccessToken() {
            return canRefreshAccessToken() && credential.aboutToExpire();
        }

        @Override
        protected void addAuthHeaders(List<HttpRequestor.Header> headers) {
            DbxRequestUtil.removeAuthHeader(headers);
            DbxRequestUtil.addAuthHeader(headers, credential.getAccessToken());
        }

        @Override
        protected DbxRawClientV2 withPathRoot(PathRoot pathRoot) {
            return new DbxUserRawClientV2(
                this.getRequestConfig(),
                this.credential,
                this.getHost(),
                this.getUserId(),
                pathRoot
            );
        }
    }
}
