package com.dropbox.core.examples.authorize_beta;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuth;
import com.dropbox.core.TokenAccessType;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.oauth.DbxCredential;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * <b>Beta</b>: This feature is not available to all developers. Please do NOT use it unless you are
 * early access partner of this feature.
 *
 * An example command-line application that runs through the web-based OAuth
 * flow (using {@link DbxWebAuth}). It use the beta feature to grab short-live token as well as
 * refresh token from server. It stores all authentication related data into the new
 * DbxCredential object and save them to file.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        // Only display important log messages.
        Logger.getLogger("").setLevel(Level.WARNING);

        if (args.length != 2) {
            System.out.println("Usage: COMMAND <app-info-file> <auth-file-output>");
            System.out.println("");
            System.out.println("<app-info-file>: a JSON file with information about your API app.  Example:");
            System.out.println("");
            System.out.println("  {");
            System.out.println("    \"key\": \"Your Dropbox API app key...\",");
            System.out.println("    \"secret\": \"Your Dropbox API app secret...\"");
            System.out.println("  }");
            System.out.println("");
            System.out.println("  Get an API app key by registering with Dropbox:");
            System.out.println("    https://dropbox.com/developers/apps");
            System.out.println("");
            System.out.println("<auth-file-output>: If authorization is successful, the resulting API");
            System.out.println("  credential will be saved to this file, which can then be used with");
            System.out.println("  other example programs, such as the one in \"examples/account-info\".");
            System.out.println("");
            System.exit(1);
            return;
        }

        String argAppInfoFile = args[0];
        String argAuthFileOutput = args[1];

        // Read app info file (contains app key and app secret)
        DbxAppInfo appInfo;
        try {
            appInfo = DbxAppInfo.Reader.readFromFile(argAppInfoFile);
        } catch (JsonReader.FileLoadException ex) {
            System.err.println("Error reading <app-info-file>: " + ex.getMessage());
            System.exit(1); return;
        }

        // Run through Dropbox API authorization process
        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-authorize");
        DbxWebAuth webAuth = new DbxWebAuth(requestConfig, appInfo);
        DbxWebAuth.Request.Builder builder = DbxWebAuth.newRequestBuilder()
                .withNoRedirect().withTokenAccessType(TokenAccessType.OFFLINE);


        // TokenAccessType.OFFLINE means refresh_token + access_token. ONLINE means access_token only.
        DbxWebAuth.Request webAuthRequest =  DbxWebAuth.newRequestBuilder()
            .withNoRedirect()
            .withTokenAccessType(TokenAccessType.OFFLINE)
            .build();

        String authorizeUrl = webAuth.authorize(webAuthRequest);
        System.out.println("1. Go to " + authorizeUrl);
        System.out.println("2. Click \"Allow\" (you might have to log in first).");
        System.out.println("3. Copy the authorization code.");
        System.out.print("Enter the authorization code here: ");

        String code = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (code == null) {
            System.exit(1); return;
        }
        code = code.trim();

        DbxAuthFinish authFinish;
        try {
            authFinish = webAuth.finishFromCode(code);
        } catch (DbxException ex) {
            System.err.println("Error in DbxWebAuth.authorize: " + ex.getMessage());
            System.exit(1); return;
        }

        System.out.println("Authorization complete.");
        System.out.println("- User ID: " + authFinish.getUserId());
        System.out.println("- Account ID: " + authFinish.getAccountId());
        System.out.println("- Access Token: " + authFinish.getAccessToken());
        System.out.println("- Expires At: " + authFinish.getExpiresAt());
        System.out.println("- Refresh Token: " + authFinish.getRefreshToken());
        System.out.println("- Scope: " + authFinish.getScope());

        // Save auth information the new DbxCredential instance. It also contains app_key and
        // app_secret which is required to do refresh call.
        DbxCredential credential = new DbxCredential(authFinish.getAccessToken(), authFinish
            .getExpiresAt(), authFinish.getRefreshToken(), appInfo.getKey(), appInfo.getSecret());
        File output = new File(argAuthFileOutput);
        try {
            DbxCredential.Writer.writeToFile(credential, output);
            System.out.println("Saved authorization information to \"" + output.getCanonicalPath() + "\".");
        } catch (IOException ex) {
            System.err.println("Error saving to <auth-file-out>: " + ex.getMessage());
            System.err.println("Dumping to stderr instead:");
            DbxCredential.Writer.writeToStream(credential, System.err);
            System.exit(1); return;
        }
    }
}
