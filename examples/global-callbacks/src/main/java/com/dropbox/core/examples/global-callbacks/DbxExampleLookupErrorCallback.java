package com.dropbox.core.examples.global_callbacks;

import com.dropbox.core.v2.callbacks.DbxRouteErrorCallback;
import com.dropbox.core.v2.files.LookupError;

public class DbxExampleLookupErrorCallback<T> extends DbxRouteErrorCallback<T> {
    @Override
    public void run() {
        System.out.println("GLOBAL ROUTE ERROR HANDLER (LookupError): " + this.getRouteError() + "\n");
        // do some work
    }
}