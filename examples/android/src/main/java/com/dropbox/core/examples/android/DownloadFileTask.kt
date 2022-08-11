package com.dropbox.core.examples.android

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.AsyncTask
import android.os.Environment
import com.dropbox.core.DbxException
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.FileMetadata
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

/**
 * Task to download a file from Dropbox and put it in the Downloads folder
 */
internal class DownloadFileTask(
    private val mContext: Context,
    private val mDbxClient: DbxClientV2,
    private val mCallback: Callback
) : AsyncTask<FileMetadata?, Void?, File?>() {
    private var mException: Exception? = null

    interface Callback {
        fun onDownloadComplete(result: File?)
        fun onError(e: Exception?)
    }

    override fun onPostExecute(result: File?) {
        super.onPostExecute(result)
        if (mException != null) {
            mCallback.onError(mException)
        } else {
            mCallback.onDownloadComplete(result)
        }
    }

    override fun doInBackground(vararg params: FileMetadata?): File? {
        val metadata = params[0]!!
        try {
            val path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS
            )
            val file = File(path, metadata.name)

            // Make sure the Downloads directory exists.
            if (!path.exists()) {
                if (!path.mkdirs()) {
                    mException = RuntimeException("Unable to create directory: $path")
                }
            } else if (!path.isDirectory) {
                mException = IllegalStateException("Download path is not a directory: $path")
                return null
            }
            FileOutputStream(file).use { outputStream ->
                mDbxClient.files().download(metadata.pathLower, metadata.rev)
                    .download(outputStream)
            }

            // Tell android about the file
            val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            intent.data = Uri.fromFile(file)
            mContext.sendBroadcast(intent)
            return file
        } catch (e: DbxException) {
            mException = e
        } catch (e: IOException) {
            mException = e
        }
        return null
    }
}