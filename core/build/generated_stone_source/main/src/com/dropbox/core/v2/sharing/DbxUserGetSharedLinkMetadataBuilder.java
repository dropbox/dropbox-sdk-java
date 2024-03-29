/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#getSharedLinkMetadataBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class DbxUserGetSharedLinkMetadataBuilder {
    private final DbxUserSharingRequests _client;
    private final GetSharedLinkMetadataArg.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    DbxUserGetSharedLinkMetadataBuilder(DbxUserSharingRequests _client, GetSharedLinkMetadataArg.Builder _builder) {
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
     * @param path  If the shared link is to a folder, this parameter can be
     *     used to retrieve the metadata for a specific file or sub-folder in
     *     this folder. A relative path should be used. Must match pattern
     *     "{@code /(.|[\\r\\n])*}".
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DbxUserGetSharedLinkMetadataBuilder withPath(String path) {
        this._builder.withPath(path);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param linkPassword  If the shared link has a password, this parameter
     *     can be used.
     *
     * @return this builder
     */
    public DbxUserGetSharedLinkMetadataBuilder withLinkPassword(String linkPassword) {
        this._builder.withLinkPassword(linkPassword);
        return this;
    }

    /**
     * Issues the request.
     */
    public SharedLinkMetadata start() throws SharedLinkErrorException, DbxException {
        GetSharedLinkMetadataArg arg_ = this._builder.build();
        return _client.getSharedLinkMetadata(arg_);
    }
}
