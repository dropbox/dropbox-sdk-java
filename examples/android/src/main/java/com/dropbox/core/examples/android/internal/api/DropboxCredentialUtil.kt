package com.dropbox.core.examples.android.internal.api

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.dropbox.core.android.Auth
import com.dropbox.core.oauth.DbxCredential

class DropboxCredentialUtil(appContext: Context) {
    private val sharedPreferences: SharedPreferences = appContext.getSharedPreferences(
        "dropbox-sample",
        AppCompatActivity.MODE_PRIVATE
    )

    fun readCredentialLocally(): DbxCredential? {
        val serializedCredentialJson = sharedPreferences.getString("credential", null)
        Log.d(TAG, "Local Credential Value from Shared Preferences: $serializedCredentialJson")
        return try {
            DbxCredential.Reader.readFully(serializedCredentialJson)
        } catch (e: Exception) {
            Log.d(TAG, "Something went wrong parsing the credential, clearing it")
            removeCredentialLocally()
            null
        }
    }

    //serialize the credential and store in SharedPreferences
    fun storeCredentialLocally(dbxCredential: DbxCredential) {
        Log.d(TAG, "Storing credential in Shared Preferences")
        sharedPreferences.edit().apply {
            putString("credential", DbxCredential.Writer.writeToString(dbxCredential))
        }.apply()
    }

    fun removeCredentialLocally() {
        Log.d(TAG, "Clearing credential from Shared Preferences")
        sharedPreferences.edit().apply {
            remove("credential")
        }.apply()
    }

    fun isAuthenticated(): Boolean {
        return readCredentialLocally() != null
    }

    private companion object {
        private val TAG = DropboxCredentialUtil::class.java.simpleName
    }
}