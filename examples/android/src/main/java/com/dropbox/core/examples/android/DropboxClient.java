package com.dropbox.core.examples.android;

import com.dropbox.core.http.OkHttpRequestor;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.Files;
import com.dropbox.core.v2.Sharing;
import com.dropbox.core.v2.Users;

import java.util.Locale;

/**
 * Singleton instance of {@link DbxClientV2} and friends
 */
public class DropboxClient {

    private static DbxClientV2 sDbxClient;

    public static void init(String accessToken) {
        if (sDbxClient == null) {
            String userLocale = Locale.getDefault().toString();
            DbxRequestConfig requestConfig = new DbxRequestConfig(
                    "examples-v2-demo",
                    userLocale,
                    OkHttpRequestor.Instance);

            sDbxClient = new DbxClientV2(requestConfig, accessToken, DbxHost.Default);
        }
    }

    public static Files files() {
        if (sDbxClient != null)
            return sDbxClient.files;
        else
            return null;
    }

    public static Users users() {
        if (sDbxClient != null)
            return sDbxClient.users;
        else
            return null;
    }

    public static Sharing sharing() {
        if (sDbxClient != null)
            return sDbxClient.sharing;
        else
            return null;
    }
}
