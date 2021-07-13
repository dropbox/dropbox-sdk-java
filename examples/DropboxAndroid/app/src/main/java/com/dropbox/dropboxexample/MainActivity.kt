package com.dropbox.dropboxexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.dropbox.core.DbxRequestConfig
import com.dropbox.core.android.Auth
import com.dropbox.core.oauth.DbxCredential
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.dropboxexample.UriHelpers.getFileForUri
import com.dropbox.dropboxexample.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.io.File
import java.io.InputStream
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //TODO where to keep the app key?
    //does it need hidden?
    private val APP_KEY = "8yvxleco33h5ucf"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onStart() {
        super.onStart()
        binding.loginButton.setOnClickListener {
            startDropboxAuthorization()
        }
        binding.logoutButton.setOnClickListener {
            revokeDropboxAuthorization()
        }
        binding.uploadButton.setOnClickListener {
            selectFileForUpload()
        }
    }

    override fun onResume() {
        super.onResume()

        //Check if we have an existing token stored
        //TODO this credential is never being updated, even though the dbxclientv2 might be refreshing
        val localCredential: DbxCredential? = getLocalCredential()
        val credential: DbxCredential? = if (localCredential == null) {
            val credential = Auth.getDbxCredential()
            credential?.let {
                //we have a credential from Dropbox OAuth and we haven't stored it yet
                storeCredentialLocally(it)
            }
            credential
        } else localCredential

        credential?.let {
            val expiryTime = credential.expiresAt - System.currentTimeMillis()
            val minutes = TimeUnit.MILLISECONDS.toMinutes(expiryTime)
            with(binding) {
                accessToken.text = credential.accessToken
                appKey.text = credential.appKey
                refreshToken.text = credential.refreshToken
                expiresIn.text = "$minutes minutes"
                uploadButton.isEnabled = true
                logoutButton.visibility = View.VISIBLE
                loginButton.visibility = View.GONE
                fetchAccountInfo()
            }
        }
    }

    /**
     * Starts the Dropbox OAuth process by launching the Dropbox official app or web
     * browser if dropbox official app is not available. In browser flow, normally user needs to
     * sign in.
     *
     * Because mobile apps need to keep Dropbox secrets in their binaries we need to use PKCE.
     * Read more about this here: https://dropbox.tech/developers/pkce--what-and-why-
    **/
    private fun startDropboxAuthorization() {
        // The client identifier is usually of the form "SoftwareName/SoftwareVersion".
        val clientIdentifier = "DrobpoxSampleAndroid/1.0.0"
        val requestConfig = DbxRequestConfig(clientIdentifier)

        // The scope's your app will need from Dropbox
        // Read more about Scopes here: https://developers.dropbox.com/oauth-guide#dropbox-api-permissions
        val scopes = listOf("account_info.read", "files.content.write")
        Auth.startOAuth2PKCE(this, APP_KEY, requestConfig, scopes)
    }

    private fun revokeDropboxAuthorization() {
        val clientIdentifier = "DrobpoxSampleAndroid/1.0.0"
        val requestConfig = DbxRequestConfig(clientIdentifier)
        val credential = getLocalCredential()
        val dropboxClient = DbxClientV2(requestConfig, credential)
        val dropboxApi = DropboxApi(dropboxClient)
        lifecycleScope.launch {
            dropboxApi.revokeDropboxAuthorization()
        }
        val sharedPreferences = getSharedPreferences("dropbox-sample", MODE_PRIVATE)
        sharedPreferences.edit().remove("credential").apply()
    }

    //deserialize the credential from SharedPreferences if it exists
    private fun getLocalCredential(): DbxCredential? {
        val sharedPreferences = getSharedPreferences("dropbox-sample", MODE_PRIVATE)
        val serializedCredential = sharedPreferences.getString("credential", null) ?: return null
        return DbxCredential.Reader.readFully(serializedCredential)
    }

    //serialize the credential and store in SharedPreferences
    private fun storeCredentialLocally(dbxCredential: DbxCredential) {
        val sharedPreferences = getSharedPreferences("dropbox-sample", MODE_PRIVATE)
        sharedPreferences.edit().putString("credential", dbxCredential.toString()).apply()
    }

    private fun fetchAccountInfo() {
        val clientIdentifier = "DrobpoxSampleAndroid/1.0.0"
        val requestConfig = DbxRequestConfig(clientIdentifier)
        val credential = getLocalCredential()
        val dropboxClient = DbxClientV2(requestConfig, credential)
        val dropboxApi = DropboxApi(dropboxClient)
        lifecycleScope.launch {
            when (val response = dropboxApi.getAccountInfo()) {
                is DropboxAccountInfoResponse.Failure -> {
                    Toast.makeText(this@MainActivity, "Error getting account info!", Toast.LENGTH_SHORT).show()
                    binding.exceptionText.text = "type: ${response.exception.javaClass} + ${response.exception.localizedMessage}"
                }
                is DropboxAccountInfoResponse.Success -> {
                    val profileImageUrl = response.accountInfo.profilePhotoUrl
                    Glide.with(this@MainActivity).load(profileImageUrl).into( binding.accountPhoto)
                }
            }
        }
    }

    private fun selectFileForUpload() {
        contract.launch("image/*")
    }

    private fun uploadFile(file: File, inputStream: InputStream) {
        val clientIdentifier = "DrobpoxSampleAndroid/1.0.0"
        val requestConfig = DbxRequestConfig(clientIdentifier)
        val credential = getLocalCredential()
        val dropboxClient = DbxClientV2(requestConfig, credential)
        val dropboxApi = DropboxApi(dropboxClient)
        lifecycleScope.launch {
            binding.uploadLoading.visibility = View.VISIBLE
            val response = dropboxApi.uploadFile(file.name, inputStream)
            binding.uploadLoading.visibility = View.GONE
            when (response) {
                is DropboxUploadApiResponse.Failure -> {
                    Toast.makeText(this@MainActivity, "Error uploading file", Toast.LENGTH_SHORT).show()
                    binding.exceptionText.text = "type: ${response.exception.javaClass} + ${response.exception.localizedMessage}"
                }
                is DropboxUploadApiResponse.Success -> {
                    Toast.makeText(this@MainActivity, "${response.fileMetadata.name} uploaded successfully!", Toast.LENGTH_SHORT).show()
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
                val file = getFileForUri(this, uri) //TODO this is null
                val inputStream = contentResolver?.openInputStream(uri)
                uploadFile(file!!, inputStream!!)
            }
        } else {
            Toast.makeText(this, "Error selecting file", Toast.LENGTH_SHORT).show()
        }
    }
}