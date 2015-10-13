package com.dropbox.core.examples.android;

import android.os.AsyncTask;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.Files;

/**
 * Async task to list items in a folder
 */
class ListFolderTask extends AsyncTask<String, Void, Files.ListFolderResult> {

    private final Files mFilesClient;
    private Exception mException;
    private Callback mCallback;

    public interface Callback {
        void onDataLoaded(Files.ListFolderResult result);

        void onError(Exception e);
    }

    public ListFolderTask(Files filesClient, Callback callback) {
        mFilesClient = filesClient;
        mCallback = callback;
    }

    @Override
    protected void onPostExecute(Files.ListFolderResult result) {
        super.onPostExecute(result);

        if (mException != null) {
            mCallback.onError(mException);
        } else {
            mCallback.onDataLoaded(result);
        }
    }

    @Override
    protected Files.ListFolderResult doInBackground(String... params) {
        try {
            return mFilesClient.listFolder(params[0]);
        } catch (DbxException e) {
            mException = e;
            e.printStackTrace();
        }

        return null;
    }
}
