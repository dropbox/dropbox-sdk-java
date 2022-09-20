package com.dropbox.core.android.internal

import com.dropbox.core.DbxHost
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.IncludeGrantedScopes
import com.dropbox.core.TokenAccessType

/** Temporary storage for parameters before Activity is created */
internal data class AuthParameters(
    val sAppKey: String?,
    val sApiType: String?,
    val sDesiredUid: String?,
    val sAlreadyAuthedUids: List<String>,
    val sSessionId: String?,
    val sTokenAccessType: TokenAccessType?,
    val sRequestConfig: DbxRequestConfig?,
    val sHost: DbxHost?,
    val sScope: String?,
    val sIncludeGrantedScopes: IncludeGrantedScopes?,
)
