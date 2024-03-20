package com.dropbox.core.v2;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.http.StandardHttpRequestor;
import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.oauth.DbxRefreshResult;
import com.dropbox.core.v2.common.PathRoot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Build a new {@link DbxUserClient}.
 */
public class DbxUserClientBuilder {
    @NotNull private final DbxCredential credential;
    @NotNull private final String clientIdentifier;
    @NotNull private DbxHost host = DbxHost.DEFAULT;
    @NotNull private HttpRequestor httpRequestor = StandardHttpRequestor.INSTANCE;
    @Nullable private String userLocale = null;
    @Nullable private String userId = null;
    @Nullable private PathRoot pathRoot = null;
    private int maxRetries = 0;

    public DbxUserClientBuilder(@NotNull String clientIdentifier, @NotNull String accessToken) {
        this(clientIdentifier, new DbxCredential(accessToken));
    }

    public DbxUserClientBuilder(@NotNull String clientIdentifier, @NotNull DbxCredential credential) {
        this.clientIdentifier = clientIdentifier;
        this.credential = credential;
    }

    public DbxUserClientBuilder(@NotNull DbxUserClient client, @NotNull String accessToken) {
        this(client, new DbxCredential(accessToken));
    }

    public DbxUserClientBuilder(@NotNull DbxUserClient client, @NotNull DbxCredential credential) {
        this(client._client.getRequestConfig(), credential);
    }

    public DbxUserClientBuilder(@NotNull DbxRequestConfig requestConfig, @NotNull String accessToken) {
        this(requestConfig, new DbxCredential(accessToken));
    }

    public DbxUserClientBuilder(@NotNull DbxRequestConfig requestConfig, @NotNull DbxCredential credential) {
        this.clientIdentifier = requestConfig.getClientIdentifier();
        this.userLocale = requestConfig.getUserLocale();
        this.httpRequestor = requestConfig.getHttpRequestor();
        this.maxRetries = requestConfig.getMaxRetries();
        this.credential = credential;
    }

    public DbxUserClientBuilder setHost(@NotNull DbxHost host) {
        this.host = host;
        return this;
    }

    public DbxUserClientBuilder setUserId(@Nullable String userId) {
        this.userId = userId;
        return this;
    }

    public DbxUserClientBuilder setPathRoot(@Nullable PathRoot pathRoot) {
        this.pathRoot = pathRoot;
        return this;
    }

    public DbxUserClientBuilder setUserLocale(@Nullable String userLocale) {
        this.userLocale = userLocale;
        return this;
    }

    public DbxUserClientBuilder setHttpRequestor(@NotNull HttpRequestor httpRequestor) {
        this.httpRequestor = httpRequestor;
        return this;
    }

    public DbxUserClientBuilder setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
        return this;
    }

    public DbxUserClient build() {
        DbxRequestConfig.Builder requestConfigBuilder = DbxRequestConfig.newBuilder(clientIdentifier)
                .withHttpRequestor(httpRequestor)
                .withUserLocale(userLocale);
        if (maxRetries == 0) {
            requestConfigBuilder.withAutoRetryDisabled();
        } else {
            requestConfigBuilder.withAutoRetryEnabled(maxRetries);
        }
        return new DbxUserClient(
                new DbxUserRawClientV2(
                        requestConfigBuilder.build(),
                        credential,
                        host,
                        userId,
                        pathRoot
                )
        );
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
            return new DbxRefreshResult(credential.getAccessToken(), (credential.getExpiresAt() - System.currentTimeMillis())/1000);
        }

        @Override
        public boolean canRefreshAccessToken() {
            return credential.getRefreshToken() != null;
        }

        @Override
        public boolean needsRefreshAccessToken() {
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
