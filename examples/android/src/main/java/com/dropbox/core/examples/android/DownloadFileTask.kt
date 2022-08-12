package com.dropbox.core.examples.android

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import com.dropbox.core.DbxException
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.FileMetadata
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

sealed interface DownloadFileTaskResult {
    class Success(val result: File) : DownloadFileTaskResult
    class Error(val e: Exception) : DownloadFileTaskResult
}

/**
 * Task to download a file from Dropbox and put it in the Downloads folder
 */
internal class DownloadFileTask(
    private val mContext: Context,
    private val mDbxClient: DbxClientV2,
    private val dispatcher: CoroutineContext,
) {
    suspend fun download(metadata: FileMetadata): DownloadFileTaskResult = withContext(dispatcher){
         try {
            val path = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS
            )
            val file = File(path, metadata.name)

            // Make sure the Downloads directory exists.
            if (!path.exists()) {
                if (!path.mkdirs()) {
                    return@withContext DownloadFileTaskResult.Error(
                        RuntimeException("Unable to create directory: $path")
                    )
                }
            } else if (!path.isDirectory) {
                return@withContext  DownloadFileTaskResult.Error(
                    IllegalStateException("Download path is not a directory: $path")
                )
            }
            FileOutputStream(file).use { outputStream ->
                mDbxClient.files().download(metadata.pathLower, metadata.rev)
                    .download(outputStream)
            }

            // Tell android about the file
            val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            intent.data = Uri.fromFile(file)
            mContext.sendBroadcast(intent)
             DownloadFileTaskResult.Success(file)
        } catch (e: DbxException) {
             DownloadFileTaskResult.Error(e)
        } catch (e: IOException) {
             DownloadFileTaskResult.Error(e)
        }
    }
}