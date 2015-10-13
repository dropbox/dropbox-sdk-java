package com.dropbox.core.examples.android;

import android.os.AsyncTask;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.Users;

/**
 * Async task for getting user account info
 */
class GetCurrentAccountTask extends AsyncTask<Void, Void, Users.FullAccount> {

    private final Users mUsersClient;
    private final Callback mCallback;
    private Exception mException;

    public interface Callback {
        void onComplete(Users.FullAccount result);
        void onError(Exception e);
    }

    GetCurrentAccountTask(Users usersClient, Callback callback) {
        mUsersClient = usersClient;
        mCallback = callback;
    }

    @Override
    protected void onPostExecute(Users.FullAccount account) {
        super.onPostExecute(account);
        if (mException != null) {
            mCallback.onError(mException);
        } else {
            mCallback.onComplete(account);
        }
    }

    @Override
    protected Users.FullAccount doInBackground(Void... params) {

        try {
            return mUsersClient.getCurrentAccount();

        } catch (DbxException e) {
            mException = e;
            e.printStackTrace();
        }

        return null;
    }
}
