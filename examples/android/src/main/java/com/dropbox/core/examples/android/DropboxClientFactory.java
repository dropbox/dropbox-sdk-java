package com.dropbox.core.examples.android;

import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;

/**
 * Singleton instance of {@link DbxClientV2} and friends
 */
public class DropboxClientFactory {

    private static DbxClientV2 sDbxClient;

    public static void init(String accessToken) {
        if (sDbxClient == null) {
            DbxRequestConfig requestConfig = DbxRequestConfig.newBuilder("examples-v2-demo")
                // don't use OkHttpRequestor so we can verify cert pinning on Android works (since
                // Dalvik implementation is slightly different)
                .build();

            sDbxClient = new DbxClientV2(requestConfig, accessToken);
        }
    }

    public static DbxClientV2 getClient() {
        if (sDbxClient == null) {
            throw new IllegalStateException("Client not initialized.");
        }
        return sDbxClient;
    }
}
