package com.dropbox.core.examples.android.internal.di;

import android.content.Context
import com.dropbox.core.examples.android.internal.api.DropboxApiWrapper
import com.dropbox.core.examples.android.internal.api.DropboxAppConfig
import com.dropbox.core.examples.android.internal.api.DropboxCredentialUtil
import com.dropbox.core.examples.android.internal.api.DropboxOAuthUtil

internal class AppGraphImpl(context: Context) : AppGraph {
    private val dropboxAppConfig = DropboxAppConfig()

    override val dropboxCredentialUtil by lazy { DropboxCredentialUtil(context.applicationContext) }

    override val dropboxOAuthUtil by lazy {
        DropboxOAuthUtil(
            dropboxAppConfig = dropboxAppConfig,
            dropboxCredentialUtil = dropboxCredentialUtil
        )
    }

    override val dropboxApiWrapper
        get() = DropboxApiWrapper(
            dbxCredential = dropboxCredentialUtil.readCredentialLocally()!!,
            clientIdentifier = dropboxAppConfig.clientIdentifier
        )
}
