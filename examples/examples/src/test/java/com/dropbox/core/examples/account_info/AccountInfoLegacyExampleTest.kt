package com.dropbox.core.examples.account_info

import com.dropbox.core.examples.CredentialsUtil
import com.dropbox.core.examples.TestUtil
import com.dropbox.core.examples.account_info_legacy.AccountInfoLegacyExample
import org.junit.Assume.assumeTrue
import org.junit.Before
import org.junit.Test

/**
 * An example command-line application that grab access token and refresh token from credential
 * file, and then call APIV2. If the access token has expired, SDK will automatically refresh and
 * get a new one, and store them into the original DbxCredential object.
 */
class AccountInfoLegacyExampleTest {

    @Before
    fun setup() {
        assumeTrue(TestUtil.isRunningInCI())
    }

    @Test
    fun accountInfo() {
        AccountInfoLegacyExample.runExample(CredentialsUtil.getAuthInfo())
    }
}