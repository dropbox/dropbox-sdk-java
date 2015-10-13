package com.dropbox.core.examples.android;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;

import com.dropbox.core.v2.Files;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Adapter for file list
 */
public class FilesAdapter extends RecyclerView.Adapter<FilesAdapter.MetadataViewHolder> {
    private List<Files.Metadata> mFiles;
    private final Picasso mPicasso;
    private final Callback mCallback;

    public void setFiles(List<Files.Metadata> files) {
        mFiles = files;
        notifyDataSetChanged();
    }

    public interface Callback {
        void onFolderClicked(Files.FolderMetadata folder);
        void onFileClicked(Files.FileMetadata file);
    }

    public FilesAdapter(Picasso picasso, Callback callback) {
        mPicasso = picasso;
        mCallback = callback;
    }

    @Override
    public MetadataViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.files_item, viewGroup, false);
        return new MetadataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MetadataViewHolder metadataViewHolder, int i) {
        metadataViewHolder.bind(mFiles.get(i));
    }

    @Override
    public long getItemId(int position) {
        return mFiles.get(position).pathLower.hashCode();
    }

    @Override
    public int getItemCount() {
        return mFiles == null ? 0 : mFiles.size();
    }

    public class MetadataViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView mTextView;
        private final ImageView mImageView;
        private Files.Metadata mItem;

        public MetadataViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.image);
            mTextView = (TextView)itemView.findViewById(R.id.text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (mItem instanceof Files.FolderMetadata) {
                mCallback.onFolderClicked((Files.FolderMetadata) mItem);
            }  else if (mItem instanceof Files.FileMetadata) {
                mCallback.onFileClicked((Files.FileMetadata)mItem);
            }
        }

        public void bind(Files.Metadata item) {
            mItem = item;
            mTextView.setText(mItem.name);

            // Load based on file path
            // Prepending a magic scheme to get it to
            // be picked up by DropboxPicassoRequestHandler

            if (item instanceof Files.FileMetadata) {
                MimeTypeMap mime = MimeTypeMap.getSingleton();
                String ext = item.name.substring(item.name.indexOf(".") + 1);
                String type = mime.getMimeTypeFromExtension(ext);
                if (type != null && type.startsWith("image/")) {
                    mPicasso.load(FileThumbnailRequestHandler.buildPicassoUri((Files.FileMetadata)item))
                            .placeholder(R.drawable.ic_photo_grey_600_36dp)
                            .error(R.drawable.ic_photo_grey_600_36dp)
                            .into(mImageView);
                } else {
                    mPicasso.load(R.drawable.ic_insert_drive_file_blue_36dp)
                            .noFade()
                            .into(mImageView);
                }
            } else if (item instanceof Files.FolderMetadata) {
                mPicasso.load(R.drawable.ic_folder_blue_36dp)
                        .noFade()
                        .into(mImageView);
            }
        }
    }
}
