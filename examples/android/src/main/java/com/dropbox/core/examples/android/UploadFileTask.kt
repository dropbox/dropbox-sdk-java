package com.dropbox.core.examples.android

import android.content.Context
import android.net.Uri
import android.os.AsyncTask
import com.dropbox.core.DbxException
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.WriteMode
import java.io.FileInputStream
import java.io.IOException

/**
 * Async task to upload a file to a directory
 */
internal class UploadFileTask(
    private val mContext: Context,
    private val mDbxClient: DbxClientV2,
    private val mCallback: Callback
) : AsyncTask<String?, Void?, FileMetadata?>() {
    private var mException: Exception? = null

    interface Callback {
        fun onUploadComplete(result: FileMetadata?)
        fun onError(e: Exception?)
    }

    override fun onPostExecute(result: FileMetadata?) {
        super.onPostExecute(result)
        if (mException != null) {
            mCallback.onError(mException)
        } else if (result == null) {
            mCallback.onError(null)
        } else {
            mCallback.onUploadComplete(result)
        }
    }

    override fun doInBackground(vararg params: String?): FileMetadata? {
        val localUri = params[0]
        val localFile = UriHelpers.getFileForUri(mContext, Uri.parse(localUri))
        if (localFile != null) {
            val remoteFolderPath = params[1]

            // Note - this is not ensuring the name is a valid dropbox file name
            val remoteFileName = localFile.name
            try {
                FileInputStream(localFile).use { inputStream ->
                    return mDbxClient.files().uploadBuilder(
                        "$remoteFolderPath/$remoteFileName"
                    )
                        .withMode(WriteMode.OVERWRITE)
                        .uploadAndFinish(inputStream)
                }
            } catch (e: DbxException) {
                mException = e
            } catch (e: IOException) {
                mException = e
            }
        }
        return null
    }
}