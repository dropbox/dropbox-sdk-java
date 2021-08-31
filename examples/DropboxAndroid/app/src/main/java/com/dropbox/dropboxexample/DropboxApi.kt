package com.dropbox.dropboxexample

import com.dropbox.core.DbxException
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.ListFolderResult
import com.dropbox.core.v2.files.Metadata
import com.dropbox.core.v2.files.WriteMode
import com.dropbox.core.v2.users.FullAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.InputStream

class DropboxApi(private val dropboxClient: DbxClientV2) {

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

sealed class DropboxUploadApiResponse {
    data class Success(val fileMetadata: FileMetadata) : DropboxUploadApiResponse()
    data class Failure(val exception: DbxException) : DropboxUploadApiResponse()
}

sealed class DropboxAccountInfoResponse {
    data class Success(val accountInfo: FullAccount) : DropboxAccountInfoResponse()
    data class Failure(val exception: DbxException) : DropboxAccountInfoResponse()
}

sealed class GetFilesResponse {
    data class Success(val result: List<Metadata>) : GetFilesResponse()
    data class Failure(val exception: DbxException) : GetFilesResponse()
}


sealed class GetFilesApiResponse {
    data class Success(val result: ListFolderResult) : GetFilesApiResponse()
    data class Failure(val exception: DbxException) : GetFilesApiResponse()
}
