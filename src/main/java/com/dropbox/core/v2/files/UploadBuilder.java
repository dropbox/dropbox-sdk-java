/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxException;

import java.util.Date;

/**
 * The request builder returned by {@link DbxFiles#uploadBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class UploadBuilder extends com.dropbox.core.v2.DbxUploadStyleBuilder<FileMetadata,UploadErrorException> {
    private final DbxFiles files;
    private final CommitInfo.Builder commitInfoBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param files  Dropbox namespace-specific client used to issue files
     *     requests.
     * @param commitInfoBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    UploadBuilder(DbxFiles files, CommitInfo.Builder commitInfoBuilder) {
        if (files == null) {
            throw new NullPointerException("files");
        }
        if (commitInfoBuilder == null) {
            throw new NullPointerException("commitInfoBuilder");
        }
        this.files = files;
        this.commitInfoBuilder = commitInfoBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code
     * WriteMode.ADD}. </p>
     *
     * @param mode  Selects what to do if the file already exists. Defaults to
     *     {@code WriteMode.ADD} when set to {@code null}.
     *
     * @return this builder
     */
    public UploadBuilder withMode(WriteMode mode) {
        this.commitInfoBuilder.withMode(mode);
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
    public UploadBuilder withAutorename(Boolean autorename) {
        this.commitInfoBuilder.withAutorename(autorename);
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
    public UploadBuilder withClientModified(Date clientModified) {
        this.commitInfoBuilder.withClientModified(clientModified);
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
    public UploadBuilder withMute(Boolean mute) {
        this.commitInfoBuilder.withMute(mute);
        return this;
    }

    @Override
    public UploadUploader start() throws UploadErrorException, DbxException {
        CommitInfo arg = this.commitInfoBuilder.build();
        return files.upload(arg);
    }
}
