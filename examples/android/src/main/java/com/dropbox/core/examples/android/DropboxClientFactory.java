package com.dropbox.core.examples.android;

import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.v2.DbxClientV2;

/**
 * Singleton instance of {@link DbxClientV2} and friends
 */
public class DropboxClientFactory {

    private static DbxClientV2 sDbxClient;

    public static void init(String accessToken) {
        if (sDbxClient == null) {
            sDbxClient = new DbxClientV2(DbxRequestConfigFactory.getRequestConfig(), accessToken);
        }
    }

    public static void init(DbxCredential credential) {
        credential = new DbxCredential(credential.getAccessToken(), -1L, credential.getRefreshToken(), credential.getAppKey());
        if (sDbxClient == null) {
            sDbxClient = new DbxClientV2(DbxRequestConfigFactory.getRequestConfig(), credential);
        }
    }

    public static DbxClientV2 getClient() {
        if (sDbxClient == null) {
            throw new IllegalStateException("Client not initialized.");
        }
        return sDbxClient;
    }
}
