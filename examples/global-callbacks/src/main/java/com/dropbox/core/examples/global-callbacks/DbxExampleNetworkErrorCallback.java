package com.dropbox.core.examples.global_callbacks;

import com.dropbox.core.v2.callbacks.DbxNetworkErrorCallback;
import com.dropbox.core.DbxException;
import com.dropbox.core.InvalidAccessTokenException;

public class DbxExampleNetworkErrorCallback extends DbxNetworkErrorCallback {
    @Override
    public void onNetworkError(DbxException networkError) {
        if (networkError instanceof InvalidAccessTokenException) {
            System.out.println("GLOBAL NETWORK ERROR HANDLER (InvalidAccessTokenException): " + networkError + "\n");
            // do some work
        }
    }
}
