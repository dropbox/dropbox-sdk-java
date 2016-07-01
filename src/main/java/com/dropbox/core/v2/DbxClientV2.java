package com.dropbox.core.v2;

import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;

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
        this(requestConfig, accessToken, DbxHost.DEFAULT);
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
        super(new DbxUserRawClientV2(requestConfig, accessToken, host));
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
     * {@link DbxRawClientV2} raw client that adds user OAuth2 auth headers to all requests.
     */
    private static final class DbxUserRawClientV2 extends DbxRawClientV2 {
        private final String accessToken;

        public DbxUserRawClientV2(DbxRequestConfig requestConfig, String accessToken, DbxHost host) {
            super(requestConfig, host);

            if (accessToken == null) throw new NullPointerException("accessToken");

            this.accessToken = accessToken;
        }

        @Override
        protected void addAuthHeaders(List<HttpRequestor.Header> headers) {
            DbxRequestUtil.addAuthHeader(headers, accessToken);
        }
    }
}
