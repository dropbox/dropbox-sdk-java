package com.dropbox.core.examples.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.dropbox.core.examples.android.internal.api.DropboxUploadApiResponse
import com.dropbox.core.examples.android.internal.api.GetCurrentAccountResult
import java.io.InputStream
import kotlinx.coroutines.launch

/**
 * Activity that shows information about the currently logged in user
 */
class HomeActivity : BaseSampleActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<Toolbar>(R.id.app_bar)
        setSupportActionBar(toolbar)
        filesButton.setOnClickListener {
            startActivity(
                FilesActivity.getIntent(
                    this@HomeActivity,
                    ""
                )
            )
        }
        val openWithButton = findViewById<Button>(R.id.open_with)
        openWithButton.setOnClickListener {
            val openWithIntent = Intent(this@HomeActivity, OpenWithActivity::class.java)
            startActivity(openWithIntent)
        }

        dropboxOAuthUtil.showWarningDialogIfAppKeyNotSet(this)
    }

    private fun fetchAccountInfo() {
        lifecycleScope.launch {
            when (val accountResult = dropboxApiWrapper.getCurrentAccount()) {
                is GetCurrentAccountResult.Error -> {
                    Log.e(
                        javaClass.name,
                        "Failed to get account details.",
                        accountResult.e
                    )
                    Toast.makeText(
                        applicationContext,
                        "Error getting account info!",
                        Toast.LENGTH_SHORT
                    ).show()
                    exceptionText.text =
                        "type: ${accountResult.e.javaClass} + ${accountResult.e.localizedMessage}"
                }
                is GetCurrentAccountResult.Success -> {
                    val account = accountResult.account
                    (findViewById<View>(R.id.email_text) as TextView).text = account.email
                    (findViewById<View>(R.id.name_text) as TextView).text = account.name.displayName
                    (findViewById<View>(R.id.type_text) as TextView).text = account.accountType.name

                    Glide.with(applicationContext)
                        .load(account.profilePhotoUrl)
                        .into(accountPhoto)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        resetUi()
    }

    override fun loadData() {
        fetchAccountInfo()
    }

    private val loginWithOAuth2PXCEButton get() = findViewById<Button>(R.id.login_button_pkce)
    private val loginWithOAuth2Button get() = findViewById<Button>(R.id.login_button_oauth)
    private val logoutButton get() = findViewById<Button>(R.id.logout_button)
    private val uploadImageButton get() = findViewById<Button>(R.id.upload_button)
    private val accountPhoto get() = findViewById<ImageView>(R.id.account_photo)
    private val exceptionText get() = findViewById<TextView>(R.id.exception_text)
    private val uploadLoading get() = findViewById<ProgressBar>(R.id.upload_loading)
    private val loggedInContent get() = findViewById<View>(R.id.logged_in_content)
    private val emailText get() = findViewById<View>(R.id.email_text)
    private val typeText get() = findViewById<View>(R.id.type_text)
    private val nameText get() = findViewById<View>(R.id.name_text)
    private val filesButton get() = findViewById<Button>(R.id.files_button)
    private val openWithButton get() = findViewById<Button>(R.id.open_with)

    override fun onStart() {
        super.onStart()
        loginWithOAuth2PXCEButton.setOnClickListener {
            dropboxOAuthUtil.startDropboxAuthorization2PKCE(this)
        }
        loginWithOAuth2Button.setOnClickListener {
            dropboxOAuthUtil.startDropboxAuthorizationOAuth2(this)
        }
        logoutButton.setOnClickListener {
            dropboxOAuthUtil.revokeDropboxAuthorization(dropboxApiWrapper)
            resetUi()
        }
        uploadImageButton.setOnClickListener {
            selectFileForUpload()
        }
    }

    private fun resetUi() {
        accountPhoto.setImageBitmap(null)

        if (isAuthenticated()) {
            emailText.visibility = View.VISIBLE
            nameText.visibility = View.VISIBLE
            typeText.visibility = View.VISIBLE
            loggedInContent.visibility = View.VISIBLE
            logoutButton.visibility = View.VISIBLE

            loginWithOAuth2Button.visibility = View.GONE
            loginWithOAuth2PXCEButton.visibility = View.GONE

            filesButton.isEnabled = true
            openWithButton.isEnabled = true
            uploadImageButton.isEnabled = true
        } else {
            emailText.visibility = View.GONE
            loggedInContent.visibility = View.GONE
            nameText.visibility = View.GONE
            typeText.visibility = View.GONE
            logoutButton.visibility = View.GONE

            loginWithOAuth2Button.visibility = View.VISIBLE
            loginWithOAuth2PXCEButton.visibility = View.VISIBLE

            uploadImageButton.isEnabled = false
            filesButton.isEnabled = false
            openWithButton.isEnabled = false
        }
    }

    private fun selectFileForUpload() {
        contract.launch("image/*")
    }

    private fun uploadFile(fileName: String, inputStream: InputStream) {
        lifecycleScope.launch {
            uploadLoading.visibility = View.VISIBLE
            val response = dropboxApiWrapper.uploadFile(fileName, inputStream)
            uploadLoading.visibility = View.GONE
            when (response) {
                is DropboxUploadApiResponse.Failure -> {
                    Toast.makeText(
                        applicationContext,
                        "Error uploading file",
                        Toast.LENGTH_SHORT
                    ).show()
                    exceptionText.text =
                        "type: ${response.exception.javaClass} + ${response.exception.localizedMessage}"
                }
                is DropboxUploadApiResponse.Success -> {
                    Toast.makeText(
                        applicationContext,
                        "${response.fileMetadata.name} uploaded successfully!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private val openFileContract = object : ActivityResultContracts.GetContent() {
        override fun createIntent(context: Context, input: String): Intent {
            val intent = super.createIntent(context, input)
            val mimeTypes = arrayOf("image/*")
            intent.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes)
            return intent
        }
    }

    private val contract = registerForActivityResult(openFileContract) { uri ->
        if (uri != null) {
            if (uri.scheme == "content") {
                val name = uri.lastPathSegment
                val type = MimeTypeMap.getSingleton()
                    .getExtensionFromMimeType(contentResolver?.getType(uri))
                val inputStream = contentResolver?.openInputStream(uri)
                uploadFile("$name.$type", inputStream!!)
            }
        } else {
            Toast.makeText(this, "Error selecting file", Toast.LENGTH_SHORT).show()
        }
    }
}