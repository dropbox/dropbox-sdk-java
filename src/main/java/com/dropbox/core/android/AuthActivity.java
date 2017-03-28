package com.dropbox.core.android;

import java.security.SecureRandom;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.dropbox.core.DbxRequestUtil;

//Note: This class's code is duplicated between Core SDK and Sync SDK.  For now,
//it has to be manually copied, but the code is set up so that it can be used in both
//places, with only a few import changes above.  If you're making changes here, you
//should consider if the other side needs them.  Don't break compatibility if you
//don't have to.  This is a hack we should get away from eventually.

/**
 * This activity is used internally for authentication, but must be exposed both
 * so that Android can launch it and for backwards compatibility.
 */
public class AuthActivity extends Activity {
    private static final String TAG = AuthActivity.class.getName();

    /**
     * The extra that goes in an intent to provide your consumer key for
     * Dropbox authentication. You won't ever have to use this.
     */
    public static final String EXTRA_CONSUMER_KEY = "CONSUMER_KEY";

    /**
     * The extra that goes in an intent when returning from Dropbox auth to
     * provide the user's access token, if auth succeeded. You won't ever have
     * to use this.
     */
    public static final String EXTRA_ACCESS_TOKEN = "ACCESS_TOKEN";

    /**
     * The extra that goes in an intent when returning from Dropbox auth to
     * provide the user's access token secret, if auth succeeded. You won't
     * ever have to use this.
     */
    public static final String EXTRA_ACCESS_SECRET = "ACCESS_SECRET";

    /**
     * The extra that goes in an intent when returning from Dropbox auth to
     * provide the user's Dropbox UID, if auth succeeded. You won't ever have
     * to use this.
     */
    public static final String EXTRA_UID = "UID";

    /**
     * Used for internal authentication. You won't ever have to use this.
     */
    public static final String EXTRA_CONSUMER_SIG = "CONSUMER_SIG";

    /**
     * Used for internal authentication. You won't ever have to use this.
     */
    public static final String EXTRA_CALLING_PACKAGE = "CALLING_PACKAGE";

    /**
     * Used for internal authentication. You won't ever have to use this.
     */
    public static final String EXTRA_CALLING_CLASS = "CALLING_CLASS";

    /**
     * Used for internal authentication. You won't ever have to use this.
     */
    public static final String EXTRA_AUTH_STATE = "AUTH_STATE";

    /**
     * Used for internal authentication. Allows app to request a specific UID to auth against
     * You won't ever have to use this.
     */
    public static final String EXTRA_DESIRED_UID = "DESIRED_UID";

    /**
     * Used for internal authentication. Allows app to request array of UIDs that should not be auth'd
     * You won't ever have to use this.
     */
    public static final String EXTRA_ALREADY_AUTHED_UIDS = "ALREADY_AUTHED_UIDS";

    /**
     * Used for internal authentication. Allows app to transfer session info to/from DbApp
     * You won't ever have to use this.
     */
    public static final String EXTRA_SESSION_ID = "SESSION_ID";

    /**
     * The Android action which the official Dropbox app will accept to
     * authenticate a user. You won't ever have to use this.
     */
    public static final String ACTION_AUTHENTICATE_V1 = "com.dropbox.android.AUTHENTICATE_V1";

    /**
     * The Android action which the official Dropbox app will accept to
     * authenticate a user. You won't ever have to use this.
     */
    public static final String ACTION_AUTHENTICATE_V2 = "com.dropbox.android.AUTHENTICATE_V2";

    /**
     * The version of the API for the web-auth callback with token (not the initial auth request).
     */
    public static final int AUTH_VERSION = 1;

    /**
     * The path for a successful callback with token (not the initial auth request).
     */
    public static final String AUTH_PATH_CONNECT = "/connect";

    private static final String DEFAULT_WEB_HOST = "www.dropbox.com";

    // saved instance state keys
    private static final String SIS_KEY_AUTH_STATE_NONCE = "SIS_KEY_AUTH_STATE_NONCE";

    /**
     * Provider of the local security needs of an AuthActivity.
     *
     * <p>
     * You shouldn't need to use this class directly in your app.  Instead,
     * simply configure {@code java.security}'s providers to match your preferences.
     * </p>
     */
    public interface SecurityProvider {
        /**
         * Gets a SecureRandom implementation for use during authentication.
         */
        SecureRandom getSecureRandom();
    }

    // Class-level state used to replace the default SecureRandom implementation
    // if desired.
    private static SecurityProvider sSecurityProvider = new SecurityProvider() {
        @Override
        public SecureRandom getSecureRandom() {
            return FixedSecureRandom.get();
        }
    };
    private static final Object sSecurityProviderLock = new Object();

    /** Used internally. */
    public static Intent result = null;

    // Temporary storage for parameters before Activity is created
    private static String sAppKey;
    private static String sWebHost = DEFAULT_WEB_HOST;
    private static String sApiType;
    private static String sDesiredUid;
    private static String[] sAlreadyAuthedUids;
    private static String sSessionId;

    // These instance variables need not be stored in savedInstanceState as onNewIntent()
    // does not read them.
    private String mAppKey;
    private String mWebHost;
    private String mApiType;
    private String mDesiredUid;
    private String[] mAlreadyAuthedUids;
    private String mSessionId;

    // Stored in savedInstanceState to track an ongoing auth attempt, which
    // must include a locally-generated nonce in the response.
    private String mAuthStateNonce = null;

    private boolean mActivityDispatchHandlerPosted = false;

    /**
     * Set static authentication parameters
     */
    static void setAuthParams(String appKey, String desiredUid,
                              String[] alreadyAuthedUids) {
        setAuthParams(appKey, desiredUid, alreadyAuthedUids, null);
    }



    /**
     * Set static authentication parameters
     */
    static void setAuthParams(String appKey, String desiredUid,
                              String[] alreadyAuthedUids, String webHost, String apiType) {
        setAuthParams(appKey, desiredUid, alreadyAuthedUids, null, null, null);
    }

    /**
     * Set static authentication parameters
     */
    static void setAuthParams(String appKey, String desiredUid,
                              String[] alreadyAuthedUids, String sessionId) {
        setAuthParams(appKey, desiredUid, alreadyAuthedUids, sessionId, null, null);
    }

    /**
     * Set static authentication parameters
     */
    static void setAuthParams(String appKey, String desiredUid,
                              String[] alreadyAuthedUids, String sessionId, String webHost, String apiType) {
        sAppKey = appKey;
        sDesiredUid = desiredUid;
        sAlreadyAuthedUids = (alreadyAuthedUids != null) ? alreadyAuthedUids : new String[0];
        sSessionId = sessionId;
        sWebHost = (webHost != null) ? webHost : DEFAULT_WEB_HOST;
        sApiType = apiType;
    }

    /**
     * Create an intent which can be sent to this activity to start OAuth 2 authentication.
     *
     * @param context the source context
     * @param appKey the consumer key for the app
     * @param webHost the host to use for web authentication, or null for the default
     * @param apiType an identifier for the type of API being supported, or null for
     *  the default
     *
     * @return a newly created intent.
     */
    public static Intent makeIntent(Context context, String appKey, String webHost,
                                          String apiType) {
        if (appKey == null) throw new IllegalArgumentException("'appKey' can't be null");
        setAuthParams(appKey, null, null, webHost, apiType);
        return new Intent(context, AuthActivity.class);
    }

    /**
     * Check's the current app's manifest setup for authentication.
     * If the manifest is incorrect, an exception will be thrown.
     * If another app on the device is conflicting with this one,
     * the user will (optionally) be alerted and false will be returned.
     *
     * @param context the app context
     * @param appKey the consumer key for the app
     * @param alertUser whether to alert the user for the case where
     *  multiple apps are conflicting.
     *
     * @return {@code true} if this app is properly set up for authentication.
     */
    public static boolean checkAppBeforeAuth(Context context, String appKey, boolean alertUser) {
        // Check if the app has set up its manifest properly.
        Intent testIntent = new Intent(Intent.ACTION_VIEW);
        String scheme = "db-" +appKey;
        String uri = scheme + "://" + AUTH_VERSION + AUTH_PATH_CONNECT;
        testIntent.setData(Uri.parse(uri));
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(testIntent, 0);

        if (null == activities || 0 == activities.size()) {
            throw new IllegalStateException("URI scheme in your app's " +
                    "manifest is not set up correctly. You should have a " +
                    AuthActivity.class.getName() + " with the " +
                    "scheme: " + scheme);
        } else if (activities.size() > 1) {
            if (alertUser) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Security alert");
                builder.setMessage("Another app on your phone may be trying to " +
                        "pose as the app you are currently using. The malicious " +
                        "app can't access your account, but linking to Dropbox " +
                        "has been disabled as a precaution. Please contact " +
                        "support@dropbox.com.");
                builder.setPositiveButton("OK", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            } else {
                Log.w(TAG, "There are multiple apps registered for the AuthActivity " +
                        "URI scheme (" + scheme + ").  Another app may be trying to " +
                        " impersonate this app, so authentication will be disabled.");
            }
            return false;
        } else {
            // Just one activity registered for the URI scheme. Now make sure
            // it's within the same package so when we return from web auth
            // we're going back to this app and not some other app.
            ResolveInfo resolveInfo = activities.get(0);
            if (null == resolveInfo || null == resolveInfo.activityInfo
                    || !context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
                throw new IllegalStateException("There must be a " +
                        AuthActivity.class.getName() + " within your app's package " +
                        "registered for your URI scheme (" + scheme + "). However, " +
                        "it appears that an activity in a different package is " +
                        "registered for that scheme instead. If you have " +
                        "multiple apps that all want to use the same access" +
                        "token pair, designate one of them to do " +
                        "authentication and have the other apps launch it " +
                        "and then retrieve the token pair from it.");
            }
        }

        return true;
    }

    /**
     * Sets the SecurityProvider interface to use for all AuthActivity instances.
     * If set to null (or never set at all), default {@code java.security} providers
     * will be used instead.
     *
     * <p>
     * You shouldn't need to use this method directly in your app.  Instead,
     * simply configure {@code java.security}'s providers to match your preferences.
     * </p>
     *
     * @param prov the new {@code SecurityProvider} interface.
     */
    public static void setSecurityProvider(SecurityProvider prov) {
        synchronized (sSecurityProviderLock) {
            sSecurityProvider = prov;
        }
    }

    private static SecurityProvider getSecurityProvider() {
        synchronized (sSecurityProviderLock) {
            return sSecurityProvider;
        }
    }

    private static SecureRandom getSecureRandom() {
        SecurityProvider prov = getSecurityProvider();
        if (null != prov) {
            return prov.getSecureRandom();
        }
        return new SecureRandom();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAppKey = sAppKey;
        mWebHost = sWebHost;
        mApiType = sApiType;
        mDesiredUid = sDesiredUid;
        mAlreadyAuthedUids = sAlreadyAuthedUids;
        mSessionId = sSessionId;

        if (savedInstanceState == null) {
            result = null;
            mAuthStateNonce = null;
        } else {
            mAuthStateNonce = savedInstanceState.getString(SIS_KEY_AUTH_STATE_NONCE);
        }

        setTheme(android.R.style.Theme_Translucent_NoTitleBar);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SIS_KEY_AUTH_STATE_NONCE, mAuthStateNonce);
    }

    /**
     * @return Intent to auth with official app
     * Extras should be filled in by callee
     */
    static Intent getOfficialAuthIntent() {
        Intent authIntent = new Intent(ACTION_AUTHENTICATE_V2);
        authIntent.setPackage("com.dropbox.android");
        return authIntent;
    }


    @Override
    protected void onResume() {
        super.onResume();

        if (isFinishing()) {
            return;
        }

        if (mAuthStateNonce != null || mAppKey == null) {
            // We somehow returned to this activity without being forwarded
            // here by the official app.
            // Most commonly caused by user hitting "back" from the auth screen
            // or (if doing browser auth) task switching from auth task back to
            // this one.
            authFinished(null);
            return;
        }

        result = null;

        if (mActivityDispatchHandlerPosted) {
            Log.w(TAG, "onResume called again before Handler run");
            return;
        }

        // Random entropy passed through auth makes sure we don't accept a
        // response which didn't come from our request.  Each random
        // value is only ever used once.
        final String state = createStateNonce();

        // Create intent to auth with official app.
        final Intent officialAuthIntent = getOfficialAuthIntent();
        officialAuthIntent.putExtra(EXTRA_CONSUMER_KEY, mAppKey);
        officialAuthIntent.putExtra(EXTRA_CONSUMER_SIG, "");
        officialAuthIntent.putExtra(EXTRA_DESIRED_UID, mDesiredUid);
        officialAuthIntent.putExtra(EXTRA_ALREADY_AUTHED_UIDS, mAlreadyAuthedUids);
        officialAuthIntent.putExtra(EXTRA_SESSION_ID, mSessionId);
        officialAuthIntent.putExtra(EXTRA_CALLING_PACKAGE, getPackageName());
        officialAuthIntent.putExtra(EXTRA_CALLING_CLASS, getClass().getName());
        officialAuthIntent.putExtra(EXTRA_AUTH_STATE, state);

        /*
         * An Android bug exists where onResume may be called twice in rapid succession.
         * As mAuthNonceState would already be set at start of the second onResume, auth would fail.
         * Empirical research has found that posting the remainder of the auth logic to a handler
         * mitigates the issue by delaying remainder of auth logic to after the
         * previously posted onResume.
         */
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {

                Log.d(TAG, "running startActivity in handler");
                try {
                    // Auth with official app, or fall back to web.
                    if (DbxOfficialAppConnector.getDropboxAppPackage(AuthActivity.this, officialAuthIntent) != null) {
                        startActivity(officialAuthIntent);
                    } else {
                        startWebAuth(state);
                    }
                } catch (ActivityNotFoundException e) {
                    Log.e(TAG, "Could not launch intent. User may have restricted profile", e);
                    finish();
                    return;
                }
                // Save state that indicates we started a request, only after
                // we started one successfully.
                mAuthStateNonce = state;
                setAuthParams(null, null, null);
            }
        });

        mActivityDispatchHandlerPosted = true;
    }


    @Override
    protected void onNewIntent(Intent intent) {
        // Reject attempt to finish authentication if we never started (nonce=null)
        if (null == mAuthStateNonce) {
            authFinished(null);
            return;
        }

        String token = null, secret = null, uid = null, state = null;

        if (intent.hasExtra(EXTRA_ACCESS_TOKEN)) {
            // Dropbox app auth.
            token = intent.getStringExtra(EXTRA_ACCESS_TOKEN);
            secret = intent.getStringExtra(EXTRA_ACCESS_SECRET);
            uid = intent.getStringExtra(EXTRA_UID);
            state = intent.getStringExtra(EXTRA_AUTH_STATE);
        } else {
            // Web auth.
            Uri uri = intent.getData();
            if (uri != null) {
                String path = uri.getPath();
                if (AUTH_PATH_CONNECT.equals(path)) {
                    try {
                        token = uri.getQueryParameter("oauth_token");
                        secret = uri.getQueryParameter("oauth_token_secret");
                        uid = uri.getQueryParameter("uid");
                        state = uri.getQueryParameter("state");
                    } catch (UnsupportedOperationException e) {}
                }
            }
        }

        Intent newResult;
        if (token != null && !token.equals("") &&
                (secret != null && !secret.equals("")) &&
                uid != null && !uid.equals("") &&
                state != null && !state.equals("")) {
            // Reject attempt to link if the nonce in the auth state doesn't match,
            // or if we never asked for auth at all.
            if (!mAuthStateNonce.equals(state)) {
                authFinished(null);
                return;
            }

            // Successful auth.
            newResult = new Intent();
            newResult.putExtra(EXTRA_ACCESS_TOKEN, token);
            newResult.putExtra(EXTRA_ACCESS_SECRET, secret);
            newResult.putExtra(EXTRA_UID, uid);
        } else {
            // Unsuccessful auth, or missing required parameters.
            newResult = null;
        }

        authFinished(newResult);
    }

    private void authFinished(Intent authResult) {
        result = authResult;
        mAuthStateNonce = null;
        setAuthParams(null, null, null);
        finish();
    }

    private void startWebAuth(String state) {
        String path = "1/connect";
        Locale locale = Locale.getDefault();

        // Web Auth currently does not support desiredUid and only one alreadyAuthUid (param n).
        // We use first alreadyAuthUid arbitrarily.
        // Note that the API treats alreadyAuthUid of 0 and not present equivalently.
        String alreadyAuthedUid = (mAlreadyAuthedUids.length > 0) ? mAlreadyAuthedUids[0] : "0";

        String[] params = {
                "k", mAppKey,
                "n", alreadyAuthedUid,
                "api", mApiType,
                "state", state};

        String url = DbxRequestUtil.buildUrlWithParams(locale.toString(), mWebHost, path, params);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private String createStateNonce() {
        final int NONCE_BYTES = 16; // 128 bits of randomness.
        byte randomBytes[] = new byte[NONCE_BYTES];
        getSecureRandom().nextBytes(randomBytes);
        StringBuilder sb = new StringBuilder();
        sb.append("oauth2:");
        for (int i = 0; i < NONCE_BYTES; ++i) {
            sb.append(String.format("%02x", (randomBytes[i]&0xff)));
        }
        return sb.toString();
    }
}
