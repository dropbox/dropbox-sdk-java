package com.dropbox.core.android

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.dropbox.core.DbxHost
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.IncludeGrantedScopes
import com.dropbox.core.TokenAccessType
import com.dropbox.core.android.AuthActivity.Companion.checkAppBeforeAuth
import com.dropbox.core.android.AuthActivity.Companion.makeIntent
import com.dropbox.core.android.internal.DropboxAuthIntent
import com.dropbox.core.oauth.DbxCredential
import com.dropbox.core.util.StringUtil
import java.util.Arrays

/**
 * Helper class for integrating with [AuthActivity]
 */
public class Auth {
    public companion object {

        /**
         * @see Auth#startOAuth2Authentication(Context, String, String, String[], String, String)
         */
        @JvmStatic
        public fun startOAuth2Authentication(
            context: Context,
            appKey: String?,
        ) {
            startOAuth2Authentication(
                context = context,
                appKey = appKey,
                desiredUid = null,
                alreadyAuthedUids = null,
                sessionId = null
            )
        }

        /**
         * @see Auth#startOAuth2Authentication(Context, String, String, String[], String, String)
         */
        @JvmStatic
        public fun startOAuth2Authentication(
            context: Context,
            appKey: String?,
            desiredUid: String?,
            alreadyAuthedUids: Array<String>?,
            sessionId: String?,
        ) {
            startOAuth2Authentication(
                context = context,
                appKey = appKey,
                desiredUid = desiredUid,
                alreadyAuthedUids = alreadyAuthedUids,
                sessionId = sessionId,
                webHost = "www.dropbox.com"
            )
        }

        /**
         * @param scope A list of scope strings. Each scope correspond to a group of
         * API endpoints. To call one API endpoint you have to obtains the scope first otherwise you
         * will get HTTP 401.
         * @see Auth.startOAuth2PKCE
         */
        @JvmStatic
        @JvmOverloads
        public fun startOAuth2PKCE(
            context: Context,
            appKey: String?,
            requestConfig: DbxRequestConfig?,
            scope: Collection<String?>? = null
        ) {
            startOAuth2PKCE(
                context = context,
                appKey = appKey,
                requestConfig = requestConfig,
                host = null,
                scope = scope
            )
        }

        /**
         * Starts the Dropbox OAuth process by launching the Dropbox official app (AKA DAuth) or web
         * browser if dropbox official app is not available. In browser flow, normally user needs to
         * sign in.
         * @param context               the [Context] to use to launch the
         * *                       Dropbox authentication activity. This will typically be an
         * *                       [Activity] and the user will be taken back to that
         * *                       activity after authentication is complete (i.e., your activity
         * *                       will receive an `onResume()`).
         * @param appKey                the app's key.
         * @param requestConfig         Default attributes to use for each request
         * @param host                  Dropbox hosts to send requests to (used for mocking and testing)
         */
        @JvmStatic
        public fun startOAuth2PKCE(
            context: Context,
            appKey: String?,
            requestConfig: DbxRequestConfig?,
            host: DbxHost?
        ) {
            requireNotNull(requestConfig) { "Invalid Dbx requestConfig for PKCE flow." }
            startOAuth2Authentication(
                context = context,
                appKey = appKey,
                desiredUid = null,
                alreadyAuthedUids = null,
                sessionId = null,
                webHost = null,
                tokenAccessType = TokenAccessType.OFFLINE,
                requestConfig = requestConfig,
                host = host
            )
        }

        /**
         *
         *
         * @see Auth.startOAuth2PKCE
         */
        @JvmStatic
        public fun startOAuth2PKCE(
            context: Context,
            appKey: String?,
            requestConfig: DbxRequestConfig?,
            host: DbxHost?,
            scope: Collection<String?>?
        ) {
            requireNotNull(requestConfig) { "Invalid Dbx requestConfig for PKCE flow." }
            startOAuth2Authentication(
                context = context,
                appKey = appKey,
                desiredUid = null,
                alreadyAuthedUids = null,
                sessionId = null,
                webHost = null,
                tokenAccessType = TokenAccessType.OFFLINE,
                requestConfig = requestConfig,
                host = host,
                scope = scope,
                includeGrantedScopes = null
            )
        }

        /**
         *
         *
         * Starts the Dropbox OAuth process by launching the Dropbox official app (AKA DAuth) or web
         * browser if dropbox official app is not available. In browser flow, normally user needs to
         * sign in.
         * @param context               the [Context] to use to launch the
         * *                       Dropbox authentication activity. This will typically be an
         * *                       [Activity] and the user will be taken back to that
         * *                       activity after authentication is complete (i.e., your activity
         * *                       will receive an `onResume()`).
         * @param appKey                the app's key.
         * @param requestConfig         Default attributes to use for each request
         * @param host                  Dropbox hosts to send requests to (used for mocking and testing)
         * @param scope                 A list of scope strings. Each scope correspond
         * to a group of API endpoints. To call one API endpoint you
         * have to obtains the scope first otherwise you will get HTTP 401.
         * @param includeGrantedScopes  If this is set, result will contain both new scopes and all
         * previously granted scopes. It enables incrementally
         * requesting scopes.
         */
        @JvmStatic
        public fun startOAuth2PKCE(
            context: Context,
            appKey: String?,
            requestConfig: DbxRequestConfig?,
            host: DbxHost?,
            scope: Collection<String?>?,
            includeGrantedScopes: IncludeGrantedScopes?
        ) {
            requireNotNull(requestConfig) { "Invalid Dbx requestConfig for PKCE flow." }
            require(!(includeGrantedScopes != null && scope == null)) {
                "If you are using includeGrantedScope, you" +
                        " must ask for specific new scopes"
            }
            startOAuth2Authentication(
                context = context,
                appKey = appKey,
                desiredUid = null,
                alreadyAuthedUids = null,
                sessionId = null,
                webHost = null,
                tokenAccessType = TokenAccessType.OFFLINE,
                requestConfig = requestConfig,
                host = host,
                scope = scope,
                includeGrantedScopes = includeGrantedScopes
            )
        }

        /**
         * Starts the Dropbox authentication process by launching an external app
         * (either the Dropbox app if available or a web browser) where the user
         * will log in and allow your app access.
         *
         *
         * This variant should be used when authentication is being done due to an OpenWith request through action
         * {@value DbxOfficialAppConnector#ACTION_DBXC_EDIT} and {@value DbxOfficialAppConnector#ACTION_DBXC_VIEW}.
         * You won't need to use this unless you are a partner who registered your app with openwith feature in our official
         * Dropbox app.
         *
         *
         * @param context           the [Context] to use to launch the
         * Dropbox authentication activity. This will typically be an
         * [Activity] and the user will be taken back to that
         * activity after authentication is complete (i.e., your activity
         * will receive an `onResume()`).
         * @param appKey            the app's key.
         * @param desiredUid        Encourage user to authenticate account defined by this uid.
         * (note that user still can authenticate other accounts).
         * May be null if no uid desired.
         * @param alreadyAuthedUids Array of any other uids currently authenticated with this app.
         * May be null if no uids previously authenticated.
         * Authentication screen will encourage user to not authorize these
         * user accounts. (note that user may still authorize the accounts).
         * @param sessionId         The SESSION_ID Extra on an OpenWith intent. null if dAuth
         * is being launched outside of OpenWith flow
         * @param webHost           Server host used for oauth
         * @throws IllegalStateException if you have not correctly set up the AuthActivity in your
         * manifest, meaning that the Dropbox app will
         * not be able to redirect back to your app after auth.
         */
        @JvmStatic
        public fun startOAuth2Authentication(
            context: Context,
            appKey: String?,
            desiredUid: String?,
            alreadyAuthedUids: Array<String>?,
            sessionId: String?,
            webHost: String?
        ) {
            startOAuth2Authentication(
                context = context,
                appKey = appKey,
                desiredUid = desiredUid,
                alreadyAuthedUids = alreadyAuthedUids,
                sessionId = sessionId,
                webHost = webHost,
                tokenAccessType = null,
                requestConfig = null,
                host = null
            )
        }

        /**
         * @see Auth.startOAuth2Authentication
         */
        private fun startOAuth2Authentication(
            context: Context,
            appKey: String?,
            desiredUid: String?,
            alreadyAuthedUids: Array<String>?,
            sessionId: String?,
            webHost: String?,
            tokenAccessType: TokenAccessType?,
            requestConfig: DbxRequestConfig?,
            host: DbxHost?,
            scope: Collection<String?>? = null,
            includeGrantedScopes: IncludeGrantedScopes? = null
        ) {
            if (!checkAppBeforeAuth(context, appKey!!, true /*alertUser*/)) {
                return
            }
            require(
                !(alreadyAuthedUids != null && Arrays.asList(*alreadyAuthedUids)
                    .contains(desiredUid))
            ) { "desiredUid cannot be present in alreadyAuthedUids" }
            var scopeString: String? = null
            if (scope != null) {
                scopeString = StringUtil.join(scope, " ")
            }

            // Start Dropbox auth activity.
            val apiType = "1"
            val intent = makeIntent(
                context, appKey, desiredUid, alreadyAuthedUids, sessionId, webHost, apiType,
                tokenAccessType, requestConfig, host, scopeString, includeGrantedScopes
            )
            if (context !is Activity) {
                // If starting the intent outside of an Activity, must include
                // this. See startActivity(). Otherwise, we prefer to stay in
                // the same task.
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }

        @JvmStatic
        public fun getOAuth2Token(): String? {
            val credential = getDbxCredential() ?: return null
            return credential.accessToken
        }

        @JvmStatic
        public fun getUid(): String? {
            if (getDbxCredential() == null) {
                return null
            }
            val data = AuthActivity.result
            return data!!.getStringExtra(DropboxAuthIntent.EXTRA_UID)
        }

        /**
         *
         *
         * @return The result after
         */
        @JvmStatic
        public fun getDbxCredential(): DbxCredential? {
            val data = AuthActivity.result ?: return null
            val token = data.getStringExtra(DropboxAuthIntent.EXTRA_ACCESS_TOKEN)
            val secret = data.getStringExtra(DropboxAuthIntent.EXTRA_ACCESS_SECRET)
            val uid = data.getStringExtra(DropboxAuthIntent.EXTRA_UID)
            if (token == null || "" == token || secret == null || "" == secret || uid == null || "" == uid) {
                return null
            }
            val appKey = data.getStringExtra(DropboxAuthIntent.EXTRA_CONSUMER_KEY)
            val refreshToken = data.getStringExtra(DropboxAuthIntent.EXTRA_REFRESH_TOKEN)
            val expiresAt = data.getLongExtra(DropboxAuthIntent.EXTRA_EXPIRES_AT, -1)
            val nullableExpiresAt = if (expiresAt >= 0) expiresAt else null
            return DbxCredential(secret, nullableExpiresAt, refreshToken, appKey)
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
        @JvmStatic
        public fun getScope(): String? {
            val data = AuthActivity.result ?: return null
            return data.getStringExtra(DropboxAuthIntent.EXTRA_SCOPE)
        }
    }
}