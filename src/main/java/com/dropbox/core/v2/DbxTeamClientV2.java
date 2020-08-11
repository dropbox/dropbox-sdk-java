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
 * Use this class to make remote calls to the Dropbox API team endpoints.  Team
 * endpoints expose actions you can perform on or for a Dropbox team.  You'll
 * need a team access token first, normally acquired by directing a Dropbox
 * Business team administrator through the auth flow using {@link
 * com.dropbox.core.DbxWebAuth}.
 *
 * <p> Team clients can access user endpoints by using the {@link #asMember}
 * method.  This allows team clients to perform actions as a particular team
 * member. </p>
 *
 * <p> This class has no mutable state, so it's thread safe as long as you pass
 * in a thread safe {@link HttpRequestor} implementation. </p>
 */
public class DbxTeamClientV2 extends DbxTeamClientV2Base {
    private final DbxCredential credential;

    /**
     * Creates a client that uses the given OAuth 2 access token as
     * authorization when performing requests against the default Dropbox hosts.
     *
     * @param requestConfig  Default attributes to use for each request
     * @param accessToken  OAuth 2 access token (that you got from Dropbox) that
     *     gives your app the ability to make Dropbox API calls. Typically
     *     acquired through {@link com.dropbox.core.DbxWebAuth}
     */
    public DbxTeamClientV2(DbxRequestConfig requestConfig, String accessToken) {
        this(requestConfig, accessToken, DbxHost.DEFAULT);
    }

    /**
     * Same as {@link #DbxTeamClientV2(DbxRequestConfig, String)} except you can
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
    public DbxTeamClientV2(DbxRequestConfig requestConfig, String accessToken, DbxHost host) {
        this(requestConfig, accessToken, host, null);
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
    public DbxTeamClientV2(DbxRequestConfig requestConfig, DbxCredential credential) {
        this(requestConfig, credential, DbxHost.DEFAULT, null);
    }

    /**
     * Same as {@link #DbxTeamClientV2(DbxRequestConfig, String, DbxHost)} except you can
     * also set the userId for multiple Dropbox accounts.
     *
     * @param requestConfig  Default attributes to use for each request
     * @param accessToken  OAuth 2 access token (that you got from Dropbox) that
     *     gives your app the ability to make Dropbox API calls. Typically
     *     acquired through {@link com.dropbox.core.DbxWebAuth}
     * @param host  Dropbox hosts to send requests to (used for mocking and
     *     testing)
     * @param userId The user ID of the current Dropbox account. Used for
     *               multi-Dropbox account use-case.
     */
    public DbxTeamClientV2(DbxRequestConfig requestConfig, String accessToken, DbxHost host, String userId) {
        this(requestConfig, new DbxCredential(accessToken), host, userId);
    }

    /**
     *
     *
     * Same as {@link #DbxTeamClientV2(DbxRequestConfig, DbxCredential)} except you can set host
     * and userId.
     *
     * @param requestConfig Default attributes to use for each request
     * @param credential The credential object containing all the information for authentication.
     * @param host  Dropbox hosts to send requests to (used for mocking and testing)
     * @param userId The user ID of the current Dropbox account. Used for
     *               multi-Dropbox account use-case.
     */
    public DbxTeamClientV2(DbxRequestConfig requestConfig, DbxCredential credential, DbxHost host,
                           String userId) {
        super(new DbxTeamRawClientV2(requestConfig, credential, host, userId, null, null, null));
        this.credential = credential;
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
     * Returns a {@link DbxClientV2} that performs requests against Dropbox API
     * user endpoints as the given team member.
     *
     * <p> This method performs no validation of the team member ID. </p>
     *
     * @param memberId  Team member ID of member in this client's team, never
     *     {@code null}.
     *
     * @return Dropbox client that issues requests to user endpoints as the
     *     given team member
     *
     * @throws IllegalArgumentException  If {@code memberId} is {@code null}
     */
    public DbxClientV2 asMember(String memberId) {
        if (memberId == null) {
            throw new IllegalArgumentException("'memberId' should not be null");
        }

        DbxRawClientV2 asMemberClient = new DbxTeamRawClientV2(
            _client.getRequestConfig(),
            credential,
            _client.getHost(),
            _client.getUserId(),
            memberId,
            null,
            null
        );
        return new DbxClientV2(asMemberClient);
    }

    /**
     * Returns a {@link DbxClientV2} that performs requests against Dropbox API
     * user endpoints as the given team admin.
     *
     * <p> This method performs no validation of the team admin ID. </p>
     *
     * @param adminId  Team member ID of the admin in client's team, never
     *     {@code null}.
     *
     * @return Dropbox client that issues requests to user endpoints as the
     *     given team Admin.
     *
     * @throws IllegalArgumentException  If {@code adminId} is {@code null}
     */
    public DbxClientV2 asAdmin(String adminId) {
        if (adminId == null) {
            throw new IllegalArgumentException("'adminId' should not be null");
        }

        DbxRawClientV2 asAdminClient = new DbxTeamRawClientV2(
            _client.getRequestConfig(),
            credential,
            _client.getHost(),
            _client.getUserId(),
            null,
            adminId,
            null
        );
        return new DbxClientV2(asAdminClient);
    }

    /**
     * {@link DbxRawClientV2} raw client that adds team OAuth2 auth headers to all requests. If a
     * member ID is specified, this client will also add select-user headers to all requests (used
     * to perform requests as a particular team member).
     */
    private static final class DbxTeamRawClientV2 extends DbxRawClientV2 {
        private final DbxCredential credential;
        private final String memberId;
        private final String adminId;

        private DbxTeamRawClientV2(
            DbxRequestConfig requestConfig,
            DbxCredential credential,
            DbxHost host,
            String userId,
            String memberId,
            String adminId,
            PathRoot pathRoot) {
            super(requestConfig, host, userId, pathRoot);

            if (credential == null) throw new NullPointerException("credential");

            this.credential = credential;
            this.memberId = memberId;
            this.adminId = adminId;
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
            if (memberId != null) {
                DbxRequestUtil.addSelectUserHeader(headers, memberId);
            }
            if (adminId != null) {
                DbxRequestUtil.addSelectAdminHeader(headers, adminId);
            }
        }

        @Override
        protected DbxRawClientV2 withPathRoot(PathRoot pathRoot) {
            return new DbxTeamRawClientV2(
                this.getRequestConfig(),
                this.credential,
                this.getHost(),
                this.getUserId(),
                this.memberId,
                this.adminId,
                pathRoot
            );
        }
    }
}
