/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

public class SearchArg {
    // struct SearchArg

    private final String path;
    private final String query;
    private final long start;
    private final long maxResults;
    private final SearchMode mode;

    /**
     * Use {@link newBuilder} to create instances of this class without
     * specifying values for all optional fields.
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code (/.*)?}" and not be {@code
     *     null}.
     * @param query  The string to search for. The search string is split on
     *     spaces into multiple tokens. For file name searching, the last token
     *     is used for prefix matching (i.e. "bat c" matches "bat cave" but not
     *     "batman car"). Must not be {@code null}.
     * @param start  The starting index within the search results (used for
     *     paging).
     * @param maxResults  The maximum number of search results to return. Must
     *     be greater than or equal to 1 and be less than or equal to 1000.
     * @param mode  The search mode (filename, filename_and_content, or
     *     deleted_filename). Note that searching file content is only available
     *     for Dropbox Business accounts.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchArg(String path, String query, long start, long maxResults, SearchMode mode) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("(/.*)?", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (query == null) {
            throw new IllegalArgumentException("Required value for 'query' is null");
        }
        this.query = query;
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
     * The default values for unset fields will be used.
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code (/.*)?}" and not be {@code
     *     null}.
     * @param query  The string to search for. The search string is split on
     *     spaces into multiple tokens. For file name searching, the last token
     *     is used for prefix matching (i.e. "bat c" matches "bat cave" but not
     *     "batman car"). Must not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchArg(String path, String query) {
        this(path, query, 0L, 100L, SearchMode.FILENAME);
    }

    /**
     * The path in the user's Dropbox to search. Should probably be a folder.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * The string to search for. The search string is split on spaces into
     * multiple tokens. For file name searching, the last token is used for
     * prefix matching (i.e. "bat c" matches "bat cave" but not "batman car").
     *
     * @return value for this field, never {@code null}.
     */
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
    public SearchMode getMode() {
        return mode;
    }

    /**
     * Returns a new builder for creating an instance of this class.
     *
     * @param path  The path in the user's Dropbox to search. Should probably be
     *     a folder. Must match pattern "{@code (/.*)?}" and not be {@code
     *     null}.
     * @param query  The string to search for. The search string is split on
     *     spaces into multiple tokens. For file name searching, the last token
     *     is used for prefix matching (i.e. "bat c" matches "bat cave" but not
     *     "batman car"). Must not be {@code null}.
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
            if (!java.util.regex.Pattern.matches("(/.*)?", path)) {
                throw new IllegalArgumentException("String 'path' does not match pattern");
            }
            this.path = path;
            if (query == null) {
                throw new IllegalArgumentException("Required value for 'query' is null");
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
         *     paging). Defaults to {@code 0L} when set to {@code null}.
         *
         * @return this builder
         */
        public Builder withStart(Long start) {
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
         *     available for Dropbox Business accounts. Defaults to {@code
         *     SearchMode.FILENAME} when set to {@code null}.
         *
         * @return this builder
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
        int hash = java.util.Arrays.hashCode(new Object [] {
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SearchArg fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SearchArg> _JSON_WRITER = new JsonWriter<SearchArg>() {
        public final void write(SearchArg x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SearchArg._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(SearchArg x, JsonGenerator g) throws IOException {
            g.writeFieldName("path");
            g.writeString(x.path);
            g.writeFieldName("query");
            g.writeString(x.query);
            g.writeFieldName("start");
            g.writeNumber(x.start);
            g.writeFieldName("max_results");
            g.writeNumber(x.maxResults);
            g.writeFieldName("mode");
            SearchMode._JSON_WRITER.write(x.mode, g);
        }
    };

    public static final JsonReader<SearchArg> _JSON_READER = new JsonReader<SearchArg>() {
        public final SearchArg read(JsonParser parser) throws IOException, JsonReadException {
            SearchArg result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final SearchArg readFields(JsonParser parser) throws IOException, JsonReadException {
            String path = null;
            String query = null;
            Long start = null;
            Long maxResults = null;
            SearchMode mode = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("path".equals(fieldName)) {
                    path = JsonReader.StringReader
                        .readField(parser, "path", path);
                }
                else if ("query".equals(fieldName)) {
                    query = JsonReader.StringReader
                        .readField(parser, "query", query);
                }
                else if ("start".equals(fieldName)) {
                    start = JsonReader.UInt64Reader
                        .readField(parser, "start", start);
                }
                else if ("max_results".equals(fieldName)) {
                    maxResults = JsonReader.UInt64Reader
                        .readField(parser, "max_results", maxResults);
                }
                else if ("mode".equals(fieldName)) {
                    mode = SearchMode._JSON_READER
                        .readField(parser, "mode", mode);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (path == null) {
                throw new JsonReadException("Required field \"path\" is missing.", parser.getTokenLocation());
            }
            if (query == null) {
                throw new JsonReadException("Required field \"query\" is missing.", parser.getTokenLocation());
            }
            return new SearchArg(path, query, start, maxResults, mode);
        }
    };
}
