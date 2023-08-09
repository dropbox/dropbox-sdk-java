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

public class SearchResult {
    // struct files.SearchResult (files.stone)

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
        int hash = Arrays.hashCode(new Object [] {
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
        if (obj == null) {
            return false;
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
    static class Serializer extends StructSerializer<SearchResult> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(SearchResult value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("matches");
            StoneSerializers.list(SearchMatch.Serializer.INSTANCE).serialize(value.matches, g);
            g.writeFieldName("more");
            StoneSerializers.boolean_().serialize(value.more, g);
            g.writeFieldName("start");
            StoneSerializers.uInt64().serialize(value.start, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public SearchResult deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            SearchResult value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                List<SearchMatch> f_matches = null;
                Boolean f_more = null;
                Long f_start = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("matches".equals(field)) {
                        f_matches = StoneSerializers.list(SearchMatch.Serializer.INSTANCE).deserialize(p);
                    }
                    else if ("more".equals(field)) {
                        f_more = StoneSerializers.boolean_().deserialize(p);
                    }
                    else if ("start".equals(field)) {
                        f_start = StoneSerializers.uInt64().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_matches == null) {
                    throw new JsonParseException(p, "Required field \"matches\" missing.");
                }
                if (f_more == null) {
                    throw new JsonParseException(p, "Required field \"more\" missing.");
                }
                if (f_start == null) {
                    throw new JsonParseException(p, "Required field \"start\" missing.");
                }
                value = new SearchResult(f_matches, f_more, f_start);
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
