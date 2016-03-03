/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.DbxException;

/**
 * The request builder returned by {@link
 * DbxUserFilesRequests#searchBuilder(String,String)}.
 *
 * <p> Use this class to set optional request parameters and complete the
 * request. </p>
 */
public class SearchBuilder {
    private final DbxUserFilesRequests files;
    private final SearchArg.Builder searchArgBuilder;

    /**
     * Creates a new instance of this builder.
     *
     * @param files  Dropbox namespace-specific client used to issue files
     *     requests.
     * @param searchArgBuilder  Request argument builder.
     *
     * @return instsance of this builder
     */
    SearchBuilder(DbxUserFilesRequests files, SearchArg.Builder searchArgBuilder) {
        if (files == null) {
            throw new NullPointerException("files");
        }
        if (searchArgBuilder == null) {
            throw new NullPointerException("searchArgBuilder");
        }
        this.files = files;
        this.searchArgBuilder = searchArgBuilder;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code 0L}. </p>
     *
     * @param start  The starting index within the search results (used for
     *     paging). Defaults to {@code 0L} when set to {@code null}.
     *
     * @return this builder
     */
    public SearchBuilder withStart(Long start) {
        this.searchArgBuilder.withStart(start);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code 100L}. </p>
     *
     * @param maxResults  The maximum number of search results to return. Must
     *     be greater than or equal to 1 and be less than or equal to 1000.
     *     Defaults to {@code 100L} when set to {@code null}.
     *
     * @return this builder
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchBuilder withMaxResults(Long maxResults) {
        this.searchArgBuilder.withMaxResults(maxResults);
        return this;
    }

    /**
     * Set value for optional field.
     *
     * <p> If left unset or set to {@code null}, defaults to {@code
     * SearchMode.FILENAME}. </p>
     *
     * @param mode  The search mode (filename, filename_and_content, or
     *     deleted_filename). Note that searching file content is only available
     *     for Dropbox Business accounts. Defaults to {@code
     *     SearchMode.FILENAME} when set to {@code null}.
     *
     * @return this builder
     */
    public SearchBuilder withMode(SearchMode mode) {
        this.searchArgBuilder.withMode(mode);
        return this;
    }

    /**
     * Issues the request.
     */
    public SearchResult start() throws SearchErrorException, DbxException {
        SearchArg arg = this.searchArgBuilder.build();
        return files.search(arg);
    }
}
