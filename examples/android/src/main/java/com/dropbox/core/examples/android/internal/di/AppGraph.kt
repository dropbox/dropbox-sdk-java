package com.dropbox.core.examples.android.internal.di

import com.dropbox.core.examples.android.internal.api.DropboxApiWrapper
import com.dropbox.core.examples.android.internal.api.DropboxCredentialUtil
import com.dropbox.core.examples.android.internal.api.DropboxOAuthUtil

interface AppGraph {
    val dropboxCredentialUtil: DropboxCredentialUtil
    val dropboxOAuthUtil: DropboxOAuthUtil
    val dropboxApiWrapper: DropboxApiWrapper
}