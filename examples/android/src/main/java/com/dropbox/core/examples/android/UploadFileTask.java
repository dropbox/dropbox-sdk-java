package com.dropbox.core.examples.android;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Async task to upload a file to a directory
 */
class UploadFileTask extends AsyncTask<String, Void, Files.FileMetadata> {

    private final Context mContext;
    private final Files mFilesClient;
    private Exception mException;
    private Callback mCallback;

    public interface Callback {
        void onUploadComplete(Files.FileMetadata result);
        void onError(Exception e);
    }

    UploadFileTask(Context context, Files filesClient, Callback callback) {
        mContext = context;
        mFilesClient = filesClient;
        mCallback = callback;
    }

    @Override
    protected void onPostExecute(Files.FileMetadata result) {
        super.onPostExecute(result);
        if (mException != null) {
            mCallback.onError(mException);
        } else if (result == null) {
            mCallback.onError(null);
        } else {
            mCallback.onUploadComplete(result);
        }
    }

    @Override
    protected Files.FileMetadata doInBackground(String... params) {
        String localUri = params[0];
        File localFile = UriHelpers.getFileForUri(mContext, Uri.parse(localUri));

        if (localFile != null) {
            String remoteFolderPath = params[1];

            // Note - this is not ensuring the name is a valid dropbox file name
            String remoteFileName = localFile.getName();

            try {
                InputStream inputStream = new FileInputStream(localFile);
                try {
                    mFilesClient.uploadBuilder(remoteFolderPath + "/" + remoteFileName)
                            .mode(Files.WriteMode.overwrite)
                            .run(inputStream);
                } finally {
                    inputStream.close();
                }
            } catch (DbxException | IOException e) {
                e.printStackTrace();
                mException = e;
            }
        }

        return null;
    }
}
