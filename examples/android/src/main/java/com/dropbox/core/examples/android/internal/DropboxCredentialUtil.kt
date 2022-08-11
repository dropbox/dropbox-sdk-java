
package com.dropbox.core.examples.android.internal

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import com.dropbox.core.oauth.DbxCredential

class DropboxCredentialUtil(appContext: Context) {
    private val sharedPreferences: SharedPreferences = appContext.getSharedPreferences(
        "dropbox-sample",
        AppCompatActivity.MODE_PRIVATE
    )

    //deserialize the credential from SharedPreferences if it exists
    fun getLocalCredential(): DbxCredential? {
        val serializedCredential = sharedPreferences.getString("credential", null) ?: return null
        return DbxCredential.Reader.readFully(serializedCredential)
    }

    //serialize the credential and store in SharedPreferences
    fun storeCredentialLocally(dbxCredential: DbxCredential) {
        sharedPreferences.edit().putString("credential", dbxCredential.toString()).apply()
    }

    fun removeCredentialLocally() {
        sharedPreferences.edit().remove("credential").apply()
    }
}