package com.dropbox.core.android;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
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
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxPKCEManager;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxRequestUtil;
import com.dropbox.core.IncludeGrantedScopes;
import com.dropbox.core.TokenAccessType;

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

    public static final String EXTRA_REFRESH_TOKEN = "REFRESH_TOKEN";

    public static final String EXTRA_EXPIRES_AT = "EXPIRES_AT";

    public static final String EXTRA_SCOPE = "SCOPE";

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
     * Used for internal authentication. You won't ever have to use this.
     */
    public static final String EXTRA_AUTH_QUERY_PARAMS = "AUTH_QUERY_PARAMS";

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

    // saved instance PKCE manger key
    private static final String SIS_KEY_PKCE_CODE_VERIFIER = "SIS_KEY_PKCE_CODE_VERIFIER";
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
    private static String sApiType;
    private static String sDesiredUid;
    private static String[] sAlreadyAuthedUids;
    private static String sSessionId;
    private static TokenAccessType sTokenAccessType;
    private static DbxRequestConfig sRequestConfig;
    private static DbxHost sHost;
    private static String sScope;
    private static IncludeGrantedScopes sIncludeGrantedScopes;

    // These instance variables need not be stored in savedInstanceState as onNewIntent()
    // does not read them.
    private String mAppKey;
    private String mApiType;
    private String mDesiredUid;
    private String[] mAlreadyAuthedUids;
    private String mSessionId;
    private TokenAccessType mTokenAccessType;
    private DbxPKCEManager mPKCEManager;
    private DbxRequestConfig mRequestConfig;
    private DbxHost mHost;
    private String mScope;
    private IncludeGrantedScopes mIncludeGrantedScopes;

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
        setAuthParams(appKey, desiredUid, alreadyAuthedUids, null, null, null, null, null, null,
            null, null);
    }

    /**
     * Set static authentication parameters
     */
    static void setAuthParams(String appKey, String desiredUid,
                              String[] alreadyAuthedUids, String sessionId) {
        setAuthParams(appKey, desiredUid, alreadyAuthedUids, sessionId, null, null, null, null,
            null, null, null);
    }

    /**
     * Set static authentication parameters. If both host and webHost are provided, we take use
     * host as source of truth.
     */
    static void setAuthParams(String appKey, String desiredUid,
                              String[] alreadyAuthedUids, String sessionId, String webHost,
                              String apiType, TokenAccessType tokenAccessType,
                              DbxRequestConfig requestConfig, DbxHost host, String scope,
                              IncludeGrantedScopes includeGrantedScopes) {
        sAppKey = appKey;
        sDesiredUid = desiredUid;
        sAlreadyAuthedUids = (alreadyAuthedUids != null) ? alreadyAuthedUids : new String[0];
        sSessionId = sessionId;
        sApiType = apiType;
        sTokenAccessType = tokenAccessType;
        sRequestConfig = requestConfig;
        if (host != null) {
            sHost = host;
        } else if (webHost != null) {
            sHost = new DbxHost(
                DbxHost.DEFAULT.getApi(), DbxHost.DEFAULT.getContent(), webHost,
                DbxHost.DEFAULT.getNotify()
            );
        } else {
            sHost = DbxHost.DEFAULT;
        }
        sScope = scope;
        sIncludeGrantedScopes = includeGrantedScopes;
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
        return makeIntent(context, appKey, null, null, null, webHost, apiType, null, null, null,
            null, null);
    }

    /**
     * Create an intent which can be sent to this activity to start OAuth 2 authentication.
     *
     * @param context the source context
     * @param appKey the consumer key for the app
     * @param desiredUid    Encourage user to authenticate account defined by this uid.
     *                      (note that user still can authenticate other accounts).
     *                      May be null if no uid desired.
     * @param alreadyAuthedUids Array of any other uids currently authenticated with this app.
     *                          May be null if no uids previously authenticated.
     *                          Authentication screen will encourage user to not authorize these
     *                          user accounts. (note that user may still authorize the accounts).
     * @param sessionId     The SESSION_ID Extra on an OpenWith intent. null if dAuth
     *                      is being launched outside of OpenWith flow
     * @param webHost the host to use for web authentication, or null for the default
     * @param apiType an identifier for the type of API being supported, or null for
     *  the default
     *
     * @return a newly created intent.
     */
    public static Intent makeIntent(Context context, String appKey, String desiredUid, String[] alreadyAuthedUids,
                                    String sessionId, String webHost, String apiType) {
        if (appKey == null) {
            throw new IllegalArgumentException("'appKey' can't be null");
        }
        setAuthParams(appKey, desiredUid, alreadyAuthedUids, sessionId, webHost, apiType, null,
            null, null, null, null);
        return new Intent(context, AuthActivity.class);
    }

    /**
     * If both host and webHost are provided, we take use host as source of truth.
     */
    static Intent makeIntent(
        Context context, String appKey, String desiredUid, String[] alreadyAuthedUids,
        String sessionId, String webHost, String apiType, TokenAccessType tokenAccessType,
        DbxRequestConfig requestConfig, DbxHost host, String scope, IncludeGrantedScopes includeGrantedScopes
    ) {
        if (appKey == null) throw new IllegalArgumentException("'appKey' can't be null");
        setAuthParams(
            appKey, desiredUid, alreadyAuthedUids, sessionId, webHost, apiType, tokenAccessType,
            requestConfig, host, scope, includeGrantedScopes
        );
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
        mApiType = sApiType;
        mDesiredUid = sDesiredUid;
        mAlreadyAuthedUids = sAlreadyAuthedUids;
        mSessionId = sSessionId;
        mTokenAccessType = sTokenAccessType;
        mRequestConfig = sRequestConfig;
        mHost = sHost;
        mScope = sScope;
        mIncludeGrantedScopes = sIncludeGrantedScopes;

        if (savedInstanceState == null) {
            result = null;
            mAuthStateNonce = null;
            mPKCEManager = new DbxPKCEManager();
        } else {
            mAuthStateNonce = savedInstanceState.getString(SIS_KEY_AUTH_STATE_NONCE);
            mPKCEManager = new DbxPKCEManager(savedInstanceState.getString(SIS_KEY_PKCE_CODE_VERIFIER));
        }

        setTheme(android.R.style.Theme_Translucent_NoTitleBar);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SIS_KEY_AUTH_STATE_NONCE, mAuthStateNonce);
        outState.putString(SIS_KEY_PKCE_CODE_VERIFIER, mPKCEManager.getCodeVerifier());
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

        if (Build.VERSION.SDK_INT < 29) {
            // onTopResumedActivityChanged was introduced in Android 29 so we need to call it
            // manually when Android version is less than 29
            onTopResumedActivityChanged(true/* onTop */);
        }
    }

    /**
     * AuthActivity is launched first time, or user didn't finish oauth/dauth flow but
     * switched back to this activity. (hit back button)
     *
     * If DAuth/Browser Auth succeeded, this flow should finish through onNewIntent()
     * instead of onResume().
     *
     * NOTE: Although Android Studio doesn't think this overrides a method, it actually overrides
     * onTopResumedActivityChanged() introduced in Android level 29. 
     *
     * See:
     * https://developer.android.com/reference/android/app/Activity#onTopResumedActivityChanged(boolean)
     */
    protected void onTopResumedActivityChanged(boolean onTop) {
        if (isFinishing() || !onTop) {
            return;
        }

        boolean authNotFinish = mAuthStateNonce != null || mAppKey == null;

        if (authNotFinish) {
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
        final String state;

        // Create intent to auth with official app.
        final Intent officialAuthIntent = getOfficialAuthIntent();

        if (mTokenAccessType != null) {
            // short live token flow
            state = createPKCEStateNonce(); // to support legacy DBApp with V1 flow with
            officialAuthIntent.putExtra(EXTRA_AUTH_QUERY_PARAMS, createExtraQueryParams());
        } else {
            // Legacy long live token flow
            state = createStateNonce();
        }

        officialAuthIntent.putExtra(EXTRA_CONSUMER_KEY, mAppKey);
        officialAuthIntent.putExtra(EXTRA_CONSUMER_SIG, "");
        officialAuthIntent.putExtra(EXTRA_CALLING_PACKAGE, getPackageName());
        officialAuthIntent.putExtra(EXTRA_CALLING_CLASS, getClass().getName());
        officialAuthIntent.putExtra(EXTRA_AUTH_STATE, state);
        officialAuthIntent.putExtra(EXTRA_DESIRED_UID, mDesiredUid);
        officialAuthIntent.putExtra(EXTRA_ALREADY_AUTHED_UIDS, mAlreadyAuthedUids);
        officialAuthIntent.putExtra(EXTRA_SESSION_ID, mSessionId);

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
            if (token.equals(TokenType.OAUTH2.toString())) {
                // token flow
                newResult = new Intent();
                newResult.putExtra(EXTRA_ACCESS_TOKEN, token);
                newResult.putExtra(EXTRA_ACCESS_SECRET, secret);
                newResult.putExtra(EXTRA_UID, uid);
            } else if (token.equals(TokenType.OAUTH2CODE.toString())) {
                // code flow with PKCE
                TokenRequestAsyncTask tokenRequest = new TokenRequestAsyncTask(secret);
                try {
                    DbxAuthFinish dbxAuthFinish = tokenRequest.execute().get();

                    if (dbxAuthFinish == null) {
                        newResult = null;
                    } else {
                        newResult = new Intent();
                        // access_token and access_secret are OAuth1 concept. In OAuth2 we only
                        // have access token. So I put both of them to be the same.
                        newResult.putExtra(EXTRA_ACCESS_TOKEN, dbxAuthFinish.getAccessToken());
                        newResult.putExtra(EXTRA_ACCESS_SECRET, dbxAuthFinish.getAccessToken());
                        newResult.putExtra(EXTRA_REFRESH_TOKEN, dbxAuthFinish.getRefreshToken());
                        newResult.putExtra(EXTRA_EXPIRES_AT, dbxAuthFinish.getExpiresAt());
                        newResult.putExtra(EXTRA_UID, dbxAuthFinish.getUserId());
                        newResult.putExtra(EXTRA_CONSUMER_KEY, mAppKey);
                        newResult.putExtra(EXTRA_SCOPE, dbxAuthFinish.getScope());
                    }
                } catch (Exception e) {
                    newResult = null;
                }
            } else {
                newResult = null;
            }
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
        locale = new Locale(locale.getLanguage(), locale.getCountry());

        // Web Auth currently does not support desiredUid and only one alreadyAuthUid (param n).
        // We use first alreadyAuthUid arbitrarily.
        // Note that the API treats alreadyAuthUid of 0 and not present equivalently.
        String alreadyAuthedUid = (mAlreadyAuthedUids.length > 0) ? mAlreadyAuthedUids[0] : "0";

        List<String> params = new ArrayList<String>(Arrays.asList(
            "k", mAppKey,
            "n", alreadyAuthedUid,
            "api", mApiType,
            "state", state
        ));

        if (mTokenAccessType != null) {
            params.add("extra_query_params");
            params.add(createExtraQueryParams());
        }

        String url = DbxRequestUtil.buildUrlWithParams(locale.toString(), mHost.getWeb(), path,
            params.toArray(new String [0]));

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

    private String createPKCEStateNonce() {
        String state =  String.format(Locale.US, "oauth2code:%s:%s:%s",
                             mPKCEManager.getCodeChallenge(),
                             DbxPKCEManager.CODE_CHALLENGE_METHODS,
                             mTokenAccessType.toString()
        );

        if (mScope != null) {
            state += ":" + mScope;
        }

        if (mIncludeGrantedScopes != null) {
            state += ":" + mIncludeGrantedScopes.toString();
        }

        return state;
    }

    private String createExtraQueryParams() {
        if (mTokenAccessType == null) {
            throw new IllegalStateException("Extra Query Param should only be used in short live " +
                "token flow.");
        }

        String param = String.format(Locale.US,
            "%s=%s&%s=%s&%s=%s&%s=%s",
            "code_challenge", mPKCEManager.getCodeChallenge(),
            "code_challenge_method", DbxPKCEManager.CODE_CHALLENGE_METHODS,
            "token_access_type", mTokenAccessType.toString(),
            "response_type", "code"
        );

        if (mScope != null) {
            param += String.format(Locale.US, "&%s=%s", "scope", mScope);
        }

        if (mIncludeGrantedScopes != null) {
            param += String.format(Locale.US, "&%s=%s", "include_granted_scopes",
                mIncludeGrantedScopes.toString());
        }

        return param;
    }

    private enum TokenType {
        OAUTH2("oauth2:"),
        OAUTH2CODE("oauth2code:");

        private String string;

        TokenType(String string) {
            this.string = string;
        }

        @Override
        public String toString() {
            return string;
        }
    }

    private class TokenRequestAsyncTask extends AsyncTask<Void, Void, DbxAuthFinish> {
        private final String code;

        private TokenRequestAsyncTask(String code) {
            this.code = code;
        }


        @Override
        protected DbxAuthFinish doInBackground(Void... p) {
            try {
                return mPKCEManager.makeTokenRequest(mRequestConfig, code, mAppKey, null, mHost);
            } catch (DbxException e) {
                Log.e(TAG, "Token Request Failed: " + e.getMessage());
                return null;
            }
        }
    }
}
