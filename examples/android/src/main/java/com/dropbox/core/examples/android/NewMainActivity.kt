package com.dropbox.core.examples.android

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.dropbox.core.android.Auth
import com.dropbox.core.examples.android.databinding.ActivityMainBinding
import com.dropbox.core.examples.android.internal.DropboxAccountInfoResponse
import com.dropbox.core.examples.android.internal.DropboxCredentialUtil
import com.dropbox.core.examples.android.internal.DropboxOAuthUtil
import com.dropbox.core.examples.android.internal.DropboxUploadApiResponse
import com.dropbox.core.examples.android.internal.GetFilesResponse
import com.dropbox.core.oauth.DbxCredential
import java.io.InputStream
import kotlinx.coroutines.launch


class NewMainActivity : DropboxActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter = NewFilesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dropboxCredentialUtil.getLocalCredential()?.let {
            fetchAccountInfo()
            fetchDropboxFolder()
        }

        dropboxOAuthUtil.showWarningDialogIfAppKeyNotSet(this)
    }

    override fun onStart() {
        super.onStart()
        binding.loginButton.setOnClickListener {
            dropboxOAuthUtil.startDropboxAuthorization(this)
        }
        binding.logoutButton.setOnClickListener {
            dropboxOAuthUtil.revokeDropboxAuthorization(lifecycleScope)
            resetUi()
        }
        binding.uploadButton.setOnClickListener {
            selectFileForUpload()
        }
        binding.files.adapter = adapter
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
            with(binding) {
                loginButton.visibility = View.VISIBLE
                logoutButton.visibility = View.GONE
                uploadButton.isEnabled = false
            }
        } else {
            with(binding) {
                uploadButton.isEnabled = true
                logoutButton.visibility = View.VISIBLE
                loginButton.visibility = View.GONE
            }
        }
    }

    override fun loadData() {
        fetchAccountInfo()
        fetchDropboxFolder()
    }

    private fun resetUi() {
        adapter.submitList(emptyList())
        binding.accountPhoto.setImageBitmap(null)
        binding.logoutButton.visibility = View.GONE
        binding.loginButton.visibility = View.VISIBLE
        binding.uploadButton.isEnabled = false
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
                    binding.exceptionText.text =
                        "type: ${response.exception.javaClass} + ${response.exception.localizedMessage}"
                }
                is DropboxAccountInfoResponse.Success -> {
                    val profileImageUrl = response.accountInfo.profilePhotoUrl
                    Glide.with(this@NewMainActivity).load(profileImageUrl)
                        .into(binding.accountPhoto)
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
                        binding.exceptionText.text =
                            "type: ${it.exception.javaClass} + ${it.exception.localizedMessage}"
                    }
                    is GetFilesResponse.Success -> {
                        adapter.submitList(it.result)
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
            binding.uploadLoading.visibility = View.VISIBLE
            val response = dropboxApi.uploadFile(fileName, inputStream)
            binding.uploadLoading.visibility = View.GONE
            when (response) {
                is DropboxUploadApiResponse.Failure -> {
                    Toast.makeText(
                        this@NewMainActivity,
                        "Error uploading file",
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.exceptionText.text =
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