package com.dropbox.core.v2;

import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.DbxSdkVersion;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.http.StandardHttpRequestor;
import com.dropbox.core.oauth.DbxRefreshResult;
import com.dropbox.core.v2.common.PathRoot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Build a new {@link DbxAppClient}.
 */
public class DbxAppClientBuilder {
    @NotNull private final String clientIdentifier;
    @NotNull private final String key;
    @NotNull private final String secret;
    @NotNull private DbxHost host = DbxHost.DEFAULT;
    @NotNull private HttpRequestor httpRequestor = StandardHttpRequestor.INSTANCE;
    @Nullable private String userLocale = null;
    @Nullable private String userId = null;
    private int maxRetries = 0;

    public DbxAppClientBuilder(@NotNull String clientIdentifier, @NotNull String key, @NotNull String secret) {
        this.clientIdentifier = clientIdentifier;
        this.key = key;
        this.secret = secret;
    }

    public DbxAppClientBuilder setHost(@NotNull DbxHost host) {
        this.host = host;
        return this;
    }

    public DbxAppClientBuilder setHttpRequestor(@NotNull HttpRequestor httpRequestor) {
        this.httpRequestor = httpRequestor;
        return this;
    }

    public DbxAppClientBuilder setUserLocale(@Nullable String userLocale) {
        this.userLocale = userLocale;
        return this;
    }

    public DbxAppClientBuilder setUserId(@Nullable String userId) {
        this.userId = userId;
        return this;
    }

    public DbxAppClientBuilder setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
        return this;
    }

    public DbxAppClient build() {
        DbxRequestConfig.Builder requestConfigBuilder = DbxRequestConfig
                .newBuilder(clientIdentifier)
                .withSdkVersion(DbxSdkVersion.Version)
                .withHttpRequestor(httpRequestor)
                .withUserLocale(userLocale);
        if (maxRetries == 0) {
            requestConfigBuilder.withAutoRetryDisabled();
        } else {
            requestConfigBuilder.withAutoRetryEnabled(maxRetries);
        }
        return new DbxAppClient(
                new DbxAppRawClientV2(
                        requestConfigBuilder.build(),
                        key,
                        secret,
                        host,
                        userId
                )
        );
    }

    /**
     * {@link DbxRawClientV2} raw client that adds app auth headers to all requests.
     */
    private static final class DbxAppRawClientV2 extends DbxRawClientV2 {
        private final String key;
        private final String secret;

        private DbxAppRawClientV2(DbxRequestConfig requestConfig, String key, String secret, DbxHost host, String userId) {
            super(requestConfig, host, userId, null);
            this.key = key;
            this.secret = secret;
        }

        @Override
        public DbxRefreshResult refreshAccessToken() {
            //no op
            return null;
        }

        @Override
        public boolean canRefreshAccessToken() {
            return false;
        }

        @Override
        public boolean needsRefreshAccessToken() {
            return false;
        }

        @Override
        protected void addAuthHeaders(List<HttpRequestor.Header> headers) {
            DbxRequestUtil.removeAuthHeader(headers);
            DbxRequestUtil.addBasicAuthHeader(headers, key, secret);
        }

        @Override
        protected DbxRawClientV2 withPathRoot(PathRoot pathRoot) {
            throw new UnsupportedOperationException("App endpoints don't support Dropbox-API-Path-Root header.");
        }
    }
}
