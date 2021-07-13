package com.dropbox.dropboxexample

import com.dropbox.core.DbxException
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.oauth.DbxCredential
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.WriteMode
import com.dropbox.core.v2.users.FullAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.InputStream

class DropboxApi(private val dropboxClient: DbxClientV2) {

    suspend fun uploadFile(fileName: String, inputStream: InputStream): DropboxUploadApiResponse = withContext(Dispatchers.IO) {
        try {
            val fileMetadata = dropboxClient
                .files()
                .uploadBuilder("/$fileName") //always upload to the root of dropbox
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

    suspend fun refreshToken() = withContext(Dispatchers.IO) {
        dropboxClient.refreshAccessToken()
    }

    suspend fun revokeDropboxAuthorization() = withContext(Dispatchers.IO) {
        dropboxClient.auth().tokenRevoke()
    }
}

sealed class DropboxUploadApiResponse {
    data class Success(val fileMetadata: FileMetadata): DropboxUploadApiResponse()
    data class Failure(val exception: DbxException): DropboxUploadApiResponse()
}

sealed class DropboxAccountInfoResponse {
    data class Success(val accountInfo: FullAccount): DropboxAccountInfoResponse()
    data class Failure(val exception: DbxException): DropboxAccountInfoResponse()
}