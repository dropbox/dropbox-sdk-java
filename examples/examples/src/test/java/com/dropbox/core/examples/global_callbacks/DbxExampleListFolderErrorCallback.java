package com.dropbox.core.examples.global_callbacks;

import com.dropbox.core.v2.callbacks.DbxRouteErrorCallback;
import com.dropbox.core.v2.files.ListFolderError;

public class DbxExampleListFolderErrorCallback<T> extends DbxRouteErrorCallback<T> {
    @Override
    public void run() {
        System.out.println("GLOBAL ROUTE ERROR HANDLER (ListFolderError): " + this.getRouteError() + "\n");
        // do some work
    }
}

