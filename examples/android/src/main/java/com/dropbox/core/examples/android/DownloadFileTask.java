package com.dropbox.core.examples.android;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Task to download a file from Dropbox and put it in the Downloads folder
 */
class DownloadFileTask extends AsyncTask<Files.FileMetadata, Void, File> {

    private final Context mContext;
    private final Files mFilesClient;
    private Exception mException;
    private Callback mCallback;

    public interface Callback {
        void onDownloadComplete(File result);
        void onError(Exception e);
    }

    DownloadFileTask(Context context, Files filesClient, Callback callback) {
        mContext = context;
        mFilesClient = filesClient;
        mCallback = callback;
    }

    @Override
    protected void onPostExecute(File result) {
        super.onPostExecute(result);
        if (mException != null) {
            mCallback.onError(mException);
        } else {
            mCallback.onDownloadComplete(result);
        }
    }

    @Override
    protected File doInBackground(Files.FileMetadata... params) {
        Files.FileMetadata metadata = params[0];
        try {
            File path = Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS);
            File file = new File(path, metadata.name);

            // Make sure the Downloads directory exists.
            path.mkdirs();

            // Upload the file.
            OutputStream outputStream = new FileOutputStream(file);
            try {
                mFilesClient.downloadBuilder(metadata.pathLower).
                        rev(metadata.rev).run(outputStream);
            } finally {
                outputStream.close();
            }

            // Tell android about the file
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            intent.setData(Uri.fromFile(file));
            mContext.sendBroadcast(intent);

            return file;
        } catch (DbxException | IOException e) {
            e.printStackTrace();
            mException = e;
        }

        return null;
    }
}
