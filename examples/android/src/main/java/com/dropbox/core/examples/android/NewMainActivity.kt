package com.dropbox.core.examples.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dropbox.core.android.Auth
import com.dropbox.core.examples.android.internal.DropboxAccountInfoResponse
import com.dropbox.core.examples.android.internal.DropboxUploadApiResponse
import com.dropbox.core.examples.android.internal.GetFilesResponse
import com.dropbox.core.oauth.DbxCredential
import java.io.InputStream
import kotlinx.coroutines.launch


class NewMainActivity : DropboxActivity() {

    private val NewFilesAdapter = NewFilesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dropboxCredentialUtil.getLocalCredential()?.let {
            fetchAccountInfo()
            fetchDropboxFolder()
        }

        dropboxOAuthUtil.showWarningDialogIfAppKeyNotSet(this)
    }

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
        filesRecyclerView.adapter = NewFilesAdapter
    }

    override fun onResume() {
        super.onResume()

        //Check if we have an existing token stored, this will be used by DbxClient to make requests
        val localCredential: DbxCredential? = dropboxCredentialUtil.getLocalCredential()
        val credential: DbxCredential? = if (localCredential == null) {
            val credential = Auth.getDbxCredential() //fetch the result from the AuthActivity
            credential?.let {
                //the user successfully connected their Dropbox account!
                dropboxCredentialUtil.storeCredentialLocally(it)
                loadData()
            }
            credential
        } else localCredential

        if (credential == null) {
            loginButton.visibility = View.VISIBLE
            logoutButton.visibility = View.GONE
            uploadButton.isEnabled = false
        } else {
            uploadButton.isEnabled = true
            logoutButton.visibility = View.VISIBLE
            loginButton.visibility = View.GONE
        }
    }

    override fun loadData() {
        fetchAccountInfo()
        fetchDropboxFolder()
    }

    private fun resetUi() {
        NewFilesAdapter.submitList(emptyList())
        accountPhoto.setImageBitmap(null)
        logoutButton.visibility = View.GONE
        loginButton.visibility = View.VISIBLE
        uploadButton.isEnabled = false
    }

    private fun fetchAccountInfo() {
        lifecycleScope.launch {
            when (val response = dropboxApi.getAccountInfo()) {
                is DropboxAccountInfoResponse.Failure -> {
                    Toast.makeText(
                        this@NewMainActivity,
                        "Error getting account info!",
                        Toast.LENGTH_SHORT
                    ).show()
                    exceptionText.text =
                        "type: ${response.exception.javaClass} + ${response.exception.localizedMessage}"
                }
                is DropboxAccountInfoResponse.Success -> {
                    val profileImageUrl = response.accountInfo.profilePhotoUrl
                    Glide.with(this@NewMainActivity).load(profileImageUrl)
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
                            this@NewMainActivity,
                            "Error getting Dropbox files!",
                            Toast.LENGTH_SHORT
                        ).show()
                        exceptionText.text =
                            "type: ${it.exception.javaClass} + ${it.exception.localizedMessage}"
                    }
                    is GetFilesResponse.Success -> {
                        NewFilesAdapter.submitList(it.result)
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
                        this@NewMainActivity,
                        "Error uploading file",
                        Toast.LENGTH_SHORT
                    ).show()
                    exceptionText.text =
                        "type: ${response.exception.javaClass} + ${response.exception.localizedMessage}"
                }
                is DropboxUploadApiResponse.Success -> {
                    Toast.makeText(
                        this@NewMainActivity,
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