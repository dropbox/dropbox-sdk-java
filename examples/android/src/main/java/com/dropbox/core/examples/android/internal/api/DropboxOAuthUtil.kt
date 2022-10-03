package com.dropbox.core.examples.android.internal.api

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.android.Auth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DropboxOAuthUtil(
    private val dropboxCredentialUtil: DropboxCredentialUtil,
    private val dropboxAppConfig: DropboxAppConfig
) {
    fun showWarningDialogIfAppKeyNotSet(context: Context) {
        if (dropboxAppConfig.apiKey == "PUT_YOUR_APP_KEY_HERE") {
            AlertDialog.Builder(context)
                .setTitle("API KEY Required")
                .setMessage(
                    """
                    You must specify a value for DROPBOX_APP_KEY in examples/android/local.properties.
                    
                    You can register an application and obtain an API key at https://developers.dropbox.com/
                    """.trimIndent()
                )
                .create()
                .show()
        }
    }

    var isAwaitingResult: Boolean = false

    /**
     * Starts the Dropbox OAuth process by launching the Dropbox official app or web
     * browser if dropbox official app is not available. In browser flow, normally user needs to
     * sign in.
     *
     * Because mobile apps need to keep Dropbox secrets in their binaries we need to use PKCE.
     * Read more about this here: https://dropbox.tech/developers/pkce--what-and-why-
     **/
    fun startDropboxAuthorization2PKCE(context: Context) {
        val requestConfig = DbxRequestConfig(dropboxAppConfig.clientIdentifier)

        // The scope's your app will need from Dropbox
        // Read more about Scopes here: https://developers.dropbox.com/oauth-guide#dropbox-api-permissions
        val scopes = listOf(
            "account_info.read",
            "files.content.write",
            "files.content.read",
            "sharing.read"
        )
        Auth.startOAuth2PKCE(context, dropboxAppConfig.apiKey, requestConfig, scopes)
        isAwaitingResult = true
    }

    /**
     * Starts the Dropbox OAuth process by launching the Dropbox official app or web
     * browser if dropbox official app is not available. In browser flow, normally user needs to
     * sign in.
     *
     * Because mobile apps need to keep Dropbox secrets in their binaries we need to use PKCE.
     * Read more about this here: https://dropbox.tech/developers/pkce--what-and-why-
     **/
    fun startDropboxAuthorizationOAuth2(context: Context) {
        Auth.startOAuth2Authentication(context, dropboxAppConfig.apiKey)
        isAwaitingResult = true
    }

    fun revokeDropboxAuthorization(dropboxApiWrapper: DropboxApiWrapper) {
        if (dropboxCredentialUtil.isAuthenticated()) {
            CoroutineScope(Dispatchers.IO).launch {
                dropboxApiWrapper.revokeDropboxAuthorization()
            }
            dropboxCredentialUtil.removeCredentialLocally()
        }
    }

    /**
     * Call this from onResume() in the activity you are awaiting an Auth Result
     */
    fun onResume() {
        if (isAwaitingResult) {
            val authDbxCredential = Auth.getDbxCredential() //fetch the result from the AuthActivity
            isAwaitingResult = false
            if (authDbxCredential != null) {
                dropboxCredentialUtil.storeCredentialLocally(authDbxCredential)
            }
        }
    }

}