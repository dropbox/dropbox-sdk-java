package com.dropbox.core.android.internal

import android.content.Intent
import com.dropbox.core.android.AuthActivity

internal object DropboxAuthIntent {

    fun buildActionAuthenticateIntent(): Intent {
        return Intent(AuthActivity.ACTION_AUTHENTICATE_V2)
            .apply {
                setPackage("com.dropbox.android")
            }
    }

    /**
     * @return Intent to auth with official app
     * Extras should be filled in by callee
     */
    fun buildOfficialAuthIntent(
        mState: AuthSessionViewModel.State,
        stateNonce: String,
        packageName: String,
        callingActivityFullyQualifiedClassName: String
    ): Intent {
        return buildActionAuthenticateIntent().apply {
            putExtra(EXTRA_CONSUMER_KEY, mState.mAppKey)
            putExtra(EXTRA_CONSUMER_SIG, "")
            putExtra(EXTRA_CALLING_CLASS, callingActivityFullyQualifiedClassName)
            putExtra(EXTRA_DESIRED_UID, mState.mDesiredUid)
            putExtra(EXTRA_ALREADY_AUTHED_UIDS, mState.mAlreadyAuthedUids.toTypedArray())
            putExtra(EXTRA_SESSION_ID, mState.mSessionId)
            putExtra(EXTRA_CALLING_PACKAGE, packageName)
            putExtra(EXTRA_AUTH_STATE, stateNonce)

            mState.mTokenAccessType?.apply {
                val queryParams = QueryParamsUtil.createExtraQueryParams(
                    tokenAccessType = mState.mTokenAccessType,
                    scope = mState.mScope,
                    includeGrantedScopes = mState.mIncludeGrantedScopes,
                    pkceManagerCodeChallenge = mState.mPKCEManager.codeChallenge
                )
                // to support legacy DBApp with V1 flow with
                putExtra(EXTRA_AUTH_QUERY_PARAMS, queryParams)
            }
        }
    }

    /**
     * The extra that goes in an intent to provide your consumer key for
     * Dropbox authentication. You won't ever have to use this.
     */
    const val EXTRA_CONSUMER_KEY: String = "CONSUMER_KEY"

    /**
     * The extra that goes in an intent when returning from Dropbox auth to
     * provide the user's access token, if auth succeeded. You won't ever have
     * to use this.
     */
    const val EXTRA_ACCESS_TOKEN: String = "ACCESS_TOKEN"

    /**
     * The extra that goes in an intent when returning from Dropbox auth to
     * provide the user's access token secret, if auth succeeded. You won't
     * ever have to use this.
     */
    const val EXTRA_ACCESS_SECRET: String = "ACCESS_SECRET"

    /**
     * The extra that goes in an intent when returning from Dropbox auth to
     * provide the user's Dropbox UID, if auth succeeded. You won't ever have
     * to use this.
     */
    const val EXTRA_UID: String = "UID"
    const val EXTRA_REFRESH_TOKEN: String = "REFRESH_TOKEN"
    const val EXTRA_EXPIRES_AT: String = "EXPIRES_AT"
    const val EXTRA_SCOPE: String = "SCOPE"

    /**
     * Used for internal authentication. You won't ever have to use this.
     */
    const val EXTRA_CONSUMER_SIG: String = "CONSUMER_SIG"

    /**
     * Used for internal authentication. You won't ever have to use this.
     */
    const val EXTRA_CALLING_PACKAGE: String = "CALLING_PACKAGE"

    /**
     * Used for internal authentication. You won't ever have to use this.
     */
    const val EXTRA_CALLING_CLASS: String = "CALLING_CLASS"

    /**
     * Used for internal authentication. You won't ever have to use this.
     */
    const val EXTRA_AUTH_STATE: String = "AUTH_STATE"

    /**
     * Used for internal authentication. Allows app to request a specific UID to auth against
     * You won't ever have to use this.
     */
    const val EXTRA_DESIRED_UID: String = "DESIRED_UID"

    /**
     * Used for internal authentication. Allows app to request array of UIDs that should not be auth'd
     * You won't ever have to use this.
     */
    const val EXTRA_ALREADY_AUTHED_UIDS: String = "ALREADY_AUTHED_UIDS"

    /**
     * Used for internal authentication. Allows app to transfer session info to/from DbApp
     * You won't ever have to use this.
     */
    const val EXTRA_SESSION_ID: String = "SESSION_ID"

    /**
     * Used for internal authentication. You won't ever have to use this.
     */
    const val EXTRA_AUTH_QUERY_PARAMS: String = "AUTH_QUERY_PARAMS"


}