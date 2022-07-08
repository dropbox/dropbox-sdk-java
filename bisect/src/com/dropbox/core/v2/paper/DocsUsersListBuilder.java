/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.paper;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserPaperRequests#docsUsersListBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class DocsUsersListBuilder {
    private final DbxUserPaperRequests _client;
    private final ListUsersOnPaperDocArgs.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue paper
     *     requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    DocsUsersListBuilder(DbxUserPaperRequests _client, ListUsersOnPaperDocArgs.Builder _builder) {
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
     * <p> If left unset or set to {@code null}, defaults to {@code 1000}. </p>
     *
     * @param limit  Size limit per batch. The maximum number of users that can
     *     be retrieved per batch is 1000. Higher value results in invalid
     *     arguments error. Must be greater than or equal to 1 and be less than
     *     or equal to 1000. Defaults to {@code 1000} when set to {@code null}.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DocsUsersListBuilder withLimit(Integer limit) {
        this._builder.withLimit(limit);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code
     * UserOnPaperDocFilter.SHARED}. </p>
     *
     * @param filterBy  Specify this attribute if you want to obtain users that
     *     have already accessed the Paper doc. Must not be {@code null}.
     *     Defaults to {@code UserOnPaperDocFilter.SHARED} when set to {@code
     *     null}.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DocsUsersListBuilder withFilterBy(UserOnPaperDocFilter filterBy) {
        this._builder.withFilterBy(filterBy);
        return this;
    }

    /**
     * Issues the request.
     */
    @SuppressWarnings("deprecation")
    public ListUsersOnPaperDocResponse start() throws DocLookupErrorException, DbxException {
        ListUsersOnPaperDocArgs arg_ = this._builder.build();
        return _client.docsUsersList(arg_);
    }
}
