/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

import java.util.List;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#listFolderMembersBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ListFolderMembersBuilder {
    private final DbxUserSharingRequests _client;
    private final ListFolderMembersArgs.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ListFolderMembersBuilder(DbxUserSharingRequests _client, ListFolderMembersArgs.Builder _builder) {
        if (_client == null) {
            throw new NullPointerException("_client");
        }
        this._client = _client;
        if (_builder == null) {
            throw new NullPointerException("_builder");
        }
        this._builder = _builder;
    }

    /**
     * Set value for optional field.
     *
     * @param actions  This is a list indicating whether each returned member
     *     will include a boolean value {@link MemberPermission#getAllow} that
     *     describes whether the current user can perform the MemberAction on
     *     the member. Must not contain a {@code null} item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderMembersBuilder withActions(List<MemberAction> actions) {
        this._builder.withActions(actions);
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
        this._builder.withLimit(limit);
        return this;
    }

    /**
     * Issues the request.
     */
    public SharedFolderMembers start() throws SharedFolderAccessErrorException, DbxException {
        ListFolderMembersArgs arg_ = this._builder.build();
        return _client.listFolderMembers(arg_);
    }
}
