/* DO NOT EDIT */
/* This file was generated by Stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxException;
import com.dropbox.core.v2.fileproperties.TemplateFilterBase;

/**
 * The request builder returned by {@link
 * DbxUserFilesRequests#listFolderBuilder}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class ListFolderBuilder {
    private final DbxUserFilesRequests _client;
    private final ListFolderArg.Builder _builder;

    /**
     * Creates a new instance of this builder.
     *
     * @param _client  Dropbox namespace-specific client used to issue files
     *     requests.
     * @param _builder  Request argument builder.
     *
     * @return instsance of this builder
     */
    ListFolderBuilder(DbxUserFilesRequests _client, ListFolderArg.Builder _builder) {
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
     * @param recursive  If true, the list folder operation will be applied
     *     recursively to all subfolders and the response will contain contents
     *     of all subfolders. Defaults to {@code false} when set to {@code
     *     null}.
     *
     * @return this builder
     */
    public ListFolderBuilder withRecursive(Boolean recursive) {
        this._builder.withRecursive(recursive);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code false}. </p>
     *
     * @param includeMediaInfo  If true, {@link FileMetadata#getMediaInfo} is
     *     set for photo and video. This parameter will no longer have an effect
     *     starting December 2, 2019. Defaults to {@code false} when set to
     *     {@code null}.
     *
     * @return this builder
     */
    public ListFolderBuilder withIncludeMediaInfo(Boolean includeMediaInfo) {
        this._builder.withIncludeMediaInfo(includeMediaInfo);
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
        this._builder.withIncludeDeleted(includeDeleted);
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
        this._builder.withIncludeHasExplicitSharedMembers(includeHasExplicitSharedMembers);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param includeMountedFolders  If true, the results will include entries
     *     under mounted folders which includes app folder, shared folder and
     *     team folder. Defaults to {@code true} when set to {@code null}.
     *
     * @return this builder
     */
    public ListFolderBuilder withIncludeMountedFolders(Boolean includeMountedFolders) {
        this._builder.withIncludeMountedFolders(includeMountedFolders);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param limit  The maximum number of results to return per request. Note:
     *     This is an approximate number and there can be slightly more entries
     *     returned in some cases. Must be greater than or equal to 1 and be
     *     less than or equal to 2000.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public ListFolderBuilder withLimit(Long limit) {
        this._builder.withLimit(limit);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param sharedLink  A shared link to list the contents of. If the link is
     *     password-protected, the password must be provided. If this field is
     *     present, {@link ListFolderArg#getPath} will be relative to root of
     *     the shared link. Only non-recursive mode is supported for shared
     *     link.
     *
     * @return this builder
     */
    public ListFolderBuilder withSharedLink(SharedLink sharedLink) {
        this._builder.withSharedLink(sharedLink);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * @param includePropertyGroups  If set to a valid list of template IDs,
     *     {@link FileMetadata#getPropertyGroups} is set if there exists
     *     property data associated with the file and each of the listed
     *     templates.
     *
     * @return this builder
     */
    public ListFolderBuilder withIncludePropertyGroups(TemplateFilterBase includePropertyGroups) {
        this._builder.withIncludePropertyGroups(includePropertyGroups);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code true}. </p>
     *
     * @param includeNonDownloadableFiles  If true, include files that are not
     *     downloadable, i.e. Google Docs. Defaults to {@code true} when set to
     *     {@code null}.
     *
     * @return this builder
     */
    public ListFolderBuilder withIncludeNonDownloadableFiles(Boolean includeNonDownloadableFiles) {
        this._builder.withIncludeNonDownloadableFiles(includeNonDownloadableFiles);
        return this;
    }

    /**
     * Issues the request.
     */
    public ListFolderResult start() throws ListFolderErrorException, DbxException {
        ListFolderArg arg_ = this._builder.build();
        return _client.listFolder(arg_);
    }
}
