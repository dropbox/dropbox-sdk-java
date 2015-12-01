package com.dropbox.core.examples.upgrade_oauth1_token;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthInfo;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxOAuth1AccessToken;
import com.dropbox.core.DbxOAuth1Upgrader;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.json.JsonReader;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An example command-line application that converts the given OAuth 1 access
 * token to an OAuth 2 access token and then disables the original OAuth 1 access
 * token.
 */
public class Main
{
    public static void main(String[] args)
        throws IOException
    {
        // Only display important log messages.
        Logger.getLogger("").setLevel(Level.INFO);

        Config cfg = parseArgs(args);
        if (cfg == null) {
            System.exit(1); return;
        }

        // Read app info file (contains app key and app secret)
        DbxAppInfo appInfo;
        try {
            appInfo = DbxAppInfo.Reader.readFromFile(cfg.appInfoFile);
        }
        catch (JsonReader.FileLoadException ex) {
            System.err.println("Error reading <app-info-file>: " + ex.getMessage());
            System.exit(1); return;
        }

        DbxOAuth1AccessToken oauth1AccessToken =
                new DbxOAuth1AccessToken(cfg.accessTokenKey, cfg.accessTokenSecret);

        // Get an OAuth 2 access token.
        String userLocale = Locale.getDefault().toString();
        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-authorize", userLocale);
        DbxOAuth1Upgrader upgrader = new DbxOAuth1Upgrader(requestConfig, appInfo);

        String oauth2AccessToken ;
        try {
            oauth2AccessToken = upgrader.createOAuth2AccessToken(oauth1AccessToken);
        }
        catch (DbxException ex) {
            System.err.println("Error getting OAuth 2 access token: " + ex.getMessage());
            System.exit(1); return;
        }

        System.out.println("OAuth 2 access token obtained.");
        DbxAuthInfo authInfo = new DbxAuthInfo(oauth2AccessToken, appInfo.host);
        DbxAuthInfo.Writer.writeToStream(authInfo, System.out);
        System.out.println();

        // Disable the OAuth 1 access token.
        if (cfg.disable) {
            try {
                upgrader.disableOAuth1AccessToken(oauth1AccessToken);
            }
            catch (DbxException ex) {
                System.err.println("Error disabling OAuth 1 access token: " + ex.getMessage());
                System.exit(1); return;
            }
            System.out.println("OAuth 1 access token disabled.");
        }
    }

    private static void printHelp(PrintStream out)
    {
        out.println("Usage: COMMAND <app-info-file> <oa1-access-token-key> <oa1-access-token-secret>");
        out.println("");
        out.println("<app-info-file>: a JSON file with information about your API app.  Example:");
        out.println("");
        out.println("  {");
        out.println("    \"key\": \"Your Dropbox API app key...\",");
        out.println("    \"secret\": \"Your Dropbox API app secret...\"");
        out.println("  }");
        out.println("");
        out.println("  Get an API app key by registering with Dropbox:");
        out.println("    https://dropbox.com/developers/apps");
        out.println("");
        out.println("<oa1-access-token-key>: The OAuth 1 access token key.");
        out.println("");
        out.println("<oa1-access-token-secret>: The OAuth 1 access token secret.");
        out.println("");
        out.println("Options:");
        out.println("");
        out.println("  --disable: After we get an OAuth 2 access token, tell the server to");
        out.println("      disable the OAuth 1 access token.");
        out.println("");
    }

    private static final class Config
    {
        public final String appInfoFile;
        public final String accessTokenKey;
        public final String accessTokenSecret;
        public final boolean disable;

        public Config(String appInfoFile, String accessTokenKey, String accessTokenSecret, boolean disable)
        {
            this.appInfoFile = appInfoFile;
            this.accessTokenKey = accessTokenKey;
            this.accessTokenSecret = accessTokenSecret;
            this.disable = disable;
        }
    }

    private static Config parseArgs(String[] args)
    {
        if (args.length == 0) {
            printHelp(System.out);
            return null;
        }

        ArrayList<String> remainingArgs = new ArrayList<String>();
        boolean optionsAllowed = true;
        boolean disable = false;
        for (String arg : args) {
            if (optionsAllowed && arg.startsWith("-")) {
                if (arg.equals("--")) {
                    optionsAllowed = false;
                    continue;
                }
                if (arg.equals("--disable")) {
                    if (disable) {
                        System.err.println("Option \"--disable\" used more than once.");
                        return null;
                    }
                    disable = true;
                }
                else {
                    System.err.println("Unrecognized option \"" + arg + "\".");
                    System.err.println("Run with no arguments for help.");
                    return null;
                }
            }
            else {
                remainingArgs.add(arg);
            }
        }

        if (remainingArgs.size() != 3) {
            System.err.println("Expecting at least 3 non-option arguments, got " + remainingArgs.size() + ".");
            System.err.println("Run with no arguments for help.");
            return null;
        }

        return new Config(remainingArgs.get(0), remainingArgs.get(1), remainingArgs.get(2), disable);
    }
}
