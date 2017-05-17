package com.dropbox.core.examples.global_callbacks;

import com.dropbox.core.v2.callbacks.DbxGlobalCallbackFactory;
import com.dropbox.core.v2.callbacks.DbxRouteErrorCallback;
import com.dropbox.core.v2.callbacks.DbxNetworkErrorCallback;
import com.dropbox.core.v2.files.ListFolderError;
import com.dropbox.core.v2.files.LookupError;

public class DbxExampleGlobalCallbackFactory implements DbxGlobalCallbackFactory {
    @Override
    public <T> DbxRouteErrorCallback<T> createRouteErrorCallback(String userId, T routeError) {
        if (routeError instanceof ListFolderError) {
            return new DbxExampleListFolderErrorCallback<T>();
        } else if (routeError instanceof LookupError) {
            return new DbxExampleLookupErrorCallback<T>();
        }

        return null;
    }

    @Override
    public DbxExampleNetworkErrorCallback createNetworkErrorCallback(String userId) {
        return new DbxExampleNetworkErrorCallback();
    }
}
