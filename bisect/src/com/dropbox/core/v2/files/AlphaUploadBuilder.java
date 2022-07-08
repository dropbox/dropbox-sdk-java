/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.util.LangUtil;
import com.dropbox.core.v2.DbxUploadStyleBuilder;
import com.dropbox.core.v2.fileproperties.PropertyGroup;

import java.util.Date;
import java.util.List;

/**
 * The request builder returned by {@link
 * DbxUserFilesRequests#alphaUploadBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class AlphaUploadBuilder extends DbxUploadStyleBuilder<FileMetadata, UploadErrorWithProperties, UploadErrorWithPropertiesException> {
    private final DbxUserFilesRequests _client;
    private final CommitInfoWithProperties.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue files
     *     requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    AlphaUploadBuilder(DbxUserFilesRequests _client, CommitInfoWithProperties.Builder _builder) {
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
     * <p> If left unset or set to {@code null}, defaults to {@code
     * WriteMode.ADD}. </p>
     *
     * @param mode  Selects what to do if the file already exists. Must not be
     *     {@code null}. Defaults to {@code WriteMode.ADD} when set to {@code
     *     null}.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AlphaUploadBuilder withMode(WriteMode mode) {
        this._builder.withMode(mode);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param autorename  If there's a conflict, as determined by {@link
     *     CommitInfo#getMode}, have the Dropbox server try to autorename the
     *     file to avoid conflict. Defaults to {@code false} when set to {@code
     *     null}.
     *
     * @return this builder
     */
    public AlphaUploadBuilder withAutorename(Boolean autorename) {
        this._builder.withAutorename(autorename);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param clientModified  The value to store as the {@link
     *     CommitInfo#getClientModified} timestamp. Dropbox automatically
     *     records the time at which the file was written to the Dropbox
     *     servers. It can also record an additional timestamp, provided by
     *     Dropbox desktop clients, mobile clients, and API apps of when the
     *     file was actually created or modified.
     *
     * @return this builder
     */
    public AlphaUploadBuilder withClientModified(Date clientModified) {
        this._builder.withClientModified(clientModified);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param mute  Normally, users are made aware of any file modifications in
     *     their Dropbox account via notifications in the client software. If
     *     {@code true}, this tells the clients that this modification shouldn't
     *     result in a user notification. Defaults to {@code false} when set to
     *     {@code null}.
     *
     * @return this builder
     */
    public AlphaUploadBuilder withMute(Boolean mute) {
        this._builder.withMute(mute);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param propertyGroups  List of custom properties to add to file. Must not
     *     contain a {@code null} item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public AlphaUploadBuilder withPropertyGroups(List<PropertyGroup> propertyGroups) {
        this._builder.withPropertyGroups(propertyGroups);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param strictConflict  Be more strict about how each {@link WriteMode}
     *     detects conflict. For example, always return a conflict error when
     *     {@link CommitInfo#getMode} = {@link WriteMode#getUpdateValue} and the
     *     given "rev" doesn't match the existing file's "rev", even if the
     *     existing file has been deleted. Defaults to {@code false} when set to
     *     {@code null}.
     *
     * @return this builder
     */
    public AlphaUploadBuilder withStrictConflict(Boolean strictConflict) {
        this._builder.withStrictConflict(strictConflict);
        return this;
    }

    @Override
    @SuppressWarnings("deprecation")
    public AlphaUploadUploader start() throws UploadErrorWithPropertiesException, DbxException {
        CommitInfoWithProperties arg_ = this._builder.build();
        return _client.alphaUpload(arg_);
    }
}