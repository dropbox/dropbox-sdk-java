package com.dropbox.core.examples.global_callbacks;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.v2.DbxUserClient;
import com.dropbox.core.v2.DbxUserClientBuilder;
import com.dropbox.core.v2.files.ListFolderErrorException;

import java.io.IOException;

public class GlobalCallbacksExample {
    private static final String ACCESS_TOKEN = "<ACCESS_TOKEN>";

    public static void main(String args[]) throws DbxException, IOException {
        // Create Dropbox client
        DbxUserClient client = new DbxUserClientBuilder("dropbox/java-tutorial", ACCESS_TOKEN)
                .build();

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
