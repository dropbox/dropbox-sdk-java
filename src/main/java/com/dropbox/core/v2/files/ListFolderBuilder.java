/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserFilesRequests#listFolderBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ListFolderBuilder {
    private final DbxUserFilesRequests files_;
    private final ListFolderArg.Builder listFolderArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param files_  Dropbox namespace-specific client used to issue files
     *     requests.
     * @param listFolderArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ListFolderBuilder(DbxUserFilesRequests files_, ListFolderArg.Builder listFolderArgBuilder) {
        if (files_ == null) {
            throw new NullPointerException("files_");
        }
        this.files_ = files_;
        if (listFolderArgBuilder == null) {
            throw new NullPointerException("listFolderArgBuilder");
        }
        this.listFolderArgBuilder = listFolderArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param recursive  If true, the list folder operation will be applied
     *     recursively to all subfolders and the response will contain contents
     *     of all subfolders. Defaults to {@code false} when set to {@code
     *     null}.
     *
     * @return this builder
     */
    public ListFolderBuilder withRecursive(Boolean recursive) {
        this.listFolderArgBuilder.withRecursive(recursive);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param includeMediaInfo  If true, {@link FileMetadata#getMediaInfo} is
     *     set for photo and video. Defaults to {@code false} when set to {@code
     *     null}.
     *
     * @return this builder
     */
    public ListFolderBuilder withIncludeMediaInfo(Boolean includeMediaInfo) {
        this.listFolderArgBuilder.withIncludeMediaInfo(includeMediaInfo);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param includeDeleted  If true, the results will include entries for
     *     files and folders that used to exist but were deleted. Defaults to
     *     {@code false} when set to {@code null}.
     *
     * @return this builder
     */
    public ListFolderBuilder withIncludeDeleted(Boolean includeDeleted) {
        this.listFolderArgBuilder.withIncludeDeleted(includeDeleted);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param includeHasExplicitSharedMembers  If true, the results will include
     *     a flag for each file indicating whether or not  that file has any
     *     explicit members. Defaults to {@code false} when set to {@code null}.
     *
     * @return this builder
     */
    public ListFolderBuilder withIncludeHasExplicitSharedMembers(Boolean includeHasExplicitSharedMembers) {
        this.listFolderArgBuilder.withIncludeHasExplicitSharedMembers(includeHasExplicitSharedMembers);
        return this;
    }

    /**
     * Issues the request.
     */
    public ListFolderResult start() throws ListFolderErrorException, DbxException {
        ListFolderArg arg_ = this.listFolderArgBuilder.build();
        return files_.listFolder(arg_);
    }
}
