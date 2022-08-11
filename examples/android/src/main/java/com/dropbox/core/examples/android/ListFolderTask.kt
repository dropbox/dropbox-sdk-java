package com.dropbox.core.examples.android

import android.os.AsyncTask
import com.dropbox.core.DbxException
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.ListFolderResult

/**
 * Async task to list items in a folder
 */
internal class ListFolderTask(
    private val mDbxClient: DbxClientV2,
    private val mCallback: Callback
) : AsyncTask<String?, Void?, ListFolderResult?>() {
    private var mException: Exception? = null

    interface Callback {
        fun onDataLoaded(result: ListFolderResult?)
        fun onError(e: Exception?)
    }

    override fun onPostExecute(result: ListFolderResult?) {
        super.onPostExecute(result)
        if (mException != null) {
            mCallback.onError(mException)
        } else {
            mCallback.onDataLoaded(result)
        }
    }

    override fun doInBackground(vararg params: String?): ListFolderResult? {
        mException = try {
            return mDbxClient.files().listFolder(params[0])
        } catch (e: DbxException) {
            e
        }
        return null
    }
}