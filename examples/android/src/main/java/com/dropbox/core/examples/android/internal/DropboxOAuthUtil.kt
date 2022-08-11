package com.dropbox.core.examples.android.internal

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.android.Auth
import com.dropbox.core.examples.android.BuildConfig
import com.dropbox.core.examples.android.DropboxApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class DropboxOAuthUtil(
    private val dropboxCredentialUtil: DropboxCredentialUtil,
    private val apiKey: String = BuildConfig.DROPBOX_APP_KEY,
    private val clientIdentifier: String = "db-$apiKey",
) {
    fun showWarningDialogIfAppKeyNotSet(context: Context) {
        if (apiKey == "PUT_YOUR_APP_KEY_HERE") {
            AlertDialog.Builder(context)
                .setTitle("API KEY Required")
                .setMessage(
                    """
                    You must specify an DROPBOX_APP_KEY KEY in local.properties.
                    
                    You can get your own API key at https://developers.dropbox.com/.
                    """.trimIndent()
                )
                .create()
                .show()
        }
    }

    /**
     * Starts the Dropbox OAuth process by launching the Dropbox official app or web
     * browser if dropbox official app is not available. In browser flow, normally user needs to
     * sign in.
     *
     * Because mobile apps need to keep Dropbox secrets in their binaries we need to use PKCE.
     * Read more about this here: https://dropbox.tech/developers/pkce--what-and-why-
     **/
    fun startDropboxAuthorization(context: Context) {
        val requestConfig = DbxRequestConfig(clientIdentifier)

        // The scope's your app will need from Dropbox
        // Read more about Scopes here: https://developers.dropbox.com/oauth-guide#dropbox-api-permissions
        val scopes = listOf("account_info.read", "files.content.write")
        Auth.startOAuth2PKCE(context, apiKey, requestConfig, scopes)
    }

    fun revokeDropboxAuthorization(scope: CoroutineScope) {
        val credential = dropboxCredentialUtil.getLocalCredential()
        val dropboxApi = DropboxApi(credential!!)
        scope.launch {
            dropboxApi.revokeDropboxAuthorization()
        }
        dropboxCredentialUtil.removeCredentialLocally()
    }
}