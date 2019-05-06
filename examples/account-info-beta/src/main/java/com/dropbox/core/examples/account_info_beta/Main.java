package com.dropbox.core.examples.account_info_beta;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuth;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;
import com.dropbox.core.v2.users.Name;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An example command-line application that grab access token and refresh token from credential
 * file, and then call APIV2.
 */
public class Main
{
    public static void main(String[] args)
        throws IOException
    {
        // Only display important log messages.
        Logger.getLogger("").setLevel(Level.WARNING);

        if (args.length != 1) {
            System.out.println("");
            System.out.println("Usage: COMMAND <auth-file>");
            System.out.println("");
            System.out.println(" <auth-file>: An \"auth file\" that contains the information necessary to make");
            System.out.println("    an authorized Dropbox API request.  Generate this file using the");
            System.out.println("    \"authorize-beta\" example program.");
            System.out.println("");
            System.exit(1);
            return;
        }

        String argAuthFile = args[0];

        // Read auth from file.
        DbxCredential credential;
        try {
            credential = DbxCredential.Reader.readFromFile(argAuthFile);
        }
        catch (JsonReader.FileLoadException ex) {
            System.err.println("Error loading <auth-file>: " + ex.getMessage());
            System.exit(1); return;
        }

        // Create a DbxClientV2, which is what you use to make API calls.
        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-account-info");
        // Use credential to create dbx client.
        DbxClientV2 dbxClient = new DbxClientV2(requestConfig, credential);

        // Make the /account/info API call.
        FullAccount dbxAccountInfo;
        try {
            dbxAccountInfo = dbxClient.users()
                .getCurrentAccount();
        }
        catch (DbxException ex) {
            System.err.println("Error making API call: " + ex.getMessage());
            System.exit(1); return;
        }

        System.out.print(dbxAccountInfo.toStringMultiline());
    }
}
