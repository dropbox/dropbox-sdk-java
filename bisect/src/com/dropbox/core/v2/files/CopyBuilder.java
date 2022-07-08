/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link DbxUserFilesRequests#copyBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class CopyBuilder {
    private final DbxUserFilesRequests _client;
    private final RelocationArg.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue files
     *     requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    CopyBuilder(DbxUserFilesRequests _client, RelocationArg.Builder _builder) {
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
     * @param allowSharedFolder  If true, {@link
     *     DbxUserFilesRequests#copy(String,String)} will copy contents in
     *     shared folder, otherwise {@link
     *     RelocationError#CANT_COPY_SHARED_FOLDER} will be returned if {@link
     *     RelocationArg#getFromPath} contains shared folder. This field is
     *     always true for {@link DbxUserFilesRequests#move(String,String)}.
     *     Defaults to {@code false} when set to {@code null}.
     *
     * @return this builder
     */
    public CopyBuilder withAllowSharedFolder(Boolean allowSharedFolder) {
        this._builder.withAllowSharedFolder(allowSharedFolder);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param autorename  If there's a conflict, have the Dropbox server try to
     *     autorename the file to avoid the conflict. Defaults to {@code false}
     *     when set to {@code null}.
     *
     * @return this builder
     */
    public CopyBuilder withAutorename(Boolean autorename) {
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
    public CopyBuilder withAllowOwnershipTransfer(Boolean allowOwnershipTransfer) {
        this._builder.withAllowOwnershipTransfer(allowOwnershipTransfer);
        return this;
    }

    /**
     * Issues the request.
     */
    @SuppressWarnings("deprecation")
    public Metadata start() throws RelocationErrorException, DbxException {
        RelocationArg arg_ = this._builder.build();
        return _client.copy(arg_);
    }
}
