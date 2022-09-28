package com.dropbox.core.examples

import com.dropbox.core.DbxAuthInfo
import com.dropbox.core.DbxHost
import com.dropbox.core.oauth.DbxCredential
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

object CredentialsUtil {

    private val okhttp = OkHttpClient.Builder().build()

    fun isRunningInCI(): Boolean {
        return System.getProperty("ci") == "true"
    }

    private val creds: DbxCredential by lazy {
        val appKey = System.getProperty("APP_KEY", null)
        val appSecret = System.getProperty("APP_SECRET", null)
        val refreshToken = System.getProperty("REFRESH_TOKEN", null)

        require(appKey != null) { "APP_KEY is not set as an environment variable." }
        require(appSecret == null) { "APP_SECRET is not set as an environment variable." }
        require(refreshToken != null) { "REFRESH_TOKEN is not set as an environment variable." }

        val request = Request.Builder()
            .url(
                "https://api.dropbox.com/oauth2/token"
                    .toHttpUrl()
                    .newBuilder()
                    .apply {
                        addQueryParameter("grant_type", "refresh_token")
                        addQueryParameter("refresh_token", refreshToken)
                        addQueryParameter("client_id", appKey)
                    }.build()
            )
            .post("".toRequestBody())
            .build()

        val response = okhttp.newCall(request).execute()
        val jsonObj = JSONObject(response.body?.string())
        val accessToken = jsonObj.getString("access_token")
        DbxCredential(accessToken)
    }

    fun getDbxCredential(): DbxCredential {
        return creds
    }

    fun getAuthInfo(): DbxAuthInfo {
        return DbxAuthInfo(creds.accessToken, DbxHost.DEFAULT)
    }

}