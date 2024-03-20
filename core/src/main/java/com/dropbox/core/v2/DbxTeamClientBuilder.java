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
 * Build a new {@link DbxTeamClient}.
 */
public class DbxTeamClientBuilder {
    @NotNull private final DbxCredential credential;
    @NotNull private final String clientIdentifier;
    @NotNull private DbxHost host = DbxHost.DEFAULT;
    @NotNull private HttpRequestor httpRequestor = StandardHttpRequestor.INSTANCE;
    @Nullable private String userLocale = null;
    @Nullable private String userId = null;
    @Nullable private String adminId = null;
    @Nullable private String memberId = null;
    @Nullable private PathRoot pathRoot = null;
    private int maxRetries = 0;

    public DbxTeamClientBuilder(@NotNull String clientIdentifier, @NotNull String accessToken) {
        this(clientIdentifier, new DbxCredential(accessToken));
    }

    public DbxTeamClientBuilder(@NotNull String clientIdentifier, @NotNull DbxCredential credential) {
        this.clientIdentifier = clientIdentifier;
        this.credential = credential;
    }

    public DbxTeamClientBuilder(@NotNull DbxTeamClient client) {
        if (!(client._client instanceof DbxTeamRawClientV2)) {
            throw new IllegalArgumentException("DbxTeamClientV2 constructor requires a raw client.");
        }
        DbxTeamRawClientV2 rawClient = (DbxTeamRawClientV2) client._client;
        DbxRequestConfig requestConfig = rawClient.getRequestConfig();
        this.clientIdentifier = requestConfig.getClientIdentifier();
        this.httpRequestor = requestConfig.getHttpRequestor();
        this.userLocale = requestConfig.getUserLocale();
        this.maxRetries = requestConfig.getMaxRetries();
        this.credential = rawClient.credential;
        this.host = rawClient.getHost();
        this.userId = rawClient.getUserId();
        this.adminId = rawClient.adminId;
        this.memberId = rawClient.memberId;
    }

    public DbxTeamClientBuilder(@NotNull DbxRequestConfig requestConfig, @NotNull String accessToken) {
        this(requestConfig, new DbxCredential(accessToken));
    }

    public DbxTeamClientBuilder(@NotNull DbxRequestConfig requestConfig, @NotNull DbxCredential credential) {
        this.clientIdentifier = requestConfig.getClientIdentifier();
        this.userLocale = requestConfig.getUserLocale();
        this.httpRequestor = requestConfig.getHttpRequestor();
        this.maxRetries = requestConfig.getMaxRetries();
        this.credential = credential;
    }


    public DbxTeamClientBuilder setHost(@NotNull DbxHost host) {
        this.host = host;
        return this;
    }

    public DbxTeamClientBuilder setUserId(@Nullable String userId) {
        this.userId = userId;
        return this;
    }

    public DbxTeamClientBuilder setMemberId(@Nullable String memberId) {
        this.memberId = memberId;
        return this;
    }

    public DbxTeamClientBuilder setAdminId(@Nullable String adminId) {
        this.adminId = adminId;
        return this;
    }

    public DbxTeamClientBuilder setPathRoot(@Nullable PathRoot pathRoot) {
        this.pathRoot = pathRoot;
        return this;
    }

    public DbxTeamClientBuilder setUserLocale(@Nullable String userLocale) {
        this.userLocale = userLocale;
        return this;
    }

    public DbxTeamClientBuilder setHttpRequestor(@NotNull HttpRequestor httpRequestor) {
        this.httpRequestor = httpRequestor;
        return this;
    }

    public DbxTeamClientBuilder setMaxRetries(int maxRetries) {
        this.maxRetries = maxRetries;
        return this;
    }

    public DbxTeamClient build() {
        DbxRequestConfig.Builder requestConfigBuilder = DbxRequestConfig.newBuilder(clientIdentifier)
                .withHttpRequestor(httpRequestor)
                .withUserLocale(userLocale);
        if (maxRetries == 0) {
            requestConfigBuilder.withAutoRetryDisabled();
        } else {
            requestConfigBuilder.withAutoRetryEnabled(maxRetries);
        }
        return new DbxTeamClient(
                new DbxTeamRawClientV2(
                        requestConfigBuilder.build(),
                        credential,
                        host,
                        userId,
                        memberId,
                        adminId,
                        pathRoot
                )
        );
    }

    /**
     * {@link DbxRawClientV2} raw client that adds team OAuth2 auth headers to all requests. If a
     * member ID is specified, this client will also add select-user headers to all requests (used
     * to perform requests as a particular team member).
     */
    private static final class DbxTeamRawClientV2 extends DbxRawClientV2 {
        final DbxCredential credential;
        final String memberId;
        final String adminId;

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
