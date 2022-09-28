package com.dropbox.core.examples.account_info

import com.dropbox.core.DbxException
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.examples.CredentialsUtil.getDbxCredential
import com.dropbox.core.examples.CredentialsUtil.isRunningInCI
import com.dropbox.core.v2.DbxClientV2
import org.junit.Test
import java.io.IOException

/**
 * An example command-line application that grab access token and refresh token from credential
 * file, and then call APIV2. If the access token has expired, SDK will automatically refresh and
 * get a new one, and store them into the original DbxCredential object.
 */
class AccountInfoExample {

    @Test
    fun test() {
        if (!isRunningInCI()) {
            // Only run in CI
            return
        }
        val credential = getDbxCredential()
        // Create a DbxClientV2, which is what you use to make API calls.
        val requestConfig = DbxRequestConfig("examples-account-info")
        // Use DbxCredential to create dbx client.
        val dbxClient = DbxClientV2(requestConfig, credential)

        // Make the /account/info API call.
        try {
            val dbxAccountInfo = dbxClient.users().currentAccount
            println(dbxAccountInfo.toStringMultiline())
        } catch (ex: DbxException) {
            throw RuntimeException("Error making API call: " + ex.message)
        }
    }
}