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

private class FileDiffCallback : DiffUtil.ItemCallback<Metadata>() {

    override fun areItemsTheSame(oldItem: Metadata, newItem: Metadata): Boolean {
        return oldItem.pathLower == newItem.pathLower
    }

    override fun areContentsTheSame(oldItem: Metadata, newItem: Metadata): Boolean {
        return oldItem == newItem
    }
}