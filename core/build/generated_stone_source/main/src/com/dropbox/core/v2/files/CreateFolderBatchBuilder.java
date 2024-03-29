/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxApiException;
import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserFilesRequests#createFolderBatchBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class CreateFolderBatchBuilder {
    private final DbxUserFilesRequests _client;
    private final CreateFolderBatchArg.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue files
     *     requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    CreateFolderBatchBuilder(DbxUserFilesRequests _client, CreateFolderBatchArg.Builder _builder) {
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
     * @param autorename  If there's a conflict, have the Dropbox server try to
     *     autorename the folder to avoid the conflict. Defaults to {@code
     *     false} when set to {@code null}.
     *
     * @return this builder
     */
    public CreateFolderBatchBuilder withAutorename(Boolean autorename) {
        this._builder.withAutorename(autorename);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param forceAsync  Whether to force the create to happen asynchronously.
     *     Defaults to {@code false} when set to {@code null}.
     *
     * @return this builder
     */
    public CreateFolderBatchBuilder withForceAsync(Boolean forceAsync) {
        this._builder.withForceAsync(forceAsync);
        return this;
    }

    /**
     * Issues the request.
     */
    public CreateFolderBatchLaunch start() throws DbxApiException, DbxException {
        CreateFolderBatchArg arg_ = this._builder.build();
        return _client.createFolderBatch(arg_);
    }
}
