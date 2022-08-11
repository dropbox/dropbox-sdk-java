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
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dropbox.core.android.Auth
import com.dropbox.core.examples.android.internal.DropboxAccountInfoResponse
import com.dropbox.core.examples.android.internal.DropboxUploadApiResponse
import com.dropbox.core.examples.android.internal.GetFilesResponse
import com.dropbox.core.examples.android.internal.OpenWithActivity
import com.dropbox.core.oauth.DbxCredential
import com.dropbox.core.v2.users.FullAccount
import java.io.InputStream
import kotlinx.coroutines.launch

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

        dropboxCredentialUtil.getLocalCredential()?.let {
            fetchAccountInfo()
            fetchDropboxFolder()
        }

        dropboxOAuthUtil.showWarningDialogIfAppKeyNotSet(this)
    }

    override fun onResume() {
        super.onResume()
       resetUi()
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

        fetchAccountInfo()
        fetchDropboxFolder()
    }


    private val newFilesAdapter = NewFilesAdapter()

    private val loginButton get() = findViewById<Button>(R.id.login_button)
    private val logoutButton get() = findViewById<Button>(R.id.logout_button)
    private val uploadButton get() = findViewById<Button>(R.id.upload_button)
    private val filesRecyclerView get() = findViewById<RecyclerView>(R.id.files)
    private val accountPhoto get() = findViewById<ImageView>(R.id.account_photo)
    private val exceptionText get() = findViewById<TextView>(R.id.exception_text)
    private val uploadLoading get() = findViewById<ProgressBar>(R.id.upload_loading)

    override fun onStart() {
        super.onStart()
        loginButton.setOnClickListener {
            dropboxOAuthUtil.startDropboxAuthorization(this)
        }
        logoutButton.setOnClickListener {
            dropboxOAuthUtil.revokeDropboxAuthorization(lifecycleScope)
            resetUi()
        }
        uploadButton.setOnClickListener {
            selectFileForUpload()
        }
        filesRecyclerView.adapter = newFilesAdapter
    }

    private fun resetUi() {
        newFilesAdapter.submitList(emptyList())
        accountPhoto.setImageBitmap(null)

        if (isAuthenticated()) {
            findViewById<View>(R.id.login_button).visibility = View.GONE
            findViewById<View>(R.id.email_text).visibility = View.VISIBLE
            findViewById<View>(R.id.name_text).visibility = View.VISIBLE
            findViewById<View>(R.id.type_text).visibility = View.VISIBLE
            findViewById<View>(R.id.files_button).isEnabled = true
            findViewById<View>(R.id.open_with).isEnabled = true


            uploadButton.isEnabled = true
            logoutButton.visibility = View.VISIBLE
            loginButton.visibility = View.GONE
        } else {
            findViewById<View>(R.id.login_button).visibility = View.VISIBLE
            findViewById<View>(R.id.email_text).visibility = View.GONE
            findViewById<View>(R.id.name_text).visibility = View.GONE
            findViewById<View>(R.id.type_text).visibility = View.GONE
            findViewById<View>(R.id.files_button).isEnabled = false
            findViewById<View>(R.id.open_with).isEnabled = false


            loginButton.visibility = View.VISIBLE
            logoutButton.visibility = View.GONE
            uploadButton.isEnabled = false
        }
    }

    private fun fetchAccountInfo() {
        lifecycleScope.launch {
            when (val response = dropboxApi.getAccountInfo()) {
                is DropboxAccountInfoResponse.Failure -> {
                    Toast.makeText(
                        applicationContext,
                        "Error getting account info!",
                        Toast.LENGTH_SHORT
                    ).show()
                    exceptionText.text =
                        "type: ${response.exception.javaClass} + ${response.exception.localizedMessage}"
                }
                is DropboxAccountInfoResponse.Success -> {
                    val profileImageUrl = response.accountInfo.profilePhotoUrl
                    Glide.with(applicationContext).load(profileImageUrl)
                        .into(accountPhoto)
                }
            }
        }
    }

    private fun fetchDropboxFolder() {
        lifecycleScope.launch {
            dropboxApi.getFilesForFolderFlow("").collect {
                when (it) {
                    is GetFilesResponse.Failure -> {
                        Toast.makeText(
                            applicationContext,
                            "Error getting Dropbox files!",
                            Toast.LENGTH_SHORT
                        ).show()
                        exceptionText.text =
                            "type: ${it.exception.javaClass} + ${it.exception.localizedMessage}"
                    }
                    is GetFilesResponse.Success -> {
                        newFilesAdapter.submitList(it.result)
                    }
                }
            }
        }
    }

    private fun selectFileForUpload() {
        contract.launch("image/*")
    }

    private fun uploadFile(fileName: String, inputStream: InputStream) {
        lifecycleScope.launch {
            uploadLoading.visibility = View.VISIBLE
            val response = dropboxApi.uploadFile(fileName, inputStream)
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