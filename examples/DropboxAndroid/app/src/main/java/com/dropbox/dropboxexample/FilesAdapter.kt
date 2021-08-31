package com.dropbox.dropboxexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dropbox.core.v2.files.FileMetadata
import com.dropbox.core.v2.files.FolderMetadata
import com.dropbox.core.v2.files.Metadata
import com.dropbox.dropboxexample.databinding.ItemFileBinding

class FilesAdapter : ListAdapter<Metadata, RecyclerView.ViewHolder>(FileDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FileViewHolder(
            ItemFileBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val file = getItem(position)
        (holder as FileViewHolder).bind(file)
    }

    class FileViewHolder(
        private val binding: ItemFileBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Metadata) {
            if (item is FileMetadata) {
                //the item is a file
                binding.fileIcon.setImageResource(R.drawable.ic_file)
            } else if (item is FolderMetadata) {
                //the item is a folder
                binding.fileIcon.setImageResource(R.drawable.ic_folder)
            } else {
                throw IllegalStateException("Unsupported item in adapter")
            }
            binding.apply {
                fileName.text = item.name
                filePath.text = item.pathDisplay
            }
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