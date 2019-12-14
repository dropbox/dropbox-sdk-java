package com.dropbox.core.examples.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.dropbox.core.android.Auth;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.oauth.DbxCredential;


/**
 * Base class for Activities that require auth tokens
 * Will redirect to auth flow if needed
 */
public abstract class DropboxActivity extends AppCompatActivity {

    private final static boolean USE_SLT = false; //If USE_SLT is set to true, our Android example
    // will use our beta feature Short Live Token.

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getSharedPreferences("dropbox-sample", MODE_PRIVATE);

        if (USE_SLT) {
            String serailizedCredental = prefs.getString("credential", null);

            if (serailizedCredental == null) {
                DbxCredential credential = Auth.getDbxCredential();

                if (credential != null) {
                    prefs.edit().putString("credential", credential.toString()).apply();
                    initAndLoadData(credential);
                }
            } else {
                try {
                    DbxCredential credential = DbxCredential.Reader.readFully(serailizedCredental);
                    initAndLoadData(credential);
                } catch (JsonReadException e) {
                    throw new IllegalStateException("Credential data corrupted: " + e.getMessage());
                }
            }

        } else {
            String accessToken = prefs.getString("access-token", null);
            if (accessToken == null) {
                accessToken = Auth.getOAuth2Token();
                if (accessToken != null) {
                    prefs.edit().putString("access-token", accessToken).apply();
                    initAndLoadData(accessToken);
                }
            } else {
                initAndLoadData(accessToken);
            }
        }

        String uid = Auth.getUid();
        String storedUid = prefs.getString("user-id", null);
        if (uid != null && !uid.equals(storedUid)) {
            prefs.edit().putString("user-id", uid).apply();
        }
    }

    private void initAndLoadData(String accessToken) {
        DropboxClientFactory.init(accessToken);
        PicassoClient.init(getApplicationContext(), DropboxClientFactory.getClient());
        loadData();
    }

    private void initAndLoadData(DbxCredential dbxCredential) {
        DropboxClientFactory.init(dbxCredential);
        PicassoClient.init(getApplicationContext(), DropboxClientFactory.getClient());
        loadData();
    }

    protected abstract void loadData();

    protected boolean hasToken() {
        SharedPreferences prefs = getSharedPreferences("dropbox-sample", MODE_PRIVATE);
        if (USE_SLT) {
            return prefs.getString("credential", null) != null;
        } else {
            String accessToken = prefs.getString("access-token", null);
            return accessToken != null;
        }
    }

    public static void startOAuth2Authentication(Context context, String app_key, String scope) {
        if (USE_SLT) {
            Auth.startOAuth2PKCE(context, app_key, DbxRequestConfigFactory.getRequestConfig(), scope);
        } else {
            Auth.startOAuth2Authentication(context, app_key);
        }
    }
}
