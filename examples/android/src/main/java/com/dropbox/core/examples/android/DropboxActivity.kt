package com.dropbox.core.examples.android

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.dropbox.core.android.Auth
import com.dropbox.core.examples.android.internal.DropboxCredentialUtil
import com.dropbox.core.examples.android.internal.DropboxOAuthUtil
import com.dropbox.core.json.JsonReadException
import com.dropbox.core.oauth.DbxCredential

/**
 * Base class for Activities that require auth tokens
 * Will redirect to auth flow if needed
 */
abstract class DropboxActivity : AppCompatActivity() {

    protected val dropboxCredentialUtil by lazy { DropboxCredentialUtil(this.applicationContext) }

    protected val dropboxOAuthUtil by lazy {
        DropboxOAuthUtil(
            dropboxCredentialUtil = dropboxCredentialUtil
        )
    }

    protected val dropboxApi get() = DropboxApi(dropboxCredentialUtil.getLocalCredential()!!)

    // will use our Short Lived Token.
    override fun onResume() {
        super.onResume()
        val prefs = getSharedPreferences("dropbox-sample", Context.MODE_PRIVATE)

        dropboxCredentialUtil.getLocalCredential()?.let {
            initAndLoadData(it)
        }

        val uid = Auth.getUid()
        val storedUid = prefs.getString("user-id", null)
        if (uid != null && uid != storedUid) {
            prefs.edit().apply {
                putString("user-id", uid)
            }.apply()
        }
    }

    private fun initAndLoadData(dbxCredential: DbxCredential) {
        PicassoClient.init(applicationContext, dropboxApi.dropboxClient)
        loadData()
    }

    protected abstract fun loadData()
    protected fun hasToken(): Boolean {
        return dropboxCredentialUtil.getLocalCredential() != null
    }

}