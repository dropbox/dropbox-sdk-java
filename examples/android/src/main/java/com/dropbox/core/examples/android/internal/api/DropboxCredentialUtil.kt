package com.dropbox.core.examples.android.internal.api

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.dropbox.core.android.Auth
import com.dropbox.core.oauth.DbxCredential

class DropboxCredentialUtil(appContext: Context) {
    private val sharedPreferences: SharedPreferences = appContext.getSharedPreferences(
        "dropbox-sample",
        AppCompatActivity.MODE_PRIVATE
    )

    //deserialize the credential from SharedPreferences if it exists
    fun getLocalCredential(): DbxCredential? {
        val serializedCredential = sharedPreferences.getString("credential", null)
        val resultCredential: DbxCredential? = if (serializedCredential != null) {
            DbxCredential.Reader.readFully(serializedCredential)
        } else {
            val authDbxCredential = Auth.dbxCredential //fetch the result from the AuthActivity
            if (authDbxCredential != null) {
                storeCredentialLocally(authDbxCredential)
                authDbxCredential
            } else {
                null
            }
        }
        return resultCredential
    }

    //serialize the credential and store in SharedPreferences
    fun storeCredentialLocally(dbxCredential: DbxCredential) {
        sharedPreferences.edit().apply {
            putString("credential", DbxCredential.Writer.writeToString(dbxCredential))
        }.apply()
    }

    fun removeCredentialLocally() {
        sharedPreferences.edit().apply {
            remove("credential")
        }.apply()
    }
}