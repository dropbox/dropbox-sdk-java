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
import java.util.regex.Pattern;

import javax.annotation.Nonnull;

class SearchArg {
    // struct files.SearchArg (files.stone)

    @Nonnull
    protected final String path;
    @Nonnull
    protected final String query;
    protected final long start;
    protected final long maxResults;
    @Nonnull
    protected final SearchMode mode;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     * @param query  The string to search for. Query string may be rewritten to
     *     improve relevance of results. The string is split on spaces into
     *     multiple tokens. For file name searching, the last token is used for
     *     prefix matching (i.e. "bat c" matches "bat cave" but not "batman
     *     car"). Must have length of at most 1000 and not be {@code null}.
     * @param start  The starting index within the search results (used for
     *     paging). Must be less than or equal to 9999.
     * @param maxResults  The maximum number of search results to return. Must
     *     be greater than or equal to 1 and be less than or equal to 1000.
     * @param mode  The search mode (filename, filename_and_content, or
     *     deleted_filename). Note that searching file content is only available
     *     for Dropbox Business accounts. Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchArg(@Nonnull String path, @Nonnull String query, long start, long maxResults, @Nonnull SearchMode mode) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (query == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        if (query.length() > 1000) {
            throw new IllegalArgumentException("String 'query' is longer than 1000");
        }
        this.query = query;
        if (start > 9999L) {
            throw new IllegalArgumentException("Number 'start' is larger than 9999L");
        }
        this.start = start;
        if (maxResults < 1L) {
            throw new IllegalArgumentException("Number 'maxResults' is smaller than 1L");
        }
        if (maxResults > 1000L) {
            throw new IllegalArgumentException("Number 'maxResults' is larger than 1000L");
        }
        this.maxResults = maxResults;
        if (mode == null) {
            throw new IllegalArgumentException("Required value for 'mode' is null");
        }
        this.mode = mode;
    }

    /**
     * None
     *
     * <p> The default values for unset fields will be used. </p>
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     * @param query  The string to search for. Query string may be rewritten to
     *     improve relevance of results. The string is split on spaces into
     *     multiple tokens. For file name searching, the last token is used for
     *     prefix matching (i.e. "bat c" matches "bat cave" but not "batman
     *     car"). Must have length of at most 1000 and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchArg(@Nonnull String path, @Nonnull String query) {
        this(path, query, 0L, 100L, SearchMode.FILENAME);
    }

    /**
     * The path in the user's Dropbox to search. Should probably be a folder.
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getPath() {
        return path;
    }

    /**
     * The string to search for. Query string may be rewritten to improve
     * relevance of results. The string is split on spaces into multiple tokens.
     * For file name searching, the last token is used for prefix matching (i.e.
     * "bat c" matches "bat cave" but not "batman car").
     *
     * @return value for this field, never {@code null}.
     */
    @Nonnull
    public String getQuery() {
        return query;
    }

    /**
     * The starting index within the search results (used for paging).
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     0L.
     */
    public long getStart() {
        return start;
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
     * The search mode (filename, filename_and_content, or deleted_filename).
     * Note that searching file content is only available for Dropbox Business
     * accounts.
     *
     * @return value for this field, or {@code null} if not present. Defaults to
     *     SearchMode.FILENAME.
     */
    @Nonnull
    public SearchMode getMode() {
        return mode;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code
     *     (/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)}" and not be {@code null}.
     * @param query  The string to search for. Query string may be rewritten to
     *     improve relevance of results. The string is split on spaces into
     *     multiple tokens. For file name searching, the last token is used for
     *     prefix matching (i.e. "bat c" matches "bat cave" but not "batman
     *     car"). Must have length of at most 1000 and not be {@code null}.
     *
     * @return builder for this class.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public static Builder newBuilder(String path, String query) {
        return new Builder(path, query);
    }

    /**
     * Builder for {@link SearchArg}.
     */
    public static class Builder {
        protected final String path;
        protected final String query;

        protected long start;
        protected long maxResults;
        protected SearchMode mode;

        protected Builder(String path, String query) {
            if (path == null) {
                throw new IllegalArgumentException("Required value for 'path' is null");
            }
            if (!Pattern.matches("(/(.|[\\r\\n])*)?|id:.*|(ns:[0-9]+(/.*)?)", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            if (query == null) {
                throw new IllegalArgumentException("Required value for 'query' is null");
            }
            if (query.length() > 1000) {
                throw new IllegalArgumentException("String 'query' is longer than 1000");
            }
            this.query = query;
            this.start = 0L;
            this.maxResults = 100L;
            this.mode = SearchMode.FILENAME;
        }

        /**
         * Set value for optional field.
         *
         * <p> If left unset or set to {@code null}, defaults to {@code 0L}.
         * </p>
         *
         * @param start  The starting index within the search results (used for
         *     paging). Must be less than or equal to 9999. Defaults to {@code
         *     0L} when set to {@code null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withStart(Long start) {
            if (start > 9999L) {
                throw new IllegalArgumentException("Number 'start' is larger than 9999L");
            }
            if (start != null) {
                this.start = start;
            }
            else {
                this.start = 0L;
            }
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
         * <p> If left unset or set to {@code null}, defaults to {@code
         * SearchMode.FILENAME}. </p>
         *
         * @param mode  The search mode (filename, filename_and_content, or
         *     deleted_filename). Note that searching file content is only
         *     available for Dropbox Business accounts. Must not be {@code
         *     null}. Defaults to {@code SearchMode.FILENAME} when set to {@code
         *     null}.
         *
         * @return this builder
         *
         * @throws IllegalArgumentException  If any argument does not meet its
         *     preconditions.
         */
        public Builder withMode(SearchMode mode) {
            if (mode != null) {
                this.mode = mode;
            }
            else {
                this.mode = SearchMode.FILENAME;
            }
            return this;
        }

        /**
         * Builds an instance of {@link SearchArg} configured with this
         * builder's values
         *
         * @return new instance of {@link SearchArg}
         */
        public SearchArg build() {
            return new SearchArg(path, query, start, maxResults, mode);
        }
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            path,
            query,
            start,
            maxResults,
            mode
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
            SearchArg other = (SearchArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.query == other.query) || (this.query.equals(other.query)))
                && (this.start == other.start)
                && (this.maxResults == other.maxResults)
                && ((this.mode == other.mode) || (this.mode.equals(other.mode)))
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
    static class Serializer extends StructSerializer<SearchArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SearchArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            g.writeFieldName("query");
            StoneSerializers.string().serialize(value.query, g);
            g.writeFieldName("start");
            StoneSerializers.uInt64().serialize(value.start, g);
            g.writeFieldName("max_results");
            StoneSerializers.uInt64().serialize(value.maxResults, g);
            g.writeFieldName("mode");
            SearchMode.Serializer.INSTANCE.serialize(value.mode, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SearchArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SearchArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                String f_query = null;
                Long f_start = 0L;
                Long f_maxResults = 100L;
                SearchMode f_mode = SearchMode.FILENAME;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("query".equals(field)) {
                        f_query = StoneSerializers.string().deserialize(p);
                    }
                    else if ("start".equals(field)) {
                        f_start = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("max_results".equals(field)) {
                        f_maxResults = StoneSerializers.uInt64().deserialize(p);
                    }
                    else if ("mode".equals(field)) {
                        f_mode = SearchMode.Serializer.INSTANCE.deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                if (f_query == null) {
                    throw new JsonParseException(p, "Required field \"query\" missing.");
                }
                value = new SearchArg(f_path, f_query, f_start, f_maxResults, f_mode);
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
