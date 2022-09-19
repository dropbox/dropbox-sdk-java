package com.dropbox.core.android.internal

import com.dropbox.core.DbxPKCEManager
import com.dropbox.core.IncludeGrantedScopes
import com.dropbox.core.android.AuthActivity.SecurityProvider
import java.util.Locale

internal object AuthUtils {
    @JvmStatic
    fun createStateNonce(securityProvider: SecurityProvider): String {
        val NONCE_BYTES: Int = 16 // 128 bits of randomness.
        val randomBytes = ByteArray(NONCE_BYTES)
        securityProvider.secureRandom.nextBytes(randomBytes)
        val sb = StringBuilder()
        sb.append("oauth2:")
        for (i in 0 until NONCE_BYTES) {
            sb.append(String.format("%02x", randomBytes[i].toInt() and 0xff))
        }
        return sb.toString()
    }

    @JvmStatic
    fun createPKCEStateNonce(
        codeChallenge: String,
        tokenAccessType: String,
        scope: String?,
        mIncludeGrantedScopes: IncludeGrantedScopes?
    ): String {
        var state = String.format(
            Locale.US, "oauth2code:%s:%s:%s",
            codeChallenge,
            DbxPKCEManager.CODE_CHALLENGE_METHODS,
            tokenAccessType
        )
        if (scope != null) {
            state += ":$scope"
        }
        if (mIncludeGrantedScopes != null) {
            state += ":$mIncludeGrantedScopes"
        }
        return state
    }
}