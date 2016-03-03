package com.dropbox.core.examples.web_file_browser;

/**
 * A database record for a user of our web app.
 */
public class User
{
    public String username;

    /**
     * If this user has allowed us (the Web File Browser app) to "link" to his Dropbox
     * account, then we save the Dropbox <em>access token</em> here.  This access token
     * will let us use the Dropbox API with his account.
     */
    public String dropboxAccessToken;
}
