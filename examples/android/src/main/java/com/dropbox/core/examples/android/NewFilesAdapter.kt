package com.dropbox.core.examples.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.FolderMetadata
import com.dropbox.core.v2.files.Metadata

class NewFilesAdapter : ListAdapter<Metadata, RecyclerView.ViewHolder>(FileDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_file, parent, false)
        return FileViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val file = getItem(position)
        (holder as FileViewHolder).bind(file)
    }

    class FileViewHolder(
        view: View
    ) : RecyclerView.ViewHolder(view) {

        private val fileIcon = view.findViewById<ImageView>(R.id.file_icon)
        private val fileName = view.findViewById<TextView>(R.id.file_name)
        private val filePath = view.findViewById<TextView>(R.id.file_path)

        fun bind(item: Metadata) {
            when (item) {
                is FileMetadata -> {
                    //the item is a file
                    fileIcon.setImageResource(R.drawable.ic_file)
                }
                is FolderMetadata -> {
                    //the item is a folder
                    fileIcon.setImageResource(R.drawable.ic_folder)
                }
                else -> {
                    throw IllegalStateException("Unsupported item in adapter")
                }
            }
            fileName.text = item.name
            filePath.text = item.pathDisplay
        }
    }
}

private class FileDiffCallback : DiffUtil.ItemCallback<Metadata>() {

    override fun areItemsTheSame(oldItem: Metadata, newItem: Metadata): Boolean {
        return oldItem.pathLower == newItem.pathLower
    }

    override fun areContentsTheSame(oldItem: Metadata, newItem: Metadata): Boolean {
        return oldItem == newItem
    }
}