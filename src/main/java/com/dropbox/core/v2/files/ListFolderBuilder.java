/* DO NOT EDIT */
/* This file was generated from files.babel */

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
    private final DbxUserFilesRequests files;
    private final ListFolderArg.Builder listFolderArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param files  Dropbox namespace-specific client used to issue files
     *     requests.
     * @param listFolderArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ListFolderBuilder(DbxUserFilesRequests files, ListFolderArg.Builder listFolderArgBuilder) {
        if (files == null) {
            throw new NullPointerException("files");
        }
        if (listFolderArgBuilder == null) {
            throw new NullPointerException("listFolderArgBuilder");
        }
        this.files = files;
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
     * Issues the request.
     */
    public ListFolderResult start() throws ListFolderErrorException, DbxException {
        ListFolderArg arg = this.listFolderArgBuilder.build();
        return files.listFolder(arg);
    }
}
