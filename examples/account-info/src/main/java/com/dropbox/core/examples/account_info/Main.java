package com.dropbox.core.examples.account_info;

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
 *
 * An example command-line application that grab access token and refresh token from credential
 * file, and then call APIV2. If the access token has expired, SDK will automatically refresh and
 * get a new one, and store them into the original DbxCredential object.
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
            System.out.println("    \"authorize\" example program.");
            System.out.println("");
            System.exit(1);
            return;
        }

        String argAuthFile = args[0];

        // Use DbxCredential instead of DbxAuthInfo.
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
        // Use DbxCredential to create dbx client.
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
