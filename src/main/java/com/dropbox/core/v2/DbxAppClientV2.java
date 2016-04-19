package com.dropbox.core.v2;

import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;

import java.util.List;

/**
 * Use this class to make remote calls to the Dropbox API app endpoints.  App endpoints expose
 * actions you can perform as a Dropbox app without user authorization.  You'll need your app key
 * and secret. You can create an app key and secret on the <a
 * href="https://www.dropbox.com/developers/apps">Dropbox developer website</a>.
 *
 * <p> This class has no mutable state, so it's thread safe as long as you pass
 * in a thread safe {@link HttpRequestor} implementation. </p>
 */
// package private to hide from documentation for now until we have a route that requires it.
class DbxAppClientV2 extends DbxAppClientV2Base {

    /**
     * Creates a client that uses the given app key and secret when performing requests against the
     * default Dropbox hosts.
     *
     * @param requestConfig Default attributes to use for each request
     * @param key Dropbox app key (e.g. consumer key in OAuth)
     * @param secret Dropbox app secret (e.g. consumer secret in OAuth)
     */
    public DbxAppClientV2(DbxRequestConfig requestConfig, String key, String secret) {
        this(requestConfig, key, secret, DbxHost.DEFAULT);
    }

    /**
     * Same as {@link #DbxAppClientV2(DbxRequestConfig, String, String)} except you can also set the
     * hostnames of the Dropbox API servers. This is used in testing. You don't normally need to
     * call this.
     *
     * @param requestConfig  Default attributes to use for each request
     * @param key Dropbox app key (e.g. consumer key in OAuth)
     * @param secret Dropbox app secret (e.g. consumer secret in OAuth)
     * @param host  Dropbox hosts to send requests to (used for mocking and
     *     testing)
     */
    public DbxAppClientV2(DbxRequestConfig requestConfig, String key, String secret, DbxHost host) {
        super(new DbxAppRawClientV2(requestConfig, key, secret, host));
    }

    /**
     * {@link DbxRawClientV2} raw client that adds app auth headers to all requests.
     */
    private static final class DbxAppRawClientV2 extends DbxRawClientV2 {
        private final String key;
        private final String secret;

        private DbxAppRawClientV2(DbxRequestConfig requestConfig, String key, String secret, DbxHost host) {
            super(requestConfig, host);
            this.key = key;
            this.secret = secret;
        }

        @Override
        protected void addAuthHeaders(List<HttpRequestor.Header> headers) {
            DbxRequestUtil.addBasicAuthHeader(headers, key, secret);
        }
    }
}
