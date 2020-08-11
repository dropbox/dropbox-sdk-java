package com.dropbox.core.examples.authorize;

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
import java.util.Arrays;
import java.util.Collections;


/**
 * You must have an api app migrated to new permission to run this example. You app must have
 * scopes "account_info.read", "files.metadata.write", "files.content.read" and
 * "files.content.write" to run this example. You can manage your app's scopes inside your app
 * console's permisison tab.
 *
 * This example goes through 3 different flows:
 *  Step 1: Kick off initial authorization with only "account_info.read" scope
 *  Step 2: Request a different scope "files.metadata.write"
 *  Step 3: Request "files.content.read" and "files.content.write", along with all previously
 *  granted scopes using include_granted_scopes.
 */
public class ScopeAuthorize {
    public DbxAuthFinish authorize(DbxAppInfo appInfo) throws IOException {
        // Run through Dropbox API authorization process
        DbxRequestConfig requestConfig = new DbxRequestConfig("examples-authorize");
        DbxWebAuth webAuth = new DbxWebAuth(requestConfig, appInfo);

        // OAuth2 flow 1: Ask for account_info.read scope. Get a token with account_info.read
        DbxWebAuth.Request webAuthRequest =  DbxWebAuth.newRequestBuilder()
            .withNoRedirect()
            .withTokenAccessType(TokenAccessType.OFFLINE)
            .withScope(Collections.singletonList("account_info.read"))
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

            assert authFinish.getScope().contains("account_info.read");

            if (!authFinish.getScope().contains("account_info.read")) {
                System.err.println("You app doesn't have account_info.read scope. Can't finish " +
                    "this example.");
                System.exit(1); return null;
            }

            System.out.println("Successfully requested scope " + authFinish.getScope());
        } catch (DbxException ex) {
            System.err.println("Error in DbxWebAuth.authorize: " + ex.getMessage());
            System.exit(1); return null;
        }


        // OAuth2 flow 2: Ask for files.metadata.write only. Get a token with files.metadata
        // .write and its dependency files.metadata.read.
        webAuthRequest = DbxWebAuth.newRequestBuilder()
            .withNoRedirect()
            .withTokenAccessType(TokenAccessType.OFFLINE)
            .withScope(Collections.singletonList("files.metadata.write"))
            .build();

        authorizeUrl = webAuth.authorize(webAuthRequest);
        System.out.println("1. Go to " + authorizeUrl);
        System.out.println("2. Click \"Allow\" (you might have to log in first).");
        System.out.println("3. Copy the authorization code.");
        System.out.print("Enter the authorization code here: ");

        code = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (code == null) {
            System.exit(1);
        }
        code = code.trim();

        try {
            DbxAuthFinish authFinish = webAuth.finishFromCode(code);

            if (!authFinish.getScope().contains("files.metadata.write")) {
                System.err.println("You app doesn't have files.metadata.write scope. Can't finish " +
                    "this example.");
                System.exit(1); return null;
            }

            assert !authFinish.getScope().contains("account_info.read");

            System.out.println("Successfully requested scope " + authFinish.getScope());
        } catch (DbxException ex) {
            System.err.println("Error in DbxWebAuth.authorize: " + ex.getMessage());
            System.exit(1); return null;
        }


        // Oauth2 flow 3: Ask for "files.content.read" and "files.content.write", along with all
        // previously granted scopes.
        webAuthRequest = DbxWebAuth.newRequestBuilder()
            .withNoRedirect()
            .withTokenAccessType(TokenAccessType.OFFLINE)
            .withScope(Arrays.asList("files.content.read", "files.content.write"))
            .withIncludeGrantedScopes(IncludeGrantedScopes.USER)
            .build();

        authorizeUrl = webAuth.authorize(webAuthRequest);
        System.out.println("1. Go to " + authorizeUrl);
        System.out.println("2. Click \"Allow\" (you might have to log in first).");
        System.out.println("3. Copy the authorization code.");
        System.out.print("Enter the authorization code here: ");

        code = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if (code == null) {
            System.exit(1);
        }
        code = code.trim();

        try {
            DbxAuthFinish authFinish = webAuth.finishFromCode(code);

            if (!authFinish.getScope().contains("files.content.read")) {
                System.err.println("You app doesn't have files.content.read scope. Can't finish " +
                    "this example.");
                System.exit(1); return null;
            }

            if (!authFinish.getScope().contains("files.content.write")) {
                System.err.println("You app doesn't have files.content.write scope. Can't finish" +
                    " " +
                    "this example.");
                System.exit(1); return null;
            }

            assert authFinish.getScope().contains("account_info.read");
            assert authFinish.getScope().contains("files.metadata.write");

            System.out.println("Successfully requested scope " + authFinish.getScope());
            return authFinish;
        } catch (DbxException ex) {
            System.err.println("Error in DbxWebAuth.authorize: " + ex.getMessage());
            System.exit(1); return null;
        }

    }
}
