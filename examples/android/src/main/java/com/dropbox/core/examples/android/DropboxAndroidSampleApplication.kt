package com.dropbox.core.examples.android

import android.app.Application
import com.dropbox.core.examples.android.internal.di.AppGraph
import com.dropbox.core.examples.android.internal.di.AppGraphImpl

class DropboxAndroidSampleApplication : Application() {
    val appGraph: AppGraph = AppGraphImpl(this)
}