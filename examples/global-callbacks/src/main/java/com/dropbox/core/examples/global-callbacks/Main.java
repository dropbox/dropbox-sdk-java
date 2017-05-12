package com.dropbox.core.examples.global_callbacks;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.v2.callbacks.DbxGlobalCallbackFactory;
import com.dropbox.core.v2.callbacks.DbxRouteErrorCallback;
import com.dropbox.core.v2.callbacks.DbxNetworkErrorCallback;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderError;
import com.dropbox.core.v2.files.ListFolderErrorException;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

import java.util.List;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class Main {
    private static final String ACCESS_TOKEN = "<ACCESS_TOKEN>";

    public static void main(String args[]) throws DbxException, IOException {
        // Create Dropbox client
        DbxRequestConfig config = new DbxRequestConfig("dropbox/java-tutorial");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        // Instantiate factory and set shared factory
        DbxRequestUtil.sharedCallbackFactory = new DbxExampleGlobalCallbackFactory();

        try {
            // Get files and folder metadata from Dropbox root directory
            client.files().listFolder("/does/not/exist/folder/");
        }
        catch (ListFolderErrorException ex) {
            System.err.println("STANDARD ROUTE ERROR HANDLER: " + ex.errorValue + "\n");
        }
        catch (DbxException ex) {
            System.err.println("STANDARD NETWORK ERROR HANDLER: " + ex + "\n");
        }

        try {
            // Get files and folder metadata from Dropbox root directory
            client.auth().tokenRevoke();
            client.files().listFolder("/does/not/exist");
        }
        catch (ListFolderErrorException ex) {
            System.err.println("STANDARD ROUTE ERROR HANDLER2: " + ex.errorValue + "\n");
        }
        catch (DbxException ex) {
            System.err.println("STANDARD NETWORK ERROR HANDLER2: " + ex + "\n");
        }
    }
}
