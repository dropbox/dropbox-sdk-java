package com.dropbox.core.examples.android

import com.dropbox.core.DbxException
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.examples.android.internal.DropboxAccountInfoResponse
import com.dropbox.core.examples.android.internal.DropboxUploadApiResponse
import com.dropbox.core.examples.android.internal.GetFilesApiResponse
import com.dropbox.core.examples.android.internal.GetFilesResponse
import com.dropbox.core.oauth.DbxCredential
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.Metadata
import com.dropbox.core.v2.files.WriteMode
import java.io.InputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class DropboxApi(dbxCredential: DbxCredential, clientIdentifier: String) {

    val dropboxClient: DbxClientV2 = DbxClientV2(
        DbxRequestConfig(clientIdentifier),
        dbxCredential
    )

    suspend fun uploadFile(fileName: String, inputStream: InputStream): DropboxUploadApiResponse =
        withContext(Dispatchers.IO) {
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

    suspend fun getAccountInfo(): DropboxAccountInfoResponse = withContext(Dispatchers.IO) {
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

    private suspend fun getFilesForFolderContinue(cursor: String) = withContext(Dispatchers.IO) {
        try {
            val files = dropboxClient.files().listFolderContinue(cursor)
            GetFilesApiResponse.Success(files)
        } catch (exception: DbxException) {
            GetFilesApiResponse.Failure(exception)
        }
    }

    suspend fun revokeDropboxAuthorization() = withContext(Dispatchers.IO) {
        dropboxClient.auth().tokenRevoke()
    }
}


