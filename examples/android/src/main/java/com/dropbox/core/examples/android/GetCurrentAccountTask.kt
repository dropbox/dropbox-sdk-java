package com.dropbox.core.examples.android

import com.dropbox.core.DbxException
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.users.FullAccount
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.withContext

sealed interface GetCurrentAccountResult {
    class Success(val account: FullAccount) : GetCurrentAccountResult
    class Error(val e: Exception) : GetCurrentAccountResult
}

/**
 * Async task for getting user account info
 */
internal class GetCurrentAccountTask(
    private val mDbxClient: DbxClientV2,
    private val dispatcher: CoroutineContext,
){

    suspend fun execute(): GetCurrentAccountResult = withContext(dispatcher) {
        try {
            GetCurrentAccountResult.Success(mDbxClient.users().currentAccount)
        } catch (e: DbxException) {
            GetCurrentAccountResult.Error(e)
        }
    }
}