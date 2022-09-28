package com.dropbox.core.examples.authorize

import com.dropbox.core.DbxAppInfo
import com.dropbox.core.DbxAuthFinish
import com.dropbox.core.json.JsonReader
import com.dropbox.core.oauth.DbxCredential
import java.io.File
import java.io.IOException
import java.util.logging.Level
import java.util.logging.Logger

/**
 *
 * An example command-line application that runs through the web-based OAuth
 * flow (using [DbxWebAuth]). It grabs short-live token as well as
 * refresh token from server. It stores all authentication related data into the new
 * DbxCredential object and save them to file.
 */
object AuthorizeExample {
    @JvmStatic
    fun main(args: Array<String>) {
        // Only display important log messages.
        Logger.getLogger("").level = Level.WARNING
        if (args.size != 3) {
            System.err.println("Usage: COMMAND <app-info-file> <auth-file-output> <mode>")
            System.err.println("")
            System.err.println("<app-info-file>: a JSON file with information about your API app.  Example:")
            System.err.println("")
            System.err.println("  {")
            System.err.println("    \"key\": \"Your Dropbox API app key...\",")
            System.err.println("    \"secret\": \"Your Dropbox API app secret...\"")
            System.err.println("  }")
            System.err.println("")
            System.err.println("  Get an API app key by registering with Dropbox:")
            System.err.println("    https://dropbox.com/developers/apps")
            System.err.println("")
            System.err.println("<auth-file-output>: If authorization is successful, the resulting API")
            System.err.println("  credential will be saved to this file, which can then be used with")
            System.err.println("  other example programs, such as the one in \"examples/account-info\".")
            System.err.println("")
            System.err.println("<mode>: value can only be short_live_token, pkce, scope, or incremental.")
            System.err.println("  short_live_token: authorization will request short_lived_token")
            System.err.println("    together with refresh token and expiration time.")
            System.err.println("  pkce: authorization will run short_live_token without app secret")
            System.err.println("    use that when you have a client side only app without server.")
            System.err.println("  scope: authorization will request specific scope.")
            System.err.println("")
            System.exit(1)
            return
        }
        val argAppInfoFile = args[0]
        val argAuthFileOutput = args[1]

        // Read app info file (contains app key and app secret)
        val appInfo: DbxAppInfo
        appInfo = try {
            DbxAppInfo.Reader.readFromFile(argAppInfoFile)
        } catch (ex: JsonReader.FileLoadException) {
            System.err.println("Error reading <app-info-file>: " + ex.message)
            System.exit(1)
            return
        }

        // Run through Dropbox API authorization process
        var authFinish: DbxAuthFinish? = null
        when (args[2]) {
            "short_live_token" -> authFinish = ShortLiveTokenAuthorize().authorize(appInfo)
            "pkce" -> authFinish = PkceAuthorize().authorize(appInfo)
            "scope" -> authFinish = ScopeAuthorize().authorize(appInfo)
            else -> {
                System.err.println("Error reading <mode> : " + args[2])
                System.exit(1)
            }
        }
        println("Authorization complete.")
        println("- User ID: " + authFinish!!.userId)
        println("- Account ID: " + authFinish.accountId)
        println("- Access Token: " + authFinish.accessToken)
        println("- Expires At: " + authFinish.expiresAt)
        println("- Refresh Token: " + authFinish.refreshToken)
        println("- Scope: " + authFinish.scope)

        // Save auth information the new DbxCredential instance. It also contains app_key and
        // app_secret which is required to do refresh call.
        val credential = DbxCredential(
            authFinish.accessToken, authFinish
                .expiresAt, authFinish.refreshToken, appInfo.key, appInfo.secret
        )
        val output = File(argAuthFileOutput)
        try {
            DbxCredential.Writer.writeToFile(credential, output)
            println("Saved authorization information to \"" + output.canonicalPath + "\".")
        } catch (ex: IOException) {
            System.err.println("Error saving to <auth-file-out>: " + ex.message)
            System.err.println("Dumping to stderr instead:")
            DbxCredential.Writer.writeToStream(credential, System.err)
            System.exit(1)
            return
        }
    }
}