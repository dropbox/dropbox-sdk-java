package com.dropbox.core.examples.android

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.dropbox.core.android.Auth
import com.dropbox.core.examples.android.internal.di.AppGraph


/**
 * Base class for Activities that require auth tokens
 * Will redirect to auth flow if needed
 */
abstract class BaseSampleActivity : AppCompatActivity() {

    val appGraph: AppGraph get() = (this.applicationContext as DropboxAndroidSampleApplication).appGraph

    protected val dropboxOAuthUtil get() = appGraph.dropboxOAuthUtil

    protected val dropboxCredentialUtil get() = appGraph.dropboxCredentialUtil

    protected val dropboxApiWrapper get() = appGraph.dropboxApiWrapper

    // will use our Short Lived Token.
    override fun onResume() {
        super.onResume()
        dropboxOAuthUtil.onResume()
        if (isAuthenticated()) {
            loadData()
        }

        val prefs = getSharedPreferences("dropbox-sample", Context.MODE_PRIVATE)

        val uid = Auth.uid
        val storedUid = prefs.getString("user-id", null)
        if (uid != null && uid != storedUid) {
            prefs.edit().apply {
                putString("user-id", uid)
            }.apply()
        }
    }

    protected abstract fun loadData()

    protected fun isAuthenticated(): Boolean {
        return dropboxCredentialUtil.isAuthenticated()
    }

}