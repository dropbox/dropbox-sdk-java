package com.dropbox.core.examples.android;

import android.os.AsyncTask;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.DbxFiles;

/**
 * Async task to list items in a folder
 */
class ListFolderTask extends AsyncTask<String, Void, DbxFiles.ListFolderResult> {

    private final DbxFiles mDbxFilesClient;
    private Exception mException;
    private Callback mCallback;

    public interface Callback {
        void onDataLoaded(DbxFiles.ListFolderResult result);

        void onError(Exception e);
    }

    public ListFolderTask(DbxFiles DbxFilesClient, Callback callback) {
        mDbxFilesClient = DbxFilesClient;
        mCallback = callback;
    }

    @Override
    protected void onPostExecute(DbxFiles.ListFolderResult result) {
        super.onPostExecute(result);

        if (mException != null) {
            mCallback.onError(mException);
        } else {
            mCallback.onDataLoaded(result);
        }
    }

    @Override
    protected DbxFiles.ListFolderResult doInBackground(String... params) {
        try {
            return mDbxFilesClient.listFolder(params[0]);
        } catch (DbxException e) {
            mException = e;
            e.printStackTrace();
        }

        return null;
    }
}
