package src.main.java.com.dropbox.core.examples.authorize_beta;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuth;
import com.dropbox.core.IncludeGrantedScopes;
import com.dropbox.core.TokenAccessType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Use include_granted_scopes when you ask for a small amount of permission at beginning, and
 * then incrementally ask for more permission when user hit certain feature.
 * The token contains all previously granted scopes.
 */
public class IncrementalScopeAuthorize {
    public DbxAuthFinish authorize(DbxAppInfo appInfo) throws IOException {
        // Run through Dropbox API authorization process
        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-authorize");
        DbxWebAuth webAuth = new DbxWebAuth(requestConfig, appInfo);

        // Ask for account_info.read scope
        DbxWebAuth.Request webAuthRequest =  DbxWebAuth.newRequestBuilder()
            .withNoRedirect()
            .withTokenAccessType(TokenAccessType.OFFLINE)
            .withScope("account_info.read")
            .withIncludeGrantedScopes(IncludeGrantedScopes.USER)
            .build();

        String authorizeUrl = webAuth.authorize(webAuthRequest);
        System.out.println("1. Go to " + authorizeUrl);
        System.out.println("2. Click \"Allow\" (you might have to log in first).");
        System.out.println("3. Copy the authorization code.");
        System.out.print("Enter the authorization code here: ");

        String code = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (code == null) {
            System.exit(1);
        }
        code = code.trim();

        try {
            DbxAuthFinish authFinish = webAuth.finishFromCode(code);

            if (!authFinish.getScope().contains("account_info.read")) {
                System.err.println("You app doesn't have account_info.read scope. Can't finish " +
                    "this example.");
                System.exit(1); return null;
            }

            System.out.println("Successfully requested scope account_info.read");
            return authFinish;
        } catch (DbxException ex) {
            System.err.println("Error in DbxWebAuth.authorize: " + ex.getMessage());
            System.exit(1); return null;
        }
    }
}
