package com.dropbox.core.examples.android.internal.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dropbox.core.DbxDownloader
import com.dropbox.core.examples.android.R
import com.dropbox.core.examples.android.internal.ui.FilesAdapter.MetadataViewHolder
import com.dropbox.core.v2.DbxClientV2
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.FolderMetadata
import com.dropbox.core.v2.files.Metadata
import com.dropbox.core.v2.files.ThumbnailFormat
import com.dropbox.core.v2.files.ThumbnailSize
import java.io.ByteArrayOutputStream
import java.util.Collections
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * Adapter for file list
 */
class FilesAdapter(
    private val dbxClientV2: DbxClientV2,
    private val mCallback: Callback,
    private val scope: CoroutineScope,
) :
    RecyclerView.Adapter<MetadataViewHolder>() {
    private var mFiles: List<Metadata>? = null
    fun setFiles(files: List<Metadata>?) {
        mFiles = Collections.unmodifiableList(ArrayList(files))
        notifyDataSetChanged()
    }

    interface Callback {
        fun onFolderClicked(folder: FolderMetadata?)
        fun onFileClicked(file: FileMetadata?)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MetadataViewHolder {
        val context = viewGroup.context
        val view = LayoutInflater.from(context)
            .inflate(R.layout.files_item, viewGroup, false)
        return MetadataViewHolder(view)
    }

    override fun onBindViewHolder(metadataViewHolder: MetadataViewHolder, i: Int) {
        metadataViewHolder.bind(mFiles!![i])
    }

    override fun getItemId(position: Int): Long {
        return mFiles!![position].pathLower.hashCode().toLong()
    }

    override fun getItemCount(): Int {
        return if (mFiles == null) 0 else mFiles!!.size
    }

    inner class MetadataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private var job: Job? = null
        private val mTextView: TextView
        private val mImageView: ImageView
        private var mItem: Metadata? = null

        init {
            mImageView = itemView.findViewById<View>(R.id.image) as ImageView
            mTextView = itemView.findViewById<View>(R.id.text) as TextView
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            if (mItem is FolderMetadata) {
                mCallback.onFolderClicked(mItem as FolderMetadata?)
            } else if (mItem is FileMetadata) {
                mCallback.onFileClicked(mItem as FileMetadata?)
            }
        }

        fun bind(item: Metadata) {
            job?.let {
                if (it.isActive) {
                    it.cancel()
                }
            }
            job = null
            mItem = item
            mTextView.text = mItem!!.name
            val applicationContext = mImageView.context.applicationContext

            // Load based on file path
            // Prepending a magic scheme to get it to
            if (item is FileMetadata) {
                val mime = MimeTypeMap.getSingleton()
                val ext = item.getName().substring(item.getName().indexOf(".") + 1)
                val type = mime.getMimeTypeFromExtension(ext)
                if (type != null && type.startsWith("image/")) {
                    job = scope.launch {
                        Glide.with(applicationContext)
                            .load(R.drawable.ic_photo_grey_600_36dp)
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .into(mImageView)

                        val byteBuffer = ByteArrayOutputStream()
                        withContext(Dispatchers.IO) {
                            val downloader: DbxDownloader<FileMetadata> = dbxClientV2.files()
                                .getThumbnailBuilder(item.getPathLower())
                                .withFormat(ThumbnailFormat.JPEG)
                                .withSize(ThumbnailSize.W1024H768)
                                .start()
                            downloader.download(byteBuffer)
                        }

                        Glide.with(applicationContext)
                            .load(byteBuffer.toByteArray())
                            .placeholder(R.drawable.ic_photo_grey_600_36dp)
                            .error(R.drawable.ic_photo_grey_600_36dp)
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .into(mImageView)
                    }
                } else {
                    println(item.mediaInfo)
                    Glide.with(applicationContext)
                        .load(R.drawable.ic_insert_drive_file_blue_36dp)
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(mImageView)
                }
            } else if (item is FolderMetadata) {
                Glide.with(applicationContext)
                    .load(R.drawable.ic_folder_blue_36dp)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(mImageView)
            }
        }
    }
}