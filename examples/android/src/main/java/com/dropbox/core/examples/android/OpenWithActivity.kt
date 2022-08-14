package com.dropbox.core.examples.android

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcel
import android.util.Base64
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.dropbox.core.android.Auth
import com.dropbox.core.android.DbxOfficialAppConnector
import com.dropbox.core.android.DropboxParseException
import com.dropbox.core.android.DropboxUidNotInitializedException

/**
 * This example is only for 3rd party apps who registered OpenWith feature at our server side who use
 * intent action {@value DbxOfficialAppConnector#ACTION_DBXC_EDIT} and
 * {@value DbxOfficialAppConnector#ACTION_DBXC_VIEW} to jump to their apps. Don't follow this if
 * you don't need openwith or if you use regular {@value Intent#ACTION_EDIT} and
 * {@value Intent#ACTION_VIEW}.
 */
class OpenWithActivity : BaseSampleActivity() {
    private var mDoac: DbxOfficialAppConnector? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_open_with)
        val toolbar = findViewById<View>(R.id.app_bar) as Toolbar
        setSupportActionBar(toolbar)
        val generateIntentButton = findViewById<View>(R.id.generate_intent) as Button
        generateIntentButton.setOnClickListener {
            val editText = findViewById<View>(R.id.editText) as EditText
            val path = editText.text.toString()
            //fake OpenWithIntent with some dummy parameters
            val fakeOpenWithIntent = generateOpenWithIntent(path)
            //encode the fake OpenWithIntent into UtmContent
            val encodedFakeIntent = encodeOpenWithIntent(fakeOpenWithIntent)
            try {
                //test that decoding utmcontent works
                val decodedIntent = DbxOfficialAppConnector
                    .generateOpenWithIntentFromUtmContent(encodedFakeIntent)
                //start that fake OpenWithIntent. This will lead us to a new OpenWithActivity.
                startActivity(decodedIntent)
            } catch (e: DropboxParseException) {
                // TODO Auto-generated catch block
                e.printStackTrace()
            }
        }
        val mInstalled = findViewById<View>(R.id.is_installed) as Button
        mInstalled.setOnClickListener {
            val installInfo = DbxOfficialAppConnector.isInstalled(this@OpenWithActivity)
            val toastText = installInfo?.toString() ?: "Not installed!"
            showToast(toastText)
        }
        val mGenLinked = findViewById<View>(R.id.is_linked_any_button) as Button
        mGenLinked.setOnClickListener {
            val isSigned = DbxOfficialAppConnector.isAnySignedIn(this@OpenWithActivity)
            showToast("Any Signed in?: $isSigned")
        }
        val mSpecLinked = findViewById<View>(R.id.is_linked_spec_button) as Button
        mSpecLinked.setOnClickListener {
            val isSigned = mDoac!!.isSignedIn(this@OpenWithActivity)
            showToast("Signed in?: $isSigned")
        }
        val mPreview = findViewById<View>(R.id.preview_button) as Button
        mPreview.setOnClickListener {
            val editText = findViewById<View>(R.id.editText) as EditText
            val path = editText.text.toString()
            val pIntent = mDoac!!.getPreviewFileIntent(this@OpenWithActivity, path, "")
            startActivity(pIntent)
        }
        val mUpgrade = findViewById<View>(R.id.upgrade_button) as Button
        mUpgrade.setOnClickListener {
            val uIntent = mDoac!!.getUpgradeAccountIntent(this@OpenWithActivity)
            startActivity(uIntent)
        }
    }

    /* Because it's just a fake intent, we just print it in Toast and do nothing here. As third
     * party app you should take the intent from Dropbox official app and potentially go through
     * the auth flow. Finally handle that file sent with this intent.
     */
    private fun handleFakeOpenWithIntent(intent: Intent) {
        if (intent.action == DbxOfficialAppConnector.ACTION_DBXC_EDIT || intent.action == DbxOfficialAppConnector.ACTION_DBXC_VIEW) {
            val path = intent.getStringExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_PATH)
            val uid = intent.getStringExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_UID)
            val read_only =
                intent.getBooleanExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_READ_ONLY, false)
            val session_id = intent.getStringExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_SESSION_ID)
            showToast(path + uid + read_only + session_id)
        }
    }

    protected fun generateOpenWithIntent(path: String): Intent {
        /*
         * Generate an OpenWithIntent.
         * Real 3rd party apps should never run this function as DropboxApp does this entirely
         */
        val uid = Auth.getUid()

        // fake the URI
        // WARNING: URI FORMAT IS NOT FINALIZED AND MAY CHANGE AT ANY TIME
        val builder = Uri.Builder()
        builder.scheme("content")
        builder.authority("com.dropbox.android.FileCache")
        builder.appendPath("filecache")
        builder.appendPath(uid)
        for (component in path.substring(1).split("/".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()) {
            builder.appendPath(component)
        }
        val uri = builder.build()
        // end URI fakery
        val owpIntent = Intent(DbxOfficialAppConnector.ACTION_DBXC_EDIT, uri)

        // extras
        owpIntent.putExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_PATH, path)
        owpIntent.putExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_UID, uid)
        owpIntent.putExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_READ_ONLY, false)
        owpIntent.putExtra(DbxOfficialAppConnector.EXTRA_DROPBOX_SESSION_ID, "generated")
        owpIntent.setDataAndType(uri, "text/plain")
        return owpIntent
    }

    protected fun encodeOpenWithIntent(owpIntent: Intent): String {
        /*
         * Encode OpenWith intent
         * Real 3rd party apps should never run this function as DropboxApp does this entirely
         */
        val extras = owpIntent.extras
        extras!!.putString("_action", owpIntent.action)
        extras.putParcelable("_uri", owpIntent.data)
        extras.putString("_type", owpIntent.type)

        // marshall it!
        val parcel = Parcel.obtain()
        parcel.writeBundle(extras)
        val b = parcel.marshall()
        parcel.recycle()
        return String(Base64.encode(b, 0))
    }

    private fun showToast(msg: String) {
        val error = Toast.makeText(this, msg, Toast.LENGTH_LONG)
        error.show()
    }

    override fun loadData() {
        try {
            var uid = Auth.getUid()
            if (uid == null) {
                val prefs = getSharedPreferences("dropbox-sample", Context.MODE_PRIVATE)
                uid = prefs.getString("user-id", null)
            }
            mDoac = DbxOfficialAppConnector(uid)
        } catch (e: DropboxUidNotInitializedException) {
            e.printStackTrace()
            return
        }
        handleFakeOpenWithIntent(intent)
    }
}