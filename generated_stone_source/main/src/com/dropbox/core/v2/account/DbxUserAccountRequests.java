/* DO NOT EDIT */
/* This file was generated from account.stone */

package com.dropbox.core.v2.account;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.HashMap;
import java.util.Map;

/**
 * Routes in namespace "account".
 */
public class DbxUserAccountRequests {
    // namespace account (account.stone)

    private final DbxRawClientV2 client;

    public DbxUserAccountRequests(DbxRawClientV2 client) {
        this.client = client;
    }

    //
    // route 2/account/set_profile_photo
    //

    /**
     * Sets a user's profile photo.
     *
     */
    SetProfilePhotoResult setProfilePhoto(SetProfilePhotoArg arg) throws SetProfilePhotoErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/account/set_profile_photo",
                                        arg,
                                        false,
                                        SetProfilePhotoArg.Serializer.INSTANCE,
                                        SetProfilePhotoResult.Serializer.INSTANCE,
                                        SetProfilePhotoError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new SetProfilePhotoErrorException("2/account/set_profile_photo", ex.getRequestId(), ex.getUserMessage(), (SetProfilePhotoError) ex.getErrorValue());
        }
    }

    /**
     * Sets a user's profile photo.
     *
     * @param photo  Image to set as the user's new profile photo. Must not be
     *     {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SetProfilePhotoResult setProfilePhoto(PhotoSourceArg photo) throws SetProfilePhotoErrorException, DbxException {
        SetProfilePhotoArg _arg = new SetProfilePhotoArg(photo);
        return setProfilePhoto(_arg);
    }
}
