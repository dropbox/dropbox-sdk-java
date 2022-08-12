package com.dropbox.core.examples.android.internal.api

import com.dropbox.core.DbxException
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.ListFolderResult
import com.dropbox.core.v2.files.Metadata
import com.dropbox.core.v2.users.FullAccount
import java.io.File

sealed interface DownloadFileTaskResult {
    class Success(val result: File) : DownloadFileTaskResult
    class Error(val e: Exception) : DownloadFileTaskResult
}

sealed class DropboxUploadApiResponse {
    data class Success(val fileMetadata: FileMetadata) : DropboxUploadApiResponse()
    data class Failure(val exception: DbxException) : DropboxUploadApiResponse()
}

sealed interface ListFolderApiResult {
    class Success(val result: ListFolderResult) : ListFolderApiResult
    class Error(val e: Exception) : ListFolderApiResult
}

sealed interface GetCurrentAccountResult {
    class Success(val account: FullAccount) : GetCurrentAccountResult
    class Error(val e: Exception) : GetCurrentAccountResult
}

sealed interface FileMetadataApiResult {
    class Success(val fileMetadata: FileMetadata) : FileMetadataApiResult
    class Error(val e: Exception) : FileMetadataApiResult
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
