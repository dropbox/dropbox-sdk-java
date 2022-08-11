package com.dropbox.core.examples.android

import android.Manifest
import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.MimeTypeMap
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.FolderMetadata
import com.dropbox.core.v2.files.ListFolderResult
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.File
import java.text.DateFormat

/**
 * Activity that displays the content of a path in dropbox and lets users navigate folders,
 * and upload/download files
 */
class FilesActivity : DropboxActivity() {
    private var mPath: String? = null
    private var mFilesAdapter: FilesAdapter? = null
    private var mSelectedFile: FileMetadata? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val path = intent.getStringExtra(EXTRA_PATH)
        mPath = path ?: ""
        setContentView(R.layout.activity_files)
        val toolbar = findViewById<View>(R.id.app_bar) as Toolbar
        setSupportActionBar(toolbar)
        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { performWithPermissions(FileAction.UPLOAD) }
        val recyclerView = findViewById<View>(R.id.files_list) as RecyclerView
        mFilesAdapter = FilesAdapter(
            SamplePicassoClient(this, dropboxApi.dropboxClient).picasso,
            object : FilesAdapter.Callback {
                override fun onFolderClicked(folder: FolderMetadata?) {
                    requireNotNull(folder)
                    startActivity(getIntent(this@FilesActivity, folder.pathLower))
                }

                override fun onFileClicked(file: FileMetadata?) {
                    mSelectedFile = file
                    performWithPermissions(FileAction.DOWNLOAD)
                }
            })
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = mFilesAdapter
        mSelectedFile = null
    }

    private fun launchFilePicker() {
        // Launch intent to pick file for upload
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.addCategory(Intent.CATEGORY_OPENABLE)
        intent.type = "*/*"
        startActivityForResult(intent, PICKFILE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICKFILE_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                // This is the result of a call to launchFilePicker
                uploadFile(data!!.data.toString())
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        val action = FileAction.fromCode(requestCode)
        var granted = true
        for (i in grantResults.indices) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                Log.w(
                    TAG, "User denied " + permissions[i] +
                            " permission to perform file action: " + action
                )
                granted = false
                break
            }
        }
        if (granted) {
            performAction(action)
        } else {
            when (action) {
                FileAction.UPLOAD -> Toast.makeText(
                    this,
                    "Can't upload file: read access denied. " +
                            "Please grant storage permissions to use this functionality.",
                    Toast.LENGTH_LONG
                )
                    .show()
                FileAction.DOWNLOAD -> Toast.makeText(
                    this,
                    "Can't download file: write access denied. " +
                            "Please grant storage permissions to use this functionality.",
                    Toast.LENGTH_LONG
                )
                    .show()
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun performAction(action: FileAction) {
        when (action) {
            FileAction.UPLOAD -> launchFilePicker()
            FileAction.DOWNLOAD -> if (mSelectedFile != null) {
                downloadFile(mSelectedFile!!)
            } else {
                Log.e(TAG, "No file selected to download.")
            }
            else -> Log.e(TAG, "Can't perform unhandled file action: $action")
        }
    }

    override fun loadData() {
        val dialog = ProgressDialog(this)
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        dialog.setCancelable(false)
        dialog.setMessage("Loading")
        dialog.show()
        ListFolderTask(dropboxApi.dropboxClient, object : ListFolderTask.Callback {
            override fun onDataLoaded(result: ListFolderResult?) {
                dialog.dismiss()
                mFilesAdapter!!.setFiles(result!!.entries)
            }

            override fun onError(e: Exception?) {
                dialog.dismiss()
                Log.e(TAG, "Failed to list folder.", e)
                Toast.makeText(
                    this@FilesActivity,
                    "An error has occurred",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }).execute(mPath)
    }

    private fun downloadFile(file: FileMetadata) {
        val dialog = ProgressDialog(this)
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        dialog.setCancelable(false)
        dialog.setMessage("Downloading")
        dialog.show()
        DownloadFileTask(
            this@FilesActivity,
            dropboxApi.dropboxClient,
            object : DownloadFileTask.Callback {
                override fun onDownloadComplete(result: File?) {
                    dialog.dismiss()
                    result?.let { viewFileInExternalApp(it) }
                }

                override fun onError(e: Exception?) {
                    dialog.dismiss()
                    Log.e(TAG, "Failed to download file.", e)
                    Toast.makeText(
                        this@FilesActivity,
                        "An error has occurred",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }).execute(file)
    }

    private fun viewFileInExternalApp(result: File) {
        val intent = Intent(Intent.ACTION_VIEW)
        val mime = MimeTypeMap.getSingleton()
        val ext = result.name.substring(result.name.indexOf(".") + 1)
        val type = mime.getMimeTypeFromExtension(ext)
        intent.setDataAndType(Uri.fromFile(result), type)

        // Check for a handler first to avoid a crash
        val manager = packageManager
        val resolveInfo = manager.queryIntentActivities(intent, 0)
        if (resolveInfo.size > 0) {
            startActivity(intent)
        }
    }

    private fun uploadFile(fileUri: String) {
        val dialog = ProgressDialog(this)
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER)
        dialog.setCancelable(false)
        dialog.setMessage("Uploading")
        dialog.show()
        UploadFileTask(this, dropboxApi.dropboxClient, object : UploadFileTask.Callback {
            override fun onUploadComplete(result: FileMetadata?) {
                dialog.dismiss()
                requireNotNull(result)
                val message = result.name + " size " + result.size + " modified " +
                        DateFormat.getDateTimeInstance().format(result.clientModified)
                Toast.makeText(this@FilesActivity, message, Toast.LENGTH_SHORT)
                    .show()

                // Reload the folder
                loadData()
            }

            override fun onError(e: Exception?) {
                dialog.dismiss()
                Log.e(TAG, "Failed to upload file.", e)
                Toast.makeText(
                    this@FilesActivity,
                    "An error has occurred",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }).execute(fileUri, mPath)
    }

    private fun performWithPermissions(action: FileAction) {
        if (hasPermissionsForAction(action)) {
            performAction(action)
            return
        }
        if (shouldDisplayRationaleForAction(action)) {
            AlertDialog.Builder(this)
                .setMessage("This app requires storage access to download and upload files.")
                .setPositiveButton("OK") { dialog, which -> requestPermissionsForAction(action) }
                .setNegativeButton("Cancel", null)
                .create()
                .show()
        } else {
            requestPermissionsForAction(action)
        }
    }

    private fun hasPermissionsForAction(action: FileAction): Boolean {
        for (permission in action.permissions) {
            val result = ContextCompat.checkSelfPermission(this, permission)
            if (result == PackageManager.PERMISSION_DENIED) {
                return false
            }
        }
        return true
    }

    private fun shouldDisplayRationaleForAction(action: FileAction): Boolean {
        for (permission in action.permissions) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                return true
            }
        }
        return false
    }

    private fun requestPermissionsForAction(action: FileAction) {
        ActivityCompat.requestPermissions(
            this,
            action.permissions,
            action.getCode()
        )
    }

    private enum class FileAction(vararg permissions: String) {
        DOWNLOAD(Manifest.permission.WRITE_EXTERNAL_STORAGE), UPLOAD(Manifest.permission.READ_EXTERNAL_STORAGE);

        val permissions: Array<String> = permissions.toList().toTypedArray()

        fun getCode(): Int {
            return ordinal
        }

        companion object {
            private val values = values()
            fun fromCode(code: Int): FileAction {
                require(!(code < 0 || code >= values.size)) { "Invalid FileAction code: $code" }
                return values[code]
            }
        }
    }

    companion object {
        private val TAG = FilesActivity::class.java.name
        const val EXTRA_PATH = "FilesActivity_Path"
        private const val PICKFILE_REQUEST_CODE = 1
        fun getIntent(context: Context?, path: String?): Intent {
            val filesIntent = Intent(context, FilesActivity::class.java)
            filesIntent.putExtra(EXTRA_PATH, path)
            return filesIntent
        }
    }
}