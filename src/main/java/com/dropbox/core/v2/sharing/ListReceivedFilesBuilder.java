/* DO NOT EDIT */
/* This file was generated from sharing_files.stone */

package com.dropbox.core.v2.sharing;

import com.dropbox.core.DbxException;

import java.util.List;

/**
 * The request builder returned by {@link
 * DbxUserSharingRequests#listReceivedFilesBuilder()}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ListReceivedFilesBuilder {
    private final DbxUserSharingRequests sharing_;
    private final ListFilesArg.Builder listFilesArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param sharing_  Dropbox namespace-specific client used to issue sharing
     *     requests.
     * @param listFilesArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ListReceivedFilesBuilder(DbxUserSharingRequests sharing_, ListFilesArg.Builder listFilesArgBuilder) {
        if (sharing_ == null) {
            throw new NullPointerException("sharing_");
        }
        this.sharing_ = sharing_;
        if (listFilesArgBuilder == null) {
            throw new NullPointerException("listFilesArgBuilder");
        }
        this.listFilesArgBuilder = listFilesArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code 100L}. </p>
     *
     * @param limit  Number of files to return max per query. Defaults to 100 if
     *     no limit is specified. Must be greater than or equal to 1 and be less
     *     than or equal to 300. Defaults to {@code 100L} when set to {@code
     *     null}.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListReceivedFilesBuilder withLimit(Long limit) {
        this.listFilesArgBuilder.withLimit(limit);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param actions  File actions to query. Must not contain a {@code null}
     *     item.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListReceivedFilesBuilder withActions(List<FileAction> actions) {
        this.listFilesArgBuilder.withActions(actions);
        return this;
    }

    /**
     * Issues the request.
     */
    public ListFilesResult start() throws SharingUserErrorException, DbxException {
        ListFilesArg arg_ = this.listFilesArgBuilder.build();
        return sharing_.listReceivedFiles(arg_);
    }
}
