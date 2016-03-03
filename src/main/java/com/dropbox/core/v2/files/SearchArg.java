/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonUtil;
import com.dropbox.core.json.StructJsonDeserializer;
import com.dropbox.core.json.StructJsonSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

@JsonSerialize(using=SearchArg.Serializer.class)
@JsonDeserialize(using=SearchArg.Deserializer.class)
class SearchArg {
    // struct SearchArg

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final String path;
    protected final String query;
    protected final long start;
    protected final long maxResults;
    protected final SearchMode mode;

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
        return serialize(false);
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
        return serialize(true);
    }

    private String serialize(boolean longForm) {
        try {
            return JsonUtil.getMapper(longForm).writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException("Failed to serialize object", ex);
        }
    }

    static final class Serializer extends StructJsonSerializer<SearchArg> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SearchArg.class);
        }

        public Serializer(boolean unwrapping) {
            super(SearchArg.class, unwrapping);
        }

        @Override
        protected JsonSerializer<SearchArg> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(SearchArg value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("path", value.path);
            g.writeObjectField("query", value.query);
            g.writeObjectField("start", value.start);
            g.writeObjectField("max_results", value.maxResults);
            g.writeObjectField("mode", value.mode);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<SearchArg> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SearchArg.class);
        }

        public Deserializer(boolean unwrapping) {
            super(SearchArg.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<SearchArg> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public SearchArg deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            String path = null;
            String query = null;
            Long start = null;
            Long maxResults = null;
            SearchMode mode = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("path".equals(_field)) {
                    path = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("query".equals(_field)) {
                    query = getStringValue(_p);
                    _p.nextToken();
                }
                else if ("start".equals(_field)) {
                    start = _p.getLongValue();
                    assertUnsigned(_p, start);
                    _p.nextToken();
                }
                else if ("max_results".equals(_field)) {
                    maxResults = _p.getLongValue();
                    assertUnsigned(_p, maxResults);
                    _p.nextToken();
                }
                else if ("mode".equals(_field)) {
                    mode = _p.readValueAs(SearchMode.class);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (path == null) {
                throw new JsonParseException(_p, "Required field \"path\" is missing.");
            }
            if (query == null) {
                throw new JsonParseException(_p, "Required field \"query\" is missing.");
            }

            return new SearchArg(path, query, start, maxResults, mode);
        }
    }
}
