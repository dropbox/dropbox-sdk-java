/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserFilesRequests#moveBatchV2Builder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class MoveBatchV2Builder {
    private final DbxUserFilesRequests _client;
    private final MoveBatchArg.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue files
     *     requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    MoveBatchV2Builder(DbxUserFilesRequests _client, MoveBatchArg.Builder _builder) {
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
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param autorename  If there's a conflict with any file, have the Dropbox
     *     server try to autorename that file to avoid the conflict. Defaults to
     *     {@code false} when set to {@code null}.
     *
     * @return this builder
     */
    public MoveBatchV2Builder withAutorename(Boolean autorename) {
        this._builder.withAutorename(autorename);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param allowOwnershipTransfer  Allow moves by owner even if it would
     *     result in an ownership transfer for the content being moved. This
     *     does not apply to copies. Defaults to {@code false} when set to
     *     {@code null}.
     *
     * @return this builder
     */
    public MoveBatchV2Builder withAllowOwnershipTransfer(Boolean allowOwnershipTransfer) {
        this._builder.withAllowOwnershipTransfer(allowOwnershipTransfer);
        return this;
    }

    /**
     * Issues the request.
     */
    public RelocationBatchV2Launch start() throws DbxApiException, DbxException {
        MoveBatchArg arg_ = this._builder.build();
        return _client.moveBatchV2(arg_);
    }
}
