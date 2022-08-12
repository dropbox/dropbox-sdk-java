package com.dropbox.core.examples.android

import com.dropbox.core.DbxException
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.ListFolderResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

sealed interface ListFolderApiResult {
    class Success(val result: ListFolderResult) : ListFolderApiResult
    class Error(val e: Exception) : ListFolderApiResult
}

/**
 * Async task to list items in a folder
 */
internal class ListFolderTask(
    private val mDbxClient: DbxClientV2,
) {
    suspend fun execute(path: String): ListFolderApiResult = withContext(Dispatchers.IO) {
        try {
            ListFolderApiResult.Success(mDbxClient.files().listFolder(path))
        } catch (e: DbxException) {
            ListFolderApiResult.Error(e)
        }
    }
}