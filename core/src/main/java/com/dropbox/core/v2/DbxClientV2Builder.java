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
 * Build a new {@link DbxClientV2Base}.
 */
public class DbxClientV2Builder {
    @NotNull private final DbxCredential credential;
    @NotNull private final String clientIdentifier;
    @NotNull private DbxHost host = DbxHost.DEFAULT;
    @NotNull private HttpRequestor httpRequestor = StandardHttpRequestor.INSTANCE;
    @Nullable private String userLocale = null;
    @Nullable private String userId = null;
    @Nullable private PathRoot pathRoot = null;
    private int maxRetries = 0;

    public DbxClientV2Builder(@NotNull String clientIdentifier, @NotNull String accessToken) {
        this(clientIdentifier, new DbxCredential(accessToken));
    }

    public DbxClientV2Builder(@NotNull String clientIdentifier, @NotNull DbxCredential credential) {
        this.clientIdentifier = clientIdentifier;
        this.credential = credential;
    }

    public DbxClientV2Builder setHost(@NotNull DbxHost host) {
        this.host = host;
        return this;
    }

    public DbxClientV2Builder setUserId(@Nullable String userId) {
        this.userId = userId;
        return this;
    }

    public DbxClientV2Builder setPathRoot(@Nullable PathRoot pathRoot) {
        this.pathRoot = pathRoot;
        return this;
    }

    public DbxClientV2Builder setUserLocale(@Nullable String userLocale) {
        this.userLocale = userLocale;
        return this;
    }

    public DbxClientV2Builder setHttpRequestor(@NotNull HttpRequestor httpRequestor) {
        this.httpRequestor = httpRequestor;
        return this;
    }

    public DbxClientV2Builder setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
        return this;
    }

    public DbxClientV2Base build() {
        DbxRequestConfig.Builder requestConfigBuilder = DbxRequestConfig.newBuilder(clientIdentifier)
                .withHttpRequestor(httpRequestor)
                .withUserLocale(userLocale);
        if (maxRetries == 0) {
            requestConfigBuilder.withAutoRetryDisabled();
        } else {
            requestConfigBuilder.withAutoRetryEnabled(maxRetries);
        }
        return new DbxClientV2Base(
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
