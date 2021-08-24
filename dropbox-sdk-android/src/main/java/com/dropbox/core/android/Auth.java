package com.dropbox.core.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxHost;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.IncludeGrantedScopes;
import com.dropbox.core.TokenAccessType;
import com.dropbox.core.oauth.DbxCredential;
import com.dropbox.core.util.StringUtil;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Helper class for integrating with {@link AuthActivity}
 */
public class Auth {
    
    
    /**
     * @see Auth#startOAuth2Authentication(Context, String, String, String[], String, String)
     */
    public static void startOAuth2Authentication(Context context, String appKey) {
        startOAuth2Authentication(context, appKey, null, null, null);
    }

    /**
     * @see Auth#startOAuth2Authentication(Context, String, String, String[], String, String)
     */
    public static void startOAuth2Authentication(Context context, String appKey, String desiredUid,
                                                 String[] alreadyAuthedUids, String sessionId) {
        startOAuth2Authentication(context, appKey, desiredUid, alreadyAuthedUids, sessionId, "www.dropbox.com");
    }

    /**
     *
     *
     * @see Auth#startOAuth2PKCE(Context, String, DbxRequestConfig, DbxHost)
     */
    public static void startOAuth2PKCE(Context context, String appKey,
                                                     DbxRequestConfig requestConfig) {
        startOAuth2PKCE(context, appKey, requestConfig, null, null);
    }

    /**
     *
     *
     * @param scope A list of scope strings. Each scope correspond to a group of
     * API endpoints. To call one API endpoint you have to obtains the scope first otherwise you
     * will get HTTP 401.
     * @see Auth#startOAuth2PKCE(Context, String, DbxRequestConfig, DbxHost)
     */
    public static void startOAuth2PKCE(Context context, String appKey, DbxRequestConfig
        requestConfig, Collection<String> scope) {
        startOAuth2PKCE(context, appKey, requestConfig, null, scope);
    }

    /**
     *
     *
     * Starts the Dropbox OAuth process by launching the Dropbox official app (AKA DAuth) or web
     * browser if dropbox official app is not available. In browser flow, normally user needs to
     * sign in.
     * @param context               the {@link Context} to use to launch the
     *      *                       Dropbox authentication activity. This will typically be an
     *      *                       {@link Activity} and the user will be taken back to that
     *      *                       activity after authentication is complete (i.e., your activity
     *      *                       will receive an {@code onResume()}).
     * @param appKey                the app's key.
     * @param requestConfig         Default attributes to use for each request
     * @param host                  Dropbox hosts to send requests to (used for mocking and testing)
     */
    public static void startOAuth2PKCE(Context context, String appKey, DbxRequestConfig
        requestConfig, DbxHost host) {
        if (requestConfig == null) {
            throw new IllegalArgumentException("Invalid Dbx requestConfig for PKCE flow.");
        }
        startOAuth2Authentication(context, appKey, null, null, null, null, TokenAccessType
            .OFFLINE, requestConfig, host);
    }

    public static void startOAuth2PKCE(Context context, String appKey, DbxRequestConfig
        requestConfig, DbxHost host, Collection<String> scope) {
        if (requestConfig == null) {
            throw new IllegalArgumentException("Invalid Dbx requestConfig for PKCE flow.");
        }
        startOAuth2Authentication(context, appKey, null, null, null, null, TokenAccessType
            .OFFLINE, requestConfig, host, scope, null);
    }

    /**
     *
     *
     * Starts the Dropbox OAuth process by launching the Dropbox official app (AKA DAuth) or web
     * browser if dropbox official app is not available. In browser flow, normally user needs to
     * sign in.
     * @param context               the {@link Context} to use to launch the
     *      *                       Dropbox authentication activity. This will typically be an
     *      *                       {@link Activity} and the user will be taken back to that
     *      *                       activity after authentication is complete (i.e., your activity
     *      *                       will receive an {@code onResume()}).
     * @param appKey                the app's key.
     * @param requestConfig         Default attributes to use for each request
     * @param host                  Dropbox hosts to send requests to (used for mocking and testing)
     * @param scope                 A list of scope strings. Each scope correspond
     *                              to a group of API endpoints. To call one API endpoint you
     *                              have to obtains the scope first otherwise you will get HTTP 401.
     * @param includeGrantedScopes  If this is set, result will contain both new scopes and all
     *                              previously granted scopes. It enables incrementally
     *                              requesting scopes.
     */
    public static void startOAuth2PKCE(Context context, String appKey, DbxRequestConfig
        requestConfig, DbxHost host, Collection<String> scope, IncludeGrantedScopes includeGrantedScopes) {
        if (requestConfig == null) {
            throw new IllegalArgumentException("Invalid Dbx requestConfig for PKCE flow.");
        }

        if (includeGrantedScopes != null && scope == null) {
            throw new IllegalArgumentException("If you are using includeGrantedScope, you" +
                " must ask for specific new scopes");
        }

        startOAuth2Authentication(context, appKey, null, null, null, null, TokenAccessType
            .OFFLINE, requestConfig, host, scope, includeGrantedScopes);
    }
    
    /**
     * Starts the Dropbox authentication process by launching an external app
     * (either the Dropbox app if available or a web browser) where the user
     * will log in and allow your app access.
     * <p>
     * This variant should be used when authentication is being done due to an OpenWith request through action
     * {@value DbxOfficialAppConnector#ACTION_DBXC_EDIT} and {@value DbxOfficialAppConnector#ACTION_DBXC_VIEW}.
     * You won't need to use this unless you are a partner who registered your app with openwith feature in our official
     * Dropbox app.
     * </p>
     *
     * @param context           the {@link Context} to use to launch the
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
     * @param webHost           Server host used for oauth
     * @throws IllegalStateException if you have not correctly set up the AuthActivity in your
     *                               manifest, meaning that the Dropbox app will
     *                               not be able to redirect back to your app after auth.
     */
    public static void startOAuth2Authentication(Context context,
                                                 String appKey,
                                                 String desiredUid,
                                                 String[] alreadyAuthedUids,
                                                 String sessionId,
                                                 String webHost) {
        startOAuth2Authentication(context, appKey, desiredUid, alreadyAuthedUids, sessionId,
            webHost, null, null, null);
    }

    private static void startOAuth2Authentication(Context context,
                                                  String appKey,
                                                  String desiredUid,
                                                  String[] alreadyAuthedUids,
                                                  String sessionId,
                                                  String webHost,
                                                  TokenAccessType tokenAccessType,
                                                  DbxRequestConfig requestConfig,
                                                  DbxHost host) {
        startOAuth2Authentication(context, appKey, desiredUid, alreadyAuthedUids, sessionId,
            webHost, tokenAccessType, requestConfig, host, null, null);
    }

    private static void startOAuth2Authentication(Context context,
                                                  String appKey,
                                                  String desiredUid,
                                                  String[] alreadyAuthedUids,
                                                  String sessionId,
                                                  String webHost,
                                                  TokenAccessType tokenAccessType,
                                                  DbxRequestConfig requestConfig,
                                                  DbxHost host,
                                                  Collection<String>  scope,
                                                  IncludeGrantedScopes includeGrantedScopes) {
        if (!AuthActivity.checkAppBeforeAuth(context, appKey, true /*alertUser*/)) {
            return;
        }

        if (alreadyAuthedUids != null && Arrays.asList(alreadyAuthedUids).contains(desiredUid)) {
            throw new IllegalArgumentException("desiredUid cannot be present in alreadyAuthedUids");
        }

        String scopeString = null;
        if (scope != null) {
            scopeString = StringUtil.join(scope, " ");
        }

        // Start Dropbox auth activity.
        String apiType = "1";
        Intent intent =  AuthActivity.makeIntent(
            context, appKey, desiredUid, alreadyAuthedUids, sessionId, webHost, apiType,
            tokenAccessType, requestConfig, host, scopeString, includeGrantedScopes
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
        DbxCredential credential = getDbxCredential();

        if (credential == null) {
            return null;
        }

        return credential.getAccessToken();
    }

    public static String getUid() {
        if (getDbxCredential() == null) {
            return null;
        }

        Intent data = AuthActivity.result;
        return data.getStringExtra(AuthActivity.EXTRA_UID);
    }

    /**
     *
     *
     * @return The result after
     */
    public static DbxCredential getDbxCredential() {
        Intent data = AuthActivity.result;

        if (data == null) {
            return null;
        }

        String token = data.getStringExtra(AuthActivity.EXTRA_ACCESS_TOKEN);
        String secret = data.getStringExtra(AuthActivity.EXTRA_ACCESS_SECRET);
        String uid = data.getStringExtra(AuthActivity.EXTRA_UID);

        if (token == null || "".equals(token) || secret == null || "".equals(secret) || uid ==
            null || "".equals(uid)) {
            return null;
        }

        String appKey = data.getStringExtra(AuthActivity.EXTRA_CONSUMER_KEY);
        String refreshToken = data.getStringExtra(AuthActivity.EXTRA_REFRESH_TOKEN);
        long expiresAt = data.getLongExtra(AuthActivity.EXTRA_EXPIRES_AT, -1);
        Long nullableExpiresAt = (expiresAt >= 0) ? expiresAt : null;


        return new DbxCredential(secret, nullableExpiresAt, refreshToken, appKey);
    }

    /**
     *
     *
     * Get the scope authorized in this OAuth flow.
     *
     * @return A list of scope returned by Dropbox server. Each scope correspond to a group of
     * API endpoints. To call one API endpoint you have to obtains the scope first otherwise you
     * will get HTTP 401.
     */
    public static String getScope() {
        Intent data = AuthActivity.result;

        if (data == null) {
            return null;
        }

        return data.getStringExtra(AuthActivity.EXTRA_SCOPE);
    }
}
