/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2;

import com.dropbox.core.v2.account.DbxUserAccountRequests;
import com.dropbox.core.v2.auth.DbxUserAuthRequests;
import com.dropbox.core.v2.check.DbxUserCheckRequests;
import com.dropbox.core.v2.contacts.DbxUserContactsRequests;
import com.dropbox.core.v2.fileproperties.DbxUserFilePropertiesRequests;
import com.dropbox.core.v2.filerequests.DbxUserFileRequestsRequests;
import com.dropbox.core.v2.files.DbxUserFilesRequests;
import com.dropbox.core.v2.paper.DbxUserPaperRequests;
import com.dropbox.core.v2.sharing.DbxUserSharingRequests;
import com.dropbox.core.v2.users.DbxUserUsersRequests;

/**
 * Base class for user auth clients.
 */
public class DbxClientV2Base {
    protected final DbxRawClientV2 _client;

    private final DbxUserAccountRequests account;
    private final DbxUserAuthRequests auth;
    private final DbxUserCheckRequests check;
    private final DbxUserContactsRequests contacts;
    private final DbxUserFilePropertiesRequests fileProperties;
    private final DbxUserFileRequestsRequests fileRequests;
    private final DbxUserFilesRequests files;
    private final DbxUserPaperRequests paper;
    private final DbxUserSharingRequests sharing;
    private final DbxUserUsersRequests users;

    /**
     * For internal use only.
     *
     * @param _client  Raw v2 client to use for issuing requests
     */
    protected DbxClientV2Base(DbxRawClientV2 _client) {
        this._client = _client;
        this.account = new DbxUserAccountRequests(_client);
        this.auth = new DbxUserAuthRequests(_client);
        this.check = new DbxUserCheckRequests(_client);
        this.contacts = new DbxUserContactsRequests(_client);
        this.fileProperties = new DbxUserFilePropertiesRequests(_client);
        this.fileRequests = new DbxUserFileRequestsRequests(_client);
        this.files = new DbxUserFilesRequests(_client);
        this.paper = new DbxUserPaperRequests(_client);
        this.sharing = new DbxUserSharingRequests(_client);
        this.users = new DbxUserUsersRequests(_client);
    }

    /**
     * Returns client for issuing requests in the {@code "account"} namespace.
     *
     * @return Dropbox account client
     */
    public DbxUserAccountRequests account() {
        return account;
    }

    /**
     * Returns client for issuing requests in the {@code "auth"} namespace.
     *
     * @return Dropbox auth client
     */
    public DbxUserAuthRequests auth() {
        return auth;
    }

    /**
     * Returns client for issuing requests in the {@code "check"} namespace.
     *
     * @return Dropbox check client
     */
    public DbxUserCheckRequests check() {
        return check;
    }

    /**
     * Returns client for issuing requests in the {@code "contacts"} namespace.
     *
     * @return Dropbox contacts client
     */
    public DbxUserContactsRequests contacts() {
        return contacts;
    }

    /**
     * Returns client for issuing requests in the {@code "file_properties"}
     * namespace.
     *
     * @return Dropbox file_properties client
     */
    public DbxUserFilePropertiesRequests fileProperties() {
        return fileProperties;
    }

    /**
     * Returns client for issuing requests in the {@code "file_requests"}
     * namespace.
     *
     * @return Dropbox file_requests client
     */
    public DbxUserFileRequestsRequests fileRequests() {
        return fileRequests;
    }

    /**
     * Returns client for issuing requests in the {@code "files"} namespace.
     *
     * @return Dropbox files client
     */
    public DbxUserFilesRequests files() {
        return files;
    }

    /**
     * Returns client for issuing requests in the {@code "paper"} namespace.
     *
     * @return Dropbox paper client
     */
    public DbxUserPaperRequests paper() {
        return paper;
    }

    /**
     * Returns client for issuing requests in the {@code "sharing"} namespace.
     *
     * @return Dropbox sharing client
     */
    public DbxUserSharingRequests sharing() {
        return sharing;
    }

    /**
     * Returns client for issuing requests in the {@code "users"} namespace.
     *
     * @return Dropbox users client
     */
    public DbxUserUsersRequests users() {
        return users;
    }
}
