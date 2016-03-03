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
import java.util.List;

@JsonSerialize(using=SearchResult.Serializer.class)
@JsonDeserialize(using=SearchResult.Deserializer.class)
public class SearchResult {
    // struct SearchResult

    // ProGuard work-around since we declare serializers in annotation
    static final Serializer SERIALIZER = new Serializer();
    static final Deserializer DESERIALIZER = new Deserializer();

    protected final List<SearchMatch> matches;
    protected final boolean more;
    protected final long start;

    /**
     *
     * @param matches  A list (possibly empty) of matches for the query. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param more  Used for paging. If true, indicates there is another page of
     *     results available that can be fetched by calling {@link
     *     DbxUserFilesRequests#search(String,String)} again.
     * @param start  Used for paging. Value to set the start argument to when
     *     calling {@link DbxUserFilesRequests#search(String,String)} to fetch
     *     the next page of results.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public SearchResult(List<SearchMatch> matches, boolean more, long start) {
        if (matches == null) {
            throw new IllegalArgumentException("Required value for 'matches' is null");
        }
        for (SearchMatch x : matches) {
            if (x == null) {
                throw new IllegalArgumentException("An item in list 'matches' is null");
            }
        }
        this.matches = matches;
        this.more = more;
        this.start = start;
    }

    /**
     * A list (possibly empty) of matches for the query.
     *
     * @return value for this field, never {@code null}.
     */
    public List<SearchMatch> getMatches() {
        return matches;
    }

    /**
     * Used for paging. If true, indicates there is another page of results
     * available that can be fetched by calling {@link
     * DbxUserFilesRequests#search(String,String)} again.
     *
     * @return value for this field.
     */
    public boolean getMore() {
        return more;
    }

    /**
     * Used for paging. Value to set the start argument to when calling {@link
     * DbxUserFilesRequests#search(String,String)} to fetch the next page of
     * results.
     *
     * @return value for this field.
     */
    public long getStart() {
        return start;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            matches,
            more,
            start
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
            SearchResult other = (SearchResult) obj;
            return ((this.matches == other.matches) || (this.matches.equals(other.matches)))
                && (this.more == other.more)
                && (this.start == other.start)
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

    static final class Serializer extends StructJsonSerializer<SearchResult> {
        private static final long serialVersionUID = 0L;

        public Serializer() {
            super(SearchResult.class);
        }

        public Serializer(boolean unwrapping) {
            super(SearchResult.class, unwrapping);
        }

        @Override
        protected JsonSerializer<SearchResult> asUnwrapping() {
            return new Serializer(true);
        }

        @Override
        protected void serializeFields(SearchResult value, JsonGenerator g, SerializerProvider provider) throws IOException, JsonProcessingException {
            g.writeObjectField("matches", value.matches);
            g.writeObjectField("more", value.more);
            g.writeObjectField("start", value.start);
        }
    }

    static final class Deserializer extends StructJsonDeserializer<SearchResult> {
        private static final long serialVersionUID = 0L;

        public Deserializer() {
            super(SearchResult.class);
        }

        public Deserializer(boolean unwrapping) {
            super(SearchResult.class, unwrapping);
        }

        @Override
        protected JsonDeserializer<SearchResult> asUnwrapping() {
            return new Deserializer(true);
        }

        @Override
        public SearchResult deserializeFields(JsonParser _p, DeserializationContext _ctx) throws IOException, JsonParseException {

            List<SearchMatch> matches = null;
            Boolean more = null;
            Long start = null;

            while (_p.getCurrentToken() == JsonToken.FIELD_NAME) {
                String _field = _p.getCurrentName();
                _p.nextToken();
                if ("matches".equals(_field)) {
                    expectArrayStart(_p);
                    matches = new java.util.ArrayList<SearchMatch>();
                    while (!isArrayEnd(_p)) {
                        SearchMatch _x = null;
                        _x = _p.readValueAs(SearchMatch.class);
                        _p.nextToken();
                        matches.add(_x);
                    }
                    expectArrayEnd(_p);
                    _p.nextToken();
                }
                else if ("more".equals(_field)) {
                    more = _p.getValueAsBoolean();
                    _p.nextToken();
                }
                else if ("start".equals(_field)) {
                    start = _p.getLongValue();
                    assertUnsigned(_p, start);
                    _p.nextToken();
                }
                else {
                    skipValue(_p);
                }
            }

            if (matches == null) {
                throw new JsonParseException(_p, "Required field \"matches\" is missing.");
            }
            if (more == null) {
                throw new JsonParseException(_p, "Required field \"more\" is missing.");
            }
            if (start == null) {
                throw new JsonParseException(_p, "Required field \"start\" is missing.");
            }

            return new SearchResult(matches, more, start);
        }
    }
}
