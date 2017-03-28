package com.dropbox.core.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import java.util.Arrays;

/**
 * Helper class for integrating with {@link AuthActivity}
 */
public class Auth {

    public static void startOAuth2Authentication(Context context, String appKey) {
        startOAuth2Authentication(context, appKey, null, null, null);
    }

    /**
     * Starts the Dropbox authentication process by launching an external app
     * (either the Dropbox app if available or a web browser) where the user
     * will log in and allow your app access.
     * <p>
     * This variant should be used when authentication is being done due to an OpenWith request through action
     * {@value DbxOfficialAppConnector#ACTION_DBXC_EDIT} and {@value DbxOfficialAppConnector#ACTION_DBXC_VIEW}.
     * You won't need to use this unless you are an partner who registered your app with openwith feature in our official
     * Dropbox app.
     * </p>
     *
     * @param context           the {@link Context} which to use to launch the
     *                          Dropbox authentication activity. This will typically be an
     *                          {@link Activity} and the user will be taken back to that
     *                          activity after authentication is complete (i.e., your activity
     *                          will receive an {@code onResume()}).
     * @param appKey            the app's key.
     * @param desiredUid        Encourage user to authenticate account defined by this uid.
     *                          (note that user still can authenticate other accounts).
     *                          May be null if no uid desired.
     * @param alreadyAuthedUids Array of any other uids currently authenticated with this app.
     *                          May be null if no uids previously authenticated.
     *                          Authentication screen will encourage user to not authorize these
     *                          user accounts. (note that user may still authorize the accounts).
     * @param sessionId         The SESSION_ID Extra on an OpenWith intent. null if dAuth
     *                          is being launched outside of OpenWith flow
     * @throws IllegalStateException if you have not correctly set up the AuthActivity in your
     *                               manifest, meaning that the Dropbox app will
     *                               not be able to redirect back to your app after auth.
     */
    public static void startOAuth2Authentication(Context context, String appKey, String desiredUid,
                                                 String[] alreadyAuthedUids, String sessionId) {
        if (!AuthActivity.checkAppBeforeAuth(context, appKey, true /*alertUser*/)) {
            return;
        }

        if (alreadyAuthedUids != null && Arrays.asList(alreadyAuthedUids).contains(desiredUid)) {
            throw new IllegalArgumentException("desiredUid cannot be present in alreadyAuthedUids");
        }

        // Start Dropbox auth activity.
        String apiType = "1";
        String webHost = "www.dropbox.com";
        Intent intent =  AuthActivity.makeIntent(
            context, appKey, desiredUid, alreadyAuthedUids, sessionId, webHost, apiType
        );
        if (!(context instanceof Activity)) {
            // If starting the intent outside of an Activity, must include
            // this. See startActivity(). Otherwise, we prefer to stay in
            // the same task.
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    public static String getOAuth2Token() {
        Intent data = AuthActivity.result;

        if (data == null) {
            return null;
        }

        String token = data.getStringExtra(AuthActivity.EXTRA_ACCESS_TOKEN);
        String secret = data.getStringExtra(AuthActivity.EXTRA_ACCESS_SECRET);
        String uid = data.getStringExtra(AuthActivity.EXTRA_UID);

        if (token != null && !token.equals("") &&
                secret != null && !secret.equals("") &&
                uid != null && !uid.equals("")) {
            return secret;
        }

        return null;
    }

    public static String getUid() {
        Intent data = AuthActivity.result;

        if (data == null) {
            return null;
        }

        String token = data.getStringExtra(AuthActivity.EXTRA_ACCESS_TOKEN);
        String secret = data.getStringExtra(AuthActivity.EXTRA_ACCESS_SECRET);
        String uid = data.getStringExtra(AuthActivity.EXTRA_UID);

        if (token != null && !token.equals("") &&
            secret != null && !secret.equals("") &&
            uid != null && !uid.equals("")) {
            return uid;
        }

        return null;
    }
}
