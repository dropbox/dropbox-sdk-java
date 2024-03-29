/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.filerequests;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserFileRequestsRequests#createBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class CreateBuilder {
    private final DbxUserFileRequestsRequests _client;
    private final CreateFileRequestArgs.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue
     *     file_requests requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    CreateBuilder(DbxUserFileRequestsRequests _client, CreateFileRequestArgs.Builder _builder) {
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
     * @param deadline  The deadline for the file request. Deadlines can only be
     *     set by Professional and Business accounts.
     *
     * @return this builder
     */
    public CreateBuilder withDeadline(FileRequestDeadline deadline) {
        this._builder.withDeadline(deadline);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param open  Whether or not the file request should be open. If the file
     *     request is closed, it will not accept any file submissions, but it
     *     can be opened later. Defaults to {@code true} when set to {@code
     *     null}.
     *
     * @return this builder
     */
    public CreateBuilder withOpen(Boolean open) {
        this._builder.withOpen(open);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param description  A description of the file request.
     *
     * @return this builder
     */
    public CreateBuilder withDescription(String description) {
        this._builder.withDescription(description);
        return this;
    }

    /**
     * Issues the request.
     */
    public FileRequest start() throws CreateFileRequestErrorException, DbxException {
        CreateFileRequestArgs arg_ = this._builder.build();
        return _client.create(arg_);
    }
}
