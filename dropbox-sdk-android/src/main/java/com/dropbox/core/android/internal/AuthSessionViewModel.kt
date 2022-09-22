package com.dropbox.core.android.internal

import android.content.Intent
import com.dropbox.core.DbxHost
import com.dropbox.core.DbxPKCEManager
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.IncludeGrantedScopes
import com.dropbox.core.TokenAccessType

internal class AuthSessionViewModel {

    internal data class State(
        var mHost: DbxHost? = null,
        var result: Intent? = null,
        var mPKCEManager: DbxPKCEManager = DbxPKCEManager(),
        var mAuthStateNonce: String? = null,
        var mAppKey: String? = null,
        var mApiType: String? = null,
        var mDesiredUid: String? = null,
        var mAlreadyAuthedUids: List<String> = emptyList(),
        var mSessionId: String? = null,
        var mTokenAccessType: TokenAccessType? = null,
        var mRequestConfig: DbxRequestConfig? = null,
        var mScope: String? = null,
        var mIncludeGrantedScopes: IncludeGrantedScopes? = null,
    ) {
        companion object {
            fun fromAuthParams(sAuthParams: AuthParameters?): State {
                return State(
                    mAppKey = sAuthParams?.sAppKey,
                    mApiType = sAuthParams?.sApiType,
                    mDesiredUid = sAuthParams?.sDesiredUid,
                    mAlreadyAuthedUids = sAuthParams?.sAlreadyAuthedUids ?: emptyList(),
                    mSessionId = sAuthParams?.sSessionId,
                    mTokenAccessType = sAuthParams?.sTokenAccessType,
                    mRequestConfig = sAuthParams?.sRequestConfig,
                    mHost = sAuthParams?.sHost,
                    mScope = sAuthParams?.sScope,
                    mIncludeGrantedScopes = sAuthParams?.sIncludeGrantedScopes,
                )
            }
        }
    }

    companion object {
        private var _state: State = State()

        private var authInProgress = false

        val state: State get() = _state

        fun isAuthInProgress(): Boolean {
            return authInProgress
        }

        fun startAuthSession(state: State) {
            authInProgress = true
            this._state = state
        }

        fun endAuthSession() {
            authInProgress = false
            this._state = State()
        }
    }
}
