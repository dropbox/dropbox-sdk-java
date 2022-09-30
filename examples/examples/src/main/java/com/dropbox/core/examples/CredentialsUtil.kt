package com.dropbox.core.examples

import com.dropbox.core.DbxAuthInfo
import com.dropbox.core.DbxHost
import com.dropbox.core.oauth.DbxCredential
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import java.io.File

object CredentialsUtil {

    private val okhttp = OkHttpClient.Builder().build()

    data class OAuth2TokenInputs(
        val appKey: String?,
        val appSecret: String?,
        val refreshToken: String?,
    ) {
        companion object {
            fun fromEnvironment(): OAuth2TokenInputs {
                val appKey = System.getenv("APP_KEY")
                val appSecret = System.getenv("APP_SECRET")
                val refreshToken = System.getenv("REFRESH_TOKEN")

                require(appKey?.isNotEmpty() == true) { "APP_KEY is not set as an environment variable." }
                require(appSecret?.isNotEmpty() == true) { "APP_SECRET is not set as an environment variable." }
                require(refreshToken?.isNotEmpty() == true) { "REFRESH_TOKEN is not set as an environment variable." }

                return OAuth2TokenInputs(
                    appKey = appKey,
                    appSecret = appSecret,
                    refreshToken = refreshToken
                )
            }
        }
    }

    /**
     * Will call the token API and get a new Access Token in exchange for a Refresh Token and App Key
     */
    private fun credsFromRefreshToken(refreshToken: String, appKey: String): DbxCredential {
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
        return DbxCredential(accessToken)
    }

    /**
     * JSON file that is generated at auth_output when the ./generate-ci-auth-file script is run
     * with the required parameters.  This is read in CI during integration tests.
     */
    private val authOutputFile = File("../../auth_output")

    fun getDbxCredential(): DbxCredential {
        return DbxCredential.Reader.readFromFile(authOutputFile)
    }

    fun getAuthInfo(): DbxAuthInfo {
        return DbxAuthInfo.Reader.readFromFile(authOutputFile)
    }

}
