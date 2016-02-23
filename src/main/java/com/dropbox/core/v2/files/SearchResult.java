/* DO NOT EDIT */
/* This file was generated from files.babel */

package com.dropbox.core.v2.files;

import com.dropbox.core.json.JsonArrayReader;
import com.dropbox.core.json.JsonReadException;
import com.dropbox.core.json.JsonReader;
import com.dropbox.core.json.JsonWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.List;

public class SearchResult {
    // struct SearchResult

    private final List<SearchMatch> matches;
    private final boolean more;
    private final long start;

    /**
     *
     * @param matches  A list (possibly empty) of matches for the query. Must
     *     not contain a {@code null} item and not be {@code null}.
     * @param more  Used for paging. If true, indicates there is another page of
     *     results available that can be fetched by calling {@link
     *     DbxFiles#search(String,String)} again.
     * @param start  Used for paging. Value to set the start argument to when
     *     calling {@link DbxFiles#search(String,String)} to fetch the next page
     *     of results.
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
     * DbxFiles#search(String,String)} again.
     *
     * @return value for this field.
     */
    public boolean getMore() {
        return more;
    }

    /**
     * Used for paging. Value to set the start argument to when calling {@link
     * DbxFiles#search(String,String)} to fetch the next page of results.
     *
     * @return value for this field.
     */
    public long getStart() {
        return start;
    }

    @Override
    public int hashCode() {
        // objects containing lists are not hash-able. This is used as a safeguard
        // against adding this object to a HashSet or HashMap. Since list fields are
        // mutable, it is not safe to compute a hashCode here.
        return System.identityHashCode(this);
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
        return _JSON_WRITER.writeToString(this, false);
    }

    public String toStringMultiline() {
        return _JSON_WRITER.writeToString(this, true);
    }

    public String toJson(Boolean longForm) {
        return _JSON_WRITER.writeToString(this, longForm);
    }

    public static SearchResult fromJson(String s) throws JsonReadException {
        return _JSON_READER.readFully(s);
    }

    public static final JsonWriter<SearchResult> _JSON_WRITER = new JsonWriter<SearchResult>() {
        public final void write(SearchResult x, JsonGenerator g) throws IOException {
            g.writeStartObject();
            SearchResult._JSON_WRITER.writeFields(x, g);
            g.writeEndObject();
        }
        public final void writeFields(SearchResult x, JsonGenerator g) throws IOException {
            g.writeFieldName("matches");
            g.writeStartArray();
            for (SearchMatch item: x.matches) {
                if (item != null) {
                    SearchMatch._JSON_WRITER.write(item, g);
                }
            }
            g.writeEndArray();
            g.writeFieldName("more");
            g.writeBoolean(x.more);
            g.writeFieldName("start");
            g.writeNumber(x.start);
        }
    };

    public static final JsonReader<SearchResult> _JSON_READER = new JsonReader<SearchResult>() {
        public final SearchResult read(JsonParser parser) throws IOException, JsonReadException {
            SearchResult result;
            JsonReader.expectObjectStart(parser);
            result = readFields(parser);
            JsonReader.expectObjectEnd(parser);
            return result;
        }

        public final SearchResult readFields(JsonParser parser) throws IOException, JsonReadException {
            List<SearchMatch> matches = null;
            Boolean more = null;
            Long start = null;
            while (parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                String fieldName = parser.getCurrentName();
                parser.nextToken();
                if ("matches".equals(fieldName)) {
                    matches = JsonArrayReader.mk(SearchMatch._JSON_READER)
                        .readField(parser, "matches", matches);
                }
                else if ("more".equals(fieldName)) {
                    more = JsonReader.BooleanReader
                        .readField(parser, "more", more);
                }
                else if ("start".equals(fieldName)) {
                    start = JsonReader.UInt64Reader
                        .readField(parser, "start", start);
                }
                else {
                    JsonReader.skipValue(parser);
                }
            }
            if (matches == null) {
                throw new JsonReadException("Required field \"matches\" is missing.", parser.getTokenLocation());
            }
            if (more == null) {
                throw new JsonReadException("Required field \"more\" is missing.", parser.getTokenLocation());
            }
            if (start == null) {
                throw new JsonReadException("Required field \"start\" is missing.", parser.getTokenLocation());
            }
            return new SearchResult(matches, more, start);
        }
    };
}
