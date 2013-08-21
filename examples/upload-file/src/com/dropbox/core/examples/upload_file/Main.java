package com.dropbox.core.examples.upload_file;

import com.dropbox.core.*;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.util.IOUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
        int code = _main(args);
        System.exit(code);
    }

    private static int _main(String[] args)
        throws IOException
    {
        // Only display important log messages.
        Logger.getLogger("").setLevel(Level.WARNING);

        if (args.length == 0) {
            System.out.println("");
            System.out.println("Usage: COMMAND <auth-file> <local-path> <dropbox-path>");
            System.out.println("");
            System.out.println(" <auth-file>: An \"auth file\" that contains the information necessary to make");
            System.out.println("    an authorized Dropbox API request.  Generate this file using the \"authorize\"");
            System.out.println("    example program.");
            System.out.println("");
            System.out.println(" <local-path>: The path to a local file whose contents you want to upload.");
            System.out.println("");
            System.out.println(" <dropbox-path>: The path on Dropbox to save the file to.");
            System.out.println("");
            return 0;
        }

        if (args.length != 3) {
            System.err.println("Expecting exactly 3 arguments, got " + args.length + ".");
            System.err.println("Run with no arguments for help.");
            return 1;
        }

        String argAuthFile = args[0];
        String localPath = args[1];
        String dropboxPath = args[2];

        // Read auth info file.
        DbxAuthInfo authInfo;
        try {
            authInfo = DbxAuthInfo.Reader.readFromFile(argAuthFile);
        }
        catch (JsonReader.FileLoadException ex) {
            System.err.println("Error loading <auth-file>: " + ex.getMessage());
            return 1;
        }

        String pathError = DbxPath.findError(dropboxPath);
        if (pathError != null) {
            System.err.println("Invalid <dropbox-path>: " + pathError);
            return 1;
        }

        // Create a DbxClient, which is what you use to make API calls.
        String userLocale = Locale.getDefault().toString();
        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-upload-file", userLocale);
        DbxClient dbxClient = new DbxClient(requestConfig, authInfo.accessToken, authInfo.host);

        // Make the API call to upload the file.
        DbxEntry.File metadata;
        try {
            InputStream in = new FileInputStream(localPath);
            try {
                metadata = dbxClient.uploadFile(dropboxPath, DbxWriteMode.add(), -1, in);
            } catch (DbxException ex) {
                System.out.println("Error uploading to Dropbox: " + ex.getMessage());
                return 1;
            } finally {
                IOUtil.closeInput(in);
            }
        }
        catch (IOException ex) {
            System.out.println("Error reading from file \"" + localPath + "\": " + ex.getMessage());
            return 1;
        }

        System.out.print(metadata.toStringMultiline());
        return 0;
    }
}
