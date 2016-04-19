package com.dropbox.core.v2;

import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;

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
public final class DbxTeamClientV2 extends DbxTeamClientV2Base {
    private final String accessToken;

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
        super(new DbxTeamRawClientV2(requestConfig, host, accessToken));
        this.accessToken = accessToken;
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
            _client.getHost(),
            accessToken,
            memberId
        );
        return new DbxClientV2(asMemberClient);
    }

    /**
     * {@link DbxRawClientV2} raw client that adds team OAuth2 auth headers to all requests. If a
     * member ID is specified, this client will also add select-user headers to all requests (used
     * to perform requests as a particular team member).
     */
    private static final class DbxTeamRawClientV2 extends DbxRawClientV2 {
        private final String accessToken;
        private final String memberId;

        private DbxTeamRawClientV2(DbxRequestConfig requestConfig, DbxHost host, String accessToken) {
            this(requestConfig, host, accessToken, null);
        }

        private DbxTeamRawClientV2(DbxRequestConfig requestConfig, DbxHost host, String accessToken, String memberId) {
            super(requestConfig, host);

            if (accessToken == null) throw new NullPointerException("accessToken");

            this.accessToken = accessToken;
            this.memberId = memberId;
        }

        @Override
        protected void addAuthHeaders(List<HttpRequestor.Header> headers) {
            DbxRequestUtil.addAuthHeader(headers, accessToken);
            if (memberId != null) {
                DbxRequestUtil.addSelectUserHeader(headers, memberId);
            }
        }
    }
}
