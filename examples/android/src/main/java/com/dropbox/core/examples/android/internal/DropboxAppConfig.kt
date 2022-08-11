package com.dropbox.core.examples.android.internal

import com.dropbox.core.examples.android.BuildConfig

class DropboxAppConfig(
    val apiKey: String = BuildConfig.DROPBOX_APP_KEY,
    val clientIdentifier: String = "db-${apiKey}"
)