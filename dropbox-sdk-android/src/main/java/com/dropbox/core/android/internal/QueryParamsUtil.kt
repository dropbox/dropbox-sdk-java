package com.dropbox.core.android.internal

import com.dropbox.core.DbxPKCEManager
import com.dropbox.core.IncludeGrantedScopes
import com.dropbox.core.TokenAccessType
import java.util.*

internal object QueryParamsUtil {

    internal fun createExtraQueryParams(
        tokenAccessType: TokenAccessType?,
        scope: String?,
        includeGrantedScopes: IncludeGrantedScopes?,
        pkceManagerCodeChallenge: String,
    ): String {
        checkNotNull(tokenAccessType) {
            "Extra Query Param should only be used in short live " +
                    "token flow."
        }
        var param = String.format(
            Locale.US,
            "%s=%s&%s=%s&%s=%s&%s=%s",
            "code_challenge", pkceManagerCodeChallenge,
            "code_challenge_method", DbxPKCEManager.CODE_CHALLENGE_METHODS,
            "token_access_type", tokenAccessType.toString(),
            "response_type", "code"
        )
        if (scope != null) {
            param += String.format(Locale.US, "&%s=%s", "scope", scope)
        }
        if (includeGrantedScopes != null) {
            param += String.format(
                Locale.US, "&%s=%s", "include_granted_scopes",
                includeGrantedScopes.toString()
            )
        }
        return param
    }
}