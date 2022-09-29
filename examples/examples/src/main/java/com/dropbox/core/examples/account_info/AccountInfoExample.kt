package com.dropbox.core.examples.account_info

import com.dropbox.core.DbxException
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.examples.CredentialsUtil
import com.dropbox.core.oauth.DbxCredential
import com.dropbox.core.v2.DbxClientV2

/**
 * An example command-line application that grab access token and refresh token from credential
 * file, and then call APIV2. If the access token has expired, SDK will automatically refresh and
 * get a new one, and store them into the original DbxCredential object.
 */
object AccountInfoExample {

    @JvmStatic
    fun main(args: Array<String>) {
        val credential = CredentialsUtil.getDbxCredential()
        runExample(credential)
    }

    fun runExample(credential: DbxCredential) {
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
