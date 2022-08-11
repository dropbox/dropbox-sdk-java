package com.dropbox.core.examples.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import com.dropbox.core.examples.android.internal.DropboxCredentialUtil
import com.dropbox.core.examples.android.internal.DropboxOAuthUtil
import com.dropbox.core.examples.android.internal.OpenWithActivity
import com.dropbox.core.v2.users.FullAccount

/**
 * Activity that shows information about the currently logged in user
 */
class UserActivity : DropboxActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val toolbar = findViewById<Toolbar>(R.id.app_bar)
        setSupportActionBar(toolbar)
        val loginButton = findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener { v: View? ->
            dropboxOAuthUtil.startDropboxAuthorization(this)
        }
        val filesButton = findViewById<Button>(R.id.files_button)
        filesButton.setOnClickListener { v: View? ->
            startActivity(
                FilesActivity.getIntent(
                    this@UserActivity,
                    ""
                )
            )
        }
        val openWithButton = findViewById<Button>(R.id.open_with)
        openWithButton.setOnClickListener { v: View? ->
            val openWithIntent = Intent(this@UserActivity, OpenWithActivity::class.java)
            startActivity(openWithIntent)
        }

        dropboxOAuthUtil.showWarningDialogIfAppKeyNotSet(this)
    }

    override fun onResume() {
        super.onResume()
        if (hasToken()) {
            findViewById<View>(R.id.login_button).visibility = View.GONE
            findViewById<View>(R.id.email_text).visibility = View.VISIBLE
            findViewById<View>(R.id.name_text).visibility = View.VISIBLE
            findViewById<View>(R.id.type_text).visibility = View.VISIBLE
            findViewById<View>(R.id.files_button).isEnabled = true
            findViewById<View>(R.id.open_with).isEnabled = true
        } else {
            findViewById<View>(R.id.login_button).visibility = View.VISIBLE
            findViewById<View>(R.id.email_text).visibility = View.GONE
            findViewById<View>(R.id.name_text).visibility = View.GONE
            findViewById<View>(R.id.type_text).visibility = View.GONE
            findViewById<View>(R.id.files_button).isEnabled = false
            findViewById<View>(R.id.open_with).isEnabled = false
        }
    }

    override fun loadData() {
        GetCurrentAccountTask(
            dropboxApi.dropboxClient,
            object : GetCurrentAccountTask.Callback {
                override fun onComplete(result: FullAccount?) {
                    requireNotNull(result)
                    (findViewById<View>(R.id.email_text) as TextView).text = result.email
                    (findViewById<View>(R.id.name_text) as TextView).text = result.name.displayName
                    (findViewById<View>(R.id.type_text) as TextView).text = result.accountType.name
                }

                override fun onError(e: Exception?) {
                    Log.e(javaClass.name, "Failed to get account details.", e)
                }
            }).execute()
    }
}