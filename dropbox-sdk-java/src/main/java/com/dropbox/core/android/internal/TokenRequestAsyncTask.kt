package com.dropbox.core.android.internal;

import android.os.AsyncTask
import android.util.Log
import com.dropbox.core.DbxAuthFinish
import com.dropbox.core.DbxException
import com.dropbox.core.DbxHost
import com.dropbox.core.DbxPKCEManager
import com.dropbox.core.DbxRequestConfig

internal class TokenRequestAsyncTask(
    private val code: String,
    private val mPKCEManager: DbxPKCEManager,
    private val requestConfig: DbxRequestConfig,
    private val appKey: String,
    private val host: DbxHost,
) : AsyncTask<Void, Void, DbxAuthFinish>() {

    override fun doInBackground(vararg params: Void?): DbxAuthFinish? {
        return try {
            val redirectUri = null
            mPKCEManager.makeTokenRequest(requestConfig, code, appKey, redirectUri, host)
        } catch (e: DbxException) {
            Log.e(TAG, "Token Request Failed: " + e.message)
            null
        }
    }

    companion object {
        private val TAG: String = TokenRequestAsyncTask::class.java.simpleName
    }
}