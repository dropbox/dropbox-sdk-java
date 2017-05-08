package com.dropbox.core.examples.global_callbacks;

import com.dropbox.core.v2.callbacks.DbxNetworkErrorCallback;
import com.dropbox.core.InvalidAccessTokenException;

public class DbxExampleNetworkErrorCallback extends DbxNetworkErrorCallback {
    @Override
    public void run() {
        if (this.getNetworkError() instanceof InvalidAccessTokenException) {
            System.out.println("GLOBAL NETWORK ERROR HANDLER: " + this.getNetworkError() + "\n");
            // do some work
        }
    }
}
