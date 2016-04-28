/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserFilesRequests#getMetadataBuilder(String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class GetMetadataBuilder {
    private final DbxUserFilesRequests files;
    private final GetMetadataArg.Builder getMetadataArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param files  Dropbox namespace-specific client used to issue files
     *     requests.
     * @param getMetadataArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    GetMetadataBuilder(DbxUserFilesRequests files, GetMetadataArg.Builder getMetadataArgBuilder) {
        if (files == null) {
            throw new NullPointerException("files");
        }
        if (getMetadataArgBuilder == null) {
            throw new NullPointerException("getMetadataArgBuilder");
        }
        this.files = files;
        this.getMetadataArgBuilder = getMetadataArgBuilder;
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
    public GetMetadataBuilder withIncludeMediaInfo(Boolean includeMediaInfo) {
        this.getMetadataArgBuilder.withIncludeMediaInfo(includeMediaInfo);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param includeDeleted  If true, {@link DeletedMetadata} will be returned
     *     for deleted file or folder, otherwise {@link LookupError#NOT_FOUND}
     *     will be returned. Defaults to {@code false} when set to {@code null}.
     *
     * @return this builder
     */
    public GetMetadataBuilder withIncludeDeleted(Boolean includeDeleted) {
        this.getMetadataArgBuilder.withIncludeDeleted(includeDeleted);
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
    public GetMetadataBuilder withIncludeHasExplicitSharedMembers(Boolean includeHasExplicitSharedMembers) {
        this.getMetadataArgBuilder.withIncludeHasExplicitSharedMembers(includeHasExplicitSharedMembers);
        return this;
    }

    /**
     * Issues the request.
     */
    public Metadata start() throws GetMetadataErrorException, DbxException {
        GetMetadataArg arg = this.getMetadataArgBuilder.build();
        return files.getMetadata(arg);
    }
}
