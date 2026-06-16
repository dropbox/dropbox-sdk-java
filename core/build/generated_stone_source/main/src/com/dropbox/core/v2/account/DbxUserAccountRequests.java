/* DO NOT EDIT */
/* This file was generated from account.stone */

package com.dropbox.core.v2.account;

import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxWrappedException;
import com.dropbox.core.http.HttpRequestor;
import com.dropbox.core.v2.DbxDownloadStyleBuilder;
import com.dropbox.core.v2.DbxRawClientV2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
    // route 2/account/delete_profile_photo
    //

    /**
     * Deletes the current user's profile photo.
     *
     * @param arg  This struct is empty. The comment here is intentionally
     *     emitted to avoid indentation issues with Stone.
     *
     * @return This struct is empty. The comment here is intentionally emitted
     *     to avoid indentation issues with Stone.
     */
    DeleteProfilePhotoResult deleteProfilePhoto(DeleteProfilePhotoArg arg) throws DeleteProfilePhotoErrorException, DbxException {
        try {
            return this.client.rpcStyle(this.client.getHost().getApi(),
                                        "2/account/delete_profile_photo",
                                        arg,
                                        false,
                                        DeleteProfilePhotoArg.Serializer.INSTANCE,
                                        DeleteProfilePhotoResult.Serializer.INSTANCE,
                                        DeleteProfilePhotoError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new DeleteProfilePhotoErrorException("2/account/delete_profile_photo", ex.getRequestId(), ex.getUserMessage(), (DeleteProfilePhotoError) ex.getErrorValue());
        }
    }

    /**
     * Deletes the current user's profile photo.
     *
     * @return This struct is empty. The comment here is intentionally emitted
     *     to avoid indentation issues with Stone.
     */
    public DeleteProfilePhotoResult deleteProfilePhoto() throws DeleteProfilePhotoErrorException, DbxException {
        DeleteProfilePhotoArg _arg = new DeleteProfilePhotoArg();
        return deleteProfilePhoto(_arg);
    }

    //
    // route 2/account/get_photo
    //

    /**
     * This lovely endpoint gets the account photo of a given user.
     *
     * @param _headers  Extra headers to send with request.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     */
    DbxDownloader<AccountPhotoGetResult> getPhoto(AccountPhotoGetArg arg, List<HttpRequestor.Header> _headers) throws AccountPhotoGetErrorException, DbxException {
        try {
            return this.client.downloadStyle(this.client.getHost().getContent(),
                                             "2/account/get_photo",
                                             arg,
                                             false,
                                             _headers,
                                             AccountPhotoGetArg.Serializer.INSTANCE,
                                             AccountPhotoGetResult.Serializer.INSTANCE,
                                             AccountPhotoGetError.Serializer.INSTANCE);
        }
        catch (DbxWrappedException ex) {
            throw new AccountPhotoGetErrorException("2/account/get_photo", ex.getRequestId(), ex.getUserMessage(), (AccountPhotoGetError) ex.getErrorValue());
        }
    }

    /**
     * This lovely endpoint gets the account photo of a given user.
     *
     * @param dbxAccountId  Encoded ID of the user. Must start either with
     *     'dbid:' or 'dbaphid:'. Must not be {@code null}.
     * @param size  A string representing the size of the photo. Must not be
     *     {@code null}.
     * @param circleCrop  True if the photo should be cropped and false
     *     otherwise.
     * @param expectAccountPhoto  True if we expect account photo to exist.
     *
     * @return Downloader used to download the response body and view the server
     *     response.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxDownloader<AccountPhotoGetResult> getPhoto(String dbxAccountId, String size, boolean circleCrop, boolean expectAccountPhoto) throws AccountPhotoGetErrorException, DbxException {
        AccountPhotoGetArg _arg = new AccountPhotoGetArg(dbxAccountId, size, circleCrop, expectAccountPhoto);
        return getPhoto(_arg, Collections.<HttpRequestor.Header>emptyList());
    }

    /**
     * This lovely endpoint gets the account photo of a given user.
     *
     * @param dbxAccountId  Encoded ID of the user. Must start either with
     *     'dbid:' or 'dbaphid:'. Must not be {@code null}.
     * @param size  A string representing the size of the photo. Must not be
     *     {@code null}.
     * @param circleCrop  True if the photo should be cropped and false
     *     otherwise.
     * @param expectAccountPhoto  True if we expect account photo to exist.
     *
     * @return Downloader builder for configuring the request parameters and
     *     instantiating a downloader.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public GetPhotoBuilder getPhotoBuilder(String dbxAccountId, String size, boolean circleCrop, boolean expectAccountPhoto) {
        return new GetPhotoBuilder(this, dbxAccountId, size, circleCrop, expectAccountPhoto);
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
