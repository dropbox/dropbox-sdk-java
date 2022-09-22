/*
 * Copyright (c) 2009-2017 Dropbox, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.dropbox.core.android

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Parcel
import android.util.Base64
import com.dropbox.core.android.DropboxUidNotInitializedException
import com.dropbox.core.android.internal.DropboxAuthIntent

/**
 * The DbxOfficialAppConnector is used by an app to communicate with the Official Android Dropbox
 * app.
 */
public class DbxOfficialAppConnector(uid: String?) {
    /**
     * uid associated with this DbxOfficialAppConnector
     */
    protected var uid: String? = null

    public class DbxOfficialAppInstallInfo(
        /**
         * Whether installed version of Dropbox supports OpenWith
         */
        @JvmField
        public val supportsOpenWith: Boolean,
        /**
         * Version of Dropbox installed
         */
        @JvmField
        public val versionCode: Int
    ) {
        override fun toString(): String {
            return String.format(
                "DbxOfficialAppInstallInfo(versionCode=%s, supportsOpenWith=%s)",
                versionCode, supportsOpenWith
            )
        }
    }

    /**
     * Add uid information to an explicit intent directed to DropboxApp
     */
    protected fun addExtrasToIntent(context: Context, intent: Intent) {
        intent.putExtra(EXTRA_DROPBOX_UID, uid)
        intent.putExtra(EXTRA_CALLING_PACKAGE, context.packageName)
    }

    /**
     * @return If authorized user is signed in to DropboxApp
     */
    public fun isSignedIn(context: Context): Boolean {
        val loggedInState = getLoggedinState(context, uid)
        return loggedInState == CORRECT_USER
    }

    protected fun launchDropbox(context: Context): Intent? {
        val pm = context.packageManager
        val i = pm.getLaunchIntentForPackage("com.dropbox.android")
        return if (getDropboxAppPackage(context, i) == null) {
            null
        } else i
    }

    /**
     * @return Intent that when passed into startActivity() will start Dropbox account upgrade flow.
     * If DropboxApp is installed, upgrade flow will launch an activity within DropboxApp.
     * Otherwise, a web browser will be launched
     */
    public fun getUpgradeAccountIntent(context: Context): Intent {
        val upgradeIntent = Intent(ACTION_SHOW_UPGRADE)
        addExtrasToIntent(context, upgradeIntent)
        if (getDropboxAppPackage(context, upgradeIntent) != null) {
            return upgradeIntent
        }
        // Fall back to web upgrade if no Dropbox App Installed
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://www.dropbox.com/upgrade?oqa=upeaoq")
        return intent
    }

    /**
     * Construct DbxOfficialAppConnector
     *
     * @param uid The extra that goes in an intent when returning from Dropbox auth to
     * provide the user's Dropbox UID.
     * @throws DropboxUidNotInitializedException when `uid` is empty
     */
    init {
        if (uid == null || uid.length == 0) {
            throw DropboxUidNotInitializedException(
                "Must initialize session's uid before constructing DbxOfficialAppConnector"
            )
        }
        this.uid = uid
    }

    /**
     * Display the DropboxApp's preview of file located at path This function should only be called
     * if file was opened through DropboxAPI. If path refers to a directory (as defined by having a '/' at end,
     * will show Dropbox file tree.
     *
     *
     * You won't need to use this unless you are our official partner in openwith.
     *
     * @param path    path of file in authorized user's Dropbox to preview
     * @param lastRev The revision of file user is seeing (as returned by
     * DropboxAPI.getFile/DropboxAPI.putFile)
     * @return Intent that when passed into startActivity() displays Dropbox preview Returns null if
     * DropboxApp is not installed
     */
    public fun getPreviewFileIntent(context: Context, path: String?, lastRev: String?): Intent? {
        // TODO(jiuyangzhao): Assert path is valid
        val previewIntent = Intent(ACTION_SHOW_DROPBOX_PREVIEW)
        addExtrasToIntent(context, previewIntent)
        previewIntent.putExtra(EXTRA_DROPBOX_PATH, path)
        previewIntent.putExtra(EXTRA_DROPBOX_REV, lastRev)
        return if (getDropboxAppPackage(context, previewIntent) == null) {
            null
        } else previewIntent
    }

    public companion object {
        // App Connector intent definitions
        // to Dropbox actions
        public const val ACTION_SHOW_UPGRADE: String = "com.dropbox.android.intent.action.SHOW_UPGRADE"

        // extras
        public const val EXTRA_DROPBOX_UID: String = "com.dropbox.android.intent.extra.DROPBOX_UID"
        public const val EXTRA_CALLING_PACKAGE: String = "com.dropbox.android.intent.extra.CALLING_PACKAGE"

        //OpenWith intent definitions. You won't need to use this unless you are our official partner in openwith.
        // from Dropbox actions
        public const val ACTION_DBXC_EDIT: String = "com.dropbox.android.intent.action.DBXC_EDIT"
        public const val ACTION_DBXC_VIEW: String = "com.dropbox.android.intent.action.DBXC_VIEW"

        // to Dropbox actions
        public const val ACTION_SHOW_DROPBOX_PREVIEW: String = "com.dropbox.android.intent.action.SHOW_PREVIEW"

        //extras (used either dirction)
        public const val EXTRA_DROPBOX_PATH: String = "com.dropbox.android.intent.extra.DROPBOX_PATH"
        public const val EXTRA_DROPBOX_READ_ONLY: String = "com.dropbox.android.intent.extra.READ_ONLY"
        public const val EXTRA_DROPBOX_REV: String = "com.dropbox.android.intent.extra.DROPBOX_REV"
        public const val EXTRA_DROPBOX_SESSION_ID: String = "com.dropbox.android.intent.extra.SESSION_ID"
        private const val MIN_OPENWITH_VERSION = 240607

        /**
         * @return Information about installed version of DropboxApp. Returns null if DropboxApp is not
         * installed
         */
        @JvmStatic
        public fun isInstalled(context: Context): DbxOfficialAppInstallInfo? {

            // For now, use dAuth intent
            val authIntent = DropboxAuthIntent.buildActionAuthenticateIntent()
            val dropboxPackage = getDropboxAppPackage(context, authIntent) ?: return null
            val versionCode = dropboxPackage.versionCode
            val supportsOpenWith = versionCode >= MIN_OPENWITH_VERSION
            return DbxOfficialAppInstallInfo(supportsOpenWith, versionCode)
        }

        private val LOGGED_IN_URI = Uri
            .parse("content://com.dropbox.android.provider.SDK/is_user_logged_in/")
        private const val CORRECT_USER = 1
        private const val NO_USER = 0
        private const val WRONG_USER = -1

        /**
         * Determine if user uid is logged in
         *
         * @param context
         * @param uid
         * @return NO_USER if no users connected CORRECT_USER if uid connected WRONG_USER if uid not
         * connected
         */
        private fun getLoggedinState(context: Context, uid: String?): Int {
            val cursor = context.contentResolver.query(
                LOGGED_IN_URI.buildUpon().appendPath(uid).build(), null,  // projection
                null,  // selection clause
                null,  // selection args
                null
            )
                ?: // DropboxApp not installed
                return NO_USER // sort order
            cursor.moveToFirst()
            val columnIndex = cursor.getColumnIndex("logged_in")
            return if (columnIndex < 0) {
                // Column Doesn't Exist
                NO_USER
            } else cursor.getInt(columnIndex)
        }

        /**
         * @return If any account is connected to DropboxApp
         */
        @JvmStatic
        public fun isAnySignedIn(context: Context): Boolean {
            val loggedInState = getLoggedinState(context, "0")
            return loggedInState != NO_USER
        }

        /**
         * @return Intent that when passed into startActivity() will launch the Play Store page for
         * Dropbox.
         */
        @JvmStatic
        public fun getDropboxPlayStoreIntent(): Intent {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("market://details?id=com.dropbox.android")
                return intent
            }

        /* Begin internal functions */
        private val DROPBOX_APP_SIGNATURES = arrayOf(
            "308202223082018b02044bd207bd300d06092a864886f70d01010405003058310b3"
                    + "009060355040613025553310b300906035504081302434131163014060355040713"
                    + "0d53616e204672616e636973636f3110300e060355040a130744726f70626f78311"
                    + "2301006035504031309546f6d204d65796572301e170d3130303432333230343930"
                    + "315a170d3430303431353230343930315a3058310b3009060355040613025553310"
                    + "b3009060355040813024341311630140603550407130d53616e204672616e636973"
                    + "636f3110300e060355040a130744726f70626f783112301006035504031309546f6"
                    + "d204d6579657230819f300d06092a864886f70d010101050003818d003081890281"
                    + "8100ac1595d0ab278a9577f0ca5a14144f96eccde75f5616f36172c562fab0e98c4"
                    + "8ad7d64f1091c6cc11ce084a4313d522f899378d312e112a748827545146a779def"
                    + "a7c31d8c00c2ed73135802f6952f59798579859e0214d4e9c0554b53b26032a4d2d"
                    + "fc2f62540d776df2ea70e2a6152945fb53fef5bac5344251595b729d48102030100"
                    + "01300d06092a864886f70d01010405000381810055c425d94d036153203dc0bbeb3"
                    + "516f94563b102fff39c3d4ed91278db24fc4424a244c2e59f03bbfea59404512b8b"
                    + "f74662f2a32e37eafa2ac904c31f99cfc21c9ff375c977c432d3b6ec22776f28767"
                    + "d0f292144884538c3d5669b568e4254e4ed75d9054f75229ac9d4ccd0b7c3c74a34"
                    + "f07b7657083b2aa76225c0c56ffc",
            "308201e53082014ea00302010202044e17e115300d06092a864886f70d010105050"
                    + "03037310b30090603550406130255533110300e060355040a1307416e64726f6964"
                    + "311630140603550403130d416e64726f6964204465627567301e170d31313037303"
                    + "93035303331375a170d3431303730313035303331375a3037310b30090603550406"
                    + "130255533110300e060355040a1307416e64726f6964311630140603550403130d4"
                    + "16e64726f696420446562756730819f300d06092a864886f70d010101050003818d"
                    + "003081890281810096759fe5abea6a0757039b92adc68d672efa84732c3f959408e"
                    + "12efa264545c61f23141026a6d01eceeeaa13ec7087087e5894a3363da8bf5c69ed"
                    + "93657a6890738a80998e4ca22dc94848f30e2d0e1890000ae2cddf543b20c0c3828"
                    + "deca6c7944b5ecd21a9d18c988b2b3e54517dafbc34b48e801bb1321e0fa49e4d57"
                    + "5d7f0203010001300d06092a864886f70d0101050500038181002b6d4b65bcfa6ec"
                    + "7bac97ae6d878064d47b3f9f8da654995b8ef4c385bc4fbfbb7a987f60783ef0348"
                    + "760c0708acd4b7e63f0235c35a4fbcd5ec41b3b4cb295feaa7d5c27fa562a02562b"
                    + "7e1f4776b85147be3e295714986c4a9a07183f48ea09ae4d3ea31b88d0016c65b93"
                    + "526b9c45f2967c3d28dee1aff5a5b29b9c2c8639"
        )

        /**
         * Verify that intent will be processed by Dropbox App
         *
         * @return PackageInfo of DropboxApp if Dropbox App can process intent, else null
         */
        internal fun getDropboxAppPackage(context: Context, intent: Intent?): PackageInfo? {
            val manager = context.packageManager
            val infos = manager.queryIntentActivities(intent!!, 0)
            if (1 != infos.size) {
                // The official app doesn't exist, or only an older version
                // is available, or multiple activities are confusing us.
                return null
            } else {
                // The official app exists. Make sure it's the correct one by
                // checking signing keys.
                val resolveInfo = manager.resolveActivity(intent, 0) ?: return null
                val packageInfo: PackageInfo = try {
                    manager.getPackageInfo(
                        resolveInfo.activityInfo.packageName,
                        PackageManager.GET_SIGNATURES
                    )
                } catch (e: PackageManager.NameNotFoundException) {
                    return null
                }
                for (signature in packageInfo.signatures) {
                    for (dbSignature in DROPBOX_APP_SIGNATURES) {
                        if (dbSignature == signature.toCharsString()) {
                            return packageInfo
                        }
                    }
                }
            }
            return null
        }

        /**
         * Decodes a Google Play Campaign attribution utm_content field that was generated by Dropbox
         * OpenWith flow. This should only be called if utm_source=”dropbox_android_openwith”. See
         * https://developers.google.com/analytics/devguides/collection/android/v4/campaign for more
         * information about how to use Play Store attribution.
         *
         *
         * You won't need to use this unless you are our official partner in openwith.
         *
         * @param UtmContent GooglePlay utm content that has been urldecoded
         * @return Intent OpenWith intent that, when launched, will open the file the user requested to
         * edit. Caller MUST convert intent into an explicit intent it can handle.
         * @throws DropboxParseException if cannot produce Intent from UtmContent
         */
        @JvmStatic
        @Throws(DropboxParseException::class)
        public fun generateOpenWithIntentFromUtmContent(UtmContent: String?): Intent {
            // Utm content is encoded a base64-encoded marshalled bundle
            // _action is extracted and becomes intent's action
            // _uri is extracted and becomes intent's data uri
            // All other items in bundle transferred to returned intent's extras
            val b: ByteArray
            b = try {
                Base64.decode(UtmContent, 0)
            } catch (ex: IllegalArgumentException) {
                throw DropboxParseException("UtmContent was not base64 encoded: " + ex.message)
            }
            val parcel = Parcel.obtain()
            parcel.unmarshall(b, 0, b.size)
            parcel.setDataPosition(0)
            val bundle = parcel.readBundle()
            parcel.recycle()
            if (bundle == null) {
                throw DropboxParseException("Could not extract bundle from UtmContent")
            }
            val action = bundle.getString("_action") ?: throw DropboxParseException("_action was not present in bundle")
            bundle.remove("_action")
            val uri = bundle.getParcelable<Uri>("_uri")
                ?: throw DropboxParseException("_uri was not present in bundle")
            bundle.remove("_uri")
            val type = bundle.getString("_type") ?: throw DropboxParseException("_type was not present in bundle")
            bundle.remove("_type")
            val openWithIntent = Intent(action)
            openWithIntent.setDataAndType(uri, type)
            openWithIntent.putExtras(bundle)
            return openWithIntent
        }
    }
}