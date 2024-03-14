/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SearchOptions {
    // struct files.SearchOptions (files.stone)

    protected final String path;
    protected final long maxResults;
    protected final SearchOrderBy orderBy;
    protected final FileStatus fileStatus;
    protected final boolean filenameOnly;
    protected final List<String> fileExtensions;
    protected final List<FileCategory> fileCategories;
    protected final String accountId;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  Scopes the search to a path in the user's Dropbox. Searches
     *     the entire Dropbox if not specified. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}".
     * @param maxResults  The maximum number of search results to return. Must
     *     be greater than or equal to 1 and be less than or equal to 1000.
     * @param orderBy  Specified property of the order of search results. By
     *     default, results are sorted by relevance.
     * @param fileStatus  Restricts search to the given file status. Must not be
     *     {@code null}.
     * @param filenameOnly  Restricts search to only match on filenames.
     * @param fileExtensions  Restricts search to only the extensions specified.
     *     Only supported for active file search. Must not contain a {@code
     *     null} item.
     * @param fileCategories  Restricts search to only the file categories
     *     specified. Only supported for active file search. Must not contain a
     *     {@code null} item.
     * @param accountId  Restricts results to the given account id. Must have
     *     length of at least 40 and have length of at most 40.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchOptions(String path, long maxResults, SearchOrderBy orderBy, FileStatus fileStatus, boolean filenameOnly, List<String> fileExtensions, List<FileCategory> fileCategories, String accountId) {
        if (path != null) {
            if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
        }
        this.path = path;
        if (maxResults < 1L) {
            throw new IllegalArgumentException("Number 'maxResults' is smaller than 1L");
        }
        if (maxResults > 1000L) {
            throw new IllegalArgumentException("Number 'maxResults' is larger than 1000L");
        }
        this.maxResults = maxResults;
        this.orderBy = orderBy;
        if (fileStatus == null) {
            throw new IllegalArgumentException("Required value for 'fileStatus' is null");
        }
        this.fileStatus = fileStatus;
        this.filenameOnly = filenameOnly;
        if (fileExtensions != null) {
            for (String x : fileExtensions) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'fileExtensions' is null");
                }
            }
        }
        this.fileExtensions = fileExtensions;
        if (fileCategories != null) {
            for (FileCategory x : fileCategories) {
                if (x == null) {
                    throw new IllegalArgumentException("An item in list 'fileCategories' is null");
                }
            }
        }
        this.fileCategories = fileCategories;
        if (accountId != null) {
            if (accountId.length() < 40) {
                throw new IllegalArgumentException("String 'accountId' is shorter than 40");
            }
            if (accountId.length() > 40) {
                throw new IllegalArgumentException("String 'accountId' is longer than 40");
            }
        }
        this.accountId = accountId;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     */
    public SearchOptions() {
        this(null, 100L, null, FileStatus.ACTIVE, false, null, null, null);
    }

    /**
     * Scopes the search to a path in the user's Dropbox. Searches the entire
     * Dropbox if not specified.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getPath() {
        return path;
    }

    /**
     * The maximum number of search results to return.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     100L.
     */
    public long getMaxResults() {
        return maxResults;
    }

    /**
     * Specified property of the order of search results. By default, results
     * are sorted by relevance.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public SearchOrderBy getOrderBy() {
        return orderBy;
    }

    /**
     * Restricts search to the given file status.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     FileStatus.ACTIVE.
     */
    @javax.annotation.Nonnull
    public FileStatus getFileStatus() {
        return fileStatus;
    }

    /**
     * Restricts search to only match on filenames.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     false.
     */
    public boolean getFilenameOnly() {
        return filenameOnly;
    }

    /**
     * Restricts search to only the extensions specified. Only supported for
     * active file search.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<String> getFileExtensions() {
        return fileExtensions;
    }

    /**
     * Restricts search to only the file categories specified. Only supported
     * for active file search.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public List<FileCategory> getFileCategories() {
        return fileCategories;
    }

    /**
     * Restricts results to the given account id.
     *
     * @return value for this field, or {@code null} if not present.
     */
    @javax.annotation.Nullable
    public String getAccountId() {
        return accountId;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @return builder for this class.
     */
    public static Builder newBuilder() {
        return new Builder();
    }

    /**
     * Builder for {@link SearchOptions}.
     */
    public static class Builder {

        protected String path;
        protected long maxResults;
        protected SearchOrderBy orderBy;
        protected FileStatus fileStatus;
        protected boolean filenameOnly;
        protected List<String> fileExtensions;
        protected List<FileCategory> fileCategories;
        protected String accountId;

        protected Builder() {
            this.path = null;
            this.maxResults = 100L;
            this.orderBy = null;
            this.fileStatus = FileStatus.ACTIVE;
            this.filenameOnly = false;
            this.fileExtensions = null;
            this.fileCategories = null;
            this.accountId = null;
        }

        /**
         * Set value for optional field.
         *
         * @param path  Scopes the search to a path in the user's Dropbox.
         *     Searches the entire Dropbox if not specified. Must match pattern
         *     "{@code (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}".
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withPath(String path) {
            if (path != null) {
                if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", path)) {
                    throw new IllegalArgumentException("String 'path' does not match pattern");
                }
            }
            this.path = path;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 100L}.
         * </p>
         *
         * @param maxResults  The maximum number of search results to return.
         *     Must be greater than or equal to 1 and be less than or equal to
         *     1000. Defaults to {@code 100L} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMaxResults(Long maxResults) {
            if (maxResults < 1L) {
                throw new IllegalArgumentException("Number 'maxResults' is smaller than 1L");
            }
            if (maxResults > 1000L) {
                throw new IllegalArgumentException("Number 'maxResults' is larger than 1000L");
            }
            if (maxResults != null) {
                this.maxResults = maxResults;
            }
            else {
                this.maxResults = 100L;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param orderBy  Specified property of the order of search results. By
         *     default, results are sorted by relevance.
         *
         * @return this builder
         */
        public Builder withOrderBy(SearchOrderBy orderBy) {
            this.orderBy = orderBy;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code
         * FileStatus.ACTIVE}. </p>
         *
         * @param fileStatus  Restricts search to the given file status. Must
         *     not be {@code null}. Defaults to {@code FileStatus.ACTIVE} when
         *     set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withFileStatus(FileStatus fileStatus) {
            if (fileStatus != null) {
                this.fileStatus = fileStatus;
            }
            else {
                this.fileStatus = FileStatus.ACTIVE;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code false}.
         * </p>
         *
         * @param filenameOnly  Restricts search to only match on filenames.
         *     Defaults to {@code false} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withFilenameOnly(Boolean filenameOnly) {
            if (filenameOnly != null) {
                this.filenameOnly = filenameOnly;
            }
            else {
                this.filenameOnly = false;
            }
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param fileExtensions  Restricts search to only the extensions
         *     specified. Only supported for active file search. Must not
         *     contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withFileExtensions(List<String> fileExtensions) {
            if (fileExtensions != null) {
                for (String x : fileExtensions) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'fileExtensions' is null");
                    }
                }
            }
            this.fileExtensions = fileExtensions;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param fileCategories  Restricts search to only the file categories
         *     specified. Only supported for active file search. Must not
         *     contain a {@code null} item.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withFileCategories(List<FileCategory> fileCategories) {
            if (fileCategories != null) {
                for (FileCategory x : fileCategories) {
                    if (x == null) {
                        throw new IllegalArgumentException("An item in list 'fileCategories' is null");
                    }
                }
            }
            this.fileCategories = fileCategories;
            return this;
        }

        /**
         * Set value for optional field.
         *
         * @param accountId  Restricts results to the given account id. Must
         *     have length of at least 40 and have length of at most 40.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withAccountId(String accountId) {
            if (accountId != null) {
                if (accountId.length() < 40) {
                    throw new IllegalArgumentException("String 'accountId' is shorter than 40");
                }
                if (accountId.length() > 40) {
                    throw new IllegalArgumentException("String 'accountId' is longer than 40");
                }
            }
            this.accountId = accountId;
            return this;
        }

        /**
         * Builds an instance of {@link SearchOptions} configured with this
         * builder's values
         *
         * @return new instance of {@link SearchOptions}
         */
        public SearchOptions build() {
            return new SearchOptions(path, maxResults, orderBy, fileStatus, filenameOnly, fileExtensions, fileCategories, accountId);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            maxResults,
            orderBy,
            fileStatus,
            filenameOnly,
            fileExtensions,
            fileCategories,
            accountId
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            SearchOptions other = (SearchOptions) obj;
            return ((this.path == other.path) || (this.path != null && this.path.equals(other.path)))
                && (this.maxResults == other.maxResults)
                && ((this.orderBy == other.orderBy) || (this.orderBy != null && this.orderBy.equals(other.orderBy)))
                && ((this.fileStatus == other.fileStatus) || (this.fileStatus.equals(other.fileStatus)))
                && (this.filenameOnly == other.filenameOnly)
                && ((this.fileExtensions == other.fileExtensions) || (this.fileExtensions != null && this.fileExtensions.equals(other.fileExtensions)))
                && ((this.fileCategories == other.fileCategories) || (this.fileCategories != null && this.fileCategories.equals(other.fileCategories)))
                && ((this.accountId == other.accountId) || (this.accountId != null && this.accountId.equals(other.accountId)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<SearchOptions> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SearchOptions value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            if (value.path != null) {
                g.writeFieldName("path");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.path, g);
            }
            g.writeFieldName("max_results");
            StoneSerializers.uInt64().serialize(value.maxResults, g);
            if (value.orderBy != null) {
                g.writeFieldName("order_by");
                StoneSerializers.nullable(SearchOrderBy.Serializer.INSTANCE).serialize(value.orderBy, g);
            }
            g.writeFieldName("file_status");
            FileStatus.Serializer.INSTANCE.serialize(value.fileStatus, g);
            g.writeFieldName("filename_only");
            StoneSerializers.boolean_().serialize(value.filenameOnly, g);
            if (value.fileExtensions != null) {
                g.writeFieldName("file_extensions");
                StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).serialize(value.fileExtensions, g);
            }
            if (value.fileCategories != null) {
                g.writeFieldName("file_categories");
                StoneSerializers.nullable(StoneSerializers.list(FileCategory.Serializer.INSTANCE)).serialize(value.fileCategories, g);
            }
            if (value.accountId != null) {
                g.writeFieldName("account_id");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.accountId, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SearchOptions deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SearchOptions value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                Long f_maxResults = 100L;
                SearchOrderBy f_orderBy = null;
                FileStatus f_fileStatus = FileStatus.ACTIVE;
                Boolean f_filenameOnly = false;
                List<String> f_fileExtensions = null;
                List<FileCategory> f_fileCategories = null;
                String f_accountId = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else if ("max_results".equals(field)) {
                        f_maxResults = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("order_by".equals(field)) {
                        f_orderBy = StoneSerializers.nullable(SearchOrderBy.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("file_status".equals(field)) {
                        f_fileStatus = FileStatus.Serializer.INSTANCE.deserialize(p);
                    }
                    else if ("filename_only".equals(field)) {
                        f_filenameOnly = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("file_extensions".equals(field)) {
                        f_fileExtensions = StoneSerializers.nullable(StoneSerializers.list(StoneSerializers.string())).deserialize(p);
                    }
                    else if ("file_categories".equals(field)) {
                        f_fileCategories = StoneSerializers.nullable(StoneSerializers.list(FileCategory.Serializer.INSTANCE)).deserialize(p);
                    }
                    else if ("account_id".equals(field)) {
                        f_accountId = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                value = new SearchOptions(f_path, f_maxResults, f_orderBy, f_fileStatus, f_filenameOnly, f_fileExtensions, f_fileCategories, f_accountId);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
