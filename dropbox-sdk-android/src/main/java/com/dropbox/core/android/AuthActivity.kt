package com.dropbox.core.android

import android.R
import android.app.Activity
import android.app.AlertDialog
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import com.dropbox.core.DbxHost
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.DbxRequestUtil
import com.dropbox.core.IncludeGrantedScopes
import com.dropbox.core.TokenAccessType
import com.dropbox.core.android.internal.AuthParameters
import com.dropbox.core.android.internal.AuthSessionViewModel
import com.dropbox.core.android.internal.AuthUtils.createPKCEStateNonce
import com.dropbox.core.android.internal.AuthUtils.createStateNonce
import com.dropbox.core.android.internal.DropboxAuthIntent
import com.dropbox.core.android.internal.QueryParamsUtil
import com.dropbox.core.android.internal.TokenRequestAsyncTask
import com.dropbox.core.android.internal.TokenType
import java.security.SecureRandom
import java.util.*

/**
 * This activity is used internally for authentication, but must be exposed both
 * so that Android can launch it and for backwards compatibility.
 *
 * This class has been marked as "open" for binary compatibility reasons,
 * but will be "final" in the next major version.
 */
public open class AuthActivity : Activity() {
    /**
     * Provider of the local security needs of an AuthActivity.
     *
     * You shouldn't need to use this class directly in your app.  Instead,
     * simply configure `java.security`'s providers to match your preferences.
     *
     */
    public interface SecurityProvider {
        /**
         * Gets a SecureRandom implementation for use during authentication.
         */
        public val secureRandom: SecureRandom
    }

    private var mActivityDispatchHandlerPosted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        if (!AuthSessionViewModel.isAuthInProgress()) {
            val newStateFromAuthParams = AuthSessionViewModel.State.fromAuthParams(sAuthParams)
            AuthSessionViewModel.startAuthSession(newStateFromAuthParams)
        }
        setTheme(R.style.Theme_Translucent_NoTitleBar)
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        if (Build.VERSION.SDK_INT < 29) {
            // onTopResumedActivityChanged was introduced in Android 29 so we need to call it
            // manually when Android version is less than 29
            onTopResumedActivityChanged(true /* onTop */)
        }
    }

    private val mState: AuthSessionViewModel.State get() = AuthSessionViewModel.state

    /**
     * AuthActivity is launched first time, or user didn't finish oauth/dauth flow but
     * switched back to this activity. (hit back button)
     *
     * If DAuth/Browser Auth succeeded, this flow should finish through onNewIntent()
     * instead of onResume().
     *
     * See:
     * https://developer.android.com/reference/android/app/Activity#onTopResumedActivityChanged(boolean)
     */
    fun onTopResumedActivityChanged(onTop: Boolean) {
        if (isFinishing || !onTop) {
            return
        }
        val authNotFinish = mState.mAuthStateNonce != null || mState.mAppKey == null
        if (authNotFinish) {
            // We somehow returned to this activity without being forwarded
            // here by the official app.

            // Most commonly caused by user hitting "back" from the auth screen
            // or (if doing browser auth) task switching from auth task back to
            // this one.
            authFinished(null)
            return
        }
        result = null
        if (mActivityDispatchHandlerPosted) {
            Log.w(TAG, "onResume called again before Handler run")
            return
        }

        // Random entropy passed through auth makes sure we don't accept a
        // response which didn't come from our request.  Each random
        // value is only ever used once.
        val stateNonce: String = if (mState.mTokenAccessType != null) {
            // short live token flow
            createPKCEStateNonce(
                codeChallenge = mState.mPKCEManager.codeChallenge,
                tokenAccessType = mState.mTokenAccessType.toString(),
                scope = mState.mScope,
                mIncludeGrantedScopes = mState.mIncludeGrantedScopes
            )
        } else {
            // Legacy long live token flow
            createStateNonce(getSecurityProvider())
        }

        // Create intent to auth with official app.
        val officialAuthIntent = DropboxAuthIntent.buildOfficialAuthIntent(
            authActivity = this@AuthActivity,
            mState = mState,
            stateNonce = stateNonce,
        )

        /*
         * An Android bug exists where onResume may be called twice in rapid succession.
         * As mAuthNonceState would already be set at start of the second onResume, auth would fail.
         * Empirical research has found that posting the remainder of the auth logic to a handler
         * mitigates the issue by delaying remainder of auth logic to after the
         * previously posted onResume.
         */
        runOnUiThread {
            Log.d(TAG, "running startActivity in handler")
            try {
                val dropboxAppPackage = DbxOfficialAppConnector
                    .getDropboxAppPackage(applicationContext, officialAuthIntent)

                // Auth with official app, or fall back to web.
                if (dropboxAppPackage != null) {
                    startActivity(officialAuthIntent)
                } else {
                    startWebAuth(stateNonce)
                }
            } catch (e: ActivityNotFoundException) {
                Log.e(TAG, "Could not launch intent. User may have restricted profile", e)
                finish()
                return@runOnUiThread
            }
            // Save state that indicates we started a request, only after
            // we started one successfully.
            mState.mAuthStateNonce = stateNonce
        }
        mActivityDispatchHandlerPosted = true
    }

    override fun onNewIntent(intent: Intent) {
        // Reject attempt to finish authentication if we never started (nonce=null)
        if (null == mState.mAuthStateNonce) {
            authFinished(null)
            return
        }
        var token: String? = null
        var secret: String? = null
        var uid: String? = null
        var state: String? = null
        if (intent.hasExtra(DropboxAuthIntent.EXTRA_ACCESS_TOKEN)) {
            // Dropbox app auth.
            token = intent.getStringExtra(DropboxAuthIntent.EXTRA_ACCESS_TOKEN)
            secret = intent.getStringExtra(DropboxAuthIntent.EXTRA_ACCESS_SECRET)
            uid = intent.getStringExtra(DropboxAuthIntent.EXTRA_UID)
            state = intent.getStringExtra(DropboxAuthIntent.EXTRA_AUTH_STATE)
        } else {
            // Web auth.
            val uri = intent.data
            if (uri != null) {
                val path = uri.path
                if (AUTH_PATH_CONNECT == path) {
                    try {
                        token = uri.getQueryParameter("oauth_token")
                        secret = uri.getQueryParameter("oauth_token_secret")
                        uid = uri.getQueryParameter("uid")
                        state = uri.getQueryParameter("state")
                    } catch (e: UnsupportedOperationException) {
                    }
                }
            }
        }
        var newResult: Intent?
        if (token != null && token != "" && secret != null && secret != "" && uid != null && uid != "" && state != null && state != "") {
            // Reject attempt to link if the nonce in the auth state doesn't match,
            // or if we never asked for auth at all.
            if (mState.mAuthStateNonce != state) {
                authFinished(null)
                return
            }

            // Successful auth.
            if (token == TokenType.OAUTH2.toString()) {
                // token flow
                newResult = Intent()
                newResult.putExtra(DropboxAuthIntent.EXTRA_ACCESS_TOKEN, token)
                newResult.putExtra(DropboxAuthIntent.EXTRA_ACCESS_SECRET, secret)
                newResult.putExtra(DropboxAuthIntent.EXTRA_UID, uid)
            } else if (token == TokenType.OAUTH2CODE.toString()) {
                // code flow with PKCE
                val tokenRequest = TokenRequestAsyncTask(
                    secret,
                    mState.mPKCEManager,
                    mState.mRequestConfig!!,
                    mState.mAppKey!!,
                    mState.mHost!!
                )
                try {
                    val dbxAuthFinish = tokenRequest.execute().get()
                    if (dbxAuthFinish == null) {
                        newResult = null
                    } else {
                        newResult = Intent()
                        // access_token and access_secret are OAuth1 concept. In OAuth2 we only
                        // have access token. So I put both of them to be the same.
                        newResult.putExtra(
                            DropboxAuthIntent.EXTRA_ACCESS_TOKEN,
                            dbxAuthFinish.accessToken
                        )
                        newResult.putExtra(
                            DropboxAuthIntent.EXTRA_ACCESS_SECRET,
                            dbxAuthFinish.accessToken
                        )
                        newResult.putExtra(
                            DropboxAuthIntent.EXTRA_REFRESH_TOKEN,
                            dbxAuthFinish.refreshToken
                        )
                        newResult.putExtra(
                            DropboxAuthIntent.EXTRA_EXPIRES_AT,
                            dbxAuthFinish.expiresAt
                        )
                        newResult.putExtra(DropboxAuthIntent.EXTRA_UID, dbxAuthFinish.userId)
                        newResult.putExtra(DropboxAuthIntent.EXTRA_CONSUMER_KEY, mState.mAppKey)
                        newResult.putExtra(DropboxAuthIntent.EXTRA_SCOPE, dbxAuthFinish.scope)
                    }
                } catch (e: Exception) {
                    newResult = null
                }
            } else {
                newResult = null
            }
        } else {
            // Unsuccessful auth, or missing required parameters.
            newResult = null
        }
        authFinished(newResult)
    }

    private fun authFinished(authResult: Intent?) {
        result = authResult
        AuthSessionViewModel.endAuthSession()
        finish()
    }

    private fun startWebAuth(state: String) {
        val path = "1/connect"
        var locale = Locale.getDefault()
        locale = Locale(locale.language, locale.country)

        // Web Auth currently does not support desiredUid and only one alreadyAuthUid (param n).
        // We use first alreadyAuthUid arbitrarily.
        // Note that the API treats alreadyAuthUid of 0 and not present equivalently.
        val alreadyAuthedUid =
            if (mState.mAlreadyAuthedUids.isNotEmpty()) mState.mAlreadyAuthedUids[0] else "0"
        val params: MutableList<String?> =
            mutableListOf(
                "k", mState.mAppKey,
                "n", alreadyAuthedUid,
                "api", mState.mApiType,
                "state", state
            )
        if (mState.mTokenAccessType != null) {
            params.add("extra_query_params")
            params.add(
                QueryParamsUtil.createExtraQueryParams(
                    tokenAccessType = mState.mTokenAccessType,
                    scope = mState.mScope,
                    includeGrantedScopes = mState.mIncludeGrantedScopes,
                    pkceManagerCodeChallenge = mState.mPKCEManager.codeChallenge,
                )
            )
        }
        val url = DbxRequestUtil.buildUrlWithParams(
            locale.toString(), mState.mHost!!.web, path,
            params.toTypedArray()
        )
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    public companion object {
        private val TAG = AuthActivity::class.java.name

        /**
         * The Android action which the official Dropbox app will accept to
         * authenticate a user. You won't ever have to use this.
         */
        const val ACTION_AUTHENTICATE_V1: String = "com.dropbox.android.AUTHENTICATE_V1"

        /**
         * The Android action which the official Dropbox app will accept to
         * authenticate a user. You won't ever have to use this.
         */
        const val ACTION_AUTHENTICATE_V2: String = "com.dropbox.android.AUTHENTICATE_V2"

        /**
         * The version of the API for the web-auth callback with token (not the initial auth request).
         */
        const val AUTH_VERSION: Int = 1

        /**
         * The path for a successful callback with token (not the initial auth request).
         */
        const val AUTH_PATH_CONNECT: String = "/connect"

        // Class-level state used to replace the default SecureRandom implementation
        // if desired.
        private var sSecurityProvider: SecurityProvider = object : SecurityProvider {
            override val secureRandom: SecureRandom
                get() = SecureRandom()
        }
        private val sSecurityProviderLock = Any()

        /** Used internally.  */
        @JvmField
        public var result: Intent? = null

        private var sAuthParams: AuthParameters? = null

        /**
         * Set static authentication parameters
         */
        public fun setAuthParams(
            appKey: String?,
            desiredUid: String?,
            alreadyAuthedUids: Array<String>?
        ) {
            setAuthParams(appKey, desiredUid, alreadyAuthedUids, null)
        }

        /**
         * Set static authentication parameters
         */
        public fun setAuthParams(
            appKey: String?,
            desiredUid: String?,
            alreadyAuthedUids:
            Array<String>?,
            webHost: String?,
            apiType: String?
        ) {
            setAuthParams(
                appKey = appKey,
                desiredUid = desiredUid,
                alreadyAuthedUids = alreadyAuthedUids,
                sessionId = null,
                webHost = null,
                apiType = null,
                tokenAccessType = null,
                requestConfig = null,
                host = null,
                scope = null,
                includeGrantedScopes = null
            )
        }

        /**
         * Set static authentication parameters
         */
        public fun setAuthParams(
            appKey: String?,
            desiredUid: String?,
            alreadyAuthedUids: Array<String>?,
            sessionId: String?
        ) {
            setAuthParams(
                appKey = appKey,
                desiredUid = desiredUid,
                alreadyAuthedUids = alreadyAuthedUids,
                sessionId = sessionId,
                webHost = null,
                apiType = null,
                tokenAccessType = null,
                requestConfig = null,
                host = null,
                scope = null,
                includeGrantedScopes = null
            )
        }

        /**
         * Set static authentication parameters. If both host and webHost are provided, we take use
         * host as source of truth.
         */
        internal fun setAuthParams(
            appKey: String?,
            desiredUid: String?,
            alreadyAuthedUids: Array<String>?,
            sessionId: String?, webHost: String?,
            apiType: String?,
            tokenAccessType: TokenAccessType?,
            requestConfig: DbxRequestConfig?,
            host: DbxHost?,
            scope: String?,
            includeGrantedScopes: IncludeGrantedScopes?
        ) {
            sAuthParams = AuthParameters(
                sAppKey = appKey,
                sDesiredUid = desiredUid,
                sAlreadyAuthedUids = alreadyAuthedUids?.toList() ?: emptyList(),
                sSessionId = sessionId,
                sApiType = apiType,
                sTokenAccessType = tokenAccessType,
                sRequestConfig = requestConfig,
                sHost = host ?: if (webHost != null) {
                    DbxHost(
                        DbxHost.DEFAULT.api, DbxHost.DEFAULT.content, webHost,
                        DbxHost.DEFAULT.notify
                    )
                } else {
                    DbxHost.DEFAULT
                },
                sScope = scope,
                sIncludeGrantedScopes = includeGrantedScopes,
            )
        }

        /**
         * Create an intent which can be sent to this activity to start OAuth 2 authentication.
         *
         * @param context the source context
         * @param appKey the consumer key for the app
         * @param webHost the host to use for web authentication, or null for the default
         * @param apiType an identifier for the type of API being supported, or null for
         * the default
         *
         * @return a newly created intent.
         */
        @JvmStatic
        @Deprecated("Use Methods in com.dropbox.core.android.Auth, This will be removed in future versions.")
        public fun makeIntent(
            context: Context?,
            appKey: String?,
            webHost: String?,
            apiType: String?
        ): Intent {
            return makeIntent(
                context = context,
                appKey = appKey,
                desiredUid = null,
                alreadyAuthedUids = null,
                sessionId = null,
                webHost = webHost,
                apiType = apiType,
                tokenAccessType = null,
                requestConfig = null,
                host = null,
                scope = null,
                includeGrantedScopes = null
            )
        }

        /**
         * Create an intent which can be sent to this activity to start OAuth 2 authentication.
         *
         * @param context the source context
         * @param appKey the consumer key for the app
         * @param desiredUid    Encourage user to authenticate account defined by this uid.
         * (note that user still can authenticate other accounts).
         * May be null if no uid desired.
         * @param alreadyAuthedUids Array of any other uids currently authenticated with this app.
         * May be null if no uids previously authenticated.
         * Authentication screen will encourage user to not authorize these
         * user accounts. (note that user may still authorize the accounts).
         * @param sessionId     The SESSION_ID Extra on an OpenWith intent. null if dAuth
         * is being launched outside of OpenWith flow
         * @param webHost the host to use for web authentication, or null for the default
         * @param apiType an identifier for the type of API being supported, or null for
         * the default
         *
         * @return a newly created intent.
         */
        @JvmStatic
        @Deprecated("Use Methods in com.dropbox.core.android.Auth. This will be removed in future versions.")
        public fun makeIntent(
            context: Context?,
            appKey: String?,
            desiredUid: String?,
            alreadyAuthedUids: Array<String>?,
            sessionId: String?,
            webHost: String?,
            apiType: String?
        ): Intent {
            requireNotNull(appKey) { "'appKey' can't be null" }
            setAuthParams(
                appKey = appKey,
                desiredUid = desiredUid,
                alreadyAuthedUids = alreadyAuthedUids,
                sessionId = sessionId,
                webHost = webHost,
                apiType = apiType,
                tokenAccessType = null,
                requestConfig = null,
                host = null,
                scope = null,
                includeGrantedScopes = null
            )
            return Intent(context, AuthActivity::class.java)
        }

        /**
         * If both host and webHost are provided, we take use host as source of truth.
         */
        internal fun makeIntent(
            context: Context?,
            appKey: String?,
            desiredUid: String?,
            alreadyAuthedUids: Array<String>?,
            sessionId: String?,
            webHost: String?,
            apiType: String?,
            tokenAccessType: TokenAccessType?,
            requestConfig: DbxRequestConfig?,
            host: DbxHost?,
            scope: String?,
            includeGrantedScopes: IncludeGrantedScopes?
        ): Intent {
            requireNotNull(appKey) { "'appKey' can't be null" }
            setAuthParams(
                appKey, desiredUid, alreadyAuthedUids, sessionId, webHost, apiType, tokenAccessType,
                requestConfig, host, scope, includeGrantedScopes
            )
            return Intent(context, AuthActivity::class.java)
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
         * multiple apps are conflicting.
         *
         * @return `true` if this app is properly set up for authentication.
         */
        @JvmStatic
        @Deprecated("Use Methods in com.dropbox.core.android.Auth, This will be removed in future versions.")
        public fun checkAppBeforeAuth(
            context: Context,
            appKey: String,
            alertUser: Boolean
        ): Boolean {
            // Check if the app has set up its manifest properly.
            val testIntent = Intent(Intent.ACTION_VIEW)
            val scheme = "db-$appKey"
            val uri = "$scheme://$AUTH_VERSION$AUTH_PATH_CONNECT"
            testIntent.data = Uri.parse(uri)
            val pm = context.packageManager
            val activities = pm.queryIntentActivities(testIntent, 0)
            // Just one activity registered for the URI scheme. Now make sure
            // it's within the same package so when we return from web auth
            // we're going back to this app and not some other app.
            check(0 != activities.size) {
                "URI scheme in your app's " +
                        "manifest is not set up correctly. You should have a " +
                        AuthActivity::class.java.name + " with the " +
                        "scheme: " + scheme
            }
            if (activities.size > 1) {
                if (alertUser) {
                    val builder = AlertDialog.Builder(context)
                    builder.setTitle("Security alert")
                    builder.setMessage(
                        "Another app on your phone may be trying to " +
                                "pose as the app you are currently using. The malicious " +
                                "app can't access your account, but linking to Dropbox " +
                                "has been disabled as a precaution. Please contact " +
                                "support@dropbox.com."
                    )
                    builder.setPositiveButton("OK") { dialog, which -> dialog.dismiss() }
                    builder.show()
                } else {
                    Log.w(
                        TAG, "There are multiple apps registered for the AuthActivity " +
                                "URI scheme (" + scheme + ").  Another app may be trying to " +
                                " impersonate this app, so authentication will be disabled."
                    )
                }
                return false
            } else {
                // Just one activity registered for the URI scheme. Now make sure
                // it's within the same package so when we return from web auth
                // we're going back to this app and not some other app.
                val resolveInfo = activities[0]
                check(!(resolveInfo?.activityInfo == null || context.packageName != resolveInfo.activityInfo.packageName)) {
                    "There must be a " +
                            AuthActivity::class.java.name + " within your app's package " +
                            "registered for your URI scheme (" + scheme + "). However, " +
                            "it appears that an activity in a different package is " +
                            "registered for that scheme instead. If you have " +
                            "multiple apps that all want to use the same access" +
                            "token pair, designate one of them to do " +
                            "authentication and have the other apps launch it " +
                            "and then retrieve the token pair from it."
                }
            }
            return true
        }

        /**
         * Sets the SecurityProvider interface to use for all AuthActivity instances.
         * If set to null (or never set at all), default `java.security` providers
         * will be used instead.
         *
         *
         *
         * You shouldn't need to use this method directly in your app.  Instead,
         * simply configure `java.security`'s providers to match your preferences.
         *
         *
         * @param prov the new `SecurityProvider` interface.
         */
        private fun getSecurityProvider(): SecurityProvider {
            synchronized(sSecurityProviderLock) { return sSecurityProvider }
        }

        @JvmStatic
        public fun setSecurityProvider(prov: SecurityProvider) {
            synchronized(sSecurityProviderLock) { sSecurityProvider = prov }
        }

    }
}