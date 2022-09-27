package com.dropbox.core.examples.account_info_legacy

import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.examples.CredentialsUtil
import com.dropbox.core.examples.CredentialsUtil.getAuthInfo
import com.dropbox.core.examples.CredentialsUtil.isRunningInCI
import com.dropbox.core.stone.StoneDeserializerLogger
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.users.Name
import org.junit.Ignore
import org.junit.Test

/**
 * An example command-line application that runs through the web-based OAuth
 * flow (using [DbxWebAuth]).
 */
class AccountInfoLegacyExample {

    @Ignore("Not Enabling Yet")
    @Test
    fun test() {
        if (!isRunningInCI()) {
            // Only run in CI
            return
        }
        // Read auth info file.
        val authInfo = getAuthInfo()

        // Create a DbxClientV2, which is what you use to make API calls.
        val requestConfig = DbxRequestConfig("examples-account-info")
        val dbxClient = DbxClientV2(requestConfig, authInfo.accessToken, authInfo.host)
        val callback = StoneDeserializerLogger.LoggerCallback { _: Any?, s: String? ->
            println("This is from StoneDeserializerLogger: ")
            println(s)
        }
        StoneDeserializerLogger.registerCallback(Name::class.java, callback)

        // Make the /account/info API call.
        val dbxAccountInfo = dbxClient.users().currentAccount
        print(dbxAccountInfo.toStringMultiline())
    }
}