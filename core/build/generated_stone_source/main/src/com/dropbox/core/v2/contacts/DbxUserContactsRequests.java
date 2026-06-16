/* DO NOT EDIT */
/* This file was generated from contacts.stone */

package com.dropbox.core.v2.contacts;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Routes in namespace "contacts".
 */
public class DbxUserContactsRequests {
    // namespace contacts (contacts.stone)

    private final DbxRawClientV2 client;

    public DbxUserContactsRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/contacts/delete_manual_contacts
    //

    /**
     * Removes all manually added contacts. You'll still keep contacts who are
     * on your team or who you imported. New contacts will be added when you
     * share.
     */
    public void deleteManualContacts() throws DbxApiException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/contacts/delete_manual_contacts",
                                 null,
                                 false,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 com.dropbox.core.stone.StoneSerializers.void_());
        }
        catch (DbxWrappedException ex) {
            throw new DbxApiException(ex.getRequestId(), ex.getUserMessage(), "Unexpected error response for \"delete_manual_contacts\":" + ex.getErrorValue());
        }
    }

    //
    // route 2/contacts/delete_manual_contacts_batch
    //

    /**
     * Removes manually added contacts from the given list.
     *
     */
    void deleteManualContactsBatch(DeleteManualContactsArg arg) throws DeleteManualContactsErrorException, DbxException {
        try {
            this.client.rpcStyle(this.client.getHost().getApi(),
                                 "2/contacts/delete_manual_contacts_batch",
                                 arg,
                                 false,
                                 DeleteManualContactsArg.Serializer.INSTANCE,
                                 com.dropbox.core.stone.StoneSerializers.void_(),
                                 DeleteManualContactsError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DeleteManualContactsErrorException("2/contacts/delete_manual_contacts_batch", ex.getRequestId(), ex.getUserMessage(), (DeleteManualContactsError) ex.getErrorValue());
        }
    }

    /**
     * Removes manually added contacts from the given list.
     *
     * @param emailAddresses  List of manually added contacts to be deleted.
     *     Must not contain a {@code null} item and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public void deleteManualContactsBatch(List<String> emailAddresses) throws DeleteManualContactsErrorException, DbxException {
        DeleteManualContactsArg _arg = new DeleteManualContactsArg(emailAddresses);
        deleteManualContactsBatch(_arg);
    }
}
