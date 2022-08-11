package com.dropbox.core.examples.android

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.dropbox.core.android.Auth
import com.dropbox.core.examples.android.internal.DropboxAppConfig
import com.dropbox.core.examples.android.internal.DropboxCredentialUtil
import com.dropbox.core.examples.android.internal.DropboxOAuthUtil


/**
 * Base class for Activities that require auth tokens
 * Will redirect to auth flow if needed
 */
abstract class DropboxActivity : AppCompatActivity() {

    protected val dropboxAppConfig = DropboxAppConfig()

    protected val dropboxCredentialUtil by lazy { DropboxCredentialUtil(this.applicationContext) }

    protected val dropboxOAuthUtil by lazy {
        DropboxOAuthUtil(
            dropboxAppConfig = dropboxAppConfig,
            dropboxCredentialUtil = dropboxCredentialUtil
        )
    }

    protected val dropboxApi
        get() = DropboxApi(
            dbxCredential = dropboxCredentialUtil.getLocalCredential()!!,
            clientIdentifier = dropboxAppConfig.clientIdentifier
        )

    // will use our Short Lived Token.
    override fun onResume() {
        super.onResume()
        if (isAuthenticated()) {
            loadData()
        }

        val prefs = getSharedPreferences("dropbox-sample", Context.MODE_PRIVATE)

        val uid = Auth.getUid()
        val storedUid = prefs.getString("user-id", null)
        if (uid != null && uid != storedUid) {
            prefs.edit().apply {
                putString("user-id", uid)
            }.apply()
        }
    }

    protected abstract fun loadData()

    protected fun isAuthenticated(): Boolean {
        return dropboxCredentialUtil.getLocalCredential() != null
    }

}