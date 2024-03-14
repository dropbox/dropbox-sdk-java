/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.team;

import com.dropbox.core.DbxException;

import java.util.List;

/**
 * The request builder returned by {@link
 * DbxTeamTeamRequests#sharingAllowlistAddBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class SharingAllowlistAddBuilder {
    private final DbxTeamTeamRequests _client;
    private final SharingAllowlistAddArgs.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue team
     *     requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    SharingAllowlistAddBuilder(DbxTeamTeamRequests _client, SharingAllowlistAddArgs.Builder _builder) {
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
     * @param domains  List of domains represented by valid string
     *     representation (RFC-1034/5). Must not contain a {@code null} item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharingAllowlistAddBuilder withDomains(List<String> domains) {
        this._builder.withDomains(domains);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param emails  List of emails represented by valid string representation
     *     (RFC-5322/822). Must not contain a {@code null} item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SharingAllowlistAddBuilder withEmails(List<String> emails) {
        this._builder.withEmails(emails);
        return this;
    }

    /**
     * Issues the request.
     */
    public SharingAllowlistAddResponse start() throws SharingAllowlistAddErrorException, DbxException {
        SharingAllowlistAddArgs arg_ = this._builder.build();
        return _client.sharingAllowlistAdd(arg_);
    }
}
