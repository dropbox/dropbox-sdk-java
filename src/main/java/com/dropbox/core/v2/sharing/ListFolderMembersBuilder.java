/* DO NOT EDIT */
/* This file was generated from sharing_folders.babel */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

import java.util.List;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#listFolderMembersBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ListFolderMembersBuilder {
    private final DbxUserSharingRequests sharing;
    private final ListFolderMembersArgs.Builder listFolderMembersArgsBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param listFolderMembersArgsBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ListFolderMembersBuilder(DbxUserSharingRequests sharing, ListFolderMembersArgs.Builder listFolderMembersArgsBuilder) {
        if (sharing == null) {
            throw new NullPointerException("sharing");
        }
        if (listFolderMembersArgsBuilder == null) {
            throw new NullPointerException("listFolderMembersArgsBuilder");
        }
        this.sharing = sharing;
        this.listFolderMembersArgsBuilder = listFolderMembersArgsBuilder;
    }

    /**
     * Set value for optional field.
     *
     * @param actions  Member actions to query. Must not contain a {@code null}
     *     item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderMembersBuilder withActions(List<MemberAction> actions) {
        this.listFolderMembersArgsBuilder.withActions(actions);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code 1000L}. </p>
     *
     * @param limit  The maximum number of results that include members, groups
     *     and invitees to return per request. Must be greater than or equal to
     *     1 and be less than or equal to 1000. Defaults to {@code 1000L} when
     *     set to {@code null}.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderMembersBuilder withLimit(Long limit) {
        this.listFolderMembersArgsBuilder.withLimit(limit);
        return this;
    }

    /**
     * Issues the request.
     */
    public SharedFolderMembers start() throws SharedFolderAccessErrorException, DbxException {
        ListFolderMembersArgs arg = this.listFolderMembersArgsBuilder.build();
        return sharing.listFolderMembers(arg);
    }
}
