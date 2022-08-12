package com.dropbox.core.examples.android.internal.api

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Environment
import com.dropbox.core.DbxException
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.oauth.DbxCredential
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.Metadata
import com.dropbox.core.v2.files.WriteMode
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class DropboxApiWrapper(
    dbxCredential: DbxCredential,
    clientIdentifier: String,
    private val ioDispatcher: CoroutineContext = Dispatchers.IO
) {

    val dropboxClient: DbxClientV2 = DbxClientV2(
        DbxRequestConfig(clientIdentifier),
        dbxCredential
    )

    suspend fun getCurrentAccount(): GetCurrentAccountResult = withContext(ioDispatcher) {
        try {
            GetCurrentAccountResult.Success(dropboxClient.users().currentAccount)
        } catch (e: DbxException) {
            GetCurrentAccountResult.Error(e)
        }
    }

    suspend fun uploadFile(fileName: String, inputStream: InputStream): DropboxUploadApiResponse =
        withContext(ioDispatcher) {
            try {
                val fileMetadata = dropboxClient
                    .files()
                    .uploadBuilder("/$fileName") //Upload to the root of Dropbox
                    .withMode(WriteMode.OVERWRITE)
                    .uploadAndFinish(inputStream)
                DropboxUploadApiResponse.Success(fileMetadata)
            } catch (exception: DbxException) {
                DropboxUploadApiResponse.Failure(exception)
            }
        }

    suspend fun getAccountInfo(): DropboxAccountInfoResponse = withContext(ioDispatcher) {
        try {
            val accountInfo = dropboxClient.users().currentAccount
            DropboxAccountInfoResponse.Success(accountInfo)
        } catch (exception: DbxException) {
            DropboxAccountInfoResponse.Failure(exception)
        }
    }

    /**
     *   Loads the file metadata for a folder, it will continue until the server says there is no
     *   more data in the folder
     */
    fun getFilesForFolderFlow(folderPath: String): Flow<GetFilesResponse> = flow {
        val files = mutableListOf<Metadata>()
        when (val response = getFilesForFolder(folderPath)) {
            is GetFilesApiResponse.Failure -> {
                emit(GetFilesResponse.Failure(response.exception))
            }
            is GetFilesApiResponse.Success -> {
                var hasMore = response.result.hasMore
                var cursor = response.result.cursor
                files.addAll(response.result.entries)
                emit(GetFilesResponse.Success(files))
                while (hasMore) {
                    when (val continueResponse = getFilesForFolderContinue(cursor)) {
                        is GetFilesApiResponse.Failure -> {
                            emit(GetFilesResponse.Failure(continueResponse.exception))
                        }
                        is GetFilesApiResponse.Success -> {
                            cursor = continueResponse.result.cursor
                            hasMore = continueResponse.result.hasMore
                            files.addAll(continueResponse.result.entries)
                            emit(GetFilesResponse.Success(files))
                        }
                    }
                }
            }
        }
    }

    private suspend fun getFilesForFolder(folderPath: String): GetFilesApiResponse =
        withContext(Dispatchers.IO) {
            try {
                val files = dropboxClient.files().listFolder(folderPath)
                GetFilesApiResponse.Success(files)
            } catch (exception: DbxException) {
                GetFilesApiResponse.Failure(exception)
            }
        }

    private suspend fun getFilesForFolderContinue(cursor: String) = withContext(ioDispatcher) {
        try {
            val files = dropboxClient.files().listFolderContinue(cursor)
            GetFilesApiResponse.Success(files)
        } catch (exception: DbxException) {
            GetFilesApiResponse.Failure(exception)
        }
    }

    suspend fun revokeDropboxAuthorization() = withContext(ioDispatcher) {
        dropboxClient.auth().tokenRevoke()
    }

    suspend fun listFolders(path: String): ListFolderApiResult = withContext(ioDispatcher) {
        try {
            ListFolderApiResult.Success(dropboxClient.files().listFolder(path))
        } catch (e: DbxException) {
            ListFolderApiResult.Error(e)
        }
    }

    suspend fun uploadFile(localFile: File, remoteFolderPath: String): FileMetadataApiResult =
        withContext(ioDispatcher) {
            if (localFile != null) {
                // Note - this is not ensuring the name is a valid dropbox file name
                val remoteFileName = localFile.name
                try {
                    FileInputStream(localFile).use { inputStream ->
                        val metadata = dropboxClient.files().uploadBuilder(
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

    suspend fun download(
        applicationContext: Context,
        metadata: FileMetadata
    ): DownloadFileTaskResult = withContext(ioDispatcher) {
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
                return@withContext DownloadFileTaskResult.Error(
                    IllegalStateException("Download path is not a directory: $path")
                )
            }
            FileOutputStream(file).use { outputStream ->
                dropboxClient.files().download(metadata.pathLower, metadata.rev)
                    .download(outputStream)
            }

            // Tell android about the file
            val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            intent.data = Uri.fromFile(file)
            applicationContext.sendBroadcast(intent)
            DownloadFileTaskResult.Success(file)
        } catch (e: DbxException) {
            DownloadFileTaskResult.Error(e)
        } catch (e: IOException) {
            DownloadFileTaskResult.Error(e)
        }
    }
}


