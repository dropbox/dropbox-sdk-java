package com.dropbox.core.examples.android;

import com.dropbox.core.http.OkHttpRequestor;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;

import java.util.Locale;

/**
 * Singleton instance of {@link DbxClientV2} and friends
 */
public class DropboxClientFactory {

    private static DbxClientV2 sDbxClient;

    public static void init(String accessToken) {
        if (sDbxClient == null) {
            String userLocale = Locale.getDefault().toLanguageTag();
            DbxRequestConfig requestConfig = new DbxRequestConfig(
                    "examples-v2-demo",
                    userLocale,
                    OkHttpRequestor.INSTANCE);

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
