package com.dropbox.core.examples.android

import android.content.Context
import android.net.Uri
import com.dropbox.core.DbxException
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.WriteMode
import java.io.FileInputStream
import java.io.IOException
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.withContext


sealed interface FileMetadataApiResult {
    class Success(val fileMetadata: FileMetadata) : FileMetadataApiResult
    class Error(val e: Exception) : FileMetadataApiResult
}

/**
 * Async task to upload a file to a directory
 */
internal class UploadFileTask(
    private val mContext: Context,
    private val mDbxClient: DbxClientV2,
    private val dispatcher: CoroutineContext,
) {
    suspend fun execute(localUri: String, remoteFolderPath: String): FileMetadataApiResult =
        withContext(dispatcher) {
            val localFile = UriHelpers.getFileForUri(mContext, Uri.parse(localUri))
            if (localFile != null) {
                // Note - this is not ensuring the name is a valid dropbox file name
                val remoteFileName = localFile.name
                try {
                    FileInputStream(localFile).use { inputStream ->
                        val metadata = mDbxClient.files().uploadBuilder(
                            "$remoteFolderPath/$remoteFileName"
                        )
                            .withMode(WriteMode.OVERWRITE)
                            .uploadAndFinish(inputStream)
                        FileMetadataApiResult.Success(metadata)
                    }
                } catch (e: DbxException) {
                    FileMetadataApiResult.Error(e)
                } catch (e: IOException) {
                    FileMetadataApiResult.Error(e)
                }
            } else {
                FileMetadataApiResult.Error(Exception("Local File to Upload Not Found"))
            }
        }
}