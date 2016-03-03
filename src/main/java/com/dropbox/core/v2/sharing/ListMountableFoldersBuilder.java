/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;

import java.util.List;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#listMountableFoldersBuilder()}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ListMountableFoldersBuilder {
    private final DbxUserSharingRequests sharing;
    private final ListFoldersArgs.Builder listFoldersArgsBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param listFoldersArgsBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ListMountableFoldersBuilder(DbxUserSharingRequests sharing, ListFoldersArgs.Builder listFoldersArgsBuilder) {
        if (sharing == null) {
            throw new NullPointerException("sharing");
        }
        if (listFoldersArgsBuilder == null) {
            throw new NullPointerException("listFoldersArgsBuilder");
        }
        this.sharing = sharing;
        this.listFoldersArgsBuilder = listFoldersArgsBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code 1000L}. </p>
     *
     * @param limit  The maximum number of results to return per request. Must
     *     be greater than or equal to 1 and be less than or equal to 1000.
     *     Defaults to {@code 1000L} when set to {@code null}.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMountableFoldersBuilder withLimit(Long limit) {
        this.listFoldersArgsBuilder.withLimit(limit);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param actions  Folder actions to query. This field is optional. Must not
     *     contain a {@code null} item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListMountableFoldersBuilder withActions(List<FolderAction> actions) {
        this.listFoldersArgsBuilder.withActions(actions);
        return this;
    }

    /**
     * Issues the request.
     */
    public ListFoldersResult start() throws DbxApiException, DbxException {
        ListFoldersArgs arg = this.listFoldersArgsBuilder.build();
        return sharing.listMountableFolders(arg);
    }
}
