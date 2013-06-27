package com.dropbox.core.examples.account_info;

import com.dropbox.core.*;
import com.dropbox.core.json.JsonReader;

import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An example command-line application that runs through the web-based OAuth
 * flow (using {@link DbxWebAuth}).
 */
public class Main
{
    public static void main(String[] args)
        throws IOException
    {
        // Only display important log messages.
        Logger.getLogger("").setLevel(Level.WARNING);

        if (args.length == 0) {
            System.out.println("");
            System.out.println("Usage: COMMAND <auth-file>");
            System.out.println("");
            System.out.println(" <auth-file>: An \"auth file\" that contains the information necessary to make");
            System.out.println("    an authorized Dropbox API request.  Generate this file using the \"authorize\"");
            System.out.println("    example program.");
            System.out.println("");
            return;
        }

        if (args.length != 1) {
            System.err.println("Expecting exactly 1 argument, got " + args.length + ".");
            System.err.println("Run with no arguments for help.");
            System.exit(1); return;
        }

        String argAuthFile = args[0];

        // Read auth info file.
        DbxAuthInfo authInfo;
        try {
            authInfo = DbxAuthInfo.Reader.readFromFile(argAuthFile);
        }
        catch (JsonReader.FileLoadException ex) {
            System.err.println("Error loading <auth-file>: " + ex.getMessage());
            System.exit(1); return;
        }

        // Create a DbxClient, which is what you use to make API calls.
        String userLocale = Locale.getDefault().toString();
        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-account-info", userLocale);
        DbxClient dbxClient = new DbxClient(requestConfig, authInfo.accessToken, authInfo.host);

        // Make the /account/info API call.
        DbxAccountInfo dbxAccountInfo;
        try {
            dbxAccountInfo = dbxClient.getAccountInfo();
        }
        catch (DbxException ex) {
            ex.printStackTrace();
            System.err.println("Error in getAccountInfo(): " + ex.getMessage());
            System.exit(1); return;
        }
        System.out.println("User's account info: " + dbxAccountInfo.toStringMultiline());
    }
}
